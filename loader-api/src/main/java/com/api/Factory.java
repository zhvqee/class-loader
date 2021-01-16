package com.api;

public interface Factory {

    <T> T getObject(Class<T> clazz) throws IllegalAccessException, InstantiationException;
}
