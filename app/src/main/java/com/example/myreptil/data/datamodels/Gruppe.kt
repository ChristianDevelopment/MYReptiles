package com.example.myreptil.data.datamodels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Gruppe(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    var Name: String,
    var tiereInGruppe: MutableList<Tier>


)