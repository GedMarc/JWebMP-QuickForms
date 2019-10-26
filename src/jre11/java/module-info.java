module com.jwebmp.plugins.quickforms {

	exports com.jwebmp.plugins.quickforms;
	exports com.jwebmp.plugins.quickforms.annotations;
	exports com.jwebmp.plugins.quickforms.annotations.states;

	requires com.jwebmp.core;
	requires com.guicedee.logmaster;
	requires com.fasterxml.jackson.annotation;

	requires java.validation;
	requires java.logging;
	requires com.guicedee.guicedinjection;

	provides com.guicedee.guicedinjection.interfaces.IGuiceScanJarExclusions with com.jwebmp.plugins.quickforms.implementations.QuickFormsExclusionsModule;
	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions with com.jwebmp.plugins.quickforms.implementations.QuickFormsExclusionsModule;

	opens com.jwebmp.plugins.quickforms to com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.plugins.quickforms.annotations to com.fasterxml.jackson.databind, com.jwebmp.core;
}
