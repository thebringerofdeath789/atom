package org.apache.poi.xwpf.usermodel;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdn;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;

/* loaded from: classes5.dex */
public class XWPFFootnote implements Iterable<XWPFParagraph>, IBody {
    private CTFtnEdn ctFtnEdn;
    private XWPFDocument document;
    private XWPFFootnotes footnotes;
    private List<XWPFParagraph> paragraphs = new ArrayList();
    private List<XWPFTable> tables = new ArrayList();
    private List<XWPFPictureData> pictures = new ArrayList();
    private List<IBodyElement> bodyElements = new ArrayList();

    public XWPFFootnote(CTFtnEdn cTFtnEdn, XWPFFootnotes xWPFFootnotes) {
        this.footnotes = xWPFFootnotes;
        this.ctFtnEdn = cTFtnEdn;
        this.document = xWPFFootnotes.getXWPFDocument();
        init();
    }

    public XWPFFootnote(XWPFDocument xWPFDocument, CTFtnEdn cTFtnEdn) {
        this.ctFtnEdn = cTFtnEdn;
        this.document = xWPFDocument;
        init();
    }

    private void init() {
        XmlCursor newCursor = this.ctFtnEdn.newCursor();
        newCursor.selectPath("./*");
        while (newCursor.toNextSelection()) {
            XmlObject object = newCursor.getObject();
            if (object instanceof CTP) {
                XWPFParagraph xWPFParagraph = new XWPFParagraph((CTP) object, this);
                this.bodyElements.add(xWPFParagraph);
                this.paragraphs.add(xWPFParagraph);
            } else if (object instanceof CTTbl) {
                XWPFTable xWPFTable = new XWPFTable((CTTbl) object, this);
                this.bodyElements.add(xWPFTable);
                this.tables.add(xWPFTable);
            } else if (object instanceof CTSdtBlock) {
                this.bodyElements.add(new XWPFSDT((CTSdtBlock) object, this));
            }
        }
        newCursor.dispose();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<XWPFParagraph> getParagraphs() {
        return this.paragraphs;
    }

    @Override // java.lang.Iterable
    public Iterator<XWPFParagraph> iterator() {
        return this.paragraphs.iterator();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<XWPFTable> getTables() {
        return this.tables;
    }

    public List<XWPFPictureData> getPictures() {
        return this.pictures;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<IBodyElement> getBodyElements() {
        return this.bodyElements;
    }

    public CTFtnEdn getCTFtnEdn() {
        return this.ctFtnEdn;
    }

    public void setCTFtnEdn(CTFtnEdn cTFtnEdn) {
        this.ctFtnEdn = cTFtnEdn;
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
        CTTbl[] tblArray = this.ctFtnEdn.getTblArray();
        int length = tblArray.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length && tblArray[i3] != xWPFTable.getCTTbl(); i3++) {
            i2++;
        }
        this.tables.add(i2, xWPFTable);
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

    private boolean isCursorInFtn(XmlCursor xmlCursor) {
        XmlCursor newCursor = xmlCursor.newCursor();
        newCursor.toParent();
        return newCursor.getObject() == this.ctFtnEdn;
    }

    public POIXMLDocumentPart getOwner() {
        return this.footnotes;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable insertNewTbl(XmlCursor xmlCursor) {
        boolean z;
        XmlObject xmlObject = null;
        if (!isCursorInFtn(xmlCursor)) {
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

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph insertNewParagraph(XmlCursor xmlCursor) {
        boolean z;
        CTP ctp;
        XmlObject xmlObject = null;
        if (!isCursorInFtn(xmlCursor)) {
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

    public XWPFTable addNewTbl(CTTbl cTTbl) {
        CTTbl addNewTbl = this.ctFtnEdn.addNewTbl();
        addNewTbl.set(cTTbl);
        XWPFTable xWPFTable = new XWPFTable(addNewTbl, this);
        this.tables.add(xWPFTable);
        return xWPFTable;
    }

    public XWPFParagraph addNewParagraph(CTP ctp) {
        CTP addNewP = this.ctFtnEdn.addNewP();
        addNewP.set(ctp);
        XWPFParagraph xWPFParagraph = new XWPFParagraph(addNewP, this);
        this.paragraphs.add(xWPFParagraph);
        return xWPFParagraph;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFDocument getXWPFDocument() {
        return this.document;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public POIXMLDocumentPart getPart() {
        return this.footnotes;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public BodyType getPartType() {
        return BodyType.FOOTNOTE;
    }
}
