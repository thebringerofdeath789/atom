package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTStyles extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTStyles.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctstyles8506type");

    public static final class Factory {
        private Factory() {
        }

        public static CTStyles newInstance() {
            return (CTStyles) XmlBeans.getContextTypeLoader().newInstance(CTStyles.type, null);
        }

        public static CTStyles newInstance(XmlOptions xmlOptions) {
            return (CTStyles) XmlBeans.getContextTypeLoader().newInstance(CTStyles.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTStyles.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTStyles.type, xmlOptions);
        }

        public static CTStyles parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTStyles) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTStyles.type, (XmlOptions) null);
        }

        public static CTStyles parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTStyles) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTStyles.type, xmlOptions);
        }

        public static CTStyles parse(File file) throws XmlException, IOException {
            return (CTStyles) XmlBeans.getContextTypeLoader().parse(file, CTStyles.type, (XmlOptions) null);
        }

        public static CTStyles parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyles) XmlBeans.getContextTypeLoader().parse(file, CTStyles.type, xmlOptions);
        }

        public static CTStyles parse(InputStream inputStream) throws XmlException, IOException {
            return (CTStyles) XmlBeans.getContextTypeLoader().parse(inputStream, CTStyles.type, (XmlOptions) null);
        }

        public static CTStyles parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyles) XmlBeans.getContextTypeLoader().parse(inputStream, CTStyles.type, xmlOptions);
        }

        public static CTStyles parse(Reader reader) throws XmlException, IOException {
            return (CTStyles) XmlBeans.getContextTypeLoader().parse(reader, CTStyles.type, (XmlOptions) null);
        }

        public static CTStyles parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyles) XmlBeans.getContextTypeLoader().parse(reader, CTStyles.type, xmlOptions);
        }

        public static CTStyles parse(String str) throws XmlException {
            return (CTStyles) XmlBeans.getContextTypeLoader().parse(str, CTStyles.type, (XmlOptions) null);
        }

        public static CTStyles parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTStyles) XmlBeans.getContextTypeLoader().parse(str, CTStyles.type, xmlOptions);
        }

        public static CTStyles parse(URL url) throws XmlException, IOException {
            return (CTStyles) XmlBeans.getContextTypeLoader().parse(url, CTStyles.type, (XmlOptions) null);
        }

        public static CTStyles parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyles) XmlBeans.getContextTypeLoader().parse(url, CTStyles.type, xmlOptions);
        }

        public static CTStyles parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTStyles) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTStyles.type, (XmlOptions) null);
        }

        public static CTStyles parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTStyles) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTStyles.type, xmlOptions);
        }

        public static CTStyles parse(Node node) throws XmlException {
            return (CTStyles) XmlBeans.getContextTypeLoader().parse(node, CTStyles.type, (XmlOptions) null);
        }

        public static CTStyles parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTStyles) XmlBeans.getContextTypeLoader().parse(node, CTStyles.type, xmlOptions);
        }
    }

    CTDocDefaults addNewDocDefaults();

    CTLatentStyles addNewLatentStyles();

    CTStyle addNewStyle();

    CTDocDefaults getDocDefaults();

    CTLatentStyles getLatentStyles();

    CTStyle getStyleArray(int i);

    CTStyle[] getStyleArray();

    List<CTStyle> getStyleList();

    CTStyle insertNewStyle(int i);

    boolean isSetDocDefaults();

    boolean isSetLatentStyles();

    void removeStyle(int i);

    void setDocDefaults(CTDocDefaults cTDocDefaults);

    void setLatentStyles(CTLatentStyles cTLatentStyles);

    void setStyleArray(int i, CTStyle cTStyle);

    void setStyleArray(CTStyle[] cTStyleArr);

    int sizeOfStyleArray();

    void unsetDocDefaults();

    void unsetLatentStyles();
}
