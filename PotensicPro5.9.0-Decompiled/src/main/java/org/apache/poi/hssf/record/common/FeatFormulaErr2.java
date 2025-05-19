package org.apache.poi.hssf.record.common;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class FeatFormulaErr2 implements SharedFeature {
    private int errorCheck;
    static BitField checkCalculationErrors = BitFieldFactory.getInstance(1);
    static BitField checkEmptyCellRef = BitFieldFactory.getInstance(2);
    static BitField checkNumbersAsText = BitFieldFactory.getInstance(4);
    static BitField checkInconsistentRanges = BitFieldFactory.getInstance(8);
    static BitField checkInconsistentFormulas = BitFieldFactory.getInstance(16);
    static BitField checkDateTimeFormats = BitFieldFactory.getInstance(32);
    static BitField checkUnprotectedFormulas = BitFieldFactory.getInstance(64);
    static BitField performDataValidation = BitFieldFactory.getInstance(128);

    @Override // org.apache.poi.hssf.record.common.SharedFeature
    public int getDataSize() {
        return 4;
    }

    public FeatFormulaErr2() {
    }

    public FeatFormulaErr2(RecordInputStream recordInputStream) {
        this.errorCheck = recordInputStream.readInt();
    }

    @Override // org.apache.poi.hssf.record.common.SharedFeature
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" [FEATURE FORMULA ERRORS]\n");
        stringBuffer.append("  checkCalculationErrors    = ");
        stringBuffer.append("  checkEmptyCellRef         = ");
        stringBuffer.append("  checkNumbersAsText        = ");
        stringBuffer.append("  checkInconsistentRanges   = ");
        stringBuffer.append("  checkInconsistentFormulas = ");
        stringBuffer.append("  checkDateTimeFormats      = ");
        stringBuffer.append("  checkUnprotectedFormulas  = ");
        stringBuffer.append("  performDataValidation     = ");
        stringBuffer.append(" [/FEATURE FORMULA ERRORS]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.common.SharedFeature
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(this.errorCheck);
    }

    public int _getRawErrorCheckValue() {
        return this.errorCheck;
    }

    public boolean getCheckCalculationErrors() {
        return checkCalculationErrors.isSet(this.errorCheck);
    }

    public void setCheckCalculationErrors(boolean z) {
        checkCalculationErrors.setBoolean(this.errorCheck, z);
    }

    public boolean getCheckEmptyCellRef() {
        return checkEmptyCellRef.isSet(this.errorCheck);
    }

    public void setCheckEmptyCellRef(boolean z) {
        checkEmptyCellRef.setBoolean(this.errorCheck, z);
    }

    public boolean getCheckNumbersAsText() {
        return checkNumbersAsText.isSet(this.errorCheck);
    }

    public void setCheckNumbersAsText(boolean z) {
        checkNumbersAsText.setBoolean(this.errorCheck, z);
    }

    public boolean getCheckInconsistentRanges() {
        return checkInconsistentRanges.isSet(this.errorCheck);
    }

    public void setCheckInconsistentRanges(boolean z) {
        checkInconsistentRanges.setBoolean(this.errorCheck, z);
    }

    public boolean getCheckInconsistentFormulas() {
        return checkInconsistentFormulas.isSet(this.errorCheck);
    }

    public void setCheckInconsistentFormulas(boolean z) {
        checkInconsistentFormulas.setBoolean(this.errorCheck, z);
    }

    public boolean getCheckDateTimeFormats() {
        return checkDateTimeFormats.isSet(this.errorCheck);
    }

    public void setCheckDateTimeFormats(boolean z) {
        checkDateTimeFormats.setBoolean(this.errorCheck, z);
    }

    public boolean getCheckUnprotectedFormulas() {
        return checkUnprotectedFormulas.isSet(this.errorCheck);
    }

    public void setCheckUnprotectedFormulas(boolean z) {
        checkUnprotectedFormulas.setBoolean(this.errorCheck, z);
    }

    public boolean getPerformDataValidation() {
        return performDataValidation.isSet(this.errorCheck);
    }

    public void setPerformDataValidation(boolean z) {
        performDataValidation.setBoolean(this.errorCheck, z);
    }
}
