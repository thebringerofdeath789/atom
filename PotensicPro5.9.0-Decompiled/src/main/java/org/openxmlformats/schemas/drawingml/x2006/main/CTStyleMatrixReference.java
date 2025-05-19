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
public interface CTStyleMatrixReference extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTStyleMatrixReference.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctstylematrixreference6ef4type");

    public static final class Factory {
        private Factory() {
        }

        public static CTStyleMatrixReference newInstance() {
            return (CTStyleMatrixReference) XmlBeans.getContextTypeLoader().newInstance(CTStyleMatrixReference.type, null);
        }

        public static CTStyleMatrixReference newInstance(XmlOptions xmlOptions) {
            return (CTStyleMatrixReference) XmlBeans.getContextTypeLoader().newInstance(CTStyleMatrixReference.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTStyleMatrixReference.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTStyleMatrixReference) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTStyleMatrixReference) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(File file) throws XmlException, IOException {
            return (CTStyleMatrixReference) XmlBeans.getContextTypeLoader().parse(file, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyleMatrixReference) XmlBeans.getContextTypeLoader().parse(file, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(InputStream inputStream) throws XmlException, IOException {
            return (CTStyleMatrixReference) XmlBeans.getContextTypeLoader().parse(inputStream, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyleMatrixReference) XmlBeans.getContextTypeLoader().parse(inputStream, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(Reader reader) throws XmlException, IOException {
            return (CTStyleMatrixReference) XmlBeans.getContextTypeLoader().parse(reader, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyleMatrixReference) XmlBeans.getContextTypeLoader().parse(reader, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(String str) throws XmlException {
            return (CTStyleMatrixReference) XmlBeans.getContextTypeLoader().parse(str, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTStyleMatrixReference) XmlBeans.getContextTypeLoader().parse(str, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(URL url) throws XmlException, IOException {
            return (CTStyleMatrixReference) XmlBeans.getContextTypeLoader().parse(url, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyleMatrixReference) XmlBeans.getContextTypeLoader().parse(url, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTStyleMatrixReference) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTStyleMatrixReference) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(Node node) throws XmlException {
            return (CTStyleMatrixReference) XmlBeans.getContextTypeLoader().parse(node, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTStyleMatrixReference) XmlBeans.getContextTypeLoader().parse(node, CTStyleMatrixReference.type, xmlOptions);
        }
    }

    CTHslColor addNewHslClr();

    CTPresetColor addNewPrstClr();

    CTSchemeColor addNewSchemeClr();

    CTScRgbColor addNewScrgbClr();

    CTSRgbColor addNewSrgbClr();

    CTSystemColor addNewSysClr();

    CTHslColor getHslClr();

    long getIdx();

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

    void setIdx(long j);

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

    STStyleMatrixColumnIndex xgetIdx();

    void xsetIdx(STStyleMatrixColumnIndex sTStyleMatrixColumnIndex);
}
