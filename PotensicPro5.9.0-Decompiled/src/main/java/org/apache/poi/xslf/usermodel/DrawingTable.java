package org.apache.poi.xslf.usermodel;

import org.openxmlformats.schemas.drawingml.x2006.main.CTTable;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow;

/* loaded from: classes5.dex */
public class DrawingTable {
    private final CTTable table;

    public DrawingTable(CTTable cTTable) {
        this.table = cTTable;
    }

    public DrawingTableRow[] getRows() {
        CTTableRow[] trArray = this.table.getTrArray();
        int length = trArray.length;
        DrawingTableRow[] drawingTableRowArr = new DrawingTableRow[length];
        for (int i = 0; i < length; i++) {
            drawingTableRowArr[i] = new DrawingTableRow(trArray[i]);
        }
        return drawingTableRowArr;
    }
}
