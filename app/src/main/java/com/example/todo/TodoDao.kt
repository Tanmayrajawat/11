package com.example.todo

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: todo)

    @Delete
    suspend fun delete(note: todo)

    @Query("Select *  from list order by id ASC")
    fun getAllTodo(): LiveData<List<todo>>
}