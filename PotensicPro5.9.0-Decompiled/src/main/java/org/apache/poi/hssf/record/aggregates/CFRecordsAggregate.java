package org.apache.poi.hssf.record.aggregates;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.CFHeaderRecord;
import org.apache.poi.hssf.record.CFRuleRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.aggregates.RecordAggregate;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.formula.ptg.AreaErrPtg;
import org.apache.poi.ss.formula.ptg.AreaPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* loaded from: classes5.dex */
public final class CFRecordsAggregate extends RecordAggregate {
    private static final int MAX_97_2003_CONDTIONAL_FORMAT_RULES = 3;
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) CFRecordsAggregate.class);
    private final CFHeaderRecord header;
    private final List<CFRuleRecord> rules;

    private CFRecordsAggregate(CFHeaderRecord cFHeaderRecord, CFRuleRecord[] cFRuleRecordArr) {
        if (cFHeaderRecord == null) {
            throw new IllegalArgumentException("header must not be null");
        }
        if (cFRuleRecordArr == null) {
            throw new IllegalArgumentException("rules must not be null");
        }
        if (cFRuleRecordArr.length > 3) {
            logger.log(5, "Excel versions before 2007 require that No more than 3 rules may be specified, " + cFRuleRecordArr.length + " were found, this file will cause problems with old Excel versions");
        }
        if (cFRuleRecordArr.length != cFHeaderRecord.getNumberOfConditionalFormats()) {
            throw new RuntimeException("Mismatch number of rules");
        }
        this.header = cFHeaderRecord;
        this.rules = new ArrayList(3);
        for (CFRuleRecord cFRuleRecord : cFRuleRecordArr) {
            this.rules.add(cFRuleRecord);
        }
    }

    public CFRecordsAggregate(CellRangeAddress[] cellRangeAddressArr, CFRuleRecord[] cFRuleRecordArr) {
        this(new CFHeaderRecord(cellRangeAddressArr, cFRuleRecordArr.length), cFRuleRecordArr);
    }

    public static CFRecordsAggregate createCFAggregate(RecordStream recordStream) {
        Record next = recordStream.getNext();
        if (next.getSid() != 432) {
            throw new IllegalStateException("next record sid was " + ((int) next.getSid()) + " instead of 432 as expected");
        }
        CFHeaderRecord cFHeaderRecord = (CFHeaderRecord) next;
        int numberOfConditionalFormats = cFHeaderRecord.getNumberOfConditionalFormats();
        CFRuleRecord[] cFRuleRecordArr = new CFRuleRecord[numberOfConditionalFormats];
        for (int i = 0; i < numberOfConditionalFormats; i++) {
            cFRuleRecordArr[i] = (CFRuleRecord) recordStream.getNext();
        }
        return new CFRecordsAggregate(cFHeaderRecord, cFRuleRecordArr);
    }

    public CFRecordsAggregate cloneCFAggregate() {
        int size = this.rules.size();
        CFRuleRecord[] cFRuleRecordArr = new CFRuleRecord[size];
        for (int i = 0; i < size; i++) {
            cFRuleRecordArr[i] = (CFRuleRecord) getRule(i).clone();
        }
        return new CFRecordsAggregate((CFHeaderRecord) this.header.clone(), cFRuleRecordArr);
    }

    public CFHeaderRecord getHeader() {
        return this.header;
    }

    private void checkRuleIndex(int i) {
        if (i < 0 || i >= this.rules.size()) {
            throw new IllegalArgumentException("Bad rule record index (" + i + ") nRules=" + this.rules.size());
        }
    }

    public CFRuleRecord getRule(int i) {
        checkRuleIndex(i);
        return this.rules.get(i);
    }

    public void setRule(int i, CFRuleRecord cFRuleRecord) {
        if (cFRuleRecord == null) {
            throw new IllegalArgumentException("r must not be null");
        }
        checkRuleIndex(i);
        this.rules.set(i, cFRuleRecord);
    }

    public void addRule(CFRuleRecord cFRuleRecord) {
        if (cFRuleRecord == null) {
            throw new IllegalArgumentException("r must not be null");
        }
        if (this.rules.size() >= 3) {
            logger.log(5, "Excel versions before 2007 cannot cope with any more than 3 - this file will cause problems with old Excel versions");
        }
        this.rules.add(cFRuleRecord);
        this.header.setNumberOfConditionalFormats(this.rules.size());
    }

    public int getNumberOfRules() {
        return this.rules.size();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[CF]\n");
        CFHeaderRecord cFHeaderRecord = this.header;
        if (cFHeaderRecord != null) {
            stringBuffer.append(cFHeaderRecord.toString());
        }
        for (int i = 0; i < this.rules.size(); i++) {
            stringBuffer.append(this.rules.get(i).toString());
        }
        stringBuffer.append("[/CF]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor) {
        recordVisitor.visitRecord(this.header);
        for (int i = 0; i < this.rules.size(); i++) {
            recordVisitor.visitRecord(this.rules.get(i));
        }
    }

    public boolean updateFormulasAfterCellShift(FormulaShifter formulaShifter, int i) {
        int i2;
        CellRangeAddress[] cellRanges = this.header.getCellRanges();
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (CellRangeAddress cellRangeAddress : cellRanges) {
            CellRangeAddress shiftRange = shiftRange(formulaShifter, cellRangeAddress, i);
            if (shiftRange != null) {
                arrayList.add(shiftRange);
                i2 = shiftRange == cellRangeAddress ? i2 + 1 : 0;
            }
            z = true;
        }
        if (z) {
            int size = arrayList.size();
            if (size == 0) {
                return false;
            }
            CellRangeAddress[] cellRangeAddressArr = new CellRangeAddress[size];
            arrayList.toArray(cellRangeAddressArr);
            this.header.setCellRanges(cellRangeAddressArr);
        }
        for (int i3 = 0; i3 < this.rules.size(); i3++) {
            CFRuleRecord cFRuleRecord = this.rules.get(i3);
            Ptg[] parsedExpression1 = cFRuleRecord.getParsedExpression1();
            if (parsedExpression1 != null && formulaShifter.adjustFormula(parsedExpression1, i)) {
                cFRuleRecord.setParsedExpression1(parsedExpression1);
            }
            Ptg[] parsedExpression2 = cFRuleRecord.getParsedExpression2();
            if (parsedExpression2 != null && formulaShifter.adjustFormula(parsedExpression2, i)) {
                cFRuleRecord.setParsedExpression2(parsedExpression2);
            }
        }
        return true;
    }

    private static CellRangeAddress shiftRange(FormulaShifter formulaShifter, CellRangeAddress cellRangeAddress, int i) {
        Ptg[] ptgArr = {new AreaPtg(cellRangeAddress.getFirstRow(), cellRangeAddress.getLastRow(), cellRangeAddress.getFirstColumn(), cellRangeAddress.getLastColumn(), false, false, false, false)};
        if (!formulaShifter.adjustFormula(ptgArr, i)) {
            return cellRangeAddress;
        }
        Ptg ptg = ptgArr[0];
        if (ptg instanceof AreaPtg) {
            AreaPtg areaPtg = (AreaPtg) ptg;
            return new CellRangeAddress(areaPtg.getFirstRow(), areaPtg.getLastRow(), areaPtg.getFirstColumn(), areaPtg.getLastColumn());
        }
        if (ptg instanceof AreaErrPtg) {
            return null;
        }
        throw new IllegalStateException("Unexpected shifted ptg class (" + ptg.getClass().getName() + ")");
    }
}
