package org.apache.poi.xwpf.usermodel;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell;

/* loaded from: classes5.dex */
public class XWPFSDTCell extends AbstractXWPFSDT implements ICell {
    private final XWPFSDTContentCell cellContent;

    public XWPFSDTCell(CTSdtCell cTSdtCell, XWPFTableRow xWPFTableRow, IBody iBody) {
        super(cTSdtCell.getSdtPr(), iBody);
        this.cellContent = new XWPFSDTContentCell(cTSdtCell.getSdtContent(), xWPFTableRow, iBody);
    }

    @Override // org.apache.poi.xwpf.usermodel.AbstractXWPFSDT
    public ISDTContent getContent() {
        return this.cellContent;
    }
}
