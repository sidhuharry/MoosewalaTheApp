package com.sidhuharry.moosewalatheapp.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.sidhuharry.moosewalatheapp.R;
import com.sidhuharry.moosewalatheapp.TheApplication;
import com.sidhuharry.moosewalatheapp.presentor.InstructionsPresenter;

import javax.inject.Inject;

public class Instructions extends BaseActivity {
    
    @Inject
    InstructionsPresenter instructionsPresenter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((TheApplication) getApplication()).getAppComponent().inject(this);
        setContentView(R.layout.instructions);
        Button startButton = findViewById(R.id.instructions_ok_btn);
        startButton.setOnClickListener(v -> instructionsPresenter.onClickStart(Instructions.this));
    }
    
    @Override
    protected void onResume() {
        super.onResume();
    }
    
}
