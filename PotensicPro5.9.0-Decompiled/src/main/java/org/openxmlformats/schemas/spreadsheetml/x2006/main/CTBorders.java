package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTBorders extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTBorders.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctborders0d66type");

    public static final class Factory {
        private Factory() {
        }

        public static CTBorders newInstance() {
            return (CTBorders) XmlBeans.getContextTypeLoader().newInstance(CTBorders.type, null);
        }

        public static CTBorders newInstance(XmlOptions xmlOptions) {
            return (CTBorders) XmlBeans.getContextTypeLoader().newInstance(CTBorders.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTBorders.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTBorders.type, xmlOptions);
        }

        public static CTBorders parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTBorders) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTBorders.type, (XmlOptions) null);
        }

        public static CTBorders parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTBorders) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTBorders.type, xmlOptions);
        }

        public static CTBorders parse(File file) throws XmlException, IOException {
            return (CTBorders) XmlBeans.getContextTypeLoader().parse(file, CTBorders.type, (XmlOptions) null);
        }

        public static CTBorders parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBorders) XmlBeans.getContextTypeLoader().parse(file, CTBorders.type, xmlOptions);
        }

        public static CTBorders parse(InputStream inputStream) throws XmlException, IOException {
            return (CTBorders) XmlBeans.getContextTypeLoader().parse(inputStream, CTBorders.type, (XmlOptions) null);
        }

        public static CTBorders parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBorders) XmlBeans.getContextTypeLoader().parse(inputStream, CTBorders.type, xmlOptions);
        }

        public static CTBorders parse(Reader reader) throws XmlException, IOException {
            return (CTBorders) XmlBeans.getContextTypeLoader().parse(reader, CTBorders.type, (XmlOptions) null);
        }

        public static CTBorders parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBorders) XmlBeans.getContextTypeLoader().parse(reader, CTBorders.type, xmlOptions);
        }

        public static CTBorders parse(String str) throws XmlException {
            return (CTBorders) XmlBeans.getContextTypeLoader().parse(str, CTBorders.type, (XmlOptions) null);
        }

        public static CTBorders parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTBorders) XmlBeans.getContextTypeLoader().parse(str, CTBorders.type, xmlOptions);
        }

        public static CTBorders parse(URL url) throws XmlException, IOException {
            return (CTBorders) XmlBeans.getContextTypeLoader().parse(url, CTBorders.type, (XmlOptions) null);
        }

        public static CTBorders parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBorders) XmlBeans.getContextTypeLoader().parse(url, CTBorders.type, xmlOptions);
        }

        public static CTBorders parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTBorders) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTBorders.type, (XmlOptions) null);
        }

        public static CTBorders parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTBorders) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTBorders.type, xmlOptions);
        }

        public static CTBorders parse(Node node) throws XmlException {
            return (CTBorders) XmlBeans.getContextTypeLoader().parse(node, CTBorders.type, (XmlOptions) null);
        }

        public static CTBorders parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTBorders) XmlBeans.getContextTypeLoader().parse(node, CTBorders.type, xmlOptions);
        }
    }

    CTBorder addNewBorder();

    CTBorder getBorderArray(int i);

    CTBorder[] getBorderArray();

    List<CTBorder> getBorderList();

    long getCount();

    CTBorder insertNewBorder(int i);

    boolean isSetCount();

    void removeBorder(int i);

    void setBorderArray(int i, CTBorder cTBorder);

    void setBorderArray(CTBorder[] cTBorderArr);

    void setCount(long j);

    int sizeOfBorderArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
