package com.sidhuharry.moosewalatheapp;

import com.sidhuharry.moosewalatheapp.di.AppComponent;
import com.sidhuharry.moosewalatheapp.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * @author Harvinder_Sidhu
 */
public class TheApplication extends DaggerApplication {
    
    private AppComponent appComponent;
    
    
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        // Initialize dagger main app component here and return it
        return DaggerAppComponent.builder().application(this).build();
    }
    
}
