package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTTableStyleList extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTableStyleList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttablestylelist4bdctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableStyleList newInstance() {
            return (CTTableStyleList) XmlBeans.getContextTypeLoader().newInstance(CTTableStyleList.type, null);
        }

        public static CTTableStyleList newInstance(XmlOptions xmlOptions) {
            return (CTTableStyleList) XmlBeans.getContextTypeLoader().newInstance(CTTableStyleList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTableStyleList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTableStyleList.type, xmlOptions);
        }

        public static CTTableStyleList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTableStyleList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTableStyleList.type, (XmlOptions) null);
        }

        public static CTTableStyleList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTableStyleList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTableStyleList.type, xmlOptions);
        }

        public static CTTableStyleList parse(File file) throws XmlException, IOException {
            return (CTTableStyleList) XmlBeans.getContextTypeLoader().parse(file, CTTableStyleList.type, (XmlOptions) null);
        }

        public static CTTableStyleList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyleList) XmlBeans.getContextTypeLoader().parse(file, CTTableStyleList.type, xmlOptions);
        }

        public static CTTableStyleList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTableStyleList) XmlBeans.getContextTypeLoader().parse(inputStream, CTTableStyleList.type, (XmlOptions) null);
        }

        public static CTTableStyleList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyleList) XmlBeans.getContextTypeLoader().parse(inputStream, CTTableStyleList.type, xmlOptions);
        }

        public static CTTableStyleList parse(Reader reader) throws XmlException, IOException {
            return (CTTableStyleList) XmlBeans.getContextTypeLoader().parse(reader, CTTableStyleList.type, (XmlOptions) null);
        }

        public static CTTableStyleList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyleList) XmlBeans.getContextTypeLoader().parse(reader, CTTableStyleList.type, xmlOptions);
        }

        public static CTTableStyleList parse(String str) throws XmlException {
            return (CTTableStyleList) XmlBeans.getContextTypeLoader().parse(str, CTTableStyleList.type, (XmlOptions) null);
        }

        public static CTTableStyleList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTableStyleList) XmlBeans.getContextTypeLoader().parse(str, CTTableStyleList.type, xmlOptions);
        }

        public static CTTableStyleList parse(URL url) throws XmlException, IOException {
            return (CTTableStyleList) XmlBeans.getContextTypeLoader().parse(url, CTTableStyleList.type, (XmlOptions) null);
        }

        public static CTTableStyleList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyleList) XmlBeans.getContextTypeLoader().parse(url, CTTableStyleList.type, xmlOptions);
        }

        public static CTTableStyleList parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTableStyleList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTableStyleList.type, (XmlOptions) null);
        }

        public static CTTableStyleList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTableStyleList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTableStyleList.type, xmlOptions);
        }

        public static CTTableStyleList parse(Node node) throws XmlException {
            return (CTTableStyleList) XmlBeans.getContextTypeLoader().parse(node, CTTableStyleList.type, (XmlOptions) null);
        }

        public static CTTableStyleList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTableStyleList) XmlBeans.getContextTypeLoader().parse(node, CTTableStyleList.type, xmlOptions);
        }
    }

    CTTableStyle addNewTblStyle();

    String getDef();

    CTTableStyle getTblStyleArray(int i);

    CTTableStyle[] getTblStyleArray();

    List<CTTableStyle> getTblStyleList();

    CTTableStyle insertNewTblStyle(int i);

    void removeTblStyle(int i);

    void setDef(String str);

    void setTblStyleArray(int i, CTTableStyle cTTableStyle);

    void setTblStyleArray(CTTableStyle[] cTTableStyleArr);

    int sizeOfTblStyleArray();

    STGuid xgetDef();

    void xsetDef(STGuid sTGuid);
}
