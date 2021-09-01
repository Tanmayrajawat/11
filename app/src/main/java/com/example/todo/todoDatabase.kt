package com.example.todo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(todo::class), version = 1, exportSchema = false)
abstract class todoDatabase : RoomDatabase() {

    abstract fun gettodoDao(): TodoDao

    companion object {

        @Volatile
        private var INSTANCE: todoDatabase? = null

        fun getDatabase(context: Context): todoDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this)  {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    todoDatabase::class.java,
                    
                    "todo database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }


}