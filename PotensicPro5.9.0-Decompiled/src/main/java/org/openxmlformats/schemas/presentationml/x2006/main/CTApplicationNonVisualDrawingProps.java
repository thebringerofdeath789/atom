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
import org.openxmlformats.schemas.drawingml.x2006.main.CTAudioCD;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAudioFile;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEmbeddedWAVAudioFile;
import org.openxmlformats.schemas.drawingml.x2006.main.CTQuickTimeFile;
import org.openxmlformats.schemas.drawingml.x2006.main.CTVideoFile;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTApplicationNonVisualDrawingProps extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTApplicationNonVisualDrawingProps.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctapplicationnonvisualdrawingprops2fb6type");

    public static final class Factory {
        private Factory() {
        }

        public static CTApplicationNonVisualDrawingProps newInstance() {
            return (CTApplicationNonVisualDrawingProps) XmlBeans.getContextTypeLoader().newInstance(CTApplicationNonVisualDrawingProps.type, null);
        }

        public static CTApplicationNonVisualDrawingProps newInstance(XmlOptions xmlOptions) {
            return (CTApplicationNonVisualDrawingProps) XmlBeans.getContextTypeLoader().newInstance(CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTApplicationNonVisualDrawingProps.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTApplicationNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTApplicationNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(File file) throws XmlException, IOException {
            return (CTApplicationNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(file, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTApplicationNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(file, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(InputStream inputStream) throws XmlException, IOException {
            return (CTApplicationNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(inputStream, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTApplicationNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(inputStream, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(Reader reader) throws XmlException, IOException {
            return (CTApplicationNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(reader, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTApplicationNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(reader, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(String str) throws XmlException {
            return (CTApplicationNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(str, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTApplicationNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(str, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(URL url) throws XmlException, IOException {
            return (CTApplicationNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(url, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTApplicationNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(url, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTApplicationNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTApplicationNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(Node node) throws XmlException {
            return (CTApplicationNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(node, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTApplicationNonVisualDrawingProps) XmlBeans.getContextTypeLoader().parse(node, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }
    }

    CTAudioCD addNewAudioCd();

    CTAudioFile addNewAudioFile();

    CTCustomerDataList addNewCustDataLst();

    CTExtensionList addNewExtLst();

    CTPlaceholder addNewPh();

    CTQuickTimeFile addNewQuickTimeFile();

    CTVideoFile addNewVideoFile();

    CTEmbeddedWAVAudioFile addNewWavAudioFile();

    CTAudioCD getAudioCd();

    CTAudioFile getAudioFile();

    CTCustomerDataList getCustDataLst();

    CTExtensionList getExtLst();

    boolean getIsPhoto();

    CTPlaceholder getPh();

    CTQuickTimeFile getQuickTimeFile();

    boolean getUserDrawn();

    CTVideoFile getVideoFile();

    CTEmbeddedWAVAudioFile getWavAudioFile();

    boolean isSetAudioCd();

    boolean isSetAudioFile();

    boolean isSetCustDataLst();

    boolean isSetExtLst();

    boolean isSetIsPhoto();

    boolean isSetPh();

    boolean isSetQuickTimeFile();

    boolean isSetUserDrawn();

    boolean isSetVideoFile();

    boolean isSetWavAudioFile();

    void setAudioCd(CTAudioCD cTAudioCD);

    void setAudioFile(CTAudioFile cTAudioFile);

    void setCustDataLst(CTCustomerDataList cTCustomerDataList);

    void setExtLst(CTExtensionList cTExtensionList);

    void setIsPhoto(boolean z);

    void setPh(CTPlaceholder cTPlaceholder);

    void setQuickTimeFile(CTQuickTimeFile cTQuickTimeFile);

    void setUserDrawn(boolean z);

    void setVideoFile(CTVideoFile cTVideoFile);

    void setWavAudioFile(CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFile);

    void unsetAudioCd();

    void unsetAudioFile();

    void unsetCustDataLst();

    void unsetExtLst();

    void unsetIsPhoto();

    void unsetPh();

    void unsetQuickTimeFile();

    void unsetUserDrawn();

    void unsetVideoFile();

    void unsetWavAudioFile();

    XmlBoolean xgetIsPhoto();

    XmlBoolean xgetUserDrawn();

    void xsetIsPhoto(XmlBoolean xmlBoolean);

    void xsetUserDrawn(XmlBoolean xmlBoolean);
}
