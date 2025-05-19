package org.openxmlformats.schemas.xpackage.x2006.relationships;

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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.xpackage.x2006.relationships.STTargetMode;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTRelationship extends XmlString {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTRelationship.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("ctrelationship8cf8type");

    public static final class Factory {
        private Factory() {
        }

        public static CTRelationship newInstance() {
            return (CTRelationship) XmlBeans.getContextTypeLoader().newInstance(CTRelationship.type, null);
        }

        public static CTRelationship newInstance(XmlOptions xmlOptions) {
            return (CTRelationship) XmlBeans.getContextTypeLoader().newInstance(CTRelationship.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTRelationship.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTRelationship.type, xmlOptions);
        }

        public static CTRelationship parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTRelationship) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTRelationship.type, (XmlOptions) null);
        }

        public static CTRelationship parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTRelationship) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTRelationship.type, xmlOptions);
        }

        public static CTRelationship parse(File file) throws XmlException, IOException {
            return (CTRelationship) XmlBeans.getContextTypeLoader().parse(file, CTRelationship.type, (XmlOptions) null);
        }

        public static CTRelationship parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRelationship) XmlBeans.getContextTypeLoader().parse(file, CTRelationship.type, xmlOptions);
        }

        public static CTRelationship parse(InputStream inputStream) throws XmlException, IOException {
            return (CTRelationship) XmlBeans.getContextTypeLoader().parse(inputStream, CTRelationship.type, (XmlOptions) null);
        }

        public static CTRelationship parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRelationship) XmlBeans.getContextTypeLoader().parse(inputStream, CTRelationship.type, xmlOptions);
        }

        public static CTRelationship parse(Reader reader) throws XmlException, IOException {
            return (CTRelationship) XmlBeans.getContextTypeLoader().parse(reader, CTRelationship.type, (XmlOptions) null);
        }

        public static CTRelationship parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRelationship) XmlBeans.getContextTypeLoader().parse(reader, CTRelationship.type, xmlOptions);
        }

        public static CTRelationship parse(String str) throws XmlException {
            return (CTRelationship) XmlBeans.getContextTypeLoader().parse(str, CTRelationship.type, (XmlOptions) null);
        }

        public static CTRelationship parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTRelationship) XmlBeans.getContextTypeLoader().parse(str, CTRelationship.type, xmlOptions);
        }

        public static CTRelationship parse(URL url) throws XmlException, IOException {
            return (CTRelationship) XmlBeans.getContextTypeLoader().parse(url, CTRelationship.type, (XmlOptions) null);
        }

        public static CTRelationship parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRelationship) XmlBeans.getContextTypeLoader().parse(url, CTRelationship.type, xmlOptions);
        }

        public static CTRelationship parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTRelationship) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTRelationship.type, (XmlOptions) null);
        }

        public static CTRelationship parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTRelationship) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTRelationship.type, xmlOptions);
        }

        public static CTRelationship parse(Node node) throws XmlException {
            return (CTRelationship) XmlBeans.getContextTypeLoader().parse(node, CTRelationship.type, (XmlOptions) null);
        }

        public static CTRelationship parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTRelationship) XmlBeans.getContextTypeLoader().parse(node, CTRelationship.type, xmlOptions);
        }
    }

    String getId();

    String getTarget();

    STTargetMode.Enum getTargetMode();

    String getType();

    boolean isSetTargetMode();

    void setId(String str);

    void setTarget(String str);

    void setTargetMode(STTargetMode.Enum r1);

    void setType(String str);

    void unsetTargetMode();

    XmlID xgetId();

    XmlAnyURI xgetTarget();

    STTargetMode xgetTargetMode();

    XmlAnyURI xgetType();

    void xsetId(XmlID xmlID);

    void xsetTarget(XmlAnyURI xmlAnyURI);

    void xsetTargetMode(STTargetMode sTTargetMode);

    void xsetType(XmlAnyURI xmlAnyURI);
}
