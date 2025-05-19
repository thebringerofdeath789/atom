package com.opencsv.validators;

import com.opencsv.exceptions.CsvValidationException;

/* loaded from: classes3.dex */
public interface RowValidator {
    boolean isValid(String[] strArr);

    void validate(String[] strArr) throws CsvValidationException;
}
