package com.developbharat.facegate.domain.data.database

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

    private fun createTables() {
        database!!.rawQuery(
            """
            CREATE TABLE vectors(
                 id INTEGER PRIMARY KEY AUTOINCREMENT,
                 name TEXT NOT NULL,
                 thumbnail TEXT,
                 vec_val_1 REAL,
                 vec_val_2 REAL,
                 vec_val_3 REAL,
                 vec_val_4 REAL,
                 vec_val_5 REAL,
                 vec_val_6 REAL,
                 vec_val_7 REAL,
                 vec_val_8 REAL,
                 vec_val_9 REAL,
                 vec_val_10 REAL,
                 vec_val_11 REAL,
                 vec_val_12 REAL,
                 vec_val_13 REAL,
                 vec_val_14 REAL,
                 vec_val_15 REAL,
                 vec_val_16 REAL,
                 vec_val_17 REAL,
                 vec_val_18 REAL,
                 vec_val_19 REAL,
                 vec_val_20 REAL,
                 vec_val_21 REAL,
                 vec_val_22 REAL,
                 vec_val_23 REAL,
                 vec_val_24 REAL,
                 vec_val_25 REAL,
                 vec_val_26 REAL,
                 vec_val_27 REAL,
                 vec_val_28 REAL,
                 vec_val_29 REAL,
                 vec_val_30 REAL,
                 vec_val_31 REAL,
                 vec_val_32 REAL,
                 vec_val_33 REAL,
                 vec_val_34 REAL,
                 vec_val_35 REAL,
                 vec_val_36 REAL,
                 vec_val_37 REAL,
                 vec_val_38 REAL,
                 vec_val_39 REAL,
                 vec_val_40 REAL,
                 vec_val_41 REAL,
                 vec_val_42 REAL,
                 vec_val_43 REAL,
                 vec_val_44 REAL,
                 vec_val_45 REAL,
                 vec_val_46 REAL,
                 vec_val_47 REAL,
                 vec_val_48 REAL,
                 vec_val_49 REAL,
                 vec_val_50 REAL,
                 vec_val_51 REAL,
                 vec_val_52 REAL,
                 vec_val_53 REAL,
                 vec_val_54 REAL,
                 vec_val_55 REAL,
                 vec_val_56 REAL,
                 vec_val_57 REAL,
                 vec_val_58 REAL,
                 vec_val_59 REAL,
                 vec_val_60 REAL,
                 vec_val_61 REAL,
                 vec_val_62 REAL,
                 vec_val_63 REAL,
                 vec_val_64 REAL,
                 vec_val_65 REAL,
                 vec_val_66 REAL,
                 vec_val_67 REAL,
                 vec_val_68 REAL,
                 vec_val_69 REAL,
                 vec_val_70 REAL,
                 vec_val_71 REAL,
                 vec_val_72 REAL,
                 vec_val_73 REAL,
                 vec_val_74 REAL,
                 vec_val_75 REAL,
                 vec_val_76 REAL,
                 vec_val_77 REAL,
                 vec_val_78 REAL,
                 vec_val_79 REAL,
                 vec_val_80 REAL,
                 vec_val_81 REAL,
                 vec_val_82 REAL,
                 vec_val_83 REAL,
                 vec_val_84 REAL,
                 vec_val_85 REAL,
                 vec_val_86 REAL,
                 vec_val_87 REAL,
                 vec_val_88 REAL,
                 vec_val_89 REAL,
                 vec_val_90 REAL,
                 vec_val_91 REAL,
                 vec_val_92 REAL,
                 vec_val_93 REAL,
                 vec_val_94 REAL,
                 vec_val_95 REAL,
                 vec_val_96 REAL,
                 vec_val_97 REAL,
                 vec_val_98 REAL,
                 vec_val_99 REAL,
                 vec_val_100 REAL,
                 vec_val_101 REAL,
                 vec_val_102 REAL,
                 vec_val_103 REAL,
                 vec_val_104 REAL,
                 vec_val_105 REAL,
                 vec_val_106 REAL,
                 vec_val_107 REAL,
                 vec_val_108 REAL,
                 vec_val_109 REAL,
                 vec_val_110 REAL,
                 vec_val_111 REAL,
                 vec_val_112 REAL,
                 vec_val_113 REAL,
                 vec_val_114 REAL,
                 vec_val_115 REAL,
                 vec_val_116 REAL,
                 vec_val_117 REAL,
                 vec_val_118 REAL,
                 vec_val_119 REAL,
                 vec_val_120 REAL,
                 vec_val_121 REAL,
                 vec_val_122 REAL,
                 vec_val_123 REAL,
                 vec_val_124 REAL,
                 vec_val_125 REAL,
                 vec_val_126 REAL,
                 vec_val_127 REAL,
                 vec_val_128 REAL,
                 vec_val_129 REAL,
                 vec_val_130 REAL,
                 vec_val_131 REAL,
                 vec_val_132 REAL,
                 vec_val_133 REAL,
                 vec_val_134 REAL,
                 vec_val_135 REAL,
                 vec_val_136 REAL,
                 vec_val_137 REAL,
                 vec_val_138 REAL,
                 vec_val_139 REAL,
                 vec_val_140 REAL,
                 vec_val_141 REAL,
                 vec_val_142 REAL,
                 vec_val_143 REAL,
                 vec_val_144 REAL,
                 vec_val_145 REAL,
                 vec_val_146 REAL,
                 vec_val_147 REAL,
                 vec_val_148 REAL,
                 vec_val_149 REAL,
                 vec_val_150 REAL,
                 vec_val_151 REAL,
                 vec_val_152 REAL,
                 vec_val_153 REAL,
                 vec_val_154 REAL,
                 vec_val_155 REAL,
                 vec_val_156 REAL,
                 vec_val_157 REAL,
                 vec_val_158 REAL,
                 vec_val_159 REAL,
                 vec_val_160 REAL,
                 vec_val_161 REAL,
                 vec_val_162 REAL,
                 vec_val_163 REAL,
                 vec_val_164 REAL,
                 vec_val_165 REAL,
                 vec_val_166 REAL,
                 vec_val_167 REAL,
                 vec_val_168 REAL,
                 vec_val_169 REAL,
                 vec_val_170 REAL,
                 vec_val_171 REAL,
                 vec_val_172 REAL,
                 vec_val_173 REAL,
                 vec_val_174 REAL,
                 vec_val_175 REAL,
                 vec_val_176 REAL,
                 vec_val_177 REAL,
                 vec_val_178 REAL,
                 vec_val_179 REAL,
                 vec_val_180 REAL,
                 vec_val_181 REAL,
                 vec_val_182 REAL,
                 vec_val_183 REAL,
                 vec_val_184 REAL,
                 vec_val_185 REAL,
                 vec_val_186 REAL,
                 vec_val_187 REAL,
                 vec_val_188 REAL,
                 vec_val_189 REAL,
                 vec_val_190 REAL,
                 vec_val_191 REAL,
                 vec_val_192 REAL,
                 vec_val_193 REAL,
                 vec_val_194 REAL,
                 vec_val_195 REAL,
                 vec_val_196 REAL,
                 vec_val_197 REAL,
                 vec_val_198 REAL,
                 vec_val_199 REAL,
                 vec_val_200 REAL,
                 vec_val_201 REAL,
                 vec_val_202 REAL,
                 vec_val_203 REAL,
                 vec_val_204 REAL,
                 vec_val_205 REAL,
                 vec_val_206 REAL,
                 vec_val_207 REAL,
                 vec_val_208 REAL,
                 vec_val_209 REAL,
                 vec_val_210 REAL,
                 vec_val_211 REAL,
                 vec_val_212 REAL,
                 vec_val_213 REAL,
                 vec_val_214 REAL,
                 vec_val_215 REAL,
                 vec_val_216 REAL,
                 vec_val_217 REAL,
                 vec_val_218 REAL,
                 vec_val_219 REAL,
                 vec_val_220 REAL,
                 vec_val_221 REAL,
                 vec_val_222 REAL,
                 vec_val_223 REAL,
                 vec_val_224 REAL,
                 vec_val_225 REAL,
                 vec_val_226 REAL,
                 vec_val_227 REAL,
                 vec_val_228 REAL,
                 vec_val_229 REAL,
                 vec_val_230 REAL,
                 vec_val_231 REAL,
                 vec_val_232 REAL,
                 vec_val_233 REAL,
                 vec_val_234 REAL,
                 vec_val_235 REAL,
                 vec_val_236 REAL,
                 vec_val_237 REAL,
                 vec_val_238 REAL,
                 vec_val_239 REAL,
                 vec_val_240 REAL,
                 vec_val_241 REAL,
                 vec_val_242 REAL,
                 vec_val_243 REAL,
                 vec_val_244 REAL,
                 vec_val_245 REAL,
                 vec_val_246 REAL,
                 vec_val_247 REAL,
                 vec_val_248 REAL,
                 vec_val_249 REAL,
                 vec_val_250 REAL,
                 vec_val_251 REAL,
                 vec_val_252 REAL,
                 vec_val_253 REAL,
                 vec_val_254 REAL,
                 vec_val_255 REAL,
                 vec_val_256 REAL,
                 vec_val_257 REAL,
                 vec_val_258 REAL,
                 vec_val_259 REAL,
                 vec_val_260 REAL,
                 vec_val_261 REAL,
                 vec_val_262 REAL,
                 vec_val_263 REAL,
                 vec_val_264 REAL,
                 vec_val_265 REAL,
                 vec_val_266 REAL,
                 vec_val_267 REAL,
                 vec_val_268 REAL,
                 vec_val_269 REAL,
                 vec_val_270 REAL,
                 vec_val_271 REAL,
                 vec_val_272 REAL,
                 vec_val_273 REAL,
                 vec_val_274 REAL,
                 vec_val_275 REAL,
                 vec_val_276 REAL,
                 vec_val_277 REAL,
                 vec_val_278 REAL,
                 vec_val_279 REAL,
                 vec_val_280 REAL,
                 vec_val_281 REAL,
                 vec_val_282 REAL,
                 vec_val_283 REAL,
                 vec_val_284 REAL,
                 vec_val_285 REAL,
                 vec_val_286 REAL,
                 vec_val_287 REAL,
                 vec_val_288 REAL,
                 vec_val_289 REAL,
                 vec_val_290 REAL,
                 vec_val_291 REAL,
                 vec_val_292 REAL,
                 vec_val_293 REAL,
                 vec_val_294 REAL,
                 vec_val_295 REAL,
                 vec_val_296 REAL,
                 vec_val_297 REAL,
                 vec_val_298 REAL,
                 vec_val_299 REAL,
                 vec_val_300 REAL,
                 vec_val_301 REAL,
                 vec_val_302 REAL,
                 vec_val_303 REAL,
                 vec_val_304 REAL,
                 vec_val_305 REAL,
                 vec_val_306 REAL,
                 vec_val_307 REAL,
                 vec_val_308 REAL,
                 vec_val_309 REAL,
                 vec_val_310 REAL,
                 vec_val_311 REAL,
                 vec_val_312 REAL,
                 vec_val_313 REAL,
                 vec_val_314 REAL,
                 vec_val_315 REAL,
                 vec_val_316 REAL,
                 vec_val_317 REAL,
                 vec_val_318 REAL,
                 vec_val_319 REAL,
                 vec_val_320 REAL,
                 vec_val_321 REAL,
                 vec_val_322 REAL,
                 vec_val_323 REAL,
                 vec_val_324 REAL,
                 vec_val_325 REAL,
                 vec_val_326 REAL,
                 vec_val_327 REAL,
                 vec_val_328 REAL,
                 vec_val_329 REAL,
                 vec_val_330 REAL,
                 vec_val_331 REAL,
                 vec_val_332 REAL,
                 vec_val_333 REAL,
                 vec_val_334 REAL,
                 vec_val_335 REAL,
                 vec_val_336 REAL,
                 vec_val_337 REAL,
                 vec_val_338 REAL,
                 vec_val_339 REAL,
                 vec_val_340 REAL,
                 vec_val_341 REAL,
                 vec_val_342 REAL,
                 vec_val_343 REAL,
                 vec_val_344 REAL,
                 vec_val_345 REAL,
                 vec_val_346 REAL,
                 vec_val_347 REAL,
                 vec_val_348 REAL,
                 vec_val_349 REAL,
                 vec_val_350 REAL,
                 vec_val_351 REAL,
                 vec_val_352 REAL,
                 vec_val_353 REAL,
                 vec_val_354 REAL,
                 vec_val_355 REAL,
                 vec_val_356 REAL,
                 vec_val_357 REAL,
                 vec_val_358 REAL,
                 vec_val_359 REAL,
                 vec_val_360 REAL,
                 vec_val_361 REAL,
                 vec_val_362 REAL,
                 vec_val_363 REAL,
                 vec_val_364 REAL,
                 vec_val_365 REAL,
                 vec_val_366 REAL,
                 vec_val_367 REAL,
                 vec_val_368 REAL,
                 vec_val_369 REAL,
                 vec_val_370 REAL,
                 vec_val_371 REAL,
                 vec_val_372 REAL,
                 vec_val_373 REAL,
                 vec_val_374 REAL,
                 vec_val_375 REAL,
                 vec_val_376 REAL,
                 vec_val_377 REAL,
                 vec_val_378 REAL,
                 vec_val_379 REAL,
                 vec_val_380 REAL,
                 vec_val_381 REAL,
                 vec_val_382 REAL,
                 vec_val_383 REAL,
                 vec_val_384 REAL,
                 vec_val_385 REAL,
                 vec_val_386 REAL,
                 vec_val_387 REAL,
                 vec_val_388 REAL,
                 vec_val_389 REAL,
                 vec_val_390 REAL,
                 vec_val_391 REAL,
                 vec_val_392 REAL,
                 vec_val_393 REAL,
                 vec_val_394 REAL,
                 vec_val_395 REAL,
                 vec_val_396 REAL,
                 vec_val_397 REAL,
                 vec_val_398 REAL,
                 vec_val_399 REAL,
                 vec_val_400 REAL,
                 vec_val_401 REAL,
                 vec_val_402 REAL,
                 vec_val_403 REAL,
                 vec_val_404 REAL,
                 vec_val_405 REAL,
                 vec_val_406 REAL,
                 vec_val_407 REAL,
                 vec_val_408 REAL,
                 vec_val_409 REAL,
                 vec_val_410 REAL,
                 vec_val_411 REAL,
                 vec_val_412 REAL,
                 vec_val_413 REAL,
                 vec_val_414 REAL,
                 vec_val_415 REAL,
                 vec_val_416 REAL,
                 vec_val_417 REAL,
                 vec_val_418 REAL,
                 vec_val_419 REAL,
                 vec_val_420 REAL,
                 vec_val_421 REAL,
                 vec_val_422 REAL,
                 vec_val_423 REAL,
                 vec_val_424 REAL,
                 vec_val_425 REAL,
                 vec_val_426 REAL,
                 vec_val_427 REAL,
                 vec_val_428 REAL,
                 vec_val_429 REAL,
                 vec_val_430 REAL,
                 vec_val_431 REAL,
                 vec_val_432 REAL,
                 vec_val_433 REAL,
                 vec_val_434 REAL,
                 vec_val_435 REAL,
                 vec_val_436 REAL,
                 vec_val_437 REAL,
                 vec_val_438 REAL,
                 vec_val_439 REAL,
                 vec_val_440 REAL,
                 vec_val_441 REAL,
                 vec_val_442 REAL,
                 vec_val_443 REAL,
                 vec_val_444 REAL,
                 vec_val_445 REAL,
                 vec_val_446 REAL,
                 vec_val_447 REAL,
                 vec_val_448 REAL,
                 vec_val_449 REAL,
                 vec_val_450 REAL,
                 vec_val_451 REAL,
                 vec_val_452 REAL,
                 vec_val_453 REAL,
                 vec_val_454 REAL,
                 vec_val_455 REAL,
                 vec_val_456 REAL,
                 vec_val_457 REAL,
                 vec_val_458 REAL,
                 vec_val_459 REAL,
                 vec_val_460 REAL,
                 vec_val_461 REAL,
                 vec_val_462 REAL,
                 vec_val_463 REAL,
                 vec_val_464 REAL,
                 vec_val_465 REAL,
                 vec_val_466 REAL,
                 vec_val_467 REAL,
                 vec_val_468 REAL,
                 vec_val_469 REAL,
                 vec_val_470 REAL,
                 vec_val_471 REAL,
                 vec_val_472 REAL,
                 vec_val_473 REAL,
                 vec_val_474 REAL,
                 vec_val_475 REAL,
                 vec_val_476 REAL,
                 vec_val_477 REAL,
                 vec_val_478 REAL,
                 vec_val_479 REAL,
                 vec_val_480 REAL,
                 vec_val_481 REAL,
                 vec_val_482 REAL,
                 vec_val_483 REAL,
                 vec_val_484 REAL,
                 vec_val_485 REAL,
                 vec_val_486 REAL,
                 vec_val_487 REAL,
                 vec_val_488 REAL,
                 vec_val_489 REAL,
                 vec_val_490 REAL,
                 vec_val_491 REAL,
                 vec_val_492 REAL,
                 vec_val_493 REAL,
                 vec_val_494 REAL,
                 vec_val_495 REAL,
                 vec_val_496 REAL,
                 vec_val_497 REAL,
                 vec_val_498 REAL,
                 vec_val_499 REAL,
                 vec_val_500 REAL,
                 vec_val_501 REAL,
                 vec_val_502 REAL,
                 vec_val_503 REAL,
                 vec_val_504 REAL,
                 vec_val_505 REAL,
                 vec_val_506 REAL,
                 vec_val_507 REAL,
                 vec_val_508 REAL,
                 vec_val_509 REAL,
                 vec_val_510 REAL,
                 vec_val_511 REAL,
                 vec_val_512 REAL
            );
        """.trimIndent(), emptyList<String>().toTypedArray()
        )
    }

    override suspend fun searchVectors(
        vectors: Iterable<Double>, minThreshold: Int, maxThreshold: Int
    ): List<SearchVectorResult> {
        // load database if not loaded.
        if (database == null) loadDatabase()

        val params = vectors.map { value -> value.toString() }.toTypedArray()
        val cursor = database!!.rawQuery(
            """
            SELECT id, name, thumbnail, (
            (vec_val_1 - ?1) * (vec_val_1 - ?1)+
            (vec_val_2 - ?2) * (vec_val_2 - ?2)+
            (vec_val_3 - ?3) * (vec_val_3 - ?3)+
            (vec_val_4 - ?4) * (vec_val_4 - ?4)+
            (vec_val_5 - ?5) * (vec_val_5 - ?5)+
            (vec_val_6 - ?6) * (vec_val_6 - ?6)+
            (vec_val_7 - ?7) * (vec_val_7 - ?7)+
            (vec_val_8 - ?8) * (vec_val_8 - ?8)+
            (vec_val_9 - ?9) * (vec_val_9 - ?9)+
            (vec_val_10 - ?10) * (vec_val_10 - ?10)+
            (vec_val_11 - ?11) * (vec_val_11 - ?11)+
            (vec_val_12 - ?12) * (vec_val_12 - ?12)+
            (vec_val_13 - ?13) * (vec_val_13 - ?13)+
            (vec_val_14 - ?14) * (vec_val_14 - ?14)+
            (vec_val_15 - ?15) * (vec_val_15 - ?15)+
            (vec_val_16 - ?16) * (vec_val_16 - ?16)+
            (vec_val_17 - ?17) * (vec_val_17 - ?17)+
            (vec_val_18 - ?18) * (vec_val_18 - ?18)+
            (vec_val_19 - ?19) * (vec_val_19 - ?19)+
            (vec_val_20 - ?20) * (vec_val_20 - ?20)+
            (vec_val_21 - ?21) * (vec_val_21 - ?21)+
            (vec_val_22 - ?22) * (vec_val_22 - ?22)+
            (vec_val_23 - ?23) * (vec_val_23 - ?23)+
            (vec_val_24 - ?24) * (vec_val_24 - ?24)+
            (vec_val_25 - ?25) * (vec_val_25 - ?25)+
            (vec_val_26 - ?26) * (vec_val_26 - ?26)+
            (vec_val_27 - ?27) * (vec_val_27 - ?27)+
            (vec_val_28 - ?28) * (vec_val_28 - ?28)+
            (vec_val_29 - ?29) * (vec_val_29 - ?29)+
            (vec_val_30 - ?30) * (vec_val_30 - ?30)+
            (vec_val_31 - ?31) * (vec_val_31 - ?31)+
            (vec_val_32 - ?32) * (vec_val_32 - ?32)+
            (vec_val_33 - ?33) * (vec_val_33 - ?33)+
            (vec_val_34 - ?34) * (vec_val_34 - ?34)+
            (vec_val_35 - ?35) * (vec_val_35 - ?35)+
            (vec_val_36 - ?36) * (vec_val_36 - ?36)+
            (vec_val_37 - ?37) * (vec_val_37 - ?37)+
            (vec_val_38 - ?38) * (vec_val_38 - ?38)+
            (vec_val_39 - ?39) * (vec_val_39 - ?39)+
            (vec_val_40 - ?40) * (vec_val_40 - ?40)+
            (vec_val_41 - ?41) * (vec_val_41 - ?41)+
            (vec_val_42 - ?42) * (vec_val_42 - ?42)+
            (vec_val_43 - ?43) * (vec_val_43 - ?43)+
            (vec_val_44 - ?44) * (vec_val_44 - ?44)+
            (vec_val_45 - ?45) * (vec_val_45 - ?45)+
            (vec_val_46 - ?46) * (vec_val_46 - ?46)+
            (vec_val_47 - ?47) * (vec_val_47 - ?47)+
            (vec_val_48 - ?48) * (vec_val_48 - ?48)+
            (vec_val_49 - ?49) * (vec_val_49 - ?49)+
            (vec_val_50 - ?50) * (vec_val_50 - ?50)+
            (vec_val_51 - ?51) * (vec_val_51 - ?51)+
            (vec_val_52 - ?52) * (vec_val_52 - ?52)+
            (vec_val_53 - ?53) * (vec_val_53 - ?53)+
            (vec_val_54 - ?54) * (vec_val_54 - ?54)+
            (vec_val_55 - ?55) * (vec_val_55 - ?55)+
            (vec_val_56 - ?56) * (vec_val_56 - ?56)+
            (vec_val_57 - ?57) * (vec_val_57 - ?57)+
            (vec_val_58 - ?58) * (vec_val_58 - ?58)+
            (vec_val_59 - ?59) * (vec_val_59 - ?59)+
            (vec_val_60 - ?60) * (vec_val_60 - ?60)+
            (vec_val_61 - ?61) * (vec_val_61 - ?61)+
            (vec_val_62 - ?62) * (vec_val_62 - ?62)+
            (vec_val_63 - ?63) * (vec_val_63 - ?63)+
            (vec_val_64 - ?64) * (vec_val_64 - ?64)+
            (vec_val_65 - ?65) * (vec_val_65 - ?65)+
            (vec_val_66 - ?66) * (vec_val_66 - ?66)+
            (vec_val_67 - ?67) * (vec_val_67 - ?67)+
            (vec_val_68 - ?68) * (vec_val_68 - ?68)+
            (vec_val_69 - ?69) * (vec_val_69 - ?69)+
            (vec_val_70 - ?70) * (vec_val_70 - ?70)+
            (vec_val_71 - ?71) * (vec_val_71 - ?71)+
            (vec_val_72 - ?72) * (vec_val_72 - ?72)+
            (vec_val_73 - ?73) * (vec_val_73 - ?73)+
            (vec_val_74 - ?74) * (vec_val_74 - ?74)+
            (vec_val_75 - ?75) * (vec_val_75 - ?75)+
            (vec_val_76 - ?76) * (vec_val_76 - ?76)+
            (vec_val_77 - ?77) * (vec_val_77 - ?77)+
            (vec_val_78 - ?78) * (vec_val_78 - ?78)+
            (vec_val_79 - ?79) * (vec_val_79 - ?79)+
            (vec_val_80 - ?80) * (vec_val_80 - ?80)+
            (vec_val_81 - ?81) * (vec_val_81 - ?81)+
            (vec_val_82 - ?82) * (vec_val_82 - ?82)+
            (vec_val_83 - ?83) * (vec_val_83 - ?83)+
            (vec_val_84 - ?84) * (vec_val_84 - ?84)+
            (vec_val_85 - ?85) * (vec_val_85 - ?85)+
            (vec_val_86 - ?86) * (vec_val_86 - ?86)+
            (vec_val_87 - ?87) * (vec_val_87 - ?87)+
            (vec_val_88 - ?88) * (vec_val_88 - ?88)+
            (vec_val_89 - ?89) * (vec_val_89 - ?89)+
            (vec_val_90 - ?90) * (vec_val_90 - ?90)+
            (vec_val_91 - ?91) * (vec_val_91 - ?91)+
            (vec_val_92 - ?92) * (vec_val_92 - ?92)+
            (vec_val_93 - ?93) * (vec_val_93 - ?93)+
            (vec_val_94 - ?94) * (vec_val_94 - ?94)+
            (vec_val_95 - ?95) * (vec_val_95 - ?95)+
            (vec_val_96 - ?96) * (vec_val_96 - ?96)+
            (vec_val_97 - ?97) * (vec_val_97 - ?97)+
            (vec_val_98 - ?98) * (vec_val_98 - ?98)+
            (vec_val_99 - ?99) * (vec_val_99 - ?99)+
            (vec_val_100 - ?100) * (vec_val_100 - ?100)+
            (vec_val_101 - ?101) * (vec_val_101 - ?101)+
            (vec_val_102 - ?102) * (vec_val_102 - ?102)+
            (vec_val_103 - ?103) * (vec_val_103 - ?103)+
            (vec_val_104 - ?104) * (vec_val_104 - ?104)+
            (vec_val_105 - ?105) * (vec_val_105 - ?105)+
            (vec_val_106 - ?106) * (vec_val_106 - ?106)+
            (vec_val_107 - ?107) * (vec_val_107 - ?107)+
            (vec_val_108 - ?108) * (vec_val_108 - ?108)+
            (vec_val_109 - ?109) * (vec_val_109 - ?109)+
            (vec_val_110 - ?110) * (vec_val_110 - ?110)+
            (vec_val_111 - ?111) * (vec_val_111 - ?111)+
            (vec_val_112 - ?112) * (vec_val_112 - ?112)+
            (vec_val_113 - ?113) * (vec_val_113 - ?113)+
            (vec_val_114 - ?114) * (vec_val_114 - ?114)+
            (vec_val_115 - ?115) * (vec_val_115 - ?115)+
            (vec_val_116 - ?116) * (vec_val_116 - ?116)+
            (vec_val_117 - ?117) * (vec_val_117 - ?117)+
            (vec_val_118 - ?118) * (vec_val_118 - ?118)+
            (vec_val_119 - ?119) * (vec_val_119 - ?119)+
            (vec_val_120 - ?120) * (vec_val_120 - ?120)+
            (vec_val_121 - ?121) * (vec_val_121 - ?121)+
            (vec_val_122 - ?122) * (vec_val_122 - ?122)+
            (vec_val_123 - ?123) * (vec_val_123 - ?123)+
            (vec_val_124 - ?124) * (vec_val_124 - ?124)+
            (vec_val_125 - ?125) * (vec_val_125 - ?125)+
            (vec_val_126 - ?126) * (vec_val_126 - ?126)+
            (vec_val_127 - ?127) * (vec_val_127 - ?127)+
            (vec_val_128 - ?128) * (vec_val_128 - ?128)+
            (vec_val_129 - ?129) * (vec_val_129 - ?129)+
            (vec_val_130 - ?130) * (vec_val_130 - ?130)+
            (vec_val_131 - ?131) * (vec_val_131 - ?131)+
            (vec_val_132 - ?132) * (vec_val_132 - ?132)+
            (vec_val_133 - ?133) * (vec_val_133 - ?133)+
            (vec_val_134 - ?134) * (vec_val_134 - ?134)+
            (vec_val_135 - ?135) * (vec_val_135 - ?135)+
            (vec_val_136 - ?136) * (vec_val_136 - ?136)+
            (vec_val_137 - ?137) * (vec_val_137 - ?137)+
            (vec_val_138 - ?138) * (vec_val_138 - ?138)+
            (vec_val_139 - ?139) * (vec_val_139 - ?139)+
            (vec_val_140 - ?140) * (vec_val_140 - ?140)+
            (vec_val_141 - ?141) * (vec_val_141 - ?141)+
            (vec_val_142 - ?142) * (vec_val_142 - ?142)+
            (vec_val_143 - ?143) * (vec_val_143 - ?143)+
            (vec_val_144 - ?144) * (vec_val_144 - ?144)+
            (vec_val_145 - ?145) * (vec_val_145 - ?145)+
            (vec_val_146 - ?146) * (vec_val_146 - ?146)+
            (vec_val_147 - ?147) * (vec_val_147 - ?147)+
            (vec_val_148 - ?148) * (vec_val_148 - ?148)+
            (vec_val_149 - ?149) * (vec_val_149 - ?149)+
            (vec_val_150 - ?150) * (vec_val_150 - ?150)+
            (vec_val_151 - ?151) * (vec_val_151 - ?151)+
            (vec_val_152 - ?152) * (vec_val_152 - ?152)+
            (vec_val_153 - ?153) * (vec_val_153 - ?153)+
            (vec_val_154 - ?154) * (vec_val_154 - ?154)+
            (vec_val_155 - ?155) * (vec_val_155 - ?155)+
            (vec_val_156 - ?156) * (vec_val_156 - ?156)+
            (vec_val_157 - ?157) * (vec_val_157 - ?157)+
            (vec_val_158 - ?158) * (vec_val_158 - ?158)+
            (vec_val_159 - ?159) * (vec_val_159 - ?159)+
            (vec_val_160 - ?160) * (vec_val_160 - ?160)+
            (vec_val_161 - ?161) * (vec_val_161 - ?161)+
            (vec_val_162 - ?162) * (vec_val_162 - ?162)+
            (vec_val_163 - ?163) * (vec_val_163 - ?163)+
            (vec_val_164 - ?164) * (vec_val_164 - ?164)+
            (vec_val_165 - ?165) * (vec_val_165 - ?165)+
            (vec_val_166 - ?166) * (vec_val_166 - ?166)+
            (vec_val_167 - ?167) * (vec_val_167 - ?167)+
            (vec_val_168 - ?168) * (vec_val_168 - ?168)+
            (vec_val_169 - ?169) * (vec_val_169 - ?169)+
            (vec_val_170 - ?170) * (vec_val_170 - ?170)+
            (vec_val_171 - ?171) * (vec_val_171 - ?171)+
            (vec_val_172 - ?172) * (vec_val_172 - ?172)+
            (vec_val_173 - ?173) * (vec_val_173 - ?173)+
            (vec_val_174 - ?174) * (vec_val_174 - ?174)+
            (vec_val_175 - ?175) * (vec_val_175 - ?175)+
            (vec_val_176 - ?176) * (vec_val_176 - ?176)+
            (vec_val_177 - ?177) * (vec_val_177 - ?177)+
            (vec_val_178 - ?178) * (vec_val_178 - ?178)+
            (vec_val_179 - ?179) * (vec_val_179 - ?179)+
            (vec_val_180 - ?180) * (vec_val_180 - ?180)+
            (vec_val_181 - ?181) * (vec_val_181 - ?181)+
            (vec_val_182 - ?182) * (vec_val_182 - ?182)+
            (vec_val_183 - ?183) * (vec_val_183 - ?183)+
            (vec_val_184 - ?184) * (vec_val_184 - ?184)+
            (vec_val_185 - ?185) * (vec_val_185 - ?185)+
            (vec_val_186 - ?186) * (vec_val_186 - ?186)+
            (vec_val_187 - ?187) * (vec_val_187 - ?187)+
            (vec_val_188 - ?188) * (vec_val_188 - ?188)+
            (vec_val_189 - ?189) * (vec_val_189 - ?189)+
            (vec_val_190 - ?190) * (vec_val_190 - ?190)+
            (vec_val_191 - ?191) * (vec_val_191 - ?191)+
            (vec_val_192 - ?192) * (vec_val_192 - ?192)+
            (vec_val_193 - ?193) * (vec_val_193 - ?193)+
            (vec_val_194 - ?194) * (vec_val_194 - ?194)+
            (vec_val_195 - ?195) * (vec_val_195 - ?195)+
            (vec_val_196 - ?196) * (vec_val_196 - ?196)+
            (vec_val_197 - ?197) * (vec_val_197 - ?197)+
            (vec_val_198 - ?198) * (vec_val_198 - ?198)+
            (vec_val_199 - ?199) * (vec_val_199 - ?199)+
            (vec_val_200 - ?200) * (vec_val_200 - ?200)+
            (vec_val_201 - ?201) * (vec_val_201 - ?201)+
            (vec_val_202 - ?202) * (vec_val_202 - ?202)+
            (vec_val_203 - ?203) * (vec_val_203 - ?203)+
            (vec_val_204 - ?204) * (vec_val_204 - ?204)+
            (vec_val_205 - ?205) * (vec_val_205 - ?205)+
            (vec_val_206 - ?206) * (vec_val_206 - ?206)+
            (vec_val_207 - ?207) * (vec_val_207 - ?207)+
            (vec_val_208 - ?208) * (vec_val_208 - ?208)+
            (vec_val_209 - ?209) * (vec_val_209 - ?209)+
            (vec_val_210 - ?210) * (vec_val_210 - ?210)+
            (vec_val_211 - ?211) * (vec_val_211 - ?211)+
            (vec_val_212 - ?212) * (vec_val_212 - ?212)+
            (vec_val_213 - ?213) * (vec_val_213 - ?213)+
            (vec_val_214 - ?214) * (vec_val_214 - ?214)+
            (vec_val_215 - ?215) * (vec_val_215 - ?215)+
            (vec_val_216 - ?216) * (vec_val_216 - ?216)+
            (vec_val_217 - ?217) * (vec_val_217 - ?217)+
            (vec_val_218 - ?218) * (vec_val_218 - ?218)+
            (vec_val_219 - ?219) * (vec_val_219 - ?219)+
            (vec_val_220 - ?220) * (vec_val_220 - ?220)+
            (vec_val_221 - ?221) * (vec_val_221 - ?221)+
            (vec_val_222 - ?222) * (vec_val_222 - ?222)+
            (vec_val_223 - ?223) * (vec_val_223 - ?223)+
            (vec_val_224 - ?224) * (vec_val_224 - ?224)+
            (vec_val_225 - ?225) * (vec_val_225 - ?225)+
            (vec_val_226 - ?226) * (vec_val_226 - ?226)+
            (vec_val_227 - ?227) * (vec_val_227 - ?227)+
            (vec_val_228 - ?228) * (vec_val_228 - ?228)+
            (vec_val_229 - ?229) * (vec_val_229 - ?229)+
            (vec_val_230 - ?230) * (vec_val_230 - ?230)+
            (vec_val_231 - ?231) * (vec_val_231 - ?231)+
            (vec_val_232 - ?232) * (vec_val_232 - ?232)+
            (vec_val_233 - ?233) * (vec_val_233 - ?233)+
            (vec_val_234 - ?234) * (vec_val_234 - ?234)+
            (vec_val_235 - ?235) * (vec_val_235 - ?235)+
            (vec_val_236 - ?236) * (vec_val_236 - ?236)+
            (vec_val_237 - ?237) * (vec_val_237 - ?237)+
            (vec_val_238 - ?238) * (vec_val_238 - ?238)+
            (vec_val_239 - ?239) * (vec_val_239 - ?239)+
            (vec_val_240 - ?240) * (vec_val_240 - ?240)+
            (vec_val_241 - ?241) * (vec_val_241 - ?241)+
            (vec_val_242 - ?242) * (vec_val_242 - ?242)+
            (vec_val_243 - ?243) * (vec_val_243 - ?243)+
            (vec_val_244 - ?244) * (vec_val_244 - ?244)+
            (vec_val_245 - ?245) * (vec_val_245 - ?245)+
            (vec_val_246 - ?246) * (vec_val_246 - ?246)+
            (vec_val_247 - ?247) * (vec_val_247 - ?247)+
            (vec_val_248 - ?248) * (vec_val_248 - ?248)+
            (vec_val_249 - ?249) * (vec_val_249 - ?249)+
            (vec_val_250 - ?250) * (vec_val_250 - ?250)+
            (vec_val_251 - ?251) * (vec_val_251 - ?251)+
            (vec_val_252 - ?252) * (vec_val_252 - ?252)+
            (vec_val_253 - ?253) * (vec_val_253 - ?253)+
            (vec_val_254 - ?254) * (vec_val_254 - ?254)+
            (vec_val_255 - ?255) * (vec_val_255 - ?255)+
            (vec_val_256 - ?256) * (vec_val_256 - ?256)+
            (vec_val_257 - ?257) * (vec_val_257 - ?257)+
            (vec_val_258 - ?258) * (vec_val_258 - ?258)+
            (vec_val_259 - ?259) * (vec_val_259 - ?259)+
            (vec_val_260 - ?260) * (vec_val_260 - ?260)+
            (vec_val_261 - ?261) * (vec_val_261 - ?261)+
            (vec_val_262 - ?262) * (vec_val_262 - ?262)+
            (vec_val_263 - ?263) * (vec_val_263 - ?263)+
            (vec_val_264 - ?264) * (vec_val_264 - ?264)+
            (vec_val_265 - ?265) * (vec_val_265 - ?265)+
            (vec_val_266 - ?266) * (vec_val_266 - ?266)+
            (vec_val_267 - ?267) * (vec_val_267 - ?267)+
            (vec_val_268 - ?268) * (vec_val_268 - ?268)+
            (vec_val_269 - ?269) * (vec_val_269 - ?269)+
            (vec_val_270 - ?270) * (vec_val_270 - ?270)+
            (vec_val_271 - ?271) * (vec_val_271 - ?271)+
            (vec_val_272 - ?272) * (vec_val_272 - ?272)+
            (vec_val_273 - ?273) * (vec_val_273 - ?273)+
            (vec_val_274 - ?274) * (vec_val_274 - ?274)+
            (vec_val_275 - ?275) * (vec_val_275 - ?275)+
            (vec_val_276 - ?276) * (vec_val_276 - ?276)+
            (vec_val_277 - ?277) * (vec_val_277 - ?277)+
            (vec_val_278 - ?278) * (vec_val_278 - ?278)+
            (vec_val_279 - ?279) * (vec_val_279 - ?279)+
            (vec_val_280 - ?280) * (vec_val_280 - ?280)+
            (vec_val_281 - ?281) * (vec_val_281 - ?281)+
            (vec_val_282 - ?282) * (vec_val_282 - ?282)+
            (vec_val_283 - ?283) * (vec_val_283 - ?283)+
            (vec_val_284 - ?284) * (vec_val_284 - ?284)+
            (vec_val_285 - ?285) * (vec_val_285 - ?285)+
            (vec_val_286 - ?286) * (vec_val_286 - ?286)+
            (vec_val_287 - ?287) * (vec_val_287 - ?287)+
            (vec_val_288 - ?288) * (vec_val_288 - ?288)+
            (vec_val_289 - ?289) * (vec_val_289 - ?289)+
            (vec_val_290 - ?290) * (vec_val_290 - ?290)+
            (vec_val_291 - ?291) * (vec_val_291 - ?291)+
            (vec_val_292 - ?292) * (vec_val_292 - ?292)+
            (vec_val_293 - ?293) * (vec_val_293 - ?293)+
            (vec_val_294 - ?294) * (vec_val_294 - ?294)+
            (vec_val_295 - ?295) * (vec_val_295 - ?295)+
            (vec_val_296 - ?296) * (vec_val_296 - ?296)+
            (vec_val_297 - ?297) * (vec_val_297 - ?297)+
            (vec_val_298 - ?298) * (vec_val_298 - ?298)+
            (vec_val_299 - ?299) * (vec_val_299 - ?299)+
            (vec_val_300 - ?300) * (vec_val_300 - ?300)+
            (vec_val_301 - ?301) * (vec_val_301 - ?301)+
            (vec_val_302 - ?302) * (vec_val_302 - ?302)+
            (vec_val_303 - ?303) * (vec_val_303 - ?303)+
            (vec_val_304 - ?304) * (vec_val_304 - ?304)+
            (vec_val_305 - ?305) * (vec_val_305 - ?305)+
            (vec_val_306 - ?306) * (vec_val_306 - ?306)+
            (vec_val_307 - ?307) * (vec_val_307 - ?307)+
            (vec_val_308 - ?308) * (vec_val_308 - ?308)+
            (vec_val_309 - ?309) * (vec_val_309 - ?309)+
            (vec_val_310 - ?310) * (vec_val_310 - ?310)+
            (vec_val_311 - ?311) * (vec_val_311 - ?311)+
            (vec_val_312 - ?312) * (vec_val_312 - ?312)+
            (vec_val_313 - ?313) * (vec_val_313 - ?313)+
            (vec_val_314 - ?314) * (vec_val_314 - ?314)+
            (vec_val_315 - ?315) * (vec_val_315 - ?315)+
            (vec_val_316 - ?316) * (vec_val_316 - ?316)+
            (vec_val_317 - ?317) * (vec_val_317 - ?317)+
            (vec_val_318 - ?318) * (vec_val_318 - ?318)+
            (vec_val_319 - ?319) * (vec_val_319 - ?319)+
            (vec_val_320 - ?320) * (vec_val_320 - ?320)+
            (vec_val_321 - ?321) * (vec_val_321 - ?321)+
            (vec_val_322 - ?322) * (vec_val_322 - ?322)+
            (vec_val_323 - ?323) * (vec_val_323 - ?323)+
            (vec_val_324 - ?324) * (vec_val_324 - ?324)+
            (vec_val_325 - ?325) * (vec_val_325 - ?325)+
            (vec_val_326 - ?326) * (vec_val_326 - ?326)+
            (vec_val_327 - ?327) * (vec_val_327 - ?327)+
            (vec_val_328 - ?328) * (vec_val_328 - ?328)+
            (vec_val_329 - ?329) * (vec_val_329 - ?329)+
            (vec_val_330 - ?330) * (vec_val_330 - ?330)+
            (vec_val_331 - ?331) * (vec_val_331 - ?331)+
            (vec_val_332 - ?332) * (vec_val_332 - ?332)+
            (vec_val_333 - ?333) * (vec_val_333 - ?333)+
            (vec_val_334 - ?334) * (vec_val_334 - ?334)+
            (vec_val_335 - ?335) * (vec_val_335 - ?335)+
            (vec_val_336 - ?336) * (vec_val_336 - ?336)+
            (vec_val_337 - ?337) * (vec_val_337 - ?337)+
            (vec_val_338 - ?338) * (vec_val_338 - ?338)+
            (vec_val_339 - ?339) * (vec_val_339 - ?339)+
            (vec_val_340 - ?340) * (vec_val_340 - ?340)+
            (vec_val_341 - ?341) * (vec_val_341 - ?341)+
            (vec_val_342 - ?342) * (vec_val_342 - ?342)+
            (vec_val_343 - ?343) * (vec_val_343 - ?343)+
            (vec_val_344 - ?344) * (vec_val_344 - ?344)+
            (vec_val_345 - ?345) * (vec_val_345 - ?345)+
            (vec_val_346 - ?346) * (vec_val_346 - ?346)+
            (vec_val_347 - ?347) * (vec_val_347 - ?347)+
            (vec_val_348 - ?348) * (vec_val_348 - ?348)+
            (vec_val_349 - ?349) * (vec_val_349 - ?349)+
            (vec_val_350 - ?350) * (vec_val_350 - ?350)+
            (vec_val_351 - ?351) * (vec_val_351 - ?351)+
            (vec_val_352 - ?352) * (vec_val_352 - ?352)+
            (vec_val_353 - ?353) * (vec_val_353 - ?353)+
            (vec_val_354 - ?354) * (vec_val_354 - ?354)+
            (vec_val_355 - ?355) * (vec_val_355 - ?355)+
            (vec_val_356 - ?356) * (vec_val_356 - ?356)+
            (vec_val_357 - ?357) * (vec_val_357 - ?357)+
            (vec_val_358 - ?358) * (vec_val_358 - ?358)+
            (vec_val_359 - ?359) * (vec_val_359 - ?359)+
            (vec_val_360 - ?360) * (vec_val_360 - ?360)+
            (vec_val_361 - ?361) * (vec_val_361 - ?361)+
            (vec_val_362 - ?362) * (vec_val_362 - ?362)+
            (vec_val_363 - ?363) * (vec_val_363 - ?363)+
            (vec_val_364 - ?364) * (vec_val_364 - ?364)+
            (vec_val_365 - ?365) * (vec_val_365 - ?365)+
            (vec_val_366 - ?366) * (vec_val_366 - ?366)+
            (vec_val_367 - ?367) * (vec_val_367 - ?367)+
            (vec_val_368 - ?368) * (vec_val_368 - ?368)+
            (vec_val_369 - ?369) * (vec_val_369 - ?369)+
            (vec_val_370 - ?370) * (vec_val_370 - ?370)+
            (vec_val_371 - ?371) * (vec_val_371 - ?371)+
            (vec_val_372 - ?372) * (vec_val_372 - ?372)+
            (vec_val_373 - ?373) * (vec_val_373 - ?373)+
            (vec_val_374 - ?374) * (vec_val_374 - ?374)+
            (vec_val_375 - ?375) * (vec_val_375 - ?375)+
            (vec_val_376 - ?376) * (vec_val_376 - ?376)+
            (vec_val_377 - ?377) * (vec_val_377 - ?377)+
            (vec_val_378 - ?378) * (vec_val_378 - ?378)+
            (vec_val_379 - ?379) * (vec_val_379 - ?379)+
            (vec_val_380 - ?380) * (vec_val_380 - ?380)+
            (vec_val_381 - ?381) * (vec_val_381 - ?381)+
            (vec_val_382 - ?382) * (vec_val_382 - ?382)+
            (vec_val_383 - ?383) * (vec_val_383 - ?383)+
            (vec_val_384 - ?384) * (vec_val_384 - ?384)+
            (vec_val_385 - ?385) * (vec_val_385 - ?385)+
            (vec_val_386 - ?386) * (vec_val_386 - ?386)+
            (vec_val_387 - ?387) * (vec_val_387 - ?387)+
            (vec_val_388 - ?388) * (vec_val_388 - ?388)+
            (vec_val_389 - ?389) * (vec_val_389 - ?389)+
            (vec_val_390 - ?390) * (vec_val_390 - ?390)+
            (vec_val_391 - ?391) * (vec_val_391 - ?391)+
            (vec_val_392 - ?392) * (vec_val_392 - ?392)+
            (vec_val_393 - ?393) * (vec_val_393 - ?393)+
            (vec_val_394 - ?394) * (vec_val_394 - ?394)+
            (vec_val_395 - ?395) * (vec_val_395 - ?395)+
            (vec_val_396 - ?396) * (vec_val_396 - ?396)+
            (vec_val_397 - ?397) * (vec_val_397 - ?397)+
            (vec_val_398 - ?398) * (vec_val_398 - ?398)+
            (vec_val_399 - ?399) * (vec_val_399 - ?399)+
            (vec_val_400 - ?400) * (vec_val_400 - ?400)+
            (vec_val_401 - ?401) * (vec_val_401 - ?401)+
            (vec_val_402 - ?402) * (vec_val_402 - ?402)+
            (vec_val_403 - ?403) * (vec_val_403 - ?403)+
            (vec_val_404 - ?404) * (vec_val_404 - ?404)+
            (vec_val_405 - ?405) * (vec_val_405 - ?405)+
            (vec_val_406 - ?406) * (vec_val_406 - ?406)+
            (vec_val_407 - ?407) * (vec_val_407 - ?407)+
            (vec_val_408 - ?408) * (vec_val_408 - ?408)+
            (vec_val_409 - ?409) * (vec_val_409 - ?409)+
            (vec_val_410 - ?410) * (vec_val_410 - ?410)+
            (vec_val_411 - ?411) * (vec_val_411 - ?411)+
            (vec_val_412 - ?412) * (vec_val_412 - ?412)+
            (vec_val_413 - ?413) * (vec_val_413 - ?413)+
            (vec_val_414 - ?414) * (vec_val_414 - ?414)+
            (vec_val_415 - ?415) * (vec_val_415 - ?415)+
            (vec_val_416 - ?416) * (vec_val_416 - ?416)+
            (vec_val_417 - ?417) * (vec_val_417 - ?417)+
            (vec_val_418 - ?418) * (vec_val_418 - ?418)+
            (vec_val_419 - ?419) * (vec_val_419 - ?419)+
            (vec_val_420 - ?420) * (vec_val_420 - ?420)+
            (vec_val_421 - ?421) * (vec_val_421 - ?421)+
            (vec_val_422 - ?422) * (vec_val_422 - ?422)+
            (vec_val_423 - ?423) * (vec_val_423 - ?423)+
            (vec_val_424 - ?424) * (vec_val_424 - ?424)+
            (vec_val_425 - ?425) * (vec_val_425 - ?425)+
            (vec_val_426 - ?426) * (vec_val_426 - ?426)+
            (vec_val_427 - ?427) * (vec_val_427 - ?427)+
            (vec_val_428 - ?428) * (vec_val_428 - ?428)+
            (vec_val_429 - ?429) * (vec_val_429 - ?429)+
            (vec_val_430 - ?430) * (vec_val_430 - ?430)+
            (vec_val_431 - ?431) * (vec_val_431 - ?431)+
            (vec_val_432 - ?432) * (vec_val_432 - ?432)+
            (vec_val_433 - ?433) * (vec_val_433 - ?433)+
            (vec_val_434 - ?434) * (vec_val_434 - ?434)+
            (vec_val_435 - ?435) * (vec_val_435 - ?435)+
            (vec_val_436 - ?436) * (vec_val_436 - ?436)+
            (vec_val_437 - ?437) * (vec_val_437 - ?437)+
            (vec_val_438 - ?438) * (vec_val_438 - ?438)+
            (vec_val_439 - ?439) * (vec_val_439 - ?439)+
            (vec_val_440 - ?440) * (vec_val_440 - ?440)+
            (vec_val_441 - ?441) * (vec_val_441 - ?441)+
            (vec_val_442 - ?442) * (vec_val_442 - ?442)+
            (vec_val_443 - ?443) * (vec_val_443 - ?443)+
            (vec_val_444 - ?444) * (vec_val_444 - ?444)+
            (vec_val_445 - ?445) * (vec_val_445 - ?445)+
            (vec_val_446 - ?446) * (vec_val_446 - ?446)+
            (vec_val_447 - ?447) * (vec_val_447 - ?447)+
            (vec_val_448 - ?448) * (vec_val_448 - ?448)+
            (vec_val_449 - ?449) * (vec_val_449 - ?449)+
            (vec_val_450 - ?450) * (vec_val_450 - ?450)+
            (vec_val_451 - ?451) * (vec_val_451 - ?451)+
            (vec_val_452 - ?452) * (vec_val_452 - ?452)+
            (vec_val_453 - ?453) * (vec_val_453 - ?453)+
            (vec_val_454 - ?454) * (vec_val_454 - ?454)+
            (vec_val_455 - ?455) * (vec_val_455 - ?455)+
            (vec_val_456 - ?456) * (vec_val_456 - ?456)+
            (vec_val_457 - ?457) * (vec_val_457 - ?457)+
            (vec_val_458 - ?458) * (vec_val_458 - ?458)+
            (vec_val_459 - ?459) * (vec_val_459 - ?459)+
            (vec_val_460 - ?460) * (vec_val_460 - ?460)+
            (vec_val_461 - ?461) * (vec_val_461 - ?461)+
            (vec_val_462 - ?462) * (vec_val_462 - ?462)+
            (vec_val_463 - ?463) * (vec_val_463 - ?463)+
            (vec_val_464 - ?464) * (vec_val_464 - ?464)+
            (vec_val_465 - ?465) * (vec_val_465 - ?465)+
            (vec_val_466 - ?466) * (vec_val_466 - ?466)+
            (vec_val_467 - ?467) * (vec_val_467 - ?467)+
            (vec_val_468 - ?468) * (vec_val_468 - ?468)+
            (vec_val_469 - ?469) * (vec_val_469 - ?469)+
            (vec_val_470 - ?470) * (vec_val_470 - ?470)+
            (vec_val_471 - ?471) * (vec_val_471 - ?471)+
            (vec_val_472 - ?472) * (vec_val_472 - ?472)+
            (vec_val_473 - ?473) * (vec_val_473 - ?473)+
            (vec_val_474 - ?474) * (vec_val_474 - ?474)+
            (vec_val_475 - ?475) * (vec_val_475 - ?475)+
            (vec_val_476 - ?476) * (vec_val_476 - ?476)+
            (vec_val_477 - ?477) * (vec_val_477 - ?477)+
            (vec_val_478 - ?478) * (vec_val_478 - ?478)+
            (vec_val_479 - ?479) * (vec_val_479 - ?479)+
            (vec_val_480 - ?480) * (vec_val_480 - ?480)+
            (vec_val_481 - ?481) * (vec_val_481 - ?481)+
            (vec_val_482 - ?482) * (vec_val_482 - ?482)+
            (vec_val_483 - ?483) * (vec_val_483 - ?483)+
            (vec_val_484 - ?484) * (vec_val_484 - ?484)+
            (vec_val_485 - ?485) * (vec_val_485 - ?485)+
            (vec_val_486 - ?486) * (vec_val_486 - ?486)+
            (vec_val_487 - ?487) * (vec_val_487 - ?487)+
            (vec_val_488 - ?488) * (vec_val_488 - ?488)+
            (vec_val_489 - ?489) * (vec_val_489 - ?489)+
            (vec_val_490 - ?490) * (vec_val_490 - ?490)+
            (vec_val_491 - ?491) * (vec_val_491 - ?491)+
            (vec_val_492 - ?492) * (vec_val_492 - ?492)+
            (vec_val_493 - ?493) * (vec_val_493 - ?493)+
            (vec_val_494 - ?494) * (vec_val_494 - ?494)+
            (vec_val_495 - ?495) * (vec_val_495 - ?495)+
            (vec_val_496 - ?496) * (vec_val_496 - ?496)+
            (vec_val_497 - ?497) * (vec_val_497 - ?497)+
            (vec_val_498 - ?498) * (vec_val_498 - ?498)+
            (vec_val_499 - ?499) * (vec_val_499 - ?499)+
            (vec_val_500 - ?500) * (vec_val_500 - ?500)+
            (vec_val_501 - ?501) * (vec_val_501 - ?501)+
            (vec_val_502 - ?502) * (vec_val_502 - ?502)+
            (vec_val_503 - ?503) * (vec_val_503 - ?503)+
            (vec_val_504 - ?504) * (vec_val_504 - ?504)+
            (vec_val_505 - ?505) * (vec_val_505 - ?505)+
            (vec_val_506 - ?506) * (vec_val_506 - ?506)+
            (vec_val_507 - ?507) * (vec_val_507 - ?507)+
            (vec_val_508 - ?508) * (vec_val_508 - ?508)+
            (vec_val_509 - ?509) * (vec_val_509 - ?509)+
            (vec_val_510 - ?510) * (vec_val_510 - ?510)+
            (vec_val_511 - ?511) * (vec_val_511 - ?511)+
            (vec_val_512 - ?512) * (vec_val_512 - ?512)
            ) AS l2norm FROM vectors ORDER BY l2norm ASC limit 1;
        """.trimIndent(), params
        )

        val items: List<SearchVectorResult> = mutableListOf()
        for (i in 0..<cursor.count) {
            if (cursor.moveToNext()) {
                val colId = cursor.getColumnIndex("id")
                val colName = cursor.getColumnIndex("name")
                val colThumbnail = cursor.getColumnIndex("thumbnail")
                val colL2Norm = cursor.getColumnIndex("l2norm")

                // Check if we don't have any rows
                if (colId == -1 || colName == -1 || colThumbnail == -1 || colL2Norm == -1) {
                    throw Exception("Invalid column names detected in database file.")
                }

                // Get data from sqlite database
                val id = cursor.getInt(colId)
                val name = cursor.getString(colName)
                val thumbnail = cursor.getString(colThumbnail)
                val l2norm = sqrt(cursor.getFloat(colL2Norm))

                return if (l2norm >= minThreshold && l2norm <= maxThreshold) {
                    items.plus(SearchVectorResult(id = id, name = name, thumbnail = thumbnail, matchScore = l2norm))
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
        database!!.rawQuery(
            """
            INSERT INTO vectors 
            (name,thumbnail,vec_val_1,vec_val_2,vec_val_3,vec_val_4,vec_val_5,vec_val_6,vec_val_7,vec_val_8,vec_val_9,vec_val_10,vec_val_11,vec_val_12,vec_val_13,vec_val_14,vec_val_15,vec_val_16,vec_val_17,vec_val_18,vec_val_19,vec_val_20,vec_val_21,vec_val_22,vec_val_23,vec_val_24,vec_val_25,vec_val_26,vec_val_27,vec_val_28,vec_val_29,vec_val_30,vec_val_31,vec_val_32,vec_val_33,vec_val_34,vec_val_35,vec_val_36,vec_val_37,vec_val_38,vec_val_39,vec_val_40,vec_val_41,vec_val_42,vec_val_43,vec_val_44,vec_val_45,vec_val_46,vec_val_47,vec_val_48,vec_val_49,vec_val_50,vec_val_51,vec_val_52,vec_val_53,vec_val_54,vec_val_55,vec_val_56,vec_val_57,vec_val_58,vec_val_59,vec_val_60,vec_val_61,vec_val_62,vec_val_63,vec_val_64,vec_val_65,vec_val_66,vec_val_67,vec_val_68,vec_val_69,vec_val_70,vec_val_71,vec_val_72,vec_val_73,vec_val_74,vec_val_75,vec_val_76,vec_val_77,vec_val_78,vec_val_79,vec_val_80,vec_val_81,vec_val_82,vec_val_83,vec_val_84,vec_val_85,vec_val_86,vec_val_87,vec_val_88,vec_val_89,vec_val_90,vec_val_91,vec_val_92,vec_val_93,vec_val_94,vec_val_95,vec_val_96,vec_val_97,vec_val_98,vec_val_99,vec_val_100,vec_val_101,vec_val_102,vec_val_103,vec_val_104,vec_val_105,vec_val_106,vec_val_107,vec_val_108,vec_val_109,vec_val_110,vec_val_111,vec_val_112,vec_val_113,vec_val_114,vec_val_115,vec_val_116,vec_val_117,vec_val_118,vec_val_119,vec_val_120,vec_val_121,vec_val_122,vec_val_123,vec_val_124,vec_val_125,vec_val_126,vec_val_127,vec_val_128,vec_val_129,vec_val_130,vec_val_131,vec_val_132,vec_val_133,vec_val_134,vec_val_135,vec_val_136,vec_val_137,vec_val_138,vec_val_139,vec_val_140,vec_val_141,vec_val_142,vec_val_143,vec_val_144,vec_val_145,vec_val_146,vec_val_147,vec_val_148,vec_val_149,vec_val_150,vec_val_151,vec_val_152,vec_val_153,vec_val_154,vec_val_155,vec_val_156,vec_val_157,vec_val_158,vec_val_159,vec_val_160,vec_val_161,vec_val_162,vec_val_163,vec_val_164,vec_val_165,vec_val_166,vec_val_167,vec_val_168,vec_val_169,vec_val_170,vec_val_171,vec_val_172,vec_val_173,vec_val_174,vec_val_175,vec_val_176,vec_val_177,vec_val_178,vec_val_179,vec_val_180,vec_val_181,vec_val_182,vec_val_183,vec_val_184,vec_val_185,vec_val_186,vec_val_187,vec_val_188,vec_val_189,vec_val_190,vec_val_191,vec_val_192,vec_val_193,vec_val_194,vec_val_195,vec_val_196,vec_val_197,vec_val_198,vec_val_199,vec_val_200,vec_val_201,vec_val_202,vec_val_203,vec_val_204,vec_val_205,vec_val_206,vec_val_207,vec_val_208,vec_val_209,vec_val_210,vec_val_211,vec_val_212,vec_val_213,vec_val_214,vec_val_215,vec_val_216,vec_val_217,vec_val_218,vec_val_219,vec_val_220,vec_val_221,vec_val_222,vec_val_223,vec_val_224,vec_val_225,vec_val_226,vec_val_227,vec_val_228,vec_val_229,vec_val_230,vec_val_231,vec_val_232,vec_val_233,vec_val_234,vec_val_235,vec_val_236,vec_val_237,vec_val_238,vec_val_239,vec_val_240,vec_val_241,vec_val_242,vec_val_243,vec_val_244,vec_val_245,vec_val_246,vec_val_247,vec_val_248,vec_val_249,vec_val_250,vec_val_251,vec_val_252,vec_val_253,vec_val_254,vec_val_255,vec_val_256,vec_val_257,vec_val_258,vec_val_259,vec_val_260,vec_val_261,vec_val_262,vec_val_263,vec_val_264,vec_val_265,vec_val_266,vec_val_267,vec_val_268,vec_val_269,vec_val_270,vec_val_271,vec_val_272,vec_val_273,vec_val_274,vec_val_275,vec_val_276,vec_val_277,vec_val_278,vec_val_279,vec_val_280,vec_val_281,vec_val_282,vec_val_283,vec_val_284,vec_val_285,vec_val_286,vec_val_287,vec_val_288,vec_val_289,vec_val_290,vec_val_291,vec_val_292,vec_val_293,vec_val_294,vec_val_295,vec_val_296,vec_val_297,vec_val_298,vec_val_299,vec_val_300,vec_val_301,vec_val_302,vec_val_303,vec_val_304,vec_val_305,vec_val_306,vec_val_307,vec_val_308,vec_val_309,vec_val_310,vec_val_311,vec_val_312,vec_val_313,vec_val_314,vec_val_315,vec_val_316,vec_val_317,vec_val_318,vec_val_319,vec_val_320,vec_val_321,vec_val_322,vec_val_323,vec_val_324,vec_val_325,vec_val_326,vec_val_327,vec_val_328,vec_val_329,vec_val_330,vec_val_331,vec_val_332,vec_val_333,vec_val_334,vec_val_335,vec_val_336,vec_val_337,vec_val_338,vec_val_339,vec_val_340,vec_val_341,vec_val_342,vec_val_343,vec_val_344,vec_val_345,vec_val_346,vec_val_347,vec_val_348,vec_val_349,vec_val_350,vec_val_351,vec_val_352,vec_val_353,vec_val_354,vec_val_355,vec_val_356,vec_val_357,vec_val_358,vec_val_359,vec_val_360,vec_val_361,vec_val_362,vec_val_363,vec_val_364,vec_val_365,vec_val_366,vec_val_367,vec_val_368,vec_val_369,vec_val_370,vec_val_371,vec_val_372,vec_val_373,vec_val_374,vec_val_375,vec_val_376,vec_val_377,vec_val_378,vec_val_379,vec_val_380,vec_val_381,vec_val_382,vec_val_383,vec_val_384,vec_val_385,vec_val_386,vec_val_387,vec_val_388,vec_val_389,vec_val_390,vec_val_391,vec_val_392,vec_val_393,vec_val_394,vec_val_395,vec_val_396,vec_val_397,vec_val_398,vec_val_399,vec_val_400,vec_val_401,vec_val_402,vec_val_403,vec_val_404,vec_val_405,vec_val_406,vec_val_407,vec_val_408,vec_val_409,vec_val_410,vec_val_411,vec_val_412,vec_val_413,vec_val_414,vec_val_415,vec_val_416,vec_val_417,vec_val_418,vec_val_419,vec_val_420,vec_val_421,vec_val_422,vec_val_423,vec_val_424,vec_val_425,vec_val_426,vec_val_427,vec_val_428,vec_val_429,vec_val_430,vec_val_431,vec_val_432,vec_val_433,vec_val_434,vec_val_435,vec_val_436,vec_val_437,vec_val_438,vec_val_439,vec_val_440,vec_val_441,vec_val_442,vec_val_443,vec_val_444,vec_val_445,vec_val_446,vec_val_447,vec_val_448,vec_val_449,vec_val_450,vec_val_451,vec_val_452,vec_val_453,vec_val_454,vec_val_455,vec_val_456,vec_val_457,vec_val_458,vec_val_459,vec_val_460,vec_val_461,vec_val_462,vec_val_463,vec_val_464,vec_val_465,vec_val_466,vec_val_467,vec_val_468,vec_val_469,vec_val_470,vec_val_471,vec_val_472,vec_val_473,vec_val_474,vec_val_475,vec_val_476,vec_val_477,vec_val_478,vec_val_479,vec_val_480,vec_val_481,vec_val_482,vec_val_483,vec_val_484,vec_val_485,vec_val_486,vec_val_487,vec_val_488,vec_val_489,vec_val_490,vec_val_491,vec_val_492,vec_val_493,vec_val_494,vec_val_495,vec_val_496,vec_val_497,vec_val_498,vec_val_499,vec_val_500,vec_val_501,vec_val_502,vec_val_503,vec_val_504,vec_val_505,vec_val_506,vec_val_507,vec_val_508,vec_val_509,vec_val_510,vec_val_511,vec_val_512)
            VALUES (${data.name}, ${data.thumbnail}, ?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15,?16,?17,?18,?19,?20,?21,?22,?23,?24,?25,?26,?27,?28,?29,?30,?31,?32,?33,?34,?35,?36,?37,?38,?39,?40,?41,?42,?43,?44,?45,?46,?47,?48,?49,?50,?51,?52,?53,?54,?55,?56,?57,?58,?59,?60,?61,?62,?63,?64,?65,?66,?67,?68,?69,?70,?71,?72,?73,?74,?75,?76,?77,?78,?79,?80,?81,?82,?83,?84,?85,?86,?87,?88,?89,?90,?91,?92,?93,?94,?95,?96,?97,?98,?99,?100,?101,?102,?103,?104,?105,?106,?107,?108,?109,?110,?111,?112,?113,?114,?115,?116,?117,?118,?119,?120,?121,?122,?123,?124,?125,?126,?127,?128,?129,?130,?131,?132,?133,?134,?135,?136,?137,?138,?139,?140,?141,?142,?143,?144,?145,?146,?147,?148,?149,?150,?151,?152,?153,?154,?155,?156,?157,?158,?159,?160,?161,?162,?163,?164,?165,?166,?167,?168,?169,?170,?171,?172,?173,?174,?175,?176,?177,?178,?179,?180,?181,?182,?183,?184,?185,?186,?187,?188,?189,?190,?191,?192,?193,?194,?195,?196,?197,?198,?199,?200,?201,?202,?203,?204,?205,?206,?207,?208,?209,?210,?211,?212,?213,?214,?215,?216,?217,?218,?219,?220,?221,?222,?223,?224,?225,?226,?227,?228,?229,?230,?231,?232,?233,?234,?235,?236,?237,?238,?239,?240,?241,?242,?243,?244,?245,?246,?247,?248,?249,?250,?251,?252,?253,?254,?255,?256,?257,?258,?259,?260,?261,?262,?263,?264,?265,?266,?267,?268,?269,?270,?271,?272,?273,?274,?275,?276,?277,?278,?279,?280,?281,?282,?283,?284,?285,?286,?287,?288,?289,?290,?291,?292,?293,?294,?295,?296,?297,?298,?299,?300,?301,?302,?303,?304,?305,?306,?307,?308,?309,?310,?311,?312,?313,?314,?315,?316,?317,?318,?319,?320,?321,?322,?323,?324,?325,?326,?327,?328,?329,?330,?331,?332,?333,?334,?335,?336,?337,?338,?339,?340,?341,?342,?343,?344,?345,?346,?347,?348,?349,?350,?351,?352,?353,?354,?355,?356,?357,?358,?359,?360,?361,?362,?363,?364,?365,?366,?367,?368,?369,?370,?371,?372,?373,?374,?375,?376,?377,?378,?379,?380,?381,?382,?383,?384,?385,?386,?387,?388,?389,?390,?391,?392,?393,?394,?395,?396,?397,?398,?399,?400,?401,?402,?403,?404,?405,?406,?407,?408,?409,?410,?411,?412,?413,?414,?415,?416,?417,?418,?419,?420,?421,?422,?423,?424,?425,?426,?427,?428,?429,?430,?431,?432,?433,?434,?435,?436,?437,?438,?439,?440,?441,?442,?443,?444,?445,?446,?447,?448,?449,?450,?451,?452,?453,?454,?455,?456,?457,?458,?459,?460,?461,?462,?463,?464,?465,?466,?467,?468,?469,?470,?471,?472,?473,?474,?475,?476,?477,?478,?479,?480,?481,?482,?483,?484,?485,?486,?487,?488,?489,?490,?491,?492,?493,?494,?495,?496,?497,?498,?499,?500,?501,?502,?503,?504,?505,?506,?507,?508,?509,?510,?511,?512);
        """.trimIndent(), vectors
        )
    }

    override suspend fun deleteVectors(id: Int) {
        // load database if not loaded.
        if (database == null) loadDatabase()

        database!!.rawQuery("DELETE FROM vectors WHERE id = ?1;", arrayOf(id))
    }
}