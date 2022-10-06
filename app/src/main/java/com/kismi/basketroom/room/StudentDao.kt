package com.kismi.basketroom.room

import androidx.room.*

//pada bagian ini menggunakan suspend function yang digunakan untuk melakukan proses asyncronus database
@Dao
interface StudentDao {
    @Query("SELECT * FROM tb_student")
    //bagian ini untuk proses mendapatkan data
    suspend fun getAllStudents() : List<StudentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //bagian ini digunakan untuk proses menambah data
    suspend fun insertStudent(data:StudentEntity)

    @Update
    //bagian ini digunakan untuk proses merubah data
    suspend fun updateStudent(data:StudentEntity)

    @Delete
    //bagian ini digunakan untuk proses menghapus data
    suspend fun deleteStudent(data:StudentEntity)
}