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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface STTextIndent extends STCoordinate32 {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTextIndent.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttextindent16e4type");

    public static final class Factory {
        private Factory() {
        }

        public static STTextIndent newInstance() {
            return (STTextIndent) XmlBeans.getContextTypeLoader().newInstance(STTextIndent.type, null);
        }

        public static STTextIndent newInstance(XmlOptions xmlOptions) {
            return (STTextIndent) XmlBeans.getContextTypeLoader().newInstance(STTextIndent.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextIndent.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent newValue(Object obj) {
            return (STTextIndent) STTextIndent.type.newValue(obj);
        }

        public static STTextIndent parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTextIndent) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTextIndent) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent parse(File file) throws XmlException, IOException {
            return (STTextIndent) XmlBeans.getContextTypeLoader().parse(file, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextIndent) XmlBeans.getContextTypeLoader().parse(file, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent parse(InputStream inputStream) throws XmlException, IOException {
            return (STTextIndent) XmlBeans.getContextTypeLoader().parse(inputStream, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextIndent) XmlBeans.getContextTypeLoader().parse(inputStream, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent parse(Reader reader) throws XmlException, IOException {
            return (STTextIndent) XmlBeans.getContextTypeLoader().parse(reader, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextIndent) XmlBeans.getContextTypeLoader().parse(reader, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent parse(String str) throws XmlException {
            return (STTextIndent) XmlBeans.getContextTypeLoader().parse(str, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTextIndent) XmlBeans.getContextTypeLoader().parse(str, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent parse(URL url) throws XmlException, IOException {
            return (STTextIndent) XmlBeans.getContextTypeLoader().parse(url, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextIndent) XmlBeans.getContextTypeLoader().parse(url, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTextIndent) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTextIndent) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent parse(Node node) throws XmlException {
            return (STTextIndent) XmlBeans.getContextTypeLoader().parse(node, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTextIndent) XmlBeans.getContextTypeLoader().parse(node, STTextIndent.type, xmlOptions);
        }
    }
}
