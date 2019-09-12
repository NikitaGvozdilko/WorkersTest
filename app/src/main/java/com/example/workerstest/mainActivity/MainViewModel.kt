package com.example.workerstest.mainActivity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.workerstest.database.Repository
import com.example.workerstest.database.RepositoryImpl
import com.example.workerstest.database.models.Worker


class MainViewModel(application: Application) : AndroidViewModel(application){
    private var repository: Repository? = null

    init {
        repository = RepositoryImpl(application)
    }

    fun getWorkers() : LiveData<List<Worker>> {
        return repository?.getWorkers()!!
    }


}