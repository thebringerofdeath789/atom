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
public interface CTPPrDefault extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPPrDefault.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpprdefaultf839type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPPrDefault newInstance() {
            return (CTPPrDefault) XmlBeans.getContextTypeLoader().newInstance(CTPPrDefault.type, null);
        }

        public static CTPPrDefault newInstance(XmlOptions xmlOptions) {
            return (CTPPrDefault) XmlBeans.getContextTypeLoader().newInstance(CTPPrDefault.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPPrDefault.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPPrDefault.type, xmlOptions);
        }

        public static CTPPrDefault parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPPrDefault) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPPrDefault.type, (XmlOptions) null);
        }

        public static CTPPrDefault parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPPrDefault) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPPrDefault.type, xmlOptions);
        }

        public static CTPPrDefault parse(File file) throws XmlException, IOException {
            return (CTPPrDefault) XmlBeans.getContextTypeLoader().parse(file, CTPPrDefault.type, (XmlOptions) null);
        }

        public static CTPPrDefault parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPPrDefault) XmlBeans.getContextTypeLoader().parse(file, CTPPrDefault.type, xmlOptions);
        }

        public static CTPPrDefault parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPPrDefault) XmlBeans.getContextTypeLoader().parse(inputStream, CTPPrDefault.type, (XmlOptions) null);
        }

        public static CTPPrDefault parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPPrDefault) XmlBeans.getContextTypeLoader().parse(inputStream, CTPPrDefault.type, xmlOptions);
        }

        public static CTPPrDefault parse(Reader reader) throws XmlException, IOException {
            return (CTPPrDefault) XmlBeans.getContextTypeLoader().parse(reader, CTPPrDefault.type, (XmlOptions) null);
        }

        public static CTPPrDefault parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPPrDefault) XmlBeans.getContextTypeLoader().parse(reader, CTPPrDefault.type, xmlOptions);
        }

        public static CTPPrDefault parse(String str) throws XmlException {
            return (CTPPrDefault) XmlBeans.getContextTypeLoader().parse(str, CTPPrDefault.type, (XmlOptions) null);
        }

        public static CTPPrDefault parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPPrDefault) XmlBeans.getContextTypeLoader().parse(str, CTPPrDefault.type, xmlOptions);
        }

        public static CTPPrDefault parse(URL url) throws XmlException, IOException {
            return (CTPPrDefault) XmlBeans.getContextTypeLoader().parse(url, CTPPrDefault.type, (XmlOptions) null);
        }

        public static CTPPrDefault parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPPrDefault) XmlBeans.getContextTypeLoader().parse(url, CTPPrDefault.type, xmlOptions);
        }

        public static CTPPrDefault parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPPrDefault) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPPrDefault.type, (XmlOptions) null);
        }

        public static CTPPrDefault parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPPrDefault) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPPrDefault.type, xmlOptions);
        }

        public static CTPPrDefault parse(Node node) throws XmlException {
            return (CTPPrDefault) XmlBeans.getContextTypeLoader().parse(node, CTPPrDefault.type, (XmlOptions) null);
        }

        public static CTPPrDefault parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPPrDefault) XmlBeans.getContextTypeLoader().parse(node, CTPPrDefault.type, xmlOptions);
        }
    }

    CTPPr addNewPPr();

    CTPPr getPPr();

    boolean isSetPPr();

    void setPPr(CTPPr cTPPr);

    void unsetPPr();
}
