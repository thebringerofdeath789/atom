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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTSlideMaster extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTSlideMaster.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctslidemasterd8fctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSlideMaster newInstance() {
            return (CTSlideMaster) XmlBeans.getContextTypeLoader().newInstance(CTSlideMaster.type, null);
        }

        public static CTSlideMaster newInstance(XmlOptions xmlOptions) {
            return (CTSlideMaster) XmlBeans.getContextTypeLoader().newInstance(CTSlideMaster.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSlideMaster.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTSlideMaster.type, xmlOptions);
        }

        public static CTSlideMaster parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSlideMaster) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSlideMaster.type, (XmlOptions) null);
        }

        public static CTSlideMaster parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideMaster) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTSlideMaster.type, xmlOptions);
        }

        public static CTSlideMaster parse(File file) throws XmlException, IOException {
            return (CTSlideMaster) XmlBeans.getContextTypeLoader().parse(file, CTSlideMaster.type, (XmlOptions) null);
        }

        public static CTSlideMaster parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideMaster) XmlBeans.getContextTypeLoader().parse(file, CTSlideMaster.type, xmlOptions);
        }

        public static CTSlideMaster parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSlideMaster) XmlBeans.getContextTypeLoader().parse(inputStream, CTSlideMaster.type, (XmlOptions) null);
        }

        public static CTSlideMaster parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideMaster) XmlBeans.getContextTypeLoader().parse(inputStream, CTSlideMaster.type, xmlOptions);
        }

        public static CTSlideMaster parse(Reader reader) throws XmlException, IOException {
            return (CTSlideMaster) XmlBeans.getContextTypeLoader().parse(reader, CTSlideMaster.type, (XmlOptions) null);
        }

        public static CTSlideMaster parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideMaster) XmlBeans.getContextTypeLoader().parse(reader, CTSlideMaster.type, xmlOptions);
        }

        public static CTSlideMaster parse(String str) throws XmlException {
            return (CTSlideMaster) XmlBeans.getContextTypeLoader().parse(str, CTSlideMaster.type, (XmlOptions) null);
        }

        public static CTSlideMaster parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideMaster) XmlBeans.getContextTypeLoader().parse(str, CTSlideMaster.type, xmlOptions);
        }

        public static CTSlideMaster parse(URL url) throws XmlException, IOException {
            return (CTSlideMaster) XmlBeans.getContextTypeLoader().parse(url, CTSlideMaster.type, (XmlOptions) null);
        }

        public static CTSlideMaster parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideMaster) XmlBeans.getContextTypeLoader().parse(url, CTSlideMaster.type, xmlOptions);
        }

        public static CTSlideMaster parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTSlideMaster) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSlideMaster.type, (XmlOptions) null);
        }

        public static CTSlideMaster parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTSlideMaster) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTSlideMaster.type, xmlOptions);
        }

        public static CTSlideMaster parse(Node node) throws XmlException {
            return (CTSlideMaster) XmlBeans.getContextTypeLoader().parse(node, CTSlideMaster.type, (XmlOptions) null);
        }

        public static CTSlideMaster parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideMaster) XmlBeans.getContextTypeLoader().parse(node, CTSlideMaster.type, xmlOptions);
        }
    }

    CTCommonSlideData addNewCSld();

    CTColorMapping addNewClrMap();

    CTExtensionListModify addNewExtLst();

    CTHeaderFooter addNewHf();

    CTSlideLayoutIdList addNewSldLayoutIdLst();

    CTSlideTiming addNewTiming();

    CTSlideTransition addNewTransition();

    CTSlideMasterTextStyles addNewTxStyles();

    CTCommonSlideData getCSld();

    CTColorMapping getClrMap();

    CTExtensionListModify getExtLst();

    CTHeaderFooter getHf();

    boolean getPreserve();

    CTSlideLayoutIdList getSldLayoutIdLst();

    CTSlideTiming getTiming();

    CTSlideTransition getTransition();

    CTSlideMasterTextStyles getTxStyles();

    boolean isSetExtLst();

    boolean isSetHf();

    boolean isSetPreserve();

    boolean isSetSldLayoutIdLst();

    boolean isSetTiming();

    boolean isSetTransition();

    boolean isSetTxStyles();

    void setCSld(CTCommonSlideData cTCommonSlideData);

    void setClrMap(CTColorMapping cTColorMapping);

    void setExtLst(CTExtensionListModify cTExtensionListModify);

    void setHf(CTHeaderFooter cTHeaderFooter);

    void setPreserve(boolean z);

    void setSldLayoutIdLst(CTSlideLayoutIdList cTSlideLayoutIdList);

    void setTiming(CTSlideTiming cTSlideTiming);

    void setTransition(CTSlideTransition cTSlideTransition);

    void setTxStyles(CTSlideMasterTextStyles cTSlideMasterTextStyles);

    void unsetExtLst();

    void unsetHf();

    void unsetPreserve();

    void unsetSldLayoutIdLst();

    void unsetTiming();

    void unsetTransition();

    void unsetTxStyles();

    XmlBoolean xgetPreserve();

    void xsetPreserve(XmlBoolean xmlBoolean);
}
