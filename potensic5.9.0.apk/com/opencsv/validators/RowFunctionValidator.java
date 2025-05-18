package com.opencsv.validators;

import com.opencsv.exceptions.CsvValidationException;
import java.util.function.Function;

/* loaded from: classes3.dex */
public class RowFunctionValidator implements RowValidator {
    private String failureMessage;
    private Function<String[], Boolean> testFunction;

    public RowFunctionValidator(Function<String[], Boolean> function, String str) {
        this.testFunction = function;
        this.failureMessage = str;
    }

    @Override // com.opencsv.validators.RowValidator
    public boolean isValid(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        return this.testFunction.apply(strArr).booleanValue();
    }

    @Override // com.opencsv.validators.RowValidator
    public void validate(String[] strArr) throws CsvValidationException {
        if (!isValid(strArr)) {
            throw new CsvValidationException(this.failureMessage);
        }
    }
}