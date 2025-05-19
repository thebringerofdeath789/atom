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
public interface CTBookViews extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTBookViews.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctbookviewsb864type");

    public static final class Factory {
        private Factory() {
        }

        public static CTBookViews newInstance() {
            return (CTBookViews) XmlBeans.getContextTypeLoader().newInstance(CTBookViews.type, null);
        }

        public static CTBookViews newInstance(XmlOptions xmlOptions) {
            return (CTBookViews) XmlBeans.getContextTypeLoader().newInstance(CTBookViews.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTBookViews.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTBookViews.type, xmlOptions);
        }

        public static CTBookViews parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTBookViews) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTBookViews.type, (XmlOptions) null);
        }

        public static CTBookViews parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTBookViews) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTBookViews.type, xmlOptions);
        }

        public static CTBookViews parse(File file) throws XmlException, IOException {
            return (CTBookViews) XmlBeans.getContextTypeLoader().parse(file, CTBookViews.type, (XmlOptions) null);
        }

        public static CTBookViews parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBookViews) XmlBeans.getContextTypeLoader().parse(file, CTBookViews.type, xmlOptions);
        }

        public static CTBookViews parse(InputStream inputStream) throws XmlException, IOException {
            return (CTBookViews) XmlBeans.getContextTypeLoader().parse(inputStream, CTBookViews.type, (XmlOptions) null);
        }

        public static CTBookViews parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBookViews) XmlBeans.getContextTypeLoader().parse(inputStream, CTBookViews.type, xmlOptions);
        }

        public static CTBookViews parse(Reader reader) throws XmlException, IOException {
            return (CTBookViews) XmlBeans.getContextTypeLoader().parse(reader, CTBookViews.type, (XmlOptions) null);
        }

        public static CTBookViews parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBookViews) XmlBeans.getContextTypeLoader().parse(reader, CTBookViews.type, xmlOptions);
        }

        public static CTBookViews parse(String str) throws XmlException {
            return (CTBookViews) XmlBeans.getContextTypeLoader().parse(str, CTBookViews.type, (XmlOptions) null);
        }

        public static CTBookViews parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTBookViews) XmlBeans.getContextTypeLoader().parse(str, CTBookViews.type, xmlOptions);
        }

        public static CTBookViews parse(URL url) throws XmlException, IOException {
            return (CTBookViews) XmlBeans.getContextTypeLoader().parse(url, CTBookViews.type, (XmlOptions) null);
        }

        public static CTBookViews parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBookViews) XmlBeans.getContextTypeLoader().parse(url, CTBookViews.type, xmlOptions);
        }

        public static CTBookViews parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTBookViews) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTBookViews.type, (XmlOptions) null);
        }

        public static CTBookViews parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTBookViews) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTBookViews.type, xmlOptions);
        }

        public static CTBookViews parse(Node node) throws XmlException {
            return (CTBookViews) XmlBeans.getContextTypeLoader().parse(node, CTBookViews.type, (XmlOptions) null);
        }

        public static CTBookViews parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTBookViews) XmlBeans.getContextTypeLoader().parse(node, CTBookViews.type, xmlOptions);
        }
    }

    CTBookView addNewWorkbookView();

    CTBookView getWorkbookViewArray(int i);

    CTBookView[] getWorkbookViewArray();

    List<CTBookView> getWorkbookViewList();

    CTBookView insertNewWorkbookView(int i);

    void removeWorkbookView(int i);

    void setWorkbookViewArray(int i, CTBookView cTBookView);

    void setWorkbookViewArray(CTBookView[] cTBookViewArr);

    int sizeOfWorkbookViewArray();
}
