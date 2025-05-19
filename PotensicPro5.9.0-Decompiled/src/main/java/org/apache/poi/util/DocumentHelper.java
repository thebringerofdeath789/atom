package org.apache.poi.util;

import aavax.xml.stream.events.Namespace;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public final class DocumentHelper {
    private static final DocumentBuilderFactory documentBuilderFactory;
    private static final DocumentBuilder documentBuilderSingleton;
    private static POILogger logger = POILogFactory.getLogger((Class<?>) DocumentHelper.class);

    static {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        documentBuilderFactory = newInstance;
        newInstance.setNamespaceAware(true);
        newInstance.setValidating(false);
        trySetSAXFeature(newInstance, "http://aavax.xml.XMLConstants/feature/secure-processing", true);
        trySetXercesSecurityManager(newInstance);
        documentBuilderSingleton = newDocumentBuilder();
    }

    private DocumentHelper() {
    }

    public static synchronized DocumentBuilder newDocumentBuilder() {
        DocumentBuilder newDocumentBuilder;
        synchronized (DocumentHelper.class) {
            try {
                newDocumentBuilder = documentBuilderFactory.newDocumentBuilder();
                newDocumentBuilder.setEntityResolver(SAXHelper.IGNORING_ENTITY_RESOLVER);
            } catch (ParserConfigurationException e) {
                throw new IllegalStateException("cannot create a DocumentBuilder", e);
            }
        }
        return newDocumentBuilder;
    }

    private static void trySetSAXFeature(DocumentBuilderFactory documentBuilderFactory2, String str, boolean z) {
        try {
            documentBuilderFactory2.setFeature(str, z);
        } catch (AbstractMethodError e) {
            logger.log(5, (Object) "Cannot set SAX feature because outdated XML parser in classpath", (Object) str, (Throwable) e);
        } catch (Exception e2) {
            logger.log(5, (Object) "SAX Feature unsupported", (Object) str, (Throwable) e2);
        }
    }

    private static void trySetXercesSecurityManager(DocumentBuilderFactory documentBuilderFactory2) {
        String[] strArr = {"com.sun.org.apache.xerces.internal.util.SecurityManager", "org.apache.xerces.util.SecurityManager"};
        for (int i = 0; i < 2; i++) {
            try {
                Object newInstance = Class.forName(strArr[i]).newInstance();
                newInstance.getClass().getMethod("setEntityExpansionLimit", Integer.TYPE).invoke(newInstance, 4096);
                documentBuilderFactory2.setAttribute("http://apache.org/xml/properties/security-manager", newInstance);
                return;
            } catch (Throwable th) {
                logger.log(5, (Object) "SAX Security Manager could not be setup", th);
            }
        }
    }

    public static Document readDocument(InputStream inputStream) throws IOException, SAXException {
        return newDocumentBuilder().parse(inputStream);
    }

    public static synchronized Document createDocument() {
        Document newDocument;
        synchronized (DocumentHelper.class) {
            newDocument = documentBuilderSingleton.newDocument();
        }
        return newDocument;
    }

    public static void addNamespaceDeclaration(Element element, String str, String str2) {
        element.setAttributeNS("http://www.w3.org/2000/xmlns/", Sax2Dom.XMLNS_STRING + str, str2);
    }

    public static void addNamespaceDeclaration(Element element, Namespace namespace) {
        addNamespaceDeclaration(element, namespace.getPrefix(), namespace.getNamespaceURI());
    }
}
