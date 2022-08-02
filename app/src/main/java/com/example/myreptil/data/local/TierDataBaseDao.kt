package com.example.myreptil.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myreptil.Class.Eintrag
import com.example.myreptil.Class.Tier

@Dao
interface TierDataBaseDao {

    // diese funktion selektiert alle aus den room befindlichen daten von der data liste Tier

    @Query("SELECT * FROM Tier")
    fun getAllFromTierTable(): List<Tier>

    // diese funktion selektiert alle aus den room befindlichen daten von der data liste Eintrag

    @Query("SELECT * FROM eintrag_table")
    fun getAllFromEintragTable(): List<Eintrag>

    //diese funktion fügt ein tier hinzu bei der data liste Tier

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tier: Tier)

    //diese funktion fügt ein eintrag hinzu

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(eintrag: Eintrag)

    //diese funktion updatet die data liste Tier

    @Update
    suspend fun update(tier: Tier)

    //diese funktion löscht ein tier aus der data liste Tier über die id

    @Query("DELETE FROM Tier Where id =:id")
    suspend fun delete(id: Long)



}

