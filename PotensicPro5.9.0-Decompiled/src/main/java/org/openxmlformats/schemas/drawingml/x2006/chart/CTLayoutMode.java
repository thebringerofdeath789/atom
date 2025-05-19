package org.openxmlformats.schemas.drawingml.x2006.chart;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.chart.STLayoutMode;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTLayoutMode extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTLayoutMode.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctlayoutmode53eftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTLayoutMode newInstance() {
            return (CTLayoutMode) XmlBeans.getContextTypeLoader().newInstance(CTLayoutMode.type, null);
        }

        public static CTLayoutMode newInstance(XmlOptions xmlOptions) {
            return (CTLayoutMode) XmlBeans.getContextTypeLoader().newInstance(CTLayoutMode.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLayoutMode.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLayoutMode.type, xmlOptions);
        }

        public static CTLayoutMode parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLayoutMode) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLayoutMode.type, (XmlOptions) null);
        }

        public static CTLayoutMode parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLayoutMode) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLayoutMode.type, xmlOptions);
        }

        public static CTLayoutMode parse(File file) throws XmlException, IOException {
            return (CTLayoutMode) XmlBeans.getContextTypeLoader().parse(file, CTLayoutMode.type, (XmlOptions) null);
        }

        public static CTLayoutMode parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayoutMode) XmlBeans.getContextTypeLoader().parse(file, CTLayoutMode.type, xmlOptions);
        }

        public static CTLayoutMode parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLayoutMode) XmlBeans.getContextTypeLoader().parse(inputStream, CTLayoutMode.type, (XmlOptions) null);
        }

        public static CTLayoutMode parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayoutMode) XmlBeans.getContextTypeLoader().parse(inputStream, CTLayoutMode.type, xmlOptions);
        }

        public static CTLayoutMode parse(Reader reader) throws XmlException, IOException {
            return (CTLayoutMode) XmlBeans.getContextTypeLoader().parse(reader, CTLayoutMode.type, (XmlOptions) null);
        }

        public static CTLayoutMode parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayoutMode) XmlBeans.getContextTypeLoader().parse(reader, CTLayoutMode.type, xmlOptions);
        }

        public static CTLayoutMode parse(String str) throws XmlException {
            return (CTLayoutMode) XmlBeans.getContextTypeLoader().parse(str, CTLayoutMode.type, (XmlOptions) null);
        }

        public static CTLayoutMode parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLayoutMode) XmlBeans.getContextTypeLoader().parse(str, CTLayoutMode.type, xmlOptions);
        }

        public static CTLayoutMode parse(URL url) throws XmlException, IOException {
            return (CTLayoutMode) XmlBeans.getContextTypeLoader().parse(url, CTLayoutMode.type, (XmlOptions) null);
        }

        public static CTLayoutMode parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayoutMode) XmlBeans.getContextTypeLoader().parse(url, CTLayoutMode.type, xmlOptions);
        }

        public static CTLayoutMode parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTLayoutMode) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLayoutMode.type, (XmlOptions) null);
        }

        public static CTLayoutMode parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTLayoutMode) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLayoutMode.type, xmlOptions);
        }

        public static CTLayoutMode parse(Node node) throws XmlException {
            return (CTLayoutMode) XmlBeans.getContextTypeLoader().parse(node, CTLayoutMode.type, (XmlOptions) null);
        }

        public static CTLayoutMode parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLayoutMode) XmlBeans.getContextTypeLoader().parse(node, CTLayoutMode.type, xmlOptions);
        }
    }

    STLayoutMode.Enum getVal();

    boolean isSetVal();

    void setVal(STLayoutMode.Enum r1);

    void unsetVal();

    STLayoutMode xgetVal();

    void xsetVal(STLayoutMode sTLayoutMode);
}
