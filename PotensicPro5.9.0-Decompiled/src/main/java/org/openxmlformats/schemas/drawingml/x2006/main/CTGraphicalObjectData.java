package org.openxmlformats.schemas.drawingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTGraphicalObjectData extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTGraphicalObjectData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctgraphicalobjectdata66adtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTGraphicalObjectData newInstance() {
            return (CTGraphicalObjectData) XmlBeans.getContextTypeLoader().newInstance(CTGraphicalObjectData.type, null);
        }

        public static CTGraphicalObjectData newInstance(XmlOptions xmlOptions) {
            return (CTGraphicalObjectData) XmlBeans.getContextTypeLoader().newInstance(CTGraphicalObjectData.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGraphicalObjectData.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGraphicalObjectData) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObjectData) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(File file) throws XmlException, IOException {
            return (CTGraphicalObjectData) XmlBeans.getContextTypeLoader().parse(file, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectData) XmlBeans.getContextTypeLoader().parse(file, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGraphicalObjectData) XmlBeans.getContextTypeLoader().parse(inputStream, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectData) XmlBeans.getContextTypeLoader().parse(inputStream, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(Reader reader) throws XmlException, IOException {
            return (CTGraphicalObjectData) XmlBeans.getContextTypeLoader().parse(reader, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectData) XmlBeans.getContextTypeLoader().parse(reader, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(String str) throws XmlException {
            return (CTGraphicalObjectData) XmlBeans.getContextTypeLoader().parse(str, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObjectData) XmlBeans.getContextTypeLoader().parse(str, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(URL url) throws XmlException, IOException {
            return (CTGraphicalObjectData) XmlBeans.getContextTypeLoader().parse(url, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectData) XmlBeans.getContextTypeLoader().parse(url, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTGraphicalObjectData) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTGraphicalObjectData) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(Node node) throws XmlException {
            return (CTGraphicalObjectData) XmlBeans.getContextTypeLoader().parse(node, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObjectData) XmlBeans.getContextTypeLoader().parse(node, CTGraphicalObjectData.type, xmlOptions);
        }
    }

    String getUri();

    boolean isSetUri();

    void setUri(String str);

    void unsetUri();

    XmlToken xgetUri();

    void xsetUri(XmlToken xmlToken);
}
