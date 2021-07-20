package com.example.todolist.model

import android.content.Context
import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [Note::class], version = 1)
abstract class DataBase : RoomDatabase() {

    abstract fun DaoNote():DaoNote

    companion object{
        @Volatile
        private var INSTANCE: DataBase? = null

        fun getDatabase(context: Context): DataBase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                "note_table"
                ).build()
                INSTANCE = instance
                instance
            }
        }
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}