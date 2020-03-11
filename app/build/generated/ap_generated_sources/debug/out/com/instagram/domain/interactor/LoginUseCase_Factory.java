// Generated by Dagger (https://dagger.dev).
package com.instagram.domain.interactor;

import com.instagram.domain.executor.ExecutionThread;
import com.instagram.domain.repository.AccountInfoRepository;
import com.instagram.domain.repository.AuthenticationRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class LoginUseCase_Factory implements Factory<LoginUseCase> {
  private final Provider<ExecutionThread> executionThreadProvider;

  private final Provider<AuthenticationRepository> authenticationRepositoryProvider;

  private final Provider<AccountInfoRepository> accountInfoRepositoryProvider;

  public LoginUseCase_Factory(Provider<ExecutionThread> executionThreadProvider,
      Provider<AuthenticationRepository> authenticationRepositoryProvider,
      Provider<AccountInfoRepository> accountInfoRepositoryProvider) {
    this.executionThreadProvider = executionThreadProvider;
    this.authenticationRepositoryProvider = authenticationRepositoryProvider;
    this.accountInfoRepositoryProvider = accountInfoRepositoryProvider;
  }

  @Override
  public LoginUseCase get() {
    return newInstance(executionThreadProvider.get(), authenticationRepositoryProvider.get(), accountInfoRepositoryProvider.get());
  }

  public static LoginUseCase_Factory create(Provider<ExecutionThread> executionThreadProvider,
      Provider<AuthenticationRepository> authenticationRepositoryProvider,
      Provider<AccountInfoRepository> accountInfoRepositoryProvider) {
    return new LoginUseCase_Factory(executionThreadProvider, authenticationRepositoryProvider, accountInfoRepositoryProvider);
  }

  public static LoginUseCase newInstance(ExecutionThread executionThread,
      AuthenticationRepository authenticationRepository,
      AccountInfoRepository accountInfoRepository) {
    return new LoginUseCase(executionThread, authenticationRepository, accountInfoRepository);
  }
}