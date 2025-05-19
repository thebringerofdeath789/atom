package org.apache.poi.xssf.usermodel;

import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShapeNonVisual;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;

/* loaded from: classes5.dex */
public final class XSSFShapeGroup extends XSSFShape {
    private static CTGroupShape prototype;
    private CTGroupShape ctGroup;

    protected XSSFShapeGroup(XSSFDrawing xSSFDrawing, CTGroupShape cTGroupShape) {
        this.drawing = xSSFDrawing;
        this.ctGroup = cTGroupShape;
    }

    protected static CTGroupShape prototype() {
        if (prototype == null) {
            CTGroupShape newInstance = CTGroupShape.Factory.newInstance();
            CTGroupShapeNonVisual addNewNvGrpSpPr = newInstance.addNewNvGrpSpPr();
            CTNonVisualDrawingProps addNewCNvPr = addNewNvGrpSpPr.addNewCNvPr();
            addNewCNvPr.setId(0L);
            addNewCNvPr.setName("Group 0");
            addNewNvGrpSpPr.addNewCNvGrpSpPr();
            CTGroupTransform2D addNewXfrm = newInstance.addNewGrpSpPr().addNewXfrm();
            CTPositiveSize2D addNewExt = addNewXfrm.addNewExt();
            addNewExt.setCx(0L);
            addNewExt.setCy(0L);
            CTPoint2D addNewOff = addNewXfrm.addNewOff();
            addNewOff.setX(0L);
            addNewOff.setY(0L);
            CTPositiveSize2D addNewChExt = addNewXfrm.addNewChExt();
            addNewChExt.setCx(0L);
            addNewChExt.setCy(0L);
            CTPoint2D addNewChOff = addNewXfrm.addNewChOff();
            addNewChOff.setX(0L);
            addNewChOff.setY(0L);
            prototype = newInstance;
        }
        return prototype;
    }

    public XSSFTextBox createTextbox(XSSFChildAnchor xSSFChildAnchor) {
        CTShape addNewSp = this.ctGroup.addNewSp();
        addNewSp.set(XSSFSimpleShape.prototype());
        XSSFTextBox xSSFTextBox = new XSSFTextBox(getDrawing(), addNewSp);
        xSSFTextBox.parent = this;
        xSSFTextBox.anchor = xSSFChildAnchor;
        xSSFTextBox.getCTShape().getSpPr().setXfrm(xSSFChildAnchor.getCTTransform2D());
        return xSSFTextBox;
    }

    public XSSFSimpleShape createSimpleShape(XSSFChildAnchor xSSFChildAnchor) {
        CTShape addNewSp = this.ctGroup.addNewSp();
        addNewSp.set(XSSFSimpleShape.prototype());
        XSSFSimpleShape xSSFSimpleShape = new XSSFSimpleShape(getDrawing(), addNewSp);
        xSSFSimpleShape.parent = this;
        xSSFSimpleShape.anchor = xSSFChildAnchor;
        xSSFSimpleShape.getCTShape().getSpPr().setXfrm(xSSFChildAnchor.getCTTransform2D());
        return xSSFSimpleShape;
    }

    public XSSFConnector createConnector(XSSFChildAnchor xSSFChildAnchor) {
        CTConnector addNewCxnSp = this.ctGroup.addNewCxnSp();
        addNewCxnSp.set(XSSFConnector.prototype());
        XSSFConnector xSSFConnector = new XSSFConnector(getDrawing(), addNewCxnSp);
        xSSFConnector.parent = this;
        xSSFConnector.anchor = xSSFChildAnchor;
        xSSFConnector.getCTConnector().getSpPr().setXfrm(xSSFChildAnchor.getCTTransform2D());
        return xSSFConnector;
    }

    public XSSFPicture createPicture(XSSFClientAnchor xSSFClientAnchor, int i) {
        PackageRelationship addPictureReference = getDrawing().addPictureReference(i);
        CTPicture addNewPic = this.ctGroup.addNewPic();
        addNewPic.set(XSSFPicture.prototype());
        XSSFPicture xSSFPicture = new XSSFPicture(getDrawing(), addNewPic);
        xSSFPicture.parent = this;
        xSSFPicture.anchor = xSSFClientAnchor;
        xSSFPicture.setPictureReference(addPictureReference);
        return xSSFPicture;
    }

    @Internal
    public CTGroupShape getCTGroupShape() {
        return this.ctGroup;
    }

    public void setCoordinates(int i, int i2, int i3, int i4) {
        CTGroupTransform2D xfrm = this.ctGroup.getGrpSpPr().getXfrm();
        CTPoint2D off = xfrm.getOff();
        long j = i;
        off.setX(j);
        long j2 = i2;
        off.setY(j2);
        CTPositiveSize2D ext = xfrm.getExt();
        long j3 = i3;
        ext.setCx(j3);
        long j4 = i4;
        ext.setCy(j4);
        CTPoint2D chOff = xfrm.getChOff();
        chOff.setX(j);
        chOff.setY(j2);
        CTPositiveSize2D chExt = xfrm.getChExt();
        chExt.setCx(j3);
        chExt.setCy(j4);
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFShape
    protected CTShapeProperties getShapeProperties() {
        throw new IllegalStateException("Not supported for shape group");
    }
}
