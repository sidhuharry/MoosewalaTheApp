package com.sidhuharry.moosewalatheapp.presentor;

import android.content.Context;

import com.sidhuharry.moosewalatheapp.core.StringUtil;
import com.sidhuharry.moosewalatheapp.interactor.LanguageSelectionInteractor;
import com.sidhuharry.moosewalatheapp.router.IRouter;

import javax.inject.Inject;

/**
 * @author Harvinder_Sidhu
 */
public class LanguageSelectionPresenter {
    
    private LanguageSelectionInteractor languageSelectionInteractor;
    
    private IRouter languageSelectionRouter;
    
    private String userLocaleString;
    
    @Inject
    public LanguageSelectionPresenter(LanguageSelectionInteractor languageSelectionInteractor, IRouter languageSelectionRouter, String userLocaleString) {
        this.languageSelectionRouter = languageSelectionRouter;
        this.userLocaleString = userLocaleString;
        this.languageSelectionInteractor = languageSelectionInteractor;
    }
    
    public void onCreate(Context activityContext) {
        if (!StringUtil.isEmpty(userLocaleString)) {
            languageSelectionRouter.nextScreen(activityContext, null);
        }
    }
    
    public void onPaBtnClick(Context activityContext, String paLangCode) {
        languageSelectionInteractor.switchLanguage(paLangCode);
        languageSelectionRouter.nextScreen(activityContext, null);
    }
    
    public void onEnBtnClick(Context activityContext, String enLangCode) {
        languageSelectionInteractor.switchLanguage(enLangCode);
        languageSelectionRouter.nextScreen(activityContext, null);
    }
    
}
