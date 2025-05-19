package org.apache.poi.hpsf.extractor;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import org.apache.poi.POIDocument;
import org.apache.poi.POITextExtractor;
import org.apache.poi.hpsf.CustomProperties;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.HPSFPropertiesOnlyDocument;
import org.apache.poi.hpsf.MutablePropertySet;
import org.apache.poi.hpsf.Property;
import org.apache.poi.hpsf.SpecialPropertySet;
import org.apache.poi.hpsf.wellknown.PropertyIDMap;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* loaded from: classes4.dex */
public class HPSFPropertiesExtractor extends POITextExtractor {
    private Closeable toClose;

    public HPSFPropertiesExtractor(POITextExtractor pOITextExtractor) {
        super(pOITextExtractor);
    }

    public HPSFPropertiesExtractor(POIDocument pOIDocument) {
        super(pOIDocument);
    }

    public HPSFPropertiesExtractor(POIFSFileSystem pOIFSFileSystem) {
        super(new HPSFPropertiesOnlyDocument(pOIFSFileSystem));
    }

    public HPSFPropertiesExtractor(NPOIFSFileSystem nPOIFSFileSystem) {
        super(new HPSFPropertiesOnlyDocument(nPOIFSFileSystem));
        this.toClose = nPOIFSFileSystem;
    }

    public String getDocumentSummaryInformationText() {
        if (this.document == null) {
            return "";
        }
        DocumentSummaryInformation documentSummaryInformation = this.document.getDocumentSummaryInformation();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getPropertiesText(documentSummaryInformation));
        CustomProperties customProperties = documentSummaryInformation == null ? null : documentSummaryInformation.getCustomProperties();
        if (customProperties != null) {
            for (String str : customProperties.nameSet()) {
                stringBuffer.append(str + " = " + HelperPropertySet.getPropertyValueText(customProperties.get(str)) + "\n");
            }
        }
        return stringBuffer.toString();
    }

    public String getSummaryInformationText() {
        return this.document == null ? "" : getPropertiesText(this.document.getSummaryInformation());
    }

    private static String getPropertiesText(SpecialPropertySet specialPropertySet) {
        if (specialPropertySet == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        PropertyIDMap propertySetIDMap = specialPropertySet.getPropertySetIDMap();
        Property[] properties = specialPropertySet.getProperties();
        for (int i = 0; i < properties.length; i++) {
            String l = Long.toString(properties[i].getID());
            Object obj = propertySetIDMap.get(properties[i].getID());
            if (obj != null) {
                l = obj.toString();
            }
            stringBuffer.append(l + " = " + HelperPropertySet.getPropertyValueText(properties[i].getValue()) + "\n");
        }
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.POITextExtractor
    public String getText() {
        return getSummaryInformationText() + getDocumentSummaryInformationText();
    }

    @Override // org.apache.poi.POITextExtractor
    public POITextExtractor getMetadataTextExtractor() {
        throw new IllegalStateException("You already have the Metadata Text Extractor, not recursing!");
    }

    @Override // org.apache.poi.POITextExtractor, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        Closeable closeable = this.toClose;
        if (closeable != null) {
            closeable.close();
            this.toClose = null;
        }
    }

    private static abstract class HelperPropertySet extends SpecialPropertySet {
        public HelperPropertySet() {
            super((MutablePropertySet) null);
        }

        public static String getPropertyValueText(Object obj) {
            return obj == null ? "(not set)" : SpecialPropertySet.getPropertyStringValue(obj);
        }
    }

    public static void main(String[] strArr) throws IOException {
        for (String str : strArr) {
            HPSFPropertiesExtractor hPSFPropertiesExtractor = new HPSFPropertiesExtractor(new NPOIFSFileSystem(new File(str)));
            try {
                System.out.println(hPSFPropertiesExtractor.getText());
                hPSFPropertiesExtractor.close();
            } catch (Throwable th) {
                hPSFPropertiesExtractor.close();
                throw th;
            }
        }
    }
}
