package com.jwebmp.plugins.quickforms;

import com.jwebmp.base.ComponentHierarchyBase;
import com.jwebmp.base.html.interfaces.children.FormChildren;
import com.jwebmp.plugins.quickforms.annotations.*;

import java.lang.reflect.Field;

public interface IQForm<GROUP extends FormChildren>
{
	/**
	 * Renders a text field in the group with the given annotationtation
	 *
	 * @param field
	 * @param annotation
	 * @param fieldGroup
	 *
	 * @return
	 */
	GROUP buildTextField(Field field, TextField annotation, GROUP fieldGroup);

	/**
	 * Rendersa a date tieme picker in the group for the given annotationtation
	 *
	 * @param field
	 * @param annotation
	 * @param fieldGroup
	 *
	 * @return
	 */
	GROUP buildDateTimePicker(Field field, DateTimePickerField annotation, GROUP fieldGroup);

	/**
	 * Renders a date picker
	 *
	 * @param field
	 * @param annotation
	 * @param fieldGroup
	 *
	 * @return
	 */
	GROUP buildDatePicker(Field field, DatePickerField annotation, GROUP fieldGroup);

	/**
	 * Renders an email field
	 *
	 * @param field
	 * @param annotation
	 * @param fieldGroup
	 *
	 * @return
	 */
	GROUP buildEmailField(Field field, EmailField annotation, GROUP fieldGroup);

	/**
	 * Renders a sub header field
	 *
	 * @param field
	 * @param annotation
	 * @param fieldGroup
	 *
	 * @return
	 */
	GROUP buildSubHeaderField(Field field, SubHeaderField annotation, GROUP fieldGroup);

	/**
	 * Renders a default header (H tag) field
	 *
	 * @param field
	 * @param annotation
	 * @param fieldGroup
	 *
	 * @return
	 */
	GROUP buildHeaderField(Field field, HeaderField annotation, GROUP fieldGroup);

	/**
	 * Renders a form label for the given group
	 *
	 * @param field
	 * @param label
	 * @param fieldGroup
	 *
	 * @return
	 */
	GROUP buildFieldLabel(Field field, LabelField label, GROUP fieldGroup);

	/**
	 * Renders a default password field with the given annotationtation
	 *
	 * @param field
	 * @param annotation
	 * @param fieldGroup
	 *
	 * @return
	 */
	GROUP buildPasswordField(Field field, PasswordField annotation, GROUP fieldGroup);

	/**
	 * Renders a default colour field selector with the given annotationtation
	 *
	 * @param field
	 * @param fieldGroup
	 *
	 * @return
	 */
	GROUP buildColourField(Field field, ColorField annotation, GROUP fieldGroup);

	/**
	 * Renders a checkbox with the given annotationtation
	 *
	 * @param field
	 * @param annotation
	 * @param fieldGroup
	 *
	 * @return
	 */
	GROUP buildCheckboxField(Field field, CheckboxField annotation, GROUP fieldGroup);

	/**
	 * Renders a default file uploader with the given group and annotationtation
	 *
	 * @param field
	 * @param fieldGroup
	 *
	 * @return
	 */
	GROUP buildFileUploadField(Field field, FileField annotation, GROUP fieldGroup);

	/**
	 * Renders a default radio field with the group for the annotationtation
	 *
	 * @param field
	 * @param fieldGroup
	 *
	 * @return
	 */
	GROUP buildRadioField(Field field, RadioField annotation, GROUP fieldGroup);

	/**
	 * Renders a search field with the given group
	 *
	 * @param field
	 * @param fieldGroup
	 *
	 * @return
	 */
	GROUP buildSearchField(Field field, SearchField annotation, GROUP fieldGroup);

	/**
	 * Renders a switch field for the given group
	 *
	 * @param field
	 * @param annotation
	 * @param fieldGroup
	 *
	 * @return
	 */
	GROUP buildSwitchField(Field field, SwitchField annotation, GROUP fieldGroup);

	/**
	 * Renders a select field with the given annotationtation
	 *
	 * @param field
	 * @param annotation
	 * @param fieldGroup
	 *
	 * @return
	 */
	GROUP buildSelectField(Field field, SelectField annotation, GROUP fieldGroup);

	/**
	 * Renders a telephone entry with the given annotationtation
	 *
	 * @param field
	 * @param annotation
	 * @param fieldGroup
	 *
	 * @return
	 */
	GROUP buildTelephoneField(Field field, TelephoneField annotation, GROUP fieldGroup);

	/**
	 * Renders a default text area with the given annotationtation
	 *
	 * @param field
	 * @param annotation
	 * @param fieldGroup
	 *
	 * @return
	 */
	GROUP buildTextAreaField(Field field, TextAreaField annotation, GROUP fieldGroup);

	/**
	 * Renders a number field with the given annotationtation
	 *
	 * @param field
	 * @param annotation
	 * @param fieldGroup
	 *
	 * @return
	 */
	GROUP buildNumberField(Field field, NumberField annotation, GROUP fieldGroup);

	/**
	 * Builds a time selector field with the given annotationtation
	 *
	 * @param field
	 * @param fieldGroup
	 *
	 * @return
	 */
	GROUP buildTimeField(Field field, TimePickerField annotation, GROUP fieldGroup);

	/**
	 * Builds a default URL with the given annotationtation in the group.
	 *
	 * @param field
	 * @param fieldGroup
	 *
	 * @return
	 */
	GROUP buildUrlField(Field field, UrlField annotation, GROUP fieldGroup);

	/**
	 * Adds hidden content into the form
	 *
	 * @param field
	 * @param fieldGroup
	 *
	 * @return
	 */
	GROUP buildHiddenField(Field field, HiddenField annotation, GROUP fieldGroup);

	/**
	 * Adds hidden content into the form
	 *
	 * @param field
	 * @param fieldGroup
	 *
	 * @return
	 */
	ComponentHierarchyBase buildSubmitButton(Field field, SubmitButtonField annotation, GROUP fieldGroup);

	/**
	 * Adds hidden content into the form
	 *
	 * @param field
	 * @param fieldGroup
	 *
	 * @return
	 */
	ComponentHierarchyBase buildCancelButton(Field field, CancelButtonField annotation, GROUP fieldGroup);

	/**
	 * Adds hidden content into the form
	 *
	 * @param field
	 * @param fieldGroup
	 *
	 * @return
	 */
	ComponentHierarchyBase buildResetButton(Field field, ResetButtonField annotation, GROUP fieldGroup);
}
