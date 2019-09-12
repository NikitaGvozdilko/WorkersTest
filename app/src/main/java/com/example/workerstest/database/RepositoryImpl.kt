package com.example.workerstest.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.workerstest.database.models.Worker

class RepositoryImpl: Repository {
    private val workersDb: WorkersDb

    constructor(context: Context) {
        workersDb = WorkersDb(context)
    }


    override fun getWorkers(): LiveData<List<Worker>> {
        return workersDb.getWorkers()
    }

    override fun addWorker(worker: Worker) {
        workersDb.addWorker(worker)
    }
}