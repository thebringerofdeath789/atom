package org.apache.poi.openxml4j.opc.internal.marshallers;

import java.io.OutputStream;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.internal.PartMarshaller;

/* loaded from: classes5.dex */
public final class DefaultMarshaller implements PartMarshaller {
    @Override // org.apache.poi.openxml4j.opc.internal.PartMarshaller
    public boolean marshall(PackagePart packagePart, OutputStream outputStream) throws OpenXML4JException {
        return packagePart.save(outputStream);
    }
}
