package com.example.myreptil.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.myreptil.R
import com.example.myreptil.data.datamodels.TierartEnum
import com.example.myreptil.databinding.FragmentShowDetailCardBinding


class ShowDetailCardFragment : Fragment() {

    private val viewModel: ViewModel by activityViewModels()

    private lateinit var binding: FragmentShowDetailCardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShowDetailCardBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var tierId = requireArguments().getLong("tierId")

        var tier = viewModel.tierList.value!!.find { it.id == tierId }


        if (tier != null) {
            binding.tiName.setText(tier.Name)
            binding.tiTierart.setText(tier.Tierart.toString())
            binding.tiDeuName.setText(tier.DeutscherName)
            binding.tiLatName.setText(tier.LateinischerName)
            binding.tiAlter.setText(tier.Alter.toString())
            binding.tiGeschlecht.setText(tier.Geschlecht.toString())
            binding.tiGewicht.setText(tier.Gewicht.toString())
            binding.tiGroesse.setText(tier.Groesse.toString())
            binding.tiGeboren.setText(tier.Geboren.toString())
            binding.tiErworben.setText(tier.Erworben.toString())
            binding.tiVerstorben.setText(tier.Verstorben.toString())
            binding.tiZucht.setText(tier.Zuchtlinie)
            binding.tiGeneration.setText(tier.Generation)
            binding.tiLetHaeutung.setText(tier.LetzteHaeutung.toString())
            binding.tiLetFuetterung.setText(tier.LetzteFuetterung.toString())
            binding.tiFueIntervall.setText(tier.FuetterungsIntervall.toString())
            binding.tiArzt.setText(tier.Tierarzt)
            binding.tiLetArzt.setText(tier.LetzterArztbesuch.toString())
            binding.tiLetEreignis.setText(tier.LetztesEreignis)
            binding.tiAnmerkung.setText(tier.Anmerkung)
        }

        // definiert Bild durch dazugehörige Tierart

        val imageRes = when (tier?.Tierart) {
            TierartEnum.INSEKTEN -> R.drawable.insektwarnschild
            TierartEnum.SCHLANGEN -> R.drawable.schlangewarnschild
            TierartEnum.ECHSEN -> R.drawable.echsewarnschild
            TierartEnum.FROESCHE -> R.drawable.froschwarnschild
            TierartEnum.SCHMETTERLINGE -> R.drawable.schmetterlingwarnschild
            TierartEnum.SKORPIONE -> R.drawable.skorpionwarnschild
            TierartEnum.AMPHIBIEN -> R.drawable.amphibienwarnschild
            TierartEnum.SPINNEN -> R.drawable.spinnewarnschild

            else -> R.drawable.blankwarnschild
        }

        binding.imageButton.setImageResource(imageRes)

    }

}