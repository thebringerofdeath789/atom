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
public interface STDrawingElementId extends XmlUnsignedInt {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STDrawingElementId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stdrawingelementid75a4type");

    public static final class Factory {
        private Factory() {
        }

        public static STDrawingElementId newInstance() {
            return (STDrawingElementId) XmlBeans.getContextTypeLoader().newInstance(STDrawingElementId.type, null);
        }

        public static STDrawingElementId newInstance(XmlOptions xmlOptions) {
            return (STDrawingElementId) XmlBeans.getContextTypeLoader().newInstance(STDrawingElementId.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STDrawingElementId.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId newValue(Object obj) {
            return (STDrawingElementId) STDrawingElementId.type.newValue(obj);
        }

        public static STDrawingElementId parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STDrawingElementId) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STDrawingElementId) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId parse(File file) throws XmlException, IOException {
            return (STDrawingElementId) XmlBeans.getContextTypeLoader().parse(file, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDrawingElementId) XmlBeans.getContextTypeLoader().parse(file, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId parse(InputStream inputStream) throws XmlException, IOException {
            return (STDrawingElementId) XmlBeans.getContextTypeLoader().parse(inputStream, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDrawingElementId) XmlBeans.getContextTypeLoader().parse(inputStream, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId parse(Reader reader) throws XmlException, IOException {
            return (STDrawingElementId) XmlBeans.getContextTypeLoader().parse(reader, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDrawingElementId) XmlBeans.getContextTypeLoader().parse(reader, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId parse(String str) throws XmlException {
            return (STDrawingElementId) XmlBeans.getContextTypeLoader().parse(str, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STDrawingElementId) XmlBeans.getContextTypeLoader().parse(str, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId parse(URL url) throws XmlException, IOException {
            return (STDrawingElementId) XmlBeans.getContextTypeLoader().parse(url, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STDrawingElementId) XmlBeans.getContextTypeLoader().parse(url, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STDrawingElementId) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STDrawingElementId) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId parse(Node node) throws XmlException {
            return (STDrawingElementId) XmlBeans.getContextTypeLoader().parse(node, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STDrawingElementId) XmlBeans.getContextTypeLoader().parse(node, STDrawingElementId.type, xmlOptions);
        }
    }
}
