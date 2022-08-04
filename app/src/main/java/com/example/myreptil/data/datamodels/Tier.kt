package com.example.myreptil.data.datamodels

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Tier(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
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

) {
    //TODO überlegen der anderen typen überprüfung
    fun wortFilter(suchBegriff: String): Boolean {
        //TODO all the way für strings machen
        return Name.contains(suchBegriff) || CustomTierart.contains(suchBegriff)

    }
}
