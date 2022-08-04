package com.example.myreptil.fragmente

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.myreptil.Class.Eintrag
import com.example.myreptil.Class.Tier
import com.example.myreptil.Class.TierartEnum
import com.example.myreptil.R
import com.example.myreptil.data.ViewModel
import com.example.myreptil.databinding.FragmentDetailCardBinding
import java.time.LocalDateTime


class DetailCardFragment : Fragment() {

    private val viewModel : ViewModel by activityViewModels()

    private lateinit var binding: FragmentDetailCardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_card, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivSaveTier.setOnClickListener {


            //TODO input felder Auslesen
            val name = binding.tiName.text.toString()

            // bisher nur beispielwerte (frei eintragbar später)

            //            var newEntry = Eintrag(
            //                datum = LocalDateTime.now().toString(),
            //                eintrag = eintrag,
            //                eintragTyp = eintragTyp
            //            )

            val tier = Tier(
                0, 0, name, TierartEnum.SPINNEN, "", "", "",
                0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, "", "", 0.0,
                0.0, 0, "", 0.0, "", ""
            )



            viewModel.saveTierData(tier)

        }

    }

}