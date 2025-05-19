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
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.STPercentage;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTPresentation extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTPresentation.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctpresentation56cbtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPresentation newInstance() {
            return (CTPresentation) XmlBeans.getContextTypeLoader().newInstance(CTPresentation.type, null);
        }

        public static CTPresentation newInstance(XmlOptions xmlOptions) {
            return (CTPresentation) XmlBeans.getContextTypeLoader().newInstance(CTPresentation.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPresentation.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTPresentation.type, xmlOptions);
        }

        public static CTPresentation parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPresentation) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPresentation.type, (XmlOptions) null);
        }

        public static CTPresentation parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPresentation) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTPresentation.type, xmlOptions);
        }

        public static CTPresentation parse(File file) throws XmlException, IOException {
            return (CTPresentation) XmlBeans.getContextTypeLoader().parse(file, CTPresentation.type, (XmlOptions) null);
        }

        public static CTPresentation parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPresentation) XmlBeans.getContextTypeLoader().parse(file, CTPresentation.type, xmlOptions);
        }

        public static CTPresentation parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPresentation) XmlBeans.getContextTypeLoader().parse(inputStream, CTPresentation.type, (XmlOptions) null);
        }

        public static CTPresentation parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPresentation) XmlBeans.getContextTypeLoader().parse(inputStream, CTPresentation.type, xmlOptions);
        }

        public static CTPresentation parse(Reader reader) throws XmlException, IOException {
            return (CTPresentation) XmlBeans.getContextTypeLoader().parse(reader, CTPresentation.type, (XmlOptions) null);
        }

        public static CTPresentation parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPresentation) XmlBeans.getContextTypeLoader().parse(reader, CTPresentation.type, xmlOptions);
        }

        public static CTPresentation parse(String str) throws XmlException {
            return (CTPresentation) XmlBeans.getContextTypeLoader().parse(str, CTPresentation.type, (XmlOptions) null);
        }

        public static CTPresentation parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPresentation) XmlBeans.getContextTypeLoader().parse(str, CTPresentation.type, xmlOptions);
        }

        public static CTPresentation parse(URL url) throws XmlException, IOException {
            return (CTPresentation) XmlBeans.getContextTypeLoader().parse(url, CTPresentation.type, (XmlOptions) null);
        }

        public static CTPresentation parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPresentation) XmlBeans.getContextTypeLoader().parse(url, CTPresentation.type, xmlOptions);
        }

        public static CTPresentation parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTPresentation) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPresentation.type, (XmlOptions) null);
        }

        public static CTPresentation parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTPresentation) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTPresentation.type, xmlOptions);
        }

        public static CTPresentation parse(Node node) throws XmlException {
            return (CTPresentation) XmlBeans.getContextTypeLoader().parse(node, CTPresentation.type, (XmlOptions) null);
        }

        public static CTPresentation parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPresentation) XmlBeans.getContextTypeLoader().parse(node, CTPresentation.type, xmlOptions);
        }
    }

    CTCustomerDataList addNewCustDataLst();

    CTCustomShowList addNewCustShowLst();

    CTTextListStyle addNewDefaultTextStyle();

    CTEmbeddedFontList addNewEmbeddedFontLst();

    CTExtensionList addNewExtLst();

    CTHandoutMasterIdList addNewHandoutMasterIdLst();

    CTKinsoku addNewKinsoku();

    CTModifyVerifier addNewModifyVerifier();

    CTNotesMasterIdList addNewNotesMasterIdLst();

    CTPositiveSize2D addNewNotesSz();

    CTPhotoAlbum addNewPhotoAlbum();

    CTSlideIdList addNewSldIdLst();

    CTSlideMasterIdList addNewSldMasterIdLst();

    CTSlideSize addNewSldSz();

    CTSmartTags addNewSmartTags();

    boolean getAutoCompressPictures();

    long getBookmarkIdSeed();

    boolean getCompatMode();

    CTCustomerDataList getCustDataLst();

    CTCustomShowList getCustShowLst();

    CTTextListStyle getDefaultTextStyle();

    boolean getEmbedTrueTypeFonts();

    CTEmbeddedFontList getEmbeddedFontLst();

    CTExtensionList getExtLst();

    int getFirstSlideNum();

    CTHandoutMasterIdList getHandoutMasterIdLst();

    CTKinsoku getKinsoku();

    CTModifyVerifier getModifyVerifier();

    CTNotesMasterIdList getNotesMasterIdLst();

    CTPositiveSize2D getNotesSz();

    CTPhotoAlbum getPhotoAlbum();

    boolean getRemovePersonalInfoOnSave();

    boolean getRtl();

    boolean getSaveSubsetFonts();

    int getServerZoom();

    boolean getShowSpecialPlsOnTitleSld();

    CTSlideIdList getSldIdLst();

    CTSlideMasterIdList getSldMasterIdLst();

    CTSlideSize getSldSz();

    CTSmartTags getSmartTags();

    boolean getStrictFirstAndLastChars();

    boolean isSetAutoCompressPictures();

    boolean isSetBookmarkIdSeed();

    boolean isSetCompatMode();

    boolean isSetCustDataLst();

    boolean isSetCustShowLst();

    boolean isSetDefaultTextStyle();

    boolean isSetEmbedTrueTypeFonts();

    boolean isSetEmbeddedFontLst();

    boolean isSetExtLst();

    boolean isSetFirstSlideNum();

    boolean isSetHandoutMasterIdLst();

    boolean isSetKinsoku();

    boolean isSetModifyVerifier();

    boolean isSetNotesMasterIdLst();

    boolean isSetPhotoAlbum();

    boolean isSetRemovePersonalInfoOnSave();

    boolean isSetRtl();

    boolean isSetSaveSubsetFonts();

    boolean isSetServerZoom();

    boolean isSetShowSpecialPlsOnTitleSld();

    boolean isSetSldIdLst();

    boolean isSetSldMasterIdLst();

    boolean isSetSldSz();

    boolean isSetSmartTags();

    boolean isSetStrictFirstAndLastChars();

    void setAutoCompressPictures(boolean z);

    void setBookmarkIdSeed(long j);

    void setCompatMode(boolean z);

    void setCustDataLst(CTCustomerDataList cTCustomerDataList);

    void setCustShowLst(CTCustomShowList cTCustomShowList);

    void setDefaultTextStyle(CTTextListStyle cTTextListStyle);

    void setEmbedTrueTypeFonts(boolean z);

    void setEmbeddedFontLst(CTEmbeddedFontList cTEmbeddedFontList);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFirstSlideNum(int i);

    void setHandoutMasterIdLst(CTHandoutMasterIdList cTHandoutMasterIdList);

    void setKinsoku(CTKinsoku cTKinsoku);

    void setModifyVerifier(CTModifyVerifier cTModifyVerifier);

    void setNotesMasterIdLst(CTNotesMasterIdList cTNotesMasterIdList);

    void setNotesSz(CTPositiveSize2D cTPositiveSize2D);

    void setPhotoAlbum(CTPhotoAlbum cTPhotoAlbum);

    void setRemovePersonalInfoOnSave(boolean z);

    void setRtl(boolean z);

    void setSaveSubsetFonts(boolean z);

    void setServerZoom(int i);

    void setShowSpecialPlsOnTitleSld(boolean z);

    void setSldIdLst(CTSlideIdList cTSlideIdList);

    void setSldMasterIdLst(CTSlideMasterIdList cTSlideMasterIdList);

    void setSldSz(CTSlideSize cTSlideSize);

    void setSmartTags(CTSmartTags cTSmartTags);

    void setStrictFirstAndLastChars(boolean z);

    void unsetAutoCompressPictures();

    void unsetBookmarkIdSeed();

    void unsetCompatMode();

    void unsetCustDataLst();

    void unsetCustShowLst();

    void unsetDefaultTextStyle();

    void unsetEmbedTrueTypeFonts();

    void unsetEmbeddedFontLst();

    void unsetExtLst();

    void unsetFirstSlideNum();

    void unsetHandoutMasterIdLst();

    void unsetKinsoku();

    void unsetModifyVerifier();

    void unsetNotesMasterIdLst();

    void unsetPhotoAlbum();

    void unsetRemovePersonalInfoOnSave();

    void unsetRtl();

    void unsetSaveSubsetFonts();

    void unsetServerZoom();

    void unsetShowSpecialPlsOnTitleSld();

    void unsetSldIdLst();

    void unsetSldMasterIdLst();

    void unsetSldSz();

    void unsetSmartTags();

    void unsetStrictFirstAndLastChars();

    XmlBoolean xgetAutoCompressPictures();

    STBookmarkIdSeed xgetBookmarkIdSeed();

    XmlBoolean xgetCompatMode();

    XmlBoolean xgetEmbedTrueTypeFonts();

    XmlInt xgetFirstSlideNum();

    XmlBoolean xgetRemovePersonalInfoOnSave();

    XmlBoolean xgetRtl();

    XmlBoolean xgetSaveSubsetFonts();

    STPercentage xgetServerZoom();

    XmlBoolean xgetShowSpecialPlsOnTitleSld();

    XmlBoolean xgetStrictFirstAndLastChars();

    void xsetAutoCompressPictures(XmlBoolean xmlBoolean);

    void xsetBookmarkIdSeed(STBookmarkIdSeed sTBookmarkIdSeed);

    void xsetCompatMode(XmlBoolean xmlBoolean);

    void xsetEmbedTrueTypeFonts(XmlBoolean xmlBoolean);

    void xsetFirstSlideNum(XmlInt xmlInt);

    void xsetRemovePersonalInfoOnSave(XmlBoolean xmlBoolean);

    void xsetRtl(XmlBoolean xmlBoolean);

    void xsetSaveSubsetFonts(XmlBoolean xmlBoolean);

    void xsetServerZoom(STPercentage sTPercentage);

    void xsetShowSpecialPlsOnTitleSld(XmlBoolean xmlBoolean);

    void xsetStrictFirstAndLastChars(XmlBoolean xmlBoolean);
}
