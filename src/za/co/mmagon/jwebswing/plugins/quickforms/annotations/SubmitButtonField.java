/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.mmagon.jwebswing.plugins.quickforms.annotations;

import za.co.mmagon.jwebswing.events.click.ClickAdapter;

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
public @interface SubmitButtonField
{
	public Class<? extends ClickAdapter> eventClass();
	
	public String style() default "";
	
	public String classes() default "";
	
	
	public String regex() default "";
	
	public String regexBind() default "";
}
