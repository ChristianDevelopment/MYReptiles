package com.example.myreptil.data.datamodels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="eintrag_table")
data class Eintrag(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0 ,
    var datum : String,
    var eintrag: String,
    var eintragTyp: EintragEnum
)

