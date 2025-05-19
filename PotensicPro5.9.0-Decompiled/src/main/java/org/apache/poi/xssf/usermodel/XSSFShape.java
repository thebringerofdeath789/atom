package org.apache.poi.xssf.usermodel;

import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetLineDashProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STPresetLineDashVal;

/* loaded from: classes5.dex */
public abstract class XSSFShape {
    public static final int EMU_PER_PIXEL = 9525;
    public static final int EMU_PER_POINT = 12700;
    public static final int PIXEL_DPI = 96;
    public static final int POINT_DPI = 72;
    protected XSSFAnchor anchor;
    protected XSSFDrawing drawing;
    protected XSSFShapeGroup parent;

    protected abstract CTShapeProperties getShapeProperties();

    public XSSFDrawing getDrawing() {
        return this.drawing;
    }

    public XSSFShapeGroup getParent() {
        return this.parent;
    }

    public XSSFAnchor getAnchor() {
        return this.anchor;
    }

    public boolean isNoFill() {
        return getShapeProperties().isSetNoFill();
    }

    public void setNoFill(boolean z) {
        CTShapeProperties shapeProperties = getShapeProperties();
        if (shapeProperties.isSetPattFill()) {
            shapeProperties.unsetPattFill();
        }
        if (shapeProperties.isSetSolidFill()) {
            shapeProperties.unsetSolidFill();
        }
        shapeProperties.setNoFill(CTNoFillProperties.Factory.newInstance());
    }

    public void setFillColor(int i, int i2, int i3) {
        CTShapeProperties shapeProperties = getShapeProperties();
        CTSolidColorFillProperties solidFill = shapeProperties.isSetSolidFill() ? shapeProperties.getSolidFill() : shapeProperties.addNewSolidFill();
        CTSRgbColor newInstance = CTSRgbColor.Factory.newInstance();
        newInstance.setVal(new byte[]{(byte) i, (byte) i2, (byte) i3});
        solidFill.setSrgbClr(newInstance);
    }

    public void setLineStyleColor(int i, int i2, int i3) {
        CTShapeProperties shapeProperties = getShapeProperties();
        CTLineProperties ln = shapeProperties.isSetLn() ? shapeProperties.getLn() : shapeProperties.addNewLn();
        CTSolidColorFillProperties solidFill = ln.isSetSolidFill() ? ln.getSolidFill() : ln.addNewSolidFill();
        CTSRgbColor newInstance = CTSRgbColor.Factory.newInstance();
        newInstance.setVal(new byte[]{(byte) i, (byte) i2, (byte) i3});
        solidFill.setSrgbClr(newInstance);
    }

    public void setLineWidth(double d) {
        CTShapeProperties shapeProperties = getShapeProperties();
        (shapeProperties.isSetLn() ? shapeProperties.getLn() : shapeProperties.addNewLn()).setW((int) (d * 12700.0d));
    }

    public void setLineStyle(int i) {
        CTShapeProperties shapeProperties = getShapeProperties();
        CTLineProperties ln = shapeProperties.isSetLn() ? shapeProperties.getLn() : shapeProperties.addNewLn();
        CTPresetLineDashProperties newInstance = CTPresetLineDashProperties.Factory.newInstance();
        newInstance.setVal(STPresetLineDashVal.Enum.forInt(i + 1));
        ln.setPrstDash(newInstance);
    }
}
