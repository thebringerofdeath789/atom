package org.jdom.input;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.jdom.DefaultJDOMFactory;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.JDOMFactory;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/* loaded from: classes5.dex */
public class SAXBuilder {
    private static final String CVS_ID = "@(#) $RCSfile: SAXBuilder.java,v $ $Revision: 1.89 $ $Date: 2004/09/03 18:24:28 $ $Name: jdom_1_0 $";
    private static final String DEFAULT_SAX_DRIVER = "org.apache.xerces.parsers.SAXParser";
    static /* synthetic */ Class class$java$util$Map;
    private boolean expand;
    private JDOMFactory factory;
    private HashMap features;
    private boolean ignoringWhite;
    private HashMap properties;
    private boolean reuseParser;
    private DTDHandler saxDTDHandler;
    private String saxDriverClass;
    private EntityResolver saxEntityResolver;
    private ErrorHandler saxErrorHandler;
    private XMLReader saxParser;
    private XMLFilter saxXMLFilter;
    private boolean validate;

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public SAXBuilder() {
        this(false);
    }

    public SAXBuilder(boolean z) {
        this.expand = true;
        this.saxErrorHandler = null;
        this.saxEntityResolver = null;
        this.saxDTDHandler = null;
        this.saxXMLFilter = null;
        this.factory = new DefaultJDOMFactory();
        this.ignoringWhite = false;
        this.features = new HashMap(5);
        this.properties = new HashMap(5);
        this.reuseParser = true;
        this.saxParser = null;
        this.validate = z;
    }

    public SAXBuilder(String str) {
        this(str, false);
    }

    public SAXBuilder(String str, boolean z) {
        this.expand = true;
        this.saxErrorHandler = null;
        this.saxEntityResolver = null;
        this.saxDTDHandler = null;
        this.saxXMLFilter = null;
        this.factory = new DefaultJDOMFactory();
        this.ignoringWhite = false;
        this.features = new HashMap(5);
        this.properties = new HashMap(5);
        this.reuseParser = true;
        this.saxParser = null;
        this.saxDriverClass = str;
        this.validate = z;
    }

    public String getDriverClass() {
        return this.saxDriverClass;
    }

    public JDOMFactory getFactory() {
        return this.factory;
    }

    public void setFactory(JDOMFactory jDOMFactory) {
        this.factory = jDOMFactory;
    }

    public boolean getValidation() {
        return this.validate;
    }

    public void setValidation(boolean z) {
        this.validate = z;
    }

    public ErrorHandler getErrorHandler() {
        return this.saxErrorHandler;
    }

    public void setErrorHandler(ErrorHandler errorHandler) {
        this.saxErrorHandler = errorHandler;
    }

    public EntityResolver getEntityResolver() {
        return this.saxEntityResolver;
    }

    public void setEntityResolver(EntityResolver entityResolver) {
        this.saxEntityResolver = entityResolver;
    }

    public DTDHandler getDTDHandler() {
        return this.saxDTDHandler;
    }

    public void setDTDHandler(DTDHandler dTDHandler) {
        this.saxDTDHandler = dTDHandler;
    }

    public XMLFilter getXMLFilter() {
        return this.saxXMLFilter;
    }

    public void setXMLFilter(XMLFilter xMLFilter) {
        this.saxXMLFilter = xMLFilter;
    }

    public boolean getIgnoringElementContentWhitespace() {
        return this.ignoringWhite;
    }

    public void setIgnoringElementContentWhitespace(boolean z) {
        this.ignoringWhite = z;
    }

    public boolean getReuseParser() {
        return this.reuseParser;
    }

    public void setReuseParser(boolean z) {
        this.reuseParser = z;
        this.saxParser = null;
    }

    public void setFeature(String str, boolean z) {
        this.features.put(str, new Boolean(z));
    }

    public void setProperty(String str, Object obj) {
        this.properties.put(str, obj);
    }

    public Document build(InputSource inputSource) throws JDOMException, IOException {
        SAXHandler sAXHandler;
        SAXHandler sAXHandler2 = null;
        Document document = null;
        try {
            sAXHandler = createContentHandler();
            try {
                configureContentHandler(sAXHandler);
                XMLReader xMLReader = this.saxParser;
                if (xMLReader == null) {
                    xMLReader = createParser();
                    XMLFilter xMLFilter = this.saxXMLFilter;
                    if (xMLFilter != null) {
                        while (xMLFilter.getParent() instanceof XMLFilter) {
                            xMLFilter = (XMLFilter) xMLFilter.getParent();
                        }
                        xMLFilter.setParent(xMLReader);
                        xMLReader = this.saxXMLFilter;
                    }
                    configureParser(xMLReader, sAXHandler);
                    if (this.reuseParser) {
                        this.saxParser = xMLReader;
                    }
                } else {
                    configureParser(xMLReader, sAXHandler);
                }
                xMLReader.parse(inputSource);
                return sAXHandler.getDocument();
            } catch (SAXParseException e) {
                e = e;
                Document document2 = sAXHandler.getDocument();
                if (document2.hasRootElement()) {
                    document = document2;
                }
                String systemId = e.getSystemId();
                if (systemId != null) {
                    throw new JDOMParseException(new StringBuffer("Error on line ").append(e.getLineNumber()).append(" of document ").append(systemId).toString(), e, document);
                }
                throw new JDOMParseException(new StringBuffer("Error on line ").append(e.getLineNumber()).toString(), e, document);
            } catch (SAXException e2) {
                e = e2;
                sAXHandler2 = sAXHandler;
                throw new JDOMParseException(new StringBuffer("Error in building: ").append(e.getMessage()).toString(), e, sAXHandler2.getDocument());
            }
        } catch (SAXParseException e3) {
            e = e3;
            sAXHandler = null;
        } catch (SAXException e4) {
            e = e4;
        }
    }

    protected SAXHandler createContentHandler() {
        return new SAXHandler(this.factory);
    }

    protected void configureContentHandler(SAXHandler sAXHandler) {
        sAXHandler.setExpandEntities(this.expand);
        sAXHandler.setIgnoringElementContentWhitespace(this.ignoringWhite);
    }

    protected XMLReader createParser() throws JDOMException {
        XMLReader createXMLReader;
        String str = this.saxDriverClass;
        if (str != null) {
            try {
                createXMLReader = XMLReaderFactory.createXMLReader(str);
                setFeaturesAndProperties(createXMLReader, true);
            } catch (SAXException e) {
                throw new JDOMException(new StringBuffer("Could not load ").append(this.saxDriverClass).toString(), e);
            }
        } else {
            createXMLReader = null;
            try {
                try {
                    Class<?> cls = Class.forName("org.jdom.input.JAXPParserFactory");
                    Class<?>[] clsArr = new Class[3];
                    clsArr[0] = Boolean.TYPE;
                    Class<?> cls2 = class$java$util$Map;
                    if (cls2 == null) {
                        cls2 = class$("java.util.Map");
                        class$java$util$Map = cls2;
                    }
                    clsArr[1] = cls2;
                    Class<?> cls3 = class$java$util$Map;
                    if (cls3 == null) {
                        cls3 = class$("java.util.Map");
                        class$java$util$Map = cls3;
                    }
                    clsArr[2] = cls3;
                    XMLReader xMLReader = (XMLReader) cls.getMethod("createParser", clsArr).invoke(null, new Boolean(this.validate), this.features, this.properties);
                    try {
                        setFeaturesAndProperties(xMLReader, false);
                    } catch (Exception | NoClassDefFoundError unused) {
                    }
                    createXMLReader = xMLReader;
                } catch (Exception | NoClassDefFoundError unused2) {
                }
            } catch (JDOMException e2) {
                throw e2;
            }
        }
        if (createXMLReader != null) {
            return createXMLReader;
        }
        try {
            XMLReader createXMLReader2 = XMLReaderFactory.createXMLReader(DEFAULT_SAX_DRIVER);
            this.saxDriverClass = createXMLReader2.getClass().getName();
            setFeaturesAndProperties(createXMLReader2, true);
            return createXMLReader2;
        } catch (SAXException e3) {
            throw new JDOMException("Could not load default SAX parser: org.apache.xerces.parsers.SAXParser", e3);
        }
    }

    protected void configureParser(XMLReader xMLReader, SAXHandler sAXHandler) throws JDOMException {
        xMLReader.setContentHandler(sAXHandler);
        EntityResolver entityResolver = this.saxEntityResolver;
        if (entityResolver != null) {
            xMLReader.setEntityResolver(entityResolver);
        }
        DTDHandler dTDHandler = this.saxDTDHandler;
        if (dTDHandler != null) {
            xMLReader.setDTDHandler(dTDHandler);
        } else {
            xMLReader.setDTDHandler(sAXHandler);
        }
        ErrorHandler errorHandler = this.saxErrorHandler;
        if (errorHandler != null) {
            xMLReader.setErrorHandler(errorHandler);
        } else {
            xMLReader.setErrorHandler(new BuilderErrorHandler());
        }
        boolean z = false;
        try {
            xMLReader.setProperty("http://xml.org/sax/handlers/LexicalHandler", sAXHandler);
            z = true;
        } catch (SAXNotRecognizedException | SAXNotSupportedException unused) {
        }
        if (!z) {
            try {
                xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", sAXHandler);
            } catch (SAXNotRecognizedException | SAXNotSupportedException unused2) {
            }
        }
        if (this.expand) {
            return;
        }
        try {
            xMLReader.setProperty("http://xml.org/sax/properties/declaration-handler", sAXHandler);
        } catch (SAXNotRecognizedException | SAXNotSupportedException unused3) {
        }
    }

    private void setFeaturesAndProperties(XMLReader xMLReader, boolean z) throws JDOMException {
        for (String str : this.features.keySet()) {
            internalSetFeature(xMLReader, str, ((Boolean) this.features.get(str)).booleanValue(), str);
        }
        for (String str2 : this.properties.keySet()) {
            internalSetProperty(xMLReader, str2, this.properties.get(str2), str2);
        }
        if (z) {
            try {
                internalSetFeature(xMLReader, "http://xml.org/sax/features/validation", this.validate, "Validation");
            } catch (JDOMException e) {
                if (this.validate) {
                    throw e;
                }
            }
            internalSetFeature(xMLReader, "http://xml.org/sax/features/namespaces", true, "Namespaces");
            internalSetFeature(xMLReader, "http://xml.org/sax/features/namespace-prefixes", true, "Namespace prefixes");
        }
        try {
            boolean feature = xMLReader.getFeature("http://xml.org/sax/features/external-general-entities");
            boolean z2 = this.expand;
            if (feature != z2) {
                xMLReader.setFeature("http://xml.org/sax/features/external-general-entities", z2);
            }
        } catch (SAXNotRecognizedException | SAXNotSupportedException unused) {
        }
    }

    private void internalSetFeature(XMLReader xMLReader, String str, boolean z, String str2) throws JDOMException {
        try {
            xMLReader.setFeature(str, z);
        } catch (SAXNotRecognizedException unused) {
            throw new JDOMException(new StringBuffer(String.valueOf(str2)).append(" feature not recognized for SAX driver ").append(xMLReader.getClass().getName()).toString());
        } catch (SAXNotSupportedException unused2) {
            throw new JDOMException(new StringBuffer(String.valueOf(str2)).append(" feature not supported for SAX driver ").append(xMLReader.getClass().getName()).toString());
        }
    }

    private void internalSetProperty(XMLReader xMLReader, String str, Object obj, String str2) throws JDOMException {
        try {
            xMLReader.setProperty(str, obj);
        } catch (SAXNotRecognizedException unused) {
            throw new JDOMException(new StringBuffer(String.valueOf(str2)).append(" property not recognized for SAX driver ").append(xMLReader.getClass().getName()).toString());
        } catch (SAXNotSupportedException unused2) {
            throw new JDOMException(new StringBuffer(String.valueOf(str2)).append(" property not supported for SAX driver ").append(xMLReader.getClass().getName()).toString());
        }
    }

    public Document build(InputStream inputStream) throws JDOMException, IOException {
        return build(new InputSource(inputStream));
    }

    public Document build(File file) throws JDOMException, IOException {
        try {
            return build(fileToURL(file));
        } catch (MalformedURLException e) {
            throw new JDOMException("Error in building", e);
        }
    }

    public Document build(URL url) throws JDOMException, IOException {
        return build(new InputSource(url.toExternalForm()));
    }

    public Document build(InputStream inputStream, String str) throws JDOMException, IOException {
        InputSource inputSource = new InputSource(inputStream);
        inputSource.setSystemId(str);
        return build(inputSource);
    }

    public Document build(Reader reader) throws JDOMException, IOException {
        return build(new InputSource(reader));
    }

    public Document build(Reader reader, String str) throws JDOMException, IOException {
        InputSource inputSource = new InputSource(reader);
        inputSource.setSystemId(str);
        return build(inputSource);
    }

    public Document build(String str) throws JDOMException, IOException {
        return build(new InputSource(str));
    }

    private static URL fileToURL(File file) throws MalformedURLException {
        StringBuffer stringBuffer = new StringBuffer();
        String absolutePath = file.getAbsolutePath();
        if (File.separatorChar != '/') {
            absolutePath = absolutePath.replace(File.separatorChar, '/');
        }
        if (!absolutePath.startsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            stringBuffer.append('/');
        }
        int length = absolutePath.length();
        for (int i = 0; i < length; i++) {
            char charAt = absolutePath.charAt(i);
            if (charAt == ' ') {
                stringBuffer.append("%20");
            } else if (charAt == '#') {
                stringBuffer.append("%23");
            } else if (charAt == '%') {
                stringBuffer.append("%25");
            } else if (charAt == '&') {
                stringBuffer.append("%26");
            } else if (charAt == ';') {
                stringBuffer.append("%3B");
            } else if (charAt == '<') {
                stringBuffer.append("%3C");
            } else if (charAt == '=') {
                stringBuffer.append("%3D");
            } else if (charAt == '>') {
                stringBuffer.append("%3E");
            } else if (charAt == '?') {
                stringBuffer.append("%3F");
            } else if (charAt == '~') {
                stringBuffer.append("%7E");
            } else {
                stringBuffer.append(charAt);
            }
        }
        if (!absolutePath.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR) && file.isDirectory()) {
            stringBuffer.append('/');
        }
        return new URL(StringLookupFactory.KEY_FILE, "", stringBuffer.toString());
    }

    public boolean getExpandEntities() {
        return this.expand;
    }

    public void setExpandEntities(boolean z) {
        this.expand = z;
    }
}
