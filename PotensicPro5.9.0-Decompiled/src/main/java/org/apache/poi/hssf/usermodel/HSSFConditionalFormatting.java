package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.aggregates.CFRecordsAggregate;
import org.apache.poi.ss.usermodel.ConditionalFormatting;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.Region;

/* loaded from: classes5.dex */
public final class HSSFConditionalFormatting implements ConditionalFormatting {
    private final HSSFWorkbook _workbook;
    private final CFRecordsAggregate cfAggregate;

    HSSFConditionalFormatting(HSSFWorkbook hSSFWorkbook, CFRecordsAggregate cFRecordsAggregate) {
        if (hSSFWorkbook == null) {
            throw new IllegalArgumentException("workbook must not be null");
        }
        if (cFRecordsAggregate == null) {
            throw new IllegalArgumentException("cfAggregate must not be null");
        }
        this._workbook = hSSFWorkbook;
        this.cfAggregate = cFRecordsAggregate;
    }

    CFRecordsAggregate getCFRecordsAggregate() {
        return this.cfAggregate;
    }

    public Region[] getFormattingRegions() {
        return Region.convertCellRangesToRegions(getFormattingRanges());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public CellRangeAddress[] getFormattingRanges() {
        return this.cfAggregate.getHeader().getCellRanges();
    }

    public void setRule(int i, HSSFConditionalFormattingRule hSSFConditionalFormattingRule) {
        this.cfAggregate.setRule(i, hSSFConditionalFormattingRule.getCfRuleRecord());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public void setRule(int i, ConditionalFormattingRule conditionalFormattingRule) {
        setRule(i, (HSSFConditionalFormattingRule) conditionalFormattingRule);
    }

    public void addRule(HSSFConditionalFormattingRule hSSFConditionalFormattingRule) {
        this.cfAggregate.addRule(hSSFConditionalFormattingRule.getCfRuleRecord());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public void addRule(ConditionalFormattingRule conditionalFormattingRule) {
        addRule((HSSFConditionalFormattingRule) conditionalFormattingRule);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public HSSFConditionalFormattingRule getRule(int i) {
        return new HSSFConditionalFormattingRule(this._workbook, this.cfAggregate.getRule(i));
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public int getNumberOfRules() {
        return this.cfAggregate.getNumberOfRules();
    }

    public String toString() {
        return this.cfAggregate.toString();
    }
}
