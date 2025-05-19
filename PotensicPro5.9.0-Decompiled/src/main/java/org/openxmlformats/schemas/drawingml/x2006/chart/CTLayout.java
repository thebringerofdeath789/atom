package org.openxmlformats.schemas.drawingml.x2006.chart;

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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTLayout extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTLayout.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctlayout3192type");

    public static final class Factory {
        private Factory() {
        }

        public static CTLayout newInstance() {
            return (CTLayout) XmlBeans.getContextTypeLoader().newInstance(CTLayout.type, null);
        }

        public static CTLayout newInstance(XmlOptions xmlOptions) {
            return (CTLayout) XmlBeans.getContextTypeLoader().newInstance(CTLayout.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLayout.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLayout.type, xmlOptions);
        }

        public static CTLayout parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLayout) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLayout.type, (XmlOptions) null);
        }

        public static CTLayout parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLayout) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLayout.type, xmlOptions);
        }

        public static CTLayout parse(File file) throws XmlException, IOException {
            return (CTLayout) XmlBeans.getContextTypeLoader().parse(file, CTLayout.type, (XmlOptions) null);
        }

        public static CTLayout parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayout) XmlBeans.getContextTypeLoader().parse(file, CTLayout.type, xmlOptions);
        }

        public static CTLayout parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLayout) XmlBeans.getContextTypeLoader().parse(inputStream, CTLayout.type, (XmlOptions) null);
        }

        public static CTLayout parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayout) XmlBeans.getContextTypeLoader().parse(inputStream, CTLayout.type, xmlOptions);
        }

        public static CTLayout parse(Reader reader) throws XmlException, IOException {
            return (CTLayout) XmlBeans.getContextTypeLoader().parse(reader, CTLayout.type, (XmlOptions) null);
        }

        public static CTLayout parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayout) XmlBeans.getContextTypeLoader().parse(reader, CTLayout.type, xmlOptions);
        }

        public static CTLayout parse(String str) throws XmlException {
            return (CTLayout) XmlBeans.getContextTypeLoader().parse(str, CTLayout.type, (XmlOptions) null);
        }

        public static CTLayout parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLayout) XmlBeans.getContextTypeLoader().parse(str, CTLayout.type, xmlOptions);
        }

        public static CTLayout parse(URL url) throws XmlException, IOException {
            return (CTLayout) XmlBeans.getContextTypeLoader().parse(url, CTLayout.type, (XmlOptions) null);
        }

        public static CTLayout parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayout) XmlBeans.getContextTypeLoader().parse(url, CTLayout.type, xmlOptions);
        }

        public static CTLayout parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTLayout) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLayout.type, (XmlOptions) null);
        }

        public static CTLayout parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTLayout) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLayout.type, xmlOptions);
        }

        public static CTLayout parse(Node node) throws XmlException {
            return (CTLayout) XmlBeans.getContextTypeLoader().parse(node, CTLayout.type, (XmlOptions) null);
        }

        public static CTLayout parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLayout) XmlBeans.getContextTypeLoader().parse(node, CTLayout.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTManualLayout addNewManualLayout();

    CTExtensionList getExtLst();

    CTManualLayout getManualLayout();

    boolean isSetExtLst();

    boolean isSetManualLayout();

    void setExtLst(CTExtensionList cTExtensionList);

    void setManualLayout(CTManualLayout cTManualLayout);

    void unsetExtLst();

    void unsetManualLayout();
}
