package org.openxmlformats.schemas.drawingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTTableProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTableProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttableproperties3512type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableProperties newInstance() {
            return (CTTableProperties) XmlBeans.getContextTypeLoader().newInstance(CTTableProperties.type, null);
        }

        public static CTTableProperties newInstance(XmlOptions xmlOptions) {
            return (CTTableProperties) XmlBeans.getContextTypeLoader().newInstance(CTTableProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTableProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTableProperties.type, xmlOptions);
        }

        public static CTTableProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTableProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTableProperties.type, (XmlOptions) null);
        }

        public static CTTableProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTableProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTableProperties.type, xmlOptions);
        }

        public static CTTableProperties parse(File file) throws XmlException, IOException {
            return (CTTableProperties) XmlBeans.getContextTypeLoader().parse(file, CTTableProperties.type, (XmlOptions) null);
        }

        public static CTTableProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableProperties) XmlBeans.getContextTypeLoader().parse(file, CTTableProperties.type, xmlOptions);
        }

        public static CTTableProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTableProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTTableProperties.type, (XmlOptions) null);
        }

        public static CTTableProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTTableProperties.type, xmlOptions);
        }

        public static CTTableProperties parse(Reader reader) throws XmlException, IOException {
            return (CTTableProperties) XmlBeans.getContextTypeLoader().parse(reader, CTTableProperties.type, (XmlOptions) null);
        }

        public static CTTableProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableProperties) XmlBeans.getContextTypeLoader().parse(reader, CTTableProperties.type, xmlOptions);
        }

        public static CTTableProperties parse(String str) throws XmlException {
            return (CTTableProperties) XmlBeans.getContextTypeLoader().parse(str, CTTableProperties.type, (XmlOptions) null);
        }

        public static CTTableProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTableProperties) XmlBeans.getContextTypeLoader().parse(str, CTTableProperties.type, xmlOptions);
        }

        public static CTTableProperties parse(URL url) throws XmlException, IOException {
            return (CTTableProperties) XmlBeans.getContextTypeLoader().parse(url, CTTableProperties.type, (XmlOptions) null);
        }

        public static CTTableProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableProperties) XmlBeans.getContextTypeLoader().parse(url, CTTableProperties.type, xmlOptions);
        }

        public static CTTableProperties parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTableProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTableProperties.type, (XmlOptions) null);
        }

        public static CTTableProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTableProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTableProperties.type, xmlOptions);
        }

        public static CTTableProperties parse(Node node) throws XmlException {
            return (CTTableProperties) XmlBeans.getContextTypeLoader().parse(node, CTTableProperties.type, (XmlOptions) null);
        }

        public static CTTableProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTableProperties) XmlBeans.getContextTypeLoader().parse(node, CTTableProperties.type, xmlOptions);
        }
    }

    CTBlipFillProperties addNewBlipFill();

    CTEffectContainer addNewEffectDag();

    CTEffectList addNewEffectLst();

    CTOfficeArtExtensionList addNewExtLst();

    CTGradientFillProperties addNewGradFill();

    CTGroupFillProperties addNewGrpFill();

    CTNoFillProperties addNewNoFill();

    CTPatternFillProperties addNewPattFill();

    CTSolidColorFillProperties addNewSolidFill();

    CTTableStyle addNewTableStyle();

    boolean getBandCol();

    boolean getBandRow();

    CTBlipFillProperties getBlipFill();

    CTEffectContainer getEffectDag();

    CTEffectList getEffectLst();

    CTOfficeArtExtensionList getExtLst();

    boolean getFirstCol();

    boolean getFirstRow();

    CTGradientFillProperties getGradFill();

    CTGroupFillProperties getGrpFill();

    boolean getLastCol();

    boolean getLastRow();

    CTNoFillProperties getNoFill();

    CTPatternFillProperties getPattFill();

    boolean getRtl();

    CTSolidColorFillProperties getSolidFill();

    CTTableStyle getTableStyle();

    String getTableStyleId();

    boolean isSetBandCol();

    boolean isSetBandRow();

    boolean isSetBlipFill();

    boolean isSetEffectDag();

    boolean isSetEffectLst();

    boolean isSetExtLst();

    boolean isSetFirstCol();

    boolean isSetFirstRow();

    boolean isSetGradFill();

    boolean isSetGrpFill();

    boolean isSetLastCol();

    boolean isSetLastRow();

    boolean isSetNoFill();

    boolean isSetPattFill();

    boolean isSetRtl();

    boolean isSetSolidFill();

    boolean isSetTableStyle();

    boolean isSetTableStyleId();

    void setBandCol(boolean z);

    void setBandRow(boolean z);

    void setBlipFill(CTBlipFillProperties cTBlipFillProperties);

    void setEffectDag(CTEffectContainer cTEffectContainer);

    void setEffectLst(CTEffectList cTEffectList);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setFirstCol(boolean z);

    void setFirstRow(boolean z);

    void setGradFill(CTGradientFillProperties cTGradientFillProperties);

    void setGrpFill(CTGroupFillProperties cTGroupFillProperties);

    void setLastCol(boolean z);

    void setLastRow(boolean z);

    void setNoFill(CTNoFillProperties cTNoFillProperties);

    void setPattFill(CTPatternFillProperties cTPatternFillProperties);

    void setRtl(boolean z);

    void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties);

    void setTableStyle(CTTableStyle cTTableStyle);

    void setTableStyleId(String str);

    void unsetBandCol();

    void unsetBandRow();

    void unsetBlipFill();

    void unsetEffectDag();

    void unsetEffectLst();

    void unsetExtLst();

    void unsetFirstCol();

    void unsetFirstRow();

    void unsetGradFill();

    void unsetGrpFill();

    void unsetLastCol();

    void unsetLastRow();

    void unsetNoFill();

    void unsetPattFill();

    void unsetRtl();

    void unsetSolidFill();

    void unsetTableStyle();

    void unsetTableStyleId();

    XmlBoolean xgetBandCol();

    XmlBoolean xgetBandRow();

    XmlBoolean xgetFirstCol();

    XmlBoolean xgetFirstRow();

    XmlBoolean xgetLastCol();

    XmlBoolean xgetLastRow();

    XmlBoolean xgetRtl();

    STGuid xgetTableStyleId();

    void xsetBandCol(XmlBoolean xmlBoolean);

    void xsetBandRow(XmlBoolean xmlBoolean);

    void xsetFirstCol(XmlBoolean xmlBoolean);

    void xsetFirstRow(XmlBoolean xmlBoolean);

    void xsetLastCol(XmlBoolean xmlBoolean);

    void xsetLastRow(XmlBoolean xmlBoolean);

    void xsetRtl(XmlBoolean xmlBoolean);

    void xsetTableStyleId(STGuid sTGuid);
}
