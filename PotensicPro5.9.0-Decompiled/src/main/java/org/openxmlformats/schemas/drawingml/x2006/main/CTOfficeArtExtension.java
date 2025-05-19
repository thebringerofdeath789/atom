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
public interface CTOfficeArtExtension extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTOfficeArtExtension.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctofficeartextension8e53type");

    public static final class Factory {
        private Factory() {
        }

        public static CTOfficeArtExtension newInstance() {
            return (CTOfficeArtExtension) XmlBeans.getContextTypeLoader().newInstance(CTOfficeArtExtension.type, null);
        }

        public static CTOfficeArtExtension newInstance(XmlOptions xmlOptions) {
            return (CTOfficeArtExtension) XmlBeans.getContextTypeLoader().newInstance(CTOfficeArtExtension.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTOfficeArtExtension.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTOfficeArtExtension) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTOfficeArtExtension) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(File file) throws XmlException, IOException {
            return (CTOfficeArtExtension) XmlBeans.getContextTypeLoader().parse(file, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeArtExtension) XmlBeans.getContextTypeLoader().parse(file, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(InputStream inputStream) throws XmlException, IOException {
            return (CTOfficeArtExtension) XmlBeans.getContextTypeLoader().parse(inputStream, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeArtExtension) XmlBeans.getContextTypeLoader().parse(inputStream, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(Reader reader) throws XmlException, IOException {
            return (CTOfficeArtExtension) XmlBeans.getContextTypeLoader().parse(reader, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeArtExtension) XmlBeans.getContextTypeLoader().parse(reader, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(String str) throws XmlException {
            return (CTOfficeArtExtension) XmlBeans.getContextTypeLoader().parse(str, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTOfficeArtExtension) XmlBeans.getContextTypeLoader().parse(str, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(URL url) throws XmlException, IOException {
            return (CTOfficeArtExtension) XmlBeans.getContextTypeLoader().parse(url, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeArtExtension) XmlBeans.getContextTypeLoader().parse(url, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTOfficeArtExtension) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTOfficeArtExtension) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(Node node) throws XmlException {
            return (CTOfficeArtExtension) XmlBeans.getContextTypeLoader().parse(node, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTOfficeArtExtension) XmlBeans.getContextTypeLoader().parse(node, CTOfficeArtExtension.type, xmlOptions);
        }
    }

    String getUri();

    boolean isSetUri();

    void setUri(String str);

    void unsetUri();

    XmlToken xgetUri();

    void xsetUri(XmlToken xmlToken);
}
