package za.co.mmagon.jwebswing.plugins.quickforms.annotations.search;

import java.lang.annotation.*;

@Target(
		{
				ElementType.FIELD, ElementType.TYPE_USE
		})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
/**
 * Marker to denote that the field must be displayed on the search screen
 */
public @interface SearchDisplay
{

}
