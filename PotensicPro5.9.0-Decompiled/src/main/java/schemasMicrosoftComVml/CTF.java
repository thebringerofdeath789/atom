package schemasMicrosoftComVml;

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

/* loaded from: classes6.dex */
public interface CTF extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTF.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctfbc3atype");

    public static final class Factory {
        private Factory() {
        }

        public static CTF newInstance() {
            return (CTF) XmlBeans.getContextTypeLoader().newInstance(CTF.type, null);
        }

        public static CTF newInstance(XmlOptions xmlOptions) {
            return (CTF) XmlBeans.getContextTypeLoader().newInstance(CTF.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTF.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTF.type, xmlOptions);
        }

        public static CTF parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTF) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTF.type, (XmlOptions) null);
        }

        public static CTF parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTF) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTF.type, xmlOptions);
        }

        public static CTF parse(File file) throws XmlException, IOException {
            return (CTF) XmlBeans.getContextTypeLoader().parse(file, CTF.type, (XmlOptions) null);
        }

        public static CTF parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTF) XmlBeans.getContextTypeLoader().parse(file, CTF.type, xmlOptions);
        }

        public static CTF parse(InputStream inputStream) throws XmlException, IOException {
            return (CTF) XmlBeans.getContextTypeLoader().parse(inputStream, CTF.type, (XmlOptions) null);
        }

        public static CTF parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTF) XmlBeans.getContextTypeLoader().parse(inputStream, CTF.type, xmlOptions);
        }

        public static CTF parse(Reader reader) throws XmlException, IOException {
            return (CTF) XmlBeans.getContextTypeLoader().parse(reader, CTF.type, (XmlOptions) null);
        }

        public static CTF parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTF) XmlBeans.getContextTypeLoader().parse(reader, CTF.type, xmlOptions);
        }

        public static CTF parse(String str) throws XmlException {
            return (CTF) XmlBeans.getContextTypeLoader().parse(str, CTF.type, (XmlOptions) null);
        }

        public static CTF parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTF) XmlBeans.getContextTypeLoader().parse(str, CTF.type, xmlOptions);
        }

        public static CTF parse(URL url) throws XmlException, IOException {
            return (CTF) XmlBeans.getContextTypeLoader().parse(url, CTF.type, (XmlOptions) null);
        }

        public static CTF parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTF) XmlBeans.getContextTypeLoader().parse(url, CTF.type, xmlOptions);
        }

        public static CTF parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTF) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTF.type, (XmlOptions) null);
        }

        public static CTF parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTF) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTF.type, xmlOptions);
        }

        public static CTF parse(Node node) throws XmlException {
            return (CTF) XmlBeans.getContextTypeLoader().parse(node, CTF.type, (XmlOptions) null);
        }

        public static CTF parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTF) XmlBeans.getContextTypeLoader().parse(node, CTF.type, xmlOptions);
        }
    }

    String getEqn();

    boolean isSetEqn();

    void setEqn(String str);

    void unsetEqn();

    XmlString xgetEqn();

    void xsetEqn(XmlString xmlString);
}
