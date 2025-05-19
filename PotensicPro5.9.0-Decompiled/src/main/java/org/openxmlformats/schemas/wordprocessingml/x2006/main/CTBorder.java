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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTBorder extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTBorder.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctbordercdfctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTBorder newInstance() {
            return (CTBorder) XmlBeans.getContextTypeLoader().newInstance(CTBorder.type, null);
        }

        public static CTBorder newInstance(XmlOptions xmlOptions) {
            return (CTBorder) XmlBeans.getContextTypeLoader().newInstance(CTBorder.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTBorder.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTBorder) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTBorder) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(File file) throws XmlException, IOException {
            return (CTBorder) XmlBeans.getContextTypeLoader().parse(file, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBorder) XmlBeans.getContextTypeLoader().parse(file, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(InputStream inputStream) throws XmlException, IOException {
            return (CTBorder) XmlBeans.getContextTypeLoader().parse(inputStream, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBorder) XmlBeans.getContextTypeLoader().parse(inputStream, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(Reader reader) throws XmlException, IOException {
            return (CTBorder) XmlBeans.getContextTypeLoader().parse(reader, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBorder) XmlBeans.getContextTypeLoader().parse(reader, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(String str) throws XmlException {
            return (CTBorder) XmlBeans.getContextTypeLoader().parse(str, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTBorder) XmlBeans.getContextTypeLoader().parse(str, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(URL url) throws XmlException, IOException {
            return (CTBorder) XmlBeans.getContextTypeLoader().parse(url, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBorder) XmlBeans.getContextTypeLoader().parse(url, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTBorder) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTBorder) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(Node node) throws XmlException {
            return (CTBorder) XmlBeans.getContextTypeLoader().parse(node, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTBorder) XmlBeans.getContextTypeLoader().parse(node, CTBorder.type, xmlOptions);
        }
    }

    Object getColor();

    STOnOff.Enum getFrame();

    STOnOff.Enum getShadow();

    BigInteger getSpace();

    BigInteger getSz();

    STThemeColor$Enum getThemeColor();

    byte[] getThemeShade();

    byte[] getThemeTint();

    STBorder.Enum getVal();

    boolean isSetColor();

    boolean isSetFrame();

    boolean isSetShadow();

    boolean isSetSpace();

    boolean isSetSz();

    boolean isSetThemeColor();

    boolean isSetThemeShade();

    boolean isSetThemeTint();

    void setColor(Object obj);

    void setFrame(STOnOff.Enum r1);

    void setShadow(STOnOff.Enum r1);

    void setSpace(BigInteger bigInteger);

    void setSz(BigInteger bigInteger);

    void setThemeColor(STThemeColor$Enum sTThemeColor$Enum);

    void setThemeShade(byte[] bArr);

    void setThemeTint(byte[] bArr);

    void setVal(STBorder.Enum r1);

    void unsetColor();

    void unsetFrame();

    void unsetShadow();

    void unsetSpace();

    void unsetSz();

    void unsetThemeColor();

    void unsetThemeShade();

    void unsetThemeTint();

    STHexColor xgetColor();

    STOnOff xgetFrame();

    STOnOff xgetShadow();

    STPointMeasure xgetSpace();

    STEighthPointMeasure xgetSz();

    STThemeColor xgetThemeColor();

    STUcharHexNumber xgetThemeShade();

    STUcharHexNumber xgetThemeTint();

    STBorder xgetVal();

    void xsetColor(STHexColor sTHexColor);

    void xsetFrame(STOnOff sTOnOff);

    void xsetShadow(STOnOff sTOnOff);

    void xsetSpace(STPointMeasure sTPointMeasure);

    void xsetSz(STEighthPointMeasure sTEighthPointMeasure);

    void xsetThemeColor(STThemeColor sTThemeColor);

    void xsetThemeShade(STUcharHexNumber sTUcharHexNumber);

    void xsetThemeTint(STUcharHexNumber sTUcharHexNumber);

    void xsetVal(STBorder sTBorder);
}
