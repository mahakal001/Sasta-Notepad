package com.mahakal001.sastanotepad.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NotesDatabaseDao {

    @Insert
    fun insert(note : Notes)

    @Update
    fun update(note: Notes)

    @Query ("DELETE FROM notes_table")
    fun clear()

    @Query("SELECT * FROM notes_table ORDER BY noteId DESC")
    fun getAllNotes() : LiveData<List<Notes>>

    @Query("SELECT * from notes_table WHERE noteId = :key")
    fun getNoteWithId(key: Long): LiveData<Notes>
}