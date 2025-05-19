package org.apache.poi.openxml4j.opc.internal;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.openxml4j.opc.ZipPackage;

/* loaded from: classes5.dex */
public final class ZipHelper {
    private static final String FORWARD_SLASH = "/";
    public static final int READ_WRITE_FILE_BUFFER_SIZE = 8192;

    private ZipHelper() {
    }

    public static ZipEntry getCorePropertiesZipEntry(ZipPackage zipPackage) {
        PackageRelationship relationship = zipPackage.getRelationshipsByType(PackageRelationshipTypes.CORE_PROPERTIES).getRelationship(0);
        if (relationship == null) {
            return null;
        }
        return new ZipEntry(relationship.getTargetURI().getPath());
    }

    public static ZipEntry getContentTypeZipEntry(ZipPackage zipPackage) {
        Enumeration<? extends ZipEntry> entries = zipPackage.getZipArchive().getEntries();
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            if (nextElement.getName().equals(ContentTypeManager.CONTENT_TYPES_PART_NAME)) {
                return nextElement;
            }
        }
        return null;
    }

    public static String getOPCNameFromZipItemName(String str) {
        if (str != null) {
            return str.startsWith("/") ? str : "/" + str;
        }
        throw new IllegalArgumentException("zipItemName");
    }

    public static String getZipItemNameFromOPCName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("opcItemName");
        }
        while (str.startsWith("/")) {
            str = str.substring(1);
        }
        return str;
    }

    public static URI getZipURIFromOPCName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("opcItemName");
        }
        while (str.startsWith("/")) {
            str = str.substring(1);
        }
        try {
            return new URI(str);
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    public static ZipFile openZipFile(File file) throws IOException {
        if (file.exists()) {
            return new ZipFile(file);
        }
        return null;
    }

    public static ZipFile openZipFile(String str) throws IOException {
        File file = new File(str);
        if (file.exists()) {
            return new ZipFile(file);
        }
        return null;
    }
}
