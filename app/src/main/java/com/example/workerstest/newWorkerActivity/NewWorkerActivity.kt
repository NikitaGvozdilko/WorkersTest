package com.example.workerstest.newWorkerActivity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.workerstest.R
import com.example.workerstest.database.models.Worker
import com.example.workerstest.utils.Sex
import kotlinx.android.synthetic.main.activity_new_worker.*

class NewWorkerActivity : AppCompatActivity() {
    private var viewModel: NewWorkerViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_worker)
        viewModel = ViewModelProviders.of(this).get(NewWorkerViewModel::class.java)
        buttonSave.setOnClickListener {
            if (validateData()) {
                val sex = if (radioFemale.isChecked) Sex.FEMALE
                else Sex.MALE
                    viewModel?.addWorker(Worker(editName.text.toString(),
                            Integer.parseInt(editAge.text.toString()),
                            editPhoneNumber.text.toString(),
                            sex))
                finish()
            }
        }
    }

    private fun validateData(): Boolean {
        var isValid = true
        if (editName.text!!.isEmpty()) {
            editName.error = "Enter the name"
            isValid = false
        }
        if (editAge.text!!.isEmpty()) {
            editAge.error = "Enter the age"
            isValid = false
        }
        if (editAge.text!!.isNotEmpty() && Integer.parseInt(editAge.text.toString()) > 110) {
            editAge.error = "Too big age"
            isValid = false
        }
        if (editPhoneNumber.text!!.isEmpty()) {
            editPhoneNumber.error = "Enter the phone number"
            isValid = false
        }
        if (!radioMale.isChecked && !radioFemale.isChecked) {
            Toast.makeText(this, "Select sex", Toast.LENGTH_SHORT).show()
            isValid = false
        }
        return isValid
    }
}
