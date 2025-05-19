package org.apache.xmlbeans.impl.piccolo.xml;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.apache.xmlbeans.impl.piccolo.util.FactoryServiceFinder;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

/* loaded from: classes5.dex */
public class JAXPSAXParserFactory extends SAXParserFactory {
    private static final String VALIDATING_PROPERTY = "org.apache.xmlbeans.impl.piccolo.xml.ValidatingSAXParserFactory";
    private SAXParserFactory validatingFactory;
    private static Boolean TRUE = new Boolean(true);
    private static Boolean FALSE = new Boolean(false);
    private static Class validatingFactoryClass = findValidatingFactory();
    private Map featureMap = new HashMap();
    private Piccolo nvParser = new Piccolo();
    private ParserConfigurationException pendingValidatingException = null;
    private ParserConfigurationException pendingNonvalidatingException = null;
    private boolean validating = false;
    private boolean namespaceAware = false;

    public static SAXParserFactory newInstance() {
        return new JAXPSAXParserFactory();
    }

    public JAXPSAXParserFactory() {
        try {
            Class cls = validatingFactoryClass;
            if (cls != null) {
                SAXParserFactory sAXParserFactory = (SAXParserFactory) cls.newInstance();
                this.validatingFactory = sAXParserFactory;
                sAXParserFactory.setNamespaceAware(false);
                this.validatingFactory.setValidating(true);
            }
        } catch (Exception unused) {
            this.validatingFactory = null;
        }
        setNamespaceAware(false);
    }

    @Override // javax.xml.parsers.SAXParserFactory
    public boolean getFeature(String str) throws ParserConfigurationException, SAXNotRecognizedException, SAXNotSupportedException {
        SAXParserFactory sAXParserFactory;
        if (this.validating && (sAXParserFactory = this.validatingFactory) != null) {
            return sAXParserFactory.getFeature(str);
        }
        return this.nvParser.getFeature(str);
    }

    @Override // javax.xml.parsers.SAXParserFactory
    public SAXParser newSAXParser() throws ParserConfigurationException, SAXException {
        if (this.validating) {
            SAXParserFactory sAXParserFactory = this.validatingFactory;
            if (sAXParserFactory == null) {
                throw new ParserConfigurationException("XML document validation is not supported");
            }
            ParserConfigurationException parserConfigurationException = this.pendingValidatingException;
            if (parserConfigurationException != null) {
                throw parserConfigurationException;
            }
            return sAXParserFactory.newSAXParser();
        }
        ParserConfigurationException parserConfigurationException2 = this.pendingNonvalidatingException;
        if (parserConfigurationException2 != null) {
            throw parserConfigurationException2;
        }
        return new JAXPSAXParser(new Piccolo(this.nvParser));
    }

    @Override // javax.xml.parsers.SAXParserFactory
    public void setFeature(String str, boolean z) throws ParserConfigurationException, SAXNotRecognizedException, SAXNotSupportedException {
        ParserConfigurationException parserConfigurationException;
        ParserConfigurationException parserConfigurationException2;
        this.featureMap.put(str, z ? TRUE : FALSE);
        SAXParserFactory sAXParserFactory = this.validatingFactory;
        if (sAXParserFactory != null) {
            if (this.pendingValidatingException != null) {
                reconfigureValidating();
            } else {
                try {
                    sAXParserFactory.setFeature(str, z);
                } catch (ParserConfigurationException e) {
                    this.pendingValidatingException = e;
                }
            }
        }
        if (this.pendingNonvalidatingException != null) {
            reconfigureNonvalidating();
        }
        boolean z2 = this.validating;
        if (z2 && (parserConfigurationException2 = this.pendingValidatingException) != null) {
            throw parserConfigurationException2;
        }
        if (!z2 && (parserConfigurationException = this.pendingNonvalidatingException) != null) {
            throw parserConfigurationException;
        }
    }

    @Override // javax.xml.parsers.SAXParserFactory
    public void setNamespaceAware(boolean z) {
        super.setNamespaceAware(z);
        this.namespaceAware = z;
        try {
            this.nvParser.setFeature("http://xml.org/sax/features/namespaces", z);
            this.nvParser.setFeature("http://xml.org/sax/features/namespace-prefixes", !z);
        } catch (SAXNotRecognizedException e) {
            this.pendingNonvalidatingException = new ParserConfigurationException(new StringBuffer().append("Error setting namespace feature: ").append(e.toString()).toString());
        } catch (SAXNotSupportedException e2) {
            this.pendingNonvalidatingException = new ParserConfigurationException(new StringBuffer().append("Error setting namespace feature: ").append(e2.toString()).toString());
        }
        SAXParserFactory sAXParserFactory = this.validatingFactory;
        if (sAXParserFactory != null) {
            sAXParserFactory.setNamespaceAware(z);
        }
    }

    @Override // javax.xml.parsers.SAXParserFactory
    public void setValidating(boolean z) {
        super.setValidating(z);
        this.validating = z;
    }

    private static Class findValidatingFactory() {
        String str;
        try {
            String property = System.getProperty(VALIDATING_PROPERTY);
            if (property != null) {
                return Class.forName(property);
            }
        } catch (Exception unused) {
        }
        try {
            File file = new File(new StringBuffer().append(System.getProperty("java.home")).append(File.separator).append("lib").append(File.separator).append("jaxp.properties").toString());
            if (file.exists()) {
                Properties properties = new Properties();
                properties.load(new FileInputStream(file));
                String property2 = properties.getProperty(VALIDATING_PROPERTY);
                if (property2 != null) {
                    return Class.forName(property2);
                }
            }
        } catch (Exception unused2) {
        }
        try {
            Enumeration findServices = FactoryServiceFinder.findServices("javax.xml.parsers.SAXParserFactory");
            while (findServices.hasMoreElements()) {
                try {
                    str = (String) findServices.nextElement();
                } catch (ClassNotFoundException unused3) {
                }
                if (!str.equals("org.apache.xmlbeans.impl.piccolo.xml.Piccolo")) {
                    return Class.forName(str);
                }
                continue;
            }
        } catch (Exception unused4) {
        }
        try {
            return Class.forName("org.apache.crimson.jaxp.SAXParserFactoryImpl");
        } catch (ClassNotFoundException unused5) {
            return null;
        }
    }

    private void reconfigureValidating() {
        if (this.validatingFactory == null) {
            return;
        }
        try {
            for (Map.Entry entry : this.featureMap.entrySet()) {
                this.validatingFactory.setFeature((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue());
            }
        } catch (ParserConfigurationException e) {
            this.pendingValidatingException = e;
        } catch (SAXNotRecognizedException e2) {
            this.pendingValidatingException = new ParserConfigurationException(e2.toString());
        } catch (SAXNotSupportedException e3) {
            this.pendingValidatingException = new ParserConfigurationException(e3.toString());
        }
    }

    private void reconfigureNonvalidating() {
        try {
            for (Map.Entry entry : this.featureMap.entrySet()) {
                this.nvParser.setFeature((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue());
            }
        } catch (SAXNotRecognizedException e) {
            this.pendingNonvalidatingException = new ParserConfigurationException(e.toString());
        } catch (SAXNotSupportedException e2) {
            this.pendingNonvalidatingException = new ParserConfigurationException(e2.toString());
        }
    }

    static class JAXPSAXParser extends SAXParser {
        Piccolo parser;

        @Override // javax.xml.parsers.SAXParser
        public boolean isValidating() {
            return false;
        }

        JAXPSAXParser(Piccolo piccolo) {
            this.parser = piccolo;
        }

        @Override // javax.xml.parsers.SAXParser
        public Parser getParser() {
            return this.parser;
        }

        @Override // javax.xml.parsers.SAXParser
        public Object getProperty(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
            return this.parser.getProperty(str);
        }

        @Override // javax.xml.parsers.SAXParser
        public XMLReader getXMLReader() {
            return this.parser;
        }

        @Override // javax.xml.parsers.SAXParser
        public boolean isNamespaceAware() {
            return this.parser.fNamespaces;
        }

        @Override // javax.xml.parsers.SAXParser
        public void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
            this.parser.setProperty(str, obj);
        }
    }
}
