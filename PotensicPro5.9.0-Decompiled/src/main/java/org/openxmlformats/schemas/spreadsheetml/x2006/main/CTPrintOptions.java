package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTPrintOptions extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPrintOptions.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctprintoptions943atype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPrintOptions newInstance() {
            return (CTPrintOptions) XmlBeans.getContextTypeLoader().newInstance(CTPrintOptions.type, null);
        }

        public static CTPrintOptions newInstance(XmlOptions xmlOptions) {
            return (CTPrintOptions) XmlBeans.getContextTypeLoader().newInstance(CTPrintOptions.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPrintOptions.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPrintOptions.type, xmlOptions);
        }

        public static CTPrintOptions parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPrintOptions) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPrintOptions.type, (XmlOptions) null);
        }

        public static CTPrintOptions parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPrintOptions) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPrintOptions.type, xmlOptions);
        }

        public static CTPrintOptions parse(File file) throws XmlException, IOException {
            return (CTPrintOptions) XmlBeans.getContextTypeLoader().parse(file, CTPrintOptions.type, (XmlOptions) null);
        }

        public static CTPrintOptions parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPrintOptions) XmlBeans.getContextTypeLoader().parse(file, CTPrintOptions.type, xmlOptions);
        }

        public static CTPrintOptions parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPrintOptions) XmlBeans.getContextTypeLoader().parse(inputStream, CTPrintOptions.type, (XmlOptions) null);
        }

        public static CTPrintOptions parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPrintOptions) XmlBeans.getContextTypeLoader().parse(inputStream, CTPrintOptions.type, xmlOptions);
        }

        public static CTPrintOptions parse(Reader reader) throws XmlException, IOException {
            return (CTPrintOptions) XmlBeans.getContextTypeLoader().parse(reader, CTPrintOptions.type, (XmlOptions) null);
        }

        public static CTPrintOptions parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPrintOptions) XmlBeans.getContextTypeLoader().parse(reader, CTPrintOptions.type, xmlOptions);
        }

        public static CTPrintOptions parse(String str) throws XmlException {
            return (CTPrintOptions) XmlBeans.getContextTypeLoader().parse(str, CTPrintOptions.type, (XmlOptions) null);
        }

        public static CTPrintOptions parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPrintOptions) XmlBeans.getContextTypeLoader().parse(str, CTPrintOptions.type, xmlOptions);
        }

        public static CTPrintOptions parse(URL url) throws XmlException, IOException {
            return (CTPrintOptions) XmlBeans.getContextTypeLoader().parse(url, CTPrintOptions.type, (XmlOptions) null);
        }

        public static CTPrintOptions parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPrintOptions) XmlBeans.getContextTypeLoader().parse(url, CTPrintOptions.type, xmlOptions);
        }

        public static CTPrintOptions parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPrintOptions) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPrintOptions.type, (XmlOptions) null);
        }

        public static CTPrintOptions parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPrintOptions) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPrintOptions.type, xmlOptions);
        }

        public static CTPrintOptions parse(Node node) throws XmlException {
            return (CTPrintOptions) XmlBeans.getContextTypeLoader().parse(node, CTPrintOptions.type, (XmlOptions) null);
        }

        public static CTPrintOptions parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPrintOptions) XmlBeans.getContextTypeLoader().parse(node, CTPrintOptions.type, xmlOptions);
        }
    }

    boolean getGridLines();

    boolean getGridLinesSet();

    boolean getHeadings();

    boolean getHorizontalCentered();

    boolean getVerticalCentered();

    boolean isSetGridLines();

    boolean isSetGridLinesSet();

    boolean isSetHeadings();

    boolean isSetHorizontalCentered();

    boolean isSetVerticalCentered();

    void setGridLines(boolean z);

    void setGridLinesSet(boolean z);

    void setHeadings(boolean z);

    void setHorizontalCentered(boolean z);

    void setVerticalCentered(boolean z);

    void unsetGridLines();

    void unsetGridLinesSet();

    void unsetHeadings();

    void unsetHorizontalCentered();

    void unsetVerticalCentered();

    XmlBoolean xgetGridLines();

    XmlBoolean xgetGridLinesSet();

    XmlBoolean xgetHeadings();

    XmlBoolean xgetHorizontalCentered();

    XmlBoolean xgetVerticalCentered();

    void xsetGridLines(XmlBoolean xmlBoolean);

    void xsetGridLinesSet(XmlBoolean xmlBoolean);

    void xsetHeadings(XmlBoolean xmlBoolean);

    void xsetHorizontalCentered(XmlBoolean xmlBoolean);

    void xsetVerticalCentered(XmlBoolean xmlBoolean);
}
