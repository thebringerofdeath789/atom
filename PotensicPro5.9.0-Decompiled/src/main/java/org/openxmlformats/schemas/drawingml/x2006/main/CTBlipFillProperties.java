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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTBlipFillProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTBlipFillProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctblipfillproperties0382type");

    public static final class Factory {
        private Factory() {
        }

        public static CTBlipFillProperties newInstance() {
            return (CTBlipFillProperties) XmlBeans.getContextTypeLoader().newInstance(CTBlipFillProperties.type, null);
        }

        public static CTBlipFillProperties newInstance(XmlOptions xmlOptions) {
            return (CTBlipFillProperties) XmlBeans.getContextTypeLoader().newInstance(CTBlipFillProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTBlipFillProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTBlipFillProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTBlipFillProperties) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(File file) throws XmlException, IOException {
            return (CTBlipFillProperties) XmlBeans.getContextTypeLoader().parse(file, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBlipFillProperties) XmlBeans.getContextTypeLoader().parse(file, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTBlipFillProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBlipFillProperties) XmlBeans.getContextTypeLoader().parse(inputStream, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(Reader reader) throws XmlException, IOException {
            return (CTBlipFillProperties) XmlBeans.getContextTypeLoader().parse(reader, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBlipFillProperties) XmlBeans.getContextTypeLoader().parse(reader, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(String str) throws XmlException {
            return (CTBlipFillProperties) XmlBeans.getContextTypeLoader().parse(str, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTBlipFillProperties) XmlBeans.getContextTypeLoader().parse(str, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(URL url) throws XmlException, IOException {
            return (CTBlipFillProperties) XmlBeans.getContextTypeLoader().parse(url, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBlipFillProperties) XmlBeans.getContextTypeLoader().parse(url, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTBlipFillProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTBlipFillProperties) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(Node node) throws XmlException {
            return (CTBlipFillProperties) XmlBeans.getContextTypeLoader().parse(node, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTBlipFillProperties) XmlBeans.getContextTypeLoader().parse(node, CTBlipFillProperties.type, xmlOptions);
        }
    }

    CTBlip addNewBlip();

    CTRelativeRect addNewSrcRect();

    CTStretchInfoProperties addNewStretch();

    CTTileInfoProperties addNewTile();

    CTBlip getBlip();

    long getDpi();

    boolean getRotWithShape();

    CTRelativeRect getSrcRect();

    CTStretchInfoProperties getStretch();

    CTTileInfoProperties getTile();

    boolean isSetBlip();

    boolean isSetDpi();

    boolean isSetRotWithShape();

    boolean isSetSrcRect();

    boolean isSetStretch();

    boolean isSetTile();

    void setBlip(CTBlip cTBlip);

    void setDpi(long j);

    void setRotWithShape(boolean z);

    void setSrcRect(CTRelativeRect cTRelativeRect);

    void setStretch(CTStretchInfoProperties cTStretchInfoProperties);

    void setTile(CTTileInfoProperties cTTileInfoProperties);

    void unsetBlip();

    void unsetDpi();

    void unsetRotWithShape();

    void unsetSrcRect();

    void unsetStretch();

    void unsetTile();

    XmlUnsignedInt xgetDpi();

    XmlBoolean xgetRotWithShape();

    void xsetDpi(XmlUnsignedInt xmlUnsignedInt);

    void xsetRotWithShape(XmlBoolean xmlBoolean);
}
