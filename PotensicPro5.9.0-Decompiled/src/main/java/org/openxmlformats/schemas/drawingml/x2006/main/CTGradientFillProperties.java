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
public interface CTGradientFillProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTGradientFillProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctgradientfillproperties81c1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTGradientFillProperties newInstance() {
            return (CTGradientFillProperties) XmlBeans.getContextTypeLoader().newInstance(CTGradientFillProperties.type, null);
        }

        public static CTGradientFillProperties newInstance(XmlOptions xmlOptions) {
            return (CTGradientFillProperties) XmlBeans.getContextTypeLoader().newInstance(CTGradientFillProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGradientFillProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGradientFillProperties.type, xmlOptions);
        }

        public static CTGradientFillProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGradientFillProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGradientFillProperties.type, (XmlOptions) null);
        }

        public static CTGradientFillProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGradientFillProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGradientFillProperties.type, xmlOptions);
        }

        public static CTGradientFillProperties parse(File file) throws XmlException, IOException {
            return (CTGradientFillProperties) XmlBeans.getContextTypeLoader().parse(file, CTGradientFillProperties.type, (XmlOptions) null);
        }

        public static CTGradientFillProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGradientFillProperties) XmlBeans.getContextTypeLoader().parse(file, CTGradientFillProperties.type, xmlOptions);
        }

        public static CTGradientFillProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGradientFillProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTGradientFillProperties.type, (XmlOptions) null);
        }

        public static CTGradientFillProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGradientFillProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTGradientFillProperties.type, xmlOptions);
        }

        public static CTGradientFillProperties parse(Reader reader) throws XmlException, IOException {
            return (CTGradientFillProperties) XmlBeans.getContextTypeLoader().parse(reader, CTGradientFillProperties.type, (XmlOptions) null);
        }

        public static CTGradientFillProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGradientFillProperties) XmlBeans.getContextTypeLoader().parse(reader, CTGradientFillProperties.type, xmlOptions);
        }

        public static CTGradientFillProperties parse(String str) throws XmlException {
            return (CTGradientFillProperties) XmlBeans.getContextTypeLoader().parse(str, CTGradientFillProperties.type, (XmlOptions) null);
        }

        public static CTGradientFillProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGradientFillProperties) XmlBeans.getContextTypeLoader().parse(str, CTGradientFillProperties.type, xmlOptions);
        }

        public static CTGradientFillProperties parse(URL url) throws XmlException, IOException {
            return (CTGradientFillProperties) XmlBeans.getContextTypeLoader().parse(url, CTGradientFillProperties.type, (XmlOptions) null);
        }

        public static CTGradientFillProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGradientFillProperties) XmlBeans.getContextTypeLoader().parse(url, CTGradientFillProperties.type, xmlOptions);
        }

        public static CTGradientFillProperties parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTGradientFillProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGradientFillProperties.type, (XmlOptions) null);
        }

        public static CTGradientFillProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTGradientFillProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGradientFillProperties.type, xmlOptions);
        }

        public static CTGradientFillProperties parse(Node node) throws XmlException {
            return (CTGradientFillProperties) XmlBeans.getContextTypeLoader().parse(node, CTGradientFillProperties.type, (XmlOptions) null);
        }

        public static CTGradientFillProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGradientFillProperties) XmlBeans.getContextTypeLoader().parse(node, CTGradientFillProperties.type, xmlOptions);
        }
    }

    CTGradientStopList addNewGsLst();

    CTLinearShadeProperties addNewLin();

    CTPathShadeProperties addNewPath();

    CTRelativeRect addNewTileRect();

    STTileFlipMode$Enum getFlip();

    CTGradientStopList getGsLst();

    CTLinearShadeProperties getLin();

    CTPathShadeProperties getPath();

    boolean getRotWithShape();

    CTRelativeRect getTileRect();

    boolean isSetFlip();

    boolean isSetGsLst();

    boolean isSetLin();

    boolean isSetPath();

    boolean isSetRotWithShape();

    boolean isSetTileRect();

    void setFlip(STTileFlipMode$Enum sTTileFlipMode$Enum);

    void setGsLst(CTGradientStopList cTGradientStopList);

    void setLin(CTLinearShadeProperties cTLinearShadeProperties);

    void setPath(CTPathShadeProperties cTPathShadeProperties);

    void setRotWithShape(boolean z);

    void setTileRect(CTRelativeRect cTRelativeRect);

    void unsetFlip();

    void unsetGsLst();

    void unsetLin();

    void unsetPath();

    void unsetRotWithShape();

    void unsetTileRect();

    STTileFlipMode xgetFlip();

    XmlBoolean xgetRotWithShape();

    void xsetFlip(STTileFlipMode sTTileFlipMode);

    void xsetRotWithShape(XmlBoolean xmlBoolean);
}
