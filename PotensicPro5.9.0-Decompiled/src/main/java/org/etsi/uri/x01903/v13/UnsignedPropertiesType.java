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
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface UnsignedPropertiesType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(UnsignedPropertiesType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("unsignedpropertiestype49d6type");

    public static final class Factory {
        private Factory() {
        }

        public static UnsignedPropertiesType newInstance() {
            return (UnsignedPropertiesType) XmlBeans.getContextTypeLoader().newInstance(UnsignedPropertiesType.type, null);
        }

        public static UnsignedPropertiesType newInstance(XmlOptions xmlOptions) {
            return (UnsignedPropertiesType) XmlBeans.getContextTypeLoader().newInstance(UnsignedPropertiesType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, UnsignedPropertiesType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, UnsignedPropertiesType.type, xmlOptions);
        }

        public static UnsignedPropertiesType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (UnsignedPropertiesType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, UnsignedPropertiesType.type, (XmlOptions) null);
        }

        public static UnsignedPropertiesType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (UnsignedPropertiesType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, UnsignedPropertiesType.type, xmlOptions);
        }

        public static UnsignedPropertiesType parse(File file) throws XmlException, IOException {
            return (UnsignedPropertiesType) XmlBeans.getContextTypeLoader().parse(file, UnsignedPropertiesType.type, (XmlOptions) null);
        }

        public static UnsignedPropertiesType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (UnsignedPropertiesType) XmlBeans.getContextTypeLoader().parse(file, UnsignedPropertiesType.type, xmlOptions);
        }

        public static UnsignedPropertiesType parse(InputStream inputStream) throws XmlException, IOException {
            return (UnsignedPropertiesType) XmlBeans.getContextTypeLoader().parse(inputStream, UnsignedPropertiesType.type, (XmlOptions) null);
        }

        public static UnsignedPropertiesType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (UnsignedPropertiesType) XmlBeans.getContextTypeLoader().parse(inputStream, UnsignedPropertiesType.type, xmlOptions);
        }

        public static UnsignedPropertiesType parse(Reader reader) throws XmlException, IOException {
            return (UnsignedPropertiesType) XmlBeans.getContextTypeLoader().parse(reader, UnsignedPropertiesType.type, (XmlOptions) null);
        }

        public static UnsignedPropertiesType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (UnsignedPropertiesType) XmlBeans.getContextTypeLoader().parse(reader, UnsignedPropertiesType.type, xmlOptions);
        }

        public static UnsignedPropertiesType parse(String str) throws XmlException {
            return (UnsignedPropertiesType) XmlBeans.getContextTypeLoader().parse(str, UnsignedPropertiesType.type, (XmlOptions) null);
        }

        public static UnsignedPropertiesType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (UnsignedPropertiesType) XmlBeans.getContextTypeLoader().parse(str, UnsignedPropertiesType.type, xmlOptions);
        }

        public static UnsignedPropertiesType parse(URL url) throws XmlException, IOException {
            return (UnsignedPropertiesType) XmlBeans.getContextTypeLoader().parse(url, UnsignedPropertiesType.type, (XmlOptions) null);
        }

        public static UnsignedPropertiesType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (UnsignedPropertiesType) XmlBeans.getContextTypeLoader().parse(url, UnsignedPropertiesType.type, xmlOptions);
        }

        public static UnsignedPropertiesType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (UnsignedPropertiesType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, UnsignedPropertiesType.type, (XmlOptions) null);
        }

        public static UnsignedPropertiesType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (UnsignedPropertiesType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, UnsignedPropertiesType.type, xmlOptions);
        }

        public static UnsignedPropertiesType parse(Node node) throws XmlException {
            return (UnsignedPropertiesType) XmlBeans.getContextTypeLoader().parse(node, UnsignedPropertiesType.type, (XmlOptions) null);
        }

        public static UnsignedPropertiesType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (UnsignedPropertiesType) XmlBeans.getContextTypeLoader().parse(node, UnsignedPropertiesType.type, xmlOptions);
        }
    }

    UnsignedDataObjectPropertiesType addNewUnsignedDataObjectProperties();

    UnsignedSignaturePropertiesType addNewUnsignedSignatureProperties();

    String getId();

    UnsignedDataObjectPropertiesType getUnsignedDataObjectProperties();

    UnsignedSignaturePropertiesType getUnsignedSignatureProperties();

    boolean isSetId();

    boolean isSetUnsignedDataObjectProperties();

    boolean isSetUnsignedSignatureProperties();

    void setId(String str);

    void setUnsignedDataObjectProperties(UnsignedDataObjectPropertiesType unsignedDataObjectPropertiesType);

    void setUnsignedSignatureProperties(UnsignedSignaturePropertiesType unsignedSignaturePropertiesType);

    void unsetId();

    void unsetUnsignedDataObjectProperties();

    void unsetUnsignedSignatureProperties();

    XmlID xgetId();

    void xsetId(XmlID xmlID);
}
