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
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndLength;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndType;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndWidth;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTLineEndProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTLineEndProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctlineendproperties8acbtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTLineEndProperties newInstance() {
            return (CTLineEndProperties) XmlBeans.getContextTypeLoader().newInstance(CTLineEndProperties.type, null);
        }

        public static CTLineEndProperties newInstance(XmlOptions xmlOptions) {
            return (CTLineEndProperties) XmlBeans.getContextTypeLoader().newInstance(CTLineEndProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLineEndProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLineEndProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLineEndProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(File file) throws XmlException, IOException {
            return (CTLineEndProperties) XmlBeans.getContextTypeLoader().parse(file, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineEndProperties) XmlBeans.getContextTypeLoader().parse(file, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLineEndProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineEndProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(Reader reader) throws XmlException, IOException {
            return (CTLineEndProperties) XmlBeans.getContextTypeLoader().parse(reader, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineEndProperties) XmlBeans.getContextTypeLoader().parse(reader, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(String str) throws XmlException {
            return (CTLineEndProperties) XmlBeans.getContextTypeLoader().parse(str, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLineEndProperties) XmlBeans.getContextTypeLoader().parse(str, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(URL url) throws XmlException, IOException {
            return (CTLineEndProperties) XmlBeans.getContextTypeLoader().parse(url, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineEndProperties) XmlBeans.getContextTypeLoader().parse(url, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTLineEndProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTLineEndProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(Node node) throws XmlException {
            return (CTLineEndProperties) XmlBeans.getContextTypeLoader().parse(node, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLineEndProperties) XmlBeans.getContextTypeLoader().parse(node, CTLineEndProperties.type, xmlOptions);
        }
    }

    STLineEndLength.Enum getLen();

    STLineEndType.Enum getType();

    STLineEndWidth.Enum getW();

    boolean isSetLen();

    boolean isSetType();

    boolean isSetW();

    void setLen(STLineEndLength.Enum r1);

    void setType(STLineEndType.Enum r1);

    void setW(STLineEndWidth.Enum r1);

    void unsetLen();

    void unsetType();

    void unsetW();

    STLineEndLength xgetLen();

    STLineEndType xgetType();

    STLineEndWidth xgetW();

    void xsetLen(STLineEndLength sTLineEndLength);

    void xsetType(STLineEndType sTLineEndType);

    void xsetW(STLineEndWidth sTLineEndWidth);
}
