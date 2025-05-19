package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTFootnotes extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTFootnotes.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctfootnotes691ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFootnotes newInstance() {
            return (CTFootnotes) XmlBeans.getContextTypeLoader().newInstance(CTFootnotes.type, null);
        }

        public static CTFootnotes newInstance(XmlOptions xmlOptions) {
            return (CTFootnotes) XmlBeans.getContextTypeLoader().newInstance(CTFootnotes.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFootnotes.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFootnotes) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFootnotes) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(File file) throws XmlException, IOException {
            return (CTFootnotes) XmlBeans.getContextTypeLoader().parse(file, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFootnotes) XmlBeans.getContextTypeLoader().parse(file, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFootnotes) XmlBeans.getContextTypeLoader().parse(inputStream, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFootnotes) XmlBeans.getContextTypeLoader().parse(inputStream, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(Reader reader) throws XmlException, IOException {
            return (CTFootnotes) XmlBeans.getContextTypeLoader().parse(reader, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFootnotes) XmlBeans.getContextTypeLoader().parse(reader, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(String str) throws XmlException {
            return (CTFootnotes) XmlBeans.getContextTypeLoader().parse(str, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFootnotes) XmlBeans.getContextTypeLoader().parse(str, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(URL url) throws XmlException, IOException {
            return (CTFootnotes) XmlBeans.getContextTypeLoader().parse(url, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFootnotes) XmlBeans.getContextTypeLoader().parse(url, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTFootnotes) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTFootnotes) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(Node node) throws XmlException {
            return (CTFootnotes) XmlBeans.getContextTypeLoader().parse(node, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFootnotes) XmlBeans.getContextTypeLoader().parse(node, CTFootnotes.type, xmlOptions);
        }
    }

    CTFtnEdn addNewFootnote();

    CTFtnEdn getFootnoteArray(int i);

    CTFtnEdn[] getFootnoteArray();

    List<CTFtnEdn> getFootnoteList();

    CTFtnEdn insertNewFootnote(int i);

    void removeFootnote(int i);

    void setFootnoteArray(int i, CTFtnEdn cTFtnEdn);

    void setFootnoteArray(CTFtnEdn[] cTFtnEdnArr);

    int sizeOfFootnoteArray();
}
