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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTSheetViews extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSheetViews.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctsheetviewsb918type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSheetViews newInstance() {
            return (CTSheetViews) XmlBeans.getContextTypeLoader().newInstance(CTSheetViews.type, null);
        }

        public static CTSheetViews newInstance(XmlOptions xmlOptions) {
            return (CTSheetViews) XmlBeans.getContextTypeLoader().newInstance(CTSheetViews.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSheetViews.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSheetViews.type, xmlOptions);
        }

        public static CTSheetViews parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSheetViews) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSheetViews.type, (XmlOptions) null);
        }

        public static CTSheetViews parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetViews) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSheetViews.type, xmlOptions);
        }

        public static CTSheetViews parse(File file) throws XmlException, IOException {
            return (CTSheetViews) XmlBeans.getContextTypeLoader().parse(file, CTSheetViews.type, (XmlOptions) null);
        }

        public static CTSheetViews parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetViews) XmlBeans.getContextTypeLoader().parse(file, CTSheetViews.type, xmlOptions);
        }

        public static CTSheetViews parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSheetViews) XmlBeans.getContextTypeLoader().parse(inputStream, CTSheetViews.type, (XmlOptions) null);
        }

        public static CTSheetViews parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetViews) XmlBeans.getContextTypeLoader().parse(inputStream, CTSheetViews.type, xmlOptions);
        }

        public static CTSheetViews parse(Reader reader) throws XmlException, IOException {
            return (CTSheetViews) XmlBeans.getContextTypeLoader().parse(reader, CTSheetViews.type, (XmlOptions) null);
        }

        public static CTSheetViews parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetViews) XmlBeans.getContextTypeLoader().parse(reader, CTSheetViews.type, xmlOptions);
        }

        public static CTSheetViews parse(String str) throws XmlException {
            return (CTSheetViews) XmlBeans.getContextTypeLoader().parse(str, CTSheetViews.type, (XmlOptions) null);
        }

        public static CTSheetViews parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetViews) XmlBeans.getContextTypeLoader().parse(str, CTSheetViews.type, xmlOptions);
        }

        public static CTSheetViews parse(URL url) throws XmlException, IOException {
            return (CTSheetViews) XmlBeans.getContextTypeLoader().parse(url, CTSheetViews.type, (XmlOptions) null);
        }

        public static CTSheetViews parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetViews) XmlBeans.getContextTypeLoader().parse(url, CTSheetViews.type, xmlOptions);
        }

        public static CTSheetViews parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSheetViews) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSheetViews.type, (XmlOptions) null);
        }

        public static CTSheetViews parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSheetViews) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSheetViews.type, xmlOptions);
        }

        public static CTSheetViews parse(Node node) throws XmlException {
            return (CTSheetViews) XmlBeans.getContextTypeLoader().parse(node, CTSheetViews.type, (XmlOptions) null);
        }

        public static CTSheetViews parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetViews) XmlBeans.getContextTypeLoader().parse(node, CTSheetViews.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTSheetView addNewSheetView();

    CTExtensionList getExtLst();

    CTSheetView getSheetViewArray(int i);

    CTSheetView[] getSheetViewArray();

    List<CTSheetView> getSheetViewList();

    CTSheetView insertNewSheetView(int i);

    boolean isSetExtLst();

    void removeSheetView(int i);

    void setExtLst(CTExtensionList cTExtensionList);

    void setSheetViewArray(int i, CTSheetView cTSheetView);

    void setSheetViewArray(CTSheetView[] cTSheetViewArr);

    int sizeOfSheetViewArray();

    void unsetExtLst();
}
