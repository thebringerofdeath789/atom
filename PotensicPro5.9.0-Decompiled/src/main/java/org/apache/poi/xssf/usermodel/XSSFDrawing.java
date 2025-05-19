package org.apache.poi.xssf.usermodel;

import aavax.xml.namespace.QName;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.model.CommentsTable;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTOneCellAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.STEditAs;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;

/* loaded from: classes5.dex */
public final class XSSFDrawing extends POIXMLDocumentPart implements Drawing {
    protected static final String NAMESPACE_A = "http://schemas.openxmlformats.org/drawingml/2006/main";
    protected static final String NAMESPACE_C = "http://schemas.openxmlformats.org/drawingml/2006/chart";
    private CTDrawing drawing;
    private long numOfGraphicFrames;

    protected XSSFDrawing() {
        this.numOfGraphicFrames = 0L;
        this.drawing = newDrawing();
    }

    public XSSFDrawing(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException, XmlException {
        super(packagePart, packageRelationship);
        this.numOfGraphicFrames = 0L;
        XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
        xmlOptions.setLoadReplaceDocumentElement(null);
        this.drawing = CTDrawing.Factory.parse(packagePart.getInputStream(), xmlOptions);
    }

    private static CTDrawing newDrawing() {
        return CTDrawing.Factory.newInstance();
    }

    @Internal
    public CTDrawing getCTDrawing() {
        return this.drawing;
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTDrawing.type.getName().getNamespaceURI(), "wsDr", "xdr"));
        HashMap hashMap = new HashMap();
        hashMap.put(NAMESPACE_A, "a");
        hashMap.put(STRelationshipId.type.getName().getNamespaceURI(), InternalZipConstants.READ_MODE);
        xmlOptions.setSaveSuggestedPrefixes(hashMap);
        OutputStream outputStream = getPackagePart().getOutputStream();
        this.drawing.save(outputStream, xmlOptions);
        outputStream.close();
    }

    @Override // org.apache.poi.ss.usermodel.Drawing
    public XSSFClientAnchor createAnchor(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return new XSSFClientAnchor(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public XSSFTextBox createTextbox(XSSFClientAnchor xSSFClientAnchor) {
        long newShapeId = newShapeId();
        CTShape addNewSp = createTwoCellAnchor(xSSFClientAnchor).addNewSp();
        addNewSp.set(XSSFSimpleShape.prototype());
        addNewSp.getNvSpPr().getCNvPr().setId(newShapeId);
        XSSFTextBox xSSFTextBox = new XSSFTextBox(this, addNewSp);
        xSSFTextBox.anchor = xSSFClientAnchor;
        return xSSFTextBox;
    }

    public XSSFPicture createPicture(XSSFClientAnchor xSSFClientAnchor, int i) {
        PackageRelationship addPictureReference = addPictureReference(i);
        long newShapeId = newShapeId();
        CTPicture addNewPic = createTwoCellAnchor(xSSFClientAnchor).addNewPic();
        addNewPic.set(XSSFPicture.prototype());
        addNewPic.getNvPicPr().getCNvPr().setId(newShapeId);
        XSSFPicture xSSFPicture = new XSSFPicture(this, addNewPic);
        xSSFPicture.anchor = xSSFClientAnchor;
        xSSFPicture.setPictureReference(addPictureReference);
        return xSSFPicture;
    }

    @Override // org.apache.poi.ss.usermodel.Drawing
    public XSSFPicture createPicture(ClientAnchor clientAnchor, int i) {
        return createPicture((XSSFClientAnchor) clientAnchor, i);
    }

    public XSSFChart createChart(XSSFClientAnchor xSSFClientAnchor) {
        XSSFChart xSSFChart = (XSSFChart) createRelationship(XSSFRelation.CHART, XSSFFactory.getInstance(), getPackagePart().getPackage().getPartsByContentType(XSSFRelation.CHART.getContentType()).size() + 1);
        createGraphicFrame(xSSFClientAnchor).setChart(xSSFChart, xSSFChart.getPackageRelationship().getId());
        return xSSFChart;
    }

    @Override // org.apache.poi.ss.usermodel.Drawing
    public XSSFChart createChart(ClientAnchor clientAnchor) {
        return createChart((XSSFClientAnchor) clientAnchor);
    }

    protected PackageRelationship addPictureReference(int i) {
        XSSFPictureData xSSFPictureData = ((XSSFWorkbook) getParent().getParent()).getAllPictures().get(i);
        PackageRelationship addRelationship = getPackagePart().addRelationship(xSSFPictureData.getPackagePart().getPartName(), TargetMode.INTERNAL, XSSFRelation.IMAGES.getRelation());
        addRelation(addRelationship.getId(), new XSSFPictureData(xSSFPictureData.getPackagePart(), addRelationship));
        return addRelationship;
    }

    public XSSFSimpleShape createSimpleShape(XSSFClientAnchor xSSFClientAnchor) {
        long newShapeId = newShapeId();
        CTShape addNewSp = createTwoCellAnchor(xSSFClientAnchor).addNewSp();
        addNewSp.set(XSSFSimpleShape.prototype());
        addNewSp.getNvSpPr().getCNvPr().setId(newShapeId);
        XSSFSimpleShape xSSFSimpleShape = new XSSFSimpleShape(this, addNewSp);
        xSSFSimpleShape.anchor = xSSFClientAnchor;
        return xSSFSimpleShape;
    }

    public XSSFConnector createConnector(XSSFClientAnchor xSSFClientAnchor) {
        CTConnector addNewCxnSp = createTwoCellAnchor(xSSFClientAnchor).addNewCxnSp();
        addNewCxnSp.set(XSSFConnector.prototype());
        XSSFConnector xSSFConnector = new XSSFConnector(this, addNewCxnSp);
        xSSFConnector.anchor = xSSFClientAnchor;
        return xSSFConnector;
    }

    public XSSFShapeGroup createGroup(XSSFClientAnchor xSSFClientAnchor) {
        CTGroupShape addNewGrpSp = createTwoCellAnchor(xSSFClientAnchor).addNewGrpSp();
        addNewGrpSp.set(XSSFShapeGroup.prototype());
        XSSFShapeGroup xSSFShapeGroup = new XSSFShapeGroup(this, addNewGrpSp);
        xSSFShapeGroup.anchor = xSSFClientAnchor;
        return xSSFShapeGroup;
    }

    @Override // org.apache.poi.ss.usermodel.Drawing
    public XSSFComment createCellComment(ClientAnchor clientAnchor) {
        XSSFClientAnchor xSSFClientAnchor = (XSSFClientAnchor) clientAnchor;
        XSSFSheet xSSFSheet = (XSSFSheet) getParent();
        CommentsTable commentsTable = xSSFSheet.getCommentsTable(true);
        schemasMicrosoftComVml.CTShape newCommentShape = xSSFSheet.getVMLDrawing(true).newCommentShape();
        if (xSSFClientAnchor.isSet()) {
            newCommentShape.getClientDataArray(0).setAnchorArray(0, ((int) xSSFClientAnchor.getCol1()) + ", " + (xSSFClientAnchor.getDx1() / 9525) + ", " + xSSFClientAnchor.getRow1() + ", " + (xSSFClientAnchor.getDy1() / 9525) + ", " + ((int) xSSFClientAnchor.getCol2()) + ", " + (xSSFClientAnchor.getDx2() / 9525) + ", " + xSSFClientAnchor.getRow2() + ", " + (xSSFClientAnchor.getDy2() / 9525));
        }
        String formatAsString = new CellReference(xSSFClientAnchor.getRow1(), xSSFClientAnchor.getCol1()).formatAsString();
        if (commentsTable.findCellComment(formatAsString) != null) {
            throw new IllegalArgumentException("Multiple cell comments in one cell are not allowed, cell: " + formatAsString);
        }
        return new XSSFComment(commentsTable, commentsTable.newComment(formatAsString), newCommentShape);
    }

    private XSSFGraphicFrame createGraphicFrame(XSSFClientAnchor xSSFClientAnchor) {
        CTGraphicalObjectFrame addNewGraphicFrame = createTwoCellAnchor(xSSFClientAnchor).addNewGraphicFrame();
        addNewGraphicFrame.set(XSSFGraphicFrame.prototype());
        long j = this.numOfGraphicFrames;
        this.numOfGraphicFrames = 1 + j;
        XSSFGraphicFrame xSSFGraphicFrame = new XSSFGraphicFrame(this, addNewGraphicFrame);
        xSSFGraphicFrame.setAnchor(xSSFClientAnchor);
        xSSFGraphicFrame.setId(j);
        xSSFGraphicFrame.setName("Diagramm" + j);
        return xSSFGraphicFrame;
    }

    public List<XSSFChart> getCharts() {
        ArrayList arrayList = new ArrayList();
        for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
            if (pOIXMLDocumentPart instanceof XSSFChart) {
                arrayList.add((XSSFChart) pOIXMLDocumentPart);
            }
        }
        return arrayList;
    }

    private CTTwoCellAnchor createTwoCellAnchor(XSSFClientAnchor xSSFClientAnchor) {
        STEditAs.Enum r3;
        CTTwoCellAnchor addNewTwoCellAnchor = this.drawing.addNewTwoCellAnchor();
        addNewTwoCellAnchor.setFrom(xSSFClientAnchor.getFrom());
        addNewTwoCellAnchor.setTo(xSSFClientAnchor.getTo());
        addNewTwoCellAnchor.addNewClientData();
        xSSFClientAnchor.setTo(addNewTwoCellAnchor.getTo());
        xSSFClientAnchor.setFrom(addNewTwoCellAnchor.getFrom());
        int anchorType = xSSFClientAnchor.getAnchorType();
        if (anchorType == 0) {
            r3 = STEditAs.TWO_CELL;
        } else if (anchorType == 2) {
            r3 = STEditAs.ONE_CELL;
        } else if (anchorType == 3) {
            r3 = STEditAs.ABSOLUTE;
        } else {
            r3 = STEditAs.ONE_CELL;
        }
        addNewTwoCellAnchor.setEditAs(r3);
        return addNewTwoCellAnchor;
    }

    private long newShapeId() {
        return this.drawing.sizeOfTwoCellAnchorArray() + 1;
    }

    public List<XSSFShape> getShapes() {
        ArrayList arrayList = new ArrayList();
        for (XmlObject xmlObject : this.drawing.selectPath("./*/*")) {
            XSSFShape xSSFShape = null;
            if (xmlObject instanceof CTPicture) {
                xSSFShape = new XSSFPicture(this, (CTPicture) xmlObject);
            } else if (xmlObject instanceof CTConnector) {
                xSSFShape = new XSSFConnector(this, (CTConnector) xmlObject);
            } else if (xmlObject instanceof CTShape) {
                xSSFShape = new XSSFSimpleShape(this, (CTShape) xmlObject);
            } else if (xmlObject instanceof CTGraphicalObjectFrame) {
                xSSFShape = new XSSFGraphicFrame(this, (CTGraphicalObjectFrame) xmlObject);
            } else if (xmlObject instanceof CTGroupShape) {
                xSSFShape = new XSSFShapeGroup(this, (CTGroupShape) xmlObject);
            }
            if (xSSFShape != null) {
                xSSFShape.anchor = getAnchorFromParent(xmlObject);
                arrayList.add(xSSFShape);
            }
        }
        return arrayList;
    }

    private XSSFAnchor getAnchorFromParent(XmlObject xmlObject) {
        XmlCursor newCursor = xmlObject.newCursor();
        XmlObject object = newCursor.toParent() ? newCursor.getObject() : null;
        newCursor.dispose();
        if (object == null) {
            return null;
        }
        if (object instanceof CTTwoCellAnchor) {
            CTTwoCellAnchor cTTwoCellAnchor = (CTTwoCellAnchor) object;
            return new XSSFClientAnchor(cTTwoCellAnchor.getFrom(), cTTwoCellAnchor.getTo());
        }
        if (object instanceof CTOneCellAnchor) {
            return new XSSFClientAnchor(((CTOneCellAnchor) object).getFrom(), CTMarker.Factory.newInstance());
        }
        return null;
    }
}
