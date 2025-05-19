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
public interface CTVMerge extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTVMerge.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctvmergee086type");

    public static final class Factory {
        private Factory() {
        }

        public static CTVMerge newInstance() {
            return (CTVMerge) XmlBeans.getContextTypeLoader().newInstance(CTVMerge.type, null);
        }

        public static CTVMerge newInstance(XmlOptions xmlOptions) {
            return (CTVMerge) XmlBeans.getContextTypeLoader().newInstance(CTVMerge.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTVMerge.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTVMerge.type, xmlOptions);
        }

        public static CTVMerge parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTVMerge) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTVMerge.type, (XmlOptions) null);
        }

        public static CTVMerge parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTVMerge) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTVMerge.type, xmlOptions);
        }

        public static CTVMerge parse(File file) throws XmlException, IOException {
            return (CTVMerge) XmlBeans.getContextTypeLoader().parse(file, CTVMerge.type, (XmlOptions) null);
        }

        public static CTVMerge parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVMerge) XmlBeans.getContextTypeLoader().parse(file, CTVMerge.type, xmlOptions);
        }

        public static CTVMerge parse(InputStream inputStream) throws XmlException, IOException {
            return (CTVMerge) XmlBeans.getContextTypeLoader().parse(inputStream, CTVMerge.type, (XmlOptions) null);
        }

        public static CTVMerge parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVMerge) XmlBeans.getContextTypeLoader().parse(inputStream, CTVMerge.type, xmlOptions);
        }

        public static CTVMerge parse(Reader reader) throws XmlException, IOException {
            return (CTVMerge) XmlBeans.getContextTypeLoader().parse(reader, CTVMerge.type, (XmlOptions) null);
        }

        public static CTVMerge parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVMerge) XmlBeans.getContextTypeLoader().parse(reader, CTVMerge.type, xmlOptions);
        }

        public static CTVMerge parse(String str) throws XmlException {
            return (CTVMerge) XmlBeans.getContextTypeLoader().parse(str, CTVMerge.type, (XmlOptions) null);
        }

        public static CTVMerge parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTVMerge) XmlBeans.getContextTypeLoader().parse(str, CTVMerge.type, xmlOptions);
        }

        public static CTVMerge parse(URL url) throws XmlException, IOException {
            return (CTVMerge) XmlBeans.getContextTypeLoader().parse(url, CTVMerge.type, (XmlOptions) null);
        }

        public static CTVMerge parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVMerge) XmlBeans.getContextTypeLoader().parse(url, CTVMerge.type, xmlOptions);
        }

        public static CTVMerge parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTVMerge) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTVMerge.type, (XmlOptions) null);
        }

        public static CTVMerge parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTVMerge) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTVMerge.type, xmlOptions);
        }

        public static CTVMerge parse(Node node) throws XmlException {
            return (CTVMerge) XmlBeans.getContextTypeLoader().parse(node, CTVMerge.type, (XmlOptions) null);
        }

        public static CTVMerge parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTVMerge) XmlBeans.getContextTypeLoader().parse(node, CTVMerge.type, xmlOptions);
        }
    }

    STMerge.Enum getVal();

    boolean isSetVal();

    void setVal(STMerge.Enum r1);

    void unsetVal();

    STMerge xgetVal();

    void xsetVal(STMerge sTMerge);
}
