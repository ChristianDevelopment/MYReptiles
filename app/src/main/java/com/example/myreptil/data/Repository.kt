package com.example.myreptil.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.myreptil.Class.Eintrag
import com.example.myreptil.Class.Tier
import com.example.myreptil.data.local.TierDataBase

class Repository(private val dataBase: TierDataBase) {

    val tierListe: List<Tier> = dataBase.tierDataBaseDao.getAllFromTierTable()


    suspend fun insert(tier: Tier) {

        try {
            dataBase.tierDataBaseDao.insert(tier)
        }

        catch(e:Exception){
            Log.d("Repository","Folgendes ist falsch gelaufen:$e")
        }

    }

    suspend fun insert(eintrag: Eintrag) {

        try {
            dataBase.tierDataBaseDao.insert(eintrag)
        }

        catch(e:Exception){
            Log.d("Repository","Folgendes ist falsch gelaufen:$e")
        }

    }

    suspend fun getAllFromEintragTable ():List<Eintrag>{

        return dataBase.tierDataBaseDao.getAllFromEintragTable()
    }

    suspend fun update(tier: Tier) {

        try {
            dataBase.tierDataBaseDao.update(tier)
        }

        catch(e:Exception){
            Log.d("Repository","Folgendes ist falsch gelaufen:$e")
        }

    }

    suspend fun delete(tier: Tier) {

        try {
            dataBase.tierDataBaseDao.delete(tier.id)
        }

        catch(e:Exception){
            Log.d("Repository","Folgendes ist falsch gelaufen:$e")
        }

    }

}