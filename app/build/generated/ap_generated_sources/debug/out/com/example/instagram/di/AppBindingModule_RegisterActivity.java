package com.example.instagram.di;

import com.example.instagram.presentation.register.RegisterActivity;
import com.example.instagram.presentation.register.RegisterModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = AppBindingModule_RegisterActivity.RegisterActivitySubcomponent.class)
public abstract class AppBindingModule_RegisterActivity {
  private AppBindingModule_RegisterActivity() {}

  @Binds
  @IntoMap
  @ClassKey(RegisterActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      RegisterActivitySubcomponent.Factory builder);

  @Subcomponent(modules = RegisterModule.class)
  public interface RegisterActivitySubcomponent extends AndroidInjector<RegisterActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<RegisterActivity> {}
  }
}
