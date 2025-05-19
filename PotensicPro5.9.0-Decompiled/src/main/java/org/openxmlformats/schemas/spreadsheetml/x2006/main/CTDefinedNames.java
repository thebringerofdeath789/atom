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
public interface CTDefinedNames extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTDefinedNames.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctdefinednamesce48type");

    public static final class Factory {
        private Factory() {
        }

        public static CTDefinedNames newInstance() {
            return (CTDefinedNames) XmlBeans.getContextTypeLoader().newInstance(CTDefinedNames.type, null);
        }

        public static CTDefinedNames newInstance(XmlOptions xmlOptions) {
            return (CTDefinedNames) XmlBeans.getContextTypeLoader().newInstance(CTDefinedNames.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDefinedNames.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDefinedNames.type, xmlOptions);
        }

        public static CTDefinedNames parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDefinedNames) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDefinedNames.type, (XmlOptions) null);
        }

        public static CTDefinedNames parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDefinedNames) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDefinedNames.type, xmlOptions);
        }

        public static CTDefinedNames parse(File file) throws XmlException, IOException {
            return (CTDefinedNames) XmlBeans.getContextTypeLoader().parse(file, CTDefinedNames.type, (XmlOptions) null);
        }

        public static CTDefinedNames parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDefinedNames) XmlBeans.getContextTypeLoader().parse(file, CTDefinedNames.type, xmlOptions);
        }

        public static CTDefinedNames parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDefinedNames) XmlBeans.getContextTypeLoader().parse(inputStream, CTDefinedNames.type, (XmlOptions) null);
        }

        public static CTDefinedNames parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDefinedNames) XmlBeans.getContextTypeLoader().parse(inputStream, CTDefinedNames.type, xmlOptions);
        }

        public static CTDefinedNames parse(Reader reader) throws XmlException, IOException {
            return (CTDefinedNames) XmlBeans.getContextTypeLoader().parse(reader, CTDefinedNames.type, (XmlOptions) null);
        }

        public static CTDefinedNames parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDefinedNames) XmlBeans.getContextTypeLoader().parse(reader, CTDefinedNames.type, xmlOptions);
        }

        public static CTDefinedNames parse(String str) throws XmlException {
            return (CTDefinedNames) XmlBeans.getContextTypeLoader().parse(str, CTDefinedNames.type, (XmlOptions) null);
        }

        public static CTDefinedNames parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDefinedNames) XmlBeans.getContextTypeLoader().parse(str, CTDefinedNames.type, xmlOptions);
        }

        public static CTDefinedNames parse(URL url) throws XmlException, IOException {
            return (CTDefinedNames) XmlBeans.getContextTypeLoader().parse(url, CTDefinedNames.type, (XmlOptions) null);
        }

        public static CTDefinedNames parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDefinedNames) XmlBeans.getContextTypeLoader().parse(url, CTDefinedNames.type, xmlOptions);
        }

        public static CTDefinedNames parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTDefinedNames) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDefinedNames.type, (XmlOptions) null);
        }

        public static CTDefinedNames parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTDefinedNames) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDefinedNames.type, xmlOptions);
        }

        public static CTDefinedNames parse(Node node) throws XmlException {
            return (CTDefinedNames) XmlBeans.getContextTypeLoader().parse(node, CTDefinedNames.type, (XmlOptions) null);
        }

        public static CTDefinedNames parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDefinedNames) XmlBeans.getContextTypeLoader().parse(node, CTDefinedNames.type, xmlOptions);
        }
    }

    CTDefinedName addNewDefinedName();

    CTDefinedName getDefinedNameArray(int i);

    CTDefinedName[] getDefinedNameArray();

    List<CTDefinedName> getDefinedNameList();

    CTDefinedName insertNewDefinedName(int i);

    void removeDefinedName(int i);

    void setDefinedNameArray(int i, CTDefinedName cTDefinedName);

    void setDefinedNameArray(CTDefinedName[] cTDefinedNameArr);

    int sizeOfDefinedNameArray();
}
