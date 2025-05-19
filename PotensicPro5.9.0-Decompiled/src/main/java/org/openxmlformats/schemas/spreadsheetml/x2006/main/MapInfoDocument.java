package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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

/* loaded from: classes6.dex */
public interface MapInfoDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(MapInfoDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("mapinfo5715doctype");

    public static final class Factory {
        private Factory() {
        }

        public static MapInfoDocument newInstance() {
            return (MapInfoDocument) XmlBeans.getContextTypeLoader().newInstance(MapInfoDocument.type, null);
        }

        public static MapInfoDocument newInstance(XmlOptions xmlOptions) {
            return (MapInfoDocument) XmlBeans.getContextTypeLoader().newInstance(MapInfoDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, MapInfoDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, MapInfoDocument.type, xmlOptions);
        }

        public static MapInfoDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (MapInfoDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, MapInfoDocument.type, (XmlOptions) null);
        }

        public static MapInfoDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (MapInfoDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, MapInfoDocument.type, xmlOptions);
        }

        public static MapInfoDocument parse(File file) throws XmlException, IOException {
            return (MapInfoDocument) XmlBeans.getContextTypeLoader().parse(file, MapInfoDocument.type, (XmlOptions) null);
        }

        public static MapInfoDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MapInfoDocument) XmlBeans.getContextTypeLoader().parse(file, MapInfoDocument.type, xmlOptions);
        }

        public static MapInfoDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (MapInfoDocument) XmlBeans.getContextTypeLoader().parse(inputStream, MapInfoDocument.type, (XmlOptions) null);
        }

        public static MapInfoDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MapInfoDocument) XmlBeans.getContextTypeLoader().parse(inputStream, MapInfoDocument.type, xmlOptions);
        }

        public static MapInfoDocument parse(Reader reader) throws XmlException, IOException {
            return (MapInfoDocument) XmlBeans.getContextTypeLoader().parse(reader, MapInfoDocument.type, (XmlOptions) null);
        }

        public static MapInfoDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MapInfoDocument) XmlBeans.getContextTypeLoader().parse(reader, MapInfoDocument.type, xmlOptions);
        }

        public static MapInfoDocument parse(String str) throws XmlException {
            return (MapInfoDocument) XmlBeans.getContextTypeLoader().parse(str, MapInfoDocument.type, (XmlOptions) null);
        }

        public static MapInfoDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (MapInfoDocument) XmlBeans.getContextTypeLoader().parse(str, MapInfoDocument.type, xmlOptions);
        }

        public static MapInfoDocument parse(URL url) throws XmlException, IOException {
            return (MapInfoDocument) XmlBeans.getContextTypeLoader().parse(url, MapInfoDocument.type, (XmlOptions) null);
        }

        public static MapInfoDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MapInfoDocument) XmlBeans.getContextTypeLoader().parse(url, MapInfoDocument.type, xmlOptions);
        }

        public static MapInfoDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (MapInfoDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, MapInfoDocument.type, (XmlOptions) null);
        }

        public static MapInfoDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (MapInfoDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, MapInfoDocument.type, xmlOptions);
        }

        public static MapInfoDocument parse(Node node) throws XmlException {
            return (MapInfoDocument) XmlBeans.getContextTypeLoader().parse(node, MapInfoDocument.type, (XmlOptions) null);
        }

        public static MapInfoDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (MapInfoDocument) XmlBeans.getContextTypeLoader().parse(node, MapInfoDocument.type, xmlOptions);
        }
    }

    CTMapInfo addNewMapInfo();

    CTMapInfo getMapInfo();

    void setMapInfo(CTMapInfo cTMapInfo);
}
