package com.example.myreptil.data.local

import androidx.room.TypeConverter
import com.example.myreptil.data.datamodels.Tier
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    // erstellt ein Gson und convertiert die Liste in einen String (ist da das man in Datenbank abspeichern kann)

    @TypeConverter
    fun listOfItemsToString(items: MutableList<Tier>): String? {
        var gson = Gson()
        return gson.toJson(items)
    }

    // wandelt den String wieder um in die Liste um
    @TypeConverter
    fun fromString(value: String?): MutableList<Tier> {
        val listType = object : TypeToken<ArrayList<Tier?>?>() {}.type

        return Gson().fromJson(value, listType)
    }
}
