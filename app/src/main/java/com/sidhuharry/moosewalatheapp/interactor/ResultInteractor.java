/* *****************************************************************************
 * Symantec Watermark: CB70-0400-9993-66-15-1
 ******************************************************************************/
package com.sidhuharry.moosewalatheapp.interactor;

import android.util.Log;

import com.sidhuharry.moosewalatheapp.R;
import com.sidhuharry.moosewalatheapp.core.QuizController;

import javax.inject.Inject;

/**
 * @author Harvinder_Sidhu
 */
public class ResultInteractor {
    
    private static final String TAG = "ResultInteractor";
    
    private QuizController quizController;
    
    @Inject
    public ResultInteractor(QuizController quizController) {
        this.quizController = quizController;
    }
    
    public int getScore() {
        if (quizController.isAllQuestionCompleted()) {
            return quizController.getScore();
        }
        else {
            //TODO handle error  here
            Log.e(TAG, "What the fuck? How did it reach here");
            return 0;
        }
    }
    
    public int getMedal() {
        switch (quizController.getScore()) {
            case 5:
                return R.string.medal_5;
            case 4:
                return R.string.medal_4;
            case 3:
                return R.string.medal_3;
            case 2:
                return R.string.medal_2;
            case 1:
                return R.string.medal_1;
            case 0:
                return R.string.medal_0;
        }
        return 0;
    }
    
}
