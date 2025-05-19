package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHdrFtr;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTHdrFtrRef extends CTRel {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTHdrFtrRef.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cthdrftrref224dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTHdrFtrRef newInstance() {
            return (CTHdrFtrRef) XmlBeans.getContextTypeLoader().newInstance(CTHdrFtrRef.type, null);
        }

        public static CTHdrFtrRef newInstance(XmlOptions xmlOptions) {
            return (CTHdrFtrRef) XmlBeans.getContextTypeLoader().newInstance(CTHdrFtrRef.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTHdrFtrRef.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTHdrFtrRef.type, xmlOptions);
        }

        public static CTHdrFtrRef parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTHdrFtrRef) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTHdrFtrRef.type, (XmlOptions) null);
        }

        public static CTHdrFtrRef parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTHdrFtrRef) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTHdrFtrRef.type, xmlOptions);
        }

        public static CTHdrFtrRef parse(File file) throws XmlException, IOException {
            return (CTHdrFtrRef) XmlBeans.getContextTypeLoader().parse(file, CTHdrFtrRef.type, (XmlOptions) null);
        }

        public static CTHdrFtrRef parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHdrFtrRef) XmlBeans.getContextTypeLoader().parse(file, CTHdrFtrRef.type, xmlOptions);
        }

        public static CTHdrFtrRef parse(InputStream inputStream) throws XmlException, IOException {
            return (CTHdrFtrRef) XmlBeans.getContextTypeLoader().parse(inputStream, CTHdrFtrRef.type, (XmlOptions) null);
        }

        public static CTHdrFtrRef parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHdrFtrRef) XmlBeans.getContextTypeLoader().parse(inputStream, CTHdrFtrRef.type, xmlOptions);
        }

        public static CTHdrFtrRef parse(Reader reader) throws XmlException, IOException {
            return (CTHdrFtrRef) XmlBeans.getContextTypeLoader().parse(reader, CTHdrFtrRef.type, (XmlOptions) null);
        }

        public static CTHdrFtrRef parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHdrFtrRef) XmlBeans.getContextTypeLoader().parse(reader, CTHdrFtrRef.type, xmlOptions);
        }

        public static CTHdrFtrRef parse(String str) throws XmlException {
            return (CTHdrFtrRef) XmlBeans.getContextTypeLoader().parse(str, CTHdrFtrRef.type, (XmlOptions) null);
        }

        public static CTHdrFtrRef parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTHdrFtrRef) XmlBeans.getContextTypeLoader().parse(str, CTHdrFtrRef.type, xmlOptions);
        }

        public static CTHdrFtrRef parse(URL url) throws XmlException, IOException {
            return (CTHdrFtrRef) XmlBeans.getContextTypeLoader().parse(url, CTHdrFtrRef.type, (XmlOptions) null);
        }

        public static CTHdrFtrRef parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHdrFtrRef) XmlBeans.getContextTypeLoader().parse(url, CTHdrFtrRef.type, xmlOptions);
        }

        public static CTHdrFtrRef parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTHdrFtrRef) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTHdrFtrRef.type, (XmlOptions) null);
        }

        public static CTHdrFtrRef parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTHdrFtrRef) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTHdrFtrRef.type, xmlOptions);
        }

        public static CTHdrFtrRef parse(Node node) throws XmlException {
            return (CTHdrFtrRef) XmlBeans.getContextTypeLoader().parse(node, CTHdrFtrRef.type, (XmlOptions) null);
        }

        public static CTHdrFtrRef parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTHdrFtrRef) XmlBeans.getContextTypeLoader().parse(node, CTHdrFtrRef.type, xmlOptions);
        }
    }

    STHdrFtr.Enum getType();

    void setType(STHdrFtr.Enum r1);

    STHdrFtr xgetType();

    void xsetType(STHdrFtr sTHdrFtr);
}
