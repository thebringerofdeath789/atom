package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTSmartTagPr extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSmartTagPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctsmarttagprf715type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSmartTagPr newInstance() {
            return (CTSmartTagPr) XmlBeans.getContextTypeLoader().newInstance(CTSmartTagPr.type, null);
        }

        public static CTSmartTagPr newInstance(XmlOptions xmlOptions) {
            return (CTSmartTagPr) XmlBeans.getContextTypeLoader().newInstance(CTSmartTagPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSmartTagPr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSmartTagPr.type, xmlOptions);
        }

        public static CTSmartTagPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSmartTagPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSmartTagPr.type, (XmlOptions) null);
        }

        public static CTSmartTagPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSmartTagPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSmartTagPr.type, xmlOptions);
        }

        public static CTSmartTagPr parse(File file) throws XmlException, IOException {
            return (CTSmartTagPr) XmlBeans.getContextTypeLoader().parse(file, CTSmartTagPr.type, (XmlOptions) null);
        }

        public static CTSmartTagPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSmartTagPr) XmlBeans.getContextTypeLoader().parse(file, CTSmartTagPr.type, xmlOptions);
        }

        public static CTSmartTagPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSmartTagPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTSmartTagPr.type, (XmlOptions) null);
        }

        public static CTSmartTagPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSmartTagPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTSmartTagPr.type, xmlOptions);
        }

        public static CTSmartTagPr parse(Reader reader) throws XmlException, IOException {
            return (CTSmartTagPr) XmlBeans.getContextTypeLoader().parse(reader, CTSmartTagPr.type, (XmlOptions) null);
        }

        public static CTSmartTagPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSmartTagPr) XmlBeans.getContextTypeLoader().parse(reader, CTSmartTagPr.type, xmlOptions);
        }

        public static CTSmartTagPr parse(String str) throws XmlException {
            return (CTSmartTagPr) XmlBeans.getContextTypeLoader().parse(str, CTSmartTagPr.type, (XmlOptions) null);
        }

        public static CTSmartTagPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSmartTagPr) XmlBeans.getContextTypeLoader().parse(str, CTSmartTagPr.type, xmlOptions);
        }

        public static CTSmartTagPr parse(URL url) throws XmlException, IOException {
            return (CTSmartTagPr) XmlBeans.getContextTypeLoader().parse(url, CTSmartTagPr.type, (XmlOptions) null);
        }

        public static CTSmartTagPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSmartTagPr) XmlBeans.getContextTypeLoader().parse(url, CTSmartTagPr.type, xmlOptions);
        }

        public static CTSmartTagPr parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSmartTagPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSmartTagPr.type, (XmlOptions) null);
        }

        public static CTSmartTagPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSmartTagPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSmartTagPr.type, xmlOptions);
        }

        public static CTSmartTagPr parse(Node node) throws XmlException {
            return (CTSmartTagPr) XmlBeans.getContextTypeLoader().parse(node, CTSmartTagPr.type, (XmlOptions) null);
        }

        public static CTSmartTagPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSmartTagPr) XmlBeans.getContextTypeLoader().parse(node, CTSmartTagPr.type, xmlOptions);
        }
    }

    CTAttr addNewAttr();

    CTAttr getAttrArray(int i);

    CTAttr[] getAttrArray();

    List<CTAttr> getAttrList();

    CTAttr insertNewAttr(int i);

    void removeAttr(int i);

    void setAttrArray(int i, CTAttr cTAttr);

    void setAttrArray(CTAttr[] cTAttrArr);

    int sizeOfAttrArray();
}
