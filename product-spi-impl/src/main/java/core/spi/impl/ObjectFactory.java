package core.spi.impl;

import com.api.Factory;
import com.core.ObjectModel;
import core.business.MethodStatistics;
import core.logger.DefaultLogger;
import core.logger.Logger;

import java.util.UUID;

public class ObjectFactory implements Factory {

    private Logger logger;

    public ObjectFactory() {
        this.logger = new DefaultLogger();
    }

    public <T> T getObject(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        long start = System.nanoTime();
        logger.info(clazz);
        System.out.println(" factory->Logger.class.getClassLoader():" + Logger.class.getClassLoader());
        MethodStatistics methodStatistics = new MethodStatistics(clazz.getName(), "getObject", System.nanoTime() - start);
        System.out.println(methodStatistics.getClassName() + "." + methodStatistics.getMethodName() + ":" + methodStatistics.getCost());
        System.out.println("MethodStatistics:" + MethodStatistics.class.getClassLoader());
        return clazz.newInstance();
    }

    public ObjectModel getObjectModel(Class<?> clazz) {
        String id = UUID.randomUUID().toString();
        try {
            return new SingleObjectModel(id, getObject(clazz));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
