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
public interface CRLValuesType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CRLValuesType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("crlvaluestype0ebbtype");

    public static final class Factory {
        private Factory() {
        }

        public static CRLValuesType newInstance() {
            return (CRLValuesType) XmlBeans.getContextTypeLoader().newInstance(CRLValuesType.type, null);
        }

        public static CRLValuesType newInstance(XmlOptions xmlOptions) {
            return (CRLValuesType) XmlBeans.getContextTypeLoader().newInstance(CRLValuesType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CRLValuesType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CRLValuesType.type, xmlOptions);
        }

        public static CRLValuesType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CRLValuesType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CRLValuesType.type, (XmlOptions) null);
        }

        public static CRLValuesType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CRLValuesType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CRLValuesType.type, xmlOptions);
        }

        public static CRLValuesType parse(File file) throws XmlException, IOException {
            return (CRLValuesType) XmlBeans.getContextTypeLoader().parse(file, CRLValuesType.type, (XmlOptions) null);
        }

        public static CRLValuesType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CRLValuesType) XmlBeans.getContextTypeLoader().parse(file, CRLValuesType.type, xmlOptions);
        }

        public static CRLValuesType parse(InputStream inputStream) throws XmlException, IOException {
            return (CRLValuesType) XmlBeans.getContextTypeLoader().parse(inputStream, CRLValuesType.type, (XmlOptions) null);
        }

        public static CRLValuesType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CRLValuesType) XmlBeans.getContextTypeLoader().parse(inputStream, CRLValuesType.type, xmlOptions);
        }

        public static CRLValuesType parse(Reader reader) throws XmlException, IOException {
            return (CRLValuesType) XmlBeans.getContextTypeLoader().parse(reader, CRLValuesType.type, (XmlOptions) null);
        }

        public static CRLValuesType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CRLValuesType) XmlBeans.getContextTypeLoader().parse(reader, CRLValuesType.type, xmlOptions);
        }

        public static CRLValuesType parse(String str) throws XmlException {
            return (CRLValuesType) XmlBeans.getContextTypeLoader().parse(str, CRLValuesType.type, (XmlOptions) null);
        }

        public static CRLValuesType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CRLValuesType) XmlBeans.getContextTypeLoader().parse(str, CRLValuesType.type, xmlOptions);
        }

        public static CRLValuesType parse(URL url) throws XmlException, IOException {
            return (CRLValuesType) XmlBeans.getContextTypeLoader().parse(url, CRLValuesType.type, (XmlOptions) null);
        }

        public static CRLValuesType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CRLValuesType) XmlBeans.getContextTypeLoader().parse(url, CRLValuesType.type, xmlOptions);
        }

        public static CRLValuesType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CRLValuesType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CRLValuesType.type, (XmlOptions) null);
        }

        public static CRLValuesType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CRLValuesType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CRLValuesType.type, xmlOptions);
        }

        public static CRLValuesType parse(Node node) throws XmlException {
            return (CRLValuesType) XmlBeans.getContextTypeLoader().parse(node, CRLValuesType.type, (XmlOptions) null);
        }

        public static CRLValuesType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CRLValuesType) XmlBeans.getContextTypeLoader().parse(node, CRLValuesType.type, xmlOptions);
        }
    }

    EncapsulatedPKIDataType addNewEncapsulatedCRLValue();

    EncapsulatedPKIDataType getEncapsulatedCRLValueArray(int i);

    EncapsulatedPKIDataType[] getEncapsulatedCRLValueArray();

    List<EncapsulatedPKIDataType> getEncapsulatedCRLValueList();

    EncapsulatedPKIDataType insertNewEncapsulatedCRLValue(int i);

    void removeEncapsulatedCRLValue(int i);

    void setEncapsulatedCRLValueArray(int i, EncapsulatedPKIDataType encapsulatedPKIDataType);

    void setEncapsulatedCRLValueArray(EncapsulatedPKIDataType[] encapsulatedPKIDataTypeArr);

    int sizeOfEncapsulatedCRLValueArray();
}
