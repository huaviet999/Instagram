// Generated by Dagger (https://dagger.dev).
package com.example.instagram.presentation.register;

import com.example.instagram.presentation.base.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RegisterActivity_MembersInjector implements MembersInjector<RegisterActivity> {
  private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

  private final Provider<RegisterContract.Presenter> presenterProvider;

  public RegisterActivity_MembersInjector(
      Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider,
      Provider<RegisterContract.Presenter> presenterProvider) {
    this.androidInjectorProvider = androidInjectorProvider;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<RegisterActivity> create(
      Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider,
      Provider<RegisterContract.Presenter> presenterProvider) {
    return new RegisterActivity_MembersInjector(androidInjectorProvider, presenterProvider);}

  @Override
  public void injectMembers(RegisterActivity instance) {
    BaseActivity_MembersInjector.injectAndroidInjector(instance, androidInjectorProvider.get());
    injectPresenter(instance, presenterProvider.get());
  }

  @InjectedFieldSignature("com.example.instagram.presentation.register.RegisterActivity.presenter")
  public static void injectPresenter(RegisterActivity instance,
      RegisterContract.Presenter presenter) {
    instance.presenter = presenter;
  }
}