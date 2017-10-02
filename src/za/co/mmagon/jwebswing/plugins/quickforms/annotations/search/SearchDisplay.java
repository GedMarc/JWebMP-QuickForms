package za.co.mmagon.jwebswing.plugins.quickforms.annotations.search;

import java.lang.annotation.*;

@Target(
		{
				ElementType.FIELD
		})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
/**
 * Marker to denote that the field must be displayed on the search screen
 */
public @interface SearchDisplay
{
	public String columnHeader();
	public int columnOrder() default 0;
	
}
