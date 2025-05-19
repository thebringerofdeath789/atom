package org.apache.xmlbeans.impl.common;

import java.util.Stack;
import java.util.Vector;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes5.dex */
public class Sax2Dom extends DefaultHandler implements ContentHandler, LexicalHandler {
    public static final String EMPTYSTRING = "";
    public static final String XMLNS_PREFIX = "xmlns";
    public static final String XMLNS_STRING = "xmlns:";
    public static final String XMLNS_URI = "http://www.w3.org/2000/xmlns/";
    public static final String XML_PREFIX = "xml";
    private Document _document;
    private Node _root;
    private Stack _nodeStk = new Stack();
    private Vector _namespaceDecls = null;

    @Override // org.xml.sax.ext.LexicalHandler
    public void endCDATA() {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endDTD() {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endEntity(String str) {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endPrefixMapping(String str) {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i, int i2) {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void skippedEntity(String str) {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startCDATA() {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startDTD(String str, String str2, String str3) throws SAXException {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startEntity(String str) {
    }

    public Sax2Dom() throws ParserConfigurationException {
        this._root = null;
        this._document = null;
        Document newDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        this._document = newDocument;
        this._root = newDocument;
    }

    public Sax2Dom(Node node) throws ParserConfigurationException {
        this._root = null;
        this._document = null;
        this._root = node;
        if (node instanceof Document) {
            this._document = (Document) node;
        } else {
            if (node != null) {
                this._document = node.getOwnerDocument();
                return;
            }
            Document newDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            this._document = newDocument;
            this._root = newDocument;
        }
    }

    public Node getDOM() {
        return this._root;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) {
        Node node = (Node) this._nodeStk.peek();
        if (node != this._document) {
            node.appendChild(this._document.createTextNode(new String(cArr, i, i2)));
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() {
        this._nodeStk.push(this._root);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() {
        this._nodeStk.pop();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        Element createElementNS = this._document.createElementNS(str, str3);
        Vector vector = this._namespaceDecls;
        if (vector != null) {
            int size = vector.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                String str4 = (String) this._namespaceDecls.elementAt(i);
                if (str4 == null || str4.equals("")) {
                    createElementNS.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", (String) this._namespaceDecls.elementAt(i2));
                } else {
                    createElementNS.setAttributeNS("http://www.w3.org/2000/xmlns/", new StringBuffer().append(XMLNS_STRING).append(str4).toString(), (String) this._namespaceDecls.elementAt(i2));
                }
                i = i2 + 1;
            }
            this._namespaceDecls.clear();
        }
        int length = attributes.getLength();
        for (int i3 = 0; i3 < length; i3++) {
            if (attributes.getLocalName(i3) == null) {
                createElementNS.setAttribute(attributes.getQName(i3), attributes.getValue(i3));
            } else {
                createElementNS.setAttributeNS(attributes.getURI(i3), attributes.getQName(i3), attributes.getValue(i3));
            }
        }
        ((Node) this._nodeStk.peek()).appendChild(createElementNS);
        this._nodeStk.push(createElementNS);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        this._nodeStk.pop();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startPrefixMapping(String str, String str2) {
        if (this._namespaceDecls == null) {
            this._namespaceDecls = new Vector(2);
        }
        this._namespaceDecls.addElement(str);
        this._namespaceDecls.addElement(str2);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void processingInstruction(String str, String str2) {
        Node node = (Node) this._nodeStk.peek();
        ProcessingInstruction createProcessingInstruction = this._document.createProcessingInstruction(str, str2);
        if (createProcessingInstruction != null) {
            node.appendChild(createProcessingInstruction);
        }
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void comment(char[] cArr, int i, int i2) {
        Node node = (Node) this._nodeStk.peek();
        Comment createComment = this._document.createComment(new String(cArr, i, i2));
        if (createComment != null) {
            node.appendChild(createComment);
        }
    }
}
