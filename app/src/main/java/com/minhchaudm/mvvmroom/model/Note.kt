package com.minhchaudm.mvvmroom.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Note_App")
class Note(
    @ColumnInfo(name = "title_col")var title: String = "",
    @ColumnInfo(name = "description_col") var description: String = "")
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_col")
    var id: Int = 0
}