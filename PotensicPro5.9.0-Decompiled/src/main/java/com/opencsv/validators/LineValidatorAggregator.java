package com.opencsv.validators;

import com.opencsv.exceptions.CsvValidationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/* loaded from: classes3.dex */
public class LineValidatorAggregator {
    private static final int CAPACITY = 512;
    private static final int MULTIPLIER = 3;
    private List<LineValidator> validators = new ArrayList();

    public void addValidator(LineValidator lineValidator) {
        if (lineValidator != null) {
            this.validators.add(lineValidator);
        }
    }

    public boolean isValid(final String str) {
        return this.validators.stream().allMatch(new Predicate() { // from class: com.opencsv.validators.-$$Lambda$LineValidatorAggregator$8FHHslobT_TAv8Xks6tV9lZqdW4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean isValid;
                isValid = ((LineValidator) obj).isValid(str);
                return isValid;
            }
        });
    }

    public void validate(String str) throws CsvValidationException {
        if (this.validators.isEmpty()) {
            return;
        }
        StringBuilder sb = null;
        Iterator<LineValidator> it = this.validators.iterator();
        while (it.hasNext()) {
            try {
                it.next().validate(str);
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

    void setValidators(List<LineValidator> list) {
        this.validators = list;
    }
}
