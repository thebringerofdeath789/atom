package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTSlideMasterTextStyles extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSlideMasterTextStyles.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctslidemastertextstylesb48dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSlideMasterTextStyles newInstance() {
            return (CTSlideMasterTextStyles) XmlBeans.getContextTypeLoader().newInstance(CTSlideMasterTextStyles.type, null);
        }

        public static CTSlideMasterTextStyles newInstance(XmlOptions xmlOptions) {
            return (CTSlideMasterTextStyles) XmlBeans.getContextTypeLoader().newInstance(CTSlideMasterTextStyles.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSlideMasterTextStyles.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSlideMasterTextStyles.type, xmlOptions);
        }

        public static CTSlideMasterTextStyles parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSlideMasterTextStyles) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSlideMasterTextStyles.type, (XmlOptions) null);
        }

        public static CTSlideMasterTextStyles parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideMasterTextStyles) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSlideMasterTextStyles.type, xmlOptions);
        }

        public static CTSlideMasterTextStyles parse(File file) throws XmlException, IOException {
            return (CTSlideMasterTextStyles) XmlBeans.getContextTypeLoader().parse(file, CTSlideMasterTextStyles.type, (XmlOptions) null);
        }

        public static CTSlideMasterTextStyles parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideMasterTextStyles) XmlBeans.getContextTypeLoader().parse(file, CTSlideMasterTextStyles.type, xmlOptions);
        }

        public static CTSlideMasterTextStyles parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSlideMasterTextStyles) XmlBeans.getContextTypeLoader().parse(inputStream, CTSlideMasterTextStyles.type, (XmlOptions) null);
        }

        public static CTSlideMasterTextStyles parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideMasterTextStyles) XmlBeans.getContextTypeLoader().parse(inputStream, CTSlideMasterTextStyles.type, xmlOptions);
        }

        public static CTSlideMasterTextStyles parse(Reader reader) throws XmlException, IOException {
            return (CTSlideMasterTextStyles) XmlBeans.getContextTypeLoader().parse(reader, CTSlideMasterTextStyles.type, (XmlOptions) null);
        }

        public static CTSlideMasterTextStyles parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideMasterTextStyles) XmlBeans.getContextTypeLoader().parse(reader, CTSlideMasterTextStyles.type, xmlOptions);
        }

        public static CTSlideMasterTextStyles parse(String str) throws XmlException {
            return (CTSlideMasterTextStyles) XmlBeans.getContextTypeLoader().parse(str, CTSlideMasterTextStyles.type, (XmlOptions) null);
        }

        public static CTSlideMasterTextStyles parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideMasterTextStyles) XmlBeans.getContextTypeLoader().parse(str, CTSlideMasterTextStyles.type, xmlOptions);
        }

        public static CTSlideMasterTextStyles parse(URL url) throws XmlException, IOException {
            return (CTSlideMasterTextStyles) XmlBeans.getContextTypeLoader().parse(url, CTSlideMasterTextStyles.type, (XmlOptions) null);
        }

        public static CTSlideMasterTextStyles parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideMasterTextStyles) XmlBeans.getContextTypeLoader().parse(url, CTSlideMasterTextStyles.type, xmlOptions);
        }

        public static CTSlideMasterTextStyles parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSlideMasterTextStyles) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSlideMasterTextStyles.type, (XmlOptions) null);
        }

        public static CTSlideMasterTextStyles parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSlideMasterTextStyles) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSlideMasterTextStyles.type, xmlOptions);
        }

        public static CTSlideMasterTextStyles parse(Node node) throws XmlException {
            return (CTSlideMasterTextStyles) XmlBeans.getContextTypeLoader().parse(node, CTSlideMasterTextStyles.type, (XmlOptions) null);
        }

        public static CTSlideMasterTextStyles parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideMasterTextStyles) XmlBeans.getContextTypeLoader().parse(node, CTSlideMasterTextStyles.type, xmlOptions);
        }
    }

    CTTextListStyle addNewBodyStyle();

    CTExtensionList addNewExtLst();

    CTTextListStyle addNewOtherStyle();

    CTTextListStyle addNewTitleStyle();

    CTTextListStyle getBodyStyle();

    CTExtensionList getExtLst();

    CTTextListStyle getOtherStyle();

    CTTextListStyle getTitleStyle();

    boolean isSetBodyStyle();

    boolean isSetExtLst();

    boolean isSetOtherStyle();

    boolean isSetTitleStyle();

    void setBodyStyle(CTTextListStyle cTTextListStyle);

    void setExtLst(CTExtensionList cTExtensionList);

    void setOtherStyle(CTTextListStyle cTTextListStyle);

    void setTitleStyle(CTTextListStyle cTTextListStyle);

    void unsetBodyStyle();

    void unsetExtLst();

    void unsetOtherStyle();

    void unsetTitleStyle();
}
