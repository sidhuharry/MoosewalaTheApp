package com.sidhuharry.moosewalatheapp.ui;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sidhuharry.moosewalatheapp.R;
import com.sidhuharry.moosewalatheapp.TheApplication;
import com.sidhuharry.moosewalatheapp.core.StringUtil;
import com.sidhuharry.moosewalatheapp.core.tasks.DelayedHandler;

import javax.inject.Inject;

/**
 * @author Harvinder_Sidhu
 */
public class Splash extends AppCompatActivity {
    
    private static final String TAG = "Splash";
    
    @Inject
    String userLocaleString;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((TheApplication) getApplication()).getAppComponent().inject(this);
        Log.d(TAG, "Inside splash activity");
        setContentView(R.layout.splash);
        ImageView imageView = findViewById(R.id.moos_splash_container);
        imageView.setBackgroundResource(R.drawable.moos_splash);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();
        Handler handler = new Handler();
        Log.d(TAG, "userLocaleString value is " + userLocaleString);
        
        //TODO move this routing out of here to some kind of router
        if (StringUtil.isEmpty(userLocaleString)) {
            handler.postDelayed(new DelayedHandler(this, LanguageSelection.class), 3000);
        }
        else {
            handler.postDelayed(new DelayedHandler(this, Instructions.class), 3000);
        }
        
    }
    
}

