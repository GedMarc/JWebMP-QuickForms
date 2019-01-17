/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jwebmp.plugins.quickforms.annotations;

import com.jwebmp.core.events.click.ClickAdapter;

import java.lang.annotation.*;

/**
 * @author GedMarc
 * @since 25 Mar 2017
 */
@Target({ElementType.FIELD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SubmitButtonField
{
	/**
	 * The submit class to fire on
	 *
	 * @return
	 */
	Class<? extends ClickAdapter> eventClass();

	boolean activeOnFormValidationOnly() default true;

	String style() default "";

	String classes() default "";

	String regex() default "";

	String regexBind() default "";

	boolean afterField() default true;
}
