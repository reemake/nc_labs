package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation for storing package names
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see injection.Injector
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface Configuration {

    String[] packages();

}
