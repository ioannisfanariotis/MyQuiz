package com.example.elearningquizapplication.repository

import com.example.elearningquizapplication.database.AppDao
import com.example.elearningquizapplication.models.Grades
import kotlinx.coroutines.flow.Flow

class GradesRepo(private val dao: AppDao) {

    suspend fun insertGrades(grades: Grades){
        dao.insertGrades(grades)
    }

    val fetchAllGrades: Flow<List<Grades>> = dao.fetchAllGrades()

    suspend fun deleteGrades(grades: Grades){
        dao.deleteGrades(grades)
    }
}