package org.apache.poi.xslf.usermodel;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLFactory;
import org.apache.poi.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* loaded from: classes5.dex */
public final class XSLFFactory extends POIXMLFactory {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) XSLFFactory.class);
    private static final XSLFFactory inst = new XSLFFactory();

    private XSLFFactory() {
    }

    public static XSLFFactory getInstance() {
        return inst;
    }

    @Override // org.apache.poi.POIXMLFactory
    public POIXMLDocumentPart createDocumentPart(POIXMLDocumentPart pOIXMLDocumentPart, PackageRelationship packageRelationship, PackagePart packagePart) {
        XSLFRelation xSLFRelation = XSLFRelation.getInstance(packageRelationship.getRelationshipType());
        if (xSLFRelation == null || xSLFRelation.getRelationClass() == null) {
            logger.log(1, "using default POIXMLDocumentPart for " + packageRelationship.getRelationshipType());
            return new POIXMLDocumentPart(packagePart, packageRelationship);
        }
        try {
            return xSLFRelation.getRelationClass().getDeclaredConstructor(PackagePart.class, PackageRelationship.class).newInstance(packagePart, packageRelationship);
        } catch (Exception e) {
            throw new POIXMLException(e);
        }
    }

    @Override // org.apache.poi.POIXMLFactory
    public POIXMLDocumentPart newDocumentPart(POIXMLRelation pOIXMLRelation) {
        try {
            return pOIXMLRelation.getRelationClass().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            throw new POIXMLException(e);
        }
    }
}
