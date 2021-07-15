package com.example.todolist.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [Note::class], version = 1)
abstract class DataBase : RoomDatabase() {

    abstract fun DaoNote():DaoNote

    companion object{
        private var INSTANCE: DataBase? = null

        fun getDatabase(context: Context): DataBase?{
            if(INSTANCE==null)
                INSTANCE = Room.databaseBuilder(context,DataBase::class.java,"note_db").build()

            return INSTANCE
        }
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}