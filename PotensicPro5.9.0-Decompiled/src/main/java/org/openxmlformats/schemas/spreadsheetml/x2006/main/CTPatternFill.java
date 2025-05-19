package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPatternType;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTPatternFill extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPatternFill.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpatternfill7452type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPatternFill newInstance() {
            return (CTPatternFill) XmlBeans.getContextTypeLoader().newInstance(CTPatternFill.type, null);
        }

        public static CTPatternFill newInstance(XmlOptions xmlOptions) {
            return (CTPatternFill) XmlBeans.getContextTypeLoader().newInstance(CTPatternFill.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPatternFill.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPatternFill.type, xmlOptions);
        }

        public static CTPatternFill parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPatternFill) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPatternFill.type, (XmlOptions) null);
        }

        public static CTPatternFill parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPatternFill) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPatternFill.type, xmlOptions);
        }

        public static CTPatternFill parse(File file) throws XmlException, IOException {
            return (CTPatternFill) XmlBeans.getContextTypeLoader().parse(file, CTPatternFill.type, (XmlOptions) null);
        }

        public static CTPatternFill parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPatternFill) XmlBeans.getContextTypeLoader().parse(file, CTPatternFill.type, xmlOptions);
        }

        public static CTPatternFill parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPatternFill) XmlBeans.getContextTypeLoader().parse(inputStream, CTPatternFill.type, (XmlOptions) null);
        }

        public static CTPatternFill parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPatternFill) XmlBeans.getContextTypeLoader().parse(inputStream, CTPatternFill.type, xmlOptions);
        }

        public static CTPatternFill parse(Reader reader) throws XmlException, IOException {
            return (CTPatternFill) XmlBeans.getContextTypeLoader().parse(reader, CTPatternFill.type, (XmlOptions) null);
        }

        public static CTPatternFill parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPatternFill) XmlBeans.getContextTypeLoader().parse(reader, CTPatternFill.type, xmlOptions);
        }

        public static CTPatternFill parse(String str) throws XmlException {
            return (CTPatternFill) XmlBeans.getContextTypeLoader().parse(str, CTPatternFill.type, (XmlOptions) null);
        }

        public static CTPatternFill parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPatternFill) XmlBeans.getContextTypeLoader().parse(str, CTPatternFill.type, xmlOptions);
        }

        public static CTPatternFill parse(URL url) throws XmlException, IOException {
            return (CTPatternFill) XmlBeans.getContextTypeLoader().parse(url, CTPatternFill.type, (XmlOptions) null);
        }

        public static CTPatternFill parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPatternFill) XmlBeans.getContextTypeLoader().parse(url, CTPatternFill.type, xmlOptions);
        }

        public static CTPatternFill parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPatternFill) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPatternFill.type, (XmlOptions) null);
        }

        public static CTPatternFill parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPatternFill) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPatternFill.type, xmlOptions);
        }

        public static CTPatternFill parse(Node node) throws XmlException {
            return (CTPatternFill) XmlBeans.getContextTypeLoader().parse(node, CTPatternFill.type, (XmlOptions) null);
        }

        public static CTPatternFill parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPatternFill) XmlBeans.getContextTypeLoader().parse(node, CTPatternFill.type, xmlOptions);
        }
    }

    CTColor addNewBgColor();

    CTColor addNewFgColor();

    CTColor getBgColor();

    CTColor getFgColor();

    STPatternType.Enum getPatternType();

    boolean isSetBgColor();

    boolean isSetFgColor();

    boolean isSetPatternType();

    void setBgColor(CTColor cTColor);

    void setFgColor(CTColor cTColor);

    void setPatternType(STPatternType.Enum r1);

    void unsetBgColor();

    void unsetFgColor();

    void unsetPatternType();

    STPatternType xgetPatternType();

    void xsetPatternType(STPatternType sTPatternType);
}
