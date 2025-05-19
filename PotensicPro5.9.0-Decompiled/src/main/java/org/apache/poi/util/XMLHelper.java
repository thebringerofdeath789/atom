package org.apache.poi.util;

import javax.xml.parsers.DocumentBuilderFactory;

/* loaded from: classes5.dex */
public final class XMLHelper {
    private static POILogger logger = POILogFactory.getLogger((Class<?>) XMLHelper.class);

    public static DocumentBuilderFactory getDocumentBuilderFactory() {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setExpandEntityReferences(false);
        trySetSAXFeature(newInstance, "http://aavax.xml.XMLConstants/feature/secure-processing", true);
        trySetSAXFeature(newInstance, "http://xml.org/sax/features/external-general-entities", false);
        trySetSAXFeature(newInstance, "http://xml.org/sax/features/external-parameter-entities", false);
        trySetSAXFeature(newInstance, "http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        trySetSAXFeature(newInstance, "http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
        return newInstance;
    }

    private static void trySetSAXFeature(DocumentBuilderFactory documentBuilderFactory, String str, boolean z) {
        try {
            documentBuilderFactory.setFeature(str, z);
        } catch (AbstractMethodError e) {
            logger.log(5, (Object) "Cannot set SAX feature because outdated XML parser in classpath", (Object) str, (Throwable) e);
        } catch (Exception e2) {
            logger.log(5, (Object) "SAX Feature unsupported", (Object) str, (Throwable) e2);
        }
    }
}
