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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTHMerge extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTHMerge.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cthmerge1bf8type");

    public static final class Factory {
        private Factory() {
        }

        public static CTHMerge newInstance() {
            return (CTHMerge) XmlBeans.getContextTypeLoader().newInstance(CTHMerge.type, null);
        }

        public static CTHMerge newInstance(XmlOptions xmlOptions) {
            return (CTHMerge) XmlBeans.getContextTypeLoader().newInstance(CTHMerge.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTHMerge.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTHMerge.type, xmlOptions);
        }

        public static CTHMerge parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTHMerge) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTHMerge.type, (XmlOptions) null);
        }

        public static CTHMerge parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTHMerge) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTHMerge.type, xmlOptions);
        }

        public static CTHMerge parse(File file) throws XmlException, IOException {
            return (CTHMerge) XmlBeans.getContextTypeLoader().parse(file, CTHMerge.type, (XmlOptions) null);
        }

        public static CTHMerge parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHMerge) XmlBeans.getContextTypeLoader().parse(file, CTHMerge.type, xmlOptions);
        }

        public static CTHMerge parse(InputStream inputStream) throws XmlException, IOException {
            return (CTHMerge) XmlBeans.getContextTypeLoader().parse(inputStream, CTHMerge.type, (XmlOptions) null);
        }

        public static CTHMerge parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHMerge) XmlBeans.getContextTypeLoader().parse(inputStream, CTHMerge.type, xmlOptions);
        }

        public static CTHMerge parse(Reader reader) throws XmlException, IOException {
            return (CTHMerge) XmlBeans.getContextTypeLoader().parse(reader, CTHMerge.type, (XmlOptions) null);
        }

        public static CTHMerge parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHMerge) XmlBeans.getContextTypeLoader().parse(reader, CTHMerge.type, xmlOptions);
        }

        public static CTHMerge parse(String str) throws XmlException {
            return (CTHMerge) XmlBeans.getContextTypeLoader().parse(str, CTHMerge.type, (XmlOptions) null);
        }

        public static CTHMerge parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTHMerge) XmlBeans.getContextTypeLoader().parse(str, CTHMerge.type, xmlOptions);
        }

        public static CTHMerge parse(URL url) throws XmlException, IOException {
            return (CTHMerge) XmlBeans.getContextTypeLoader().parse(url, CTHMerge.type, (XmlOptions) null);
        }

        public static CTHMerge parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHMerge) XmlBeans.getContextTypeLoader().parse(url, CTHMerge.type, xmlOptions);
        }

        public static CTHMerge parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTHMerge) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTHMerge.type, (XmlOptions) null);
        }

        public static CTHMerge parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTHMerge) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTHMerge.type, xmlOptions);
        }

        public static CTHMerge parse(Node node) throws XmlException {
            return (CTHMerge) XmlBeans.getContextTypeLoader().parse(node, CTHMerge.type, (XmlOptions) null);
        }

        public static CTHMerge parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTHMerge) XmlBeans.getContextTypeLoader().parse(node, CTHMerge.type, xmlOptions);
        }
    }

    STMerge.Enum getVal();

    boolean isSetVal();

    void setVal(STMerge.Enum r1);

    void unsetVal();

    STMerge xgetVal();

    void xsetVal(STMerge sTMerge);
}
