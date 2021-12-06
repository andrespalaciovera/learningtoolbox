package com.example.learningtoolbox.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.learningtoolbox.databinding.FragmentTopBinding
import com.example.learningtoolbox.view.viewmodel.TopViewModel

class TopFragment : Fragment() {

    private lateinit var topViewModel: TopViewModel
    private var _binding: FragmentTopBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        topViewModel =
            ViewModelProvider(this)[TopViewModel::class.java]

        _binding = FragmentTopBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        topViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}