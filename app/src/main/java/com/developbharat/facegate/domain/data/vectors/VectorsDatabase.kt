package com.developbharat.facegate.domain.data.vectors

import android.content.Context
import net.sqlcipher.database.SQLiteDatabase
import java.io.File
import javax.inject.Inject
import kotlin.math.sqrt

class VectorsDatabase @Inject constructor(
    private val appContext: Context,
    private val dbPassword: String,
    private val dbName: String,
) : IVectorsDatabase {
    private var database: SQLiteDatabase? = null

    private fun loadDatabase() {
        // skip if database is already loaded.
        if (database != null) return

        System.loadLibrary("sqlcipher")
        val databaseFile: File = appContext.getDatabasePath(dbName)
        this.database = SQLiteDatabase.openOrCreateDatabase(databaseFile, dbPassword, null, null, null)
        this.createTables()
    }

    private fun createTables(dims: Int = 512) {
        val vecCols = (1..dims).joinToString(",") { "vec_val_${it} REAL" }
        database!!.rawQuery(
            "CREATE TABLE IF NOT EXISTS vectors(id INTEGER PRIMARY KEY AUTOINCREMENT, content_id TEXT NOT NULL, ${vecCols});",
            emptyList<String>().toTypedArray()
        )
    }

    override suspend fun searchVectors(
        vectors: Iterable<Double>, minThreshold: Int, maxThreshold: Int
    ): List<SearchVectorResult> {
        // load database if not loaded.
        if (database == null) loadDatabase()

        val params = vectors.map { value -> value.toString() }.toTypedArray()

        val l2NormSql = (1..vectors.count()).joinToString("+") { "(vec_val_${it} - ?${it}) * (vec_val_${it} - ?${it})" }
        val cursor = database!!.rawQuery(
            "SELECT id, name, thumbnail, (${l2NormSql}) AS l2norm FROM vectors ORDER BY l2norm ASC limit 1;", params
        )

        val items: List<SearchVectorResult> = mutableListOf()
        for (i in 0..<cursor.count) {
            if (cursor.moveToNext()) {
                val colId = cursor.getColumnIndex("id")
                val colContentId = cursor.getColumnIndex("content_id")
                val colL2Norm = cursor.getColumnIndex("l2norm")

                // Check if we don't have any rows
                if (colId == -1 || colContentId == -1 || colL2Norm == -1) {
                    throw Exception("Invalid column names detected in database file.")
                }

                // Get data from sqlite database
                val id = cursor.getInt(colId)
                val contentId = cursor.getString(colContentId)
                val l2norm = sqrt(cursor.getFloat(colL2Norm))

                return if (l2norm >= minThreshold && l2norm <= maxThreshold) {
                    items.plus(SearchVectorResult(id = id, contentId = contentId, matchScore = l2norm))
                } else {
                    continue
                }
            }
        }

        return items
    }

    override suspend fun insertVectors(data: InsertVectorData) {
        // load database if not loaded.
        if (database == null) loadDatabase()

        val vectors = data.vectors.map { it.toString() }.toTypedArray()
        val insertColsSql = (1..data.vectors.count()).joinToString(",") { "vec_val_${it}" }
        val insertPlacesSql = (1..data.vectors.count()).joinToString(",") { "?${it}" }

        database!!.rawQuery(
            "INSERT INTO vectors (content_id, ${insertColsSql}) VALUES (${data.contentId}, ${insertPlacesSql});",
            vectors
        )
    }

    override suspend fun deleteVectors(id: Int) {
        // load database if not loaded.
        if (database == null) loadDatabase()

        database!!.rawQuery("DELETE FROM vectors WHERE id = ?1;", arrayOf(id))
    }
}