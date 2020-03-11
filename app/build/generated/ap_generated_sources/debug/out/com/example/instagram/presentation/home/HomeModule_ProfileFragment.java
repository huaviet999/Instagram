package com.example.instagram.presentation.home;

import com.example.instagram.presentation.profile.ProfileFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = HomeModule_ProfileFragment.ProfileFragmentSubcomponent.class)
public abstract class HomeModule_ProfileFragment {
  private HomeModule_ProfileFragment() {}

  @Binds
  @IntoMap
  @ClassKey(ProfileFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ProfileFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface ProfileFragmentSubcomponent extends AndroidInjector<ProfileFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ProfileFragment> {}
  }
}
