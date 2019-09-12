package com.example.workerstest.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.workerstest.R
import com.example.workerstest.database.models.Worker
import com.example.workerstest.utils.Sex

class WorkersAdapter : RecyclerView.Adapter<WorkersAdapter.ViewHolder>() {
    private var list: List<Worker>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_worker, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (list == null) return
        val worker = list!![position]
        holder.apply {
            textName?.text = worker.name
            textAge?.text = worker.age.toString()
            textPhoneNumber?.text = worker.phoneNumber
            textSex?.text = when (worker.sex) {
                Sex.MALE -> "Male"
                Sex.FEMALE -> "Female"
                else -> ""
            }
        }
    }

    fun update(list: List<Worker>) {
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textName: TextView? = null
        var textAge: TextView? = null
        var textPhoneNumber: TextView? = null
        var textSex: TextView? = null

        init {
            textName = itemView.findViewById(R.id.textName)
            textAge = itemView.findViewById(R.id.textAge)
            textPhoneNumber = itemView.findViewById(R.id.textPhoneNumber)
            textSex = itemView.findViewById(R.id.textSex)
        }
    }
}