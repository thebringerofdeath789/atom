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
public interface CTEndnotes extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTEndnotes.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctendnotescee2type");

    public static final class Factory {
        private Factory() {
        }

        public static CTEndnotes newInstance() {
            return (CTEndnotes) XmlBeans.getContextTypeLoader().newInstance(CTEndnotes.type, null);
        }

        public static CTEndnotes newInstance(XmlOptions xmlOptions) {
            return (CTEndnotes) XmlBeans.getContextTypeLoader().newInstance(CTEndnotes.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTEndnotes.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTEndnotes) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTEndnotes) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(File file) throws XmlException, IOException {
            return (CTEndnotes) XmlBeans.getContextTypeLoader().parse(file, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEndnotes) XmlBeans.getContextTypeLoader().parse(file, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(InputStream inputStream) throws XmlException, IOException {
            return (CTEndnotes) XmlBeans.getContextTypeLoader().parse(inputStream, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEndnotes) XmlBeans.getContextTypeLoader().parse(inputStream, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(Reader reader) throws XmlException, IOException {
            return (CTEndnotes) XmlBeans.getContextTypeLoader().parse(reader, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEndnotes) XmlBeans.getContextTypeLoader().parse(reader, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(String str) throws XmlException {
            return (CTEndnotes) XmlBeans.getContextTypeLoader().parse(str, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTEndnotes) XmlBeans.getContextTypeLoader().parse(str, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(URL url) throws XmlException, IOException {
            return (CTEndnotes) XmlBeans.getContextTypeLoader().parse(url, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEndnotes) XmlBeans.getContextTypeLoader().parse(url, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTEndnotes) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTEndnotes) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(Node node) throws XmlException {
            return (CTEndnotes) XmlBeans.getContextTypeLoader().parse(node, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTEndnotes) XmlBeans.getContextTypeLoader().parse(node, CTEndnotes.type, xmlOptions);
        }
    }

    CTFtnEdn addNewEndnote();

    CTFtnEdn getEndnoteArray(int i);

    CTFtnEdn[] getEndnoteArray();

    List<CTFtnEdn> getEndnoteList();

    CTFtnEdn insertNewEndnote(int i);

    void removeEndnote(int i);

    void setEndnoteArray(int i, CTFtnEdn cTFtnEdn);

    void setEndnoteArray(CTFtnEdn[] cTFtnEdnArr);

    int sizeOfEndnoteArray();
}
