package com.kismi.basketroom.room

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

//membuat class entity yang digunakan untuk mengirimkan data antar activity
//struktur table pada database ini  dengan nama table tb_student
//table terdiri dari 3 kolom yaitu id, name dan kelas.
//id dengan tipe data int, name dengan tipe data string dan kelas dengan tipe data string
@Entity(tableName="tb_student")
@Parcelize
data class StudentEntity(
    @PrimaryKey(autoGenerate=true)
    val id:Int = 0,
    val name:String,
    val kelas:String
) : Parcelable