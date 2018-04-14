package com.jwebmp.plugins.quickforms.events;

import com.jwebmp.base.ajax.AjaxCall;
import com.jwebmp.base.ajax.AjaxResponse;
import com.jwebmp.events.click.ClickAdapter;

import java.io.Serializable;

public abstract class QuickFormsClearEvent<E extends Serializable>
		extends ClickAdapter
{
	/**
	 * The returned value on clear
	 *
	 * @param returnedDto
	 */
	public abstract void onClear(E returnedDto, AjaxCall call, AjaxResponse response);

	@Override
	public void onClick(AjaxCall call, AjaxResponse response)
	{

	}
}
