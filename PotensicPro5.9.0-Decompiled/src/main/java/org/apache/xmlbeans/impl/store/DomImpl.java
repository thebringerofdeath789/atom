package org.apache.xmlbeans.impl.store;

import aavax.xml.namespace.QName;
import aavax.xml.stream.XMLStreamReader;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.transform.Source;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.impl.common.XMLChar;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.soap.Detail;
import org.apache.xmlbeans.impl.soap.DetailEntry;
import org.apache.xmlbeans.impl.soap.Name;
import org.apache.xmlbeans.impl.soap.SOAPBody;
import org.apache.xmlbeans.impl.soap.SOAPBodyElement;
import org.apache.xmlbeans.impl.soap.SOAPElement;
import org.apache.xmlbeans.impl.soap.SOAPEnvelope;
import org.apache.xmlbeans.impl.soap.SOAPException;
import org.apache.xmlbeans.impl.soap.SOAPFault;
import org.apache.xmlbeans.impl.soap.SOAPHeader;
import org.apache.xmlbeans.impl.soap.SOAPHeaderElement;
import org.apache.xmlbeans.impl.soap.SOAPPart;
import org.apache.xmlbeans.impl.store.Xobj;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;

/* loaded from: classes5.dex */
final class DomImpl {
    static final /* synthetic */ boolean $assertionsDisabled;
    static final int ATTR = 2;
    static final int CDATA = 4;
    static final int COMMENT = 8;
    static final int DOCFRAG = 11;
    static final int DOCTYPE = 10;
    static final int DOCUMENT = 9;
    static final int ELEMENT = 1;
    static final int ENTITY = 6;
    static final int ENTITYREF = 5;
    static final int NOTATION = 12;
    static final int PROCINST = 7;
    static final int TEXT = 3;
    public static NodeList _emptyNodeList;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$store$DomImpl;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$store$DomImpl$SaajData;

    interface Dom {
        void dump();

        void dump(PrintStream printStream);

        void dump(PrintStream printStream, Object obj);

        QName getQName();

        Locale locale();

        boolean nodeCanHavePrefixUri();

        int nodeType();

        Cur tempCur();
    }

    public static boolean _attr_getSpecified(Dom dom) {
        return true;
    }

    public static Dom document_getDoctype(Dom dom) {
        return null;
    }

    public static Text impl_saajCallback_ensureSoapTextNode(Dom dom) {
        return null;
    }

    static {
        if (class$org$apache$xmlbeans$impl$store$DomImpl == null) {
            class$org$apache$xmlbeans$impl$store$DomImpl = class$("org.apache.xmlbeans.impl.store.DomImpl");
        }
        $assertionsDisabled = true;
        _emptyNodeList = new EmptyNodeList();
    }

    DomImpl() {
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    static Dom parent(Dom dom) {
        return node_getParentNode(dom);
    }

    static Dom firstChild(Dom dom) {
        return node_getFirstChild(dom);
    }

    static Dom nextSibling(Dom dom) {
        return node_getNextSibling(dom);
    }

    static Dom prevSibling(Dom dom) {
        return node_getPreviousSibling(dom);
    }

    public static Dom append(Dom dom, Dom dom2) {
        return node_insertBefore(dom2, dom, null);
    }

    public static Dom insert(Dom dom, Dom dom2) {
        if ($assertionsDisabled || dom2 != null) {
            return node_insertBefore(parent(dom2), dom, dom2);
        }
        throw new AssertionError();
    }

    public static Dom remove(Dom dom) {
        Dom parent = parent(dom);
        if (parent != null) {
            node_removeChild(parent, dom);
        }
        return dom;
    }

    static class HierarchyRequestErr extends DOMException {
        HierarchyRequestErr() {
            this("This node isn't allowed there");
        }

        HierarchyRequestErr(String str) {
            super((short) 3, str);
        }
    }

    static class WrongDocumentErr extends DOMException {
        WrongDocumentErr() {
            this("Nodes do not belong to the same document");
        }

        WrongDocumentErr(String str) {
            super((short) 4, str);
        }
    }

    static class NotFoundErr extends DOMException {
        NotFoundErr() {
            this("Node not found");
        }

        NotFoundErr(String str) {
            super((short) 8, str);
        }
    }

    static class NamespaceErr extends DOMException {
        NamespaceErr() {
            this("Namespace error");
        }

        NamespaceErr(String str) {
            super((short) 14, str);
        }
    }

    static class NoModificationAllowedErr extends DOMException {
        NoModificationAllowedErr() {
            this("No modification allowed error");
        }

        NoModificationAllowedErr(String str) {
            super((short) 7, str);
        }
    }

    static class InuseAttributeError extends DOMException {
        InuseAttributeError() {
            this("Attribute currently in use error");
        }

        InuseAttributeError(String str) {
            super((short) 10, str);
        }
    }

    static class IndexSizeError extends DOMException {
        IndexSizeError() {
            this("Index Size Error");
        }

        IndexSizeError(String str) {
            super((short) 1, str);
        }
    }

    static class NotSupportedError extends DOMException {
        NotSupportedError() {
            this("This operation is not supported");
        }

        NotSupportedError(String str) {
            super((short) 9, str);
        }
    }

    static class InvalidCharacterError extends DOMException {
        InvalidCharacterError() {
            this("The name contains an invalid character");
        }

        InvalidCharacterError(String str) {
            super((short) 5, str);
        }
    }

    private static final class EmptyNodeList implements NodeList {
        @Override // org.w3c.dom.NodeList
        public int getLength() {
            return 0;
        }

        @Override // org.w3c.dom.NodeList
        public Node item(int i) {
            return null;
        }

        private EmptyNodeList() {
        }
    }

    static String nodeKindName(int i) {
        switch (i) {
            case 1:
                return "element";
            case 2:
                return "attribute";
            case 3:
                return "text";
            case 4:
                return "cdata section";
            case 5:
                return "entity reference";
            case 6:
                return "entity";
            case 7:
                return "processing instruction";
            case 8:
                return JamXmlElements.COMMENT;
            case 9:
                return "document";
            case 10:
                return "document type";
            case 11:
                return "document fragment";
            case 12:
                return "notation";
            default:
                throw new RuntimeException("Unknown node type");
        }
    }

    private static String isValidChild(Dom dom, Dom dom2) {
        int nodeType = dom.nodeType();
        int nodeType2 = dom2.nodeType();
        switch (nodeType) {
            case 1:
            case 5:
            case 6:
            case 11:
                if (nodeType2 == 1 || nodeType2 == 3 || nodeType2 == 4 || nodeType2 == 5 || nodeType2 == 7 || nodeType2 == 8) {
                    return null;
                }
            case 2:
                if (nodeType2 == 3 || nodeType2 == 5) {
                    return null;
                }
            case 3:
            case 4:
            case 7:
            case 8:
            case 10:
            case 12:
                return new StringBuffer().append(nodeKindName(nodeType)).append(" nodes may not have any children").toString();
            case 9:
                if (nodeType2 == 1) {
                    if (document_getDocumentElement(dom) != null) {
                        return "Documents may only have a maximum of one document element";
                    }
                    return null;
                }
                if (nodeType2 == 10) {
                    if (document_getDoctype(dom) != null) {
                        return "Documents may only have a maximum of one document type node";
                    }
                    return null;
                }
                if (nodeType2 == 7 || nodeType2 == 8) {
                    return null;
                }
        }
        return new StringBuffer().append(nodeKindName(nodeType)).append(" nodes may not have ").append(nodeKindName(nodeType2)).append(" nodes as children").toString();
    }

    private static void validateNewChild(Dom dom, Dom dom2) {
        String isValidChild = isValidChild(dom, dom2);
        if (isValidChild != null) {
            throw new HierarchyRequestErr(isValidChild);
        }
        if (dom == dom2) {
            throw new HierarchyRequestErr("New child and parent are the same node");
        }
        do {
            dom = parent(dom);
            if (dom == null) {
                return;
            }
            if (dom2.nodeType() == 5) {
                throw new NoModificationAllowedErr("Entity reference trees may not be modified");
            }
        } while (dom2 != dom);
        throw new HierarchyRequestErr("New child is an ancestor node of the parent node");
    }

    private static String validatePrefix(String str, String str2, String str3, boolean z) {
        validateNcName(str);
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str.length() > 0 && str2.length() == 0) {
            throw new NamespaceErr("Attempt to give a prefix for no namespace");
        }
        if (str.equals("xml") && !str2.equals("http://www.w3.org/XML/1998/namespace")) {
            throw new NamespaceErr("Invalid prefix - begins with 'xml'");
        }
        if (z) {
            if (str.length() > 0) {
                if (str3.equals("xmlns")) {
                    throw new NamespaceErr("Invalid namespace - attr is default namespace already");
                }
                if (Locale.beginsWithXml(str3)) {
                    throw new NamespaceErr("Invalid namespace - attr prefix begins with 'xml'");
                }
                if (str.equals("xmlns") && !str2.equals("http://www.w3.org/2000/xmlns/")) {
                    throw new NamespaceErr("Invalid namespace - uri is not 'http://www.w3.org/2000/xmlns/;");
                }
            } else if (str3.equals("xmlns") && !str2.equals("http://www.w3.org/2000/xmlns/")) {
                throw new NamespaceErr("Invalid namespace - uri is not 'http://www.w3.org/2000/xmlns/;");
            }
        } else if (Locale.beginsWithXml(str)) {
            throw new NamespaceErr("Invalid prefix - begins with 'xml'");
        }
        return str;
    }

    private static void validateName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Name is null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("Name is empty");
        }
        if (!XMLChar.isValidName(str)) {
            throw new InvalidCharacterError("Name has an invalid character");
        }
    }

    private static void validateNcName(String str) {
        if (str != null && str.length() > 0 && !XMLChar.isValidNCName(str)) {
            throw new InvalidCharacterError();
        }
    }

    private static void validateQualifiedName(String str, String str2, boolean z) {
        if (!$assertionsDisabled && str == null) {
            throw new AssertionError();
        }
        if (str2 == null) {
            str2 = "";
        }
        int indexOf = str.indexOf(58);
        if (indexOf < 0) {
            validateNcName(str);
            if (z && str.equals("xmlns") && !str2.equals("http://www.w3.org/2000/xmlns/")) {
                throw new NamespaceErr("Default xmlns attribute does not have namespace: http://www.w3.org/2000/xmlns/");
            }
        } else {
            if (indexOf == 0) {
                throw new NamespaceErr("Invalid qualified name, no prefix specified");
            }
            String substring = str.substring(0, indexOf);
            validateNcName(substring);
            if (str2.length() == 0) {
                throw new NamespaceErr("Attempt to give a prefix for no namespace");
            }
            str = str.substring(indexOf + 1);
            if (str.indexOf(58) >= 0) {
                throw new NamespaceErr("Invalid qualified name, more than one colon");
            }
            validateNcName(str);
            if (substring.equals("xml") && !str2.equals("http://www.w3.org/XML/1998/namespace")) {
                throw new NamespaceErr("Invalid prefix - begins with 'xml'");
            }
        }
        if (str.length() == 0) {
            throw new NamespaceErr("Invalid qualified name, no local part specified");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void removeNode(Dom dom) {
        CharNode charNodes;
        if (!$assertionsDisabled && (dom.nodeType() == 3 || dom.nodeType() == 4)) {
            throw new AssertionError();
        }
        Cur tempCur = dom.tempCur();
        tempCur.toEnd();
        if (tempCur.next() && (charNodes = tempCur.getCharNodes()) != null) {
            tempCur.setCharNodes(null);
            Cur tempCur2 = dom.tempCur();
            tempCur2.setCharNodes(CharNode.appendNodes(tempCur2.getCharNodes(), charNodes));
            tempCur2.release();
        }
        tempCur.release();
        Cur.moveNode((Xobj) dom, null);
    }

    private static abstract class ElementsNodeList implements NodeList {
        static final /* synthetic */ boolean $assertionsDisabled;
        private ArrayList _elements;
        private Locale _locale;
        private Dom _root;
        private long _version;

        protected abstract boolean match(Dom dom);

        static {
            if (DomImpl.class$org$apache$xmlbeans$impl$store$DomImpl == null) {
                DomImpl.class$org$apache$xmlbeans$impl$store$DomImpl = DomImpl.class$("org.apache.xmlbeans.impl.store.DomImpl");
            } else {
                Class cls = DomImpl.class$org$apache$xmlbeans$impl$store$DomImpl;
            }
            $assertionsDisabled = true;
        }

        ElementsNodeList(Dom dom) {
            if (!$assertionsDisabled && dom.nodeType() != 9 && dom.nodeType() != 1) {
                throw new AssertionError();
            }
            this._root = dom;
            this._locale = dom.locale();
            this._version = 0L;
        }

        @Override // org.w3c.dom.NodeList
        public int getLength() {
            ensureElements();
            return this._elements.size();
        }

        @Override // org.w3c.dom.NodeList
        public Node item(int i) {
            ensureElements();
            return (Node) ((i < 0 || i >= this._elements.size()) ? null : this._elements.get(i));
        }

        private void ensureElements() {
            if (this._version == this._locale.version()) {
                return;
            }
            this._version = this._locale.version();
            this._elements = new ArrayList();
            Locale locale = this._locale;
            if (locale.noSync()) {
                locale.enter();
                try {
                    addElements(this._root);
                } finally {
                }
            } else {
                synchronized (locale) {
                    locale.enter();
                    try {
                        addElements(this._root);
                    } finally {
                    }
                }
            }
        }

        private void addElements(Dom dom) {
            for (Dom firstChild = DomImpl.firstChild(dom); firstChild != null; firstChild = DomImpl.nextSibling(firstChild)) {
                if (firstChild.nodeType() == 1) {
                    if (match(firstChild)) {
                        this._elements.add(firstChild);
                    }
                    addElements(firstChild);
                }
            }
        }
    }

    private static class ElementsByTagNameNodeList extends ElementsNodeList {
        private String _name;

        ElementsByTagNameNodeList(Dom dom, String str) {
            super(dom);
            this._name = str;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.ElementsNodeList
        protected boolean match(Dom dom) {
            if (this._name.equals(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) {
                return true;
            }
            return DomImpl._node_getNodeName(dom).equals(this._name);
        }
    }

    private static class ElementsByTagNameNSNodeList extends ElementsNodeList {
        private String _local;
        private String _uri;

        ElementsByTagNameNSNodeList(Dom dom, String str, String str2) {
            super(dom);
            this._uri = str == null ? "" : str;
            this._local = str2;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.ElementsNodeList
        protected boolean match(Dom dom) {
            if (!this._uri.equals(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD) && !DomImpl._node_getNamespaceURI(dom).equals(this._uri)) {
                return false;
            }
            if (this._local.equals(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) {
                return true;
            }
            return DomImpl._node_getLocalName(dom).equals(this._local);
        }
    }

    public static Document _domImplementation_createDocument(Locale locale, String str, String str2, DocumentType documentType) {
        Document domImplementation_createDocument;
        if (locale.noSync()) {
            locale.enter();
            try {
                return domImplementation_createDocument(locale, str, str2, documentType);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                domImplementation_createDocument = domImplementation_createDocument(locale, str, str2, documentType);
            } finally {
            }
        }
        return domImplementation_createDocument;
    }

    public static Document domImplementation_createDocument(Locale locale, String str, String str2, DocumentType documentType) {
        validateQualifiedName(str2, str, false);
        Cur tempCur = locale.tempCur();
        tempCur.createDomDocumentRoot();
        Document document = (Document) tempCur.getDom();
        tempCur.next();
        tempCur.createElement(locale.makeQualifiedQName(str, str2));
        if (documentType != null) {
            throw new RuntimeException("Not impl");
        }
        tempCur.toParent();
        try {
            Locale.autoTypeDocument(tempCur, null, null);
            tempCur.release();
            return document;
        } catch (XmlException e) {
            throw new XmlRuntimeException(e);
        }
    }

    public static boolean _domImplementation_hasFeature(Locale locale, String str, String str2) {
        if (str == null) {
            return false;
        }
        if (str2 == null || str2.length() <= 0 || str2.equals("1.0") || str2.equals("2.0")) {
            return str.equalsIgnoreCase("core") || str.equalsIgnoreCase("xml");
        }
        return false;
    }

    public static Element _document_getDocumentElement(Dom dom) {
        Dom document_getDocumentElement;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                document_getDocumentElement = document_getDocumentElement(dom);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    document_getDocumentElement = document_getDocumentElement(dom);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Element) document_getDocumentElement;
    }

    public static Dom document_getDocumentElement(Dom dom) {
        for (Dom firstChild = firstChild(dom); firstChild != null; firstChild = nextSibling(firstChild)) {
            if (firstChild.nodeType() == 1) {
                return firstChild;
            }
        }
        return null;
    }

    public static DocumentFragment _document_createDocumentFragment(Dom dom) {
        Dom document_createDocumentFragment;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                document_createDocumentFragment = document_createDocumentFragment(dom);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    document_createDocumentFragment = document_createDocumentFragment(dom);
                    locale.exit();
                } finally {
                }
            }
        }
        return (DocumentFragment) document_createDocumentFragment;
    }

    public static Dom document_createDocumentFragment(Dom dom) {
        Cur tempCur = dom.locale().tempCur();
        tempCur.createDomDocFragRoot();
        Dom dom2 = tempCur.getDom();
        tempCur.release();
        return dom2;
    }

    public static Element _document_createElement(Dom dom, String str) {
        Dom document_createElement;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                document_createElement = document_createElement(dom, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    document_createElement = document_createElement(dom, str);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Element) document_createElement;
    }

    public static Dom document_createElement(Dom dom, String str) {
        validateName(str);
        Locale locale = dom.locale();
        Cur tempCur = locale.tempCur();
        tempCur.createElement(locale.makeQualifiedQName("", str));
        Dom dom2 = tempCur.getDom();
        tempCur.release();
        ((Xobj.ElementXobj) dom2)._canHavePrefixUri = false;
        return dom2;
    }

    public static Element _document_createElementNS(Dom dom, String str, String str2) {
        Dom document_createElementNS;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                document_createElementNS = document_createElementNS(dom, str, str2);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    document_createElementNS = document_createElementNS(dom, str, str2);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Element) document_createElementNS;
    }

    public static Dom document_createElementNS(Dom dom, String str, String str2) {
        validateQualifiedName(str2, str, false);
        Locale locale = dom.locale();
        Cur tempCur = locale.tempCur();
        tempCur.createElement(locale.makeQualifiedQName(str, str2));
        Dom dom2 = tempCur.getDom();
        tempCur.release();
        return dom2;
    }

    public static Attr _document_createAttribute(Dom dom, String str) {
        Dom document_createAttribute;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                document_createAttribute = document_createAttribute(dom, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    document_createAttribute = document_createAttribute(dom, str);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Attr) document_createAttribute;
    }

    public static Dom document_createAttribute(Dom dom, String str) {
        validateName(str);
        Locale locale = dom.locale();
        Cur tempCur = locale.tempCur();
        tempCur.createAttr(locale.makeQualifiedQName("", str));
        Dom dom2 = tempCur.getDom();
        tempCur.release();
        ((Xobj.AttrXobj) dom2)._canHavePrefixUri = false;
        return dom2;
    }

    public static Attr _document_createAttributeNS(Dom dom, String str, String str2) {
        Dom document_createAttributeNS;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                document_createAttributeNS = document_createAttributeNS(dom, str, str2);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    document_createAttributeNS = document_createAttributeNS(dom, str, str2);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Attr) document_createAttributeNS;
    }

    public static Dom document_createAttributeNS(Dom dom, String str, String str2) {
        validateQualifiedName(str2, str, true);
        Locale locale = dom.locale();
        Cur tempCur = locale.tempCur();
        tempCur.createAttr(locale.makeQualifiedQName(str, str2));
        Dom dom2 = tempCur.getDom();
        tempCur.release();
        return dom2;
    }

    public static Comment _document_createComment(Dom dom, String str) {
        Dom document_createComment;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                document_createComment = document_createComment(dom, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    document_createComment = document_createComment(dom, str);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Comment) document_createComment;
    }

    public static Dom document_createComment(Dom dom, String str) {
        Cur tempCur = dom.locale().tempCur();
        tempCur.createComment();
        Dom dom2 = tempCur.getDom();
        if (str != null) {
            tempCur.next();
            tempCur.insertString(str);
        }
        tempCur.release();
        return dom2;
    }

    public static ProcessingInstruction _document_createProcessingInstruction(Dom dom, String str, String str2) {
        Dom document_createProcessingInstruction;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                document_createProcessingInstruction = document_createProcessingInstruction(dom, str, str2);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    document_createProcessingInstruction = document_createProcessingInstruction(dom, str, str2);
                    locale.exit();
                } finally {
                }
            }
        }
        return (ProcessingInstruction) document_createProcessingInstruction;
    }

    public static Dom document_createProcessingInstruction(Dom dom, String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Target is null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("Target is empty");
        }
        if (!XMLChar.isValidName(str)) {
            throw new InvalidCharacterError("Target has an invalid character");
        }
        if (Locale.beginsWithXml(str) && str.length() == 3) {
            throw new InvalidCharacterError("Invalid target - is 'xml'");
        }
        Cur tempCur = dom.locale().tempCur();
        tempCur.createProcinst(str);
        Dom dom2 = tempCur.getDom();
        if (str2 != null) {
            tempCur.next();
            tempCur.insertString(str2);
        }
        tempCur.release();
        return dom2;
    }

    public static CDATASection _document_createCDATASection(Dom dom, String str) {
        return (CDATASection) document_createCDATASection(dom, str);
    }

    public static Dom document_createCDATASection(Dom dom, String str) {
        CdataNode createCdataNode = dom.locale().createCdataNode();
        if (str == null) {
            str = "";
        }
        createCdataNode.setChars(str, 0, str.length());
        return createCdataNode;
    }

    public static Text _document_createTextNode(Dom dom, String str) {
        return (Text) document_createTextNode(dom, str);
    }

    public static CharNode document_createTextNode(Dom dom, String str) {
        TextNode createTextNode = dom.locale().createTextNode();
        if (str == null) {
            str = "";
        }
        createTextNode.setChars(str, 0, str.length());
        return createTextNode;
    }

    public static EntityReference _document_createEntityReference(Dom dom, String str) {
        throw new RuntimeException("Not implemented");
    }

    public static Element _document_getElementById(Dom dom, String str) {
        throw new RuntimeException("Not implemented");
    }

    public static NodeList _document_getElementsByTagName(Dom dom, String str) {
        NodeList document_getElementsByTagName;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return document_getElementsByTagName(dom, str);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                document_getElementsByTagName = document_getElementsByTagName(dom, str);
            } finally {
            }
        }
        return document_getElementsByTagName;
    }

    public static NodeList document_getElementsByTagName(Dom dom, String str) {
        return new ElementsByTagNameNodeList(dom, str);
    }

    public static NodeList _document_getElementsByTagNameNS(Dom dom, String str, String str2) {
        NodeList document_getElementsByTagNameNS;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return document_getElementsByTagNameNS(dom, str, str2);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                document_getElementsByTagNameNS = document_getElementsByTagNameNS(dom, str, str2);
            } finally {
            }
        }
        return document_getElementsByTagNameNS;
    }

    public static NodeList document_getElementsByTagNameNS(Dom dom, String str, String str2) {
        return new ElementsByTagNameNSNodeList(dom, str, str2);
    }

    public static DOMImplementation _document_getImplementation(Dom dom) {
        return dom.locale();
    }

    public static Node _document_importNode(Dom dom, Node node, boolean z) {
        Dom document_importNode;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                document_importNode = document_importNode(dom, node, z);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    document_importNode = document_importNode(dom, node, z);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Node) document_importNode;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.apache.xmlbeans.impl.store.DomImpl.Dom document_importNode(org.apache.xmlbeans.impl.store.DomImpl.Dom r7, org.w3c.dom.Node r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.store.DomImpl.document_importNode(org.apache.xmlbeans.impl.store.DomImpl$Dom, org.w3c.dom.Node, boolean):org.apache.xmlbeans.impl.store.DomImpl$Dom");
    }

    public static DocumentType _document_getDoctype(Dom dom) {
        Dom document_getDoctype;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                document_getDoctype = document_getDoctype(dom);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    document_getDoctype = document_getDoctype(dom);
                    locale.exit();
                } finally {
                }
            }
        }
        return (DocumentType) document_getDoctype;
    }

    public static Document _node_getOwnerDocument(Dom dom) {
        Dom node_getOwnerDocument;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                node_getOwnerDocument = node_getOwnerDocument(dom);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    node_getOwnerDocument = node_getOwnerDocument(dom);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Document) node_getOwnerDocument;
    }

    public static Dom node_getOwnerDocument(Dom dom) {
        if (dom.nodeType() == 9) {
            return null;
        }
        Locale locale = dom.locale();
        if (locale._ownerDoc == null) {
            Cur tempCur = locale.tempCur();
            tempCur.createDomDocumentRoot();
            locale._ownerDoc = tempCur.getDom();
            tempCur.release();
        }
        return locale._ownerDoc;
    }

    public static Node _node_getParentNode(Dom dom) {
        Dom node_getParentNode;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                node_getParentNode = node_getParentNode(dom);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    node_getParentNode = node_getParentNode(dom);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Node) node_getParentNode;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.apache.xmlbeans.impl.store.DomImpl.Dom node_getParentNode(org.apache.xmlbeans.impl.store.DomImpl.Dom r3) {
        /*
            int r0 = r3.nodeType()
            java.lang.String r1 = "Not impl"
            r2 = 0
            switch(r0) {
                case 1: goto L2a;
                case 2: goto L28;
                case 3: goto L1e;
                case 4: goto L1e;
                case 5: goto L18;
                case 6: goto L12;
                case 7: goto L2a;
                case 8: goto L2a;
                case 9: goto L28;
                case 10: goto L12;
                case 11: goto L28;
                case 12: goto L12;
                default: goto La;
            }
        La:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            java.lang.String r0 = "Unknown kind"
            r3.<init>(r0)
            throw r3
        L12:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            r3.<init>(r1)
            throw r3
        L18:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            r3.<init>(r1)
            throw r3
        L1e:
            org.apache.xmlbeans.impl.store.Cur r3 = r3.tempCur()
            if (r3 == 0) goto L38
            r3.toParent()
            goto L38
        L28:
            r3 = r2
            goto L38
        L2a:
            org.apache.xmlbeans.impl.store.Cur r3 = r3.tempCur()
            boolean r0 = r3.toParentRaw()
            if (r0 != 0) goto L38
            r3.release()
            goto L28
        L38:
            if (r3 != 0) goto L3b
            return r2
        L3b:
            org.apache.xmlbeans.impl.store.DomImpl$Dom r0 = r3.getDom()
            r3.release()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.store.DomImpl.node_getParentNode(org.apache.xmlbeans.impl.store.DomImpl$Dom):org.apache.xmlbeans.impl.store.DomImpl$Dom");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Node _node_getFirstChild(Dom dom) {
        Dom node_getFirstChild;
        Locale locale = dom.locale();
        if (!$assertionsDisabled && !(dom instanceof Xobj)) {
            throw new AssertionError();
        }
        Xobj xobj = (Xobj) dom;
        if (!xobj.isVacant()) {
            if (xobj.isFirstChildPtrDomUsable()) {
                return (Node) xobj._firstChild;
            }
            Xobj lastAttr = xobj.lastAttr();
            if (lastAttr != null && lastAttr.isNextSiblingPtrDomUsable()) {
                return (Xobj.NodeXobj) lastAttr._nextSibling;
            }
            if (xobj.isExistingCharNodesValueUsable()) {
                return xobj._charNodesValue;
            }
        }
        if (locale.noSync()) {
            node_getFirstChild = node_getFirstChild(dom);
        } else {
            synchronized (locale) {
                node_getFirstChild = node_getFirstChild(dom);
            }
        }
        return (Node) node_getFirstChild;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Dom node_getFirstChild(Dom dom) {
        int nodeType = dom.nodeType();
        if (nodeType != 1 && nodeType != 2) {
            if (nodeType == 5) {
                throw new RuntimeException("Not impl");
            }
            if (nodeType != 6) {
                switch (nodeType) {
                    case 9:
                    case 11:
                        break;
                    case 10:
                    case 12:
                        break;
                    default:
                        return null;
                }
            }
            throw new RuntimeException("Not impl");
        }
        Xobj xobj = (Xobj) dom;
        xobj.ensureOccupancy();
        if (xobj.isFirstChildPtrDomUsable()) {
            return (Xobj.NodeXobj) xobj._firstChild;
        }
        Xobj lastAttr = xobj.lastAttr();
        if (lastAttr != null) {
            if (lastAttr.isNextSiblingPtrDomUsable()) {
                return (Xobj.NodeXobj) lastAttr._nextSibling;
            }
            if (lastAttr.isCharNodesAfterUsable()) {
                return lastAttr._charNodesAfter;
            }
        }
        if (xobj.isCharNodesValueUsable()) {
            return xobj._charNodesValue;
        }
        return null;
    }

    public static Node _node_getLastChild(Dom dom) {
        Dom node_getLastChild;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                node_getLastChild = node_getLastChild(dom);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    node_getLastChild = node_getLastChild(dom);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Node) node_getLastChild;
    }

    public static Dom node_getLastChild(Dom dom) {
        CharNode charNodes;
        CharNode charNode = null;
        switch (dom.nodeType()) {
            case 3:
            case 4:
            case 7:
            case 8:
                return null;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 9:
            case 11:
            default:
                Cur tempCur = dom.tempCur();
                if (tempCur.toLastChild()) {
                    Dom dom2 = tempCur.getDom();
                    tempCur.skip();
                    charNodes = tempCur.getCharNodes();
                    if (charNodes == null) {
                        charNode = dom2;
                    }
                } else {
                    tempCur.next();
                    charNodes = tempCur.getCharNodes();
                }
                if (charNode == null && charNodes != null) {
                    while (charNodes._next != null) {
                        charNodes = charNodes._next;
                    }
                    charNode = charNodes;
                }
                tempCur.release();
                return charNode;
        }
    }

    public static Node _node_getNextSibling(Dom dom) {
        Dom node_getNextSibling;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            node_getNextSibling = node_getNextSibling(dom);
        } else {
            synchronized (locale) {
                node_getNextSibling = node_getNextSibling(dom);
            }
        }
        return (Node) node_getNextSibling;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Dom node_getNextSibling(Dom dom) {
        switch (dom.nodeType()) {
            case 1:
            case 7:
            case 8:
                if (!$assertionsDisabled && !(dom instanceof Xobj)) {
                    throw new AssertionError("PI, Comments and Elements always backed up by Xobj");
                }
                Xobj xobj = (Xobj) dom;
                xobj.ensureOccupancy();
                if (xobj.isNextSiblingPtrDomUsable()) {
                    return (Xobj.NodeXobj) xobj._nextSibling;
                }
                if (xobj.isCharNodesAfterUsable()) {
                    return xobj._charNodesAfter;
                }
                return null;
            case 2:
            case 9:
            case 11:
            default:
                return null;
            case 3:
            case 4:
                CharNode charNode = (CharNode) dom;
                if (!(charNode._src instanceof Xobj)) {
                    return null;
                }
                Xobj xobj2 = (Xobj) charNode._src;
                xobj2._charNodesAfter = Cur.updateCharNodes(xobj2._locale, xobj2, xobj2._charNodesAfter, xobj2._cchAfter);
                xobj2._charNodesValue = Cur.updateCharNodes(xobj2._locale, xobj2, xobj2._charNodesValue, xobj2._cchValue);
                if (charNode._next != null) {
                    return charNode._next;
                }
                if (charNode.isNodeAftertext()) {
                    return (Xobj.NodeXobj) xobj2._nextSibling;
                }
                return (Xobj.NodeXobj) xobj2._firstChild;
            case 5:
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not implemented");
        }
    }

    public static Node _node_getPreviousSibling(Dom dom) {
        Dom node_getPreviousSibling;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            node_getPreviousSibling = node_getPreviousSibling(dom);
        } else {
            synchronized (locale) {
                node_getPreviousSibling = node_getPreviousSibling(dom);
            }
        }
        return (Node) node_getPreviousSibling;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x006e -> B:17:0x0066). Please report as a decompilation issue!!! */
    public static Dom node_getPreviousSibling(Dom dom) {
        Dom dom2;
        int nodeType = dom.nodeType();
        if (nodeType == 3 || nodeType == 4) {
            if (!$assertionsDisabled && !(dom instanceof CharNode)) {
                throw new AssertionError("Text/CData should be a CharNode");
            }
            CharNode charNode = (CharNode) dom;
            if (!(charNode._src instanceof Xobj)) {
                return null;
            }
            Xobj xobj = (Xobj) charNode._src;
            xobj.ensureOccupancy();
            boolean isNodeAftertext = charNode.isNodeAftertext();
            Dom dom3 = charNode._prev;
            if (dom3 == null) {
                if (isNodeAftertext) {
                    dom2 = (Dom) xobj;
                } else {
                    dom3 = xobj._charNodesValue;
                }
            }
            dom2 = dom3;
        } else {
            if (!$assertionsDisabled && !(dom instanceof Xobj)) {
                throw new AssertionError();
            }
            Xobj xobj2 = (Xobj) dom;
            dom2 = (Dom) xobj2._prevSibling;
            if (dom2 == null && xobj2._parent != null) {
                dom2 = node_getFirstChild((Dom) xobj2._parent);
            }
        }
        if (dom2 != null || (dom3 = node_getNextSibling(dom2)) == dom) {
            return dom2;
        }
        dom2 = dom3;
        if (dom2 != null) {
        }
        return dom2;
    }

    public static boolean _node_hasAttributes(Dom dom) {
        boolean node_hasAttributes;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return node_hasAttributes(dom);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                node_hasAttributes = node_hasAttributes(dom);
            } finally {
            }
        }
        return node_hasAttributes;
    }

    public static boolean node_hasAttributes(Dom dom) {
        if (dom.nodeType() != 1) {
            return false;
        }
        Cur tempCur = dom.tempCur();
        boolean hasAttrs = tempCur.hasAttrs();
        tempCur.release();
        return hasAttrs;
    }

    public static boolean _node_isSupported(Dom dom, String str, String str2) {
        return _domImplementation_hasFeature(dom.locale(), str, str2);
    }

    public static void _node_normalize(Dom dom) {
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                node_normalize(dom);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    node_normalize(dom);
                } finally {
                }
            }
        }
    }

    public static void node_normalize(Dom dom) {
        switch (dom.nodeType()) {
            case 3:
            case 4:
            case 7:
            case 8:
                return;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 9:
            case 11:
            default:
                Cur tempCur = dom.tempCur();
                tempCur.push();
                do {
                    tempCur.nextWithAttrs();
                    CharNode charNodes = tempCur.getCharNodes();
                    if (charNodes != null) {
                        if (!tempCur.isText()) {
                            while (charNodes != null) {
                                charNodes.setChars(null, 0, 0);
                                charNodes = CharNode.remove(charNodes, charNodes);
                            }
                        } else if (charNodes._next != null) {
                            while (charNodes._next != null) {
                                charNodes.setChars(null, 0, 0);
                                charNodes = CharNode.remove(charNodes, charNodes._next);
                            }
                            charNodes._cch = Integer.MAX_VALUE;
                        }
                        tempCur.setCharNodes(charNodes);
                    }
                } while (!tempCur.isAtEndOfLastPush());
                tempCur.release();
                dom.locale().invalidateDomCaches(dom);
                return;
        }
    }

    public static boolean _node_hasChildNodes(Dom dom) {
        return _node_getFirstChild(dom) != null;
    }

    public static Node _node_appendChild(Dom dom, Node node) {
        return _node_insertBefore(dom, node, null);
    }

    public static Node _node_replaceChild(Dom dom, Node node, Node node2) {
        Dom node_replaceChild;
        Locale locale = dom.locale();
        if (node == null) {
            throw new IllegalArgumentException("Child to add is null");
        }
        if (node2 == null) {
            throw new NotFoundErr("Child to replace is null");
        }
        if (node instanceof Dom) {
            Dom dom2 = (Dom) node;
            if (dom2.locale() == locale) {
                if (node2 instanceof Dom) {
                    Dom dom3 = (Dom) node2;
                    if (dom3.locale() == locale) {
                        if (locale.noSync()) {
                            locale.enter();
                            try {
                                node_replaceChild = node_replaceChild(dom, dom2, dom3);
                            } finally {
                            }
                        } else {
                            synchronized (locale) {
                                locale.enter();
                                try {
                                    node_replaceChild = node_replaceChild(dom, dom2, dom3);
                                    locale.exit();
                                } finally {
                                }
                            }
                        }
                        return (Node) node_replaceChild;
                    }
                }
                throw new WrongDocumentErr("Child to replace is from another document");
            }
        }
        throw new WrongDocumentErr("Child to add is from another document");
    }

    public static Dom node_replaceChild(Dom dom, Dom dom2, Dom dom3) {
        Dom node_getNextSibling = node_getNextSibling(dom3);
        node_removeChild(dom, dom3);
        try {
            node_insertBefore(dom, dom2, node_getNextSibling);
            return dom3;
        } catch (DOMException e) {
            node_insertBefore(dom, dom3, node_getNextSibling);
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        if (r1.locale() == r0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.w3c.dom.Node _node_insertBefore(org.apache.xmlbeans.impl.store.DomImpl.Dom r2, org.w3c.dom.Node r3, org.w3c.dom.Node r4) {
        /*
            org.apache.xmlbeans.impl.store.Locale r0 = r2.locale()
            if (r3 == 0) goto L60
            boolean r1 = r3 instanceof org.apache.xmlbeans.impl.store.DomImpl.Dom
            if (r1 == 0) goto L58
            org.apache.xmlbeans.impl.store.DomImpl$Dom r3 = (org.apache.xmlbeans.impl.store.DomImpl.Dom) r3
            org.apache.xmlbeans.impl.store.Locale r1 = r3.locale()
            if (r1 != r0) goto L58
            r1 = 0
            if (r4 == 0) goto L2b
            boolean r1 = r4 instanceof org.apache.xmlbeans.impl.store.DomImpl.Dom
            if (r1 == 0) goto L23
            r1 = r4
            org.apache.xmlbeans.impl.store.DomImpl$Dom r1 = (org.apache.xmlbeans.impl.store.DomImpl.Dom) r1
            org.apache.xmlbeans.impl.store.Locale r4 = r1.locale()
            if (r4 != r0) goto L23
            goto L2b
        L23:
            org.apache.xmlbeans.impl.store.DomImpl$WrongDocumentErr r2 = new org.apache.xmlbeans.impl.store.DomImpl$WrongDocumentErr
            java.lang.String r3 = "Reference child is from another document"
            r2.<init>(r3)
            throw r2
        L2b:
            boolean r4 = r0.noSync()
            if (r4 == 0) goto L41
            r0.enter()
            org.apache.xmlbeans.impl.store.DomImpl$Dom r2 = node_insertBefore(r2, r3, r1)     // Catch: java.lang.Throwable -> L3c
            r0.exit()
            goto L4d
        L3c:
            r2 = move-exception
            r0.exit()
            throw r2
        L41:
            monitor-enter(r0)
            r0.enter()     // Catch: java.lang.Throwable -> L55
            org.apache.xmlbeans.impl.store.DomImpl$Dom r2 = node_insertBefore(r2, r3, r1)     // Catch: java.lang.Throwable -> L50
            r0.exit()     // Catch: java.lang.Throwable -> L55
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L55
        L4d:
            org.w3c.dom.Node r2 = (org.w3c.dom.Node) r2
            return r2
        L50:
            r2 = move-exception
            r0.exit()     // Catch: java.lang.Throwable -> L55
            throw r2     // Catch: java.lang.Throwable -> L55
        L55:
            r2 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L55
            throw r2
        L58:
            org.apache.xmlbeans.impl.store.DomImpl$WrongDocumentErr r2 = new org.apache.xmlbeans.impl.store.DomImpl$WrongDocumentErr
            java.lang.String r3 = "Child to add is from another document"
            r2.<init>(r3)
            throw r2
        L60:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Child to add is null"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.store.DomImpl._node_insertBefore(org.apache.xmlbeans.impl.store.DomImpl$Dom, org.w3c.dom.Node, org.w3c.dom.Node):org.w3c.dom.Node");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Dom node_insertBefore(Dom dom, Dom dom2, Dom dom3) {
        boolean z = $assertionsDisabled;
        if (!z && dom2 == 0) {
            throw new AssertionError();
        }
        if (dom2 == dom3) {
            return dom2;
        }
        if (dom3 != null && parent(dom3) != dom) {
            throw new NotFoundErr("RefChild is not a child of this node");
        }
        int nodeType = dom2.nodeType();
        if (nodeType == 11) {
            for (Dom firstChild = firstChild(dom2); firstChild != null; firstChild = nextSibling(firstChild)) {
                validateNewChild(dom, firstChild);
            }
            Dom firstChild2 = firstChild(dom2);
            while (firstChild2 != null) {
                Dom nextSibling = nextSibling(firstChild2);
                if (dom3 == null) {
                    append(firstChild2, dom);
                } else {
                    insert(firstChild2, dom3);
                }
                firstChild2 = nextSibling;
            }
            return dom2;
        }
        validateNewChild(dom, dom2);
        remove(dom2);
        int nodeType2 = dom.nodeType();
        if (!z && nodeType2 != 2 && nodeType2 != 11 && nodeType2 != 9 && nodeType2 != 1) {
            throw new AssertionError();
        }
        if (nodeType != 1) {
            if (nodeType == 10) {
                throw new RuntimeException("Not implemented");
            }
            if (nodeType == 3 || nodeType == 4) {
                CharNode charNode = (CharNode) dom2;
                if (!z && (charNode._prev != null || charNode._next != null)) {
                    throw new AssertionError();
                }
                CharNode charNode2 = null;
                Cur tempCur = dom.tempCur();
                if (dom3 == null) {
                    tempCur.toEnd();
                } else {
                    int nodeType3 = dom3.nodeType();
                    if (nodeType3 == 3 || nodeType3 == 4) {
                        charNode2 = (CharNode) dom3;
                        tempCur.moveToCharNode(charNode2);
                    } else {
                        if (nodeType3 == 5) {
                            throw new RuntimeException("Not implemented");
                        }
                        tempCur.moveToDom(dom3);
                    }
                }
                CharNode insertNode = CharNode.insertNode(tempCur.getCharNodes(), charNode, charNode2);
                tempCur.insertChars(charNode._src, charNode._off, charNode._cch);
                tempCur.setCharNodes(insertNode);
                tempCur.release();
                return dom2;
            }
            if (nodeType == 5) {
                throw new RuntimeException("Not implemented");
            }
            if (nodeType != 7 && nodeType != 8) {
                throw new RuntimeException("Unexpected child node type");
            }
        }
        if (dom3 == null) {
            Cur tempCur2 = dom.tempCur();
            tempCur2.toEnd();
            Cur.moveNode((Xobj) dom2, tempCur2);
            tempCur2.release();
        } else {
            int nodeType4 = dom3.nodeType();
            if (nodeType4 == 3 || nodeType4 == 4) {
                ArrayList arrayList = new ArrayList();
                while (dom3 != null && (dom3.nodeType() == 3 || dom3.nodeType() == 4)) {
                    Dom nextSibling2 = nextSibling(dom3);
                    arrayList.add(remove(dom3));
                    dom3 = nextSibling2;
                }
                if (dom3 == null) {
                    append(dom2, dom);
                } else {
                    insert(dom2, dom3);
                }
                Dom nextSibling3 = nextSibling(dom2);
                for (int i = 0; i < arrayList.size(); i++) {
                    Dom dom4 = (Dom) arrayList.get(i);
                    if (nextSibling3 == null) {
                        append(dom4, dom);
                    } else {
                        insert(dom4, nextSibling3);
                    }
                }
            } else {
                if (nodeType4 == 5) {
                    throw new RuntimeException("Not implemented");
                }
                if (!z && nodeType4 != 1 && nodeType4 != 7 && nodeType4 != 8) {
                    throw new AssertionError();
                }
                Cur tempCur3 = dom3.tempCur();
                Cur.moveNode((Xobj) dom2, tempCur3);
                tempCur3.release();
            }
        }
        return dom2;
    }

    public static Node _node_removeChild(Dom dom, Node node) {
        Dom node_removeChild;
        Locale locale = dom.locale();
        if (node == null) {
            throw new NotFoundErr("Child to remove is null");
        }
        if (node instanceof Dom) {
            Dom dom2 = (Dom) node;
            if (dom2.locale() == locale) {
                if (locale.noSync()) {
                    locale.enter();
                    try {
                        node_removeChild = node_removeChild(dom, dom2);
                    } finally {
                    }
                } else {
                    synchronized (locale) {
                        locale.enter();
                        try {
                            node_removeChild = node_removeChild(dom, dom2);
                            locale.exit();
                        } finally {
                        }
                    }
                }
                return (Node) node_removeChild;
            }
        }
        throw new WrongDocumentErr("Child to remove is from another document");
    }

    public static Dom node_removeChild(Dom dom, Dom dom2) {
        if (parent(dom2) != dom) {
            throw new NotFoundErr("Child to remove is not a child of given parent");
        }
        switch (dom2.nodeType()) {
            case 1:
            case 7:
            case 8:
                removeNode(dom2);
                return dom2;
            case 2:
            case 9:
            case 11:
                throw new IllegalStateException();
            case 3:
            case 4:
                Cur tempCur = dom2.tempCur();
                CharNode charNodes = tempCur.getCharNodes();
                CharNode charNode = (CharNode) dom2;
                if (!$assertionsDisabled && !(charNode._src instanceof Dom)) {
                    throw new AssertionError();
                }
                charNode.setChars(tempCur.moveChars(null, charNode._cch), tempCur._offSrc, tempCur._cchSrc);
                tempCur.setCharNodes(CharNode.remove(charNodes, charNode));
                tempCur.release();
                return dom2;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            default:
                throw new RuntimeException("Unknown kind");
        }
    }

    public static Node _node_cloneNode(Dom dom, boolean z) {
        Dom node_cloneNode;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                node_cloneNode = node_cloneNode(dom, z);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    node_cloneNode = node_cloneNode(dom, z);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Node) node_cloneNode;
    }

    public static Dom node_cloneNode(Dom dom, boolean z) {
        Cur tempCur;
        Locale locale = dom.locale();
        Dom dom2 = null;
        if (!z) {
            int nodeType = dom.nodeType();
            if (nodeType == 1) {
                tempCur = locale.tempCur();
                tempCur.createElement(dom.getQName());
                Element element = (Element) tempCur.getDom();
                NamedNodeMap attributes = ((Element) dom).getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    element.setAttributeNodeNS((Attr) attributes.item(i).cloneNode(true));
                }
            } else if (nodeType == 2) {
                tempCur = locale.tempCur();
                tempCur.createAttr(dom.getQName());
            } else if (nodeType == 9) {
                tempCur = locale.tempCur();
                tempCur.createDomDocumentRoot();
            } else if (nodeType != 11) {
                tempCur = null;
            } else {
                tempCur = locale.tempCur();
                tempCur.createDomDocFragRoot();
            }
            if (tempCur != null) {
                dom2 = tempCur.getDom();
                tempCur.release();
            }
        }
        if (dom2 != null) {
            return dom2;
        }
        switch (dom.nodeType()) {
            case 1:
            case 2:
            case 7:
            case 8:
            case 9:
            case 11:
                Cur tempCur2 = locale.tempCur();
                Cur tempCur3 = dom.tempCur();
                tempCur3.copyNode(tempCur2);
                Dom dom3 = tempCur2.getDom();
                tempCur2.release();
                tempCur3.release();
                return dom3;
            case 3:
            case 4:
                Cur tempCur4 = dom.tempCur();
                TextNode createTextNode = dom.nodeType() == 3 ? locale.createTextNode() : locale.createCdataNode();
                createTextNode.setChars(tempCur4.getChars(((CharNode) dom)._cch), tempCur4._offSrc, tempCur4._cchSrc);
                tempCur4.release();
                return createTextNode;
            case 5:
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            default:
                throw new RuntimeException("Unknown kind");
        }
    }

    public static String _node_getLocalName(Dom dom) {
        if (!dom.nodeCanHavePrefixUri()) {
            return null;
        }
        QName qName = dom.getQName();
        return qName == null ? "" : qName.getLocalPart();
    }

    public static String _node_getNamespaceURI(Dom dom) {
        if (!dom.nodeCanHavePrefixUri()) {
            return null;
        }
        QName qName = dom.getQName();
        return qName == null ? "" : qName.getNamespaceURI();
    }

    public static void _node_setPrefix(Dom dom, String str) {
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                node_setPrefix(dom, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    node_setPrefix(dom, str);
                } finally {
                }
            }
        }
    }

    public static void node_setPrefix(Dom dom, String str) {
        if (dom.nodeType() == 1 || dom.nodeType() == 2) {
            Cur tempCur = dom.tempCur();
            QName name = tempCur.getName();
            String namespaceURI = name.getNamespaceURI();
            String localPart = name.getLocalPart();
            tempCur.setName(dom.locale().makeQName(namespaceURI, localPart, validatePrefix(str, namespaceURI, localPart, dom.nodeType() == 2)));
            tempCur.release();
            return;
        }
        validatePrefix(str, "", "", false);
    }

    public static String _node_getPrefix(Dom dom) {
        if (!dom.nodeCanHavePrefixUri()) {
            return null;
        }
        QName qName = dom.getQName();
        return qName == null ? "" : qName.getPrefix();
    }

    public static String _node_getNodeName(Dom dom) {
        switch (dom.nodeType()) {
            case 1:
            case 2:
                QName qName = dom.getQName();
                String prefix = qName.getPrefix();
                return prefix.length() == 0 ? qName.getLocalPart() : new StringBuffer().append(prefix).append(":").append(qName.getLocalPart()).toString();
            case 3:
                return "#text";
            case 4:
                return "#cdata-section";
            case 5:
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 7:
                return dom.getQName().getLocalPart();
            case 8:
                return "#comment";
            case 9:
                return "#document";
            case 11:
                return "#document-fragment";
            default:
                throw new RuntimeException("Unknown node type");
        }
    }

    public static short _node_getNodeType(Dom dom) {
        return (short) dom.nodeType();
    }

    public static void _node_setNodeValue(Dom dom, String str) {
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                node_setNodeValue(dom, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    node_setNodeValue(dom, str);
                } finally {
                }
            }
        }
    }

    public static void node_setNodeValue(Dom dom, String str) {
        if (str == null) {
            str = "";
        }
        int nodeType = dom.nodeType();
        if (nodeType == 2) {
            NodeList childNodes = ((Node) dom).getChildNodes();
            while (childNodes.getLength() > 1) {
                node_removeChild(dom, (Dom) childNodes.item(1));
            }
            if (childNodes.getLength() == 0) {
                TextNode createTextNode = dom.locale().createTextNode();
                createTextNode.setChars(str, 0, str.length());
                node_insertBefore(dom, createTextNode, null);
            } else {
                if (!$assertionsDisabled && childNodes.getLength() != 1) {
                    throw new AssertionError();
                }
                childNodes.item(0).setNodeValue(str);
            }
            if (((Xobj.AttrXobj) dom).isId()) {
                Dom node_getOwnerDocument = node_getOwnerDocument(dom);
                String node_getNodeValue = node_getNodeValue(dom);
                if (node_getOwnerDocument instanceof Xobj.DocumentXobj) {
                    Xobj.DocumentXobj documentXobj = (Xobj.DocumentXobj) node_getOwnerDocument;
                    documentXobj.removeIdElement(node_getNodeValue);
                    documentXobj.addIdElement(str, attr_getOwnerElement(dom));
                    return;
                }
                return;
            }
            return;
        }
        if (nodeType == 3 || nodeType == 4) {
            CharNode charNode = (CharNode) dom;
            Cur tempCur = charNode.tempCur();
            if (tempCur != null) {
                tempCur.moveChars(null, charNode._cch);
                charNode._cch = str.length();
                tempCur.insertString(str);
                tempCur.release();
                return;
            }
            charNode.setChars(str, 0, str.length());
            return;
        }
        if (nodeType == 7 || nodeType == 8) {
            Cur tempCur2 = dom.tempCur();
            tempCur2.next();
            tempCur2.getChars(-1);
            tempCur2.moveChars(null, tempCur2._cchSrc);
            tempCur2.insertString(str);
            tempCur2.release();
        }
    }

    public static String _node_getNodeValue(Dom dom) {
        String node_getNodeValue;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            return node_getNodeValue(dom);
        }
        synchronized (locale) {
            node_getNodeValue = node_getNodeValue(dom);
        }
        return node_getNodeValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String node_getNodeValue(Dom dom) {
        int nodeType = dom.nodeType();
        if (nodeType != 2) {
            if (nodeType == 3 || nodeType == 4) {
                if (!$assertionsDisabled && !(dom instanceof CharNode)) {
                    throw new AssertionError("Text/CData should be a CharNode");
                }
                CharNode charNode = (CharNode) dom;
                if (!(charNode._src instanceof Xobj)) {
                    return CharUtil.getString(charNode._src, charNode._off, charNode._cch);
                }
                Xobj xobj = (Xobj) charNode._src;
                xobj.ensureOccupancy();
                if (charNode.isNodeAftertext()) {
                    xobj._charNodesAfter = Cur.updateCharNodes(xobj._locale, xobj, xobj._charNodesAfter, xobj._cchAfter);
                    return xobj.getCharsAfterAsString(charNode._off, charNode._cch);
                }
                xobj._charNodesValue = Cur.updateCharNodes(xobj._locale, xobj, xobj._charNodesValue, xobj._cchValue);
                return xobj.getCharsValueAsString(charNode._off, charNode._cch);
            }
            if (nodeType != 7 && nodeType != 8) {
                return null;
            }
        }
        return ((Xobj) dom).getValueAsString();
    }

    public static Object _node_getUserData(Dom dom, String str) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static Object _node_setUserData(Dom dom, String str, Object obj, UserDataHandler userDataHandler) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static Object _node_getFeature(Dom dom, String str, String str2) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static boolean _node_isEqualNode(Dom dom, Node node) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static boolean _node_isSameNode(Dom dom, Node node) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static String _node_lookupNamespaceURI(Dom dom, String str) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static boolean _node_isDefaultNamespace(Dom dom, String str) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static String _node_lookupPrefix(Dom dom, String str) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static void _node_setTextContent(Dom dom, String str) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static String _node_getTextContent(Dom dom) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static short _node_compareDocumentPosition(Dom dom, Node node) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static String _node_getBaseURI(Dom dom) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static Node _childNodes_item(Dom dom, int i) {
        Dom childNodes_item;
        Locale locale = dom.locale();
        if (i == 0) {
            return _node_getFirstChild(dom);
        }
        if (locale.noSync()) {
            childNodes_item = childNodes_item(dom, i);
        } else {
            synchronized (locale) {
                childNodes_item = childNodes_item(dom, i);
            }
        }
        return (Node) childNodes_item;
    }

    public static Dom childNodes_item(Dom dom, int i) {
        if (i < 0) {
            return null;
        }
        switch (dom.nodeType()) {
            case 3:
            case 4:
            case 7:
            case 8:
                return null;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 9:
            case 11:
            default:
                if (i == 0) {
                    return node_getFirstChild(dom);
                }
                return dom.locale().findDomNthChild(dom, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int _childNodes_getLength(Dom dom) {
        int childNodes_getLength;
        int domZeroOneChildren;
        Locale locale = dom.locale();
        if (!$assertionsDisabled && !(dom instanceof Xobj)) {
            throw new AssertionError();
        }
        Xobj xobj = (Xobj) dom;
        if (!xobj.isVacant() && (domZeroOneChildren = xobj.getDomZeroOneChildren()) < 2) {
            return domZeroOneChildren;
        }
        if (locale.noSync()) {
            return childNodes_getLength(dom);
        }
        synchronized (locale) {
            childNodes_getLength = childNodes_getLength(dom);
        }
        return childNodes_getLength;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int childNodes_getLength(Dom dom) {
        switch (dom.nodeType()) {
            case 3:
            case 4:
            case 7:
            case 8:
                return 0;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 9:
            case 11:
            default:
                if (!$assertionsDisabled && !(dom instanceof Xobj)) {
                    throw new AssertionError();
                }
                Xobj xobj = (Xobj) dom;
                xobj.ensureOccupancy();
                int domZeroOneChildren = xobj.getDomZeroOneChildren();
                return domZeroOneChildren < 2 ? domZeroOneChildren : dom.locale().domLength(dom);
        }
    }

    public static String _element_getTagName(Dom dom) {
        return _node_getNodeName(dom);
    }

    public static Attr _element_getAttributeNode(Dom dom, String str) {
        return (Attr) _attributes_getNamedItem(dom, str);
    }

    public static Attr _element_getAttributeNodeNS(Dom dom, String str, String str2) {
        return (Attr) _attributes_getNamedItemNS(dom, str, str2);
    }

    public static Attr _element_setAttributeNode(Dom dom, Attr attr) {
        return (Attr) _attributes_setNamedItem(dom, attr);
    }

    public static Attr _element_setAttributeNodeNS(Dom dom, Attr attr) {
        return (Attr) _attributes_setNamedItemNS(dom, attr);
    }

    public static String _element_getAttribute(Dom dom, String str) {
        Node _attributes_getNamedItem = _attributes_getNamedItem(dom, str);
        return _attributes_getNamedItem == null ? "" : _attributes_getNamedItem.getNodeValue();
    }

    public static String _element_getAttributeNS(Dom dom, String str, String str2) {
        Node _attributes_getNamedItemNS = _attributes_getNamedItemNS(dom, str, str2);
        return _attributes_getNamedItemNS == null ? "" : _attributes_getNamedItemNS.getNodeValue();
    }

    public static boolean _element_hasAttribute(Dom dom, String str) {
        return _attributes_getNamedItem(dom, str) != null;
    }

    public static boolean _element_hasAttributeNS(Dom dom, String str, String str2) {
        return _attributes_getNamedItemNS(dom, str, str2) != null;
    }

    public static void _element_removeAttribute(Dom dom, String str) {
        try {
            _attributes_removeNamedItem(dom, str);
        } catch (NotFoundErr unused) {
        }
    }

    public static void _element_removeAttributeNS(Dom dom, String str, String str2) {
        try {
            _attributes_removeNamedItemNS(dom, str, str2);
        } catch (NotFoundErr unused) {
        }
    }

    public static Attr _element_removeAttributeNode(Dom dom, Attr attr) {
        if (attr == null) {
            throw new NotFoundErr("Attribute to remove is null");
        }
        if (attr.getOwnerElement() != dom) {
            throw new NotFoundErr("Attribute to remove does not belong to this element");
        }
        return (Attr) _attributes_removeNamedItem(dom, attr.getNodeName());
    }

    public static void _element_setAttribute(Dom dom, String str, String str2) {
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                element_setAttribute(dom, str, str2);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    element_setAttribute(dom, str, str2);
                } finally {
                }
            }
        }
    }

    public static void element_setAttribute(Dom dom, String str, String str2) {
        Dom attributes_getNamedItem = attributes_getNamedItem(dom, str);
        if (attributes_getNamedItem == null) {
            attributes_getNamedItem = document_createAttribute(node_getOwnerDocument(dom), str);
            attributes_setNamedItem(dom, attributes_getNamedItem);
        }
        node_setNodeValue(attributes_getNamedItem, str2);
    }

    public static void _element_setAttributeNS(Dom dom, String str, String str2, String str3) {
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                element_setAttributeNS(dom, str, str2, str3);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    element_setAttributeNS(dom, str, str2, str3);
                } finally {
                }
            }
        }
    }

    public static void element_setAttributeNS(Dom dom, String str, String str2, String str3) {
        validateQualifiedName(str2, str, true);
        QName makeQualifiedQName = dom.locale().makeQualifiedQName(str, str2);
        String localPart = makeQualifiedQName.getLocalPart();
        String validatePrefix = validatePrefix(makeQualifiedQName.getPrefix(), str, localPart, true);
        Dom attributes_getNamedItemNS = attributes_getNamedItemNS(dom, str, localPart);
        if (attributes_getNamedItemNS == null) {
            attributes_getNamedItemNS = document_createAttributeNS(node_getOwnerDocument(dom), str, localPart);
            attributes_setNamedItemNS(dom, attributes_getNamedItemNS);
        }
        node_setPrefix(attributes_getNamedItemNS, validatePrefix);
        node_setNodeValue(attributes_getNamedItemNS, str3);
    }

    public static NodeList _element_getElementsByTagName(Dom dom, String str) {
        NodeList element_getElementsByTagName;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return element_getElementsByTagName(dom, str);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                element_getElementsByTagName = element_getElementsByTagName(dom, str);
            } finally {
            }
        }
        return element_getElementsByTagName;
    }

    public static NodeList element_getElementsByTagName(Dom dom, String str) {
        return new ElementsByTagNameNodeList(dom, str);
    }

    public static NodeList _element_getElementsByTagNameNS(Dom dom, String str, String str2) {
        NodeList element_getElementsByTagNameNS;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return element_getElementsByTagNameNS(dom, str, str2);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                element_getElementsByTagNameNS = element_getElementsByTagNameNS(dom, str, str2);
            } finally {
            }
        }
        return element_getElementsByTagNameNS;
    }

    public static NodeList element_getElementsByTagNameNS(Dom dom, String str, String str2) {
        return new ElementsByTagNameNSNodeList(dom, str, str2);
    }

    public static int _attributes_getLength(Dom dom) {
        int attributes_getLength;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return attributes_getLength(dom);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                attributes_getLength = attributes_getLength(dom);
            } finally {
            }
        }
        return attributes_getLength;
    }

    public static int attributes_getLength(Dom dom) {
        Cur tempCur = dom.tempCur();
        int i = 0;
        while (tempCur.toNextAttr()) {
            i++;
        }
        tempCur.release();
        return i;
    }

    public static Node _attributes_setNamedItem(Dom dom, Node node) {
        Dom attributes_setNamedItem;
        Locale locale = dom.locale();
        if (node == null) {
            throw new IllegalArgumentException("Attr to set is null");
        }
        if (node instanceof Dom) {
            Dom dom2 = (Dom) node;
            if (dom2.locale() == locale) {
                if (locale.noSync()) {
                    locale.enter();
                    try {
                        attributes_setNamedItem = attributes_setNamedItem(dom, dom2);
                    } finally {
                    }
                } else {
                    synchronized (locale) {
                        locale.enter();
                        try {
                            attributes_setNamedItem = attributes_setNamedItem(dom, dom2);
                            locale.exit();
                        } finally {
                        }
                    }
                }
                return (Node) attributes_setNamedItem;
            }
        }
        throw new WrongDocumentErr("Attr to set is from another document");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Dom attributes_setNamedItem(Dom dom, Dom dom2) {
        if (attr_getOwnerElement(dom2) != null) {
            throw new InuseAttributeError();
        }
        if (dom2.nodeType() != 2) {
            throw new HierarchyRequestErr("Node is not an attribute");
        }
        String _node_getNodeName = _node_getNodeName(dom2);
        Dom dom3 = null;
        Cur tempCur = dom.tempCur();
        while (tempCur.toNextAttr()) {
            Dom dom4 = tempCur.getDom();
            if (_node_getNodeName(dom4).equals(_node_getNodeName)) {
                if (dom3 == null) {
                    dom3 = dom4;
                } else {
                    removeNode(dom4);
                    tempCur.toPrevAttr();
                }
            }
        }
        if (dom3 == null) {
            tempCur.moveToDom(dom);
            tempCur.next();
            Cur.moveNode((Xobj) dom2, tempCur);
        } else {
            tempCur.moveToDom(dom3);
            Cur.moveNode((Xobj) dom2, tempCur);
            removeNode(dom3);
        }
        tempCur.release();
        return dom3;
    }

    public static Node _attributes_getNamedItem(Dom dom, String str) {
        Dom attributes_getNamedItem;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                attributes_getNamedItem = attributes_getNamedItem(dom, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    attributes_getNamedItem = attributes_getNamedItem(dom, str);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Node) attributes_getNamedItem;
    }

    public static Dom attributes_getNamedItem(Dom dom, String str) {
        Dom dom2;
        Cur tempCur = dom.tempCur();
        while (true) {
            if (!tempCur.toNextAttr()) {
                dom2 = null;
                break;
            }
            dom2 = tempCur.getDom();
            if (_node_getNodeName(dom2).equals(str)) {
                break;
            }
        }
        tempCur.release();
        return dom2;
    }

    public static Node _attributes_getNamedItemNS(Dom dom, String str, String str2) {
        Dom attributes_getNamedItemNS;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                attributes_getNamedItemNS = attributes_getNamedItemNS(dom, str, str2);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    attributes_getNamedItemNS = attributes_getNamedItemNS(dom, str, str2);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Node) attributes_getNamedItemNS;
    }

    public static Dom attributes_getNamedItemNS(Dom dom, String str, String str2) {
        if (str == null) {
            str = "";
        }
        Dom dom2 = null;
        Cur tempCur = dom.tempCur();
        while (true) {
            if (!tempCur.toNextAttr()) {
                break;
            }
            Dom dom3 = tempCur.getDom();
            QName qName = dom3.getQName();
            if (qName.getNamespaceURI().equals(str) && qName.getLocalPart().equals(str2)) {
                dom2 = dom3;
                break;
            }
        }
        tempCur.release();
        return dom2;
    }

    public static Node _attributes_removeNamedItem(Dom dom, String str) {
        Dom attributes_removeNamedItem;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                attributes_removeNamedItem = attributes_removeNamedItem(dom, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    attributes_removeNamedItem = attributes_removeNamedItem(dom, str);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Node) attributes_removeNamedItem;
    }

    public static Dom attributes_removeNamedItem(Dom dom, String str) {
        Cur tempCur = dom.tempCur();
        Dom dom2 = null;
        while (tempCur.toNextAttr()) {
            Dom dom3 = tempCur.getDom();
            if (_node_getNodeName(dom3).equals(str)) {
                if (dom2 == null) {
                    dom2 = dom3;
                }
                if (((Xobj.AttrXobj) dom3).isId()) {
                    Dom node_getOwnerDocument = node_getOwnerDocument(dom3);
                    String node_getNodeValue = node_getNodeValue(dom3);
                    if (node_getOwnerDocument instanceof Xobj.DocumentXobj) {
                        ((Xobj.DocumentXobj) node_getOwnerDocument).removeIdElement(node_getNodeValue);
                    }
                }
                removeNode(dom3);
                tempCur.toPrevAttr();
            }
        }
        tempCur.release();
        if (dom2 != null) {
            return dom2;
        }
        throw new NotFoundErr(new StringBuffer().append("Named item not found: ").append(str).toString());
    }

    public static Node _attributes_removeNamedItemNS(Dom dom, String str, String str2) {
        Dom attributes_removeNamedItemNS;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                attributes_removeNamedItemNS = attributes_removeNamedItemNS(dom, str, str2);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    attributes_removeNamedItemNS = attributes_removeNamedItemNS(dom, str, str2);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Node) attributes_removeNamedItemNS;
    }

    public static Dom attributes_removeNamedItemNS(Dom dom, String str, String str2) {
        if (str == null) {
            str = "";
        }
        Dom dom2 = null;
        Cur tempCur = dom.tempCur();
        while (tempCur.toNextAttr()) {
            Dom dom3 = tempCur.getDom();
            QName qName = dom3.getQName();
            if (qName.getNamespaceURI().equals(str) && qName.getLocalPart().equals(str2)) {
                if (dom2 == null) {
                    dom2 = dom3;
                }
                if (((Xobj.AttrXobj) dom3).isId()) {
                    Dom node_getOwnerDocument = node_getOwnerDocument(dom3);
                    String node_getNodeValue = node_getNodeValue(dom3);
                    if (node_getOwnerDocument instanceof Xobj.DocumentXobj) {
                        ((Xobj.DocumentXobj) node_getOwnerDocument).removeIdElement(node_getNodeValue);
                    }
                }
                removeNode(dom3);
                tempCur.toPrevAttr();
            }
        }
        tempCur.release();
        if (dom2 != null) {
            return dom2;
        }
        throw new NotFoundErr(new StringBuffer().append("Named item not found: uri=").append(str).append(", local=").append(str2).toString());
    }

    public static Node _attributes_setNamedItemNS(Dom dom, Node node) {
        Dom attributes_setNamedItemNS;
        Locale locale = dom.locale();
        if (node == null) {
            throw new IllegalArgumentException("Attr to set is null");
        }
        if (node instanceof Dom) {
            Dom dom2 = (Dom) node;
            if (dom2.locale() == locale) {
                if (locale.noSync()) {
                    locale.enter();
                    try {
                        attributes_setNamedItemNS = attributes_setNamedItemNS(dom, dom2);
                    } finally {
                    }
                } else {
                    synchronized (locale) {
                        locale.enter();
                        try {
                            attributes_setNamedItemNS = attributes_setNamedItemNS(dom, dom2);
                            locale.exit();
                        } finally {
                        }
                    }
                }
                return (Node) attributes_setNamedItemNS;
            }
        }
        throw new WrongDocumentErr("Attr to set is from another document");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Dom attributes_setNamedItemNS(Dom dom, Dom dom2) {
        Dom attr_getOwnerElement = attr_getOwnerElement(dom2);
        if (attr_getOwnerElement == dom) {
            return dom2;
        }
        if (attr_getOwnerElement != null) {
            throw new InuseAttributeError();
        }
        if (dom2.nodeType() != 2) {
            throw new HierarchyRequestErr("Node is not an attribute");
        }
        QName qName = dom2.getQName();
        Dom dom3 = null;
        Cur tempCur = dom.tempCur();
        while (tempCur.toNextAttr()) {
            Dom dom4 = tempCur.getDom();
            if (dom4.getQName().equals(qName)) {
                if (dom3 == null) {
                    dom3 = dom4;
                } else {
                    removeNode(dom4);
                    tempCur.toPrevAttr();
                }
            }
        }
        if (dom3 == null) {
            tempCur.moveToDom(dom);
            tempCur.next();
            Cur.moveNode((Xobj) dom2, tempCur);
        } else {
            tempCur.moveToDom(dom3);
            Cur.moveNode((Xobj) dom2, tempCur);
            removeNode(dom3);
        }
        tempCur.release();
        return dom3;
    }

    public static Node _attributes_item(Dom dom, int i) {
        Dom attributes_item;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                attributes_item = attributes_item(dom, i);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    attributes_item = attributes_item(dom, i);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Node) attributes_item;
    }

    public static Dom attributes_item(Dom dom, int i) {
        Dom dom2 = null;
        if (i < 0) {
            return null;
        }
        Cur tempCur = dom.tempCur();
        while (true) {
            if (!tempCur.toNextAttr()) {
                break;
            }
            int i2 = i - 1;
            if (i == 0) {
                dom2 = tempCur.getDom();
                break;
            }
            i = i2;
        }
        tempCur.release();
        return dom2;
    }

    public static String _processingInstruction_getData(Dom dom) {
        return _node_getNodeValue(dom);
    }

    public static String _processingInstruction_getTarget(Dom dom) {
        return _node_getNodeName(dom);
    }

    public static void _processingInstruction_setData(Dom dom, String str) {
        _node_setNodeValue(dom, str);
    }

    public static Element _attr_getOwnerElement(Dom dom) {
        Dom attr_getOwnerElement;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                attr_getOwnerElement = attr_getOwnerElement(dom);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    attr_getOwnerElement = attr_getOwnerElement(dom);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Element) attr_getOwnerElement;
    }

    public static Dom attr_getOwnerElement(Dom dom) {
        Cur tempCur = dom.tempCur();
        if (!tempCur.toParentRaw()) {
            tempCur.release();
            return null;
        }
        Dom dom2 = tempCur.getDom();
        tempCur.release();
        return dom2;
    }

    public static void _characterData_appendData(Dom dom, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        _node_setNodeValue(dom, new StringBuffer().append(_node_getNodeValue(dom)).append(str).toString());
    }

    public static void _characterData_deleteData(Dom dom, int i, int i2) {
        String _characterData_getData = _characterData_getData(dom);
        if (i < 0 || i > _characterData_getData.length() || i2 < 0) {
            throw new IndexSizeError();
        }
        if (i + i2 > _characterData_getData.length()) {
            i2 = _characterData_getData.length() - i;
        }
        if (i2 > 0) {
            _characterData_setData(dom, new StringBuffer().append(_characterData_getData.substring(0, i)).append(_characterData_getData.substring(i + i2)).toString());
        }
    }

    public static String _characterData_getData(Dom dom) {
        return _node_getNodeValue(dom);
    }

    public static int _characterData_getLength(Dom dom) {
        return _characterData_getData(dom).length();
    }

    public static void _characterData_insertData(Dom dom, int i, String str) {
        String _characterData_getData = _characterData_getData(dom);
        if (i < 0 || i > _characterData_getData.length()) {
            throw new IndexSizeError();
        }
        if (str == null || str.length() <= 0) {
            return;
        }
        _characterData_setData(dom, new StringBuffer().append(_characterData_getData.substring(0, i)).append(str).append(_characterData_getData.substring(i)).toString());
    }

    public static void _characterData_replaceData(Dom dom, int i, int i2, String str) {
        String _characterData_getData = _characterData_getData(dom);
        if (i < 0 || i > _characterData_getData.length() || i2 < 0) {
            throw new IndexSizeError();
        }
        if (i + i2 > _characterData_getData.length()) {
            i2 = _characterData_getData.length() - i;
        }
        if (i2 > 0) {
            StringBuffer append = new StringBuffer().append(_characterData_getData.substring(0, i));
            if (str == null) {
                str = "";
            }
            _characterData_setData(dom, append.append(str).append(_characterData_getData.substring(i + i2)).toString());
        }
    }

    public static void _characterData_setData(Dom dom, String str) {
        _node_setNodeValue(dom, str);
    }

    public static String _characterData_substringData(Dom dom, int i, int i2) {
        String _characterData_getData = _characterData_getData(dom);
        if (i < 0 || i > _characterData_getData.length() || i2 < 0) {
            throw new IndexSizeError();
        }
        if (i + i2 > _characterData_getData.length()) {
            i2 = _characterData_getData.length() - i;
        }
        return _characterData_getData.substring(i, i2 + i);
    }

    public static Text _text_splitText(Dom dom, int i) {
        if (!$assertionsDisabled && dom.nodeType() != 3) {
            throw new AssertionError();
        }
        String _characterData_getData = _characterData_getData(dom);
        if (i < 0 || i > _characterData_getData.length()) {
            throw new IndexSizeError();
        }
        _characterData_deleteData(dom, i, _characterData_getData.length() - i);
        Dom dom2 = (Dom) _document_createTextNode(dom, _characterData_getData.substring(i));
        Dom dom3 = (Dom) _node_getParentNode(dom);
        if (dom3 != null) {
            _node_insertBefore(dom3, (Text) dom2, _node_getNextSibling(dom));
            dom.locale().invalidateDomCaches(dom3);
        }
        return (Text) dom2;
    }

    public static String _text_getWholeText(Dom dom) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static boolean _text_isElementContentWhitespace(Dom dom) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static Text _text_replaceWholeText(Dom dom, String str) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public static XMLStreamReader _getXmlStreamReader(Dom dom) {
        XMLStreamReader xmlStreamReader;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return getXmlStreamReader(dom);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                xmlStreamReader = getXmlStreamReader(dom);
            } finally {
            }
        }
        return xmlStreamReader;
    }

    public static XMLStreamReader getXmlStreamReader(Dom dom) {
        XMLStreamReader newXmlStreamReader;
        switch (dom.nodeType()) {
            case 1:
            case 2:
            case 7:
            case 8:
            case 9:
            case 11:
                Cur tempCur = dom.tempCur();
                XMLStreamReader newXmlStreamReader2 = Jsr173.newXmlStreamReader(tempCur, null);
                tempCur.release();
                return newXmlStreamReader2;
            case 3:
            case 4:
                CharNode charNode = (CharNode) dom;
                Cur tempCur2 = charNode.tempCur();
                if (tempCur2 == null) {
                    tempCur2 = dom.locale().tempCur();
                    newXmlStreamReader = Jsr173.newXmlStreamReader(tempCur2, charNode._src, charNode._off, charNode._cch);
                } else {
                    newXmlStreamReader = Jsr173.newXmlStreamReader(tempCur2, tempCur2.getChars(charNode._cch), tempCur2._offSrc, tempCur2._cchSrc);
                }
                tempCur2.release();
                return newXmlStreamReader;
            case 5:
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            default:
                throw new RuntimeException("Unknown kind");
        }
    }

    public static XmlCursor _getXmlCursor(Dom dom) {
        XmlCursor xmlCursor;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return getXmlCursor(dom);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                xmlCursor = getXmlCursor(dom);
            } finally {
            }
        }
        return xmlCursor;
    }

    public static XmlCursor getXmlCursor(Dom dom) {
        Cur tempCur = dom.tempCur();
        Cursor cursor = new Cursor(tempCur);
        tempCur.release();
        return cursor;
    }

    public static XmlObject _getXmlObject(Dom dom) {
        XmlObject xmlObject;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return getXmlObject(dom);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                xmlObject = getXmlObject(dom);
            } finally {
            }
        }
        return xmlObject;
    }

    public static XmlObject getXmlObject(Dom dom) {
        Cur tempCur = dom.tempCur();
        XmlObject object = tempCur.getObject();
        tempCur.release();
        return object;
    }

    static abstract class CharNode implements Dom, Node, CharacterData {
        static final /* synthetic */ boolean $assertionsDisabled;
        int _cch;
        private Locale _locale;
        CharNode _next;
        int _off;
        CharNode _prev;
        private Object _src;

        @Override // org.w3c.dom.Node
        public NamedNodeMap getAttributes() {
            return null;
        }

        @Override // org.w3c.dom.Node
        public Node getFirstChild() {
            return null;
        }

        @Override // org.w3c.dom.Node
        public Node getLastChild() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public QName getQName() {
            return null;
        }

        @Override // org.w3c.dom.Node
        public boolean hasAttributes() {
            return false;
        }

        @Override // org.w3c.dom.Node
        public boolean hasChildNodes() {
            return false;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public boolean nodeCanHavePrefixUri() {
            return false;
        }

        static {
            if (DomImpl.class$org$apache$xmlbeans$impl$store$DomImpl == null) {
                DomImpl.class$org$apache$xmlbeans$impl$store$DomImpl = DomImpl.class$("org.apache.xmlbeans.impl.store.DomImpl");
            } else {
                Class cls = DomImpl.class$org$apache$xmlbeans$impl$store$DomImpl;
            }
            $assertionsDisabled = true;
        }

        public CharNode(Locale locale) {
            if (!$assertionsDisabled && locale == null) {
                throw new AssertionError();
            }
            this._locale = locale;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public Locale locale() {
            if (!$assertionsDisabled && !isValid()) {
                throw new AssertionError();
            }
            Locale locale = this._locale;
            return locale == null ? ((Dom) this._src).locale() : locale;
        }

        public void setChars(Object obj, int i, int i2) {
            boolean z = $assertionsDisabled;
            if (!z && !CharUtil.isValid(obj, i, i2)) {
                throw new AssertionError();
            }
            if (!z && this._locale == null && !(this._src instanceof Dom)) {
                throw new AssertionError();
            }
            if (this._locale == null) {
                this._locale = ((Dom) this._src).locale();
            }
            this._src = obj;
            this._off = i;
            this._cch = i2;
        }

        public Dom getDom() {
            if (!$assertionsDisabled && !isValid()) {
                throw new AssertionError();
            }
            Object obj = this._src;
            if (obj instanceof Dom) {
                return (Dom) obj;
            }
            return null;
        }

        public void setDom(Dom dom) {
            if (!$assertionsDisabled && dom == null) {
                throw new AssertionError();
            }
            this._src = dom;
            this._locale = null;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public Cur tempCur() {
            if (!$assertionsDisabled && !isValid()) {
                throw new AssertionError();
            }
            if (!(this._src instanceof Dom)) {
                return null;
            }
            Cur tempCur = locale().tempCur();
            tempCur.moveToCharNode(this);
            return tempCur;
        }

        private boolean isValid() {
            return this._src instanceof Dom ? this._locale == null : this._locale != null;
        }

        public static boolean isOnList(CharNode charNode, CharNode charNode2) {
            if (!$assertionsDisabled && charNode2 == null) {
                throw new AssertionError();
            }
            while (charNode != null) {
                if (charNode == charNode2) {
                    return true;
                }
                charNode = charNode._next;
            }
            return false;
        }

        public static CharNode remove(CharNode charNode, CharNode charNode2) {
            if (!$assertionsDisabled && !isOnList(charNode, charNode2)) {
                throw new AssertionError();
            }
            if (charNode == charNode2) {
                charNode = charNode2._next;
            } else {
                charNode2._prev._next = charNode2._next;
            }
            CharNode charNode3 = charNode2._next;
            if (charNode3 != null) {
                charNode3._prev = charNode2._prev;
            }
            charNode2._next = null;
            charNode2._prev = null;
            return charNode;
        }

        public static CharNode insertNode(CharNode charNode, CharNode charNode2, CharNode charNode3) {
            CharNode charNode4;
            boolean z = $assertionsDisabled;
            if (!z && isOnList(charNode, charNode2)) {
                throw new AssertionError();
            }
            if (!z && charNode3 != null && !isOnList(charNode, charNode3)) {
                throw new AssertionError();
            }
            if (!z && charNode2 == null) {
                throw new AssertionError();
            }
            if (!z && (charNode2._prev != null || charNode2._next != null)) {
                throw new AssertionError();
            }
            if (charNode == null) {
                if (!z && charNode3 != null) {
                    throw new AssertionError();
                }
            } else if (charNode == charNode3) {
                charNode._prev = charNode2;
                charNode2._next = charNode;
            } else {
                CharNode charNode5 = charNode;
                while (true) {
                    charNode4 = charNode5._next;
                    if (charNode4 == charNode3) {
                        break;
                    }
                    charNode5 = charNode4;
                }
                charNode2._next = charNode4;
                if (charNode4 != null) {
                    charNode5._next._prev = charNode2;
                }
                charNode2._prev = charNode5;
                charNode5._next = charNode2;
                return charNode;
            }
            return charNode2;
        }

        public static CharNode appendNode(CharNode charNode, CharNode charNode2) {
            return insertNode(charNode, charNode2, null);
        }

        public static CharNode appendNodes(CharNode charNode, CharNode charNode2) {
            boolean z = $assertionsDisabled;
            if (!z && charNode2 == null) {
                throw new AssertionError();
            }
            if (!z && charNode2._prev != null) {
                throw new AssertionError();
            }
            if (charNode == null) {
                return charNode2;
            }
            CharNode charNode3 = charNode;
            while (true) {
                CharNode charNode4 = charNode3._next;
                if (charNode4 == null) {
                    charNode3._next = charNode2;
                    charNode2._prev = charNode3;
                    return charNode;
                }
                charNode3 = charNode4;
            }
        }

        public static CharNode copyNodes(CharNode charNode, Object obj) {
            TextNode createCdataNode;
            TextNode textNode = null;
            TextNode textNode2 = null;
            while (charNode != null) {
                if (charNode instanceof TextNode) {
                    createCdataNode = charNode.locale().createTextNode();
                } else {
                    createCdataNode = charNode.locale().createCdataNode();
                }
                createCdataNode.setChars(obj, charNode._off, charNode._cch);
                if (textNode == null) {
                    textNode = createCdataNode;
                }
                if (textNode2 != null) {
                    textNode2._next = createCdataNode;
                    createCdataNode._prev = textNode2;
                }
                charNode = charNode._next;
                textNode2 = createCdataNode;
            }
            return textNode;
        }

        public boolean isNodeAftertext() {
            if (!$assertionsDisabled && !(this._src instanceof Xobj)) {
                throw new AssertionError("this method is to only be used for nodes backed up by Xobjs");
            }
            Xobj xobj = (Xobj) this._src;
            if (xobj._charNodesValue == null) {
                return true;
            }
            if (xobj._charNodesAfter == null) {
                return false;
            }
            return isOnList(xobj._charNodesAfter, this);
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public void dump(PrintStream printStream, Object obj) {
            Object obj2 = this._src;
            if (obj2 instanceof Dom) {
                ((Dom) obj2).dump(printStream, obj);
            } else {
                printStream.println(new StringBuffer().append("Lonely CharNode: \"").append(CharUtil.getString(this._src, this._off, this._cch)).append("\"").toString());
            }
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public void dump(PrintStream printStream) {
            dump(printStream, this);
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public void dump() {
            dump(System.out);
        }

        @Override // org.w3c.dom.Node
        public Node appendChild(Node node) {
            return DomImpl._node_appendChild(this, node);
        }

        @Override // org.w3c.dom.Node
        public Node cloneNode(boolean z) {
            return DomImpl._node_cloneNode(this, z);
        }

        @Override // org.w3c.dom.Node
        public NodeList getChildNodes() {
            return DomImpl._emptyNodeList;
        }

        @Override // org.w3c.dom.Node
        public Node getParentNode() {
            return DomImpl._node_getParentNode(this);
        }

        @Override // org.w3c.dom.Node
        public Node removeChild(Node node) {
            return DomImpl._node_removeChild(this, node);
        }

        @Override // org.w3c.dom.Node
        public String getLocalName() {
            return DomImpl._node_getLocalName(this);
        }

        @Override // org.w3c.dom.Node
        public String getNamespaceURI() {
            return DomImpl._node_getNamespaceURI(this);
        }

        @Override // org.w3c.dom.Node
        public Node getNextSibling() {
            return DomImpl._node_getNextSibling(this);
        }

        @Override // org.w3c.dom.Node
        public String getNodeName() {
            return DomImpl._node_getNodeName(this);
        }

        @Override // org.w3c.dom.Node
        public short getNodeType() {
            return DomImpl._node_getNodeType(this);
        }

        @Override // org.w3c.dom.Node
        public String getNodeValue() {
            return DomImpl._node_getNodeValue(this);
        }

        @Override // org.w3c.dom.Node
        public Document getOwnerDocument() {
            return DomImpl._node_getOwnerDocument(this);
        }

        @Override // org.w3c.dom.Node
        public String getPrefix() {
            return DomImpl._node_getPrefix(this);
        }

        @Override // org.w3c.dom.Node
        public Node getPreviousSibling() {
            return DomImpl._node_getPreviousSibling(this);
        }

        @Override // org.w3c.dom.Node
        public Node insertBefore(Node node, Node node2) {
            return DomImpl._node_insertBefore(this, node, node2);
        }

        @Override // org.w3c.dom.Node
        public boolean isSupported(String str, String str2) {
            return DomImpl._node_isSupported(this, str, str2);
        }

        @Override // org.w3c.dom.Node
        public void normalize() {
            DomImpl._node_normalize(this);
        }

        @Override // org.w3c.dom.Node
        public Node replaceChild(Node node, Node node2) {
            return DomImpl._node_replaceChild(this, node, node2);
        }

        @Override // org.w3c.dom.Node
        public void setNodeValue(String str) {
            DomImpl._node_setNodeValue(this, str);
        }

        @Override // org.w3c.dom.Node
        public void setPrefix(String str) {
            DomImpl._node_setPrefix(this, str);
        }

        public Object getUserData(String str) {
            return DomImpl._node_getUserData(this, str);
        }

        public Object setUserData(String str, Object obj, UserDataHandler userDataHandler) {
            return DomImpl._node_setUserData(this, str, obj, userDataHandler);
        }

        public Object getFeature(String str, String str2) {
            return DomImpl._node_getFeature(this, str, str2);
        }

        public boolean isEqualNode(Node node) {
            return DomImpl._node_isEqualNode(this, node);
        }

        public boolean isSameNode(Node node) {
            return DomImpl._node_isSameNode(this, node);
        }

        public String lookupNamespaceURI(String str) {
            return DomImpl._node_lookupNamespaceURI(this, str);
        }

        public String lookupPrefix(String str) {
            return DomImpl._node_lookupPrefix(this, str);
        }

        public boolean isDefaultNamespace(String str) {
            return DomImpl._node_isDefaultNamespace(this, str);
        }

        public void setTextContent(String str) {
            DomImpl._node_setTextContent(this, str);
        }

        public String getTextContent() {
            return DomImpl._node_getTextContent(this);
        }

        public short compareDocumentPosition(Node node) {
            return DomImpl._node_compareDocumentPosition(this, node);
        }

        public String getBaseURI() {
            return DomImpl._node_getBaseURI(this);
        }

        @Override // org.w3c.dom.CharacterData
        public void appendData(String str) {
            DomImpl._characterData_appendData(this, str);
        }

        @Override // org.w3c.dom.CharacterData
        public void deleteData(int i, int i2) {
            DomImpl._characterData_deleteData(this, i, i2);
        }

        @Override // org.w3c.dom.CharacterData
        public String getData() {
            return DomImpl._characterData_getData(this);
        }

        @Override // org.w3c.dom.CharacterData
        public int getLength() {
            return DomImpl._characterData_getLength(this);
        }

        @Override // org.w3c.dom.CharacterData
        public void insertData(int i, String str) {
            DomImpl._characterData_insertData(this, i, str);
        }

        @Override // org.w3c.dom.CharacterData
        public void replaceData(int i, int i2, String str) {
            DomImpl._characterData_replaceData(this, i, i2, str);
        }

        @Override // org.w3c.dom.CharacterData
        public void setData(String str) {
            DomImpl._characterData_setData(this, str);
        }

        @Override // org.w3c.dom.CharacterData
        public String substringData(int i, int i2) {
            return DomImpl._characterData_substringData(this, i, i2);
        }
    }

    static class TextNode extends CharNode implements Text {
        public String name() {
            return "#text";
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
        public int nodeType() {
            return 3;
        }

        TextNode(Locale locale) {
            super(locale);
        }

        @Override // org.w3c.dom.Text
        public Text splitText(int i) {
            return DomImpl._text_splitText(this, i);
        }

        public String getWholeText() {
            return DomImpl._text_getWholeText(this);
        }

        public boolean isElementContentWhitespace() {
            return DomImpl._text_isElementContentWhitespace(this);
        }

        public Text replaceWholeText(String str) {
            return DomImpl._text_replaceWholeText(this, str);
        }
    }

    static class CdataNode extends TextNode implements CDATASection {
        @Override // org.apache.xmlbeans.impl.store.DomImpl.TextNode
        public String name() {
            return "#cdata-section";
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.TextNode, org.apache.xmlbeans.impl.store.DomImpl.Dom
        public int nodeType() {
            return 4;
        }

        CdataNode(Locale locale) {
            super(locale);
        }
    }

    static class SaajTextNode extends TextNode implements org.apache.xmlbeans.impl.soap.Text {
        SaajTextNode(Locale locale) {
            super(locale);
        }

        @Override // org.apache.xmlbeans.impl.soap.Text
        public boolean isComment() {
            return DomImpl._soapText_isComment(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void detachNode() {
            DomImpl._soapNode_detachNode(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void recycleNode() {
            DomImpl._soapNode_recycleNode(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public String getValue() {
            return DomImpl._soapNode_getValue(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void setValue(String str) {
            DomImpl._soapNode_setValue(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public SOAPElement getParentElement() {
            return DomImpl._soapNode_getParentElement(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void setParentElement(SOAPElement sOAPElement) {
            DomImpl._soapNode_setParentElement(this, sOAPElement);
        }
    }

    static class SaajCdataNode extends CdataNode implements org.apache.xmlbeans.impl.soap.Text {
        public SaajCdataNode(Locale locale) {
            super(locale);
        }

        @Override // org.apache.xmlbeans.impl.soap.Text
        public boolean isComment() {
            return DomImpl._soapText_isComment(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void detachNode() {
            DomImpl._soapNode_detachNode(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void recycleNode() {
            DomImpl._soapNode_recycleNode(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public String getValue() {
            return DomImpl._soapNode_getValue(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void setValue(String str) {
            DomImpl._soapNode_setValue(this, str);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public SOAPElement getParentElement() {
            return DomImpl._soapNode_getParentElement(this);
        }

        @Override // org.apache.xmlbeans.impl.soap.Node
        public void setParentElement(SOAPElement sOAPElement) {
            DomImpl._soapNode_setParentElement(this, sOAPElement);
        }
    }

    public static boolean _soapText_isComment(Dom dom) {
        boolean soapText_isComment;
        Locale locale = dom.locale();
        org.apache.xmlbeans.impl.soap.Text text = (org.apache.xmlbeans.impl.soap.Text) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapText_isComment(text);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapText_isComment = locale._saaj.soapText_isComment(text);
            } finally {
            }
        }
        return soapText_isComment;
    }

    public static void _soapNode_detachNode(Dom dom) {
        Locale locale = dom.locale();
        org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapNode_detachNode(node);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    locale._saaj.soapNode_detachNode(node);
                } finally {
                }
            }
        }
    }

    public static void _soapNode_recycleNode(Dom dom) {
        Locale locale = dom.locale();
        org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapNode_recycleNode(node);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    locale._saaj.soapNode_recycleNode(node);
                } finally {
                }
            }
        }
    }

    public static String _soapNode_getValue(Dom dom) {
        String soapNode_getValue;
        Locale locale = dom.locale();
        org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapNode_getValue(node);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapNode_getValue = locale._saaj.soapNode_getValue(node);
            } finally {
            }
        }
        return soapNode_getValue;
    }

    public static void _soapNode_setValue(Dom dom, String str) {
        Locale locale = dom.locale();
        org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapNode_setValue(node, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    locale._saaj.soapNode_setValue(node, str);
                } finally {
                }
            }
        }
    }

    public static SOAPElement _soapNode_getParentElement(Dom dom) {
        SOAPElement soapNode_getParentElement;
        Locale locale = dom.locale();
        org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapNode_getParentElement(node);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapNode_getParentElement = locale._saaj.soapNode_getParentElement(node);
            } finally {
            }
        }
        return soapNode_getParentElement;
    }

    public static void _soapNode_setParentElement(Dom dom, SOAPElement sOAPElement) {
        Locale locale = dom.locale();
        org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapNode_setParentElement(node, sOAPElement);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    locale._saaj.soapNode_setParentElement(node, sOAPElement);
                } finally {
                }
            }
        }
    }

    public static void _soapElement_removeContents(Dom dom) {
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapElement_removeContents(sOAPElement);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    locale._saaj.soapElement_removeContents(sOAPElement);
                } finally {
                }
            }
        }
    }

    public static String _soapElement_getEncodingStyle(Dom dom) {
        String soapElement_getEncodingStyle;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getEncodingStyle(sOAPElement);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapElement_getEncodingStyle = locale._saaj.soapElement_getEncodingStyle(sOAPElement);
            } finally {
            }
        }
        return soapElement_getEncodingStyle;
    }

    public static void _soapElement_setEncodingStyle(Dom dom, String str) {
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapElement_setEncodingStyle(sOAPElement, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    locale._saaj.soapElement_setEncodingStyle(sOAPElement, str);
                } finally {
                }
            }
        }
    }

    public static boolean _soapElement_removeNamespaceDeclaration(Dom dom, String str) {
        boolean soapElement_removeNamespaceDeclaration;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_removeNamespaceDeclaration(sOAPElement, str);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapElement_removeNamespaceDeclaration = locale._saaj.soapElement_removeNamespaceDeclaration(sOAPElement, str);
            } finally {
            }
        }
        return soapElement_removeNamespaceDeclaration;
    }

    public static Iterator _soapElement_getAllAttributes(Dom dom) {
        Iterator soapElement_getAllAttributes;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getAllAttributes(sOAPElement);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapElement_getAllAttributes = locale._saaj.soapElement_getAllAttributes(sOAPElement);
            } finally {
            }
        }
        return soapElement_getAllAttributes;
    }

    public static Iterator _soapElement_getChildElements(Dom dom) {
        Iterator soapElement_getChildElements;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getChildElements(sOAPElement);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapElement_getChildElements = locale._saaj.soapElement_getChildElements(sOAPElement);
            } finally {
            }
        }
        return soapElement_getChildElements;
    }

    public static Iterator _soapElement_getNamespacePrefixes(Dom dom) {
        Iterator soapElement_getNamespacePrefixes;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getNamespacePrefixes(sOAPElement);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapElement_getNamespacePrefixes = locale._saaj.soapElement_getNamespacePrefixes(sOAPElement);
            } finally {
            }
        }
        return soapElement_getNamespacePrefixes;
    }

    public static SOAPElement _soapElement_addAttribute(Dom dom, Name name, String str) throws SOAPException {
        SOAPElement soapElement_addAttribute;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addAttribute(sOAPElement, name, str);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapElement_addAttribute = locale._saaj.soapElement_addAttribute(sOAPElement, name, str);
            } finally {
            }
        }
        return soapElement_addAttribute;
    }

    public static SOAPElement _soapElement_addChildElement(Dom dom, SOAPElement sOAPElement) throws SOAPException {
        SOAPElement soapElement_addChildElement;
        Locale locale = dom.locale();
        SOAPElement sOAPElement2 = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addChildElement(sOAPElement2, sOAPElement);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapElement_addChildElement = locale._saaj.soapElement_addChildElement(sOAPElement2, sOAPElement);
            } finally {
            }
        }
        return soapElement_addChildElement;
    }

    public static SOAPElement _soapElement_addChildElement(Dom dom, Name name) throws SOAPException {
        SOAPElement soapElement_addChildElement;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addChildElement(sOAPElement, name);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapElement_addChildElement = locale._saaj.soapElement_addChildElement(sOAPElement, name);
            } finally {
            }
        }
        return soapElement_addChildElement;
    }

    public static SOAPElement _soapElement_addChildElement(Dom dom, String str) throws SOAPException {
        SOAPElement soapElement_addChildElement;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addChildElement(sOAPElement, str);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapElement_addChildElement = locale._saaj.soapElement_addChildElement(sOAPElement, str);
            } finally {
            }
        }
        return soapElement_addChildElement;
    }

    public static SOAPElement _soapElement_addChildElement(Dom dom, String str, String str2) throws SOAPException {
        SOAPElement soapElement_addChildElement;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addChildElement(sOAPElement, str, str2);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapElement_addChildElement = locale._saaj.soapElement_addChildElement(sOAPElement, str, str2);
            } finally {
            }
        }
        return soapElement_addChildElement;
    }

    public static SOAPElement _soapElement_addChildElement(Dom dom, String str, String str2, String str3) throws SOAPException {
        SOAPElement soapElement_addChildElement;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addChildElement(sOAPElement, str, str2, str3);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapElement_addChildElement = locale._saaj.soapElement_addChildElement(sOAPElement, str, str2, str3);
            } finally {
            }
        }
        return soapElement_addChildElement;
    }

    public static SOAPElement _soapElement_addNamespaceDeclaration(Dom dom, String str, String str2) {
        SOAPElement soapElement_addNamespaceDeclaration;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addNamespaceDeclaration(sOAPElement, str, str2);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapElement_addNamespaceDeclaration = locale._saaj.soapElement_addNamespaceDeclaration(sOAPElement, str, str2);
            } finally {
            }
        }
        return soapElement_addNamespaceDeclaration;
    }

    public static SOAPElement _soapElement_addTextNode(Dom dom, String str) {
        SOAPElement soapElement_addTextNode;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_addTextNode(sOAPElement, str);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapElement_addTextNode = locale._saaj.soapElement_addTextNode(sOAPElement, str);
            } finally {
            }
        }
        return soapElement_addTextNode;
    }

    public static String _soapElement_getAttributeValue(Dom dom, Name name) {
        String soapElement_getAttributeValue;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getAttributeValue(sOAPElement, name);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapElement_getAttributeValue = locale._saaj.soapElement_getAttributeValue(sOAPElement, name);
            } finally {
            }
        }
        return soapElement_getAttributeValue;
    }

    public static Iterator _soapElement_getChildElements(Dom dom, Name name) {
        Iterator soapElement_getChildElements;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getChildElements(sOAPElement, name);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapElement_getChildElements = locale._saaj.soapElement_getChildElements(sOAPElement, name);
            } finally {
            }
        }
        return soapElement_getChildElements;
    }

    public static Name _soapElement_getElementName(Dom dom) {
        Name soapElement_getElementName;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getElementName(sOAPElement);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapElement_getElementName = locale._saaj.soapElement_getElementName(sOAPElement);
            } finally {
            }
        }
        return soapElement_getElementName;
    }

    public static String _soapElement_getNamespaceURI(Dom dom, String str) {
        String soapElement_getNamespaceURI;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getNamespaceURI(sOAPElement, str);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapElement_getNamespaceURI = locale._saaj.soapElement_getNamespaceURI(sOAPElement, str);
            } finally {
            }
        }
        return soapElement_getNamespaceURI;
    }

    public static Iterator _soapElement_getVisibleNamespacePrefixes(Dom dom) {
        Iterator soapElement_getVisibleNamespacePrefixes;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_getVisibleNamespacePrefixes(sOAPElement);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapElement_getVisibleNamespacePrefixes = locale._saaj.soapElement_getVisibleNamespacePrefixes(sOAPElement);
            } finally {
            }
        }
        return soapElement_getVisibleNamespacePrefixes;
    }

    public static boolean _soapElement_removeAttribute(Dom dom, Name name) {
        boolean soapElement_removeAttribute;
        Locale locale = dom.locale();
        SOAPElement sOAPElement = (SOAPElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapElement_removeAttribute(sOAPElement, name);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapElement_removeAttribute = locale._saaj.soapElement_removeAttribute(sOAPElement, name);
            } finally {
            }
        }
        return soapElement_removeAttribute;
    }

    public static SOAPBody _soapEnvelope_addBody(Dom dom) throws SOAPException {
        SOAPBody soapEnvelope_addBody;
        Locale locale = dom.locale();
        SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapEnvelope_addBody(sOAPEnvelope);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapEnvelope_addBody = locale._saaj.soapEnvelope_addBody(sOAPEnvelope);
            } finally {
            }
        }
        return soapEnvelope_addBody;
    }

    public static SOAPBody _soapEnvelope_getBody(Dom dom) throws SOAPException {
        SOAPBody soapEnvelope_getBody;
        Locale locale = dom.locale();
        SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapEnvelope_getBody(sOAPEnvelope);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapEnvelope_getBody = locale._saaj.soapEnvelope_getBody(sOAPEnvelope);
            } finally {
            }
        }
        return soapEnvelope_getBody;
    }

    public static SOAPHeader _soapEnvelope_getHeader(Dom dom) throws SOAPException {
        SOAPHeader soapEnvelope_getHeader;
        Locale locale = dom.locale();
        SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapEnvelope_getHeader(sOAPEnvelope);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapEnvelope_getHeader = locale._saaj.soapEnvelope_getHeader(sOAPEnvelope);
            } finally {
            }
        }
        return soapEnvelope_getHeader;
    }

    public static SOAPHeader _soapEnvelope_addHeader(Dom dom) throws SOAPException {
        SOAPHeader soapEnvelope_addHeader;
        Locale locale = dom.locale();
        SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapEnvelope_addHeader(sOAPEnvelope);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapEnvelope_addHeader = locale._saaj.soapEnvelope_addHeader(sOAPEnvelope);
            } finally {
            }
        }
        return soapEnvelope_addHeader;
    }

    public static Name _soapEnvelope_createName(Dom dom, String str) {
        Name soapEnvelope_createName;
        Locale locale = dom.locale();
        SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapEnvelope_createName(sOAPEnvelope, str);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapEnvelope_createName = locale._saaj.soapEnvelope_createName(sOAPEnvelope, str);
            } finally {
            }
        }
        return soapEnvelope_createName;
    }

    public static Name _soapEnvelope_createName(Dom dom, String str, String str2, String str3) {
        Name soapEnvelope_createName;
        Locale locale = dom.locale();
        SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapEnvelope_createName(sOAPEnvelope, str, str2, str3);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapEnvelope_createName = locale._saaj.soapEnvelope_createName(sOAPEnvelope, str, str2, str3);
            } finally {
            }
        }
        return soapEnvelope_createName;
    }

    public static Iterator soapHeader_examineAllHeaderElements(Dom dom) {
        Iterator soapHeader_examineAllHeaderElements;
        Locale locale = dom.locale();
        SOAPHeader sOAPHeader = (SOAPHeader) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeader_examineAllHeaderElements(sOAPHeader);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapHeader_examineAllHeaderElements = locale._saaj.soapHeader_examineAllHeaderElements(sOAPHeader);
            } finally {
            }
        }
        return soapHeader_examineAllHeaderElements;
    }

    public static Iterator soapHeader_extractAllHeaderElements(Dom dom) {
        Iterator soapHeader_extractAllHeaderElements;
        Locale locale = dom.locale();
        SOAPHeader sOAPHeader = (SOAPHeader) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeader_extractAllHeaderElements(sOAPHeader);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapHeader_extractAllHeaderElements = locale._saaj.soapHeader_extractAllHeaderElements(sOAPHeader);
            } finally {
            }
        }
        return soapHeader_extractAllHeaderElements;
    }

    public static Iterator soapHeader_examineHeaderElements(Dom dom, String str) {
        Iterator soapHeader_examineHeaderElements;
        Locale locale = dom.locale();
        SOAPHeader sOAPHeader = (SOAPHeader) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeader_examineHeaderElements(sOAPHeader, str);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapHeader_examineHeaderElements = locale._saaj.soapHeader_examineHeaderElements(sOAPHeader, str);
            } finally {
            }
        }
        return soapHeader_examineHeaderElements;
    }

    public static Iterator soapHeader_examineMustUnderstandHeaderElements(Dom dom, String str) {
        Iterator soapHeader_examineMustUnderstandHeaderElements;
        Locale locale = dom.locale();
        SOAPHeader sOAPHeader = (SOAPHeader) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeader_examineMustUnderstandHeaderElements(sOAPHeader, str);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapHeader_examineMustUnderstandHeaderElements = locale._saaj.soapHeader_examineMustUnderstandHeaderElements(sOAPHeader, str);
            } finally {
            }
        }
        return soapHeader_examineMustUnderstandHeaderElements;
    }

    public static Iterator soapHeader_extractHeaderElements(Dom dom, String str) {
        Iterator soapHeader_extractHeaderElements;
        Locale locale = dom.locale();
        SOAPHeader sOAPHeader = (SOAPHeader) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeader_extractHeaderElements(sOAPHeader, str);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapHeader_extractHeaderElements = locale._saaj.soapHeader_extractHeaderElements(sOAPHeader, str);
            } finally {
            }
        }
        return soapHeader_extractHeaderElements;
    }

    public static SOAPHeaderElement soapHeader_addHeaderElement(Dom dom, Name name) {
        SOAPHeaderElement soapHeader_addHeaderElement;
        Locale locale = dom.locale();
        SOAPHeader sOAPHeader = (SOAPHeader) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeader_addHeaderElement(sOAPHeader, name);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapHeader_addHeaderElement = locale._saaj.soapHeader_addHeaderElement(sOAPHeader, name);
            } finally {
            }
        }
        return soapHeader_addHeaderElement;
    }

    public static boolean soapBody_hasFault(Dom dom) {
        boolean soapBody_hasFault;
        Locale locale = dom.locale();
        SOAPBody sOAPBody = (SOAPBody) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapBody_hasFault(sOAPBody);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapBody_hasFault = locale._saaj.soapBody_hasFault(sOAPBody);
            } finally {
            }
        }
        return soapBody_hasFault;
    }

    public static SOAPFault soapBody_addFault(Dom dom) throws SOAPException {
        SOAPFault soapBody_addFault;
        Locale locale = dom.locale();
        SOAPBody sOAPBody = (SOAPBody) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapBody_addFault(sOAPBody);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapBody_addFault = locale._saaj.soapBody_addFault(sOAPBody);
            } finally {
            }
        }
        return soapBody_addFault;
    }

    public static SOAPFault soapBody_getFault(Dom dom) {
        SOAPFault soapBody_getFault;
        Locale locale = dom.locale();
        SOAPBody sOAPBody = (SOAPBody) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapBody_getFault(sOAPBody);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapBody_getFault = locale._saaj.soapBody_getFault(sOAPBody);
            } finally {
            }
        }
        return soapBody_getFault;
    }

    public static SOAPBodyElement soapBody_addBodyElement(Dom dom, Name name) {
        SOAPBodyElement soapBody_addBodyElement;
        Locale locale = dom.locale();
        SOAPBody sOAPBody = (SOAPBody) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapBody_addBodyElement(sOAPBody, name);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapBody_addBodyElement = locale._saaj.soapBody_addBodyElement(sOAPBody, name);
            } finally {
            }
        }
        return soapBody_addBodyElement;
    }

    public static SOAPBodyElement soapBody_addDocument(Dom dom, Document document) {
        SOAPBodyElement soapBody_addDocument;
        Locale locale = dom.locale();
        SOAPBody sOAPBody = (SOAPBody) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapBody_addDocument(sOAPBody, document);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapBody_addDocument = locale._saaj.soapBody_addDocument(sOAPBody, document);
            } finally {
            }
        }
        return soapBody_addDocument;
    }

    public static SOAPFault soapBody_addFault(Dom dom, Name name, String str) throws SOAPException {
        SOAPFault soapBody_addFault;
        Locale locale = dom.locale();
        SOAPBody sOAPBody = (SOAPBody) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapBody_addFault(sOAPBody, name, str);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapBody_addFault = locale._saaj.soapBody_addFault(sOAPBody, name, str);
            } finally {
            }
        }
        return soapBody_addFault;
    }

    public static SOAPFault soapBody_addFault(Dom dom, Name name, String str, java.util.Locale locale) throws SOAPException {
        SOAPFault soapBody_addFault;
        Locale locale2 = dom.locale();
        SOAPBody sOAPBody = (SOAPBody) dom;
        if (locale2.noSync()) {
            locale2.enter();
            try {
                return locale2._saaj.soapBody_addFault(sOAPBody, name, str, locale);
            } finally {
            }
        }
        synchronized (locale2) {
            locale2.enter();
            try {
                soapBody_addFault = locale2._saaj.soapBody_addFault(sOAPBody, name, str, locale);
            } finally {
            }
        }
        return soapBody_addFault;
    }

    public static void soapFault_setFaultString(Dom dom, String str) {
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapFault_setFaultString(sOAPFault, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    locale._saaj.soapFault_setFaultString(sOAPFault, str);
                } finally {
                }
            }
        }
    }

    public static void soapFault_setFaultString(Dom dom, String str, java.util.Locale locale) {
        Locale locale2 = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale2.noSync()) {
            locale2.enter();
            try {
                locale2._saaj.soapFault_setFaultString(sOAPFault, str, locale);
            } finally {
            }
        } else {
            synchronized (locale2) {
                locale2.enter();
                try {
                    locale2._saaj.soapFault_setFaultString(sOAPFault, str, locale);
                } finally {
                }
            }
        }
    }

    public static void soapFault_setFaultCode(Dom dom, Name name) throws SOAPException {
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapFault_setFaultCode(sOAPFault, name);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    locale._saaj.soapFault_setFaultCode(sOAPFault, name);
                } finally {
                }
            }
        }
    }

    public static void soapFault_setFaultActor(Dom dom, String str) {
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapFault_setFaultActor(sOAPFault, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    locale._saaj.soapFault_setFaultActor(sOAPFault, str);
                } finally {
                }
            }
        }
    }

    public static String soapFault_getFaultActor(Dom dom) {
        String soapFault_getFaultActor;
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapFault_getFaultActor(sOAPFault);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapFault_getFaultActor = locale._saaj.soapFault_getFaultActor(sOAPFault);
            } finally {
            }
        }
        return soapFault_getFaultActor;
    }

    public static String soapFault_getFaultCode(Dom dom) {
        String soapFault_getFaultCode;
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapFault_getFaultCode(sOAPFault);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapFault_getFaultCode = locale._saaj.soapFault_getFaultCode(sOAPFault);
            } finally {
            }
        }
        return soapFault_getFaultCode;
    }

    public static void soapFault_setFaultCode(Dom dom, String str) throws SOAPException {
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapFault_setFaultCode(sOAPFault, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    locale._saaj.soapFault_setFaultCode(sOAPFault, str);
                } finally {
                }
            }
        }
    }

    public static java.util.Locale soapFault_getFaultStringLocale(Dom dom) {
        java.util.Locale soapFault_getFaultStringLocale;
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapFault_getFaultStringLocale(sOAPFault);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapFault_getFaultStringLocale = locale._saaj.soapFault_getFaultStringLocale(sOAPFault);
            } finally {
            }
        }
        return soapFault_getFaultStringLocale;
    }

    public static Name soapFault_getFaultCodeAsName(Dom dom) {
        Name soapFault_getFaultCodeAsName;
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapFault_getFaultCodeAsName(sOAPFault);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapFault_getFaultCodeAsName = locale._saaj.soapFault_getFaultCodeAsName(sOAPFault);
            } finally {
            }
        }
        return soapFault_getFaultCodeAsName;
    }

    public static String soapFault_getFaultString(Dom dom) {
        String soapFault_getFaultString;
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapFault_getFaultString(sOAPFault);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapFault_getFaultString = locale._saaj.soapFault_getFaultString(sOAPFault);
            } finally {
            }
        }
        return soapFault_getFaultString;
    }

    public static Detail soapFault_addDetail(Dom dom) throws SOAPException {
        Detail soapFault_addDetail;
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapFault_addDetail(sOAPFault);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapFault_addDetail = locale._saaj.soapFault_addDetail(sOAPFault);
            } finally {
            }
        }
        return soapFault_addDetail;
    }

    public static Detail soapFault_getDetail(Dom dom) {
        Detail soapFault_getDetail;
        Locale locale = dom.locale();
        SOAPFault sOAPFault = (SOAPFault) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapFault_getDetail(sOAPFault);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapFault_getDetail = locale._saaj.soapFault_getDetail(sOAPFault);
            } finally {
            }
        }
        return soapFault_getDetail;
    }

    public static void soapHeaderElement_setMustUnderstand(Dom dom, boolean z) {
        Locale locale = dom.locale();
        SOAPHeaderElement sOAPHeaderElement = (SOAPHeaderElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapHeaderElement_setMustUnderstand(sOAPHeaderElement, z);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    locale._saaj.soapHeaderElement_setMustUnderstand(sOAPHeaderElement, z);
                } finally {
                }
            }
        }
    }

    public static boolean soapHeaderElement_getMustUnderstand(Dom dom) {
        boolean soapHeaderElement_getMustUnderstand;
        Locale locale = dom.locale();
        SOAPHeaderElement sOAPHeaderElement = (SOAPHeaderElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeaderElement_getMustUnderstand(sOAPHeaderElement);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapHeaderElement_getMustUnderstand = locale._saaj.soapHeaderElement_getMustUnderstand(sOAPHeaderElement);
            } finally {
            }
        }
        return soapHeaderElement_getMustUnderstand;
    }

    public static void soapHeaderElement_setActor(Dom dom, String str) {
        Locale locale = dom.locale();
        SOAPHeaderElement sOAPHeaderElement = (SOAPHeaderElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapHeaderElement_setActor(sOAPHeaderElement, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    locale._saaj.soapHeaderElement_setActor(sOAPHeaderElement, str);
                } finally {
                }
            }
        }
    }

    public static String soapHeaderElement_getActor(Dom dom) {
        String soapHeaderElement_getActor;
        Locale locale = dom.locale();
        SOAPHeaderElement sOAPHeaderElement = (SOAPHeaderElement) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapHeaderElement_getActor(sOAPHeaderElement);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapHeaderElement_getActor = locale._saaj.soapHeaderElement_getActor(sOAPHeaderElement);
            } finally {
            }
        }
        return soapHeaderElement_getActor;
    }

    public static DetailEntry detail_addDetailEntry(Dom dom, Name name) {
        DetailEntry detail_addDetailEntry;
        Locale locale = dom.locale();
        Detail detail = (Detail) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.detail_addDetailEntry(detail, name);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                detail_addDetailEntry = locale._saaj.detail_addDetailEntry(detail, name);
            } finally {
            }
        }
        return detail_addDetailEntry;
    }

    public static Iterator detail_getDetailEntries(Dom dom) {
        Iterator detail_getDetailEntries;
        Locale locale = dom.locale();
        Detail detail = (Detail) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.detail_getDetailEntries(detail);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                detail_getDetailEntries = locale._saaj.detail_getDetailEntries(detail);
            } finally {
            }
        }
        return detail_getDetailEntries;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _soapPart_removeAllMimeHeaders(Dom dom) {
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapPart_removeAllMimeHeaders(sOAPPart);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    locale._saaj.soapPart_removeAllMimeHeaders(sOAPPart);
                } finally {
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _soapPart_removeMimeHeader(Dom dom, String str) {
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapPart_removeMimeHeader(sOAPPart, str);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    locale._saaj.soapPart_removeMimeHeader(sOAPPart, str);
                } finally {
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Iterator _soapPart_getAllMimeHeaders(Dom dom) {
        Iterator soapPart_getAllMimeHeaders;
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapPart_getAllMimeHeaders(sOAPPart);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapPart_getAllMimeHeaders = locale._saaj.soapPart_getAllMimeHeaders(sOAPPart);
            } finally {
            }
        }
        return soapPart_getAllMimeHeaders;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static SOAPEnvelope _soapPart_getEnvelope(Dom dom) {
        SOAPEnvelope soapPart_getEnvelope;
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapPart_getEnvelope(sOAPPart);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapPart_getEnvelope = locale._saaj.soapPart_getEnvelope(sOAPPart);
            } finally {
            }
        }
        return soapPart_getEnvelope;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Source _soapPart_getContent(Dom dom) {
        Source soapPart_getContent;
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapPart_getContent(sOAPPart);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapPart_getContent = locale._saaj.soapPart_getContent(sOAPPart);
            } finally {
            }
        }
        return soapPart_getContent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _soapPart_setContent(Dom dom, Source source) {
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapPart_setContent(sOAPPart, source);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    locale._saaj.soapPart_setContent(sOAPPart, source);
                } finally {
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String[] _soapPart_getMimeHeader(Dom dom, String str) {
        String[] soapPart_getMimeHeader;
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapPart_getMimeHeader(sOAPPart, str);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapPart_getMimeHeader = locale._saaj.soapPart_getMimeHeader(sOAPPart, str);
            } finally {
            }
        }
        return soapPart_getMimeHeader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _soapPart_addMimeHeader(Dom dom, String str, String str2) {
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapPart_addMimeHeader(sOAPPart, str, str2);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    locale._saaj.soapPart_addMimeHeader(sOAPPart, str, str2);
                } finally {
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _soapPart_setMimeHeader(Dom dom, String str, String str2) {
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                locale._saaj.soapPart_setMimeHeader(sOAPPart, str, str2);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    locale._saaj.soapPart_setMimeHeader(sOAPPart, str, str2);
                } finally {
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Iterator _soapPart_getMatchingMimeHeaders(Dom dom, String[] strArr) {
        Iterator soapPart_getMatchingMimeHeaders;
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapPart_getMatchingMimeHeaders(sOAPPart, strArr);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapPart_getMatchingMimeHeaders = locale._saaj.soapPart_getMatchingMimeHeaders(sOAPPart, strArr);
            } finally {
            }
        }
        return soapPart_getMatchingMimeHeaders;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Iterator _soapPart_getNonMatchingMimeHeaders(Dom dom, String[] strArr) {
        Iterator soapPart_getNonMatchingMimeHeaders;
        Locale locale = dom.locale();
        SOAPPart sOAPPart = (SOAPPart) dom;
        if (locale.noSync()) {
            locale.enter();
            try {
                return locale._saaj.soapPart_getNonMatchingMimeHeaders(sOAPPart, strArr);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                soapPart_getNonMatchingMimeHeaders = locale._saaj.soapPart_getNonMatchingMimeHeaders(sOAPPart, strArr);
            } finally {
            }
        }
        return soapPart_getNonMatchingMimeHeaders;
    }

    private static class SaajData {
        Object _obj;

        private SaajData() {
        }
    }

    public static void saajCallback_setSaajData(Dom dom, Object obj) {
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                impl_saajCallback_setSaajData(dom, obj);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    impl_saajCallback_setSaajData(dom, obj);
                } finally {
                }
            }
        }
    }

    public static void impl_saajCallback_setSaajData(Dom dom, Object obj) {
        Cur tempCur = dom.locale().tempCur();
        tempCur.moveToDom(dom);
        SaajData saajData = null;
        byte b = 0;
        if (obj != null) {
            Class cls = class$org$apache$xmlbeans$impl$store$DomImpl$SaajData;
            if (cls == null) {
                cls = class$("org.apache.xmlbeans.impl.store.DomImpl$SaajData");
                class$org$apache$xmlbeans$impl$store$DomImpl$SaajData = cls;
            }
            SaajData saajData2 = (SaajData) tempCur.getBookmark(cls);
            if (saajData2 == null) {
                saajData2 = new SaajData();
            }
            saajData = saajData2;
            saajData._obj = obj;
        }
        Class cls2 = class$org$apache$xmlbeans$impl$store$DomImpl$SaajData;
        if (cls2 == null) {
            cls2 = class$("org.apache.xmlbeans.impl.store.DomImpl$SaajData");
            class$org$apache$xmlbeans$impl$store$DomImpl$SaajData = cls2;
        }
        tempCur.setBookmark(cls2, saajData);
        tempCur.release();
    }

    public static Object saajCallback_getSaajData(Dom dom) {
        Object impl_saajCallback_getSaajData;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return impl_saajCallback_getSaajData(dom);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                impl_saajCallback_getSaajData = impl_saajCallback_getSaajData(dom);
            } finally {
            }
        }
        return impl_saajCallback_getSaajData;
    }

    public static Object impl_saajCallback_getSaajData(Dom dom) {
        Cur tempCur = dom.locale().tempCur();
        tempCur.moveToDom(dom);
        Class cls = class$org$apache$xmlbeans$impl$store$DomImpl$SaajData;
        if (cls == null) {
            cls = class$("org.apache.xmlbeans.impl.store.DomImpl$SaajData");
            class$org$apache$xmlbeans$impl$store$DomImpl$SaajData = cls;
        }
        SaajData saajData = (SaajData) tempCur.getBookmark(cls);
        Object obj = saajData == null ? null : saajData._obj;
        tempCur.release();
        return obj;
    }

    public static Element saajCallback_createSoapElement(Dom dom, QName qName, QName qName2) {
        Dom impl_saajCallback_createSoapElement;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                impl_saajCallback_createSoapElement = impl_saajCallback_createSoapElement(dom, qName, qName2);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    impl_saajCallback_createSoapElement = impl_saajCallback_createSoapElement(dom, qName, qName2);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Element) impl_saajCallback_createSoapElement;
    }

    public static Dom impl_saajCallback_createSoapElement(Dom dom, QName qName, QName qName2) {
        Cur tempCur = dom.locale().tempCur();
        tempCur.createElement(qName, qName2);
        Dom dom2 = tempCur.getDom();
        tempCur.release();
        return dom2;
    }

    public static Element saajCallback_importSoapElement(Dom dom, Element element, boolean z, QName qName) {
        Dom impl_saajCallback_importSoapElement;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                impl_saajCallback_importSoapElement = impl_saajCallback_importSoapElement(dom, element, z, qName);
            } finally {
            }
        } else {
            synchronized (locale) {
                locale.enter();
                try {
                    impl_saajCallback_importSoapElement = impl_saajCallback_importSoapElement(dom, element, z, qName);
                    locale.exit();
                } finally {
                }
            }
        }
        return (Element) impl_saajCallback_importSoapElement;
    }

    public static Dom impl_saajCallback_importSoapElement(Dom dom, Element element, boolean z, QName qName) {
        throw new RuntimeException("Not impl");
    }

    public static Text saajCallback_ensureSoapTextNode(Dom dom) {
        Text impl_saajCallback_ensureSoapTextNode;
        Locale locale = dom.locale();
        if (locale.noSync()) {
            locale.enter();
            try {
                return impl_saajCallback_ensureSoapTextNode(dom);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                impl_saajCallback_ensureSoapTextNode = impl_saajCallback_ensureSoapTextNode(dom);
            } finally {
            }
        }
        return impl_saajCallback_ensureSoapTextNode;
    }
}
