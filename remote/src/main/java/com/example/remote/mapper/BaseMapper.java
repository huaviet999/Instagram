package com.example.remote.mapper;

public interface BaseMapper<M,E> {
    M mapToModel(E e);
    E mapFromModel(M m);

}
