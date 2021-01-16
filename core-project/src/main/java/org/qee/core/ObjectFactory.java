package org.qee.core;

import com.api.Factory;
import com.api.Logger;

public class ObjectFactory implements Factory {

    private Logger logger;

    public ObjectFactory(Logger logger) {
        this.logger = logger;
    }

    public <T> T getObject(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        logger.info(clazz);
        System.out.println(" factory->Logger.class.getClassLoader():" + Logger.class.getClassLoader());
        return clazz.newInstance();
    }
}
