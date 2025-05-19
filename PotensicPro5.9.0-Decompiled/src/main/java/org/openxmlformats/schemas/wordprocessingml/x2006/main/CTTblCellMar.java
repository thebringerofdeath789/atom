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
public interface CTTblCellMar extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTblCellMar.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttblcellmar66eatype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblCellMar newInstance() {
            return (CTTblCellMar) XmlBeans.getContextTypeLoader().newInstance(CTTblCellMar.type, null);
        }

        public static CTTblCellMar newInstance(XmlOptions xmlOptions) {
            return (CTTblCellMar) XmlBeans.getContextTypeLoader().newInstance(CTTblCellMar.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTblCellMar.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTblCellMar.type, xmlOptions);
        }

        public static CTTblCellMar parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTblCellMar) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTblCellMar.type, (XmlOptions) null);
        }

        public static CTTblCellMar parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTblCellMar) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTblCellMar.type, xmlOptions);
        }

        public static CTTblCellMar parse(File file) throws XmlException, IOException {
            return (CTTblCellMar) XmlBeans.getContextTypeLoader().parse(file, CTTblCellMar.type, (XmlOptions) null);
        }

        public static CTTblCellMar parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblCellMar) XmlBeans.getContextTypeLoader().parse(file, CTTblCellMar.type, xmlOptions);
        }

        public static CTTblCellMar parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTblCellMar) XmlBeans.getContextTypeLoader().parse(inputStream, CTTblCellMar.type, (XmlOptions) null);
        }

        public static CTTblCellMar parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblCellMar) XmlBeans.getContextTypeLoader().parse(inputStream, CTTblCellMar.type, xmlOptions);
        }

        public static CTTblCellMar parse(Reader reader) throws XmlException, IOException {
            return (CTTblCellMar) XmlBeans.getContextTypeLoader().parse(reader, CTTblCellMar.type, (XmlOptions) null);
        }

        public static CTTblCellMar parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblCellMar) XmlBeans.getContextTypeLoader().parse(reader, CTTblCellMar.type, xmlOptions);
        }

        public static CTTblCellMar parse(String str) throws XmlException {
            return (CTTblCellMar) XmlBeans.getContextTypeLoader().parse(str, CTTblCellMar.type, (XmlOptions) null);
        }

        public static CTTblCellMar parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTblCellMar) XmlBeans.getContextTypeLoader().parse(str, CTTblCellMar.type, xmlOptions);
        }

        public static CTTblCellMar parse(URL url) throws XmlException, IOException {
            return (CTTblCellMar) XmlBeans.getContextTypeLoader().parse(url, CTTblCellMar.type, (XmlOptions) null);
        }

        public static CTTblCellMar parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblCellMar) XmlBeans.getContextTypeLoader().parse(url, CTTblCellMar.type, xmlOptions);
        }

        public static CTTblCellMar parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTblCellMar) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTblCellMar.type, (XmlOptions) null);
        }

        public static CTTblCellMar parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTblCellMar) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTblCellMar.type, xmlOptions);
        }

        public static CTTblCellMar parse(Node node) throws XmlException {
            return (CTTblCellMar) XmlBeans.getContextTypeLoader().parse(node, CTTblCellMar.type, (XmlOptions) null);
        }

        public static CTTblCellMar parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTblCellMar) XmlBeans.getContextTypeLoader().parse(node, CTTblCellMar.type, xmlOptions);
        }
    }

    CTTblWidth addNewBottom();

    CTTblWidth addNewLeft();

    CTTblWidth addNewRight();

    CTTblWidth addNewTop();

    CTTblWidth getBottom();

    CTTblWidth getLeft();

    CTTblWidth getRight();

    CTTblWidth getTop();

    boolean isSetBottom();

    boolean isSetLeft();

    boolean isSetRight();

    boolean isSetTop();

    void setBottom(CTTblWidth cTTblWidth);

    void setLeft(CTTblWidth cTTblWidth);

    void setRight(CTTblWidth cTTblWidth);

    void setTop(CTTblWidth cTTblWidth);

    void unsetBottom();

    void unsetLeft();

    void unsetRight();

    void unsetTop();
}
