package com.mars.tea.springmvc.annotation;

import static com.mars.tea.springmvc.enums.ElementTypeE.DEFAULTE_ELEMENT;
import static com.mars.tea.springmvc.enums.GroupTypeE.DEFAULTE_GROUP;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.mars.tea.springmvc.enums.ElementTypeE;
import com.mars.tea.springmvc.enums.GroupTypeE;

@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorization {
	
	GroupTypeE group() default DEFAULTE_GROUP;
	
	ElementTypeE element() default DEFAULTE_ELEMENT;

}
