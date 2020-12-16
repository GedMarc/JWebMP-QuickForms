/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jwebmp.plugins.quickforms.annotations.states;

import com.jwebmp.core.plugins.ComponentInformation;

import java.lang.annotation.*;

/**
 * Instructs the form renderer to ignore the field
 *
 * @author GedMarc
 * @since 26 April 2018
 */
@Target({ElementType.FIELD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@ComponentInformation(name = "Marks a field as explicitly ignored",description = "Marks a field as explicitly ignored")
public @interface WebIgnore
{

}
