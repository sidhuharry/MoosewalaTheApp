
package com.sidhuharry.moosewalatheapp.router;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.sidhuharry.moosewalatheapp.ui.ImageQuiz;

/**
 * @author Harvinder_Sidhu
 */
public class InstructionsRouter implements IRouter {
    
    @Override
    public void nextScreen(Context activityContext, Bundle bundle) {
        Intent intent = new Intent(activityContext, ImageQuiz.class);
        activityContext.startActivity(intent);
    }
    
    @Override
    public void previousScreen(Context activityContext) {
        // TODO Implement this
    }
    
}
