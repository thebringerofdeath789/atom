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
public interface CTPhoneticPr extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPhoneticPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctphoneticpr898btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPhoneticPr newInstance() {
            return (CTPhoneticPr) XmlBeans.getContextTypeLoader().newInstance(CTPhoneticPr.type, null);
        }

        public static CTPhoneticPr newInstance(XmlOptions xmlOptions) {
            return (CTPhoneticPr) XmlBeans.getContextTypeLoader().newInstance(CTPhoneticPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPhoneticPr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPhoneticPr.type, xmlOptions);
        }

        public static CTPhoneticPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPhoneticPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPhoneticPr.type, (XmlOptions) null);
        }

        public static CTPhoneticPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPhoneticPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPhoneticPr.type, xmlOptions);
        }

        public static CTPhoneticPr parse(File file) throws XmlException, IOException {
            return (CTPhoneticPr) XmlBeans.getContextTypeLoader().parse(file, CTPhoneticPr.type, (XmlOptions) null);
        }

        public static CTPhoneticPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPhoneticPr) XmlBeans.getContextTypeLoader().parse(file, CTPhoneticPr.type, xmlOptions);
        }

        public static CTPhoneticPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPhoneticPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTPhoneticPr.type, (XmlOptions) null);
        }

        public static CTPhoneticPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPhoneticPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTPhoneticPr.type, xmlOptions);
        }

        public static CTPhoneticPr parse(Reader reader) throws XmlException, IOException {
            return (CTPhoneticPr) XmlBeans.getContextTypeLoader().parse(reader, CTPhoneticPr.type, (XmlOptions) null);
        }

        public static CTPhoneticPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPhoneticPr) XmlBeans.getContextTypeLoader().parse(reader, CTPhoneticPr.type, xmlOptions);
        }

        public static CTPhoneticPr parse(String str) throws XmlException {
            return (CTPhoneticPr) XmlBeans.getContextTypeLoader().parse(str, CTPhoneticPr.type, (XmlOptions) null);
        }

        public static CTPhoneticPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPhoneticPr) XmlBeans.getContextTypeLoader().parse(str, CTPhoneticPr.type, xmlOptions);
        }

        public static CTPhoneticPr parse(URL url) throws XmlException, IOException {
            return (CTPhoneticPr) XmlBeans.getContextTypeLoader().parse(url, CTPhoneticPr.type, (XmlOptions) null);
        }

        public static CTPhoneticPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPhoneticPr) XmlBeans.getContextTypeLoader().parse(url, CTPhoneticPr.type, xmlOptions);
        }

        public static CTPhoneticPr parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPhoneticPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPhoneticPr.type, (XmlOptions) null);
        }

        public static CTPhoneticPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPhoneticPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPhoneticPr.type, xmlOptions);
        }

        public static CTPhoneticPr parse(Node node) throws XmlException {
            return (CTPhoneticPr) XmlBeans.getContextTypeLoader().parse(node, CTPhoneticPr.type, (XmlOptions) null);
        }

        public static CTPhoneticPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPhoneticPr) XmlBeans.getContextTypeLoader().parse(node, CTPhoneticPr.type, xmlOptions);
        }
    }

    STPhoneticAlignment$Enum getAlignment();

    long getFontId();

    STPhoneticType$Enum getType();

    boolean isSetAlignment();

    boolean isSetType();

    void setAlignment(STPhoneticAlignment$Enum sTPhoneticAlignment$Enum);

    void setFontId(long j);

    void setType(STPhoneticType$Enum sTPhoneticType$Enum);

    void unsetAlignment();

    void unsetType();

    STPhoneticAlignment xgetAlignment();

    STFontId xgetFontId();

    STPhoneticType xgetType();

    void xsetAlignment(STPhoneticAlignment sTPhoneticAlignment);

    void xsetFontId(STFontId sTFontId);

    void xsetType(STPhoneticType sTPhoneticType);
}
