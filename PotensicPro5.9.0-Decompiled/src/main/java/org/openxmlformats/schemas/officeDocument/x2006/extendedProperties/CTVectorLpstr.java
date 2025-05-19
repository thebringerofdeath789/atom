package org.openxmlformats.schemas.officeDocument.x2006.extendedProperties;

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
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTVectorLpstr extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTVectorLpstr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctvectorlpstr9b1dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTVectorLpstr newInstance() {
            return (CTVectorLpstr) XmlBeans.getContextTypeLoader().newInstance(CTVectorLpstr.type, null);
        }

        public static CTVectorLpstr newInstance(XmlOptions xmlOptions) {
            return (CTVectorLpstr) XmlBeans.getContextTypeLoader().newInstance(CTVectorLpstr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTVectorLpstr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTVectorLpstr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTVectorLpstr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(File file) throws XmlException, IOException {
            return (CTVectorLpstr) XmlBeans.getContextTypeLoader().parse(file, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVectorLpstr) XmlBeans.getContextTypeLoader().parse(file, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTVectorLpstr) XmlBeans.getContextTypeLoader().parse(inputStream, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVectorLpstr) XmlBeans.getContextTypeLoader().parse(inputStream, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(Reader reader) throws XmlException, IOException {
            return (CTVectorLpstr) XmlBeans.getContextTypeLoader().parse(reader, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVectorLpstr) XmlBeans.getContextTypeLoader().parse(reader, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(String str) throws XmlException {
            return (CTVectorLpstr) XmlBeans.getContextTypeLoader().parse(str, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTVectorLpstr) XmlBeans.getContextTypeLoader().parse(str, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(URL url) throws XmlException, IOException {
            return (CTVectorLpstr) XmlBeans.getContextTypeLoader().parse(url, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVectorLpstr) XmlBeans.getContextTypeLoader().parse(url, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTVectorLpstr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTVectorLpstr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(Node node) throws XmlException {
            return (CTVectorLpstr) XmlBeans.getContextTypeLoader().parse(node, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTVectorLpstr) XmlBeans.getContextTypeLoader().parse(node, CTVectorLpstr.type, xmlOptions);
        }
    }

    CTVector addNewVector();

    CTVector getVector();

    void setVector(CTVector cTVector);
}
