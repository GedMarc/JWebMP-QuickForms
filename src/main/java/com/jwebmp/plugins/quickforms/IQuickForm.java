package com.jwebmp.plugins.quickforms;

import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.plugins.quickforms.annotations.*;

import java.lang.reflect.Field;
import java.util.Optional;

public interface IQuickForm<GROUP>
{
	Optional<LabelField> getLabelFromField(Field field);

	/**
	 * Adds hidden content into the form
	 *
	 * @param field
	 * @param fieldGroup
	 *
	 * @return
	 */
	IComponentHierarchyBase<?,?> buildSubmitButton(Field field, SubmitButtonField annotation, GROUP fieldGroup);

	/**
	 * Adds hidden content into the form
	 *
	 * @param field
	 * @param fieldGroup
	 *
	 * @return
	 */
	IComponentHierarchyBase<?,?> buildCancelButton(Field field, CancelButtonField annotation, GROUP fieldGroup);

	/**
	 * Adds hidden content into the form
	 *
	 * @param field
	 * @param fieldGroup
	 *
	 * @return
	 */
	IComponentHierarchyBase<?,?> buildResetButton(Field field, ResetButtonField annotation, GROUP fieldGroup);
}
