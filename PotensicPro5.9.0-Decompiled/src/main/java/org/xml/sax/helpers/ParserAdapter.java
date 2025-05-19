package org.xml.sax.helpers;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Objects;
import org.xml.sax.AttributeList;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.DocumentHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

/* loaded from: classes6.dex */
public class ParserAdapter implements XMLReader, DocumentHandler {
    private static final String FEATURES = "http://xml.org/sax/features/";
    private static final String NAMESPACES = "http://xml.org/sax/features/namespaces";
    private static final String NAMESPACE_PREFIXES = "http://xml.org/sax/features/namespace-prefixes";
    private AttributeListAdapter attAdapter;
    private AttributesImpl atts;
    ContentHandler contentHandler;
    DTDHandler dtdHandler;
    EntityResolver entityResolver;
    ErrorHandler errorHandler;
    Locator locator;
    private String[] nameParts;
    private boolean namespaces;
    private NamespaceSupport nsSupport;
    private Parser parser;
    private boolean parsing;
    private boolean prefixes;

    final class AttributeListAdapter implements Attributes {
        private AttributeList qAtts;

        AttributeListAdapter() {
        }

        @Override // org.xml.sax.Attributes
        public int getIndex(String str) {
            int length = ParserAdapter.this.atts.getLength();
            for (int i = 0; i < length; i++) {
                if (this.qAtts.getName(i).equals(str)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public int getIndex(String str, String str2) {
            return -1;
        }

        @Override // org.xml.sax.Attributes, org.xml.sax.AttributeList
        public int getLength() {
            return this.qAtts.getLength();
        }

        @Override // org.xml.sax.Attributes
        public String getLocalName(int i) {
            return "";
        }

        @Override // org.xml.sax.Attributes
        public String getQName(int i) {
            return this.qAtts.getName(i).intern();
        }

        @Override // org.xml.sax.Attributes, org.xml.sax.AttributeList
        public String getType(int i) {
            return this.qAtts.getType(i).intern();
        }

        @Override // org.xml.sax.Attributes, org.xml.sax.AttributeList
        public String getType(String str) {
            return this.qAtts.getType(str).intern();
        }

        @Override // org.xml.sax.Attributes
        public String getType(String str, String str2) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getURI(int i) {
            return "";
        }

        @Override // org.xml.sax.Attributes, org.xml.sax.AttributeList
        public String getValue(int i) {
            return this.qAtts.getValue(i);
        }

        @Override // org.xml.sax.Attributes, org.xml.sax.AttributeList
        public String getValue(String str) {
            return this.qAtts.getValue(str);
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String str, String str2) {
            return null;
        }

        void setAttributeList(AttributeList attributeList) {
            this.qAtts = attributeList;
        }
    }

    public ParserAdapter() throws SAXException {
        this.parsing = false;
        this.nameParts = new String[3];
        this.parser = null;
        this.atts = null;
        this.namespaces = true;
        this.prefixes = false;
        this.entityResolver = null;
        this.dtdHandler = null;
        this.contentHandler = null;
        this.errorHandler = null;
        String property = System.getProperty("org.xml.sax.parser");
        try {
            setup(ParserFactory.makeParser());
        } catch (ClassCastException unused) {
            throw new SAXException(new StringBuffer().append("SAX1 driver class ").append(property).append(" does not implement org.xml.sax.Parser").toString());
        } catch (ClassNotFoundException e) {
            throw new SAXException(new StringBuffer().append("Cannot find SAX1 driver class ").append(property).toString(), e);
        } catch (IllegalAccessException e2) {
            throw new SAXException(new StringBuffer().append("SAX1 driver class ").append(property).append(" found but cannot be loaded").toString(), e2);
        } catch (InstantiationException e3) {
            throw new SAXException(new StringBuffer().append("SAX1 driver class ").append(property).append(" loaded but cannot be instantiated").toString(), e3);
        } catch (NullPointerException unused2) {
            throw new SAXException("System property org.xml.sax.parser not specified");
        }
    }

    public ParserAdapter(Parser parser) {
        this.parsing = false;
        this.nameParts = new String[3];
        this.parser = null;
        this.atts = null;
        this.namespaces = true;
        this.prefixes = false;
        this.entityResolver = null;
        this.dtdHandler = null;
        this.contentHandler = null;
        this.errorHandler = null;
        setup(parser);
    }

    private void checkNotParsing(String str, String str2) throws SAXNotSupportedException {
        if (this.parsing) {
            throw new SAXNotSupportedException(new StringBuffer().append("Cannot change ").append(str).append(' ').append(str2).append(" while parsing").toString());
        }
    }

    private SAXParseException makeException(String str) {
        return this.locator != null ? new SAXParseException(str, this.locator) : new SAXParseException(str, null, null, -1, -1);
    }

    private String[] processName(String str, boolean z, boolean z2) throws SAXException {
        String[] processName = this.nsSupport.processName(str, this.nameParts, z);
        if (processName != null) {
            return processName;
        }
        if (z2) {
            throw makeException(new StringBuffer().append("Undeclared prefix: ").append(str).toString());
        }
        reportError(new StringBuffer().append("Undeclared prefix: ").append(str).toString());
        return new String[]{"", "", str.intern()};
    }

    private void setup(Parser parser) {
        Objects.requireNonNull(parser, "Parser argument must not be null");
        this.parser = parser;
        this.atts = new AttributesImpl();
        this.nsSupport = new NamespaceSupport();
        this.attAdapter = new AttributeListAdapter();
    }

    private void setupParser() {
        this.nsSupport.reset();
        EntityResolver entityResolver = this.entityResolver;
        if (entityResolver != null) {
            this.parser.setEntityResolver(entityResolver);
        }
        DTDHandler dTDHandler = this.dtdHandler;
        if (dTDHandler != null) {
            this.parser.setDTDHandler(dTDHandler);
        }
        ErrorHandler errorHandler = this.errorHandler;
        if (errorHandler != null) {
            this.parser.setErrorHandler(errorHandler);
        }
        this.parser.setDocumentHandler(this);
        this.locator = null;
    }

    @Override // org.xml.sax.DocumentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        ContentHandler contentHandler = this.contentHandler;
        if (contentHandler != null) {
            contentHandler.characters(cArr, i, i2);
        }
    }

    @Override // org.xml.sax.DocumentHandler
    public void endDocument() throws SAXException {
        ContentHandler contentHandler = this.contentHandler;
        if (contentHandler != null) {
            contentHandler.endDocument();
        }
    }

    @Override // org.xml.sax.DocumentHandler
    public void endElement(String str) throws SAXException {
        if (!this.namespaces) {
            ContentHandler contentHandler = this.contentHandler;
            if (contentHandler != null) {
                contentHandler.endElement("", "", str.intern());
                return;
            }
            return;
        }
        String[] processName = processName(str, false, false);
        ContentHandler contentHandler2 = this.contentHandler;
        if (contentHandler2 != null) {
            contentHandler2.endElement(processName[0], processName[1], processName[2]);
            Enumeration declaredPrefixes = this.nsSupport.getDeclaredPrefixes();
            while (declaredPrefixes.hasMoreElements()) {
                this.contentHandler.endPrefixMapping((String) declaredPrefixes.nextElement());
            }
        }
        this.nsSupport.popContext();
    }

    @Override // org.xml.sax.XMLReader
    public ContentHandler getContentHandler() {
        return this.contentHandler;
    }

    @Override // org.xml.sax.XMLReader
    public DTDHandler getDTDHandler() {
        return this.dtdHandler;
    }

    @Override // org.xml.sax.XMLReader
    public EntityResolver getEntityResolver() {
        return this.entityResolver;
    }

    @Override // org.xml.sax.XMLReader
    public ErrorHandler getErrorHandler() {
        return this.errorHandler;
    }

    @Override // org.xml.sax.XMLReader
    public boolean getFeature(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (str.equals(NAMESPACES)) {
            return this.namespaces;
        }
        if (str.equals(NAMESPACE_PREFIXES)) {
            return this.prefixes;
        }
        throw new SAXNotRecognizedException(new StringBuffer().append("Feature: ").append(str).toString());
    }

    @Override // org.xml.sax.XMLReader
    public Object getProperty(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        throw new SAXNotRecognizedException(new StringBuffer().append("Property: ").append(str).toString());
    }

    @Override // org.xml.sax.DocumentHandler
    public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
        ContentHandler contentHandler = this.contentHandler;
        if (contentHandler != null) {
            contentHandler.ignorableWhitespace(cArr, i, i2);
        }
    }

    @Override // org.xml.sax.XMLReader
    public void parse(String str) throws IOException, SAXException {
        parse(new InputSource(str));
    }

    @Override // org.xml.sax.XMLReader
    public void parse(InputSource inputSource) throws IOException, SAXException {
        if (this.parsing) {
            throw new SAXException("Parser is already in use");
        }
        setupParser();
        this.parsing = true;
        try {
            this.parser.parse(inputSource);
            this.parsing = false;
        } finally {
            this.parsing = false;
        }
    }

    @Override // org.xml.sax.DocumentHandler
    public void processingInstruction(String str, String str2) throws SAXException {
        ContentHandler contentHandler = this.contentHandler;
        if (contentHandler != null) {
            contentHandler.processingInstruction(str, str2);
        }
    }

    void reportError(String str) throws SAXException {
        ErrorHandler errorHandler = this.errorHandler;
        if (errorHandler != null) {
            errorHandler.error(makeException(str));
        }
    }

    @Override // org.xml.sax.XMLReader
    public void setContentHandler(ContentHandler contentHandler) {
        this.contentHandler = contentHandler;
    }

    @Override // org.xml.sax.XMLReader
    public void setDTDHandler(DTDHandler dTDHandler) {
        this.dtdHandler = dTDHandler;
    }

    @Override // org.xml.sax.DocumentHandler
    public void setDocumentLocator(Locator locator) {
        this.locator = locator;
        ContentHandler contentHandler = this.contentHandler;
        if (contentHandler != null) {
            contentHandler.setDocumentLocator(locator);
        }
    }

    @Override // org.xml.sax.XMLReader
    public void setEntityResolver(EntityResolver entityResolver) {
        this.entityResolver = entityResolver;
    }

    @Override // org.xml.sax.XMLReader
    public void setErrorHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    @Override // org.xml.sax.XMLReader
    public void setFeature(String str, boolean z) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (str.equals(NAMESPACES)) {
            checkNotParsing("feature", str);
            this.namespaces = z;
            if (z || this.prefixes) {
                return;
            }
            this.prefixes = true;
            return;
        }
        if (!str.equals(NAMESPACE_PREFIXES)) {
            throw new SAXNotRecognizedException(new StringBuffer().append("Feature: ").append(str).toString());
        }
        checkNotParsing("feature", str);
        this.prefixes = z;
        if (z || this.namespaces) {
            return;
        }
        this.namespaces = true;
    }

    @Override // org.xml.sax.XMLReader
    public void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        throw new SAXNotRecognizedException(new StringBuffer().append("Property: ").append(str).toString());
    }

    @Override // org.xml.sax.DocumentHandler
    public void startDocument() throws SAXException {
        ContentHandler contentHandler = this.contentHandler;
        if (contentHandler != null) {
            contentHandler.startDocument();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:37|(3:39|(1:(1:52)(1:53))(1:43)|(3:45|(2:47|48)(1:50)|49))|54|55|57|49|35) */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00cd, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ce, code lost:
    
        if (r12 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d0, code lost:
    
        r12 = new java.util.Vector();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d5, code lost:
    
        r12.addElement(r0);
        r24.atts.addAttribute("", r15, r15, r22, r23);
     */
    @Override // org.xml.sax.DocumentHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void startElement(java.lang.String r25, org.xml.sax.AttributeList r26) throws org.xml.sax.SAXException {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xml.sax.helpers.ParserAdapter.startElement(java.lang.String, org.xml.sax.AttributeList):void");
    }
}
