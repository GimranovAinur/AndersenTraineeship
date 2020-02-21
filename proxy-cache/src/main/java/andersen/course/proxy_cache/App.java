package andersen.course.proxy_cache;

import java.net.URISyntaxException;

import andersen.course.proxy_cache.proxy.CacheProxy;
import andersen.course.proxy_cache.proxy.settings.CacheSettings;
import andersen.course.proxy_cache.proxy.settings.CachingType;
import andersen.course.proxy_cache.service.IService;
import andersen.course.proxy_cache.service.ServiceImpl;

public class App {

    public static void main(String[] args) throws URISyntaxException {
        CacheProxy proxy = new CacheProxy(null);
        proxy.changeSettings(new CacheSettings(CachingType.MEMORY));
        IService service = new ServiceImpl();
        IService proxyService = proxy.cache(service);

        int i = proxyService.doHardWork();

        System.out.println(i);

        int a = proxyService.doHardWork();

        String b = proxyService.doAnotherHardWork();

        System.out.println(a);
    }
}
