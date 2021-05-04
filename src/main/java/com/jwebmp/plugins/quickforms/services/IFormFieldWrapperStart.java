package com.jwebmp.plugins.quickforms.services;

import com.guicedee.guicedinjection.interfaces.IDefaultService;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.plugins.quickforms.annotations.WebFormStartRow;

public interface IFormFieldWrapperStart extends IDefaultService<IFormFieldWrapperStart>
{
    IComponentHierarchyBase<?,?> createWrapper(WebFormStartRow annotation);
}
