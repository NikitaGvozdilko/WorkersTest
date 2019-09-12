package com.example.workerstest.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.workerstest.database.dao.WorkersDao
import com.example.workerstest.database.models.Worker

@Database(entities = [Worker::class], version = 1)
abstract class WorkersDb : RoomDatabase() {
    abstract fun workersDao() : WorkersDao

    companion object {
        @Volatile private var instance: WorkersDb? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            WorkersDb::class.java, "bws_coworkers.db")
            .allowMainThreadQueries()
            .build()
    }

    fun getWorkers(): LiveData<List<Worker>> {
        return workersDao().getWorkers()
    }

    fun addWorker(worker: Worker) {
        workersDao().addWorker(worker)
    }
}