package org.apache.poi.hssf.record.aggregates;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.CFHeaderRecord;
import org.apache.poi.hssf.record.aggregates.RecordAggregate;
import org.apache.poi.ss.formula.FormulaShifter;

/* loaded from: classes5.dex */
public final class ConditionalFormattingTable extends RecordAggregate {
    private final List<CFRecordsAggregate> _cfHeaders;

    public ConditionalFormattingTable() {
        this._cfHeaders = new ArrayList();
    }

    public ConditionalFormattingTable(RecordStream recordStream) {
        ArrayList arrayList = new ArrayList();
        while (recordStream.peekNextClass() == CFHeaderRecord.class) {
            arrayList.add(CFRecordsAggregate.createCFAggregate(recordStream));
        }
        this._cfHeaders = arrayList;
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor) {
        for (int i = 0; i < this._cfHeaders.size(); i++) {
            this._cfHeaders.get(i).visitContainedRecords(recordVisitor);
        }
    }

    public int add(CFRecordsAggregate cFRecordsAggregate) {
        this._cfHeaders.add(cFRecordsAggregate);
        return this._cfHeaders.size() - 1;
    }

    public int size() {
        return this._cfHeaders.size();
    }

    public CFRecordsAggregate get(int i) {
        checkIndex(i);
        return this._cfHeaders.get(i);
    }

    public void remove(int i) {
        checkIndex(i);
        this._cfHeaders.remove(i);
    }

    private void checkIndex(int i) {
        if (i < 0 || i >= this._cfHeaders.size()) {
            throw new IllegalArgumentException("Specified CF index " + i + " is outside the allowable range (0.." + (this._cfHeaders.size() - 1) + ")");
        }
    }

    public void updateFormulasAfterCellShift(FormulaShifter formulaShifter, int i) {
        int i2 = 0;
        while (i2 < this._cfHeaders.size()) {
            if (!this._cfHeaders.get(i2).updateFormulasAfterCellShift(formulaShifter, i)) {
                this._cfHeaders.remove(i2);
                i2--;
            }
            i2++;
        }
    }
}
