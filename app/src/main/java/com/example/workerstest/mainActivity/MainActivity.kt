package com.example.workerstest.mainActivity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workerstest.R
import com.example.workerstest.adapters.WorkersAdapter
import com.example.workerstest.database.models.Worker
import com.example.workerstest.newWorkerActivity.NewWorkerActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var viewModel: MainViewModel? = null
    private var adapter: WorkersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        adapter = WorkersAdapter()
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)
        viewModel?.getWorkers()?.observe(this, object: Observer<List<Worker>> {
            override fun onChanged(list: List<Worker>?) {
                if (list != null) adapter?.update(list)
            }
        })

        imageAdd.setOnClickListener {
            val intent = Intent(this, NewWorkerActivity::class.java)
            startActivity(intent)
        }
    }
}
