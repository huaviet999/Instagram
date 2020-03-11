// Generated by Dagger (https://dagger.dev).
package com.example.instagram.presentation.home.fragment;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HomeFragment_MembersInjector implements MembersInjector<HomeFragment> {
  private final Provider<HomeFragmentContract.Presenter> presenterProvider;

  public HomeFragment_MembersInjector(Provider<HomeFragmentContract.Presenter> presenterProvider) {
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<HomeFragment> create(
      Provider<HomeFragmentContract.Presenter> presenterProvider) {
    return new HomeFragment_MembersInjector(presenterProvider);}

  @Override
  public void injectMembers(HomeFragment instance) {
    injectPresenter(instance, presenterProvider.get());
  }

  @InjectedFieldSignature("com.example.instagram.presentation.home.fragment.HomeFragment.presenter")
  public static void injectPresenter(HomeFragment instance,
      HomeFragmentContract.Presenter presenter) {
    instance.presenter = presenter;
  }
}