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
public interface CTTableCol extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTableCol.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttablecol19edtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableCol newInstance() {
            return (CTTableCol) XmlBeans.getContextTypeLoader().newInstance(CTTableCol.type, null);
        }

        public static CTTableCol newInstance(XmlOptions xmlOptions) {
            return (CTTableCol) XmlBeans.getContextTypeLoader().newInstance(CTTableCol.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTableCol.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTableCol.type, xmlOptions);
        }

        public static CTTableCol parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTableCol) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTableCol.type, (XmlOptions) null);
        }

        public static CTTableCol parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTableCol) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTableCol.type, xmlOptions);
        }

        public static CTTableCol parse(File file) throws XmlException, IOException {
            return (CTTableCol) XmlBeans.getContextTypeLoader().parse(file, CTTableCol.type, (XmlOptions) null);
        }

        public static CTTableCol parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableCol) XmlBeans.getContextTypeLoader().parse(file, CTTableCol.type, xmlOptions);
        }

        public static CTTableCol parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTableCol) XmlBeans.getContextTypeLoader().parse(inputStream, CTTableCol.type, (XmlOptions) null);
        }

        public static CTTableCol parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableCol) XmlBeans.getContextTypeLoader().parse(inputStream, CTTableCol.type, xmlOptions);
        }

        public static CTTableCol parse(Reader reader) throws XmlException, IOException {
            return (CTTableCol) XmlBeans.getContextTypeLoader().parse(reader, CTTableCol.type, (XmlOptions) null);
        }

        public static CTTableCol parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableCol) XmlBeans.getContextTypeLoader().parse(reader, CTTableCol.type, xmlOptions);
        }

        public static CTTableCol parse(String str) throws XmlException {
            return (CTTableCol) XmlBeans.getContextTypeLoader().parse(str, CTTableCol.type, (XmlOptions) null);
        }

        public static CTTableCol parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTableCol) XmlBeans.getContextTypeLoader().parse(str, CTTableCol.type, xmlOptions);
        }

        public static CTTableCol parse(URL url) throws XmlException, IOException {
            return (CTTableCol) XmlBeans.getContextTypeLoader().parse(url, CTTableCol.type, (XmlOptions) null);
        }

        public static CTTableCol parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableCol) XmlBeans.getContextTypeLoader().parse(url, CTTableCol.type, xmlOptions);
        }

        public static CTTableCol parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTableCol) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTableCol.type, (XmlOptions) null);
        }

        public static CTTableCol parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTableCol) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTableCol.type, xmlOptions);
        }

        public static CTTableCol parse(Node node) throws XmlException {
            return (CTTableCol) XmlBeans.getContextTypeLoader().parse(node, CTTableCol.type, (XmlOptions) null);
        }

        public static CTTableCol parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTableCol) XmlBeans.getContextTypeLoader().parse(node, CTTableCol.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTOfficeArtExtensionList getExtLst();

    long getW();

    boolean isSetExtLst();

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setW(long j);

    void unsetExtLst();

    STCoordinate xgetW();

    void xsetW(STCoordinate sTCoordinate);
}
