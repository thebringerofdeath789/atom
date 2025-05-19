package org.xml.sax.helpers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import net.lingala.zip4j.util.InternalZipConstants;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* loaded from: classes6.dex */
public final class XMLReaderFactory {
    private static final String property = "org.xml.sax.driver";

    private XMLReaderFactory() {
    }

    public static XMLReader createXMLReader() throws SAXException {
        String str;
        ClassLoader classLoader = NewInstance.getClassLoader();
        try {
            str = System.getProperty(property);
        } catch (Exception unused) {
            str = null;
        }
        if (str == null) {
            try {
                InputStream systemResourceAsStream = classLoader == null ? ClassLoader.getSystemResourceAsStream("META-INF/services/org.xml.sax.driver") : classLoader.getResourceAsStream("META-INF/services/org.xml.sax.driver");
                if (systemResourceAsStream != null) {
                    str = new BufferedReader(new InputStreamReader(systemResourceAsStream, InternalZipConstants.CHARSET_UTF8)).readLine();
                    systemResourceAsStream.close();
                }
            } catch (Exception unused2) {
            }
        }
        if (str != null) {
            return loadClass(classLoader, str);
        }
        try {
            return new ParserAdapter(ParserFactory.makeParser());
        } catch (Exception unused3) {
            throw new SAXException("Can't create default XMLReader; is system property org.xml.sax.driver set?");
        }
    }

    public static XMLReader createXMLReader(String str) throws SAXException {
        return loadClass(NewInstance.getClassLoader(), str);
    }

    private static XMLReader loadClass(ClassLoader classLoader, String str) throws SAXException {
        try {
            return (XMLReader) NewInstance.newInstance(classLoader, str);
        } catch (ClassCastException e) {
            throw new SAXException(new StringBuffer().append("SAX2 driver class ").append(str).append(" does not implement XMLReader").toString(), e);
        } catch (ClassNotFoundException e2) {
            throw new SAXException(new StringBuffer().append("SAX2 driver class ").append(str).append(" not found").toString(), e2);
        } catch (IllegalAccessException e3) {
            throw new SAXException(new StringBuffer().append("SAX2 driver class ").append(str).append(" found but cannot be loaded").toString(), e3);
        } catch (InstantiationException e4) {
            throw new SAXException(new StringBuffer().append("SAX2 driver class ").append(str).append(" loaded but cannot be instantiated (no empty public constructor?)").toString(), e4);
        }
    }
}
