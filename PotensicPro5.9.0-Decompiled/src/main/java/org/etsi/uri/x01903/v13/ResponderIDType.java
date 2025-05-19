package org.etsi.uri.x01903.v13;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface ResponderIDType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(ResponderIDType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("responderidtype55b9type");

    public static final class Factory {
        private Factory() {
        }

        public static ResponderIDType newInstance() {
            return (ResponderIDType) XmlBeans.getContextTypeLoader().newInstance(ResponderIDType.type, null);
        }

        public static ResponderIDType newInstance(XmlOptions xmlOptions) {
            return (ResponderIDType) XmlBeans.getContextTypeLoader().newInstance(ResponderIDType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ResponderIDType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ResponderIDType.type, xmlOptions);
        }

        public static ResponderIDType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ResponderIDType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ResponderIDType.type, (XmlOptions) null);
        }

        public static ResponderIDType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ResponderIDType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ResponderIDType.type, xmlOptions);
        }

        public static ResponderIDType parse(File file) throws XmlException, IOException {
            return (ResponderIDType) XmlBeans.getContextTypeLoader().parse(file, ResponderIDType.type, (XmlOptions) null);
        }

        public static ResponderIDType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ResponderIDType) XmlBeans.getContextTypeLoader().parse(file, ResponderIDType.type, xmlOptions);
        }

        public static ResponderIDType parse(InputStream inputStream) throws XmlException, IOException {
            return (ResponderIDType) XmlBeans.getContextTypeLoader().parse(inputStream, ResponderIDType.type, (XmlOptions) null);
        }

        public static ResponderIDType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ResponderIDType) XmlBeans.getContextTypeLoader().parse(inputStream, ResponderIDType.type, xmlOptions);
        }

        public static ResponderIDType parse(Reader reader) throws XmlException, IOException {
            return (ResponderIDType) XmlBeans.getContextTypeLoader().parse(reader, ResponderIDType.type, (XmlOptions) null);
        }

        public static ResponderIDType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ResponderIDType) XmlBeans.getContextTypeLoader().parse(reader, ResponderIDType.type, xmlOptions);
        }

        public static ResponderIDType parse(String str) throws XmlException {
            return (ResponderIDType) XmlBeans.getContextTypeLoader().parse(str, ResponderIDType.type, (XmlOptions) null);
        }

        public static ResponderIDType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ResponderIDType) XmlBeans.getContextTypeLoader().parse(str, ResponderIDType.type, xmlOptions);
        }

        public static ResponderIDType parse(URL url) throws XmlException, IOException {
            return (ResponderIDType) XmlBeans.getContextTypeLoader().parse(url, ResponderIDType.type, (XmlOptions) null);
        }

        public static ResponderIDType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ResponderIDType) XmlBeans.getContextTypeLoader().parse(url, ResponderIDType.type, xmlOptions);
        }

        public static ResponderIDType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (ResponderIDType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ResponderIDType.type, (XmlOptions) null);
        }

        public static ResponderIDType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (ResponderIDType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ResponderIDType.type, xmlOptions);
        }

        public static ResponderIDType parse(Node node) throws XmlException {
            return (ResponderIDType) XmlBeans.getContextTypeLoader().parse(node, ResponderIDType.type, (XmlOptions) null);
        }

        public static ResponderIDType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ResponderIDType) XmlBeans.getContextTypeLoader().parse(node, ResponderIDType.type, xmlOptions);
        }
    }

    byte[] getByKey();

    String getByName();

    boolean isSetByKey();

    boolean isSetByName();

    void setByKey(byte[] bArr);

    void setByName(String str);

    void unsetByKey();

    void unsetByName();

    XmlBase64Binary xgetByKey();

    XmlString xgetByName();

    void xsetByKey(XmlBase64Binary xmlBase64Binary);

    void xsetByName(XmlString xmlString);
}
