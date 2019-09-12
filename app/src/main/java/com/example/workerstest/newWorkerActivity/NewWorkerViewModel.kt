package com.example.workerstest.newWorkerActivity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.workerstest.database.Repository
import com.example.workerstest.database.RepositoryImpl
import com.example.workerstest.database.models.Worker


class NewWorkerViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: Repository? = null

    init {
        repository = RepositoryImpl(getApplication())
    }

    fun addWorker(worker: Worker) {
        repository?.addWorker(worker)
    }

}