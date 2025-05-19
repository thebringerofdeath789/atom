package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
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

/* loaded from: classes6.dex */
public interface CTNum extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTNum.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctnume94ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTNum newInstance() {
            return (CTNum) XmlBeans.getContextTypeLoader().newInstance(CTNum.type, null);
        }

        public static CTNum newInstance(XmlOptions xmlOptions) {
            return (CTNum) XmlBeans.getContextTypeLoader().newInstance(CTNum.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNum.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNum.type, xmlOptions);
        }

        public static CTNum parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNum) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNum.type, (XmlOptions) null);
        }

        public static CTNum parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNum) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNum.type, xmlOptions);
        }

        public static CTNum parse(File file) throws XmlException, IOException {
            return (CTNum) XmlBeans.getContextTypeLoader().parse(file, CTNum.type, (XmlOptions) null);
        }

        public static CTNum parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNum) XmlBeans.getContextTypeLoader().parse(file, CTNum.type, xmlOptions);
        }

        public static CTNum parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNum) XmlBeans.getContextTypeLoader().parse(inputStream, CTNum.type, (XmlOptions) null);
        }

        public static CTNum parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNum) XmlBeans.getContextTypeLoader().parse(inputStream, CTNum.type, xmlOptions);
        }

        public static CTNum parse(Reader reader) throws XmlException, IOException {
            return (CTNum) XmlBeans.getContextTypeLoader().parse(reader, CTNum.type, (XmlOptions) null);
        }

        public static CTNum parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNum) XmlBeans.getContextTypeLoader().parse(reader, CTNum.type, xmlOptions);
        }

        public static CTNum parse(String str) throws XmlException {
            return (CTNum) XmlBeans.getContextTypeLoader().parse(str, CTNum.type, (XmlOptions) null);
        }

        public static CTNum parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNum) XmlBeans.getContextTypeLoader().parse(str, CTNum.type, xmlOptions);
        }

        public static CTNum parse(URL url) throws XmlException, IOException {
            return (CTNum) XmlBeans.getContextTypeLoader().parse(url, CTNum.type, (XmlOptions) null);
        }

        public static CTNum parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNum) XmlBeans.getContextTypeLoader().parse(url, CTNum.type, xmlOptions);
        }

        public static CTNum parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTNum) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNum.type, (XmlOptions) null);
        }

        public static CTNum parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTNum) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNum.type, xmlOptions);
        }

        public static CTNum parse(Node node) throws XmlException {
            return (CTNum) XmlBeans.getContextTypeLoader().parse(node, CTNum.type, (XmlOptions) null);
        }

        public static CTNum parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNum) XmlBeans.getContextTypeLoader().parse(node, CTNum.type, xmlOptions);
        }
    }

    CTDecimalNumber addNewAbstractNumId();

    CTNumLvl addNewLvlOverride();

    CTDecimalNumber getAbstractNumId();

    CTNumLvl getLvlOverrideArray(int i);

    CTNumLvl[] getLvlOverrideArray();

    List<CTNumLvl> getLvlOverrideList();

    BigInteger getNumId();

    CTNumLvl insertNewLvlOverride(int i);

    void removeLvlOverride(int i);

    void setAbstractNumId(CTDecimalNumber cTDecimalNumber);

    void setLvlOverrideArray(int i, CTNumLvl cTNumLvl);

    void setLvlOverrideArray(CTNumLvl[] cTNumLvlArr);

    void setNumId(BigInteger bigInteger);

    int sizeOfLvlOverrideArray();

    STDecimalNumber xgetNumId();

    void xsetNumId(STDecimalNumber sTDecimalNumber);
}
