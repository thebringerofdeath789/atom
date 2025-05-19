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
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTDxf extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTDxf.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctdxfa3b1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTDxf newInstance() {
            return (CTDxf) XmlBeans.getContextTypeLoader().newInstance(CTDxf.type, null);
        }

        public static CTDxf newInstance(XmlOptions xmlOptions) {
            return (CTDxf) XmlBeans.getContextTypeLoader().newInstance(CTDxf.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDxf.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTDxf.type, xmlOptions);
        }

        public static CTDxf parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDxf) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDxf.type, (XmlOptions) null);
        }

        public static CTDxf parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDxf) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTDxf.type, xmlOptions);
        }

        public static CTDxf parse(File file) throws XmlException, IOException {
            return (CTDxf) XmlBeans.getContextTypeLoader().parse(file, CTDxf.type, (XmlOptions) null);
        }

        public static CTDxf parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDxf) XmlBeans.getContextTypeLoader().parse(file, CTDxf.type, xmlOptions);
        }

        public static CTDxf parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDxf) XmlBeans.getContextTypeLoader().parse(inputStream, CTDxf.type, (XmlOptions) null);
        }

        public static CTDxf parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDxf) XmlBeans.getContextTypeLoader().parse(inputStream, CTDxf.type, xmlOptions);
        }

        public static CTDxf parse(Reader reader) throws XmlException, IOException {
            return (CTDxf) XmlBeans.getContextTypeLoader().parse(reader, CTDxf.type, (XmlOptions) null);
        }

        public static CTDxf parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDxf) XmlBeans.getContextTypeLoader().parse(reader, CTDxf.type, xmlOptions);
        }

        public static CTDxf parse(String str) throws XmlException {
            return (CTDxf) XmlBeans.getContextTypeLoader().parse(str, CTDxf.type, (XmlOptions) null);
        }

        public static CTDxf parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDxf) XmlBeans.getContextTypeLoader().parse(str, CTDxf.type, xmlOptions);
        }

        public static CTDxf parse(URL url) throws XmlException, IOException {
            return (CTDxf) XmlBeans.getContextTypeLoader().parse(url, CTDxf.type, (XmlOptions) null);
        }

        public static CTDxf parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDxf) XmlBeans.getContextTypeLoader().parse(url, CTDxf.type, xmlOptions);
        }

        public static CTDxf parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTDxf) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDxf.type, (XmlOptions) null);
        }

        public static CTDxf parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTDxf) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTDxf.type, xmlOptions);
        }

        public static CTDxf parse(Node node) throws XmlException {
            return (CTDxf) XmlBeans.getContextTypeLoader().parse(node, CTDxf.type, (XmlOptions) null);
        }

        public static CTDxf parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDxf) XmlBeans.getContextTypeLoader().parse(node, CTDxf.type, xmlOptions);
        }
    }

    CTCellAlignment addNewAlignment();

    CTBorder addNewBorder();

    CTExtensionList addNewExtLst();

    CTFill addNewFill();

    CTFont addNewFont();

    CTNumFmt addNewNumFmt();

    CTCellProtection addNewProtection();

    CTCellAlignment getAlignment();

    CTBorder getBorder();

    CTExtensionList getExtLst();

    CTFill getFill();

    CTFont getFont();

    CTNumFmt getNumFmt();

    CTCellProtection getProtection();

    boolean isSetAlignment();

    boolean isSetBorder();

    boolean isSetExtLst();

    boolean isSetFill();

    boolean isSetFont();

    boolean isSetNumFmt();

    boolean isSetProtection();

    void setAlignment(CTCellAlignment cTCellAlignment);

    void setBorder(CTBorder cTBorder);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFill(CTFill cTFill);

    void setFont(CTFont cTFont);

    void setNumFmt(CTNumFmt cTNumFmt);

    void setProtection(CTCellProtection cTCellProtection);

    void unsetAlignment();

    void unsetBorder();

    void unsetExtLst();

    void unsetFill();

    void unsetFont();

    void unsetNumFmt();

    void unsetProtection();
}
