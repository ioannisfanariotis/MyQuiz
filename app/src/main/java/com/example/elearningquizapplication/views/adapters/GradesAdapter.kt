package com.example.elearningquizapplication.views.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.elearningquizapplication.databinding.RecyclerViewGradesBinding
import com.example.elearningquizapplication.models.Grades
import com.example.elearningquizapplication.views.fragments.GradesFragment

class GradesAdapter (private val fragment: Fragment): RecyclerView.Adapter<GradesAdapter.ViewHolder>() {

    private var grades: List<Grades> = listOf()

    class ViewHolder(binding: RecyclerViewGradesBinding) : RecyclerView.ViewHolder(binding.root) {
        val name = binding.name
        val geo = binding.geoGrade
        val phys = binding.physGrade
        val pro = binding.proGrade
        val total = binding.totalGrade
        val delete = binding.layout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecyclerViewGradesBinding.inflate(LayoutInflater.from(fragment.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gr = grades[position]
        holder.name.text = gr.name
        holder.geo.text = gr.geo.toString()
        holder.phys.text = gr.phys.toString()
        holder.pro.text = gr.pro.toString()
        holder.total.text = gr.total.toString()
        holder.delete.setOnClickListener{
            if (fragment is GradesFragment)
                fragment.deleteGrades(gr)
        }
    }

    override fun getItemCount(): Int {
        return grades.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun gradesList(list: List<Grades>){
        grades = list
        notifyDataSetChanged()
    }
}