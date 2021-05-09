package com.smz.springbootdemo.test.compnentscan;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;

@Import(ImportedByAnotationBean.class)
public @interface ImportedInteface {
    Class<?>[] exclude1() default {};
    String[] names() default {};
    String value() default "";
}
