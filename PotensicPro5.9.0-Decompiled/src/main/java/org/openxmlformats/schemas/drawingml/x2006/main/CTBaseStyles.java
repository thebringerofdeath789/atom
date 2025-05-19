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
public interface CTBaseStyles extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTBaseStyles.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctbasestyles122etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTBaseStyles newInstance() {
            return (CTBaseStyles) XmlBeans.getContextTypeLoader().newInstance(CTBaseStyles.type, null);
        }

        public static CTBaseStyles newInstance(XmlOptions xmlOptions) {
            return (CTBaseStyles) XmlBeans.getContextTypeLoader().newInstance(CTBaseStyles.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTBaseStyles.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTBaseStyles.type, xmlOptions);
        }

        public static CTBaseStyles parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTBaseStyles) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTBaseStyles.type, (XmlOptions) null);
        }

        public static CTBaseStyles parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTBaseStyles) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTBaseStyles.type, xmlOptions);
        }

        public static CTBaseStyles parse(File file) throws XmlException, IOException {
            return (CTBaseStyles) XmlBeans.getContextTypeLoader().parse(file, CTBaseStyles.type, (XmlOptions) null);
        }

        public static CTBaseStyles parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBaseStyles) XmlBeans.getContextTypeLoader().parse(file, CTBaseStyles.type, xmlOptions);
        }

        public static CTBaseStyles parse(InputStream inputStream) throws XmlException, IOException {
            return (CTBaseStyles) XmlBeans.getContextTypeLoader().parse(inputStream, CTBaseStyles.type, (XmlOptions) null);
        }

        public static CTBaseStyles parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBaseStyles) XmlBeans.getContextTypeLoader().parse(inputStream, CTBaseStyles.type, xmlOptions);
        }

        public static CTBaseStyles parse(Reader reader) throws XmlException, IOException {
            return (CTBaseStyles) XmlBeans.getContextTypeLoader().parse(reader, CTBaseStyles.type, (XmlOptions) null);
        }

        public static CTBaseStyles parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBaseStyles) XmlBeans.getContextTypeLoader().parse(reader, CTBaseStyles.type, xmlOptions);
        }

        public static CTBaseStyles parse(String str) throws XmlException {
            return (CTBaseStyles) XmlBeans.getContextTypeLoader().parse(str, CTBaseStyles.type, (XmlOptions) null);
        }

        public static CTBaseStyles parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTBaseStyles) XmlBeans.getContextTypeLoader().parse(str, CTBaseStyles.type, xmlOptions);
        }

        public static CTBaseStyles parse(URL url) throws XmlException, IOException {
            return (CTBaseStyles) XmlBeans.getContextTypeLoader().parse(url, CTBaseStyles.type, (XmlOptions) null);
        }

        public static CTBaseStyles parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBaseStyles) XmlBeans.getContextTypeLoader().parse(url, CTBaseStyles.type, xmlOptions);
        }

        public static CTBaseStyles parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTBaseStyles) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTBaseStyles.type, (XmlOptions) null);
        }

        public static CTBaseStyles parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTBaseStyles) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTBaseStyles.type, xmlOptions);
        }

        public static CTBaseStyles parse(Node node) throws XmlException {
            return (CTBaseStyles) XmlBeans.getContextTypeLoader().parse(node, CTBaseStyles.type, (XmlOptions) null);
        }

        public static CTBaseStyles parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTBaseStyles) XmlBeans.getContextTypeLoader().parse(node, CTBaseStyles.type, xmlOptions);
        }
    }

    CTColorScheme addNewClrScheme();

    CTOfficeArtExtensionList addNewExtLst();

    CTStyleMatrix addNewFmtScheme();

    CTFontScheme addNewFontScheme();

    CTColorScheme getClrScheme();

    CTOfficeArtExtensionList getExtLst();

    CTStyleMatrix getFmtScheme();

    CTFontScheme getFontScheme();

    boolean isSetExtLst();

    void setClrScheme(CTColorScheme cTColorScheme);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setFmtScheme(CTStyleMatrix cTStyleMatrix);

    void setFontScheme(CTFontScheme cTFontScheme);

    void unsetExtLst();
}
