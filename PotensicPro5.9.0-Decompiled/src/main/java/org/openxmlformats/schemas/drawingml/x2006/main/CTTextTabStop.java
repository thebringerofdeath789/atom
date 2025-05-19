package org.openxmlformats.schemas.drawingml.x2006.main;

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

/* loaded from: classes5.dex */
public interface CTTextTabStop extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTextTabStop.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttexttabstopb57btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextTabStop newInstance() {
            return (CTTextTabStop) XmlBeans.getContextTypeLoader().newInstance(CTTextTabStop.type, null);
        }

        public static CTTextTabStop newInstance(XmlOptions xmlOptions) {
            return (CTTextTabStop) XmlBeans.getContextTypeLoader().newInstance(CTTextTabStop.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextTabStop.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextTabStop.type, xmlOptions);
        }

        public static CTTextTabStop parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextTabStop) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextTabStop.type, (XmlOptions) null);
        }

        public static CTTextTabStop parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextTabStop) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextTabStop.type, xmlOptions);
        }

        public static CTTextTabStop parse(File file) throws XmlException, IOException {
            return (CTTextTabStop) XmlBeans.getContextTypeLoader().parse(file, CTTextTabStop.type, (XmlOptions) null);
        }

        public static CTTextTabStop parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextTabStop) XmlBeans.getContextTypeLoader().parse(file, CTTextTabStop.type, xmlOptions);
        }

        public static CTTextTabStop parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextTabStop) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextTabStop.type, (XmlOptions) null);
        }

        public static CTTextTabStop parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextTabStop) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextTabStop.type, xmlOptions);
        }

        public static CTTextTabStop parse(Reader reader) throws XmlException, IOException {
            return (CTTextTabStop) XmlBeans.getContextTypeLoader().parse(reader, CTTextTabStop.type, (XmlOptions) null);
        }

        public static CTTextTabStop parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextTabStop) XmlBeans.getContextTypeLoader().parse(reader, CTTextTabStop.type, xmlOptions);
        }

        public static CTTextTabStop parse(String str) throws XmlException {
            return (CTTextTabStop) XmlBeans.getContextTypeLoader().parse(str, CTTextTabStop.type, (XmlOptions) null);
        }

        public static CTTextTabStop parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextTabStop) XmlBeans.getContextTypeLoader().parse(str, CTTextTabStop.type, xmlOptions);
        }

        public static CTTextTabStop parse(URL url) throws XmlException, IOException {
            return (CTTextTabStop) XmlBeans.getContextTypeLoader().parse(url, CTTextTabStop.type, (XmlOptions) null);
        }

        public static CTTextTabStop parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextTabStop) XmlBeans.getContextTypeLoader().parse(url, CTTextTabStop.type, xmlOptions);
        }

        public static CTTextTabStop parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTextTabStop) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextTabStop.type, (XmlOptions) null);
        }

        public static CTTextTabStop parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTextTabStop) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextTabStop.type, xmlOptions);
        }

        public static CTTextTabStop parse(Node node) throws XmlException {
            return (CTTextTabStop) XmlBeans.getContextTypeLoader().parse(node, CTTextTabStop.type, (XmlOptions) null);
        }

        public static CTTextTabStop parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextTabStop) XmlBeans.getContextTypeLoader().parse(node, CTTextTabStop.type, xmlOptions);
        }
    }

    STTextTabAlignType$Enum getAlgn();

    int getPos();

    boolean isSetAlgn();

    boolean isSetPos();

    void setAlgn(STTextTabAlignType$Enum sTTextTabAlignType$Enum);

    void setPos(int i);

    void unsetAlgn();

    void unsetPos();

    STTextTabAlignType xgetAlgn();

    STCoordinate32 xgetPos();

    void xsetAlgn(STTextTabAlignType sTTextTabAlignType);

    void xsetPos(STCoordinate32 sTCoordinate32);
}
