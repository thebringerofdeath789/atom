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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLineSpacingRule;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTSpacing extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSpacing.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctspacingff2ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSpacing newInstance() {
            return (CTSpacing) XmlBeans.getContextTypeLoader().newInstance(CTSpacing.type, null);
        }

        public static CTSpacing newInstance(XmlOptions xmlOptions) {
            return (CTSpacing) XmlBeans.getContextTypeLoader().newInstance(CTSpacing.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSpacing.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSpacing.type, xmlOptions);
        }

        public static CTSpacing parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSpacing) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSpacing.type, (XmlOptions) null);
        }

        public static CTSpacing parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSpacing) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSpacing.type, xmlOptions);
        }

        public static CTSpacing parse(File file) throws XmlException, IOException {
            return (CTSpacing) XmlBeans.getContextTypeLoader().parse(file, CTSpacing.type, (XmlOptions) null);
        }

        public static CTSpacing parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSpacing) XmlBeans.getContextTypeLoader().parse(file, CTSpacing.type, xmlOptions);
        }

        public static CTSpacing parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSpacing) XmlBeans.getContextTypeLoader().parse(inputStream, CTSpacing.type, (XmlOptions) null);
        }

        public static CTSpacing parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSpacing) XmlBeans.getContextTypeLoader().parse(inputStream, CTSpacing.type, xmlOptions);
        }

        public static CTSpacing parse(Reader reader) throws XmlException, IOException {
            return (CTSpacing) XmlBeans.getContextTypeLoader().parse(reader, CTSpacing.type, (XmlOptions) null);
        }

        public static CTSpacing parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSpacing) XmlBeans.getContextTypeLoader().parse(reader, CTSpacing.type, xmlOptions);
        }

        public static CTSpacing parse(String str) throws XmlException {
            return (CTSpacing) XmlBeans.getContextTypeLoader().parse(str, CTSpacing.type, (XmlOptions) null);
        }

        public static CTSpacing parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSpacing) XmlBeans.getContextTypeLoader().parse(str, CTSpacing.type, xmlOptions);
        }

        public static CTSpacing parse(URL url) throws XmlException, IOException {
            return (CTSpacing) XmlBeans.getContextTypeLoader().parse(url, CTSpacing.type, (XmlOptions) null);
        }

        public static CTSpacing parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSpacing) XmlBeans.getContextTypeLoader().parse(url, CTSpacing.type, xmlOptions);
        }

        public static CTSpacing parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSpacing) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSpacing.type, (XmlOptions) null);
        }

        public static CTSpacing parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSpacing) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSpacing.type, xmlOptions);
        }

        public static CTSpacing parse(Node node) throws XmlException {
            return (CTSpacing) XmlBeans.getContextTypeLoader().parse(node, CTSpacing.type, (XmlOptions) null);
        }

        public static CTSpacing parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSpacing) XmlBeans.getContextTypeLoader().parse(node, CTSpacing.type, xmlOptions);
        }
    }

    BigInteger getAfter();

    STOnOff.Enum getAfterAutospacing();

    BigInteger getAfterLines();

    BigInteger getBefore();

    STOnOff.Enum getBeforeAutospacing();

    BigInteger getBeforeLines();

    BigInteger getLine();

    STLineSpacingRule.Enum getLineRule();

    boolean isSetAfter();

    boolean isSetAfterAutospacing();

    boolean isSetAfterLines();

    boolean isSetBefore();

    boolean isSetBeforeAutospacing();

    boolean isSetBeforeLines();

    boolean isSetLine();

    boolean isSetLineRule();

    void setAfter(BigInteger bigInteger);

    void setAfterAutospacing(STOnOff.Enum r1);

    void setAfterLines(BigInteger bigInteger);

    void setBefore(BigInteger bigInteger);

    void setBeforeAutospacing(STOnOff.Enum r1);

    void setBeforeLines(BigInteger bigInteger);

    void setLine(BigInteger bigInteger);

    void setLineRule(STLineSpacingRule.Enum r1);

    void unsetAfter();

    void unsetAfterAutospacing();

    void unsetAfterLines();

    void unsetBefore();

    void unsetBeforeAutospacing();

    void unsetBeforeLines();

    void unsetLine();

    void unsetLineRule();

    STTwipsMeasure xgetAfter();

    STOnOff xgetAfterAutospacing();

    STDecimalNumber xgetAfterLines();

    STTwipsMeasure xgetBefore();

    STOnOff xgetBeforeAutospacing();

    STDecimalNumber xgetBeforeLines();

    STSignedTwipsMeasure xgetLine();

    STLineSpacingRule xgetLineRule();

    void xsetAfter(STTwipsMeasure sTTwipsMeasure);

    void xsetAfterAutospacing(STOnOff sTOnOff);

    void xsetAfterLines(STDecimalNumber sTDecimalNumber);

    void xsetBefore(STTwipsMeasure sTTwipsMeasure);

    void xsetBeforeAutospacing(STOnOff sTOnOff);

    void xsetBeforeLines(STDecimalNumber sTDecimalNumber);

    void xsetLine(STSignedTwipsMeasure sTSignedTwipsMeasure);

    void xsetLineRule(STLineSpacingRule sTLineSpacingRule);
}
