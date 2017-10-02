package za.co.mmagon.jwebswing.plugins.quickforms.annotations.search;

import java.lang.annotation.*;

@Target(
		{
				ElementType.FIELD, ElementType.TYPE_USE
		})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Searchable
{
	public String title() default "";
}
