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
public interface STTextFontScalePercent extends STPercentage {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STTextFontScalePercent.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("sttextfontscalepercente6c2type");

    public static final class Factory {
        private Factory() {
        }

        public static STTextFontScalePercent newInstance() {
            return (STTextFontScalePercent) XmlBeans.getContextTypeLoader().newInstance(STTextFontScalePercent.type, null);
        }

        public static STTextFontScalePercent newInstance(XmlOptions xmlOptions) {
            return (STTextFontScalePercent) XmlBeans.getContextTypeLoader().newInstance(STTextFontScalePercent.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextFontScalePercent.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent newValue(Object obj) {
            return (STTextFontScalePercent) STTextFontScalePercent.type.newValue(obj);
        }

        public static STTextFontScalePercent parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STTextFontScalePercent) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STTextFontScalePercent) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent parse(File file) throws XmlException, IOException {
            return (STTextFontScalePercent) XmlBeans.getContextTypeLoader().parse(file, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextFontScalePercent) XmlBeans.getContextTypeLoader().parse(file, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent parse(InputStream inputStream) throws XmlException, IOException {
            return (STTextFontScalePercent) XmlBeans.getContextTypeLoader().parse(inputStream, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextFontScalePercent) XmlBeans.getContextTypeLoader().parse(inputStream, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent parse(Reader reader) throws XmlException, IOException {
            return (STTextFontScalePercent) XmlBeans.getContextTypeLoader().parse(reader, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextFontScalePercent) XmlBeans.getContextTypeLoader().parse(reader, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent parse(String str) throws XmlException {
            return (STTextFontScalePercent) XmlBeans.getContextTypeLoader().parse(str, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STTextFontScalePercent) XmlBeans.getContextTypeLoader().parse(str, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent parse(URL url) throws XmlException, IOException {
            return (STTextFontScalePercent) XmlBeans.getContextTypeLoader().parse(url, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STTextFontScalePercent) XmlBeans.getContextTypeLoader().parse(url, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STTextFontScalePercent) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STTextFontScalePercent) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent parse(Node node) throws XmlException {
            return (STTextFontScalePercent) XmlBeans.getContextTypeLoader().parse(node, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STTextFontScalePercent) XmlBeans.getContextTypeLoader().parse(node, STTextFontScalePercent.type, xmlOptions);
        }
    }
}
