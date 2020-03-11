package com.example.instagram.presentation.home;

import com.example.instagram.presentation.home.fragment.HomeFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = HomeModule_HomeFragment.HomeFragmentSubcomponent.class)
public abstract class HomeModule_HomeFragment {
  private HomeModule_HomeFragment() {}

  @Binds
  @IntoMap
  @ClassKey(HomeFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      HomeFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface HomeFragmentSubcomponent extends AndroidInjector<HomeFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<HomeFragment> {}
  }
}
