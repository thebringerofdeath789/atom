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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STUnderline;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTUnderline extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTUnderline.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctunderline8406type");

    public static final class Factory {
        private Factory() {
        }

        public static CTUnderline newInstance() {
            return (CTUnderline) XmlBeans.getContextTypeLoader().newInstance(CTUnderline.type, null);
        }

        public static CTUnderline newInstance(XmlOptions xmlOptions) {
            return (CTUnderline) XmlBeans.getContextTypeLoader().newInstance(CTUnderline.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTUnderline.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTUnderline.type, xmlOptions);
        }

        public static CTUnderline parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTUnderline) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTUnderline.type, (XmlOptions) null);
        }

        public static CTUnderline parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTUnderline) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTUnderline.type, xmlOptions);
        }

        public static CTUnderline parse(File file) throws XmlException, IOException {
            return (CTUnderline) XmlBeans.getContextTypeLoader().parse(file, CTUnderline.type, (XmlOptions) null);
        }

        public static CTUnderline parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTUnderline) XmlBeans.getContextTypeLoader().parse(file, CTUnderline.type, xmlOptions);
        }

        public static CTUnderline parse(InputStream inputStream) throws XmlException, IOException {
            return (CTUnderline) XmlBeans.getContextTypeLoader().parse(inputStream, CTUnderline.type, (XmlOptions) null);
        }

        public static CTUnderline parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTUnderline) XmlBeans.getContextTypeLoader().parse(inputStream, CTUnderline.type, xmlOptions);
        }

        public static CTUnderline parse(Reader reader) throws XmlException, IOException {
            return (CTUnderline) XmlBeans.getContextTypeLoader().parse(reader, CTUnderline.type, (XmlOptions) null);
        }

        public static CTUnderline parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTUnderline) XmlBeans.getContextTypeLoader().parse(reader, CTUnderline.type, xmlOptions);
        }

        public static CTUnderline parse(String str) throws XmlException {
            return (CTUnderline) XmlBeans.getContextTypeLoader().parse(str, CTUnderline.type, (XmlOptions) null);
        }

        public static CTUnderline parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTUnderline) XmlBeans.getContextTypeLoader().parse(str, CTUnderline.type, xmlOptions);
        }

        public static CTUnderline parse(URL url) throws XmlException, IOException {
            return (CTUnderline) XmlBeans.getContextTypeLoader().parse(url, CTUnderline.type, (XmlOptions) null);
        }

        public static CTUnderline parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTUnderline) XmlBeans.getContextTypeLoader().parse(url, CTUnderline.type, xmlOptions);
        }

        public static CTUnderline parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTUnderline) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTUnderline.type, (XmlOptions) null);
        }

        public static CTUnderline parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTUnderline) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTUnderline.type, xmlOptions);
        }

        public static CTUnderline parse(Node node) throws XmlException {
            return (CTUnderline) XmlBeans.getContextTypeLoader().parse(node, CTUnderline.type, (XmlOptions) null);
        }

        public static CTUnderline parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTUnderline) XmlBeans.getContextTypeLoader().parse(node, CTUnderline.type, xmlOptions);
        }
    }

    Object getColor();

    STThemeColor$Enum getThemeColor();

    byte[] getThemeShade();

    byte[] getThemeTint();

    STUnderline.Enum getVal();

    boolean isSetColor();

    boolean isSetThemeColor();

    boolean isSetThemeShade();

    boolean isSetThemeTint();

    boolean isSetVal();

    void setColor(Object obj);

    void setThemeColor(STThemeColor$Enum sTThemeColor$Enum);

    void setThemeShade(byte[] bArr);

    void setThemeTint(byte[] bArr);

    void setVal(STUnderline.Enum r1);

    void unsetColor();

    void unsetThemeColor();

    void unsetThemeShade();

    void unsetThemeTint();

    void unsetVal();

    STHexColor xgetColor();

    STThemeColor xgetThemeColor();

    STUcharHexNumber xgetThemeShade();

    STUcharHexNumber xgetThemeTint();

    STUnderline xgetVal();

    void xsetColor(STHexColor sTHexColor);

    void xsetThemeColor(STThemeColor sTThemeColor);

    void xsetThemeShade(STUcharHexNumber sTUcharHexNumber);

    void xsetThemeTint(STUcharHexNumber sTUcharHexNumber);

    void xsetVal(STUnderline sTUnderline);
}
