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
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTInd extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTInd.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctind4b93type");

    public static final class Factory {
        private Factory() {
        }

        public static CTInd newInstance() {
            return (CTInd) XmlBeans.getContextTypeLoader().newInstance(CTInd.type, null);
        }

        public static CTInd newInstance(XmlOptions xmlOptions) {
            return (CTInd) XmlBeans.getContextTypeLoader().newInstance(CTInd.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTInd.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTInd.type, xmlOptions);
        }

        public static CTInd parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTInd) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTInd.type, (XmlOptions) null);
        }

        public static CTInd parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTInd) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTInd.type, xmlOptions);
        }

        public static CTInd parse(File file) throws XmlException, IOException {
            return (CTInd) XmlBeans.getContextTypeLoader().parse(file, CTInd.type, (XmlOptions) null);
        }

        public static CTInd parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTInd) XmlBeans.getContextTypeLoader().parse(file, CTInd.type, xmlOptions);
        }

        public static CTInd parse(InputStream inputStream) throws XmlException, IOException {
            return (CTInd) XmlBeans.getContextTypeLoader().parse(inputStream, CTInd.type, (XmlOptions) null);
        }

        public static CTInd parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTInd) XmlBeans.getContextTypeLoader().parse(inputStream, CTInd.type, xmlOptions);
        }

        public static CTInd parse(Reader reader) throws XmlException, IOException {
            return (CTInd) XmlBeans.getContextTypeLoader().parse(reader, CTInd.type, (XmlOptions) null);
        }

        public static CTInd parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTInd) XmlBeans.getContextTypeLoader().parse(reader, CTInd.type, xmlOptions);
        }

        public static CTInd parse(String str) throws XmlException {
            return (CTInd) XmlBeans.getContextTypeLoader().parse(str, CTInd.type, (XmlOptions) null);
        }

        public static CTInd parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTInd) XmlBeans.getContextTypeLoader().parse(str, CTInd.type, xmlOptions);
        }

        public static CTInd parse(URL url) throws XmlException, IOException {
            return (CTInd) XmlBeans.getContextTypeLoader().parse(url, CTInd.type, (XmlOptions) null);
        }

        public static CTInd parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTInd) XmlBeans.getContextTypeLoader().parse(url, CTInd.type, xmlOptions);
        }

        public static CTInd parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTInd) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTInd.type, (XmlOptions) null);
        }

        public static CTInd parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTInd) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTInd.type, xmlOptions);
        }

        public static CTInd parse(Node node) throws XmlException {
            return (CTInd) XmlBeans.getContextTypeLoader().parse(node, CTInd.type, (XmlOptions) null);
        }

        public static CTInd parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTInd) XmlBeans.getContextTypeLoader().parse(node, CTInd.type, xmlOptions);
        }
    }

    BigInteger getFirstLine();

    BigInteger getFirstLineChars();

    BigInteger getHanging();

    BigInteger getHangingChars();

    BigInteger getLeft();

    BigInteger getLeftChars();

    BigInteger getRight();

    BigInteger getRightChars();

    boolean isSetFirstLine();

    boolean isSetFirstLineChars();

    boolean isSetHanging();

    boolean isSetHangingChars();

    boolean isSetLeft();

    boolean isSetLeftChars();

    boolean isSetRight();

    boolean isSetRightChars();

    void setFirstLine(BigInteger bigInteger);

    void setFirstLineChars(BigInteger bigInteger);

    void setHanging(BigInteger bigInteger);

    void setHangingChars(BigInteger bigInteger);

    void setLeft(BigInteger bigInteger);

    void setLeftChars(BigInteger bigInteger);

    void setRight(BigInteger bigInteger);

    void setRightChars(BigInteger bigInteger);

    void unsetFirstLine();

    void unsetFirstLineChars();

    void unsetHanging();

    void unsetHangingChars();

    void unsetLeft();

    void unsetLeftChars();

    void unsetRight();

    void unsetRightChars();

    STTwipsMeasure xgetFirstLine();

    STDecimalNumber xgetFirstLineChars();

    STTwipsMeasure xgetHanging();

    STDecimalNumber xgetHangingChars();

    STSignedTwipsMeasure xgetLeft();

    STDecimalNumber xgetLeftChars();

    STSignedTwipsMeasure xgetRight();

    STDecimalNumber xgetRightChars();

    void xsetFirstLine(STTwipsMeasure sTTwipsMeasure);

    void xsetFirstLineChars(STDecimalNumber sTDecimalNumber);

    void xsetHanging(STTwipsMeasure sTTwipsMeasure);

    void xsetHangingChars(STDecimalNumber sTDecimalNumber);

    void xsetLeft(STSignedTwipsMeasure sTSignedTwipsMeasure);

    void xsetLeftChars(STDecimalNumber sTDecimalNumber);

    void xsetRight(STSignedTwipsMeasure sTSignedTwipsMeasure);

    void xsetRightChars(STDecimalNumber sTDecimalNumber);
}
