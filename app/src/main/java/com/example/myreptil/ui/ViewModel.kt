package com.example.myreptil.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myreptil.data.Repository
import com.example.myreptil.data.datamodels.Gruppe
import com.example.myreptil.data.datamodels.Tier
import com.example.myreptil.data.local.getDataBase
import kotlinx.coroutines.launch

class ViewModel(application: Application) : AndroidViewModel(application) {

    // variable speicher DataBase und dessen Instance

    private val dataBase = getDataBase(application)

    // variable speichert eine Repository Instance

    private val repository = Repository(dataBase)   //<-object

    // speichert in der variable die tierliste vom Repository ab

    val tierList = repository.tierListe  //<- tierListe vom Repository

    fun search(suchBegriff: String): List<Tier> {

        return repository.search(suchBegriff)
    }

    // ruft die Funktion Speichern aus der Datenbank auf (über das Repository (aus dem DAO) )
     fun saveTierData (tier: Tier) {

         viewModelScope.launch {

             repository.insert(tier)

         }
     }
// ruft die Funktion Speichern aus der Datenbank auf (über das Repository (aus dem DAO) )

    fun saveGruppeData (gruppe: Gruppe) {

        viewModelScope.launch {

            repository.insert(gruppe)

        }
    }
}
