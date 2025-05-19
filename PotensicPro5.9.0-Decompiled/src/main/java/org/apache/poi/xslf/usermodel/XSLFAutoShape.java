package org.apache.poi.xslf.usermodel;

import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual;

/* loaded from: classes5.dex */
public class XSLFAutoShape extends XSLFTextShape {
    XSLFAutoShape(CTShape cTShape, XSLFSheet xSLFSheet) {
        super(cTShape, xSLFSheet);
    }

    static XSLFAutoShape create(CTShape cTShape, XSLFSheet xSLFSheet) {
        if (cTShape.getSpPr().isSetCustGeom()) {
            return new XSLFFreeformShape(cTShape, xSLFSheet);
        }
        if (cTShape.getNvSpPr().getCNvSpPr().isSetTxBox()) {
            return new XSLFTextBox(cTShape, xSLFSheet);
        }
        return new XSLFAutoShape(cTShape, xSLFSheet);
    }

    static CTShape prototype(int i) {
        CTShape newInstance = CTShape.Factory.newInstance();
        CTShapeNonVisual addNewNvSpPr = newInstance.addNewNvSpPr();
        CTNonVisualDrawingProps addNewCNvPr = addNewNvSpPr.addNewCNvPr();
        addNewCNvPr.setName("AutoShape " + i);
        addNewCNvPr.setId(i + 1);
        addNewNvSpPr.addNewCNvSpPr();
        addNewNvSpPr.addNewNvPr();
        CTPresetGeometry2D addNewPrstGeom = newInstance.addNewSpPr().addNewPrstGeom();
        addNewPrstGeom.setPrst(STShapeType.RECT);
        addNewPrstGeom.addNewAvLst();
        return newInstance;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    protected CTTextBody getTextBody(boolean z) {
        CTShape cTShape = (CTShape) getXmlObject();
        CTTextBody txBody = cTShape.getTxBody();
        if (txBody != null || !z) {
            return txBody;
        }
        CTTextBody addNewTxBody = cTShape.addNewTxBody();
        addNewTxBody.addNewBodyPr();
        addNewTxBody.addNewLstStyle();
        return addNewTxBody;
    }

    public String toString() {
        return "[" + getClass().getSimpleName() + "] " + getShapeName();
    }
}
