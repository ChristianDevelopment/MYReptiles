package com.example.myreptil.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.myreptil.R
import com.example.myreptil.adapter.ItemAdapterGruppe
import com.example.myreptil.databinding.FragmentGruppenBinding


class GruppenFragment : Fragment() {

    private lateinit var binding: FragmentGruppenBinding
    private val viewModel : ViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_gruppen, container, false)

        // Inflate the layout for this fragment

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.gruppenList.observe(viewLifecycleOwner){

            binding.rvRvLayout.adapter = ItemAdapterGruppe(it)

        }


        // OnklickListener für die navigation vom GruppenFragment zum Gruppen Tiere Fragment
        binding.MTiere.setOnClickListener {

            findNavController().navigate(GruppenFragmentDirections.actionGruppenFragmentToFragmentTiere())
        }

    }
}



