package com.example.todolist.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DaoNote {

    @Query("SELECT * FROM note_table")
    fun getAllNotes(): List<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note)

    @Query("DELETE FROM note_table")
    fun deleteAll()

    @Query("SELECT COUNT(*) FROM note_table")
    fun size(): Int
}