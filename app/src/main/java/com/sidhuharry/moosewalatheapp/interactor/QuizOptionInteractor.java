
package com.sidhuharry.moosewalatheapp.interactor;

import android.util.Log;

import com.sidhuharry.moosewalatheapp.core.Constants;
import com.sidhuharry.moosewalatheapp.core.QuizController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

/**
 * @author Harvinder_Sidhu
 */
public class QuizOptionInteractor {
    
    private static final String TAG = "QuizOptionInteractor";
    
    private List<Integer> fillerOptionsLocalCopy;
    
    private QuizController quizController;
    
    @Inject
    public QuizOptionInteractor(QuizController quizController) {
        this.quizController = quizController;
    }
    
    public void reset() {
        fillerOptionsLocalCopy = new ArrayList<>(Constants.FILLER_OPTIONS);
    }
    
    public int getRandomFillerOption() {
        Random random = new Random();
        int randomIndex = random.nextInt(fillerOptionsLocalCopy.size() - 1);
        int optionId = fillerOptionsLocalCopy.get(randomIndex);
        fillerOptionsLocalCopy.remove(randomIndex);
        return optionId;
    }
    
    public int getRandomIndexForCorrectOption() {
        return new Random().nextInt(3);
    }
    
    public int getCorrectOption(int imageId) {
        Integer correctOpt = Constants.QUIZ_ANS_MAP.get(imageId);
        if (correctOpt != null) {
            return correctOpt;
        }
        else {
            return 0;
        }
    }
    
    public void evaluateAnswer(int selectedRadioBtnStringId, int imageId) {
        Log.d(TAG, "Evaluating answer");
        if (getCorrectOption(imageId) == selectedRadioBtnStringId) {
            Log.d(TAG, "It was correct answer");
            int score = quizController.getScore();
            score++;
            quizController.setScore(score);
            Log.d(TAG, "Set the score " + score);
        }
        int numberOfQue = quizController.getNoOfQueCompleted();
        numberOfQue++;
        quizController.setNoOfQueCompleted(numberOfQue);
        Log.d(TAG, "Set the number of questions done " + numberOfQue);
    }
    
}
