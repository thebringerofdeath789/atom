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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTTableStyle extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTableStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttablestyled59etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableStyle newInstance() {
            return (CTTableStyle) XmlBeans.getContextTypeLoader().newInstance(CTTableStyle.type, null);
        }

        public static CTTableStyle newInstance(XmlOptions xmlOptions) {
            return (CTTableStyle) XmlBeans.getContextTypeLoader().newInstance(CTTableStyle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTableStyle.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTableStyle.type, xmlOptions);
        }

        public static CTTableStyle parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTableStyle) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTableStyle.type, (XmlOptions) null);
        }

        public static CTTableStyle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTableStyle) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTableStyle.type, xmlOptions);
        }

        public static CTTableStyle parse(File file) throws XmlException, IOException {
            return (CTTableStyle) XmlBeans.getContextTypeLoader().parse(file, CTTableStyle.type, (XmlOptions) null);
        }

        public static CTTableStyle parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyle) XmlBeans.getContextTypeLoader().parse(file, CTTableStyle.type, xmlOptions);
        }

        public static CTTableStyle parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTableStyle) XmlBeans.getContextTypeLoader().parse(inputStream, CTTableStyle.type, (XmlOptions) null);
        }

        public static CTTableStyle parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyle) XmlBeans.getContextTypeLoader().parse(inputStream, CTTableStyle.type, xmlOptions);
        }

        public static CTTableStyle parse(Reader reader) throws XmlException, IOException {
            return (CTTableStyle) XmlBeans.getContextTypeLoader().parse(reader, CTTableStyle.type, (XmlOptions) null);
        }

        public static CTTableStyle parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyle) XmlBeans.getContextTypeLoader().parse(reader, CTTableStyle.type, xmlOptions);
        }

        public static CTTableStyle parse(String str) throws XmlException {
            return (CTTableStyle) XmlBeans.getContextTypeLoader().parse(str, CTTableStyle.type, (XmlOptions) null);
        }

        public static CTTableStyle parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTableStyle) XmlBeans.getContextTypeLoader().parse(str, CTTableStyle.type, xmlOptions);
        }

        public static CTTableStyle parse(URL url) throws XmlException, IOException {
            return (CTTableStyle) XmlBeans.getContextTypeLoader().parse(url, CTTableStyle.type, (XmlOptions) null);
        }

        public static CTTableStyle parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableStyle) XmlBeans.getContextTypeLoader().parse(url, CTTableStyle.type, xmlOptions);
        }

        public static CTTableStyle parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTableStyle) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTableStyle.type, (XmlOptions) null);
        }

        public static CTTableStyle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTableStyle) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTableStyle.type, xmlOptions);
        }

        public static CTTableStyle parse(Node node) throws XmlException {
            return (CTTableStyle) XmlBeans.getContextTypeLoader().parse(node, CTTableStyle.type, (XmlOptions) null);
        }

        public static CTTableStyle parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTableStyle) XmlBeans.getContextTypeLoader().parse(node, CTTableStyle.type, xmlOptions);
        }
    }

    CTTablePartStyle addNewBand1H();

    CTTablePartStyle addNewBand1V();

    CTTablePartStyle addNewBand2H();

    CTTablePartStyle addNewBand2V();

    CTOfficeArtExtensionList addNewExtLst();

    CTTablePartStyle addNewFirstCol();

    CTTablePartStyle addNewFirstRow();

    CTTablePartStyle addNewLastCol();

    CTTablePartStyle addNewLastRow();

    CTTablePartStyle addNewNeCell();

    CTTablePartStyle addNewNwCell();

    CTTablePartStyle addNewSeCell();

    CTTablePartStyle addNewSwCell();

    CTTableBackgroundStyle addNewTblBg();

    CTTablePartStyle addNewWholeTbl();

    CTTablePartStyle getBand1H();

    CTTablePartStyle getBand1V();

    CTTablePartStyle getBand2H();

    CTTablePartStyle getBand2V();

    CTOfficeArtExtensionList getExtLst();

    CTTablePartStyle getFirstCol();

    CTTablePartStyle getFirstRow();

    CTTablePartStyle getLastCol();

    CTTablePartStyle getLastRow();

    CTTablePartStyle getNeCell();

    CTTablePartStyle getNwCell();

    CTTablePartStyle getSeCell();

    String getStyleId();

    String getStyleName();

    CTTablePartStyle getSwCell();

    CTTableBackgroundStyle getTblBg();

    CTTablePartStyle getWholeTbl();

    boolean isSetBand1H();

    boolean isSetBand1V();

    boolean isSetBand2H();

    boolean isSetBand2V();

    boolean isSetExtLst();

    boolean isSetFirstCol();

    boolean isSetFirstRow();

    boolean isSetLastCol();

    boolean isSetLastRow();

    boolean isSetNeCell();

    boolean isSetNwCell();

    boolean isSetSeCell();

    boolean isSetSwCell();

    boolean isSetTblBg();

    boolean isSetWholeTbl();

    void setBand1H(CTTablePartStyle cTTablePartStyle);

    void setBand1V(CTTablePartStyle cTTablePartStyle);

    void setBand2H(CTTablePartStyle cTTablePartStyle);

    void setBand2V(CTTablePartStyle cTTablePartStyle);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setFirstCol(CTTablePartStyle cTTablePartStyle);

    void setFirstRow(CTTablePartStyle cTTablePartStyle);

    void setLastCol(CTTablePartStyle cTTablePartStyle);

    void setLastRow(CTTablePartStyle cTTablePartStyle);

    void setNeCell(CTTablePartStyle cTTablePartStyle);

    void setNwCell(CTTablePartStyle cTTablePartStyle);

    void setSeCell(CTTablePartStyle cTTablePartStyle);

    void setStyleId(String str);

    void setStyleName(String str);

    void setSwCell(CTTablePartStyle cTTablePartStyle);

    void setTblBg(CTTableBackgroundStyle cTTableBackgroundStyle);

    void setWholeTbl(CTTablePartStyle cTTablePartStyle);

    void unsetBand1H();

    void unsetBand1V();

    void unsetBand2H();

    void unsetBand2V();

    void unsetExtLst();

    void unsetFirstCol();

    void unsetFirstRow();

    void unsetLastCol();

    void unsetLastRow();

    void unsetNeCell();

    void unsetNwCell();

    void unsetSeCell();

    void unsetSwCell();

    void unsetTblBg();

    void unsetWholeTbl();

    STGuid xgetStyleId();

    XmlString xgetStyleName();

    void xsetStyleId(STGuid sTGuid);

    void xsetStyleName(XmlString xmlString);
}
