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
import org.openxmlformats.schemas.drawingml.x2006.chart.STLayoutTarget;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTLayoutTarget extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTLayoutTarget.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctlayouttarget1001type");

    public static final class Factory {
        private Factory() {
        }

        public static CTLayoutTarget newInstance() {
            return (CTLayoutTarget) XmlBeans.getContextTypeLoader().newInstance(CTLayoutTarget.type, null);
        }

        public static CTLayoutTarget newInstance(XmlOptions xmlOptions) {
            return (CTLayoutTarget) XmlBeans.getContextTypeLoader().newInstance(CTLayoutTarget.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLayoutTarget.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLayoutTarget.type, xmlOptions);
        }

        public static CTLayoutTarget parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLayoutTarget) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLayoutTarget.type, (XmlOptions) null);
        }

        public static CTLayoutTarget parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLayoutTarget) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLayoutTarget.type, xmlOptions);
        }

        public static CTLayoutTarget parse(File file) throws XmlException, IOException {
            return (CTLayoutTarget) XmlBeans.getContextTypeLoader().parse(file, CTLayoutTarget.type, (XmlOptions) null);
        }

        public static CTLayoutTarget parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayoutTarget) XmlBeans.getContextTypeLoader().parse(file, CTLayoutTarget.type, xmlOptions);
        }

        public static CTLayoutTarget parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLayoutTarget) XmlBeans.getContextTypeLoader().parse(inputStream, CTLayoutTarget.type, (XmlOptions) null);
        }

        public static CTLayoutTarget parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayoutTarget) XmlBeans.getContextTypeLoader().parse(inputStream, CTLayoutTarget.type, xmlOptions);
        }

        public static CTLayoutTarget parse(Reader reader) throws XmlException, IOException {
            return (CTLayoutTarget) XmlBeans.getContextTypeLoader().parse(reader, CTLayoutTarget.type, (XmlOptions) null);
        }

        public static CTLayoutTarget parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayoutTarget) XmlBeans.getContextTypeLoader().parse(reader, CTLayoutTarget.type, xmlOptions);
        }

        public static CTLayoutTarget parse(String str) throws XmlException {
            return (CTLayoutTarget) XmlBeans.getContextTypeLoader().parse(str, CTLayoutTarget.type, (XmlOptions) null);
        }

        public static CTLayoutTarget parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLayoutTarget) XmlBeans.getContextTypeLoader().parse(str, CTLayoutTarget.type, xmlOptions);
        }

        public static CTLayoutTarget parse(URL url) throws XmlException, IOException {
            return (CTLayoutTarget) XmlBeans.getContextTypeLoader().parse(url, CTLayoutTarget.type, (XmlOptions) null);
        }

        public static CTLayoutTarget parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayoutTarget) XmlBeans.getContextTypeLoader().parse(url, CTLayoutTarget.type, xmlOptions);
        }

        public static CTLayoutTarget parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTLayoutTarget) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLayoutTarget.type, (XmlOptions) null);
        }

        public static CTLayoutTarget parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTLayoutTarget) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLayoutTarget.type, xmlOptions);
        }

        public static CTLayoutTarget parse(Node node) throws XmlException {
            return (CTLayoutTarget) XmlBeans.getContextTypeLoader().parse(node, CTLayoutTarget.type, (XmlOptions) null);
        }

        public static CTLayoutTarget parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLayoutTarget) XmlBeans.getContextTypeLoader().parse(node, CTLayoutTarget.type, xmlOptions);
        }
    }

    STLayoutTarget.Enum getVal();

    boolean isSetVal();

    void setVal(STLayoutTarget.Enum r1);

    void unsetVal();

    STLayoutTarget xgetVal();

    void xsetVal(STLayoutTarget sTLayoutTarget);
}
