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
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTTx extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTx.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttx9678type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTx newInstance() {
            return (CTTx) XmlBeans.getContextTypeLoader().newInstance(CTTx.type, null);
        }

        public static CTTx newInstance(XmlOptions xmlOptions) {
            return (CTTx) XmlBeans.getContextTypeLoader().newInstance(CTTx.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTx.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTx.type, xmlOptions);
        }

        public static CTTx parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTx) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTx.type, (XmlOptions) null);
        }

        public static CTTx parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTx) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTx.type, xmlOptions);
        }

        public static CTTx parse(File file) throws XmlException, IOException {
            return (CTTx) XmlBeans.getContextTypeLoader().parse(file, CTTx.type, (XmlOptions) null);
        }

        public static CTTx parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTx) XmlBeans.getContextTypeLoader().parse(file, CTTx.type, xmlOptions);
        }

        public static CTTx parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTx) XmlBeans.getContextTypeLoader().parse(inputStream, CTTx.type, (XmlOptions) null);
        }

        public static CTTx parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTx) XmlBeans.getContextTypeLoader().parse(inputStream, CTTx.type, xmlOptions);
        }

        public static CTTx parse(Reader reader) throws XmlException, IOException {
            return (CTTx) XmlBeans.getContextTypeLoader().parse(reader, CTTx.type, (XmlOptions) null);
        }

        public static CTTx parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTx) XmlBeans.getContextTypeLoader().parse(reader, CTTx.type, xmlOptions);
        }

        public static CTTx parse(String str) throws XmlException {
            return (CTTx) XmlBeans.getContextTypeLoader().parse(str, CTTx.type, (XmlOptions) null);
        }

        public static CTTx parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTx) XmlBeans.getContextTypeLoader().parse(str, CTTx.type, xmlOptions);
        }

        public static CTTx parse(URL url) throws XmlException, IOException {
            return (CTTx) XmlBeans.getContextTypeLoader().parse(url, CTTx.type, (XmlOptions) null);
        }

        public static CTTx parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTx) XmlBeans.getContextTypeLoader().parse(url, CTTx.type, xmlOptions);
        }

        public static CTTx parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTx) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTx.type, (XmlOptions) null);
        }

        public static CTTx parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTx) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTx.type, xmlOptions);
        }

        public static CTTx parse(Node node) throws XmlException {
            return (CTTx) XmlBeans.getContextTypeLoader().parse(node, CTTx.type, (XmlOptions) null);
        }

        public static CTTx parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTx) XmlBeans.getContextTypeLoader().parse(node, CTTx.type, xmlOptions);
        }
    }

    CTTextBody addNewRich();

    CTStrRef addNewStrRef();

    CTTextBody getRich();

    CTStrRef getStrRef();

    boolean isSetRich();

    boolean isSetStrRef();

    void setRich(CTTextBody cTTextBody);

    void setStrRef(CTStrRef cTStrRef);

    void unsetRich();

    void unsetStrRef();
}
