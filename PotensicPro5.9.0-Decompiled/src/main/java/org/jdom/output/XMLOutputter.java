package org.jdom.output;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;
import javax.xml.transform.Result;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.lang3.StringUtils;
import org.jdom.Attribute;
import org.jdom.CDATA;
import org.jdom.Comment;
import org.jdom.DocType;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.EntityRef;
import org.jdom.Namespace;
import org.jdom.ProcessingInstruction;
import org.jdom.Text;
import org.jdom.output.Format;

/* loaded from: classes5.dex */
public class XMLOutputter implements Cloneable {
    private static final String CVS_ID = "@(#) $RCSfile: XMLOutputter.java,v $ $Revision: 1.112 $ $Date: 2004/09/01 06:08:18 $ $Name: jdom_1_0 $";
    protected static final Format preserveFormat = Format.getRawFormat();
    protected Format currentFormat;
    private boolean escapeOutput;
    private Format userFormat;

    private static boolean isWhitespace(char c) {
        return c == ' ' || c == '\n' || c == '\t' || c == '\r';
    }

    public XMLOutputter() {
        Format rawFormat = Format.getRawFormat();
        this.userFormat = rawFormat;
        this.currentFormat = rawFormat;
        this.escapeOutput = true;
    }

    public XMLOutputter(Format format) {
        Format rawFormat = Format.getRawFormat();
        this.userFormat = rawFormat;
        this.currentFormat = rawFormat;
        this.escapeOutput = true;
        Format format2 = (Format) format.clone();
        this.userFormat = format2;
        this.currentFormat = format2;
    }

    public XMLOutputter(XMLOutputter xMLOutputter) {
        Format rawFormat = Format.getRawFormat();
        this.userFormat = rawFormat;
        this.currentFormat = rawFormat;
        this.escapeOutput = true;
        Format format = (Format) xMLOutputter.userFormat.clone();
        this.userFormat = format;
        this.currentFormat = format;
    }

    public void setFormat(Format format) {
        Format format2 = (Format) format.clone();
        this.userFormat = format2;
        this.currentFormat = format2;
    }

    public Format getFormat() {
        return (Format) this.userFormat.clone();
    }

    public void output(Document document, OutputStream outputStream) throws IOException {
        output(document, makeWriter(outputStream));
    }

    public void output(DocType docType, OutputStream outputStream) throws IOException {
        output(docType, makeWriter(outputStream));
    }

    public void output(Element element, OutputStream outputStream) throws IOException {
        output(element, makeWriter(outputStream));
    }

    public void outputElementContent(Element element, OutputStream outputStream) throws IOException {
        outputElementContent(element, makeWriter(outputStream));
    }

    public void output(List list, OutputStream outputStream) throws IOException {
        output(list, makeWriter(outputStream));
    }

    public void output(CDATA cdata, OutputStream outputStream) throws IOException {
        output(cdata, makeWriter(outputStream));
    }

    public void output(Text text, OutputStream outputStream) throws IOException {
        output(text, makeWriter(outputStream));
    }

    public void output(Comment comment, OutputStream outputStream) throws IOException {
        output(comment, makeWriter(outputStream));
    }

    public void output(ProcessingInstruction processingInstruction, OutputStream outputStream) throws IOException {
        output(processingInstruction, makeWriter(outputStream));
    }

    public void output(EntityRef entityRef, OutputStream outputStream) throws IOException {
        output(entityRef, makeWriter(outputStream));
    }

    private Writer makeWriter(OutputStream outputStream) throws UnsupportedEncodingException {
        return makeWriter(outputStream, this.userFormat.encoding);
    }

    private static Writer makeWriter(OutputStream outputStream, String str) throws UnsupportedEncodingException {
        if ("UTF-8".equals(str)) {
            str = InternalZipConstants.CHARSET_UTF8;
        }
        return new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(outputStream), str));
    }

    public void output(Document document, Writer writer) throws IOException {
        printDeclaration(writer, document, this.userFormat.encoding);
        List content = document.getContent();
        int size = content.size();
        for (int i = 0; i < size; i++) {
            Object obj = content.get(i);
            if (obj instanceof Element) {
                printElement(writer, document.getRootElement(), 0, createNamespaceStack());
            } else if (obj instanceof Comment) {
                printComment(writer, (Comment) obj);
            } else if (obj instanceof ProcessingInstruction) {
                printProcessingInstruction(writer, (ProcessingInstruction) obj);
            } else if (obj instanceof DocType) {
                printDocType(writer, document.getDocType());
                writer.write(this.currentFormat.lineSeparator);
            }
            newline(writer);
            indent(writer, 0);
        }
        writer.write(this.currentFormat.lineSeparator);
        writer.flush();
    }

    public void output(DocType docType, Writer writer) throws IOException {
        printDocType(writer, docType);
        writer.flush();
    }

    public void output(Element element, Writer writer) throws IOException {
        printElement(writer, element, 0, createNamespaceStack());
        writer.flush();
    }

    public void outputElementContent(Element element, Writer writer) throws IOException {
        List content = element.getContent();
        printContentRange(writer, content, 0, content.size(), 0, createNamespaceStack());
        writer.flush();
    }

    public void output(List list, Writer writer) throws IOException {
        printContentRange(writer, list, 0, list.size(), 0, createNamespaceStack());
        writer.flush();
    }

    public void output(CDATA cdata, Writer writer) throws IOException {
        printCDATA(writer, cdata);
        writer.flush();
    }

    public void output(Text text, Writer writer) throws IOException {
        printText(writer, text);
        writer.flush();
    }

    public void output(Comment comment, Writer writer) throws IOException {
        printComment(writer, comment);
        writer.flush();
    }

    public void output(ProcessingInstruction processingInstruction, Writer writer) throws IOException {
        boolean z = this.currentFormat.ignoreTrAXEscapingPIs;
        this.currentFormat.setIgnoreTrAXEscapingPIs(true);
        printProcessingInstruction(writer, processingInstruction);
        this.currentFormat.setIgnoreTrAXEscapingPIs(z);
        writer.flush();
    }

    public void output(EntityRef entityRef, Writer writer) throws IOException {
        printEntityRef(writer, entityRef);
        writer.flush();
    }

    public String outputString(Document document) {
        StringWriter stringWriter = new StringWriter();
        try {
            output(document, stringWriter);
        } catch (IOException unused) {
        }
        return stringWriter.toString();
    }

    public String outputString(DocType docType) {
        StringWriter stringWriter = new StringWriter();
        try {
            output(docType, stringWriter);
        } catch (IOException unused) {
        }
        return stringWriter.toString();
    }

    public String outputString(Element element) {
        StringWriter stringWriter = new StringWriter();
        try {
            output(element, stringWriter);
        } catch (IOException unused) {
        }
        return stringWriter.toString();
    }

    public String outputString(List list) {
        StringWriter stringWriter = new StringWriter();
        try {
            output(list, stringWriter);
        } catch (IOException unused) {
        }
        return stringWriter.toString();
    }

    public String outputString(CDATA cdata) {
        StringWriter stringWriter = new StringWriter();
        try {
            output(cdata, (Writer) stringWriter);
        } catch (IOException unused) {
        }
        return stringWriter.toString();
    }

    public String outputString(Text text) {
        StringWriter stringWriter = new StringWriter();
        try {
            output(text, stringWriter);
        } catch (IOException unused) {
        }
        return stringWriter.toString();
    }

    public String outputString(Comment comment) {
        StringWriter stringWriter = new StringWriter();
        try {
            output(comment, stringWriter);
        } catch (IOException unused) {
        }
        return stringWriter.toString();
    }

    public String outputString(ProcessingInstruction processingInstruction) {
        StringWriter stringWriter = new StringWriter();
        try {
            output(processingInstruction, stringWriter);
        } catch (IOException unused) {
        }
        return stringWriter.toString();
    }

    public String outputString(EntityRef entityRef) {
        StringWriter stringWriter = new StringWriter();
        try {
            output(entityRef, stringWriter);
        } catch (IOException unused) {
        }
        return stringWriter.toString();
    }

    protected void printDeclaration(Writer writer, Document document, String str) throws IOException {
        if (this.userFormat.omitDeclaration) {
            return;
        }
        writer.write("<?xml version=\"1.0\"");
        if (!this.userFormat.omitEncoding) {
            writer.write(new StringBuffer(" encoding=\"").append(str).append("\"").toString());
        }
        writer.write("?>");
        writer.write(this.currentFormat.lineSeparator);
    }

    protected void printDocType(Writer writer, DocType docType) throws IOException {
        boolean z;
        String publicID = docType.getPublicID();
        String systemID = docType.getSystemID();
        String internalSubset = docType.getInternalSubset();
        writer.write("<!DOCTYPE ");
        writer.write(docType.getElementName());
        if (publicID != null) {
            writer.write(" PUBLIC \"");
            writer.write(publicID);
            writer.write("\"");
            z = true;
        } else {
            z = false;
        }
        if (systemID != null) {
            if (!z) {
                writer.write(" SYSTEM");
            }
            writer.write(" \"");
            writer.write(systemID);
            writer.write("\"");
        }
        if (internalSubset != null && !internalSubset.equals("")) {
            writer.write(" [");
            writer.write(this.currentFormat.lineSeparator);
            writer.write(docType.getInternalSubset());
            writer.write("]");
        }
        writer.write(">");
    }

    protected void printComment(Writer writer, Comment comment) throws IOException {
        writer.write("<!--");
        writer.write(comment.getText());
        writer.write("-->");
    }

    protected void printProcessingInstruction(Writer writer, ProcessingInstruction processingInstruction) throws IOException {
        String target = processingInstruction.getTarget();
        boolean z = false;
        if (!this.currentFormat.ignoreTrAXEscapingPIs) {
            if (target.equals(Result.PI_DISABLE_OUTPUT_ESCAPING)) {
                this.escapeOutput = false;
            } else if (target.equals(Result.PI_ENABLE_OUTPUT_ESCAPING)) {
                this.escapeOutput = true;
            }
            z = true;
        }
        if (z) {
            return;
        }
        String data = processingInstruction.getData();
        if (!"".equals(data)) {
            writer.write("<?");
            writer.write(target);
            writer.write(StringUtils.SPACE);
            writer.write(data);
            writer.write("?>");
            return;
        }
        writer.write("<?");
        writer.write(target);
        writer.write("?>");
    }

    protected void printEntityRef(Writer writer, EntityRef entityRef) throws IOException {
        writer.write("&");
        writer.write(entityRef.getName());
        writer.write(";");
    }

    protected void printCDATA(Writer writer, CDATA cdata) throws IOException {
        String trim;
        if (this.currentFormat.mode == Format.TextMode.NORMALIZE) {
            trim = cdata.getTextNormalize();
        } else {
            trim = this.currentFormat.mode == Format.TextMode.TRIM ? cdata.getText().trim() : cdata.getText();
        }
        writer.write("<![CDATA[");
        writer.write(trim);
        writer.write("]]>");
    }

    protected void printText(Writer writer, Text text) throws IOException {
        String trim;
        if (this.currentFormat.mode == Format.TextMode.NORMALIZE) {
            trim = text.getTextNormalize();
        } else {
            trim = this.currentFormat.mode == Format.TextMode.TRIM ? text.getText().trim() : text.getText();
        }
        writer.write(escapeElementEntities(trim));
    }

    private void printString(Writer writer, String str) throws IOException {
        if (this.currentFormat.mode == Format.TextMode.NORMALIZE) {
            str = Text.normalizeString(str);
        } else if (this.currentFormat.mode == Format.TextMode.TRIM) {
            str = str.trim();
        }
        writer.write(escapeElementEntities(str));
    }

    protected void printElement(Writer writer, Element element, int i, NamespaceStack namespaceStack) throws IOException {
        List attributes = element.getAttributes();
        List content = element.getContent();
        String attributeValue = attributes != null ? element.getAttributeValue("space", Namespace.XML_NAMESPACE) : null;
        Format format = this.currentFormat;
        if ("default".equals(attributeValue)) {
            this.currentFormat = this.userFormat;
        } else if ("preserve".equals(attributeValue)) {
            this.currentFormat = preserveFormat;
        }
        writer.write("<");
        printQualifiedName(writer, element);
        int size = namespaceStack.size();
        printElementNamespace(writer, element, namespaceStack);
        printAdditionalNamespaces(writer, element, namespaceStack);
        if (attributes != null) {
            printAttributes(writer, attributes, element, namespaceStack);
        }
        int skipLeadingWhite = skipLeadingWhite(content, 0);
        int size2 = content.size();
        if (skipLeadingWhite >= size2) {
            if (this.currentFormat.expandEmptyElements) {
                writer.write("></");
                printQualifiedName(writer, element);
                writer.write(">");
            } else {
                writer.write(" />");
            }
        } else {
            writer.write(">");
            if (nextNonText(content, skipLeadingWhite) < size2) {
                newline(writer);
                printContentRange(writer, content, skipLeadingWhite, size2, i + 1, namespaceStack);
                newline(writer);
                indent(writer, i);
            } else {
                printTextRange(writer, content, skipLeadingWhite, size2);
            }
            writer.write("</");
            printQualifiedName(writer, element);
            writer.write(">");
        }
        while (namespaceStack.size() > size) {
            namespaceStack.pop();
        }
        this.currentFormat = format;
    }

    private void printContentRange(Writer writer, List list, int i, int i2, int i3, NamespaceStack namespaceStack) throws IOException {
        int i4 = i;
        while (i4 < i2) {
            boolean z = i4 == i;
            Object obj = list.get(i4);
            if ((obj instanceof Text) || (obj instanceof EntityRef)) {
                int skipLeadingWhite = skipLeadingWhite(list, i4);
                int nextNonText = nextNonText(list, skipLeadingWhite);
                if (skipLeadingWhite < nextNonText) {
                    if (!z) {
                        newline(writer);
                    }
                    indent(writer, i3);
                    printTextRange(writer, list, skipLeadingWhite, nextNonText);
                }
                i4 = nextNonText;
            } else {
                if (!z) {
                    newline(writer);
                }
                indent(writer, i3);
                if (obj instanceof Comment) {
                    printComment(writer, (Comment) obj);
                } else if (obj instanceof Element) {
                    printElement(writer, (Element) obj, i3, namespaceStack);
                } else if (obj instanceof ProcessingInstruction) {
                    printProcessingInstruction(writer, (ProcessingInstruction) obj);
                }
                i4++;
            }
        }
    }

    private void printTextRange(Writer writer, List list, int i, int i2) throws IOException {
        String stringBuffer;
        int skipLeadingWhite = skipLeadingWhite(list, i);
        if (skipLeadingWhite < list.size()) {
            int skipTrailingWhite = skipTrailingWhite(list, i2);
            String str = null;
            while (skipLeadingWhite < skipTrailingWhite) {
                Object obj = list.get(skipLeadingWhite);
                if (obj instanceof Text) {
                    stringBuffer = ((Text) obj).getText();
                } else if (obj instanceof EntityRef) {
                    stringBuffer = new StringBuffer("&").append(((EntityRef) obj).getValue()).append(";").toString();
                } else {
                    throw new IllegalStateException("Should see only CDATA, Text, or EntityRef");
                }
                if (stringBuffer != null && !"".equals(stringBuffer)) {
                    if (str != null && ((this.currentFormat.mode == Format.TextMode.NORMALIZE || this.currentFormat.mode == Format.TextMode.TRIM) && (endsWithWhite(str) || startsWithWhite(stringBuffer)))) {
                        writer.write(StringUtils.SPACE);
                    }
                    if (obj instanceof CDATA) {
                        printCDATA(writer, (CDATA) obj);
                    } else if (obj instanceof EntityRef) {
                        printEntityRef(writer, (EntityRef) obj);
                    } else {
                        printString(writer, stringBuffer);
                    }
                    str = stringBuffer;
                }
                skipLeadingWhite++;
            }
        }
    }

    private void printNamespace(Writer writer, Namespace namespace, NamespaceStack namespaceStack) throws IOException {
        String prefix = namespace.getPrefix();
        String uri = namespace.getURI();
        if (uri.equals(namespaceStack.getURI(prefix))) {
            return;
        }
        writer.write(" xmlns");
        if (!prefix.equals("")) {
            writer.write(":");
            writer.write(prefix);
        }
        writer.write("=\"");
        writer.write(uri);
        writer.write("\"");
        namespaceStack.push(namespace);
    }

    protected void printAttributes(Writer writer, List list, Element element, NamespaceStack namespaceStack) throws IOException {
        for (int i = 0; i < list.size(); i++) {
            Attribute attribute = (Attribute) list.get(i);
            Namespace namespace = attribute.getNamespace();
            if (namespace != Namespace.NO_NAMESPACE && namespace != Namespace.XML_NAMESPACE) {
                printNamespace(writer, namespace, namespaceStack);
            }
            writer.write(StringUtils.SPACE);
            printQualifiedName(writer, attribute);
            writer.write("=");
            writer.write("\"");
            writer.write(escapeAttributeEntities(attribute.getValue()));
            writer.write("\"");
        }
    }

    private void printElementNamespace(Writer writer, Element element, NamespaceStack namespaceStack) throws IOException {
        Namespace namespace = element.getNamespace();
        if (namespace == Namespace.XML_NAMESPACE) {
            return;
        }
        if (namespace == Namespace.NO_NAMESPACE && namespaceStack.getURI("") == null) {
            return;
        }
        printNamespace(writer, namespace, namespaceStack);
    }

    private void printAdditionalNamespaces(Writer writer, Element element, NamespaceStack namespaceStack) throws IOException {
        List additionalNamespaces = element.getAdditionalNamespaces();
        if (additionalNamespaces != null) {
            for (int i = 0; i < additionalNamespaces.size(); i++) {
                printNamespace(writer, (Namespace) additionalNamespaces.get(i), namespaceStack);
            }
        }
    }

    private void newline(Writer writer) throws IOException {
        if (this.currentFormat.indent != null) {
            writer.write(this.currentFormat.lineSeparator);
        }
    }

    private void indent(Writer writer, int i) throws IOException {
        if (this.currentFormat.indent == null || this.currentFormat.indent.equals("")) {
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            writer.write(this.currentFormat.indent);
        }
    }

    private int skipLeadingWhite(List list, int i) {
        if (i < 0) {
            i = 0;
        }
        int size = list.size();
        if (this.currentFormat.mode == Format.TextMode.TRIM_FULL_WHITE || this.currentFormat.mode == Format.TextMode.NORMALIZE || this.currentFormat.mode == Format.TextMode.TRIM) {
            while (i < size) {
                if (!isAllWhitespace(list.get(i))) {
                    return i;
                }
                i++;
            }
        }
        return i;
    }

    private int skipTrailingWhite(List list, int i) {
        int size = list.size();
        if (i > size) {
            i = size;
        }
        if (this.currentFormat.mode == Format.TextMode.TRIM_FULL_WHITE || this.currentFormat.mode == Format.TextMode.NORMALIZE || this.currentFormat.mode == Format.TextMode.TRIM) {
            while (i >= 0 && isAllWhitespace(list.get(i - 1))) {
                i--;
            }
        }
        return i;
    }

    private static int nextNonText(List list, int i) {
        if (i < 0) {
            i = 0;
        }
        int size = list.size();
        while (i < size) {
            Object obj = list.get(i);
            if (!(obj instanceof Text) && !(obj instanceof EntityRef)) {
                return i;
            }
            i++;
        }
        return size;
    }

    private boolean isAllWhitespace(Object obj) {
        String text;
        if (obj instanceof String) {
            text = (String) obj;
        } else if (obj instanceof Text) {
            text = ((Text) obj).getText();
        } else {
            if (obj instanceof EntityRef) {
            }
            return false;
        }
        String str = text;
        for (int i = 0; i < str.length(); i++) {
            if (!isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean startsWithWhite(String str) {
        return str != null && str.length() > 0 && isWhitespace(str.charAt(0));
    }

    private boolean endsWithWhite(String str) {
        return str != null && str.length() > 0 && isWhitespace(str.charAt(str.length() - 1));
    }

    public String escapeAttributeEntities(String str) {
        String str2;
        EscapeStrategy escapeStrategy = this.currentFormat.escapeStrategy;
        StringBuffer stringBuffer = null;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\t') {
                str2 = "&#x9;";
            } else if (charAt == '\n') {
                str2 = "&#xA;";
            } else if (charAt == '\r') {
                str2 = "&#xD;";
            } else if (charAt == '\"') {
                str2 = "&quot;";
            } else if (charAt == '&') {
                str2 = "&amp;";
            } else if (charAt == '<') {
                str2 = "&lt;";
            } else if (charAt != '>') {
                str2 = escapeStrategy.shouldEscape(charAt) ? new StringBuffer("&#x").append(Integer.toHexString(charAt)).append(";").toString() : null;
            } else {
                str2 = "&gt;";
            }
            if (stringBuffer == null) {
                if (str2 != null) {
                    stringBuffer = new StringBuffer(str.length() + 20);
                    stringBuffer.append(str.substring(0, i));
                    stringBuffer.append(str2);
                }
            } else if (str2 == null) {
                stringBuffer.append(charAt);
            } else {
                stringBuffer.append(str2);
            }
        }
        return stringBuffer == null ? str : stringBuffer.toString();
    }

    public String escapeElementEntities(String str) {
        String str2;
        if (!this.escapeOutput) {
            return str;
        }
        EscapeStrategy escapeStrategy = this.currentFormat.escapeStrategy;
        StringBuffer stringBuffer = null;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\n') {
                str2 = this.currentFormat.lineSeparator;
            } else if (charAt == '\r') {
                str2 = "&#xD;";
            } else if (charAt == '&') {
                str2 = "&amp;";
            } else if (charAt == '<') {
                str2 = "&lt;";
            } else if (charAt != '>') {
                str2 = escapeStrategy.shouldEscape(charAt) ? new StringBuffer("&#x").append(Integer.toHexString(charAt)).append(";").toString() : null;
            } else {
                str2 = "&gt;";
            }
            if (stringBuffer == null) {
                if (str2 != null) {
                    stringBuffer = new StringBuffer(str.length() + 20);
                    stringBuffer.append(str.substring(0, i));
                    stringBuffer.append(str2);
                }
            } else if (str2 == null) {
                stringBuffer.append(charAt);
            } else {
                stringBuffer.append(str2);
            }
        }
        return stringBuffer == null ? str : stringBuffer.toString();
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e.toString());
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.userFormat.lineSeparator.length(); i++) {
            char charAt = this.userFormat.lineSeparator.charAt(i);
            if (charAt == '\t') {
                stringBuffer.append("\\t");
            } else if (charAt == '\n') {
                stringBuffer.append("\\n");
            } else if (charAt == '\r') {
                stringBuffer.append("\\r");
            } else {
                stringBuffer.append(new StringBuffer("[").append((int) charAt).append("]").toString());
            }
        }
        return new StringBuffer("XMLOutputter[omitDeclaration = ").append(this.userFormat.omitDeclaration).append(", ").append("encoding = ").append(this.userFormat.encoding).append(", ").append("omitEncoding = ").append(this.userFormat.omitEncoding).append(", ").append("indent = '").append(this.userFormat.indent).append("'").append(", ").append("expandEmptyElements = ").append(this.userFormat.expandEmptyElements).append(", ").append("lineSeparator = '").append(stringBuffer.toString()).append("', ").append("textMode = ").append(this.userFormat.mode).append("]").toString();
    }

    private NamespaceStack createNamespaceStack() {
        return new NamespaceStack();
    }

    protected class NamespaceStack extends org.jdom.output.NamespaceStack {
        protected NamespaceStack() {
        }
    }

    private void printQualifiedName(Writer writer, Element element) throws IOException {
        if (element.getNamespace().getPrefix().length() == 0) {
            writer.write(element.getName());
            return;
        }
        writer.write(element.getNamespace().getPrefix());
        writer.write(58);
        writer.write(element.getName());
    }

    private void printQualifiedName(Writer writer, Attribute attribute) throws IOException {
        String prefix = attribute.getNamespace().getPrefix();
        if (prefix != null && !prefix.equals("")) {
            writer.write(prefix);
            writer.write(58);
            writer.write(attribute.getName());
            return;
        }
        writer.write(attribute.getName());
    }
}
