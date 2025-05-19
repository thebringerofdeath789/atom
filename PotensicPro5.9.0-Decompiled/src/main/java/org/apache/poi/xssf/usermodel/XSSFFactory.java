package org.apache.poi.xssf.usermodel;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLFactory;
import org.apache.poi.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* loaded from: classes5.dex */
public final class XSSFFactory extends POIXMLFactory {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) XSSFFactory.class);
    private static final XSSFFactory inst = new XSSFFactory();

    private XSSFFactory() {
    }

    public static XSSFFactory getInstance() {
        return inst;
    }

    @Override // org.apache.poi.POIXMLFactory
    public POIXMLDocumentPart createDocumentPart(POIXMLDocumentPart pOIXMLDocumentPart, PackageRelationship packageRelationship, PackagePart packagePart) {
        XSSFRelation xSSFRelation = XSSFRelation.getInstance(packageRelationship.getRelationshipType());
        if (xSSFRelation == null || xSSFRelation.getRelationClass() == null) {
            logger.log(1, "using default POIXMLDocumentPart for " + packageRelationship.getRelationshipType());
            return new POIXMLDocumentPart(packagePart, packageRelationship);
        }
        try {
            return xSSFRelation.getRelationClass().getDeclaredConstructor(PackagePart.class, PackageRelationship.class).newInstance(packagePart, packageRelationship);
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
