package com.jwebmp.plugins.quickforms;

import com.jwebmp.base.ComponentHierarchyBase;
import com.jwebmp.base.html.Form;
import com.jwebmp.base.html.Input;
import com.jwebmp.plugins.quickforms.annotations.*;
import com.jwebmp.plugins.quickforms.annotations.states.WebReadOnly;
import com.jwebmp.utilities.StaticStrings;
import za.co.mmagon.guiceinjection.GuiceContext;
import za.co.mmagon.logger.LogFactory;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An abstract layer to distribute quick forms calls
 * <p>
 * Base quick forms class
 *
 * @param <J>
 */
@Deprecated
public abstract class QuickForms<E extends Serializable, G extends ComponentHierarchyBase, J extends QuickForms<E, G, J>>
		extends Form<J>
		implements IQuickForm<E, G, J>
{
	private static final long serialVersionUID = 1L;
	private static final Logger log = LogFactory.getLog("QuickForms");

	/**
	 * The object in question
	 */
	private E serializable;

	/**
	 * Constructs a new object of type
	 *
	 * @param serializable
	 */
	public QuickForms(E serializable)
	{
		this.serializable = serializable;
	}

	@Override
	public void init()
	{
		if (!isInitialized())
		{
			buildForm();
		}
		super.init();
	}

	/**
	 * Builds the fields group as a Div
	 *
	 * @return
	 */
	protected abstract G buildFieldGroup();

	/**
	 * Configures visible non-entry fields and annotations
	 *
	 * @param field
	 * @param groupContent
	 *
	 * @return
	 */
	protected QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> configureHeaderFields(Field field, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> groupContent)
	{
		if (field.isAnnotationPresent(LabelField.class))
		{
			LabelField lf = field.getDeclaredAnnotation(LabelField.class);
			groupContent = buildFieldLabel(field, lf, groupContent);
			groupContent.getLabelField()
			            .setID(getFieldId(field, "lbl"));
		}

		if (field.isAnnotationPresent(HeaderField.class))
		{
			HeaderField lf = field.getDeclaredAnnotation(HeaderField.class);
			groupContent = buildHeaderField(field, lf, groupContent);
		}

		if (field.isAnnotationPresent(SubHeaderField.class))
		{
			SubHeaderField lf = field.getDeclaredAnnotation(SubHeaderField.class);
			groupContent = buildSubHeaderField(field, lf, groupContent);
		}
		return groupContent;
	}

	/**
	 * Builds the input object id for a given field
	 *
	 * @param field
	 * 		The field to get the ID for
	 * @param suffix
	 * 		Any identifier for the field (like labels) that must be applied. Nullable
	 *
	 * @return
	 */
	protected String getFieldId(@NotNull Field field, @Nullable String suffix)
	{
		return getSerializable().getClass()
		                        .getSimpleName() + "_" + field.getName() + "_" + (suffix == null ? "" : suffix);
	}

	/**
	 * Configures visible non-entry fields and annotations
	 *
	 * @param field
	 * @param groupContent
	 *
	 * @return
	 */
	protected QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> configureInputFields(Field field, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> groupContent)
	{
		if (field.isAnnotationPresent(DateTimePickerField.class))
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
		else if (field.isAnnotationPresent(HiddenField.class))
		{
			HiddenField lf = field.getDeclaredAnnotation(HiddenField.class);
			groupContent = buildHiddenField(field, lf, groupContent);
		}
		else if (field.isAnnotationPresent(NumberField.class))
		{
			NumberField lf = field.getDeclaredAnnotation(NumberField.class);
			groupContent = buildNumberField(field, lf, groupContent);
		}
		else if (field.isAnnotationPresent(NumberSpinnerField.class))
		{
			NumberSpinnerField lf = field.getDeclaredAnnotation(NumberSpinnerField.class);
			groupContent = buildNumberSpinnerField(field, lf, groupContent);
		}
		else if (field.isAnnotationPresent(PasswordField.class) && field.getType()
		                                                                .equals(String.class))
		{
			PasswordField lf = field.getDeclaredAnnotation(PasswordField.class);
			groupContent = buildPasswordField(field, lf, groupContent);
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
		else if (field.isAnnotationPresent(SwitchField.class))
		{
			SwitchField lf = field.getDeclaredAnnotation(SwitchField.class);
			groupContent = buildSwitchField(field, lf, groupContent);
		}

		configureReadOnly(groupContent, field);
		return groupContent;
	}

	/**
	 * Configures and builds the form from the group content
	 *
	 * @param field
	 * @param groupContent
	 *
	 * @return
	 */
	protected QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> configureGroupContent(Field field, QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> groupContent)
	{
		if (groupContent.getLabelField() != null)
		{
			groupContent.getGroup()
			            .add(groupContent.getLabelField());
		}
		for (ComponentHierarchyBase comp : groupContent.getPreInputFields())
		{
			groupContent.getGroup()
			            .add(comp);
		}
		if (groupContent.getInputField() != null)
		{
			groupContent.getGroup()
			            .add(groupContent.getInputField());
		}
		for (ComponentHierarchyBase comp : groupContent.getPostInputFields())
		{
			groupContent.getGroup()
			            .add(comp);
		}
		return groupContent;
	}

	private void configureReadOnly(QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> groupContent, Field field)
	{
		if (groupContent.getInputField() != null)
		{
			if (field.isAnnotationPresent(WebReadOnly.class))
			{
				groupContent.getInputField()
				            .addAttribute("readonly", "");
				groupContent.getInputField()
				            .addAttribute("disabled", "");
			}

			groupContent.getInputField()
			            .setID(getFieldId(field, null));
		}
	}

	/**
	 * Builds the form for the given object
	 *
	 * @return
	 */
	protected J buildForm()
	{
		Field[] myFields = getSerializable().getClass()
		                                    .getDeclaredFields();
		for (Field field : myFields)
		{
			QuickFormFieldGroup<G, ? extends QuickFormFieldGroup> groupContent = new QuickFormFieldGroup<>(this);

			groupContent.setGroup(buildFieldGroup());
			groupContent = configureHeaderFields(field, groupContent);
			groupContent = configureInputFields(field, groupContent);
			groupContent = configureGroupContent(field, groupContent);

			add(groupContent.getGroup());
		}
		return (J) this;
	}

	/**
	 * Sets the value of the field to the input
	 *
	 * @param field
	 * @param input
	 */
	protected J setValue(Field field, Input input)
	{
		try
		{
			field.setAccessible(true);
			if (field.get(getSerializable()) != null)
			{
				Object value = field.get(getSerializable());
				input.setValue(value.toString());
			}
		}
		catch (IllegalAccessException e)
		{
			log.log(Level.WARNING, "Unable to access field : " + field.getName() + " in " + getSerializable().getClass(), e);
		}
		return (J) this;
	}

	/**
	 * Returns the assigned object
	 *
	 * @return
	 */
	public E getSerializable()
	{
		return serializable;
	}

	/**
	 * Sets the object
	 *
	 * @param serializable
	 *
	 * @return
	 */
	public J setSerializable(E serializable)
	{
		this.serializable = serializable;

		if (getSerializable() instanceof Class)
		{
			Class<E> c = (Class) getSerializable();
			E instance = GuiceContext.getInstance(c);
			setSerializable(instance);
		}
		if (getSerializable() instanceof Class)
		{
			setID(Class.class.cast(getSerializable())
			                 .getCanonicalName()
			                 .replace(StaticStrings.CHAR_DOT, StaticStrings.CHAR_UNDERSCORE));
		}
		else
		{
			setID(getSerializable().getClass()
			                       .getCanonicalName()
			                       .replace(StaticStrings.CHAR_DOT, StaticStrings.CHAR_UNDERSCORE));
		}

		return (J) this;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof QuickForms))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}
		QuickForms<E, G, J> that = (QuickForms<E, G, J>) o;
		return Objects.equals(getSerializable(), that.getSerializable());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(super.hashCode(), getSerializable());
	}
}
