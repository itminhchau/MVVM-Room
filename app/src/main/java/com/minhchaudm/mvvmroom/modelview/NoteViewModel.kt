package com.minhchaudm.mvvmroom.modelview

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.minhchaudm.mvvmroom.model.Note
import com.minhchaudm.mvvmroom.remote.repository.NoteRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class NoteViewModel(application: Application):ViewModel() {
     private val noteRepository: NoteRepository = NoteRepository(application)

    fun insertNote(_note: Note)= viewModelScope.launch {
        noteRepository.insertNote(_note)
    }
    fun updateNote(_note: Note)= viewModelScope.launch {
        noteRepository.updateNote(_note)
    }
    fun deleteNote(_note: Note)= viewModelScope.launch {
        noteRepository.deleteNote(_note)
    }
    fun getAllNote(): LiveData<List<Note>> = noteRepository.getAllNote()

    class NoteViewModelFactory(private val application: Application): ViewModelProvider.Factory{
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
           if (modelClass.isAssignableFrom(NoteViewModel::class.java)){
               return NoteViewModel(application) as T
           }
            throw IllegalArgumentException("unable constructor viewModel")
        }

    }
}