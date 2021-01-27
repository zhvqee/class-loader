package loader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 错误样例
 */
public class Core2ClassLoader extends ClassLoader {

    private static String location = "/Users/zhuqi/Documents/workspace/class-loader/product-spi-impl/target/";


    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        File file = new File(location);
        File[] files = file.listFiles();
        if (files == null || files.length == 0) {
            throw new RuntimeException(name + "类加载失败");
        }
        for (File target : files) {
            if (!target.getName().endsWith(".jar")) {
                continue;
            }
            JarFile jarFile = null;
            try {
                jarFile = new JarFile(target);
                String replace = name.replace(".", "/") + ".class";
                JarEntry jarEntry = jarFile.getJarEntry(replace);
                if (jarEntry == null) {
                    break;
                }
                InputStream inputStream = jarFile.getInputStream(jarEntry);
                byte[] bytes = new byte[inputStream.available()];
                inputStream.read(bytes);
                return defineClass(name, bytes, 0, bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (jarFile != null) {
                        jarFile.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(name + "用appclassloader 加载");
        return super.loadClass(name);
    }
}
