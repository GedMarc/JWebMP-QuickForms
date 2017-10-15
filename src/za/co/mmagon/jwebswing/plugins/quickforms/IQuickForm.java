package za.co.mmagon.jwebswing.plugins.quickforms;

import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.plugins.quickforms.annotations.*;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * This interface defines all the possibile renders for the default quick form
 * @param <E> The serializable object for building on
 * @param <G> The group component type for the input
 * @param <J> This class for CRP
 */
public interface IQuickForm<E extends Serializable, G extends ComponentHierarchyBase, J extends IQuickForm<E, G,J>>
{
	/**
	 * Renders a text field in the group with the given annotation
	 * @param field
	 * @param anno
	 * @param fieldGroup
	 * @return
	 */
	QuickFormFieldGroup<G,? extends QuickFormFieldGroup> buildTextField(Field field, TextField anno, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> fieldGroup);
	
	/**
	 * Rendersa a date tieme picker in the group for the given annotation
	 * @param field
	 * @param anno
	 * @param fieldGroup
	 * @return
	 */
	QuickFormFieldGroup<G,? extends QuickFormFieldGroup> buildDateTimePicker(Field field, DateTimePickerField anno, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> fieldGroup);
	
	/**
	 * Renders a date picker
	 * @param field
	 * @param anno
	 * @param fieldGroup
	 * @return
	 */
	QuickFormFieldGroup<G,? extends QuickFormFieldGroup> buildDatePicker(Field field, DatePickerField anno, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> fieldGroup);
	
	/**
	 * Renders an email field
	 * @param field
	 * @param anno
	 * @param fieldGroup
	 * @return
	 */
	QuickFormFieldGroup<G,? extends QuickFormFieldGroup> buildEmailField(Field field, EmailField anno, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> fieldGroup);
	
	/**
	 * Renders a sub header field
	 * @param field
	 * @param anno
	 * @param fieldGroup
	 * @return
	 */
	QuickFormFieldGroup<G,? extends QuickFormFieldGroup> buildSubHeaderField(Field field, SubHeaderField anno, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> fieldGroup);
	
	/**
	 * Renders a default header (H tag) field
	 * @param field
	 * @param anno
	 * @param fieldGroup
	 * @return
	 */
	QuickFormFieldGroup<G,? extends QuickFormFieldGroup> buildHeaderField(Field field, HeaderField anno, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> fieldGroup);
	
	/**
	 * Renders a form label for the given group
	 * @param field
	 * @param label
	 * @param fieldGroup
	 * @return
	 */
	QuickFormFieldGroup<G,? extends QuickFormFieldGroup> buildFieldLabel(Field field, LabelField label, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> fieldGroup);
	
	/**
	 * Renders a default password field with the given annotation
	 * @param field
	 * @param anno
	 * @param fieldGroup
	 * @return
	 */
	QuickFormFieldGroup<G,? extends QuickFormFieldGroup> buildPasswordField(Field field, PasswordField anno, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> fieldGroup);
	
	/**
	 * Renders a default colour field selector with the given annotation
	 * @param field
	 * @param fieldGroup
	 * @return
	 */
	QuickFormFieldGroup<G,? extends QuickFormFieldGroup> buildColourField(Field field, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> fieldGroup);
	
	/**
	 * Renders a checkbox with the given annotation
	 * @param field
	 * @param anno
	 * @param fieldGroup
	 * @return
	 */
	QuickFormFieldGroup<G,? extends QuickFormFieldGroup> buildCheckboxField(Field field, SwitchField anno, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> fieldGroup);
	
	/**
	 * Renders a default file uploader with the given group and annotation
	 * @param field
	 * @param fieldGroup
	 * @return
	 */
	QuickFormFieldGroup<G,? extends QuickFormFieldGroup> buildFileUploadField(Field field, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> fieldGroup);
	
	/**
	 * Renders a default radio field with the group for the annotation
	 * @param field
	 * @param fieldGroup
	 * @return
	 */
	QuickFormFieldGroup<G,? extends QuickFormFieldGroup> buildRadioField(Field field, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> fieldGroup);
	
	/**
	 * Renders a search field with the given group
	 * @param field
	 * @param fieldGroup
	 * @return
	 */
	QuickFormFieldGroup<G,? extends QuickFormFieldGroup> buildSearchField(Field field, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> fieldGroup);
	
	/**
	 * Renders a switch field for the given group
	 * @param field
	 * @param anno
	 * @param fieldGroup
	 * @return
	 */
	QuickFormFieldGroup<G,? extends QuickFormFieldGroup> buildSwitchField(Field field, SwitchField anno, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> fieldGroup);
	
	/**
	 * Renders a select drop down field with the given selector
	 * @param field
	 * @param anno
	 * @param fieldGroup
	 * @return
	 */
	QuickFormFieldGroup<G,? extends QuickFormFieldGroup> buildSelectDropDownField(Field field, SelectField anno, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> fieldGroup);
	
	/**
	 * Renders a select field with the given annotation
	 * @param field
	 * @param anno
	 * @param fieldGroup
	 * @return
	 */
	QuickFormFieldGroup<G,? extends QuickFormFieldGroup> buildSelectField(Field field, SelectField anno, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> fieldGroup);
	
	/**
	 * Renders a telephone entry with the given annotation
	 * @param field
	 * @param anno
	 * @param fieldGroup
	 * @return
	 */
	QuickFormFieldGroup<G,? extends QuickFormFieldGroup> buildTelephoneField(Field field, TelephoneField anno, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> fieldGroup);
	
	/**
	 * Renders a default text area with the given annotation
	 * @param field
	 * @param anno
	 * @param fieldGroup
	 * @return
	 */
	QuickFormFieldGroup<G,? extends QuickFormFieldGroup> buildTextAreaField(Field field, TextAreaField anno, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> fieldGroup);
	
	/**
	 * Renders a number field with the given annotation
	 * @param field
	 * @param anno
	 * @param fieldGroup
	 * @return
	 */
	QuickFormFieldGroup<G,? extends QuickFormFieldGroup> buildNumberField(Field field, NumberField anno, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> fieldGroup);
	
	/**
	 * Renders a number spinner field in the group with the given annotation
	 * @param field
	 * @param anno
	 * @param fieldGroup
	 * @return
	 */
	QuickFormFieldGroup<G,? extends QuickFormFieldGroup> buildNumberSpinnerField(Field field, NumberSpinnerField anno, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> fieldGroup);
	
	/**
	 * Builds a time selector field with the given annotation
	 * @param field
	 * @param fieldGroup
	 * @return
	 */
	QuickFormFieldGroup<G,? extends QuickFormFieldGroup> buildTimeField(Field field,TimePickerField anno, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> fieldGroup);
	
	/**
	 * Builds a default URL with the given annotation in the group.
	 * @param field
	 * @param fieldGroup
	 * @return
	 */
	QuickFormFieldGroup<G,? extends QuickFormFieldGroup> buildUrlField(Field field,UrlField anno, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> fieldGroup);
	
	/**
	 * Adds hidden content into the form
	 * @param field
	 * @param fieldGroup
	 * @return
	 */
	QuickFormFieldGroup<G,? extends QuickFormFieldGroup> buildHiddenField(Field field, HiddenField anno, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> fieldGroup);
}
