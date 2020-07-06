package com.sidhuharry.moosewalatheapp.core;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * @author Harvinder_Sidhu
 */
public class AppSharedPreference {
    
    private SharedPreferences sharedPreferences;
    
    private Context context;
    
    @Inject
    public AppSharedPreference(Context context, SharedPreferences sharedPreferences) {
        this.context = context;
        this.sharedPreferences = sharedPreferences;
    }
    
    public void updatePerf(String key, String value) {
        sharedPreferences.edit().putString(key, value).commit();
    }
    
    public String getValue(String key) {
        String defaultVal = "";
        return sharedPreferences.getString(key, defaultVal);
    }
    
}
