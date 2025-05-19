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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTOfficeStyleSheet extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTOfficeStyleSheet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctofficestylesheetce25type");

    public static final class Factory {
        private Factory() {
        }

        public static CTOfficeStyleSheet newInstance() {
            return (CTOfficeStyleSheet) XmlBeans.getContextTypeLoader().newInstance(CTOfficeStyleSheet.type, null);
        }

        public static CTOfficeStyleSheet newInstance(XmlOptions xmlOptions) {
            return (CTOfficeStyleSheet) XmlBeans.getContextTypeLoader().newInstance(CTOfficeStyleSheet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTOfficeStyleSheet.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTOfficeStyleSheet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTOfficeStyleSheet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(File file) throws XmlException, IOException {
            return (CTOfficeStyleSheet) XmlBeans.getContextTypeLoader().parse(file, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeStyleSheet) XmlBeans.getContextTypeLoader().parse(file, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(InputStream inputStream) throws XmlException, IOException {
            return (CTOfficeStyleSheet) XmlBeans.getContextTypeLoader().parse(inputStream, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeStyleSheet) XmlBeans.getContextTypeLoader().parse(inputStream, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(Reader reader) throws XmlException, IOException {
            return (CTOfficeStyleSheet) XmlBeans.getContextTypeLoader().parse(reader, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeStyleSheet) XmlBeans.getContextTypeLoader().parse(reader, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(String str) throws XmlException {
            return (CTOfficeStyleSheet) XmlBeans.getContextTypeLoader().parse(str, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTOfficeStyleSheet) XmlBeans.getContextTypeLoader().parse(str, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(URL url) throws XmlException, IOException {
            return (CTOfficeStyleSheet) XmlBeans.getContextTypeLoader().parse(url, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeStyleSheet) XmlBeans.getContextTypeLoader().parse(url, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTOfficeStyleSheet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTOfficeStyleSheet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(Node node) throws XmlException {
            return (CTOfficeStyleSheet) XmlBeans.getContextTypeLoader().parse(node, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTOfficeStyleSheet) XmlBeans.getContextTypeLoader().parse(node, CTOfficeStyleSheet.type, xmlOptions);
        }
    }

    CTCustomColorList addNewCustClrLst();

    CTOfficeArtExtensionList addNewExtLst();

    CTColorSchemeList addNewExtraClrSchemeLst();

    CTObjectStyleDefaults addNewObjectDefaults();

    CTBaseStyles addNewThemeElements();

    CTCustomColorList getCustClrLst();

    CTOfficeArtExtensionList getExtLst();

    CTColorSchemeList getExtraClrSchemeLst();

    String getName();

    CTObjectStyleDefaults getObjectDefaults();

    CTBaseStyles getThemeElements();

    boolean isSetCustClrLst();

    boolean isSetExtLst();

    boolean isSetExtraClrSchemeLst();

    boolean isSetName();

    boolean isSetObjectDefaults();

    void setCustClrLst(CTCustomColorList cTCustomColorList);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setExtraClrSchemeLst(CTColorSchemeList cTColorSchemeList);

    void setName(String str);

    void setObjectDefaults(CTObjectStyleDefaults cTObjectStyleDefaults);

    void setThemeElements(CTBaseStyles cTBaseStyles);

    void unsetCustClrLst();

    void unsetExtLst();

    void unsetExtraClrSchemeLst();

    void unsetName();

    void unsetObjectDefaults();

    XmlString xgetName();

    void xsetName(XmlString xmlString);
}
