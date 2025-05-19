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
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTTblGrid extends CTTblGridBase {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTblGrid.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttblgrid2eeetype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblGrid newInstance() {
            return (CTTblGrid) XmlBeans.getContextTypeLoader().newInstance(CTTblGrid.type, null);
        }

        public static CTTblGrid newInstance(XmlOptions xmlOptions) {
            return (CTTblGrid) XmlBeans.getContextTypeLoader().newInstance(CTTblGrid.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTblGrid.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTblGrid.type, xmlOptions);
        }

        public static CTTblGrid parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTblGrid) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTblGrid.type, (XmlOptions) null);
        }

        public static CTTblGrid parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTblGrid) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTblGrid.type, xmlOptions);
        }

        public static CTTblGrid parse(File file) throws XmlException, IOException {
            return (CTTblGrid) XmlBeans.getContextTypeLoader().parse(file, CTTblGrid.type, (XmlOptions) null);
        }

        public static CTTblGrid parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblGrid) XmlBeans.getContextTypeLoader().parse(file, CTTblGrid.type, xmlOptions);
        }

        public static CTTblGrid parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTblGrid) XmlBeans.getContextTypeLoader().parse(inputStream, CTTblGrid.type, (XmlOptions) null);
        }

        public static CTTblGrid parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblGrid) XmlBeans.getContextTypeLoader().parse(inputStream, CTTblGrid.type, xmlOptions);
        }

        public static CTTblGrid parse(Reader reader) throws XmlException, IOException {
            return (CTTblGrid) XmlBeans.getContextTypeLoader().parse(reader, CTTblGrid.type, (XmlOptions) null);
        }

        public static CTTblGrid parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblGrid) XmlBeans.getContextTypeLoader().parse(reader, CTTblGrid.type, xmlOptions);
        }

        public static CTTblGrid parse(String str) throws XmlException {
            return (CTTblGrid) XmlBeans.getContextTypeLoader().parse(str, CTTblGrid.type, (XmlOptions) null);
        }

        public static CTTblGrid parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTblGrid) XmlBeans.getContextTypeLoader().parse(str, CTTblGrid.type, xmlOptions);
        }

        public static CTTblGrid parse(URL url) throws XmlException, IOException {
            return (CTTblGrid) XmlBeans.getContextTypeLoader().parse(url, CTTblGrid.type, (XmlOptions) null);
        }

        public static CTTblGrid parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblGrid) XmlBeans.getContextTypeLoader().parse(url, CTTblGrid.type, xmlOptions);
        }

        public static CTTblGrid parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTblGrid) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTblGrid.type, (XmlOptions) null);
        }

        public static CTTblGrid parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTblGrid) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTblGrid.type, xmlOptions);
        }

        public static CTTblGrid parse(Node node) throws XmlException {
            return (CTTblGrid) XmlBeans.getContextTypeLoader().parse(node, CTTblGrid.type, (XmlOptions) null);
        }

        public static CTTblGrid parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTblGrid) XmlBeans.getContextTypeLoader().parse(node, CTTblGrid.type, xmlOptions);
        }
    }

    CTTblGridChange addNewTblGridChange();

    CTTblGridChange getTblGridChange();

    boolean isSetTblGridChange();

    void setTblGridChange(CTTblGridChange cTTblGridChange);

    void unsetTblGridChange();
}
