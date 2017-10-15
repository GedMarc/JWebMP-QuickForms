package za.co.mmagon.jwebswing.plugins.quickforms.annotations.search;

import java.lang.annotation.*;

/**
 * Marker to cover an input field with a given mask
 */
@Target(
		{
				ElementType.FIELD
		})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Mask
{
	/**
	 * A character to use if a mask string is not specified
	 * @return
	 */
	public char maskCharacter() default '*';
	
	/**
	 * Number of characters to use or any negative number to use the length of the value
	 * @return
	 */
	public int maskCharacters () default -1;
	
	/**
	 * An empty string to use the character settings or a fixed mask
	 * @return
	 */
	public String maskString() default "";
}
