package com.sidhuharry.moosewalatheapp.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.sidhuharry.moosewalatheapp.R;
import com.sidhuharry.moosewalatheapp.TheApplication;
import com.sidhuharry.moosewalatheapp.presentor.ImageQuizPresenter;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

public class ImageQuiz extends BaseActivity {
    
    @Inject
    ImageQuizPresenter presenter;
    
    private int imageId;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((TheApplication) getApplication()).getAppComponent().inject(this);
        setContentView(R.layout.image_quiz_screen);
    }
    
    public void setTimeInTextView(int time) {
        TextView timer = findViewById(R.id.timer);
        timer.setText(String.valueOf(time));
    }
    
    public int getImageId() {
        return imageId;
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        ImageView imageView = findViewById(R.id.imgQuiz);
        presenter.reset();
        imageId = presenter.getRandomQuizScreenId();
        imageView.setImageResource(imageId);
        presenter.setImageQuizWeakReference(new WeakReference<ImageQuiz>(this));
        presenter.startTimer(this);
    }
    
}
