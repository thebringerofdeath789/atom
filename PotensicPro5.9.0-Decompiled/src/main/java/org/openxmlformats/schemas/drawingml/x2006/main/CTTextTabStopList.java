package org.openxmlformats.schemas.drawingml.x2006.main;

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

/* loaded from: classes5.dex */
public interface CTTextTabStopList extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTextTabStopList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttexttabstoplistf539type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextTabStopList newInstance() {
            return (CTTextTabStopList) XmlBeans.getContextTypeLoader().newInstance(CTTextTabStopList.type, null);
        }

        public static CTTextTabStopList newInstance(XmlOptions xmlOptions) {
            return (CTTextTabStopList) XmlBeans.getContextTypeLoader().newInstance(CTTextTabStopList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextTabStopList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextTabStopList.type, xmlOptions);
        }

        public static CTTextTabStopList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextTabStopList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextTabStopList.type, (XmlOptions) null);
        }

        public static CTTextTabStopList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextTabStopList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextTabStopList.type, xmlOptions);
        }

        public static CTTextTabStopList parse(File file) throws XmlException, IOException {
            return (CTTextTabStopList) XmlBeans.getContextTypeLoader().parse(file, CTTextTabStopList.type, (XmlOptions) null);
        }

        public static CTTextTabStopList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextTabStopList) XmlBeans.getContextTypeLoader().parse(file, CTTextTabStopList.type, xmlOptions);
        }

        public static CTTextTabStopList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextTabStopList) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextTabStopList.type, (XmlOptions) null);
        }

        public static CTTextTabStopList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextTabStopList) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextTabStopList.type, xmlOptions);
        }

        public static CTTextTabStopList parse(Reader reader) throws XmlException, IOException {
            return (CTTextTabStopList) XmlBeans.getContextTypeLoader().parse(reader, CTTextTabStopList.type, (XmlOptions) null);
        }

        public static CTTextTabStopList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextTabStopList) XmlBeans.getContextTypeLoader().parse(reader, CTTextTabStopList.type, xmlOptions);
        }

        public static CTTextTabStopList parse(String str) throws XmlException {
            return (CTTextTabStopList) XmlBeans.getContextTypeLoader().parse(str, CTTextTabStopList.type, (XmlOptions) null);
        }

        public static CTTextTabStopList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextTabStopList) XmlBeans.getContextTypeLoader().parse(str, CTTextTabStopList.type, xmlOptions);
        }

        public static CTTextTabStopList parse(URL url) throws XmlException, IOException {
            return (CTTextTabStopList) XmlBeans.getContextTypeLoader().parse(url, CTTextTabStopList.type, (XmlOptions) null);
        }

        public static CTTextTabStopList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextTabStopList) XmlBeans.getContextTypeLoader().parse(url, CTTextTabStopList.type, xmlOptions);
        }

        public static CTTextTabStopList parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTextTabStopList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextTabStopList.type, (XmlOptions) null);
        }

        public static CTTextTabStopList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTextTabStopList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextTabStopList.type, xmlOptions);
        }

        public static CTTextTabStopList parse(Node node) throws XmlException {
            return (CTTextTabStopList) XmlBeans.getContextTypeLoader().parse(node, CTTextTabStopList.type, (XmlOptions) null);
        }

        public static CTTextTabStopList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextTabStopList) XmlBeans.getContextTypeLoader().parse(node, CTTextTabStopList.type, xmlOptions);
        }
    }

    CTTextTabStop addNewTab();

    CTTextTabStop getTabArray(int i);

    CTTextTabStop[] getTabArray();

    List<CTTextTabStop> getTabList();

    CTTextTabStop insertNewTab(int i);

    void removeTab(int i);

    void setTabArray(int i, CTTextTabStop cTTextTabStop);

    void setTabArray(CTTextTabStop[] cTTextTabStopArr);

    int sizeOfTabArray();
}
