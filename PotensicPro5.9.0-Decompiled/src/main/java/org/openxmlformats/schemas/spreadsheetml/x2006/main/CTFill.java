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
public interface CTFill extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTFill.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctfill550ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFill newInstance() {
            return (CTFill) XmlBeans.getContextTypeLoader().newInstance(CTFill.type, null);
        }

        public static CTFill newInstance(XmlOptions xmlOptions) {
            return (CTFill) XmlBeans.getContextTypeLoader().newInstance(CTFill.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFill.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFill.type, xmlOptions);
        }

        public static CTFill parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFill.type, xmlOptions);
        }

        public static CTFill parse(File file) throws XmlException, IOException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(file, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(file, CTFill.type, xmlOptions);
        }

        public static CTFill parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(inputStream, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(inputStream, CTFill.type, xmlOptions);
        }

        public static CTFill parse(Reader reader) throws XmlException, IOException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(reader, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(reader, CTFill.type, xmlOptions);
        }

        public static CTFill parse(String str) throws XmlException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(str, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(str, CTFill.type, xmlOptions);
        }

        public static CTFill parse(URL url) throws XmlException, IOException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(url, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(url, CTFill.type, xmlOptions);
        }

        public static CTFill parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFill.type, xmlOptions);
        }

        public static CTFill parse(Node node) throws XmlException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(node, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(node, CTFill.type, xmlOptions);
        }
    }

    CTGradientFill addNewGradientFill();

    CTPatternFill addNewPatternFill();

    CTGradientFill getGradientFill();

    CTPatternFill getPatternFill();

    boolean isSetGradientFill();

    boolean isSetPatternFill();

    void setGradientFill(CTGradientFill cTGradientFill);

    void setPatternFill(CTPatternFill cTPatternFill);

    void unsetGradientFill();

    void unsetPatternFill();
}
