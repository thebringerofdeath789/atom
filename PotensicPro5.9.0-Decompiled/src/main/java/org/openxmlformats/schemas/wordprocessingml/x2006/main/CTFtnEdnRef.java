package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
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
public interface CTFtnEdnRef extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTFtnEdnRef.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctftnednref89eetype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFtnEdnRef newInstance() {
            return (CTFtnEdnRef) XmlBeans.getContextTypeLoader().newInstance(CTFtnEdnRef.type, null);
        }

        public static CTFtnEdnRef newInstance(XmlOptions xmlOptions) {
            return (CTFtnEdnRef) XmlBeans.getContextTypeLoader().newInstance(CTFtnEdnRef.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFtnEdnRef.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFtnEdnRef.type, xmlOptions);
        }

        public static CTFtnEdnRef parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFtnEdnRef) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFtnEdnRef.type, (XmlOptions) null);
        }

        public static CTFtnEdnRef parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFtnEdnRef) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFtnEdnRef.type, xmlOptions);
        }

        public static CTFtnEdnRef parse(File file) throws XmlException, IOException {
            return (CTFtnEdnRef) XmlBeans.getContextTypeLoader().parse(file, CTFtnEdnRef.type, (XmlOptions) null);
        }

        public static CTFtnEdnRef parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFtnEdnRef) XmlBeans.getContextTypeLoader().parse(file, CTFtnEdnRef.type, xmlOptions);
        }

        public static CTFtnEdnRef parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFtnEdnRef) XmlBeans.getContextTypeLoader().parse(inputStream, CTFtnEdnRef.type, (XmlOptions) null);
        }

        public static CTFtnEdnRef parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFtnEdnRef) XmlBeans.getContextTypeLoader().parse(inputStream, CTFtnEdnRef.type, xmlOptions);
        }

        public static CTFtnEdnRef parse(Reader reader) throws XmlException, IOException {
            return (CTFtnEdnRef) XmlBeans.getContextTypeLoader().parse(reader, CTFtnEdnRef.type, (XmlOptions) null);
        }

        public static CTFtnEdnRef parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFtnEdnRef) XmlBeans.getContextTypeLoader().parse(reader, CTFtnEdnRef.type, xmlOptions);
        }

        public static CTFtnEdnRef parse(String str) throws XmlException {
            return (CTFtnEdnRef) XmlBeans.getContextTypeLoader().parse(str, CTFtnEdnRef.type, (XmlOptions) null);
        }

        public static CTFtnEdnRef parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFtnEdnRef) XmlBeans.getContextTypeLoader().parse(str, CTFtnEdnRef.type, xmlOptions);
        }

        public static CTFtnEdnRef parse(URL url) throws XmlException, IOException {
            return (CTFtnEdnRef) XmlBeans.getContextTypeLoader().parse(url, CTFtnEdnRef.type, (XmlOptions) null);
        }

        public static CTFtnEdnRef parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFtnEdnRef) XmlBeans.getContextTypeLoader().parse(url, CTFtnEdnRef.type, xmlOptions);
        }

        public static CTFtnEdnRef parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTFtnEdnRef) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFtnEdnRef.type, (XmlOptions) null);
        }

        public static CTFtnEdnRef parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTFtnEdnRef) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFtnEdnRef.type, xmlOptions);
        }

        public static CTFtnEdnRef parse(Node node) throws XmlException {
            return (CTFtnEdnRef) XmlBeans.getContextTypeLoader().parse(node, CTFtnEdnRef.type, (XmlOptions) null);
        }

        public static CTFtnEdnRef parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFtnEdnRef) XmlBeans.getContextTypeLoader().parse(node, CTFtnEdnRef.type, xmlOptions);
        }
    }

    STOnOff.Enum getCustomMarkFollows();

    BigInteger getId();

    boolean isSetCustomMarkFollows();

    void setCustomMarkFollows(STOnOff.Enum r1);

    void setId(BigInteger bigInteger);

    void unsetCustomMarkFollows();

    STOnOff xgetCustomMarkFollows();

    STDecimalNumber xgetId();

    void xsetCustomMarkFollows(STOnOff sTOnOff);

    void xsetId(STDecimalNumber sTDecimalNumber);
}
