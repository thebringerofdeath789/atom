package org.dom4j.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Entity;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public class HTMLWriter extends XMLWriter {
    protected static final OutputFormat DEFAULT_HTML_FORMAT;
    protected static final HashSet DEFAULT_PREFORMATTED_TAGS;
    private static String lineSeparator = System.getProperty("line.separator");
    private Stack formatStack;
    private String lastText;
    private int newLineAfterNTags;
    private HashSet omitElementCloseSet;
    private HashSet preformattedTags;
    private int tagsOuput;

    @Override // org.dom4j.io.XMLWriter, org.xml.sax.ext.LexicalHandler
    public void endCDATA() throws SAXException {
    }

    @Override // org.dom4j.io.XMLWriter, org.xml.sax.ext.LexicalHandler
    public void startCDATA() throws SAXException {
    }

    @Override // org.dom4j.io.XMLWriter
    protected void writeDeclaration() throws IOException {
    }

    static {
        HashSet hashSet = new HashSet();
        DEFAULT_PREFORMATTED_TAGS = hashSet;
        hashSet.add("PRE");
        hashSet.add("SCRIPT");
        hashSet.add("STYLE");
        hashSet.add("TEXTAREA");
        OutputFormat outputFormat = new OutputFormat("  ", true);
        DEFAULT_HTML_FORMAT = outputFormat;
        outputFormat.setTrimText(true);
        outputFormat.setSuppressDeclaration(true);
    }

    public HTMLWriter(Writer writer) {
        super(writer, DEFAULT_HTML_FORMAT);
        this.formatStack = new Stack();
        this.lastText = "";
        this.tagsOuput = 0;
        this.newLineAfterNTags = -1;
        this.preformattedTags = DEFAULT_PREFORMATTED_TAGS;
    }

    public HTMLWriter(Writer writer, OutputFormat outputFormat) {
        super(writer, outputFormat);
        this.formatStack = new Stack();
        this.lastText = "";
        this.tagsOuput = 0;
        this.newLineAfterNTags = -1;
        this.preformattedTags = DEFAULT_PREFORMATTED_TAGS;
    }

    public HTMLWriter() throws UnsupportedEncodingException {
        super(DEFAULT_HTML_FORMAT);
        this.formatStack = new Stack();
        this.lastText = "";
        this.tagsOuput = 0;
        this.newLineAfterNTags = -1;
        this.preformattedTags = DEFAULT_PREFORMATTED_TAGS;
    }

    public HTMLWriter(OutputFormat outputFormat) throws UnsupportedEncodingException {
        super(outputFormat);
        this.formatStack = new Stack();
        this.lastText = "";
        this.tagsOuput = 0;
        this.newLineAfterNTags = -1;
        this.preformattedTags = DEFAULT_PREFORMATTED_TAGS;
    }

    public HTMLWriter(OutputStream outputStream) throws UnsupportedEncodingException {
        super(outputStream, DEFAULT_HTML_FORMAT);
        this.formatStack = new Stack();
        this.lastText = "";
        this.tagsOuput = 0;
        this.newLineAfterNTags = -1;
        this.preformattedTags = DEFAULT_PREFORMATTED_TAGS;
    }

    public HTMLWriter(OutputStream outputStream, OutputFormat outputFormat) throws UnsupportedEncodingException {
        super(outputStream, outputFormat);
        this.formatStack = new Stack();
        this.lastText = "";
        this.tagsOuput = 0;
        this.newLineAfterNTags = -1;
        this.preformattedTags = DEFAULT_PREFORMATTED_TAGS;
    }

    @Override // org.dom4j.io.XMLWriter
    protected void writeCDATA(String str) throws IOException {
        if (getOutputFormat().isXHTML()) {
            super.writeCDATA(str);
        } else {
            this.writer.write(str);
        }
        this.lastOutputNodeType = 4;
    }

    @Override // org.dom4j.io.XMLWriter
    protected void writeEntity(Entity entity) throws IOException {
        this.writer.write(entity.getText());
        this.lastOutputNodeType = 5;
    }

    @Override // org.dom4j.io.XMLWriter
    protected void writeString(String str) throws IOException {
        if (str.equals("\n")) {
            if (this.formatStack.empty()) {
                return;
            }
            super.writeString(lineSeparator);
        } else {
            this.lastText = str;
            if (this.formatStack.empty()) {
                super.writeString(str.trim());
            } else {
                super.writeString(str);
            }
        }
    }

    @Override // org.dom4j.io.XMLWriter
    protected void writeClose(String str) throws IOException {
        if (omitElementClose(str)) {
            return;
        }
        super.writeClose(str);
    }

    @Override // org.dom4j.io.XMLWriter
    protected void writeEmptyElementClose(String str) throws IOException {
        if (getOutputFormat().isXHTML()) {
            if (omitElementClose(str)) {
                this.writer.write(" />");
                return;
            } else {
                super.writeEmptyElementClose(str);
                return;
            }
        }
        if (omitElementClose(str)) {
            this.writer.write(">");
        } else {
            super.writeEmptyElementClose(str);
        }
    }

    protected boolean omitElementClose(String str) {
        return internalGetOmitElementCloseSet().contains(str.toUpperCase());
    }

    private HashSet internalGetOmitElementCloseSet() {
        if (this.omitElementCloseSet == null) {
            HashSet hashSet = new HashSet();
            this.omitElementCloseSet = hashSet;
            loadOmitElementCloseSet(hashSet);
        }
        return this.omitElementCloseSet;
    }

    protected void loadOmitElementCloseSet(Set set) {
        set.add("AREA");
        set.add("BASE");
        set.add("BR");
        set.add("COL");
        set.add("HR");
        set.add("IMG");
        set.add("INPUT");
        set.add("LINK");
        set.add("META");
        set.add("P");
        set.add("PARAM");
    }

    public Set getOmitElementCloseSet() {
        return (Set) internalGetOmitElementCloseSet().clone();
    }

    public void setOmitElementCloseSet(Set set) {
        this.omitElementCloseSet = new HashSet();
        if (set != null) {
            this.omitElementCloseSet = new HashSet();
            for (Object obj : set) {
                if (obj != null) {
                    this.omitElementCloseSet.add(obj.toString().toUpperCase());
                }
            }
        }
    }

    public Set getPreformattedTags() {
        return (Set) this.preformattedTags.clone();
    }

    public void setPreformattedTags(Set set) {
        this.preformattedTags = new HashSet();
        if (set != null) {
            for (Object obj : set) {
                if (obj != null) {
                    this.preformattedTags.add(obj.toString().toUpperCase());
                }
            }
        }
    }

    public boolean isPreformattedTag(String str) {
        HashSet hashSet = this.preformattedTags;
        return hashSet != null && hashSet.contains(str.toUpperCase());
    }

    @Override // org.dom4j.io.XMLWriter
    protected void writeElement(Element element) throws IOException {
        int i;
        if (this.newLineAfterNTags == -1) {
            lazyInitNewLinesAfterNTags();
        }
        int i2 = this.newLineAfterNTags;
        if (i2 > 0 && (i = this.tagsOuput) > 0 && i % i2 == 0) {
            this.writer.write(lineSeparator);
        }
        this.tagsOuput++;
        String qualifiedName = element.getQualifiedName();
        String str = this.lastText;
        element.nodeCount();
        if (isPreformattedTag(qualifiedName)) {
            OutputFormat outputFormat = getOutputFormat();
            boolean isNewlines = outputFormat.isNewlines();
            boolean isTrimText = outputFormat.isTrimText();
            String indent = outputFormat.getIndent();
            this.formatStack.push(new FormatState(isNewlines, isTrimText, indent));
            try {
                super.writePrintln();
                if (str.trim().length() == 0 && indent != null && indent.length() > 0) {
                    this.writer.write(justSpaces(str));
                }
                outputFormat.setNewlines(false);
                outputFormat.setTrimText(false);
                outputFormat.setIndent("");
                super.writeElement(element);
                return;
            } finally {
                FormatState formatState = (FormatState) this.formatStack.pop();
                outputFormat.setNewlines(formatState.isNewlines());
                outputFormat.setTrimText(formatState.isTrimText());
                outputFormat.setIndent(formatState.getIndent());
            }
        }
        super.writeElement(element);
    }

    private String justSpaces(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt != '\n' && charAt != '\r') {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    private void lazyInitNewLinesAfterNTags() {
        if (getOutputFormat().isNewlines()) {
            this.newLineAfterNTags = 0;
        } else {
            this.newLineAfterNTags = getOutputFormat().getNewLineAfterNTags();
        }
    }

    public static String prettyPrintHTML(String str) throws IOException, UnsupportedEncodingException, DocumentException {
        return prettyPrintHTML(str, true, true, false, true);
    }

    public static String prettyPrintXHTML(String str) throws IOException, UnsupportedEncodingException, DocumentException {
        return prettyPrintHTML(str, true, true, true, false);
    }

    public static String prettyPrintHTML(String str, boolean z, boolean z2, boolean z3, boolean z4) throws IOException, UnsupportedEncodingException, DocumentException {
        StringWriter stringWriter = new StringWriter();
        OutputFormat createPrettyPrint = OutputFormat.createPrettyPrint();
        createPrettyPrint.setNewlines(z);
        createPrettyPrint.setTrimText(z2);
        createPrettyPrint.setXHTML(z3);
        createPrettyPrint.setExpandEmptyElements(z4);
        HTMLWriter hTMLWriter = new HTMLWriter(stringWriter, createPrettyPrint);
        hTMLWriter.write(DocumentHelper.parseText(str));
        hTMLWriter.flush();
        return stringWriter.toString();
    }

    private class FormatState {
        private String indent;
        private boolean newlines;
        private boolean trimText;

        public FormatState(boolean z, boolean z2, String str) {
            this.newlines = false;
            this.trimText = false;
            this.indent = "";
            this.newlines = z;
            this.trimText = z2;
            this.indent = str;
        }

        public boolean isNewlines() {
            return this.newlines;
        }

        public boolean isTrimText() {
            return this.trimText;
        }

        public String getIndent() {
            return this.indent;
        }
    }
}
