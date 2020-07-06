package com.sidhuharry.moosewalatheapp.di;

import android.content.Context;

import com.sidhuharry.moosewalatheapp.ui.BaseActivity;
import com.sidhuharry.moosewalatheapp.ui.ImageQuiz;
import com.sidhuharry.moosewalatheapp.ui.Instructions;
import com.sidhuharry.moosewalatheapp.ui.LanguageSelection;
import com.sidhuharry.moosewalatheapp.ui.QuizOptions;
import com.sidhuharry.moosewalatheapp.ui.Result;
import com.sidhuharry.moosewalatheapp.ui.Splash;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * @author Harvinder_Sidhu
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, MainModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {
    
    @Override
    void inject(DaggerApplication instance);
    
    void inject(LanguageSelection languageSelection);
    
    void inject(BaseActivity baseActivity);
    
    void inject(Splash splash);
    
    void inject(Instructions instructions);
    
    void inject(ImageQuiz imageQuiz);
    
    void inject(QuizOptions quizOptions);
    
    void inject(Result result);
    
    @Component.Builder
    interface Builder {
        
        @BindsInstance
        Builder application(DaggerApplication application);
        
        @BindsInstance
        Builder setApplicationContext(@Singleton Context context);
        
        AppComponent build();
        
    }
    
}
