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
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface STGeomGuideName extends XmlToken {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STGeomGuideName.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stgeomguidename366ctype");

    public static final class Factory {
        private Factory() {
        }

        public static STGeomGuideName newInstance() {
            return (STGeomGuideName) XmlBeans.getContextTypeLoader().newInstance(STGeomGuideName.type, null);
        }

        public static STGeomGuideName newInstance(XmlOptions xmlOptions) {
            return (STGeomGuideName) XmlBeans.getContextTypeLoader().newInstance(STGeomGuideName.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STGeomGuideName.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName newValue(Object obj) {
            return (STGeomGuideName) STGeomGuideName.type.newValue(obj);
        }

        public static STGeomGuideName parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STGeomGuideName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STGeomGuideName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName parse(File file) throws XmlException, IOException {
            return (STGeomGuideName) XmlBeans.getContextTypeLoader().parse(file, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STGeomGuideName) XmlBeans.getContextTypeLoader().parse(file, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName parse(InputStream inputStream) throws XmlException, IOException {
            return (STGeomGuideName) XmlBeans.getContextTypeLoader().parse(inputStream, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STGeomGuideName) XmlBeans.getContextTypeLoader().parse(inputStream, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName parse(Reader reader) throws XmlException, IOException {
            return (STGeomGuideName) XmlBeans.getContextTypeLoader().parse(reader, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STGeomGuideName) XmlBeans.getContextTypeLoader().parse(reader, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName parse(String str) throws XmlException {
            return (STGeomGuideName) XmlBeans.getContextTypeLoader().parse(str, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STGeomGuideName) XmlBeans.getContextTypeLoader().parse(str, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName parse(URL url) throws XmlException, IOException {
            return (STGeomGuideName) XmlBeans.getContextTypeLoader().parse(url, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STGeomGuideName) XmlBeans.getContextTypeLoader().parse(url, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STGeomGuideName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STGeomGuideName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName parse(Node node) throws XmlException {
            return (STGeomGuideName) XmlBeans.getContextTypeLoader().parse(node, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STGeomGuideName) XmlBeans.getContextTypeLoader().parse(node, STGeomGuideName.type, xmlOptions);
        }
    }
}
