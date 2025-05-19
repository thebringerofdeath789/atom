package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
public interface CTRElt extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTRElt.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctrelt6464type");

    public static final class Factory {
        private Factory() {
        }

        public static CTRElt newInstance() {
            return (CTRElt) XmlBeans.getContextTypeLoader().newInstance(CTRElt.type, null);
        }

        public static CTRElt newInstance(XmlOptions xmlOptions) {
            return (CTRElt) XmlBeans.getContextTypeLoader().newInstance(CTRElt.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTRElt.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTRElt.type, xmlOptions);
        }

        public static CTRElt parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTRElt) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTRElt.type, (XmlOptions) null);
        }

        public static CTRElt parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTRElt) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTRElt.type, xmlOptions);
        }

        public static CTRElt parse(File file) throws XmlException, IOException {
            return (CTRElt) XmlBeans.getContextTypeLoader().parse(file, CTRElt.type, (XmlOptions) null);
        }

        public static CTRElt parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRElt) XmlBeans.getContextTypeLoader().parse(file, CTRElt.type, xmlOptions);
        }

        public static CTRElt parse(InputStream inputStream) throws XmlException, IOException {
            return (CTRElt) XmlBeans.getContextTypeLoader().parse(inputStream, CTRElt.type, (XmlOptions) null);
        }

        public static CTRElt parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRElt) XmlBeans.getContextTypeLoader().parse(inputStream, CTRElt.type, xmlOptions);
        }

        public static CTRElt parse(Reader reader) throws XmlException, IOException {
            return (CTRElt) XmlBeans.getContextTypeLoader().parse(reader, CTRElt.type, (XmlOptions) null);
        }

        public static CTRElt parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRElt) XmlBeans.getContextTypeLoader().parse(reader, CTRElt.type, xmlOptions);
        }

        public static CTRElt parse(String str) throws XmlException {
            return (CTRElt) XmlBeans.getContextTypeLoader().parse(str, CTRElt.type, (XmlOptions) null);
        }

        public static CTRElt parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTRElt) XmlBeans.getContextTypeLoader().parse(str, CTRElt.type, xmlOptions);
        }

        public static CTRElt parse(URL url) throws XmlException, IOException {
            return (CTRElt) XmlBeans.getContextTypeLoader().parse(url, CTRElt.type, (XmlOptions) null);
        }

        public static CTRElt parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRElt) XmlBeans.getContextTypeLoader().parse(url, CTRElt.type, xmlOptions);
        }

        public static CTRElt parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTRElt) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTRElt.type, (XmlOptions) null);
        }

        public static CTRElt parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTRElt) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTRElt.type, xmlOptions);
        }

        public static CTRElt parse(Node node) throws XmlException {
            return (CTRElt) XmlBeans.getContextTypeLoader().parse(node, CTRElt.type, (XmlOptions) null);
        }

        public static CTRElt parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTRElt) XmlBeans.getContextTypeLoader().parse(node, CTRElt.type, xmlOptions);
        }
    }

    CTRPrElt addNewRPr();

    CTRPrElt getRPr();

    String getT();

    boolean isSetRPr();

    void setRPr(CTRPrElt cTRPrElt);

    void setT(String str);

    void unsetRPr();

    STXstring xgetT();

    void xsetT(STXstring sTXstring);
}
