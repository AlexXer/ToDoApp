package com.alexxer.todoapp.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
@Entity(tableName = "task_table")
@Parcelize
data class Task(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var title:String,
    var description:String,
    var priority: Priority
):Parcelable