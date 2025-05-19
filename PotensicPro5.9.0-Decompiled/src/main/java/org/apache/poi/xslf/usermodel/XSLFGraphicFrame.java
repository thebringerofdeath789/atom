package org.apache.poi.xslf.usermodel;

import aavax.xml.namespace.QName;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import org.apache.poi.POIXMLException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.util.Units;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;

/* loaded from: classes5.dex */
public class XSLFGraphicFrame extends XSLFShape {
    private final CTGraphicalObjectFrame _shape;
    private final XSLFSheet _sheet;

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public void draw(Graphics2D graphics2D) {
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public boolean getFlipHorizontal() {
        return false;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public boolean getFlipVertical() {
        return false;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public double getRotation() {
        return 0.0d;
    }

    XSLFGraphicFrame(CTGraphicalObjectFrame cTGraphicalObjectFrame, XSLFSheet xSLFSheet) {
        this._shape = cTGraphicalObjectFrame;
        this._sheet = xSLFSheet;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public CTGraphicalObjectFrame getXmlObject() {
        return this._shape;
    }

    public XSLFSheet getSheet() {
        return this._sheet;
    }

    public int getShapeType() {
        throw new RuntimeException("NotImplemented");
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public int getShapeId() {
        return (int) this._shape.getNvGraphicFramePr().getCNvPr().getId();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public String getShapeName() {
        return this._shape.getNvGraphicFramePr().getCNvPr().getName();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public Rectangle2D getAnchor() {
        CTTransform2D xfrm = this._shape.getXfrm();
        CTPoint2D off = xfrm.getOff();
        long x = off.getX();
        long y = off.getY();
        CTPositiveSize2D ext = xfrm.getExt();
        return new Rectangle2D.Double(Units.toPoints(x), Units.toPoints(y), Units.toPoints(ext.getCx()), Units.toPoints(ext.getCy()));
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public void setAnchor(Rectangle2D rectangle2D) {
        CTTransform2D xfrm = this._shape.getXfrm();
        CTPoint2D off = xfrm.isSetOff() ? xfrm.getOff() : xfrm.addNewOff();
        long emu = Units.toEMU(rectangle2D.getX());
        long emu2 = Units.toEMU(rectangle2D.getY());
        off.setX(emu);
        off.setY(emu2);
        CTPositiveSize2D ext = xfrm.isSetExt() ? xfrm.getExt() : xfrm.addNewExt();
        long emu3 = Units.toEMU(rectangle2D.getWidth());
        long emu4 = Units.toEMU(rectangle2D.getHeight());
        ext.setCx(emu3);
        ext.setCy(emu4);
    }

    static XSLFGraphicFrame create(CTGraphicalObjectFrame cTGraphicalObjectFrame, XSLFSheet xSLFSheet) {
        if (XSLFTable.TABLE_URI.equals(cTGraphicalObjectFrame.getGraphic().getGraphicData().getUri())) {
            return new XSLFTable(cTGraphicalObjectFrame, xSLFSheet);
        }
        return new XSLFGraphicFrame(cTGraphicalObjectFrame, xSLFSheet);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public void setRotation(double d) {
        throw new IllegalArgumentException("Operation not supported");
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public void setFlipHorizontal(boolean z) {
        throw new IllegalArgumentException("Operation not supported");
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public void setFlipVertical(boolean z) {
        throw new IllegalArgumentException("Operation not supported");
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    void copy(XSLFShape xSLFShape) {
        super.copy(xSLFShape);
        CTGraphicalObjectData graphicData = this._shape.getGraphic().getGraphicData();
        if (graphicData.getUri().equals("http://schemas.openxmlformats.org/drawingml/2006/diagram")) {
            copyDiagram(graphicData, (XSLFGraphicFrame) xSLFShape);
        }
    }

    private void copyDiagram(CTGraphicalObjectData cTGraphicalObjectData, XSLFGraphicFrame xSLFGraphicFrame) {
        XmlObject[] selectPath = cTGraphicalObjectData.selectPath("declare namespace dgm='http://schemas.openxmlformats.org/drawingml/2006/diagram' $this//dgm:relIds");
        if (selectPath == null || selectPath.length != 1) {
            return;
        }
        XmlCursor newCursor = selectPath[0].newCursor();
        XSLFSheet sheet = xSLFGraphicFrame.getSheet();
        try {
            PackageRelationship relationship = sheet.getPackagePart().getRelationship(newCursor.getAttributeText(new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "dm")));
            this._sheet.importPart(relationship, sheet.getPackagePart().getRelatedPart(relationship));
            PackageRelationship relationship2 = sheet.getPackagePart().getRelationship(newCursor.getAttributeText(new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "lo")));
            this._sheet.importPart(relationship2, sheet.getPackagePart().getRelatedPart(relationship2));
            PackageRelationship relationship3 = sheet.getPackagePart().getRelationship(newCursor.getAttributeText(new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "qs")));
            this._sheet.importPart(relationship3, sheet.getPackagePart().getRelatedPart(relationship3));
            PackageRelationship relationship4 = sheet.getPackagePart().getRelationship(newCursor.getAttributeText(new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "cs")));
            this._sheet.importPart(relationship4, sheet.getPackagePart().getRelatedPart(relationship4));
            newCursor.dispose();
        } catch (InvalidFormatException e) {
            throw new POIXMLException(e);
        }
    }
}
