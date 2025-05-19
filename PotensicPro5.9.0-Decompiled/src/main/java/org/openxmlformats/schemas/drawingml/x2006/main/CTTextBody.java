package org.openxmlformats.schemas.drawingml.x2006.main;

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

/* loaded from: classes5.dex */
public interface CTTextBody extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTextBody.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttextbodya3catype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextBody newInstance() {
            return (CTTextBody) XmlBeans.getContextTypeLoader().newInstance(CTTextBody.type, null);
        }

        public static CTTextBody newInstance(XmlOptions xmlOptions) {
            return (CTTextBody) XmlBeans.getContextTypeLoader().newInstance(CTTextBody.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextBody.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextBody.type, xmlOptions);
        }

        public static CTTextBody parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextBody) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextBody.type, (XmlOptions) null);
        }

        public static CTTextBody parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextBody) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextBody.type, xmlOptions);
        }

        public static CTTextBody parse(File file) throws XmlException, IOException {
            return (CTTextBody) XmlBeans.getContextTypeLoader().parse(file, CTTextBody.type, (XmlOptions) null);
        }

        public static CTTextBody parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBody) XmlBeans.getContextTypeLoader().parse(file, CTTextBody.type, xmlOptions);
        }

        public static CTTextBody parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextBody) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextBody.type, (XmlOptions) null);
        }

        public static CTTextBody parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBody) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextBody.type, xmlOptions);
        }

        public static CTTextBody parse(Reader reader) throws XmlException, IOException {
            return (CTTextBody) XmlBeans.getContextTypeLoader().parse(reader, CTTextBody.type, (XmlOptions) null);
        }

        public static CTTextBody parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBody) XmlBeans.getContextTypeLoader().parse(reader, CTTextBody.type, xmlOptions);
        }

        public static CTTextBody parse(String str) throws XmlException {
            return (CTTextBody) XmlBeans.getContextTypeLoader().parse(str, CTTextBody.type, (XmlOptions) null);
        }

        public static CTTextBody parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextBody) XmlBeans.getContextTypeLoader().parse(str, CTTextBody.type, xmlOptions);
        }

        public static CTTextBody parse(URL url) throws XmlException, IOException {
            return (CTTextBody) XmlBeans.getContextTypeLoader().parse(url, CTTextBody.type, (XmlOptions) null);
        }

        public static CTTextBody parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBody) XmlBeans.getContextTypeLoader().parse(url, CTTextBody.type, xmlOptions);
        }

        public static CTTextBody parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTextBody) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextBody.type, (XmlOptions) null);
        }

        public static CTTextBody parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTextBody) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextBody.type, xmlOptions);
        }

        public static CTTextBody parse(Node node) throws XmlException {
            return (CTTextBody) XmlBeans.getContextTypeLoader().parse(node, CTTextBody.type, (XmlOptions) null);
        }

        public static CTTextBody parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextBody) XmlBeans.getContextTypeLoader().parse(node, CTTextBody.type, xmlOptions);
        }
    }

    CTTextBodyProperties addNewBodyPr();

    CTTextListStyle addNewLstStyle();

    CTTextParagraph addNewP();

    CTTextBodyProperties getBodyPr();

    CTTextListStyle getLstStyle();

    CTTextParagraph getPArray(int i);

    CTTextParagraph[] getPArray();

    List<CTTextParagraph> getPList();

    CTTextParagraph insertNewP(int i);

    boolean isSetLstStyle();

    void removeP(int i);

    void setBodyPr(CTTextBodyProperties cTTextBodyProperties);

    void setLstStyle(CTTextListStyle cTTextListStyle);

    void setPArray(int i, CTTextParagraph cTTextParagraph);

    void setPArray(CTTextParagraph[] cTTextParagraphArr);

    int sizeOfPArray();

    void unsetLstStyle();
}
