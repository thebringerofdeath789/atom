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
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTSerTx extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSerTx.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctsertxd722type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSerTx newInstance() {
            return (CTSerTx) XmlBeans.getContextTypeLoader().newInstance(CTSerTx.type, null);
        }

        public static CTSerTx newInstance(XmlOptions xmlOptions) {
            return (CTSerTx) XmlBeans.getContextTypeLoader().newInstance(CTSerTx.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSerTx.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSerTx.type, xmlOptions);
        }

        public static CTSerTx parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSerTx) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSerTx.type, (XmlOptions) null);
        }

        public static CTSerTx parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSerTx) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSerTx.type, xmlOptions);
        }

        public static CTSerTx parse(File file) throws XmlException, IOException {
            return (CTSerTx) XmlBeans.getContextTypeLoader().parse(file, CTSerTx.type, (XmlOptions) null);
        }

        public static CTSerTx parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSerTx) XmlBeans.getContextTypeLoader().parse(file, CTSerTx.type, xmlOptions);
        }

        public static CTSerTx parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSerTx) XmlBeans.getContextTypeLoader().parse(inputStream, CTSerTx.type, (XmlOptions) null);
        }

        public static CTSerTx parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSerTx) XmlBeans.getContextTypeLoader().parse(inputStream, CTSerTx.type, xmlOptions);
        }

        public static CTSerTx parse(Reader reader) throws XmlException, IOException {
            return (CTSerTx) XmlBeans.getContextTypeLoader().parse(reader, CTSerTx.type, (XmlOptions) null);
        }

        public static CTSerTx parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSerTx) XmlBeans.getContextTypeLoader().parse(reader, CTSerTx.type, xmlOptions);
        }

        public static CTSerTx parse(String str) throws XmlException {
            return (CTSerTx) XmlBeans.getContextTypeLoader().parse(str, CTSerTx.type, (XmlOptions) null);
        }

        public static CTSerTx parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSerTx) XmlBeans.getContextTypeLoader().parse(str, CTSerTx.type, xmlOptions);
        }

        public static CTSerTx parse(URL url) throws XmlException, IOException {
            return (CTSerTx) XmlBeans.getContextTypeLoader().parse(url, CTSerTx.type, (XmlOptions) null);
        }

        public static CTSerTx parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSerTx) XmlBeans.getContextTypeLoader().parse(url, CTSerTx.type, xmlOptions);
        }

        public static CTSerTx parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSerTx) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSerTx.type, (XmlOptions) null);
        }

        public static CTSerTx parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSerTx) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSerTx.type, xmlOptions);
        }

        public static CTSerTx parse(Node node) throws XmlException {
            return (CTSerTx) XmlBeans.getContextTypeLoader().parse(node, CTSerTx.type, (XmlOptions) null);
        }

        public static CTSerTx parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSerTx) XmlBeans.getContextTypeLoader().parse(node, CTSerTx.type, xmlOptions);
        }
    }

    CTStrRef addNewStrRef();

    CTStrRef getStrRef();

    String getV();

    boolean isSetStrRef();

    boolean isSetV();

    void setStrRef(CTStrRef cTStrRef);

    void setV(String str);

    void unsetStrRef();

    void unsetV();

    STXstring xgetV();

    void xsetV(STXstring sTXstring);
}
