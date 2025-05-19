package org.apache.poi.xssf.usermodel;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.xssf.util.EvilUnclosedBRFixingInputStream;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.w3c.dom.Node;
import schemasMicrosoftComOfficeExcel.CTClientData;
import schemasMicrosoftComOfficeExcel.STObjectType;
import schemasMicrosoftComOfficeOffice.CTIdMap;
import schemasMicrosoftComOfficeOffice.CTShapeLayout;
import schemasMicrosoftComOfficeOffice.STConnectType;
import schemasMicrosoftComOfficeOffice.STInsetMode;
import schemasMicrosoftComVml.CTPath;
import schemasMicrosoftComVml.CTShadow;
import schemasMicrosoftComVml.CTShape;
import schemasMicrosoftComVml.CTShapetype;
import schemasMicrosoftComVml.STExt;
import schemasMicrosoftComVml.STStrokeJoinStyle;
import schemasMicrosoftComVml.STTrueFalse;

/* loaded from: classes5.dex */
public final class XSSFVMLDrawing extends POIXMLDocumentPart {
    private List<XmlObject> _items;
    private List<QName> _qnames;
    private int _shapeId;
    private String _shapeTypeId;
    private static final QName QNAME_SHAPE_LAYOUT = new QName("urn:schemas-microsoft-com:office:office", "shapelayout");
    private static final QName QNAME_SHAPE_TYPE = new QName("urn:schemas-microsoft-com:vml", "shapetype");
    private static final QName QNAME_SHAPE = new QName("urn:schemas-microsoft-com:vml", "shape");
    private static final Pattern ptrn_shapeId = Pattern.compile("_x0000_s(\\d+)");

    protected XSSFVMLDrawing() {
        this._qnames = new ArrayList();
        this._items = new ArrayList();
        this._shapeId = 1024;
        newDrawing();
    }

    protected XSSFVMLDrawing(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException, XmlException {
        super(packagePart, packageRelationship);
        this._qnames = new ArrayList();
        this._items = new ArrayList();
        this._shapeId = 1024;
        read(getPackagePart().getInputStream());
    }

    protected void read(InputStream inputStream) throws IOException, XmlException {
        XmlObject parse = XmlObject.Factory.parse(new EvilUnclosedBRFixingInputStream(inputStream));
        this._qnames = new ArrayList();
        this._items = new ArrayList();
        for (XmlObject xmlObject : parse.selectPath("$this/xml/*")) {
            Node domNode = xmlObject.getDomNode();
            QName qName = new QName(domNode.getNamespaceURI(), domNode.getLocalName());
            if (qName.equals(QNAME_SHAPE_LAYOUT)) {
                this._items.add(CTShapeLayout.Factory.parse(xmlObject.xmlText()));
            } else if (qName.equals(QNAME_SHAPE_TYPE)) {
                CTShapetype parse2 = CTShapetype.Factory.parse(xmlObject.xmlText());
                this._items.add(parse2);
                this._shapeTypeId = parse2.getId();
            } else if (qName.equals(QNAME_SHAPE)) {
                CTShape parse3 = CTShape.Factory.parse(xmlObject.xmlText());
                String id = parse3.getId();
                if (id != null) {
                    Matcher matcher = ptrn_shapeId.matcher(id);
                    if (matcher.find()) {
                        this._shapeId = Math.max(this._shapeId, Integer.parseInt(matcher.group(1)));
                    }
                }
                this._items.add(parse3);
            } else {
                this._items.add(XmlObject.Factory.parse(xmlObject.xmlText()));
            }
            this._qnames.add(qName);
        }
    }

    protected List<XmlObject> getItems() {
        return this._items;
    }

    protected void write(OutputStream outputStream) throws IOException {
        XmlObject newInstance = XmlObject.Factory.newInstance();
        XmlCursor newCursor = newInstance.newCursor();
        newCursor.toNextToken();
        newCursor.beginElement("xml");
        for (int i = 0; i < this._items.size(); i++) {
            XmlCursor newCursor2 = this._items.get(i).newCursor();
            newCursor.beginElement(this._qnames.get(i));
            while (newCursor2.toNextToken() == XmlCursor.TokenType.ATTR) {
                Node domNode = newCursor2.getDomNode();
                newCursor.insertAttributeWithValue(domNode.getLocalName(), domNode.getNamespaceURI(), domNode.getNodeValue());
            }
            newCursor2.toStartDoc();
            newCursor2.copyXmlContents(newCursor);
            newCursor.toNextToken();
            newCursor2.dispose();
        }
        newCursor.dispose();
        XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
        xmlOptions.setSavePrettyPrint();
        HashMap hashMap = new HashMap();
        hashMap.put("urn:schemas-microsoft-com:vml", "v");
        hashMap.put("urn:schemas-microsoft-com:office:office", "o");
        hashMap.put("urn:schemas-microsoft-com:office:excel", "x");
        xmlOptions.setSaveSuggestedPrefixes(hashMap);
        newInstance.save(outputStream, xmlOptions);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        write(outputStream);
        outputStream.close();
    }

    private void newDrawing() {
        CTShapeLayout newInstance = CTShapeLayout.Factory.newInstance();
        newInstance.setExt(STExt.EDIT);
        CTIdMap addNewIdmap = newInstance.addNewIdmap();
        addNewIdmap.setExt(STExt.EDIT);
        addNewIdmap.setData("1");
        this._items.add(newInstance);
        this._qnames.add(QNAME_SHAPE_LAYOUT);
        CTShapetype newInstance2 = CTShapetype.Factory.newInstance();
        this._shapeTypeId = "_xssf_cell_comment";
        newInstance2.setId("_xssf_cell_comment");
        newInstance2.setCoordsize("21600,21600");
        newInstance2.setSpt(202.0f);
        newInstance2.setPath2("m,l,21600r21600,l21600,xe");
        newInstance2.addNewStroke().setJoinstyle(STStrokeJoinStyle.MITER);
        CTPath addNewPath = newInstance2.addNewPath();
        addNewPath.setGradientshapeok(STTrueFalse.T);
        addNewPath.setConnecttype(STConnectType.RECT);
        this._items.add(newInstance2);
        this._qnames.add(QNAME_SHAPE_TYPE);
    }

    protected CTShape newCommentShape() {
        CTShape newInstance = CTShape.Factory.newInstance();
        StringBuilder append = new StringBuilder().append("_x0000_s");
        int i = this._shapeId + 1;
        this._shapeId = i;
        newInstance.setId(append.append(i).toString());
        newInstance.setType("#" + this._shapeTypeId);
        newInstance.setStyle("position:absolute; visibility:hidden");
        newInstance.setFillcolor("#ffffe1");
        newInstance.setInsetmode(STInsetMode.AUTO);
        newInstance.addNewFill().setColor("#ffffe1");
        CTShadow addNewShadow = newInstance.addNewShadow();
        addNewShadow.setOn(STTrueFalse.T);
        addNewShadow.setColor("black");
        addNewShadow.setObscured(STTrueFalse.T);
        newInstance.addNewPath().setConnecttype(STConnectType.NONE);
        newInstance.addNewTextbox().setStyle("mso-direction-alt:auto");
        CTClientData addNewClientData = newInstance.addNewClientData();
        addNewClientData.setObjectType(STObjectType.NOTE);
        addNewClientData.addNewMoveWithCells();
        addNewClientData.addNewSizeWithCells();
        addNewClientData.addNewAnchor().setStringValue("1, 15, 0, 2, 3, 15, 3, 16");
        addNewClientData.addNewAutoFill().setStringValue("False");
        addNewClientData.addNewRow().setBigIntegerValue(new BigInteger(SessionDescription.SUPPORTED_SDP_VERSION));
        addNewClientData.addNewColumn().setBigIntegerValue(new BigInteger(SessionDescription.SUPPORTED_SDP_VERSION));
        this._items.add(newInstance);
        this._qnames.add(QNAME_SHAPE);
        return newInstance;
    }

    protected CTShape findCommentShape(int i, int i2) {
        for (XmlObject xmlObject : this._items) {
            if (xmlObject instanceof CTShape) {
                CTShape cTShape = (CTShape) xmlObject;
                if (cTShape.sizeOfClientDataArray() > 0) {
                    CTClientData clientDataArray = cTShape.getClientDataArray(0);
                    if (clientDataArray.getObjectType() == STObjectType.NOTE) {
                        int intValue = clientDataArray.getRowArray(0).intValue();
                        int intValue2 = clientDataArray.getColumnArray(0).intValue();
                        if (intValue == i && intValue2 == i2) {
                            return cTShape;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    protected boolean removeCommentShape(int i, int i2) {
        CTShape findCommentShape = findCommentShape(i, i2);
        return findCommentShape != null && this._items.remove(findCommentShape);
    }
}
