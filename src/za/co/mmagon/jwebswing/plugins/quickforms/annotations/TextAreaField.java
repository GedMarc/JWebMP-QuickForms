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
public @interface TextAreaField
{
	
	
	public String style() default "";
	
	public String classes() default "";
	
	public String placeholder() default "";
	
	public int minLength() default Integer.MIN_VALUE;
	
	public int maxLength() default Integer.MIN_VALUE;
	
	public String minLengthMessage() default "This fields needs more characters";
	
	public String maxLengthMessage() default "You need to make this entry shorter";
	
	public String requiredMessage() default "This field is required";
	
	public String patternMessage() default "This field doesn't match the required pattern";
	
	public boolean required() default false;
	
	public String regex() default "";
	
	public String regexBind() default "";
	
	public boolean showControlFeedback() default true;
	
}
