/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jwebmp.plugins.quickforms.annotations;

import com.jwebmp.core.plugins.ComponentInformation;

import java.lang.annotation.*;

/**
 * @author GedMarc
 * @since 25 Mar 2017
 */
@Target({ElementType.FIELD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@ComponentInformation(name = "Configures a field as an number",description = "Configures a field as an number")
public @interface NumberField
{

	String style() default "";

	String classes() default "";

	String requiredMessage() default "This field is required";

	String patternMessage() default "This field doesn't match the required pattern";

	boolean required() default false;

	int precision() default 0;

	int scale() default -1;

	int minimumValue() default Integer.MIN_VALUE;

	int maximumValue() default Integer.MIN_VALUE;

	boolean showControlFeedback() default true;

	String regex() default "";

	String regexBind() default "";
}
