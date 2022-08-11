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
import com.example.myreptil.data.datamodels.Tier
import com.example.myreptil.data.datamodels.TierartEnum
import com.example.myreptil.databinding.FragmentDetailCardBinding

class DetailCardFragment : Fragment() {

    private val viewModel: ViewModel by activityViewModels()

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
            // für das Auslesen der input felder

            val Name = binding.tiName.text.toString()
            var CustomTierart = binding.tiTierart.text.toString()
            var DeutscherName = binding.tiDeuName.text.toString()
            var LateinischerName = binding.tiLatName.text.toString()
            val Alter = binding.tiAlter.text.toString().toDoubleOrNull()
            var Geschlecht = binding.tiGeschlecht.text.toString().toDoubleOrNull()
            val Gewicht = binding.tiGewicht.text.toString().toDoubleOrNull()
            val Groesse = binding.tiGroesse.text.toString().toDoubleOrNull()
            var Geboren = binding.tiGeboren.text.toString().toDoubleOrNull()
            var Erworben = binding.tiErworben.text.toString().toDoubleOrNull()
            var Verstorben = binding.tiVerstorben.text.toString().toDoubleOrNull()
            var Zuchtlinie = binding.tiZucht.text.toString()
            var Generation = binding.tiGeneration.text.toString()
            val LetzteHaeutung = binding.tiLetHaeutung.text.toString().toDoubleOrNull()
            val LetzteFuetterung = binding.tiLetFuetterung.text.toString().toDoubleOrNull()
            val FuetterungsIntervall = binding.tiFueIntervall.text.toString().toDoubleOrNull()
            val Tierarzt = binding.tiArzt.text.toString()
            val LetzterArztbesuch = binding.tiLetArzt.text.toString().toDoubleOrNull()
            val LetztesEreignis = binding.tiLetEreignis.text.toString()
            val Anmerkung = binding.tiAnmerkung.text.toString()

            val race = binding.tiTierart.text.toString().lowercase()

            var tierartEnum = when (race) {
                // mögliche schreibweise für jede tierart und Image zuweisung

//                INSEKTEN,
                "insekt" -> TierartEnum.INSEKTEN
                "insekten" -> TierartEnum.INSEKTEN

//                SCHLANGEN,
                "schlange" -> TierartEnum.SCHLANGEN
                "schlangen" -> TierartEnum.SCHLANGEN

//                ECHSEN,
                "echse" -> TierartEnum.ECHSEN
                "echsen" -> TierartEnum.ECHSEN

//                FROESCHE,
                "frosch" -> TierartEnum.FROESCHE
                "frösche" -> TierartEnum.FROESCHE

//                SCHMETTERLINGE,
                "schmetterling" -> TierartEnum.SCHMETTERLINGE
                "schmetterlinge" -> TierartEnum.SCHMETTERLINGE

//                SKORPIONE,
                "skorpion" -> TierartEnum.SKORPIONE
                "skorpione" -> TierartEnum.SKORPIONE

//                AMPHIBIEN,
                "amphibie" -> TierartEnum.AMPHIBIEN
                "amphibien" -> TierartEnum.AMPHIBIEN

//                SPINNE,
                "spinne" -> TierartEnum.SPINNEN
                "spinnen" -> TierartEnum.SPINNEN

                else -> TierartEnum.NOTHING
            }

            val tier = Tier(
                Image = 0,
                Name = Name,
                CustomTierart = CustomTierart,
                DeutscherName = DeutscherName,
                LateinischerName = LateinischerName,
                Alter = Alter ?: 0.0,
                Geschlecht = Geschlecht ?: 0.0,
                Tierart = tierartEnum,
                Gewicht = Gewicht ?: 0.0,
                Groesse = Groesse ?: 0.0,
                Geboren = Geboren ?: 0.0,
                Erworben = Erworben ?: 0.0,
                Verstorben = Verstorben ?: 0.0,
                Zuchtlinie = Zuchtlinie,
                Generation = Generation,
                LetzteHaeutung = LetzteHaeutung ?: 0.0,
                LetzteFuetterung = LetzteFuetterung ?: 0.0,
                FuetterungsIntervall = FuetterungsIntervall ?: 0.0,
                Tierarzt = Tierarzt,
                LetzterArztbesuch = LetzterArztbesuch ?: 0.0,
                LetztesEreignis = LetztesEreignis,
                Anmerkung = Anmerkung

            )

            //  beim speichern zur weiterleitung zum nächsten Fragment
            viewModel.saveTierData(tier)
            findNavController().navigate(DetailCardFragmentDirections.actionDetailCardFragment2ToFragmentTiere())
        }
    }
}
