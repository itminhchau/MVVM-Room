package com.minhchaudm.mvvmroom.remote.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.minhchaudm.mvvmroom.model.Note
import com.minhchaudm.mvvmroom.remote.NoteDatabase
import com.minhchaudm.mvvmroom.remote.dao.NoteDao

class NoteRepository(app: Application) {
    private  val noteDao: NoteDao
    init {
        val noteDatabase: NoteDatabase = NoteDatabase.getInstance(app)
        noteDao = noteDatabase.getNoteDao()
    }
    suspend fun insertNote(_note: Note) = noteDao.insertNote(_note)
    suspend fun updateNote (_note: Note) = noteDao.updateNote(_note)
    suspend fun deleteNote (_note: Note)= noteDao.deleteNote(_note)
    fun getAllNote():LiveData<List<Note>> = noteDao.getAll()
}