package andersen.course.proxy_cache.proxy.storage;

import java.io.NotSerializableException;

/**
 * Интерфейс кеша.
 */
public interface IStorage {

    /**
     * Возвращает объект из кеша.
     *
     * @param aKey ключ
     * @return закешированный объект
     */
    Object get(String aKey);

    /**
     * Кеширует объект.
     *
     * @param aKey ключ
     * @param aValue объект
     */
    void cache(String aKey, Object aValue) throws NotSerializableException;

    /**
     * Возвращает признак налиия кеша объекта.
     *
     * @param aKey ключ
     * @return {@code true} - объект есть в кеше, иначе - {@code false}
     */
    boolean isCached(String aKey);

}
