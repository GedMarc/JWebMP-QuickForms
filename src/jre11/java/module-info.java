import com.jwebmp.plugins.quickforms.services.IAnnotationFieldHandler;
import com.jwebmp.plugins.quickforms.services.IFormFieldWrapperEnd;
import com.jwebmp.plugins.quickforms.services.IFormFieldWrapperStart;

module com.jwebmp.plugins.quickforms {

	exports com.jwebmp.plugins.quickforms;
	exports com.jwebmp.plugins.quickforms.services;

	requires transitive com.jwebmp.plugins.quickforms.annotations;

	requires com.jwebmp.core;
	

	requires jakarta.validation;
	requires java.logging;
	requires com.guicedee.guicedinjection;

	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions with com.jwebmp.plugins.quickforms.implementations.QuickFormsExclusionsModule;

	uses IAnnotationFieldHandler;
	uses IFormFieldWrapperStart;
	uses IFormFieldWrapperEnd;

	opens com.jwebmp.plugins.quickforms to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.plugins.quickforms.services to com.google.guice,com.fasterxml.jackson.databind, com.jwebmp.core;
}
