package andersen.course.proxy_cache.proxy.settings;

import java.util.Optional;

/**
 * Настройки кеширования.
 */
public class CacheSettings {

    /** Тип кеширования */
    private Optional<CachingType> type;

    /** Ключ, по которому будет храниться результат */
    private Optional<String> storageKey;

    public CacheSettings() {
        this(null, null);
    }

    public CacheSettings(CachingType aType) {
        this(aType, null);
    }

    public CacheSettings(CachingType aType, String aStorageKey) {
        type = Optional.ofNullable(aType);
        storageKey = Optional.ofNullable(aStorageKey);
    }

    public CachingType getType() {
        return type.orElse(CachingType.MEMORY);
    }

    public String getStorageKey() {
        return storageKey.orElse("DEFAULT");
    }

}
