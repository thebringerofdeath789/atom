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
public interface CTPositiveFixedPercentage extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPositiveFixedPercentage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpositivefixedpercentage8966type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPositiveFixedPercentage newInstance() {
            return (CTPositiveFixedPercentage) XmlBeans.getContextTypeLoader().newInstance(CTPositiveFixedPercentage.type, null);
        }

        public static CTPositiveFixedPercentage newInstance(XmlOptions xmlOptions) {
            return (CTPositiveFixedPercentage) XmlBeans.getContextTypeLoader().newInstance(CTPositiveFixedPercentage.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPositiveFixedPercentage.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPositiveFixedPercentage.type, xmlOptions);
        }

        public static CTPositiveFixedPercentage parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static CTPositiveFixedPercentage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPositiveFixedPercentage.type, xmlOptions);
        }

        public static CTPositiveFixedPercentage parse(File file) throws XmlException, IOException {
            return (CTPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(file, CTPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static CTPositiveFixedPercentage parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(file, CTPositiveFixedPercentage.type, xmlOptions);
        }

        public static CTPositiveFixedPercentage parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(inputStream, CTPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static CTPositiveFixedPercentage parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(inputStream, CTPositiveFixedPercentage.type, xmlOptions);
        }

        public static CTPositiveFixedPercentage parse(Reader reader) throws XmlException, IOException {
            return (CTPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(reader, CTPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static CTPositiveFixedPercentage parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(reader, CTPositiveFixedPercentage.type, xmlOptions);
        }

        public static CTPositiveFixedPercentage parse(String str) throws XmlException {
            return (CTPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(str, CTPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static CTPositiveFixedPercentage parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(str, CTPositiveFixedPercentage.type, xmlOptions);
        }

        public static CTPositiveFixedPercentage parse(URL url) throws XmlException, IOException {
            return (CTPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(url, CTPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static CTPositiveFixedPercentage parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(url, CTPositiveFixedPercentage.type, xmlOptions);
        }

        public static CTPositiveFixedPercentage parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static CTPositiveFixedPercentage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPositiveFixedPercentage.type, xmlOptions);
        }

        public static CTPositiveFixedPercentage parse(Node node) throws XmlException {
            return (CTPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(node, CTPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static CTPositiveFixedPercentage parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPositiveFixedPercentage) XmlBeans.getContextTypeLoader().parse(node, CTPositiveFixedPercentage.type, xmlOptions);
        }
    }

    int getVal();

    void setVal(int i);

    STPositiveFixedPercentage xgetVal();

    void xsetVal(STPositiveFixedPercentage sTPositiveFixedPercentage);
}
