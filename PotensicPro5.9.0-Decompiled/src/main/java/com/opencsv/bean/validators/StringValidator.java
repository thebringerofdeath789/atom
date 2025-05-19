package com.opencsv.bean.validators;

import com.opencsv.bean.BeanField;
import com.opencsv.exceptions.CsvValidationException;

/* loaded from: classes3.dex */
public interface StringValidator {
    boolean isValid(String str);

    void setParameterString(String str);

    void validate(String str, BeanField beanField) throws CsvValidationException;
}
