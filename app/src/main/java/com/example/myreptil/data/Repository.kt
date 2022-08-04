package com.example.myreptil.data

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import com.example.myreptil.data.datamodels.Eintrag
import com.example.myreptil.data.datamodels.EintragEnum
import com.example.myreptil.data.datamodels.Tier
import com.example.myreptil.data.local.TierDataBase
import java.time.LocalDateTime

class Repository(private val dataBase: TierDataBase) {

    val tierListe: LiveData<List<Tier>> = dataBase.tierDataBaseDao.getAllFromTierTable()


    suspend fun insert(tier: Tier) {

        try {
            dataBase.tierDataBaseDao.insert(tier)
        } catch (e: Exception) {
            Log.d("Repository", "Folgendes ist falsch gelaufen:$e")
        }

    }

    suspend fun insert(eintrag: Eintrag) {

        try {
            dataBase.tierDataBaseDao.insert(eintrag)
        } catch (e: Exception) {
            Log.d("Repository", "Folgendes ist falsch gelaufen:$e")
        }

    }

    suspend fun getAllFromEintragTable(): List<Eintrag> {

        return dataBase.tierDataBaseDao.getAllFromEintragTable()
    }

    suspend fun update(tier: Tier) {

        try {
            dataBase.tierDataBaseDao.update(tier)
        } catch (e: Exception) {
            Log.d("Repository", "Folgendes ist falsch gelaufen:$e")
        }

    }

    suspend fun delete(tier: Tier) {

        try {
            dataBase.tierDataBaseDao.delete(tier.id)
        } catch (e: Exception) {
            Log.d("Repository", "Folgendes ist falsch gelaufen:$e")
        }

    }

    // funktion zum speichern der Timeline(Haeutung,fütterung,arztbesuch)
    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun insertTimeline(eintrag: String, eintragTyp: EintragEnum) {

        var newEntry = Eintrag(
            datum = LocalDateTime.now().toString(),
            eintrag = eintrag,
            eintragTyp = eintragTyp
        )

        dataBase.tierDataBaseDao.insert(newEntry)
    }

    suspend fun getTimeline(eintragTyp: EintragEnum): List<Eintrag> {

        val entries = dataBase.tierDataBaseDao.getAllFromEintragTable()
        // filter für die timeline zum unterschied vom arzt , haeutung, fütterung
        val filterEntries = mutableListOf<Eintrag>()

        for (entry in entries) {
            if (entry.eintragTyp == eintragTyp)
                filterEntries.add(entry)
        }
        return filterEntries
    }


    // funktion für den suchfilter der suchseite

    fun search(suchBegriff: String): List<Tier> {

        var filterList = tierListe.value!!.filter {
            it.wortFilter(suchBegriff)
        }
        return filterList
    }
}