package org.apache.poi;

import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;

/* loaded from: classes.dex */
public abstract class POIXMLFactory {
    public abstract POIXMLDocumentPart createDocumentPart(POIXMLDocumentPart pOIXMLDocumentPart, PackageRelationship packageRelationship, PackagePart packagePart);

    public abstract POIXMLDocumentPart newDocumentPart(POIXMLRelation pOIXMLRelation);
}
