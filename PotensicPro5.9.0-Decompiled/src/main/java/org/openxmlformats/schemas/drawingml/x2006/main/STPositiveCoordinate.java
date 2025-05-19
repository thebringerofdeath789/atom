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
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface STPositiveCoordinate extends XmlLong {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STPositiveCoordinate.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stpositivecoordinatecbfctype");

    public static final class Factory {
        private Factory() {
        }

        public static STPositiveCoordinate newInstance() {
            return (STPositiveCoordinate) XmlBeans.getContextTypeLoader().newInstance(STPositiveCoordinate.type, null);
        }

        public static STPositiveCoordinate newInstance(XmlOptions xmlOptions) {
            return (STPositiveCoordinate) XmlBeans.getContextTypeLoader().newInstance(STPositiveCoordinate.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPositiveCoordinate.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STPositiveCoordinate.type, xmlOptions);
        }

        public static STPositiveCoordinate newValue(Object obj) {
            return (STPositiveCoordinate) STPositiveCoordinate.type.newValue(obj);
        }

        public static STPositiveCoordinate parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STPositiveCoordinate) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPositiveCoordinate.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STPositiveCoordinate) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STPositiveCoordinate.type, xmlOptions);
        }

        public static STPositiveCoordinate parse(File file) throws XmlException, IOException {
            return (STPositiveCoordinate) XmlBeans.getContextTypeLoader().parse(file, STPositiveCoordinate.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPositiveCoordinate) XmlBeans.getContextTypeLoader().parse(file, STPositiveCoordinate.type, xmlOptions);
        }

        public static STPositiveCoordinate parse(InputStream inputStream) throws XmlException, IOException {
            return (STPositiveCoordinate) XmlBeans.getContextTypeLoader().parse(inputStream, STPositiveCoordinate.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPositiveCoordinate) XmlBeans.getContextTypeLoader().parse(inputStream, STPositiveCoordinate.type, xmlOptions);
        }

        public static STPositiveCoordinate parse(Reader reader) throws XmlException, IOException {
            return (STPositiveCoordinate) XmlBeans.getContextTypeLoader().parse(reader, STPositiveCoordinate.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPositiveCoordinate) XmlBeans.getContextTypeLoader().parse(reader, STPositiveCoordinate.type, xmlOptions);
        }

        public static STPositiveCoordinate parse(String str) throws XmlException {
            return (STPositiveCoordinate) XmlBeans.getContextTypeLoader().parse(str, STPositiveCoordinate.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STPositiveCoordinate) XmlBeans.getContextTypeLoader().parse(str, STPositiveCoordinate.type, xmlOptions);
        }

        public static STPositiveCoordinate parse(URL url) throws XmlException, IOException {
            return (STPositiveCoordinate) XmlBeans.getContextTypeLoader().parse(url, STPositiveCoordinate.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STPositiveCoordinate) XmlBeans.getContextTypeLoader().parse(url, STPositiveCoordinate.type, xmlOptions);
        }

        public static STPositiveCoordinate parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STPositiveCoordinate) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPositiveCoordinate.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STPositiveCoordinate) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STPositiveCoordinate.type, xmlOptions);
        }

        public static STPositiveCoordinate parse(Node node) throws XmlException {
            return (STPositiveCoordinate) XmlBeans.getContextTypeLoader().parse(node, STPositiveCoordinate.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STPositiveCoordinate) XmlBeans.getContextTypeLoader().parse(node, STPositiveCoordinate.type, xmlOptions);
        }
    }
}
