package org.apache.poi.xssf.usermodel;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrameNonVisual;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;

/* loaded from: classes5.dex */
public final class XSSFGraphicFrame extends XSSFShape {
    private static CTGraphicalObjectFrame prototype;
    private XSSFClientAnchor anchor;
    private XSSFDrawing drawing;
    private CTGraphicalObjectFrame graphicFrame;

    @Override // org.apache.poi.xssf.usermodel.XSSFShape
    protected CTShapeProperties getShapeProperties() {
        return null;
    }

    protected XSSFGraphicFrame(XSSFDrawing xSSFDrawing, CTGraphicalObjectFrame cTGraphicalObjectFrame) {
        this.drawing = xSSFDrawing;
        this.graphicFrame = cTGraphicalObjectFrame;
    }

    @Internal
    public CTGraphicalObjectFrame getCTGraphicalObjectFrame() {
        return this.graphicFrame;
    }

    protected static CTGraphicalObjectFrame prototype() {
        if (prototype == null) {
            CTGraphicalObjectFrame newInstance = CTGraphicalObjectFrame.Factory.newInstance();
            CTGraphicalObjectFrameNonVisual addNewNvGraphicFramePr = newInstance.addNewNvGraphicFramePr();
            CTNonVisualDrawingProps addNewCNvPr = addNewNvGraphicFramePr.addNewCNvPr();
            addNewCNvPr.setId(0L);
            addNewCNvPr.setName("Diagramm 1");
            addNewNvGraphicFramePr.addNewCNvGraphicFramePr();
            CTTransform2D addNewXfrm = newInstance.addNewXfrm();
            CTPositiveSize2D addNewExt = addNewXfrm.addNewExt();
            CTPoint2D addNewOff = addNewXfrm.addNewOff();
            addNewExt.setCx(0L);
            addNewExt.setCy(0L);
            addNewOff.setX(0L);
            addNewOff.setY(0L);
            newInstance.addNewGraphic();
            prototype = newInstance;
        }
        return prototype;
    }

    public void setMacro(String str) {
        this.graphicFrame.setMacro(str);
    }

    public void setName(String str) {
        getNonVisualProperties().setName(str);
    }

    public String getName() {
        return getNonVisualProperties().getName();
    }

    private CTNonVisualDrawingProps getNonVisualProperties() {
        return this.graphicFrame.getNvGraphicFramePr().getCNvPr();
    }

    protected void setAnchor(XSSFClientAnchor xSSFClientAnchor) {
        this.anchor = xSSFClientAnchor;
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFShape
    public XSSFClientAnchor getAnchor() {
        return this.anchor;
    }

    protected void setChart(XSSFChart xSSFChart, String str) {
        appendChartElement(this.graphicFrame.getGraphic().addNewGraphicData(), str);
        xSSFChart.setGraphicFrame(this);
    }

    public long getId() {
        return this.graphicFrame.getNvGraphicFramePr().getCNvPr().getId();
    }

    protected void setId(long j) {
        this.graphicFrame.getNvGraphicFramePr().getCNvPr().setId(j);
    }

    private void appendChartElement(CTGraphicalObjectData cTGraphicalObjectData, String str) {
        String namespaceURI = STRelationshipId.type.getName().getNamespaceURI();
        XmlCursor newCursor = cTGraphicalObjectData.newCursor();
        newCursor.toNextToken();
        newCursor.beginElement(new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "chart", "c"));
        newCursor.insertAttributeWithValue(new QName(namespaceURI, TtmlNode.ATTR_ID, InternalZipConstants.READ_MODE), str);
        newCursor.dispose();
        cTGraphicalObjectData.setUri("http://schemas.openxmlformats.org/drawingml/2006/chart");
    }
}
