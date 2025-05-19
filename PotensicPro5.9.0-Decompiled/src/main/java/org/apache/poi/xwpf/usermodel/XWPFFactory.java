package org.apache.poi.xwpf.usermodel;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLFactory;
import org.apache.poi.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* loaded from: classes5.dex */
public final class XWPFFactory extends POIXMLFactory {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) XWPFFactory.class);
    private static final XWPFFactory inst = new XWPFFactory();

    private XWPFFactory() {
    }

    public static XWPFFactory getInstance() {
        return inst;
    }

    @Override // org.apache.poi.POIXMLFactory
    public POIXMLDocumentPart createDocumentPart(POIXMLDocumentPart pOIXMLDocumentPart, PackageRelationship packageRelationship, PackagePart packagePart) {
        XWPFRelation xWPFRelation = XWPFRelation.getInstance(packageRelationship.getRelationshipType());
        if (xWPFRelation == null || xWPFRelation.getRelationClass() == null) {
            logger.log(1, "using default POIXMLDocumentPart for " + packageRelationship.getRelationshipType());
            return new POIXMLDocumentPart(packagePart, packageRelationship);
        }
        try {
            Class<? extends POIXMLDocumentPart> relationClass = xWPFRelation.getRelationClass();
            try {
                return relationClass.getDeclaredConstructor(POIXMLDocumentPart.class, PackagePart.class, PackageRelationship.class).newInstance(pOIXMLDocumentPart, packagePart, packageRelationship);
            } catch (NoSuchMethodException unused) {
                return relationClass.getDeclaredConstructor(PackagePart.class, PackageRelationship.class).newInstance(packagePart, packageRelationship);
            }
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
