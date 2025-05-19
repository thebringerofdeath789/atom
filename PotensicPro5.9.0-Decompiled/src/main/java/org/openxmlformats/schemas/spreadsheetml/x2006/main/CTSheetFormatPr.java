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
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTSheetFormatPr extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSheetFormatPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctsheetformatprdef7type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSheetFormatPr newInstance() {
            return (CTSheetFormatPr) XmlBeans.getContextTypeLoader().newInstance(CTSheetFormatPr.type, null);
        }

        public static CTSheetFormatPr newInstance(XmlOptions xmlOptions) {
            return (CTSheetFormatPr) XmlBeans.getContextTypeLoader().newInstance(CTSheetFormatPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSheetFormatPr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSheetFormatPr.type, xmlOptions);
        }

        public static CTSheetFormatPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSheetFormatPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSheetFormatPr.type, (XmlOptions) null);
        }

        public static CTSheetFormatPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetFormatPr) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSheetFormatPr.type, xmlOptions);
        }

        public static CTSheetFormatPr parse(File file) throws XmlException, IOException {
            return (CTSheetFormatPr) XmlBeans.getContextTypeLoader().parse(file, CTSheetFormatPr.type, (XmlOptions) null);
        }

        public static CTSheetFormatPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetFormatPr) XmlBeans.getContextTypeLoader().parse(file, CTSheetFormatPr.type, xmlOptions);
        }

        public static CTSheetFormatPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSheetFormatPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTSheetFormatPr.type, (XmlOptions) null);
        }

        public static CTSheetFormatPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetFormatPr) XmlBeans.getContextTypeLoader().parse(inputStream, CTSheetFormatPr.type, xmlOptions);
        }

        public static CTSheetFormatPr parse(Reader reader) throws XmlException, IOException {
            return (CTSheetFormatPr) XmlBeans.getContextTypeLoader().parse(reader, CTSheetFormatPr.type, (XmlOptions) null);
        }

        public static CTSheetFormatPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetFormatPr) XmlBeans.getContextTypeLoader().parse(reader, CTSheetFormatPr.type, xmlOptions);
        }

        public static CTSheetFormatPr parse(String str) throws XmlException {
            return (CTSheetFormatPr) XmlBeans.getContextTypeLoader().parse(str, CTSheetFormatPr.type, (XmlOptions) null);
        }

        public static CTSheetFormatPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetFormatPr) XmlBeans.getContextTypeLoader().parse(str, CTSheetFormatPr.type, xmlOptions);
        }

        public static CTSheetFormatPr parse(URL url) throws XmlException, IOException {
            return (CTSheetFormatPr) XmlBeans.getContextTypeLoader().parse(url, CTSheetFormatPr.type, (XmlOptions) null);
        }

        public static CTSheetFormatPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetFormatPr) XmlBeans.getContextTypeLoader().parse(url, CTSheetFormatPr.type, xmlOptions);
        }

        public static CTSheetFormatPr parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSheetFormatPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSheetFormatPr.type, (XmlOptions) null);
        }

        public static CTSheetFormatPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSheetFormatPr) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSheetFormatPr.type, xmlOptions);
        }

        public static CTSheetFormatPr parse(Node node) throws XmlException {
            return (CTSheetFormatPr) XmlBeans.getContextTypeLoader().parse(node, CTSheetFormatPr.type, (XmlOptions) null);
        }

        public static CTSheetFormatPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetFormatPr) XmlBeans.getContextTypeLoader().parse(node, CTSheetFormatPr.type, xmlOptions);
        }
    }

    long getBaseColWidth();

    boolean getCustomHeight();

    double getDefaultColWidth();

    double getDefaultRowHeight();

    short getOutlineLevelCol();

    short getOutlineLevelRow();

    boolean getThickBottom();

    boolean getThickTop();

    boolean getZeroHeight();

    boolean isSetBaseColWidth();

    boolean isSetCustomHeight();

    boolean isSetDefaultColWidth();

    boolean isSetOutlineLevelCol();

    boolean isSetOutlineLevelRow();

    boolean isSetThickBottom();

    boolean isSetThickTop();

    boolean isSetZeroHeight();

    void setBaseColWidth(long j);

    void setCustomHeight(boolean z);

    void setDefaultColWidth(double d);

    void setDefaultRowHeight(double d);

    void setOutlineLevelCol(short s);

    void setOutlineLevelRow(short s);

    void setThickBottom(boolean z);

    void setThickTop(boolean z);

    void setZeroHeight(boolean z);

    void unsetBaseColWidth();

    void unsetCustomHeight();

    void unsetDefaultColWidth();

    void unsetOutlineLevelCol();

    void unsetOutlineLevelRow();

    void unsetThickBottom();

    void unsetThickTop();

    void unsetZeroHeight();

    XmlUnsignedInt xgetBaseColWidth();

    XmlBoolean xgetCustomHeight();

    XmlDouble xgetDefaultColWidth();

    XmlDouble xgetDefaultRowHeight();

    XmlUnsignedByte xgetOutlineLevelCol();

    XmlUnsignedByte xgetOutlineLevelRow();

    XmlBoolean xgetThickBottom();

    XmlBoolean xgetThickTop();

    XmlBoolean xgetZeroHeight();

    void xsetBaseColWidth(XmlUnsignedInt xmlUnsignedInt);

    void xsetCustomHeight(XmlBoolean xmlBoolean);

    void xsetDefaultColWidth(XmlDouble xmlDouble);

    void xsetDefaultRowHeight(XmlDouble xmlDouble);

    void xsetOutlineLevelCol(XmlUnsignedByte xmlUnsignedByte);

    void xsetOutlineLevelRow(XmlUnsignedByte xmlUnsignedByte);

    void xsetThickBottom(XmlBoolean xmlBoolean);

    void xsetThickTop(XmlBoolean xmlBoolean);

    void xsetZeroHeight(XmlBoolean xmlBoolean);
}
