package andersen.course.proxy_cache.service;

public interface IService {

    /**
     * Делает какую-то сложную и долгую работу.
     *
     * @return результат работы
     */
    int doHardWork();

    String doAnotherHardWork();

    int doEasyButLongWork();

}
