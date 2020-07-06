
package com.sidhuharry.moosewalatheapp.router;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.sidhuharry.moosewalatheapp.core.QuizController;
import com.sidhuharry.moosewalatheapp.ui.ImageQuiz;
import com.sidhuharry.moosewalatheapp.ui.Result;

import javax.inject.Inject;

/**
 * @author Harvinder_Sidhu
 */
public class QuizOptionRouter implements IRouter {
    
    private QuizController quizController;
    
    @Inject
    public QuizOptionRouter(QuizController quizController) {
        this.quizController = quizController;
    }
    
    @Override
    public void nextScreen(Context activityContext, Bundle bundle) {
        if (quizController.isAllQuestionCompleted()) {
            // go to result screen
            activityContext.startActivity(new Intent(activityContext, Result.class));
        }
        else {
            // go to quiz screen
            activityContext.startActivity(new Intent(activityContext, ImageQuiz.class));
        }
    }
    
    @Override
    public void previousScreen(Context activityContext) {
    
    }
    
}
