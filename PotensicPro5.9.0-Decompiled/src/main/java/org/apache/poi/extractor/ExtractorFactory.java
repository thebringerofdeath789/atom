package org.apache.poi.extractor;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import jxl.biff.BaseCompoundFile;
import org.apache.poi.POIOLE2TextExtractor;
import org.apache.poi.POITextExtractor;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hdgf.extractor.VisioTextExtractor;
import org.apache.poi.hpbf.extractor.PublisherTextExtractor;
import org.apache.poi.hslf.extractor.PowerPointExtractor;
import org.apache.poi.hsmf.datatypes.AttachmentChunks;
import org.apache.poi.hsmf.extractor.OutlookTextExtactor;
import org.apache.poi.hssf.extractor.EventBasedExcelExtractor;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hwpf.OldWordFileFormatException;
import org.apache.poi.hwpf.extractor.Word6Extractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xslf.XSLFSlideShow;
import org.apache.poi.xslf.extractor.XSLFPowerPointExtractor;
import org.apache.poi.xslf.usermodel.XSLFRelation;
import org.apache.poi.xssf.extractor.XSSFEventBasedExcelExtractor;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFRelation;
import org.apache.xmlbeans.XmlException;

/* loaded from: classes4.dex */
public class ExtractorFactory {
    public static final String CORE_DOCUMENT_REL = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument";
    protected static final String STRICT_DOCUMENT_REL = "http://purl.oclc.org/ooxml/officeDocument/relationships/officeDocument";
    protected static final String VISIO_DOCUMENT_REL = "http://schemas.microsoft.com/visio/2010/relationships/document";
    private static Boolean allPreferEventExtractors;
    private static final ThreadLocal<Boolean> threadPreferEventExtractors = new ThreadLocal<Boolean>() { // from class: org.apache.poi.extractor.ExtractorFactory.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    };

    public static boolean getThreadPrefersEventExtractors() {
        return threadPreferEventExtractors.get().booleanValue();
    }

    public static Boolean getAllThreadsPreferEventExtractors() {
        return allPreferEventExtractors;
    }

    public static void setThreadPrefersEventExtractors(boolean z) {
        threadPreferEventExtractors.set(Boolean.valueOf(z));
    }

    public static void setAllThreadsPreferEventExtractors(Boolean bool) {
        allPreferEventExtractors = bool;
    }

    protected static boolean getPreferEventExtractor() {
        Boolean bool = allPreferEventExtractors;
        if (bool != null) {
            return bool.booleanValue();
        }
        return threadPreferEventExtractors.get().booleanValue();
    }

    public static POITextExtractor createExtractor(File file) throws IOException, InvalidFormatException, OpenXML4JException, XmlException {
        PushbackInputStream pushbackInputStream;
        PushbackInputStream pushbackInputStream2 = null;
        try {
            pushbackInputStream = new PushbackInputStream(new FileInputStream(file), 8);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (POIFSFileSystem.hasPOIFSHeader(pushbackInputStream)) {
                POIOLE2TextExtractor createExtractor = createExtractor(new POIFSFileSystem(pushbackInputStream));
                pushbackInputStream.close();
                return createExtractor;
            }
            if (POIXMLDocument.hasOOXMLHeader(pushbackInputStream)) {
                POIXMLTextExtractor createExtractor2 = createExtractor(OPCPackage.open(file.toString(), PackageAccess.READ));
                pushbackInputStream.close();
                return createExtractor2;
            }
            throw new IllegalArgumentException("Your File was neither an OLE2 file, nor an OOXML file");
        } catch (Throwable th2) {
            th = th2;
            pushbackInputStream2 = pushbackInputStream;
            if (pushbackInputStream2 != null) {
                pushbackInputStream2.close();
            }
            throw th;
        }
    }

    public static POITextExtractor createExtractor(InputStream inputStream) throws IOException, InvalidFormatException, OpenXML4JException, XmlException {
        if (!inputStream.markSupported()) {
            inputStream = new PushbackInputStream(inputStream, 8);
        }
        if (POIFSFileSystem.hasPOIFSHeader(inputStream)) {
            return createExtractor(new POIFSFileSystem(inputStream));
        }
        if (POIXMLDocument.hasOOXMLHeader(inputStream)) {
            return createExtractor(OPCPackage.open(inputStream));
        }
        throw new IllegalArgumentException("Your InputStream was neither an OLE2 stream, nor an OOXML stream");
    }

    public static POIXMLTextExtractor createExtractor(OPCPackage oPCPackage) throws IOException, OpenXML4JException, XmlException {
        PackageRelationshipCollection relationshipsByType = oPCPackage.getRelationshipsByType("http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument");
        if (relationshipsByType.size() == 0) {
            relationshipsByType = oPCPackage.getRelationshipsByType("http://purl.oclc.org/ooxml/officeDocument/relationships/officeDocument");
        }
        if (relationshipsByType.size() == 0 && oPCPackage.getRelationshipsByType("http://schemas.microsoft.com/visio/2010/relationships/document").size() == 1) {
            throw new IllegalArgumentException("Text extraction not supported for Visio OOXML files");
        }
        if (relationshipsByType.size() != 1) {
            throw new IllegalArgumentException("Invalid OOXML Package received - expected 1 core document, found " + relationshipsByType.size());
        }
        PackagePart part = oPCPackage.getPart(relationshipsByType.getRelationship(0));
        for (XSSFRelation xSSFRelation : XSSFExcelExtractor.SUPPORTED_TYPES) {
            if (part.getContentType().equals(xSSFRelation.getContentType())) {
                if (getPreferEventExtractor()) {
                    return new XSSFEventBasedExcelExtractor(oPCPackage);
                }
                return new XSSFExcelExtractor(oPCPackage);
            }
        }
        for (XWPFRelation xWPFRelation : XWPFWordExtractor.SUPPORTED_TYPES) {
            if (part.getContentType().equals(xWPFRelation.getContentType())) {
                return new XWPFWordExtractor(oPCPackage);
            }
        }
        for (XSLFRelation xSLFRelation : XSLFPowerPointExtractor.SUPPORTED_TYPES) {
            if (part.getContentType().equals(xSLFRelation.getContentType())) {
                return new XSLFPowerPointExtractor(oPCPackage);
            }
        }
        if (XSLFRelation.THEME_MANAGER.getContentType().equals(part.getContentType())) {
            return new XSLFPowerPointExtractor(new XSLFSlideShow(oPCPackage));
        }
        oPCPackage.revert();
        throw new IllegalArgumentException("No supported documents found in the OOXML package (found " + part.getContentType() + ")");
    }

    public static POIOLE2TextExtractor createExtractor(POIFSFileSystem pOIFSFileSystem) throws IOException, InvalidFormatException, OpenXML4JException, XmlException {
        return (POIOLE2TextExtractor) createExtractor(pOIFSFileSystem.getRoot());
    }

    @Deprecated
    public static POITextExtractor createExtractor(DirectoryNode directoryNode, POIFSFileSystem pOIFSFileSystem) throws IOException, InvalidFormatException, OpenXML4JException, XmlException {
        return createExtractor(directoryNode);
    }

    public static POITextExtractor createExtractor(DirectoryNode directoryNode) throws IOException, InvalidFormatException, OpenXML4JException, XmlException {
        if (directoryNode.hasEntry(BaseCompoundFile.WORKBOOK_NAME) || directoryNode.hasEntry("WORKBOOK") || directoryNode.hasEntry("BOOK")) {
            if (getPreferEventExtractor()) {
                return new EventBasedExcelExtractor(directoryNode);
            }
            return new ExcelExtractor(directoryNode);
        }
        if (directoryNode.hasEntry("WordDocument")) {
            try {
                return new WordExtractor(directoryNode);
            } catch (OldWordFileFormatException unused) {
                return new Word6Extractor(directoryNode);
            }
        }
        if (directoryNode.hasEntry("PowerPoint Document")) {
            return new PowerPointExtractor(directoryNode);
        }
        if (directoryNode.hasEntry("VisioDocument")) {
            return new VisioTextExtractor(directoryNode);
        }
        if (directoryNode.hasEntry("Quill")) {
            return new PublisherTextExtractor(directoryNode);
        }
        if (directoryNode.hasEntry("__substg1.0_1000001E") || directoryNode.hasEntry("__substg1.0_1000001F") || directoryNode.hasEntry("__substg1.0_0047001E") || directoryNode.hasEntry("__substg1.0_0047001F") || directoryNode.hasEntry("__substg1.0_0037001E") || directoryNode.hasEntry("__substg1.0_0037001F")) {
            return new OutlookTextExtactor(directoryNode);
        }
        Iterator<Entry> entries = directoryNode.getEntries();
        while (entries.hasNext()) {
            if (entries.next().getName().equals("Package")) {
                return createExtractor(OPCPackage.open(directoryNode.createDocumentInputStream("Package")));
            }
        }
        throw new IllegalArgumentException("No supported documents found in the OLE2 stream");
    }

    public static POITextExtractor[] getEmbededDocsTextExtractors(POIOLE2TextExtractor pOIOLE2TextExtractor) throws IOException, InvalidFormatException, OpenXML4JException, XmlException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        DirectoryEntry root = pOIOLE2TextExtractor.getRoot();
        if (root == null) {
            throw new IllegalStateException("The extractor didn't know which POIFS it came from!");
        }
        if (pOIOLE2TextExtractor instanceof ExcelExtractor) {
            Iterator<Entry> entries = root.getEntries();
            while (entries.hasNext()) {
                Entry next = entries.next();
                if (next.getName().startsWith("MBD")) {
                    arrayList.add(next);
                }
            }
        } else if (pOIOLE2TextExtractor instanceof WordExtractor) {
            try {
                Iterator<Entry> entries2 = ((DirectoryEntry) root.getEntry("ObjectPool")).getEntries();
                while (entries2.hasNext()) {
                    Entry next2 = entries2.next();
                    if (next2.getName().startsWith("_")) {
                        arrayList.add(next2);
                    }
                }
            } catch (FileNotFoundException unused) {
            }
        } else if (!(pOIOLE2TextExtractor instanceof PowerPointExtractor) && (pOIOLE2TextExtractor instanceof OutlookTextExtactor)) {
            for (AttachmentChunks attachmentChunks : ((OutlookTextExtactor) pOIOLE2TextExtractor).getMAPIMessage().getAttachmentFiles()) {
                if (attachmentChunks.attachData != null) {
                    arrayList2.add(new ByteArrayInputStream(attachmentChunks.attachData.getValue()));
                } else if (attachmentChunks.attachmentDirectory != null) {
                    arrayList.add(attachmentChunks.attachmentDirectory.getDirectory());
                }
            }
        }
        if (arrayList.size() == 0 && arrayList2.size() == 0) {
            return new POITextExtractor[0];
        }
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList3.add(createExtractor((DirectoryNode) arrayList.get(i)));
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            try {
                arrayList3.add(createExtractor((InputStream) arrayList2.get(i2)));
            } catch (IllegalArgumentException unused2) {
            } catch (OpenXML4JException e) {
                throw new IOException(e.getMessage());
            } catch (XmlException e2) {
                throw new IOException(e2.getMessage());
            }
        }
        return (POITextExtractor[]) arrayList3.toArray(new POITextExtractor[arrayList3.size()]);
    }

    public static POITextExtractor[] getEmbededDocsTextExtractors(POIXMLTextExtractor pOIXMLTextExtractor) {
        throw new IllegalStateException("Not yet supported");
    }
}
