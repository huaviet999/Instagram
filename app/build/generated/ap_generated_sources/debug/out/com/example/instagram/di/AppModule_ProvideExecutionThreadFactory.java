// Generated by Dagger (https://dagger.dev).
package com.example.instagram.di;

import com.instagram.domain.executor.ExecutionThread;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideExecutionThreadFactory implements Factory<ExecutionThread> {
  private final AppModule module;

  public AppModule_ProvideExecutionThreadFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public ExecutionThread get() {
    return provideExecutionThread(module);
  }

  public static AppModule_ProvideExecutionThreadFactory create(AppModule module) {
    return new AppModule_ProvideExecutionThreadFactory(module);
  }

  public static ExecutionThread provideExecutionThread(AppModule instance) {
    return Preconditions.checkNotNull(instance.provideExecutionThread(), "Cannot return null from a non-@Nullable @Provides method");
  }
}