package com.bea.xml.stream;

import aavax.xml.namespace.NamespaceContext;
import aavax.xml.stream.XMLOutputFactory;
import aavax.xml.stream.XMLStreamException;
import aavax.xml.stream.XMLStreamWriter;
import com.bea.xml.stream.util.NamespaceContextImpl;
import com.bea.xml.stream.util.Stack;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public class XMLWriterBase extends ReaderToWriter implements XMLStreamWriter {
    protected static final String DEFAULTNS = "";
    private ConfigurationContextBase config;
    private CharsetEncoder encoder;
    private boolean isPrefixDefaulting;
    private HashSet needToWrite;
    private Writer writer;
    private boolean startElementOpened = false;
    private boolean isEmpty = false;
    private Stack localNameStack = new Stack();
    private Stack prefixStack = new Stack();
    private Stack uriStack = new Stack();
    protected NamespaceContextImpl context = new NamespaceContextImpl();
    private int defaultPrefixCount = 0;
    private HashSet setNeedsWritingNs = new HashSet();

    public XMLWriterBase() {
    }

    public XMLWriterBase(Writer writer) {
        this.writer = writer;
        setWriter(writer);
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
        setStreamWriter(this);
        if (writer instanceof OutputStreamWriter) {
            this.encoder = Charset.forName(((OutputStreamWriter) writer).getEncoding()).newEncoder();
        } else {
            this.encoder = null;
        }
    }

    public void setConfigurationContext(ConfigurationContextBase configurationContextBase) {
        this.config = configurationContextBase;
        this.isPrefixDefaulting = configurationContextBase.isPrefixDefaulting();
    }

    protected void write(String str) throws XMLStreamException {
        try {
            this.writer.write(str);
        } catch (IOException e) {
            throw new XMLStreamException(e);
        }
    }

    protected void write(char c) throws XMLStreamException {
        try {
            this.writer.write(c);
        } catch (IOException e) {
            throw new XMLStreamException(e);
        }
    }

    protected void write(char[] cArr) throws XMLStreamException {
        try {
            this.writer.write(cArr);
        } catch (IOException e) {
            throw new XMLStreamException(e);
        }
    }

    protected void write(char[] cArr, int i, int i2) throws XMLStreamException {
        try {
            this.writer.write(cArr, i, i2);
        } catch (IOException e) {
            throw new XMLStreamException(e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
    
        slowWriteCharacters(r4, r5, r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void writeCharactersInternal(char[] r4, int r5, int r6, boolean r7) throws aavax.xml.stream.XMLStreamException {
        /*
            r3 = this;
            if (r6 != 0) goto L3
            return
        L3:
            r0 = 0
        L4:
            if (r0 >= r6) goto L3d
            int r1 = r0 + r5
            char r1 = r4[r1]
            r2 = 34
            if (r1 == r2) goto L38
            r2 = 38
            if (r1 == r2) goto L3d
            r2 = 60
            if (r1 == r2) goto L3d
            r2 = 62
            if (r1 == r2) goto L3d
            r2 = 32
            if (r1 >= r2) goto L29
            if (r7 != 0) goto L3d
            r2 = 9
            if (r1 == r2) goto L3a
            r2 = 10
            if (r1 == r2) goto L3a
            goto L3d
        L29:
            r2 = 127(0x7f, float:1.78E-43)
            if (r1 <= r2) goto L3a
            java.nio.charset.CharsetEncoder r2 = r3.encoder
            if (r2 == 0) goto L3a
            boolean r1 = r2.canEncode(r1)
            if (r1 != 0) goto L3a
            goto L3d
        L38:
            if (r7 != 0) goto L3d
        L3a:
            int r0 = r0 + 1
            goto L4
        L3d:
            if (r0 >= r6) goto L43
            r3.slowWriteCharacters(r4, r5, r6, r7)
            goto L46
        L43:
            r3.write(r4, r5, r6)
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bea.xml.stream.XMLWriterBase.writeCharactersInternal(char[], int, int, boolean):void");
    }

    private void slowWriteCharacters(char[] cArr, int i, int i2, boolean z) throws XMLStreamException {
        CharsetEncoder charsetEncoder;
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i3 + i];
            if (c != '\"') {
                if (c == '&') {
                    write("&amp;");
                } else if (c == '<') {
                    write("&lt;");
                } else if (c == '>') {
                    write("&gt;");
                } else if (c < ' ') {
                    if (z || (c != '\t' && c != '\n')) {
                        write("&#");
                        write(Integer.toString(c));
                        write(';');
                    }
                    write(c);
                } else {
                    if (c > 127 && (charsetEncoder = this.encoder) != null && !charsetEncoder.canEncode(c)) {
                        write("&#");
                        write(Integer.toString(c));
                        write(';');
                    }
                    write(c);
                }
            } else {
                if (z) {
                    write("&quot;");
                }
                write(c);
            }
        }
    }

    protected void closeStartElement() throws XMLStreamException {
        if (this.startElementOpened) {
            closeStartTag();
            this.startElementOpened = false;
        }
    }

    protected boolean isOpen() {
        return this.startElementOpened;
    }

    protected void closeStartTag() throws XMLStreamException {
        flushNamespace();
        clearNeedsWritingNs();
        if (this.isEmpty) {
            write("/>");
            this.isEmpty = false;
        } else {
            write(">");
        }
    }

    private void openStartElement() throws XMLStreamException {
        if (this.startElementOpened) {
            closeStartTag();
        } else {
            this.startElementOpened = true;
        }
    }

    protected String writeName(String str, String str2, String str3) throws XMLStreamException {
        if (!"".equals(str2)) {
            str = getPrefixInternal(str2);
        }
        if (!"".equals(str)) {
            write(str);
            write(":");
        }
        write(str3);
        return str;
    }

    private String getPrefixInternal(String str) {
        String prefix = this.context.getPrefix(str);
        return prefix == null ? "" : prefix;
    }

    protected String getURIInternal(String str) {
        String namespaceURI = this.context.getNamespaceURI(str);
        return namespaceURI == null ? "" : namespaceURI;
    }

    protected void openStartTag() throws XMLStreamException {
        write("<");
    }

    private boolean needToWrite(String str) {
        if (this.needToWrite == null) {
            this.needToWrite = new HashSet();
        }
        boolean contains = this.needToWrite.contains(str);
        this.needToWrite.add(str);
        return contains;
    }

    private void prepareNamespace(String str) throws XMLStreamException {
        if (this.isPrefixDefaulting && !"".equals(str) && getPrefix(str) == null) {
            this.defaultPrefixCount++;
            setPrefix(new StringBuffer().append("ns").append(this.defaultPrefixCount).toString(), str);
        }
    }

    private void removeNamespace(String str) {
        HashSet hashSet;
        if (!this.isPrefixDefaulting || (hashSet = this.needToWrite) == null) {
            return;
        }
        hashSet.remove(str);
    }

    private void flushNamespace() throws XMLStreamException {
        HashSet hashSet;
        if (!this.isPrefixDefaulting || (hashSet = this.needToWrite) == null) {
            return;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String prefix = this.context.getPrefix(str);
            if (prefix == null) {
                throw new XMLStreamException(new StringBuffer().append("Unable to default prefix with uri:").append(str).toString());
            }
            writeNamespace(prefix, str);
        }
        this.needToWrite.clear();
    }

    protected void writeStartElementInternal(String str, String str2) throws XMLStreamException {
        if (str == null) {
            throw new IllegalArgumentException("The namespace URI may not be null");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("The local name  may not be null");
        }
        openStartElement();
        openStartTag();
        prepareNamespace(str);
        this.prefixStack.push(writeName("", str, str2));
        this.localNameStack.push(str2);
        this.uriStack.push(str);
    }

    @Override // aavax.xml.stream.XMLStreamWriter
    public void writeStartElement(String str, String str2) throws XMLStreamException {
        this.context.openScope();
        writeStartElementInternal(str, str2);
    }

    @Override // aavax.xml.stream.XMLStreamWriter
    public void writeStartElement(String str, String str2, String str3) throws XMLStreamException {
        if (str3 == null) {
            throw new IllegalArgumentException("The namespace URI may not be null");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("The local name may not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("The prefix may not be null");
        }
        this.context.openScope();
        prepareNamespace(str3);
        this.context.bindNamespace(str, str3);
        writeStartElementInternal(str3, str2);
    }

    @Override // aavax.xml.stream.XMLStreamWriter
    public void writeStartElement(String str) throws XMLStreamException {
        this.context.openScope();
        writeStartElement("", str);
    }

    @Override // aavax.xml.stream.XMLStreamWriter
    public void writeEmptyElement(String str, String str2) throws XMLStreamException {
        openStartElement();
        prepareNamespace(str);
        this.isEmpty = true;
        write("<");
        writeName("", str, str2);
    }

    @Override // aavax.xml.stream.XMLStreamWriter
    public void writeEmptyElement(String str, String str2, String str3) throws XMLStreamException {
        openStartElement();
        prepareNamespace(str3);
        this.isEmpty = true;
        write("<");
        write(str);
        write(":");
        write(str2);
    }

    @Override // aavax.xml.stream.XMLStreamWriter
    public void writeEmptyElement(String str) throws XMLStreamException {
        writeEmptyElement("", str);
    }

    protected void openEndTag() throws XMLStreamException {
        write("</");
    }

    protected void closeEndTag() throws XMLStreamException {
        write(">");
    }

    @Override // aavax.xml.stream.XMLStreamWriter
    public void writeEndElement() throws XMLStreamException {
        if (isOpen()) {
            closeStartElement();
        }
        String str = (String) this.prefixStack.pop();
        String str2 = (String) this.localNameStack.pop();
        this.uriStack.pop();
        openEndTag();
        writeName(str, "", str2);
        closeEndTag();
        this.context.closeScope();
    }

    public void writeRaw(String str) throws XMLStreamException {
        closeStartElement();
        write(str);
    }

    @Override // aavax.xml.stream.XMLStreamWriter
    public void close() throws XMLStreamException {
        flush();
    }

    @Override // aavax.xml.stream.XMLStreamWriter
    public void flush() throws XMLStreamException {
        try {
            this.writer.flush();
        } catch (IOException e) {
            throw new XMLStreamException(e);
        }
    }

    @Override // aavax.xml.stream.XMLStreamWriter
    public void writeEndDocument() throws XMLStreamException {
        while (!this.localNameStack.isEmpty()) {
            writeEndElement();
        }
    }

    @Override // aavax.xml.stream.XMLStreamWriter
    public void writeAttribute(String str, String str2) throws XMLStreamException {
        writeAttribute("", str, str2);
    }

    public void writeAttribute(String str, String str2, String str3) throws XMLStreamException {
        if (!isOpen()) {
            throw new XMLStreamException("A start element must be written before an attribute");
        }
        prepareNamespace(str);
        write(StringUtils.SPACE);
        writeName("", str, str2);
        write("=\"");
        writeCharactersInternal(str3.toCharArray(), 0, str3.length(), true);
        write("\"");
    }

    @Override // aavax.xml.stream.XMLStreamWriter
    public void writeAttribute(String str, String str2, String str3, String str4) throws XMLStreamException {
        if (!isOpen()) {
            throw new XMLStreamException("A start element must be written before an attribute");
        }
        prepareNamespace(str2);
        this.context.bindNamespace(str, str2);
        write(StringUtils.SPACE);
        writeName(str, str2, str3);
        write("=\"");
        writeCharactersInternal(str4.toCharArray(), 0, str4.length(), true);
        write("\"");
    }

    public void writeNamespace(String str, String str2) throws XMLStreamException {
        if (!isOpen()) {
            throw new XMLStreamException("A start element must be written before a namespace");
        }
        if (str == null || "".equals(str) || "xmlns".equals(str)) {
            writeDefaultNamespace(str2);
            return;
        }
        if (needsWritingNs(str)) {
            write(" xmlns:");
            write(str);
            write("=\"");
            write(str2);
            write("\"");
            setPrefix(str, str2);
        }
    }

    private void clearNeedsWritingNs() {
        this.setNeedsWritingNs.clear();
    }

    private boolean needsWritingNs(String str) {
        boolean z = !this.setNeedsWritingNs.contains(str);
        if (z) {
            this.setNeedsWritingNs.add(str);
        }
        return z;
    }

    public void writeDefaultNamespace(String str) throws XMLStreamException {
        if (!isOpen()) {
            throw new XMLStreamException("A start element must be written before the default namespace");
        }
        if (needsWritingNs("")) {
            write(" xmlns");
            write("=\"");
            write(str);
            write("\"");
            setPrefix("", str);
        }
    }

    public void writeComment(String str) throws XMLStreamException {
        closeStartElement();
        write("<!--");
        if (str != null) {
            write(str);
        }
        write("-->");
    }

    @Override // aavax.xml.stream.XMLStreamWriter
    public void writeProcessingInstruction(String str) throws XMLStreamException {
        closeStartElement();
        writeProcessingInstruction(str, null);
    }

    public void writeProcessingInstruction(String str, String str2) throws XMLStreamException {
        closeStartElement();
        write("<?");
        if (str != null) {
            write(str);
        }
        if (str2 != null) {
            write(' ');
            write(str2);
        }
        write("?>");
    }

    public void writeDTD(String str) throws XMLStreamException {
        write(str);
    }

    public void writeCData(String str) throws XMLStreamException {
        closeStartElement();
        write("<![CDATA[");
        if (str != null) {
            write(str);
        }
        write("]]>");
    }

    public void writeEntityRef(String str) throws XMLStreamException {
        closeStartElement();
        write("&");
        write(str);
        write(";");
    }

    public void writeStartDocument() throws XMLStreamException {
        write("<?xml version='1.0' encoding='utf-8'?>");
    }

    public void writeStartDocument(String str) throws XMLStreamException {
        write("<?xml version='");
        write(str);
        write("'?>");
    }

    public void writeStartDocument(String str, String str2) throws XMLStreamException {
        write("<?xml version='");
        write(str2);
        write("' encoding='");
        write(str);
        write("'?>");
    }

    @Override // aavax.xml.stream.XMLStreamWriter
    public void writeCharacters(String str) throws XMLStreamException {
        closeStartElement();
        writeCharactersInternal(str.toCharArray(), 0, str.length(), false);
    }

    @Override // aavax.xml.stream.XMLStreamWriter
    public void writeCharacters(char[] cArr, int i, int i2) throws XMLStreamException {
        closeStartElement();
        writeCharactersInternal(cArr, i, i2, false);
    }

    @Override // aavax.xml.stream.XMLStreamWriter
    public String getPrefix(String str) throws XMLStreamException {
        return this.context.getPrefix(str);
    }

    @Override // aavax.xml.stream.XMLStreamWriter
    public void setPrefix(String str, String str2) throws XMLStreamException {
        needToWrite(str2);
        this.context.bindNamespace(str, str2);
    }

    @Override // aavax.xml.stream.XMLStreamWriter
    public void setDefaultNamespace(String str) throws XMLStreamException {
        needToWrite(str);
        this.context.bindDefaultNameSpace(str);
    }

    @Override // aavax.xml.stream.XMLStreamWriter
    public void setNamespaceContext(NamespaceContext namespaceContext) throws XMLStreamException {
        Objects.requireNonNull(namespaceContext, "The namespace  context may not be null.");
        this.context = new NamespaceContextImpl(namespaceContext);
    }

    @Override // aavax.xml.stream.XMLStreamWriter
    public NamespaceContext getNamespaceContext() {
        return this.context;
    }

    @Override // aavax.xml.stream.XMLStreamWriter
    public Object getProperty(String str) throws IllegalArgumentException {
        return this.config.getProperty(str);
    }

    public static void main(String[] strArr) throws Exception {
        XMLOutputFactory newInstance = XMLOutputFactoryBase.newInstance();
        newInstance.setProperty(XMLOutputFactory.IS_REPAIRING_NAMESPACES, new Boolean(true));
        XMLStreamWriter createXMLStreamWriter = newInstance.createXMLStreamWriter(new OutputStreamWriter(new FileOutputStream("tmp"), "us-ascii"));
        createXMLStreamWriter.writeStartDocument();
        createXMLStreamWriter.setPrefix("c", "http://c");
        createXMLStreamWriter.setDefaultNamespace("http://d");
        createXMLStreamWriter.writeStartElement("http://c", "a");
        createXMLStreamWriter.writeAttribute("b", "blah");
        createXMLStreamWriter.writeEmptyElement("http://c", "d");
        createXMLStreamWriter.writeEmptyElement("http://d", "e");
        createXMLStreamWriter.writeEmptyElement("http://e", "f");
        createXMLStreamWriter.writeEmptyElement("http://f", "g");
        createXMLStreamWriter.writeAttribute("http://c", "chris", "fry");
        createXMLStreamWriter.writeCharacters("foo bar foo");
        createXMLStreamWriter.writeCharacters("bad char coming[");
        createXMLStreamWriter.writeCharacters("$");
        createXMLStreamWriter.writeCharacters("]");
        createXMLStreamWriter.writeEndElement();
        createXMLStreamWriter.flush();
    }
}
