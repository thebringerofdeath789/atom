package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
public interface CTHyperlinks extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTHyperlinks.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cthyperlinks6416type");

    public static final class Factory {
        private Factory() {
        }

        public static CTHyperlinks newInstance() {
            return (CTHyperlinks) XmlBeans.getContextTypeLoader().newInstance(CTHyperlinks.type, null);
        }

        public static CTHyperlinks newInstance(XmlOptions xmlOptions) {
            return (CTHyperlinks) XmlBeans.getContextTypeLoader().newInstance(CTHyperlinks.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTHyperlinks.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTHyperlinks.type, xmlOptions);
        }

        public static CTHyperlinks parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTHyperlinks) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTHyperlinks.type, (XmlOptions) null);
        }

        public static CTHyperlinks parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTHyperlinks) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTHyperlinks.type, xmlOptions);
        }

        public static CTHyperlinks parse(File file) throws XmlException, IOException {
            return (CTHyperlinks) XmlBeans.getContextTypeLoader().parse(file, CTHyperlinks.type, (XmlOptions) null);
        }

        public static CTHyperlinks parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHyperlinks) XmlBeans.getContextTypeLoader().parse(file, CTHyperlinks.type, xmlOptions);
        }

        public static CTHyperlinks parse(InputStream inputStream) throws XmlException, IOException {
            return (CTHyperlinks) XmlBeans.getContextTypeLoader().parse(inputStream, CTHyperlinks.type, (XmlOptions) null);
        }

        public static CTHyperlinks parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHyperlinks) XmlBeans.getContextTypeLoader().parse(inputStream, CTHyperlinks.type, xmlOptions);
        }

        public static CTHyperlinks parse(Reader reader) throws XmlException, IOException {
            return (CTHyperlinks) XmlBeans.getContextTypeLoader().parse(reader, CTHyperlinks.type, (XmlOptions) null);
        }

        public static CTHyperlinks parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHyperlinks) XmlBeans.getContextTypeLoader().parse(reader, CTHyperlinks.type, xmlOptions);
        }

        public static CTHyperlinks parse(String str) throws XmlException {
            return (CTHyperlinks) XmlBeans.getContextTypeLoader().parse(str, CTHyperlinks.type, (XmlOptions) null);
        }

        public static CTHyperlinks parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTHyperlinks) XmlBeans.getContextTypeLoader().parse(str, CTHyperlinks.type, xmlOptions);
        }

        public static CTHyperlinks parse(URL url) throws XmlException, IOException {
            return (CTHyperlinks) XmlBeans.getContextTypeLoader().parse(url, CTHyperlinks.type, (XmlOptions) null);
        }

        public static CTHyperlinks parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHyperlinks) XmlBeans.getContextTypeLoader().parse(url, CTHyperlinks.type, xmlOptions);
        }

        public static CTHyperlinks parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTHyperlinks) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTHyperlinks.type, (XmlOptions) null);
        }

        public static CTHyperlinks parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTHyperlinks) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTHyperlinks.type, xmlOptions);
        }

        public static CTHyperlinks parse(Node node) throws XmlException {
            return (CTHyperlinks) XmlBeans.getContextTypeLoader().parse(node, CTHyperlinks.type, (XmlOptions) null);
        }

        public static CTHyperlinks parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTHyperlinks) XmlBeans.getContextTypeLoader().parse(node, CTHyperlinks.type, xmlOptions);
        }
    }

    CTHyperlink addNewHyperlink();

    CTHyperlink getHyperlinkArray(int i);

    CTHyperlink[] getHyperlinkArray();

    List<CTHyperlink> getHyperlinkList();

    CTHyperlink insertNewHyperlink(int i);

    void removeHyperlink(int i);

    void setHyperlinkArray(int i, CTHyperlink cTHyperlink);

    void setHyperlinkArray(CTHyperlink[] cTHyperlinkArr);

    int sizeOfHyperlinkArray();
}
