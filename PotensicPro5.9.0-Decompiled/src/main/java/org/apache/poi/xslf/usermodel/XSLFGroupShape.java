package org.apache.poi.xslf.usermodel;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.util.Units;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.presentationml.x2006.main.CTConnector;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;

/* loaded from: classes5.dex */
public class XSLFGroupShape extends XSLFShape implements XSLFShapeContainer {
    private XSLFDrawing _drawing;
    private final CTGroupShape _shape;
    private final List<XSLFShape> _shapes;
    private final XSLFSheet _sheet;
    private final CTGroupShapeProperties _spPr;

    XSLFGroupShape(CTGroupShape cTGroupShape, XSLFSheet xSLFSheet) {
        this._shape = cTGroupShape;
        this._sheet = xSLFSheet;
        this._shapes = xSLFSheet.buildShapes(cTGroupShape);
        this._spPr = cTGroupShape.getGrpSpPr();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public CTGroupShape getXmlObject() {
        return this._shape;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public Rectangle2D getAnchor() {
        CTGroupTransform2D xfrm = this._spPr.getXfrm();
        CTPoint2D off = xfrm.getOff();
        long x = off.getX();
        long y = off.getY();
        CTPositiveSize2D ext = xfrm.getExt();
        return new Rectangle2D.Double(Units.toPoints(x), Units.toPoints(y), Units.toPoints(ext.getCx()), Units.toPoints(ext.getCy()));
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public void setAnchor(Rectangle2D rectangle2D) {
        CTGroupTransform2D xfrm = this._spPr.isSetXfrm() ? this._spPr.getXfrm() : this._spPr.addNewXfrm();
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

    public Rectangle2D getInteriorAnchor() {
        CTGroupTransform2D xfrm = this._spPr.getXfrm();
        CTPoint2D chOff = xfrm.getChOff();
        long x = chOff.getX();
        long y = chOff.getY();
        CTPositiveSize2D chExt = xfrm.getChExt();
        return new Rectangle2D.Double(Units.toPoints(x), Units.toPoints(y), Units.toPoints(chExt.getCx()), Units.toPoints(chExt.getCy()));
    }

    public void setInteriorAnchor(Rectangle2D rectangle2D) {
        CTGroupTransform2D xfrm = this._spPr.isSetXfrm() ? this._spPr.getXfrm() : this._spPr.addNewXfrm();
        CTPoint2D chOff = xfrm.isSetChOff() ? xfrm.getChOff() : xfrm.addNewChOff();
        long emu = Units.toEMU(rectangle2D.getX());
        long emu2 = Units.toEMU(rectangle2D.getY());
        chOff.setX(emu);
        chOff.setY(emu2);
        CTPositiveSize2D chExt = xfrm.isSetChExt() ? xfrm.getChExt() : xfrm.addNewChExt();
        long emu3 = Units.toEMU(rectangle2D.getWidth());
        long emu4 = Units.toEMU(rectangle2D.getHeight());
        chExt.setCx(emu3);
        chExt.setCy(emu4);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer
    public XSLFShape[] getShapes() {
        List<XSLFShape> list = this._shapes;
        return (XSLFShape[]) list.toArray(new XSLFShape[list.size()]);
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFShape> iterator() {
        return this._shapes.iterator();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer
    public boolean removeShape(XSLFShape xSLFShape) {
        XmlObject xmlObject = xSLFShape.getXmlObject();
        if (xmlObject instanceof CTShape) {
            this._shape.getSpList().remove(xmlObject);
        } else if (xmlObject instanceof CTGroupShape) {
            this._shape.getGrpSpList().remove(xmlObject);
        } else if (xmlObject instanceof CTConnector) {
            this._shape.getCxnSpList().remove(xmlObject);
        } else {
            throw new IllegalArgumentException("Unsupported shape: " + xSLFShape);
        }
        return this._shapes.remove(xSLFShape);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public String getShapeName() {
        return this._shape.getNvGrpSpPr().getCNvPr().getName();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public int getShapeId() {
        return (int) this._shape.getNvGrpSpPr().getCNvPr().getId();
    }

    static CTGroupShape prototype(int i) {
        CTGroupShape newInstance = CTGroupShape.Factory.newInstance();
        CTGroupShapeNonVisual addNewNvGrpSpPr = newInstance.addNewNvGrpSpPr();
        CTNonVisualDrawingProps addNewCNvPr = addNewNvGrpSpPr.addNewCNvPr();
        addNewCNvPr.setName("Group " + i);
        addNewCNvPr.setId(i + 1);
        addNewNvGrpSpPr.addNewCNvGrpSpPr();
        addNewNvGrpSpPr.addNewNvPr();
        newInstance.addNewGrpSpPr();
        return newInstance;
    }

    private XSLFDrawing getDrawing() {
        if (this._drawing == null) {
            this._drawing = new XSLFDrawing(this._sheet, this._shape);
        }
        return this._drawing;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer
    public XSLFAutoShape createAutoShape() {
        XSLFAutoShape createAutoShape = getDrawing().createAutoShape();
        this._shapes.add(createAutoShape);
        return createAutoShape;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer
    public XSLFFreeformShape createFreeform() {
        XSLFFreeformShape createFreeform = getDrawing().createFreeform();
        this._shapes.add(createFreeform);
        return createFreeform;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer
    public XSLFTextBox createTextBox() {
        XSLFTextBox createTextBox = getDrawing().createTextBox();
        this._shapes.add(createTextBox);
        return createTextBox;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer
    public XSLFConnectorShape createConnector() {
        XSLFConnectorShape createConnector = getDrawing().createConnector();
        this._shapes.add(createConnector);
        return createConnector;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer
    public XSLFGroupShape createGroup() {
        XSLFGroupShape createGroup = getDrawing().createGroup();
        this._shapes.add(createGroup);
        return createGroup;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer
    public XSLFPictureShape createPicture(int i) {
        List<PackagePart> partsByName = this._sheet.getPackagePart().getPackage().getPartsByName(Pattern.compile("/ppt/media/image" + (i + 1) + ".*?"));
        if (partsByName.size() == 0) {
            throw new IllegalArgumentException("Picture with index=" + i + " was not found");
        }
        XSLFPictureShape createPicture = getDrawing().createPicture(this._sheet.getPackagePart().addRelationship(partsByName.get(0).getPartName(), TargetMode.INTERNAL, XSLFRelation.IMAGES.getRelation()).getId());
        createPicture.resize();
        this._shapes.add(createPicture);
        return createPicture;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public void setFlipHorizontal(boolean z) {
        this._spPr.getXfrm().setFlipH(z);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public void setFlipVertical(boolean z) {
        this._spPr.getXfrm().setFlipV(z);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public boolean getFlipHorizontal() {
        return this._spPr.getXfrm().getFlipH();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public boolean getFlipVertical() {
        return this._spPr.getXfrm().getFlipV();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public void setRotation(double d) {
        this._spPr.getXfrm().setRot((int) (d * 60000.0d));
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public double getRotation() {
        return this._spPr.getXfrm().getRot() / 60000.0d;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public void draw(Graphics2D graphics2D) {
        Rectangle2D interiorAnchor = getInteriorAnchor();
        Rectangle2D anchor = getAnchor();
        AffineTransform affineTransform = (AffineTransform) graphics2D.getRenderingHint(XSLFRenderingHint.GROUP_TRANSFORM);
        AffineTransform affineTransform2 = new AffineTransform(affineTransform);
        double width = interiorAnchor.getWidth() == 0.0d ? 1.0d : anchor.getWidth() / interiorAnchor.getWidth();
        double height = interiorAnchor.getHeight() != 0.0d ? anchor.getHeight() / interiorAnchor.getHeight() : 1.0d;
        affineTransform.translate(anchor.getX(), anchor.getY());
        affineTransform.scale(width, height);
        affineTransform.translate(-interiorAnchor.getX(), -interiorAnchor.getY());
        for (XSLFShape xSLFShape : getShapes()) {
            AffineTransform transform = graphics2D.getTransform();
            graphics2D.setRenderingHint(XSLFRenderingHint.GSAVE, true);
            xSLFShape.applyTransform(graphics2D);
            xSLFShape.draw(graphics2D);
            graphics2D.setTransform(transform);
            graphics2D.setRenderingHint(XSLFRenderingHint.GRESTORE, true);
        }
        graphics2D.setRenderingHint(XSLFRenderingHint.GROUP_TRANSFORM, affineTransform2);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    void copy(XSLFShape xSLFShape) {
        XSLFShape[] shapes = getShapes();
        XSLFShape[] shapes2 = ((XSLFGroupShape) xSLFShape).getShapes();
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].copy(shapes2[i]);
        }
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer
    public void clear() {
        for (XSLFShape xSLFShape : getShapes()) {
            removeShape(xSLFShape);
        }
    }
}
