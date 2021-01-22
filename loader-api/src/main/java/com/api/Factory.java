package com.api;

public interface Factory {

    <T> T getObject(Class<T> clazz, Object object) throws IllegalAccessException, InstantiationException;
}
