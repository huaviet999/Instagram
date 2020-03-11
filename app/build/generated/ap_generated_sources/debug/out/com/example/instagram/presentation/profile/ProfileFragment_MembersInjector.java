// Generated by Dagger (https://dagger.dev).
package com.example.instagram.presentation.profile;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ProfileFragment_MembersInjector implements MembersInjector<ProfileFragment> {
  private final Provider<ProfileContract.Presenter> presenterProvider;

  public ProfileFragment_MembersInjector(Provider<ProfileContract.Presenter> presenterProvider) {
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<ProfileFragment> create(
      Provider<ProfileContract.Presenter> presenterProvider) {
    return new ProfileFragment_MembersInjector(presenterProvider);}

  @Override
  public void injectMembers(ProfileFragment instance) {
    injectPresenter(instance, presenterProvider.get());
  }

  @InjectedFieldSignature("com.example.instagram.presentation.profile.ProfileFragment.presenter")
  public static void injectPresenter(ProfileFragment instance,
      ProfileContract.Presenter presenter) {
    instance.presenter = presenter;
  }
}
