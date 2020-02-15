package com.example.instagram.presentation.base;

public interface ItemClickListener<T> {
    void onClickListener(int position , T t);
    void onLongClickListener(int position,T t);
}
