package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation for automatic dependency injection into class fields
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see injection.Injector
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface AutoInjectable {}
