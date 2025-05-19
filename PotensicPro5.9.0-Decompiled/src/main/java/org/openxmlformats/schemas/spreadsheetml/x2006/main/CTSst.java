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
public interface CTSst extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSst.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctsst44f3type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSst newInstance() {
            return (CTSst) XmlBeans.getContextTypeLoader().newInstance(CTSst.type, null);
        }

        public static CTSst newInstance(XmlOptions xmlOptions) {
            return (CTSst) XmlBeans.getContextTypeLoader().newInstance(CTSst.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSst.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSst.type, xmlOptions);
        }

        public static CTSst parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSst) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSst.type, (XmlOptions) null);
        }

        public static CTSst parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSst) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSst.type, xmlOptions);
        }

        public static CTSst parse(File file) throws XmlException, IOException {
            return (CTSst) XmlBeans.getContextTypeLoader().parse(file, CTSst.type, (XmlOptions) null);
        }

        public static CTSst parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSst) XmlBeans.getContextTypeLoader().parse(file, CTSst.type, xmlOptions);
        }

        public static CTSst parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSst) XmlBeans.getContextTypeLoader().parse(inputStream, CTSst.type, (XmlOptions) null);
        }

        public static CTSst parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSst) XmlBeans.getContextTypeLoader().parse(inputStream, CTSst.type, xmlOptions);
        }

        public static CTSst parse(Reader reader) throws XmlException, IOException {
            return (CTSst) XmlBeans.getContextTypeLoader().parse(reader, CTSst.type, (XmlOptions) null);
        }

        public static CTSst parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSst) XmlBeans.getContextTypeLoader().parse(reader, CTSst.type, xmlOptions);
        }

        public static CTSst parse(String str) throws XmlException {
            return (CTSst) XmlBeans.getContextTypeLoader().parse(str, CTSst.type, (XmlOptions) null);
        }

        public static CTSst parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSst) XmlBeans.getContextTypeLoader().parse(str, CTSst.type, xmlOptions);
        }

        public static CTSst parse(URL url) throws XmlException, IOException {
            return (CTSst) XmlBeans.getContextTypeLoader().parse(url, CTSst.type, (XmlOptions) null);
        }

        public static CTSst parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSst) XmlBeans.getContextTypeLoader().parse(url, CTSst.type, xmlOptions);
        }

        public static CTSst parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSst) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSst.type, (XmlOptions) null);
        }

        public static CTSst parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSst) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSst.type, xmlOptions);
        }

        public static CTSst parse(Node node) throws XmlException {
            return (CTSst) XmlBeans.getContextTypeLoader().parse(node, CTSst.type, (XmlOptions) null);
        }

        public static CTSst parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSst) XmlBeans.getContextTypeLoader().parse(node, CTSst.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTRst addNewSi();

    long getCount();

    CTExtensionList getExtLst();

    CTRst getSiArray(int i);

    CTRst[] getSiArray();

    List<CTRst> getSiList();

    long getUniqueCount();

    CTRst insertNewSi(int i);

    boolean isSetCount();

    boolean isSetExtLst();

    boolean isSetUniqueCount();

    void removeSi(int i);

    void setCount(long j);

    void setExtLst(CTExtensionList cTExtensionList);

    void setSiArray(int i, CTRst cTRst);

    void setSiArray(CTRst[] cTRstArr);

    void setUniqueCount(long j);

    int sizeOfSiArray();

    void unsetCount();

    void unsetExtLst();

    void unsetUniqueCount();

    XmlUnsignedInt xgetCount();

    XmlUnsignedInt xgetUniqueCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetUniqueCount(XmlUnsignedInt xmlUnsignedInt);
}
