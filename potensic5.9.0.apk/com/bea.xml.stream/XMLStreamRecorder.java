package com.bea.xml.stream;

import aavax.xml.stream.XMLInputFactory;
import aavax.xml.stream.XMLOutputFactory;
import aavax.xml.stream.XMLStreamException;
import aavax.xml.stream.XMLStreamReader;
import com.bea.xml.stream.util.ElementTypeNames;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import okhttp3.HttpUrl;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.xmlbeans.impl.common.Sax2Dom;

/* loaded from: classes.dex */
public class XMLStreamRecorder extends XMLWriterBase {
    public XMLStreamRecorder() {
    }

    public XMLStreamRecorder(Writer writer) {
        super(writer);
    }

    @Override // com.bea.xml.stream.XMLWriterBase
    protected String writeName(String str, String str2, String str3) throws XMLStreamException {
        if (!"".equals(str2)) {
            write(new StringBuffer().append("['").append(str2).append("':").toString());
        } else {
            write("[");
        }
        String writeName = super.writeName(str, str2, str3);
        write(PropertyUtils.INDEXED_DELIM2);
        return writeName;
    }

    protected void writeType(int i) throws XMLStreamException {
        closeStartElement();
        write(PropertyUtils.INDEXED_DELIM);
        write(ElementTypeNames.getEventTypeString(i));
        write(PropertyUtils.INDEXED_DELIM2);
    }

    @Override // com.bea.xml.stream.XMLWriterBase
    protected void openStartTag() throws XMLStreamException {
        write(PropertyUtils.INDEXED_DELIM);
    }

    @Override // com.bea.xml.stream.XMLWriterBase
    protected void closeStartTag() throws XMLStreamException {
        write("];\n");
    }

    @Override // com.bea.xml.stream.XMLWriterBase
    protected void openEndTag() throws XMLStreamException {
        write(PropertyUtils.INDEXED_DELIM);
    }

    @Override // com.bea.xml.stream.XMLWriterBase
    protected void closeEndTag() throws XMLStreamException {
        write(PropertyUtils.INDEXED_DELIM2);
    }

    @Override // com.bea.xml.stream.XMLWriterBase, aavax.xml.stream.XMLStreamWriter
    public void writeAttribute(String str, String str2, String str3) throws XMLStreamException {
        write("[[ATTRIBUTE]");
        writeName("", str, str2);
        write("=");
        writeCharactersInternal(str3.toCharArray(), 0, str3.length(), true);
        write("]");
    }

    @Override // com.bea.xml.stream.XMLWriterBase, aavax.xml.stream.XMLStreamWriter
    public void writeNamespace(String str, String str2) throws XMLStreamException {
        if (!isOpen()) {
            throw new XMLStreamException("A start element must be written before a namespace");
        }
        if (str == null || "".equals(str) || "xmlns".equals(str)) {
            writeDefaultNamespace(str2);
            return;
        }
        write("[[NAMESPACE][");
        write(Sax2Dom.XMLNS_STRING);
        write(str);
        write("]=[");
        write(str2);
        write("]");
        setPrefix(str, str2);
        write(PropertyUtils.INDEXED_DELIM2);
    }

    @Override // com.bea.xml.stream.XMLWriterBase, aavax.xml.stream.XMLStreamWriter
    public void writeDefaultNamespace(String str) throws XMLStreamException {
        write("[[DEFAULT][");
        if (!isOpen()) {
            throw new XMLStreamException("A start element must be written before the default namespace");
        }
        write("xmlns]");
        write("=[");
        write(str);
        write("]");
        setPrefix("", str);
        write(PropertyUtils.INDEXED_DELIM2);
    }

    @Override // com.bea.xml.stream.XMLWriterBase, aavax.xml.stream.XMLStreamWriter
    public void writeComment(String str) throws XMLStreamException {
        closeStartElement();
        write("[");
        if (str != null) {
            write(str);
        }
        write("]");
    }

    @Override // com.bea.xml.stream.XMLWriterBase, aavax.xml.stream.XMLStreamWriter
    public void writeProcessingInstruction(String str, String str2) throws XMLStreamException {
        closeStartElement();
        write("[");
        if (str != null) {
            write(new StringBuffer().append("[").append(str).append("]").toString());
        }
        if (str2 != null) {
            write(new StringBuffer().append(",[").append(str2).append("]").toString());
        }
        write("]");
    }

    @Override // com.bea.xml.stream.XMLWriterBase, aavax.xml.stream.XMLStreamWriter
    public void writeDTD(String str) throws XMLStreamException {
        write("[");
        super.write(str);
        write("]");
    }

    @Override // com.bea.xml.stream.XMLWriterBase, aavax.xml.stream.XMLStreamWriter
    public void writeCData(String str) throws XMLStreamException {
        write("[");
        if (str != null) {
            write(str);
        }
        write("]");
    }

    @Override // com.bea.xml.stream.XMLWriterBase, aavax.xml.stream.XMLStreamWriter
    public void writeEntityRef(String str) throws XMLStreamException {
        write("[");
        super.writeEntityRef(str);
        write("]");
    }

    @Override // com.bea.xml.stream.XMLWriterBase, aavax.xml.stream.XMLStreamWriter
    public void writeStartDocument() throws XMLStreamException {
        write("[[1.0],[utf-8]]");
    }

    @Override // com.bea.xml.stream.XMLWriterBase, aavax.xml.stream.XMLStreamWriter
    public void writeStartDocument(String str) throws XMLStreamException {
        write("[[");
        write(str);
        write("],[utf-8]]");
    }

    @Override // com.bea.xml.stream.XMLWriterBase, aavax.xml.stream.XMLStreamWriter
    public void writeStartDocument(String str, String str2) throws XMLStreamException {
        write("[[");
        write(str2);
        write("],[");
        write(str);
        write("]]");
    }

    @Override // com.bea.xml.stream.XMLWriterBase
    protected void writeCharactersInternal(char[] cArr, int i, int i2, boolean z) throws XMLStreamException {
        if (i2 == 0) {
            write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        write("[");
        write(cArr, i, i2);
        write("]");
    }

    @Override // com.bea.xml.stream.ReaderToWriter
    public void write(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        writeType(xMLStreamReader.getEventType());
        super.write(xMLStreamReader);
        if (isOpen()) {
            return;
        }
        write(";\n");
    }

    public static void main(String[] strArr) throws Exception {
        XMLInputFactory newInstance = XMLInputFactory.newInstance();
        XMLOutputFactory.newInstance();
        XMLStreamReader createXMLStreamReader = newInstance.createXMLStreamReader(new FileReader(strArr[0]));
        XMLStreamRecorder xMLStreamRecorder = new XMLStreamRecorder(new OutputStreamWriter(new FileOutputStream("out.stream")));
        while (createXMLStreamReader.hasNext()) {
            xMLStreamRecorder.write(createXMLStreamReader);
            createXMLStreamReader.next();
        }
        xMLStreamRecorder.write(createXMLStreamReader);
        xMLStreamRecorder.flush();
    }
}