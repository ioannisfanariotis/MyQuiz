package com.example.elearningquizapplication

import android.app.Application
import com.example.elearningquizapplication.database.AppDatabase
import com.example.elearningquizapplication.repository.GradesRepo

class App : Application() {
    private val db by lazy { AppDatabase.getInstance(this@App) }

    val gradesRepo by lazy { GradesRepo(db.dao()) }
}