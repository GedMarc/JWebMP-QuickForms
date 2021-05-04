package com.jwebmp.plugins.quickforms.services;

import com.guicedee.guicedinjection.interfaces.IDefaultService;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.plugins.quickforms.annotations.WebFormEndRow;

public interface IFormFieldWrapperEnd extends IDefaultService<IFormFieldWrapperEnd>
{
    IComponentHierarchyBase<?,?> finalizeDiv(IComponentHierarchyBase<?,?> finalizeDiv, WebFormEndRow annotation);
}
