package com.jwebmp.plugins.quickforms.annotations.search;

import java.lang.annotation.*;

/**
 * Instructs this quick form to be searchable with the given title
 */
@Target({ElementType.FIELD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Searchable
{
	String title() default "";
}
