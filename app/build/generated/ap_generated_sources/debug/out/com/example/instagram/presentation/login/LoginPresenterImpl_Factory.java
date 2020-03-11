// Generated by Dagger (https://dagger.dev).
package com.example.instagram.presentation.login;

import com.instagram.domain.interactor.LoginUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class LoginPresenterImpl_Factory implements Factory<LoginPresenterImpl> {
  private final Provider<LoginUseCase> loginUseCaseProvider;

  public LoginPresenterImpl_Factory(Provider<LoginUseCase> loginUseCaseProvider) {
    this.loginUseCaseProvider = loginUseCaseProvider;
  }

  @Override
  public LoginPresenterImpl get() {
    LoginPresenterImpl instance = newInstance();
    LoginPresenterImpl_MembersInjector.injectLoginUseCase(instance, loginUseCaseProvider.get());
    return instance;
  }

  public static LoginPresenterImpl_Factory create(Provider<LoginUseCase> loginUseCaseProvider) {
    return new LoginPresenterImpl_Factory(loginUseCaseProvider);
  }

  public static LoginPresenterImpl newInstance() {
    return new LoginPresenterImpl();
  }
}