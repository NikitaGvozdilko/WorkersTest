package com.example.workerstest.database

import androidx.lifecycle.LiveData
import com.example.workerstest.database.models.Worker

interface Repository {
    fun getWorkers(): LiveData<List<Worker>>
    fun addWorker(worker: Worker)
}