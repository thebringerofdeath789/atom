package org.apache.poi.openxml4j.opc;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JRuntimeException;
import org.apache.poi.openxml4j.exceptions.PartAlreadyExistsException;
import org.apache.poi.openxml4j.opc.internal.ContentType;
import org.apache.poi.openxml4j.opc.internal.ContentTypeManager;
import org.apache.poi.openxml4j.opc.internal.PackagePropertiesPart;
import org.apache.poi.openxml4j.opc.internal.PartMarshaller;
import org.apache.poi.openxml4j.opc.internal.PartUnmarshaller;
import org.apache.poi.openxml4j.opc.internal.ZipContentTypeManager;
import org.apache.poi.openxml4j.opc.internal.marshallers.DefaultMarshaller;
import org.apache.poi.openxml4j.opc.internal.marshallers.ZipPackagePropertiesMarshaller;
import org.apache.poi.openxml4j.opc.internal.unmarshallers.PackagePropertiesUnmarshaller;
import org.apache.poi.openxml4j.opc.internal.unmarshallers.UnmarshallContext;
import org.apache.poi.openxml4j.util.Nullable;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* loaded from: classes5.dex */
public abstract class OPCPackage implements RelationshipSource, Closeable {
    protected ContentTypeManager contentTypeManager;
    protected PartMarshaller defaultPartMarshaller;
    protected boolean isDirty = false;
    protected String originalPackagePath;
    protected OutputStream output;
    private PackageAccess packageAccess;
    protected PackagePropertiesPart packageProperties;
    protected PackagePartCollection partList;
    protected Hashtable<ContentType, PartMarshaller> partMarshallers;
    protected Hashtable<ContentType, PartUnmarshaller> partUnmarshallers;
    protected PackageRelationshipCollection relationships;
    private static POILogger logger = POILogFactory.getLogger((Class<?>) OPCPackage.class);
    protected static final PackageAccess defaultPackageAccess = PackageAccess.READ_WRITE;

    protected abstract void closeImpl() throws IOException;

    protected abstract PackagePart createPartImpl(PackagePartName packagePartName, String str, boolean z);

    protected abstract void flushImpl();

    protected abstract PackagePart getPartImpl(PackagePartName packagePartName);

    protected abstract PackagePart[] getPartsImpl() throws InvalidFormatException;

    protected abstract void removePartImpl(PackagePartName packagePartName);

    protected abstract void revertImpl();

    protected abstract void saveImpl(OutputStream outputStream) throws IOException;

    OPCPackage(PackageAccess packageAccess) {
        if (getClass() != ZipPackage.class) {
            throw new IllegalArgumentException("PackageBase may not be subclassed");
        }
        init();
        this.packageAccess = packageAccess;
    }

    private void init() {
        this.partMarshallers = new Hashtable<>(5);
        Hashtable<ContentType, PartUnmarshaller> hashtable = new Hashtable<>(2);
        this.partUnmarshallers = hashtable;
        try {
            hashtable.put(new ContentType(ContentTypes.CORE_PROPERTIES_PART), new PackagePropertiesUnmarshaller());
            this.defaultPartMarshaller = new DefaultMarshaller();
            this.partMarshallers.put(new ContentType(ContentTypes.CORE_PROPERTIES_PART), new ZipPackagePropertiesMarshaller());
        } catch (InvalidFormatException e) {
            throw new OpenXML4JRuntimeException("Package.init() : this exception should never happen, if you read this message please send a mail to the developers team. : " + e.getMessage());
        }
    }

    public static OPCPackage open(String str) throws InvalidFormatException {
        return open(str, defaultPackageAccess);
    }

    public static OPCPackage open(File file) throws InvalidFormatException {
        return open(file, defaultPackageAccess);
    }

    public static OPCPackage open(String str, PackageAccess packageAccess) throws InvalidFormatException {
        if (str == null || "".equals(str.trim())) {
            throw new IllegalArgumentException("'path' must be given");
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            throw new IllegalArgumentException("path must not be a directory");
        }
        ZipPackage zipPackage = new ZipPackage(str, packageAccess);
        if (zipPackage.partList == null && packageAccess != PackageAccess.WRITE) {
            zipPackage.getParts();
        }
        zipPackage.originalPackagePath = new File(str).getAbsolutePath();
        return zipPackage;
    }

    public static OPCPackage open(File file, PackageAccess packageAccess) throws InvalidFormatException {
        if (file == null) {
            throw new IllegalArgumentException("'file' must be given");
        }
        if (file == null || (file.exists() && file.isDirectory())) {
            throw new IllegalArgumentException("file must not be a directory");
        }
        ZipPackage zipPackage = new ZipPackage(file, packageAccess);
        if (zipPackage.partList == null && packageAccess != PackageAccess.WRITE) {
            zipPackage.getParts();
        }
        zipPackage.originalPackagePath = file.getAbsolutePath();
        return zipPackage;
    }

    public static OPCPackage open(InputStream inputStream) throws InvalidFormatException, IOException {
        ZipPackage zipPackage = new ZipPackage(inputStream, PackageAccess.READ_WRITE);
        if (zipPackage.partList == null) {
            zipPackage.getParts();
        }
        return zipPackage;
    }

    public static OPCPackage openOrCreate(File file) throws InvalidFormatException {
        if (file.exists()) {
            return open(file.getAbsolutePath());
        }
        return create(file);
    }

    public static OPCPackage create(String str) {
        return create(new File(str));
    }

    public static OPCPackage create(File file) {
        if (file == null || (file.exists() && file.isDirectory())) {
            throw new IllegalArgumentException(StringLookupFactory.KEY_FILE);
        }
        if (file.exists()) {
            throw new InvalidOperationException("This package (or file) already exists : use the open() method or delete the file.");
        }
        ZipPackage zipPackage = new ZipPackage();
        zipPackage.originalPackagePath = file.getAbsolutePath();
        configurePackage(zipPackage);
        return zipPackage;
    }

    public static OPCPackage create(OutputStream outputStream) {
        ZipPackage zipPackage = new ZipPackage();
        zipPackage.originalPackagePath = null;
        zipPackage.output = outputStream;
        configurePackage(zipPackage);
        return zipPackage;
    }

    private static void configurePackage(OPCPackage oPCPackage) {
        try {
            ZipContentTypeManager zipContentTypeManager = new ZipContentTypeManager(null, oPCPackage);
            oPCPackage.contentTypeManager = zipContentTypeManager;
            zipContentTypeManager.addContentType(PackagingURIHelper.createPartName(PackagingURIHelper.PACKAGE_RELATIONSHIPS_ROOT_URI), ContentTypes.RELATIONSHIPS_PART);
            oPCPackage.contentTypeManager.addContentType(PackagingURIHelper.createPartName("/default.xml"), ContentTypes.PLAIN_OLD_XML);
            PackagePropertiesPart packagePropertiesPart = new PackagePropertiesPart(oPCPackage, PackagingURIHelper.CORE_PROPERTIES_PART_NAME);
            oPCPackage.packageProperties = packagePropertiesPart;
            packagePropertiesPart.setCreatorProperty("Generated by Apache POI OpenXML4J");
            oPCPackage.packageProperties.setCreatedProperty(new Nullable<>(new Date()));
        } catch (InvalidFormatException e) {
            throw new IllegalStateException(e);
        }
    }

    public void flush() {
        throwExceptionIfReadOnly();
        PackagePropertiesPart packagePropertiesPart = this.packageProperties;
        if (packagePropertiesPart != null) {
            packagePropertiesPart.flush();
        }
        flushImpl();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.packageAccess == PackageAccess.READ) {
            logger.log(5, "The close() method is intended to SAVE a package. This package is open in READ ONLY mode, use the revert() method instead !");
            revert();
            return;
        }
        if (this.contentTypeManager == null) {
            logger.log(5, "Unable to call close() on a package that hasn't been fully opened yet");
            return;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        try {
            reentrantReadWriteLock.writeLock().lock();
            String str = this.originalPackagePath;
            if (str != null && !"".equals(str.trim())) {
                File file = new File(this.originalPackagePath);
                if (file.exists() && this.originalPackagePath.equalsIgnoreCase(file.getAbsolutePath())) {
                    closeImpl();
                }
                save(file);
            } else {
                OutputStream outputStream = this.output;
                if (outputStream != null) {
                    save(outputStream);
                    this.output.close();
                }
            }
            reentrantReadWriteLock.writeLock().unlock();
            this.contentTypeManager.clearAll();
        } catch (Throwable th) {
            reentrantReadWriteLock.writeLock().unlock();
            throw th;
        }
    }

    public void revert() {
        revertImpl();
    }

    public void addThumbnail(String str) throws IOException {
        PackagePartName createPartName;
        if ("".equals(str)) {
            throw new IllegalArgumentException("path");
        }
        String substring = str.substring(str.lastIndexOf(File.separatorChar) + 1);
        String contentTypeFromFileExtension = ContentTypes.getContentTypeFromFileExtension(substring);
        try {
            try {
                createPartName = PackagingURIHelper.createPartName("/docProps/" + substring);
            } catch (InvalidFormatException unused) {
                createPartName = PackagingURIHelper.createPartName("/docProps/thumbnail" + str.substring(str.lastIndexOf(".") + 1));
            }
            if (getPart(createPartName) != null) {
                throw new InvalidOperationException("You already add a thumbnail named '" + substring + "'");
            }
            PackagePart createPart = createPart(createPartName, contentTypeFromFileExtension, false);
            addRelationship(createPartName, TargetMode.INTERNAL, PackageRelationshipTypes.THUMBNAIL);
            FileInputStream fileInputStream = new FileInputStream(str);
            StreamHelper.copyStream(fileInputStream, createPart.getOutputStream());
            fileInputStream.close();
        } catch (InvalidFormatException unused2) {
            throw new InvalidOperationException("Can't add a thumbnail file named '" + substring + "'");
        }
    }

    void throwExceptionIfReadOnly() throws InvalidOperationException {
        if (this.packageAccess == PackageAccess.READ) {
            throw new InvalidOperationException("Operation not allowed, document open in read only mode!");
        }
    }

    void throwExceptionIfWriteOnly() throws InvalidOperationException {
        if (this.packageAccess == PackageAccess.WRITE) {
            throw new InvalidOperationException("Operation not allowed, document open in write only mode!");
        }
    }

    public PackageProperties getPackageProperties() throws InvalidFormatException {
        throwExceptionIfWriteOnly();
        if (this.packageProperties == null) {
            this.packageProperties = new PackagePropertiesPart(this, PackagingURIHelper.CORE_PROPERTIES_PART_NAME);
        }
        return this.packageProperties;
    }

    public PackagePart getPart(PackagePartName packagePartName) {
        throwExceptionIfWriteOnly();
        if (packagePartName == null) {
            throw new IllegalArgumentException("partName");
        }
        if (this.partList == null) {
            try {
                getParts();
            } catch (InvalidFormatException unused) {
                return null;
            }
        }
        return getPartImpl(packagePartName);
    }

    public ArrayList<PackagePart> getPartsByContentType(String str) {
        ArrayList<PackagePart> arrayList = new ArrayList<>();
        for (PackagePart packagePart : this.partList.values()) {
            if (packagePart.getContentType().equals(str)) {
                arrayList.add(packagePart);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public ArrayList<PackagePart> getPartsByRelationshipType(String str) {
        if (str == null) {
            throw new IllegalArgumentException("relationshipType");
        }
        ArrayList<PackagePart> arrayList = new ArrayList<>();
        Iterator<PackageRelationship> it = getRelationshipsByType(str).iterator();
        while (it.hasNext()) {
            PackagePart part = getPart(it.next());
            if (part != null) {
                arrayList.add(part);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public List<PackagePart> getPartsByName(Pattern pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("name pattern must not be null");
        }
        Matcher matcher = pattern.matcher("");
        ArrayList arrayList = new ArrayList();
        for (PackagePart packagePart : this.partList.values()) {
            if (matcher.reset(packagePart.getPartName().getName()).matches()) {
                arrayList.add(packagePart);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public PackagePart getPart(PackageRelationship packageRelationship) {
        ensureRelationships();
        Iterator<PackageRelationship> it = this.relationships.iterator();
        while (it.hasNext()) {
            PackageRelationship next = it.next();
            if (next.getRelationshipType().equals(packageRelationship.getRelationshipType())) {
                try {
                    return getPart(PackagingURIHelper.createPartName(next.getTargetURI()));
                } catch (InvalidFormatException unused) {
                    continue;
                }
            }
        }
        return null;
    }

    public ArrayList<PackagePart> getParts() throws InvalidFormatException {
        throwExceptionIfWriteOnly();
        if (this.partList == null) {
            PackagePart[] partsImpl = getPartsImpl();
            this.partList = new PackagePartCollection();
            boolean z = true;
            boolean z2 = false;
            for (PackagePart packagePart : partsImpl) {
                if (this.partList.containsKey(packagePart._partName)) {
                    throw new InvalidFormatException("A part with the name '" + packagePart._partName + "' already exist : Packages shall not contain equivalent part names and package implementers shall neither create nor recognize packages with equivalent part names. [M1.12]");
                }
                if (packagePart.getContentType().equals(ContentTypes.CORE_PROPERTIES_PART)) {
                    if (z2) {
                        logger.log(5, "OPC Compliance error [M4.1]: there is more than one core properties relationship in the package! POI will use only the first, but other software may reject this file.");
                    } else {
                        z2 = true;
                    }
                }
                PartUnmarshaller partUnmarshaller = this.partUnmarshallers.get(packagePart._contentType);
                if (partUnmarshaller != null) {
                    try {
                        PackagePart unmarshall = partUnmarshaller.unmarshall(new UnmarshallContext(this, packagePart._partName), packagePart.getInputStream());
                        this.partList.put(unmarshall._partName, unmarshall);
                        if ((unmarshall instanceof PackagePropertiesPart) && z2 && z) {
                            this.packageProperties = (PackagePropertiesPart) unmarshall;
                            z = false;
                        }
                    } catch (IOException unused) {
                        logger.log(5, "Unmarshall operation : IOException for " + packagePart._partName);
                    } catch (InvalidOperationException e) {
                        throw new InvalidFormatException(e.getMessage());
                    }
                } else {
                    try {
                        this.partList.put(packagePart._partName, packagePart);
                    } catch (InvalidOperationException e2) {
                        throw new InvalidFormatException(e2.getMessage());
                    }
                }
            }
        }
        ArrayList<PackagePart> arrayList = new ArrayList<>(this.partList.values());
        Collections.sort(arrayList);
        return arrayList;
    }

    public PackagePart createPart(PackagePartName packagePartName, String str) {
        return createPart(packagePartName, str, true);
    }

    PackagePart createPart(PackagePartName packagePartName, String str, boolean z) {
        throwExceptionIfReadOnly();
        if (packagePartName == null) {
            throw new IllegalArgumentException("partName");
        }
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("contentType");
        }
        if (this.partList.containsKey(packagePartName) && !this.partList.get(packagePartName).isDeleted()) {
            throw new PartAlreadyExistsException("A part with the name '" + packagePartName.getName() + "' already exists : Packages shall not contain equivalent part names and package implementers shall neither create nor recognize packages with equivalent part names. [M1.12]");
        }
        if (str.equals(ContentTypes.CORE_PROPERTIES_PART) && this.packageProperties != null) {
            throw new InvalidOperationException("OPC Compliance error [M4.1]: you try to add more than one core properties relationship in the package !");
        }
        PackagePart createPartImpl = createPartImpl(packagePartName, str, z);
        this.contentTypeManager.addContentType(packagePartName, str);
        this.partList.put(packagePartName, createPartImpl);
        this.isDirty = true;
        return createPartImpl;
    }

    public PackagePart createPart(PackagePartName packagePartName, String str, ByteArrayOutputStream byteArrayOutputStream) {
        PackagePart createPart = createPart(packagePartName, str);
        if (createPart != null && byteArrayOutputStream != null) {
            try {
                OutputStream outputStream = createPart.getOutputStream();
                if (outputStream == null) {
                    return null;
                }
                outputStream.write(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                outputStream.close();
                return createPart;
            } catch (IOException unused) {
            }
        }
        return null;
    }

    protected PackagePart addPackagePart(PackagePart packagePart) {
        throwExceptionIfReadOnly();
        if (packagePart == null) {
            throw new IllegalArgumentException("part");
        }
        if (this.partList.containsKey(packagePart._partName)) {
            if (!this.partList.get(packagePart._partName).isDeleted()) {
                throw new InvalidOperationException("A part with the name '" + packagePart._partName.getName() + "' already exists : Packages shall not contain equivalent part names and package implementers shall neither create nor recognize packages with equivalent part names. [M1.12]");
            }
            packagePart.setDeleted(false);
            this.partList.remove((Object) packagePart._partName);
        }
        this.partList.put(packagePart._partName, packagePart);
        this.isDirty = true;
        return packagePart;
    }

    public void removePart(PackagePart packagePart) {
        if (packagePart != null) {
            removePart(packagePart.getPartName());
        }
    }

    public void removePart(PackagePartName packagePartName) {
        PackagePart part;
        throwExceptionIfReadOnly();
        if (packagePartName == null || !containPart(packagePartName)) {
            throw new IllegalArgumentException("partName");
        }
        if (this.partList.containsKey(packagePartName)) {
            this.partList.get(packagePartName).setDeleted(true);
            removePartImpl(packagePartName);
            this.partList.remove((Object) packagePartName);
        } else {
            removePartImpl(packagePartName);
        }
        this.contentTypeManager.removeContentType(packagePartName);
        if (packagePartName.isRelationshipPartURI()) {
            URI sourcePartUriFromRelationshipPartUri = PackagingURIHelper.getSourcePartUriFromRelationshipPartUri(packagePartName.getURI());
            try {
                PackagePartName createPartName = PackagingURIHelper.createPartName(sourcePartUriFromRelationshipPartUri);
                if (createPartName.getURI().equals(PackagingURIHelper.PACKAGE_ROOT_URI)) {
                    clearRelationships();
                } else if (containPart(createPartName) && (part = getPart(createPartName)) != null) {
                    part.clearRelationships();
                }
            } catch (InvalidFormatException unused) {
                logger.log(7, "Part name URI '" + sourcePartUriFromRelationshipPartUri + "' is not valid ! This message is not intended to be displayed !");
                return;
            }
        }
        this.isDirty = true;
    }

    public void removePartRecursive(PackagePartName packagePartName) throws InvalidFormatException {
        PackagePart packagePart = this.partList.get(PackagingURIHelper.getRelationshipPartName(packagePartName));
        PackagePart packagePart2 = this.partList.get(packagePartName);
        if (packagePart != null) {
            Iterator<PackageRelationship> it = new PackageRelationshipCollection(packagePart2).iterator();
            while (it.hasNext()) {
                PackageRelationship next = it.next();
                removePart(PackagingURIHelper.createPartName(PackagingURIHelper.resolvePartUri(next.getSourceURI(), next.getTargetURI())));
            }
            removePart(packagePart._partName);
        }
        removePart(packagePart2._partName);
    }

    public void deletePart(PackagePartName packagePartName) {
        if (packagePartName == null) {
            throw new IllegalArgumentException("partName");
        }
        removePart(packagePartName);
        removePart(PackagingURIHelper.getRelationshipPartName(packagePartName));
    }

    public void deletePartRecursive(PackagePartName packagePartName) {
        if (packagePartName == null || !containPart(packagePartName)) {
            throw new IllegalArgumentException("partName");
        }
        PackagePart part = getPart(packagePartName);
        removePart(packagePartName);
        try {
            Iterator<PackageRelationship> it = part.getRelationships().iterator();
            while (it.hasNext()) {
                deletePartRecursive(PackagingURIHelper.createPartName(PackagingURIHelper.resolvePartUri(packagePartName.getURI(), it.next().getTargetURI())));
            }
            PackagePartName relationshipPartName = PackagingURIHelper.getRelationshipPartName(packagePartName);
            if (relationshipPartName == null || !containPart(relationshipPartName)) {
                return;
            }
            removePart(relationshipPartName);
        } catch (InvalidFormatException e) {
            logger.log(5, "An exception occurs while deleting part '" + packagePartName.getName() + "'. Some parts may remain in the package. - " + e.getMessage());
        }
    }

    public boolean containPart(PackagePartName packagePartName) {
        return getPart(packagePartName) != null;
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public PackageRelationship addRelationship(PackagePartName packagePartName, TargetMode targetMode, String str, String str2) {
        if (str.equals(PackageRelationshipTypes.CORE_PROPERTIES) && this.packageProperties != null) {
            throw new InvalidOperationException("OPC Compliance error [M4.1]: can't add another core properties part ! Use the built-in package method instead.");
        }
        if (packagePartName.isRelationshipPartURI()) {
            throw new InvalidOperationException("Rule M1.25: The Relationships part shall not have relationships to any other part.");
        }
        ensureRelationships();
        PackageRelationship addRelationship = this.relationships.addRelationship(packagePartName.getURI(), targetMode, str, str2);
        this.isDirty = true;
        return addRelationship;
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public PackageRelationship addRelationship(PackagePartName packagePartName, TargetMode targetMode, String str) {
        return addRelationship(packagePartName, targetMode, str, null);
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public PackageRelationship addExternalRelationship(String str, String str2) {
        return addExternalRelationship(str, str2, null);
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public PackageRelationship addExternalRelationship(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException("target");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("relationshipType");
        }
        try {
            URI uri = new URI(str);
            ensureRelationships();
            PackageRelationship addRelationship = this.relationships.addRelationship(uri, TargetMode.EXTERNAL, str2, str3);
            this.isDirty = true;
            return addRelationship;
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid target - " + e);
        }
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public void removeRelationship(String str) {
        PackageRelationshipCollection packageRelationshipCollection = this.relationships;
        if (packageRelationshipCollection != null) {
            packageRelationshipCollection.removeRelationship(str);
            this.isDirty = true;
        }
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public PackageRelationshipCollection getRelationships() {
        return getRelationshipsHelper(null);
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public PackageRelationshipCollection getRelationshipsByType(String str) {
        throwExceptionIfWriteOnly();
        if (str == null) {
            throw new IllegalArgumentException("relationshipType");
        }
        return getRelationshipsHelper(str);
    }

    private PackageRelationshipCollection getRelationshipsHelper(String str) {
        throwExceptionIfWriteOnly();
        ensureRelationships();
        return this.relationships.getRelationships(str);
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public void clearRelationships() {
        PackageRelationshipCollection packageRelationshipCollection = this.relationships;
        if (packageRelationshipCollection != null) {
            packageRelationshipCollection.clear();
            this.isDirty = true;
        }
    }

    public void ensureRelationships() {
        if (this.relationships == null) {
            try {
                this.relationships = new PackageRelationshipCollection(this);
            } catch (InvalidFormatException unused) {
                this.relationships = new PackageRelationshipCollection();
            }
        }
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public PackageRelationship getRelationship(String str) {
        return this.relationships.getRelationshipByID(str);
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public boolean hasRelationships() {
        return this.relationships.size() > 0;
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public boolean isRelationshipExists(PackageRelationship packageRelationship) {
        Iterator<PackageRelationship> it = getRelationships().iterator();
        while (it.hasNext()) {
            if (it.next() == packageRelationship) {
                return true;
            }
        }
        return false;
    }

    public void addMarshaller(String str, PartMarshaller partMarshaller) {
        try {
            this.partMarshallers.put(new ContentType(str), partMarshaller);
        } catch (InvalidFormatException e) {
            logger.log(5, "The specified content type is not valid: '" + e.getMessage() + "'. The marshaller will not be added !");
        }
    }

    public void addUnmarshaller(String str, PartUnmarshaller partUnmarshaller) {
        try {
            this.partUnmarshallers.put(new ContentType(str), partUnmarshaller);
        } catch (InvalidFormatException e) {
            logger.log(5, "The specified content type is not valid: '" + e.getMessage() + "'. The unmarshaller will not be added !");
        }
    }

    public void removeMarshaller(String str) {
        this.partMarshallers.remove(str);
    }

    public void removeUnmarshaller(String str) {
        this.partUnmarshallers.remove(str);
    }

    public PackageAccess getPackageAccess() {
        return this.packageAccess;
    }

    public boolean validatePackage(OPCPackage oPCPackage) throws InvalidFormatException {
        throw new InvalidOperationException("Not implemented yet !!!");
    }

    public void save(File file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("targetFile");
        }
        throwExceptionIfReadOnly();
        if (file.exists() && file.getAbsolutePath().equals(this.originalPackagePath)) {
            throw new InvalidOperationException("You can't call save(File) to save to the currently open file. To save to the current file, please just call close()");
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                save(fileOutputStream);
            } finally {
                fileOutputStream.close();
            }
        } catch (FileNotFoundException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public void save(OutputStream outputStream) throws IOException {
        throwExceptionIfReadOnly();
        saveImpl(outputStream);
    }

    public boolean replaceContentType(String str, String str2) {
        Iterator<PackagePart> it = getPartsByContentType(str).iterator();
        boolean z = false;
        while (it.hasNext()) {
            PackagePart next = it.next();
            if (next.getContentType().equals(str)) {
                this.contentTypeManager.addContentType(next.getPartName(), str2);
                z = true;
            }
        }
        return z;
    }
}
