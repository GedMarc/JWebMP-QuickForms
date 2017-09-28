package za.co.mmagon.jwebswing.plugins.quickforms.annotations.formtypes;

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
}
