// Generated by Dagger (https://dagger.dev).
package com.example.instagram.presentation.home;

import dagger.internal.Factory;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HomePresenterImpl_Factory implements Factory<HomePresenterImpl> {
  @Override
  public HomePresenterImpl get() {
    return newInstance();
  }

  public static HomePresenterImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static HomePresenterImpl newInstance() {
    return new HomePresenterImpl();
  }

  private static final class InstanceHolder {
    private static final HomePresenterImpl_Factory INSTANCE = new HomePresenterImpl_Factory();
  }
}