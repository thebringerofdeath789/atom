package org.apache.poi.xwpf.usermodel;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;

/* loaded from: classes5.dex */
public class XWPFTableCell implements IBody, ICell {
    private static EnumMap<XWPFVertAlign, STVerticalJc.Enum> alignMap;
    private static HashMap<Integer, XWPFVertAlign> stVertAlignTypeMap;
    protected List<IBodyElement> bodyElements;
    private final CTTc ctTc;
    protected List<XWPFParagraph> paragraphs;
    protected IBody part;
    private XWPFTableRow tableRow;
    protected List<XWPFTable> tables;

    public enum XWPFVertAlign {
        TOP,
        CENTER,
        BOTH,
        BOTTOM
    }

    static {
        EnumMap<XWPFVertAlign, STVerticalJc.Enum> enumMap = new EnumMap<>((Class<XWPFVertAlign>) XWPFVertAlign.class);
        alignMap = enumMap;
        enumMap.put((EnumMap<XWPFVertAlign, STVerticalJc.Enum>) XWPFVertAlign.TOP, (XWPFVertAlign) STVerticalJc.Enum.forInt(1));
        alignMap.put((EnumMap<XWPFVertAlign, STVerticalJc.Enum>) XWPFVertAlign.CENTER, (XWPFVertAlign) STVerticalJc.Enum.forInt(2));
        alignMap.put((EnumMap<XWPFVertAlign, STVerticalJc.Enum>) XWPFVertAlign.BOTH, (XWPFVertAlign) STVerticalJc.Enum.forInt(3));
        alignMap.put((EnumMap<XWPFVertAlign, STVerticalJc.Enum>) XWPFVertAlign.BOTTOM, (XWPFVertAlign) STVerticalJc.Enum.forInt(4));
        HashMap<Integer, XWPFVertAlign> hashMap = new HashMap<>();
        stVertAlignTypeMap = hashMap;
        hashMap.put(1, XWPFVertAlign.TOP);
        stVertAlignTypeMap.put(2, XWPFVertAlign.CENTER);
        stVertAlignTypeMap.put(3, XWPFVertAlign.BOTH);
        stVertAlignTypeMap.put(4, XWPFVertAlign.BOTTOM);
    }

    public XWPFTableCell(CTTc cTTc, XWPFTableRow xWPFTableRow, IBody iBody) {
        this.paragraphs = null;
        this.tables = null;
        this.bodyElements = null;
        this.tableRow = null;
        this.ctTc = cTTc;
        this.part = iBody;
        this.tableRow = xWPFTableRow;
        if (cTTc.sizeOfPArray() < 1) {
            cTTc.addNewP();
        }
        this.bodyElements = new ArrayList();
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        XmlCursor newCursor = cTTc.newCursor();
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
            if (object instanceof CTSdtBlock) {
                this.bodyElements.add(new XWPFSDT((CTSdtBlock) object, this));
            }
            if (object instanceof CTSdtRun) {
                XWPFSDT xwpfsdt = new XWPFSDT((CTSdtRun) object, this);
                System.out.println(xwpfsdt.getContent().getText());
                this.bodyElements.add(xwpfsdt);
            }
        }
        newCursor.dispose();
    }

    @Internal
    public CTTc getCTTc() {
        return this.ctTc;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<IBodyElement> getBodyElements() {
        return Collections.unmodifiableList(this.bodyElements);
    }

    public void setParagraph(XWPFParagraph xWPFParagraph) {
        if (this.ctTc.sizeOfPArray() == 0) {
            this.ctTc.addNewP();
        }
        this.ctTc.setPArray(0, xWPFParagraph.getCTP());
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<XWPFParagraph> getParagraphs() {
        return this.paragraphs;
    }

    public XWPFParagraph addParagraph() {
        XWPFParagraph xWPFParagraph = new XWPFParagraph(this.ctTc.addNewP(), this);
        addParagraph(xWPFParagraph);
        return xWPFParagraph;
    }

    public void addParagraph(XWPFParagraph xWPFParagraph) {
        this.paragraphs.add(xWPFParagraph);
    }

    public void removeParagraph(int i) {
        this.paragraphs.remove(i);
        this.ctTc.removeP(i);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph getParagraph(CTP ctp) {
        for (XWPFParagraph xWPFParagraph : this.paragraphs) {
            if (ctp.equals(xWPFParagraph.getCTP())) {
                return xWPFParagraph;
            }
        }
        return null;
    }

    public void setText(String str) {
        new XWPFParagraph(this.ctTc.sizeOfPArray() == 0 ? this.ctTc.addNewP() : this.ctTc.getPArray(0), this).createRun().setText(str);
    }

    public XWPFTableRow getTableRow() {
        return this.tableRow;
    }

    public void setColor(String str) {
        CTTcPr tcPr = this.ctTc.isSetTcPr() ? this.ctTc.getTcPr() : this.ctTc.addNewTcPr();
        CTShd shd = tcPr.isSetShd() ? tcPr.getShd() : tcPr.addNewShd();
        shd.setColor("auto");
        shd.setVal(STShd.CLEAR);
        shd.setFill(str);
    }

    public String getColor() {
        CTShd shd;
        CTTcPr tcPr = this.ctTc.getTcPr();
        if (tcPr == null || (shd = tcPr.getShd()) == null) {
            return null;
        }
        return shd.xgetFill().getStringValue();
    }

    public void setVerticalAlignment(XWPFVertAlign xWPFVertAlign) {
        (this.ctTc.isSetTcPr() ? this.ctTc.getTcPr() : this.ctTc.addNewTcPr()).addNewVAlign().setVal(alignMap.get(xWPFVertAlign));
    }

    public XWPFVertAlign getVerticalAlignment() {
        CTTcPr tcPr = this.ctTc.getTcPr();
        if (this.ctTc == null) {
            return null;
        }
        return stVertAlignTypeMap.get(Integer.valueOf(tcPr.getVAlign().getVal().intValue()));
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph insertNewParagraph(XmlCursor xmlCursor) {
        boolean z;
        CTP ctp;
        XmlObject xmlObject = null;
        if (!isCursorInTableCell(xmlCursor)) {
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
        if (!isCursorInTableCell(xmlCursor)) {
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

    private boolean isCursorInTableCell(XmlCursor xmlCursor) {
        XmlCursor newCursor = xmlCursor.newCursor();
        newCursor.toParent();
        return newCursor.getObject() == this.ctTc;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph getParagraphArray(int i) {
        if (i <= 0 || i >= this.paragraphs.size()) {
            return null;
        }
        return this.paragraphs.get(i);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public POIXMLDocumentPart getPart() {
        return this.tableRow.getTable().getPart();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public BodyType getPartType() {
        return BodyType.TABLECELL;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable getTable(CTTbl cTTbl) {
        for (int i = 0; i < this.tables.size(); i++) {
            if (getTables().get(i).getCTTbl() == cTTbl) {
                return getTables().get(i);
            }
        }
        return null;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable getTableArray(int i) {
        if (i <= 0 || i >= this.tables.size()) {
            return null;
        }
        return this.tables.get(i);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<XWPFTable> getTables() {
        return Collections.unmodifiableList(this.tables);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public void insertTable(int i, XWPFTable xWPFTable) {
        this.bodyElements.add(i, xWPFTable);
        CTTbl[] tblArray = this.ctTc.getTblArray();
        int length = tblArray.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length && tblArray[i3] != xWPFTable.getCTTbl(); i3++) {
            i2++;
        }
        this.tables.add(i2, xWPFTable);
    }

    public String getText() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<XWPFParagraph> it = this.paragraphs.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().getText());
        }
        return stringBuffer.toString();
    }

    public String getTextRecursively() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.bodyElements.size(); i++) {
            boolean z = true;
            if (i != this.bodyElements.size() - 1) {
                z = false;
            }
            appendBodyElementText(stringBuffer, this.bodyElements.get(i), z);
        }
        return stringBuffer.toString();
    }

    private void appendBodyElementText(StringBuffer stringBuffer, IBodyElement iBodyElement, boolean z) {
        if (iBodyElement instanceof XWPFParagraph) {
            stringBuffer.append(((XWPFParagraph) iBodyElement).getText());
            if (z) {
                return;
            }
            stringBuffer.append('\t');
            return;
        }
        if (iBodyElement instanceof XWPFTable) {
            Iterator<XWPFTableRow> it = ((XWPFTable) iBodyElement).getRows().iterator();
            while (it.hasNext()) {
                Iterator<XWPFTableCell> it2 = it.next().getTableCells().iterator();
                while (it2.hasNext()) {
                    List<IBodyElement> bodyElements = it2.next().getBodyElements();
                    for (int i = 0; i < bodyElements.size(); i++) {
                        boolean z2 = true;
                        if (i != bodyElements.size() - 1) {
                            z2 = false;
                        }
                        appendBodyElementText(stringBuffer, bodyElements.get(i), z2);
                    }
                }
            }
            if (z) {
                return;
            }
            stringBuffer.append('\n');
            return;
        }
        if (iBodyElement instanceof XWPFSDT) {
            stringBuffer.append(((XWPFSDT) iBodyElement).getContent().getText());
            if (z) {
                return;
            }
            stringBuffer.append('\t');
        }
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTableCell getTableCell(CTTc cTTc) {
        XWPFTable table;
        XWPFTableRow row;
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
        if (!(object2 instanceof CTTbl) || (table = getTable((CTTbl) object2)) == null || (row = table.getRow(cTRow)) == null) {
            return null;
        }
        return row.getTableCell(cTTc);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFDocument getXWPFDocument() {
        return this.part.getXWPFDocument();
    }
}
