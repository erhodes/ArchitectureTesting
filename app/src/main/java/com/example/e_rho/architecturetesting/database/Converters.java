package com.example.e_rho.architecturetesting.database;

import android.arch.persistence.room.TypeConverter;

import com.example.e_rho.architecturetesting.model.Attribute;

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
}
