package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTPageField extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPageField.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpagefield338atype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPageField newInstance() {
            return (CTPageField) XmlBeans.getContextTypeLoader().newInstance(CTPageField.type, null);
        }

        public static CTPageField newInstance(XmlOptions xmlOptions) {
            return (CTPageField) XmlBeans.getContextTypeLoader().newInstance(CTPageField.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPageField.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPageField.type, xmlOptions);
        }

        public static CTPageField parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPageField) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPageField.type, (XmlOptions) null);
        }

        public static CTPageField parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPageField) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPageField.type, xmlOptions);
        }

        public static CTPageField parse(File file) throws XmlException, IOException {
            return (CTPageField) XmlBeans.getContextTypeLoader().parse(file, CTPageField.type, (XmlOptions) null);
        }

        public static CTPageField parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageField) XmlBeans.getContextTypeLoader().parse(file, CTPageField.type, xmlOptions);
        }

        public static CTPageField parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPageField) XmlBeans.getContextTypeLoader().parse(inputStream, CTPageField.type, (XmlOptions) null);
        }

        public static CTPageField parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageField) XmlBeans.getContextTypeLoader().parse(inputStream, CTPageField.type, xmlOptions);
        }

        public static CTPageField parse(Reader reader) throws XmlException, IOException {
            return (CTPageField) XmlBeans.getContextTypeLoader().parse(reader, CTPageField.type, (XmlOptions) null);
        }

        public static CTPageField parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageField) XmlBeans.getContextTypeLoader().parse(reader, CTPageField.type, xmlOptions);
        }

        public static CTPageField parse(String str) throws XmlException {
            return (CTPageField) XmlBeans.getContextTypeLoader().parse(str, CTPageField.type, (XmlOptions) null);
        }

        public static CTPageField parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPageField) XmlBeans.getContextTypeLoader().parse(str, CTPageField.type, xmlOptions);
        }

        public static CTPageField parse(URL url) throws XmlException, IOException {
            return (CTPageField) XmlBeans.getContextTypeLoader().parse(url, CTPageField.type, (XmlOptions) null);
        }

        public static CTPageField parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageField) XmlBeans.getContextTypeLoader().parse(url, CTPageField.type, xmlOptions);
        }

        public static CTPageField parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPageField) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPageField.type, (XmlOptions) null);
        }

        public static CTPageField parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPageField) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPageField.type, xmlOptions);
        }

        public static CTPageField parse(Node node) throws XmlException {
            return (CTPageField) XmlBeans.getContextTypeLoader().parse(node, CTPageField.type, (XmlOptions) null);
        }

        public static CTPageField parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPageField) XmlBeans.getContextTypeLoader().parse(node, CTPageField.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    String getCap();

    CTExtensionList getExtLst();

    int getFld();

    int getHier();

    long getItem();

    String getName();

    boolean isSetCap();

    boolean isSetExtLst();

    boolean isSetHier();

    boolean isSetItem();

    boolean isSetName();

    void setCap(String str);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFld(int i);

    void setHier(int i);

    void setItem(long j);

    void setName(String str);

    void unsetCap();

    void unsetExtLst();

    void unsetHier();

    void unsetItem();

    void unsetName();

    STXstring xgetCap();

    XmlInt xgetFld();

    XmlInt xgetHier();

    XmlUnsignedInt xgetItem();

    STXstring xgetName();

    void xsetCap(STXstring sTXstring);

    void xsetFld(XmlInt xmlInt);

    void xsetHier(XmlInt xmlInt);

    void xsetItem(XmlUnsignedInt xmlUnsignedInt);

    void xsetName(STXstring sTXstring);
}
