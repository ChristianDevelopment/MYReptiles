package com.example.myreptil.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.myreptil.R
import com.example.myreptil.data.datamodels.Gruppe

// der Adapter braucht den Context um auf String Resourcen zuzugreifen
// und die Liste an Jokes um sie für die RecyclerView vorzubereiten
class ItemAdapterGruppe(
    private val dataset: MutableList<Gruppe>,
    private val navigation: (Long) -> Unit,
    private val deleteGruppe: (Gruppe) -> Unit
) : RecyclerView.Adapter<ItemAdapterGruppe.ItemViewHolder>() {

    // IDEE VON VIEWHOLDERN
    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tv_patternGruppe)
        val imageView: ImageView = view.findViewById(R.id.iv_patternGruppe)
        val patternButton: ConstraintLayout = view.findViewById(R.id.patternGruppe_button)
    }

    // ERSTELLEN VON VIEWHOLDERN
    // hier werden neue ViewHolder erstellt

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // das itemLayout wird gebaut

        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.pattern_gruppe, parent, false)

        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(adapterLayout)
    }

    // BEFÜLLEN VON VIEWHOLDERN
    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val itemGruppe = dataset[position]
        holder.textView.text = itemGruppe.Name

        holder.patternButton.setOnClickListener {
            navigation(itemGruppe.id)
        }

        Log.i("TESTEST", "tiere in Gruppe: ${itemGruppe.tiereInGruppe}")
        if (itemGruppe.tiereInGruppe.size == 0) {
            Log.i("TESTEST", "delete")
            deleteGruppe(itemGruppe)
        }
    }

    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}
