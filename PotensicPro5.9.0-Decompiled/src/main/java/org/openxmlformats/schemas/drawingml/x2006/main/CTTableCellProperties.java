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
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAnchoringType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextHorzOverflowType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextVerticalType;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTTableCellProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTableCellProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttablecellproperties1614type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableCellProperties newInstance() {
            return (CTTableCellProperties) XmlBeans.getContextTypeLoader().newInstance(CTTableCellProperties.type, null);
        }

        public static CTTableCellProperties newInstance(XmlOptions xmlOptions) {
            return (CTTableCellProperties) XmlBeans.getContextTypeLoader().newInstance(CTTableCellProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTableCellProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTableCellProperties.type, xmlOptions);
        }

        public static CTTableCellProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTableCellProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTableCellProperties.type, (XmlOptions) null);
        }

        public static CTTableCellProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTableCellProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTableCellProperties.type, xmlOptions);
        }

        public static CTTableCellProperties parse(File file) throws XmlException, IOException {
            return (CTTableCellProperties) XmlBeans.getContextTypeLoader().parse(file, CTTableCellProperties.type, (XmlOptions) null);
        }

        public static CTTableCellProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableCellProperties) XmlBeans.getContextTypeLoader().parse(file, CTTableCellProperties.type, xmlOptions);
        }

        public static CTTableCellProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTableCellProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTTableCellProperties.type, (XmlOptions) null);
        }

        public static CTTableCellProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableCellProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTTableCellProperties.type, xmlOptions);
        }

        public static CTTableCellProperties parse(Reader reader) throws XmlException, IOException {
            return (CTTableCellProperties) XmlBeans.getContextTypeLoader().parse(reader, CTTableCellProperties.type, (XmlOptions) null);
        }

        public static CTTableCellProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableCellProperties) XmlBeans.getContextTypeLoader().parse(reader, CTTableCellProperties.type, xmlOptions);
        }

        public static CTTableCellProperties parse(String str) throws XmlException {
            return (CTTableCellProperties) XmlBeans.getContextTypeLoader().parse(str, CTTableCellProperties.type, (XmlOptions) null);
        }

        public static CTTableCellProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTableCellProperties) XmlBeans.getContextTypeLoader().parse(str, CTTableCellProperties.type, xmlOptions);
        }

        public static CTTableCellProperties parse(URL url) throws XmlException, IOException {
            return (CTTableCellProperties) XmlBeans.getContextTypeLoader().parse(url, CTTableCellProperties.type, (XmlOptions) null);
        }

        public static CTTableCellProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableCellProperties) XmlBeans.getContextTypeLoader().parse(url, CTTableCellProperties.type, xmlOptions);
        }

        public static CTTableCellProperties parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTableCellProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTableCellProperties.type, (XmlOptions) null);
        }

        public static CTTableCellProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTableCellProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTableCellProperties.type, xmlOptions);
        }

        public static CTTableCellProperties parse(Node node) throws XmlException {
            return (CTTableCellProperties) XmlBeans.getContextTypeLoader().parse(node, CTTableCellProperties.type, (XmlOptions) null);
        }

        public static CTTableCellProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTableCellProperties) XmlBeans.getContextTypeLoader().parse(node, CTTableCellProperties.type, xmlOptions);
        }
    }

    CTBlipFillProperties addNewBlipFill();

    CTCell3D addNewCell3D();

    CTOfficeArtExtensionList addNewExtLst();

    CTGradientFillProperties addNewGradFill();

    CTGroupFillProperties addNewGrpFill();

    CTLineProperties addNewLnB();

    CTLineProperties addNewLnBlToTr();

    CTLineProperties addNewLnL();

    CTLineProperties addNewLnR();

    CTLineProperties addNewLnT();

    CTLineProperties addNewLnTlToBr();

    CTNoFillProperties addNewNoFill();

    CTPatternFillProperties addNewPattFill();

    CTSolidColorFillProperties addNewSolidFill();

    STTextAnchoringType.Enum getAnchor();

    boolean getAnchorCtr();

    CTBlipFillProperties getBlipFill();

    CTCell3D getCell3D();

    CTOfficeArtExtensionList getExtLst();

    CTGradientFillProperties getGradFill();

    CTGroupFillProperties getGrpFill();

    STTextHorzOverflowType.Enum getHorzOverflow();

    CTLineProperties getLnB();

    CTLineProperties getLnBlToTr();

    CTLineProperties getLnL();

    CTLineProperties getLnR();

    CTLineProperties getLnT();

    CTLineProperties getLnTlToBr();

    int getMarB();

    int getMarL();

    int getMarR();

    int getMarT();

    CTNoFillProperties getNoFill();

    CTPatternFillProperties getPattFill();

    CTSolidColorFillProperties getSolidFill();

    STTextVerticalType.Enum getVert();

    boolean isSetAnchor();

    boolean isSetAnchorCtr();

    boolean isSetBlipFill();

    boolean isSetCell3D();

    boolean isSetExtLst();

    boolean isSetGradFill();

    boolean isSetGrpFill();

    boolean isSetHorzOverflow();

    boolean isSetLnB();

    boolean isSetLnBlToTr();

    boolean isSetLnL();

    boolean isSetLnR();

    boolean isSetLnT();

    boolean isSetLnTlToBr();

    boolean isSetMarB();

    boolean isSetMarL();

    boolean isSetMarR();

    boolean isSetMarT();

    boolean isSetNoFill();

    boolean isSetPattFill();

    boolean isSetSolidFill();

    boolean isSetVert();

    void setAnchor(STTextAnchoringType.Enum r1);

    void setAnchorCtr(boolean z);

    void setBlipFill(CTBlipFillProperties cTBlipFillProperties);

    void setCell3D(CTCell3D cTCell3D);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setGradFill(CTGradientFillProperties cTGradientFillProperties);

    void setGrpFill(CTGroupFillProperties cTGroupFillProperties);

    void setHorzOverflow(STTextHorzOverflowType.Enum r1);

    void setLnB(CTLineProperties cTLineProperties);

    void setLnBlToTr(CTLineProperties cTLineProperties);

    void setLnL(CTLineProperties cTLineProperties);

    void setLnR(CTLineProperties cTLineProperties);

    void setLnT(CTLineProperties cTLineProperties);

    void setLnTlToBr(CTLineProperties cTLineProperties);

    void setMarB(int i);

    void setMarL(int i);

    void setMarR(int i);

    void setMarT(int i);

    void setNoFill(CTNoFillProperties cTNoFillProperties);

    void setPattFill(CTPatternFillProperties cTPatternFillProperties);

    void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties);

    void setVert(STTextVerticalType.Enum r1);

    void unsetAnchor();

    void unsetAnchorCtr();

    void unsetBlipFill();

    void unsetCell3D();

    void unsetExtLst();

    void unsetGradFill();

    void unsetGrpFill();

    void unsetHorzOverflow();

    void unsetLnB();

    void unsetLnBlToTr();

    void unsetLnL();

    void unsetLnR();

    void unsetLnT();

    void unsetLnTlToBr();

    void unsetMarB();

    void unsetMarL();

    void unsetMarR();

    void unsetMarT();

    void unsetNoFill();

    void unsetPattFill();

    void unsetSolidFill();

    void unsetVert();

    STTextAnchoringType xgetAnchor();

    XmlBoolean xgetAnchorCtr();

    STTextHorzOverflowType xgetHorzOverflow();

    STCoordinate32 xgetMarB();

    STCoordinate32 xgetMarL();

    STCoordinate32 xgetMarR();

    STCoordinate32 xgetMarT();

    STTextVerticalType xgetVert();

    void xsetAnchor(STTextAnchoringType sTTextAnchoringType);

    void xsetAnchorCtr(XmlBoolean xmlBoolean);

    void xsetHorzOverflow(STTextHorzOverflowType sTTextHorzOverflowType);

    void xsetMarB(STCoordinate32 sTCoordinate32);

    void xsetMarL(STCoordinate32 sTCoordinate32);

    void xsetMarR(STCoordinate32 sTCoordinate32);

    void xsetMarT(STCoordinate32 sTCoordinate32);

    void xsetVert(STTextVerticalType sTTextVerticalType);
}
