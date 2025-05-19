package org.openxmlformats.schemas.drawingml.x2006.main;

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

/* loaded from: classes5.dex */
public interface CTPercentage extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPercentage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpercentage4e75type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPercentage newInstance() {
            return (CTPercentage) XmlBeans.getContextTypeLoader().newInstance(CTPercentage.type, null);
        }

        public static CTPercentage newInstance(XmlOptions xmlOptions) {
            return (CTPercentage) XmlBeans.getContextTypeLoader().newInstance(CTPercentage.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPercentage.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPercentage.type, xmlOptions);
        }

        public static CTPercentage parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPercentage) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPercentage.type, (XmlOptions) null);
        }

        public static CTPercentage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPercentage) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPercentage.type, xmlOptions);
        }

        public static CTPercentage parse(File file) throws XmlException, IOException {
            return (CTPercentage) XmlBeans.getContextTypeLoader().parse(file, CTPercentage.type, (XmlOptions) null);
        }

        public static CTPercentage parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPercentage) XmlBeans.getContextTypeLoader().parse(file, CTPercentage.type, xmlOptions);
        }

        public static CTPercentage parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPercentage) XmlBeans.getContextTypeLoader().parse(inputStream, CTPercentage.type, (XmlOptions) null);
        }

        public static CTPercentage parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPercentage) XmlBeans.getContextTypeLoader().parse(inputStream, CTPercentage.type, xmlOptions);
        }

        public static CTPercentage parse(Reader reader) throws XmlException, IOException {
            return (CTPercentage) XmlBeans.getContextTypeLoader().parse(reader, CTPercentage.type, (XmlOptions) null);
        }

        public static CTPercentage parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPercentage) XmlBeans.getContextTypeLoader().parse(reader, CTPercentage.type, xmlOptions);
        }

        public static CTPercentage parse(String str) throws XmlException {
            return (CTPercentage) XmlBeans.getContextTypeLoader().parse(str, CTPercentage.type, (XmlOptions) null);
        }

        public static CTPercentage parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPercentage) XmlBeans.getContextTypeLoader().parse(str, CTPercentage.type, xmlOptions);
        }

        public static CTPercentage parse(URL url) throws XmlException, IOException {
            return (CTPercentage) XmlBeans.getContextTypeLoader().parse(url, CTPercentage.type, (XmlOptions) null);
        }

        public static CTPercentage parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPercentage) XmlBeans.getContextTypeLoader().parse(url, CTPercentage.type, xmlOptions);
        }

        public static CTPercentage parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPercentage) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPercentage.type, (XmlOptions) null);
        }

        public static CTPercentage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPercentage) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPercentage.type, xmlOptions);
        }

        public static CTPercentage parse(Node node) throws XmlException {
            return (CTPercentage) XmlBeans.getContextTypeLoader().parse(node, CTPercentage.type, (XmlOptions) null);
        }

        public static CTPercentage parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPercentage) XmlBeans.getContextTypeLoader().parse(node, CTPercentage.type, xmlOptions);
        }
    }

    int getVal();

    void setVal(int i);

    STPercentage xgetVal();

    void xsetVal(STPercentage sTPercentage);
}
