package com.example.workerstest.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bws_coworkers")
data class Worker(
        var name: String,
        var age: Int,
        var phoneNumber: String,
        var sex: Int) {
        @PrimaryKey(autoGenerate = true)
        var id: Int? = null
}