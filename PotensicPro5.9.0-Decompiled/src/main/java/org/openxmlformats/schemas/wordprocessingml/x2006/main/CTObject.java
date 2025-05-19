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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTObject extends CTPictureBase {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTObject.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctobject47c9type");

    public static final class Factory {
        private Factory() {
        }

        public static CTObject newInstance() {
            return (CTObject) XmlBeans.getContextTypeLoader().newInstance(CTObject.type, null);
        }

        public static CTObject newInstance(XmlOptions xmlOptions) {
            return (CTObject) XmlBeans.getContextTypeLoader().newInstance(CTObject.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTObject.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTObject.type, xmlOptions);
        }

        public static CTObject parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTObject) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTObject.type, (XmlOptions) null);
        }

        public static CTObject parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTObject) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTObject.type, xmlOptions);
        }

        public static CTObject parse(File file) throws XmlException, IOException {
            return (CTObject) XmlBeans.getContextTypeLoader().parse(file, CTObject.type, (XmlOptions) null);
        }

        public static CTObject parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTObject) XmlBeans.getContextTypeLoader().parse(file, CTObject.type, xmlOptions);
        }

        public static CTObject parse(InputStream inputStream) throws XmlException, IOException {
            return (CTObject) XmlBeans.getContextTypeLoader().parse(inputStream, CTObject.type, (XmlOptions) null);
        }

        public static CTObject parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTObject) XmlBeans.getContextTypeLoader().parse(inputStream, CTObject.type, xmlOptions);
        }

        public static CTObject parse(Reader reader) throws XmlException, IOException {
            return (CTObject) XmlBeans.getContextTypeLoader().parse(reader, CTObject.type, (XmlOptions) null);
        }

        public static CTObject parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTObject) XmlBeans.getContextTypeLoader().parse(reader, CTObject.type, xmlOptions);
        }

        public static CTObject parse(String str) throws XmlException {
            return (CTObject) XmlBeans.getContextTypeLoader().parse(str, CTObject.type, (XmlOptions) null);
        }

        public static CTObject parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTObject) XmlBeans.getContextTypeLoader().parse(str, CTObject.type, xmlOptions);
        }

        public static CTObject parse(URL url) throws XmlException, IOException {
            return (CTObject) XmlBeans.getContextTypeLoader().parse(url, CTObject.type, (XmlOptions) null);
        }

        public static CTObject parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTObject) XmlBeans.getContextTypeLoader().parse(url, CTObject.type, xmlOptions);
        }

        public static CTObject parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTObject) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTObject.type, (XmlOptions) null);
        }

        public static CTObject parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTObject) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTObject.type, xmlOptions);
        }

        public static CTObject parse(Node node) throws XmlException {
            return (CTObject) XmlBeans.getContextTypeLoader().parse(node, CTObject.type, (XmlOptions) null);
        }

        public static CTObject parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTObject) XmlBeans.getContextTypeLoader().parse(node, CTObject.type, xmlOptions);
        }
    }

    CTControl addNewControl();

    CTControl getControl();

    BigInteger getDxaOrig();

    BigInteger getDyaOrig();

    boolean isSetControl();

    boolean isSetDxaOrig();

    boolean isSetDyaOrig();

    void setControl(CTControl cTControl);

    void setDxaOrig(BigInteger bigInteger);

    void setDyaOrig(BigInteger bigInteger);

    void unsetControl();

    void unsetDxaOrig();

    void unsetDyaOrig();

    STTwipsMeasure xgetDxaOrig();

    STTwipsMeasure xgetDyaOrig();

    void xsetDxaOrig(STTwipsMeasure sTTwipsMeasure);

    void xsetDyaOrig(STTwipsMeasure sTTwipsMeasure);
}
