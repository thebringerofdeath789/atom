package org.apache.poi.xslf.usermodel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.POIXMLException;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTable;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;

/* loaded from: classes5.dex */
public class XSLFCommonSlideData {
    private final CTCommonSlideData data;

    public XSLFCommonSlideData(CTCommonSlideData cTCommonSlideData) {
        this.data = cTCommonSlideData;
    }

    public List<DrawingTextBody> getDrawingText() {
        CTGroupShape spTree = this.data.getSpTree();
        ArrayList arrayList = new ArrayList();
        processShape(spTree, arrayList);
        for (CTGroupShape cTGroupShape : spTree.getGrpSpArray()) {
            processShape(cTGroupShape, arrayList);
        }
        for (CTGraphicalObjectFrame cTGraphicalObjectFrame : spTree.getGraphicFrameArray()) {
            XmlCursor newCursor = cTGraphicalObjectFrame.getGraphic().getGraphicData().newCursor();
            newCursor.selectPath("declare namespace pic='" + CTTable.type.getName().getNamespaceURI() + "' .//pic:tbl");
            while (newCursor.toNextSelection()) {
                XmlObject object = newCursor.getObject();
                if (object instanceof XmlAnyTypeImpl) {
                    try {
                        object = CTTable.Factory.parse(object.toString());
                    } catch (XmlException e) {
                        throw new POIXMLException(e);
                    }
                }
                if (object instanceof CTTable) {
                    for (DrawingTableRow drawingTableRow : new DrawingTable((CTTable) object).getRows()) {
                        for (DrawingTableCell drawingTableCell : drawingTableRow.getCells()) {
                            arrayList.add(drawingTableCell.getTextBody());
                        }
                    }
                }
            }
            newCursor.dispose();
        }
        return arrayList;
    }

    public List<DrawingParagraph> getText() {
        ArrayList arrayList = new ArrayList();
        Iterator<DrawingTextBody> it = getDrawingText().iterator();
        while (it.hasNext()) {
            arrayList.addAll(Arrays.asList(it.next().getParagraphs()));
        }
        return arrayList;
    }

    private void processShape(CTGroupShape cTGroupShape, List<DrawingTextBody> list) {
        DrawingTextBody drawingTextBody;
        for (CTShape cTShape : cTGroupShape.getSpArray()) {
            CTTextBody txBody = cTShape.getTxBody();
            if (txBody != null) {
                CTApplicationNonVisualDrawingProps nvPr = cTShape.getNvSpPr().getNvPr();
                if (nvPr.isSetPh()) {
                    drawingTextBody = new DrawingTextPlaceholder(txBody, nvPr.getPh());
                } else {
                    drawingTextBody = new DrawingTextBody(txBody);
                }
                list.add(drawingTextBody);
            }
        }
    }
}
