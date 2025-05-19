package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTTblWidth extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTblWidth.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttblwidthec40type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblWidth newInstance() {
            return (CTTblWidth) XmlBeans.getContextTypeLoader().newInstance(CTTblWidth.type, null);
        }

        public static CTTblWidth newInstance(XmlOptions xmlOptions) {
            return (CTTblWidth) XmlBeans.getContextTypeLoader().newInstance(CTTblWidth.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTblWidth.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTblWidth) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTblWidth) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(File file) throws XmlException, IOException {
            return (CTTblWidth) XmlBeans.getContextTypeLoader().parse(file, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblWidth) XmlBeans.getContextTypeLoader().parse(file, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTblWidth) XmlBeans.getContextTypeLoader().parse(inputStream, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblWidth) XmlBeans.getContextTypeLoader().parse(inputStream, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(Reader reader) throws XmlException, IOException {
            return (CTTblWidth) XmlBeans.getContextTypeLoader().parse(reader, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblWidth) XmlBeans.getContextTypeLoader().parse(reader, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(String str) throws XmlException {
            return (CTTblWidth) XmlBeans.getContextTypeLoader().parse(str, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTblWidth) XmlBeans.getContextTypeLoader().parse(str, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(URL url) throws XmlException, IOException {
            return (CTTblWidth) XmlBeans.getContextTypeLoader().parse(url, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblWidth) XmlBeans.getContextTypeLoader().parse(url, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTblWidth) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTblWidth) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(Node node) throws XmlException {
            return (CTTblWidth) XmlBeans.getContextTypeLoader().parse(node, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTblWidth) XmlBeans.getContextTypeLoader().parse(node, CTTblWidth.type, xmlOptions);
        }
    }

    STTblWidth.Enum getType();

    BigInteger getW();

    boolean isSetType();

    boolean isSetW();

    void setType(STTblWidth.Enum r1);

    void setW(BigInteger bigInteger);

    void unsetType();

    void unsetW();

    STTblWidth xgetType();

    STDecimalNumber xgetW();

    void xsetType(STTblWidth sTTblWidth);

    void xsetW(STDecimalNumber sTDecimalNumber);
}
