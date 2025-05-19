package org.apache.poi.openxml4j.opc.internal;

import java.io.OutputStream;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.PackagePart;

/* loaded from: classes5.dex */
public interface PartMarshaller {
    boolean marshall(PackagePart packagePart, OutputStream outputStream) throws OpenXML4JException;
}
