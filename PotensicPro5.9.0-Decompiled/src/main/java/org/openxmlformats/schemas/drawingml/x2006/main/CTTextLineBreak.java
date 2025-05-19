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
public interface CTTextLineBreak extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTextLineBreak.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttextlinebreak932ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextLineBreak newInstance() {
            return (CTTextLineBreak) XmlBeans.getContextTypeLoader().newInstance(CTTextLineBreak.type, null);
        }

        public static CTTextLineBreak newInstance(XmlOptions xmlOptions) {
            return (CTTextLineBreak) XmlBeans.getContextTypeLoader().newInstance(CTTextLineBreak.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextLineBreak.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextLineBreak) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextLineBreak) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(File file) throws XmlException, IOException {
            return (CTTextLineBreak) XmlBeans.getContextTypeLoader().parse(file, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextLineBreak) XmlBeans.getContextTypeLoader().parse(file, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextLineBreak) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextLineBreak) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(Reader reader) throws XmlException, IOException {
            return (CTTextLineBreak) XmlBeans.getContextTypeLoader().parse(reader, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextLineBreak) XmlBeans.getContextTypeLoader().parse(reader, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(String str) throws XmlException {
            return (CTTextLineBreak) XmlBeans.getContextTypeLoader().parse(str, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextLineBreak) XmlBeans.getContextTypeLoader().parse(str, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(URL url) throws XmlException, IOException {
            return (CTTextLineBreak) XmlBeans.getContextTypeLoader().parse(url, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextLineBreak) XmlBeans.getContextTypeLoader().parse(url, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTextLineBreak) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTextLineBreak) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(Node node) throws XmlException {
            return (CTTextLineBreak) XmlBeans.getContextTypeLoader().parse(node, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextLineBreak) XmlBeans.getContextTypeLoader().parse(node, CTTextLineBreak.type, xmlOptions);
        }
    }

    CTTextCharacterProperties addNewRPr();

    CTTextCharacterProperties getRPr();

    boolean isSetRPr();

    void setRPr(CTTextCharacterProperties cTTextCharacterProperties);

    void unsetRPr();
}
