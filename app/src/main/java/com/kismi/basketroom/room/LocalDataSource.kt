package com.kismi.basketroom.room

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// pada bagaian ini membuat class dengan nama LocalDatabaseSource yang digunakan untuk mengakses StudentDao
class LocalDataSource(context:Context) {
    private val appDatabase = AppDatabase.getDatabase(context)
    private val studentDao = appDatabase.studentDao()

//CoroutineScope pada bagian ini digunakan untuk menjalankan Suspend function
    fun getStudents(callback:(List<StudentEntity>) -> Unit) {
        CoroutineScope(Dispatchers.Main).launch {
            callback(studentDao.getAllStudents())
        }
    }
//pada bagian ini digunakan untuk proses menyimpan data
    fun saveStudent(data:StudentEntity) {
        CoroutineScope(Dispatchers.Main).launch {
            studentDao.insertStudent(data)
        }
    }

    //pada bagian ini digunakan untuk proses perubahan data
    fun updateStudent(data:StudentEntity) {
        CoroutineScope(Dispatchers.Main).launch {
            studentDao.updateStudent(data)
        }
    }

    fun deleteStudent(data:StudentEntity) {
        CoroutineScope(Dispatchers.Main).launch {
            studentDao.deleteStudent(data)
        }
    }

}