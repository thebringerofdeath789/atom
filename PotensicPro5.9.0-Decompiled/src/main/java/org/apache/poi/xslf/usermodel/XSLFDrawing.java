package org.apache.poi.xslf.usermodel;

import java.awt.Color;
import java.awt.Rectangle;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTConnector;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;

/* loaded from: classes5.dex */
public class XSLFDrawing {
    private int _shapeId;
    private XSLFSheet _sheet;
    private CTGroupShape _spTree;

    XSLFDrawing(XSLFSheet xSLFSheet, CTGroupShape cTGroupShape) {
        this._shapeId = 1;
        this._sheet = xSLFSheet;
        this._spTree = cTGroupShape;
        for (XmlObject xmlObject : xSLFSheet.getSpTree().selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' .//*/p:cNvPr")) {
            this._shapeId = (int) Math.max(this._shapeId, ((CTNonVisualDrawingProps) xmlObject).getId());
        }
    }

    public XSLFAutoShape createAutoShape() {
        CTShape addNewSp = this._spTree.addNewSp();
        int i = this._shapeId;
        this._shapeId = i + 1;
        addNewSp.set(XSLFAutoShape.prototype(i));
        XSLFAutoShape xSLFAutoShape = new XSLFAutoShape(addNewSp, this._sheet);
        xSLFAutoShape.setAnchor(new Rectangle());
        return xSLFAutoShape;
    }

    public XSLFFreeformShape createFreeform() {
        CTShape addNewSp = this._spTree.addNewSp();
        int i = this._shapeId;
        this._shapeId = i + 1;
        addNewSp.set(XSLFFreeformShape.prototype(i));
        XSLFFreeformShape xSLFFreeformShape = new XSLFFreeformShape(addNewSp, this._sheet);
        xSLFFreeformShape.setAnchor(new Rectangle());
        return xSLFFreeformShape;
    }

    public XSLFTextBox createTextBox() {
        CTShape addNewSp = this._spTree.addNewSp();
        int i = this._shapeId;
        this._shapeId = i + 1;
        addNewSp.set(XSLFTextBox.prototype(i));
        XSLFTextBox xSLFTextBox = new XSLFTextBox(addNewSp, this._sheet);
        xSLFTextBox.setAnchor(new Rectangle());
        return xSLFTextBox;
    }

    public XSLFConnectorShape createConnector() {
        CTConnector addNewCxnSp = this._spTree.addNewCxnSp();
        int i = this._shapeId;
        this._shapeId = i + 1;
        addNewCxnSp.set(XSLFConnectorShape.prototype(i));
        XSLFConnectorShape xSLFConnectorShape = new XSLFConnectorShape(addNewCxnSp, this._sheet);
        xSLFConnectorShape.setAnchor(new Rectangle());
        xSLFConnectorShape.setLineColor(Color.black);
        xSLFConnectorShape.setLineWidth(0.75d);
        return xSLFConnectorShape;
    }

    public XSLFGroupShape createGroup() {
        CTGroupShape addNewGrpSp = this._spTree.addNewGrpSp();
        int i = this._shapeId;
        this._shapeId = i + 1;
        addNewGrpSp.set(XSLFGroupShape.prototype(i));
        XSLFGroupShape xSLFGroupShape = new XSLFGroupShape(addNewGrpSp, this._sheet);
        xSLFGroupShape.setAnchor(new Rectangle());
        return xSLFGroupShape;
    }

    public XSLFPictureShape createPicture(String str) {
        CTPicture addNewPic = this._spTree.addNewPic();
        int i = this._shapeId;
        this._shapeId = i + 1;
        addNewPic.set(XSLFPictureShape.prototype(i, str));
        XSLFPictureShape xSLFPictureShape = new XSLFPictureShape(addNewPic, this._sheet);
        xSLFPictureShape.setAnchor(new Rectangle());
        return xSLFPictureShape;
    }

    public XSLFTable createTable() {
        CTGraphicalObjectFrame addNewGraphicFrame = this._spTree.addNewGraphicFrame();
        int i = this._shapeId;
        this._shapeId = i + 1;
        addNewGraphicFrame.set(XSLFTable.prototype(i));
        XSLFTable xSLFTable = new XSLFTable(addNewGraphicFrame, this._sheet);
        xSLFTable.setAnchor(new Rectangle());
        return xSLFTable;
    }
}
