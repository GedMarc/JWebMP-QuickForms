package com.jwebmp.plugins.quickforms;

import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.guicedinjection.interfaces.IDefaultService;
import com.guicedee.logger.LogFactory;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Form;
import com.jwebmp.core.base.html.Input;
import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import com.jwebmp.core.base.html.interfaces.children.FormChildren;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.plugins.PluginStatus;
import com.jwebmp.plugins.quickforms.annotations.*;
import com.jwebmp.plugins.quickforms.annotations.formtypes.WebFormEndRow;
import com.jwebmp.plugins.quickforms.annotations.formtypes.WebFormStartRow;
import com.jwebmp.plugins.quickforms.annotations.states.WebIgnore;
import com.jwebmp.plugins.quickforms.services.IAnnotationFieldHandler;
import com.jwebmp.plugins.quickforms.services.IFormFieldWrapperEnd;
import com.jwebmp.plugins.quickforms.services.IFormFieldWrapperStart;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.guicedee.guicedinjection.json.StaticStrings.*;

/**
 * Implementation Base for a Quick Form
 *
 * @param <GROUP>
 */
@PluginInformation(pluginName = "QuickForms",
        pluginUniqueName = "quickforms",
        pluginDescription = "Create forms out of objects automatically using annotations,reference any plugin and create automated forms with sending",
        pluginVersion = "1.0.0",
        pluginDependancyUniqueIDs = "jquery",
        pluginCategories = "forms,frameworks,ui",
        pluginSubtitle = "Create forms out of objects automatically using annotations",
        pluginGitUrl = "https://github.com/GedMarc/JWebMP-BSQuickForms4",
        pluginSourceUrl = "https://github.com/GedMarc/JWebMP-BSQuickForms4",
        pluginWikiUrl = "https://github.com/GedMarc/JWebMP-BSQuickForms4/wiki",
        pluginOriginalHomepage = "http://www.jwebmp.com/",
        pluginIconUrl = "",
        pluginIconImageUrl = "",
        pluginDownloadUrl = "https://mvnrepository.com/artifact/com.jwebmp.plugins.forms/jwebmp-quickforms",
        pluginGroupId = "com.jwebmp.plugins.forms",
        pluginArtifactId = "jwebmp-quickforms",
        pluginModuleName = "com.jwebmp.plugins.quickforms",
        pluginStatus = PluginStatus.Released,
        pluginLastUpdatedDate = "2020/12/16"
)
public abstract class QuickForms<GROUP, J extends QuickForms<GROUP, J>>
        extends DivSimple<J>
        implements IQuickForm<GROUP>
{

    private static final Logger log = LogFactory.getLog("QForms");

    /**
     * The object to work on
     */
    @NotNull
    private Object object;
    /**
     * The form that gets built
     */
    private Form<?> form;

    private boolean readOnlyOverride;
    private boolean renderDefaults;

    /**
     * Implementation Base for a Quick Form
     *
     * @param object
     */
    public QuickForms(Object object)
    {
        this();
        this.object = object;
    }

    /**
     * Implementation Base for a Quick Form
     */
    protected QuickForms()
    {
        form = new Form<>();
    }

    @Override
    public void init()
    {
        addDto(getDtoName(), object);

        Field[] classFields = getObject().getClass()
                .getDeclaredFields();
        List<Field> workableFields = new ArrayList<>();
        for (Field classField : classFields)
        {

            if (Modifier.isStatic(classField.getModifiers()) || Modifier.isFinal(classField.getModifiers()))
                continue;
            workableFields.add(classField);
        }

        workableFields.removeIf(a -> a.isAnnotationPresent(WebIgnore.class));
        workableFields.forEach(field ->
        {
            try
            {
                IComponentHierarchyBase<?, ?> groupContent = (IComponentHierarchyBase<?, ?>) processField(field, null);
                if (groupContent == null)
                    if (isRenderDefaults())
                    {
                        processDefaults(field, null);
                    }
            } catch (Throwable T)
            {
                log.log(Level.WARNING, "Cannot generate field " + field, T);
            }
        });
        processButtonEvents();
        add(form);
        super.init();
    }

    /**
     * Returns the DTO name associated with this form (for sending back to the server)
     *
     * @return
     */
    public String getDtoName()
    {
        return getObject().getClass()
                .getCanonicalName()
                .replace(CHAR_DOT, CHAR_UNDERSCORE);
    }

    /**
     * Returns the assigned object
     *
     * @return
     */
    @NotNull
    public Object getObject()
    {
        return object;
    }

    /**
     * If this form must process all fields with defaults, except for those marked @WebIgnore
     *
     * @return
     */
    public boolean isRenderDefaults()
    {
        return renderDefaults;
    }

    /**
     * if this form must process all fields with defaults, except for those marked @WebIgnore
     *
     * @param renderDefaults
     * @return
     */
    @SuppressWarnings("unchecked")
    @NotNull
    public J setRenderDefaults(boolean renderDefaults)
    {
        this.renderDefaults = renderDefaults;
        return (J) this;
    }


    /**
     * API implementation for when annotations are ignored and field types are used
     *
     * @param field        The field working on
     * @param groupContent The group content may be null
     */
    @SuppressWarnings("SameParameterValue")
    public abstract void processDefaults(Field field, GROUP groupContent);

    @SuppressWarnings("unchecked")
    private IAnnotationFieldHandler<?,?> findAnnotationClass(Annotation annotation)
    {
        @SuppressWarnings("rawtypes")
        Set<IAnnotationFieldHandler> iAnnotationFieldHandlers = IDefaultService.loaderToSet(ServiceLoader.load(IAnnotationFieldHandler.class));
        for (IAnnotationFieldHandler<Annotation, ?> annotationFieldHandler : iAnnotationFieldHandlers)
        {
            if (annotationFieldHandler.appliedAnnotation().annotationType().equals(annotation.annotationType()))
                return annotationFieldHandler;
        }
        return null;
    }

    private IComponentHierarchyBase<GlobalChildren, ?> currentWrapper = null;

    @SuppressWarnings({"SameParameterValue", "unchecked"})
    public GROUP processField(Field field, GROUP groupContent)
    {
        field.setAccessible(true);
        boolean setStart = false;
        for (Annotation declaredAnnotation : field.getDeclaredAnnotations())
        {
            if (currentWrapper == null && declaredAnnotation.annotationType().equals(WebFormStartRow.class))
            // if (declaredAnnotation instanceof IFormFieldWrapperStart)
            {

                Set<IFormFieldWrapperStart> starts = IDefaultService.loaderToSet(ServiceLoader.load(IFormFieldWrapperStart.class));
                for (IFormFieldWrapperStart start : starts)
                {
                    currentWrapper = (IComponentHierarchyBase<GlobalChildren, ?>) start.createWrapper();
                    setStart = true;
                    break;
                }
            }
            if (currentWrapper != null && !setStart  && declaredAnnotation.annotationType().equals(WebFormEndRow.class))
               // if (declaredAnnotation instanceof IFormFieldWrapperEnd)
                {
                    Set<IFormFieldWrapperEnd> starts = IDefaultService.loaderToSet(ServiceLoader.load(IFormFieldWrapperEnd.class));
                    for (IFormFieldWrapperEnd start : starts)
                    {
                        start.finalizeDiv(currentWrapper);
                        currentWrapper = null;
                        break;
                    }
                }

            //noinspection RedundantCast
            if (currentWrapper != null && !form.getChildren().contains((FormChildren) currentWrapper))
            {
                form.add((FormChildren) currentWrapper);
            }

            @SuppressWarnings("rawtypes")
            IAnnotationFieldHandler annot = findAnnotationClass(declaredAnnotation);
            if(annot != null)
            {
                groupContent = (GROUP) annot.buildField(this, field, declaredAnnotation, (IComponentHierarchyBase<?, ?>) groupContent);
                break;
            }
        }
        configureReadOnly(groupContent, field);
        if (currentWrapper == null && groupContent != null)
        {
            form.add((FormChildren) groupContent);
        } else if (currentWrapper != null && groupContent != null)
        {
            currentWrapper.getChildren().add((GlobalChildren) groupContent);
        }

        return groupContent;
    }

    public void processButtonEvents()
    {
        Field[] fields = getObject().getClass()
                .getDeclaredFields();
        for (Field field : fields)
        {
            field.setAccessible(true);
            if (field.isAnnotationPresent(SubmitButtonField.class))
            {
                SubmitButtonField lf = field.getDeclaredAnnotation(SubmitButtonField.class);
                buildSubmitButton(field, lf, null);
            } else if (field.isAnnotationPresent(CancelButtonField.class))
            {
                CancelButtonField lf = field.getDeclaredAnnotation(CancelButtonField.class);
                buildCancelButton(field, lf, null);
            } else if (field.isAnnotationPresent(ResetButtonField.class))
            {
                ResetButtonField lf = field.getDeclaredAnnotation(ResetButtonField.class);
                buildResetButton(field, lf, null);
            }
        }
    }

    /**
     * Sets the given field read only if overridden or specified.
     *
     * @param group
     * @param field
     */
    public abstract void configureReadOnly(GROUP group, Field field);

    /**
     * Sets the object to process
     *
     * @param object
     * @return
     */
    @SuppressWarnings("unchecked")
    @NotNull
    public J setObject(Object object)
    {
        this.object = object;
        return (J) this;
    }

    /**
     * If this form is overriding all values to be read only
     *
     * @return
     */
    public boolean isReadOnlyOverride()
    {
        return readOnlyOverride;
    }

    /**
     * If this form is overriding all values to be read only
     *
     * @param readOnlyOverride
     * @return
     */
    @SuppressWarnings("unchecked")
    @NotNull
    public J setReadOnlyOverride(boolean readOnlyOverride)
    {
        this.readOnlyOverride = readOnlyOverride;
        return (J) this;
    }

    /**
     * Sets the value of the field to the input
     *
     * @param field
     * @param input
     */
    @SuppressWarnings("unchecked")
    @NotNull
    public J setValue(Field field, Input<?, ?> input)
    {
        try
        {
            field.setAccessible(true);
            if (field.get(getObject()) != null)
            {
                Object value = field.get(getObject());
                input.setValue(value.toString());
            }
        } catch (IllegalAccessException e)
        {
            QuickForms.log.log(Level.WARNING, "Unable to access field : " + field.getName() + " in " + getObject().getClass(), e);
        }
        return (J) this;
    }

    /**
     * Returns the binding name given to a field variable
     *
     * @param field The field name to return
     * @return The generated ID
     */
    @NotNull
    public String getFieldVariableName(Field field)
    {
        return getDtoName() + STRING_DOT + field.getName();
    }

    /**
     * The form that gets built
     *
     * @return
     */
    public Form<?> getForm()
    {
        return form;
    }

    /**
     * The form that gets built
     *
     * @param form
     * @return
     */
    @SuppressWarnings("unchecked")
    @NotNull
    public J setForm(Form<?> form)
    {
        this.form = form;
        return (J) this;
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o)
    {
        return super.equals(o);
    }
}
