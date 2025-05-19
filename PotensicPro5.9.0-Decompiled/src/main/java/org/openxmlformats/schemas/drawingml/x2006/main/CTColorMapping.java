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
import org.openxmlformats.schemas.drawingml.x2006.main.STColorSchemeIndex;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface CTColorMapping extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTColorMapping.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctcolormapping5bc6type");

    public static final class Factory {
        private Factory() {
        }

        public static CTColorMapping newInstance() {
            return (CTColorMapping) XmlBeans.getContextTypeLoader().newInstance(CTColorMapping.type, null);
        }

        public static CTColorMapping newInstance(XmlOptions xmlOptions) {
            return (CTColorMapping) XmlBeans.getContextTypeLoader().newInstance(CTColorMapping.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTColorMapping.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTColorMapping.type, xmlOptions);
        }

        public static CTColorMapping parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTColorMapping) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTColorMapping.type, (XmlOptions) null);
        }

        public static CTColorMapping parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTColorMapping) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTColorMapping.type, xmlOptions);
        }

        public static CTColorMapping parse(File file) throws XmlException, IOException {
            return (CTColorMapping) XmlBeans.getContextTypeLoader().parse(file, CTColorMapping.type, (XmlOptions) null);
        }

        public static CTColorMapping parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColorMapping) XmlBeans.getContextTypeLoader().parse(file, CTColorMapping.type, xmlOptions);
        }

        public static CTColorMapping parse(InputStream inputStream) throws XmlException, IOException {
            return (CTColorMapping) XmlBeans.getContextTypeLoader().parse(inputStream, CTColorMapping.type, (XmlOptions) null);
        }

        public static CTColorMapping parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColorMapping) XmlBeans.getContextTypeLoader().parse(inputStream, CTColorMapping.type, xmlOptions);
        }

        public static CTColorMapping parse(Reader reader) throws XmlException, IOException {
            return (CTColorMapping) XmlBeans.getContextTypeLoader().parse(reader, CTColorMapping.type, (XmlOptions) null);
        }

        public static CTColorMapping parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColorMapping) XmlBeans.getContextTypeLoader().parse(reader, CTColorMapping.type, xmlOptions);
        }

        public static CTColorMapping parse(String str) throws XmlException {
            return (CTColorMapping) XmlBeans.getContextTypeLoader().parse(str, CTColorMapping.type, (XmlOptions) null);
        }

        public static CTColorMapping parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTColorMapping) XmlBeans.getContextTypeLoader().parse(str, CTColorMapping.type, xmlOptions);
        }

        public static CTColorMapping parse(URL url) throws XmlException, IOException {
            return (CTColorMapping) XmlBeans.getContextTypeLoader().parse(url, CTColorMapping.type, (XmlOptions) null);
        }

        public static CTColorMapping parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColorMapping) XmlBeans.getContextTypeLoader().parse(url, CTColorMapping.type, xmlOptions);
        }

        public static CTColorMapping parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTColorMapping) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTColorMapping.type, (XmlOptions) null);
        }

        public static CTColorMapping parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTColorMapping) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTColorMapping.type, xmlOptions);
        }

        public static CTColorMapping parse(Node node) throws XmlException {
            return (CTColorMapping) XmlBeans.getContextTypeLoader().parse(node, CTColorMapping.type, (XmlOptions) null);
        }

        public static CTColorMapping parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTColorMapping) XmlBeans.getContextTypeLoader().parse(node, CTColorMapping.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    STColorSchemeIndex.Enum getAccent1();

    STColorSchemeIndex.Enum getAccent2();

    STColorSchemeIndex.Enum getAccent3();

    STColorSchemeIndex.Enum getAccent4();

    STColorSchemeIndex.Enum getAccent5();

    STColorSchemeIndex.Enum getAccent6();

    STColorSchemeIndex.Enum getBg1();

    STColorSchemeIndex.Enum getBg2();

    CTOfficeArtExtensionList getExtLst();

    STColorSchemeIndex.Enum getFolHlink();

    STColorSchemeIndex.Enum getHlink();

    STColorSchemeIndex.Enum getTx1();

    STColorSchemeIndex.Enum getTx2();

    boolean isSetExtLst();

    void setAccent1(STColorSchemeIndex.Enum r1);

    void setAccent2(STColorSchemeIndex.Enum r1);

    void setAccent3(STColorSchemeIndex.Enum r1);

    void setAccent4(STColorSchemeIndex.Enum r1);

    void setAccent5(STColorSchemeIndex.Enum r1);

    void setAccent6(STColorSchemeIndex.Enum r1);

    void setBg1(STColorSchemeIndex.Enum r1);

    void setBg2(STColorSchemeIndex.Enum r1);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setFolHlink(STColorSchemeIndex.Enum r1);

    void setHlink(STColorSchemeIndex.Enum r1);

    void setTx1(STColorSchemeIndex.Enum r1);

    void setTx2(STColorSchemeIndex.Enum r1);

    void unsetExtLst();

    STColorSchemeIndex xgetAccent1();

    STColorSchemeIndex xgetAccent2();

    STColorSchemeIndex xgetAccent3();

    STColorSchemeIndex xgetAccent4();

    STColorSchemeIndex xgetAccent5();

    STColorSchemeIndex xgetAccent6();

    STColorSchemeIndex xgetBg1();

    STColorSchemeIndex xgetBg2();

    STColorSchemeIndex xgetFolHlink();

    STColorSchemeIndex xgetHlink();

    STColorSchemeIndex xgetTx1();

    STColorSchemeIndex xgetTx2();

    void xsetAccent1(STColorSchemeIndex sTColorSchemeIndex);

    void xsetAccent2(STColorSchemeIndex sTColorSchemeIndex);

    void xsetAccent3(STColorSchemeIndex sTColorSchemeIndex);

    void xsetAccent4(STColorSchemeIndex sTColorSchemeIndex);

    void xsetAccent5(STColorSchemeIndex sTColorSchemeIndex);

    void xsetAccent6(STColorSchemeIndex sTColorSchemeIndex);

    void xsetBg1(STColorSchemeIndex sTColorSchemeIndex);

    void xsetBg2(STColorSchemeIndex sTColorSchemeIndex);

    void xsetFolHlink(STColorSchemeIndex sTColorSchemeIndex);

    void xsetHlink(STColorSchemeIndex sTColorSchemeIndex);

    void xsetTx1(STColorSchemeIndex sTColorSchemeIndex);

    void xsetTx2(STColorSchemeIndex sTColorSchemeIndex);
}
