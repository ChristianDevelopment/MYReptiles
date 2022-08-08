package com.example.myreptil.data.datamodels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Gruppe(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val Image: Int,
    var Name: String,
    var Tierart: TierartEnum = TierartEnum.NOTHING,
    var CustomTierart: String = "",


) {
    //TODO überlegen der anderen typen überprüfung
    fun wortFilter(suchBegriff: String,ignoreCase: Boolean=true): Boolean {
//        TODO all the way für strings machen

        return  Name.contains(suchBegriff,ignoreCase) ||
                Tierart.name.contains(suchBegriff,ignoreCase) ||
                CustomTierart.contains(suchBegriff,ignoreCase)
    }
}
