package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
public interface CTSym extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSym.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctsym0dabtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSym newInstance() {
            return (CTSym) XmlBeans.getContextTypeLoader().newInstance(CTSym.type, null);
        }

        public static CTSym newInstance(XmlOptions xmlOptions) {
            return (CTSym) XmlBeans.getContextTypeLoader().newInstance(CTSym.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSym.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSym.type, xmlOptions);
        }

        public static CTSym parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSym) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSym.type, (XmlOptions) null);
        }

        public static CTSym parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSym) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSym.type, xmlOptions);
        }

        public static CTSym parse(File file) throws XmlException, IOException {
            return (CTSym) XmlBeans.getContextTypeLoader().parse(file, CTSym.type, (XmlOptions) null);
        }

        public static CTSym parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSym) XmlBeans.getContextTypeLoader().parse(file, CTSym.type, xmlOptions);
        }

        public static CTSym parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSym) XmlBeans.getContextTypeLoader().parse(inputStream, CTSym.type, (XmlOptions) null);
        }

        public static CTSym parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSym) XmlBeans.getContextTypeLoader().parse(inputStream, CTSym.type, xmlOptions);
        }

        public static CTSym parse(Reader reader) throws XmlException, IOException {
            return (CTSym) XmlBeans.getContextTypeLoader().parse(reader, CTSym.type, (XmlOptions) null);
        }

        public static CTSym parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSym) XmlBeans.getContextTypeLoader().parse(reader, CTSym.type, xmlOptions);
        }

        public static CTSym parse(String str) throws XmlException {
            return (CTSym) XmlBeans.getContextTypeLoader().parse(str, CTSym.type, (XmlOptions) null);
        }

        public static CTSym parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSym) XmlBeans.getContextTypeLoader().parse(str, CTSym.type, xmlOptions);
        }

        public static CTSym parse(URL url) throws XmlException, IOException {
            return (CTSym) XmlBeans.getContextTypeLoader().parse(url, CTSym.type, (XmlOptions) null);
        }

        public static CTSym parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSym) XmlBeans.getContextTypeLoader().parse(url, CTSym.type, xmlOptions);
        }

        public static CTSym parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSym) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSym.type, (XmlOptions) null);
        }

        public static CTSym parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSym) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSym.type, xmlOptions);
        }

        public static CTSym parse(Node node) throws XmlException {
            return (CTSym) XmlBeans.getContextTypeLoader().parse(node, CTSym.type, (XmlOptions) null);
        }

        public static CTSym parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSym) XmlBeans.getContextTypeLoader().parse(node, CTSym.type, xmlOptions);
        }
    }

    byte[] getChar();

    String getFont();

    boolean isSetChar();

    boolean isSetFont();

    void setChar(byte[] bArr);

    void setFont(String str);

    void unsetChar();

    void unsetFont();

    STShortHexNumber xgetChar();

    STString xgetFont();

    void xsetChar(STShortHexNumber sTShortHexNumber);

    void xsetFont(STString sTString);
}
