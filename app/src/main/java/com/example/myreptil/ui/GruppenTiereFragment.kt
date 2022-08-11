package com.example.myreptil.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.myreptil.R
import com.example.myreptil.adapter.ItemAdapterTier
import com.example.myreptil.databinding.FragmentGruppenTiereBinding
import com.example.myreptil.databinding.FragmentShowDetailCardBinding

class GruppenTiereFragment : Fragment() {


    private val viewModel: ViewModel by activityViewModels()

    private lateinit var binding: FragmentGruppenTiereBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { binding = FragmentGruppenTiereBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val gruppenId = requireArguments().getLong("gruppenId")

        viewModel.gruppenList.observe(viewLifecycleOwner){ liste ->

            Log.d("TESTTEST","id: $id, gruppenListe größe ${liste.size}")
            val gruppe = liste.find { it.id == gruppenId }


            val navigate: (Long) -> Unit = {id -> findNavController().navigate(GruppenTiereFragmentDirections.actionFragmentGruppenTiereToShowDetailCardFragment(id))}


            binding.rvRvLayout.adapter = ItemAdapterTier(gruppe!!.tiereInGruppe,navigate)

        }


    }


}
