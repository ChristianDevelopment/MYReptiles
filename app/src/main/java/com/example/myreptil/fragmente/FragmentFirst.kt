package com.example.myreptil.fragmente

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myreptil.R
import androidx.navigation.fragment.findNavController
import com.example.myreptil.databinding.FragmentFirstBinding


class FragmentFirst : Fragment(R.layout.fragment_first) {


    private lateinit var binding: FragmentFirstBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater)


        val add_picture = binding.firstPicture

        add_picture.setOnClickListener {
            findNavController().navigate(FragmentFirstDirections.actionFragmentFirst2ToDetailCardFragment2())
        }
        return binding.root
    }
}