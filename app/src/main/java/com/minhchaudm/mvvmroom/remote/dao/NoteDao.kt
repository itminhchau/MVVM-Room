package com.minhchaudm.mvvmroom.remote.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.minhchaudm.mvvmroom.model.Note

@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote(note: Note)
    @Update
    suspend fun updateNote(note: Note)
    @Delete
    suspend fun deleteNote(note: Note)
    @Query("Select *from Note_App")
    fun getAll():LiveData<List<Note>>
}