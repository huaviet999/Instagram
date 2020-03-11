package com.example.instagram.di;

import com.example.instagram.presentation.home.HomeActivity;
import com.example.instagram.presentation.home.HomeModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = AppBindingModule_HomeActivity.HomeActivitySubcomponent.class)
public abstract class AppBindingModule_HomeActivity {
  private AppBindingModule_HomeActivity() {}

  @Binds
  @IntoMap
  @ClassKey(HomeActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      HomeActivitySubcomponent.Factory builder);

  @Subcomponent(modules = HomeModule.class)
  public interface HomeActivitySubcomponent extends AndroidInjector<HomeActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<HomeActivity> {}
  }
}
