// Generated by Dagger (https://dagger.dev).
package com.example.instagram.presentation.login;

import com.instagram.domain.interactor.LoginUseCase;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class LoginPresenterImpl_MembersInjector implements MembersInjector<LoginPresenterImpl> {
  private final Provider<LoginUseCase> loginUseCaseProvider;

  public LoginPresenterImpl_MembersInjector(Provider<LoginUseCase> loginUseCaseProvider) {
    this.loginUseCaseProvider = loginUseCaseProvider;
  }

  public static MembersInjector<LoginPresenterImpl> create(
      Provider<LoginUseCase> loginUseCaseProvider) {
    return new LoginPresenterImpl_MembersInjector(loginUseCaseProvider);}

  @Override
  public void injectMembers(LoginPresenterImpl instance) {
    injectLoginUseCase(instance, loginUseCaseProvider.get());
  }

  @InjectedFieldSignature("com.example.instagram.presentation.login.LoginPresenterImpl.loginUseCase")
  public static void injectLoginUseCase(LoginPresenterImpl instance, LoginUseCase loginUseCase) {
    instance.loginUseCase = loginUseCase;
  }
}
