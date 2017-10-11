package com.example.e_rho.architecturetesting;

import android.content.Context;
import android.util.Log;

import com.example.e_rho.architecturetesting.model.DataModel;

/**
 * Created by e_rho on 10/11/2017.
 */

public class Injection {
    private static final String TAG = "Eric-Injection";
    private static DataModel sDataModel;

    public static DataModel provideDataModel(Context context) {
        if (sDataModel == null) {
            Log.d(TAG, "made a new data model");
            sDataModel = new DataModel(context);
        }
        return sDataModel;
    }
}
