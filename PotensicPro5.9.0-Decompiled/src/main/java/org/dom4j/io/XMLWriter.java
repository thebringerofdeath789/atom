package org.dom4j.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.dom4j.Attribute;
import org.dom4j.CDATA;
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
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.XMLFilterImpl;

/* loaded from: classes5.dex */
public class XMLWriter extends XMLFilterImpl implements LexicalHandler {
    private static final String PAD_TEXT = " ";
    private boolean autoFlush;
    private StringBuffer buffer;
    private boolean charsAdded;
    private boolean escapeText;
    private OutputFormat format;
    private boolean inDTD;
    private int indentLevel;
    private char lastChar;
    private boolean lastElementClosed;
    protected int lastOutputNodeType;
    private LexicalHandler lexicalHandler;
    private int maximumAllowedCharacter;
    private NamespaceStack namespaceStack;
    private Map namespacesMap;
    protected boolean preserve;
    private boolean resolveEntityRefs;
    private boolean showCommentsInDTDs;
    protected Writer writer;
    protected static final String[] LEXICAL_HANDLER_NAMES = {"http://xml.org/sax/properties/lexical-handler", "http://xml.org/sax/handlers/LexicalHandler"};
    protected static final OutputFormat DEFAULT_FORMAT = new OutputFormat();

    public XMLWriter(Writer writer) {
        this(writer, DEFAULT_FORMAT);
    }

    public XMLWriter(Writer writer, OutputFormat outputFormat) {
        this.resolveEntityRefs = true;
        this.lastElementClosed = false;
        this.preserve = false;
        this.namespaceStack = new NamespaceStack();
        this.escapeText = true;
        this.indentLevel = 0;
        this.buffer = new StringBuffer();
        this.charsAdded = false;
        this.writer = writer;
        this.format = outputFormat;
        this.namespaceStack.push(Namespace.NO_NAMESPACE);
    }

    public XMLWriter() {
        this.resolveEntityRefs = true;
        this.lastElementClosed = false;
        this.preserve = false;
        this.namespaceStack = new NamespaceStack();
        this.escapeText = true;
        this.indentLevel = 0;
        this.buffer = new StringBuffer();
        this.charsAdded = false;
        this.format = DEFAULT_FORMAT;
        this.writer = new BufferedWriter(new OutputStreamWriter(System.out));
        this.autoFlush = true;
        this.namespaceStack.push(Namespace.NO_NAMESPACE);
    }

    public XMLWriter(OutputStream outputStream) throws UnsupportedEncodingException {
        this.resolveEntityRefs = true;
        this.lastElementClosed = false;
        this.preserve = false;
        this.namespaceStack = new NamespaceStack();
        this.escapeText = true;
        this.indentLevel = 0;
        this.buffer = new StringBuffer();
        this.charsAdded = false;
        OutputFormat outputFormat = DEFAULT_FORMAT;
        this.format = outputFormat;
        this.writer = createWriter(outputStream, outputFormat.getEncoding());
        this.autoFlush = true;
        this.namespaceStack.push(Namespace.NO_NAMESPACE);
    }

    public XMLWriter(OutputStream outputStream, OutputFormat outputFormat) throws UnsupportedEncodingException {
        this.resolveEntityRefs = true;
        this.lastElementClosed = false;
        this.preserve = false;
        this.namespaceStack = new NamespaceStack();
        this.escapeText = true;
        this.indentLevel = 0;
        this.buffer = new StringBuffer();
        this.charsAdded = false;
        this.format = outputFormat;
        this.writer = createWriter(outputStream, outputFormat.getEncoding());
        this.autoFlush = true;
        this.namespaceStack.push(Namespace.NO_NAMESPACE);
    }

    public XMLWriter(OutputFormat outputFormat) throws UnsupportedEncodingException {
        this.resolveEntityRefs = true;
        this.lastElementClosed = false;
        this.preserve = false;
        this.namespaceStack = new NamespaceStack();
        this.escapeText = true;
        this.indentLevel = 0;
        this.buffer = new StringBuffer();
        this.charsAdded = false;
        this.format = outputFormat;
        this.writer = createWriter(System.out, outputFormat.getEncoding());
        this.autoFlush = true;
        this.namespaceStack.push(Namespace.NO_NAMESPACE);
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
        this.autoFlush = false;
    }

    public void setOutputStream(OutputStream outputStream) throws UnsupportedEncodingException {
        this.writer = createWriter(outputStream, this.format.getEncoding());
        this.autoFlush = true;
    }

    public boolean isEscapeText() {
        return this.escapeText;
    }

    public void setEscapeText(boolean z) {
        this.escapeText = z;
    }

    public void setIndentLevel(int i) {
        this.indentLevel = i;
    }

    public int getMaximumAllowedCharacter() {
        if (this.maximumAllowedCharacter == 0) {
            this.maximumAllowedCharacter = defaultMaximumAllowedCharacter();
        }
        return this.maximumAllowedCharacter;
    }

    public void setMaximumAllowedCharacter(int i) {
        this.maximumAllowedCharacter = i;
    }

    public void flush() throws IOException {
        this.writer.flush();
    }

    public void close() throws IOException {
        this.writer.close();
    }

    public void println() throws IOException {
        this.writer.write(this.format.getLineSeparator());
    }

    public void write(Attribute attribute) throws IOException {
        writeAttribute(attribute);
        if (this.autoFlush) {
            flush();
        }
    }

    public void write(Document document) throws IOException {
        writeDeclaration();
        if (document.getDocType() != null) {
            indent();
            writeDocType(document.getDocType());
        }
        int nodeCount = document.nodeCount();
        for (int i = 0; i < nodeCount; i++) {
            writeNode(document.node(i));
        }
        writePrintln();
        if (this.autoFlush) {
            flush();
        }
    }

    public void write(Element element) throws IOException {
        writeElement(element);
        if (this.autoFlush) {
            flush();
        }
    }

    public void write(CDATA cdata) throws IOException {
        writeCDATA(cdata.getText());
        if (this.autoFlush) {
            flush();
        }
    }

    public void write(Comment comment) throws IOException {
        writeComment(comment.getText());
        if (this.autoFlush) {
            flush();
        }
    }

    public void write(DocumentType documentType) throws IOException {
        writeDocType(documentType);
        if (this.autoFlush) {
            flush();
        }
    }

    public void write(Entity entity) throws IOException {
        writeEntity(entity);
        if (this.autoFlush) {
            flush();
        }
    }

    public void write(Namespace namespace) throws IOException {
        writeNamespace(namespace);
        if (this.autoFlush) {
            flush();
        }
    }

    public void write(ProcessingInstruction processingInstruction) throws IOException {
        writeProcessingInstruction(processingInstruction);
        if (this.autoFlush) {
            flush();
        }
    }

    public void write(String str) throws IOException {
        writeString(str);
        if (this.autoFlush) {
            flush();
        }
    }

    public void write(Text text) throws IOException {
        writeString(text.getText());
        if (this.autoFlush) {
            flush();
        }
    }

    public void write(Node node) throws IOException {
        writeNode(node);
        if (this.autoFlush) {
            flush();
        }
    }

    public void write(Object obj) throws IOException {
        if (obj instanceof Node) {
            write((Node) obj);
            return;
        }
        if (obj instanceof String) {
            write((String) obj);
            return;
        }
        if (!(obj instanceof List)) {
            if (obj != null) {
                throw new IOException(new StringBuffer().append("Invalid object: ").append(obj).toString());
            }
            return;
        }
        List list = (List) obj;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            write(list.get(i));
        }
    }

    public void writeOpen(Element element) throws IOException {
        this.writer.write("<");
        this.writer.write(element.getQualifiedName());
        writeAttributes(element);
        this.writer.write(">");
    }

    public void writeClose(Element element) throws IOException {
        writeClose(element.getQualifiedName());
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.XMLReader
    public void parse(InputSource inputSource) throws IOException, SAXException {
        installLexicalHandler();
        super.parse(inputSource);
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.XMLReader
    public void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
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
                super.setProperty(str, obj);
                return;
            }
        }
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.XMLReader
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
                return super.getProperty(str);
            }
        }
    }

    public void setLexicalHandler(LexicalHandler lexicalHandler) {
        Objects.requireNonNull(lexicalHandler, "Null lexical handler");
        this.lexicalHandler = lexicalHandler;
    }

    public LexicalHandler getLexicalHandler() {
        return this.lexicalHandler;
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
        super.setDocumentLocator(locator);
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        try {
            writeDeclaration();
            super.startDocument();
        } catch (IOException e) {
            handleException(e);
        }
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
        super.endDocument();
        if (this.autoFlush) {
            try {
                flush();
            } catch (IOException unused) {
            }
        }
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void startPrefixMapping(String str, String str2) throws SAXException {
        if (this.namespacesMap == null) {
            this.namespacesMap = new HashMap();
        }
        this.namespacesMap.put(str, str2);
        super.startPrefixMapping(str, str2);
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void endPrefixMapping(String str) throws SAXException {
        super.endPrefixMapping(str);
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        try {
            this.charsAdded = false;
            writePrintln();
            indent();
            this.writer.write("<");
            this.writer.write(str3);
            writeNamespaces();
            writeAttributes(attributes);
            this.writer.write(">");
            this.indentLevel++;
            this.lastOutputNodeType = 1;
            this.lastElementClosed = false;
            super.startElement(str, str2, str3, attributes);
        } catch (IOException e) {
            handleException(e);
        }
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        try {
            this.charsAdded = false;
            this.indentLevel--;
            if (this.lastElementClosed) {
                writePrintln();
                indent();
            }
            writeClose(str3);
            this.lastOutputNodeType = 1;
            this.lastElementClosed = true;
            super.endElement(str, str2, str3);
        } catch (IOException e) {
            handleException(e);
        }
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        if (cArr == null || cArr.length == 0 || i2 <= 0) {
            return;
        }
        try {
            String valueOf = String.valueOf(cArr, i, i2);
            if (this.escapeText) {
                valueOf = escapeElementEntities(valueOf);
            }
            if (this.format.isTrimText()) {
                if (this.lastOutputNodeType == 3 && !this.charsAdded) {
                    this.writer.write(32);
                } else if (this.charsAdded && Character.isWhitespace(this.lastChar)) {
                    this.writer.write(32);
                } else if (this.lastOutputNodeType == 1 && this.format.isPadText() && this.lastElementClosed && Character.isWhitespace(cArr[0])) {
                    this.writer.write(" ");
                }
                String str = "";
                StringTokenizer stringTokenizer = new StringTokenizer(valueOf);
                while (stringTokenizer.hasMoreTokens()) {
                    this.writer.write(str);
                    this.writer.write(stringTokenizer.nextToken());
                    str = " ";
                }
            } else {
                this.writer.write(valueOf);
            }
            this.charsAdded = true;
            this.lastChar = cArr[(i + i2) - 1];
            this.lastOutputNodeType = 3;
            super.characters(cArr, i, i2);
        } catch (IOException e) {
            handleException(e);
        }
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
        super.ignorableWhitespace(cArr, i, i2);
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void processingInstruction(String str, String str2) throws SAXException {
        try {
            indent();
            this.writer.write("<?");
            this.writer.write(str);
            this.writer.write(" ");
            this.writer.write(str2);
            this.writer.write("?>");
            writePrintln();
            this.lastOutputNodeType = 7;
            super.processingInstruction(str, str2);
        } catch (IOException e) {
            handleException(e);
        }
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.DTDHandler
    public void notationDecl(String str, String str2, String str3) throws SAXException {
        super.notationDecl(str, str2, str3);
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.DTDHandler
    public void unparsedEntityDecl(String str, String str2, String str3, String str4) throws SAXException {
        super.unparsedEntityDecl(str, str2, str3, str4);
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startDTD(String str, String str2, String str3) throws SAXException {
        this.inDTD = true;
        try {
            writeDocType(str, str2, str3);
        } catch (IOException e) {
            handleException(e);
        }
        LexicalHandler lexicalHandler = this.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.startDTD(str, str2, str3);
        }
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endDTD() throws SAXException {
        this.inDTD = false;
        LexicalHandler lexicalHandler = this.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.endDTD();
        }
    }

    public void startCDATA() throws SAXException {
        try {
            this.writer.write("<![CDATA[");
        } catch (IOException e) {
            handleException(e);
        }
        LexicalHandler lexicalHandler = this.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.startCDATA();
        }
    }

    public void endCDATA() throws SAXException {
        try {
            this.writer.write("]]>");
        } catch (IOException e) {
            handleException(e);
        }
        LexicalHandler lexicalHandler = this.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.endCDATA();
        }
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startEntity(String str) throws SAXException {
        try {
            writeEntityRef(str);
        } catch (IOException e) {
            handleException(e);
        }
        LexicalHandler lexicalHandler = this.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.startEntity(str);
        }
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endEntity(String str) throws SAXException {
        LexicalHandler lexicalHandler = this.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.endEntity(str);
        }
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void comment(char[] cArr, int i, int i2) throws SAXException {
        if (this.showCommentsInDTDs || !this.inDTD) {
            try {
                this.charsAdded = false;
                writeComment(new String(cArr, i, i2));
            } catch (IOException e) {
                handleException(e);
            }
        }
        LexicalHandler lexicalHandler = this.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.comment(cArr, i, i2);
        }
    }

    protected void writeElement(Element element) throws IOException {
        int nodeCount = element.nodeCount();
        String qualifiedName = element.getQualifiedName();
        writePrintln();
        indent();
        this.writer.write("<");
        this.writer.write(qualifiedName);
        int size = this.namespaceStack.size();
        Namespace namespace = element.getNamespace();
        if (isNamespaceDeclaration(namespace)) {
            this.namespaceStack.push(namespace);
            writeNamespace(namespace);
        }
        boolean z = true;
        for (int i = 0; i < nodeCount; i++) {
            Node node = element.node(i);
            if (node instanceof Namespace) {
                Namespace namespace2 = (Namespace) node;
                if (isNamespaceDeclaration(namespace2)) {
                    this.namespaceStack.push(namespace2);
                    writeNamespace(namespace2);
                }
            } else if ((node instanceof Element) || (node instanceof Comment)) {
                z = false;
            }
        }
        writeAttributes(element);
        this.lastOutputNodeType = 1;
        if (nodeCount <= 0) {
            writeEmptyElementClose(qualifiedName);
        } else {
            this.writer.write(">");
            if (z) {
                writeElementContent(element);
            } else {
                this.indentLevel++;
                writeElementContent(element);
                this.indentLevel--;
                writePrintln();
                indent();
            }
            this.writer.write("</");
            this.writer.write(qualifiedName);
            this.writer.write(">");
        }
        while (this.namespaceStack.size() > size) {
            this.namespaceStack.pop();
        }
        this.lastOutputNodeType = 1;
    }

    protected final boolean isElementSpacePreserved(Element element) {
        Attribute attribute = element.attribute("space");
        return attribute != null ? "xml".equals(attribute.getNamespacePrefix()) && "preserve".equals(attribute.getText()) : this.preserve;
    }

    protected void writeElementContent(Element element) throws IOException {
        char charAt;
        char charAt2;
        boolean isTrimText = this.format.isTrimText();
        boolean z = this.preserve;
        if (isTrimText) {
            boolean isElementSpacePreserved = isElementSpacePreserved(element);
            this.preserve = isElementSpacePreserved;
            isTrimText = !isElementSpacePreserved;
        }
        if (isTrimText) {
            int nodeCount = element.nodeCount();
            boolean z2 = true;
            Text text = null;
            StringBuffer stringBuffer = null;
            for (int i = 0; i < nodeCount; i++) {
                Node node = element.node(i);
                if (!(node instanceof Text)) {
                    char c = 'a';
                    if (!z2 && this.format.isPadText()) {
                        if (stringBuffer != null) {
                            charAt2 = stringBuffer.charAt(0);
                        } else {
                            charAt2 = text != null ? text.getText().charAt(0) : 'a';
                        }
                        if (Character.isWhitespace(charAt2)) {
                            this.writer.write(" ");
                        }
                    }
                    if (text != null) {
                        if (stringBuffer != null) {
                            writeString(stringBuffer.toString());
                            stringBuffer = null;
                        } else {
                            writeString(text.getText());
                        }
                        if (this.format.isPadText()) {
                            if (stringBuffer != null) {
                                c = stringBuffer.charAt(stringBuffer.length() - 1);
                            } else if (text != null) {
                                String text2 = text.getText();
                                c = text2.charAt(text2.length() - 1);
                            }
                            if (Character.isWhitespace(c)) {
                                this.writer.write(" ");
                            }
                        }
                        text = null;
                    }
                    writeNode(node);
                    z2 = false;
                } else if (text == null) {
                    text = (Text) node;
                } else {
                    if (stringBuffer == null) {
                        stringBuffer = new StringBuffer(text.getText());
                    }
                    stringBuffer.append(((Text) node).getText());
                }
            }
            if (text != null) {
                if (!z2 && this.format.isPadText()) {
                    if (stringBuffer != null) {
                        charAt = stringBuffer.charAt(0);
                    } else {
                        charAt = text.getText().charAt(0);
                    }
                    if (Character.isWhitespace(charAt)) {
                        this.writer.write(" ");
                    }
                }
                if (stringBuffer != null) {
                    writeString(stringBuffer.toString());
                } else {
                    writeString(text.getText());
                }
            }
        } else {
            int nodeCount2 = element.nodeCount();
            Node node2 = null;
            for (int i2 = 0; i2 < nodeCount2; i2++) {
                Node node3 = element.node(i2);
                if (node3 instanceof Text) {
                    writeNode(node3);
                    node2 = node3;
                } else {
                    if (node2 != null && this.format.isPadText()) {
                        String text3 = node2.getText();
                        if (Character.isWhitespace(text3.charAt(text3.length() - 1))) {
                            this.writer.write(" ");
                        }
                    }
                    writeNode(node3);
                    node2 = null;
                }
            }
        }
        this.preserve = z;
    }

    protected void writeCDATA(String str) throws IOException {
        this.writer.write("<![CDATA[");
        if (str != null) {
            this.writer.write(str);
        }
        this.writer.write("]]>");
        this.lastOutputNodeType = 4;
    }

    protected void writeDocType(DocumentType documentType) throws IOException {
        if (documentType != null) {
            documentType.write(this.writer);
            writePrintln();
        }
    }

    protected void writeNamespace(Namespace namespace) throws IOException {
        if (namespace != null) {
            writeNamespace(namespace.getPrefix(), namespace.getURI());
        }
    }

    protected void writeNamespaces() throws IOException {
        Map map = this.namespacesMap;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                writeNamespace((String) entry.getKey(), (String) entry.getValue());
            }
            this.namespacesMap = null;
        }
    }

    protected void writeNamespace(String str, String str2) throws IOException {
        if (str != null && str.length() > 0) {
            this.writer.write(" xmlns:");
            this.writer.write(str);
            this.writer.write("=\"");
        } else {
            this.writer.write(" xmlns=\"");
        }
        this.writer.write(str2);
        this.writer.write("\"");
    }

    protected void writeProcessingInstruction(ProcessingInstruction processingInstruction) throws IOException {
        this.writer.write("<?");
        this.writer.write(processingInstruction.getName());
        this.writer.write(" ");
        this.writer.write(processingInstruction.getText());
        this.writer.write("?>");
        writePrintln();
        this.lastOutputNodeType = 7;
    }

    protected void writeString(String str) throws IOException {
        if (str == null || str.length() <= 0) {
            return;
        }
        if (this.escapeText) {
            str = escapeElementEntities(str);
        }
        if (this.format.isTrimText()) {
            StringTokenizer stringTokenizer = new StringTokenizer(str);
            boolean z = true;
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                if (z) {
                    z = false;
                    if (this.lastOutputNodeType == 3) {
                        this.writer.write(" ");
                    }
                } else {
                    this.writer.write(" ");
                }
                this.writer.write(nextToken);
                this.lastOutputNodeType = 3;
                this.lastChar = nextToken.charAt(nextToken.length() - 1);
            }
            return;
        }
        this.lastOutputNodeType = 3;
        this.writer.write(str);
        this.lastChar = str.charAt(str.length() - 1);
    }

    protected void writeNodeText(Node node) throws IOException {
        String text = node.getText();
        if (text == null || text.length() <= 0) {
            return;
        }
        if (this.escapeText) {
            text = escapeElementEntities(text);
        }
        this.lastOutputNodeType = 3;
        this.writer.write(text);
        this.lastChar = text.charAt(text.length() - 1);
    }

    protected void writeNode(Node node) throws IOException {
        switch (node.getNodeType()) {
            case 1:
                writeElement((Element) node);
                return;
            case 2:
                writeAttribute((Attribute) node);
                return;
            case 3:
                writeNodeText(node);
                return;
            case 4:
                writeCDATA(node.getText());
                return;
            case 5:
                writeEntity((Entity) node);
                return;
            case 6:
            case 11:
            case 12:
            default:
                throw new IOException(new StringBuffer().append("Invalid node type: ").append(node).toString());
            case 7:
                writeProcessingInstruction((ProcessingInstruction) node);
                return;
            case 8:
                writeComment(node.getText());
                return;
            case 9:
                write((Document) node);
                return;
            case 10:
                writeDocType((DocumentType) node);
                return;
            case 13:
                return;
        }
    }

    protected void installLexicalHandler() {
        XMLReader parent = getParent();
        Objects.requireNonNull(parent, "No parent for filter");
        int i = 0;
        while (true) {
            String[] strArr = LEXICAL_HANDLER_NAMES;
            if (i >= strArr.length) {
                return;
            }
            try {
                parent.setProperty(strArr[i], this);
                return;
            } catch (SAXNotRecognizedException | SAXNotSupportedException unused) {
                i++;
            }
        }
    }

    protected void writeDocType(String str, String str2, String str3) throws IOException {
        boolean z;
        this.writer.write("<!DOCTYPE ");
        this.writer.write(str);
        if (str2 == null || str2.equals("")) {
            z = false;
        } else {
            this.writer.write(" PUBLIC \"");
            this.writer.write(str2);
            this.writer.write("\"");
            z = true;
        }
        if (str3 != null && !str3.equals("")) {
            if (!z) {
                this.writer.write(" SYSTEM");
            }
            this.writer.write(" \"");
            this.writer.write(str3);
            this.writer.write("\"");
        }
        this.writer.write(">");
        writePrintln();
    }

    protected void writeEntity(Entity entity) throws IOException {
        if (!resolveEntityRefs()) {
            writeEntityRef(entity.getName());
        } else {
            this.writer.write(entity.getText());
        }
    }

    protected void writeEntityRef(String str) throws IOException {
        this.writer.write("&");
        this.writer.write(str);
        this.writer.write(";");
        this.lastOutputNodeType = 5;
    }

    protected void writeComment(String str) throws IOException {
        if (this.format.isNewlines()) {
            println();
            indent();
        }
        this.writer.write("<!--");
        this.writer.write(str);
        this.writer.write("-->");
        this.lastOutputNodeType = 8;
    }

    protected void writeAttributes(Element element) throws IOException {
        int attributeCount = element.attributeCount();
        for (int i = 0; i < attributeCount; i++) {
            Attribute attribute = element.attribute(i);
            Namespace namespace = attribute.getNamespace();
            if (namespace != null && namespace != Namespace.NO_NAMESPACE && namespace != Namespace.XML_NAMESPACE) {
                if (!namespace.getURI().equals(this.namespaceStack.getURI(namespace.getPrefix()))) {
                    writeNamespace(namespace);
                    this.namespaceStack.push(namespace);
                }
            }
            String name = attribute.getName();
            if (name.startsWith(Sax2Dom.XMLNS_STRING)) {
                String substring = name.substring(6);
                if (this.namespaceStack.getNamespaceForPrefix(substring) == null) {
                    String value = attribute.getValue();
                    this.namespaceStack.push(substring, value);
                    writeNamespace(substring, value);
                }
            } else if (name.equals("xmlns")) {
                if (this.namespaceStack.getDefaultNamespace() == null) {
                    String value2 = attribute.getValue();
                    this.namespaceStack.push(null, value2);
                    writeNamespace(null, value2);
                }
            } else {
                char attributeQuoteCharacter = this.format.getAttributeQuoteCharacter();
                this.writer.write(" ");
                this.writer.write(attribute.getQualifiedName());
                this.writer.write("=");
                this.writer.write(attributeQuoteCharacter);
                writeEscapeAttributeEntities(attribute.getValue());
                this.writer.write(attributeQuoteCharacter);
            }
        }
    }

    protected void writeAttribute(Attribute attribute) throws IOException {
        this.writer.write(" ");
        this.writer.write(attribute.getQualifiedName());
        this.writer.write("=");
        char attributeQuoteCharacter = this.format.getAttributeQuoteCharacter();
        this.writer.write(attributeQuoteCharacter);
        writeEscapeAttributeEntities(attribute.getValue());
        this.writer.write(attributeQuoteCharacter);
        this.lastOutputNodeType = 2;
    }

    protected void writeAttributes(Attributes attributes) throws IOException {
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            writeAttribute(attributes, i);
        }
    }

    protected void writeAttribute(Attributes attributes, int i) throws IOException {
        char attributeQuoteCharacter = this.format.getAttributeQuoteCharacter();
        this.writer.write(" ");
        this.writer.write(attributes.getQName(i));
        this.writer.write("=");
        this.writer.write(attributeQuoteCharacter);
        writeEscapeAttributeEntities(attributes.getValue(i));
        this.writer.write(attributeQuoteCharacter);
    }

    protected void indent() throws IOException {
        String indent = this.format.getIndent();
        if (indent == null || indent.length() <= 0) {
            return;
        }
        for (int i = 0; i < this.indentLevel; i++) {
            this.writer.write(indent);
        }
    }

    protected void writePrintln() throws IOException {
        if (this.format.isNewlines()) {
            if (this.lastChar != this.format.getLineSeparator().charAt(r0.length() - 1)) {
                this.writer.write(this.format.getLineSeparator());
            }
        }
    }

    protected Writer createWriter(OutputStream outputStream, String str) throws UnsupportedEncodingException {
        return new BufferedWriter(new OutputStreamWriter(outputStream, str));
    }

    protected void writeDeclaration() throws IOException {
        String encoding = this.format.getEncoding();
        if (this.format.isSuppressDeclaration()) {
            return;
        }
        if (encoding.equals(InternalZipConstants.CHARSET_UTF8)) {
            this.writer.write("<?xml version=\"1.0\"");
            if (!this.format.isOmitEncoding()) {
                this.writer.write(" encoding=\"UTF-8\"");
            }
            this.writer.write("?>");
        } else {
            this.writer.write("<?xml version=\"1.0\"");
            if (!this.format.isOmitEncoding()) {
                this.writer.write(new StringBuffer().append(" encoding=\"").append(encoding).append("\"").toString());
            }
            this.writer.write("?>");
        }
        if (this.format.isNewLineAfterDeclaration()) {
            println();
        }
    }

    protected void writeClose(String str) throws IOException {
        this.writer.write("</");
        this.writer.write(str);
        this.writer.write(">");
    }

    protected void writeEmptyElementClose(String str) throws IOException {
        if (!this.format.isExpandEmptyElements()) {
            this.writer.write("/>");
            return;
        }
        this.writer.write("></");
        this.writer.write(str);
        this.writer.write(">");
    }

    protected boolean isExpandEmptyElements() {
        return this.format.isExpandEmptyElements();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0074 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.String escapeElementEntities(java.lang.String r10) {
        /*
            r9 = this;
            int r0 = r10.length()
            r1 = 0
            r2 = 0
            r5 = r1
            r3 = r2
            r4 = r3
        L9:
            if (r3 >= r0) goto L77
            char r6 = r10.charAt(r3)
            r7 = 9
            if (r6 == r7) goto L54
            r7 = 10
            if (r6 == r7) goto L54
            r7 = 13
            if (r6 == r7) goto L54
            r7 = 38
            if (r6 == r7) goto L51
            r7 = 60
            if (r6 == r7) goto L4e
            r7 = 62
            if (r6 == r7) goto L4b
            r7 = 32
            if (r6 < r7) goto L31
            boolean r7 = r9.shouldEncodeChar(r6)
            if (r7 == 0) goto L5d
        L31:
            java.lang.StringBuffer r7 = new java.lang.StringBuffer
            r7.<init>()
            java.lang.String r8 = "&#"
            java.lang.StringBuffer r7 = r7.append(r8)
            java.lang.StringBuffer r6 = r7.append(r6)
            java.lang.String r7 = ";"
            java.lang.StringBuffer r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            goto L5e
        L4b:
            java.lang.String r6 = "&gt;"
            goto L5e
        L4e:
            java.lang.String r6 = "&lt;"
            goto L5e
        L51:
            java.lang.String r6 = "&amp;"
            goto L5e
        L54:
            boolean r7 = r9.preserve
            if (r7 == 0) goto L5d
            java.lang.String r6 = java.lang.String.valueOf(r6)
            goto L5e
        L5d:
            r6 = r1
        L5e:
            if (r6 == 0) goto L74
            if (r5 != 0) goto L66
            char[] r5 = r10.toCharArray()
        L66:
            java.lang.StringBuffer r7 = r9.buffer
            int r8 = r3 - r4
            r7.append(r5, r4, r8)
            java.lang.StringBuffer r4 = r9.buffer
            r4.append(r6)
            int r4 = r3 + 1
        L74:
            int r3 = r3 + 1
            goto L9
        L77:
            if (r4 != 0) goto L7a
            return r10
        L7a:
            if (r4 >= r0) goto L88
            if (r5 != 0) goto L82
            char[] r5 = r10.toCharArray()
        L82:
            java.lang.StringBuffer r10 = r9.buffer
            int r3 = r3 - r4
            r10.append(r5, r4, r3)
        L88:
            java.lang.StringBuffer r10 = r9.buffer
            java.lang.String r10 = r10.toString()
            java.lang.StringBuffer r0 = r9.buffer
            r0.setLength(r2)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.dom4j.io.XMLWriter.escapeElementEntities(java.lang.String):java.lang.String");
    }

    protected void writeEscapeAttributeEntities(String str) throws IOException {
        if (str != null) {
            this.writer.write(escapeAttributeEntities(str));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0083 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.String escapeAttributeEntities(java.lang.String r11) {
        /*
            r10 = this;
            org.dom4j.io.OutputFormat r0 = r10.format
            char r0 = r0.getAttributeQuoteCharacter()
            int r1 = r11.length()
            r2 = 0
            r3 = 0
            r6 = r2
            r4 = r3
            r5 = r4
        Lf:
            if (r4 >= r1) goto L86
            char r7 = r11.charAt(r4)
            r8 = 9
            if (r7 == r8) goto L6c
            r8 = 10
            if (r7 == r8) goto L6c
            r8 = 13
            if (r7 == r8) goto L6c
            r8 = 34
            if (r7 == r8) goto L67
            r8 = 60
            if (r7 == r8) goto L64
            r8 = 62
            if (r7 == r8) goto L61
            r8 = 38
            if (r7 == r8) goto L5e
            r8 = 39
            if (r7 == r8) goto L59
            r8 = 32
            if (r7 < r8) goto L3f
            boolean r8 = r10.shouldEncodeChar(r7)
            if (r8 == 0) goto L6c
        L3f:
            java.lang.StringBuffer r8 = new java.lang.StringBuffer
            r8.<init>()
            java.lang.String r9 = "&#"
            java.lang.StringBuffer r8 = r8.append(r9)
            java.lang.StringBuffer r7 = r8.append(r7)
            java.lang.String r8 = ";"
            java.lang.StringBuffer r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            goto L6d
        L59:
            if (r0 != r8) goto L6c
            java.lang.String r7 = "&apos;"
            goto L6d
        L5e:
            java.lang.String r7 = "&amp;"
            goto L6d
        L61:
            java.lang.String r7 = "&gt;"
            goto L6d
        L64:
            java.lang.String r7 = "&lt;"
            goto L6d
        L67:
            if (r0 != r8) goto L6c
            java.lang.String r7 = "&quot;"
            goto L6d
        L6c:
            r7 = r2
        L6d:
            if (r7 == 0) goto L83
            if (r6 != 0) goto L75
            char[] r6 = r11.toCharArray()
        L75:
            java.lang.StringBuffer r8 = r10.buffer
            int r9 = r4 - r5
            r8.append(r6, r5, r9)
            java.lang.StringBuffer r5 = r10.buffer
            r5.append(r7)
            int r5 = r4 + 1
        L83:
            int r4 = r4 + 1
            goto Lf
        L86:
            if (r5 != 0) goto L89
            return r11
        L89:
            if (r5 >= r1) goto L97
            if (r6 != 0) goto L91
            char[] r6 = r11.toCharArray()
        L91:
            java.lang.StringBuffer r11 = r10.buffer
            int r4 = r4 - r5
            r11.append(r6, r5, r4)
        L97:
            java.lang.StringBuffer r11 = r10.buffer
            java.lang.String r11 = r11.toString()
            java.lang.StringBuffer r0 = r10.buffer
            r0.setLength(r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.dom4j.io.XMLWriter.escapeAttributeEntities(java.lang.String):java.lang.String");
    }

    protected boolean shouldEncodeChar(char c) {
        int maximumAllowedCharacter = getMaximumAllowedCharacter();
        return maximumAllowedCharacter > 0 && c > maximumAllowedCharacter;
    }

    protected int defaultMaximumAllowedCharacter() {
        String encoding = this.format.getEncoding();
        return (encoding == null || !encoding.equals("US-ASCII")) ? -1 : 127;
    }

    protected boolean isNamespaceDeclaration(Namespace namespace) {
        return (namespace == null || namespace == Namespace.XML_NAMESPACE || namespace.getURI() == null || this.namespaceStack.contains(namespace)) ? false : true;
    }

    protected void handleException(IOException iOException) throws SAXException {
        throw new SAXException(iOException);
    }

    protected OutputFormat getOutputFormat() {
        return this.format;
    }

    public boolean resolveEntityRefs() {
        return this.resolveEntityRefs;
    }

    public void setResolveEntityRefs(boolean z) {
        this.resolveEntityRefs = z;
    }
}
