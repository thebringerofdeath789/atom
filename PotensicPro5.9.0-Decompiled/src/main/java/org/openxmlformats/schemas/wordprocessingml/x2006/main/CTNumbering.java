package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

/* loaded from: classes6.dex */
public interface CTNumbering extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTNumbering.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctnumberingfdf9type");

    public static final class Factory {
        private Factory() {
        }

        public static CTNumbering newInstance() {
            return (CTNumbering) XmlBeans.getContextTypeLoader().newInstance(CTNumbering.type, null);
        }

        public static CTNumbering newInstance(XmlOptions xmlOptions) {
            return (CTNumbering) XmlBeans.getContextTypeLoader().newInstance(CTNumbering.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNumbering.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTNumbering.type, xmlOptions);
        }

        public static CTNumbering parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNumbering) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNumbering.type, (XmlOptions) null);
        }

        public static CTNumbering parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNumbering) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTNumbering.type, xmlOptions);
        }

        public static CTNumbering parse(File file) throws XmlException, IOException {
            return (CTNumbering) XmlBeans.getContextTypeLoader().parse(file, CTNumbering.type, (XmlOptions) null);
        }

        public static CTNumbering parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumbering) XmlBeans.getContextTypeLoader().parse(file, CTNumbering.type, xmlOptions);
        }

        public static CTNumbering parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNumbering) XmlBeans.getContextTypeLoader().parse(inputStream, CTNumbering.type, (XmlOptions) null);
        }

        public static CTNumbering parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumbering) XmlBeans.getContextTypeLoader().parse(inputStream, CTNumbering.type, xmlOptions);
        }

        public static CTNumbering parse(Reader reader) throws XmlException, IOException {
            return (CTNumbering) XmlBeans.getContextTypeLoader().parse(reader, CTNumbering.type, (XmlOptions) null);
        }

        public static CTNumbering parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumbering) XmlBeans.getContextTypeLoader().parse(reader, CTNumbering.type, xmlOptions);
        }

        public static CTNumbering parse(String str) throws XmlException {
            return (CTNumbering) XmlBeans.getContextTypeLoader().parse(str, CTNumbering.type, (XmlOptions) null);
        }

        public static CTNumbering parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNumbering) XmlBeans.getContextTypeLoader().parse(str, CTNumbering.type, xmlOptions);
        }

        public static CTNumbering parse(URL url) throws XmlException, IOException {
            return (CTNumbering) XmlBeans.getContextTypeLoader().parse(url, CTNumbering.type, (XmlOptions) null);
        }

        public static CTNumbering parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNumbering) XmlBeans.getContextTypeLoader().parse(url, CTNumbering.type, xmlOptions);
        }

        public static CTNumbering parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTNumbering) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNumbering.type, (XmlOptions) null);
        }

        public static CTNumbering parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTNumbering) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTNumbering.type, xmlOptions);
        }

        public static CTNumbering parse(Node node) throws XmlException {
            return (CTNumbering) XmlBeans.getContextTypeLoader().parse(node, CTNumbering.type, (XmlOptions) null);
        }

        public static CTNumbering parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNumbering) XmlBeans.getContextTypeLoader().parse(node, CTNumbering.type, xmlOptions);
        }
    }

    CTAbstractNum addNewAbstractNum();

    CTNum addNewNum();

    CTDecimalNumber addNewNumIdMacAtCleanup();

    CTNumPicBullet addNewNumPicBullet();

    CTAbstractNum getAbstractNumArray(int i);

    CTAbstractNum[] getAbstractNumArray();

    List<CTAbstractNum> getAbstractNumList();

    CTNum getNumArray(int i);

    CTNum[] getNumArray();

    CTDecimalNumber getNumIdMacAtCleanup();

    List<CTNum> getNumList();

    CTNumPicBullet getNumPicBulletArray(int i);

    CTNumPicBullet[] getNumPicBulletArray();

    List<CTNumPicBullet> getNumPicBulletList();

    CTAbstractNum insertNewAbstractNum(int i);

    CTNum insertNewNum(int i);

    CTNumPicBullet insertNewNumPicBullet(int i);

    boolean isSetNumIdMacAtCleanup();

    void removeAbstractNum(int i);

    void removeNum(int i);

    void removeNumPicBullet(int i);

    void setAbstractNumArray(int i, CTAbstractNum cTAbstractNum);

    void setAbstractNumArray(CTAbstractNum[] cTAbstractNumArr);

    void setNumArray(int i, CTNum cTNum);

    void setNumArray(CTNum[] cTNumArr);

    void setNumIdMacAtCleanup(CTDecimalNumber cTDecimalNumber);

    void setNumPicBulletArray(int i, CTNumPicBullet cTNumPicBullet);

    void setNumPicBulletArray(CTNumPicBullet[] cTNumPicBulletArr);

    int sizeOfAbstractNumArray();

    int sizeOfNumArray();

    int sizeOfNumPicBulletArray();

    void unsetNumIdMacAtCleanup();
}
