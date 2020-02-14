package com.example.instagram.presentation.base;

public interface BasePresenter<T> {
    void takeView(T view);
    void dropView();
}
