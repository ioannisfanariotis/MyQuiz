package com.example.elearningquizapplication.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.elearningquizapplication.R
import com.example.elearningquizapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private var name = " "

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreate(savedInstanceState)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews()
    }

    private fun setViews() {
        binding.startBtn.setOnClickListener {
            if(binding.nameTxt.text?.isEmpty() == true)
                Toast.makeText(requireActivity(), getString(R.string.please_enter_your_name), Toast.LENGTH_SHORT).show()
            else {
                Toast.makeText(requireActivity(), getString(R.string.first), Toast.LENGTH_SHORT).show()
                name = binding.nameTxt.text.toString().trim()
                binding.nameTxt.setText("")
                goToGeographyFragment()
            }
        }
    }

    private fun goToGeographyFragment() {
        val bundle = Bundle()
        bundle.putString("name", name)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_HomeFragment_to_GeographyFragment, bundle)
    }
}