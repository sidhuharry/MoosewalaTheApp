package com.sidhuharry.moosewalatheapp.router;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.sidhuharry.moosewalatheapp.ui.Instructions;

/**
 * @author Harvinder_Sidhu
 */
public class LanguageSelectionRouter implements IRouter {
    
    public LanguageSelectionRouter() {
    }
    
    @Override
    public void nextScreen(Context activityContext, Bundle bundle) {
        Intent intent = new Intent(activityContext, Instructions.class);
        activityContext.startActivity(intent);
    }
    
    @Override
    public void previousScreen(Context activityContext) {
    }
    
}
