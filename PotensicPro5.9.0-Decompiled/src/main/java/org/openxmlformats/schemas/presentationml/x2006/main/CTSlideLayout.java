package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride;
import org.openxmlformats.schemas.presentationml.x2006.main.STSlideLayoutType;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTSlideLayout extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSlideLayout.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctslidelayouteb34type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSlideLayout newInstance() {
            return (CTSlideLayout) XmlBeans.getContextTypeLoader().newInstance(CTSlideLayout.type, null);
        }

        public static CTSlideLayout newInstance(XmlOptions xmlOptions) {
            return (CTSlideLayout) XmlBeans.getContextTypeLoader().newInstance(CTSlideLayout.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSlideLayout.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSlideLayout) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideLayout) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(File file) throws XmlException, IOException {
            return (CTSlideLayout) XmlBeans.getContextTypeLoader().parse(file, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideLayout) XmlBeans.getContextTypeLoader().parse(file, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSlideLayout) XmlBeans.getContextTypeLoader().parse(inputStream, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideLayout) XmlBeans.getContextTypeLoader().parse(inputStream, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(Reader reader) throws XmlException, IOException {
            return (CTSlideLayout) XmlBeans.getContextTypeLoader().parse(reader, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideLayout) XmlBeans.getContextTypeLoader().parse(reader, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(String str) throws XmlException {
            return (CTSlideLayout) XmlBeans.getContextTypeLoader().parse(str, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideLayout) XmlBeans.getContextTypeLoader().parse(str, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(URL url) throws XmlException, IOException {
            return (CTSlideLayout) XmlBeans.getContextTypeLoader().parse(url, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideLayout) XmlBeans.getContextTypeLoader().parse(url, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSlideLayout) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSlideLayout) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(Node node) throws XmlException {
            return (CTSlideLayout) XmlBeans.getContextTypeLoader().parse(node, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideLayout) XmlBeans.getContextTypeLoader().parse(node, CTSlideLayout.type, xmlOptions);
        }
    }

    CTCommonSlideData addNewCSld();

    CTColorMappingOverride addNewClrMapOvr();

    CTExtensionListModify addNewExtLst();

    CTHeaderFooter addNewHf();

    CTSlideTiming addNewTiming();

    CTSlideTransition addNewTransition();

    CTCommonSlideData getCSld();

    CTColorMappingOverride getClrMapOvr();

    CTExtensionListModify getExtLst();

    CTHeaderFooter getHf();

    String getMatchingName();

    boolean getPreserve();

    boolean getShowMasterPhAnim();

    boolean getShowMasterSp();

    CTSlideTiming getTiming();

    CTSlideTransition getTransition();

    STSlideLayoutType.Enum getType();

    boolean getUserDrawn();

    boolean isSetClrMapOvr();

    boolean isSetExtLst();

    boolean isSetHf();

    boolean isSetMatchingName();

    boolean isSetPreserve();

    boolean isSetShowMasterPhAnim();

    boolean isSetShowMasterSp();

    boolean isSetTiming();

    boolean isSetTransition();

    boolean isSetType();

    boolean isSetUserDrawn();

    void setCSld(CTCommonSlideData cTCommonSlideData);

    void setClrMapOvr(CTColorMappingOverride cTColorMappingOverride);

    void setExtLst(CTExtensionListModify cTExtensionListModify);

    void setHf(CTHeaderFooter cTHeaderFooter);

    void setMatchingName(String str);

    void setPreserve(boolean z);

    void setShowMasterPhAnim(boolean z);

    void setShowMasterSp(boolean z);

    void setTiming(CTSlideTiming cTSlideTiming);

    void setTransition(CTSlideTransition cTSlideTransition);

    void setType(STSlideLayoutType.Enum r1);

    void setUserDrawn(boolean z);

    void unsetClrMapOvr();

    void unsetExtLst();

    void unsetHf();

    void unsetMatchingName();

    void unsetPreserve();

    void unsetShowMasterPhAnim();

    void unsetShowMasterSp();

    void unsetTiming();

    void unsetTransition();

    void unsetType();

    void unsetUserDrawn();

    XmlString xgetMatchingName();

    XmlBoolean xgetPreserve();

    XmlBoolean xgetShowMasterPhAnim();

    XmlBoolean xgetShowMasterSp();

    STSlideLayoutType xgetType();

    XmlBoolean xgetUserDrawn();

    void xsetMatchingName(XmlString xmlString);

    void xsetPreserve(XmlBoolean xmlBoolean);

    void xsetShowMasterPhAnim(XmlBoolean xmlBoolean);

    void xsetShowMasterSp(XmlBoolean xmlBoolean);

    void xsetType(STSlideLayoutType sTSlideLayoutType);

    void xsetUserDrawn(XmlBoolean xmlBoolean);
}
