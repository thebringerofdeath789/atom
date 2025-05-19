package org.openxmlformats.schemas.drawingml.x2006.main;

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

/* loaded from: classes5.dex */
public interface STStyleMatrixColumnIndex extends XmlUnsignedInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STStyleMatrixColumnIndex.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ststylematrixcolumnindex1755type");

    public static final class Factory {
        private Factory() {
        }

        public static STStyleMatrixColumnIndex newInstance() {
            return (STStyleMatrixColumnIndex) XmlBeans.getContextTypeLoader().newInstance(STStyleMatrixColumnIndex.type, null);
        }

        public static STStyleMatrixColumnIndex newInstance(XmlOptions xmlOptions) {
            return (STStyleMatrixColumnIndex) XmlBeans.getContextTypeLoader().newInstance(STStyleMatrixColumnIndex.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STStyleMatrixColumnIndex.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STStyleMatrixColumnIndex.type, xmlOptions);
        }

        public static STStyleMatrixColumnIndex newValue(Object obj) {
            return (STStyleMatrixColumnIndex) STStyleMatrixColumnIndex.type.newValue(obj);
        }

        public static STStyleMatrixColumnIndex parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STStyleMatrixColumnIndex) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STStyleMatrixColumnIndex.type, (XmlOptions) null);
        }

        public static STStyleMatrixColumnIndex parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STStyleMatrixColumnIndex) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STStyleMatrixColumnIndex.type, xmlOptions);
        }

        public static STStyleMatrixColumnIndex parse(File file) throws XmlException, IOException {
            return (STStyleMatrixColumnIndex) XmlBeans.getContextTypeLoader().parse(file, STStyleMatrixColumnIndex.type, (XmlOptions) null);
        }

        public static STStyleMatrixColumnIndex parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STStyleMatrixColumnIndex) XmlBeans.getContextTypeLoader().parse(file, STStyleMatrixColumnIndex.type, xmlOptions);
        }

        public static STStyleMatrixColumnIndex parse(InputStream inputStream) throws XmlException, IOException {
            return (STStyleMatrixColumnIndex) XmlBeans.getContextTypeLoader().parse(inputStream, STStyleMatrixColumnIndex.type, (XmlOptions) null);
        }

        public static STStyleMatrixColumnIndex parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STStyleMatrixColumnIndex) XmlBeans.getContextTypeLoader().parse(inputStream, STStyleMatrixColumnIndex.type, xmlOptions);
        }

        public static STStyleMatrixColumnIndex parse(Reader reader) throws XmlException, IOException {
            return (STStyleMatrixColumnIndex) XmlBeans.getContextTypeLoader().parse(reader, STStyleMatrixColumnIndex.type, (XmlOptions) null);
        }

        public static STStyleMatrixColumnIndex parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STStyleMatrixColumnIndex) XmlBeans.getContextTypeLoader().parse(reader, STStyleMatrixColumnIndex.type, xmlOptions);
        }

        public static STStyleMatrixColumnIndex parse(String str) throws XmlException {
            return (STStyleMatrixColumnIndex) XmlBeans.getContextTypeLoader().parse(str, STStyleMatrixColumnIndex.type, (XmlOptions) null);
        }

        public static STStyleMatrixColumnIndex parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STStyleMatrixColumnIndex) XmlBeans.getContextTypeLoader().parse(str, STStyleMatrixColumnIndex.type, xmlOptions);
        }

        public static STStyleMatrixColumnIndex parse(URL url) throws XmlException, IOException {
            return (STStyleMatrixColumnIndex) XmlBeans.getContextTypeLoader().parse(url, STStyleMatrixColumnIndex.type, (XmlOptions) null);
        }

        public static STStyleMatrixColumnIndex parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STStyleMatrixColumnIndex) XmlBeans.getContextTypeLoader().parse(url, STStyleMatrixColumnIndex.type, xmlOptions);
        }

        public static STStyleMatrixColumnIndex parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STStyleMatrixColumnIndex) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STStyleMatrixColumnIndex.type, (XmlOptions) null);
        }

        public static STStyleMatrixColumnIndex parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STStyleMatrixColumnIndex) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STStyleMatrixColumnIndex.type, xmlOptions);
        }

        public static STStyleMatrixColumnIndex parse(Node node) throws XmlException {
            return (STStyleMatrixColumnIndex) XmlBeans.getContextTypeLoader().parse(node, STStyleMatrixColumnIndex.type, (XmlOptions) null);
        }

        public static STStyleMatrixColumnIndex parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STStyleMatrixColumnIndex) XmlBeans.getContextTypeLoader().parse(node, STStyleMatrixColumnIndex.type, xmlOptions);
        }
    }
}
