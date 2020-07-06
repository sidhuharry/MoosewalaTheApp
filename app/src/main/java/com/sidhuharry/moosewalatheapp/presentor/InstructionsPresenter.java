
package com.sidhuharry.moosewalatheapp.presentor;

import android.content.Context;

import com.sidhuharry.moosewalatheapp.router.IRouter;

import javax.inject.Inject;

/**
 * @author Harvinder_Sidhu
 */
public class InstructionsPresenter {
    
    private IRouter instructionsRouter;
    
    @Inject
    public InstructionsPresenter(IRouter instructionsRouter) {
        this.instructionsRouter = instructionsRouter;
    }
    
    public void onClickStart(Context activityContext) {
        instructionsRouter.nextScreen(activityContext, null);
    }
    
}
