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
import org.openxmlformats.schemas.drawingml.x2006.chart.STScatterStyle;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTScatterStyle extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTScatterStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctscatterstyle94c9type");

    public static final class Factory {
        private Factory() {
        }

        public static CTScatterStyle newInstance() {
            return (CTScatterStyle) XmlBeans.getContextTypeLoader().newInstance(CTScatterStyle.type, null);
        }

        public static CTScatterStyle newInstance(XmlOptions xmlOptions) {
            return (CTScatterStyle) XmlBeans.getContextTypeLoader().newInstance(CTScatterStyle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTScatterStyle.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTScatterStyle.type, xmlOptions);
        }

        public static CTScatterStyle parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTScatterStyle) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTScatterStyle.type, (XmlOptions) null);
        }

        public static CTScatterStyle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTScatterStyle) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTScatterStyle.type, xmlOptions);
        }

        public static CTScatterStyle parse(File file) throws XmlException, IOException {
            return (CTScatterStyle) XmlBeans.getContextTypeLoader().parse(file, CTScatterStyle.type, (XmlOptions) null);
        }

        public static CTScatterStyle parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScatterStyle) XmlBeans.getContextTypeLoader().parse(file, CTScatterStyle.type, xmlOptions);
        }

        public static CTScatterStyle parse(InputStream inputStream) throws XmlException, IOException {
            return (CTScatterStyle) XmlBeans.getContextTypeLoader().parse(inputStream, CTScatterStyle.type, (XmlOptions) null);
        }

        public static CTScatterStyle parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScatterStyle) XmlBeans.getContextTypeLoader().parse(inputStream, CTScatterStyle.type, xmlOptions);
        }

        public static CTScatterStyle parse(Reader reader) throws XmlException, IOException {
            return (CTScatterStyle) XmlBeans.getContextTypeLoader().parse(reader, CTScatterStyle.type, (XmlOptions) null);
        }

        public static CTScatterStyle parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScatterStyle) XmlBeans.getContextTypeLoader().parse(reader, CTScatterStyle.type, xmlOptions);
        }

        public static CTScatterStyle parse(String str) throws XmlException {
            return (CTScatterStyle) XmlBeans.getContextTypeLoader().parse(str, CTScatterStyle.type, (XmlOptions) null);
        }

        public static CTScatterStyle parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTScatterStyle) XmlBeans.getContextTypeLoader().parse(str, CTScatterStyle.type, xmlOptions);
        }

        public static CTScatterStyle parse(URL url) throws XmlException, IOException {
            return (CTScatterStyle) XmlBeans.getContextTypeLoader().parse(url, CTScatterStyle.type, (XmlOptions) null);
        }

        public static CTScatterStyle parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTScatterStyle) XmlBeans.getContextTypeLoader().parse(url, CTScatterStyle.type, xmlOptions);
        }

        public static CTScatterStyle parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTScatterStyle) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTScatterStyle.type, (XmlOptions) null);
        }

        public static CTScatterStyle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTScatterStyle) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTScatterStyle.type, xmlOptions);
        }

        public static CTScatterStyle parse(Node node) throws XmlException {
            return (CTScatterStyle) XmlBeans.getContextTypeLoader().parse(node, CTScatterStyle.type, (XmlOptions) null);
        }

        public static CTScatterStyle parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTScatterStyle) XmlBeans.getContextTypeLoader().parse(node, CTScatterStyle.type, xmlOptions);
        }
    }

    STScatterStyle.Enum getVal();

    boolean isSetVal();

    void setVal(STScatterStyle.Enum r1);

    void unsetVal();

    STScatterStyle xgetVal();

    void xsetVal(STScatterStyle sTScatterStyle);
}
