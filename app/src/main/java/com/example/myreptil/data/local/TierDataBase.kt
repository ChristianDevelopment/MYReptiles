package com.example.myreptil.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myreptil.Class.Tier

// Class erbt von RoomDataBase

@Database(entities = [Tier::class], version = 1)
abstract class TierDataBase : RoomDatabase() {

    // verknüpft DataBank mit der Dao

    abstract val tierDataBaseDao: TierDataBaseDao

}

// erstellt variable und legt den typ TierDataBase an

private lateinit var INSTANCE: TierDataBase

// liefert oder erzeugt Instance vom typ TierDataBase

fun getDataBase(context: Context): TierDataBase {

    // wird nur ein mal beim ersten durchlauf erstellt

    synchronized(TierDataBase::class.java) {

        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                TierDataBase::class.java,
                "TierDatenBank"
            ).build()
        }
    }

    // gibt die instance aus

    return INSTANCE
}