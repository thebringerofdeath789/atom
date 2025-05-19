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
public interface CTTableGrid extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTableGrid.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttablegrid69a5type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableGrid newInstance() {
            return (CTTableGrid) XmlBeans.getContextTypeLoader().newInstance(CTTableGrid.type, null);
        }

        public static CTTableGrid newInstance(XmlOptions xmlOptions) {
            return (CTTableGrid) XmlBeans.getContextTypeLoader().newInstance(CTTableGrid.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTableGrid.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTableGrid) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTableGrid) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(File file) throws XmlException, IOException {
            return (CTTableGrid) XmlBeans.getContextTypeLoader().parse(file, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableGrid) XmlBeans.getContextTypeLoader().parse(file, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTableGrid) XmlBeans.getContextTypeLoader().parse(inputStream, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableGrid) XmlBeans.getContextTypeLoader().parse(inputStream, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(Reader reader) throws XmlException, IOException {
            return (CTTableGrid) XmlBeans.getContextTypeLoader().parse(reader, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableGrid) XmlBeans.getContextTypeLoader().parse(reader, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(String str) throws XmlException {
            return (CTTableGrid) XmlBeans.getContextTypeLoader().parse(str, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTableGrid) XmlBeans.getContextTypeLoader().parse(str, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(URL url) throws XmlException, IOException {
            return (CTTableGrid) XmlBeans.getContextTypeLoader().parse(url, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableGrid) XmlBeans.getContextTypeLoader().parse(url, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTableGrid) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTableGrid) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(Node node) throws XmlException {
            return (CTTableGrid) XmlBeans.getContextTypeLoader().parse(node, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTableGrid) XmlBeans.getContextTypeLoader().parse(node, CTTableGrid.type, xmlOptions);
        }
    }

    CTTableCol addNewGridCol();

    CTTableCol getGridColArray(int i);

    CTTableCol[] getGridColArray();

    List<CTTableCol> getGridColList();

    CTTableCol insertNewGridCol(int i);

    void removeGridCol(int i);

    void setGridColArray(int i, CTTableCol cTTableCol);

    void setGridColArray(CTTableCol[] cTTableColArr);

    int sizeOfGridColArray();
}
