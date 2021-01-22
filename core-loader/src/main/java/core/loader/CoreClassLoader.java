package core.loader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class CoreClassLoader extends URLClassLoader {

    private String path = "org.qee.core";

    private String location = "/Users/zhuqi/Documents/code";

    public CoreClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public CoreClassLoader(URL[] urls) {
        super(urls);
    }

    public CoreClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> loadedClass = findLoadedClass(name);
        if (loadedClass != null) {
            return loadedClass;
        }
        if (name.startsWith(path)) {
            Class<?> aClass = findClass(name);
            if (aClass != null) {
                return aClass;
            }
        }
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String className = name.replace(".", "/") + ".class";
        File dir = new File(location);
        File[] files = dir.listFiles();
        if (files == null) {
            return null;
        }
        for (File file : files) {
            try {
                JarFile jarFile = new JarFile(file);
                Enumeration<JarEntry> entries = jarFile.entries();
                while (entries.hasMoreElements()) {
                    JarEntry jarEntry = entries.nextElement();
                    if (jarEntry.getName().equals(className)) {
                        InputStream inputStream = jarFile.getInputStream(jarEntry);

                        byte[] bytes = new byte[2048];
                        int read = inputStream.read(bytes);
                        return defineClass(name, bytes, 0, read);
                    }
                }
                jarFile.close();
            } catch (IOException e) {
            }
        }
        return super.findClass(name);
    }
}
