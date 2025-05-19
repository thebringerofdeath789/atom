package org.apache.poi.xslf.usermodel;

import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCell;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow;

/* loaded from: classes5.dex */
public class DrawingTableRow {
    private final CTTableRow row;

    public DrawingTableRow(CTTableRow cTTableRow) {
        this.row = cTTableRow;
    }

    public DrawingTableCell[] getCells() {
        CTTableCell[] tcArray = this.row.getTcArray();
        int length = tcArray.length;
        DrawingTableCell[] drawingTableCellArr = new DrawingTableCell[length];
        for (int i = 0; i < length; i++) {
            drawingTableCellArr[i] = new DrawingTableCell(tcArray[i]);
        }
        return drawingTableCellArr;
    }
}
