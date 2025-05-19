package org.etsi.uri.x01903.v13;

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
public interface XAdESTimeStampType extends GenericTimeStampType {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(XAdESTimeStampType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("xadestimestamptypeaedbtype");

    public static final class Factory {
        private Factory() {
        }

        public static XAdESTimeStampType newInstance() {
            return (XAdESTimeStampType) XmlBeans.getContextTypeLoader().newInstance(XAdESTimeStampType.type, null);
        }

        public static XAdESTimeStampType newInstance(XmlOptions xmlOptions) {
            return (XAdESTimeStampType) XmlBeans.getContextTypeLoader().newInstance(XAdESTimeStampType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XAdESTimeStampType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XAdESTimeStampType.type, xmlOptions);
        }

        public static XAdESTimeStampType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XAdESTimeStampType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XAdESTimeStampType.type, (XmlOptions) null);
        }

        public static XAdESTimeStampType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XAdESTimeStampType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XAdESTimeStampType.type, xmlOptions);
        }

        public static XAdESTimeStampType parse(File file) throws XmlException, IOException {
            return (XAdESTimeStampType) XmlBeans.getContextTypeLoader().parse(file, XAdESTimeStampType.type, (XmlOptions) null);
        }

        public static XAdESTimeStampType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XAdESTimeStampType) XmlBeans.getContextTypeLoader().parse(file, XAdESTimeStampType.type, xmlOptions);
        }

        public static XAdESTimeStampType parse(InputStream inputStream) throws XmlException, IOException {
            return (XAdESTimeStampType) XmlBeans.getContextTypeLoader().parse(inputStream, XAdESTimeStampType.type, (XmlOptions) null);
        }

        public static XAdESTimeStampType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XAdESTimeStampType) XmlBeans.getContextTypeLoader().parse(inputStream, XAdESTimeStampType.type, xmlOptions);
        }

        public static XAdESTimeStampType parse(Reader reader) throws XmlException, IOException {
            return (XAdESTimeStampType) XmlBeans.getContextTypeLoader().parse(reader, XAdESTimeStampType.type, (XmlOptions) null);
        }

        public static XAdESTimeStampType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XAdESTimeStampType) XmlBeans.getContextTypeLoader().parse(reader, XAdESTimeStampType.type, xmlOptions);
        }

        public static XAdESTimeStampType parse(String str) throws XmlException {
            return (XAdESTimeStampType) XmlBeans.getContextTypeLoader().parse(str, XAdESTimeStampType.type, (XmlOptions) null);
        }

        public static XAdESTimeStampType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XAdESTimeStampType) XmlBeans.getContextTypeLoader().parse(str, XAdESTimeStampType.type, xmlOptions);
        }

        public static XAdESTimeStampType parse(URL url) throws XmlException, IOException {
            return (XAdESTimeStampType) XmlBeans.getContextTypeLoader().parse(url, XAdESTimeStampType.type, (XmlOptions) null);
        }

        public static XAdESTimeStampType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XAdESTimeStampType) XmlBeans.getContextTypeLoader().parse(url, XAdESTimeStampType.type, xmlOptions);
        }

        public static XAdESTimeStampType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (XAdESTimeStampType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XAdESTimeStampType.type, (XmlOptions) null);
        }

        public static XAdESTimeStampType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (XAdESTimeStampType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XAdESTimeStampType.type, xmlOptions);
        }

        public static XAdESTimeStampType parse(Node node) throws XmlException {
            return (XAdESTimeStampType) XmlBeans.getContextTypeLoader().parse(node, XAdESTimeStampType.type, (XmlOptions) null);
        }

        public static XAdESTimeStampType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XAdESTimeStampType) XmlBeans.getContextTypeLoader().parse(node, XAdESTimeStampType.type, xmlOptions);
        }
    }
}
