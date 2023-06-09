package com.example.elearningquizapplication.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "grades")
data class Grades (

    @ColumnInfo
    val name: String,

    @ColumnInfo
    val geo: Int,

    @ColumnInfo
    val phys: Int,

    @ColumnInfo
    val pro: Int,

    @ColumnInfo
    val total: Int,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
): Parcelable