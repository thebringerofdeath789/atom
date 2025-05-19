package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTAnchorClientData extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTAnchorClientData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctanchorclientdata02betype");

    public static final class Factory {
        private Factory() {
        }

        public static CTAnchorClientData newInstance() {
            return (CTAnchorClientData) XmlBeans.getContextTypeLoader().newInstance(CTAnchorClientData.type, null);
        }

        public static CTAnchorClientData newInstance(XmlOptions xmlOptions) {
            return (CTAnchorClientData) XmlBeans.getContextTypeLoader().newInstance(CTAnchorClientData.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTAnchorClientData.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTAnchorClientData.type, xmlOptions);
        }

        public static CTAnchorClientData parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTAnchorClientData) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTAnchorClientData.type, (XmlOptions) null);
        }

        public static CTAnchorClientData parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTAnchorClientData) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTAnchorClientData.type, xmlOptions);
        }

        public static CTAnchorClientData parse(File file) throws XmlException, IOException {
            return (CTAnchorClientData) XmlBeans.getContextTypeLoader().parse(file, CTAnchorClientData.type, (XmlOptions) null);
        }

        public static CTAnchorClientData parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAnchorClientData) XmlBeans.getContextTypeLoader().parse(file, CTAnchorClientData.type, xmlOptions);
        }

        public static CTAnchorClientData parse(InputStream inputStream) throws XmlException, IOException {
            return (CTAnchorClientData) XmlBeans.getContextTypeLoader().parse(inputStream, CTAnchorClientData.type, (XmlOptions) null);
        }

        public static CTAnchorClientData parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAnchorClientData) XmlBeans.getContextTypeLoader().parse(inputStream, CTAnchorClientData.type, xmlOptions);
        }

        public static CTAnchorClientData parse(Reader reader) throws XmlException, IOException {
            return (CTAnchorClientData) XmlBeans.getContextTypeLoader().parse(reader, CTAnchorClientData.type, (XmlOptions) null);
        }

        public static CTAnchorClientData parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAnchorClientData) XmlBeans.getContextTypeLoader().parse(reader, CTAnchorClientData.type, xmlOptions);
        }

        public static CTAnchorClientData parse(String str) throws XmlException {
            return (CTAnchorClientData) XmlBeans.getContextTypeLoader().parse(str, CTAnchorClientData.type, (XmlOptions) null);
        }

        public static CTAnchorClientData parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTAnchorClientData) XmlBeans.getContextTypeLoader().parse(str, CTAnchorClientData.type, xmlOptions);
        }

        public static CTAnchorClientData parse(URL url) throws XmlException, IOException {
            return (CTAnchorClientData) XmlBeans.getContextTypeLoader().parse(url, CTAnchorClientData.type, (XmlOptions) null);
        }

        public static CTAnchorClientData parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAnchorClientData) XmlBeans.getContextTypeLoader().parse(url, CTAnchorClientData.type, xmlOptions);
        }

        public static CTAnchorClientData parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTAnchorClientData) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTAnchorClientData.type, (XmlOptions) null);
        }

        public static CTAnchorClientData parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTAnchorClientData) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTAnchorClientData.type, xmlOptions);
        }

        public static CTAnchorClientData parse(Node node) throws XmlException {
            return (CTAnchorClientData) XmlBeans.getContextTypeLoader().parse(node, CTAnchorClientData.type, (XmlOptions) null);
        }

        public static CTAnchorClientData parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTAnchorClientData) XmlBeans.getContextTypeLoader().parse(node, CTAnchorClientData.type, xmlOptions);
        }
    }

    boolean getFLocksWithSheet();

    boolean getFPrintsWithSheet();

    boolean isSetFLocksWithSheet();

    boolean isSetFPrintsWithSheet();

    void setFLocksWithSheet(boolean z);

    void setFPrintsWithSheet(boolean z);

    void unsetFLocksWithSheet();

    void unsetFPrintsWithSheet();

    XmlBoolean xgetFLocksWithSheet();

    XmlBoolean xgetFPrintsWithSheet();

    void xsetFLocksWithSheet(XmlBoolean xmlBoolean);

    void xsetFPrintsWithSheet(XmlBoolean xmlBoolean);
}
