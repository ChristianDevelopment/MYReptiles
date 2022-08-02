package com.example.myreptil.Class

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myreptil.data.EintragTypen

@Entity(tableName="eintrag_table")
data class Eintrag(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0 ,
    var datum : String,
    var eintrag: String,
    var eintragTyp:EintragTypen
)

