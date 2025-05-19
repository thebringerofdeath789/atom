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
import org.w3c.dom.Node;
import schemasMicrosoftComVml.STTrueFalse;

/* loaded from: classes6.dex */
public interface CTH extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTH.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cth4cbctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTH newInstance() {
            return (CTH) XmlBeans.getContextTypeLoader().newInstance(CTH.type, null);
        }

        public static CTH newInstance(XmlOptions xmlOptions) {
            return (CTH) XmlBeans.getContextTypeLoader().newInstance(CTH.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTH.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTH.type, xmlOptions);
        }

        public static CTH parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTH) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTH.type, (XmlOptions) null);
        }

        public static CTH parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTH) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTH.type, xmlOptions);
        }

        public static CTH parse(File file) throws XmlException, IOException {
            return (CTH) XmlBeans.getContextTypeLoader().parse(file, CTH.type, (XmlOptions) null);
        }

        public static CTH parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTH) XmlBeans.getContextTypeLoader().parse(file, CTH.type, xmlOptions);
        }

        public static CTH parse(InputStream inputStream) throws XmlException, IOException {
            return (CTH) XmlBeans.getContextTypeLoader().parse(inputStream, CTH.type, (XmlOptions) null);
        }

        public static CTH parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTH) XmlBeans.getContextTypeLoader().parse(inputStream, CTH.type, xmlOptions);
        }

        public static CTH parse(Reader reader) throws XmlException, IOException {
            return (CTH) XmlBeans.getContextTypeLoader().parse(reader, CTH.type, (XmlOptions) null);
        }

        public static CTH parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTH) XmlBeans.getContextTypeLoader().parse(reader, CTH.type, xmlOptions);
        }

        public static CTH parse(String str) throws XmlException {
            return (CTH) XmlBeans.getContextTypeLoader().parse(str, CTH.type, (XmlOptions) null);
        }

        public static CTH parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTH) XmlBeans.getContextTypeLoader().parse(str, CTH.type, xmlOptions);
        }

        public static CTH parse(URL url) throws XmlException, IOException {
            return (CTH) XmlBeans.getContextTypeLoader().parse(url, CTH.type, (XmlOptions) null);
        }

        public static CTH parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTH) XmlBeans.getContextTypeLoader().parse(url, CTH.type, xmlOptions);
        }

        public static CTH parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTH) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTH.type, (XmlOptions) null);
        }

        public static CTH parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTH) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTH.type, xmlOptions);
        }

        public static CTH parse(Node node) throws XmlException {
            return (CTH) XmlBeans.getContextTypeLoader().parse(node, CTH.type, (XmlOptions) null);
        }

        public static CTH parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTH) XmlBeans.getContextTypeLoader().parse(node, CTH.type, xmlOptions);
        }
    }

    STTrueFalse.Enum getInvx();

    STTrueFalse.Enum getInvy();

    String getMap();

    String getPolar();

    String getPosition();

    String getRadiusrange();

    STTrueFalseBlank$Enum getSwitch();

    String getXrange();

    String getYrange();

    boolean isSetInvx();

    boolean isSetInvy();

    boolean isSetMap();

    boolean isSetPolar();

    boolean isSetPosition();

    boolean isSetRadiusrange();

    boolean isSetSwitch();

    boolean isSetXrange();

    boolean isSetYrange();

    void setInvx(STTrueFalse.Enum r1);

    void setInvy(STTrueFalse.Enum r1);

    void setMap(String str);

    void setPolar(String str);

    void setPosition(String str);

    void setRadiusrange(String str);

    void setSwitch(STTrueFalseBlank$Enum sTTrueFalseBlank$Enum);

    void setXrange(String str);

    void setYrange(String str);

    void unsetInvx();

    void unsetInvy();

    void unsetMap();

    void unsetPolar();

    void unsetPosition();

    void unsetRadiusrange();

    void unsetSwitch();

    void unsetXrange();

    void unsetYrange();

    STTrueFalse xgetInvx();

    STTrueFalse xgetInvy();

    XmlString xgetMap();

    XmlString xgetPolar();

    XmlString xgetPosition();

    XmlString xgetRadiusrange();

    STTrueFalseBlank xgetSwitch();

    XmlString xgetXrange();

    XmlString xgetYrange();

    void xsetInvx(STTrueFalse sTTrueFalse);

    void xsetInvy(STTrueFalse sTTrueFalse);

    void xsetMap(XmlString xmlString);

    void xsetPolar(XmlString xmlString);

    void xsetPosition(XmlString xmlString);

    void xsetRadiusrange(XmlString xmlString);

    void xsetSwitch(STTrueFalseBlank sTTrueFalseBlank);

    void xsetXrange(XmlString xmlString);

    void xsetYrange(XmlString xmlString);
}
