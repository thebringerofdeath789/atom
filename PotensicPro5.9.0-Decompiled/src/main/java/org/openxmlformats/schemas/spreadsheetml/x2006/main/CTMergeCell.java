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
public interface CTMergeCell extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTMergeCell.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctmergecelle8d9type");

    public static final class Factory {
        private Factory() {
        }

        public static CTMergeCell newInstance() {
            return (CTMergeCell) XmlBeans.getContextTypeLoader().newInstance(CTMergeCell.type, null);
        }

        public static CTMergeCell newInstance(XmlOptions xmlOptions) {
            return (CTMergeCell) XmlBeans.getContextTypeLoader().newInstance(CTMergeCell.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTMergeCell.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTMergeCell.type, xmlOptions);
        }

        public static CTMergeCell parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTMergeCell) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTMergeCell.type, (XmlOptions) null);
        }

        public static CTMergeCell parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTMergeCell) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTMergeCell.type, xmlOptions);
        }

        public static CTMergeCell parse(File file) throws XmlException, IOException {
            return (CTMergeCell) XmlBeans.getContextTypeLoader().parse(file, CTMergeCell.type, (XmlOptions) null);
        }

        public static CTMergeCell parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMergeCell) XmlBeans.getContextTypeLoader().parse(file, CTMergeCell.type, xmlOptions);
        }

        public static CTMergeCell parse(InputStream inputStream) throws XmlException, IOException {
            return (CTMergeCell) XmlBeans.getContextTypeLoader().parse(inputStream, CTMergeCell.type, (XmlOptions) null);
        }

        public static CTMergeCell parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMergeCell) XmlBeans.getContextTypeLoader().parse(inputStream, CTMergeCell.type, xmlOptions);
        }

        public static CTMergeCell parse(Reader reader) throws XmlException, IOException {
            return (CTMergeCell) XmlBeans.getContextTypeLoader().parse(reader, CTMergeCell.type, (XmlOptions) null);
        }

        public static CTMergeCell parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMergeCell) XmlBeans.getContextTypeLoader().parse(reader, CTMergeCell.type, xmlOptions);
        }

        public static CTMergeCell parse(String str) throws XmlException {
            return (CTMergeCell) XmlBeans.getContextTypeLoader().parse(str, CTMergeCell.type, (XmlOptions) null);
        }

        public static CTMergeCell parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTMergeCell) XmlBeans.getContextTypeLoader().parse(str, CTMergeCell.type, xmlOptions);
        }

        public static CTMergeCell parse(URL url) throws XmlException, IOException {
            return (CTMergeCell) XmlBeans.getContextTypeLoader().parse(url, CTMergeCell.type, (XmlOptions) null);
        }

        public static CTMergeCell parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMergeCell) XmlBeans.getContextTypeLoader().parse(url, CTMergeCell.type, xmlOptions);
        }

        public static CTMergeCell parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTMergeCell) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTMergeCell.type, (XmlOptions) null);
        }

        public static CTMergeCell parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTMergeCell) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTMergeCell.type, xmlOptions);
        }

        public static CTMergeCell parse(Node node) throws XmlException {
            return (CTMergeCell) XmlBeans.getContextTypeLoader().parse(node, CTMergeCell.type, (XmlOptions) null);
        }

        public static CTMergeCell parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTMergeCell) XmlBeans.getContextTypeLoader().parse(node, CTMergeCell.type, xmlOptions);
        }
    }

    String getRef();

    void setRef(String str);

    STRef xgetRef();

    void xsetRef(STRef sTRef);
}
