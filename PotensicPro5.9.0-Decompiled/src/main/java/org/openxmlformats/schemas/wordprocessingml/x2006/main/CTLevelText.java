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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTLevelText extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTLevelText.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctleveltext0621type");

    public static final class Factory {
        private Factory() {
        }

        public static CTLevelText newInstance() {
            return (CTLevelText) XmlBeans.getContextTypeLoader().newInstance(CTLevelText.type, null);
        }

        public static CTLevelText newInstance(XmlOptions xmlOptions) {
            return (CTLevelText) XmlBeans.getContextTypeLoader().newInstance(CTLevelText.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLevelText.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLevelText.type, xmlOptions);
        }

        public static CTLevelText parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLevelText) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLevelText.type, (XmlOptions) null);
        }

        public static CTLevelText parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLevelText) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLevelText.type, xmlOptions);
        }

        public static CTLevelText parse(File file) throws XmlException, IOException {
            return (CTLevelText) XmlBeans.getContextTypeLoader().parse(file, CTLevelText.type, (XmlOptions) null);
        }

        public static CTLevelText parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLevelText) XmlBeans.getContextTypeLoader().parse(file, CTLevelText.type, xmlOptions);
        }

        public static CTLevelText parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLevelText) XmlBeans.getContextTypeLoader().parse(inputStream, CTLevelText.type, (XmlOptions) null);
        }

        public static CTLevelText parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLevelText) XmlBeans.getContextTypeLoader().parse(inputStream, CTLevelText.type, xmlOptions);
        }

        public static CTLevelText parse(Reader reader) throws XmlException, IOException {
            return (CTLevelText) XmlBeans.getContextTypeLoader().parse(reader, CTLevelText.type, (XmlOptions) null);
        }

        public static CTLevelText parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLevelText) XmlBeans.getContextTypeLoader().parse(reader, CTLevelText.type, xmlOptions);
        }

        public static CTLevelText parse(String str) throws XmlException {
            return (CTLevelText) XmlBeans.getContextTypeLoader().parse(str, CTLevelText.type, (XmlOptions) null);
        }

        public static CTLevelText parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLevelText) XmlBeans.getContextTypeLoader().parse(str, CTLevelText.type, xmlOptions);
        }

        public static CTLevelText parse(URL url) throws XmlException, IOException {
            return (CTLevelText) XmlBeans.getContextTypeLoader().parse(url, CTLevelText.type, (XmlOptions) null);
        }

        public static CTLevelText parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLevelText) XmlBeans.getContextTypeLoader().parse(url, CTLevelText.type, xmlOptions);
        }

        public static CTLevelText parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTLevelText) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLevelText.type, (XmlOptions) null);
        }

        public static CTLevelText parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTLevelText) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLevelText.type, xmlOptions);
        }

        public static CTLevelText parse(Node node) throws XmlException {
            return (CTLevelText) XmlBeans.getContextTypeLoader().parse(node, CTLevelText.type, (XmlOptions) null);
        }

        public static CTLevelText parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLevelText) XmlBeans.getContextTypeLoader().parse(node, CTLevelText.type, xmlOptions);
        }
    }

    STOnOff.Enum getNull();

    String getVal();

    boolean isSetNull();

    boolean isSetVal();

    void setNull(STOnOff.Enum r1);

    void setVal(String str);

    void unsetNull();

    void unsetVal();

    STOnOff xgetNull();

    STString xgetVal();

    void xsetNull(STOnOff sTOnOff);

    void xsetVal(STString sTString);
}
