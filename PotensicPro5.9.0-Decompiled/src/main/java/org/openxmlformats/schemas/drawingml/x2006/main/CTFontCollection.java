package org.openxmlformats.schemas.drawingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTFontCollection extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTFontCollection.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctfontcollectiondd68type");

    public static final class Factory {
        private Factory() {
        }

        public static CTFontCollection newInstance() {
            return (CTFontCollection) XmlBeans.getContextTypeLoader().newInstance(CTFontCollection.type, null);
        }

        public static CTFontCollection newInstance(XmlOptions xmlOptions) {
            return (CTFontCollection) XmlBeans.getContextTypeLoader().newInstance(CTFontCollection.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFontCollection.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFontCollection) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFontCollection) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(File file) throws XmlException, IOException {
            return (CTFontCollection) XmlBeans.getContextTypeLoader().parse(file, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontCollection) XmlBeans.getContextTypeLoader().parse(file, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFontCollection) XmlBeans.getContextTypeLoader().parse(inputStream, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontCollection) XmlBeans.getContextTypeLoader().parse(inputStream, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(Reader reader) throws XmlException, IOException {
            return (CTFontCollection) XmlBeans.getContextTypeLoader().parse(reader, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontCollection) XmlBeans.getContextTypeLoader().parse(reader, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(String str) throws XmlException {
            return (CTFontCollection) XmlBeans.getContextTypeLoader().parse(str, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFontCollection) XmlBeans.getContextTypeLoader().parse(str, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(URL url) throws XmlException, IOException {
            return (CTFontCollection) XmlBeans.getContextTypeLoader().parse(url, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontCollection) XmlBeans.getContextTypeLoader().parse(url, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTFontCollection) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTFontCollection) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(Node node) throws XmlException {
            return (CTFontCollection) XmlBeans.getContextTypeLoader().parse(node, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFontCollection) XmlBeans.getContextTypeLoader().parse(node, CTFontCollection.type, xmlOptions);
        }
    }

    CTTextFont addNewCs();

    CTTextFont addNewEa();

    CTOfficeArtExtensionList addNewExtLst();

    CTSupplementalFont addNewFont();

    CTTextFont addNewLatin();

    CTTextFont getCs();

    CTTextFont getEa();

    CTOfficeArtExtensionList getExtLst();

    CTSupplementalFont getFontArray(int i);

    CTSupplementalFont[] getFontArray();

    List<CTSupplementalFont> getFontList();

    CTTextFont getLatin();

    CTSupplementalFont insertNewFont(int i);

    boolean isSetExtLst();

    void removeFont(int i);

    void setCs(CTTextFont cTTextFont);

    void setEa(CTTextFont cTTextFont);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setFontArray(int i, CTSupplementalFont cTSupplementalFont);

    void setFontArray(CTSupplementalFont[] cTSupplementalFontArr);

    void setLatin(CTTextFont cTTextFont);

    int sizeOfFontArray();

    void unsetExtLst();
}
