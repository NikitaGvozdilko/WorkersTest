package com.example.workerstest.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.workerstest.database.models.Worker

@Dao
interface WorkersDao {
    @Query("SELECT * FROM bws_coworkers")
    fun getWorkers(): LiveData<List<Worker>>

    @Insert
    fun addWorker(worker: Worker)
}