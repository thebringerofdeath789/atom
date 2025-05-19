package org.openxmlformats.schemas.drawingml.x2006.chart;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTBoolean extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTBoolean.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctbooleancc3etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTBoolean newInstance() {
            return (CTBoolean) XmlBeans.getContextTypeLoader().newInstance(CTBoolean.type, null);
        }

        public static CTBoolean newInstance(XmlOptions xmlOptions) {
            return (CTBoolean) XmlBeans.getContextTypeLoader().newInstance(CTBoolean.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTBoolean.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTBoolean.type, xmlOptions);
        }

        public static CTBoolean parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTBoolean) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTBoolean.type, (XmlOptions) null);
        }

        public static CTBoolean parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTBoolean) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTBoolean.type, xmlOptions);
        }

        public static CTBoolean parse(File file) throws XmlException, IOException {
            return (CTBoolean) XmlBeans.getContextTypeLoader().parse(file, CTBoolean.type, (XmlOptions) null);
        }

        public static CTBoolean parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBoolean) XmlBeans.getContextTypeLoader().parse(file, CTBoolean.type, xmlOptions);
        }

        public static CTBoolean parse(InputStream inputStream) throws XmlException, IOException {
            return (CTBoolean) XmlBeans.getContextTypeLoader().parse(inputStream, CTBoolean.type, (XmlOptions) null);
        }

        public static CTBoolean parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBoolean) XmlBeans.getContextTypeLoader().parse(inputStream, CTBoolean.type, xmlOptions);
        }

        public static CTBoolean parse(Reader reader) throws XmlException, IOException {
            return (CTBoolean) XmlBeans.getContextTypeLoader().parse(reader, CTBoolean.type, (XmlOptions) null);
        }

        public static CTBoolean parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBoolean) XmlBeans.getContextTypeLoader().parse(reader, CTBoolean.type, xmlOptions);
        }

        public static CTBoolean parse(String str) throws XmlException {
            return (CTBoolean) XmlBeans.getContextTypeLoader().parse(str, CTBoolean.type, (XmlOptions) null);
        }

        public static CTBoolean parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTBoolean) XmlBeans.getContextTypeLoader().parse(str, CTBoolean.type, xmlOptions);
        }

        public static CTBoolean parse(URL url) throws XmlException, IOException {
            return (CTBoolean) XmlBeans.getContextTypeLoader().parse(url, CTBoolean.type, (XmlOptions) null);
        }

        public static CTBoolean parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBoolean) XmlBeans.getContextTypeLoader().parse(url, CTBoolean.type, xmlOptions);
        }

        public static CTBoolean parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTBoolean) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTBoolean.type, (XmlOptions) null);
        }

        public static CTBoolean parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTBoolean) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTBoolean.type, xmlOptions);
        }

        public static CTBoolean parse(Node node) throws XmlException {
            return (CTBoolean) XmlBeans.getContextTypeLoader().parse(node, CTBoolean.type, (XmlOptions) null);
        }

        public static CTBoolean parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTBoolean) XmlBeans.getContextTypeLoader().parse(node, CTBoolean.type, xmlOptions);
        }
    }

    boolean getVal();

    boolean isSetVal();

    void setVal(boolean z);

    void unsetVal();

    XmlBoolean xgetVal();

    void xsetVal(XmlBoolean xmlBoolean);
}
