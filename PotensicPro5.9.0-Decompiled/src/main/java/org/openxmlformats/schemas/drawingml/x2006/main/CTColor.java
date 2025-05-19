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
public interface CTColor extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTColor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcolorb114type");

    public static final class Factory {
        private Factory() {
        }

        public static CTColor newInstance() {
            return (CTColor) XmlBeans.getContextTypeLoader().newInstance(CTColor.type, null);
        }

        public static CTColor newInstance(XmlOptions xmlOptions) {
            return (CTColor) XmlBeans.getContextTypeLoader().newInstance(CTColor.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTColor.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTColor.type, xmlOptions);
        }

        public static CTColor parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTColor) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTColor.type, (XmlOptions) null);
        }

        public static CTColor parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTColor) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTColor.type, xmlOptions);
        }

        public static CTColor parse(File file) throws XmlException, IOException {
            return (CTColor) XmlBeans.getContextTypeLoader().parse(file, CTColor.type, (XmlOptions) null);
        }

        public static CTColor parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColor) XmlBeans.getContextTypeLoader().parse(file, CTColor.type, xmlOptions);
        }

        public static CTColor parse(InputStream inputStream) throws XmlException, IOException {
            return (CTColor) XmlBeans.getContextTypeLoader().parse(inputStream, CTColor.type, (XmlOptions) null);
        }

        public static CTColor parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColor) XmlBeans.getContextTypeLoader().parse(inputStream, CTColor.type, xmlOptions);
        }

        public static CTColor parse(Reader reader) throws XmlException, IOException {
            return (CTColor) XmlBeans.getContextTypeLoader().parse(reader, CTColor.type, (XmlOptions) null);
        }

        public static CTColor parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColor) XmlBeans.getContextTypeLoader().parse(reader, CTColor.type, xmlOptions);
        }

        public static CTColor parse(String str) throws XmlException {
            return (CTColor) XmlBeans.getContextTypeLoader().parse(str, CTColor.type, (XmlOptions) null);
        }

        public static CTColor parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTColor) XmlBeans.getContextTypeLoader().parse(str, CTColor.type, xmlOptions);
        }

        public static CTColor parse(URL url) throws XmlException, IOException {
            return (CTColor) XmlBeans.getContextTypeLoader().parse(url, CTColor.type, (XmlOptions) null);
        }

        public static CTColor parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColor) XmlBeans.getContextTypeLoader().parse(url, CTColor.type, xmlOptions);
        }

        public static CTColor parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTColor) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTColor.type, (XmlOptions) null);
        }

        public static CTColor parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTColor) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTColor.type, xmlOptions);
        }

        public static CTColor parse(Node node) throws XmlException {
            return (CTColor) XmlBeans.getContextTypeLoader().parse(node, CTColor.type, (XmlOptions) null);
        }

        public static CTColor parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTColor) XmlBeans.getContextTypeLoader().parse(node, CTColor.type, xmlOptions);
        }
    }

    CTHslColor addNewHslClr();

    CTPresetColor addNewPrstClr();

    CTSchemeColor addNewSchemeClr();

    CTScRgbColor addNewScrgbClr();

    CTSRgbColor addNewSrgbClr();

    CTSystemColor addNewSysClr();

    CTHslColor getHslClr();

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
}
