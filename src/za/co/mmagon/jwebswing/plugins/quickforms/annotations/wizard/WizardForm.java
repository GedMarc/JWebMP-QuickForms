package za.co.mmagon.jwebswing.plugins.quickforms.annotations.wizard;

import java.lang.annotation.*;

@Target(
		{
				ElementType.TYPE, ElementType.TYPE_USE
				//ElementType.FIELD, ElementType.TYPE_USE
		})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface WizardForm
{
	/**
	 * A designated form name
	 * @return
	 */
	public String formName();
	
	
}
