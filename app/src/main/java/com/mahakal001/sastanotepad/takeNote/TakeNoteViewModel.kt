package com.mahakal001.sastanotepad.takeNote

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.mahakal001.sastanotepad.database.Notes
import com.mahakal001.sastanotepad.database.NotesDatabaseDao
import com.mahakal001.sastanotepad.formatNotes
import kotlinx.coroutines.*


class TakeNoteViewModel (
    val database: NotesDatabaseDao,
    application: Application) : AndroidViewModel(application) {

    // Start of Class definitions
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val allNotes = database.getAllNotes()

    init{
        Log.i("TakeNoteViewModel","TakeNoteViewModel created!")
    }

    fun onTakeNoteCompleted(note_text : String ) {
        uiScope.launch {
            val newNote = Notes()
            newNote.notes = note_text
            insert(newNote)
        }
    }

    private suspend fun insert( notes : Notes){
        withContext(Dispatchers.IO){
            database.insert(notes)
        }
    }

    fun onClearButtonPressed(){
        uiScope.launch {
            clearDB()
        }
    }

    private suspend fun clearDB(){
        withContext(Dispatchers.IO){
            database.clear()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
        Log.i("TakeNoteViewModel", "TakeNoteViewModel destroyed!")
    }

    private val _navigateToNoteDetail = MutableLiveData<Long>()
    val navigateToNoteDetail
        get() = _navigateToNoteDetail


    fun onNoteClicked(id: Long){
        _navigateToNoteDetail.value = id
    }

    fun onNoteDetailNavigated() {
        _navigateToNoteDetail.value = null
    }

}