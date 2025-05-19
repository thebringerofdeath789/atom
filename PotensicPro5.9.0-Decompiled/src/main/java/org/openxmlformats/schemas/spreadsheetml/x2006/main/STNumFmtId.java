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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface STNumFmtId extends XmlUnsignedInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STNumFmtId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stnumfmtid76fbtype");

    public static final class Factory {
        private Factory() {
        }

        public static STNumFmtId newInstance() {
            return (STNumFmtId) XmlBeans.getContextTypeLoader().newInstance(STNumFmtId.type, null);
        }

        public static STNumFmtId newInstance(XmlOptions xmlOptions) {
            return (STNumFmtId) XmlBeans.getContextTypeLoader().newInstance(STNumFmtId.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STNumFmtId.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STNumFmtId.type, xmlOptions);
        }

        public static STNumFmtId newValue(Object obj) {
            return (STNumFmtId) STNumFmtId.type.newValue(obj);
        }

        public static STNumFmtId parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STNumFmtId) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STNumFmtId.type, (XmlOptions) null);
        }

        public static STNumFmtId parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STNumFmtId) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STNumFmtId.type, xmlOptions);
        }

        public static STNumFmtId parse(File file) throws XmlException, IOException {
            return (STNumFmtId) XmlBeans.getContextTypeLoader().parse(file, STNumFmtId.type, (XmlOptions) null);
        }

        public static STNumFmtId parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STNumFmtId) XmlBeans.getContextTypeLoader().parse(file, STNumFmtId.type, xmlOptions);
        }

        public static STNumFmtId parse(InputStream inputStream) throws XmlException, IOException {
            return (STNumFmtId) XmlBeans.getContextTypeLoader().parse(inputStream, STNumFmtId.type, (XmlOptions) null);
        }

        public static STNumFmtId parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STNumFmtId) XmlBeans.getContextTypeLoader().parse(inputStream, STNumFmtId.type, xmlOptions);
        }

        public static STNumFmtId parse(Reader reader) throws XmlException, IOException {
            return (STNumFmtId) XmlBeans.getContextTypeLoader().parse(reader, STNumFmtId.type, (XmlOptions) null);
        }

        public static STNumFmtId parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STNumFmtId) XmlBeans.getContextTypeLoader().parse(reader, STNumFmtId.type, xmlOptions);
        }

        public static STNumFmtId parse(String str) throws XmlException {
            return (STNumFmtId) XmlBeans.getContextTypeLoader().parse(str, STNumFmtId.type, (XmlOptions) null);
        }

        public static STNumFmtId parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STNumFmtId) XmlBeans.getContextTypeLoader().parse(str, STNumFmtId.type, xmlOptions);
        }

        public static STNumFmtId parse(URL url) throws XmlException, IOException {
            return (STNumFmtId) XmlBeans.getContextTypeLoader().parse(url, STNumFmtId.type, (XmlOptions) null);
        }

        public static STNumFmtId parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STNumFmtId) XmlBeans.getContextTypeLoader().parse(url, STNumFmtId.type, xmlOptions);
        }

        public static STNumFmtId parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STNumFmtId) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STNumFmtId.type, (XmlOptions) null);
        }

        public static STNumFmtId parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STNumFmtId) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STNumFmtId.type, xmlOptions);
        }

        public static STNumFmtId parse(Node node) throws XmlException {
            return (STNumFmtId) XmlBeans.getContextTypeLoader().parse(node, STNumFmtId.type, (XmlOptions) null);
        }

        public static STNumFmtId parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STNumFmtId) XmlBeans.getContextTypeLoader().parse(node, STNumFmtId.type, xmlOptions);
        }
    }
}
