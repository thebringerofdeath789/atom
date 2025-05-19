package org.apache.poi.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Iterator;
import org.apache.poi.POIXMLException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageProperties;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;

/* loaded from: classes5.dex */
public final class PackageHelper {
    public static OPCPackage open(InputStream inputStream) throws IOException {
        try {
            return OPCPackage.open(inputStream);
        } catch (InvalidFormatException e) {
            throw new POIXMLException(e);
        }
    }

    public static OPCPackage clone(OPCPackage oPCPackage, File file) throws OpenXML4JException, IOException {
        String absolutePath = file.getAbsolutePath();
        OPCPackage create = OPCPackage.create(absolutePath);
        Iterator<PackageRelationship> it = oPCPackage.getRelationships().iterator();
        while (it.hasNext()) {
            PackageRelationship next = it.next();
            PackagePart part = oPCPackage.getPart(next);
            if (next.getRelationshipType().equals(PackageRelationshipTypes.CORE_PROPERTIES)) {
                copyProperties(oPCPackage.getPackageProperties(), create.getPackageProperties());
            } else {
                create.addRelationship(part.getPartName(), next.getTargetMode(), next.getRelationshipType());
                PackagePart createPart = create.createPart(part.getPartName(), part.getContentType());
                OutputStream outputStream = createPart.getOutputStream();
                IOUtils.copy(part.getInputStream(), outputStream);
                outputStream.close();
                if (part.hasRelationships()) {
                    copy(oPCPackage, part, create, createPart);
                }
            }
        }
        create.close();
        new File(absolutePath).deleteOnExit();
        return OPCPackage.open(absolutePath);
    }

    private static void copy(OPCPackage oPCPackage, PackagePart packagePart, OPCPackage oPCPackage2, PackagePart packagePart2) throws OpenXML4JException, IOException {
        PackageRelationshipCollection relationships = packagePart.getRelationships();
        if (relationships != null) {
            Iterator<PackageRelationship> it = relationships.iterator();
            while (it.hasNext()) {
                PackageRelationship next = it.next();
                if (next.getTargetMode() == TargetMode.EXTERNAL) {
                    packagePart2.addExternalRelationship(next.getTargetURI().toString(), next.getRelationshipType(), next.getId());
                } else {
                    URI targetURI = next.getTargetURI();
                    if (targetURI.getRawFragment() != null) {
                        packagePart2.addRelationship(targetURI, next.getTargetMode(), next.getRelationshipType(), next.getId());
                    } else {
                        PackagePart part = oPCPackage.getPart(PackagingURIHelper.createPartName(next.getTargetURI()));
                        packagePart2.addRelationship(part.getPartName(), next.getTargetMode(), next.getRelationshipType(), next.getId());
                        if (!oPCPackage2.containPart(part.getPartName())) {
                            PackagePart createPart = oPCPackage2.createPart(part.getPartName(), part.getContentType());
                            OutputStream outputStream = createPart.getOutputStream();
                            IOUtils.copy(part.getInputStream(), outputStream);
                            outputStream.close();
                            copy(oPCPackage, part, oPCPackage2, createPart);
                        }
                    }
                }
            }
        }
    }

    private static void copyProperties(PackageProperties packageProperties, PackageProperties packageProperties2) {
        packageProperties2.setCategoryProperty(packageProperties.getCategoryProperty().getValue());
        packageProperties2.setContentStatusProperty(packageProperties.getContentStatusProperty().getValue());
        packageProperties2.setContentTypeProperty(packageProperties.getContentTypeProperty().getValue());
        packageProperties2.setCreatorProperty(packageProperties.getCreatorProperty().getValue());
        packageProperties2.setDescriptionProperty(packageProperties.getDescriptionProperty().getValue());
        packageProperties2.setIdentifierProperty(packageProperties.getIdentifierProperty().getValue());
        packageProperties2.setKeywordsProperty(packageProperties.getKeywordsProperty().getValue());
        packageProperties2.setLanguageProperty(packageProperties.getLanguageProperty().getValue());
        packageProperties2.setRevisionProperty(packageProperties.getRevisionProperty().getValue());
        packageProperties2.setSubjectProperty(packageProperties.getSubjectProperty().getValue());
        packageProperties2.setTitleProperty(packageProperties.getTitleProperty().getValue());
        packageProperties2.setVersionProperty(packageProperties.getVersionProperty().getValue());
    }
}
