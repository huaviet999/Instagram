package com.example.instagram.di;

import com.example.instagram.presentation.add.AddActivity;
import com.example.instagram.presentation.add.AddModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = AppBindingModule_AddActivity.AddActivitySubcomponent.class)
public abstract class AppBindingModule_AddActivity {
  private AppBindingModule_AddActivity() {}

  @Binds
  @IntoMap
  @ClassKey(AddActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      AddActivitySubcomponent.Factory builder);

  @Subcomponent(modules = AddModule.class)
  public interface AddActivitySubcomponent extends AndroidInjector<AddActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<AddActivity> {}
  }
}
