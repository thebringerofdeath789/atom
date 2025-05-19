package org.apache.poi.xslf.usermodel;

import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual;

/* loaded from: classes5.dex */
public class XSLFTextBox extends XSLFAutoShape {
    XSLFTextBox(CTShape cTShape, XSLFSheet xSLFSheet) {
        super(cTShape, xSLFSheet);
    }

    static CTShape prototype(int i) {
        CTShape newInstance = CTShape.Factory.newInstance();
        CTShapeNonVisual addNewNvSpPr = newInstance.addNewNvSpPr();
        CTNonVisualDrawingProps addNewCNvPr = addNewNvSpPr.addNewCNvPr();
        addNewCNvPr.setName("TextBox " + i);
        addNewCNvPr.setId(i + 1);
        addNewNvSpPr.addNewCNvSpPr().setTxBox(true);
        addNewNvSpPr.addNewNvPr();
        CTPresetGeometry2D addNewPrstGeom = newInstance.addNewSpPr().addNewPrstGeom();
        addNewPrstGeom.setPrst(STShapeType.RECT);
        addNewPrstGeom.addNewAvLst();
        CTTextBody addNewTxBody = newInstance.addNewTxBody();
        addNewTxBody.addNewBodyPr();
        addNewTxBody.addNewLstStyle();
        return newInstance;
    }
}
