package org.apache.poi.xslf.usermodel;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTConnector;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;

/* loaded from: classes5.dex */
public abstract class XSLFSheet extends POIXMLDocumentPart implements XSLFShapeContainer {
    private XSLFCommonSlideData _commonSlideData;
    private XSLFDrawing _drawing;
    private Map<Integer, XSLFSimpleShape> _placeholderByIdMap;
    private Map<Integer, XSLFSimpleShape> _placeholderByTypeMap;
    private List<XSLFTextShape> _placeholders;
    private List<XSLFShape> _shapes;
    private CTGroupShape _spTree;

    protected boolean canDraw(XSLFShape xSLFShape) {
        return true;
    }

    public XSLFBackground getBackground() {
        return null;
    }

    public boolean getFollowMasterGraphics() {
        return false;
    }

    public abstract XSLFSheet getMasterSheet();

    protected abstract String getRootElementName();

    XSLFTheme getTheme() {
        return null;
    }

    public abstract XmlObject getXmlObject();

    public XSLFSheet() {
    }

    public XSLFSheet(PackagePart packagePart, PackageRelationship packageRelationship) {
        super(packagePart, packageRelationship);
    }

    public XMLSlideShow getSlideShow() {
        for (POIXMLDocumentPart parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof XMLSlideShow) {
                return (XMLSlideShow) parent;
            }
        }
        throw new IllegalStateException("SlideShow was not found");
    }

    protected List<XSLFShape> buildShapes(CTGroupShape cTGroupShape) {
        ArrayList arrayList = new ArrayList();
        for (XmlObject xmlObject : cTGroupShape.selectPath(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) {
            if (xmlObject instanceof CTShape) {
                arrayList.add(XSLFAutoShape.create((CTShape) xmlObject, this));
            } else if (xmlObject instanceof CTGroupShape) {
                arrayList.add(new XSLFGroupShape((CTGroupShape) xmlObject, this));
            } else if (xmlObject instanceof CTConnector) {
                arrayList.add(new XSLFConnectorShape((CTConnector) xmlObject, this));
            } else if (xmlObject instanceof CTPicture) {
                arrayList.add(new XSLFPictureShape((CTPicture) xmlObject, this));
            } else if (xmlObject instanceof CTGraphicalObjectFrame) {
                arrayList.add(XSLFGraphicFrame.create((CTGraphicalObjectFrame) xmlObject, this));
            }
        }
        return arrayList;
    }

    @Internal
    public XSLFCommonSlideData getCommonSlideData() {
        return this._commonSlideData;
    }

    protected void setCommonSlideData(CTCommonSlideData cTCommonSlideData) {
        if (cTCommonSlideData == null) {
            this._commonSlideData = null;
        } else {
            this._commonSlideData = new XSLFCommonSlideData(cTCommonSlideData);
        }
    }

    private XSLFDrawing getDrawing() {
        if (this._drawing == null) {
            this._drawing = new XSLFDrawing(this, getSpTree());
        }
        return this._drawing;
    }

    private List<XSLFShape> getShapeList() {
        if (this._shapes == null) {
            this._shapes = buildShapes(getSpTree());
        }
        return this._shapes;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer
    public XSLFAutoShape createAutoShape() {
        List<XSLFShape> shapeList = getShapeList();
        XSLFAutoShape createAutoShape = getDrawing().createAutoShape();
        shapeList.add(createAutoShape);
        return createAutoShape;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer
    public XSLFFreeformShape createFreeform() {
        List<XSLFShape> shapeList = getShapeList();
        XSLFFreeformShape createFreeform = getDrawing().createFreeform();
        shapeList.add(createFreeform);
        return createFreeform;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer
    public XSLFTextBox createTextBox() {
        List<XSLFShape> shapeList = getShapeList();
        XSLFTextBox createTextBox = getDrawing().createTextBox();
        shapeList.add(createTextBox);
        return createTextBox;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer
    public XSLFConnectorShape createConnector() {
        List<XSLFShape> shapeList = getShapeList();
        XSLFConnectorShape createConnector = getDrawing().createConnector();
        shapeList.add(createConnector);
        return createConnector;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer
    public XSLFGroupShape createGroup() {
        List<XSLFShape> shapeList = getShapeList();
        XSLFGroupShape createGroup = getDrawing().createGroup();
        shapeList.add(createGroup);
        return createGroup;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer
    public XSLFPictureShape createPicture(int i) {
        List<PackagePart> partsByName = getPackagePart().getPackage().getPartsByName(Pattern.compile("/ppt/media/image" + (i + 1) + ".*?"));
        if (partsByName.size() == 0) {
            throw new IllegalArgumentException("Picture with index=" + i + " was not found");
        }
        PackagePart packagePart = partsByName.get(0);
        PackageRelationship addRelationship = getPackagePart().addRelationship(packagePart.getPartName(), TargetMode.INTERNAL, XSLFRelation.IMAGES.getRelation());
        addRelation(addRelationship.getId(), new XSLFPictureData(packagePart, addRelationship));
        XSLFPictureShape createPicture = getDrawing().createPicture(addRelationship.getId());
        createPicture.resize();
        getShapeList().add(createPicture);
        return createPicture;
    }

    public XSLFTable createTable() {
        List<XSLFShape> shapeList = getShapeList();
        XSLFTable createTable = getDrawing().createTable();
        shapeList.add(createTable);
        return createTable;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer
    public XSLFShape[] getShapes() {
        return (XSLFShape[]) getShapeList().toArray(new XSLFShape[this._shapes.size()]);
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFShape> iterator() {
        return getShapeList().iterator();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer
    public boolean removeShape(XSLFShape xSLFShape) {
        XmlObject xmlObject = xSLFShape.getXmlObject();
        CTGroupShape spTree = getSpTree();
        if (xmlObject instanceof CTShape) {
            spTree.getSpList().remove(xmlObject);
        } else if (xmlObject instanceof CTGroupShape) {
            spTree.getGrpSpList().remove(xmlObject);
        } else if (xmlObject instanceof CTConnector) {
            spTree.getCxnSpList().remove(xmlObject);
        } else {
            throw new IllegalArgumentException("Unsupported shape: " + xSLFShape);
        }
        return getShapeList().remove(xSLFShape);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer
    public void clear() {
        for (XSLFShape xSLFShape : getShapes()) {
            removeShape(xSLFShape);
        }
    }

    protected CTGroupShape getSpTree() {
        if (this._spTree == null) {
            XmlObject[] selectPath = getXmlObject().selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' .//*/p:spTree");
            if (selectPath.length == 0) {
                throw new IllegalStateException("CTGroupShape was not found");
            }
            this._spTree = (CTGroupShape) selectPath[0];
        }
        return this._spTree;
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected final void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
        HashMap hashMap = new HashMap();
        hashMap.put(STRelationshipId.type.getName().getNamespaceURI(), InternalZipConstants.READ_MODE);
        hashMap.put("http://schemas.openxmlformats.org/drawingml/2006/main", "a");
        hashMap.put("http://schemas.openxmlformats.org/presentationml/2006/main", TtmlNode.TAG_P);
        xmlOptions.setSaveSuggestedPrefixes(hashMap);
        String rootElementName = getRootElementName();
        if (rootElementName != null) {
            xmlOptions.setSaveSyntheticDocumentElement(new QName("http://schemas.openxmlformats.org/presentationml/2006/main", rootElementName));
        }
        OutputStream outputStream = getPackagePart().getOutputStream();
        getXmlObject().save(outputStream, xmlOptions);
        outputStream.close();
    }

    public XSLFSheet importContent(XSLFSheet xSLFSheet) {
        this._shapes = null;
        this._spTree = null;
        this._drawing = null;
        this._spTree = null;
        this._placeholders = null;
        getSpTree().set(xSLFSheet.getSpTree());
        List<XSLFShape> shapeList = getShapeList();
        List<XSLFShape> shapeList2 = xSLFSheet.getShapeList();
        for (int i = 0; i < shapeList.size(); i++) {
            shapeList.get(i).copy(shapeList2.get(i));
        }
        return this;
    }

    public XSLFSheet appendContent(XSLFSheet xSLFSheet) {
        CTGroupShape spTree = getSpTree();
        int size = getShapeList().size();
        for (XmlObject xmlObject : xSLFSheet.getSpTree().selectPath(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) {
            if (xmlObject instanceof CTShape) {
                spTree.addNewSp().set(xmlObject);
            } else if (xmlObject instanceof CTGroupShape) {
                spTree.addNewGrpSp().set(xmlObject);
            } else if (xmlObject instanceof CTConnector) {
                spTree.addNewCxnSp().set(xmlObject);
            } else if (xmlObject instanceof CTPicture) {
                spTree.addNewPic().set(xmlObject);
            } else if (xmlObject instanceof CTGraphicalObjectFrame) {
                spTree.addNewGraphicFrame().set(xmlObject);
            }
        }
        this._shapes = null;
        this._spTree = null;
        this._drawing = null;
        this._spTree = null;
        this._placeholders = null;
        List<XSLFShape> shapeList = getShapeList();
        List<XSLFShape> shapeList2 = xSLFSheet.getShapeList();
        for (int i = 0; i < shapeList2.size(); i++) {
            shapeList.get(size + i).copy(shapeList2.get(i));
        }
        return this;
    }

    protected XSLFTextShape getTextShapeByType(Placeholder placeholder) {
        for (XSLFShape xSLFShape : getShapes()) {
            if (xSLFShape instanceof XSLFTextShape) {
                XSLFTextShape xSLFTextShape = (XSLFTextShape) xSLFShape;
                if (xSLFTextShape.getTextType() == placeholder) {
                    return xSLFTextShape;
                }
            }
        }
        return null;
    }

    XSLFSimpleShape getPlaceholder(CTPlaceholder cTPlaceholder) {
        XSLFSimpleShape placeholderById = cTPlaceholder.isSetIdx() ? getPlaceholderById((int) cTPlaceholder.getIdx()) : null;
        return (placeholderById == null && cTPlaceholder.isSetType()) ? getPlaceholderByType(cTPlaceholder.getType().intValue()) : placeholderById;
    }

    void initPlaceholders() {
        XSLFTextShape xSLFTextShape;
        CTPlaceholder cTPlaceholder;
        if (this._placeholders == null) {
            this._placeholders = new ArrayList();
            this._placeholderByIdMap = new HashMap();
            this._placeholderByTypeMap = new HashMap();
            for (XSLFShape xSLFShape : getShapes()) {
                if ((xSLFShape instanceof XSLFTextShape) && (cTPlaceholder = (xSLFTextShape = (XSLFTextShape) xSLFShape).getCTPlaceholder()) != null) {
                    this._placeholders.add(xSLFTextShape);
                    if (cTPlaceholder.isSetIdx()) {
                        this._placeholderByIdMap.put(Integer.valueOf((int) cTPlaceholder.getIdx()), xSLFTextShape);
                    }
                    if (cTPlaceholder.isSetType()) {
                        this._placeholderByTypeMap.put(Integer.valueOf(cTPlaceholder.getType().intValue()), xSLFTextShape);
                    }
                }
            }
        }
    }

    XSLFSimpleShape getPlaceholderById(int i) {
        initPlaceholders();
        return this._placeholderByIdMap.get(Integer.valueOf(i));
    }

    XSLFSimpleShape getPlaceholderByType(int i) {
        initPlaceholders();
        return this._placeholderByTypeMap.get(Integer.valueOf(i));
    }

    public XSLFTextShape getPlaceholder(int i) {
        initPlaceholders();
        return this._placeholders.get(i);
    }

    public XSLFTextShape[] getPlaceholders() {
        initPlaceholders();
        List<XSLFTextShape> list = this._placeholders;
        return (XSLFTextShape[]) list.toArray(new XSLFTextShape[list.size()]);
    }

    public void draw(Graphics2D graphics2D) {
        XSLFSheet masterSheet = getMasterSheet();
        if (getFollowMasterGraphics() && masterSheet != null) {
            masterSheet.draw(graphics2D);
        }
        graphics2D.setRenderingHint(XSLFRenderingHint.GROUP_TRANSFORM, new AffineTransform());
        for (XSLFShape xSLFShape : getShapeList()) {
            if (canDraw(xSLFShape)) {
                AffineTransform transform = graphics2D.getTransform();
                graphics2D.setRenderingHint(XSLFRenderingHint.GSAVE, true);
                xSLFShape.applyTransform(graphics2D);
                xSLFShape.draw(graphics2D);
                graphics2D.setTransform(transform);
                graphics2D.setRenderingHint(XSLFRenderingHint.GRESTORE, true);
            }
        }
    }

    String importBlip(String str, PackagePart packagePart) {
        PackageRelationship relationship = packagePart.getRelationship(str);
        try {
            XSLFPictureData xSLFPictureData = new XSLFPictureData(packagePart.getRelatedPart(relationship), null);
            XMLSlideShow slideShow = getSlideShow();
            PackagePart packagePart2 = slideShow.getAllPictures().get(slideShow.addPicture(xSLFPictureData.getData(), xSLFPictureData.getPictureType())).getPackagePart();
            PackageRelationship addRelationship = getPackagePart().addRelationship(packagePart2.getPartName(), TargetMode.INTERNAL, relationship.getRelationshipType());
            addRelation(addRelationship.getId(), new XSLFPictureData(packagePart2, addRelationship));
            return addRelationship.getId();
        } catch (InvalidFormatException e) {
            throw new POIXMLException(e);
        }
    }

    PackagePart importPart(PackageRelationship packageRelationship, PackagePart packagePart) {
        OPCPackage oPCPackage = getPackagePart().getPackage();
        if (!oPCPackage.containPart(packagePart.getPartName())) {
            getPackagePart().addRelationship(packagePart.getPartName(), TargetMode.INTERNAL, packageRelationship.getRelationshipType());
            PackagePart createPart = oPCPackage.createPart(packagePart.getPartName(), packagePart.getContentType());
            OutputStream outputStream = createPart.getOutputStream();
            try {
                IOUtils.copy(packagePart.getInputStream(), outputStream);
                outputStream.close();
                return createPart;
            } catch (IOException e) {
                throw new POIXMLException(e);
            }
        }
        return oPCPackage.getPart(packagePart.getPartName());
    }
}
