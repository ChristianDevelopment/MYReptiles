package com.example.myreptil.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myreptil.data.datamodels.Eintrag
import com.example.myreptil.data.datamodels.Gruppe
import com.example.myreptil.data.datamodels.Tier

@Dao
interface TierDataBaseDao {

    // diese funktion selektiert alle aus den room befindlichen daten von der data liste Tier

    @Query("SELECT * FROM Tier")
    fun getAllFromTierTable(): LiveData <List<Tier>>

    // diese funktion selektiert alle aus den room befindlichen daten von der data liste Eintrag

    @Query("SELECT * FROM eintrag_table")
    fun getAllFromEintragTable(): List<Eintrag>

    //diese funktion fügt ein tier hinzu bei der data liste Tier

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tier: Tier)

    //diese funktion fügt ein eintrag hinzu

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(eintrag: Eintrag)

//    diese funktion fügt der Gruppe ein tier hinzu bei der data liste Tier

//    diese funktion fügt ein Gruppe hinzu

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(gruppe: Gruppe)

    //diese funktion updatet die data liste Tier

    @Update
    suspend fun update(tier: Tier)

    //diese funktion löscht ein tier aus der data liste Tier über die id

    @Query("DELETE FROM Tier Where id =:id")
    suspend fun delete(id: Long)



}

