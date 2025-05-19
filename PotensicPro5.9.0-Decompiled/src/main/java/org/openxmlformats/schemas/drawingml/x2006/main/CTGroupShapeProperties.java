package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTGroupShapeProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTGroupShapeProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctgroupshapeproperties8690type");

    public static final class Factory {
        private Factory() {
        }

        public static CTGroupShapeProperties newInstance() {
            return (CTGroupShapeProperties) XmlBeans.getContextTypeLoader().newInstance(CTGroupShapeProperties.type, null);
        }

        public static CTGroupShapeProperties newInstance(XmlOptions xmlOptions) {
            return (CTGroupShapeProperties) XmlBeans.getContextTypeLoader().newInstance(CTGroupShapeProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGroupShapeProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGroupShapeProperties.type, xmlOptions);
        }

        public static CTGroupShapeProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGroupShapeProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGroupShapeProperties.type, (XmlOptions) null);
        }

        public static CTGroupShapeProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGroupShapeProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGroupShapeProperties.type, xmlOptions);
        }

        public static CTGroupShapeProperties parse(File file) throws XmlException, IOException {
            return (CTGroupShapeProperties) XmlBeans.getContextTypeLoader().parse(file, CTGroupShapeProperties.type, (XmlOptions) null);
        }

        public static CTGroupShapeProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupShapeProperties) XmlBeans.getContextTypeLoader().parse(file, CTGroupShapeProperties.type, xmlOptions);
        }

        public static CTGroupShapeProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGroupShapeProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTGroupShapeProperties.type, (XmlOptions) null);
        }

        public static CTGroupShapeProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupShapeProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTGroupShapeProperties.type, xmlOptions);
        }

        public static CTGroupShapeProperties parse(Reader reader) throws XmlException, IOException {
            return (CTGroupShapeProperties) XmlBeans.getContextTypeLoader().parse(reader, CTGroupShapeProperties.type, (XmlOptions) null);
        }

        public static CTGroupShapeProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupShapeProperties) XmlBeans.getContextTypeLoader().parse(reader, CTGroupShapeProperties.type, xmlOptions);
        }

        public static CTGroupShapeProperties parse(String str) throws XmlException {
            return (CTGroupShapeProperties) XmlBeans.getContextTypeLoader().parse(str, CTGroupShapeProperties.type, (XmlOptions) null);
        }

        public static CTGroupShapeProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGroupShapeProperties) XmlBeans.getContextTypeLoader().parse(str, CTGroupShapeProperties.type, xmlOptions);
        }

        public static CTGroupShapeProperties parse(URL url) throws XmlException, IOException {
            return (CTGroupShapeProperties) XmlBeans.getContextTypeLoader().parse(url, CTGroupShapeProperties.type, (XmlOptions) null);
        }

        public static CTGroupShapeProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupShapeProperties) XmlBeans.getContextTypeLoader().parse(url, CTGroupShapeProperties.type, xmlOptions);
        }

        public static CTGroupShapeProperties parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTGroupShapeProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGroupShapeProperties.type, (XmlOptions) null);
        }

        public static CTGroupShapeProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTGroupShapeProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGroupShapeProperties.type, xmlOptions);
        }

        public static CTGroupShapeProperties parse(Node node) throws XmlException {
            return (CTGroupShapeProperties) XmlBeans.getContextTypeLoader().parse(node, CTGroupShapeProperties.type, (XmlOptions) null);
        }

        public static CTGroupShapeProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGroupShapeProperties) XmlBeans.getContextTypeLoader().parse(node, CTGroupShapeProperties.type, xmlOptions);
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

    CTScene3D addNewScene3D();

    CTSolidColorFillProperties addNewSolidFill();

    CTGroupTransform2D addNewXfrm();

    CTBlipFillProperties getBlipFill();

    STBlackWhiteMode$Enum getBwMode();

    CTEffectContainer getEffectDag();

    CTEffectList getEffectLst();

    CTOfficeArtExtensionList getExtLst();

    CTGradientFillProperties getGradFill();

    CTGroupFillProperties getGrpFill();

    CTNoFillProperties getNoFill();

    CTPatternFillProperties getPattFill();

    CTScene3D getScene3D();

    CTSolidColorFillProperties getSolidFill();

    CTGroupTransform2D getXfrm();

    boolean isSetBlipFill();

    boolean isSetBwMode();

    boolean isSetEffectDag();

    boolean isSetEffectLst();

    boolean isSetExtLst();

    boolean isSetGradFill();

    boolean isSetGrpFill();

    boolean isSetNoFill();

    boolean isSetPattFill();

    boolean isSetScene3D();

    boolean isSetSolidFill();

    boolean isSetXfrm();

    void setBlipFill(CTBlipFillProperties cTBlipFillProperties);

    void setBwMode(STBlackWhiteMode$Enum sTBlackWhiteMode$Enum);

    void setEffectDag(CTEffectContainer cTEffectContainer);

    void setEffectLst(CTEffectList cTEffectList);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setGradFill(CTGradientFillProperties cTGradientFillProperties);

    void setGrpFill(CTGroupFillProperties cTGroupFillProperties);

    void setNoFill(CTNoFillProperties cTNoFillProperties);

    void setPattFill(CTPatternFillProperties cTPatternFillProperties);

    void setScene3D(CTScene3D cTScene3D);

    void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties);

    void setXfrm(CTGroupTransform2D cTGroupTransform2D);

    void unsetBlipFill();

    void unsetBwMode();

    void unsetEffectDag();

    void unsetEffectLst();

    void unsetExtLst();

    void unsetGradFill();

    void unsetGrpFill();

    void unsetNoFill();

    void unsetPattFill();

    void unsetScene3D();

    void unsetSolidFill();

    void unsetXfrm();

    STBlackWhiteMode xgetBwMode();

    void xsetBwMode(STBlackWhiteMode sTBlackWhiteMode);
}
