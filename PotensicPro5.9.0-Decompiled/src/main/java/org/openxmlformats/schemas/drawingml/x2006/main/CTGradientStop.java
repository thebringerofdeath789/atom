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
public interface CTGradientStop extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTGradientStop.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctgradientstopc7edtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTGradientStop newInstance() {
            return (CTGradientStop) XmlBeans.getContextTypeLoader().newInstance(CTGradientStop.type, null);
        }

        public static CTGradientStop newInstance(XmlOptions xmlOptions) {
            return (CTGradientStop) XmlBeans.getContextTypeLoader().newInstance(CTGradientStop.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGradientStop.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGradientStop.type, xmlOptions);
        }

        public static CTGradientStop parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGradientStop) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGradientStop.type, (XmlOptions) null);
        }

        public static CTGradientStop parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGradientStop) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGradientStop.type, xmlOptions);
        }

        public static CTGradientStop parse(File file) throws XmlException, IOException {
            return (CTGradientStop) XmlBeans.getContextTypeLoader().parse(file, CTGradientStop.type, (XmlOptions) null);
        }

        public static CTGradientStop parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGradientStop) XmlBeans.getContextTypeLoader().parse(file, CTGradientStop.type, xmlOptions);
        }

        public static CTGradientStop parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGradientStop) XmlBeans.getContextTypeLoader().parse(inputStream, CTGradientStop.type, (XmlOptions) null);
        }

        public static CTGradientStop parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGradientStop) XmlBeans.getContextTypeLoader().parse(inputStream, CTGradientStop.type, xmlOptions);
        }

        public static CTGradientStop parse(Reader reader) throws XmlException, IOException {
            return (CTGradientStop) XmlBeans.getContextTypeLoader().parse(reader, CTGradientStop.type, (XmlOptions) null);
        }

        public static CTGradientStop parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGradientStop) XmlBeans.getContextTypeLoader().parse(reader, CTGradientStop.type, xmlOptions);
        }

        public static CTGradientStop parse(String str) throws XmlException {
            return (CTGradientStop) XmlBeans.getContextTypeLoader().parse(str, CTGradientStop.type, (XmlOptions) null);
        }

        public static CTGradientStop parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGradientStop) XmlBeans.getContextTypeLoader().parse(str, CTGradientStop.type, xmlOptions);
        }

        public static CTGradientStop parse(URL url) throws XmlException, IOException {
            return (CTGradientStop) XmlBeans.getContextTypeLoader().parse(url, CTGradientStop.type, (XmlOptions) null);
        }

        public static CTGradientStop parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGradientStop) XmlBeans.getContextTypeLoader().parse(url, CTGradientStop.type, xmlOptions);
        }

        public static CTGradientStop parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTGradientStop) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGradientStop.type, (XmlOptions) null);
        }

        public static CTGradientStop parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTGradientStop) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGradientStop.type, xmlOptions);
        }

        public static CTGradientStop parse(Node node) throws XmlException {
            return (CTGradientStop) XmlBeans.getContextTypeLoader().parse(node, CTGradientStop.type, (XmlOptions) null);
        }

        public static CTGradientStop parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGradientStop) XmlBeans.getContextTypeLoader().parse(node, CTGradientStop.type, xmlOptions);
        }
    }

    CTHslColor addNewHslClr();

    CTPresetColor addNewPrstClr();

    CTSchemeColor addNewSchemeClr();

    CTScRgbColor addNewScrgbClr();

    CTSRgbColor addNewSrgbClr();

    CTSystemColor addNewSysClr();

    CTHslColor getHslClr();

    int getPos();

    CTPresetColor getPrstClr();

    CTSchemeColor getSchemeClr();

    CTScRgbColor getScrgbClr();

    CTSRgbColor getSrgbClr();

    CTSystemColor getSysClr();

    boolean isSetHslClr();

    boolean isSetPrstClr();

    boolean isSetSchemeClr();

    boolean isSetScrgbClr();

    boolean isSetSrgbClr();

    boolean isSetSysClr();

    void setHslClr(CTHslColor cTHslColor);

    void setPos(int i);

    void setPrstClr(CTPresetColor cTPresetColor);

    void setSchemeClr(CTSchemeColor cTSchemeColor);

    void setScrgbClr(CTScRgbColor cTScRgbColor);

    void setSrgbClr(CTSRgbColor cTSRgbColor);

    void setSysClr(CTSystemColor cTSystemColor);

    void unsetHslClr();

    void unsetPrstClr();

    void unsetSchemeClr();

    void unsetScrgbClr();

    void unsetSrgbClr();

    void unsetSysClr();

    STPositiveFixedPercentage xgetPos();

    void xsetPos(STPositiveFixedPercentage sTPositiveFixedPercentage);
}
