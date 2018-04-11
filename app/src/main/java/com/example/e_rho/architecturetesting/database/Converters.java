package com.example.e_rho.architecturetesting.database;

import android.arch.persistence.room.TypeConverter;
import android.util.Log;

import com.example.e_rho.architecturetesting.model.Attribute;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * Created by e_rho on 2/14/2018.
 */

public class Converters {

    @TypeConverter
    public static Attribute fromInt(int value) {
        return new Attribute(value);
    }

    @TypeConverter
    public static int attributeToInt(Attribute attribute) {
        return attribute.getBaseValue();
    }

    @TypeConverter
    public static HashMap<String, Attribute> fromString(String json) {
        Log.d("Eric","deserialzing " + json);
        Gson gson = new Gson();
        Type collectionType = new TypeToken<HashMap<String, Attribute>>() {}.getType();
        return gson.fromJson(json, collectionType);
    }

    @TypeConverter
    public static String toString(HashMap<String, Attribute> attributes) {
        Gson gson = new Gson();
        Log.d("Eric",gson.toJson(attributes));
        return gson.toJson(attributes);
    }
}
