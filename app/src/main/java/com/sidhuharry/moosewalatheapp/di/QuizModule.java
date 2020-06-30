
package com.sidhuharry.moosewalatheapp.di;

import com.sidhuharry.moosewalatheapp.logic.QuizController;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Harvinder_Sidhu
 */
@Module
public class QuizModule {
    
    @Singleton
    @Provides
    QuizController provideQuizController() {
        return new QuizController();
    }
    
}
