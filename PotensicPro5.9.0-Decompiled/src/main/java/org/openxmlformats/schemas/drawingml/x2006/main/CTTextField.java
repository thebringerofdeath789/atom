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
public interface CTTextField extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTextField.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttextfield187etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextField newInstance() {
            return (CTTextField) XmlBeans.getContextTypeLoader().newInstance(CTTextField.type, null);
        }

        public static CTTextField newInstance(XmlOptions xmlOptions) {
            return (CTTextField) XmlBeans.getContextTypeLoader().newInstance(CTTextField.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextField.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextField) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextField) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(File file) throws XmlException, IOException {
            return (CTTextField) XmlBeans.getContextTypeLoader().parse(file, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextField) XmlBeans.getContextTypeLoader().parse(file, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextField) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextField) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(Reader reader) throws XmlException, IOException {
            return (CTTextField) XmlBeans.getContextTypeLoader().parse(reader, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextField) XmlBeans.getContextTypeLoader().parse(reader, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(String str) throws XmlException {
            return (CTTextField) XmlBeans.getContextTypeLoader().parse(str, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextField) XmlBeans.getContextTypeLoader().parse(str, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(URL url) throws XmlException, IOException {
            return (CTTextField) XmlBeans.getContextTypeLoader().parse(url, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextField) XmlBeans.getContextTypeLoader().parse(url, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTextField) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTextField) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(Node node) throws XmlException {
            return (CTTextField) XmlBeans.getContextTypeLoader().parse(node, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextField) XmlBeans.getContextTypeLoader().parse(node, CTTextField.type, xmlOptions);
        }
    }

    CTTextParagraphProperties addNewPPr();

    CTTextCharacterProperties addNewRPr();

    String getId();

    CTTextParagraphProperties getPPr();

    CTTextCharacterProperties getRPr();

    String getT();

    String getType();

    boolean isSetPPr();

    boolean isSetRPr();

    boolean isSetT();

    boolean isSetType();

    void setId(String str);

    void setPPr(CTTextParagraphProperties cTTextParagraphProperties);

    void setRPr(CTTextCharacterProperties cTTextCharacterProperties);

    void setT(String str);

    void setType(String str);

    void unsetPPr();

    void unsetRPr();

    void unsetT();

    void unsetType();

    STGuid xgetId();

    XmlString xgetT();

    XmlString xgetType();

    void xsetId(STGuid sTGuid);

    void xsetT(XmlString xmlString);

    void xsetType(XmlString xmlString);
}
