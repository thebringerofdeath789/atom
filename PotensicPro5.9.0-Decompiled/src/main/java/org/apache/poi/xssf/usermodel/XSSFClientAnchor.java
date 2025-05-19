package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;

/* loaded from: classes5.dex */
public final class XSSFClientAnchor extends XSSFAnchor implements ClientAnchor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int anchorType;
    private CTMarker cell1;
    private CTMarker cell2;

    public int hashCode() {
        return 42;
    }

    public XSSFClientAnchor() {
        CTMarker newInstance = CTMarker.Factory.newInstance();
        this.cell1 = newInstance;
        newInstance.setCol(0);
        this.cell1.setColOff(0L);
        this.cell1.setRow(0);
        this.cell1.setRowOff(0L);
        CTMarker newInstance2 = CTMarker.Factory.newInstance();
        this.cell2 = newInstance2;
        newInstance2.setCol(0);
        this.cell2.setColOff(0L);
        this.cell2.setRow(0);
        this.cell2.setRowOff(0L);
    }

    public XSSFClientAnchor(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this();
        this.cell1.setCol(i5);
        this.cell1.setColOff(i);
        this.cell1.setRow(i6);
        this.cell1.setRowOff(i2);
        this.cell2.setCol(i7);
        this.cell2.setColOff(i3);
        this.cell2.setRow(i8);
        this.cell2.setRowOff(i4);
    }

    protected XSSFClientAnchor(CTMarker cTMarker, CTMarker cTMarker2) {
        this.cell1 = cTMarker;
        this.cell2 = cTMarker2;
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public short getCol1() {
        return (short) this.cell1.getCol();
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setCol1(int i) {
        this.cell1.setCol(i);
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public short getCol2() {
        return (short) this.cell2.getCol();
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setCol2(int i) {
        this.cell2.setCol(i);
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public int getRow1() {
        return this.cell1.getRow();
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setRow1(int i) {
        this.cell1.setRow(i);
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public int getRow2() {
        return this.cell2.getRow();
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setRow2(int i) {
        this.cell2.setRow(i);
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFAnchor
    public int getDx1() {
        return (int) this.cell1.getColOff();
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFAnchor
    public void setDx1(int i) {
        this.cell1.setColOff(i);
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFAnchor
    public int getDy1() {
        return (int) this.cell1.getRowOff();
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFAnchor
    public void setDy1(int i) {
        this.cell1.setRowOff(i);
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFAnchor
    public int getDy2() {
        return (int) this.cell2.getRowOff();
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFAnchor
    public void setDy2(int i) {
        this.cell2.setRowOff(i);
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFAnchor
    public int getDx2() {
        return (int) this.cell2.getColOff();
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFAnchor
    public void setDx2(int i) {
        this.cell2.setColOff(i);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof XSSFClientAnchor)) {
            return false;
        }
        XSSFClientAnchor xSSFClientAnchor = (XSSFClientAnchor) obj;
        return getDx1() == xSSFClientAnchor.getDx1() && getDx2() == xSSFClientAnchor.getDx2() && getDy1() == xSSFClientAnchor.getDy1() && getDy2() == xSSFClientAnchor.getDy2() && getCol1() == xSSFClientAnchor.getCol1() && getCol2() == xSSFClientAnchor.getCol2() && getRow1() == xSSFClientAnchor.getRow1() && getRow2() == xSSFClientAnchor.getRow2();
    }

    public String toString() {
        return "from : " + this.cell1.toString() + "; to: " + this.cell2.toString();
    }

    @Internal
    public CTMarker getFrom() {
        return this.cell1;
    }

    protected void setFrom(CTMarker cTMarker) {
        this.cell1 = cTMarker;
    }

    @Internal
    public CTMarker getTo() {
        return this.cell2;
    }

    protected void setTo(CTMarker cTMarker) {
        this.cell2 = cTMarker;
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setAnchorType(int i) {
        this.anchorType = i;
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public int getAnchorType() {
        return this.anchorType;
    }

    public boolean isSet() {
        return (this.cell1.getCol() == 0 && this.cell2.getCol() == 0 && this.cell1.getRow() == 0 && this.cell2.getRow() == 0) ? false : true;
    }
}
