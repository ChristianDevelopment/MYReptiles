package com.example.myreptil.fragmente

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myreptil.R
import com.example.myreptil.databinding.FragmentFirstBinding

class ArztBesuchFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_arzt_besuch,container,false)

        return binding.root
    }
}