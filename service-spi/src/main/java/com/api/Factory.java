package com.api;

import com.core.ObjectModel;

public interface Factory {

    <T> T getObject(Class<T> clazz) throws IllegalAccessException, InstantiationException;


    ObjectModel getObjectModel(Class<?> clazz);
}
