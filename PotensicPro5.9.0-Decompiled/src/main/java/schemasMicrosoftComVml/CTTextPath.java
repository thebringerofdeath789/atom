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
public interface CTTextPath extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTextPath.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttextpath14f0type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextPath newInstance() {
            return (CTTextPath) XmlBeans.getContextTypeLoader().newInstance(CTTextPath.type, null);
        }

        public static CTTextPath newInstance(XmlOptions xmlOptions) {
            return (CTTextPath) XmlBeans.getContextTypeLoader().newInstance(CTTextPath.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextPath.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTextPath.type, xmlOptions);
        }

        public static CTTextPath parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextPath) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextPath.type, (XmlOptions) null);
        }

        public static CTTextPath parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextPath) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTextPath.type, xmlOptions);
        }

        public static CTTextPath parse(File file) throws XmlException, IOException {
            return (CTTextPath) XmlBeans.getContextTypeLoader().parse(file, CTTextPath.type, (XmlOptions) null);
        }

        public static CTTextPath parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextPath) XmlBeans.getContextTypeLoader().parse(file, CTTextPath.type, xmlOptions);
        }

        public static CTTextPath parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextPath) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextPath.type, (XmlOptions) null);
        }

        public static CTTextPath parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextPath) XmlBeans.getContextTypeLoader().parse(inputStream, CTTextPath.type, xmlOptions);
        }

        public static CTTextPath parse(Reader reader) throws XmlException, IOException {
            return (CTTextPath) XmlBeans.getContextTypeLoader().parse(reader, CTTextPath.type, (XmlOptions) null);
        }

        public static CTTextPath parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextPath) XmlBeans.getContextTypeLoader().parse(reader, CTTextPath.type, xmlOptions);
        }

        public static CTTextPath parse(String str) throws XmlException {
            return (CTTextPath) XmlBeans.getContextTypeLoader().parse(str, CTTextPath.type, (XmlOptions) null);
        }

        public static CTTextPath parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextPath) XmlBeans.getContextTypeLoader().parse(str, CTTextPath.type, xmlOptions);
        }

        public static CTTextPath parse(URL url) throws XmlException, IOException {
            return (CTTextPath) XmlBeans.getContextTypeLoader().parse(url, CTTextPath.type, (XmlOptions) null);
        }

        public static CTTextPath parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextPath) XmlBeans.getContextTypeLoader().parse(url, CTTextPath.type, xmlOptions);
        }

        public static CTTextPath parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTextPath) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextPath.type, (XmlOptions) null);
        }

        public static CTTextPath parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTextPath) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTextPath.type, xmlOptions);
        }

        public static CTTextPath parse(Node node) throws XmlException {
            return (CTTextPath) XmlBeans.getContextTypeLoader().parse(node, CTTextPath.type, (XmlOptions) null);
        }

        public static CTTextPath parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextPath) XmlBeans.getContextTypeLoader().parse(node, CTTextPath.type, xmlOptions);
        }
    }

    STTrueFalse.Enum getFitpath();

    STTrueFalse.Enum getFitshape();

    String getId();

    STTrueFalse.Enum getOn();

    String getString();

    String getStyle();

    STTrueFalse.Enum getTrim();

    STTrueFalse.Enum getXscale();

    boolean isSetFitpath();

    boolean isSetFitshape();

    boolean isSetId();

    boolean isSetOn();

    boolean isSetString();

    boolean isSetStyle();

    boolean isSetTrim();

    boolean isSetXscale();

    void setFitpath(STTrueFalse.Enum r1);

    void setFitshape(STTrueFalse.Enum r1);

    void setId(String str);

    void setOn(STTrueFalse.Enum r1);

    void setString(String str);

    void setStyle(String str);

    void setTrim(STTrueFalse.Enum r1);

    void setXscale(STTrueFalse.Enum r1);

    void unsetFitpath();

    void unsetFitshape();

    void unsetId();

    void unsetOn();

    void unsetString();

    void unsetStyle();

    void unsetTrim();

    void unsetXscale();

    STTrueFalse xgetFitpath();

    STTrueFalse xgetFitshape();

    XmlString xgetId();

    STTrueFalse xgetOn();

    XmlString xgetString();

    XmlString xgetStyle();

    STTrueFalse xgetTrim();

    STTrueFalse xgetXscale();

    void xsetFitpath(STTrueFalse sTTrueFalse);

    void xsetFitshape(STTrueFalse sTTrueFalse);

    void xsetId(XmlString xmlString);

    void xsetOn(STTrueFalse sTTrueFalse);

    void xsetString(XmlString xmlString);

    void xsetStyle(XmlString xmlString);

    void xsetTrim(STTrueFalse sTTrueFalse);

    void xsetXscale(STTrueFalse sTTrueFalse);
}
