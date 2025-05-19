package org.apache.poi.xwpf.usermodel;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLRelation;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;

/* loaded from: classes5.dex */
public abstract class XWPFHeaderFooter extends POIXMLDocumentPart implements IBody {
    List<IBodyElement> bodyElements;
    XWPFDocument document;
    CTHdrFtr headerFooter;
    List<XWPFParagraph> paragraphs;
    List<XWPFPictureData> pictures;
    List<XWPFTable> tables;

    public POIXMLDocumentPart getOwner() {
        return this;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public POIXMLDocumentPart getPart() {
        return this;
    }

    XWPFHeaderFooter(XWPFDocument xWPFDocument, CTHdrFtr cTHdrFtr) {
        this.paragraphs = new ArrayList(1);
        this.tables = new ArrayList(1);
        this.pictures = new ArrayList();
        this.bodyElements = new ArrayList(1);
        Objects.requireNonNull(xWPFDocument);
        this.document = xWPFDocument;
        this.headerFooter = cTHdrFtr;
        readHdrFtr();
    }

    protected XWPFHeaderFooter() {
        this.paragraphs = new ArrayList(1);
        this.tables = new ArrayList(1);
        this.pictures = new ArrayList();
        this.bodyElements = new ArrayList(1);
        this.headerFooter = CTHdrFtr.Factory.newInstance();
        readHdrFtr();
    }

    public XWPFHeaderFooter(POIXMLDocumentPart pOIXMLDocumentPart, PackagePart packagePart, PackageRelationship packageRelationship) throws IOException {
        super(pOIXMLDocumentPart, packagePart, packageRelationship);
        this.paragraphs = new ArrayList(1);
        this.tables = new ArrayList(1);
        this.pictures = new ArrayList();
        this.bodyElements = new ArrayList(1);
        XWPFDocument xWPFDocument = (XWPFDocument) getParent();
        this.document = xWPFDocument;
        Objects.requireNonNull(xWPFDocument);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void onDocumentRead() throws IOException {
        for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
            if (pOIXMLDocumentPart instanceof XWPFPictureData) {
                XWPFPictureData xWPFPictureData = (XWPFPictureData) pOIXMLDocumentPart;
                this.pictures.add(xWPFPictureData);
                this.document.registerPackagePictureData(xWPFPictureData);
            }
        }
    }

    @Internal
    public CTHdrFtr _getHdrFtr() {
        return this.headerFooter;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<IBodyElement> getBodyElements() {
        return Collections.unmodifiableList(this.bodyElements);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<XWPFParagraph> getParagraphs() {
        return Collections.unmodifiableList(this.paragraphs);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<XWPFTable> getTables() throws ArrayIndexOutOfBoundsException {
        return Collections.unmodifiableList(this.tables);
    }

    public String getText() {
        String text;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.paragraphs.size(); i++) {
            if (!this.paragraphs.get(i).isEmpty() && (text = this.paragraphs.get(i).getText()) != null && text.length() > 0) {
                stringBuffer.append(text);
                stringBuffer.append('\n');
            }
        }
        List<XWPFTable> tables = getTables();
        for (int i2 = 0; i2 < tables.size(); i2++) {
            String text2 = tables.get(i2).getText();
            if (text2 != null && text2.length() > 0) {
                stringBuffer.append(text2);
                stringBuffer.append('\n');
            }
        }
        for (IBodyElement iBodyElement : getBodyElements()) {
            if (iBodyElement instanceof XWPFSDT) {
                stringBuffer.append(((XWPFSDT) iBodyElement).getContent().getText() + '\n');
            }
        }
        return stringBuffer.toString();
    }

    public void setHeaderFooter(CTHdrFtr cTHdrFtr) {
        this.headerFooter = cTHdrFtr;
        readHdrFtr();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable getTable(CTTbl cTTbl) {
        XWPFTable next;
        Iterator<XWPFTable> it = this.tables.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (next.getCTTbl().equals(cTTbl)) {
                return next;
            }
        }
        return null;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph getParagraph(CTP ctp) {
        for (XWPFParagraph xWPFParagraph : this.paragraphs) {
            if (xWPFParagraph.getCTP().equals(ctp)) {
                return xWPFParagraph;
            }
        }
        return null;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph getParagraphArray(int i) {
        return this.paragraphs.get(i);
    }

    public List<XWPFParagraph> getListParagraph() {
        return this.paragraphs;
    }

    public List<XWPFPictureData> getAllPictures() {
        return Collections.unmodifiableList(this.pictures);
    }

    public List<XWPFPictureData> getAllPackagePictures() {
        return this.document.getAllPackagePictures();
    }

    public String addPictureData(byte[] bArr, int i) throws InvalidFormatException {
        XWPFPictureData findPackagePictureData = this.document.findPackagePictureData(bArr, i);
        POIXMLRelation pOIXMLRelation = XWPFPictureData.RELATIONS[i];
        if (findPackagePictureData == null) {
            XWPFPictureData xWPFPictureData = (XWPFPictureData) createRelationship(pOIXMLRelation, XWPFFactory.getInstance(), this.document.getNextPicNameNumber(i));
            OutputStream outputStream = null;
            try {
                try {
                    outputStream = xWPFPictureData.getPackagePart().getOutputStream();
                    outputStream.write(bArr);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    this.document.registerPackagePictureData(xWPFPictureData);
                    this.pictures.add(xWPFPictureData);
                    return getRelationId(xWPFPictureData);
                } catch (IOException e) {
                    throw new POIXMLException(e);
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        }
        if (!getRelations().contains(findPackagePictureData)) {
            PackagePart packagePart = findPackagePictureData.getPackagePart();
            TargetMode targetMode = TargetMode.INTERNAL;
            String id = getPackagePart().addRelationship(packagePart.getPartName(), targetMode, pOIXMLRelation.getRelation()).getId();
            addRelation(id, findPackagePictureData);
            this.pictures.add(findPackagePictureData);
            return id;
        }
        return getRelationId(findPackagePictureData);
    }

    public String addPictureData(InputStream inputStream, int i) throws InvalidFormatException, IOException {
        return addPictureData(IOUtils.toByteArray(inputStream), i);
    }

    public XWPFPictureData getPictureDataByID(String str) {
        POIXMLDocumentPart relationById = getRelationById(str);
        if (relationById == null || !(relationById instanceof XWPFPictureData)) {
            return null;
        }
        return (XWPFPictureData) relationById;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph insertNewParagraph(XmlCursor xmlCursor) {
        boolean z;
        CTP ctp;
        XmlObject xmlObject = null;
        if (!isCursorInHdrF(xmlCursor)) {
            return null;
        }
        xmlCursor.beginElement(TtmlNode.TAG_P, CTP.type.getName().getNamespaceURI());
        xmlCursor.toParent();
        CTP ctp2 = (CTP) xmlCursor.getObject();
        XWPFParagraph xWPFParagraph = new XWPFParagraph(ctp2, this);
        while (true) {
            z = xmlObject instanceof CTP;
            if (z || !xmlCursor.toPrevSibling()) {
                break;
            }
            xmlObject = xmlCursor.getObject();
        }
        int i = 0;
        if (!z || (ctp = (CTP) xmlObject) == ctp2) {
            this.paragraphs.add(0, xWPFParagraph);
        } else {
            this.paragraphs.add(this.paragraphs.indexOf(getParagraph(ctp)) + 1, xWPFParagraph);
        }
        xmlCursor.toCursor(ctp2.newCursor());
        while (xmlCursor.toPrevSibling()) {
            XmlObject object = xmlCursor.getObject();
            if ((object instanceof CTP) || (object instanceof CTTbl)) {
                i++;
            }
        }
        this.bodyElements.add(i, xWPFParagraph);
        xmlCursor.toCursor(ctp2.newCursor());
        xmlCursor.toEndToken();
        return xWPFParagraph;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable insertNewTbl(XmlCursor xmlCursor) {
        boolean z;
        XmlObject xmlObject = null;
        if (!isCursorInHdrF(xmlCursor)) {
            return null;
        }
        xmlCursor.beginElement("tbl", CTTbl.type.getName().getNamespaceURI());
        xmlCursor.toParent();
        CTTbl cTTbl = (CTTbl) xmlCursor.getObject();
        XWPFTable xWPFTable = new XWPFTable(cTTbl, this);
        xmlCursor.removeXmlContents();
        while (true) {
            z = xmlObject instanceof CTTbl;
            if (z || !xmlCursor.toPrevSibling()) {
                break;
            }
            xmlObject = xmlCursor.getObject();
        }
        int i = 0;
        if (!z) {
            this.tables.add(0, xWPFTable);
        } else {
            this.tables.add(this.tables.indexOf(getTable((CTTbl) xmlObject)) + 1, xWPFTable);
        }
        XmlCursor newCursor = cTTbl.newCursor();
        while (newCursor.toPrevSibling()) {
            XmlObject object = newCursor.getObject();
            if ((object instanceof CTP) || (object instanceof CTTbl)) {
                i++;
            }
        }
        this.bodyElements.add(i, xWPFTable);
        cTTbl.newCursor().toEndToken();
        return xWPFTable;
    }

    private boolean isCursorInHdrF(XmlCursor xmlCursor) {
        XmlCursor newCursor = xmlCursor.newCursor();
        newCursor.toParent();
        return newCursor.getObject() == this.headerFooter;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable getTableArray(int i) {
        if (i <= 0 || i >= this.tables.size()) {
            return null;
        }
        return this.tables.get(i);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public void insertTable(int i, XWPFTable xWPFTable) {
        this.bodyElements.add(i, xWPFTable);
        CTTbl[] tblArray = this.headerFooter.getTblArray();
        int length = tblArray.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length && tblArray[i3] != xWPFTable.getCTTbl(); i3++) {
            i2++;
        }
        this.tables.add(i2, xWPFTable);
    }

    public void readHdrFtr() {
        this.bodyElements = new ArrayList();
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        XmlCursor newCursor = this.headerFooter.newCursor();
        newCursor.selectPath("./*");
        while (newCursor.toNextSelection()) {
            XmlObject object = newCursor.getObject();
            if (object instanceof CTP) {
                XWPFParagraph xWPFParagraph = new XWPFParagraph((CTP) object, this);
                this.paragraphs.add(xWPFParagraph);
                this.bodyElements.add(xWPFParagraph);
            }
            if (object instanceof CTTbl) {
                XWPFTable xWPFTable = new XWPFTable((CTTbl) object, this);
                this.tables.add(xWPFTable);
                this.bodyElements.add(xWPFTable);
            }
        }
        newCursor.dispose();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTableCell getTableCell(CTTc cTTc) {
        XWPFTable table;
        XmlCursor newCursor = cTTc.newCursor();
        newCursor.toParent();
        XmlObject object = newCursor.getObject();
        if (!(object instanceof CTRow)) {
            return null;
        }
        CTRow cTRow = (CTRow) object;
        newCursor.toParent();
        XmlObject object2 = newCursor.getObject();
        newCursor.dispose();
        if (!(object2 instanceof CTTbl) || (table = getTable((CTTbl) object2)) == null) {
            return null;
        }
        XWPFTableRow row = table.getRow(cTRow);
        if (cTRow == null) {
            return null;
        }
        return row.getTableCell(cTTc);
    }

    public void setXWPFDocument(XWPFDocument xWPFDocument) {
        this.document = xWPFDocument;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFDocument getXWPFDocument() {
        XWPFDocument xWPFDocument = this.document;
        return xWPFDocument != null ? xWPFDocument : (XWPFDocument) getParent();
    }
}
