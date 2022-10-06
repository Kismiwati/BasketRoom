package com.kismi.basketroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kismi.basketroom.databinding.ActivityMainBinding
import com.kismi.basketroom.room.StudentEntity

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var studentAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        studentAdapter = StudentAdapter(object : StudentAdapter.OnItemAction {
            override fun onItemClick(data: StudentEntity) {
                val intent = Intent(this@MainActivity, AddStudentActivity::class.java)
                intent.putExtra(AddStudentActivity.STUDENT_EXTRA, data)
                startActivityForResult(intent, 100)
            }
        })
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.rvStudent.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = studentAdapter
        }

        // pada bagian ini digunakan untuk mengamati data dari variabel pada MainViewModel yang kemudian memasang data ke adapter
        viewModel.students.observe(this, {
            studentAdapter.setData(it)
        })

        viewModel.getStudent(this)

        binding.btnAddStudent.setOnClickListener {
            goToAddStudent()
        }
    }

    private fun goToAddStudent() {
        val intent = Intent(this, AddStudentActivity::class.java)
        startActivityForResult(intent, 100)
    }

    //pada bagian ini onActivityResult digunakan untuk mendapatkan data dari database setelah terjadi proses/perubahan pada database
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100) {
            viewModel.getStudent(this)
        }
    }
}