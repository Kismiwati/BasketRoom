package com.kismi.basketroom

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kismi.basketroom.room.LocalDataSource
import com.kismi.basketroom.room.StudentEntity

// pada bagian ini adalah class view model untuk MainActivity dengan nama class MainViewModel
//dibagian ini terdapat function yang digunakan untuk mendapatkan data dari database
class MainViewModel : ViewModel() {
    val students = MutableLiveData<List<StudentEntity>>()

    fun getStudent(context: Context) {
        val localDataSource = LocalDataSource(context)
        localDataSource.getStudents { result ->
            students.postValue(result)
        }
    }
}