package com.example.myreptil.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.myreptil.Class.Tier
import com.example.myreptil.Class.TierartEnum
import com.example.myreptil.R

// der Adapter braucht den Context um auf String Resourcen zuzugreifen
// und die Liste an Jokes um sie für die RecyclerView vorzubereiten
class ItemAdapter(
    private val context: Context,
    private val dataset: List<Tier>,
    private val pattern_click : (TierartEnum)->Unit
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // IDEE VON VIEWHOLDERN
    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tv_pattern)
        val imageView: ImageView = view.findViewById(R.id.iv_pattern)
        val patternButton : ConstraintLayout = view.findViewById(R.id.pattern_button)
    }

    // ERSTELLEN VON VIEWHOLDERN
    // hier werden neue ViewHolder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        // das itemLayout wird gebaut
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.pattern, parent, false)

        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(adapterLayout)
    }

    // BEFÜLLEN VON VIEWHOLDERN
    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = item.Name
        holder.imageView.setImageResource(item.Image)
        holder.patternButton.setOnClickListener{
            pattern_click(item.Tierart)
        }

        // macht keinen sinn von item aus navigieren. muss gruppen header click
//        holder.itemView.setOnClickListener {
//            var navController = holder.itemView.findNavController()
//            navController.navigate(GruppenFragmentDirections.actionFragmentGruppenToFragmentGruppentiere())
//        }
    }

    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}
