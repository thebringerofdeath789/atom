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
public interface STCellStyleXfId extends XmlUnsignedInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STCellStyleXfId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stcellstylexfid70c7type");

    public static final class Factory {
        private Factory() {
        }

        public static STCellStyleXfId newInstance() {
            return (STCellStyleXfId) XmlBeans.getContextTypeLoader().newInstance(STCellStyleXfId.type, null);
        }

        public static STCellStyleXfId newInstance(XmlOptions xmlOptions) {
            return (STCellStyleXfId) XmlBeans.getContextTypeLoader().newInstance(STCellStyleXfId.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STCellStyleXfId.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STCellStyleXfId.type, xmlOptions);
        }

        public static STCellStyleXfId newValue(Object obj) {
            return (STCellStyleXfId) STCellStyleXfId.type.newValue(obj);
        }

        public static STCellStyleXfId parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STCellStyleXfId) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STCellStyleXfId.type, (XmlOptions) null);
        }

        public static STCellStyleXfId parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STCellStyleXfId) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STCellStyleXfId.type, xmlOptions);
        }

        public static STCellStyleXfId parse(File file) throws XmlException, IOException {
            return (STCellStyleXfId) XmlBeans.getContextTypeLoader().parse(file, STCellStyleXfId.type, (XmlOptions) null);
        }

        public static STCellStyleXfId parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCellStyleXfId) XmlBeans.getContextTypeLoader().parse(file, STCellStyleXfId.type, xmlOptions);
        }

        public static STCellStyleXfId parse(InputStream inputStream) throws XmlException, IOException {
            return (STCellStyleXfId) XmlBeans.getContextTypeLoader().parse(inputStream, STCellStyleXfId.type, (XmlOptions) null);
        }

        public static STCellStyleXfId parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCellStyleXfId) XmlBeans.getContextTypeLoader().parse(inputStream, STCellStyleXfId.type, xmlOptions);
        }

        public static STCellStyleXfId parse(Reader reader) throws XmlException, IOException {
            return (STCellStyleXfId) XmlBeans.getContextTypeLoader().parse(reader, STCellStyleXfId.type, (XmlOptions) null);
        }

        public static STCellStyleXfId parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCellStyleXfId) XmlBeans.getContextTypeLoader().parse(reader, STCellStyleXfId.type, xmlOptions);
        }

        public static STCellStyleXfId parse(String str) throws XmlException {
            return (STCellStyleXfId) XmlBeans.getContextTypeLoader().parse(str, STCellStyleXfId.type, (XmlOptions) null);
        }

        public static STCellStyleXfId parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STCellStyleXfId) XmlBeans.getContextTypeLoader().parse(str, STCellStyleXfId.type, xmlOptions);
        }

        public static STCellStyleXfId parse(URL url) throws XmlException, IOException {
            return (STCellStyleXfId) XmlBeans.getContextTypeLoader().parse(url, STCellStyleXfId.type, (XmlOptions) null);
        }

        public static STCellStyleXfId parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STCellStyleXfId) XmlBeans.getContextTypeLoader().parse(url, STCellStyleXfId.type, xmlOptions);
        }

        public static STCellStyleXfId parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STCellStyleXfId) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STCellStyleXfId.type, (XmlOptions) null);
        }

        public static STCellStyleXfId parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STCellStyleXfId) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STCellStyleXfId.type, xmlOptions);
        }

        public static STCellStyleXfId parse(Node node) throws XmlException {
            return (STCellStyleXfId) XmlBeans.getContextTypeLoader().parse(node, STCellStyleXfId.type, (XmlOptions) null);
        }

        public static STCellStyleXfId parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STCellStyleXfId) XmlBeans.getContextTypeLoader().parse(node, STCellStyleXfId.type, xmlOptions);
        }
    }
}
