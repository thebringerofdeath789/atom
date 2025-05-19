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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPane;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTSelection extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSelection.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctselectionca2btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSelection newInstance() {
            return (CTSelection) XmlBeans.getContextTypeLoader().newInstance(CTSelection.type, null);
        }

        public static CTSelection newInstance(XmlOptions xmlOptions) {
            return (CTSelection) XmlBeans.getContextTypeLoader().newInstance(CTSelection.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSelection.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSelection.type, xmlOptions);
        }

        public static CTSelection parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSelection) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSelection.type, (XmlOptions) null);
        }

        public static CTSelection parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSelection) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSelection.type, xmlOptions);
        }

        public static CTSelection parse(File file) throws XmlException, IOException {
            return (CTSelection) XmlBeans.getContextTypeLoader().parse(file, CTSelection.type, (XmlOptions) null);
        }

        public static CTSelection parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSelection) XmlBeans.getContextTypeLoader().parse(file, CTSelection.type, xmlOptions);
        }

        public static CTSelection parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSelection) XmlBeans.getContextTypeLoader().parse(inputStream, CTSelection.type, (XmlOptions) null);
        }

        public static CTSelection parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSelection) XmlBeans.getContextTypeLoader().parse(inputStream, CTSelection.type, xmlOptions);
        }

        public static CTSelection parse(Reader reader) throws XmlException, IOException {
            return (CTSelection) XmlBeans.getContextTypeLoader().parse(reader, CTSelection.type, (XmlOptions) null);
        }

        public static CTSelection parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSelection) XmlBeans.getContextTypeLoader().parse(reader, CTSelection.type, xmlOptions);
        }

        public static CTSelection parse(String str) throws XmlException {
            return (CTSelection) XmlBeans.getContextTypeLoader().parse(str, CTSelection.type, (XmlOptions) null);
        }

        public static CTSelection parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSelection) XmlBeans.getContextTypeLoader().parse(str, CTSelection.type, xmlOptions);
        }

        public static CTSelection parse(URL url) throws XmlException, IOException {
            return (CTSelection) XmlBeans.getContextTypeLoader().parse(url, CTSelection.type, (XmlOptions) null);
        }

        public static CTSelection parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSelection) XmlBeans.getContextTypeLoader().parse(url, CTSelection.type, xmlOptions);
        }

        public static CTSelection parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSelection) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSelection.type, (XmlOptions) null);
        }

        public static CTSelection parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSelection) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSelection.type, xmlOptions);
        }

        public static CTSelection parse(Node node) throws XmlException {
            return (CTSelection) XmlBeans.getContextTypeLoader().parse(node, CTSelection.type, (XmlOptions) null);
        }

        public static CTSelection parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSelection) XmlBeans.getContextTypeLoader().parse(node, CTSelection.type, xmlOptions);
        }
    }

    String getActiveCell();

    long getActiveCellId();

    STPane.Enum getPane();

    List getSqref();

    boolean isSetActiveCell();

    boolean isSetActiveCellId();

    boolean isSetPane();

    boolean isSetSqref();

    void setActiveCell(String str);

    void setActiveCellId(long j);

    void setPane(STPane.Enum r1);

    void setSqref(List list);

    void unsetActiveCell();

    void unsetActiveCellId();

    void unsetPane();

    void unsetSqref();

    STCellRef xgetActiveCell();

    XmlUnsignedInt xgetActiveCellId();

    STPane xgetPane();

    STSqref xgetSqref();

    void xsetActiveCell(STCellRef sTCellRef);

    void xsetActiveCellId(XmlUnsignedInt xmlUnsignedInt);

    void xsetPane(STPane sTPane);

    void xsetSqref(STSqref sTSqref);
}
