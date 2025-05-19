package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

/* loaded from: classes6.dex */
public interface CTDocDefaults extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTDocDefaults.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctdocdefaults2ea8type");

    public static final class Factory {
        private Factory() {
        }

        public static CTDocDefaults newInstance() {
            return (CTDocDefaults) XmlBeans.getContextTypeLoader().newInstance(CTDocDefaults.type, null);
        }

        public static CTDocDefaults newInstance(XmlOptions xmlOptions) {
            return (CTDocDefaults) XmlBeans.getContextTypeLoader().newInstance(CTDocDefaults.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDocDefaults.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDocDefaults.type, xmlOptions);
        }

        public static CTDocDefaults parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDocDefaults) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDocDefaults.type, (XmlOptions) null);
        }

        public static CTDocDefaults parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDocDefaults) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDocDefaults.type, xmlOptions);
        }

        public static CTDocDefaults parse(File file) throws XmlException, IOException {
            return (CTDocDefaults) XmlBeans.getContextTypeLoader().parse(file, CTDocDefaults.type, (XmlOptions) null);
        }

        public static CTDocDefaults parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocDefaults) XmlBeans.getContextTypeLoader().parse(file, CTDocDefaults.type, xmlOptions);
        }

        public static CTDocDefaults parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDocDefaults) XmlBeans.getContextTypeLoader().parse(inputStream, CTDocDefaults.type, (XmlOptions) null);
        }

        public static CTDocDefaults parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocDefaults) XmlBeans.getContextTypeLoader().parse(inputStream, CTDocDefaults.type, xmlOptions);
        }

        public static CTDocDefaults parse(Reader reader) throws XmlException, IOException {
            return (CTDocDefaults) XmlBeans.getContextTypeLoader().parse(reader, CTDocDefaults.type, (XmlOptions) null);
        }

        public static CTDocDefaults parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocDefaults) XmlBeans.getContextTypeLoader().parse(reader, CTDocDefaults.type, xmlOptions);
        }

        public static CTDocDefaults parse(String str) throws XmlException {
            return (CTDocDefaults) XmlBeans.getContextTypeLoader().parse(str, CTDocDefaults.type, (XmlOptions) null);
        }

        public static CTDocDefaults parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDocDefaults) XmlBeans.getContextTypeLoader().parse(str, CTDocDefaults.type, xmlOptions);
        }

        public static CTDocDefaults parse(URL url) throws XmlException, IOException {
            return (CTDocDefaults) XmlBeans.getContextTypeLoader().parse(url, CTDocDefaults.type, (XmlOptions) null);
        }

        public static CTDocDefaults parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDocDefaults) XmlBeans.getContextTypeLoader().parse(url, CTDocDefaults.type, xmlOptions);
        }

        public static CTDocDefaults parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTDocDefaults) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDocDefaults.type, (XmlOptions) null);
        }

        public static CTDocDefaults parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTDocDefaults) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDocDefaults.type, xmlOptions);
        }

        public static CTDocDefaults parse(Node node) throws XmlException {
            return (CTDocDefaults) XmlBeans.getContextTypeLoader().parse(node, CTDocDefaults.type, (XmlOptions) null);
        }

        public static CTDocDefaults parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDocDefaults) XmlBeans.getContextTypeLoader().parse(node, CTDocDefaults.type, xmlOptions);
        }
    }

    CTPPrDefault addNewPPrDefault();

    CTRPrDefault addNewRPrDefault();

    CTPPrDefault getPPrDefault();

    CTRPrDefault getRPrDefault();

    boolean isSetPPrDefault();

    boolean isSetRPrDefault();

    void setPPrDefault(CTPPrDefault cTPPrDefault);

    void setRPrDefault(CTRPrDefault cTRPrDefault);

    void unsetPPrDefault();

    void unsetRPrDefault();
}
