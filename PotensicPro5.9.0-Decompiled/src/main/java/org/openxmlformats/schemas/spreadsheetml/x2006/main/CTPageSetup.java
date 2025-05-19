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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellComments;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STOrientation;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPageOrder;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTPageSetup extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPageSetup.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpagesetup534dtype");

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

    STCellComments.Enum getCellComments();

    long getCopies();

    boolean getDraft();

    STPrintError$Enum getErrors();

    long getFirstPageNumber();

    long getFitToHeight();

    long getFitToWidth();

    long getHorizontalDpi();

    String getId();

    STOrientation.Enum getOrientation();

    STPageOrder.Enum getPageOrder();

    long getPaperSize();

    long getScale();

    boolean getUseFirstPageNumber();

    boolean getUsePrinterDefaults();

    long getVerticalDpi();

    boolean isSetBlackAndWhite();

    boolean isSetCellComments();

    boolean isSetCopies();

    boolean isSetDraft();

    boolean isSetErrors();

    boolean isSetFirstPageNumber();

    boolean isSetFitToHeight();

    boolean isSetFitToWidth();

    boolean isSetHorizontalDpi();

    boolean isSetId();

    boolean isSetOrientation();

    boolean isSetPageOrder();

    boolean isSetPaperSize();

    boolean isSetScale();

    boolean isSetUseFirstPageNumber();

    boolean isSetUsePrinterDefaults();

    boolean isSetVerticalDpi();

    void setBlackAndWhite(boolean z);

    void setCellComments(STCellComments.Enum r1);

    void setCopies(long j);

    void setDraft(boolean z);

    void setErrors(STPrintError$Enum sTPrintError$Enum);

    void setFirstPageNumber(long j);

    void setFitToHeight(long j);

    void setFitToWidth(long j);

    void setHorizontalDpi(long j);

    void setId(String str);

    void setOrientation(STOrientation.Enum r1);

    void setPageOrder(STPageOrder.Enum r1);

    void setPaperSize(long j);

    void setScale(long j);

    void setUseFirstPageNumber(boolean z);

    void setUsePrinterDefaults(boolean z);

    void setVerticalDpi(long j);

    void unsetBlackAndWhite();

    void unsetCellComments();

    void unsetCopies();

    void unsetDraft();

    void unsetErrors();

    void unsetFirstPageNumber();

    void unsetFitToHeight();

    void unsetFitToWidth();

    void unsetHorizontalDpi();

    void unsetId();

    void unsetOrientation();

    void unsetPageOrder();

    void unsetPaperSize();

    void unsetScale();

    void unsetUseFirstPageNumber();

    void unsetUsePrinterDefaults();

    void unsetVerticalDpi();

    XmlBoolean xgetBlackAndWhite();

    STCellComments xgetCellComments();

    XmlUnsignedInt xgetCopies();

    XmlBoolean xgetDraft();

    STPrintError xgetErrors();

    XmlUnsignedInt xgetFirstPageNumber();

    XmlUnsignedInt xgetFitToHeight();

    XmlUnsignedInt xgetFitToWidth();

    XmlUnsignedInt xgetHorizontalDpi();

    STRelationshipId xgetId();

    STOrientation xgetOrientation();

    STPageOrder xgetPageOrder();

    XmlUnsignedInt xgetPaperSize();

    XmlUnsignedInt xgetScale();

    XmlBoolean xgetUseFirstPageNumber();

    XmlBoolean xgetUsePrinterDefaults();

    XmlUnsignedInt xgetVerticalDpi();

    void xsetBlackAndWhite(XmlBoolean xmlBoolean);

    void xsetCellComments(STCellComments sTCellComments);

    void xsetCopies(XmlUnsignedInt xmlUnsignedInt);

    void xsetDraft(XmlBoolean xmlBoolean);

    void xsetErrors(STPrintError sTPrintError);

    void xsetFirstPageNumber(XmlUnsignedInt xmlUnsignedInt);

    void xsetFitToHeight(XmlUnsignedInt xmlUnsignedInt);

    void xsetFitToWidth(XmlUnsignedInt xmlUnsignedInt);

    void xsetHorizontalDpi(XmlUnsignedInt xmlUnsignedInt);

    void xsetId(STRelationshipId sTRelationshipId);

    void xsetOrientation(STOrientation sTOrientation);

    void xsetPageOrder(STPageOrder sTPageOrder);

    void xsetPaperSize(XmlUnsignedInt xmlUnsignedInt);

    void xsetScale(XmlUnsignedInt xmlUnsignedInt);

    void xsetUseFirstPageNumber(XmlBoolean xmlBoolean);

    void xsetUsePrinterDefaults(XmlBoolean xmlBoolean);

    void xsetVerticalDpi(XmlUnsignedInt xmlUnsignedInt);
}
