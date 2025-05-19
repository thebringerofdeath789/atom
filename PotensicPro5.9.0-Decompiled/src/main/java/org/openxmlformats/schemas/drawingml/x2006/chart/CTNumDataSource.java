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
public interface CTNumDataSource extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTNumDataSource.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctnumdatasourcef0bbtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTNumDataSource newInstance() {
            return (CTNumDataSource) XmlBeans.getContextTypeLoader().newInstance(CTNumDataSource.type, null);
        }

        public static CTNumDataSource newInstance(XmlOptions xmlOptions) {
            return (CTNumDataSource) XmlBeans.getContextTypeLoader().newInstance(CTNumDataSource.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNumDataSource.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNumDataSource.type, xmlOptions);
        }

        public static CTNumDataSource parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNumDataSource) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNumDataSource.type, (XmlOptions) null);
        }

        public static CTNumDataSource parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNumDataSource) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNumDataSource.type, xmlOptions);
        }

        public static CTNumDataSource parse(File file) throws XmlException, IOException {
            return (CTNumDataSource) XmlBeans.getContextTypeLoader().parse(file, CTNumDataSource.type, (XmlOptions) null);
        }

        public static CTNumDataSource parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumDataSource) XmlBeans.getContextTypeLoader().parse(file, CTNumDataSource.type, xmlOptions);
        }

        public static CTNumDataSource parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNumDataSource) XmlBeans.getContextTypeLoader().parse(inputStream, CTNumDataSource.type, (XmlOptions) null);
        }

        public static CTNumDataSource parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumDataSource) XmlBeans.getContextTypeLoader().parse(inputStream, CTNumDataSource.type, xmlOptions);
        }

        public static CTNumDataSource parse(Reader reader) throws XmlException, IOException {
            return (CTNumDataSource) XmlBeans.getContextTypeLoader().parse(reader, CTNumDataSource.type, (XmlOptions) null);
        }

        public static CTNumDataSource parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumDataSource) XmlBeans.getContextTypeLoader().parse(reader, CTNumDataSource.type, xmlOptions);
        }

        public static CTNumDataSource parse(String str) throws XmlException {
            return (CTNumDataSource) XmlBeans.getContextTypeLoader().parse(str, CTNumDataSource.type, (XmlOptions) null);
        }

        public static CTNumDataSource parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNumDataSource) XmlBeans.getContextTypeLoader().parse(str, CTNumDataSource.type, xmlOptions);
        }

        public static CTNumDataSource parse(URL url) throws XmlException, IOException {
            return (CTNumDataSource) XmlBeans.getContextTypeLoader().parse(url, CTNumDataSource.type, (XmlOptions) null);
        }

        public static CTNumDataSource parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumDataSource) XmlBeans.getContextTypeLoader().parse(url, CTNumDataSource.type, xmlOptions);
        }

        public static CTNumDataSource parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTNumDataSource) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNumDataSource.type, (XmlOptions) null);
        }

        public static CTNumDataSource parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTNumDataSource) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNumDataSource.type, xmlOptions);
        }

        public static CTNumDataSource parse(Node node) throws XmlException {
            return (CTNumDataSource) XmlBeans.getContextTypeLoader().parse(node, CTNumDataSource.type, (XmlOptions) null);
        }

        public static CTNumDataSource parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNumDataSource) XmlBeans.getContextTypeLoader().parse(node, CTNumDataSource.type, xmlOptions);
        }
    }

    CTNumData addNewNumLit();

    CTNumRef addNewNumRef();

    CTNumData getNumLit();

    CTNumRef getNumRef();

    boolean isSetNumLit();

    boolean isSetNumRef();

    void setNumLit(CTNumData cTNumData);

    void setNumRef(CTNumRef cTNumRef);

    void unsetNumLit();

    void unsetNumRef();
}
