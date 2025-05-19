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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTShd extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTShd.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctshd58c3type");

    public static final class Factory {
        private Factory() {
        }

        public static CTShd newInstance() {
            return (CTShd) XmlBeans.getContextTypeLoader().newInstance(CTShd.type, null);
        }

        public static CTShd newInstance(XmlOptions xmlOptions) {
            return (CTShd) XmlBeans.getContextTypeLoader().newInstance(CTShd.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTShd.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTShd.type, xmlOptions);
        }

        public static CTShd parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTShd) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTShd.type, (XmlOptions) null);
        }

        public static CTShd parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTShd) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTShd.type, xmlOptions);
        }

        public static CTShd parse(File file) throws XmlException, IOException {
            return (CTShd) XmlBeans.getContextTypeLoader().parse(file, CTShd.type, (XmlOptions) null);
        }

        public static CTShd parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShd) XmlBeans.getContextTypeLoader().parse(file, CTShd.type, xmlOptions);
        }

        public static CTShd parse(InputStream inputStream) throws XmlException, IOException {
            return (CTShd) XmlBeans.getContextTypeLoader().parse(inputStream, CTShd.type, (XmlOptions) null);
        }

        public static CTShd parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShd) XmlBeans.getContextTypeLoader().parse(inputStream, CTShd.type, xmlOptions);
        }

        public static CTShd parse(Reader reader) throws XmlException, IOException {
            return (CTShd) XmlBeans.getContextTypeLoader().parse(reader, CTShd.type, (XmlOptions) null);
        }

        public static CTShd parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShd) XmlBeans.getContextTypeLoader().parse(reader, CTShd.type, xmlOptions);
        }

        public static CTShd parse(String str) throws XmlException {
            return (CTShd) XmlBeans.getContextTypeLoader().parse(str, CTShd.type, (XmlOptions) null);
        }

        public static CTShd parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTShd) XmlBeans.getContextTypeLoader().parse(str, CTShd.type, xmlOptions);
        }

        public static CTShd parse(URL url) throws XmlException, IOException {
            return (CTShd) XmlBeans.getContextTypeLoader().parse(url, CTShd.type, (XmlOptions) null);
        }

        public static CTShd parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTShd) XmlBeans.getContextTypeLoader().parse(url, CTShd.type, xmlOptions);
        }

        public static CTShd parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTShd) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTShd.type, (XmlOptions) null);
        }

        public static CTShd parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTShd) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTShd.type, xmlOptions);
        }

        public static CTShd parse(Node node) throws XmlException {
            return (CTShd) XmlBeans.getContextTypeLoader().parse(node, CTShd.type, (XmlOptions) null);
        }

        public static CTShd parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTShd) XmlBeans.getContextTypeLoader().parse(node, CTShd.type, xmlOptions);
        }
    }

    Object getColor();

    Object getFill();

    STThemeColor$Enum getThemeColor();

    STThemeColor$Enum getThemeFill();

    byte[] getThemeFillShade();

    byte[] getThemeFillTint();

    byte[] getThemeShade();

    byte[] getThemeTint();

    STShd.Enum getVal();

    boolean isSetColor();

    boolean isSetFill();

    boolean isSetThemeColor();

    boolean isSetThemeFill();

    boolean isSetThemeFillShade();

    boolean isSetThemeFillTint();

    boolean isSetThemeShade();

    boolean isSetThemeTint();

    void setColor(Object obj);

    void setFill(Object obj);

    void setThemeColor(STThemeColor$Enum sTThemeColor$Enum);

    void setThemeFill(STThemeColor$Enum sTThemeColor$Enum);

    void setThemeFillShade(byte[] bArr);

    void setThemeFillTint(byte[] bArr);

    void setThemeShade(byte[] bArr);

    void setThemeTint(byte[] bArr);

    void setVal(STShd.Enum r1);

    void unsetColor();

    void unsetFill();

    void unsetThemeColor();

    void unsetThemeFill();

    void unsetThemeFillShade();

    void unsetThemeFillTint();

    void unsetThemeShade();

    void unsetThemeTint();

    STHexColor xgetColor();

    STHexColor xgetFill();

    STThemeColor xgetThemeColor();

    STThemeColor xgetThemeFill();

    STUcharHexNumber xgetThemeFillShade();

    STUcharHexNumber xgetThemeFillTint();

    STUcharHexNumber xgetThemeShade();

    STUcharHexNumber xgetThemeTint();

    STShd xgetVal();

    void xsetColor(STHexColor sTHexColor);

    void xsetFill(STHexColor sTHexColor);

    void xsetThemeColor(STThemeColor sTThemeColor);

    void xsetThemeFill(STThemeColor sTThemeColor);

    void xsetThemeFillShade(STUcharHexNumber sTUcharHexNumber);

    void xsetThemeFillTint(STUcharHexNumber sTUcharHexNumber);

    void xsetThemeShade(STUcharHexNumber sTUcharHexNumber);

    void xsetThemeTint(STUcharHexNumber sTUcharHexNumber);

    void xsetVal(STShd sTShd);
}
