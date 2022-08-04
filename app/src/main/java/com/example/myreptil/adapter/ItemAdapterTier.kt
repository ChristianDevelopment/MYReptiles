package com.example.myreptil.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myreptil.data.datamodels.Tier
import com.example.myreptil.data.datamodels.TierartEnum
import com.example.myreptil.R
import com.example.myreptil.databinding.FragmentTiereBinding
import com.example.myreptil.ui.Fragment_TiereDirections

class ItemAdapterTier(private val dataset: List<Tier>) :
    RecyclerView.Adapter<ItemAdapterTier.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val text: TextView = itemView.findViewById(R.id.tv_pattern)
        val image: ImageView = itemView.findViewById(R.id.iv_pattern)

    }


    // erstellt das item Layout über itemViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val itemLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.pattern, parent, false)

        return ItemViewHolder(itemLayout)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val tier = dataset[position] //<- speichert das Tier position im dataset ab

        holder.text.text = tier.Name //<- Liefert name des Tieres


        val imageRes = when (tier.Tierart) { //<- definiert Bild durch dazugehörige Tierart
            TierartEnum.INSEKTEN -> R.drawable.insektwarnschild
            TierartEnum.SCHLANGEN -> R.drawable.schlangewarnschild
            TierartEnum.ECHSEN -> R.drawable.echsewarnschild
            TierartEnum.FROESCHE -> R.drawable.froschwarnschild
            TierartEnum.SCHMETTERLINGE -> R.drawable.schmetterlingwarnschild
            TierartEnum.SKORPIONE -> R.drawable.skorpionwarnschild
            TierartEnum.AMPHIBIEN -> R.drawable.amphibienwarnschild
            TierartEnum.SPINNEN -> R.drawable.spinnewarnschild
            TierartEnum.NOTHING -> R.drawable.blankwarnschild
        }
        holder.image.setImageResource(imageRes)  //<- Liefert Bild des Tieres

        holder.image.setOnClickListener {

            holder.itemView.findNavController()
                .navigate(Fragment_TiereDirections.actionFragmentTiereToShowDetailCardFragment(position))
        }

    }

    //liefert die anzahl der Tier (Liste)

    override fun getItemCount(): Int {
        return dataset.size
    }


}