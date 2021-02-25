package com.jwebmp.plugins.quickforms.services;

import com.guicedee.guicedinjection.interfaces.IDefaultService;
import com.jwebmp.core.base.html.Form;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.plugins.quickforms.QuickForms;
import com.jwebmp.plugins.quickforms.annotations.SwitchField;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public interface IAnnotationFieldHandler<A extends Annotation, GROUP extends IComponentHierarchyBase<?, ?>>
        extends IDefaultService<IAnnotationFieldHandler<A, GROUP>>
{
    A appliedAnnotation();

    GROUP buildField(QuickForms<?, ?> form, Field field, A annotation, GROUP fieldGroup);
}
