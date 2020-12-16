/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.plugins.quickforms.annotations.search;

import com.jwebmp.core.plugins.ComponentInformation;

import java.lang.annotation.*;

/**
 * Marker to cover an input field with a given mask
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@ComponentInformation(name = "Marker to cover an input field with a given mask",description = "Marker to cover an input field with a given mask")
public @interface Mask
{
	/**
	 * A character to use if a mask string is not specified
	 *
	 * @return
	 */
	char maskCharacter() default '*';

	/**
	 * Number of characters to use or any negative number to use the length of the value
	 *
	 * @return
	 */
	int maskCharacters() default -1;

	/**
	 * An empty string to use the character settings or a fixed mask
	 *
	 * @return
	 */
	String maskString() default "";
}
