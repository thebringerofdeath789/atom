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
import org.openxmlformats.schemas.drawingml.x2006.main.STFontCollectionIndex;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTFontReference extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTFontReference.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctfontreferencef5adtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFontReference newInstance() {
            return (CTFontReference) XmlBeans.getContextTypeLoader().newInstance(CTFontReference.type, null);
        }

        public static CTFontReference newInstance(XmlOptions xmlOptions) {
            return (CTFontReference) XmlBeans.getContextTypeLoader().newInstance(CTFontReference.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFontReference.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFontReference.type, xmlOptions);
        }

        public static CTFontReference parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFontReference) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFontReference.type, (XmlOptions) null);
        }

        public static CTFontReference parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFontReference) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFontReference.type, xmlOptions);
        }

        public static CTFontReference parse(File file) throws XmlException, IOException {
            return (CTFontReference) XmlBeans.getContextTypeLoader().parse(file, CTFontReference.type, (XmlOptions) null);
        }

        public static CTFontReference parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontReference) XmlBeans.getContextTypeLoader().parse(file, CTFontReference.type, xmlOptions);
        }

        public static CTFontReference parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFontReference) XmlBeans.getContextTypeLoader().parse(inputStream, CTFontReference.type, (XmlOptions) null);
        }

        public static CTFontReference parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontReference) XmlBeans.getContextTypeLoader().parse(inputStream, CTFontReference.type, xmlOptions);
        }

        public static CTFontReference parse(Reader reader) throws XmlException, IOException {
            return (CTFontReference) XmlBeans.getContextTypeLoader().parse(reader, CTFontReference.type, (XmlOptions) null);
        }

        public static CTFontReference parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontReference) XmlBeans.getContextTypeLoader().parse(reader, CTFontReference.type, xmlOptions);
        }

        public static CTFontReference parse(String str) throws XmlException {
            return (CTFontReference) XmlBeans.getContextTypeLoader().parse(str, CTFontReference.type, (XmlOptions) null);
        }

        public static CTFontReference parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFontReference) XmlBeans.getContextTypeLoader().parse(str, CTFontReference.type, xmlOptions);
        }

        public static CTFontReference parse(URL url) throws XmlException, IOException {
            return (CTFontReference) XmlBeans.getContextTypeLoader().parse(url, CTFontReference.type, (XmlOptions) null);
        }

        public static CTFontReference parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontReference) XmlBeans.getContextTypeLoader().parse(url, CTFontReference.type, xmlOptions);
        }

        public static CTFontReference parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTFontReference) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFontReference.type, (XmlOptions) null);
        }

        public static CTFontReference parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTFontReference) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFontReference.type, xmlOptions);
        }

        public static CTFontReference parse(Node node) throws XmlException {
            return (CTFontReference) XmlBeans.getContextTypeLoader().parse(node, CTFontReference.type, (XmlOptions) null);
        }

        public static CTFontReference parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFontReference) XmlBeans.getContextTypeLoader().parse(node, CTFontReference.type, xmlOptions);
        }
    }

    CTHslColor addNewHslClr();

    CTPresetColor addNewPrstClr();

    CTSchemeColor addNewSchemeClr();

    CTScRgbColor addNewScrgbClr();

    CTSRgbColor addNewSrgbClr();

    CTSystemColor addNewSysClr();

    CTHslColor getHslClr();

    STFontCollectionIndex.Enum getIdx();

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

    void setIdx(STFontCollectionIndex.Enum r1);

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

    STFontCollectionIndex xgetIdx();

    void xsetIdx(STFontCollectionIndex sTFontCollectionIndex);
}
