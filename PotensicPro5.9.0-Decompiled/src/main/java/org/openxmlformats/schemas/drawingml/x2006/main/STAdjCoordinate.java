package org.openxmlformats.schemas.drawingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface STAdjCoordinate extends XmlAnySimpleType {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STAdjCoordinate.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stadjcoordinated920type");

    public static final class Factory {
        private Factory() {
        }

        public static STAdjCoordinate newInstance() {
            return (STAdjCoordinate) XmlBeans.getContextTypeLoader().newInstance(STAdjCoordinate.type, null);
        }

        public static STAdjCoordinate newInstance(XmlOptions xmlOptions) {
            return (STAdjCoordinate) XmlBeans.getContextTypeLoader().newInstance(STAdjCoordinate.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STAdjCoordinate.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate newValue(Object obj) {
            return (STAdjCoordinate) STAdjCoordinate.type.newValue(obj);
        }

        public static STAdjCoordinate parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STAdjCoordinate) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STAdjCoordinate) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate parse(File file) throws XmlException, IOException {
            return (STAdjCoordinate) XmlBeans.getContextTypeLoader().parse(file, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAdjCoordinate) XmlBeans.getContextTypeLoader().parse(file, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate parse(InputStream inputStream) throws XmlException, IOException {
            return (STAdjCoordinate) XmlBeans.getContextTypeLoader().parse(inputStream, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAdjCoordinate) XmlBeans.getContextTypeLoader().parse(inputStream, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate parse(Reader reader) throws XmlException, IOException {
            return (STAdjCoordinate) XmlBeans.getContextTypeLoader().parse(reader, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAdjCoordinate) XmlBeans.getContextTypeLoader().parse(reader, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate parse(String str) throws XmlException {
            return (STAdjCoordinate) XmlBeans.getContextTypeLoader().parse(str, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STAdjCoordinate) XmlBeans.getContextTypeLoader().parse(str, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate parse(URL url) throws XmlException, IOException {
            return (STAdjCoordinate) XmlBeans.getContextTypeLoader().parse(url, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STAdjCoordinate) XmlBeans.getContextTypeLoader().parse(url, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STAdjCoordinate) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STAdjCoordinate) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate parse(Node node) throws XmlException {
            return (STAdjCoordinate) XmlBeans.getContextTypeLoader().parse(node, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STAdjCoordinate) XmlBeans.getContextTypeLoader().parse(node, STAdjCoordinate.type, xmlOptions);
        }
    }

    Object getObjectValue();

    SchemaType instanceType();

    void objectSet(Object obj);

    Object objectValue();

    void setObjectValue(Object obj);
}
