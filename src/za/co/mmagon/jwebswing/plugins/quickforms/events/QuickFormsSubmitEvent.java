package za.co.mmagon.jwebswing.plugins.quickforms.events;

import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.events.click.ClickAdapter;

import javax.management.InvalidAttributeValueException;
import java.io.Serializable;

public abstract class QuickFormsSubmitEvent<E extends Serializable> extends ClickAdapter
{
	
	public abstract void onSubmit(E returnedDto,AjaxCall call, AjaxResponse response);
	
	@Override
	public void onClick(AjaxCall call, AjaxResponse response) throws InvalidAttributeValueException
	{
	
	}
}
