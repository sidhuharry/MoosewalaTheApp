package com.sidhuharry.moosewalatheapp.router;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.sidhuharry.moosewalatheapp.ui.QuizOptions;

/**
 * @author Harvinder_Sidhu
 */
public class ImageQuizRouter implements IRouter {
    
    @Override
    public void nextScreen(Context activityContext, Bundle bundle) {
        Intent intent = new Intent(activityContext, QuizOptions.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        activityContext.startActivity(intent);
    }
    
    @Override
    public void previousScreen(Context activityContext) {
    
    }
    
}
