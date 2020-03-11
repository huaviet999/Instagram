package com.example.instagram.presentation.home;

import com.example.instagram.presentation.favorite.FavoriteFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = HomeModule_FavoriteFragment.FavoriteFragmentSubcomponent.class)
public abstract class HomeModule_FavoriteFragment {
  private HomeModule_FavoriteFragment() {}

  @Binds
  @IntoMap
  @ClassKey(FavoriteFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      FavoriteFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface FavoriteFragmentSubcomponent extends AndroidInjector<FavoriteFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<FavoriteFragment> {}
  }
}
