module com.jwebmp.plugins.quickforms {

	exports com.jwebmp.plugins.quickforms;
	exports com.jwebmp.plugins.quickforms.annotations;
	exports com.jwebmp.plugins.quickforms.annotations.states;

	requires com.jwebmp.core;
	requires com.jwebmp.logmaster;
	requires com.fasterxml.jackson.annotation;

	requires java.validation;
	requires java.logging;
	requires com.jwebmp.guicedinjection;
}
