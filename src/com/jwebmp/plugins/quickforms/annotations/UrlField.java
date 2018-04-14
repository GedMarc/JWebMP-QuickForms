/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jwebmp.plugins.quickforms.annotations;

import java.lang.annotation.*;

/**
 * @author Marc Magon
 * @since 25 Mar 2017
 */
@Target({ElementType.FIELD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface UrlField
{


	String style() default "";

	String classes() default "";

	String placeholder() default "";

	int minLength() default Integer.MIN_VALUE;

	int maxLength() default Integer.MIN_VALUE;

	String requiredMessage() default "This field is required";

	String patternMessage() default "This field doesn't match the required pattern";

	boolean required() default false;

	boolean showControlFeedback() default true;


	String regex() default "";

	String regexBind() default "";
}
