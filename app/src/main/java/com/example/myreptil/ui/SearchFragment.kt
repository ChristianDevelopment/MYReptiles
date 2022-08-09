package com.example.myreptil.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.myreptil.adapter.ItemAdapterTier
import com.example.myreptil.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    private val viewModel: ViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

        binding = FragmentSearchBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sucheButton.setOnClickListener {

            binding.sucheConstraint.visibility = View.INVISIBLE
            viewModel.tierList.observe(viewLifecycleOwner) {

                var list = viewModel.search(binding.sucheText.text.toString())
                var itemAdapter = ItemAdapterTier(list, true)
                binding.rvRvLayout.adapter = itemAdapter
            }
        }

    }

}