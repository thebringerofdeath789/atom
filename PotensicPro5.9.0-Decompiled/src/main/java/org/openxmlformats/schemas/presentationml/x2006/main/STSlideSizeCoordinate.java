package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveCoordinate32;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface STSlideSizeCoordinate extends STPositiveCoordinate32 {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(STSlideSizeCoordinate.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("stslidesizecoordinate24b5type");

    public static final class Factory {
        private Factory() {
        }

        public static STSlideSizeCoordinate newInstance() {
            return (STSlideSizeCoordinate) XmlBeans.getContextTypeLoader().newInstance(STSlideSizeCoordinate.type, null);
        }

        public static STSlideSizeCoordinate newInstance(XmlOptions xmlOptions) {
            return (STSlideSizeCoordinate) XmlBeans.getContextTypeLoader().newInstance(STSlideSizeCoordinate.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STSlideSizeCoordinate.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, STSlideSizeCoordinate.type, xmlOptions);
        }

        public static STSlideSizeCoordinate newValue(Object obj) {
            return (STSlideSizeCoordinate) STSlideSizeCoordinate.type.newValue(obj);
        }

        public static STSlideSizeCoordinate parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (STSlideSizeCoordinate) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STSlideSizeCoordinate.type, (XmlOptions) null);
        }

        public static STSlideSizeCoordinate parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (STSlideSizeCoordinate) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, STSlideSizeCoordinate.type, xmlOptions);
        }

        public static STSlideSizeCoordinate parse(File file) throws XmlException, IOException {
            return (STSlideSizeCoordinate) XmlBeans.getContextTypeLoader().parse(file, STSlideSizeCoordinate.type, (XmlOptions) null);
        }

        public static STSlideSizeCoordinate parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSlideSizeCoordinate) XmlBeans.getContextTypeLoader().parse(file, STSlideSizeCoordinate.type, xmlOptions);
        }

        public static STSlideSizeCoordinate parse(InputStream inputStream) throws XmlException, IOException {
            return (STSlideSizeCoordinate) XmlBeans.getContextTypeLoader().parse(inputStream, STSlideSizeCoordinate.type, (XmlOptions) null);
        }

        public static STSlideSizeCoordinate parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSlideSizeCoordinate) XmlBeans.getContextTypeLoader().parse(inputStream, STSlideSizeCoordinate.type, xmlOptions);
        }

        public static STSlideSizeCoordinate parse(Reader reader) throws XmlException, IOException {
            return (STSlideSizeCoordinate) XmlBeans.getContextTypeLoader().parse(reader, STSlideSizeCoordinate.type, (XmlOptions) null);
        }

        public static STSlideSizeCoordinate parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSlideSizeCoordinate) XmlBeans.getContextTypeLoader().parse(reader, STSlideSizeCoordinate.type, xmlOptions);
        }

        public static STSlideSizeCoordinate parse(String str) throws XmlException {
            return (STSlideSizeCoordinate) XmlBeans.getContextTypeLoader().parse(str, STSlideSizeCoordinate.type, (XmlOptions) null);
        }

        public static STSlideSizeCoordinate parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (STSlideSizeCoordinate) XmlBeans.getContextTypeLoader().parse(str, STSlideSizeCoordinate.type, xmlOptions);
        }

        public static STSlideSizeCoordinate parse(URL url) throws XmlException, IOException {
            return (STSlideSizeCoordinate) XmlBeans.getContextTypeLoader().parse(url, STSlideSizeCoordinate.type, (XmlOptions) null);
        }

        public static STSlideSizeCoordinate parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (STSlideSizeCoordinate) XmlBeans.getContextTypeLoader().parse(url, STSlideSizeCoordinate.type, xmlOptions);
        }

        public static STSlideSizeCoordinate parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (STSlideSizeCoordinate) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STSlideSizeCoordinate.type, (XmlOptions) null);
        }

        public static STSlideSizeCoordinate parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (STSlideSizeCoordinate) XmlBeans.getContextTypeLoader().parse(xMLInputStream, STSlideSizeCoordinate.type, xmlOptions);
        }

        public static STSlideSizeCoordinate parse(Node node) throws XmlException {
            return (STSlideSizeCoordinate) XmlBeans.getContextTypeLoader().parse(node, STSlideSizeCoordinate.type, (XmlOptions) null);
        }

        public static STSlideSizeCoordinate parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (STSlideSizeCoordinate) XmlBeans.getContextTypeLoader().parse(node, STSlideSizeCoordinate.type, xmlOptions);
        }
    }
}
