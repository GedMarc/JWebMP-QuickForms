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
@ComponentInformation(name = "Configures a field as an switch field",description = "Configures a field as an switch field")
public @interface SwitchField
{

	String style() default "";

	String classes() default "";

	String requiredMessage() default "This field is required";

	String patternMessage() default "This field doesn't match the required pattern";

	boolean required() default false;

	boolean showControlFeedback() default true;

	String onText() default "";

	String offText() default "";

	String regex() default "";

	String regexBind() default "";
}
