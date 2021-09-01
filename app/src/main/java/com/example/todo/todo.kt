package com.example.todo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "list")
class todo(@ColumnInfo(name="message")val text:String) {
    @PrimaryKey(autoGenerate = true) var id = 0
}