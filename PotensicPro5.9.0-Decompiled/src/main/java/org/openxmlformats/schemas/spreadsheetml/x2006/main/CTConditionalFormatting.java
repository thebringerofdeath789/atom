package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTConditionalFormatting extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTConditionalFormatting.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctconditionalformatting0deatype");

    public static final class Factory {
        private Factory() {
        }

        public static CTConditionalFormatting newInstance() {
            return (CTConditionalFormatting) XmlBeans.getContextTypeLoader().newInstance(CTConditionalFormatting.type, null);
        }

        public static CTConditionalFormatting newInstance(XmlOptions xmlOptions) {
            return (CTConditionalFormatting) XmlBeans.getContextTypeLoader().newInstance(CTConditionalFormatting.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTConditionalFormatting.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTConditionalFormatting.type, xmlOptions);
        }

        public static CTConditionalFormatting parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTConditionalFormatting) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTConditionalFormatting.type, (XmlOptions) null);
        }

        public static CTConditionalFormatting parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTConditionalFormatting) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTConditionalFormatting.type, xmlOptions);
        }

        public static CTConditionalFormatting parse(File file) throws XmlException, IOException {
            return (CTConditionalFormatting) XmlBeans.getContextTypeLoader().parse(file, CTConditionalFormatting.type, (XmlOptions) null);
        }

        public static CTConditionalFormatting parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConditionalFormatting) XmlBeans.getContextTypeLoader().parse(file, CTConditionalFormatting.type, xmlOptions);
        }

        public static CTConditionalFormatting parse(InputStream inputStream) throws XmlException, IOException {
            return (CTConditionalFormatting) XmlBeans.getContextTypeLoader().parse(inputStream, CTConditionalFormatting.type, (XmlOptions) null);
        }

        public static CTConditionalFormatting parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConditionalFormatting) XmlBeans.getContextTypeLoader().parse(inputStream, CTConditionalFormatting.type, xmlOptions);
        }

        public static CTConditionalFormatting parse(Reader reader) throws XmlException, IOException {
            return (CTConditionalFormatting) XmlBeans.getContextTypeLoader().parse(reader, CTConditionalFormatting.type, (XmlOptions) null);
        }

        public static CTConditionalFormatting parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConditionalFormatting) XmlBeans.getContextTypeLoader().parse(reader, CTConditionalFormatting.type, xmlOptions);
        }

        public static CTConditionalFormatting parse(String str) throws XmlException {
            return (CTConditionalFormatting) XmlBeans.getContextTypeLoader().parse(str, CTConditionalFormatting.type, (XmlOptions) null);
        }

        public static CTConditionalFormatting parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTConditionalFormatting) XmlBeans.getContextTypeLoader().parse(str, CTConditionalFormatting.type, xmlOptions);
        }

        public static CTConditionalFormatting parse(URL url) throws XmlException, IOException {
            return (CTConditionalFormatting) XmlBeans.getContextTypeLoader().parse(url, CTConditionalFormatting.type, (XmlOptions) null);
        }

        public static CTConditionalFormatting parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTConditionalFormatting) XmlBeans.getContextTypeLoader().parse(url, CTConditionalFormatting.type, xmlOptions);
        }

        public static CTConditionalFormatting parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTConditionalFormatting) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTConditionalFormatting.type, (XmlOptions) null);
        }

        public static CTConditionalFormatting parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTConditionalFormatting) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTConditionalFormatting.type, xmlOptions);
        }

        public static CTConditionalFormatting parse(Node node) throws XmlException {
            return (CTConditionalFormatting) XmlBeans.getContextTypeLoader().parse(node, CTConditionalFormatting.type, (XmlOptions) null);
        }

        public static CTConditionalFormatting parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTConditionalFormatting) XmlBeans.getContextTypeLoader().parse(node, CTConditionalFormatting.type, xmlOptions);
        }
    }

    CTCfRule addNewCfRule();

    CTExtensionList addNewExtLst();

    CTCfRule getCfRuleArray(int i);

    CTCfRule[] getCfRuleArray();

    List<CTCfRule> getCfRuleList();

    CTExtensionList getExtLst();

    boolean getPivot();

    List getSqref();

    CTCfRule insertNewCfRule(int i);

    boolean isSetExtLst();

    boolean isSetPivot();

    boolean isSetSqref();

    void removeCfRule(int i);

    void setCfRuleArray(int i, CTCfRule cTCfRule);

    void setCfRuleArray(CTCfRule[] cTCfRuleArr);

    void setExtLst(CTExtensionList cTExtensionList);

    void setPivot(boolean z);

    void setSqref(List list);

    int sizeOfCfRuleArray();

    void unsetExtLst();

    void unsetPivot();

    void unsetSqref();

    XmlBoolean xgetPivot();

    STSqref xgetSqref();

    void xsetPivot(XmlBoolean xmlBoolean);

    void xsetSqref(STSqref sTSqref);
}
