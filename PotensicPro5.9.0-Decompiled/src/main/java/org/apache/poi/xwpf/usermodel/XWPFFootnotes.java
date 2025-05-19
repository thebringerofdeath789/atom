package org.apache.poi.xwpf.usermodel;

import aavax.xml.namespace.QName;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFootnotes;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdn;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.FootnotesDocument;

/* loaded from: classes5.dex */
public class XWPFFootnotes extends POIXMLDocumentPart {
    private CTFootnotes ctFootnotes;
    protected XWPFDocument document;
    private List<XWPFFootnote> listFootnote;

    public XWPFFootnotes(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException, OpenXML4JException {
        super(packagePart, packageRelationship);
        this.listFootnote = new ArrayList();
    }

    public XWPFFootnotes() {
        this.listFootnote = new ArrayList();
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void onDocumentRead() throws IOException {
        try {
            CTFootnotes footnotes = FootnotesDocument.Factory.parse(getPackagePart().getInputStream()).getFootnotes();
            this.ctFootnotes = footnotes;
            for (CTFtnEdn cTFtnEdn : footnotes.getFootnoteArray()) {
                this.listFootnote.add(new XWPFFootnote(cTFtnEdn, this));
            }
        } catch (XmlException unused) {
            throw new POIXMLException();
        }
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTFootnotes.type.getName().getNamespaceURI(), "footnotes"));
        HashMap hashMap = new HashMap();
        hashMap.put("http://schemas.openxmlformats.org/officeDocument/2006/relationships", InternalZipConstants.READ_MODE);
        hashMap.put("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "w");
        xmlOptions.setSaveSuggestedPrefixes(hashMap);
        OutputStream outputStream = getPackagePart().getOutputStream();
        this.ctFootnotes.save(outputStream, xmlOptions);
        outputStream.close();
    }

    public List<XWPFFootnote> getFootnotesList() {
        return this.listFootnote;
    }

    public XWPFFootnote getFootnoteById(int i) {
        for (XWPFFootnote xWPFFootnote : this.listFootnote) {
            if (xWPFFootnote.getCTFtnEdn().getId().intValue() == i) {
                return xWPFFootnote;
            }
        }
        return null;
    }

    public void setFootnotes(CTFootnotes cTFootnotes) {
        this.ctFootnotes = cTFootnotes;
    }

    public void addFootnote(XWPFFootnote xWPFFootnote) {
        this.listFootnote.add(xWPFFootnote);
        this.ctFootnotes.addNewFootnote().set(xWPFFootnote.getCTFtnEdn());
    }

    public XWPFFootnote addFootnote(CTFtnEdn cTFtnEdn) {
        CTFtnEdn addNewFootnote = this.ctFootnotes.addNewFootnote();
        addNewFootnote.set(cTFtnEdn);
        XWPFFootnote xWPFFootnote = new XWPFFootnote(addNewFootnote, this);
        this.listFootnote.add(xWPFFootnote);
        return xWPFFootnote;
    }

    public void setXWPFDocument(XWPFDocument xWPFDocument) {
        this.document = xWPFDocument;
    }

    public XWPFDocument getXWPFDocument() {
        XWPFDocument xWPFDocument = this.document;
        return xWPFDocument != null ? xWPFDocument : (XWPFDocument) getParent();
    }
}
