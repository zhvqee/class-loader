import com.api.Factory;
import com.core.ObjectModel;
import com.service.provider.ServiceProvider;
import loader.CoreClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class Test {


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, MalformedURLException, NoSuchMethodException, InvocationTargetException {
        // className :
        Thread.currentThread().setContextClassLoader(CoreClassLoader.getClassLoader());
        Factory factory = ServiceProvider.load("core.spi.impl.ObjectFactory");
        User user = factory.getObject(User.class);
        user.setName("name");

        ObjectModel objectModel = factory.getObjectModel(User.class);
        System.out.println(objectModel);

        Method getObject = objectModel.getClass().getMethod("getObject");
        User user1 = (User) getObject.invoke(objectModel);
        System.out.println(ObjectModel.class.getClassLoader());
        System.out.println(objectModel.getClass().getClassLoader());
        System.out.println(user1);
        System.out.println(user);
    }
}
