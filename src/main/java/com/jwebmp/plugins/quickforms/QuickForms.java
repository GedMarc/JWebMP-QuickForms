package com.jwebmp.plugins.quickforms;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Form;
import com.jwebmp.core.base.html.Input;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.utilities.StaticStrings;
import com.guicedee.logger.LogFactory;
import com.jwebmp.plugins.quickforms.annotations.*;
import com.jwebmp.plugins.quickforms.annotations.states.WebIgnore;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.guicedee.guicedinjection.json.StaticStrings.*;
import static com.jwebmp.core.utilities.StaticStrings.*;

/**
 * Implementation Base for a Quick Form
 *
 * @param <GROUP>
 */
public abstract class QuickForms<GROUP, J extends QuickForms<GROUP, J>>
		extends DivSimple<J>
		implements IQuickForm<GROUP>
{

	private static final Logger log = LogFactory.getLog("QForms");

	/**
	 * The object to work on
	 */
	@NotNull
	private Object object;
	/**
	 * The form that gets built
	 */
	private Form<?> form;

	private boolean readOnlyOverride;
	private boolean renderDefaults;

	/**
	 * Implementation Base for a Quick Form
	 *
	 * @param object
	 */
	public QuickForms(Object object)
	{
		this();
		this.object = object;
	}

	/**
	 * Implementation Base for a Quick Form
	 */
	protected QuickForms()
	{
		form = new Form();
	}

	@Override
	public void init()
	{
		if(!isInitialized())
		{
			addDto(getDtoName(), object);

			Field[] classFields = getObject().getClass()
			                                 .getDeclaredFields();
			List<Field> workableFields = Arrays.asList(classFields);
			workableFields.removeIf(a -> a.isAnnotationPresent(WebIgnore.class));
			workableFields.forEach(field ->
			                       {
			                       	try
			                        {
				                        if (isRenderDefaults())
				                        {
					                        processDefaults(field, null);
				                        }
				                        else
				                        {
					                        processField(field, null);
				                        }
			                        }catch(Throwable T)
			                        {
			                        	log.log(Level.WARNING,"Cannot generate field " + field,T);
			                        }
			                       });
			processButtonEvents();
			add(form);
			super.init();
		}
	}

	/**
	 * Returns the DTO name associated with this form (for sending back to the server)
	 *
	 * @return
	 */
	public String getDtoName()
	{
		return getObject().getClass()
		                  .getCanonicalName()
		                  .replace(CHAR_DOT, CHAR_UNDERSCORE);
	}

	/**
	 * Returns the assigned object
	 *
	 * @return
	 */
	@NotNull
	public Object getObject()
	{
		return object;
	}

	/**
	 * If this form must process all fields with defaults, except for those marked @WebIgnore
	 *
	 * @return
	 */
	public boolean isRenderDefaults()
	{
		return renderDefaults;
	}

	/**
	 * if this form must process all fields with defaults, except for those marked @WebIgnore
	 *
	 * @param renderDefaults
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setRenderDefaults(boolean renderDefaults)
	{
		this.renderDefaults = renderDefaults;
		return (J) this;
	}

	/**
	 * API implementation for when annotations are ignored and field types are used
	 *
	 * @param field
	 * 		The field working on
	 * @param groupContent
	 * 		The group content may be null
	 */
	protected abstract void processDefaults(Field field, GROUP groupContent);

	protected void processField(Field field, GROUP groupContent)
	{
		field.setAccessible(true);
		if (field.isAnnotationPresent(CheckboxField.class))
		{
			CheckboxField lf = field.getDeclaredAnnotation(CheckboxField.class);
			groupContent = buildCheckboxField(field, lf, groupContent);
		}
		else if (field.isAnnotationPresent(ColorField.class))
		{
			ColorField lf = field.getDeclaredAnnotation(ColorField.class);
			groupContent = buildColourField(field, lf, groupContent);
		}
		else if (field.isAnnotationPresent(DateTimePickerField.class))
		{
			DateTimePickerField lf = field.getDeclaredAnnotation(DateTimePickerField.class);
			groupContent = buildDateTimePicker(field, lf, groupContent);
		}
		else if (field.isAnnotationPresent(DatePickerField.class))
		{
			DatePickerField lf = field.getDeclaredAnnotation(DatePickerField.class);
			groupContent = buildDatePicker(field, lf, groupContent);
		}
		else if (field.isAnnotationPresent(EmailField.class))
		{
			EmailField lf = field.getDeclaredAnnotation(EmailField.class);
			groupContent = buildEmailField(field, lf, groupContent);
		}
		else if (field.isAnnotationPresent(FileField.class))
		{
			FileField lf = field.getDeclaredAnnotation(FileField.class);
			groupContent = buildFileUploadField(field, lf, groupContent);
		}
		else if (field.isAnnotationPresent(HeaderField.class))
		{
			HeaderField lf = field.getDeclaredAnnotation(HeaderField.class);
			groupContent = buildHeaderField(field, lf, groupContent);
		}
		else if (field.isAnnotationPresent(HiddenField.class))
		{
			HiddenField lf = field.getDeclaredAnnotation(HiddenField.class);
			groupContent = buildHiddenField(field, lf, groupContent);
		}
		else if (field.isAnnotationPresent(LabelField.class))
		{
			LabelField lf = field.getDeclaredAnnotation(LabelField.class);
			groupContent = buildFieldLabel(field, lf, groupContent);
		}
		else if (field.isAnnotationPresent(NumberField.class))
		{
			NumberField lf = field.getDeclaredAnnotation(NumberField.class);
			groupContent = buildNumberField(field, lf, groupContent);
		}
		else if (field.isAnnotationPresent(PasswordField.class) && field.getType()
		                                                                .equals(String.class))
		{
			PasswordField lf = field.getDeclaredAnnotation(PasswordField.class);
			groupContent = buildPasswordField(field, lf, groupContent);
		}
		else if (field.isAnnotationPresent(RadioField.class))
		{
			RadioField lf = field.getDeclaredAnnotation(RadioField.class);
			groupContent = buildRadioField(field, lf, groupContent);
		}
		else if (field.isAnnotationPresent(SearchField.class))
		{
			SearchField lf = field.getDeclaredAnnotation(SearchField.class);
			groupContent = buildSearchField(field, lf, groupContent);
		}
		else if (field.isAnnotationPresent(SelectField.class))
		{
			SelectField lf = field.getDeclaredAnnotation(SelectField.class);
			groupContent = buildSelectField(field, lf, groupContent);
		}
		else if (field.isAnnotationPresent(SubHeaderField.class))
		{
			SubHeaderField lf = field.getDeclaredAnnotation(SubHeaderField.class);
			groupContent = buildSubHeaderField(field, lf, groupContent);
		}
		else if (field.isAnnotationPresent(SwitchField.class))
		{
			SwitchField lf = field.getDeclaredAnnotation(SwitchField.class);
			groupContent = buildSwitchField(field, lf, groupContent);
		}
		else if (field.isAnnotationPresent(TextField.class))
		{
			TextField lf = field.getDeclaredAnnotation(TextField.class);
			groupContent = buildTextField(field, lf, groupContent);
		}
		else if (field.isAnnotationPresent(TextAreaField.class) && field.getType()
		                                                                .equals(String.class))
		{
			TextAreaField lf = field.getDeclaredAnnotation(TextAreaField.class);
			groupContent = buildTextAreaField(field, lf, groupContent);
		}
		else if (field.isAnnotationPresent(TelephoneField.class) && field.getType()
		                                                                 .equals(String.class))
		{
			TelephoneField lf = field.getDeclaredAnnotation(TelephoneField.class);
			groupContent = buildTelephoneField(field, lf, groupContent);
		}
		else if (field.isAnnotationPresent(UrlField.class))
		{
			UrlField lf = field.getDeclaredAnnotation(UrlField.class);
			groupContent = buildUrlField(field, lf, groupContent);
		}
		configureReadOnly(groupContent, field);

		form.add((IComponentHierarchyBase) groupContent);
	}

	protected void processButtonEvents()
	{
		Field[] fields = getObject().getClass()
		                            .getDeclaredFields();
		for (Field field : fields)
		{
			field.setAccessible(true);
			if (field.isAnnotationPresent(SubmitButtonField.class))
			{
				SubmitButtonField lf = field.getDeclaredAnnotation(SubmitButtonField.class);
				buildSubmitButton(field, lf, null);
			}
			else if (field.isAnnotationPresent(CancelButtonField.class))
			{
				CancelButtonField lf = field.getDeclaredAnnotation(CancelButtonField.class);
				buildCancelButton(field, lf, null);
			}
			else if (field.isAnnotationPresent(ResetButtonField.class))
			{
				ResetButtonField lf = field.getDeclaredAnnotation(ResetButtonField.class);
				buildResetButton(field, lf, null);
			}
		}
	}

	/**
	 * Sets the given field read only if overridden or specified.
	 *
	 * @param group
	 * @param field
	 */
	protected abstract void configureReadOnly(GROUP group, Field field);

	/**
	 * Sets the object to process
	 *
	 * @param object
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setObject(Object object)
	{
		this.object = object;
		return (J) this;
	}

	/**
	 * If this form is overriding all values to be read only
	 *
	 * @return
	 */
	public boolean isReadOnlyOverride()
	{
		return readOnlyOverride;
	}

	/**
	 * If this form is overriding all values to be read only
	 *
	 * @param readOnlyOverride
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setReadOnlyOverride(boolean readOnlyOverride)
	{
		this.readOnlyOverride = readOnlyOverride;
		return (J) this;
	}

	/**
	 * Sets the value of the field to the input
	 *
	 * @param field
	 * @param input
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	protected J setValue(Field field, Input input)
	{
		try
		{
			field.setAccessible(true);
			if (field.get(getObject()) != null)
			{
				Object value = field.get(getObject());
				input.setValue(value.toString());
			}
		}
		catch (IllegalAccessException e)
		{
			QuickForms.log.log(Level.WARNING, "Unable to access field : " + field.getName() + " in " + getObject().getClass(), e);
		}
		return (J) this;
	}

	/**
	 * Returns the binding name given to a field variable
	 *
	 * @param field
	 * 		The field name to return
	 *
	 * @return The generated ID
	 */
	@NotNull
	protected String getFieldVariableName(Field field)
	{
		return getDtoName() + STRING_DOT + field.getName();
	}

	/**
	 * The form that gets built
	 *
	 * @return
	 */
	public Form<?> getForm()
	{
		return form;
	}

	/**
	 * The form that gets built
	 *
	 * @param form
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setForm(Form<?> form)
	{
		this.form = form;
		return (J) this;
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}
}
