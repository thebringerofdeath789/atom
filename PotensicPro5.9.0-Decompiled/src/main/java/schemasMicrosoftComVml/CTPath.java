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
import schemasMicrosoftComOfficeOffice.STConnectType;
import schemasMicrosoftComVml.STTrueFalse;

/* loaded from: classes6.dex */
public interface CTPath extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPath.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpath5963type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPath newInstance() {
            return (CTPath) XmlBeans.getContextTypeLoader().newInstance(CTPath.type, null);
        }

        public static CTPath newInstance(XmlOptions xmlOptions) {
            return (CTPath) XmlBeans.getContextTypeLoader().newInstance(CTPath.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPath.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPath.type, xmlOptions);
        }

        public static CTPath parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPath) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPath.type, (XmlOptions) null);
        }

        public static CTPath parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPath) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPath.type, xmlOptions);
        }

        public static CTPath parse(File file) throws XmlException, IOException {
            return (CTPath) XmlBeans.getContextTypeLoader().parse(file, CTPath.type, (XmlOptions) null);
        }

        public static CTPath parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath) XmlBeans.getContextTypeLoader().parse(file, CTPath.type, xmlOptions);
        }

        public static CTPath parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPath) XmlBeans.getContextTypeLoader().parse(inputStream, CTPath.type, (XmlOptions) null);
        }

        public static CTPath parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath) XmlBeans.getContextTypeLoader().parse(inputStream, CTPath.type, xmlOptions);
        }

        public static CTPath parse(Reader reader) throws XmlException, IOException {
            return (CTPath) XmlBeans.getContextTypeLoader().parse(reader, CTPath.type, (XmlOptions) null);
        }

        public static CTPath parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath) XmlBeans.getContextTypeLoader().parse(reader, CTPath.type, xmlOptions);
        }

        public static CTPath parse(String str) throws XmlException {
            return (CTPath) XmlBeans.getContextTypeLoader().parse(str, CTPath.type, (XmlOptions) null);
        }

        public static CTPath parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPath) XmlBeans.getContextTypeLoader().parse(str, CTPath.type, xmlOptions);
        }

        public static CTPath parse(URL url) throws XmlException, IOException {
            return (CTPath) XmlBeans.getContextTypeLoader().parse(url, CTPath.type, (XmlOptions) null);
        }

        public static CTPath parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath) XmlBeans.getContextTypeLoader().parse(url, CTPath.type, xmlOptions);
        }

        public static CTPath parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPath) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPath.type, (XmlOptions) null);
        }

        public static CTPath parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPath) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPath.type, xmlOptions);
        }

        public static CTPath parse(Node node) throws XmlException {
            return (CTPath) XmlBeans.getContextTypeLoader().parse(node, CTPath.type, (XmlOptions) null);
        }

        public static CTPath parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPath) XmlBeans.getContextTypeLoader().parse(node, CTPath.type, xmlOptions);
        }
    }

    STTrueFalse.Enum getArrowok();

    String getConnectangles();

    String getConnectlocs();

    STConnectType.Enum getConnecttype();

    schemasMicrosoftComOfficeOffice.STTrueFalse$Enum getExtrusionok();

    STTrueFalse.Enum getFillok();

    STTrueFalse.Enum getGradientshapeok();

    String getId();

    STTrueFalse.Enum getInsetpenok();

    String getLimo();

    STTrueFalse.Enum getShadowok();

    STTrueFalse.Enum getStrokeok();

    String getTextboxrect();

    STTrueFalse.Enum getTextpathok();

    String getV();

    boolean isSetArrowok();

    boolean isSetConnectangles();

    boolean isSetConnectlocs();

    boolean isSetConnecttype();

    boolean isSetExtrusionok();

    boolean isSetFillok();

    boolean isSetGradientshapeok();

    boolean isSetId();

    boolean isSetInsetpenok();

    boolean isSetLimo();

    boolean isSetShadowok();

    boolean isSetStrokeok();

    boolean isSetTextboxrect();

    boolean isSetTextpathok();

    boolean isSetV();

    void setArrowok(STTrueFalse.Enum r1);

    void setConnectangles(String str);

    void setConnectlocs(String str);

    void setConnecttype(STConnectType.Enum r1);

    void setExtrusionok(schemasMicrosoftComOfficeOffice.STTrueFalse$Enum sTTrueFalse$Enum);

    void setFillok(STTrueFalse.Enum r1);

    void setGradientshapeok(STTrueFalse.Enum r1);

    void setId(String str);

    void setInsetpenok(STTrueFalse.Enum r1);

    void setLimo(String str);

    void setShadowok(STTrueFalse.Enum r1);

    void setStrokeok(STTrueFalse.Enum r1);

    void setTextboxrect(String str);

    void setTextpathok(STTrueFalse.Enum r1);

    void setV(String str);

    void unsetArrowok();

    void unsetConnectangles();

    void unsetConnectlocs();

    void unsetConnecttype();

    void unsetExtrusionok();

    void unsetFillok();

    void unsetGradientshapeok();

    void unsetId();

    void unsetInsetpenok();

    void unsetLimo();

    void unsetShadowok();

    void unsetStrokeok();

    void unsetTextboxrect();

    void unsetTextpathok();

    void unsetV();

    STTrueFalse xgetArrowok();

    XmlString xgetConnectangles();

    XmlString xgetConnectlocs();

    STConnectType xgetConnecttype();

    schemasMicrosoftComOfficeOffice.STTrueFalse xgetExtrusionok();

    STTrueFalse xgetFillok();

    STTrueFalse xgetGradientshapeok();

    XmlString xgetId();

    STTrueFalse xgetInsetpenok();

    XmlString xgetLimo();

    STTrueFalse xgetShadowok();

    STTrueFalse xgetStrokeok();

    XmlString xgetTextboxrect();

    STTrueFalse xgetTextpathok();

    XmlString xgetV();

    void xsetArrowok(STTrueFalse sTTrueFalse);

    void xsetConnectangles(XmlString xmlString);

    void xsetConnectlocs(XmlString xmlString);

    void xsetConnecttype(STConnectType sTConnectType);

    void xsetExtrusionok(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse);

    void xsetFillok(STTrueFalse sTTrueFalse);

    void xsetGradientshapeok(STTrueFalse sTTrueFalse);

    void xsetId(XmlString xmlString);

    void xsetInsetpenok(STTrueFalse sTTrueFalse);

    void xsetLimo(XmlString xmlString);

    void xsetShadowok(STTrueFalse sTTrueFalse);

    void xsetStrokeok(STTrueFalse sTTrueFalse);

    void xsetTextboxrect(XmlString xmlString);

    void xsetTextpathok(STTrueFalse sTTrueFalse);

    void xsetV(XmlString xmlString);
}
