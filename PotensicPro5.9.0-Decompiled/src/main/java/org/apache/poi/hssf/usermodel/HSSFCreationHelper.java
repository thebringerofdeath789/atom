package org.apache.poi.hssf.usermodel;

import org.apache.poi.ss.usermodel.CreationHelper;

/* loaded from: classes5.dex */
public class HSSFCreationHelper implements CreationHelper {
    private HSSFDataFormat dataFormat;
    private HSSFWorkbook workbook;

    HSSFCreationHelper(HSSFWorkbook hSSFWorkbook) {
        this.workbook = hSSFWorkbook;
        this.dataFormat = new HSSFDataFormat(this.workbook.getWorkbook());
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public HSSFRichTextString createRichTextString(String str) {
        return new HSSFRichTextString(str);
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public HSSFDataFormat createDataFormat() {
        return this.dataFormat;
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public HSSFHyperlink createHyperlink(int i) {
        return new HSSFHyperlink(i);
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public HSSFFormulaEvaluator createFormulaEvaluator() {
        return new HSSFFormulaEvaluator(this.workbook);
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public HSSFClientAnchor createClientAnchor() {
        return new HSSFClientAnchor();
    }
}
