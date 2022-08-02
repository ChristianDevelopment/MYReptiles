package com.example.myreptil.Class

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity
data class Tier(
    @PrimaryKey (autoGenerate = true)
    val id : Long = 0 ,
    val Image: Int,
    var Name: String,
    var Tierart: TierartEnum = TierartEnum.NOTHING,
    var CustomTierart: String = "",
    var DeutscherName: String,
    var LateinischerName: String,
    val Alter: Double,
    var Geschlecht: Double,
    val Gewicht: Double,
    val Groesse: Double,
    var Geboren: Double,
    var Erworben: Double,
    var Verstorben: Double,
    var Zuchtlinie: String,
    var Generation: String,
    val LetzteHaeutung: Double,
    val LetzteFuetterung: Double,
    val FuetterungsIntervall: Int,
    val Tierarzt: String,
    val LetzterArztbesuch: Double,
    val LetztesEreignis: String,
    val Anmerkung: String

)
