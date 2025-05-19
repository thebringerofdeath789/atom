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
public interface CTPBdr extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPBdr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpbdre388type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPBdr newInstance() {
            return (CTPBdr) XmlBeans.getContextTypeLoader().newInstance(CTPBdr.type, null);
        }

        public static CTPBdr newInstance(XmlOptions xmlOptions) {
            return (CTPBdr) XmlBeans.getContextTypeLoader().newInstance(CTPBdr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPBdr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPBdr.type, xmlOptions);
        }

        public static CTPBdr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPBdr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPBdr.type, (XmlOptions) null);
        }

        public static CTPBdr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPBdr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPBdr.type, xmlOptions);
        }

        public static CTPBdr parse(File file) throws XmlException, IOException {
            return (CTPBdr) XmlBeans.getContextTypeLoader().parse(file, CTPBdr.type, (XmlOptions) null);
        }

        public static CTPBdr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPBdr) XmlBeans.getContextTypeLoader().parse(file, CTPBdr.type, xmlOptions);
        }

        public static CTPBdr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPBdr) XmlBeans.getContextTypeLoader().parse(inputStream, CTPBdr.type, (XmlOptions) null);
        }

        public static CTPBdr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPBdr) XmlBeans.getContextTypeLoader().parse(inputStream, CTPBdr.type, xmlOptions);
        }

        public static CTPBdr parse(Reader reader) throws XmlException, IOException {
            return (CTPBdr) XmlBeans.getContextTypeLoader().parse(reader, CTPBdr.type, (XmlOptions) null);
        }

        public static CTPBdr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPBdr) XmlBeans.getContextTypeLoader().parse(reader, CTPBdr.type, xmlOptions);
        }

        public static CTPBdr parse(String str) throws XmlException {
            return (CTPBdr) XmlBeans.getContextTypeLoader().parse(str, CTPBdr.type, (XmlOptions) null);
        }

        public static CTPBdr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPBdr) XmlBeans.getContextTypeLoader().parse(str, CTPBdr.type, xmlOptions);
        }

        public static CTPBdr parse(URL url) throws XmlException, IOException {
            return (CTPBdr) XmlBeans.getContextTypeLoader().parse(url, CTPBdr.type, (XmlOptions) null);
        }

        public static CTPBdr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPBdr) XmlBeans.getContextTypeLoader().parse(url, CTPBdr.type, xmlOptions);
        }

        public static CTPBdr parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPBdr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPBdr.type, (XmlOptions) null);
        }

        public static CTPBdr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPBdr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPBdr.type, xmlOptions);
        }

        public static CTPBdr parse(Node node) throws XmlException {
            return (CTPBdr) XmlBeans.getContextTypeLoader().parse(node, CTPBdr.type, (XmlOptions) null);
        }

        public static CTPBdr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPBdr) XmlBeans.getContextTypeLoader().parse(node, CTPBdr.type, xmlOptions);
        }
    }

    CTBorder addNewBar();

    CTBorder addNewBetween();

    CTBorder addNewBottom();

    CTBorder addNewLeft();

    CTBorder addNewRight();

    CTBorder addNewTop();

    CTBorder getBar();

    CTBorder getBetween();

    CTBorder getBottom();

    CTBorder getLeft();

    CTBorder getRight();

    CTBorder getTop();

    boolean isSetBar();

    boolean isSetBetween();

    boolean isSetBottom();

    boolean isSetLeft();

    boolean isSetRight();

    boolean isSetTop();

    void setBar(CTBorder cTBorder);

    void setBetween(CTBorder cTBorder);

    void setBottom(CTBorder cTBorder);

    void setLeft(CTBorder cTBorder);

    void setRight(CTBorder cTBorder);

    void setTop(CTBorder cTBorder);

    void unsetBar();

    void unsetBetween();

    void unsetBottom();

    void unsetLeft();

    void unsetRight();

    void unsetTop();
}
