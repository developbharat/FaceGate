package com.developbharat.facegate.domain.data

import tables.PeopleQueries
import tables.VectorsQueries

interface ISQLiteDatabase {
    val vectorsDao: VectorsQueries
    val peopleDao: PeopleQueries
}