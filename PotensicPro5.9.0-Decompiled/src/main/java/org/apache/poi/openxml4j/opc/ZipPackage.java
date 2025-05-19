package org.apache.poi.openxml4j.opc;

import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JRuntimeException;
import org.apache.poi.openxml4j.opc.internal.ContentTypeManager;
import org.apache.poi.openxml4j.opc.internal.FileHelper;
import org.apache.poi.openxml4j.opc.internal.MemoryPackagePart;
import org.apache.poi.openxml4j.opc.internal.PartMarshaller;
import org.apache.poi.openxml4j.opc.internal.ZipContentTypeManager;
import org.apache.poi.openxml4j.opc.internal.ZipHelper;
import org.apache.poi.openxml4j.opc.internal.marshallers.ZipPartMarshaller;
import org.apache.poi.openxml4j.util.ZipEntrySource;
import org.apache.poi.openxml4j.util.ZipFileZipEntrySource;
import org.apache.poi.openxml4j.util.ZipInputStreamZipEntrySource;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.TempFile;

/* loaded from: classes5.dex */
public final class ZipPackage extends Package {
    private static POILogger logger = POILogFactory.getLogger((Class<?>) ZipPackage.class);
    private final ZipEntrySource zipArchive;

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    protected void flushImpl() {
    }

    public ZipPackage() {
        super(defaultPackageAccess);
        this.zipArchive = null;
        try {
            this.contentTypeManager = new ZipContentTypeManager(null, this);
        } catch (InvalidFormatException unused) {
        }
    }

    ZipPackage(InputStream inputStream, PackageAccess packageAccess) throws IOException {
        super(packageAccess);
        this.zipArchive = new ZipInputStreamZipEntrySource(new ZipInputStream(inputStream));
    }

    ZipPackage(String str, PackageAccess packageAccess) {
        super(packageAccess);
        try {
            this.zipArchive = new ZipFileZipEntrySource(ZipHelper.openZipFile(str));
        } catch (IOException e) {
            throw new InvalidOperationException("Can't open the specified file: '" + str + "'", e);
        }
    }

    ZipPackage(File file, PackageAccess packageAccess) {
        super(packageAccess);
        try {
            this.zipArchive = new ZipFileZipEntrySource(ZipHelper.openZipFile(file));
        } catch (IOException e) {
            throw new InvalidOperationException("Can't open the specified file: '" + file + "'", e);
        }
    }

    ZipPackage(ZipEntrySource zipEntrySource, PackageAccess packageAccess) {
        super(packageAccess);
        this.zipArchive = zipEntrySource;
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    protected PackagePart[] getPartsImpl() throws InvalidFormatException {
        String contentType;
        String contentType2;
        if (this.partList == null) {
            this.partList = new PackagePartCollection();
        }
        ZipEntrySource zipEntrySource = this.zipArchive;
        if (zipEntrySource == null) {
            return (PackagePart[]) this.partList.values().toArray(new PackagePart[this.partList.values().size()]);
        }
        Enumeration<? extends ZipEntry> entries = zipEntrySource.getEntries();
        while (true) {
            if (!entries.hasMoreElements()) {
                break;
            }
            ZipEntry nextElement = entries.nextElement();
            if (nextElement.getName().equalsIgnoreCase(ContentTypeManager.CONTENT_TYPES_PART_NAME)) {
                try {
                    this.contentTypeManager = new ZipContentTypeManager(getZipArchive().getInputStream(nextElement), this);
                    break;
                } catch (IOException e) {
                    throw new InvalidFormatException(e.getMessage());
                }
            }
        }
        if (this.contentTypeManager == null) {
            throw new InvalidFormatException("Package should contain a content type part [M1.13]");
        }
        Enumeration<? extends ZipEntry> entries2 = this.zipArchive.getEntries();
        while (entries2.hasMoreElements()) {
            ZipEntry nextElement2 = entries2.nextElement();
            PackagePartName buildPartName = buildPartName(nextElement2);
            if (buildPartName != null && (contentType2 = this.contentTypeManager.getContentType(buildPartName)) != null && contentType2.equals(ContentTypes.RELATIONSHIPS_PART)) {
                try {
                    this.partList.put(buildPartName, (PackagePart) new ZipPackagePart(this, nextElement2, buildPartName, contentType2));
                } catch (InvalidOperationException e2) {
                    throw new InvalidFormatException(e2.getMessage());
                }
            }
        }
        Enumeration<? extends ZipEntry> entries3 = this.zipArchive.getEntries();
        while (entries3.hasMoreElements()) {
            ZipEntry nextElement3 = entries3.nextElement();
            PackagePartName buildPartName2 = buildPartName(nextElement3);
            if (buildPartName2 != null && ((contentType = this.contentTypeManager.getContentType(buildPartName2)) == null || !contentType.equals(ContentTypes.RELATIONSHIPS_PART))) {
                if (contentType != null) {
                    try {
                        this.partList.put(buildPartName2, (PackagePart) new ZipPackagePart(this, nextElement3, buildPartName2, contentType));
                    } catch (InvalidOperationException e3) {
                        throw new InvalidFormatException(e3.getMessage());
                    }
                } else {
                    throw new InvalidFormatException("The part " + buildPartName2.getURI().getPath() + " does not have any content type ! Rule: Package require content types when retrieving a part from a package. [M.1.14]");
                }
            }
        }
        return (PackagePart[]) this.partList.values().toArray(new ZipPackagePart[this.partList.size()]);
    }

    private PackagePartName buildPartName(ZipEntry zipEntry) {
        try {
            if (zipEntry.getName().equalsIgnoreCase(ContentTypeManager.CONTENT_TYPES_PART_NAME)) {
                return null;
            }
            return PackagingURIHelper.createPartName(ZipHelper.getOPCNameFromZipItemName(zipEntry.getName()));
        } catch (Exception e) {
            logger.log(5, (Object) ("Entry " + zipEntry.getName() + " is not valid, so this part won't be add to the package."), (Throwable) e);
            return null;
        }
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    protected PackagePart createPartImpl(PackagePartName packagePartName, String str, boolean z) {
        if (str == null) {
            throw new IllegalArgumentException("contentType");
        }
        if (packagePartName == null) {
            throw new IllegalArgumentException("partName");
        }
        try {
            return new MemoryPackagePart(this, packagePartName, str, z);
        } catch (InvalidFormatException e) {
            logger.log(5, (Throwable) e);
            return null;
        }
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    protected void removePartImpl(PackagePartName packagePartName) {
        if (packagePartName == null) {
            throw new IllegalArgumentException("partUri");
        }
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    protected void closeImpl() throws IOException {
        boolean delete;
        flush();
        if (this.originalPackagePath == null || "".equals(this.originalPackagePath)) {
            return;
        }
        File file = new File(this.originalPackagePath);
        if (file.exists()) {
            File createTempFile = TempFile.createTempFile(generateTempFileName(FileHelper.getDirectory(file)), DiskFileUpload.postfix);
            try {
                save(createTempFile);
                this.zipArchive.close();
                FileHelper.copyFile(createTempFile, file);
                if (delete) {
                    return;
                } else {
                    return;
                }
            } finally {
                if (!createTempFile.delete()) {
                    logger.log(5, "The temporary file: '" + file.getAbsolutePath() + "' cannot be deleted ! Make sure that no other application use it.");
                }
            }
        }
        throw new InvalidOperationException("Can't close a package not previously open with the open() method !");
    }

    private synchronized String generateTempFileName(File file) {
        File file2;
        do {
            file2 = new File(file.getAbsoluteFile() + File.separator + "OpenXML4J" + System.nanoTime());
        } while (file2.exists());
        return FileHelper.getFilename(file2.getAbsoluteFile());
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    protected void revertImpl() {
        try {
            ZipEntrySource zipEntrySource = this.zipArchive;
            if (zipEntrySource != null) {
                zipEntrySource.close();
            }
        } catch (IOException unused) {
        }
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    protected PackagePart getPartImpl(PackagePartName packagePartName) {
        if (this.partList.containsKey(packagePartName)) {
            return this.partList.get(packagePartName);
        }
        return null;
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public void saveImpl(OutputStream outputStream) {
        ZipOutputStream zipOutputStream;
        throwExceptionIfReadOnly();
        try {
            if (!(outputStream instanceof ZipOutputStream)) {
                zipOutputStream = new ZipOutputStream(outputStream);
            } else {
                zipOutputStream = (ZipOutputStream) outputStream;
            }
            if (getPartsByRelationshipType(PackageRelationshipTypes.CORE_PROPERTIES).size() == 0 && getPartsByRelationshipType(PackageRelationshipTypes.CORE_PROPERTIES_ECMA376).size() == 0) {
                logger.log(1, "Save core properties part");
                getPackageProperties();
                addPackagePart(this.packageProperties);
                this.relationships.addRelationship(this.packageProperties.getPartName().getURI(), TargetMode.INTERNAL, PackageRelationshipTypes.CORE_PROPERTIES, null);
                if (!this.contentTypeManager.isContentTypeRegister(ContentTypes.CORE_PROPERTIES_PART)) {
                    this.contentTypeManager.addContentType(this.packageProperties.getPartName(), ContentTypes.CORE_PROPERTIES_PART);
                }
            }
            logger.log(1, "Save package relationships");
            ZipPartMarshaller.marshallRelationshipPart(getRelationships(), PackagingURIHelper.PACKAGE_RELATIONSHIPS_ROOT_PART_NAME, zipOutputStream);
            logger.log(1, "Save content types part");
            this.contentTypeManager.save(zipOutputStream);
            Iterator<PackagePart> it = getParts().iterator();
            while (it.hasNext()) {
                PackagePart next = it.next();
                if (!next.isRelationshipPart()) {
                    logger.log(1, "Save part '" + ZipHelper.getZipItemNameFromOPCName(next.getPartName().getName()) + "'");
                    PartMarshaller partMarshaller = this.partMarshallers.get(next._contentType);
                    if (partMarshaller != null) {
                        if (!partMarshaller.marshall(next, zipOutputStream)) {
                            throw new OpenXML4JException("The part " + next.getPartName().getURI() + " fail to be saved in the stream with marshaller " + partMarshaller);
                        }
                    } else if (!this.defaultPartMarshaller.marshall(next, zipOutputStream)) {
                        throw new OpenXML4JException("The part " + next.getPartName().getURI() + " fail to be saved in the stream with marshaller " + this.defaultPartMarshaller);
                    }
                }
            }
            zipOutputStream.close();
        } catch (Exception e) {
            throw new OpenXML4JRuntimeException("Fail to save: an error occurs while saving the package : " + e.getMessage(), e);
        }
    }

    public ZipEntrySource getZipArchive() {
        return this.zipArchive;
    }
}
