package com.service.provider;

import com.api.Factory;

public class ServiceProvider {

    /**
     * 加载特定的Factory
     * className 通过类名去加载指定的实现
     *
     * @return
     */
    public static Factory load(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("当前加载类[" + className + "]的加载器是" + classLoader);
        Class<?> targetClazz = classLoader.loadClass(className);
        return (Factory) targetClazz.newInstance();

    }
}
