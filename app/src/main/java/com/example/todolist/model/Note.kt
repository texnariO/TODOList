package com.example.todolist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.activeandroid.annotation.Column

@Entity
class Note(
    @ColumnInfo var name: String,
    @ColumnInfo var category: String,
    @ColumnInfo var date: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}