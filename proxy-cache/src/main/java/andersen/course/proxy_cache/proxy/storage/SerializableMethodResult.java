package andersen.course.proxy_cache.proxy.storage;

import java.io.Serializable;

/**
 * Сериализуемый(кешируемый) результат метода.
 */
public class SerializableMethodResult implements Serializable {

    /** Ключ сериализации */
    private static final long serialVersionUID = -3694118191467493829L;

    /** Кешируемый результат метода */
    private Object methodResult;

    public SerializableMethodResult(Object aMethodResult) {
        methodResult = aMethodResult;
    }

    public Object getMethodResult() {
        return methodResult;
    }

}
