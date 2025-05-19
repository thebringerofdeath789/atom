package org.etsi.uri.x01903.v13;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Calendar;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface OCSPIdentifierType extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(OCSPIdentifierType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("ocspidentifiertype3968type");

    public static final class Factory {
        private Factory() {
        }

        public static OCSPIdentifierType newInstance() {
            return (OCSPIdentifierType) XmlBeans.getContextTypeLoader().newInstance(OCSPIdentifierType.type, null);
        }

        public static OCSPIdentifierType newInstance(XmlOptions xmlOptions) {
            return (OCSPIdentifierType) XmlBeans.getContextTypeLoader().newInstance(OCSPIdentifierType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, OCSPIdentifierType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, OCSPIdentifierType.type, xmlOptions);
        }

        public static OCSPIdentifierType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (OCSPIdentifierType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, OCSPIdentifierType.type, (XmlOptions) null);
        }

        public static OCSPIdentifierType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (OCSPIdentifierType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, OCSPIdentifierType.type, xmlOptions);
        }

        public static OCSPIdentifierType parse(File file) throws XmlException, IOException {
            return (OCSPIdentifierType) XmlBeans.getContextTypeLoader().parse(file, OCSPIdentifierType.type, (XmlOptions) null);
        }

        public static OCSPIdentifierType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OCSPIdentifierType) XmlBeans.getContextTypeLoader().parse(file, OCSPIdentifierType.type, xmlOptions);
        }

        public static OCSPIdentifierType parse(InputStream inputStream) throws XmlException, IOException {
            return (OCSPIdentifierType) XmlBeans.getContextTypeLoader().parse(inputStream, OCSPIdentifierType.type, (XmlOptions) null);
        }

        public static OCSPIdentifierType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OCSPIdentifierType) XmlBeans.getContextTypeLoader().parse(inputStream, OCSPIdentifierType.type, xmlOptions);
        }

        public static OCSPIdentifierType parse(Reader reader) throws XmlException, IOException {
            return (OCSPIdentifierType) XmlBeans.getContextTypeLoader().parse(reader, OCSPIdentifierType.type, (XmlOptions) null);
        }

        public static OCSPIdentifierType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OCSPIdentifierType) XmlBeans.getContextTypeLoader().parse(reader, OCSPIdentifierType.type, xmlOptions);
        }

        public static OCSPIdentifierType parse(String str) throws XmlException {
            return (OCSPIdentifierType) XmlBeans.getContextTypeLoader().parse(str, OCSPIdentifierType.type, (XmlOptions) null);
        }

        public static OCSPIdentifierType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (OCSPIdentifierType) XmlBeans.getContextTypeLoader().parse(str, OCSPIdentifierType.type, xmlOptions);
        }

        public static OCSPIdentifierType parse(URL url) throws XmlException, IOException {
            return (OCSPIdentifierType) XmlBeans.getContextTypeLoader().parse(url, OCSPIdentifierType.type, (XmlOptions) null);
        }

        public static OCSPIdentifierType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (OCSPIdentifierType) XmlBeans.getContextTypeLoader().parse(url, OCSPIdentifierType.type, xmlOptions);
        }

        public static OCSPIdentifierType parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (OCSPIdentifierType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, OCSPIdentifierType.type, (XmlOptions) null);
        }

        public static OCSPIdentifierType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (OCSPIdentifierType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, OCSPIdentifierType.type, xmlOptions);
        }

        public static OCSPIdentifierType parse(Node node) throws XmlException {
            return (OCSPIdentifierType) XmlBeans.getContextTypeLoader().parse(node, OCSPIdentifierType.type, (XmlOptions) null);
        }

        public static OCSPIdentifierType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (OCSPIdentifierType) XmlBeans.getContextTypeLoader().parse(node, OCSPIdentifierType.type, xmlOptions);
        }
    }

    ResponderIDType addNewResponderID();

    Calendar getProducedAt();

    ResponderIDType getResponderID();

    String getURI();

    boolean isSetURI();

    void setProducedAt(Calendar calendar);

    void setResponderID(ResponderIDType responderIDType);

    void setURI(String str);

    void unsetURI();

    XmlDateTime xgetProducedAt();

    XmlAnyURI xgetURI();

    void xsetProducedAt(XmlDateTime xmlDateTime);

    void xsetURI(XmlAnyURI xmlAnyURI);
}
