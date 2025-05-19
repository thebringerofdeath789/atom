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
public interface CTPositivePercentage extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPositivePercentage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpositivepercentage2f8etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPositivePercentage newInstance() {
            return (CTPositivePercentage) XmlBeans.getContextTypeLoader().newInstance(CTPositivePercentage.type, null);
        }

        public static CTPositivePercentage newInstance(XmlOptions xmlOptions) {
            return (CTPositivePercentage) XmlBeans.getContextTypeLoader().newInstance(CTPositivePercentage.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPositivePercentage.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPositivePercentage) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPositivePercentage) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(File file) throws XmlException, IOException {
            return (CTPositivePercentage) XmlBeans.getContextTypeLoader().parse(file, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPositivePercentage) XmlBeans.getContextTypeLoader().parse(file, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPositivePercentage) XmlBeans.getContextTypeLoader().parse(inputStream, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPositivePercentage) XmlBeans.getContextTypeLoader().parse(inputStream, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(Reader reader) throws XmlException, IOException {
            return (CTPositivePercentage) XmlBeans.getContextTypeLoader().parse(reader, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPositivePercentage) XmlBeans.getContextTypeLoader().parse(reader, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(String str) throws XmlException {
            return (CTPositivePercentage) XmlBeans.getContextTypeLoader().parse(str, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPositivePercentage) XmlBeans.getContextTypeLoader().parse(str, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(URL url) throws XmlException, IOException {
            return (CTPositivePercentage) XmlBeans.getContextTypeLoader().parse(url, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPositivePercentage) XmlBeans.getContextTypeLoader().parse(url, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPositivePercentage) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPositivePercentage) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(Node node) throws XmlException {
            return (CTPositivePercentage) XmlBeans.getContextTypeLoader().parse(node, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPositivePercentage) XmlBeans.getContextTypeLoader().parse(node, CTPositivePercentage.type, xmlOptions);
        }
    }

    int getVal();

    void setVal(int i);

    STPositivePercentage xgetVal();

    void xsetVal(STPositivePercentage sTPositivePercentage);
}
