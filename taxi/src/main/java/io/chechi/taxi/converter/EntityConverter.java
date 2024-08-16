package io.chechi.taxi.converter;

public interface EntityConverter<T, R, E> {
    T create(R request);
    E toResponse(T entity);
}


