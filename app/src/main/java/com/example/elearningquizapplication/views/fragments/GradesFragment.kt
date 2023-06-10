package com.example.elearningquizapplication.views.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.elearningquizapplication.App
import com.example.elearningquizapplication.R
import com.example.elearningquizapplication.databinding.FragmentGradesBinding
import com.example.elearningquizapplication.models.Grades
import com.example.elearningquizapplication.viewmodel.GradesViewModel
import com.example.elearningquizapplication.viewmodel.ViewModelFactory
import com.example.elearningquizapplication.views.adapters.GradesAdapter

class GradesFragment : Fragment() {
    private lateinit var binding: FragmentGradesBinding
    private val viewModel: GradesViewModel by viewModels { ViewModelFactory((requireActivity().application as App).gradesRepo) }
    private lateinit var adapter: GradesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreate(savedInstanceState)
        binding = FragmentGradesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews()
        observeVM()
    }

    private fun setViews() {
        binding.gradesList.layoutManager = LinearLayoutManager(requireActivity())
        adapter = GradesAdapter(this@GradesFragment)
        binding.gradesList.adapter = adapter
    }

    private fun observeVM() {
        viewModel.fetchAllGrades.observe(viewLifecycleOwner) {
                grades ->
                    grades?.let {
                        if(it.isNotEmpty()) {
                            binding.gradesList.visibility = View.VISIBLE
                            binding.noGrades.visibility = View.GONE
                            adapter.gradesList(it)
                        } else {
                            binding.gradesList.visibility = View.GONE
                            binding.noGrades.visibility = View.VISIBLE
                        }
                    }
        }
    }

    fun deleteGrades(grades: Grades) {
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle(resources.getString(R.string.delete_grades))
        builder.setMessage(resources.getString(R.string.sure))
        builder.setIcon(android.R.drawable.ic_dialog_alert)
        builder.setPositiveButton(resources.getString(R.string.yes)){
                dialogInterface, _ ->
            viewModel.deleteGrades(grades)
            dialogInterface.dismiss()
        }
        builder.setNegativeButton(resources.getString(R.string.no)){
                dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        val dialog: AlertDialog = builder.create()
        dialog.setCancelable(false)
        dialog.show()
    }
}