package org.openxmlformats.schemas.drawingml.x2006.chart;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTPageMargins extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPageMargins.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpagemarginsb730type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPageMargins newInstance() {
            return (CTPageMargins) XmlBeans.getContextTypeLoader().newInstance(CTPageMargins.type, null);
        }

        public static CTPageMargins newInstance(XmlOptions xmlOptions) {
            return (CTPageMargins) XmlBeans.getContextTypeLoader().newInstance(CTPageMargins.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPageMargins.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPageMargins.type, xmlOptions);
        }

        public static CTPageMargins parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPageMargins) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPageMargins.type, (XmlOptions) null);
        }

        public static CTPageMargins parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPageMargins) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPageMargins.type, xmlOptions);
        }

        public static CTPageMargins parse(File file) throws XmlException, IOException {
            return (CTPageMargins) XmlBeans.getContextTypeLoader().parse(file, CTPageMargins.type, (XmlOptions) null);
        }

        public static CTPageMargins parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageMargins) XmlBeans.getContextTypeLoader().parse(file, CTPageMargins.type, xmlOptions);
        }

        public static CTPageMargins parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPageMargins) XmlBeans.getContextTypeLoader().parse(inputStream, CTPageMargins.type, (XmlOptions) null);
        }

        public static CTPageMargins parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageMargins) XmlBeans.getContextTypeLoader().parse(inputStream, CTPageMargins.type, xmlOptions);
        }

        public static CTPageMargins parse(Reader reader) throws XmlException, IOException {
            return (CTPageMargins) XmlBeans.getContextTypeLoader().parse(reader, CTPageMargins.type, (XmlOptions) null);
        }

        public static CTPageMargins parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageMargins) XmlBeans.getContextTypeLoader().parse(reader, CTPageMargins.type, xmlOptions);
        }

        public static CTPageMargins parse(String str) throws XmlException {
            return (CTPageMargins) XmlBeans.getContextTypeLoader().parse(str, CTPageMargins.type, (XmlOptions) null);
        }

        public static CTPageMargins parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPageMargins) XmlBeans.getContextTypeLoader().parse(str, CTPageMargins.type, xmlOptions);
        }

        public static CTPageMargins parse(URL url) throws XmlException, IOException {
            return (CTPageMargins) XmlBeans.getContextTypeLoader().parse(url, CTPageMargins.type, (XmlOptions) null);
        }

        public static CTPageMargins parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageMargins) XmlBeans.getContextTypeLoader().parse(url, CTPageMargins.type, xmlOptions);
        }

        public static CTPageMargins parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPageMargins) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPageMargins.type, (XmlOptions) null);
        }

        public static CTPageMargins parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPageMargins) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPageMargins.type, xmlOptions);
        }

        public static CTPageMargins parse(Node node) throws XmlException {
            return (CTPageMargins) XmlBeans.getContextTypeLoader().parse(node, CTPageMargins.type, (XmlOptions) null);
        }

        public static CTPageMargins parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPageMargins) XmlBeans.getContextTypeLoader().parse(node, CTPageMargins.type, xmlOptions);
        }
    }

    double getB();

    double getFooter();

    double getHeader();

    double getL();

    double getR();

    double getT();

    void setB(double d);

    void setFooter(double d);

    void setHeader(double d);

    void setL(double d);

    void setR(double d);

    void setT(double d);

    XmlDouble xgetB();

    XmlDouble xgetFooter();

    XmlDouble xgetHeader();

    XmlDouble xgetL();

    XmlDouble xgetR();

    XmlDouble xgetT();

    void xsetB(XmlDouble xmlDouble);

    void xsetFooter(XmlDouble xmlDouble);

    void xsetHeader(XmlDouble xmlDouble);

    void xsetL(XmlDouble xmlDouble);

    void xsetR(XmlDouble xmlDouble);

    void xsetT(XmlDouble xmlDouble);
}
