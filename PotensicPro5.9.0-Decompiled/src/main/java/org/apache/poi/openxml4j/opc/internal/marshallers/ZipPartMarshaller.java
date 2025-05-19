package org.apache.poi.openxml4j.opc.internal.marshallers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.PackageNamespaces;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.StreamHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.openxml4j.opc.internal.PartMarshaller;
import org.apache.poi.openxml4j.opc.internal.ZipHelper;
import org.apache.poi.util.DocumentHelper;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* loaded from: classes5.dex */
public final class ZipPartMarshaller implements PartMarshaller {
    private static POILogger logger = POILogFactory.getLogger((Class<?>) ZipPartMarshaller.class);

    @Override // org.apache.poi.openxml4j.opc.internal.PartMarshaller
    public boolean marshall(PackagePart packagePart, OutputStream outputStream) throws OpenXML4JException {
        int read;
        if (!(outputStream instanceof ZipOutputStream)) {
            logger.log(7, "Unexpected class " + outputStream.getClass().getName());
            throw new OpenXML4JException("ZipOutputStream expected !");
        }
        ZipOutputStream zipOutputStream = (ZipOutputStream) outputStream;
        try {
            zipOutputStream.putNextEntry(new ZipEntry(ZipHelper.getZipItemNameFromOPCName(packagePart.getPartName().getURI().getPath())));
            InputStream inputStream = packagePart.getInputStream();
            byte[] bArr = new byte[8192];
            while (inputStream.available() > 0 && (read = inputStream.read(bArr)) != -1) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            if (!packagePart.hasRelationships()) {
                return true;
            }
            marshallRelationshipPart(packagePart.getRelationships(), PackagingURIHelper.getRelationshipPartName(packagePart.getPartName()), zipOutputStream);
            return true;
        } catch (IOException e) {
            logger.log(7, (Object) ("Cannot write: " + packagePart.getPartName() + ": in ZIP"), (Throwable) e);
            return false;
        }
    }

    public static boolean marshallRelationshipPart(PackageRelationshipCollection packageRelationshipCollection, PackagePartName packagePartName, ZipOutputStream zipOutputStream) {
        String uri;
        Document createDocument = DocumentHelper.createDocument();
        Element createElementNS = createDocument.createElementNS(PackageNamespaces.RELATIONSHIPS, PackageRelationship.RELATIONSHIPS_TAG_NAME);
        createDocument.appendChild(createElementNS);
        URI sourcePartUriFromRelationshipPartUri = PackagingURIHelper.getSourcePartUriFromRelationshipPartUri(packagePartName.getURI());
        Iterator<PackageRelationship> it = packageRelationshipCollection.iterator();
        while (it.hasNext()) {
            PackageRelationship next = it.next();
            Element createElementNS2 = createDocument.createElementNS(PackageNamespaces.RELATIONSHIPS, PackageRelationship.RELATIONSHIP_TAG_NAME);
            createElementNS.appendChild(createElementNS2);
            createElementNS2.setAttribute(PackageRelationship.ID_ATTRIBUTE_NAME, next.getId());
            createElementNS2.setAttribute(PackageRelationship.TYPE_ATTRIBUTE_NAME, next.getRelationshipType());
            URI targetURI = next.getTargetURI();
            if (next.getTargetMode() == TargetMode.EXTERNAL) {
                uri = targetURI.toString();
                createElementNS2.setAttribute(PackageRelationship.TARGET_MODE_ATTRIBUTE_NAME, "External");
            } else {
                uri = PackagingURIHelper.relativizeURI(sourcePartUriFromRelationshipPartUri, next.getTargetURI(), true).toString();
            }
            createElementNS2.setAttribute(PackageRelationship.TARGET_ATTRIBUTE_NAME, uri);
        }
        createDocument.normalize();
        try {
            zipOutputStream.putNextEntry(new ZipEntry(ZipHelper.getZipURIFromOPCName(packagePartName.getURI().toASCIIString()).getPath()));
            if (!StreamHelper.saveXmlInStream(createDocument, zipOutputStream)) {
                return false;
            }
            zipOutputStream.closeEntry();
            return true;
        } catch (IOException e) {
            logger.log(7, (Object) ("Cannot create zip entry " + packagePartName), (Throwable) e);
            return false;
        }
    }
}
