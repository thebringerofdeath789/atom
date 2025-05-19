package org.apache.poi.xssf.usermodel;

import aavax.xml.namespace.QName;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords;

/* loaded from: classes5.dex */
public class XSSFPivotCacheRecords extends POIXMLDocumentPart {
    private CTPivotCacheRecords ctPivotCacheRecords;

    public XSSFPivotCacheRecords() {
        this.ctPivotCacheRecords = CTPivotCacheRecords.Factory.newInstance();
    }

    protected XSSFPivotCacheRecords(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException {
        super(packagePart, packageRelationship);
        readFrom(packagePart.getInputStream());
    }

    protected void readFrom(InputStream inputStream) throws IOException {
        try {
            XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
            xmlOptions.setLoadReplaceDocumentElement(null);
            this.ctPivotCacheRecords = CTPivotCacheRecords.Factory.parse(inputStream, xmlOptions);
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    @Internal
    public CTPivotCacheRecords getCtPivotCacheRecords() {
        return this.ctPivotCacheRecords;
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTPivotCacheRecords.type.getName().getNamespaceURI(), "pivotCacheRecords"));
        this.ctPivotCacheRecords.save(outputStream, xmlOptions);
        outputStream.close();
    }
}
