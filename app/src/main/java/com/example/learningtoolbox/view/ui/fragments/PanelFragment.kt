package com.example.learningtoolbox.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.learningtoolbox.databinding.FragmentPanelBinding
import com.example.learningtoolbox.view.viewmodel.PanelViewModel

class PanelFragment : Fragment() {

    private lateinit var panelViewModel: PanelViewModel
    private var _binding: FragmentPanelBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        panelViewModel =
            ViewModelProvider(this).get(PanelViewModel::class.java)

        _binding = FragmentPanelBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.category
        panelViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}