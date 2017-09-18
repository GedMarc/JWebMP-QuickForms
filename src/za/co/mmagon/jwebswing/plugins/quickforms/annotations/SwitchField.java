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
public @interface SwitchField
{
	
	
	public String style() default "";
	
	public String classes() default "";
	
	public String requiredMessage() default "This field is required";
	
	public String patternMessage() default "This field doesn't match the required pattern";
	
	public boolean required() default false;
	
	public boolean showControlFeedback() default true;
	
	public String onText() default "";
	
	public String offText() default "";

	public String regex() default "";
	
	public String regexBind() default "";
}
