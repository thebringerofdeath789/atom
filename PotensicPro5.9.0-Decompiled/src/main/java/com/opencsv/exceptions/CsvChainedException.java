package com.opencsv.exceptions;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/* loaded from: classes3.dex */
public class CsvChainedException extends CsvException {
    private final List<CsvFieldAssignmentException> exceptionChain;

    public CsvChainedException(CsvFieldAssignmentException csvFieldAssignmentException) {
        LinkedList linkedList = new LinkedList();
        this.exceptionChain = linkedList;
        linkedList.add(csvFieldAssignmentException);
    }

    public void add(CsvFieldAssignmentException csvFieldAssignmentException) {
        this.exceptionChain.add(csvFieldAssignmentException);
    }

    public List<CsvFieldAssignmentException> getExceptionChain() {
        return this.exceptionChain;
    }

    @Override // com.opencsv.exceptions.CsvException
    public void setLine(final String[] strArr) {
        super.setLine(strArr);
        this.exceptionChain.forEach(new Consumer() { // from class: com.opencsv.exceptions.-$$Lambda$CsvChainedException$BFt01g5A4Uc5CYK3KdioVbej_3M
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((CsvFieldAssignmentException) obj).setLine(strArr);
            }
        });
    }

    @Override // com.opencsv.exceptions.CsvException
    public void setLineNumber(final long j) {
        super.setLineNumber(j);
        this.exceptionChain.forEach(new Consumer() { // from class: com.opencsv.exceptions.-$$Lambda$CsvChainedException$O3ucQg73cXEyanYedoCKP4rBIYU
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((CsvFieldAssignmentException) obj).setLineNumber(j);
            }
        });
    }

    public boolean hasOnlyOneException() {
        return this.exceptionChain.size() == 1;
    }

    public CsvFieldAssignmentException getFirstException() {
        if (this.exceptionChain.isEmpty()) {
            return null;
        }
        return this.exceptionChain.get(0);
    }
}
