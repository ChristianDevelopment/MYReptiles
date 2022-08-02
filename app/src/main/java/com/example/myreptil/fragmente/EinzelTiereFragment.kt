package com.example.myreptil.fragmente

import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.myreptil.R
import com.example.myreptil.adapter.TierAdapter
import com.example.myreptil.data.ViewModel
import com.example.myreptil.databinding.FragmentTiereBinding

class Fragment_Tiere : Fragment() {
    private lateinit var binding: FragmentTiereBinding

    private val viewModel:ViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tiere, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.tierList.observe(viewLifecycleOwner){
            binding.rvRvLayout.adapter = TierAdapter(it)

        }

        binding.MGruppe.setOnClickListener {

            findNavController().navigate(Fragment_TiereDirections.actionFragmentTiereToGruppenFragment())
        }
    }

}
