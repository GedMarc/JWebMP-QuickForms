package com.jwebmp.plugins.quickforms;

import com.jwebmp.base.ComponentHierarchyBase;
import com.jwebmp.base.html.Form;
import com.jwebmp.htmlbuilder.javascript.JavaScriptPart;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Denotes a group of components in a structure to render the field
 *
 * @param <J>
 * @param <G>
 * 		The group component type
 */
public class QuickFormFieldGroup<G extends ComponentHierarchyBase, J extends QuickFormFieldGroup<G, J>>
		extends JavaScriptPart<J>
{
	private static final long serialVersionUID = 1L;
	/**
	 * The form this group belongs to
	 */
	private Form form;
	/**
	 * The group for this item
	 */
	private G group;
	/**
	 * The intended label field
	 */
	private ComponentHierarchyBase labelField;
	/**
	 * The intended input field
	 */
	private ComponentHierarchyBase inputField;
	/**
	 * The list of given input fields
	 */
	private List<ComponentHierarchyBase> preInputFields;
	/**
	 * The list of given post input fields
	 */
	private List<ComponentHierarchyBase> postInputFields;

	/**
	 * Constructs a new group with the given form
	 *
	 * @param form
	 */
	public QuickFormFieldGroup(Form form)
	{
		this.form = form;
	}

	/**
	 * Returns the form
	 *
	 * @return
	 */
	public Form getForm()
	{
		return form;
	}

	/**
	 * Sets the form object
	 *
	 * @param form
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setForm(Form form)
	{
		this.form = form;
		return (J) this;
	}

	/**
	 * Gets the group item
	 *
	 * @return
	 */
	public G getGroup()
	{
		return group;
	}

	/**
	 * Sets the group item
	 *
	 * @param group
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setGroup(G group)
	{
		this.group = group;
		return (J) this;
	}

	/**
	 * Sets the label field
	 *
	 * @return
	 */
	public ComponentHierarchyBase getLabelField()
	{
		return labelField;
	}

	/**
	 * Sets the label fields
	 *
	 * @param labelField
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setLabelField(ComponentHierarchyBase labelField)
	{
		this.labelField = labelField;
		return (J) this;
	}

	/**
	 * Returns the input fields
	 *
	 * @return
	 */
	@NotNull
	public ComponentHierarchyBase getInputField()
	{
		return inputField;
	}

	/**
	 * Sets the input field
	 *
	 * @param inputField
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setInputField(@NotNull ComponentHierarchyBase inputField)
	{
		this.inputField = inputField;
		return (J) this;
	}

	/**
	 * Returns the pre input fields
	 *
	 * @return
	 */
	@NotNull
	public List<ComponentHierarchyBase> getPreInputFields()
	{
		if (preInputFields == null)
		{
			preInputFields = new ArrayList<>();
		}
		return preInputFields;
	}

	/**
	 * Sets the pre input fields
	 *
	 * @param preInputFields
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setPreInputFields(List<ComponentHierarchyBase> preInputFields)
	{
		this.preInputFields = preInputFields;
		return (J) this;
	}

	/**
	 * Returns the post input fields
	 *
	 * @return
	 */
	@NotNull
	public List<ComponentHierarchyBase> getPostInputFields()
	{
		if (postInputFields == null)
		{
			postInputFields = new ArrayList<>();
		}
		return postInputFields;
	}

	/**
	 * Sets the post input fields
	 *
	 * @param postInputFields
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setPostInputFields(List<ComponentHierarchyBase> postInputFields)
	{
		this.postInputFields = postInputFields;
		return (J) this;
	}
}
