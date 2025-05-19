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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface STGeomGuideFormula extends XmlString {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STGeomGuideFormula.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stgeomguideformula4b51type");

    public static final class Factory {
        private Factory() {
        }

        public static STGeomGuideFormula newInstance() {
            return (STGeomGuideFormula) XmlBeans.getContextTypeLoader().newInstance(STGeomGuideFormula.type, null);
        }

        public static STGeomGuideFormula newInstance(XmlOptions xmlOptions) {
            return (STGeomGuideFormula) XmlBeans.getContextTypeLoader().newInstance(STGeomGuideFormula.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STGeomGuideFormula.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula newValue(Object obj) {
            return (STGeomGuideFormula) STGeomGuideFormula.type.newValue(obj);
        }

        public static STGeomGuideFormula parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STGeomGuideFormula) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STGeomGuideFormula) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula parse(File file) throws XmlException, IOException {
            return (STGeomGuideFormula) XmlBeans.getContextTypeLoader().parse(file, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STGeomGuideFormula) XmlBeans.getContextTypeLoader().parse(file, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula parse(InputStream inputStream) throws XmlException, IOException {
            return (STGeomGuideFormula) XmlBeans.getContextTypeLoader().parse(inputStream, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STGeomGuideFormula) XmlBeans.getContextTypeLoader().parse(inputStream, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula parse(Reader reader) throws XmlException, IOException {
            return (STGeomGuideFormula) XmlBeans.getContextTypeLoader().parse(reader, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STGeomGuideFormula) XmlBeans.getContextTypeLoader().parse(reader, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula parse(String str) throws XmlException {
            return (STGeomGuideFormula) XmlBeans.getContextTypeLoader().parse(str, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STGeomGuideFormula) XmlBeans.getContextTypeLoader().parse(str, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula parse(URL url) throws XmlException, IOException {
            return (STGeomGuideFormula) XmlBeans.getContextTypeLoader().parse(url, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STGeomGuideFormula) XmlBeans.getContextTypeLoader().parse(url, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STGeomGuideFormula) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STGeomGuideFormula) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula parse(Node node) throws XmlException {
            return (STGeomGuideFormula) XmlBeans.getContextTypeLoader().parse(node, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STGeomGuideFormula) XmlBeans.getContextTypeLoader().parse(node, STGeomGuideFormula.type, xmlOptions);
        }
    }
}
