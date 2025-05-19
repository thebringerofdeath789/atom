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
public interface CTTextParagraph extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTextParagraph.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttextparagraphcaf2type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextParagraph newInstance() {
            return (CTTextParagraph) XmlBeans.getContextTypeLoader().newInstance(CTTextParagraph.type, null);
        }

        public static CTTextParagraph newInstance(XmlOptions xmlOptions) {
            return (CTTextParagraph) XmlBeans.getContextTypeLoader().newInstance(CTTextParagraph.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextParagraph.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextParagraph.type, xmlOptions);
        }

        public static CTTextParagraph parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextParagraph) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextParagraph.type, (XmlOptions) null);
        }

        public static CTTextParagraph parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextParagraph) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextParagraph.type, xmlOptions);
        }

        public static CTTextParagraph parse(File file) throws XmlException, IOException {
            return (CTTextParagraph) XmlBeans.getContextTypeLoader().parse(file, CTTextParagraph.type, (XmlOptions) null);
        }

        public static CTTextParagraph parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextParagraph) XmlBeans.getContextTypeLoader().parse(file, CTTextParagraph.type, xmlOptions);
        }

        public static CTTextParagraph parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextParagraph) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextParagraph.type, (XmlOptions) null);
        }

        public static CTTextParagraph parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextParagraph) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextParagraph.type, xmlOptions);
        }

        public static CTTextParagraph parse(Reader reader) throws XmlException, IOException {
            return (CTTextParagraph) XmlBeans.getContextTypeLoader().parse(reader, CTTextParagraph.type, (XmlOptions) null);
        }

        public static CTTextParagraph parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextParagraph) XmlBeans.getContextTypeLoader().parse(reader, CTTextParagraph.type, xmlOptions);
        }

        public static CTTextParagraph parse(String str) throws XmlException {
            return (CTTextParagraph) XmlBeans.getContextTypeLoader().parse(str, CTTextParagraph.type, (XmlOptions) null);
        }

        public static CTTextParagraph parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextParagraph) XmlBeans.getContextTypeLoader().parse(str, CTTextParagraph.type, xmlOptions);
        }

        public static CTTextParagraph parse(URL url) throws XmlException, IOException {
            return (CTTextParagraph) XmlBeans.getContextTypeLoader().parse(url, CTTextParagraph.type, (XmlOptions) null);
        }

        public static CTTextParagraph parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextParagraph) XmlBeans.getContextTypeLoader().parse(url, CTTextParagraph.type, xmlOptions);
        }

        public static CTTextParagraph parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTextParagraph) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextParagraph.type, (XmlOptions) null);
        }

        public static CTTextParagraph parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTextParagraph) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextParagraph.type, xmlOptions);
        }

        public static CTTextParagraph parse(Node node) throws XmlException {
            return (CTTextParagraph) XmlBeans.getContextTypeLoader().parse(node, CTTextParagraph.type, (XmlOptions) null);
        }

        public static CTTextParagraph parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextParagraph) XmlBeans.getContextTypeLoader().parse(node, CTTextParagraph.type, xmlOptions);
        }
    }

    CTTextLineBreak addNewBr();

    CTTextCharacterProperties addNewEndParaRPr();

    CTTextField addNewFld();

    CTTextParagraphProperties addNewPPr();

    CTRegularTextRun addNewR();

    CTTextLineBreak getBrArray(int i);

    CTTextLineBreak[] getBrArray();

    List<CTTextLineBreak> getBrList();

    CTTextCharacterProperties getEndParaRPr();

    CTTextField getFldArray(int i);

    CTTextField[] getFldArray();

    List<CTTextField> getFldList();

    CTTextParagraphProperties getPPr();

    CTRegularTextRun getRArray(int i);

    CTRegularTextRun[] getRArray();

    List<CTRegularTextRun> getRList();

    CTTextLineBreak insertNewBr(int i);

    CTTextField insertNewFld(int i);

    CTRegularTextRun insertNewR(int i);

    boolean isSetEndParaRPr();

    boolean isSetPPr();

    void removeBr(int i);

    void removeFld(int i);

    void removeR(int i);

    void setBrArray(int i, CTTextLineBreak cTTextLineBreak);

    void setBrArray(CTTextLineBreak[] cTTextLineBreakArr);

    void setEndParaRPr(CTTextCharacterProperties cTTextCharacterProperties);

    void setFldArray(int i, CTTextField cTTextField);

    void setFldArray(CTTextField[] cTTextFieldArr);

    void setPPr(CTTextParagraphProperties cTTextParagraphProperties);

    void setRArray(int i, CTRegularTextRun cTRegularTextRun);

    void setRArray(CTRegularTextRun[] cTRegularTextRunArr);

    int sizeOfBrArray();

    int sizeOfFldArray();

    int sizeOfRArray();

    void unsetEndParaRPr();

    void unsetPPr();
}
