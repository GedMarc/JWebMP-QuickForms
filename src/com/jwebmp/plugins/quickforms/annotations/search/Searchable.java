package com.jwebmp.plugins.quickforms.annotations.search;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Searchable
{
	String title() default "";
}
