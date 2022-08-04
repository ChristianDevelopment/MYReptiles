package com.example.myreptil.data

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myreptil.Class.Eintrag
import com.example.myreptil.Class.Tier
import com.example.myreptil.data.local.getDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDateTime

class ViewModel(application: Application) : AndroidViewModel(application) {

    // variable speicher DataBase und dessen Instance

    private val dataBase = getDataBase(application)

    // variable speichert eine Repository Instance

   private val repository = Repository(dataBase)   //<-object

    // speichert in der variable die tierliste vom Repository ab

    val tierList = repository.tierListe  //<- tierListe vom Repository

    // funktion zum speichern der Timeline(Haeutung,fütterung,arztbesuch)
    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun insertTimeline(eintrag: String, eintragTyp: EintragTypen) {

        var newEntry = Eintrag(
            datum = LocalDateTime.now().toString(),
            eintrag = eintrag,
            eintragTyp = eintragTyp
        )

        dataBase.tierDataBaseDao.insert(newEntry)
    }

    suspend fun getTimeline (eintragTyp: EintragTypen):List<Eintrag>{

        val entries = dataBase.tierDataBaseDao.getAllFromEintragTable()
        // filter für die timeline zum unterschied vom arzt , haeutung, fütterung
        val filterEntries = mutableListOf<Eintrag>()

        for (entry in entries){
            if (entry.eintragTyp==eintragTyp)
                filterEntries.add(entry)
        }
        return filterEntries
    }

     fun saveTierData (tier: Tier) {

         viewModelScope.launch {

             repository.insert(tier)

         }
     }
}
