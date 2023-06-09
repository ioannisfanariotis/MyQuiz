package com.example.elearningquizapplication.views.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.elearningquizapplication.App
import com.example.elearningquizapplication.R
import com.example.elearningquizapplication.databinding.FragmentResultBinding
import com.example.elearningquizapplication.models.Grades
import com.example.elearningquizapplication.viewmodel.GradesViewModel
import com.example.elearningquizapplication.viewmodel.ViewModelFactory

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    private val viewModel: GradesViewModel by viewModels { ViewModelFactory((requireActivity().application as App).gradesRepo) }
    private var name = " "
    private var correctGeo: Int = 0
    private var percentGeo: Double = 0.0
    private var correctPhys: Int = 0
    private var percentPhys: Double = 0.0
    private var correctPro: Int = 0
    private var percentPro: Double = 0.0
    private var totalCorrects: Int = 0
    private var totalPercent: Double = 0.0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreate(savedInstanceState)
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name = arguments?.getString("name") ?: ""
        correctGeo = arguments?.getInt("correctGeo") ?: 0
        correctPhys = arguments?.getInt("correctPhys") ?: 0
        correctPro = arguments?.getInt("correctPro") ?: 0
        setViews()
    }

    @SuppressLint("SetTextI18n")
    private fun setViews() {
        percentGeo = (10 * correctGeo).toDouble()
        binding.geography.text = resources.getString(R.string.geo_score) + " " + correctGeo + " " +
                resources.getString(R.string.out_of_10) + " " + resources.getString(R.string.percentage) + " " + percentGeo + "%"

        percentPhys = (10 * correctPhys).toDouble()
        binding.physics.text = resources.getString(R.string.phys_score) + " " + correctPhys + " " +
                resources.getString(R.string.out_of_10) + " " + resources.getString(R.string.percentage) + " " + percentPhys + "%"

        percentPro = (10 * correctPro).toDouble()
        binding.programming.text = resources.getString(R.string.pro_score) + " " + correctPro + " " +
                resources.getString(R.string.out_of_10) + " " + resources.getString(R.string.percentage) + " " + percentPro + "%"

        totalCorrects = correctGeo + correctPhys + correctPro
        totalPercent = (10 * totalCorrects / 3).toDouble()
        binding.total.text = resources.getString(R.string.total_score) + " " + totalCorrects + " " +
                resources.getString(R.string.out_of_30) + " " + resources.getString(R.string.percentage) + " " + totalPercent + "%"

        if ((correctGeo >= 8 && correctPhys >= 8 && correctPro >= 8) || totalCorrects >= 25)
            binding.description.text = resources.getString(R.string.congratulations) + " " + name + "!"
        else if ((correctGeo >= 5 && correctPhys >= 5 && correctPro >= 5) || totalCorrects >= 17)
            binding.description.text = resources.getString(R.string.bravo) + " " + name + "!"
        else if ((correctGeo >= 3 && correctPhys >= 3 && correctPro >= 3) || totalCorrects >= 11)
            binding.description.text = resources.getString(R.string.well_done) + " " + name + "!"
        else
            binding.description.text = resources.getString(R.string.next_time) + " " + name + "!"

        val grades = Grades(name, correctGeo, correctPhys, correctPro, totalCorrects)
        viewModel.insertGrades(grades)

        binding.finishBtn.setOnClickListener{
            goToHomeFragment()
        }
    }

    private fun goToHomeFragment() {
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_ResultFragment_to_HomeFragment)
    }
}