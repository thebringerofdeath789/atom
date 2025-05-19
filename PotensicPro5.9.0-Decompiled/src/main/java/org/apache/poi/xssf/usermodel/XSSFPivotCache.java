package org.apache.poi.xssf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCache;

/* loaded from: classes5.dex */
public class XSSFPivotCache extends POIXMLDocumentPart {
    private CTPivotCache ctPivotCache;

    public XSSFPivotCache() {
        this.ctPivotCache = CTPivotCache.Factory.newInstance();
    }

    public XSSFPivotCache(CTPivotCache cTPivotCache) {
        this.ctPivotCache = cTPivotCache;
    }

    protected XSSFPivotCache(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException {
        super(packagePart, packageRelationship);
        readFrom(packagePart.getInputStream());
    }

    protected void readFrom(InputStream inputStream) throws IOException {
        try {
            XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
            xmlOptions.setLoadReplaceDocumentElement(null);
            this.ctPivotCache = CTPivotCache.Factory.parse(inputStream, xmlOptions);
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public CTPivotCache getCTPivotCache() {
        return this.ctPivotCache;
    }
}
