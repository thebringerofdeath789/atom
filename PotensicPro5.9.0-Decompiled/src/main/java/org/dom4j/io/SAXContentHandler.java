package org.dom4j.io;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dom4j.Branch;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.DocumentType;
import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.dom4j.QName;
import org.dom4j.dtd.AttributeDecl;
import org.dom4j.dtd.ElementDecl;
import org.dom4j.dtd.ExternalEntityDecl;
import org.dom4j.dtd.InternalEntityDecl;
import org.dom4j.tree.AbstractElement;
import org.dom4j.tree.NamespaceStack;
import org.xml.sax.Attributes;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.ext.DeclHandler;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes5.dex */
public class SAXContentHandler extends DefaultHandler implements LexicalHandler, DeclHandler, DTDHandler {
    private Map availableNamespaceMap;
    private StringBuffer cdataText;
    private Element currentElement;
    private int declaredNamespaceIndex;
    private List declaredNamespaceList;
    private Document document;
    private DocumentFactory documentFactory;
    private ElementHandler elementHandler;
    private ElementStack elementStack;
    private String entity;
    private int entityLevel;
    private EntityResolver entityResolver;
    private List externalDTDDeclarations;
    private boolean ignoreComments;
    private boolean includeExternalDTDDeclarations;
    private boolean includeInternalDTDDeclarations;
    private InputSource inputSource;
    private boolean insideCDATASection;
    private boolean insideDTDSection;
    private List internalDTDDeclarations;
    private boolean internalDTDsubset;
    private Locator locator;
    private boolean mergeAdjacentText;
    private NamespaceStack namespaceStack;
    private boolean stripWhitespaceText;
    private StringBuffer textBuffer;
    private boolean textInTextBuffer;

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.DTDHandler
    public void notationDecl(String str, String str2, String str3) throws SAXException {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.DTDHandler
    public void unparsedEntityDecl(String str, String str2, String str3, String str4) throws SAXException {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
    public void warning(SAXParseException sAXParseException) throws SAXException {
    }

    public SAXContentHandler() {
        this(DocumentFactory.getInstance());
    }

    public SAXContentHandler(DocumentFactory documentFactory) {
        this(documentFactory, null);
    }

    public SAXContentHandler(DocumentFactory documentFactory, ElementHandler elementHandler) {
        this(documentFactory, elementHandler, null);
        this.elementStack = createElementStack();
    }

    public SAXContentHandler(DocumentFactory documentFactory, ElementHandler elementHandler, ElementStack elementStack) {
        this.availableNamespaceMap = new HashMap();
        this.declaredNamespaceList = new ArrayList();
        this.includeInternalDTDDeclarations = false;
        this.includeExternalDTDDeclarations = false;
        this.internalDTDsubset = false;
        this.mergeAdjacentText = false;
        this.textInTextBuffer = false;
        this.ignoreComments = false;
        this.stripWhitespaceText = false;
        this.documentFactory = documentFactory;
        this.elementHandler = elementHandler;
        this.elementStack = elementStack;
        this.namespaceStack = new NamespaceStack(documentFactory);
    }

    public Document getDocument() {
        if (this.document == null) {
            this.document = createDocument();
        }
        return this.document;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
        this.locator = locator;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void processingInstruction(String str, String str2) throws SAXException {
        if (this.mergeAdjacentText && this.textInTextBuffer) {
            completeCurrentTextNode();
        }
        Element element = this.currentElement;
        if (element != null) {
            element.addProcessingInstruction(str, str2);
        } else {
            getDocument().addProcessingInstruction(str, str2);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startPrefixMapping(String str, String str2) throws SAXException {
        this.namespaceStack.push(str, str2);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endPrefixMapping(String str) throws SAXException {
        this.namespaceStack.pop(str);
        this.declaredNamespaceIndex = this.namespaceStack.size();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        this.document = null;
        this.currentElement = null;
        this.elementStack.clear();
        ElementHandler elementHandler = this.elementHandler;
        if (elementHandler != null && (elementHandler instanceof DispatchHandler)) {
            this.elementStack.setDispatchHandler((DispatchHandler) elementHandler);
        }
        this.namespaceStack.clear();
        this.declaredNamespaceIndex = 0;
        if (this.mergeAdjacentText && this.textBuffer == null) {
            this.textBuffer = new StringBuffer();
        }
        this.textInTextBuffer = false;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
        this.namespaceStack.clear();
        this.elementStack.clear();
        this.currentElement = null;
        this.textBuffer = null;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        if (this.mergeAdjacentText && this.textInTextBuffer) {
            completeCurrentTextNode();
        }
        QName qName = this.namespaceStack.getQName(str, str2, str3);
        Branch branch = this.currentElement;
        if (branch == null) {
            branch = getDocument();
        }
        Element addElement = branch.addElement(qName);
        addDeclaredNamespaces(addElement);
        addAttributes(addElement, attributes);
        this.elementStack.pushElement(addElement);
        this.currentElement = addElement;
        this.entity = null;
        ElementHandler elementHandler = this.elementHandler;
        if (elementHandler != null) {
            elementHandler.onStart(this.elementStack);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        if (this.mergeAdjacentText && this.textInTextBuffer) {
            completeCurrentTextNode();
        }
        ElementHandler elementHandler = this.elementHandler;
        if (elementHandler != null && this.currentElement != null) {
            elementHandler.onEnd(this.elementStack);
        }
        this.elementStack.popElement();
        this.currentElement = this.elementStack.peekElement();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        Element element;
        if (i2 == 0 || (element = this.currentElement) == null) {
            return;
        }
        if (this.entity != null) {
            if (this.mergeAdjacentText && this.textInTextBuffer) {
                completeCurrentTextNode();
            }
            this.currentElement.addEntity(this.entity, new String(cArr, i, i2));
            this.entity = null;
            return;
        }
        if (this.insideCDATASection) {
            if (this.mergeAdjacentText && this.textInTextBuffer) {
                completeCurrentTextNode();
            }
            this.cdataText.append(new String(cArr, i, i2));
            return;
        }
        if (this.mergeAdjacentText) {
            this.textBuffer.append(cArr, i, i2);
            this.textInTextBuffer = true;
        } else {
            element.addText(new String(cArr, i, i2));
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
    public void error(SAXParseException sAXParseException) throws SAXException {
        throw sAXParseException;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
    public void fatalError(SAXParseException sAXParseException) throws SAXException {
        throw sAXParseException;
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startDTD(String str, String str2, String str3) throws SAXException {
        getDocument().addDocType(str, str2, str3);
        this.insideDTDSection = true;
        this.internalDTDsubset = true;
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endDTD() throws SAXException {
        this.insideDTDSection = false;
        DocumentType docType = getDocument().getDocType();
        if (docType != null) {
            List list = this.internalDTDDeclarations;
            if (list != null) {
                docType.setInternalDeclarations(list);
            }
            List list2 = this.externalDTDDeclarations;
            if (list2 != null) {
                docType.setExternalDeclarations(list2);
            }
        }
        this.internalDTDDeclarations = null;
        this.externalDTDDeclarations = null;
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startEntity(String str) throws SAXException {
        this.entityLevel++;
        this.entity = null;
        if (!this.insideDTDSection && !isIgnorableEntity(str)) {
            this.entity = str;
        }
        this.internalDTDsubset = false;
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endEntity(String str) throws SAXException {
        int i = this.entityLevel - 1;
        this.entityLevel = i;
        this.entity = null;
        if (i == 0) {
            this.internalDTDsubset = true;
        }
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startCDATA() throws SAXException {
        this.insideCDATASection = true;
        this.cdataText = new StringBuffer();
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endCDATA() throws SAXException {
        this.insideCDATASection = false;
        this.currentElement.addCDATA(this.cdataText.toString());
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void comment(char[] cArr, int i, int i2) throws SAXException {
        if (this.ignoreComments) {
            return;
        }
        if (this.mergeAdjacentText && this.textInTextBuffer) {
            completeCurrentTextNode();
        }
        String str = new String(cArr, i, i2);
        if (this.insideDTDSection || str.length() <= 0) {
            return;
        }
        Element element = this.currentElement;
        if (element != null) {
            element.addComment(str);
        } else {
            getDocument().addComment(str);
        }
    }

    @Override // org.xml.sax.ext.DeclHandler
    public void elementDecl(String str, String str2) throws SAXException {
        if (this.internalDTDsubset) {
            if (this.includeInternalDTDDeclarations) {
                addDTDDeclaration(new ElementDecl(str, str2));
            }
        } else if (this.includeExternalDTDDeclarations) {
            addExternalDTDDeclaration(new ElementDecl(str, str2));
        }
    }

    @Override // org.xml.sax.ext.DeclHandler
    public void attributeDecl(String str, String str2, String str3, String str4, String str5) throws SAXException {
        if (this.internalDTDsubset) {
            if (this.includeInternalDTDDeclarations) {
                addDTDDeclaration(new AttributeDecl(str, str2, str3, str4, str5));
            }
        } else if (this.includeExternalDTDDeclarations) {
            addExternalDTDDeclaration(new AttributeDecl(str, str2, str3, str4, str5));
        }
    }

    @Override // org.xml.sax.ext.DeclHandler
    public void internalEntityDecl(String str, String str2) throws SAXException {
        if (this.internalDTDsubset) {
            if (this.includeInternalDTDDeclarations) {
                addDTDDeclaration(new InternalEntityDecl(str, str2));
            }
        } else if (this.includeExternalDTDDeclarations) {
            addExternalDTDDeclaration(new InternalEntityDecl(str, str2));
        }
    }

    @Override // org.xml.sax.ext.DeclHandler
    public void externalEntityDecl(String str, String str2, String str3) throws SAXException {
        ExternalEntityDecl externalEntityDecl = new ExternalEntityDecl(str, str2, str3);
        if (this.internalDTDsubset) {
            if (this.includeInternalDTDDeclarations) {
                addDTDDeclaration(externalEntityDecl);
            }
        } else if (this.includeExternalDTDDeclarations) {
            addExternalDTDDeclaration(externalEntityDecl);
        }
    }

    public ElementStack getElementStack() {
        return this.elementStack;
    }

    public void setElementStack(ElementStack elementStack) {
        this.elementStack = elementStack;
    }

    public EntityResolver getEntityResolver() {
        return this.entityResolver;
    }

    public void setEntityResolver(EntityResolver entityResolver) {
        this.entityResolver = entityResolver;
    }

    public InputSource getInputSource() {
        return this.inputSource;
    }

    public void setInputSource(InputSource inputSource) {
        this.inputSource = inputSource;
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

    protected void completeCurrentTextNode() {
        boolean z;
        if (this.stripWhitespaceText) {
            int length = this.textBuffer.length();
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = true;
                    break;
                } else {
                    if (!Character.isWhitespace(this.textBuffer.charAt(i))) {
                        z = false;
                        break;
                    }
                    i++;
                }
            }
            if (!z) {
                this.currentElement.addText(this.textBuffer.toString());
            }
        } else {
            this.currentElement.addText(this.textBuffer.toString());
        }
        this.textBuffer.setLength(0);
        this.textInTextBuffer = false;
    }

    protected Document createDocument() {
        Document createDocument = this.documentFactory.createDocument(getEncoding());
        createDocument.setEntityResolver(this.entityResolver);
        InputSource inputSource = this.inputSource;
        if (inputSource != null) {
            createDocument.setName(inputSource.getSystemId());
        }
        return createDocument;
    }

    private String getEncoding() {
        Locator locator = this.locator;
        if (locator == null) {
            return null;
        }
        try {
            Method method = locator.getClass().getMethod("getEncoding", new Class[0]);
            if (method != null) {
                return (String) method.invoke(this.locator, null);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    protected boolean isIgnorableEntity(String str) {
        return "amp".equals(str) || "apos".equals(str) || "gt".equals(str) || "lt".equals(str) || "quot".equals(str);
    }

    protected void addDeclaredNamespaces(Element element) {
        element.getNamespace();
        int size = this.namespaceStack.size();
        while (true) {
            int i = this.declaredNamespaceIndex;
            if (i >= size) {
                return;
            }
            element.add(this.namespaceStack.getNamespace(i));
            this.declaredNamespaceIndex++;
        }
    }

    protected void addAttributes(Element element, Attributes attributes) {
        if (element instanceof AbstractElement) {
            ((AbstractElement) element).setAttributes(attributes, this.namespaceStack, false);
            return;
        }
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            String qName = attributes.getQName(i);
            if (!qName.startsWith("xmlns")) {
                String uri = attributes.getURI(i);
                String localName = attributes.getLocalName(i);
                element.addAttribute(this.namespaceStack.getAttributeQName(uri, localName, qName), attributes.getValue(i));
            }
        }
    }

    protected void addDTDDeclaration(Object obj) {
        if (this.internalDTDDeclarations == null) {
            this.internalDTDDeclarations = new ArrayList();
        }
        this.internalDTDDeclarations.add(obj);
    }

    protected void addExternalDTDDeclaration(Object obj) {
        if (this.externalDTDDeclarations == null) {
            this.externalDTDDeclarations = new ArrayList();
        }
        this.externalDTDDeclarations.add(obj);
    }

    protected ElementStack createElementStack() {
        return new ElementStack();
    }
}
