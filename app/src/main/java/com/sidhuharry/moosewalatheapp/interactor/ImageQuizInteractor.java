package com.sidhuharry.moosewalatheapp.interactor;

import com.sidhuharry.moosewalatheapp.core.Constants;

import java.util.Random;

/**
 * @author Harvinder_Sidhu
 */
public class ImageQuizInteractor {
    
    public int getRandomQuizScreenId() {
        return Constants.QUIZ_IMAGES[new Random().nextInt(Constants.QUIZ_IMAGES.length - 1)];
    }
    
}
