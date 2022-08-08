package com.example.myreptil.data.datamodels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Gruppe(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
//    val Image: Int,
    var Name: String,
//    var Tierart: TierartEnum = TierartEnum.NOTHING,
//    var CustomTierart: String = "",
    var gruppenTiereId: List<Tier>


)