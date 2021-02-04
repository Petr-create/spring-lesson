package ru.itsjava.annotations;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
//ElementType.Type - где можно ставить аннотацию (везде)
@Retention(RetentionPolicy.RUNTIME)
//пользоваться во время выполнения программы
//Аннотации ставим от более общего к более частному (стратегия выставления аннотаций)
public @interface MyAnnotation {
    String message();
    boolean isFlag() default true;
}
