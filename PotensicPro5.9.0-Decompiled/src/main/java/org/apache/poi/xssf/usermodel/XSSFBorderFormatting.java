package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.BorderFormatting;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorderPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STBorderStyle;

/* loaded from: classes5.dex */
public class XSSFBorderFormatting implements BorderFormatting {
    CTBorder _border;

    XSSFBorderFormatting(CTBorder cTBorder) {
        this._border = cTBorder;
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBorderBottom() {
        if ((this._border.isSetBottom() ? this._border.getBottom().getStyle() : null) == null) {
            return (short) 0;
        }
        return (short) (r0.intValue() - 1);
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBorderDiagonal() {
        if ((this._border.isSetDiagonal() ? this._border.getDiagonal().getStyle() : null) == null) {
            return (short) 0;
        }
        return (short) (r0.intValue() - 1);
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBorderLeft() {
        if ((this._border.isSetLeft() ? this._border.getLeft().getStyle() : null) == null) {
            return (short) 0;
        }
        return (short) (r0.intValue() - 1);
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBorderRight() {
        if ((this._border.isSetRight() ? this._border.getRight().getStyle() : null) == null) {
            return (short) 0;
        }
        return (short) (r0.intValue() - 1);
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBorderTop() {
        if ((this._border.isSetTop() ? this._border.getTop().getStyle() : null) == null) {
            return (short) 0;
        }
        return (short) (r0.intValue() - 1);
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBottomBorderColor() {
        if (this._border.isSetBottom()) {
            return (short) this._border.getBottom().getColor().getIndexed();
        }
        return (short) 0;
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getDiagonalBorderColor() {
        if (this._border.isSetDiagonal()) {
            return (short) this._border.getDiagonal().getColor().getIndexed();
        }
        return (short) 0;
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getLeftBorderColor() {
        if (this._border.isSetLeft()) {
            return (short) this._border.getLeft().getColor().getIndexed();
        }
        return (short) 0;
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getRightBorderColor() {
        if (this._border.isSetRight()) {
            return (short) this._border.getRight().getColor().getIndexed();
        }
        return (short) 0;
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getTopBorderColor() {
        if (this._border.isSetTop()) {
            return (short) this._border.getTop().getColor().getIndexed();
        }
        return (short) 0;
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderBottom(short s) {
        CTBorderPr bottom = this._border.isSetBottom() ? this._border.getBottom() : this._border.addNewBottom();
        if (s == 0) {
            this._border.unsetBottom();
        } else {
            bottom.setStyle(STBorderStyle.Enum.forInt(s + 1));
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderDiagonal(short s) {
        CTBorderPr diagonal = this._border.isSetDiagonal() ? this._border.getDiagonal() : this._border.addNewDiagonal();
        if (s == 0) {
            this._border.unsetDiagonal();
        } else {
            diagonal.setStyle(STBorderStyle.Enum.forInt(s + 1));
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderLeft(short s) {
        CTBorderPr left = this._border.isSetLeft() ? this._border.getLeft() : this._border.addNewLeft();
        if (s == 0) {
            this._border.unsetLeft();
        } else {
            left.setStyle(STBorderStyle.Enum.forInt(s + 1));
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderRight(short s) {
        CTBorderPr right = this._border.isSetRight() ? this._border.getRight() : this._border.addNewRight();
        if (s == 0) {
            this._border.unsetRight();
        } else {
            right.setStyle(STBorderStyle.Enum.forInt(s + 1));
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderTop(short s) {
        CTBorderPr top = this._border.isSetTop() ? this._border.getTop() : this._border.addNewTop();
        if (s == 0) {
            this._border.unsetTop();
        } else {
            top.setStyle(STBorderStyle.Enum.forInt(s + 1));
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBottomBorderColor(short s) {
        CTBorderPr bottom = this._border.isSetBottom() ? this._border.getBottom() : this._border.addNewBottom();
        CTColor newInstance = CTColor.Factory.newInstance();
        newInstance.setIndexed(s);
        bottom.setColor(newInstance);
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setDiagonalBorderColor(short s) {
        CTBorderPr diagonal = this._border.isSetDiagonal() ? this._border.getDiagonal() : this._border.addNewDiagonal();
        CTColor newInstance = CTColor.Factory.newInstance();
        newInstance.setIndexed(s);
        diagonal.setColor(newInstance);
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setLeftBorderColor(short s) {
        CTBorderPr left = this._border.isSetLeft() ? this._border.getLeft() : this._border.addNewLeft();
        CTColor newInstance = CTColor.Factory.newInstance();
        newInstance.setIndexed(s);
        left.setColor(newInstance);
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setRightBorderColor(short s) {
        CTBorderPr right = this._border.isSetRight() ? this._border.getRight() : this._border.addNewRight();
        CTColor newInstance = CTColor.Factory.newInstance();
        newInstance.setIndexed(s);
        right.setColor(newInstance);
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setTopBorderColor(short s) {
        CTBorderPr top = this._border.isSetTop() ? this._border.getTop() : this._border.addNewTop();
        CTColor newInstance = CTColor.Factory.newInstance();
        newInstance.setIndexed(s);
        top.setColor(newInstance);
    }
}
