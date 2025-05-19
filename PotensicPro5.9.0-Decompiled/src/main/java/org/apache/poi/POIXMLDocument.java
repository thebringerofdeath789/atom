package org.apache.poi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.poifs.common.POIFSConstants;
import org.apache.poi.util.IOUtils;
import org.apache.xmlbeans.impl.common.SystemCache;

/* loaded from: classes.dex */
public abstract class POIXMLDocument extends POIXMLDocumentPart {
    public static final String DOCUMENT_CREATOR = "Apache POI";
    public static final String OLE_OBJECT_REL_TYPE = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/oleObject";
    public static final String PACK_OBJECT_REL_TYPE = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/package";
    private OPCPackage pkg;
    private POIXMLProperties properties;

    public abstract List<PackagePart> getAllEmbedds() throws OpenXML4JException;

    protected POIXMLDocument(OPCPackage oPCPackage) {
        super(oPCPackage);
        this.pkg = oPCPackage;
        SystemCache.get().setSaxLoader(null);
    }

    public static OPCPackage openPackage(String str) throws IOException {
        try {
            return OPCPackage.open(str);
        } catch (InvalidFormatException e) {
            throw new IOException(e.toString());
        }
    }

    public OPCPackage getPackage() {
        return this.pkg;
    }

    protected PackagePart getCorePart() {
        return getPackagePart();
    }

    protected PackagePart[] getRelatedByType(String str) throws InvalidFormatException {
        PackageRelationshipCollection relationshipsByType = getPackagePart().getRelationshipsByType(str);
        PackagePart[] packagePartArr = new PackagePart[relationshipsByType.size()];
        Iterator<PackageRelationship> it = relationshipsByType.iterator();
        int i = 0;
        while (it.hasNext()) {
            packagePartArr[i] = getPackagePart().getRelatedPart(it.next());
            i++;
        }
        return packagePartArr;
    }

    public static boolean hasOOXMLHeader(InputStream inputStream) throws IOException {
        inputStream.mark(4);
        byte[] bArr = new byte[4];
        IOUtils.readFully(inputStream, bArr);
        if (inputStream instanceof PushbackInputStream) {
            ((PushbackInputStream) inputStream).unread(bArr);
        } else {
            inputStream.reset();
        }
        return bArr[0] == POIFSConstants.OOXML_FILE_HEADER[0] && bArr[1] == POIFSConstants.OOXML_FILE_HEADER[1] && bArr[2] == POIFSConstants.OOXML_FILE_HEADER[2] && bArr[3] == POIFSConstants.OOXML_FILE_HEADER[3];
    }

    public POIXMLProperties getProperties() {
        if (this.properties == null) {
            try {
                this.properties = new POIXMLProperties(this.pkg);
            } catch (Exception e) {
                throw new POIXMLException(e);
            }
        }
        return this.properties;
    }

    protected final void load(POIXMLFactory pOIXMLFactory) throws IOException {
        HashMap hashMap = new HashMap();
        try {
            read(pOIXMLFactory, hashMap);
            onDocumentRead();
            hashMap.clear();
        } catch (OpenXML4JException e) {
            throw new POIXMLException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void close() throws IOException {
        OPCPackage oPCPackage = this.pkg;
        if (oPCPackage != null) {
            if (oPCPackage.getPackageAccess() == PackageAccess.READ) {
                this.pkg.revert();
            } else {
                this.pkg.close();
            }
            this.pkg = null;
        }
    }

    public final void write(OutputStream outputStream) throws IOException {
        HashSet hashSet = new HashSet();
        onSave(hashSet);
        hashSet.clear();
        getProperties().commit();
        getPackage().save(outputStream);
    }
}
