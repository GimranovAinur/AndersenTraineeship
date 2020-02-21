package andersen.course.proxy_cache.proxy;

import java.io.File;
import java.util.Optional;

import andersen.course.proxy_cache.annotations.MethodToCache;
import andersen.course.proxy_cache.proxy.settings.CacheSettings;
import andersen.course.proxy_cache.service.IService;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * Кеширующий прокси.
 */
public class CacheProxy {

    /** Настройки кеширования */
    private CacheSettings settings;

    /** Папка хранения файлов кеша */
    private final File storageFolder;

    public CacheProxy(File aStorageFolder) {
        settings = new CacheSettings();
        storageFolder = Optional.ofNullable(aStorageFolder)
                .orElse(new File(System.getProperty("java.io.tmpdir")));
    }

    /**
     * Создает кеширующий прокси для сервисов.
     *
     * @param aServiceToCache сервис для которого кешируются результаты
     * @return
     */
    public IService cache(IService aServiceToCache) {
        try {
            return new ByteBuddy().subclass(aServiceToCache.getClass())
                    .method(ElementMatchers.isAnnotatedWith(MethodToCache.class))
                    .intercept(MethodDelegation
                            .to(new CacheableMethodIterceptor(settings, storageFolder)))
                    .make().load(this.getClass().getClassLoader()).getLoaded().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println("Не удалось создать объект прокси-класса");
            return null;
        }
    }

    public void changeSettings(CacheSettings aSettings) {
        settings = aSettings;
    }

}
