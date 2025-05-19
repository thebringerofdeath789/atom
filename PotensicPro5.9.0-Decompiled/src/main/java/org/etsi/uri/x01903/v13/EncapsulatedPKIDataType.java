package org.etsi.uri.x01903.v13;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface EncapsulatedPKIDataType extends XmlBase64Binary {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(EncapsulatedPKIDataType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("encapsulatedpkidatatype4081type");

    public static final class Factory {
        private Factory() {
        }

        public static EncapsulatedPKIDataType newInstance() {
            return (EncapsulatedPKIDataType) XmlBeans.getContextTypeLoader().newInstance(EncapsulatedPKIDataType.type, null);
        }

        public static EncapsulatedPKIDataType newInstance(XmlOptions xmlOptions) {
            return (EncapsulatedPKIDataType) XmlBeans.getContextTypeLoader().newInstance(EncapsulatedPKIDataType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, EncapsulatedPKIDataType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, EncapsulatedPKIDataType.type, xmlOptions);
        }

        public static EncapsulatedPKIDataType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (EncapsulatedPKIDataType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, EncapsulatedPKIDataType.type, (XmlOptions) null);
        }

        public static EncapsulatedPKIDataType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (EncapsulatedPKIDataType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, EncapsulatedPKIDataType.type, xmlOptions);
        }

        public static EncapsulatedPKIDataType parse(File file) throws XmlException, IOException {
            return (EncapsulatedPKIDataType) XmlBeans.getContextTypeLoader().parse(file, EncapsulatedPKIDataType.type, (XmlOptions) null);
        }

        public static EncapsulatedPKIDataType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EncapsulatedPKIDataType) XmlBeans.getContextTypeLoader().parse(file, EncapsulatedPKIDataType.type, xmlOptions);
        }

        public static EncapsulatedPKIDataType parse(InputStream inputStream) throws XmlException, IOException {
            return (EncapsulatedPKIDataType) XmlBeans.getContextTypeLoader().parse(inputStream, EncapsulatedPKIDataType.type, (XmlOptions) null);
        }

        public static EncapsulatedPKIDataType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EncapsulatedPKIDataType) XmlBeans.getContextTypeLoader().parse(inputStream, EncapsulatedPKIDataType.type, xmlOptions);
        }

        public static EncapsulatedPKIDataType parse(Reader reader) throws XmlException, IOException {
            return (EncapsulatedPKIDataType) XmlBeans.getContextTypeLoader().parse(reader, EncapsulatedPKIDataType.type, (XmlOptions) null);
        }

        public static EncapsulatedPKIDataType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EncapsulatedPKIDataType) XmlBeans.getContextTypeLoader().parse(reader, EncapsulatedPKIDataType.type, xmlOptions);
        }

        public static EncapsulatedPKIDataType parse(String str) throws XmlException {
            return (EncapsulatedPKIDataType) XmlBeans.getContextTypeLoader().parse(str, EncapsulatedPKIDataType.type, (XmlOptions) null);
        }

        public static EncapsulatedPKIDataType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (EncapsulatedPKIDataType) XmlBeans.getContextTypeLoader().parse(str, EncapsulatedPKIDataType.type, xmlOptions);
        }

        public static EncapsulatedPKIDataType parse(URL url) throws XmlException, IOException {
            return (EncapsulatedPKIDataType) XmlBeans.getContextTypeLoader().parse(url, EncapsulatedPKIDataType.type, (XmlOptions) null);
        }

        public static EncapsulatedPKIDataType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EncapsulatedPKIDataType) XmlBeans.getContextTypeLoader().parse(url, EncapsulatedPKIDataType.type, xmlOptions);
        }

        public static EncapsulatedPKIDataType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (EncapsulatedPKIDataType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, EncapsulatedPKIDataType.type, (XmlOptions) null);
        }

        public static EncapsulatedPKIDataType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (EncapsulatedPKIDataType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, EncapsulatedPKIDataType.type, xmlOptions);
        }

        public static EncapsulatedPKIDataType parse(Node node) throws XmlException {
            return (EncapsulatedPKIDataType) XmlBeans.getContextTypeLoader().parse(node, EncapsulatedPKIDataType.type, (XmlOptions) null);
        }

        public static EncapsulatedPKIDataType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (EncapsulatedPKIDataType) XmlBeans.getContextTypeLoader().parse(node, EncapsulatedPKIDataType.type, xmlOptions);
        }
    }

    String getEncoding();

    String getId();

    boolean isSetEncoding();

    boolean isSetId();

    void setEncoding(String str);

    void setId(String str);

    void unsetEncoding();

    void unsetId();

    XmlAnyURI xgetEncoding();

    XmlID xgetId();

    void xsetEncoding(XmlAnyURI xmlAnyURI);

    void xsetId(XmlID xmlID);
}
