package org.apache.poi.openxml4j.opc.internal.unmarshallers;

import java.util.zip.ZipEntry;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePartName;

/* loaded from: classes5.dex */
public final class UnmarshallContext {
    private OPCPackage _package;
    private PackagePartName partName;
    private ZipEntry zipEntry;

    public UnmarshallContext(OPCPackage oPCPackage, PackagePartName packagePartName) {
        this._package = oPCPackage;
        this.partName = packagePartName;
    }

    OPCPackage getPackage() {
        return this._package;
    }

    public void setPackage(OPCPackage oPCPackage) {
        this._package = oPCPackage;
    }

    PackagePartName getPartName() {
        return this.partName;
    }

    public void setPartName(PackagePartName packagePartName) {
        this.partName = packagePartName;
    }

    ZipEntry getZipEntry() {
        return this.zipEntry;
    }

    public void setZipEntry(ZipEntry zipEntry) {
        this.zipEntry = zipEntry;
    }
}
