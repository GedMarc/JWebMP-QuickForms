/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.mmagon.jwebswing.plugins.quickforms.annotations.formtypes;

import java.lang.annotation.*;

/**
 * @author Marc Magon
 * @since 25 Mar 2017
 */
@Target(
		{
				ElementType.TYPE, ElementType.TYPE_USE
				//ElementType.FIELD, ElementType.TYPE_USE
		})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface WebForm
{
	
	public String formName();
	
	public boolean inline() default false;

	public String style() default "";
	
	public String classes() default "";
	
	public boolean showControlFeedback() default true;
}
