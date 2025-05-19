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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface ObjectType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(ObjectType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("objecttypec966type");

    public static final class Factory {
        private Factory() {
        }

        public static ObjectType newInstance() {
            return (ObjectType) XmlBeans.getContextTypeLoader().newInstance(ObjectType.type, null);
        }

        public static ObjectType newInstance(XmlOptions xmlOptions) {
            return (ObjectType) XmlBeans.getContextTypeLoader().newInstance(ObjectType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ObjectType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ObjectType.type, xmlOptions);
        }

        public static ObjectType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ObjectType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ObjectType.type, (XmlOptions) null);
        }

        public static ObjectType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ObjectType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ObjectType.type, xmlOptions);
        }

        public static ObjectType parse(File file) throws XmlException, IOException {
            return (ObjectType) XmlBeans.getContextTypeLoader().parse(file, ObjectType.type, (XmlOptions) null);
        }

        public static ObjectType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ObjectType) XmlBeans.getContextTypeLoader().parse(file, ObjectType.type, xmlOptions);
        }

        public static ObjectType parse(InputStream inputStream) throws XmlException, IOException {
            return (ObjectType) XmlBeans.getContextTypeLoader().parse(inputStream, ObjectType.type, (XmlOptions) null);
        }

        public static ObjectType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ObjectType) XmlBeans.getContextTypeLoader().parse(inputStream, ObjectType.type, xmlOptions);
        }

        public static ObjectType parse(Reader reader) throws XmlException, IOException {
            return (ObjectType) XmlBeans.getContextTypeLoader().parse(reader, ObjectType.type, (XmlOptions) null);
        }

        public static ObjectType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ObjectType) XmlBeans.getContextTypeLoader().parse(reader, ObjectType.type, xmlOptions);
        }

        public static ObjectType parse(String str) throws XmlException {
            return (ObjectType) XmlBeans.getContextTypeLoader().parse(str, ObjectType.type, (XmlOptions) null);
        }

        public static ObjectType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ObjectType) XmlBeans.getContextTypeLoader().parse(str, ObjectType.type, xmlOptions);
        }

        public static ObjectType parse(URL url) throws XmlException, IOException {
            return (ObjectType) XmlBeans.getContextTypeLoader().parse(url, ObjectType.type, (XmlOptions) null);
        }

        public static ObjectType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ObjectType) XmlBeans.getContextTypeLoader().parse(url, ObjectType.type, xmlOptions);
        }

        public static ObjectType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (ObjectType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ObjectType.type, (XmlOptions) null);
        }

        public static ObjectType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (ObjectType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ObjectType.type, xmlOptions);
        }

        public static ObjectType parse(Node node) throws XmlException {
            return (ObjectType) XmlBeans.getContextTypeLoader().parse(node, ObjectType.type, (XmlOptions) null);
        }

        public static ObjectType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ObjectType) XmlBeans.getContextTypeLoader().parse(node, ObjectType.type, xmlOptions);
        }
    }

    String getEncoding();

    String getId();

    String getMimeType();

    boolean isSetEncoding();

    boolean isSetId();

    boolean isSetMimeType();

    void setEncoding(String str);

    void setId(String str);

    void setMimeType(String str);

    void unsetEncoding();

    void unsetId();

    void unsetMimeType();

    XmlAnyURI xgetEncoding();

    XmlID xgetId();

    XmlString xgetMimeType();

    void xsetEncoding(XmlAnyURI xmlAnyURI);

    void xsetId(XmlID xmlID);

    void xsetMimeType(XmlString xmlString);
}
