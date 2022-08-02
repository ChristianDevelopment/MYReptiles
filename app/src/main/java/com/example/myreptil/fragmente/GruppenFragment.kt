package com.example.myreptil.fragmente

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myreptil.Class.TierartEnum
import com.example.myreptil.R
import com.example.myreptil.adapter.ItemAdapter
import com.example.myreptil.databinding.FragmentGruppenBinding

/**
 * A simple [Fragment] subclass.
 * Use the [GruppenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class GruppenFragment : Fragment() {

    private lateinit var binding: FragmentGruppenBinding


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

//        val daten = DataSource().loadData()
//        binding.rvRvLayout.adapter = ItemAdapter(requireContext(), daten) { partItem: TierartEnum ->
//            findNavController().navigate(GruppenFragmentDirections.actionGruppenFragmentToFragmentGruppenTiere())
//
//        }
//        binding.MTiere.setOnClickListener {
//
//            findNavController().navigate(GruppenFragmentDirections.actionGruppenFragmentToFragmentTiere())
//        }

    }
}



