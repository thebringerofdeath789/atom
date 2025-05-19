package org.openxmlformats.schemas.drawingml.x2006.chart;

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
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public interface CTPageSetup extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPageSetup.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpagesetupdb38type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPageSetup newInstance() {
            return (CTPageSetup) XmlBeans.getContextTypeLoader().newInstance(CTPageSetup.type, null);
        }

        public static CTPageSetup newInstance(XmlOptions xmlOptions) {
            return (CTPageSetup) XmlBeans.getContextTypeLoader().newInstance(CTPageSetup.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPageSetup.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPageSetup.type, xmlOptions);
        }

        public static CTPageSetup parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPageSetup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPageSetup.type, (XmlOptions) null);
        }

        public static CTPageSetup parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPageSetup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPageSetup.type, xmlOptions);
        }

        public static CTPageSetup parse(File file) throws XmlException, IOException {
            return (CTPageSetup) XmlBeans.getContextTypeLoader().parse(file, CTPageSetup.type, (XmlOptions) null);
        }

        public static CTPageSetup parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageSetup) XmlBeans.getContextTypeLoader().parse(file, CTPageSetup.type, xmlOptions);
        }

        public static CTPageSetup parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPageSetup) XmlBeans.getContextTypeLoader().parse(inputStream, CTPageSetup.type, (XmlOptions) null);
        }

        public static CTPageSetup parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageSetup) XmlBeans.getContextTypeLoader().parse(inputStream, CTPageSetup.type, xmlOptions);
        }

        public static CTPageSetup parse(Reader reader) throws XmlException, IOException {
            return (CTPageSetup) XmlBeans.getContextTypeLoader().parse(reader, CTPageSetup.type, (XmlOptions) null);
        }

        public static CTPageSetup parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageSetup) XmlBeans.getContextTypeLoader().parse(reader, CTPageSetup.type, xmlOptions);
        }

        public static CTPageSetup parse(String str) throws XmlException {
            return (CTPageSetup) XmlBeans.getContextTypeLoader().parse(str, CTPageSetup.type, (XmlOptions) null);
        }

        public static CTPageSetup parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPageSetup) XmlBeans.getContextTypeLoader().parse(str, CTPageSetup.type, xmlOptions);
        }

        public static CTPageSetup parse(URL url) throws XmlException, IOException {
            return (CTPageSetup) XmlBeans.getContextTypeLoader().parse(url, CTPageSetup.type, (XmlOptions) null);
        }

        public static CTPageSetup parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPageSetup) XmlBeans.getContextTypeLoader().parse(url, CTPageSetup.type, xmlOptions);
        }

        public static CTPageSetup parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPageSetup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPageSetup.type, (XmlOptions) null);
        }

        public static CTPageSetup parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPageSetup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPageSetup.type, xmlOptions);
        }

        public static CTPageSetup parse(Node node) throws XmlException {
            return (CTPageSetup) XmlBeans.getContextTypeLoader().parse(node, CTPageSetup.type, (XmlOptions) null);
        }

        public static CTPageSetup parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPageSetup) XmlBeans.getContextTypeLoader().parse(node, CTPageSetup.type, xmlOptions);
        }
    }

    boolean getBlackAndWhite();

    long getCopies();

    boolean getDraft();

    long getFirstPageNumber();

    int getHorizontalDpi();

    STPageSetupOrientation$Enum getOrientation();

    long getPaperSize();

    boolean getUseFirstPageNumber();

    int getVerticalDpi();

    boolean isSetBlackAndWhite();

    boolean isSetCopies();

    boolean isSetDraft();

    boolean isSetFirstPageNumber();

    boolean isSetHorizontalDpi();

    boolean isSetOrientation();

    boolean isSetPaperSize();

    boolean isSetUseFirstPageNumber();

    boolean isSetVerticalDpi();

    void setBlackAndWhite(boolean z);

    void setCopies(long j);

    void setDraft(boolean z);

    void setFirstPageNumber(long j);

    void setHorizontalDpi(int i);

    void setOrientation(STPageSetupOrientation$Enum sTPageSetupOrientation$Enum);

    void setPaperSize(long j);

    void setUseFirstPageNumber(boolean z);

    void setVerticalDpi(int i);

    void unsetBlackAndWhite();

    void unsetCopies();

    void unsetDraft();

    void unsetFirstPageNumber();

    void unsetHorizontalDpi();

    void unsetOrientation();

    void unsetPaperSize();

    void unsetUseFirstPageNumber();

    void unsetVerticalDpi();

    XmlBoolean xgetBlackAndWhite();

    XmlUnsignedInt xgetCopies();

    XmlBoolean xgetDraft();

    XmlUnsignedInt xgetFirstPageNumber();

    XmlInt xgetHorizontalDpi();

    STPageSetupOrientation xgetOrientation();

    XmlUnsignedInt xgetPaperSize();

    XmlBoolean xgetUseFirstPageNumber();

    XmlInt xgetVerticalDpi();

    void xsetBlackAndWhite(XmlBoolean xmlBoolean);

    void xsetCopies(XmlUnsignedInt xmlUnsignedInt);

    void xsetDraft(XmlBoolean xmlBoolean);

    void xsetFirstPageNumber(XmlUnsignedInt xmlUnsignedInt);

    void xsetHorizontalDpi(XmlInt xmlInt);

    void xsetOrientation(STPageSetupOrientation sTPageSetupOrientation);

    void xsetPaperSize(XmlUnsignedInt xmlUnsignedInt);

    void xsetUseFirstPageNumber(XmlBoolean xmlBoolean);

    void xsetVerticalDpi(XmlInt xmlInt);
}
