package andersen.course.proxy_cache.service;

import andersen.course.proxy_cache.annotations.MethodToCache;

public class ServiceImpl implements IService {

    @Override
    @MethodToCache
    public int doHardWork() {
        return doEasyButLongWork();
    }

    @MethodToCache
    @Override
    public String doAnotherHardWork() {
        return "Foof";
    }

    @Override
    public int doEasyButLongWork() {
        return 23;
    }

}
