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
public interface CTHandles extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTHandles.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cthandles5c1ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTHandles newInstance() {
            return (CTHandles) XmlBeans.getContextTypeLoader().newInstance(CTHandles.type, null);
        }

        public static CTHandles newInstance(XmlOptions xmlOptions) {
            return (CTHandles) XmlBeans.getContextTypeLoader().newInstance(CTHandles.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTHandles.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTHandles.type, xmlOptions);
        }

        public static CTHandles parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTHandles) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTHandles.type, (XmlOptions) null);
        }

        public static CTHandles parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTHandles) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTHandles.type, xmlOptions);
        }

        public static CTHandles parse(File file) throws XmlException, IOException {
            return (CTHandles) XmlBeans.getContextTypeLoader().parse(file, CTHandles.type, (XmlOptions) null);
        }

        public static CTHandles parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHandles) XmlBeans.getContextTypeLoader().parse(file, CTHandles.type, xmlOptions);
        }

        public static CTHandles parse(InputStream inputStream) throws XmlException, IOException {
            return (CTHandles) XmlBeans.getContextTypeLoader().parse(inputStream, CTHandles.type, (XmlOptions) null);
        }

        public static CTHandles parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHandles) XmlBeans.getContextTypeLoader().parse(inputStream, CTHandles.type, xmlOptions);
        }

        public static CTHandles parse(Reader reader) throws XmlException, IOException {
            return (CTHandles) XmlBeans.getContextTypeLoader().parse(reader, CTHandles.type, (XmlOptions) null);
        }

        public static CTHandles parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHandles) XmlBeans.getContextTypeLoader().parse(reader, CTHandles.type, xmlOptions);
        }

        public static CTHandles parse(String str) throws XmlException {
            return (CTHandles) XmlBeans.getContextTypeLoader().parse(str, CTHandles.type, (XmlOptions) null);
        }

        public static CTHandles parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTHandles) XmlBeans.getContextTypeLoader().parse(str, CTHandles.type, xmlOptions);
        }

        public static CTHandles parse(URL url) throws XmlException, IOException {
            return (CTHandles) XmlBeans.getContextTypeLoader().parse(url, CTHandles.type, (XmlOptions) null);
        }

        public static CTHandles parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHandles) XmlBeans.getContextTypeLoader().parse(url, CTHandles.type, xmlOptions);
        }

        public static CTHandles parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTHandles) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTHandles.type, (XmlOptions) null);
        }

        public static CTHandles parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTHandles) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTHandles.type, xmlOptions);
        }

        public static CTHandles parse(Node node) throws XmlException {
            return (CTHandles) XmlBeans.getContextTypeLoader().parse(node, CTHandles.type, (XmlOptions) null);
        }

        public static CTHandles parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTHandles) XmlBeans.getContextTypeLoader().parse(node, CTHandles.type, xmlOptions);
        }
    }

    CTH addNewH();

    CTH getHArray(int i);

    CTH[] getHArray();

    List<CTH> getHList();

    CTH insertNewH(int i);

    void removeH(int i);

    void setHArray(int i, CTH cth);

    void setHArray(CTH[] cthArr);

    int sizeOfHArray();
}
