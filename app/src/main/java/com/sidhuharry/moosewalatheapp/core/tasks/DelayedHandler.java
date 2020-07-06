package com.sidhuharry.moosewalatheapp.core.tasks;

import android.content.Context;
import android.content.Intent;

/**
 * @author Harvinder_Sidhu
 */
public class DelayedHandler implements Runnable {
    
    private Context context;
    
    private Class clazz;
    
    public DelayedHandler(Context context, Class clazz) {
        this.context = context;
        this.clazz = clazz;
    }
    
    @Override
    public void run() {
        context.startActivity(new Intent(context, clazz));
    }
    
}
