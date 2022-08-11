package com.example.myreptil.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.myreptil.R
import com.example.myreptil.data.datamodels.Gruppe
import com.example.myreptil.data.datamodels.Tier
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

        viewModel.tierList.observe(viewLifecycleOwner) { liste ->
            binding.IBgruppenSave.setOnClickListener {

                var tierNamen = mutableListOf<String>()
                var selected = mutableListOf<Boolean>()

                for (tier in liste) {
                    tierNamen.add(tier.Name)
                    selected.add(false)
                }

                MaterialAlertDialogBuilder(requireContext())
                    .setMultiChoiceItems(
                        tierNamen.toTypedArray(),
                        selected.toBooleanArray()
                    ) { _, which, checked -> selected[which] = checked }
                    .setTitle("Tier Auswahl")
                    .setPositiveButton("Speichern") { _, _ ->

                        var gruppenTierListe = mutableListOf<Tier>()

                        for (i in selected.indices) {
                            if (selected[i]) {
                                gruppenTierListe.add(liste[i])
                            }
                        }

                        var gruppe = Gruppe(
                            Name = binding.gruppenNameSave.text.toString(),
                            tiereInGruppe = gruppenTierListe
                        )


                        viewModel.saveGruppeData(
                            gruppe
                        )
                        findNavController().navigate(gruppeSaveDirections.actionGruppeSaveToFragmentGruppenTiere(gruppe.id))
                    }
                    .show()

            }

        }

    }

}