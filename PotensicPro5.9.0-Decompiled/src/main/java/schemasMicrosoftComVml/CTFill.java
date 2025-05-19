package schemasMicrosoftComVml;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;
import schemasMicrosoftComVml.STTrueFalse;

/* loaded from: classes6.dex */
public interface CTFill extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTFill.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctfillb241type");

    public static final class Factory {
        private Factory() {
        }

        public static CTFill newInstance() {
            return (CTFill) XmlBeans.getContextTypeLoader().newInstance(CTFill.type, null);
        }

        public static CTFill newInstance(XmlOptions xmlOptions) {
            return (CTFill) XmlBeans.getContextTypeLoader().newInstance(CTFill.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFill.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFill.type, xmlOptions);
        }

        public static CTFill parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFill.type, xmlOptions);
        }

        public static CTFill parse(File file) throws XmlException, IOException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(file, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(file, CTFill.type, xmlOptions);
        }

        public static CTFill parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(inputStream, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(inputStream, CTFill.type, xmlOptions);
        }

        public static CTFill parse(Reader reader) throws XmlException, IOException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(reader, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(reader, CTFill.type, xmlOptions);
        }

        public static CTFill parse(String str) throws XmlException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(str, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(str, CTFill.type, xmlOptions);
        }

        public static CTFill parse(URL url) throws XmlException, IOException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(url, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(url, CTFill.type, xmlOptions);
        }

        public static CTFill parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFill.type, xmlOptions);
        }

        public static CTFill parse(Node node) throws XmlException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(node, CTFill.type, (XmlOptions) null);
        }

        public static CTFill parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFill) XmlBeans.getContextTypeLoader().parse(node, CTFill.type, xmlOptions);
        }
    }

    schemasMicrosoftComOfficeOffice.CTFill addNewFill();

    STTrueFalse.Enum getAlignshape();

    String getAlthref();

    BigDecimal getAngle();

    STImageAspect$Enum getAspect();

    String getColor();

    String getColor2();

    String getColors();

    schemasMicrosoftComOfficeOffice.STTrueFalse$Enum getDetectmouseclick();

    schemasMicrosoftComOfficeOffice.CTFill getFill();

    String getFocus();

    String getFocusposition();

    String getFocussize();

    String getHref();

    String getId();

    String getId2();

    STFillMethod$Enum getMethod();

    STTrueFalse.Enum getOn();

    String getOpacity();

    String getOpacity2();

    String getOrigin();

    String getPosition();

    STTrueFalse.Enum getRecolor();

    String getRelid();

    STTrueFalse.Enum getRotate();

    String getSize();

    String getSrc();

    String getTitle();

    STFillType$Enum getType();

    boolean isSetAlignshape();

    boolean isSetAlthref();

    boolean isSetAngle();

    boolean isSetAspect();

    boolean isSetColor();

    boolean isSetColor2();

    boolean isSetColors();

    boolean isSetDetectmouseclick();

    boolean isSetFill();

    boolean isSetFocus();

    boolean isSetFocusposition();

    boolean isSetFocussize();

    boolean isSetHref();

    boolean isSetId();

    boolean isSetId2();

    boolean isSetMethod();

    boolean isSetOn();

    boolean isSetOpacity();

    boolean isSetOpacity2();

    boolean isSetOrigin();

    boolean isSetPosition();

    boolean isSetRecolor();

    boolean isSetRelid();

    boolean isSetRotate();

    boolean isSetSize();

    boolean isSetSrc();

    boolean isSetTitle();

    boolean isSetType();

    void setAlignshape(STTrueFalse.Enum r1);

    void setAlthref(String str);

    void setAngle(BigDecimal bigDecimal);

    void setAspect(STImageAspect$Enum sTImageAspect$Enum);

    void setColor(String str);

    void setColor2(String str);

    void setColors(String str);

    void setDetectmouseclick(schemasMicrosoftComOfficeOffice.STTrueFalse$Enum sTTrueFalse$Enum);

    void setFill(schemasMicrosoftComOfficeOffice.CTFill cTFill);

    void setFocus(String str);

    void setFocusposition(String str);

    void setFocussize(String str);

    void setHref(String str);

    void setId(String str);

    void setId2(String str);

    void setMethod(STFillMethod$Enum sTFillMethod$Enum);

    void setOn(STTrueFalse.Enum r1);

    void setOpacity(String str);

    void setOpacity2(String str);

    void setOrigin(String str);

    void setPosition(String str);

    void setRecolor(STTrueFalse.Enum r1);

    void setRelid(String str);

    void setRotate(STTrueFalse.Enum r1);

    void setSize(String str);

    void setSrc(String str);

    void setTitle(String str);

    void setType(STFillType$Enum sTFillType$Enum);

    void unsetAlignshape();

    void unsetAlthref();

    void unsetAngle();

    void unsetAspect();

    void unsetColor();

    void unsetColor2();

    void unsetColors();

    void unsetDetectmouseclick();

    void unsetFill();

    void unsetFocus();

    void unsetFocusposition();

    void unsetFocussize();

    void unsetHref();

    void unsetId();

    void unsetId2();

    void unsetMethod();

    void unsetOn();

    void unsetOpacity();

    void unsetOpacity2();

    void unsetOrigin();

    void unsetPosition();

    void unsetRecolor();

    void unsetRelid();

    void unsetRotate();

    void unsetSize();

    void unsetSrc();

    void unsetTitle();

    void unsetType();

    STTrueFalse xgetAlignshape();

    XmlString xgetAlthref();

    XmlDecimal xgetAngle();

    STImageAspect xgetAspect();

    STColorType xgetColor();

    STColorType xgetColor2();

    XmlString xgetColors();

    schemasMicrosoftComOfficeOffice.STTrueFalse xgetDetectmouseclick();

    XmlString xgetFocus();

    XmlString xgetFocusposition();

    XmlString xgetFocussize();

    XmlString xgetHref();

    XmlString xgetId();

    STRelationshipId xgetId2();

    STFillMethod xgetMethod();

    STTrueFalse xgetOn();

    XmlString xgetOpacity();

    XmlString xgetOpacity2();

    XmlString xgetOrigin();

    XmlString xgetPosition();

    STTrueFalse xgetRecolor();

    schemasMicrosoftComOfficeOffice.STRelationshipId xgetRelid();

    STTrueFalse xgetRotate();

    XmlString xgetSize();

    XmlString xgetSrc();

    XmlString xgetTitle();

    STFillType xgetType();

    void xsetAlignshape(STTrueFalse sTTrueFalse);

    void xsetAlthref(XmlString xmlString);

    void xsetAngle(XmlDecimal xmlDecimal);

    void xsetAspect(STImageAspect sTImageAspect);

    void xsetColor(STColorType sTColorType);

    void xsetColor2(STColorType sTColorType);

    void xsetColors(XmlString xmlString);

    void xsetDetectmouseclick(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse);

    void xsetFocus(XmlString xmlString);

    void xsetFocusposition(XmlString xmlString);

    void xsetFocussize(XmlString xmlString);

    void xsetHref(XmlString xmlString);

    void xsetId(XmlString xmlString);

    void xsetId2(STRelationshipId sTRelationshipId);

    void xsetMethod(STFillMethod sTFillMethod);

    void xsetOn(STTrueFalse sTTrueFalse);

    void xsetOpacity(XmlString xmlString);

    void xsetOpacity2(XmlString xmlString);

    void xsetOrigin(XmlString xmlString);

    void xsetPosition(XmlString xmlString);

    void xsetRecolor(STTrueFalse sTTrueFalse);

    void xsetRelid(schemasMicrosoftComOfficeOffice.STRelationshipId sTRelationshipId);

    void xsetRotate(STTrueFalse sTTrueFalse);

    void xsetSize(XmlString xmlString);

    void xsetSrc(XmlString xmlString);

    void xsetTitle(XmlString xmlString);

    void xsetType(STFillType sTFillType);
}
