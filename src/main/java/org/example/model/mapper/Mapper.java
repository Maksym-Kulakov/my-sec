package org.example.model.mapper;

public interface Mapper<T,Q,S> {
    T toModel(Q q);

    S toDto(T t);
}
