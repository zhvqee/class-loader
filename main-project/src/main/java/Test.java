import com.api.Factory;
import com.api.Logger;
import core.loader.CoreClassLoader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        CoreClassLoader coreClassLoader = new CoreClassLoader(new URL[0]);

        Thread.currentThread().setContextClassLoader(coreClassLoader);
        Class<?> aClass1 = coreClassLoader.loadClass("org.qee.core.ObjectFactory");

        System.out.println(" main->Logger.class.getClassLoader():" + Logger.class.getClassLoader());

        Logger logger = new LoggerImpl();
        System.out.println(" main->LoggerImpl.class.getClassLoader():" + logger.getClass().getClassLoader());
        Constructor<?> constructor = aClass1.getConstructor(Logger.class);
        Factory factory = (Factory) constructor.newInstance(logger);

        User user = factory.getObject(User.class);
        user.setName("abc");
        System.out.println(user);
        System.out.println(user.getClass().getClassLoader());

    }
}
