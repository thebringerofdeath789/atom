package com.opencsv.validators;

import com.opencsv.exceptions.CsvValidationException;

/* loaded from: classes3.dex */
public class RowMustHaveSameNumberOfColumnsAsFirstRowValidator implements RowValidator {
    private static final int NO_ROWS = 0;
    private int numRows = 0;

    @Override // com.opencsv.validators.RowValidator
    public boolean isValid(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        if (firstRowNotSetYet()) {
            this.numRows = strArr.length;
        }
        return strArr.length == this.numRows;
    }

    @Override // com.opencsv.validators.RowValidator
    public void validate(String[] strArr) throws CsvValidationException {
        if (isValid(strArr)) {
            return;
        }
        if (firstRowNotSetYet()) {
            throw new CsvValidationException("First row should not be empty or null");
        }
        if (strArr == null || strArr.length == 0) {
            throw new CsvValidationException("Row should not be empty or null");
        }
        throw new CsvValidationException(String.format("Row was expected to have %d elements but had %d instead", Integer.valueOf(this.numRows), Integer.valueOf(strArr.length)));
    }

    private boolean firstRowNotSetYet() {
        return this.numRows == 0;
    }
}