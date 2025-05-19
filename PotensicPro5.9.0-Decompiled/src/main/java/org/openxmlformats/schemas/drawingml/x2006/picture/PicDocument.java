package org.openxmlformats.schemas.drawingml.x2006.picture;

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
public interface PicDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(PicDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("pic8010doctype");

    public static final class Factory {
        private Factory() {
        }

        public static PicDocument newInstance() {
            return (PicDocument) XmlBeans.getContextTypeLoader().newInstance(PicDocument.type, null);
        }

        public static PicDocument newInstance(XmlOptions xmlOptions) {
            return (PicDocument) XmlBeans.getContextTypeLoader().newInstance(PicDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, PicDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (PicDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (PicDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(File file) throws XmlException, IOException {
            return (PicDocument) XmlBeans.getContextTypeLoader().parse(file, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PicDocument) XmlBeans.getContextTypeLoader().parse(file, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (PicDocument) XmlBeans.getContextTypeLoader().parse(inputStream, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PicDocument) XmlBeans.getContextTypeLoader().parse(inputStream, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(Reader reader) throws XmlException, IOException {
            return (PicDocument) XmlBeans.getContextTypeLoader().parse(reader, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PicDocument) XmlBeans.getContextTypeLoader().parse(reader, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(String str) throws XmlException {
            return (PicDocument) XmlBeans.getContextTypeLoader().parse(str, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (PicDocument) XmlBeans.getContextTypeLoader().parse(str, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(URL url) throws XmlException, IOException {
            return (PicDocument) XmlBeans.getContextTypeLoader().parse(url, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PicDocument) XmlBeans.getContextTypeLoader().parse(url, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (PicDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (PicDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(Node node) throws XmlException {
            return (PicDocument) XmlBeans.getContextTypeLoader().parse(node, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (PicDocument) XmlBeans.getContextTypeLoader().parse(node, PicDocument.type, xmlOptions);
        }
    }

    CTPicture addNewPic();

    CTPicture getPic();

    void setPic(CTPicture cTPicture);
}
