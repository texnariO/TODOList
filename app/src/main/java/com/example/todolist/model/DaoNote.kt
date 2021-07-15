package com.example.todolist.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DaoNote {

    @get:Query("SELECT * FROM Note")
    val allNoteItem: List<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNote(note: Note)

    @Query("SELECT COUNT(*) FROM Note")
    fun size(): Int
}