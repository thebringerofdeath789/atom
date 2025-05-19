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
public interface CTTabs extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTabs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttabsa2aatype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTabs newInstance() {
            return (CTTabs) XmlBeans.getContextTypeLoader().newInstance(CTTabs.type, null);
        }

        public static CTTabs newInstance(XmlOptions xmlOptions) {
            return (CTTabs) XmlBeans.getContextTypeLoader().newInstance(CTTabs.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTabs.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTabs) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTabs) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(File file) throws XmlException, IOException {
            return (CTTabs) XmlBeans.getContextTypeLoader().parse(file, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTabs) XmlBeans.getContextTypeLoader().parse(file, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTabs) XmlBeans.getContextTypeLoader().parse(inputStream, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTabs) XmlBeans.getContextTypeLoader().parse(inputStream, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(Reader reader) throws XmlException, IOException {
            return (CTTabs) XmlBeans.getContextTypeLoader().parse(reader, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTabs) XmlBeans.getContextTypeLoader().parse(reader, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(String str) throws XmlException {
            return (CTTabs) XmlBeans.getContextTypeLoader().parse(str, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTabs) XmlBeans.getContextTypeLoader().parse(str, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(URL url) throws XmlException, IOException {
            return (CTTabs) XmlBeans.getContextTypeLoader().parse(url, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTabs) XmlBeans.getContextTypeLoader().parse(url, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTabs) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTabs) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(Node node) throws XmlException {
            return (CTTabs) XmlBeans.getContextTypeLoader().parse(node, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTabs) XmlBeans.getContextTypeLoader().parse(node, CTTabs.type, xmlOptions);
        }
    }

    CTTabStop addNewTab();

    CTTabStop getTabArray(int i);

    CTTabStop[] getTabArray();

    List<CTTabStop> getTabList();

    CTTabStop insertNewTab(int i);

    void removeTab(int i);

    void setTabArray(int i, CTTabStop cTTabStop);

    void setTabArray(CTTabStop[] cTTabStopArr);

    int sizeOfTabArray();
}
