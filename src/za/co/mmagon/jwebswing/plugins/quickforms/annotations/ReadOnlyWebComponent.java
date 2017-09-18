package za.co.mmagon.jwebswing.plugins.quickforms.annotations;


import java.lang.annotation.*;

@Target(
		{
				ElementType.FIELD, ElementType.TYPE_USE
		})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ReadOnlyWebComponent
{
	

}
