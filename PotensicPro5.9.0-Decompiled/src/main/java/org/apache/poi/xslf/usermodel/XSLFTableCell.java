package org.apache.poi.xslf.usermodel;

import java.awt.Color;
import org.apache.poi.util.Units;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCell;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.STCompoundLine;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineCap;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndLength;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndType;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndWidth;
import org.openxmlformats.schemas.drawingml.x2006.main.STPenAlignment;
import org.openxmlformats.schemas.drawingml.x2006.main.STPresetLineDashVal;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAnchoringType;

/* loaded from: classes5.dex */
public class XSLFTableCell extends XSLFTextShape {
    static double defaultBorderWidth = 1.0d;

    XSLFTableCell(CTTableCell cTTableCell, XSLFSheet xSLFSheet) {
        super(cTTableCell, xSLFSheet);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.xslf.usermodel.XSLFShape
    public CTTableCell getXmlObject() {
        return (CTTableCell) super.getXmlObject();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    protected CTTextBody getTextBody(boolean z) {
        CTTableCell xmlObject = getXmlObject();
        CTTextBody txBody = xmlObject.getTxBody();
        if (txBody != null || !z) {
            return txBody;
        }
        CTTextBody addNewTxBody = xmlObject.addNewTxBody();
        addNewTxBody.addNewBodyPr();
        addNewTxBody.addNewLstStyle();
        return addNewTxBody;
    }

    static CTTableCell prototype() {
        CTTableCell newInstance = CTTableCell.Factory.newInstance();
        CTTableCellProperties addNewTcPr = newInstance.addNewTcPr();
        addNewTcPr.addNewLnL().addNewNoFill();
        addNewTcPr.addNewLnR().addNewNoFill();
        addNewTcPr.addNewLnT().addNewNoFill();
        addNewTcPr.addNewLnB().addNewNoFill();
        return newInstance;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    public void setLeftInset(double d) {
        CTTableCellProperties tcPr = getXmlObject().getTcPr();
        if (tcPr == null) {
            tcPr = getXmlObject().addNewTcPr();
        }
        tcPr.setMarL(Units.toEMU(d));
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    public void setRightInset(double d) {
        CTTableCellProperties tcPr = getXmlObject().getTcPr();
        if (tcPr == null) {
            tcPr = getXmlObject().addNewTcPr();
        }
        tcPr.setMarR(Units.toEMU(d));
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    public void setTopInset(double d) {
        CTTableCellProperties tcPr = getXmlObject().getTcPr();
        if (tcPr == null) {
            tcPr = getXmlObject().addNewTcPr();
        }
        tcPr.setMarT(Units.toEMU(d));
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    public void setBottomInset(double d) {
        CTTableCellProperties tcPr = getXmlObject().getTcPr();
        if (tcPr == null) {
            tcPr = getXmlObject().addNewTcPr();
        }
        tcPr.setMarB(Units.toEMU(d));
    }

    public void setBorderLeft(double d) {
        CTTableCellProperties tcPr = getXmlObject().getTcPr();
        (tcPr.isSetLnL() ? tcPr.getLnL() : tcPr.addNewLnL()).setW(Units.toEMU(d));
    }

    public double getBorderLeft() {
        CTLineProperties lnL = getXmlObject().getTcPr().getLnL();
        return (lnL == null || !lnL.isSetW()) ? defaultBorderWidth : Units.toPoints(lnL.getW());
    }

    public void setBorderLeftColor(Color color) {
        CTTableCellProperties tcPr = getXmlObject().getTcPr();
        setLineColor(tcPr.isSetLnL() ? tcPr.getLnL() : tcPr.addNewLnL(), color);
    }

    public Color getBorderLeftColor() {
        return getLineColor(getXmlObject().getTcPr().getLnL());
    }

    public void setBorderRight(double d) {
        CTTableCellProperties tcPr = getXmlObject().getTcPr();
        (tcPr.isSetLnR() ? tcPr.getLnR() : tcPr.addNewLnR()).setW(Units.toEMU(d));
    }

    public double getBorderRight() {
        CTLineProperties lnR = getXmlObject().getTcPr().getLnR();
        return (lnR == null || !lnR.isSetW()) ? defaultBorderWidth : Units.toPoints(lnR.getW());
    }

    public void setBorderRightColor(Color color) {
        CTTableCellProperties tcPr = getXmlObject().getTcPr();
        setLineColor(tcPr.isSetLnR() ? tcPr.getLnR() : tcPr.addNewLnR(), color);
    }

    public Color getBorderRightColor() {
        return getLineColor(getXmlObject().getTcPr().getLnR());
    }

    public void setBorderTop(double d) {
        CTTableCellProperties tcPr = getXmlObject().getTcPr();
        (tcPr.isSetLnT() ? tcPr.getLnT() : tcPr.addNewLnT()).setW(Units.toEMU(d));
    }

    public double getBorderTop() {
        CTLineProperties lnT = getXmlObject().getTcPr().getLnT();
        return (lnT == null || !lnT.isSetW()) ? defaultBorderWidth : Units.toPoints(lnT.getW());
    }

    public void setBorderTopColor(Color color) {
        CTTableCellProperties tcPr = getXmlObject().getTcPr();
        setLineColor(tcPr.isSetLnT() ? tcPr.getLnT() : tcPr.addNewLnT(), color);
    }

    public Color getBorderTopColor() {
        return getLineColor(getXmlObject().getTcPr().getLnT());
    }

    public void setBorderBottom(double d) {
        CTTableCellProperties tcPr = getXmlObject().getTcPr();
        (tcPr.isSetLnB() ? tcPr.getLnB() : tcPr.addNewLnB()).setW(Units.toEMU(d));
    }

    public double getBorderBottom() {
        CTLineProperties lnB = getXmlObject().getTcPr().getLnB();
        return (lnB == null || !lnB.isSetW()) ? defaultBorderWidth : Units.toPoints(lnB.getW());
    }

    public void setBorderBottomColor(Color color) {
        CTTableCellProperties tcPr = getXmlObject().getTcPr();
        setLineColor(tcPr.isSetLnB() ? tcPr.getLnB() : tcPr.addNewLnB(), color);
    }

    public Color getBorderBottomColor() {
        return getLineColor(getXmlObject().getTcPr().getLnB());
    }

    private void setLineColor(CTLineProperties cTLineProperties, Color color) {
        if (color == null) {
            cTLineProperties.addNewNoFill();
            if (cTLineProperties.isSetSolidFill()) {
                cTLineProperties.unsetSolidFill();
                return;
            }
            return;
        }
        if (cTLineProperties.isSetNoFill()) {
            cTLineProperties.unsetNoFill();
        }
        if (!cTLineProperties.isSetPrstDash()) {
            cTLineProperties.addNewPrstDash().setVal(STPresetLineDashVal.SOLID);
        }
        cTLineProperties.setCmpd(STCompoundLine.SNG);
        cTLineProperties.setAlgn(STPenAlignment.CTR);
        cTLineProperties.setCap(STLineCap.FLAT);
        cTLineProperties.addNewRound();
        CTLineEndProperties addNewHeadEnd = cTLineProperties.addNewHeadEnd();
        addNewHeadEnd.setType(STLineEndType.NONE);
        addNewHeadEnd.setW(STLineEndWidth.MED);
        addNewHeadEnd.setLen(STLineEndLength.MED);
        CTLineEndProperties addNewTailEnd = cTLineProperties.addNewTailEnd();
        addNewTailEnd.setType(STLineEndType.NONE);
        addNewTailEnd.setW(STLineEndWidth.MED);
        addNewTailEnd.setLen(STLineEndLength.MED);
        CTSRgbColor newInstance = CTSRgbColor.Factory.newInstance();
        newInstance.setVal(new byte[]{(byte) color.getRed(), (byte) color.getGreen(), (byte) color.getBlue()});
        cTLineProperties.addNewSolidFill().setSrgbClr(newInstance);
    }

    private Color getLineColor(CTLineProperties cTLineProperties) {
        if (cTLineProperties == null || cTLineProperties.isSetNoFill() || !cTLineProperties.isSetSolidFill()) {
            return null;
        }
        CTSolidColorFillProperties solidFill = cTLineProperties.getSolidFill();
        if (!solidFill.isSetSrgbClr()) {
            return null;
        }
        byte[] val = solidFill.getSrgbClr().getVal();
        return new Color(val[0] & 255, val[1] & 255, val[2] & 255);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape
    public void setFillColor(Color color) {
        CTTableCellProperties tcPr = getXmlObject().getTcPr();
        if (color == null) {
            if (tcPr.isSetSolidFill()) {
                tcPr.unsetSolidFill();
            }
        } else {
            CTSolidColorFillProperties solidFill = tcPr.isSetSolidFill() ? tcPr.getSolidFill() : tcPr.addNewSolidFill();
            CTSRgbColor newInstance = CTSRgbColor.Factory.newInstance();
            newInstance.setVal(new byte[]{(byte) color.getRed(), (byte) color.getGreen(), (byte) color.getBlue()});
            solidFill.setSrgbClr(newInstance);
        }
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape
    public Color getFillColor() {
        CTTableCellProperties tcPr = getXmlObject().getTcPr();
        if (!tcPr.isSetSolidFill()) {
            return null;
        }
        CTSolidColorFillProperties solidFill = tcPr.getSolidFill();
        if (!solidFill.isSetSrgbClr()) {
            return null;
        }
        byte[] val = solidFill.getSrgbClr().getVal();
        return new Color(val[0] & 255, val[1] & 255, val[2] & 255);
    }

    void setGridSpan(int i) {
        getXmlObject().setGridSpan(i);
    }

    void setRowSpan(int i) {
        getXmlObject().setRowSpan(i);
    }

    void setHMerge(boolean z) {
        getXmlObject().setHMerge(z);
    }

    void setVMerge(boolean z) {
        getXmlObject().setVMerge(z);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    public void setVerticalAlignment(VerticalAlignment verticalAlignment) {
        CTTableCellProperties tcPr = getXmlObject().getTcPr();
        if (tcPr != null) {
            if (verticalAlignment == null) {
                if (tcPr.isSetAnchor()) {
                    tcPr.unsetAnchor();
                    return;
                }
                return;
            }
            tcPr.setAnchor(STTextAnchoringType.Enum.forInt(verticalAlignment.ordinal() + 1));
        }
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    public VerticalAlignment getVerticalAlignment() {
        CTTableCellProperties tcPr = getXmlObject().getTcPr();
        VerticalAlignment verticalAlignment = VerticalAlignment.TOP;
        if (tcPr == null || !tcPr.isSetAnchor()) {
            return verticalAlignment;
        }
        return VerticalAlignment.values()[tcPr.getAnchor().intValue() - 1];
    }
}
