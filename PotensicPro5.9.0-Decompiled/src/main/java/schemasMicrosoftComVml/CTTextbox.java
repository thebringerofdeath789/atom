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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent;
import org.w3c.dom.Node;
import schemasMicrosoftComOfficeOffice.STInsetMode;

/* loaded from: classes6.dex */
public interface CTTextbox extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTextbox.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttextboxf712type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextbox newInstance() {
            return (CTTextbox) XmlBeans.getContextTypeLoader().newInstance(CTTextbox.type, null);
        }

        public static CTTextbox newInstance(XmlOptions xmlOptions) {
            return (CTTextbox) XmlBeans.getContextTypeLoader().newInstance(CTTextbox.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextbox.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextbox.type, xmlOptions);
        }

        public static CTTextbox parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextbox) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextbox.type, (XmlOptions) null);
        }

        public static CTTextbox parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextbox) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextbox.type, xmlOptions);
        }

        public static CTTextbox parse(File file) throws XmlException, IOException {
            return (CTTextbox) XmlBeans.getContextTypeLoader().parse(file, CTTextbox.type, (XmlOptions) null);
        }

        public static CTTextbox parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextbox) XmlBeans.getContextTypeLoader().parse(file, CTTextbox.type, xmlOptions);
        }

        public static CTTextbox parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextbox) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextbox.type, (XmlOptions) null);
        }

        public static CTTextbox parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextbox) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextbox.type, xmlOptions);
        }

        public static CTTextbox parse(Reader reader) throws XmlException, IOException {
            return (CTTextbox) XmlBeans.getContextTypeLoader().parse(reader, CTTextbox.type, (XmlOptions) null);
        }

        public static CTTextbox parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextbox) XmlBeans.getContextTypeLoader().parse(reader, CTTextbox.type, xmlOptions);
        }

        public static CTTextbox parse(String str) throws XmlException {
            return (CTTextbox) XmlBeans.getContextTypeLoader().parse(str, CTTextbox.type, (XmlOptions) null);
        }

        public static CTTextbox parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextbox) XmlBeans.getContextTypeLoader().parse(str, CTTextbox.type, xmlOptions);
        }

        public static CTTextbox parse(URL url) throws XmlException, IOException {
            return (CTTextbox) XmlBeans.getContextTypeLoader().parse(url, CTTextbox.type, (XmlOptions) null);
        }

        public static CTTextbox parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextbox) XmlBeans.getContextTypeLoader().parse(url, CTTextbox.type, xmlOptions);
        }

        public static CTTextbox parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTextbox) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextbox.type, (XmlOptions) null);
        }

        public static CTTextbox parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTextbox) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextbox.type, xmlOptions);
        }

        public static CTTextbox parse(Node node) throws XmlException {
            return (CTTextbox) XmlBeans.getContextTypeLoader().parse(node, CTTextbox.type, (XmlOptions) null);
        }

        public static CTTextbox parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextbox) XmlBeans.getContextTypeLoader().parse(node, CTTextbox.type, xmlOptions);
        }
    }

    CTTxbxContent addNewTxbxContent();

    String getId();

    String getInset();

    STInsetMode.Enum getInsetmode();

    schemasMicrosoftComOfficeOffice.STTrueFalse$Enum getSingleclick();

    String getStyle();

    CTTxbxContent getTxbxContent();

    boolean isSetId();

    boolean isSetInset();

    boolean isSetInsetmode();

    boolean isSetSingleclick();

    boolean isSetStyle();

    boolean isSetTxbxContent();

    void setId(String str);

    void setInset(String str);

    void setInsetmode(STInsetMode.Enum r1);

    void setSingleclick(schemasMicrosoftComOfficeOffice.STTrueFalse$Enum sTTrueFalse$Enum);

    void setStyle(String str);

    void setTxbxContent(CTTxbxContent cTTxbxContent);

    void unsetId();

    void unsetInset();

    void unsetInsetmode();

    void unsetSingleclick();

    void unsetStyle();

    void unsetTxbxContent();

    XmlString xgetId();

    XmlString xgetInset();

    STInsetMode xgetInsetmode();

    schemasMicrosoftComOfficeOffice.STTrueFalse xgetSingleclick();

    XmlString xgetStyle();

    void xsetId(XmlString xmlString);

    void xsetInset(XmlString xmlString);

    void xsetInsetmode(STInsetMode sTInsetMode);

    void xsetSingleclick(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse);

    void xsetStyle(XmlString xmlString);
}
