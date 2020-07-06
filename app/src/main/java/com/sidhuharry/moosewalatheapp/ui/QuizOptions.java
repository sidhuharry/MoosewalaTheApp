package com.sidhuharry.moosewalatheapp.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.sidhuharry.moosewalatheapp.R;
import com.sidhuharry.moosewalatheapp.TheApplication;
import com.sidhuharry.moosewalatheapp.core.Constants;
import com.sidhuharry.moosewalatheapp.presentor.QuizOptionPresenter;

import javax.inject.Inject;

public class QuizOptions extends BaseActivity {
    
    private static final String TAG = "QuizOptions";
    
    @Inject
    QuizOptionPresenter quizOptionPresenter;
    
    private int imageId = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((TheApplication) getApplication()).getAppComponent().inject(this);
        Bundle bundle = getIntent().getExtras();
        imageId = bundle.getInt(Constants.IMAGE_ID);
        setContentView(R.layout.quiz_screen);
        RadioGroup radioGroup = findViewById(R.id.quiz_opt_group);
        quizOptionPresenter.reset();
        int indexForCorrectOpt = quizOptionPresenter.getRandomIndexForCorrectOption();
        for (int index = 0; index < radioGroup.getChildCount(); index++) {
            int textId;
            if (indexForCorrectOpt == index) {
                Log.d(TAG, "Correct option index is " + indexForCorrectOpt);
                textId = quizOptionPresenter.getCorrectOption(imageId);
            }
            else {
                textId = quizOptionPresenter.getRandomFillerOption();
            }
            Log.d(TAG, "Setting the textId as " + textId);
            ((RadioButton) radioGroup.getChildAt(index)).setText(textId);
            ((RadioButton) radioGroup.getChildAt(index)).setTag(textId);
        }
        
        findViewById(R.id.next_btn).setOnClickListener(v -> {
            RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
            int selectedRadioBtnStringId = (int) radioButton.getTag();
            quizOptionPresenter.onNext(this, selectedRadioBtnStringId, imageId);
        });
    }
    
}
