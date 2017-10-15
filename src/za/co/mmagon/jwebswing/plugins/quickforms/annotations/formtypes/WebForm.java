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
		})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface WebForm
{
	/**
	 * A designated form name
	 * @return
	 */
	public String formName();
	
	/**
	 * If the form is inline
	 * @return
	 */
	public boolean inline() default false;
	
	/**
	 * Any additional styles to add
	 * @return
	 */
	public String style() default "";
	
	/**
	 * Any additional classes to add
	 * @return
	 */
	public String classes() default "";
	
	/**
	 * If this form must register control feedback as true
	 * @return
	 */
	public boolean showControlFeedback() default true;
}
