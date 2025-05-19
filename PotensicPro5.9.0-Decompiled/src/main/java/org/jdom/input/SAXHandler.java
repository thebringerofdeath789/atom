package org.jdom.input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jdom.DefaultJDOMFactory;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMFactory;
import org.jdom.Namespace;
import org.jdom.Parent;
import org.xml.sax.DTDHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DeclHandler;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes5.dex */
public class SAXHandler extends DefaultHandler implements LexicalHandler, DeclHandler, DTDHandler {
    private static final String CVS_ID = "@(#) $RCSfile: SAXHandler.java,v $ $Revision: 1.68 $ $Date: 2004/08/31 06:14:05 $ $Name: jdom_1_0 $";
    private static final Map attrNameToTypeMap;
    private boolean atRoot;
    private Element currentElement;
    private List declaredNamespaces;
    private Document document;
    private int entityDepth;
    private boolean expand;
    private Map externalEntities;
    private JDOMFactory factory;
    private boolean ignoringWhite;
    private boolean inCDATA;
    private boolean inDTD;
    private boolean inInternalSubset;
    private StringBuffer internalSubset;
    private Locator locator;
    private boolean previousCDATA;
    private boolean suppress;
    private TextBuffer textBuffer;

    static {
        HashMap hashMap = new HashMap(13);
        attrNameToTypeMap = hashMap;
        hashMap.put("CDATA", new Integer(1));
        hashMap.put("ID", new Integer(2));
        hashMap.put("IDREF", new Integer(3));
        hashMap.put("IDREFS", new Integer(4));
        hashMap.put("ENTITY", new Integer(5));
        hashMap.put("ENTITIES", new Integer(6));
        hashMap.put(XmlErrorCodes.NMTOKEN, new Integer(7));
        hashMap.put("NMTOKENS", new Integer(8));
        hashMap.put("NOTATION", new Integer(9));
        hashMap.put("ENUMERATION", new Integer(10));
    }

    public SAXHandler() {
        this(null);
    }

    public SAXHandler(JDOMFactory jDOMFactory) {
        this.inDTD = false;
        this.inInternalSubset = false;
        this.previousCDATA = false;
        this.inCDATA = false;
        this.expand = true;
        this.suppress = false;
        this.entityDepth = 0;
        this.internalSubset = new StringBuffer();
        this.textBuffer = new TextBuffer();
        this.ignoringWhite = false;
        if (jDOMFactory != null) {
            this.factory = jDOMFactory;
        } else {
            this.factory = new DefaultJDOMFactory();
        }
        this.atRoot = true;
        this.declaredNamespaces = new ArrayList();
        this.externalEntities = new HashMap();
        this.document = this.factory.document(null);
    }

    protected void pushElement(Element element) {
        if (this.atRoot) {
            this.document.setRootElement(element);
            this.atRoot = false;
        } else {
            this.factory.addContent(this.currentElement, element);
        }
        this.currentElement = element;
    }

    public Document getDocument() {
        return this.document;
    }

    public JDOMFactory getFactory() {
        return this.factory;
    }

    public void setExpandEntities(boolean z) {
        this.expand = z;
    }

    public boolean getExpandEntities() {
        return this.expand;
    }

    public void setIgnoringElementContentWhitespace(boolean z) {
        this.ignoringWhite = z;
    }

    public boolean getIgnoringElementContentWhitespace() {
        return this.ignoringWhite;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() {
        Locator locator = this.locator;
        if (locator != null) {
            this.document.setBaseURI(locator.getSystemId());
        }
    }

    @Override // org.xml.sax.ext.DeclHandler
    public void externalEntityDecl(String str, String str2, String str3) throws SAXException {
        this.externalEntities.put(str, new String[]{str2, str3});
        if (this.inInternalSubset) {
            this.internalSubset.append("  <!ENTITY ").append(str);
            appendExternalId(str2, str3);
            this.internalSubset.append(">\n");
        }
    }

    @Override // org.xml.sax.ext.DeclHandler
    public void attributeDecl(String str, String str2, String str3, String str4, String str5) throws SAXException {
        if (this.inInternalSubset) {
            this.internalSubset.append("  <!ATTLIST ").append(str).append(' ').append(str2).append(' ').append(str3).append(' ');
            if (str4 != null) {
                this.internalSubset.append(str4);
            } else {
                this.internalSubset.append('\"').append(str5).append('\"');
            }
            if (str4 != null && str4.equals("#FIXED")) {
                this.internalSubset.append(" \"").append(str5).append('\"');
            }
            this.internalSubset.append(">\n");
        }
    }

    @Override // org.xml.sax.ext.DeclHandler
    public void elementDecl(String str, String str2) throws SAXException {
        if (this.inInternalSubset) {
            this.internalSubset.append("  <!ELEMENT ").append(str).append(' ').append(str2).append(">\n");
        }
    }

    @Override // org.xml.sax.ext.DeclHandler
    public void internalEntityDecl(String str, String str2) throws SAXException {
        if (this.inInternalSubset) {
            this.internalSubset.append("  <!ENTITY ");
            if (str.startsWith("%")) {
                this.internalSubset.append("% ").append(str.substring(1));
            } else {
                this.internalSubset.append(str);
            }
            this.internalSubset.append(" \"").append(str2).append("\">\n");
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void processingInstruction(String str, String str2) throws SAXException {
        if (this.suppress) {
            return;
        }
        flushCharacters();
        if (this.atRoot) {
            JDOMFactory jDOMFactory = this.factory;
            jDOMFactory.addContent(this.document, jDOMFactory.processingInstruction(str, str2));
        } else {
            this.factory.addContent(getCurrentElement(), this.factory.processingInstruction(str, str2));
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void skippedEntity(String str) throws SAXException {
        if (str.startsWith("%")) {
            return;
        }
        flushCharacters();
        this.factory.addContent(getCurrentElement(), this.factory.entityRef(str));
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startPrefixMapping(String str, String str2) throws SAXException {
        if (this.suppress) {
            return;
        }
        this.declaredNamespaces.add(Namespace.getNamespace(str, str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0052  */
    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void startElement(java.lang.String r8, java.lang.String r9, java.lang.String r10, org.xml.sax.Attributes r11) throws org.xml.sax.SAXException {
        /*
            r7 = this;
            boolean r0 = r7.suppress
            if (r0 == 0) goto L5
            return
        L5:
            java.lang.String r0 = ":"
            r1 = 0
            if (r8 == 0) goto L2b
            java.lang.String r2 = ""
            boolean r3 = r8.equals(r2)
            if (r3 != 0) goto L2b
            boolean r3 = r10.equals(r9)
            if (r3 != 0) goto L20
            int r2 = r10.indexOf(r0)
            java.lang.String r2 = r10.substring(r1, r2)
        L20:
            org.jdom.Namespace r8 = org.jdom.Namespace.getNamespace(r2, r8)
            org.jdom.JDOMFactory r10 = r7.factory
            org.jdom.Element r8 = r10.element(r9, r8)
            goto L31
        L2b:
            org.jdom.JDOMFactory r8 = r7.factory
            org.jdom.Element r8 = r8.element(r9)
        L31:
            java.util.List r9 = r7.declaredNamespaces
            int r9 = r9.size()
            if (r9 <= 0) goto L3c
            r7.transferNamespaces(r8)
        L3c:
            int r9 = r11.getLength()
            r10 = r1
        L41:
            if (r10 < r9) goto L5e
            r7.flushCharacters()
            boolean r9 = r7.atRoot
            if (r9 == 0) goto L52
            org.jdom.Document r9 = r7.document
            r9.setRootElement(r8)
            r7.atRoot = r1
            goto L5b
        L52:
            org.jdom.JDOMFactory r9 = r7.factory
            org.jdom.Element r10 = r7.getCurrentElement()
            r9.addContent(r10, r8)
        L5b:
            r7.currentElement = r8
            return
        L5e:
            java.lang.String r2 = r11.getLocalName(r10)
            java.lang.String r3 = r11.getQName(r10)
            java.lang.String r4 = r11.getType(r10)
            int r4 = getAttributeType(r4)
            java.lang.String r5 = "xmlns:"
            boolean r5 = r3.startsWith(r5)
            if (r5 != 0) goto Laf
            java.lang.String r5 = "xmlns"
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L7f
            goto Laf
        L7f:
            boolean r5 = r3.equals(r2)
            if (r5 != 0) goto La0
            int r5 = r3.indexOf(r0)
            java.lang.String r3 = r3.substring(r1, r5)
            java.lang.String r5 = r11.getURI(r10)
            org.jdom.Namespace r3 = org.jdom.Namespace.getNamespace(r3, r5)
            org.jdom.JDOMFactory r5 = r7.factory
            java.lang.String r6 = r11.getValue(r10)
            org.jdom.Attribute r2 = r5.attribute(r2, r6, r4, r3)
            goto Laa
        La0:
            org.jdom.JDOMFactory r3 = r7.factory
            java.lang.String r5 = r11.getValue(r10)
            org.jdom.Attribute r2 = r3.attribute(r2, r5, r4)
        Laa:
            org.jdom.JDOMFactory r3 = r7.factory
            r3.setAttribute(r8, r2)
        Laf:
            int r10 = r10 + 1
            goto L41
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jdom.input.SAXHandler.startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes):void");
    }

    private void transferNamespaces(Element element) {
        for (Namespace namespace : this.declaredNamespaces) {
            if (namespace != element.getNamespace()) {
                element.addNamespaceDeclaration(namespace);
            }
        }
        this.declaredNamespaces.clear();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        if (this.suppress || i2 == 0) {
            return;
        }
        if (this.previousCDATA != this.inCDATA) {
            flushCharacters();
        }
        this.textBuffer.append(cArr, i, i2);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
        if (this.ignoringWhite) {
            return;
        }
        characters(cArr, i, i2);
    }

    protected void flushCharacters() throws SAXException {
        flushCharacters(this.textBuffer.toString());
        this.textBuffer.clear();
    }

    protected void flushCharacters(String str) throws SAXException {
        if (str.length() == 0) {
            this.previousCDATA = this.inCDATA;
            return;
        }
        if (this.previousCDATA) {
            this.factory.addContent(getCurrentElement(), this.factory.cdata(str));
        } else {
            this.factory.addContent(getCurrentElement(), this.factory.text(str));
        }
        this.previousCDATA = this.inCDATA;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        if (this.suppress) {
            return;
        }
        flushCharacters();
        if (!this.atRoot) {
            Parent parent = this.currentElement.getParent();
            if (parent instanceof Document) {
                this.atRoot = true;
                return;
            } else {
                this.currentElement = (Element) parent;
                return;
            }
        }
        throw new SAXException(new StringBuffer("Ill-formed XML document (missing opening tag for ").append(str2).append(")").toString());
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startDTD(String str, String str2, String str3) throws SAXException {
        flushCharacters();
        JDOMFactory jDOMFactory = this.factory;
        jDOMFactory.addContent(this.document, jDOMFactory.docType(str, str2, str3));
        this.inDTD = true;
        this.inInternalSubset = true;
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endDTD() throws SAXException {
        this.document.getDocType().setInternalSubset(this.internalSubset.toString());
        this.inDTD = false;
        this.inInternalSubset = false;
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startEntity(String str) throws SAXException {
        String str2;
        int i = this.entityDepth + 1;
        this.entityDepth = i;
        if (this.expand || i > 1) {
            return;
        }
        if (str.equals("[dtd]")) {
            this.inInternalSubset = false;
            return;
        }
        if (this.inDTD || str.equals("amp") || str.equals("lt") || str.equals("gt") || str.equals("apos") || str.equals("quot") || this.expand) {
            return;
        }
        String[] strArr = (String[]) this.externalEntities.get(str);
        String str3 = null;
        if (strArr != null) {
            str3 = strArr[0];
            str2 = strArr[1];
        } else {
            str2 = null;
        }
        if (!this.atRoot) {
            flushCharacters();
            this.factory.addContent(getCurrentElement(), this.factory.entityRef(str, str3, str2));
        }
        this.suppress = true;
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endEntity(String str) throws SAXException {
        int i = this.entityDepth - 1;
        this.entityDepth = i;
        if (i == 0) {
            this.suppress = false;
        }
        if (str.equals("[dtd]")) {
            this.inInternalSubset = true;
        }
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startCDATA() throws SAXException {
        if (this.suppress) {
            return;
        }
        this.inCDATA = true;
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endCDATA() throws SAXException {
        if (this.suppress) {
            return;
        }
        this.previousCDATA = true;
        this.inCDATA = false;
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void comment(char[] cArr, int i, int i2) throws SAXException {
        if (this.suppress) {
            return;
        }
        flushCharacters();
        String str = new String(cArr, i, i2);
        boolean z = this.inDTD;
        if (z && this.inInternalSubset && !this.expand) {
            this.internalSubset.append("  <!--").append(str).append("-->\n");
            return;
        }
        if (z || str.equals("")) {
            return;
        }
        if (this.atRoot) {
            JDOMFactory jDOMFactory = this.factory;
            jDOMFactory.addContent(this.document, jDOMFactory.comment(str));
        } else {
            this.factory.addContent(getCurrentElement(), this.factory.comment(str));
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.DTDHandler
    public void notationDecl(String str, String str2, String str3) throws SAXException {
        if (this.inInternalSubset) {
            this.internalSubset.append("  <!NOTATION ").append(str);
            appendExternalId(str2, str3);
            this.internalSubset.append(">\n");
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.DTDHandler
    public void unparsedEntityDecl(String str, String str2, String str3, String str4) throws SAXException {
        if (this.inInternalSubset) {
            this.internalSubset.append("  <!ENTITY ").append(str);
            appendExternalId(str2, str3);
            this.internalSubset.append(" NDATA ").append(str4);
            this.internalSubset.append(">\n");
        }
    }

    private void appendExternalId(String str, String str2) {
        if (str != null) {
            this.internalSubset.append(" PUBLIC \"").append(str).append('\"');
        }
        if (str2 != null) {
            if (str == null) {
                this.internalSubset.append(" SYSTEM ");
            } else {
                this.internalSubset.append(' ');
            }
            this.internalSubset.append('\"').append(str2).append('\"');
        }
    }

    public Element getCurrentElement() throws SAXException {
        Element element = this.currentElement;
        if (element != null) {
            return element;
        }
        throw new SAXException("Ill-formed XML document (multiple root elements detected)");
    }

    private static int getAttributeType(String str) {
        Integer num = (Integer) attrNameToTypeMap.get(str);
        if (num == null) {
            return (str == null || str.length() <= 0 || str.charAt(0) != '(') ? 0 : 10;
        }
        return num.intValue();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
        this.locator = locator;
    }

    public Locator getDocumentLocator() {
        return this.locator;
    }
}
