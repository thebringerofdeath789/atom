package org.apache.poi.xwpf.usermodel;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;

/* loaded from: classes5.dex */
public class XWPFTableRow {
    private CTRow ctRow;
    private XWPFTable table;
    private List<XWPFTableCell> tableCells;

    public XWPFTableRow(CTRow cTRow, XWPFTable xWPFTable) {
        this.table = xWPFTable;
        this.ctRow = cTRow;
        getTableCells();
    }

    @Internal
    public CTRow getCtRow() {
        return this.ctRow;
    }

    public XWPFTableCell createCell() {
        XWPFTableCell xWPFTableCell = new XWPFTableCell(this.ctRow.addNewTc(), this, this.table.getBody());
        this.tableCells.add(xWPFTableCell);
        return xWPFTableCell;
    }

    public XWPFTableCell getCell(int i) {
        if (i < 0 || i >= this.ctRow.sizeOfTcArray()) {
            return null;
        }
        return getTableCells().get(i);
    }

    public void removeCell(int i) {
        if (i < 0 || i >= this.ctRow.sizeOfTcArray()) {
            return;
        }
        this.tableCells.remove(i);
    }

    public XWPFTableCell addNewTableCell() {
        XWPFTableCell xWPFTableCell = new XWPFTableCell(this.ctRow.addNewTc(), this, this.table.getBody());
        this.tableCells.add(xWPFTableCell);
        return xWPFTableCell;
    }

    public void setHeight(int i) {
        CTTrPr trPr = getTrPr();
        (trPr.sizeOfTrHeightArray() == 0 ? trPr.addNewTrHeight() : trPr.getTrHeightArray(0)).setVal(new BigInteger("" + i));
    }

    public int getHeight() {
        CTTrPr trPr = getTrPr();
        if (trPr.sizeOfTrHeightArray() == 0) {
            return 0;
        }
        return trPr.getTrHeightArray(0).getVal().intValue();
    }

    private CTTrPr getTrPr() {
        return this.ctRow.isSetTrPr() ? this.ctRow.getTrPr() : this.ctRow.addNewTrPr();
    }

    public XWPFTable getTable() {
        return this.table;
    }

    public List<ICell> getTableICells() {
        ArrayList arrayList = new ArrayList();
        XmlCursor newCursor = this.ctRow.newCursor();
        newCursor.selectPath("./*");
        while (newCursor.toNextSelection()) {
            XmlObject object = newCursor.getObject();
            if (object instanceof CTTc) {
                arrayList.add(new XWPFTableCell((CTTc) object, this, this.table.getBody()));
            } else if (object instanceof CTSdtCell) {
                arrayList.add(new XWPFSDTCell((CTSdtCell) object, this, this.table.getBody()));
            }
        }
        return arrayList;
    }

    public List<XWPFTableCell> getTableCells() {
        if (this.tableCells == null) {
            ArrayList arrayList = new ArrayList();
            for (CTTc cTTc : this.ctRow.getTcArray()) {
                arrayList.add(new XWPFTableCell(cTTc, this, this.table.getBody()));
            }
            this.tableCells = arrayList;
        }
        return this.tableCells;
    }

    public XWPFTableCell getTableCell(CTTc cTTc) {
        for (int i = 0; i < this.tableCells.size(); i++) {
            if (this.tableCells.get(i).getCTTc() == cTTc) {
                return this.tableCells.get(i);
            }
        }
        return null;
    }

    public void setCantSplitRow(boolean z) {
        getTrPr().addNewCantSplit().setVal(z ? STOnOff.ON : STOnOff.OFF);
    }

    public boolean isCantSplitRow() {
        CTTrPr trPr = getTrPr();
        if (trPr.sizeOfCantSplitArray() > 0) {
            return trPr.getCantSplitArray(0).getVal().equals(STOnOff.ON);
        }
        return false;
    }

    public void setRepeatHeader(boolean z) {
        getTrPr().addNewTblHeader().setVal(z ? STOnOff.ON : STOnOff.OFF);
    }

    public boolean isRepeatHeader() {
        CTTrPr trPr = getTrPr();
        if (trPr.sizeOfTblHeaderArray() > 0) {
            return trPr.getTblHeaderArray(0).getVal().equals(STOnOff.ON);
        }
        return false;
    }
}
