package org.apache.poi.xwpf.usermodel;

import aavax.xml.namespace.QName;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.openxml4j.opc.PackageNamespaces;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.FtrDocument;

/* loaded from: classes5.dex */
public class XWPFFooter extends XWPFHeaderFooter {
    public XWPFFooter() {
    }

    public XWPFFooter(XWPFDocument xWPFDocument, CTHdrFtr cTHdrFtr) throws IOException {
        super(xWPFDocument, cTHdrFtr);
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

    public XWPFFooter(POIXMLDocumentPart pOIXMLDocumentPart, PackagePart packagePart, PackageRelationship packageRelationship) throws IOException {
        super(pOIXMLDocumentPart, packagePart, packageRelationship);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTNumbering.type.getName().getNamespaceURI(), "ftr"));
        HashMap hashMap = new HashMap();
        hashMap.put(PackageNamespaces.MARKUP_COMPATIBILITY, "ve");
        hashMap.put("urn:schemas-microsoft-com:office:office", "o");
        hashMap.put("http://schemas.openxmlformats.org/officeDocument/2006/relationships", InternalZipConstants.READ_MODE);
        hashMap.put("http://schemas.openxmlformats.org/officeDocument/2006/math", "m");
        hashMap.put("urn:schemas-microsoft-com:vml", "v");
        hashMap.put("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "wp");
        hashMap.put("urn:schemas-microsoft-com:office:word", "w10");
        hashMap.put("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "w");
        hashMap.put("http://schemas.microsoft.com/office/word/2006/wordml", "wne");
        xmlOptions.setSaveSuggestedPrefixes(hashMap);
        OutputStream outputStream = getPackagePart().getOutputStream();
        super._getHdrFtr().save(outputStream, xmlOptions);
        outputStream.close();
    }

    @Override // org.apache.poi.xwpf.usermodel.XWPFHeaderFooter, org.apache.poi.POIXMLDocumentPart
    protected void onDocumentRead() throws IOException {
        super.onDocumentRead();
        try {
            this.headerFooter = FtrDocument.Factory.parse(getPackagePart().getInputStream()).getFtr();
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
                if (object instanceof CTSdtBlock) {
                    this.bodyElements.add(new XWPFSDT((CTSdtBlock) object, this));
                }
            }
            newCursor.dispose();
        } catch (Exception e) {
            throw new POIXMLException(e);
        }
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public BodyType getPartType() {
        return BodyType.FOOTER;
    }
}
