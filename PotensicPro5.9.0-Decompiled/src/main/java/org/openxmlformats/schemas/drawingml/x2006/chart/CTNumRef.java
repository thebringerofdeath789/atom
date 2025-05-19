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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTNumRef extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTNumRef.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctnumref062ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTNumRef newInstance() {
            return (CTNumRef) XmlBeans.getContextTypeLoader().newInstance(CTNumRef.type, null);
        }

        public static CTNumRef newInstance(XmlOptions xmlOptions) {
            return (CTNumRef) XmlBeans.getContextTypeLoader().newInstance(CTNumRef.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNumRef.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNumRef.type, xmlOptions);
        }

        public static CTNumRef parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNumRef) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNumRef.type, (XmlOptions) null);
        }

        public static CTNumRef parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNumRef) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNumRef.type, xmlOptions);
        }

        public static CTNumRef parse(File file) throws XmlException, IOException {
            return (CTNumRef) XmlBeans.getContextTypeLoader().parse(file, CTNumRef.type, (XmlOptions) null);
        }

        public static CTNumRef parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumRef) XmlBeans.getContextTypeLoader().parse(file, CTNumRef.type, xmlOptions);
        }

        public static CTNumRef parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNumRef) XmlBeans.getContextTypeLoader().parse(inputStream, CTNumRef.type, (XmlOptions) null);
        }

        public static CTNumRef parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumRef) XmlBeans.getContextTypeLoader().parse(inputStream, CTNumRef.type, xmlOptions);
        }

        public static CTNumRef parse(Reader reader) throws XmlException, IOException {
            return (CTNumRef) XmlBeans.getContextTypeLoader().parse(reader, CTNumRef.type, (XmlOptions) null);
        }

        public static CTNumRef parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumRef) XmlBeans.getContextTypeLoader().parse(reader, CTNumRef.type, xmlOptions);
        }

        public static CTNumRef parse(String str) throws XmlException {
            return (CTNumRef) XmlBeans.getContextTypeLoader().parse(str, CTNumRef.type, (XmlOptions) null);
        }

        public static CTNumRef parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNumRef) XmlBeans.getContextTypeLoader().parse(str, CTNumRef.type, xmlOptions);
        }

        public static CTNumRef parse(URL url) throws XmlException, IOException {
            return (CTNumRef) XmlBeans.getContextTypeLoader().parse(url, CTNumRef.type, (XmlOptions) null);
        }

        public static CTNumRef parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumRef) XmlBeans.getContextTypeLoader().parse(url, CTNumRef.type, xmlOptions);
        }

        public static CTNumRef parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTNumRef) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNumRef.type, (XmlOptions) null);
        }

        public static CTNumRef parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTNumRef) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNumRef.type, xmlOptions);
        }

        public static CTNumRef parse(Node node) throws XmlException {
            return (CTNumRef) XmlBeans.getContextTypeLoader().parse(node, CTNumRef.type, (XmlOptions) null);
        }

        public static CTNumRef parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNumRef) XmlBeans.getContextTypeLoader().parse(node, CTNumRef.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTNumData addNewNumCache();

    CTExtensionList getExtLst();

    String getF();

    CTNumData getNumCache();

    boolean isSetExtLst();

    boolean isSetNumCache();

    void setExtLst(CTExtensionList cTExtensionList);

    void setF(String str);

    void setNumCache(CTNumData cTNumData);

    void unsetExtLst();

    void unsetNumCache();

    XmlString xgetF();

    void xsetF(XmlString xmlString);
}
