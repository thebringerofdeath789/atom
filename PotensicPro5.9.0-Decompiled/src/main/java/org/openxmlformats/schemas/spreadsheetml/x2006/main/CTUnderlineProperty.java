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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STUnderlineValues;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTUnderlineProperty extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTUnderlineProperty.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctunderlineproperty8e20type");

    public static final class Factory {
        private Factory() {
        }

        public static CTUnderlineProperty newInstance() {
            return (CTUnderlineProperty) XmlBeans.getContextTypeLoader().newInstance(CTUnderlineProperty.type, null);
        }

        public static CTUnderlineProperty newInstance(XmlOptions xmlOptions) {
            return (CTUnderlineProperty) XmlBeans.getContextTypeLoader().newInstance(CTUnderlineProperty.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTUnderlineProperty.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTUnderlineProperty.type, xmlOptions);
        }

        public static CTUnderlineProperty parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTUnderlineProperty) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTUnderlineProperty.type, (XmlOptions) null);
        }

        public static CTUnderlineProperty parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTUnderlineProperty) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTUnderlineProperty.type, xmlOptions);
        }

        public static CTUnderlineProperty parse(File file) throws XmlException, IOException {
            return (CTUnderlineProperty) XmlBeans.getContextTypeLoader().parse(file, CTUnderlineProperty.type, (XmlOptions) null);
        }

        public static CTUnderlineProperty parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTUnderlineProperty) XmlBeans.getContextTypeLoader().parse(file, CTUnderlineProperty.type, xmlOptions);
        }

        public static CTUnderlineProperty parse(InputStream inputStream) throws XmlException, IOException {
            return (CTUnderlineProperty) XmlBeans.getContextTypeLoader().parse(inputStream, CTUnderlineProperty.type, (XmlOptions) null);
        }

        public static CTUnderlineProperty parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTUnderlineProperty) XmlBeans.getContextTypeLoader().parse(inputStream, CTUnderlineProperty.type, xmlOptions);
        }

        public static CTUnderlineProperty parse(Reader reader) throws XmlException, IOException {
            return (CTUnderlineProperty) XmlBeans.getContextTypeLoader().parse(reader, CTUnderlineProperty.type, (XmlOptions) null);
        }

        public static CTUnderlineProperty parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTUnderlineProperty) XmlBeans.getContextTypeLoader().parse(reader, CTUnderlineProperty.type, xmlOptions);
        }

        public static CTUnderlineProperty parse(String str) throws XmlException {
            return (CTUnderlineProperty) XmlBeans.getContextTypeLoader().parse(str, CTUnderlineProperty.type, (XmlOptions) null);
        }

        public static CTUnderlineProperty parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTUnderlineProperty) XmlBeans.getContextTypeLoader().parse(str, CTUnderlineProperty.type, xmlOptions);
        }

        public static CTUnderlineProperty parse(URL url) throws XmlException, IOException {
            return (CTUnderlineProperty) XmlBeans.getContextTypeLoader().parse(url, CTUnderlineProperty.type, (XmlOptions) null);
        }

        public static CTUnderlineProperty parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTUnderlineProperty) XmlBeans.getContextTypeLoader().parse(url, CTUnderlineProperty.type, xmlOptions);
        }

        public static CTUnderlineProperty parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTUnderlineProperty) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTUnderlineProperty.type, (XmlOptions) null);
        }

        public static CTUnderlineProperty parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTUnderlineProperty) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTUnderlineProperty.type, xmlOptions);
        }

        public static CTUnderlineProperty parse(Node node) throws XmlException {
            return (CTUnderlineProperty) XmlBeans.getContextTypeLoader().parse(node, CTUnderlineProperty.type, (XmlOptions) null);
        }

        public static CTUnderlineProperty parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTUnderlineProperty) XmlBeans.getContextTypeLoader().parse(node, CTUnderlineProperty.type, xmlOptions);
        }
    }

    STUnderlineValues.Enum getVal();

    boolean isSetVal();

    void setVal(STUnderlineValues.Enum r1);

    void unsetVal();

    STUnderlineValues xgetVal();

    void xsetVal(STUnderlineValues sTUnderlineValues);
}
