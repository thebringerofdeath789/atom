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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTStrRef extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTStrRef.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctstrref5d1atype");

    public static final class Factory {
        private Factory() {
        }

        public static CTStrRef newInstance() {
            return (CTStrRef) XmlBeans.getContextTypeLoader().newInstance(CTStrRef.type, null);
        }

        public static CTStrRef newInstance(XmlOptions xmlOptions) {
            return (CTStrRef) XmlBeans.getContextTypeLoader().newInstance(CTStrRef.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTStrRef.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTStrRef.type, xmlOptions);
        }

        public static CTStrRef parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTStrRef) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTStrRef.type, (XmlOptions) null);
        }

        public static CTStrRef parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTStrRef) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTStrRef.type, xmlOptions);
        }

        public static CTStrRef parse(File file) throws XmlException, IOException {
            return (CTStrRef) XmlBeans.getContextTypeLoader().parse(file, CTStrRef.type, (XmlOptions) null);
        }

        public static CTStrRef parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStrRef) XmlBeans.getContextTypeLoader().parse(file, CTStrRef.type, xmlOptions);
        }

        public static CTStrRef parse(InputStream inputStream) throws XmlException, IOException {
            return (CTStrRef) XmlBeans.getContextTypeLoader().parse(inputStream, CTStrRef.type, (XmlOptions) null);
        }

        public static CTStrRef parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStrRef) XmlBeans.getContextTypeLoader().parse(inputStream, CTStrRef.type, xmlOptions);
        }

        public static CTStrRef parse(Reader reader) throws XmlException, IOException {
            return (CTStrRef) XmlBeans.getContextTypeLoader().parse(reader, CTStrRef.type, (XmlOptions) null);
        }

        public static CTStrRef parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStrRef) XmlBeans.getContextTypeLoader().parse(reader, CTStrRef.type, xmlOptions);
        }

        public static CTStrRef parse(String str) throws XmlException {
            return (CTStrRef) XmlBeans.getContextTypeLoader().parse(str, CTStrRef.type, (XmlOptions) null);
        }

        public static CTStrRef parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTStrRef) XmlBeans.getContextTypeLoader().parse(str, CTStrRef.type, xmlOptions);
        }

        public static CTStrRef parse(URL url) throws XmlException, IOException {
            return (CTStrRef) XmlBeans.getContextTypeLoader().parse(url, CTStrRef.type, (XmlOptions) null);
        }

        public static CTStrRef parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStrRef) XmlBeans.getContextTypeLoader().parse(url, CTStrRef.type, xmlOptions);
        }

        public static CTStrRef parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTStrRef) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTStrRef.type, (XmlOptions) null);
        }

        public static CTStrRef parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTStrRef) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTStrRef.type, xmlOptions);
        }

        public static CTStrRef parse(Node node) throws XmlException {
            return (CTStrRef) XmlBeans.getContextTypeLoader().parse(node, CTStrRef.type, (XmlOptions) null);
        }

        public static CTStrRef parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTStrRef) XmlBeans.getContextTypeLoader().parse(node, CTStrRef.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTStrData addNewStrCache();

    CTExtensionList getExtLst();

    String getF();

    CTStrData getStrCache();

    boolean isSetExtLst();

    boolean isSetStrCache();

    void setExtLst(CTExtensionList cTExtensionList);

    void setF(String str);

    void setStrCache(CTStrData cTStrData);

    void unsetExtLst();

    void unsetStrCache();

    XmlString xgetF();

    void xsetF(XmlString xmlString);
}
