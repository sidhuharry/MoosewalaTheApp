package com.sidhuharry.moosewalatheapp.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.sidhuharry.moosewalatheapp.R;
import com.sidhuharry.moosewalatheapp.TheApplication;
import com.sidhuharry.moosewalatheapp.presentor.ResultPresenter;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

public class Result extends BaseActivity {
    
    @Inject
    ResultPresenter resultPresenter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        ((TheApplication) getApplication()).getAppComponent().inject(this);
        resultPresenter.setResultWeakReference(new WeakReference<>(this));
        resultPresenter.setResults();
    }
    
    public void setScore(int score) {
        TextView scoreText = findViewById(R.id.score_title);
        scoreText.setText(String.format(getResources().getString(R.string.score), score));
    }
    
    public void setMedal(int medalStringId) {
        TextView medalTextView = findViewById(R.id.score_medal);
        medalTextView.setText(medalStringId);
    }
    
}
