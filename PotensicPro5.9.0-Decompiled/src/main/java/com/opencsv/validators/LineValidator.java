package com.opencsv.validators;

import com.opencsv.exceptions.CsvValidationException;

/* loaded from: classes3.dex */
public interface LineValidator {
    boolean isValid(String str);

    void validate(String str) throws CsvValidationException;
}
