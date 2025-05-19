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
public interface CTTcPrInner extends CTTcPrBase {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTcPrInner.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttcprinnerc56dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTcPrInner newInstance() {
            return (CTTcPrInner) XmlBeans.getContextTypeLoader().newInstance(CTTcPrInner.type, null);
        }

        public static CTTcPrInner newInstance(XmlOptions xmlOptions) {
            return (CTTcPrInner) XmlBeans.getContextTypeLoader().newInstance(CTTcPrInner.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTcPrInner.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTcPrInner.type, xmlOptions);
        }

        public static CTTcPrInner parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTcPrInner) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTcPrInner.type, (XmlOptions) null);
        }

        public static CTTcPrInner parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTcPrInner) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTcPrInner.type, xmlOptions);
        }

        public static CTTcPrInner parse(File file) throws XmlException, IOException {
            return (CTTcPrInner) XmlBeans.getContextTypeLoader().parse(file, CTTcPrInner.type, (XmlOptions) null);
        }

        public static CTTcPrInner parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTcPrInner) XmlBeans.getContextTypeLoader().parse(file, CTTcPrInner.type, xmlOptions);
        }

        public static CTTcPrInner parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTcPrInner) XmlBeans.getContextTypeLoader().parse(inputStream, CTTcPrInner.type, (XmlOptions) null);
        }

        public static CTTcPrInner parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTcPrInner) XmlBeans.getContextTypeLoader().parse(inputStream, CTTcPrInner.type, xmlOptions);
        }

        public static CTTcPrInner parse(Reader reader) throws XmlException, IOException {
            return (CTTcPrInner) XmlBeans.getContextTypeLoader().parse(reader, CTTcPrInner.type, (XmlOptions) null);
        }

        public static CTTcPrInner parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTcPrInner) XmlBeans.getContextTypeLoader().parse(reader, CTTcPrInner.type, xmlOptions);
        }

        public static CTTcPrInner parse(String str) throws XmlException {
            return (CTTcPrInner) XmlBeans.getContextTypeLoader().parse(str, CTTcPrInner.type, (XmlOptions) null);
        }

        public static CTTcPrInner parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTcPrInner) XmlBeans.getContextTypeLoader().parse(str, CTTcPrInner.type, xmlOptions);
        }

        public static CTTcPrInner parse(URL url) throws XmlException, IOException {
            return (CTTcPrInner) XmlBeans.getContextTypeLoader().parse(url, CTTcPrInner.type, (XmlOptions) null);
        }

        public static CTTcPrInner parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTcPrInner) XmlBeans.getContextTypeLoader().parse(url, CTTcPrInner.type, xmlOptions);
        }

        public static CTTcPrInner parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTcPrInner) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTcPrInner.type, (XmlOptions) null);
        }

        public static CTTcPrInner parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTcPrInner) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTcPrInner.type, xmlOptions);
        }

        public static CTTcPrInner parse(Node node) throws XmlException {
            return (CTTcPrInner) XmlBeans.getContextTypeLoader().parse(node, CTTcPrInner.type, (XmlOptions) null);
        }

        public static CTTcPrInner parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTcPrInner) XmlBeans.getContextTypeLoader().parse(node, CTTcPrInner.type, xmlOptions);
        }
    }

    CTTrackChange addNewCellDel();

    CTTrackChange addNewCellIns();

    CTCellMergeTrackChange addNewCellMerge();

    CTTrackChange getCellDel();

    CTTrackChange getCellIns();

    CTCellMergeTrackChange getCellMerge();

    boolean isSetCellDel();

    boolean isSetCellIns();

    boolean isSetCellMerge();

    void setCellDel(CTTrackChange cTTrackChange);

    void setCellIns(CTTrackChange cTTrackChange);

    void setCellMerge(CTCellMergeTrackChange cTCellMergeTrackChange);

    void unsetCellDel();

    void unsetCellIns();

    void unsetCellMerge();
}
