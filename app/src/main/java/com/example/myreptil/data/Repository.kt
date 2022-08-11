package com.example.myreptil.data

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import com.example.myreptil.data.datamodels.Eintrag
import com.example.myreptil.data.datamodels.EintragEnum
import com.example.myreptil.data.datamodels.Gruppe
import com.example.myreptil.data.datamodels.Tier
import com.example.myreptil.data.local.TierDataBase
import java.time.LocalDateTime

class Repository(private val dataBase: TierDataBase) {

    val tierListe: LiveData<List<Tier>> = dataBase.tierDataBaseDao.getAllFromTierTable()

    val gruppenListe: LiveData<MutableList<Gruppe>> = dataBase.tierDataBaseDao.getAllFromGruppenTable()


    // speichert ein Tier in die Datenbank
    suspend fun insert(tier: Tier) {

        try {
            dataBase.tierDataBaseDao.insert(tier)
        } catch (e: Exception) {
            Log.d("Repository", "Folgendes ist falsch gelaufen:$e")
        }

    }

    // speichert ein Gruppe in die Datenbank


    suspend fun insert(gruppe: Gruppe) {

        try {
            dataBase.tierDataBaseDao.insert(gruppe)
        } catch (e: Exception) {
            Log.d("Repository", "Folgendes ist falsch gelaufen:$e")
        }

    }

// speichert ein Eintrag in die Datenbank


    suspend fun insert(eintrag: Eintrag) {

        try {
            dataBase.tierDataBaseDao.insert(eintrag)
        } catch (e: Exception) {
            Log.d("Repository", "Folgendes ist falsch gelaufen:$e")
        }

    }
// holt alle Einträge von der Datenbank
    suspend fun getAllFromEintragTable(): List<Eintrag> {

        return dataBase.tierDataBaseDao.getAllFromEintragTable()
    }
// Updatet alle einträge von tier
    suspend fun update(tier: Tier) {

        try {
            dataBase.tierDataBaseDao.update(tier)
        } catch (e: Exception) {
            Log.d("Repository", "Folgendes ist falsch gelaufen:$e")
        }

    }

    // Updatet alle einträge von Gruppe
    suspend fun update(gruppe: Gruppe) {

        try {
            dataBase.tierDataBaseDao.update(gruppe)
        } catch (e: Exception) {
            Log.d("Repository", "Folgendes ist falsch gelaufen:$e")
        }

    }

    // löscht gruppe aus der Datenbank
    suspend fun delete(gruppe: Gruppe) {

        try {
            dataBase.tierDataBaseDao.delete(gruppe.id)
        } catch (e: Exception) {
            Log.d("Repository", "Folgendes ist falsch gelaufen:$e")
        }

    }

// löscht tier aus der Datenbank
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

          // filter für die timeline

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


    // funktion für den Suchfilter der Suchseite

    fun search(suchBegriff: String): List<Tier> {
        var filterList = tierListe.value!!.filter {
            it.wortFilter(suchBegriff)
        }
        return filterList
    }
}