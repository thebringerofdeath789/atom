package org.jdom.output;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.jdom.Attribute;
import org.jdom.CDATA;
import org.jdom.Comment;
import org.jdom.Content;
import org.jdom.DocType;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.EntityRef;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.ProcessingInstruction;
import org.jdom.Text;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DeclHandler;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/* loaded from: classes5.dex */
public class SAXOutputter {
    private static final String CVS_ID = "@(#) $RCSfile: SAXOutputter.java,v $ $Revision: 1.37 $ $Date: 2004/09/03 06:11:00 $ $Name: jdom_1_0 $";
    private static final String DECL_HANDLER_ALT_PROPERTY = "http://xml.org/sax/handlers/DeclHandler";
    private static final String DECL_HANDLER_SAX_PROPERTY = "http://xml.org/sax/properties/declaration-handler";
    private static final String LEXICAL_HANDLER_ALT_PROPERTY = "http://xml.org/sax/handlers/LexicalHandler";
    private static final String LEXICAL_HANDLER_SAX_PROPERTY = "http://xml.org/sax/properties/lexical-handler";
    private static final String NAMESPACES_SAX_FEATURE = "http://xml.org/sax/features/namespaces";
    private static final String NS_PREFIXES_SAX_FEATURE = "http://xml.org/sax/features/namespace-prefixes";
    private static final String VALIDATION_SAX_FEATURE = "http://xml.org/sax/features/validation";
    private static final String[] attrTypeToNameMap = {"CDATA", "CDATA", "ID", "IDREF", "IDREFS", "ENTITY", "ENTITIES", XmlErrorCodes.NMTOKEN, "NMTOKENS", "NOTATION", XmlErrorCodes.NMTOKEN};
    private ContentHandler contentHandler;
    private DeclHandler declHandler;
    private boolean declareNamespaces;
    private DTDHandler dtdHandler;
    private EntityResolver entityResolver;
    private ErrorHandler errorHandler;
    private LexicalHandler lexicalHandler;
    private JDOMLocator locator;
    private boolean reportDtdEvents;

    public SAXOutputter() {
        this.declareNamespaces = false;
        this.reportDtdEvents = true;
        this.locator = null;
    }

    public SAXOutputter(ContentHandler contentHandler) {
        this(contentHandler, null, null, null, null);
    }

    public SAXOutputter(ContentHandler contentHandler, ErrorHandler errorHandler, DTDHandler dTDHandler, EntityResolver entityResolver) {
        this(contentHandler, errorHandler, dTDHandler, entityResolver, null);
    }

    public SAXOutputter(ContentHandler contentHandler, ErrorHandler errorHandler, DTDHandler dTDHandler, EntityResolver entityResolver, LexicalHandler lexicalHandler) {
        this.declareNamespaces = false;
        this.reportDtdEvents = true;
        this.locator = null;
        this.contentHandler = contentHandler;
        this.errorHandler = errorHandler;
        this.dtdHandler = dTDHandler;
        this.entityResolver = entityResolver;
        this.lexicalHandler = lexicalHandler;
    }

    public void setContentHandler(ContentHandler contentHandler) {
        this.contentHandler = contentHandler;
    }

    public ContentHandler getContentHandler() {
        return this.contentHandler;
    }

    public void setErrorHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    public ErrorHandler getErrorHandler() {
        return this.errorHandler;
    }

    public void setDTDHandler(DTDHandler dTDHandler) {
        this.dtdHandler = dTDHandler;
    }

    public DTDHandler getDTDHandler() {
        return this.dtdHandler;
    }

    public void setEntityResolver(EntityResolver entityResolver) {
        this.entityResolver = entityResolver;
    }

    public EntityResolver getEntityResolver() {
        return this.entityResolver;
    }

    public void setLexicalHandler(LexicalHandler lexicalHandler) {
        this.lexicalHandler = lexicalHandler;
    }

    public LexicalHandler getLexicalHandler() {
        return this.lexicalHandler;
    }

    public void setDeclHandler(DeclHandler declHandler) {
        this.declHandler = declHandler;
    }

    public DeclHandler getDeclHandler() {
        return this.declHandler;
    }

    public boolean getReportNamespaceDeclarations() {
        return this.declareNamespaces;
    }

    public void setReportNamespaceDeclarations(boolean z) {
        this.declareNamespaces = z;
    }

    public boolean getReportDTDEvents() {
        return this.reportDtdEvents;
    }

    public void setReportDTDEvents(boolean z) {
        this.reportDtdEvents = z;
    }

    public void setFeature(String str, boolean z) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (NS_PREFIXES_SAX_FEATURE.equals(str)) {
            setReportNamespaceDeclarations(z);
            return;
        }
        if (NAMESPACES_SAX_FEATURE.equals(str)) {
            if (!z) {
                throw new SAXNotSupportedException(str);
            }
        } else {
            if (VALIDATION_SAX_FEATURE.equals(str)) {
                setReportDTDEvents(z);
                return;
            }
            throw new SAXNotRecognizedException(str);
        }
    }

    public boolean getFeature(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (NS_PREFIXES_SAX_FEATURE.equals(str)) {
            return this.declareNamespaces;
        }
        if (NAMESPACES_SAX_FEATURE.equals(str)) {
            return true;
        }
        if (VALIDATION_SAX_FEATURE.equals(str)) {
            return this.reportDtdEvents;
        }
        throw new SAXNotRecognizedException(str);
    }

    public void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (LEXICAL_HANDLER_SAX_PROPERTY.equals(str) || LEXICAL_HANDLER_ALT_PROPERTY.equals(str)) {
            setLexicalHandler((LexicalHandler) obj);
        } else {
            if (DECL_HANDLER_SAX_PROPERTY.equals(str) || DECL_HANDLER_ALT_PROPERTY.equals(str)) {
                setDeclHandler((DeclHandler) obj);
                return;
            }
            throw new SAXNotRecognizedException(str);
        }
    }

    public Object getProperty(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (LEXICAL_HANDLER_SAX_PROPERTY.equals(str) || LEXICAL_HANDLER_ALT_PROPERTY.equals(str)) {
            return getLexicalHandler();
        }
        if (DECL_HANDLER_SAX_PROPERTY.equals(str) || DECL_HANDLER_ALT_PROPERTY.equals(str)) {
            return getDeclHandler();
        }
        throw new SAXNotRecognizedException(str);
    }

    public void output(Document document) throws JDOMException {
        if (document == null) {
            return;
        }
        documentLocator(document);
        startDocument();
        if (this.reportDtdEvents) {
            dtdEvents(document);
        }
        for (Object obj : document.getContent()) {
            this.locator.setNode(obj);
            if (obj instanceof Element) {
                element(document.getRootElement(), new NamespaceStack());
            } else if (obj instanceof ProcessingInstruction) {
                processingInstruction((ProcessingInstruction) obj);
            } else if (obj instanceof Comment) {
                comment(((Comment) obj).getText());
            }
        }
        endDocument();
    }

    public void output(List list) throws JDOMException {
        if (list == null || list.size() == 0) {
            return;
        }
        documentLocator(null);
        startDocument();
        elementContent(list, new NamespaceStack());
        endDocument();
    }

    public void output(Element element) throws JDOMException {
        if (element == null) {
            return;
        }
        documentLocator(null);
        startDocument();
        elementContent(element, new NamespaceStack());
        endDocument();
    }

    public void outputFragment(List list) throws JDOMException {
        if (list == null || list.size() == 0) {
            return;
        }
        elementContent(list, new NamespaceStack());
    }

    public void outputFragment(Content content) throws JDOMException {
        if (content == null) {
            return;
        }
        elementContent(content, new NamespaceStack());
    }

    private void dtdEvents(Document document) throws JDOMException {
        DocType docType = document.getDocType();
        if (docType != null) {
            if (this.dtdHandler == null && this.declHandler == null) {
                return;
            }
            try {
                createDTDParser().parse(new InputSource(new StringReader(new XMLOutputter().outputString(docType))));
            } catch (IOException e) {
                throw new JDOMException("DTD parsing error", e);
            } catch (SAXParseException unused) {
            } catch (SAXException e2) {
                throw new JDOMException("DTD parsing error", e2);
            }
        }
    }

    private void documentLocator(Document document) {
        String str;
        DocType docType;
        this.locator = new JDOMLocator();
        String str2 = null;
        if (document == null || (docType = document.getDocType()) == null) {
            str = null;
        } else {
            str2 = docType.getPublicID();
            str = docType.getSystemID();
        }
        this.locator.setPublicId(str2);
        this.locator.setSystemId(str);
        this.locator.setLineNumber(-1);
        this.locator.setColumnNumber(-1);
        this.contentHandler.setDocumentLocator(this.locator);
    }

    private void startDocument() throws JDOMException {
        try {
            this.contentHandler.startDocument();
        } catch (SAXException e) {
            throw new JDOMException("Exception in startDocument", e);
        }
    }

    private void endDocument() throws JDOMException {
        try {
            this.contentHandler.endDocument();
            this.locator = null;
        } catch (SAXException e) {
            throw new JDOMException("Exception in endDocument", e);
        }
    }

    private void processingInstruction(ProcessingInstruction processingInstruction) throws JDOMException {
        if (processingInstruction != null) {
            try {
                this.contentHandler.processingInstruction(processingInstruction.getTarget(), processingInstruction.getData());
            } catch (SAXException e) {
                throw new JDOMException("Exception in processingInstruction", e);
            }
        }
    }

    private void element(Element element, NamespaceStack namespaceStack) throws JDOMException {
        int size = namespaceStack.size();
        startElement(element, startPrefixMapping(element, namespaceStack));
        elementContent(element.getContent(), namespaceStack);
        this.locator.setNode(element);
        endElement(element);
        endPrefixMapping(namespaceStack, size);
    }

    private Attributes startPrefixMapping(Element element, NamespaceStack namespaceStack) throws JDOMException {
        Namespace namespace = element.getNamespace();
        AttributesImpl attributesImpl = null;
        if (namespace != Namespace.XML_NAMESPACE) {
            String prefix = namespace.getPrefix();
            if (!namespace.getURI().equals(namespaceStack.getURI(prefix))) {
                namespaceStack.push(namespace);
                attributesImpl = addNsAttribute(null, namespace);
                try {
                    this.contentHandler.startPrefixMapping(prefix, namespace.getURI());
                } catch (SAXException e) {
                    throw new JDOMException("Exception in startPrefixMapping", e);
                }
            }
        }
        List<Namespace> additionalNamespaces = element.getAdditionalNamespaces();
        if (additionalNamespaces != null) {
            for (Namespace namespace2 : additionalNamespaces) {
                String prefix2 = namespace2.getPrefix();
                if (!namespace2.getURI().equals(namespaceStack.getURI(prefix2))) {
                    namespaceStack.push(namespace2);
                    attributesImpl = addNsAttribute(attributesImpl, namespace2);
                    try {
                        this.contentHandler.startPrefixMapping(prefix2, namespace2.getURI());
                    } catch (SAXException e2) {
                        throw new JDOMException("Exception in startPrefixMapping", e2);
                    }
                }
            }
        }
        return attributesImpl;
    }

    private void endPrefixMapping(NamespaceStack namespaceStack, int i) throws JDOMException {
        while (namespaceStack.size() > i) {
            try {
                this.contentHandler.endPrefixMapping(namespaceStack.pop());
            } catch (SAXException e) {
                throw new JDOMException("Exception in endPrefixMapping", e);
            }
        }
    }

    private void startElement(Element element, Attributes attributes) throws JDOMException {
        String namespaceURI = element.getNamespaceURI();
        String name = element.getName();
        String qualifiedName = element.getQualifiedName();
        AttributesImpl attributesImpl = attributes != null ? new AttributesImpl(attributes) : new AttributesImpl();
        for (Attribute attribute : element.getAttributes()) {
            attributesImpl.addAttribute(attribute.getNamespaceURI(), attribute.getName(), attribute.getQualifiedName(), getAttributeTypeName(attribute.getAttributeType()), attribute.getValue());
        }
        try {
            this.contentHandler.startElement(namespaceURI, name, qualifiedName, attributesImpl);
        } catch (SAXException e) {
            throw new JDOMException("Exception in startElement", e);
        }
    }

    private void endElement(Element element) throws JDOMException {
        try {
            this.contentHandler.endElement(element.getNamespaceURI(), element.getName(), element.getQualifiedName());
        } catch (SAXException e) {
            throw new JDOMException("Exception in endElement", e);
        }
    }

    private void elementContent(List list, NamespaceStack namespaceStack) throws JDOMException {
        for (Object obj : list) {
            if (obj instanceof Content) {
                elementContent((Content) obj, namespaceStack);
            } else {
                handleError(new JDOMException(new StringBuffer("Invalid element content: ").append(obj).toString()));
            }
        }
    }

    private void elementContent(Content content, NamespaceStack namespaceStack) throws JDOMException {
        this.locator.setNode(content);
        if (content instanceof Element) {
            element((Element) content, namespaceStack);
            return;
        }
        if (content instanceof CDATA) {
            cdata(((CDATA) content).getText());
            return;
        }
        if (content instanceof Text) {
            characters(((Text) content).getText());
            return;
        }
        if (content instanceof ProcessingInstruction) {
            processingInstruction((ProcessingInstruction) content);
            return;
        }
        if (content instanceof Comment) {
            comment(((Comment) content).getText());
        } else if (content instanceof EntityRef) {
            entityRef((EntityRef) content);
        } else {
            handleError(new JDOMException(new StringBuffer("Invalid element content: ").append(content).toString()));
        }
    }

    private void cdata(String str) throws JDOMException {
        try {
            LexicalHandler lexicalHandler = this.lexicalHandler;
            if (lexicalHandler != null) {
                lexicalHandler.startCDATA();
                characters(str);
                this.lexicalHandler.endCDATA();
                return;
            }
            characters(str);
        } catch (SAXException e) {
            throw new JDOMException("Exception in CDATA", e);
        }
    }

    private void characters(String str) throws JDOMException {
        char[] charArray = str.toCharArray();
        try {
            this.contentHandler.characters(charArray, 0, charArray.length);
        } catch (SAXException e) {
            throw new JDOMException("Exception in characters", e);
        }
    }

    private void comment(String str) throws JDOMException {
        if (this.lexicalHandler != null) {
            char[] charArray = str.toCharArray();
            try {
                this.lexicalHandler.comment(charArray, 0, charArray.length);
            } catch (SAXException e) {
                throw new JDOMException("Exception in comment", e);
            }
        }
    }

    private void entityRef(EntityRef entityRef) throws JDOMException {
        if (entityRef != null) {
            try {
                this.contentHandler.skippedEntity(entityRef.getName());
            } catch (SAXException e) {
                throw new JDOMException("Exception in entityRef", e);
            }
        }
    }

    private AttributesImpl addNsAttribute(AttributesImpl attributesImpl, Namespace namespace) {
        if (this.declareNamespaces) {
            if (attributesImpl == null) {
                attributesImpl = new AttributesImpl();
            }
            attributesImpl.addAttribute("", "", new StringBuffer(Sax2Dom.XMLNS_STRING).append(namespace.getPrefix()).toString(), "CDATA", namespace.getURI());
        }
        return attributesImpl;
    }

    private static String getAttributeTypeName(int i) {
        if (i < 0 || i >= attrTypeToNameMap.length) {
            i = 0;
        }
        return attrTypeToNameMap[i];
    }

    private void handleError(JDOMException jDOMException) throws JDOMException {
        ErrorHandler errorHandler = this.errorHandler;
        if (errorHandler != null) {
            try {
                errorHandler.error(new SAXParseException(jDOMException.getMessage(), null, jDOMException));
                return;
            } catch (SAXException e) {
                if (e.getException() instanceof JDOMException) {
                    throw ((JDOMException) e.getException());
                }
                throw new JDOMException(e.getMessage(), e);
            }
        }
        throw jDOMException;
    }

    protected XMLReader createParser() throws Exception {
        XMLReader xMLReader = null;
        try {
            Class<?> cls = Class.forName("javax.xml.parsers.SAXParserFactory");
            Object invoke = cls.getMethod("newSAXParser", null).invoke(cls.getMethod("newInstance", null).invoke(null, null), null);
            xMLReader = (XMLReader) invoke.getClass().getMethod("getXMLReader", null).invoke(invoke, null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return xMLReader == null ? XMLReaderFactory.createXMLReader("org.apache.xerces.parsers.SAXParser") : xMLReader;
    }

    private XMLReader createDTDParser() throws JDOMException {
        try {
            XMLReader createParser = createParser();
            if (getDTDHandler() != null) {
                createParser.setDTDHandler(getDTDHandler());
            }
            if (getEntityResolver() != null) {
                createParser.setEntityResolver(getEntityResolver());
            }
            if (getLexicalHandler() != null) {
                try {
                    try {
                        createParser.setProperty(LEXICAL_HANDLER_SAX_PROPERTY, getLexicalHandler());
                    } catch (SAXException unused) {
                        createParser.setProperty(LEXICAL_HANDLER_ALT_PROPERTY, getLexicalHandler());
                    }
                } catch (SAXException unused2) {
                }
            }
            if (getDeclHandler() != null) {
                try {
                    try {
                        createParser.setProperty(DECL_HANDLER_SAX_PROPERTY, getDeclHandler());
                    } catch (SAXException unused3) {
                        createParser.setProperty(DECL_HANDLER_ALT_PROPERTY, getDeclHandler());
                    }
                } catch (SAXException unused4) {
                }
            }
            createParser.setErrorHandler(new DefaultHandler());
            return createParser;
        } catch (Exception e) {
            throw new JDOMException("Error in SAX parser allocation", e);
        }
    }

    public JDOMLocator getLocator() {
        if (this.locator != null) {
            return new JDOMLocator(this.locator);
        }
        return null;
    }
}
