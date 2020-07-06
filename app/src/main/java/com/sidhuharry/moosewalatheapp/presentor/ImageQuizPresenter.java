package com.sidhuharry.moosewalatheapp.presentor;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.sidhuharry.moosewalatheapp.core.Constants;
import com.sidhuharry.moosewalatheapp.interactor.ImageQuizInteractor;
import com.sidhuharry.moosewalatheapp.router.IRouter;
import com.sidhuharry.moosewalatheapp.ui.ImageQuiz;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author Harvinder_Sidhu
 */
public class ImageQuizPresenter {
    
    private static final String TAG = "ImageQuizPresenter";
    
    private WeakReference<ImageQuiz> imageQuizWeakReference;
    
    private IRouter imageQuizRouter;
    
    private ImageQuizInteractor imageQuizInteractor;
    
    private int time;
    
    private List<Integer> imagesAlreadyShown = new ArrayList<>();
    
    @Inject
    public ImageQuizPresenter(IRouter imageQuizRouter, ImageQuizInteractor imageQuizInteractor) {
        this.imageQuizRouter = imageQuizRouter;
        this.imageQuizInteractor = imageQuizInteractor;
    }
    
    public void reset() {
        time = 10;
    }
    
    public void startTimer(final Context activityContext) {
        Handler handler = new Handler();
        ImageQuiz imageQuizActivity = imageQuizWeakReference.get();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (time < 0) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(Constants.IMAGE_ID, imageQuizActivity.getImageId());
                    imageQuizRouter.nextScreen(activityContext, bundle);
                }
                else {
                    handler.postDelayed(this, 1000);
                    if (imageQuizActivity != null) {
                        imageQuizActivity.setTimeInTextView(time);
                    }
                    time--;
                }
            }
        });
    }
    
    public void setImageQuizWeakReference(WeakReference<ImageQuiz> imageQuizWeakReference) {
        this.imageQuizWeakReference = imageQuizWeakReference;
    }
    
    public int getRandomQuizScreenId() {
        int imageId = imageQuizInteractor.getRandomQuizScreenId();
        if (imagesAlreadyShown.contains(imageId)) {
            Log.d(TAG, "Image is already shown so getting a new image");
            return getRandomQuizScreenId();
        }
        else {
            Log.d(TAG, "Image is not shown already so return image id");
            imagesAlreadyShown.add(imageId);
        }
        return imageId;
    }
    
}
