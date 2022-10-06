package com.kismi.basketroom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kismi.basketroom.databinding.StudentItemBinding
import com.kismi.basketroom.room.StudentEntity

//pada bagian ini merupakan adapter dengan nama StudentAdapter

class StudentAdapter(private val listener:OnItemAction) : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding:StudentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: StudentEntity) {
            binding.studentName.text = item.name
            binding.studentKelas.text = item.kelas

            binding.rowStudent.setOnClickListener {
                listener.onItemClick(item)
            }
        }
    }

    private val studentList = ArrayList<StudentEntity>()

    fun setData(items:List<StudentEntity>) {
        studentList.clear()
        studentList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAdapter.ViewHolder {
        val binding = StudentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentAdapter.ViewHolder, position: Int) {
        holder.bind(studentList[position])
    }

    override fun getItemCount(): Int = studentList.size

    interface OnItemAction {
        fun onItemClick(data:StudentEntity)
    }
}