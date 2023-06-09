package com.example.elearningquizapplication.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.elearningquizapplication.models.Grades
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {
    @Insert
    suspend fun insertGrades(grades: Grades)

    @Query("SELECT * FROM `grades`")
    fun fetchAllGrades(): Flow<List<Grades>>

    @Delete
    suspend fun deleteGrades(grades: Grades)
}