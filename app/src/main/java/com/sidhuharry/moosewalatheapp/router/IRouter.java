package com.sidhuharry.moosewalatheapp.router;

import android.content.Context;
import android.os.Bundle;

/**
 * @author Harvinder_Sidhu
 */
public interface IRouter {
    
    void nextScreen(Context activityContext, Bundle bundle);
    
    void previousScreen(Context activityContext);
    
}
