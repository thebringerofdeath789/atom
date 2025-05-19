package com.opencsv.bean;

import com.opencsv.ICSVParser;
import com.opencsv.bean.processor.PreAssignmentProcessor;
import com.opencsv.bean.processor.StringProcessor;
import com.opencsv.bean.validators.PreAssignmentValidator;
import com.opencsv.bean.validators.StringValidator;
import com.opencsv.exceptions.CsvBeanIntrospectionException;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvValidationException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public abstract class AbstractBeanField<T, I> implements BeanField<T, I> {
    protected CsvConverter converter;
    protected Locale errorLocale;
    protected Field field;
    protected FieldAccess<Object> fieldAccess;
    protected boolean required;
    protected Class<?> type;

    protected abstract Object convert(String str) throws CsvDataTypeMismatchException, CsvConstraintViolationException;

    @Override // com.opencsv.bean.BeanField
    public Object[] indexAndSplitMultivaluedField(Object obj, I i) throws CsvDataTypeMismatchException {
        return new Object[]{obj};
    }

    protected boolean isFieldEmptyForWrite(Object obj) {
        return obj == null;
    }

    public AbstractBeanField() {
        this.required = false;
        this.errorLocale = Locale.getDefault();
    }

    public AbstractBeanField(Class<?> cls, Field field, boolean z, Locale locale, CsvConverter csvConverter) {
        this.type = cls;
        this.field = field;
        this.required = z;
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
        this.converter = csvConverter;
        this.fieldAccess = new FieldAccess<>(this.field);
    }

    @Override // com.opencsv.bean.BeanField
    public Class<?> getType() {
        return this.type;
    }

    @Override // com.opencsv.bean.BeanField
    public void setType(Class<?> cls) {
        this.type = cls;
    }

    @Override // com.opencsv.bean.BeanField
    public void setField(Field field) {
        this.field = field;
        this.fieldAccess = new FieldAccess<>(this.field);
    }

    @Override // com.opencsv.bean.BeanField
    public Field getField() {
        return this.field;
    }

    @Override // com.opencsv.bean.BeanField
    public boolean isRequired() {
        return this.required;
    }

    @Override // com.opencsv.bean.BeanField
    public void setRequired(boolean z) {
        this.required = z;
    }

    @Override // com.opencsv.bean.BeanField
    public void setErrorLocale(Locale locale) {
        Locale locale2 = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
        this.errorLocale = locale2;
        CsvConverter csvConverter = this.converter;
        if (csvConverter != null) {
            csvConverter.setErrorLocale(locale2);
        }
    }

    @Override // com.opencsv.bean.BeanField
    public Locale getErrorLocale() {
        return this.errorLocale;
    }

    @Override // com.opencsv.bean.BeanField
    public final void setFieldValue(Object obj, String str, String str2) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, CsvConstraintViolationException, CsvValidationException {
        if (this.required && StringUtils.isBlank(str)) {
            throw new CsvRequiredFieldEmptyException(obj.getClass(), this.field, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("required.field.empty"), this.field.getName()));
        }
        for (PreAssignmentProcessor preAssignmentProcessor : (PreAssignmentProcessor[]) this.field.getAnnotationsByType(PreAssignmentProcessor.class)) {
            str = preProcessValue(preAssignmentProcessor, str);
        }
        for (PreAssignmentValidator preAssignmentValidator : (PreAssignmentValidator[]) this.field.getAnnotationsByType(PreAssignmentValidator.class)) {
            validateValue(preAssignmentValidator, str);
        }
        assignValueToField(obj, convert(str), str2);
    }

    private String preProcessValue(PreAssignmentProcessor preAssignmentProcessor, String str) throws CsvValidationException {
        try {
            StringProcessor newInstance = preAssignmentProcessor.processor().newInstance();
            newInstance.setParameterString(preAssignmentProcessor.paramString());
            return newInstance.processString(str);
        } catch (IllegalAccessException | InstantiationException unused) {
            throw new CsvValidationException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("validator.instantiation.impossible"), preAssignmentProcessor.processor().getName(), this.field.getName()));
        }
    }

    private void validateValue(PreAssignmentValidator preAssignmentValidator, String str) throws CsvValidationException {
        try {
            StringValidator newInstance = preAssignmentValidator.validator().newInstance();
            newInstance.setParameterString(preAssignmentValidator.paramString());
            newInstance.validate(str, this);
        } catch (IllegalAccessException | InstantiationException unused) {
            throw new CsvValidationException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("validator.instantiation.impossible"), preAssignmentValidator.validator().getName(), this.field.getName()));
        }
    }

    @Override // com.opencsv.bean.BeanField
    public Object getFieldValue(Object obj) {
        try {
            return this.fieldAccess.getField(obj);
        } catch (IllegalAccessException | InvocationTargetException e) {
            CsvBeanIntrospectionException csvBeanIntrospectionException = new CsvBeanIntrospectionException(obj, this.field, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("error.introspecting.field"), this.field.getName(), obj.getClass().toString()));
            csvBeanIntrospectionException.initCause(e);
            throw csvBeanIntrospectionException;
        }
    }

    protected void assignValueToField(Object obj, Object obj2, String str) throws CsvDataTypeMismatchException {
        if (obj2 != null) {
            try {
                this.fieldAccess.setField(obj, obj2);
            } catch (IllegalAccessException e) {
                e = e;
                CsvBeanIntrospectionException csvBeanIntrospectionException = new CsvBeanIntrospectionException(obj, this.field, e.getLocalizedMessage());
                csvBeanIntrospectionException.initCause(e);
                throw csvBeanIntrospectionException;
            } catch (IllegalArgumentException e2) {
                CsvDataTypeMismatchException csvDataTypeMismatchException = new CsvDataTypeMismatchException(obj2, this.field.getType());
                csvDataTypeMismatchException.initCause(e2);
                throw csvDataTypeMismatchException;
            } catch (InvocationTargetException e3) {
                e = e3;
                CsvBeanIntrospectionException csvBeanIntrospectionException2 = new CsvBeanIntrospectionException(obj, this.field, e.getLocalizedMessage());
                csvBeanIntrospectionException2.initCause(e);
                throw csvBeanIntrospectionException2;
            }
        }
    }

    @Override // com.opencsv.bean.BeanField
    public final String[] write(Object obj, I i) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        Object fieldValue = obj != null ? getFieldValue(obj) : null;
        if (this.required && (obj == null || isFieldEmptyForWrite(fieldValue))) {
            throw new CsvRequiredFieldEmptyException(this.type, this.field, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("required.field.empty"), this.field.getName()));
        }
        Object[] indexAndSplitMultivaluedField = indexAndSplitMultivaluedField(fieldValue, i);
        String[] strArr = new String[indexAndSplitMultivaluedField.length];
        for (int i2 = 0; i2 < indexAndSplitMultivaluedField.length; i2++) {
            try {
                strArr[i2] = convertToWrite(indexAndSplitMultivaluedField[i2]);
            } catch (CsvDataTypeMismatchException e) {
                CsvDataTypeMismatchException csvDataTypeMismatchException = new CsvDataTypeMismatchException(obj, this.field.getType(), e.getMessage());
                csvDataTypeMismatchException.initCause(e.getCause());
                throw csvDataTypeMismatchException;
            } catch (CsvRequiredFieldEmptyException e2) {
                CsvRequiredFieldEmptyException csvRequiredFieldEmptyException = new CsvRequiredFieldEmptyException(obj != null ? obj.getClass() : null, this.field, e2.getMessage());
                csvRequiredFieldEmptyException.initCause(e2.getCause());
                throw csvRequiredFieldEmptyException;
            }
        }
        return strArr;
    }

    protected String convertToWrite(Object obj) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        return Objects.toString(obj, "");
    }
}
