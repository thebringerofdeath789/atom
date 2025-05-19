package org.etsi.uri.x01903.v13;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface OCSPValuesType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(OCSPValuesType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("ocspvaluestypeb421type");

    public static final class Factory {
        private Factory() {
        }

        public static OCSPValuesType newInstance() {
            return (OCSPValuesType) XmlBeans.getContextTypeLoader().newInstance(OCSPValuesType.type, null);
        }

        public static OCSPValuesType newInstance(XmlOptions xmlOptions) {
            return (OCSPValuesType) XmlBeans.getContextTypeLoader().newInstance(OCSPValuesType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, OCSPValuesType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, OCSPValuesType.type, xmlOptions);
        }

        public static OCSPValuesType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (OCSPValuesType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, OCSPValuesType.type, (XmlOptions) null);
        }

        public static OCSPValuesType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (OCSPValuesType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, OCSPValuesType.type, xmlOptions);
        }

        public static OCSPValuesType parse(File file) throws XmlException, IOException {
            return (OCSPValuesType) XmlBeans.getContextTypeLoader().parse(file, OCSPValuesType.type, (XmlOptions) null);
        }

        public static OCSPValuesType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OCSPValuesType) XmlBeans.getContextTypeLoader().parse(file, OCSPValuesType.type, xmlOptions);
        }

        public static OCSPValuesType parse(InputStream inputStream) throws XmlException, IOException {
            return (OCSPValuesType) XmlBeans.getContextTypeLoader().parse(inputStream, OCSPValuesType.type, (XmlOptions) null);
        }

        public static OCSPValuesType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OCSPValuesType) XmlBeans.getContextTypeLoader().parse(inputStream, OCSPValuesType.type, xmlOptions);
        }

        public static OCSPValuesType parse(Reader reader) throws XmlException, IOException {
            return (OCSPValuesType) XmlBeans.getContextTypeLoader().parse(reader, OCSPValuesType.type, (XmlOptions) null);
        }

        public static OCSPValuesType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OCSPValuesType) XmlBeans.getContextTypeLoader().parse(reader, OCSPValuesType.type, xmlOptions);
        }

        public static OCSPValuesType parse(String str) throws XmlException {
            return (OCSPValuesType) XmlBeans.getContextTypeLoader().parse(str, OCSPValuesType.type, (XmlOptions) null);
        }

        public static OCSPValuesType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (OCSPValuesType) XmlBeans.getContextTypeLoader().parse(str, OCSPValuesType.type, xmlOptions);
        }

        public static OCSPValuesType parse(URL url) throws XmlException, IOException {
            return (OCSPValuesType) XmlBeans.getContextTypeLoader().parse(url, OCSPValuesType.type, (XmlOptions) null);
        }

        public static OCSPValuesType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OCSPValuesType) XmlBeans.getContextTypeLoader().parse(url, OCSPValuesType.type, xmlOptions);
        }

        public static OCSPValuesType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (OCSPValuesType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, OCSPValuesType.type, (XmlOptions) null);
        }

        public static OCSPValuesType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (OCSPValuesType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, OCSPValuesType.type, xmlOptions);
        }

        public static OCSPValuesType parse(Node node) throws XmlException {
            return (OCSPValuesType) XmlBeans.getContextTypeLoader().parse(node, OCSPValuesType.type, (XmlOptions) null);
        }

        public static OCSPValuesType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (OCSPValuesType) XmlBeans.getContextTypeLoader().parse(node, OCSPValuesType.type, xmlOptions);
        }
    }

    EncapsulatedPKIDataType addNewEncapsulatedOCSPValue();

    EncapsulatedPKIDataType getEncapsulatedOCSPValueArray(int i);

    EncapsulatedPKIDataType[] getEncapsulatedOCSPValueArray();

    List<EncapsulatedPKIDataType> getEncapsulatedOCSPValueList();

    EncapsulatedPKIDataType insertNewEncapsulatedOCSPValue(int i);

    void removeEncapsulatedOCSPValue(int i);

    void setEncapsulatedOCSPValueArray(int i, EncapsulatedPKIDataType encapsulatedPKIDataType);

    void setEncapsulatedOCSPValueArray(EncapsulatedPKIDataType[] encapsulatedPKIDataTypeArr);

    int sizeOfEncapsulatedOCSPValueArray();
}
