package org.apache.poi.openxml4j.opc.internal.signature;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.internal.ContentType;

/* loaded from: classes5.dex */
public final class DigitalCertificatePart extends PackagePart {
    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public void close() {
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public void flush() {
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    protected InputStream getInputStreamImpl() throws IOException {
        return null;
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    protected OutputStream getOutputStreamImpl() {
        return null;
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public boolean load(InputStream inputStream) throws InvalidFormatException {
        return false;
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public boolean save(OutputStream outputStream) throws OpenXML4JException {
        return false;
    }

    public DigitalCertificatePart() throws InvalidFormatException {
        super((OPCPackage) null, (PackagePartName) null, new ContentType(""));
    }
}
