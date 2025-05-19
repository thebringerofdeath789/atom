package org.apache.poi.openxml4j.opc.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.StreamHelper;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.w3c.dom.Document;

/* loaded from: classes5.dex */
public class ZipContentTypeManager extends ContentTypeManager {
    private static POILogger logger = POILogFactory.getLogger((Class<?>) ZipContentTypeManager.class);

    public ZipContentTypeManager(InputStream inputStream, OPCPackage oPCPackage) throws InvalidFormatException {
        super(inputStream, oPCPackage);
    }

    @Override // org.apache.poi.openxml4j.opc.internal.ContentTypeManager
    public boolean saveImpl(Document document, OutputStream outputStream) {
        ZipOutputStream zipOutputStream;
        if (outputStream instanceof ZipOutputStream) {
            zipOutputStream = (ZipOutputStream) outputStream;
        } else {
            zipOutputStream = new ZipOutputStream(outputStream);
        }
        try {
            zipOutputStream.putNextEntry(new ZipEntry(ContentTypeManager.CONTENT_TYPES_PART_NAME));
            if (!StreamHelper.saveXmlInStream(document, zipOutputStream)) {
                return false;
            }
            zipOutputStream.closeEntry();
            return true;
        } catch (IOException e) {
            logger.log(7, (Object) "Cannot write: [Content_Types].xml in Zip !", (Throwable) e);
            return false;
        }
    }
}
