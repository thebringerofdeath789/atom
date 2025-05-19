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
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTNotesMaster extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTNotesMaster.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctnotesmaster69ectype");

    public static final class Factory {
        private Factory() {
        }

        public static CTNotesMaster newInstance() {
            return (CTNotesMaster) XmlBeans.getContextTypeLoader().newInstance(CTNotesMaster.type, null);
        }

        public static CTNotesMaster newInstance(XmlOptions xmlOptions) {
            return (CTNotesMaster) XmlBeans.getContextTypeLoader().newInstance(CTNotesMaster.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNotesMaster.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNotesMaster.type, xmlOptions);
        }

        public static CTNotesMaster parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNotesMaster) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNotesMaster.type, (XmlOptions) null);
        }

        public static CTNotesMaster parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNotesMaster) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNotesMaster.type, xmlOptions);
        }

        public static CTNotesMaster parse(File file) throws XmlException, IOException {
            return (CTNotesMaster) XmlBeans.getContextTypeLoader().parse(file, CTNotesMaster.type, (XmlOptions) null);
        }

        public static CTNotesMaster parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNotesMaster) XmlBeans.getContextTypeLoader().parse(file, CTNotesMaster.type, xmlOptions);
        }

        public static CTNotesMaster parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNotesMaster) XmlBeans.getContextTypeLoader().parse(inputStream, CTNotesMaster.type, (XmlOptions) null);
        }

        public static CTNotesMaster parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNotesMaster) XmlBeans.getContextTypeLoader().parse(inputStream, CTNotesMaster.type, xmlOptions);
        }

        public static CTNotesMaster parse(Reader reader) throws XmlException, IOException {
            return (CTNotesMaster) XmlBeans.getContextTypeLoader().parse(reader, CTNotesMaster.type, (XmlOptions) null);
        }

        public static CTNotesMaster parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNotesMaster) XmlBeans.getContextTypeLoader().parse(reader, CTNotesMaster.type, xmlOptions);
        }

        public static CTNotesMaster parse(String str) throws XmlException {
            return (CTNotesMaster) XmlBeans.getContextTypeLoader().parse(str, CTNotesMaster.type, (XmlOptions) null);
        }

        public static CTNotesMaster parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNotesMaster) XmlBeans.getContextTypeLoader().parse(str, CTNotesMaster.type, xmlOptions);
        }

        public static CTNotesMaster parse(URL url) throws XmlException, IOException {
            return (CTNotesMaster) XmlBeans.getContextTypeLoader().parse(url, CTNotesMaster.type, (XmlOptions) null);
        }

        public static CTNotesMaster parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNotesMaster) XmlBeans.getContextTypeLoader().parse(url, CTNotesMaster.type, xmlOptions);
        }

        public static CTNotesMaster parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTNotesMaster) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNotesMaster.type, (XmlOptions) null);
        }

        public static CTNotesMaster parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTNotesMaster) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNotesMaster.type, xmlOptions);
        }

        public static CTNotesMaster parse(Node node) throws XmlException {
            return (CTNotesMaster) XmlBeans.getContextTypeLoader().parse(node, CTNotesMaster.type, (XmlOptions) null);
        }

        public static CTNotesMaster parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNotesMaster) XmlBeans.getContextTypeLoader().parse(node, CTNotesMaster.type, xmlOptions);
        }
    }

    CTCommonSlideData addNewCSld();

    CTColorMapping addNewClrMap();

    CTExtensionListModify addNewExtLst();

    CTHeaderFooter addNewHf();

    CTTextListStyle addNewNotesStyle();

    CTCommonSlideData getCSld();

    CTColorMapping getClrMap();

    CTExtensionListModify getExtLst();

    CTHeaderFooter getHf();

    CTTextListStyle getNotesStyle();

    boolean isSetExtLst();

    boolean isSetHf();

    boolean isSetNotesStyle();

    void setCSld(CTCommonSlideData cTCommonSlideData);

    void setClrMap(CTColorMapping cTColorMapping);

    void setExtLst(CTExtensionListModify cTExtensionListModify);

    void setHf(CTHeaderFooter cTHeaderFooter);

    void setNotesStyle(CTTextListStyle cTTextListStyle);

    void unsetExtLst();

    void unsetHf();

    void unsetNotesStyle();
}
