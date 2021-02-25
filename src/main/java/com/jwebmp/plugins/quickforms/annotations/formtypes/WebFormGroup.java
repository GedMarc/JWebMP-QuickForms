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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jwebmp.plugins.quickforms.annotations.formtypes;

import com.jwebmp.core.plugins.ComponentInformation;

import java.lang.annotation.*;

/**
 * @author GedMarc
 * @since 25 Mar 2017
 */
@Target({ElementType.TYPE, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@ComponentInformation(name = "Configures a Form Group",description = "Apply configurations to the form group")
public @interface WebFormGroup
{

	/**
	 * If the form group is inline
	 *
	 * @return
	 */
	boolean inline() default false;

	/**
	 * Any additional styles to add
	 *
	 * @return
	 */
	String style() default "";

	/**
	 * Any additional classes to add
	 *
	 * @return
	 */
	String classes() default "";
}
