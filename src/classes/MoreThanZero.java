package classes;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})

public @interface MoreThanZero {
    float value() default 0;

    Class<? extends Exception> exception() default Exception.class;

}
