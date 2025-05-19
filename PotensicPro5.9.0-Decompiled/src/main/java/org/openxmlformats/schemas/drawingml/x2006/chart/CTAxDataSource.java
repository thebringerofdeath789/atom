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
public interface CTAxDataSource extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTAxDataSource.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctaxdatasource1440type");

    public static final class Factory {
        private Factory() {
        }

        public static CTAxDataSource newInstance() {
            return (CTAxDataSource) XmlBeans.getContextTypeLoader().newInstance(CTAxDataSource.type, null);
        }

        public static CTAxDataSource newInstance(XmlOptions xmlOptions) {
            return (CTAxDataSource) XmlBeans.getContextTypeLoader().newInstance(CTAxDataSource.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTAxDataSource.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTAxDataSource.type, xmlOptions);
        }

        public static CTAxDataSource parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTAxDataSource) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTAxDataSource.type, (XmlOptions) null);
        }

        public static CTAxDataSource parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTAxDataSource) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTAxDataSource.type, xmlOptions);
        }

        public static CTAxDataSource parse(File file) throws XmlException, IOException {
            return (CTAxDataSource) XmlBeans.getContextTypeLoader().parse(file, CTAxDataSource.type, (XmlOptions) null);
        }

        public static CTAxDataSource parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAxDataSource) XmlBeans.getContextTypeLoader().parse(file, CTAxDataSource.type, xmlOptions);
        }

        public static CTAxDataSource parse(InputStream inputStream) throws XmlException, IOException {
            return (CTAxDataSource) XmlBeans.getContextTypeLoader().parse(inputStream, CTAxDataSource.type, (XmlOptions) null);
        }

        public static CTAxDataSource parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAxDataSource) XmlBeans.getContextTypeLoader().parse(inputStream, CTAxDataSource.type, xmlOptions);
        }

        public static CTAxDataSource parse(Reader reader) throws XmlException, IOException {
            return (CTAxDataSource) XmlBeans.getContextTypeLoader().parse(reader, CTAxDataSource.type, (XmlOptions) null);
        }

        public static CTAxDataSource parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAxDataSource) XmlBeans.getContextTypeLoader().parse(reader, CTAxDataSource.type, xmlOptions);
        }

        public static CTAxDataSource parse(String str) throws XmlException {
            return (CTAxDataSource) XmlBeans.getContextTypeLoader().parse(str, CTAxDataSource.type, (XmlOptions) null);
        }

        public static CTAxDataSource parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTAxDataSource) XmlBeans.getContextTypeLoader().parse(str, CTAxDataSource.type, xmlOptions);
        }

        public static CTAxDataSource parse(URL url) throws XmlException, IOException {
            return (CTAxDataSource) XmlBeans.getContextTypeLoader().parse(url, CTAxDataSource.type, (XmlOptions) null);
        }

        public static CTAxDataSource parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAxDataSource) XmlBeans.getContextTypeLoader().parse(url, CTAxDataSource.type, xmlOptions);
        }

        public static CTAxDataSource parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTAxDataSource) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTAxDataSource.type, (XmlOptions) null);
        }

        public static CTAxDataSource parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTAxDataSource) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTAxDataSource.type, xmlOptions);
        }

        public static CTAxDataSource parse(Node node) throws XmlException {
            return (CTAxDataSource) XmlBeans.getContextTypeLoader().parse(node, CTAxDataSource.type, (XmlOptions) null);
        }

        public static CTAxDataSource parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTAxDataSource) XmlBeans.getContextTypeLoader().parse(node, CTAxDataSource.type, xmlOptions);
        }
    }

    CTMultiLvlStrRef addNewMultiLvlStrRef();

    CTNumData addNewNumLit();

    CTNumRef addNewNumRef();

    CTStrData addNewStrLit();

    CTStrRef addNewStrRef();

    CTMultiLvlStrRef getMultiLvlStrRef();

    CTNumData getNumLit();

    CTNumRef getNumRef();

    CTStrData getStrLit();

    CTStrRef getStrRef();

    boolean isSetMultiLvlStrRef();

    boolean isSetNumLit();

    boolean isSetNumRef();

    boolean isSetStrLit();

    boolean isSetStrRef();

    void setMultiLvlStrRef(CTMultiLvlStrRef cTMultiLvlStrRef);

    void setNumLit(CTNumData cTNumData);

    void setNumRef(CTNumRef cTNumRef);

    void setStrLit(CTStrData cTStrData);

    void setStrRef(CTStrRef cTStrRef);

    void unsetMultiLvlStrRef();

    void unsetNumLit();

    void unsetNumRef();

    void unsetStrLit();

    void unsetStrRef();
}
