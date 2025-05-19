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
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTTblPrBase extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTblPrBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttblprbaseeba1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblPrBase newInstance() {
            return (CTTblPrBase) XmlBeans.getContextTypeLoader().newInstance(CTTblPrBase.type, null);
        }

        public static CTTblPrBase newInstance(XmlOptions xmlOptions) {
            return (CTTblPrBase) XmlBeans.getContextTypeLoader().newInstance(CTTblPrBase.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTblPrBase.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTblPrBase) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTblPrBase) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(File file) throws XmlException, IOException {
            return (CTTblPrBase) XmlBeans.getContextTypeLoader().parse(file, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPrBase) XmlBeans.getContextTypeLoader().parse(file, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTblPrBase) XmlBeans.getContextTypeLoader().parse(inputStream, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPrBase) XmlBeans.getContextTypeLoader().parse(inputStream, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(Reader reader) throws XmlException, IOException {
            return (CTTblPrBase) XmlBeans.getContextTypeLoader().parse(reader, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPrBase) XmlBeans.getContextTypeLoader().parse(reader, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(String str) throws XmlException {
            return (CTTblPrBase) XmlBeans.getContextTypeLoader().parse(str, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTblPrBase) XmlBeans.getContextTypeLoader().parse(str, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(URL url) throws XmlException, IOException {
            return (CTTblPrBase) XmlBeans.getContextTypeLoader().parse(url, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPrBase) XmlBeans.getContextTypeLoader().parse(url, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTblPrBase) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTblPrBase) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(Node node) throws XmlException {
            return (CTTblPrBase) XmlBeans.getContextTypeLoader().parse(node, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTblPrBase) XmlBeans.getContextTypeLoader().parse(node, CTTblPrBase.type, xmlOptions);
        }
    }

    CTOnOff addNewBidiVisual();

    CTJc addNewJc();

    CTShd addNewShd();

    CTTblBorders addNewTblBorders();

    CTTblCellMar addNewTblCellMar();

    CTTblWidth addNewTblCellSpacing();

    CTTblWidth addNewTblInd();

    CTTblLayoutType addNewTblLayout();

    CTShortHexNumber addNewTblLook();

    CTTblOverlap addNewTblOverlap();

    CTString addNewTblStyle();

    CTDecimalNumber addNewTblStyleColBandSize();

    CTDecimalNumber addNewTblStyleRowBandSize();

    CTTblWidth addNewTblW();

    CTTblPPr addNewTblpPr();

    CTOnOff getBidiVisual();

    CTJc getJc();

    CTShd getShd();

    CTTblBorders getTblBorders();

    CTTblCellMar getTblCellMar();

    CTTblWidth getTblCellSpacing();

    CTTblWidth getTblInd();

    CTTblLayoutType getTblLayout();

    CTShortHexNumber getTblLook();

    CTTblOverlap getTblOverlap();

    CTString getTblStyle();

    CTDecimalNumber getTblStyleColBandSize();

    CTDecimalNumber getTblStyleRowBandSize();

    CTTblWidth getTblW();

    CTTblPPr getTblpPr();

    boolean isSetBidiVisual();

    boolean isSetJc();

    boolean isSetShd();

    boolean isSetTblBorders();

    boolean isSetTblCellMar();

    boolean isSetTblCellSpacing();

    boolean isSetTblInd();

    boolean isSetTblLayout();

    boolean isSetTblLook();

    boolean isSetTblOverlap();

    boolean isSetTblStyle();

    boolean isSetTblStyleColBandSize();

    boolean isSetTblStyleRowBandSize();

    boolean isSetTblW();

    boolean isSetTblpPr();

    void setBidiVisual(CTOnOff cTOnOff);

    void setJc(CTJc cTJc);

    void setShd(CTShd cTShd);

    void setTblBorders(CTTblBorders cTTblBorders);

    void setTblCellMar(CTTblCellMar cTTblCellMar);

    void setTblCellSpacing(CTTblWidth cTTblWidth);

    void setTblInd(CTTblWidth cTTblWidth);

    void setTblLayout(CTTblLayoutType cTTblLayoutType);

    void setTblLook(CTShortHexNumber cTShortHexNumber);

    void setTblOverlap(CTTblOverlap cTTblOverlap);

    void setTblStyle(CTString cTString);

    void setTblStyleColBandSize(CTDecimalNumber cTDecimalNumber);

    void setTblStyleRowBandSize(CTDecimalNumber cTDecimalNumber);

    void setTblW(CTTblWidth cTTblWidth);

    void setTblpPr(CTTblPPr cTTblPPr);

    void unsetBidiVisual();

    void unsetJc();

    void unsetShd();

    void unsetTblBorders();

    void unsetTblCellMar();

    void unsetTblCellSpacing();

    void unsetTblInd();

    void unsetTblLayout();

    void unsetTblLook();

    void unsetTblOverlap();

    void unsetTblStyle();

    void unsetTblStyleColBandSize();

    void unsetTblStyleRowBandSize();

    void unsetTblW();

    void unsetTblpPr();
}
