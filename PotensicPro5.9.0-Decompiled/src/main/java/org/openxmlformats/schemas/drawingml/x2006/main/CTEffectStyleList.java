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
public interface CTEffectStyleList extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTEffectStyleList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cteffectstylelistc50ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTEffectStyleList newInstance() {
            return (CTEffectStyleList) XmlBeans.getContextTypeLoader().newInstance(CTEffectStyleList.type, null);
        }

        public static CTEffectStyleList newInstance(XmlOptions xmlOptions) {
            return (CTEffectStyleList) XmlBeans.getContextTypeLoader().newInstance(CTEffectStyleList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTEffectStyleList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTEffectStyleList.type, xmlOptions);
        }

        public static CTEffectStyleList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTEffectStyleList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTEffectStyleList.type, (XmlOptions) null);
        }

        public static CTEffectStyleList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTEffectStyleList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTEffectStyleList.type, xmlOptions);
        }

        public static CTEffectStyleList parse(File file) throws XmlException, IOException {
            return (CTEffectStyleList) XmlBeans.getContextTypeLoader().parse(file, CTEffectStyleList.type, (XmlOptions) null);
        }

        public static CTEffectStyleList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEffectStyleList) XmlBeans.getContextTypeLoader().parse(file, CTEffectStyleList.type, xmlOptions);
        }

        public static CTEffectStyleList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTEffectStyleList) XmlBeans.getContextTypeLoader().parse(inputStream, CTEffectStyleList.type, (XmlOptions) null);
        }

        public static CTEffectStyleList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEffectStyleList) XmlBeans.getContextTypeLoader().parse(inputStream, CTEffectStyleList.type, xmlOptions);
        }

        public static CTEffectStyleList parse(Reader reader) throws XmlException, IOException {
            return (CTEffectStyleList) XmlBeans.getContextTypeLoader().parse(reader, CTEffectStyleList.type, (XmlOptions) null);
        }

        public static CTEffectStyleList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEffectStyleList) XmlBeans.getContextTypeLoader().parse(reader, CTEffectStyleList.type, xmlOptions);
        }

        public static CTEffectStyleList parse(String str) throws XmlException {
            return (CTEffectStyleList) XmlBeans.getContextTypeLoader().parse(str, CTEffectStyleList.type, (XmlOptions) null);
        }

        public static CTEffectStyleList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTEffectStyleList) XmlBeans.getContextTypeLoader().parse(str, CTEffectStyleList.type, xmlOptions);
        }

        public static CTEffectStyleList parse(URL url) throws XmlException, IOException {
            return (CTEffectStyleList) XmlBeans.getContextTypeLoader().parse(url, CTEffectStyleList.type, (XmlOptions) null);
        }

        public static CTEffectStyleList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEffectStyleList) XmlBeans.getContextTypeLoader().parse(url, CTEffectStyleList.type, xmlOptions);
        }

        public static CTEffectStyleList parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTEffectStyleList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTEffectStyleList.type, (XmlOptions) null);
        }

        public static CTEffectStyleList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTEffectStyleList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTEffectStyleList.type, xmlOptions);
        }

        public static CTEffectStyleList parse(Node node) throws XmlException {
            return (CTEffectStyleList) XmlBeans.getContextTypeLoader().parse(node, CTEffectStyleList.type, (XmlOptions) null);
        }

        public static CTEffectStyleList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTEffectStyleList) XmlBeans.getContextTypeLoader().parse(node, CTEffectStyleList.type, xmlOptions);
        }
    }

    CTEffectStyleItem addNewEffectStyle();

    CTEffectStyleItem getEffectStyleArray(int i);

    CTEffectStyleItem[] getEffectStyleArray();

    List<CTEffectStyleItem> getEffectStyleList();

    CTEffectStyleItem insertNewEffectStyle(int i);

    void removeEffectStyle(int i);

    void setEffectStyleArray(int i, CTEffectStyleItem cTEffectStyleItem);

    void setEffectStyleArray(CTEffectStyleItem[] cTEffectStyleItemArr);

    int sizeOfEffectStyleArray();
}
