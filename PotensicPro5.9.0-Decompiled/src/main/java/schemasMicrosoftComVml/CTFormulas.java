package schemasMicrosoftComVml;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTFormulas extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTFormulas.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctformulas808btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFormulas newInstance() {
            return (CTFormulas) XmlBeans.getContextTypeLoader().newInstance(CTFormulas.type, null);
        }

        public static CTFormulas newInstance(XmlOptions xmlOptions) {
            return (CTFormulas) XmlBeans.getContextTypeLoader().newInstance(CTFormulas.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFormulas.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFormulas.type, xmlOptions);
        }

        public static CTFormulas parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFormulas) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFormulas) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFormulas.type, xmlOptions);
        }

        public static CTFormulas parse(File file) throws XmlException, IOException {
            return (CTFormulas) XmlBeans.getContextTypeLoader().parse(file, CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFormulas) XmlBeans.getContextTypeLoader().parse(file, CTFormulas.type, xmlOptions);
        }

        public static CTFormulas parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFormulas) XmlBeans.getContextTypeLoader().parse(inputStream, CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFormulas) XmlBeans.getContextTypeLoader().parse(inputStream, CTFormulas.type, xmlOptions);
        }

        public static CTFormulas parse(Reader reader) throws XmlException, IOException {
            return (CTFormulas) XmlBeans.getContextTypeLoader().parse(reader, CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFormulas) XmlBeans.getContextTypeLoader().parse(reader, CTFormulas.type, xmlOptions);
        }

        public static CTFormulas parse(String str) throws XmlException {
            return (CTFormulas) XmlBeans.getContextTypeLoader().parse(str, CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFormulas) XmlBeans.getContextTypeLoader().parse(str, CTFormulas.type, xmlOptions);
        }

        public static CTFormulas parse(URL url) throws XmlException, IOException {
            return (CTFormulas) XmlBeans.getContextTypeLoader().parse(url, CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFormulas) XmlBeans.getContextTypeLoader().parse(url, CTFormulas.type, xmlOptions);
        }

        public static CTFormulas parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTFormulas) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTFormulas) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFormulas.type, xmlOptions);
        }

        public static CTFormulas parse(Node node) throws XmlException {
            return (CTFormulas) XmlBeans.getContextTypeLoader().parse(node, CTFormulas.type, (XmlOptions) null);
        }

        public static CTFormulas parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFormulas) XmlBeans.getContextTypeLoader().parse(node, CTFormulas.type, xmlOptions);
        }
    }

    CTF addNewF();

    CTF getFArray(int i);

    CTF[] getFArray();

    List<CTF> getFList();

    CTF insertNewF(int i);

    void removeF(int i);

    void setFArray(int i, CTF ctf);

    void setFArray(CTF[] ctfArr);

    int sizeOfFArray();
}
