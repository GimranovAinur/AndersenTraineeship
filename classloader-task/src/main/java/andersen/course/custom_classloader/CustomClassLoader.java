package andersen.course.custom_classloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Загрузчик классов.
 */
public class CustomClassLoader extends ClassLoader {

    /** Кэш классов из jar-файла */
    private Map<String, Class<?>> classesCache = new HashMap<>();

    public CustomClassLoader() {
	super(ClassLoader.getSystemClassLoader());
    }

    public CustomClassLoader(Path aJarFilePath) {
	super(ClassLoader.getSystemClassLoader());
        extractClasses(aJarFilePath);
    }

    @Override
    public Class<?> findClass(String className) {
        Class<?> clazz = classesCache.get(className);
        if (clazz == null) {
            byte[] bt;
            try {
                bt = getClassBytes(getClass().getClassLoader()
                        .getResourceAsStream(className.replace(".", "/") + ".class"));
                clazz = defineClass(className, bt, 0, bt.length);
            } catch (IOException e) {
		return super.findClass(className);
                System.err.println("Не удалось найти файл класса");
            }
        }

        return clazz;
    }

    /**
     * Извлекает классы из jar-файла.
     *
     * @param aJarFilePath путь Jar-файла
     */
    private void extractClasses(Path aJarFilePath) {
        try (JarFile jarFile = new JarFile(aJarFilePath.toString());) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (entry.getName().endsWith(".class")) {
                    try (InputStream inputStream = jarFile.getInputStream(entry)) {
                        String className =
                                entry.getName().substring(0, entry.getName().length() - 6);
                        className = className.replace('/', '.');
                        byte[] classBytes = getClassBytes(jarFile.getInputStream(entry));
                        classesCache.put(className,
                                defineClass(className, classBytes, 0, classBytes.length));
                    } catch (IOException ioException) {
                        System.err.println("Не удаелось получить класс " + entry.getName());
                    }
                }

            }
        } catch (IOException e) {
            System.err.println("Не удалось извлечь данные из jar-файла");
        }

    }

    /**
     * Возвращает данные класса в виде массива байт.
     *
     * @param is поток ввода
     * @return данные класса в виде массива байт
     * @throws IOException при ошибке ввода
     */
    private static byte[] getClassBytes(InputStream is) throws IOException {
        try (ByteArrayOutputStream os = new ByteArrayOutputStream();) {
            byte[] buffer = new byte[0xFFFF];
            for (int len; (len = is.read(buffer)) != -1;)
                os.write(buffer, 0, len);
            os.flush();
            return os.toByteArray();
        }
    }

}
