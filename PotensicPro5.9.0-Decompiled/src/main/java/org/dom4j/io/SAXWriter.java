package org.dom4j.io;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.dom4j.Attribute;
import org.dom4j.Branch;
import org.dom4j.CDATA;
import org.dom4j.CharacterData;
import org.dom4j.Comment;
import org.dom4j.Document;
import org.dom4j.DocumentType;
import org.dom4j.Element;
import org.dom4j.Entity;
import org.dom4j.Namespace;
import org.dom4j.Node;
import org.dom4j.ProcessingInstruction;
import org.dom4j.Text;
import org.dom4j.tree.NamespaceStack;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.LocatorImpl;

/* loaded from: classes5.dex */
public class SAXWriter implements XMLReader {
    protected static final String FEATURE_NAMESPACES = "http://xml.org/sax/features/namespaces";
    protected static final String FEATURE_NAMESPACE_PREFIXES = "http://xml.org/sax/features/namespace-prefixes";
    protected static final String[] LEXICAL_HANDLER_NAMES = {"http://xml.org/sax/properties/lexical-handler", "http://xml.org/sax/handlers/LexicalHandler"};
    private AttributesImpl attributes;
    private ContentHandler contentHandler;
    private boolean declareNamespaceAttributes;
    private DTDHandler dtdHandler;
    private EntityResolver entityResolver;
    private ErrorHandler errorHandler;
    private Map features;
    private LexicalHandler lexicalHandler;
    private Map properties;

    protected void checkForNullHandlers() {
    }

    protected void dtdHandler(Document document) throws SAXException {
    }

    public SAXWriter() {
        this.attributes = new AttributesImpl();
        this.features = new HashMap();
        HashMap hashMap = new HashMap();
        this.properties = hashMap;
        hashMap.put(FEATURE_NAMESPACE_PREFIXES, Boolean.FALSE);
        this.properties.put(FEATURE_NAMESPACE_PREFIXES, Boolean.TRUE);
    }

    public SAXWriter(ContentHandler contentHandler) {
        this();
        this.contentHandler = contentHandler;
    }

    public SAXWriter(ContentHandler contentHandler, LexicalHandler lexicalHandler) {
        this();
        this.contentHandler = contentHandler;
        this.lexicalHandler = lexicalHandler;
    }

    public SAXWriter(ContentHandler contentHandler, LexicalHandler lexicalHandler, EntityResolver entityResolver) {
        this();
        this.contentHandler = contentHandler;
        this.lexicalHandler = lexicalHandler;
        this.entityResolver = entityResolver;
    }

    public void write(Node node) throws SAXException {
        switch (node.getNodeType()) {
            case 1:
                write((Element) node);
                return;
            case 2:
                write((Attribute) node);
                return;
            case 3:
                write(node.getText());
                return;
            case 4:
                write((CDATA) node);
                return;
            case 5:
                write((Entity) node);
                return;
            case 6:
            case 11:
            case 12:
            default:
                throw new SAXException(new StringBuffer().append("Invalid node type: ").append(node).toString());
            case 7:
                write((ProcessingInstruction) node);
                return;
            case 8:
                write((Comment) node);
                return;
            case 9:
                write((Document) node);
                return;
            case 10:
                write((DocumentType) node);
                return;
            case 13:
                return;
        }
    }

    public void write(Document document) throws SAXException {
        if (document != null) {
            checkForNullHandlers();
            documentLocator(document);
            startDocument();
            entityResolver(document);
            dtdHandler(document);
            writeContent(document, new NamespaceStack());
            endDocument();
        }
    }

    public void write(Element element) throws SAXException {
        write(element, new NamespaceStack());
    }

    public void writeOpen(Element element) throws SAXException {
        startElement(element, null);
    }

    public void writeClose(Element element) throws SAXException {
        endElement(element);
    }

    public void write(String str) throws SAXException {
        if (str != null) {
            char[] charArray = str.toCharArray();
            this.contentHandler.characters(charArray, 0, charArray.length);
        }
    }

    public void write(CDATA cdata) throws SAXException {
        String text = cdata.getText();
        LexicalHandler lexicalHandler = this.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.startCDATA();
            write(text);
            this.lexicalHandler.endCDATA();
            return;
        }
        write(text);
    }

    public void write(Comment comment) throws SAXException {
        if (this.lexicalHandler != null) {
            char[] charArray = comment.getText().toCharArray();
            this.lexicalHandler.comment(charArray, 0, charArray.length);
        }
    }

    public void write(Entity entity) throws SAXException {
        String text = entity.getText();
        if (this.lexicalHandler != null) {
            String name = entity.getName();
            this.lexicalHandler.startEntity(name);
            write(text);
            this.lexicalHandler.endEntity(name);
            return;
        }
        write(text);
    }

    public void write(ProcessingInstruction processingInstruction) throws SAXException {
        this.contentHandler.processingInstruction(processingInstruction.getTarget(), processingInstruction.getText());
    }

    public boolean isDeclareNamespaceAttributes() {
        return this.declareNamespaceAttributes;
    }

    public void setDeclareNamespaceAttributes(boolean z) {
        this.declareNamespaceAttributes = z;
    }

    @Override // org.xml.sax.XMLReader
    public ContentHandler getContentHandler() {
        return this.contentHandler;
    }

    @Override // org.xml.sax.XMLReader
    public void setContentHandler(ContentHandler contentHandler) {
        this.contentHandler = contentHandler;
    }

    @Override // org.xml.sax.XMLReader
    public DTDHandler getDTDHandler() {
        return this.dtdHandler;
    }

    @Override // org.xml.sax.XMLReader
    public void setDTDHandler(DTDHandler dTDHandler) {
        this.dtdHandler = dTDHandler;
    }

    @Override // org.xml.sax.XMLReader
    public ErrorHandler getErrorHandler() {
        return this.errorHandler;
    }

    @Override // org.xml.sax.XMLReader
    public void setErrorHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    @Override // org.xml.sax.XMLReader
    public EntityResolver getEntityResolver() {
        return this.entityResolver;
    }

    @Override // org.xml.sax.XMLReader
    public void setEntityResolver(EntityResolver entityResolver) {
        this.entityResolver = entityResolver;
    }

    public LexicalHandler getLexicalHandler() {
        return this.lexicalHandler;
    }

    public void setLexicalHandler(LexicalHandler lexicalHandler) {
        this.lexicalHandler = lexicalHandler;
    }

    public void setXMLReader(XMLReader xMLReader) {
        setContentHandler(xMLReader.getContentHandler());
        setDTDHandler(xMLReader.getDTDHandler());
        setEntityResolver(xMLReader.getEntityResolver());
        setErrorHandler(xMLReader.getErrorHandler());
    }

    @Override // org.xml.sax.XMLReader
    public boolean getFeature(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        Boolean bool = (Boolean) this.features.get(str);
        return bool != null && bool.booleanValue();
    }

    @Override // org.xml.sax.XMLReader
    public void setFeature(String str, boolean z) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (FEATURE_NAMESPACE_PREFIXES.equals(str)) {
            setDeclareNamespaceAttributes(z);
        } else if (FEATURE_NAMESPACE_PREFIXES.equals(str) && !z) {
            throw new SAXNotSupportedException("Namespace feature is always supported in dom4j");
        }
        this.features.put(str, z ? Boolean.TRUE : Boolean.FALSE);
    }

    @Override // org.xml.sax.XMLReader
    public void setProperty(String str, Object obj) {
        int i = 0;
        while (true) {
            String[] strArr = LEXICAL_HANDLER_NAMES;
            if (i < strArr.length) {
                if (strArr[i].equals(str)) {
                    setLexicalHandler((LexicalHandler) obj);
                    return;
                }
                i++;
            } else {
                this.properties.put(str, obj);
                return;
            }
        }
    }

    @Override // org.xml.sax.XMLReader
    public Object getProperty(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        int i = 0;
        while (true) {
            String[] strArr = LEXICAL_HANDLER_NAMES;
            if (i < strArr.length) {
                if (strArr[i].equals(str)) {
                    return getLexicalHandler();
                }
                i++;
            } else {
                return this.properties.get(str);
            }
        }
    }

    @Override // org.xml.sax.XMLReader
    public void parse(String str) throws SAXNotSupportedException {
        throw new SAXNotSupportedException("This XMLReader can only accept <dom4j> InputSource objects");
    }

    @Override // org.xml.sax.XMLReader
    public void parse(InputSource inputSource) throws SAXException {
        if (inputSource instanceof DocumentInputSource) {
            write(((DocumentInputSource) inputSource).getDocument());
            return;
        }
        throw new SAXNotSupportedException("This XMLReader can only accept <dom4j> InputSource objects");
    }

    protected void writeContent(Branch branch, NamespaceStack namespaceStack) throws SAXException {
        Iterator nodeIterator = branch.nodeIterator();
        while (nodeIterator.hasNext()) {
            Object next = nodeIterator.next();
            if (next instanceof Element) {
                write((Element) next, namespaceStack);
            } else if (next instanceof CharacterData) {
                if (next instanceof Text) {
                    write(((Text) next).getText());
                } else if (next instanceof CDATA) {
                    write((CDATA) next);
                } else if (next instanceof Comment) {
                    write((Comment) next);
                } else {
                    throw new SAXException(new StringBuffer().append("Invalid Node in DOM4J content: ").append(next).append(" of type: ").append(next.getClass()).toString());
                }
            } else if (next instanceof String) {
                write((String) next);
            } else if (next instanceof Entity) {
                write((Entity) next);
            } else if (next instanceof ProcessingInstruction) {
                write((ProcessingInstruction) next);
            } else if (next instanceof Namespace) {
                write((Namespace) next);
            } else {
                throw new SAXException(new StringBuffer().append("Invalid Node in DOM4J content: ").append(next).toString());
            }
        }
    }

    protected void documentLocator(Document document) throws SAXException {
        String str;
        LocatorImpl locatorImpl = new LocatorImpl();
        DocumentType docType = document.getDocType();
        String str2 = null;
        if (docType != null) {
            str2 = docType.getPublicID();
            str = docType.getSystemID();
        } else {
            str = null;
        }
        if (str2 != null) {
            locatorImpl.setPublicId(str2);
        }
        if (str != null) {
            locatorImpl.setSystemId(str);
        }
        locatorImpl.setLineNumber(-1);
        locatorImpl.setColumnNumber(-1);
        this.contentHandler.setDocumentLocator(locatorImpl);
    }

    protected void entityResolver(Document document) throws SAXException {
        DocumentType docType;
        if (this.entityResolver == null || (docType = document.getDocType()) == null) {
            return;
        }
        String publicID = docType.getPublicID();
        String systemID = docType.getSystemID();
        if (publicID == null && systemID == null) {
            return;
        }
        try {
            this.entityResolver.resolveEntity(publicID, systemID);
        } catch (IOException e) {
            throw new SAXException(new StringBuffer().append("Could not resolve publicID: ").append(publicID).append(" systemID: ").append(systemID).toString(), e);
        }
    }

    protected void startDocument() throws SAXException {
        this.contentHandler.startDocument();
    }

    protected void endDocument() throws SAXException {
        this.contentHandler.endDocument();
    }

    protected void write(Element element, NamespaceStack namespaceStack) throws SAXException {
        int size = namespaceStack.size();
        startElement(element, startPrefixMapping(element, namespaceStack));
        writeContent(element, namespaceStack);
        endElement(element);
        endPrefixMapping(namespaceStack, size);
    }

    protected AttributesImpl startPrefixMapping(Element element, NamespaceStack namespaceStack) throws SAXException {
        Namespace namespace = element.getNamespace();
        AttributesImpl attributesImpl = null;
        if (namespace != null && !isIgnoreableNamespace(namespace, namespaceStack)) {
            namespaceStack.push(namespace);
            this.contentHandler.startPrefixMapping(namespace.getPrefix(), namespace.getURI());
            attributesImpl = addNamespaceAttribute(null, namespace);
        }
        List declaredNamespaces = element.declaredNamespaces();
        int size = declaredNamespaces.size();
        for (int i = 0; i < size; i++) {
            Namespace namespace2 = (Namespace) declaredNamespaces.get(i);
            if (!isIgnoreableNamespace(namespace2, namespaceStack)) {
                namespaceStack.push(namespace2);
                this.contentHandler.startPrefixMapping(namespace2.getPrefix(), namespace2.getURI());
                attributesImpl = addNamespaceAttribute(attributesImpl, namespace2);
            }
        }
        return attributesImpl;
    }

    protected void endPrefixMapping(NamespaceStack namespaceStack, int i) throws SAXException {
        while (namespaceStack.size() > i) {
            Namespace pop = namespaceStack.pop();
            if (pop != null) {
                this.contentHandler.endPrefixMapping(pop.getPrefix());
            }
        }
    }

    protected void startElement(Element element, AttributesImpl attributesImpl) throws SAXException {
        this.contentHandler.startElement(element.getNamespaceURI(), element.getName(), element.getQualifiedName(), createAttributes(element, attributesImpl));
    }

    protected void endElement(Element element) throws SAXException {
        this.contentHandler.endElement(element.getNamespaceURI(), element.getName(), element.getQualifiedName());
    }

    protected Attributes createAttributes(Element element, Attributes attributes) throws SAXException {
        this.attributes.clear();
        if (attributes != null) {
            this.attributes.setAttributes(attributes);
        }
        Iterator attributeIterator = element.attributeIterator();
        while (attributeIterator.hasNext()) {
            Attribute attribute = (Attribute) attributeIterator.next();
            this.attributes.addAttribute(attribute.getNamespaceURI(), attribute.getName(), attribute.getQualifiedName(), "CDATA", attribute.getValue());
        }
        return this.attributes;
    }

    protected AttributesImpl addNamespaceAttribute(AttributesImpl attributesImpl, Namespace namespace) {
        if (this.declareNamespaceAttributes) {
            if (attributesImpl == null) {
                attributesImpl = new AttributesImpl();
            }
            String prefix = namespace.getPrefix();
            attributesImpl.addAttribute("", prefix, (prefix == null || prefix.length() <= 0) ? "xmlns" : new StringBuffer().append(Sax2Dom.XMLNS_STRING).append(prefix).toString(), "CDATA", namespace.getURI());
        }
        return attributesImpl;
    }

    protected boolean isIgnoreableNamespace(Namespace namespace, NamespaceStack namespaceStack) {
        String uri;
        if (namespace.equals(Namespace.NO_NAMESPACE) || namespace.equals(Namespace.XML_NAMESPACE) || (uri = namespace.getURI()) == null || uri.length() <= 0) {
            return true;
        }
        return namespaceStack.contains(namespace);
    }
}
