package com.example.elearningquizapplication.views.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.elearningquizapplication.R
import com.example.elearningquizapplication.databinding.FragmentGeographyBinding
import com.example.elearningquizapplication.utils.Constants
import com.example.elearningquizapplication.utils.Geography

class GeographyFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentGeographyBinding
    private var name = " "
    private var correctGeo: Int = 0
    private var currentPos: Int = 1
    private var selected: Int = 0
    private lateinit var geoQuestions: Geography
    private lateinit var geoList: ArrayList<Geography>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreate(savedInstanceState)
        binding = FragmentGeographyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name = arguments?.getString("name") ?: ""

        binding.option1.setOnClickListener(this)
        binding.option2.setOnClickListener(this)
        binding.option3.setOnClickListener(this)
        binding.option4.setOnClickListener(this)
        binding.submitBtn.setOnClickListener(this)

        geoList = Constants.getGeography()
        setQuestion()
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        defaultOption()
        geoQuestions = geoList[currentPos - 1]
        binding.progressBar.progress = currentPos
        binding.progressPercent.text = "${currentPos}/${binding.progressBar.max}"
        binding.flags.setImageResource(geoQuestions.image)
        binding.option1.text = geoQuestions.option1
        binding.option2.text = geoQuestions.option2
        binding.option3.text = geoQuestions.option3
        binding.option4.text = geoQuestions.option4
        binding.submitBtn.text = resources.getString(R.string.submit)
    }

    private fun defaultOption() {
        val options = ArrayList<TextView>()
        binding.option1.let { options.add(0, it) }
        binding.option2.let { options.add(1, it) }
        binding.option3.let { options.add(2, it) }
        binding.option4.let { options.add(3, it) }

        for(i in options) {
            i.setTextColor(Color.parseColor("#7A8089"))
            i.typeface = Typeface.DEFAULT
            i.background = ContextCompat.getDrawable(requireContext(), R.drawable.default_option)
        }
    }

    private fun selectedOption(tv: TextView, optionNum: Int) {
        defaultOption()
        selected = optionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(requireContext(), R.drawable.selected_option)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.option1 -> { selectedOption(binding.option1, 1) }
            R.id.option2 -> { selectedOption(binding.option2, 2) }
            R.id.option3 -> { selectedOption(binding.option3, 3) }
            R.id.option4 -> { selectedOption(binding.option4, 4) }
            R.id.submitBtn -> {
                if(selected==0) {
                    currentPos++
                    when {
                        currentPos <= geoList.size -> {
                            setQuestion()
                        }
                        else -> {
                            Toast.makeText(requireActivity(), getString(R.string.next), Toast.LENGTH_SHORT).show()
                            currentPos = 1
                            binding.progressBar.progress = currentPos
                            goToPhysicsFragment()
                        }
                    }
                } else {
                    val question = geoList[currentPos-1]
                    if(question.correct != selected)
                        answerView(selected, R.drawable.wrong_option)
                    else
                        correctGeo++
                    answerView(question.correct, R.drawable.correct_option)
                    if(currentPos == geoList.size)
                        binding.submitBtn.text = resources.getString(R.string.finish)
                    else
                        binding.submitBtn.text = resources.getString(R.string.next_question)
                    selected = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when(answer) {
            1 -> binding.option1.background = ContextCompat.getDrawable(requireContext(), drawableView)
            2 -> binding.option2.background = ContextCompat.getDrawable(requireContext(), drawableView)
            3 -> binding.option3.background = ContextCompat.getDrawable(requireContext(), drawableView)
            4 -> binding.option4.background = ContextCompat.getDrawable(requireContext(), drawableView)
        }
    }

    private fun goToPhysicsFragment() {
        val bundle = Bundle()
        bundle.putString("name", name)
        bundle.putInt("correctGeo", correctGeo)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_GeographyFragment_to_PhysicsFragment, bundle)
    }
}