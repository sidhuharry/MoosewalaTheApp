
package com.sidhuharry.moosewalatheapp.di;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * @author Harvinder_Sidhu
 */
@Component(modules = {AndroidInjectionModule.class, QuizModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {
    
    @Override
    void inject(DaggerApplication instance);
    
    @Component.Builder
    interface Builder {
        
        @BindsInstance
        Builder application(DaggerApplication application);
        
        AppComponent build();
        
    }
    
}
