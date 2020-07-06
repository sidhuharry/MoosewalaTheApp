package com.sidhuharry.moosewalatheapp.interactor;

import com.sidhuharry.moosewalatheapp.core.AppSharedPreference;
import com.sidhuharry.moosewalatheapp.core.Constants;
import com.sidhuharry.moosewalatheapp.core.StringUtil;

import javax.inject.Inject;

/**
 * @author Harvinder_Sidhu
 */
public class LanguageSelectionInteractor {
    
    private AppSharedPreference appSharedPreference;
    
    @Inject
    public LanguageSelectionInteractor(AppSharedPreference appSharedPreference) {
        this.appSharedPreference = appSharedPreference;
    }
    
    public void switchLanguage(String langCode) {
        appSharedPreference.updatePerf(Constants.USER_LANG, langCode);
    }
    
    public String getUserLanguage() {
        String val = appSharedPreference.getValue(Constants.USER_LANG);
        return StringUtil.isEmpty(val) ? Constants.PA_LANG_CODE : val;
    }
    
}
