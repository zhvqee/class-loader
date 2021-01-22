package org.qee.core;

import com.api.Factory;
import com.api.Logger;
import com.api.NamedService;

public class ObjectFactory implements Factory {

    private Logger logger;


    private NamedService namedService;

    public ObjectFactory(Logger logger) {
        this.logger = logger;
    }

    public <T> T getObject(Class<T> clazz, Object object) throws IllegalAccessException, InstantiationException {
        logger.info(clazz);
        System.out.println(" factory->Logger.class.getClassLoader():" + Logger.class.getClassLoader());
        System.out.println("factory->NamedService.class.getClassLoader()" + NamedService.class.getClassLoader());
        namedService = (NamedService) object;
        System.out.println(namedService.named(clazz));
        return clazz.newInstance();
    }
}
