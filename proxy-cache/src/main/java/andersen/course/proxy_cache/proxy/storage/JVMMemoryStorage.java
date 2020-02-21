package andersen.course.proxy_cache.proxy.storage;

import java.util.HashMap;
import java.util.Map;

/**
 * Кеш результата в памяти JVM.
 */
public class JVMMemoryStorage implements IStorage {

    private final Map<String, Object> storage = new HashMap<>();

    @Override
    public Object get(String aKey) {
        return storage.get(aKey);
    }

    @Override
    public void cache(String aKey, Object aValue) {
        storage.put(aKey, aValue);
    }

    @Override
    public boolean isCached(String aKey) {
        return storage.containsKey(aKey);
    }

}
