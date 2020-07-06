package com.sidhuharry.moosewalatheapp;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.ContextThemeWrapper;

import com.sidhuharry.moosewalatheapp.core.AppSharedPreference;
import com.sidhuharry.moosewalatheapp.core.Constants;
import com.sidhuharry.moosewalatheapp.core.StringUtil;
import com.sidhuharry.moosewalatheapp.di.AppComponent;
import com.sidhuharry.moosewalatheapp.di.DaggerAppComponent;

import java.util.Locale;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * @author Harvinder_Sidhu
 */
public class TheApplication extends DaggerApplication {
    
    private static final String TAG = "TheApplication";
    
    private AppComponent appComponent;
    
    @Override
    public void onCreate() {
        Log.d(TAG, "Inside onCreate");
        super.onCreate();
    }
    
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        Log.d(TAG, "Inside applicationInjector method");
        initializeDaggerAppComponent();
        return appComponent;
    }
    
    public AppComponent getAppComponent() {
        return appComponent;
    }
    
    private void initializeDaggerAppComponent() {
        appComponent = DaggerAppComponent.builder().application(this).setApplicationContext(this).build();
    }
    
}
