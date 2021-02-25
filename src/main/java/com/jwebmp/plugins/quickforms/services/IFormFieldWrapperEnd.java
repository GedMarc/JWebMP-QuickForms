package com.jwebmp.plugins.quickforms.services;

import com.guicedee.guicedinjection.interfaces.IDefaultService;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;

public interface IFormFieldWrapperEnd extends IDefaultService<IFormFieldWrapperEnd>
{
    IComponentHierarchyBase<?,?> finalizeDiv(IComponentHierarchyBase<?,?> finalizeDiv);
}
