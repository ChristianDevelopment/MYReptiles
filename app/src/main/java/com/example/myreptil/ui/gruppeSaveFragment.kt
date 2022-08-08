package com.example.myreptil.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.myreptil.R
import com.example.myreptil.databinding.FragmentGruppeSaveBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class gruppeSave : Fragment() {

    private lateinit var binding: FragmentGruppeSaveBinding

    private val viewModel: ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGruppeSaveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.tierList.observe(viewLifecycleOwner){ liste->
            binding.IBgruppenSave.setOnClickListener{

                var tierNamen = mutableListOf<String>()
                var selected = mutableListOf<Boolean>()

                for (tier in liste){
                    tierNamen.add(tier.Name)
                    selected.add(false)
                }

                MaterialAlertDialogBuilder(requireContext())
                    .setMultiChoiceItems(tierNamen.toTypedArray(),selected.toBooleanArray()){
                        _,_,_,-> }
                    .setTitle("Tier Auswahl")

                    .show()

            }

        }

    }

}