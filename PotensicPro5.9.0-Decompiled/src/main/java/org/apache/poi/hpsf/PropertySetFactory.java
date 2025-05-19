package org.apache.poi.hpsf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.apache.poi.hpsf.wellknown.SectionIDMap;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.DocumentInputStream;

/* loaded from: classes4.dex */
public class PropertySetFactory {
    public static PropertySet create(DirectoryEntry directoryEntry, String str) throws FileNotFoundException, NoPropertySetStreamException, IOException, UnsupportedEncodingException {
        DocumentInputStream documentInputStream = null;
        try {
            DocumentInputStream documentInputStream2 = new DocumentInputStream((DocumentEntry) directoryEntry.getEntry(str));
            try {
                PropertySet create = create(documentInputStream2);
                documentInputStream2.close();
                return create;
            } catch (MarkUnsupportedException unused) {
                documentInputStream2.close();
                return null;
            } catch (Throwable th) {
                th = th;
                documentInputStream = documentInputStream2;
                if (documentInputStream != null) {
                    documentInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static PropertySet create(InputStream inputStream) throws NoPropertySetStreamException, MarkUnsupportedException, UnsupportedEncodingException, IOException {
        PropertySet propertySet = new PropertySet(inputStream);
        try {
            if (propertySet.isSummaryInformation()) {
                return new SummaryInformation(propertySet);
            }
            return propertySet.isDocumentSummaryInformation() ? new DocumentSummaryInformation(propertySet) : propertySet;
        } catch (UnexpectedPropertySetTypeException e) {
            throw new IllegalStateException(e);
        }
    }

    public static SummaryInformation newSummaryInformation() {
        MutablePropertySet mutablePropertySet = new MutablePropertySet();
        ((MutableSection) mutablePropertySet.getFirstSection()).setFormatID(SectionIDMap.SUMMARY_INFORMATION_ID);
        try {
            return new SummaryInformation(mutablePropertySet);
        } catch (UnexpectedPropertySetTypeException e) {
            throw new HPSFRuntimeException(e);
        }
    }

    public static DocumentSummaryInformation newDocumentSummaryInformation() {
        MutablePropertySet mutablePropertySet = new MutablePropertySet();
        ((MutableSection) mutablePropertySet.getFirstSection()).setFormatID(SectionIDMap.DOCUMENT_SUMMARY_INFORMATION_ID[0]);
        try {
            return new DocumentSummaryInformation(mutablePropertySet);
        } catch (UnexpectedPropertySetTypeException e) {
            throw new HPSFRuntimeException(e);
        }
    }
}
