package loader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class CoreClassLoader extends URLClassLoader {

    private static String location = "/Users/zhuqi/Documents/workspace/class-loader/product-spi-impl/target/";


    public static ClassLoader getClassLoader() throws MalformedURLException {

        File file = new File(location);
        File[] files = file.listFiles();

        List<URL> urls = new ArrayList<URL>();
        for (File target : files) {
            URL url = target.toURI().toURL();
            urls.add(url);
        }
        return new CoreClassLoader(urls.toArray(new URL[0]));
    }


    private CoreClassLoader(URL[] urls) {
        super(urls);
    }

}
