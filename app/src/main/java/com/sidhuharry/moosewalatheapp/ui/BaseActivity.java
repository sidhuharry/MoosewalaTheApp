
package com.sidhuharry.moosewalatheapp.ui;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sidhuharry.moosewalatheapp.TheApplication;
import com.sidhuharry.moosewalatheapp.presentor.LanguageSelectionPresenter;

import java.util.Locale;

import javax.inject.Inject;

/**
 * @author Harvinder_Sidhu
 */
public class BaseActivity extends AppCompatActivity {
    
    @Inject
    LanguageSelectionPresenter languageSelectionPresenter;
    
    @Inject
    String userLocaleString;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((TheApplication) getApplication()).getAppComponent().inject(this);
        Locale userLocale = new Locale(userLocaleString);
        Locale.setDefault(userLocale);
        Configuration config = new Configuration();
        config.locale = userLocale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }
    
}
