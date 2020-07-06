
package com.sidhuharry.moosewalatheapp.presentor;

import android.content.Context;

import com.sidhuharry.moosewalatheapp.interactor.QuizOptionInteractor;
import com.sidhuharry.moosewalatheapp.router.IRouter;

import javax.inject.Inject;

/**
 * @author Harvinder_Sidhu
 */
public class QuizOptionPresenter {
    
    private IRouter quizOptionRouter;
    
    private QuizOptionInteractor quizOptionInteractor;
    
    @Inject
    public QuizOptionPresenter(IRouter quizOptionRouter, QuizOptionInteractor quizOptionInteractor) {
        this.quizOptionRouter = quizOptionRouter;
        this.quizOptionInteractor = quizOptionInteractor;
    }
    
    public int getRandomFillerOption() {
        return quizOptionInteractor.getRandomFillerOption();
    }
    
    public int getRandomIndexForCorrectOption() {
        return quizOptionInteractor.getRandomIndexForCorrectOption();
    }
    
    public int getCorrectOption(int imageId) {
        return quizOptionInteractor.getCorrectOption(imageId);
    }
    
    public void onNext(Context activityContext, int selectedRadioBtnStringId, int imageId) {
        quizOptionInteractor.evaluateAnswer(selectedRadioBtnStringId, imageId);
        quizOptionRouter.nextScreen(activityContext, null);
    }
    
    public void reset() {
        quizOptionInteractor.reset();
    }
    
}
