package com.mahakal001.sastanotepad.takeNote

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mahakal001.sastanotepad.database.NotesDatabaseDao

class TakeNoteViewModelFactory(
    private val dataSource : NotesDatabaseDao,
    private val application: Application ) : ViewModelProvider.Factory  {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TakeNoteViewModel::class.java)) {
            return TakeNoteViewModel(dataSource,application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}