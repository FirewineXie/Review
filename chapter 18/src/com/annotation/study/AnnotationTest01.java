package com.annotation.study;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author Firewine
 * @version : 1.0
 * @auther : Firewine
 * @Program : AnnotationTest01
 * @Create : 2019/12/31
 * @Description :
 *
 * 元注解 ：
 * 作用 ； 就是负责注解其他注解，
 * java定义了meta-annotation 类型，四个，是用来提供对其他annotation类型做说明的
 *
 * Target  用来描述注解的使用范围
 * Retention
 * Documented
 * Inherited
 */
@Target(value = ElementType.METHOD)
public @interface AnnotationTest01 {
}
