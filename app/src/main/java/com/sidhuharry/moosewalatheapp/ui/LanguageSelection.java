package com.sidhuharry.moosewalatheapp.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.sidhuharry.moosewalatheapp.R;
import com.sidhuharry.moosewalatheapp.TheApplication;
import com.sidhuharry.moosewalatheapp.core.Constants;
import com.sidhuharry.moosewalatheapp.presentor.LanguageSelectionPresenter;

import javax.inject.Inject;

public class LanguageSelection extends BaseActivity {
    
    private static final String TAG = "LanguageSelection";
    
    @Inject
    LanguageSelectionPresenter languageSelectionPresenter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((TheApplication) getApplication()).getAppComponent().inject(this);
        setContentView(R.layout.language);
        Button buttonPa = findViewById(R.id.pa_btn);
        buttonPa.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                languageSelectionPresenter.onPaBtnClick(LanguageSelection.this, Constants.PA_LANG_CODE);
            }
        });
        Button buttonEn = findViewById(R.id.en_btn);
        buttonEn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                languageSelectionPresenter.onEnBtnClick(LanguageSelection.this, Constants.EN_LANG_CODE);
            }
        });
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        // on resume
    }
    
}