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
public interface STTextSpacingPercent extends STPercentage {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTextSpacingPercent.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttextspacingpercentde3atype");

    public static final class Factory {
        private Factory() {
        }

        public static STTextSpacingPercent newInstance() {
            return (STTextSpacingPercent) XmlBeans.getContextTypeLoader().newInstance(STTextSpacingPercent.type, null);
        }

        public static STTextSpacingPercent newInstance(XmlOptions xmlOptions) {
            return (STTextSpacingPercent) XmlBeans.getContextTypeLoader().newInstance(STTextSpacingPercent.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextSpacingPercent.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextSpacingPercent.type, xmlOptions);
        }

        public static STTextSpacingPercent newValue(Object obj) {
            return (STTextSpacingPercent) STTextSpacingPercent.type.newValue(obj);
        }

        public static STTextSpacingPercent parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextSpacingPercent.type, (XmlOptions) null);
        }

        public static STTextSpacingPercent parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextSpacingPercent.type, xmlOptions);
        }

        public static STTextSpacingPercent parse(File file) throws XmlException, IOException {
            return (STTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(file, STTextSpacingPercent.type, (XmlOptions) null);
        }

        public static STTextSpacingPercent parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(file, STTextSpacingPercent.type, xmlOptions);
        }

        public static STTextSpacingPercent parse(InputStream inputStream) throws XmlException, IOException {
            return (STTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(inputStream, STTextSpacingPercent.type, (XmlOptions) null);
        }

        public static STTextSpacingPercent parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(inputStream, STTextSpacingPercent.type, xmlOptions);
        }

        public static STTextSpacingPercent parse(Reader reader) throws XmlException, IOException {
            return (STTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(reader, STTextSpacingPercent.type, (XmlOptions) null);
        }

        public static STTextSpacingPercent parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(reader, STTextSpacingPercent.type, xmlOptions);
        }

        public static STTextSpacingPercent parse(String str) throws XmlException {
            return (STTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(str, STTextSpacingPercent.type, (XmlOptions) null);
        }

        public static STTextSpacingPercent parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(str, STTextSpacingPercent.type, xmlOptions);
        }

        public static STTextSpacingPercent parse(URL url) throws XmlException, IOException {
            return (STTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(url, STTextSpacingPercent.type, (XmlOptions) null);
        }

        public static STTextSpacingPercent parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(url, STTextSpacingPercent.type, xmlOptions);
        }

        public static STTextSpacingPercent parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextSpacingPercent.type, (XmlOptions) null);
        }

        public static STTextSpacingPercent parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextSpacingPercent.type, xmlOptions);
        }

        public static STTextSpacingPercent parse(Node node) throws XmlException {
            return (STTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(node, STTextSpacingPercent.type, (XmlOptions) null);
        }

        public static STTextSpacingPercent parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTextSpacingPercent) XmlBeans.getContextTypeLoader().parse(node, STTextSpacingPercent.type, xmlOptions);
        }
    }
}
