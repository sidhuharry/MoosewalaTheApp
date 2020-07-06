package com.sidhuharry.moosewalatheapp.presentor;

import com.sidhuharry.moosewalatheapp.interactor.ResultInteractor;
import com.sidhuharry.moosewalatheapp.ui.Result;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

/**
 * @author Harvinder_Sidhu
 */
public class ResultPresenter {
    
    private WeakReference<Result> resultWeakReference;
    
    private ResultInteractor resultInteractor;
    
    @Inject
    public ResultPresenter(ResultInteractor resultInteractor) {
        this.resultInteractor = resultInteractor;
    }
    
    public void setResults() {
        Result resultScreen = resultWeakReference.get();
        if (resultScreen != null) {
            resultScreen.setMedal(resultInteractor.getMedal());
            resultScreen.setScore(resultInteractor.getScore());
        }
    }
    
    public void setResultWeakReference(WeakReference<Result> resultWeakReference) {
        this.resultWeakReference = resultWeakReference;
    }
    
}
