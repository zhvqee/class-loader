package com.api;

public class NamedService {

    public String named(Class<?> clazz) {
        return clazz.getName();
    }
}
