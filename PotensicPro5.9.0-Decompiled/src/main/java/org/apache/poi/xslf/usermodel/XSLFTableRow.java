package org.apache.poi.xslf.usermodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.util.Units;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCell;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow;

/* loaded from: classes5.dex */
public class XSLFTableRow implements Iterable<XSLFTableCell> {
    private List<XSLFTableCell> _cells;
    private CTTableRow _row;
    private XSLFTable _table;

    XSLFTableRow(CTTableRow cTTableRow, XSLFTable xSLFTable) {
        this._row = cTTableRow;
        this._table = xSLFTable;
        CTTableCell[] tcArray = cTTableRow.getTcArray();
        this._cells = new ArrayList(tcArray.length);
        for (CTTableCell cTTableCell : tcArray) {
            this._cells.add(new XSLFTableCell(cTTableCell, xSLFTable.getSheet()));
        }
    }

    public CTTableRow getXmlObject() {
        return this._row;
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFTableCell> iterator() {
        return this._cells.iterator();
    }

    public List<XSLFTableCell> getCells() {
        return Collections.unmodifiableList(this._cells);
    }

    public double getHeight() {
        return Units.toPoints(this._row.getH());
    }

    public void setHeight(double d) {
        this._row.setH(Units.toEMU(d));
    }

    public XSLFTableCell addCell() {
        CTTableCell addNewTc = this._row.addNewTc();
        addNewTc.set(XSLFTableCell.prototype());
        XSLFTableCell xSLFTableCell = new XSLFTableCell(addNewTc, this._table.getSheet());
        this._cells.add(xSLFTableCell);
        if (this._table.getNumberOfColumns() < this._row.sizeOfTcArray()) {
            this._table.getCTTable().getTblGrid().addNewGridCol().setW(Units.toEMU(100.0d));
        }
        return xSLFTableCell;
    }
}
