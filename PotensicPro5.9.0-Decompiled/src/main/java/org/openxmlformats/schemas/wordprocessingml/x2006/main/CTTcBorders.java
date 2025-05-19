package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

/* loaded from: classes6.dex */
public interface CTTcBorders extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTcBorders.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttcbordersa5fatype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTcBorders newInstance() {
            return (CTTcBorders) XmlBeans.getContextTypeLoader().newInstance(CTTcBorders.type, null);
        }

        public static CTTcBorders newInstance(XmlOptions xmlOptions) {
            return (CTTcBorders) XmlBeans.getContextTypeLoader().newInstance(CTTcBorders.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTcBorders.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTcBorders.type, xmlOptions);
        }

        public static CTTcBorders parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTcBorders) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTcBorders.type, (XmlOptions) null);
        }

        public static CTTcBorders parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTcBorders) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTcBorders.type, xmlOptions);
        }

        public static CTTcBorders parse(File file) throws XmlException, IOException {
            return (CTTcBorders) XmlBeans.getContextTypeLoader().parse(file, CTTcBorders.type, (XmlOptions) null);
        }

        public static CTTcBorders parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTcBorders) XmlBeans.getContextTypeLoader().parse(file, CTTcBorders.type, xmlOptions);
        }

        public static CTTcBorders parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTcBorders) XmlBeans.getContextTypeLoader().parse(inputStream, CTTcBorders.type, (XmlOptions) null);
        }

        public static CTTcBorders parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTcBorders) XmlBeans.getContextTypeLoader().parse(inputStream, CTTcBorders.type, xmlOptions);
        }

        public static CTTcBorders parse(Reader reader) throws XmlException, IOException {
            return (CTTcBorders) XmlBeans.getContextTypeLoader().parse(reader, CTTcBorders.type, (XmlOptions) null);
        }

        public static CTTcBorders parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTcBorders) XmlBeans.getContextTypeLoader().parse(reader, CTTcBorders.type, xmlOptions);
        }

        public static CTTcBorders parse(String str) throws XmlException {
            return (CTTcBorders) XmlBeans.getContextTypeLoader().parse(str, CTTcBorders.type, (XmlOptions) null);
        }

        public static CTTcBorders parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTcBorders) XmlBeans.getContextTypeLoader().parse(str, CTTcBorders.type, xmlOptions);
        }

        public static CTTcBorders parse(URL url) throws XmlException, IOException {
            return (CTTcBorders) XmlBeans.getContextTypeLoader().parse(url, CTTcBorders.type, (XmlOptions) null);
        }

        public static CTTcBorders parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTcBorders) XmlBeans.getContextTypeLoader().parse(url, CTTcBorders.type, xmlOptions);
        }

        public static CTTcBorders parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTcBorders) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTcBorders.type, (XmlOptions) null);
        }

        public static CTTcBorders parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTcBorders) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTcBorders.type, xmlOptions);
        }

        public static CTTcBorders parse(Node node) throws XmlException {
            return (CTTcBorders) XmlBeans.getContextTypeLoader().parse(node, CTTcBorders.type, (XmlOptions) null);
        }

        public static CTTcBorders parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTcBorders) XmlBeans.getContextTypeLoader().parse(node, CTTcBorders.type, xmlOptions);
        }
    }

    CTBorder addNewBottom();

    CTBorder addNewInsideH();

    CTBorder addNewInsideV();

    CTBorder addNewLeft();

    CTBorder addNewRight();

    CTBorder addNewTl2Br();

    CTBorder addNewTop();

    CTBorder addNewTr2Bl();

    CTBorder getBottom();

    CTBorder getInsideH();

    CTBorder getInsideV();

    CTBorder getLeft();

    CTBorder getRight();

    CTBorder getTl2Br();

    CTBorder getTop();

    CTBorder getTr2Bl();

    boolean isSetBottom();

    boolean isSetInsideH();

    boolean isSetInsideV();

    boolean isSetLeft();

    boolean isSetRight();

    boolean isSetTl2Br();

    boolean isSetTop();

    boolean isSetTr2Bl();

    void setBottom(CTBorder cTBorder);

    void setInsideH(CTBorder cTBorder);

    void setInsideV(CTBorder cTBorder);

    void setLeft(CTBorder cTBorder);

    void setRight(CTBorder cTBorder);

    void setTl2Br(CTBorder cTBorder);

    void setTop(CTBorder cTBorder);

    void setTr2Bl(CTBorder cTBorder);

    void unsetBottom();

    void unsetInsideH();

    void unsetInsideV();

    void unsetLeft();

    void unsetRight();

    void unsetTl2Br();

    void unsetTop();

    void unsetTr2Bl();
}
