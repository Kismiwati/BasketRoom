package com.kismi.basketroom

import android.content.Context
import androidx.lifecycle.ViewModel
import com.kismi.basketroom.room.LocalDataSource
import com.kismi.basketroom.room.StudentEntity

class AddStudentViewModel : ViewModel() {
    //pada bagaian ini digunakan untuk proses menambah data
    // tipe data nama dan kelas dengan tipe data string
    fun addStudent(context: Context, nama:String, kelas:String, onSuccess:(Boolean) -> Unit) {
        val localDataSource = LocalDataSource(context)
        localDataSource.saveStudent(StudentEntity(0, nama, kelas))
        onSuccess(true)
    }

    //pada bagian ini digunakan untuk proses perubahan data
    //untuk id dengan tipe data integer
    //untuk nama dan kelas dengan tipe data string
    //untuk tipe data onSucces menggunakan tipe data Boolean
    fun updateStudent(context: Context, id:Int, nama:String, kelas:String, onSuccess: (Boolean) -> Unit) {
        val localDataSource = LocalDataSource(context)
        localDataSource.updateStudent(StudentEntity(id, nama, kelas))
        onSuccess(true)
    }

    //pada bagain ini digunakan untuk proses penghapusan data
    //data yang dihapus yaitu data dari room class studentEntity
    fun deleteStudent(context: Context, data:StudentEntity, onSuccess: (Boolean) -> Unit) {
        val localDataSource = LocalDataSource(context)
        localDataSource.deleteStudent(data)
        onSuccess(true)
    }

}