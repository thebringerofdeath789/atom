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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTGraphicalObject extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTGraphicalObject.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctgraphicalobject1ce3type");

    public static final class Factory {
        private Factory() {
        }

        public static CTGraphicalObject newInstance() {
            return (CTGraphicalObject) XmlBeans.getContextTypeLoader().newInstance(CTGraphicalObject.type, null);
        }

        public static CTGraphicalObject newInstance(XmlOptions xmlOptions) {
            return (CTGraphicalObject) XmlBeans.getContextTypeLoader().newInstance(CTGraphicalObject.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGraphicalObject.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGraphicalObject) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObject) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(File file) throws XmlException, IOException {
            return (CTGraphicalObject) XmlBeans.getContextTypeLoader().parse(file, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObject) XmlBeans.getContextTypeLoader().parse(file, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGraphicalObject) XmlBeans.getContextTypeLoader().parse(inputStream, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObject) XmlBeans.getContextTypeLoader().parse(inputStream, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(Reader reader) throws XmlException, IOException {
            return (CTGraphicalObject) XmlBeans.getContextTypeLoader().parse(reader, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObject) XmlBeans.getContextTypeLoader().parse(reader, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(String str) throws XmlException {
            return (CTGraphicalObject) XmlBeans.getContextTypeLoader().parse(str, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObject) XmlBeans.getContextTypeLoader().parse(str, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(URL url) throws XmlException, IOException {
            return (CTGraphicalObject) XmlBeans.getContextTypeLoader().parse(url, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObject) XmlBeans.getContextTypeLoader().parse(url, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTGraphicalObject) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTGraphicalObject) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(Node node) throws XmlException {
            return (CTGraphicalObject) XmlBeans.getContextTypeLoader().parse(node, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObject) XmlBeans.getContextTypeLoader().parse(node, CTGraphicalObject.type, xmlOptions);
        }
    }

    CTGraphicalObjectData addNewGraphicData();

    CTGraphicalObjectData getGraphicData();

    void setGraphicData(CTGraphicalObjectData cTGraphicalObjectData);
}
