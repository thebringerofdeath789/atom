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
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3.x2000.x09.xmldsig.CanonicalizationMethodType;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface GenericTimeStampType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(GenericTimeStampType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("generictimestamptypecdadtype");

    public static final class Factory {
        private Factory() {
        }

        public static GenericTimeStampType newInstance() {
            return (GenericTimeStampType) XmlBeans.getContextTypeLoader().newInstance(GenericTimeStampType.type, null);
        }

        public static GenericTimeStampType newInstance(XmlOptions xmlOptions) {
            return (GenericTimeStampType) XmlBeans.getContextTypeLoader().newInstance(GenericTimeStampType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, GenericTimeStampType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, GenericTimeStampType.type, xmlOptions);
        }

        public static GenericTimeStampType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (GenericTimeStampType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, GenericTimeStampType.type, (XmlOptions) null);
        }

        public static GenericTimeStampType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (GenericTimeStampType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, GenericTimeStampType.type, xmlOptions);
        }

        public static GenericTimeStampType parse(File file) throws XmlException, IOException {
            return (GenericTimeStampType) XmlBeans.getContextTypeLoader().parse(file, GenericTimeStampType.type, (XmlOptions) null);
        }

        public static GenericTimeStampType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (GenericTimeStampType) XmlBeans.getContextTypeLoader().parse(file, GenericTimeStampType.type, xmlOptions);
        }

        public static GenericTimeStampType parse(InputStream inputStream) throws XmlException, IOException {
            return (GenericTimeStampType) XmlBeans.getContextTypeLoader().parse(inputStream, GenericTimeStampType.type, (XmlOptions) null);
        }

        public static GenericTimeStampType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (GenericTimeStampType) XmlBeans.getContextTypeLoader().parse(inputStream, GenericTimeStampType.type, xmlOptions);
        }

        public static GenericTimeStampType parse(Reader reader) throws XmlException, IOException {
            return (GenericTimeStampType) XmlBeans.getContextTypeLoader().parse(reader, GenericTimeStampType.type, (XmlOptions) null);
        }

        public static GenericTimeStampType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (GenericTimeStampType) XmlBeans.getContextTypeLoader().parse(reader, GenericTimeStampType.type, xmlOptions);
        }

        public static GenericTimeStampType parse(String str) throws XmlException {
            return (GenericTimeStampType) XmlBeans.getContextTypeLoader().parse(str, GenericTimeStampType.type, (XmlOptions) null);
        }

        public static GenericTimeStampType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (GenericTimeStampType) XmlBeans.getContextTypeLoader().parse(str, GenericTimeStampType.type, xmlOptions);
        }

        public static GenericTimeStampType parse(URL url) throws XmlException, IOException {
            return (GenericTimeStampType) XmlBeans.getContextTypeLoader().parse(url, GenericTimeStampType.type, (XmlOptions) null);
        }

        public static GenericTimeStampType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (GenericTimeStampType) XmlBeans.getContextTypeLoader().parse(url, GenericTimeStampType.type, xmlOptions);
        }

        public static GenericTimeStampType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (GenericTimeStampType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, GenericTimeStampType.type, (XmlOptions) null);
        }

        public static GenericTimeStampType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (GenericTimeStampType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, GenericTimeStampType.type, xmlOptions);
        }

        public static GenericTimeStampType parse(Node node) throws XmlException {
            return (GenericTimeStampType) XmlBeans.getContextTypeLoader().parse(node, GenericTimeStampType.type, (XmlOptions) null);
        }

        public static GenericTimeStampType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (GenericTimeStampType) XmlBeans.getContextTypeLoader().parse(node, GenericTimeStampType.type, xmlOptions);
        }
    }

    CanonicalizationMethodType addNewCanonicalizationMethod();

    EncapsulatedPKIDataType addNewEncapsulatedTimeStamp();

    IncludeType addNewInclude();

    ReferenceInfoType addNewReferenceInfo();

    AnyType addNewXMLTimeStamp();

    CanonicalizationMethodType getCanonicalizationMethod();

    EncapsulatedPKIDataType getEncapsulatedTimeStampArray(int i);

    EncapsulatedPKIDataType[] getEncapsulatedTimeStampArray();

    List<EncapsulatedPKIDataType> getEncapsulatedTimeStampList();

    String getId();

    IncludeType getIncludeArray(int i);

    IncludeType[] getIncludeArray();

    List<IncludeType> getIncludeList();

    ReferenceInfoType getReferenceInfoArray(int i);

    ReferenceInfoType[] getReferenceInfoArray();

    List<ReferenceInfoType> getReferenceInfoList();

    AnyType getXMLTimeStampArray(int i);

    AnyType[] getXMLTimeStampArray();

    List<AnyType> getXMLTimeStampList();

    EncapsulatedPKIDataType insertNewEncapsulatedTimeStamp(int i);

    IncludeType insertNewInclude(int i);

    ReferenceInfoType insertNewReferenceInfo(int i);

    AnyType insertNewXMLTimeStamp(int i);

    boolean isSetCanonicalizationMethod();

    boolean isSetId();

    void removeEncapsulatedTimeStamp(int i);

    void removeInclude(int i);

    void removeReferenceInfo(int i);

    void removeXMLTimeStamp(int i);

    void setCanonicalizationMethod(CanonicalizationMethodType canonicalizationMethodType);

    void setEncapsulatedTimeStampArray(int i, EncapsulatedPKIDataType encapsulatedPKIDataType);

    void setEncapsulatedTimeStampArray(EncapsulatedPKIDataType[] encapsulatedPKIDataTypeArr);

    void setId(String str);

    void setIncludeArray(int i, IncludeType includeType);

    void setIncludeArray(IncludeType[] includeTypeArr);

    void setReferenceInfoArray(int i, ReferenceInfoType referenceInfoType);

    void setReferenceInfoArray(ReferenceInfoType[] referenceInfoTypeArr);

    void setXMLTimeStampArray(int i, AnyType anyType);

    void setXMLTimeStampArray(AnyType[] anyTypeArr);

    int sizeOfEncapsulatedTimeStampArray();

    int sizeOfIncludeArray();

    int sizeOfReferenceInfoArray();

    int sizeOfXMLTimeStampArray();

    void unsetCanonicalizationMethod();

    void unsetId();

    XmlID xgetId();

    void xsetId(XmlID xmlID);
}
