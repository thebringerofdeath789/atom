package com.opencsv.exceptions;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.list.UnmodifiableList;

/* loaded from: classes3.dex */
public class CsvRequiredFieldEmptyException extends CsvFieldAssignmentException {
    private static final long serialVersionUID = 1;
    private final Class<?> beanClass;
    private final transient List<Field> destinationFields;

    public CsvRequiredFieldEmptyException() {
        this.beanClass = null;
        this.destinationFields = Collections.emptyList();
    }

    public CsvRequiredFieldEmptyException(String str) {
        super(str);
        this.beanClass = null;
        this.destinationFields = Collections.emptyList();
    }

    public CsvRequiredFieldEmptyException(Class<?> cls, Field field) {
        this.beanClass = cls;
        this.destinationFields = Collections.singletonList(field);
    }

    public CsvRequiredFieldEmptyException(Class<?> cls, List<Field> list) {
        this.beanClass = cls;
        this.destinationFields = new UnmodifiableList(list);
    }

    public CsvRequiredFieldEmptyException(Class<?> cls, String str) {
        super(str);
        this.beanClass = cls;
        this.destinationFields = Collections.emptyList();
    }

    public CsvRequiredFieldEmptyException(Class<?> cls, Field field, String str) {
        super(str);
        this.beanClass = cls;
        this.destinationFields = Collections.singletonList(field);
    }

    public CsvRequiredFieldEmptyException(Class<?> cls, List<Field> list, String str) {
        super(str);
        this.beanClass = cls;
        this.destinationFields = new UnmodifiableList(list);
    }

    public Class<?> getBeanClass() {
        return this.beanClass;
    }

    public Field getDestinationField() {
        if (CollectionUtils.isEmpty(this.destinationFields)) {
            return null;
        }
        return this.destinationFields.get(0);
    }

    public List<Field> getDestinationFields() {
        return this.destinationFields;
    }
}
