package org.apache.poi.openxml4j.opc;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

@Deprecated
/* loaded from: classes5.dex */
public abstract class Package extends OPCPackage {
    @Deprecated
    protected Package(PackageAccess packageAccess) {
        super(packageAccess);
    }

    @Deprecated
    public static Package open(String str) throws InvalidFormatException {
        return open(str, defaultPackageAccess);
    }

    @Deprecated
    public static Package open(String str, PackageAccess packageAccess) throws InvalidFormatException {
        return (Package) OPCPackage.open(str, packageAccess);
    }

    @Deprecated
    public static Package open(InputStream inputStream) throws InvalidFormatException, IOException {
        return (Package) OPCPackage.open(inputStream);
    }

    @Deprecated
    public static Package openOrCreate(File file) throws InvalidFormatException {
        return (Package) OPCPackage.openOrCreate(file);
    }

    @Deprecated
    public static Package create(String str) {
        return (Package) OPCPackage.create(str);
    }

    @Deprecated
    public static Package create(File file) {
        return (Package) OPCPackage.create(file);
    }

    @Deprecated
    public static Package create(OutputStream outputStream) {
        return (Package) OPCPackage.create(outputStream);
    }
}
