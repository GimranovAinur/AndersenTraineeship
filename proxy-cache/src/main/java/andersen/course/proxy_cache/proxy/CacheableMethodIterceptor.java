package andersen.course.proxy_cache.proxy;

import java.io.File;
import java.io.NotSerializableException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

import andersen.course.proxy_cache.proxy.settings.CacheSettings;
import andersen.course.proxy_cache.proxy.storage.FileStorage;
import andersen.course.proxy_cache.proxy.storage.IStorage;
import andersen.course.proxy_cache.proxy.storage.JVMMemoryStorage;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

/**
 * Перехватчик кэшируемых методов.
 */
public class CacheableMethodIterceptor {

    /** Кеш */
    private final IStorage cache;

    /** Настройки кеширования */
    private final CacheSettings settings;

    /** Папка хранения файлов кеша */
    private final File storageFolder;

    public CacheableMethodIterceptor(CacheSettings aSettings, File aStorageFolder) {
        storageFolder = aStorageFolder;
        settings = aSettings;
        switch (settings.getType()) {
        case MEMORY:
            cache = new JVMMemoryStorage();
            break;
        case FILE:
            cache = new FileStorage(storageFolder);
            break;
        default:
            throw new IllegalStateException();
        }
    }

    /**
     * Перехватывает метод для кеширования.
     *
     * @param zuper перехватик родительких вызовов метода
     * @param method перехваченный метод
     * @param args аргументы метода
     * @return результат метода
     * @throws Exception при ошибке кеширования
     */
    @RuntimeType
    public Object intercept(@SuperCall Callable<?> zuper, @Origin Method method,
            @AllArguments Object[] args) throws Exception {
        String key = (settings.getStorageKey().equals("DEFAULT")) ? method.getName()
                : settings.getStorageKey();
        if (cache.isCached(key)) {
            return cache.get(key);
        } else {
            Object value = zuper.call();
            try {
                cache.cache(key, value);
            } catch (NotSerializableException e) {
                System.out.println("Результат не будет кеширован, т.к. он несериализуемый");
            }
            return value;
        }
    }

}
