// Generated by Dagger (https://dagger.dev).
package com.example.instagram.presentation.home.fragment;

import dagger.internal.Factory;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HomeFragmentPresenterImpl_Factory implements Factory<HomeFragmentPresenterImpl> {
  @Override
  public HomeFragmentPresenterImpl get() {
    return newInstance();
  }

  public static HomeFragmentPresenterImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static HomeFragmentPresenterImpl newInstance() {
    return new HomeFragmentPresenterImpl();
  }

  private static final class InstanceHolder {
    private static final HomeFragmentPresenterImpl_Factory INSTANCE = new HomeFragmentPresenterImpl_Factory();
  }
}
