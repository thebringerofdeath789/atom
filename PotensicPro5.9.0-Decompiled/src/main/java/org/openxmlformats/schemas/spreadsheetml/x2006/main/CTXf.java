package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
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
public interface CTXf extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTXf.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctxf97f7type");

    public static final class Factory {
        private Factory() {
        }

        public static CTXf newInstance() {
            return (CTXf) XmlBeans.getContextTypeLoader().newInstance(CTXf.type, null);
        }

        public static CTXf newInstance(XmlOptions xmlOptions) {
            return (CTXf) XmlBeans.getContextTypeLoader().newInstance(CTXf.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTXf.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTXf.type, xmlOptions);
        }

        public static CTXf parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTXf) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTXf.type, (XmlOptions) null);
        }

        public static CTXf parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTXf) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTXf.type, xmlOptions);
        }

        public static CTXf parse(File file) throws XmlException, IOException {
            return (CTXf) XmlBeans.getContextTypeLoader().parse(file, CTXf.type, (XmlOptions) null);
        }

        public static CTXf parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXf) XmlBeans.getContextTypeLoader().parse(file, CTXf.type, xmlOptions);
        }

        public static CTXf parse(InputStream inputStream) throws XmlException, IOException {
            return (CTXf) XmlBeans.getContextTypeLoader().parse(inputStream, CTXf.type, (XmlOptions) null);
        }

        public static CTXf parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXf) XmlBeans.getContextTypeLoader().parse(inputStream, CTXf.type, xmlOptions);
        }

        public static CTXf parse(Reader reader) throws XmlException, IOException {
            return (CTXf) XmlBeans.getContextTypeLoader().parse(reader, CTXf.type, (XmlOptions) null);
        }

        public static CTXf parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXf) XmlBeans.getContextTypeLoader().parse(reader, CTXf.type, xmlOptions);
        }

        public static CTXf parse(String str) throws XmlException {
            return (CTXf) XmlBeans.getContextTypeLoader().parse(str, CTXf.type, (XmlOptions) null);
        }

        public static CTXf parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTXf) XmlBeans.getContextTypeLoader().parse(str, CTXf.type, xmlOptions);
        }

        public static CTXf parse(URL url) throws XmlException, IOException {
            return (CTXf) XmlBeans.getContextTypeLoader().parse(url, CTXf.type, (XmlOptions) null);
        }

        public static CTXf parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTXf) XmlBeans.getContextTypeLoader().parse(url, CTXf.type, xmlOptions);
        }

        public static CTXf parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTXf) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTXf.type, (XmlOptions) null);
        }

        public static CTXf parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTXf) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTXf.type, xmlOptions);
        }

        public static CTXf parse(Node node) throws XmlException {
            return (CTXf) XmlBeans.getContextTypeLoader().parse(node, CTXf.type, (XmlOptions) null);
        }

        public static CTXf parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTXf) XmlBeans.getContextTypeLoader().parse(node, CTXf.type, xmlOptions);
        }
    }

    CTCellAlignment addNewAlignment();

    CTExtensionList addNewExtLst();

    CTCellProtection addNewProtection();

    CTCellAlignment getAlignment();

    boolean getApplyAlignment();

    boolean getApplyBorder();

    boolean getApplyFill();

    boolean getApplyFont();

    boolean getApplyNumberFormat();

    boolean getApplyProtection();

    long getBorderId();

    CTExtensionList getExtLst();

    long getFillId();

    long getFontId();

    long getNumFmtId();

    boolean getPivotButton();

    CTCellProtection getProtection();

    boolean getQuotePrefix();

    long getXfId();

    boolean isSetAlignment();

    boolean isSetApplyAlignment();

    boolean isSetApplyBorder();

    boolean isSetApplyFill();

    boolean isSetApplyFont();

    boolean isSetApplyNumberFormat();

    boolean isSetApplyProtection();

    boolean isSetBorderId();

    boolean isSetExtLst();

    boolean isSetFillId();

    boolean isSetFontId();

    boolean isSetNumFmtId();

    boolean isSetPivotButton();

    boolean isSetProtection();

    boolean isSetQuotePrefix();

    boolean isSetXfId();

    void setAlignment(CTCellAlignment cTCellAlignment);

    void setApplyAlignment(boolean z);

    void setApplyBorder(boolean z);

    void setApplyFill(boolean z);

    void setApplyFont(boolean z);

    void setApplyNumberFormat(boolean z);

    void setApplyProtection(boolean z);

    void setBorderId(long j);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFillId(long j);

    void setFontId(long j);

    void setNumFmtId(long j);

    void setPivotButton(boolean z);

    void setProtection(CTCellProtection cTCellProtection);

    void setQuotePrefix(boolean z);

    void setXfId(long j);

    void unsetAlignment();

    void unsetApplyAlignment();

    void unsetApplyBorder();

    void unsetApplyFill();

    void unsetApplyFont();

    void unsetApplyNumberFormat();

    void unsetApplyProtection();

    void unsetBorderId();

    void unsetExtLst();

    void unsetFillId();

    void unsetFontId();

    void unsetNumFmtId();

    void unsetPivotButton();

    void unsetProtection();

    void unsetQuotePrefix();

    void unsetXfId();

    XmlBoolean xgetApplyAlignment();

    XmlBoolean xgetApplyBorder();

    XmlBoolean xgetApplyFill();

    XmlBoolean xgetApplyFont();

    XmlBoolean xgetApplyNumberFormat();

    XmlBoolean xgetApplyProtection();

    STBorderId xgetBorderId();

    STFillId xgetFillId();

    STFontId xgetFontId();

    STNumFmtId xgetNumFmtId();

    XmlBoolean xgetPivotButton();

    XmlBoolean xgetQuotePrefix();

    STCellStyleXfId xgetXfId();

    void xsetApplyAlignment(XmlBoolean xmlBoolean);

    void xsetApplyBorder(XmlBoolean xmlBoolean);

    void xsetApplyFill(XmlBoolean xmlBoolean);

    void xsetApplyFont(XmlBoolean xmlBoolean);

    void xsetApplyNumberFormat(XmlBoolean xmlBoolean);

    void xsetApplyProtection(XmlBoolean xmlBoolean);

    void xsetBorderId(STBorderId sTBorderId);

    void xsetFillId(STFillId sTFillId);

    void xsetFontId(STFontId sTFontId);

    void xsetNumFmtId(STNumFmtId sTNumFmtId);

    void xsetPivotButton(XmlBoolean xmlBoolean);

    void xsetQuotePrefix(XmlBoolean xmlBoolean);

    void xsetXfId(STCellStyleXfId sTCellStyleXfId);
}
