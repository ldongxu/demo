package com.ldongxu.learn.guice.inject;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by 刘东旭 on 2017/7/17.
 */
@Retention(RUNTIME)
@Target({FIELD,PARAMETER})
@BindingAnnotation
public @interface Www {
}
