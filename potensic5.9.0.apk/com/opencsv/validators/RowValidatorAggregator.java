package com.opencsv.validators;

import com.opencsv.exceptions.CsvValidationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/* loaded from: classes3.dex */
public class RowValidatorAggregator {
    private static final int CAPACITY = 512;
    private static final int MULTIPLIER = 3;
    private List<RowValidator> validators = new ArrayList();

    public void addValidator(RowValidator rowValidator) {
        if (rowValidator != null) {
            this.validators.add(rowValidator);
        }
    }

    public boolean isValid(final String[] strArr) {
        return this.validators.stream().allMatch(new Predicate() { // from class: com.opencsv.validators.-$$Lambda$RowValidatorAggregator$cCNoPL5N4bbmMnqrBgUYpXqcPQY
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean isValid;
                isValid = ((RowValidator) obj).isValid(strArr);
                return isValid;
            }
        });
    }

    public void validate(String[] strArr) throws CsvValidationException {
        if (this.validators.isEmpty()) {
            return;
        }
        StringBuilder sb = null;
        Iterator<RowValidator> it = this.validators.iterator();
        while (it.hasNext()) {
            try {
                it.next().validate(strArr);
            } catch (CsvValidationException e) {
                if (sb == null) {
                    sb = new StringBuilder(Math.max((e.getMessage().length() + 2) * 3, 512));
                }
                sb.append(e.getMessage()).append("\n");
            }
        }
        if (sb != null && sb.length() > 0) {
            throw new CsvValidationException(sb.toString());
        }
    }

    void setValidators(List<RowValidator> list) {
        this.validators = list;
    }
}