package org.apache.poi;

import java.io.IOException;
import org.apache.poi.POIXMLProperties;
import org.apache.poi.openxml4j.opc.OPCPackage;

/* loaded from: classes.dex */
public abstract class POIXMLTextExtractor extends POITextExtractor {
    private final POIXMLDocument _document;

    public POIXMLTextExtractor(POIXMLDocument pOIXMLDocument) {
        super((POIDocument) null);
        this._document = pOIXMLDocument;
    }

    public POIXMLProperties.CoreProperties getCoreProperties() {
        return this._document.getProperties().getCoreProperties();
    }

    public POIXMLProperties.ExtendedProperties getExtendedProperties() {
        return this._document.getProperties().getExtendedProperties();
    }

    public POIXMLProperties.CustomProperties getCustomProperties() {
        return this._document.getProperties().getCustomProperties();
    }

    public final POIXMLDocument getDocument() {
        return this._document;
    }

    public OPCPackage getPackage() {
        return this._document.getPackage();
    }

    @Override // org.apache.poi.POITextExtractor
    public POIXMLPropertiesTextExtractor getMetadataTextExtractor() {
        return new POIXMLPropertiesTextExtractor(this._document);
    }

    @Override // org.apache.poi.POITextExtractor, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        OPCPackage oPCPackage;
        POIXMLDocument pOIXMLDocument = this._document;
        if (pOIXMLDocument != null && (oPCPackage = pOIXMLDocument.getPackage()) != null) {
            oPCPackage.revert();
        }
        super.close();
    }
}
