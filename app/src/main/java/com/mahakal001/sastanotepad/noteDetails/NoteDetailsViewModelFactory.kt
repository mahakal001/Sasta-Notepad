package com.mahakal001.sastanotepad.noteDetails

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mahakal001.sastanotepad.database.NotesDatabaseDao
import java.lang.IllegalArgumentException
import javax.sql.CommonDataSource

class NoteDetailsViewModelFactory(
    private val noteId : Long,
    private val dataSource: NotesDatabaseDao
     ) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun<T : ViewModel?> create(modelClass: Class<T>): T{
        if( modelClass.isAssignableFrom(NoteDetailsViewModel::class.java)){
            return NoteDetailsViewModel(noteId,dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}