package com.no4.core.customizeAnnotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 动物名称注解
 * @author MR.Q
 * @date 2019年10月25日 下午4:08:23
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnimalName {
	
    String name() default "犬科类动物";
}
