package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTFldChar extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTFldChar.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctfldchare83etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFldChar newInstance() {
            return (CTFldChar) XmlBeans.getContextTypeLoader().newInstance(CTFldChar.type, null);
        }

        public static CTFldChar newInstance(XmlOptions xmlOptions) {
            return (CTFldChar) XmlBeans.getContextTypeLoader().newInstance(CTFldChar.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFldChar.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFldChar) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFldChar) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(File file) throws XmlException, IOException {
            return (CTFldChar) XmlBeans.getContextTypeLoader().parse(file, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFldChar) XmlBeans.getContextTypeLoader().parse(file, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFldChar) XmlBeans.getContextTypeLoader().parse(inputStream, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFldChar) XmlBeans.getContextTypeLoader().parse(inputStream, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(Reader reader) throws XmlException, IOException {
            return (CTFldChar) XmlBeans.getContextTypeLoader().parse(reader, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFldChar) XmlBeans.getContextTypeLoader().parse(reader, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(String str) throws XmlException {
            return (CTFldChar) XmlBeans.getContextTypeLoader().parse(str, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFldChar) XmlBeans.getContextTypeLoader().parse(str, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(URL url) throws XmlException, IOException {
            return (CTFldChar) XmlBeans.getContextTypeLoader().parse(url, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFldChar) XmlBeans.getContextTypeLoader().parse(url, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTFldChar) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTFldChar) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(Node node) throws XmlException {
            return (CTFldChar) XmlBeans.getContextTypeLoader().parse(node, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFldChar) XmlBeans.getContextTypeLoader().parse(node, CTFldChar.type, xmlOptions);
        }
    }

    CTFFData addNewFfData();

    CTText addNewFldData();

    CTTrackChangeNumbering addNewNumberingChange();

    STOnOff.Enum getDirty();

    CTFFData getFfData();

    STFldCharType.Enum getFldCharType();

    CTText getFldData();

    STOnOff.Enum getFldLock();

    CTTrackChangeNumbering getNumberingChange();

    boolean isSetDirty();

    boolean isSetFfData();

    boolean isSetFldData();

    boolean isSetFldLock();

    boolean isSetNumberingChange();

    void setDirty(STOnOff.Enum r1);

    void setFfData(CTFFData cTFFData);

    void setFldCharType(STFldCharType.Enum r1);

    void setFldData(CTText cTText);

    void setFldLock(STOnOff.Enum r1);

    void setNumberingChange(CTTrackChangeNumbering cTTrackChangeNumbering);

    void unsetDirty();

    void unsetFfData();

    void unsetFldData();

    void unsetFldLock();

    void unsetNumberingChange();

    STOnOff xgetDirty();

    STFldCharType xgetFldCharType();

    STOnOff xgetFldLock();

    void xsetDirty(STOnOff sTOnOff);

    void xsetFldCharType(STFldCharType sTFldCharType);

    void xsetFldLock(STOnOff sTOnOff);
}
