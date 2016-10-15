package com.mars.tea.springmvc.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {

    String name() default DataSource.core;
    
    public static String core = "dataSourceCore";
 
    public static String security = "dataSourceSecurity";
 
}
