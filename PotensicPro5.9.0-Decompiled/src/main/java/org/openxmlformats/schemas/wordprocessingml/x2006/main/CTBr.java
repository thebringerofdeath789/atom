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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBrClear;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBrType;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTBr extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTBr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctbr7dd8type");

    public static final class Factory {
        private Factory() {
        }

        public static CTBr newInstance() {
            return (CTBr) XmlBeans.getContextTypeLoader().newInstance(CTBr.type, null);
        }

        public static CTBr newInstance(XmlOptions xmlOptions) {
            return (CTBr) XmlBeans.getContextTypeLoader().newInstance(CTBr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTBr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTBr.type, xmlOptions);
        }

        public static CTBr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTBr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTBr.type, (XmlOptions) null);
        }

        public static CTBr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTBr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTBr.type, xmlOptions);
        }

        public static CTBr parse(File file) throws XmlException, IOException {
            return (CTBr) XmlBeans.getContextTypeLoader().parse(file, CTBr.type, (XmlOptions) null);
        }

        public static CTBr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBr) XmlBeans.getContextTypeLoader().parse(file, CTBr.type, xmlOptions);
        }

        public static CTBr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTBr) XmlBeans.getContextTypeLoader().parse(inputStream, CTBr.type, (XmlOptions) null);
        }

        public static CTBr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBr) XmlBeans.getContextTypeLoader().parse(inputStream, CTBr.type, xmlOptions);
        }

        public static CTBr parse(Reader reader) throws XmlException, IOException {
            return (CTBr) XmlBeans.getContextTypeLoader().parse(reader, CTBr.type, (XmlOptions) null);
        }

        public static CTBr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBr) XmlBeans.getContextTypeLoader().parse(reader, CTBr.type, xmlOptions);
        }

        public static CTBr parse(String str) throws XmlException {
            return (CTBr) XmlBeans.getContextTypeLoader().parse(str, CTBr.type, (XmlOptions) null);
        }

        public static CTBr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTBr) XmlBeans.getContextTypeLoader().parse(str, CTBr.type, xmlOptions);
        }

        public static CTBr parse(URL url) throws XmlException, IOException {
            return (CTBr) XmlBeans.getContextTypeLoader().parse(url, CTBr.type, (XmlOptions) null);
        }

        public static CTBr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBr) XmlBeans.getContextTypeLoader().parse(url, CTBr.type, xmlOptions);
        }

        public static CTBr parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTBr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTBr.type, (XmlOptions) null);
        }

        public static CTBr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTBr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTBr.type, xmlOptions);
        }

        public static CTBr parse(Node node) throws XmlException {
            return (CTBr) XmlBeans.getContextTypeLoader().parse(node, CTBr.type, (XmlOptions) null);
        }

        public static CTBr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTBr) XmlBeans.getContextTypeLoader().parse(node, CTBr.type, xmlOptions);
        }
    }

    STBrClear.Enum getClear();

    STBrType.Enum getType();

    boolean isSetClear();

    boolean isSetType();

    void setClear(STBrClear.Enum r1);

    void setType(STBrType.Enum r1);

    void unsetClear();

    void unsetType();

    STBrClear xgetClear();

    STBrType xgetType();

    void xsetClear(STBrClear sTBrClear);

    void xsetType(STBrType sTBrType);
}
