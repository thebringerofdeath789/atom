package org.apache.poi.xslf.usermodel;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.POIXMLException;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Units;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTable;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrameNonVisual;

/* loaded from: classes5.dex */
public class XSLFTable extends XSLFGraphicFrame implements Iterable<XSLFTableRow> {
    static String TABLE_URI = "http://schemas.openxmlformats.org/drawingml/2006/table";
    private List<XSLFTableRow> _rows;
    private CTTable _table;

    XSLFTable(CTGraphicalObjectFrame cTGraphicalObjectFrame, XSLFSheet xSLFSheet) {
        super(cTGraphicalObjectFrame, xSLFSheet);
        XmlObject[] selectPath = cTGraphicalObjectFrame.getGraphic().getGraphicData().selectPath("declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' ./a:tbl");
        if (selectPath.length == 0) {
            throw new IllegalStateException("a:tbl element was not found in\n " + cTGraphicalObjectFrame.getGraphic().getGraphicData());
        }
        if (selectPath[0] instanceof XmlAnyTypeImpl) {
            try {
                selectPath[0] = CTTable.Factory.parse(selectPath[0].toString());
            } catch (XmlException e) {
                throw new POIXMLException(e);
            }
        }
        CTTable cTTable = (CTTable) selectPath[0];
        this._table = cTTable;
        CTTableRow[] trArray = cTTable.getTrArray();
        this._rows = new ArrayList(trArray.length);
        for (CTTableRow cTTableRow : trArray) {
            this._rows.add(new XSLFTableRow(cTTableRow, this));
        }
    }

    @Internal
    public CTTable getCTTable() {
        return this._table;
    }

    public int getNumberOfColumns() {
        return this._table.getTblGrid().sizeOfGridColArray();
    }

    public int getNumberOfRows() {
        return this._table.sizeOfTrArray();
    }

    public double getColumnWidth(int i) {
        return Units.toPoints(this._table.getTblGrid().getGridColArray(i).getW());
    }

    public void setColumnWidth(int i, double d) {
        this._table.getTblGrid().getGridColArray(i).setW(Units.toEMU(d));
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFTableRow> iterator() {
        return this._rows.iterator();
    }

    public List<XSLFTableRow> getRows() {
        return Collections.unmodifiableList(this._rows);
    }

    public XSLFTableRow addRow() {
        XSLFTableRow xSLFTableRow = new XSLFTableRow(this._table.addNewTr(), this);
        xSLFTableRow.setHeight(20.0d);
        this._rows.add(xSLFTableRow);
        return xSLFTableRow;
    }

    static CTGraphicalObjectFrame prototype(int i) {
        CTGraphicalObjectFrame newInstance = CTGraphicalObjectFrame.Factory.newInstance();
        CTGraphicalObjectFrameNonVisual addNewNvGraphicFramePr = newInstance.addNewNvGraphicFramePr();
        CTNonVisualDrawingProps addNewCNvPr = addNewNvGraphicFramePr.addNewCNvPr();
        addNewCNvPr.setName("Table " + i);
        addNewCNvPr.setId(i + 1);
        addNewNvGraphicFramePr.addNewCNvGraphicFramePr().addNewGraphicFrameLocks().setNoGrp(true);
        addNewNvGraphicFramePr.addNewNvPr();
        newInstance.addNewXfrm();
        CTGraphicalObjectData addNewGraphicData = newInstance.addNewGraphic().addNewGraphicData();
        XmlCursor newCursor = addNewGraphicData.newCursor();
        newCursor.toNextToken();
        newCursor.beginElement(new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tbl"));
        newCursor.beginElement(new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tblPr"));
        newCursor.toNextToken();
        newCursor.beginElement(new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tblGrid"));
        newCursor.dispose();
        addNewGraphicData.setUri(TABLE_URI);
        return newInstance;
    }

    public void mergeCells(int i, int i2, int i3, int i4) {
        if (i > i2) {
            throw new IllegalArgumentException("Cannot merge, first row > last row : " + i + " > " + i2);
        }
        if (i3 > i4) {
            throw new IllegalArgumentException("Cannot merge, first column > last column : " + i3 + " > " + i4);
        }
        int i5 = (i2 - i) + 1;
        boolean z = i5 > 1;
        int i6 = (i4 - i3) + 1;
        boolean z2 = i6 > 1;
        for (int i7 = i; i7 <= i2; i7++) {
            XSLFTableRow xSLFTableRow = this._rows.get(i7);
            for (int i8 = i3; i8 <= i4; i8++) {
                XSLFTableCell xSLFTableCell = xSLFTableRow.getCells().get(i8);
                if (z) {
                    if (i7 == i) {
                        xSLFTableCell.setRowSpan(i5);
                    } else {
                        xSLFTableCell.setVMerge(true);
                    }
                }
                if (z2) {
                    if (i8 == i3) {
                        xSLFTableCell.setGridSpan(i6);
                    } else {
                        xSLFTableCell.setHMerge(true);
                    }
                }
            }
        }
    }
}
