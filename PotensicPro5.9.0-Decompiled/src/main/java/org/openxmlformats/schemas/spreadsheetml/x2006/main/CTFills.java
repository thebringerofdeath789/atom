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
public interface CTFills extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTFills.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctfills2c6ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFills newInstance() {
            return (CTFills) XmlBeans.getContextTypeLoader().newInstance(CTFills.type, null);
        }

        public static CTFills newInstance(XmlOptions xmlOptions) {
            return (CTFills) XmlBeans.getContextTypeLoader().newInstance(CTFills.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFills.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFills.type, xmlOptions);
        }

        public static CTFills parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFills) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFills.type, (XmlOptions) null);
        }

        public static CTFills parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFills) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFills.type, xmlOptions);
        }

        public static CTFills parse(File file) throws XmlException, IOException {
            return (CTFills) XmlBeans.getContextTypeLoader().parse(file, CTFills.type, (XmlOptions) null);
        }

        public static CTFills parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFills) XmlBeans.getContextTypeLoader().parse(file, CTFills.type, xmlOptions);
        }

        public static CTFills parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFills) XmlBeans.getContextTypeLoader().parse(inputStream, CTFills.type, (XmlOptions) null);
        }

        public static CTFills parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFills) XmlBeans.getContextTypeLoader().parse(inputStream, CTFills.type, xmlOptions);
        }

        public static CTFills parse(Reader reader) throws XmlException, IOException {
            return (CTFills) XmlBeans.getContextTypeLoader().parse(reader, CTFills.type, (XmlOptions) null);
        }

        public static CTFills parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFills) XmlBeans.getContextTypeLoader().parse(reader, CTFills.type, xmlOptions);
        }

        public static CTFills parse(String str) throws XmlException {
            return (CTFills) XmlBeans.getContextTypeLoader().parse(str, CTFills.type, (XmlOptions) null);
        }

        public static CTFills parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFills) XmlBeans.getContextTypeLoader().parse(str, CTFills.type, xmlOptions);
        }

        public static CTFills parse(URL url) throws XmlException, IOException {
            return (CTFills) XmlBeans.getContextTypeLoader().parse(url, CTFills.type, (XmlOptions) null);
        }

        public static CTFills parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFills) XmlBeans.getContextTypeLoader().parse(url, CTFills.type, xmlOptions);
        }

        public static CTFills parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTFills) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFills.type, (XmlOptions) null);
        }

        public static CTFills parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTFills) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFills.type, xmlOptions);
        }

        public static CTFills parse(Node node) throws XmlException {
            return (CTFills) XmlBeans.getContextTypeLoader().parse(node, CTFills.type, (XmlOptions) null);
        }

        public static CTFills parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFills) XmlBeans.getContextTypeLoader().parse(node, CTFills.type, xmlOptions);
        }
    }

    CTFill addNewFill();

    long getCount();

    CTFill getFillArray(int i);

    CTFill[] getFillArray();

    List<CTFill> getFillList();

    CTFill insertNewFill(int i);

    boolean isSetCount();

    void removeFill(int i);

    void setCount(long j);

    void setFillArray(int i, CTFill cTFill);

    void setFillArray(CTFill[] cTFillArr);

    int sizeOfFillArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
