package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTSingleXmlCell extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSingleXmlCell.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctsinglexmlcell7790type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSingleXmlCell newInstance() {
            return (CTSingleXmlCell) XmlBeans.getContextTypeLoader().newInstance(CTSingleXmlCell.type, null);
        }

        public static CTSingleXmlCell newInstance(XmlOptions xmlOptions) {
            return (CTSingleXmlCell) XmlBeans.getContextTypeLoader().newInstance(CTSingleXmlCell.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSingleXmlCell.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSingleXmlCell.type, xmlOptions);
        }

        public static CTSingleXmlCell parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSingleXmlCell) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSingleXmlCell.type, (XmlOptions) null);
        }

        public static CTSingleXmlCell parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSingleXmlCell) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSingleXmlCell.type, xmlOptions);
        }

        public static CTSingleXmlCell parse(File file) throws XmlException, IOException {
            return (CTSingleXmlCell) XmlBeans.getContextTypeLoader().parse(file, CTSingleXmlCell.type, (XmlOptions) null);
        }

        public static CTSingleXmlCell parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSingleXmlCell) XmlBeans.getContextTypeLoader().parse(file, CTSingleXmlCell.type, xmlOptions);
        }

        public static CTSingleXmlCell parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSingleXmlCell) XmlBeans.getContextTypeLoader().parse(inputStream, CTSingleXmlCell.type, (XmlOptions) null);
        }

        public static CTSingleXmlCell parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSingleXmlCell) XmlBeans.getContextTypeLoader().parse(inputStream, CTSingleXmlCell.type, xmlOptions);
        }

        public static CTSingleXmlCell parse(Reader reader) throws XmlException, IOException {
            return (CTSingleXmlCell) XmlBeans.getContextTypeLoader().parse(reader, CTSingleXmlCell.type, (XmlOptions) null);
        }

        public static CTSingleXmlCell parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSingleXmlCell) XmlBeans.getContextTypeLoader().parse(reader, CTSingleXmlCell.type, xmlOptions);
        }

        public static CTSingleXmlCell parse(String str) throws XmlException {
            return (CTSingleXmlCell) XmlBeans.getContextTypeLoader().parse(str, CTSingleXmlCell.type, (XmlOptions) null);
        }

        public static CTSingleXmlCell parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSingleXmlCell) XmlBeans.getContextTypeLoader().parse(str, CTSingleXmlCell.type, xmlOptions);
        }

        public static CTSingleXmlCell parse(URL url) throws XmlException, IOException {
            return (CTSingleXmlCell) XmlBeans.getContextTypeLoader().parse(url, CTSingleXmlCell.type, (XmlOptions) null);
        }

        public static CTSingleXmlCell parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSingleXmlCell) XmlBeans.getContextTypeLoader().parse(url, CTSingleXmlCell.type, xmlOptions);
        }

        public static CTSingleXmlCell parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSingleXmlCell) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSingleXmlCell.type, (XmlOptions) null);
        }

        public static CTSingleXmlCell parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSingleXmlCell) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSingleXmlCell.type, xmlOptions);
        }

        public static CTSingleXmlCell parse(Node node) throws XmlException {
            return (CTSingleXmlCell) XmlBeans.getContextTypeLoader().parse(node, CTSingleXmlCell.type, (XmlOptions) null);
        }

        public static CTSingleXmlCell parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSingleXmlCell) XmlBeans.getContextTypeLoader().parse(node, CTSingleXmlCell.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTXmlCellPr addNewXmlCellPr();

    long getConnectionId();

    CTExtensionList getExtLst();

    long getId();

    String getR();

    CTXmlCellPr getXmlCellPr();

    boolean isSetExtLst();

    void setConnectionId(long j);

    void setExtLst(CTExtensionList cTExtensionList);

    void setId(long j);

    void setR(String str);

    void setXmlCellPr(CTXmlCellPr cTXmlCellPr);

    void unsetExtLst();

    XmlUnsignedInt xgetConnectionId();

    XmlUnsignedInt xgetId();

    STCellRef xgetR();

    void xsetConnectionId(XmlUnsignedInt xmlUnsignedInt);

    void xsetId(XmlUnsignedInt xmlUnsignedInt);

    void xsetR(STCellRef sTCellRef);
}
