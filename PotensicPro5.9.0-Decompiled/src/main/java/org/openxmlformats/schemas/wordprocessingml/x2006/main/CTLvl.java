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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTLvl extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTLvl.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctlvlf630type");

    public static final class Factory {
        private Factory() {
        }

        public static CTLvl newInstance() {
            return (CTLvl) XmlBeans.getContextTypeLoader().newInstance(CTLvl.type, null);
        }

        public static CTLvl newInstance(XmlOptions xmlOptions) {
            return (CTLvl) XmlBeans.getContextTypeLoader().newInstance(CTLvl.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLvl.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLvl) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLvl) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(File file) throws XmlException, IOException {
            return (CTLvl) XmlBeans.getContextTypeLoader().parse(file, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLvl) XmlBeans.getContextTypeLoader().parse(file, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLvl) XmlBeans.getContextTypeLoader().parse(inputStream, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLvl) XmlBeans.getContextTypeLoader().parse(inputStream, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(Reader reader) throws XmlException, IOException {
            return (CTLvl) XmlBeans.getContextTypeLoader().parse(reader, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLvl) XmlBeans.getContextTypeLoader().parse(reader, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(String str) throws XmlException {
            return (CTLvl) XmlBeans.getContextTypeLoader().parse(str, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLvl) XmlBeans.getContextTypeLoader().parse(str, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(URL url) throws XmlException, IOException {
            return (CTLvl) XmlBeans.getContextTypeLoader().parse(url, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLvl) XmlBeans.getContextTypeLoader().parse(url, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTLvl) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTLvl) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(Node node) throws XmlException {
            return (CTLvl) XmlBeans.getContextTypeLoader().parse(node, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLvl) XmlBeans.getContextTypeLoader().parse(node, CTLvl.type, xmlOptions);
        }
    }

    CTOnOff addNewIsLgl();

    CTLvlLegacy addNewLegacy();

    CTJc addNewLvlJc();

    CTDecimalNumber addNewLvlPicBulletId();

    CTDecimalNumber addNewLvlRestart();

    CTLevelText addNewLvlText();

    CTNumFmt addNewNumFmt();

    CTPPr addNewPPr();

    CTString addNewPStyle();

    CTRPr addNewRPr();

    CTDecimalNumber addNewStart();

    CTLevelSuffix addNewSuff();

    BigInteger getIlvl();

    CTOnOff getIsLgl();

    CTLvlLegacy getLegacy();

    CTJc getLvlJc();

    CTDecimalNumber getLvlPicBulletId();

    CTDecimalNumber getLvlRestart();

    CTLevelText getLvlText();

    CTNumFmt getNumFmt();

    CTPPr getPPr();

    CTString getPStyle();

    CTRPr getRPr();

    CTDecimalNumber getStart();

    CTLevelSuffix getSuff();

    STOnOff.Enum getTentative();

    byte[] getTplc();

    boolean isSetIsLgl();

    boolean isSetLegacy();

    boolean isSetLvlJc();

    boolean isSetLvlPicBulletId();

    boolean isSetLvlRestart();

    boolean isSetLvlText();

    boolean isSetNumFmt();

    boolean isSetPPr();

    boolean isSetPStyle();

    boolean isSetRPr();

    boolean isSetStart();

    boolean isSetSuff();

    boolean isSetTentative();

    boolean isSetTplc();

    void setIlvl(BigInteger bigInteger);

    void setIsLgl(CTOnOff cTOnOff);

    void setLegacy(CTLvlLegacy cTLvlLegacy);

    void setLvlJc(CTJc cTJc);

    void setLvlPicBulletId(CTDecimalNumber cTDecimalNumber);

    void setLvlRestart(CTDecimalNumber cTDecimalNumber);

    void setLvlText(CTLevelText cTLevelText);

    void setNumFmt(CTNumFmt cTNumFmt);

    void setPPr(CTPPr cTPPr);

    void setPStyle(CTString cTString);

    void setRPr(CTRPr cTRPr);

    void setStart(CTDecimalNumber cTDecimalNumber);

    void setSuff(CTLevelSuffix cTLevelSuffix);

    void setTentative(STOnOff.Enum r1);

    void setTplc(byte[] bArr);

    void unsetIsLgl();

    void unsetLegacy();

    void unsetLvlJc();

    void unsetLvlPicBulletId();

    void unsetLvlRestart();

    void unsetLvlText();

    void unsetNumFmt();

    void unsetPPr();

    void unsetPStyle();

    void unsetRPr();

    void unsetStart();

    void unsetSuff();

    void unsetTentative();

    void unsetTplc();

    STDecimalNumber xgetIlvl();

    STOnOff xgetTentative();

    STLongHexNumber xgetTplc();

    void xsetIlvl(STDecimalNumber sTDecimalNumber);

    void xsetTentative(STOnOff sTOnOff);

    void xsetTplc(STLongHexNumber sTLongHexNumber);
}
