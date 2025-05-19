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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTConnection extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTConnection.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctconnection7fb9type");

    public static final class Factory {
        private Factory() {
        }

        public static CTConnection newInstance() {
            return (CTConnection) XmlBeans.getContextTypeLoader().newInstance(CTConnection.type, null);
        }

        public static CTConnection newInstance(XmlOptions xmlOptions) {
            return (CTConnection) XmlBeans.getContextTypeLoader().newInstance(CTConnection.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTConnection.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTConnection.type, xmlOptions);
        }

        public static CTConnection parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTConnection) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTConnection.type, (XmlOptions) null);
        }

        public static CTConnection parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTConnection) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTConnection.type, xmlOptions);
        }

        public static CTConnection parse(File file) throws XmlException, IOException {
            return (CTConnection) XmlBeans.getContextTypeLoader().parse(file, CTConnection.type, (XmlOptions) null);
        }

        public static CTConnection parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConnection) XmlBeans.getContextTypeLoader().parse(file, CTConnection.type, xmlOptions);
        }

        public static CTConnection parse(InputStream inputStream) throws XmlException, IOException {
            return (CTConnection) XmlBeans.getContextTypeLoader().parse(inputStream, CTConnection.type, (XmlOptions) null);
        }

        public static CTConnection parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConnection) XmlBeans.getContextTypeLoader().parse(inputStream, CTConnection.type, xmlOptions);
        }

        public static CTConnection parse(Reader reader) throws XmlException, IOException {
            return (CTConnection) XmlBeans.getContextTypeLoader().parse(reader, CTConnection.type, (XmlOptions) null);
        }

        public static CTConnection parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConnection) XmlBeans.getContextTypeLoader().parse(reader, CTConnection.type, xmlOptions);
        }

        public static CTConnection parse(String str) throws XmlException {
            return (CTConnection) XmlBeans.getContextTypeLoader().parse(str, CTConnection.type, (XmlOptions) null);
        }

        public static CTConnection parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTConnection) XmlBeans.getContextTypeLoader().parse(str, CTConnection.type, xmlOptions);
        }

        public static CTConnection parse(URL url) throws XmlException, IOException {
            return (CTConnection) XmlBeans.getContextTypeLoader().parse(url, CTConnection.type, (XmlOptions) null);
        }

        public static CTConnection parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConnection) XmlBeans.getContextTypeLoader().parse(url, CTConnection.type, xmlOptions);
        }

        public static CTConnection parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTConnection) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTConnection.type, (XmlOptions) null);
        }

        public static CTConnection parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTConnection) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTConnection.type, xmlOptions);
        }

        public static CTConnection parse(Node node) throws XmlException {
            return (CTConnection) XmlBeans.getContextTypeLoader().parse(node, CTConnection.type, (XmlOptions) null);
        }

        public static CTConnection parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTConnection) XmlBeans.getContextTypeLoader().parse(node, CTConnection.type, xmlOptions);
        }
    }

    long getId();

    long getIdx();

    void setId(long j);

    void setIdx(long j);

    STDrawingElementId xgetId();

    XmlUnsignedInt xgetIdx();

    void xsetId(STDrawingElementId sTDrawingElementId);

    void xsetIdx(XmlUnsignedInt xmlUnsignedInt);
}
