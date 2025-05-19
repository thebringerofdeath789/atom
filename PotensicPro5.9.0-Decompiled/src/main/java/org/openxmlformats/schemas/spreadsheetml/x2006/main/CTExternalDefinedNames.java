package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
public interface CTExternalDefinedNames extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTExternalDefinedNames.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctexternaldefinednamesccf3type");

    public static final class Factory {
        private Factory() {
        }

        public static CTExternalDefinedNames newInstance() {
            return (CTExternalDefinedNames) XmlBeans.getContextTypeLoader().newInstance(CTExternalDefinedNames.type, null);
        }

        public static CTExternalDefinedNames newInstance(XmlOptions xmlOptions) {
            return (CTExternalDefinedNames) XmlBeans.getContextTypeLoader().newInstance(CTExternalDefinedNames.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTExternalDefinedNames.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTExternalDefinedNames.type, xmlOptions);
        }

        public static CTExternalDefinedNames parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTExternalDefinedNames) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTExternalDefinedNames.type, (XmlOptions) null);
        }

        public static CTExternalDefinedNames parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalDefinedNames) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTExternalDefinedNames.type, xmlOptions);
        }

        public static CTExternalDefinedNames parse(File file) throws XmlException, IOException {
            return (CTExternalDefinedNames) XmlBeans.getContextTypeLoader().parse(file, CTExternalDefinedNames.type, (XmlOptions) null);
        }

        public static CTExternalDefinedNames parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalDefinedNames) XmlBeans.getContextTypeLoader().parse(file, CTExternalDefinedNames.type, xmlOptions);
        }

        public static CTExternalDefinedNames parse(InputStream inputStream) throws XmlException, IOException {
            return (CTExternalDefinedNames) XmlBeans.getContextTypeLoader().parse(inputStream, CTExternalDefinedNames.type, (XmlOptions) null);
        }

        public static CTExternalDefinedNames parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalDefinedNames) XmlBeans.getContextTypeLoader().parse(inputStream, CTExternalDefinedNames.type, xmlOptions);
        }

        public static CTExternalDefinedNames parse(Reader reader) throws XmlException, IOException {
            return (CTExternalDefinedNames) XmlBeans.getContextTypeLoader().parse(reader, CTExternalDefinedNames.type, (XmlOptions) null);
        }

        public static CTExternalDefinedNames parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalDefinedNames) XmlBeans.getContextTypeLoader().parse(reader, CTExternalDefinedNames.type, xmlOptions);
        }

        public static CTExternalDefinedNames parse(String str) throws XmlException {
            return (CTExternalDefinedNames) XmlBeans.getContextTypeLoader().parse(str, CTExternalDefinedNames.type, (XmlOptions) null);
        }

        public static CTExternalDefinedNames parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalDefinedNames) XmlBeans.getContextTypeLoader().parse(str, CTExternalDefinedNames.type, xmlOptions);
        }

        public static CTExternalDefinedNames parse(URL url) throws XmlException, IOException {
            return (CTExternalDefinedNames) XmlBeans.getContextTypeLoader().parse(url, CTExternalDefinedNames.type, (XmlOptions) null);
        }

        public static CTExternalDefinedNames parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTExternalDefinedNames) XmlBeans.getContextTypeLoader().parse(url, CTExternalDefinedNames.type, xmlOptions);
        }

        public static CTExternalDefinedNames parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTExternalDefinedNames) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTExternalDefinedNames.type, (XmlOptions) null);
        }

        public static CTExternalDefinedNames parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTExternalDefinedNames) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTExternalDefinedNames.type, xmlOptions);
        }

        public static CTExternalDefinedNames parse(Node node) throws XmlException {
            return (CTExternalDefinedNames) XmlBeans.getContextTypeLoader().parse(node, CTExternalDefinedNames.type, (XmlOptions) null);
        }

        public static CTExternalDefinedNames parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTExternalDefinedNames) XmlBeans.getContextTypeLoader().parse(node, CTExternalDefinedNames.type, xmlOptions);
        }
    }

    CTExternalDefinedName addNewDefinedName();

    CTExternalDefinedName getDefinedNameArray(int i);

    CTExternalDefinedName[] getDefinedNameArray();

    List<CTExternalDefinedName> getDefinedNameList();

    CTExternalDefinedName insertNewDefinedName(int i);

    void removeDefinedName(int i);

    void setDefinedNameArray(int i, CTExternalDefinedName cTExternalDefinedName);

    void setDefinedNameArray(CTExternalDefinedName[] cTExternalDefinedNameArr);

    int sizeOfDefinedNameArray();
}
