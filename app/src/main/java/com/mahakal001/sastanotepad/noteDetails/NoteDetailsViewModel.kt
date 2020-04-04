package com.mahakal001.sastanotepad.noteDetails

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mahakal001.sastanotepad.database.Notes
import com.mahakal001.sastanotepad.database.NotesDatabaseDao
import kotlinx.coroutines.Job


class NoteDetailsViewModel(
    private val noteKey: Long = 0L,
    dataSource : NotesDatabaseDao ) : ViewModel(){

    /**
     * Hold a reference to SleepDatabase via its SleepDatabaseDao.
     */
    val database = dataSource

    /** Coroutine setup variables */

    /**
     * viewModelJob allows us to cancel all coroutines started by this ViewModel.
     */
    private val viewModelJob = Job()

    private val note: LiveData<Notes>
    fun getNight() = note

    init {
        note = database.getNoteWithId( noteKey )
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("TakeNoteViewModel", "TakeNoteViewModel destroyed!")
    }
}