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
@ComponentInformation(name = "Configures a field as a checkbox",description = "Configures a field as a checkbox")
public @interface CheckboxField
{
	String style() default "";

	String classes() default "";

	boolean showControlFeedback() default true;

	String requiredMessage() default "This field is required";

	String patternMessage() default "This field doesn't match the required pattern";

	boolean required() default false;

}
