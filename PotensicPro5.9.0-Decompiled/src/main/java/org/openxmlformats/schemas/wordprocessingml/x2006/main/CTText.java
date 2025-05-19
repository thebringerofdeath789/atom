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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTText extends STString {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTText.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttext7f5btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTText newInstance() {
            return (CTText) XmlBeans.getContextTypeLoader().newInstance(CTText.type, null);
        }

        public static CTText newInstance(XmlOptions xmlOptions) {
            return (CTText) XmlBeans.getContextTypeLoader().newInstance(CTText.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTText.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTText.type, xmlOptions);
        }

        public static CTText parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTText) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTText.type, (XmlOptions) null);
        }

        public static CTText parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTText) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTText.type, xmlOptions);
        }

        public static CTText parse(File file) throws XmlException, IOException {
            return (CTText) XmlBeans.getContextTypeLoader().parse(file, CTText.type, (XmlOptions) null);
        }

        public static CTText parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTText) XmlBeans.getContextTypeLoader().parse(file, CTText.type, xmlOptions);
        }

        public static CTText parse(InputStream inputStream) throws XmlException, IOException {
            return (CTText) XmlBeans.getContextTypeLoader().parse(inputStream, CTText.type, (XmlOptions) null);
        }

        public static CTText parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTText) XmlBeans.getContextTypeLoader().parse(inputStream, CTText.type, xmlOptions);
        }

        public static CTText parse(Reader reader) throws XmlException, IOException {
            return (CTText) XmlBeans.getContextTypeLoader().parse(reader, CTText.type, (XmlOptions) null);
        }

        public static CTText parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTText) XmlBeans.getContextTypeLoader().parse(reader, CTText.type, xmlOptions);
        }

        public static CTText parse(String str) throws XmlException {
            return (CTText) XmlBeans.getContextTypeLoader().parse(str, CTText.type, (XmlOptions) null);
        }

        public static CTText parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTText) XmlBeans.getContextTypeLoader().parse(str, CTText.type, xmlOptions);
        }

        public static CTText parse(URL url) throws XmlException, IOException {
            return (CTText) XmlBeans.getContextTypeLoader().parse(url, CTText.type, (XmlOptions) null);
        }

        public static CTText parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTText) XmlBeans.getContextTypeLoader().parse(url, CTText.type, xmlOptions);
        }

        public static CTText parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTText) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTText.type, (XmlOptions) null);
        }

        public static CTText parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTText) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTText.type, xmlOptions);
        }

        public static CTText parse(Node node) throws XmlException {
            return (CTText) XmlBeans.getContextTypeLoader().parse(node, CTText.type, (XmlOptions) null);
        }

        public static CTText parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTText) XmlBeans.getContextTypeLoader().parse(node, CTText.type, xmlOptions);
        }
    }

    SpaceAttribute.Space.Enum getSpace();

    boolean isSetSpace();

    void setSpace(SpaceAttribute.Space.Enum r1);

    void unsetSpace();

    SpaceAttribute.Space xgetSpace();

    void xsetSpace(SpaceAttribute.Space space);
}
