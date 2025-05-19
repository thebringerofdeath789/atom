package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.CFRuleRecord;
import org.apache.poi.ss.usermodel.PatternFormatting;

/* loaded from: classes5.dex */
public class HSSFPatternFormatting implements PatternFormatting {
    private final CFRuleRecord cfRuleRecord;
    private final org.apache.poi.hssf.record.cf.PatternFormatting patternFormatting;

    protected HSSFPatternFormatting(CFRuleRecord cFRuleRecord) {
        this.cfRuleRecord = cFRuleRecord;
        this.patternFormatting = cFRuleRecord.getPatternFormatting();
    }

    protected org.apache.poi.hssf.record.cf.PatternFormatting getPatternFormattingBlock() {
        return this.patternFormatting;
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public short getFillBackgroundColor() {
        return (short) this.patternFormatting.getFillBackgroundColor();
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public short getFillForegroundColor() {
        return (short) this.patternFormatting.getFillForegroundColor();
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public short getFillPattern() {
        return (short) this.patternFormatting.getFillPattern();
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public void setFillBackgroundColor(short s) {
        this.patternFormatting.setFillBackgroundColor(s);
        if (s != 0) {
            this.cfRuleRecord.setPatternBackgroundColorModified(true);
        }
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public void setFillForegroundColor(short s) {
        this.patternFormatting.setFillForegroundColor(s);
        if (s != 0) {
            this.cfRuleRecord.setPatternColorModified(true);
        }
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public void setFillPattern(short s) {
        this.patternFormatting.setFillPattern(s);
        if (s != 0) {
            this.cfRuleRecord.setPatternStyleModified(true);
        }
    }
}
