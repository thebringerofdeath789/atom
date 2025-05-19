package org.jdom.input;

import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.jdom.JDOMException;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

/* loaded from: classes5.dex */
class JAXPParserFactory {
    private static final String CVS_ID = "@(#) $RCSfile: JAXPParserFactory.java,v $ $Revision: 1.5 $ $Date: 2004/02/27 21:08:47 $ $Name: jdom_1_0 $";
    private static final String JAXP_SCHEMA_LANGUAGE_PROPERTY = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    private static final String JAXP_SCHEMA_LOCATION_PROPERTY = "http://java.sun.com/xml/jaxp/properties/schemaSource";

    private JAXPParserFactory() {
    }

    public static XMLReader createParser(boolean z, Map map, Map map2) throws JDOMException {
        try {
            SAXParserFactory newInstance = SAXParserFactory.newInstance();
            newInstance.setValidating(z);
            newInstance.setNamespaceAware(true);
            try {
                SAXParser newSAXParser = newInstance.newSAXParser();
                setProperty(newSAXParser, map2, JAXP_SCHEMA_LANGUAGE_PROPERTY);
                setProperty(newSAXParser, map2, JAXP_SCHEMA_LOCATION_PROPERTY);
                return newSAXParser.getXMLReader();
            } catch (ParserConfigurationException e) {
                throw new JDOMException("Could not allocate JAXP SAX Parser", e);
            }
        } catch (SAXException e2) {
            throw new JDOMException("Could not allocate JAXP SAX Parser", e2);
        }
    }

    private static void setProperty(SAXParser sAXParser, Map map, String str) throws JDOMException {
        try {
            if (map.containsKey(str)) {
                sAXParser.setProperty(str, map.get(str));
            }
        } catch (SAXNotRecognizedException unused) {
            throw new JDOMException(new StringBuffer(String.valueOf(str)).append(" property not recognized for JAXP parser ").append(sAXParser.getClass().getName()).toString());
        } catch (SAXNotSupportedException unused2) {
            throw new JDOMException(new StringBuffer(String.valueOf(str)).append(" property not supported for JAXP parser ").append(sAXParser.getClass().getName()).toString());
        }
    }
}
