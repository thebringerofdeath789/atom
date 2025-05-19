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
public interface CTLineStyleList extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTLineStyleList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctlinestylelist510ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTLineStyleList newInstance() {
            return (CTLineStyleList) XmlBeans.getContextTypeLoader().newInstance(CTLineStyleList.type, null);
        }

        public static CTLineStyleList newInstance(XmlOptions xmlOptions) {
            return (CTLineStyleList) XmlBeans.getContextTypeLoader().newInstance(CTLineStyleList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLineStyleList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLineStyleList.type, xmlOptions);
        }

        public static CTLineStyleList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLineStyleList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLineStyleList.type, (XmlOptions) null);
        }

        public static CTLineStyleList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLineStyleList) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLineStyleList.type, xmlOptions);
        }

        public static CTLineStyleList parse(File file) throws XmlException, IOException {
            return (CTLineStyleList) XmlBeans.getContextTypeLoader().parse(file, CTLineStyleList.type, (XmlOptions) null);
        }

        public static CTLineStyleList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineStyleList) XmlBeans.getContextTypeLoader().parse(file, CTLineStyleList.type, xmlOptions);
        }

        public static CTLineStyleList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLineStyleList) XmlBeans.getContextTypeLoader().parse(inputStream, CTLineStyleList.type, (XmlOptions) null);
        }

        public static CTLineStyleList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineStyleList) XmlBeans.getContextTypeLoader().parse(inputStream, CTLineStyleList.type, xmlOptions);
        }

        public static CTLineStyleList parse(Reader reader) throws XmlException, IOException {
            return (CTLineStyleList) XmlBeans.getContextTypeLoader().parse(reader, CTLineStyleList.type, (XmlOptions) null);
        }

        public static CTLineStyleList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineStyleList) XmlBeans.getContextTypeLoader().parse(reader, CTLineStyleList.type, xmlOptions);
        }

        public static CTLineStyleList parse(String str) throws XmlException {
            return (CTLineStyleList) XmlBeans.getContextTypeLoader().parse(str, CTLineStyleList.type, (XmlOptions) null);
        }

        public static CTLineStyleList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLineStyleList) XmlBeans.getContextTypeLoader().parse(str, CTLineStyleList.type, xmlOptions);
        }

        public static CTLineStyleList parse(URL url) throws XmlException, IOException {
            return (CTLineStyleList) XmlBeans.getContextTypeLoader().parse(url, CTLineStyleList.type, (XmlOptions) null);
        }

        public static CTLineStyleList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineStyleList) XmlBeans.getContextTypeLoader().parse(url, CTLineStyleList.type, xmlOptions);
        }

        public static CTLineStyleList parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTLineStyleList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLineStyleList.type, (XmlOptions) null);
        }

        public static CTLineStyleList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTLineStyleList) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLineStyleList.type, xmlOptions);
        }

        public static CTLineStyleList parse(Node node) throws XmlException {
            return (CTLineStyleList) XmlBeans.getContextTypeLoader().parse(node, CTLineStyleList.type, (XmlOptions) null);
        }

        public static CTLineStyleList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLineStyleList) XmlBeans.getContextTypeLoader().parse(node, CTLineStyleList.type, xmlOptions);
        }
    }

    CTLineProperties addNewLn();

    CTLineProperties getLnArray(int i);

    CTLineProperties[] getLnArray();

    List<CTLineProperties> getLnList();

    CTLineProperties insertNewLn(int i);

    void removeLn(int i);

    void setLnArray(int i, CTLineProperties cTLineProperties);

    void setLnArray(CTLineProperties[] cTLinePropertiesArr);

    int sizeOfLnArray();
}
