package com.mahakal001.sastanotepad.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Notes (

    @PrimaryKey(autoGenerate = true)
    val noteId: Long = 0L,

    @ColumnInfo(name = "record_time_milli")
    val recordTiming: Long = System.currentTimeMillis(),

    @ColumnInfo(name = "notes_string")
    var Notes : String = ""
)