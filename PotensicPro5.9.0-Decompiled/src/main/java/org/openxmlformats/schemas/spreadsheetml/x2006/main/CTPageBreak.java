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
public interface CTPageBreak extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPageBreak.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpagebreakeb4ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPageBreak newInstance() {
            return (CTPageBreak) XmlBeans.getContextTypeLoader().newInstance(CTPageBreak.type, null);
        }

        public static CTPageBreak newInstance(XmlOptions xmlOptions) {
            return (CTPageBreak) XmlBeans.getContextTypeLoader().newInstance(CTPageBreak.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPageBreak.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPageBreak.type, xmlOptions);
        }

        public static CTPageBreak parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPageBreak) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPageBreak.type, (XmlOptions) null);
        }

        public static CTPageBreak parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPageBreak) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPageBreak.type, xmlOptions);
        }

        public static CTPageBreak parse(File file) throws XmlException, IOException {
            return (CTPageBreak) XmlBeans.getContextTypeLoader().parse(file, CTPageBreak.type, (XmlOptions) null);
        }

        public static CTPageBreak parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageBreak) XmlBeans.getContextTypeLoader().parse(file, CTPageBreak.type, xmlOptions);
        }

        public static CTPageBreak parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPageBreak) XmlBeans.getContextTypeLoader().parse(inputStream, CTPageBreak.type, (XmlOptions) null);
        }

        public static CTPageBreak parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageBreak) XmlBeans.getContextTypeLoader().parse(inputStream, CTPageBreak.type, xmlOptions);
        }

        public static CTPageBreak parse(Reader reader) throws XmlException, IOException {
            return (CTPageBreak) XmlBeans.getContextTypeLoader().parse(reader, CTPageBreak.type, (XmlOptions) null);
        }

        public static CTPageBreak parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageBreak) XmlBeans.getContextTypeLoader().parse(reader, CTPageBreak.type, xmlOptions);
        }

        public static CTPageBreak parse(String str) throws XmlException {
            return (CTPageBreak) XmlBeans.getContextTypeLoader().parse(str, CTPageBreak.type, (XmlOptions) null);
        }

        public static CTPageBreak parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPageBreak) XmlBeans.getContextTypeLoader().parse(str, CTPageBreak.type, xmlOptions);
        }

        public static CTPageBreak parse(URL url) throws XmlException, IOException {
            return (CTPageBreak) XmlBeans.getContextTypeLoader().parse(url, CTPageBreak.type, (XmlOptions) null);
        }

        public static CTPageBreak parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageBreak) XmlBeans.getContextTypeLoader().parse(url, CTPageBreak.type, xmlOptions);
        }

        public static CTPageBreak parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPageBreak) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPageBreak.type, (XmlOptions) null);
        }

        public static CTPageBreak parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPageBreak) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPageBreak.type, xmlOptions);
        }

        public static CTPageBreak parse(Node node) throws XmlException {
            return (CTPageBreak) XmlBeans.getContextTypeLoader().parse(node, CTPageBreak.type, (XmlOptions) null);
        }

        public static CTPageBreak parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPageBreak) XmlBeans.getContextTypeLoader().parse(node, CTPageBreak.type, xmlOptions);
        }
    }

    CTBreak addNewBrk();

    CTBreak getBrkArray(int i);

    CTBreak[] getBrkArray();

    List<CTBreak> getBrkList();

    long getCount();

    long getManualBreakCount();

    CTBreak insertNewBrk(int i);

    boolean isSetCount();

    boolean isSetManualBreakCount();

    void removeBrk(int i);

    void setBrkArray(int i, CTBreak cTBreak);

    void setBrkArray(CTBreak[] cTBreakArr);

    void setCount(long j);

    void setManualBreakCount(long j);

    int sizeOfBrkArray();

    void unsetCount();

    void unsetManualBreakCount();

    XmlUnsignedInt xgetCount();

    XmlUnsignedInt xgetManualBreakCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetManualBreakCount(XmlUnsignedInt xmlUnsignedInt);
}
