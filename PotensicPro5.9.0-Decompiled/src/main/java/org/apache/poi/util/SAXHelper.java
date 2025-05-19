package org.apache.poi.util;

import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* loaded from: classes5.dex */
public final class SAXHelper {
    private static final SAXParserFactory saxFactory;
    private static POILogger logger = POILogFactory.getLogger((Class<?>) SAXHelper.class);
    static final EntityResolver IGNORING_ENTITY_RESOLVER = new EntityResolver() { // from class: org.apache.poi.util.SAXHelper.1
        @Override // org.xml.sax.EntityResolver
        public InputSource resolveEntity(String str, String str2) throws SAXException, IOException {
            return new InputSource(new StringReader(""));
        }
    };

    static {
        SAXParserFactory newInstance = SAXParserFactory.newInstance();
        saxFactory = newInstance;
        newInstance.setValidating(false);
        newInstance.setNamespaceAware(true);
    }

    private SAXHelper() {
    }

    public static synchronized XMLReader newXMLReader() throws SAXException, ParserConfigurationException {
        XMLReader xMLReader;
        synchronized (SAXHelper.class) {
            xMLReader = saxFactory.newSAXParser().getXMLReader();
            xMLReader.setEntityResolver(IGNORING_ENTITY_RESOLVER);
            trySetSAXFeature(xMLReader, "http://aavax.xml.XMLConstants/feature/secure-processing", true);
            trySetXercesSecurityManager(xMLReader);
        }
        return xMLReader;
    }

    private static void trySetSAXFeature(XMLReader xMLReader, String str, boolean z) {
        try {
            xMLReader.setFeature(str, z);
        } catch (AbstractMethodError e) {
            logger.log(5, (Object) "Cannot set SAX feature because outdated XML parser in classpath", (Object) str, (Throwable) e);
        } catch (Exception e2) {
            logger.log(5, (Object) "SAX Feature unsupported", (Object) str, (Throwable) e2);
        }
    }

    private static void trySetXercesSecurityManager(XMLReader xMLReader) {
        String[] strArr = {"com.sun.org.apache.xerces.internal.util.SecurityManager", "org.apache.xerces.util.SecurityManager"};
        for (int i = 0; i < 2; i++) {
            try {
                Object newInstance = Class.forName(strArr[i]).newInstance();
                newInstance.getClass().getMethod("setEntityExpansionLimit", Integer.TYPE).invoke(newInstance, 4096);
                xMLReader.setProperty("http://apache.org/xml/properties/security-manager", newInstance);
                return;
            } catch (Exception e) {
                logger.log(5, (Object) "SAX Security Manager could not be setup", (Throwable) e);
            }
        }
    }
}
