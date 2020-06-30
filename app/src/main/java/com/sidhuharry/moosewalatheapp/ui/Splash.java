package com.sidhuharry.moosewalatheapp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sidhuharry.moosewalatheapp.R;

/**
 * @author Harvinder_Sidhu
 */
public class Splash extends AppCompatActivity {
    
    private static final String TAG = "Splash";
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Inside splash activity");
        setContentView(R.layout.splash);
        RotateAnimation rotateAnimation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setDuration(10000);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.start();
        ImageView imageView = findViewById(R.id.moosewala_loading_icon);
        imageView.startAnimation(rotateAnimation);
        
        Handler aDelayHandler = new Handler();
        aDelayHandler.postDelayed(new DelayThread(this), 3000);
    }
    
}

class DelayThread implements Runnable {
    
    private Context context;
    
    public DelayThread(Context context) {
        this.context = context;
    }
    
    @Override
    public void run() {
        Intent intent = new Intent(context, Instructions.class);
        context.startActivity(intent);
    }
    
}