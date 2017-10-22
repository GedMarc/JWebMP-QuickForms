/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.mmagon.jwebswing.plugins.quickforms.annotations;

import java.lang.annotation.*;

/**
 * @author Marc Magon
 * @since 25 Mar 2017
 */
@Target(
		{
				ElementType.FIELD, ElementType.TYPE_USE
		})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface PasswordField
{


	String style() default "";

	String classes() default "";

	boolean isConfirmPassword() default false;

	String placeholder() default "";

	int minLength() default Integer.MIN_VALUE;

	int maxLength() default Integer.MIN_VALUE;

	String requiredMessage() default "This field is required";

	String minLengthMessage() default "This field needs more characters";

	String maxLengthMessage() default "This field has reached the maximum characters";

	String patternMessage() default "This field doesn't match the required pattern";

	boolean required() default false;

	boolean showControlFeedback() default true;


	String regex() default "";

	String regexBind() default "";
}
