package com.sidhuharry.moosewalatheapp.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.sidhuharry.moosewalatheapp.core.AppSharedPreference;
import com.sidhuharry.moosewalatheapp.core.Constants;
import com.sidhuharry.moosewalatheapp.core.QuizController;
import com.sidhuharry.moosewalatheapp.interactor.ImageQuizInteractor;
import com.sidhuharry.moosewalatheapp.interactor.LanguageSelectionInteractor;
import com.sidhuharry.moosewalatheapp.interactor.QuizOptionInteractor;
import com.sidhuharry.moosewalatheapp.interactor.ResultInteractor;
import com.sidhuharry.moosewalatheapp.presentor.ImageQuizPresenter;
import com.sidhuharry.moosewalatheapp.presentor.InstructionsPresenter;
import com.sidhuharry.moosewalatheapp.presentor.LanguageSelectionPresenter;
import com.sidhuharry.moosewalatheapp.presentor.QuizOptionPresenter;
import com.sidhuharry.moosewalatheapp.presentor.ResultPresenter;
import com.sidhuharry.moosewalatheapp.router.IRouter;
import com.sidhuharry.moosewalatheapp.router.ImageQuizRouter;
import com.sidhuharry.moosewalatheapp.router.InstructionsRouter;
import com.sidhuharry.moosewalatheapp.router.LanguageSelectionRouter;
import com.sidhuharry.moosewalatheapp.router.QuizOptionRouter;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Harvinder_Sidhu
 */
@Module
public class MainModule {
    
    @Singleton
    @Provides
    public QuizController provideQuizController() {
        return new QuizController();
    }
    
    @Singleton
    @Provides
    public SharedPreferences provideSharedPreference(Context context) {
        return context.getSharedPreferences(Constants.PERF_NAME, Context.MODE_PRIVATE);
    }
    
    @Singleton
    @Provides
    public AppSharedPreference provideAppSharedPreference(Context context, SharedPreferences sharedPreferences) {
        return new AppSharedPreference(context, sharedPreferences);
    }
    
    @Singleton
    @Provides
    public LanguageSelectionInteractor provideLanguageSelectionInteractor(AppSharedPreference appSharedPreference) {
        return new LanguageSelectionInteractor(appSharedPreference);
    }
    
    @Provides
    public String provideUserLocaleString(AppSharedPreference appSharedPreference) {
        return appSharedPreference.getValue(Constants.USER_LANG);
    }
    
    @Singleton
    @Provides
    @Named("languageSelectionRouter")
    public IRouter provideLanguageSelectionRouter() {
        return new LanguageSelectionRouter();
    }
    
    @Singleton
    @Provides
    public LanguageSelectionPresenter provideLanguageSelectionPresenter(LanguageSelectionInteractor languageSelectionInteractor, String userLocaleString,
                                                                        @Named("languageSelectionRouter") IRouter languageSelectionRouter) {
        return new LanguageSelectionPresenter(languageSelectionInteractor, languageSelectionRouter, userLocaleString);
    }
    
    @Singleton
    @Provides
    @Named("instructionsRouter")
    public IRouter provideInstructionsRouter() {
        return new InstructionsRouter();
    }
    
    @Singleton
    @Provides
    public InstructionsPresenter provideInstructionsPresenter(@Named("instructionsRouter") IRouter instructionsRouter) {
        return new InstructionsPresenter(instructionsRouter);
    }
    
    @Provides
    @Singleton
    @Named("imageQuizRouter")
    public IRouter provideImageQuizRouter() {
        return new ImageQuizRouter();
    }
    
    @Singleton
    @Provides
    public ImageQuizInteractor provideImageQuizInteractor() {
        return new ImageQuizInteractor();
    }
    
    @Singleton
    @Provides
    public ImageQuizPresenter provideImageQuizPresenter(@Named("imageQuizRouter") IRouter imageQuizRouter, ImageQuizInteractor imageQuizInteractor) {
        return new ImageQuizPresenter(imageQuizRouter, imageQuizInteractor);
    }
    
    @Singleton
    @Provides
    public QuizOptionInteractor provideQuizOptionInteractor(QuizController quizController) {
        return new QuizOptionInteractor(quizController);
    }
    
    @Singleton
    @Provides
    @Named("quizOptionRouter")
    public IRouter provideQuizOptionRouter(QuizController quizController) {
        return new QuizOptionRouter(quizController);
    }
    
    @Singleton
    @Provides
    public QuizOptionPresenter provideQuizOptionPresenter(@Named("quizOptionRouter") IRouter quizOptionRouter, QuizOptionInteractor quizOptionInteractor) {
        return new QuizOptionPresenter(quizOptionRouter, quizOptionInteractor);
    }
    
    @Singleton
    @Provides
    public ResultInteractor provideResultInteractor(QuizController quizController) {
        return new ResultInteractor(quizController);
    }
    
    @Singleton
    @Provides
    public ResultPresenter provideResultPresenter(ResultInteractor resultInteractor) {
        return new ResultPresenter(resultInteractor);
    }
    
}