// Generated by Dagger (https://dagger.dev).
package com.example.instagram.presentation.search;

import dagger.internal.Factory;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SearchFragmentPresenterImpl_Factory implements Factory<SearchFragmentPresenterImpl> {
  @Override
  public SearchFragmentPresenterImpl get() {
    return newInstance();
  }

  public static SearchFragmentPresenterImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static SearchFragmentPresenterImpl newInstance() {
    return new SearchFragmentPresenterImpl();
  }

  private static final class InstanceHolder {
    private static final SearchFragmentPresenterImpl_Factory INSTANCE = new SearchFragmentPresenterImpl_Factory();
  }
}
