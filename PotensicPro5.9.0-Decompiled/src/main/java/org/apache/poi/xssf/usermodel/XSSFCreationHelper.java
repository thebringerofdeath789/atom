package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.CreationHelper;

/* loaded from: classes5.dex */
public class XSSFCreationHelper implements CreationHelper {
    private XSSFWorkbook workbook;

    XSSFCreationHelper(XSSFWorkbook xSSFWorkbook) {
        this.workbook = xSSFWorkbook;
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public XSSFRichTextString createRichTextString(String str) {
        XSSFRichTextString xSSFRichTextString = new XSSFRichTextString(str);
        xSSFRichTextString.setStylesTableReference(this.workbook.getStylesSource());
        return xSSFRichTextString;
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public XSSFDataFormat createDataFormat() {
        return this.workbook.createDataFormat();
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public XSSFHyperlink createHyperlink(int i) {
        return new XSSFHyperlink(i);
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public XSSFFormulaEvaluator createFormulaEvaluator() {
        return new XSSFFormulaEvaluator(this.workbook);
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public XSSFClientAnchor createClientAnchor() {
        return new XSSFClientAnchor();
    }
}
