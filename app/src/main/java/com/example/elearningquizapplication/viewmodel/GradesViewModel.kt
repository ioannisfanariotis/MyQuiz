package com.example.elearningquizapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.elearningquizapplication.models.Grades
import com.example.elearningquizapplication.repository.GradesRepo
import kotlinx.coroutines.launch

class GradesViewModel(private val gradesRepo: GradesRepo): ViewModel() {

    fun insertGrades(grades: Grades) = viewModelScope.launch {
        gradesRepo.insertGrades(grades)
    }

    val fetchAllGrades: LiveData<List<Grades>> = gradesRepo.fetchAllGrades.asLiveData()

    fun deleteGrades(grades: Grades) = viewModelScope.launch {
        gradesRepo.deleteGrades(grades)
    }
}

class ViewModelFactory(private val gradesRepo: GradesRepo): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GradesViewModel::class.java))
            @Suppress("UNCHECKED_CAST")
            return GradesViewModel(gradesRepo) as T
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}