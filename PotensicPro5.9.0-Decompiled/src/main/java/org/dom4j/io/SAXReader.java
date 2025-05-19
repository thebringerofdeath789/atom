package org.dom4j.io;

import com.opencsv.ICSVParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;
import java.net.URL;
import net.lingala.zip4j.util.InternalZipConstants;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.ElementHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/* loaded from: classes5.dex */
public class SAXReader {
    private static final String SAX_DECL_HANDLER = "http://xml.org/sax/properties/declaration-handler";
    private static final String SAX_LEXICALHANDLER = "http://xml.org/sax/handlers/LexicalHandler";
    private static final String SAX_LEXICAL_HANDLER = "http://xml.org/sax/properties/lexical-handler";
    private static final String SAX_NAMESPACES = "http://xml.org/sax/features/namespaces";
    private static final String SAX_NAMESPACE_PREFIXES = "http://xml.org/sax/features/namespace-prefixes";
    private static final String SAX_STRING_INTERNING = "http://xml.org/sax/features/string-interning";
    private DispatchHandler dispatchHandler;
    private EntityResolver entityResolver;
    private ErrorHandler errorHandler;
    private DocumentFactory factory;
    private boolean validating;
    private XMLFilter xmlFilter;
    private XMLReader xmlReader;
    private boolean stringInternEnabled = true;
    private boolean includeInternalDTDDeclarations = false;
    private boolean includeExternalDTDDeclarations = false;
    private boolean mergeAdjacentText = false;
    private boolean stripWhitespaceText = false;
    private boolean ignoreComments = false;
    private String encoding = null;

    public SAXReader() {
    }

    public SAXReader(boolean z) {
        this.validating = z;
    }

    public SAXReader(DocumentFactory documentFactory) {
        this.factory = documentFactory;
    }

    public SAXReader(DocumentFactory documentFactory, boolean z) {
        this.factory = documentFactory;
        this.validating = z;
    }

    public SAXReader(XMLReader xMLReader) {
        this.xmlReader = xMLReader;
    }

    public SAXReader(XMLReader xMLReader, boolean z) {
        this.xmlReader = xMLReader;
        this.validating = z;
    }

    public SAXReader(String str) throws SAXException {
        if (str != null) {
            this.xmlReader = XMLReaderFactory.createXMLReader(str);
        }
    }

    public SAXReader(String str, boolean z) throws SAXException {
        if (str != null) {
            this.xmlReader = XMLReaderFactory.createXMLReader(str);
        }
        this.validating = z;
    }

    public void setProperty(String str, Object obj) throws SAXException {
        getXMLReader().setProperty(str, obj);
    }

    public void setFeature(String str, boolean z) throws SAXException {
        getXMLReader().setFeature(str, z);
    }

    public Document read(File file) throws DocumentException {
        try {
            InputSource inputSource = new InputSource(new FileInputStream(file));
            String str = this.encoding;
            if (str != null) {
                inputSource.setEncoding(str);
            }
            String absolutePath = file.getAbsolutePath();
            if (absolutePath != null) {
                StringBuffer stringBuffer = new StringBuffer("file://");
                if (!absolutePath.startsWith(File.separator)) {
                    stringBuffer.append(InternalZipConstants.ZIP_FILE_SEPARATOR);
                }
                stringBuffer.append(absolutePath.replace(ICSVParser.DEFAULT_ESCAPE_CHARACTER, '/'));
                inputSource.setSystemId(stringBuffer.toString());
            }
            return read(inputSource);
        } catch (FileNotFoundException e) {
            throw new DocumentException(e.getMessage(), e);
        }
    }

    public Document read(URL url) throws DocumentException {
        InputSource inputSource = new InputSource(url.toExternalForm());
        String str = this.encoding;
        if (str != null) {
            inputSource.setEncoding(str);
        }
        return read(inputSource);
    }

    public Document read(String str) throws DocumentException {
        InputSource inputSource = new InputSource(str);
        String str2 = this.encoding;
        if (str2 != null) {
            inputSource.setEncoding(str2);
        }
        return read(inputSource);
    }

    public Document read(InputStream inputStream) throws DocumentException {
        InputSource inputSource = new InputSource(inputStream);
        String str = this.encoding;
        if (str != null) {
            inputSource.setEncoding(str);
        }
        return read(inputSource);
    }

    public Document read(Reader reader) throws DocumentException {
        InputSource inputSource = new InputSource(reader);
        String str = this.encoding;
        if (str != null) {
            inputSource.setEncoding(str);
        }
        return read(inputSource);
    }

    public Document read(InputStream inputStream, String str) throws DocumentException {
        InputSource inputSource = new InputSource(inputStream);
        inputSource.setSystemId(str);
        String str2 = this.encoding;
        if (str2 != null) {
            inputSource.setEncoding(str2);
        }
        return read(inputSource);
    }

    public Document read(Reader reader, String str) throws DocumentException {
        InputSource inputSource = new InputSource(reader);
        inputSource.setSystemId(str);
        String str2 = this.encoding;
        if (str2 != null) {
            inputSource.setEncoding(str2);
        }
        return read(inputSource);
    }

    public Document read(InputSource inputSource) throws DocumentException {
        try {
            XMLReader installXMLFilter = installXMLFilter(getXMLReader());
            EntityResolver entityResolver = this.entityResolver;
            if (entityResolver == null) {
                entityResolver = createDefaultEntityResolver(inputSource.getSystemId());
                this.entityResolver = entityResolver;
            }
            installXMLFilter.setEntityResolver(entityResolver);
            SAXContentHandler createContentHandler = createContentHandler(installXMLFilter);
            createContentHandler.setEntityResolver(entityResolver);
            createContentHandler.setInputSource(inputSource);
            boolean isIncludeInternalDTDDeclarations = isIncludeInternalDTDDeclarations();
            boolean isIncludeExternalDTDDeclarations = isIncludeExternalDTDDeclarations();
            createContentHandler.setIncludeInternalDTDDeclarations(isIncludeInternalDTDDeclarations);
            createContentHandler.setIncludeExternalDTDDeclarations(isIncludeExternalDTDDeclarations);
            createContentHandler.setMergeAdjacentText(isMergeAdjacentText());
            createContentHandler.setStripWhitespaceText(isStripWhitespaceText());
            createContentHandler.setIgnoreComments(isIgnoreComments());
            installXMLFilter.setContentHandler(createContentHandler);
            configureReader(installXMLFilter, createContentHandler);
            installXMLFilter.parse(inputSource);
            return createContentHandler.getDocument();
        } catch (Exception e) {
            if (e instanceof SAXParseException) {
                SAXParseException sAXParseException = (SAXParseException) e;
                String systemId = sAXParseException.getSystemId();
                if (systemId == null) {
                    systemId = "";
                }
                throw new DocumentException(new StringBuffer().append("Error on line ").append(sAXParseException.getLineNumber()).append(" of document ").append(systemId).append(" : ").append(sAXParseException.getMessage()).toString(), e);
            }
            throw new DocumentException(e.getMessage(), e);
        }
    }

    public boolean isValidating() {
        return this.validating;
    }

    public void setValidation(boolean z) {
        this.validating = z;
    }

    public boolean isIncludeInternalDTDDeclarations() {
        return this.includeInternalDTDDeclarations;
    }

    public void setIncludeInternalDTDDeclarations(boolean z) {
        this.includeInternalDTDDeclarations = z;
    }

    public boolean isIncludeExternalDTDDeclarations() {
        return this.includeExternalDTDDeclarations;
    }

    public void setIncludeExternalDTDDeclarations(boolean z) {
        this.includeExternalDTDDeclarations = z;
    }

    public boolean isStringInternEnabled() {
        return this.stringInternEnabled;
    }

    public void setStringInternEnabled(boolean z) {
        this.stringInternEnabled = z;
    }

    public boolean isMergeAdjacentText() {
        return this.mergeAdjacentText;
    }

    public void setMergeAdjacentText(boolean z) {
        this.mergeAdjacentText = z;
    }

    public boolean isStripWhitespaceText() {
        return this.stripWhitespaceText;
    }

    public void setStripWhitespaceText(boolean z) {
        this.stripWhitespaceText = z;
    }

    public boolean isIgnoreComments() {
        return this.ignoreComments;
    }

    public void setIgnoreComments(boolean z) {
        this.ignoreComments = z;
    }

    public DocumentFactory getDocumentFactory() {
        if (this.factory == null) {
            this.factory = DocumentFactory.getInstance();
        }
        return this.factory;
    }

    public void setDocumentFactory(DocumentFactory documentFactory) {
        this.factory = documentFactory;
    }

    public ErrorHandler getErrorHandler() {
        return this.errorHandler;
    }

    public void setErrorHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    public EntityResolver getEntityResolver() {
        return this.entityResolver;
    }

    public void setEntityResolver(EntityResolver entityResolver) {
        this.entityResolver = entityResolver;
    }

    public XMLReader getXMLReader() throws SAXException {
        if (this.xmlReader == null) {
            this.xmlReader = createXMLReader();
        }
        return this.xmlReader;
    }

    public void setXMLReader(XMLReader xMLReader) {
        this.xmlReader = xMLReader;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public void setEncoding(String str) {
        this.encoding = str;
    }

    public void setXMLReaderClassName(String str) throws SAXException {
        setXMLReader(XMLReaderFactory.createXMLReader(str));
    }

    public void addHandler(String str, ElementHandler elementHandler) {
        getDispatchHandler().addHandler(str, elementHandler);
    }

    public void removeHandler(String str) {
        getDispatchHandler().removeHandler(str);
    }

    public void setDefaultHandler(ElementHandler elementHandler) {
        getDispatchHandler().setDefaultHandler(elementHandler);
    }

    public void resetHandlers() {
        getDispatchHandler().resetHandlers();
    }

    public XMLFilter getXMLFilter() {
        return this.xmlFilter;
    }

    public void setXMLFilter(XMLFilter xMLFilter) {
        this.xmlFilter = xMLFilter;
    }

    protected XMLReader installXMLFilter(XMLReader xMLReader) {
        XMLFilter xMLFilter = getXMLFilter();
        if (xMLFilter == null) {
            return xMLReader;
        }
        XMLFilter xMLFilter2 = xMLFilter;
        while (true) {
            XMLReader parent = xMLFilter2.getParent();
            if (parent instanceof XMLFilter) {
                xMLFilter2 = (XMLFilter) parent;
            } else {
                xMLFilter2.setParent(xMLReader);
                return xMLFilter;
            }
        }
    }

    protected DispatchHandler getDispatchHandler() {
        if (this.dispatchHandler == null) {
            this.dispatchHandler = new DispatchHandler();
        }
        return this.dispatchHandler;
    }

    protected void setDispatchHandler(DispatchHandler dispatchHandler) {
        this.dispatchHandler = dispatchHandler;
    }

    protected XMLReader createXMLReader() throws SAXException {
        return SAXHelper.createXMLReader(isValidating());
    }

    protected void configureReader(XMLReader xMLReader, DefaultHandler defaultHandler) throws DocumentException {
        SAXHelper.setParserProperty(xMLReader, SAX_LEXICALHANDLER, defaultHandler);
        SAXHelper.setParserProperty(xMLReader, SAX_LEXICAL_HANDLER, defaultHandler);
        if (this.includeInternalDTDDeclarations || this.includeExternalDTDDeclarations) {
            SAXHelper.setParserProperty(xMLReader, SAX_DECL_HANDLER, defaultHandler);
        }
        SAXHelper.setParserFeature(xMLReader, SAX_NAMESPACES, true);
        SAXHelper.setParserFeature(xMLReader, SAX_NAMESPACE_PREFIXES, false);
        SAXHelper.setParserFeature(xMLReader, SAX_STRING_INTERNING, isStringInternEnabled());
        SAXHelper.setParserFeature(xMLReader, "http://xml.org/sax/features/use-locator2", true);
        try {
            xMLReader.setFeature("http://xml.org/sax/features/validation", isValidating());
            ErrorHandler errorHandler = this.errorHandler;
            if (errorHandler != null) {
                xMLReader.setErrorHandler(errorHandler);
            } else {
                xMLReader.setErrorHandler(defaultHandler);
            }
        } catch (Exception e) {
            if (isValidating()) {
                throw new DocumentException(new StringBuffer().append("Validation not supported for XMLReader: ").append(xMLReader).toString(), e);
            }
        }
    }

    protected SAXContentHandler createContentHandler(XMLReader xMLReader) {
        return new SAXContentHandler(getDocumentFactory(), this.dispatchHandler);
    }

    protected EntityResolver createDefaultEntityResolver(String str) {
        int lastIndexOf;
        return new SAXEntityResolver((str == null || str.length() <= 0 || (lastIndexOf = str.lastIndexOf(47)) <= 0) ? null : str.substring(0, lastIndexOf + 1));
    }

    protected static class SAXEntityResolver implements EntityResolver, Serializable {
        protected String uriPrefix;

        public SAXEntityResolver(String str) {
            this.uriPrefix = str;
        }

        @Override // org.xml.sax.EntityResolver
        public InputSource resolveEntity(String str, String str2) {
            if (str2 != null && str2.length() > 0 && this.uriPrefix != null && str2.indexOf(58) <= 0) {
                str2 = new StringBuffer().append(this.uriPrefix).append(str2).toString();
            }
            return new InputSource(str2);
        }
    }
}
