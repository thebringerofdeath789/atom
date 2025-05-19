package org.w3.x2000.x09.xmldsig;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface ReferenceType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(ReferenceType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("referencetypef44ctype");

    public static final class Factory {
        private Factory() {
        }

        public static ReferenceType newInstance() {
            return (ReferenceType) XmlBeans.getContextTypeLoader().newInstance(ReferenceType.type, null);
        }

        public static ReferenceType newInstance(XmlOptions xmlOptions) {
            return (ReferenceType) XmlBeans.getContextTypeLoader().newInstance(ReferenceType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ReferenceType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ReferenceType.type, xmlOptions);
        }

        public static ReferenceType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ReferenceType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ReferenceType.type, (XmlOptions) null);
        }

        public static ReferenceType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ReferenceType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ReferenceType.type, xmlOptions);
        }

        public static ReferenceType parse(File file) throws XmlException, IOException {
            return (ReferenceType) XmlBeans.getContextTypeLoader().parse(file, ReferenceType.type, (XmlOptions) null);
        }

        public static ReferenceType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ReferenceType) XmlBeans.getContextTypeLoader().parse(file, ReferenceType.type, xmlOptions);
        }

        public static ReferenceType parse(InputStream inputStream) throws XmlException, IOException {
            return (ReferenceType) XmlBeans.getContextTypeLoader().parse(inputStream, ReferenceType.type, (XmlOptions) null);
        }

        public static ReferenceType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ReferenceType) XmlBeans.getContextTypeLoader().parse(inputStream, ReferenceType.type, xmlOptions);
        }

        public static ReferenceType parse(Reader reader) throws XmlException, IOException {
            return (ReferenceType) XmlBeans.getContextTypeLoader().parse(reader, ReferenceType.type, (XmlOptions) null);
        }

        public static ReferenceType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ReferenceType) XmlBeans.getContextTypeLoader().parse(reader, ReferenceType.type, xmlOptions);
        }

        public static ReferenceType parse(String str) throws XmlException {
            return (ReferenceType) XmlBeans.getContextTypeLoader().parse(str, ReferenceType.type, (XmlOptions) null);
        }

        public static ReferenceType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ReferenceType) XmlBeans.getContextTypeLoader().parse(str, ReferenceType.type, xmlOptions);
        }

        public static ReferenceType parse(URL url) throws XmlException, IOException {
            return (ReferenceType) XmlBeans.getContextTypeLoader().parse(url, ReferenceType.type, (XmlOptions) null);
        }

        public static ReferenceType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ReferenceType) XmlBeans.getContextTypeLoader().parse(url, ReferenceType.type, xmlOptions);
        }

        public static ReferenceType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (ReferenceType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ReferenceType.type, (XmlOptions) null);
        }

        public static ReferenceType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (ReferenceType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ReferenceType.type, xmlOptions);
        }

        public static ReferenceType parse(Node node) throws XmlException {
            return (ReferenceType) XmlBeans.getContextTypeLoader().parse(node, ReferenceType.type, (XmlOptions) null);
        }

        public static ReferenceType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ReferenceType) XmlBeans.getContextTypeLoader().parse(node, ReferenceType.type, xmlOptions);
        }
    }

    DigestMethodType addNewDigestMethod();

    TransformsType addNewTransforms();

    DigestMethodType getDigestMethod();

    byte[] getDigestValue();

    String getId();

    TransformsType getTransforms();

    String getType();

    String getURI();

    boolean isSetId();

    boolean isSetTransforms();

    boolean isSetType();

    boolean isSetURI();

    void setDigestMethod(DigestMethodType digestMethodType);

    void setDigestValue(byte[] bArr);

    void setId(String str);

    void setTransforms(TransformsType transformsType);

    void setType(String str);

    void setURI(String str);

    void unsetId();

    void unsetTransforms();

    void unsetType();

    void unsetURI();

    DigestValueType xgetDigestValue();

    XmlID xgetId();

    XmlAnyURI xgetType();

    XmlAnyURI xgetURI();

    void xsetDigestValue(DigestValueType digestValueType);

    void xsetId(XmlID xmlID);

    void xsetType(XmlAnyURI xmlAnyURI);

    void xsetURI(XmlAnyURI xmlAnyURI);
}
