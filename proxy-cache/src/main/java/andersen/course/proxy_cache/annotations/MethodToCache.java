package andersen.course.proxy_cache.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Метка для методов, которые будут кешироваться.
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface MethodToCache {}
