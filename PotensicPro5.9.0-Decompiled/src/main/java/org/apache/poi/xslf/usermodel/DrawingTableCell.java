package org.apache.poi.xslf.usermodel;

import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCell;

/* loaded from: classes5.dex */
public class DrawingTableCell {
    private final CTTableCell cell;
    private final DrawingTextBody drawingTextBody;

    public DrawingTableCell(CTTableCell cTTableCell) {
        this.cell = cTTableCell;
        this.drawingTextBody = new DrawingTextBody(cTTableCell.getTxBody());
    }

    public DrawingTextBody getTextBody() {
        return this.drawingTextBody;
    }
}
