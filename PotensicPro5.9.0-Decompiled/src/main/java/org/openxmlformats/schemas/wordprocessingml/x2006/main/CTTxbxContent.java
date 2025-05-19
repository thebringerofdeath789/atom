package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface CTTxbxContent extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTTxbxContent.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("cttxbxcontent1133type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTxbxContent newInstance() {
            return (CTTxbxContent) XmlBeans.getContextTypeLoader().newInstance(CTTxbxContent.type, null);
        }

        public static CTTxbxContent newInstance(XmlOptions xmlOptions) {
            return (CTTxbxContent) XmlBeans.getContextTypeLoader().newInstance(CTTxbxContent.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTxbxContent.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTxbxContent.type, xmlOptions);
        }

        public static CTTxbxContent parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTxbxContent) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTxbxContent.type, (XmlOptions) null);
        }

        public static CTTxbxContent parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTxbxContent) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTTxbxContent.type, xmlOptions);
        }

        public static CTTxbxContent parse(File file) throws XmlException, IOException {
            return (CTTxbxContent) XmlBeans.getContextTypeLoader().parse(file, CTTxbxContent.type, (XmlOptions) null);
        }

        public static CTTxbxContent parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTxbxContent) XmlBeans.getContextTypeLoader().parse(file, CTTxbxContent.type, xmlOptions);
        }

        public static CTTxbxContent parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTxbxContent) XmlBeans.getContextTypeLoader().parse(inputStream, CTTxbxContent.type, (XmlOptions) null);
        }

        public static CTTxbxContent parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTxbxContent) XmlBeans.getContextTypeLoader().parse(inputStream, CTTxbxContent.type, xmlOptions);
        }

        public static CTTxbxContent parse(Reader reader) throws XmlException, IOException {
            return (CTTxbxContent) XmlBeans.getContextTypeLoader().parse(reader, CTTxbxContent.type, (XmlOptions) null);
        }

        public static CTTxbxContent parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTxbxContent) XmlBeans.getContextTypeLoader().parse(reader, CTTxbxContent.type, xmlOptions);
        }

        public static CTTxbxContent parse(String str) throws XmlException {
            return (CTTxbxContent) XmlBeans.getContextTypeLoader().parse(str, CTTxbxContent.type, (XmlOptions) null);
        }

        public static CTTxbxContent parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTxbxContent) XmlBeans.getContextTypeLoader().parse(str, CTTxbxContent.type, xmlOptions);
        }

        public static CTTxbxContent parse(URL url) throws XmlException, IOException {
            return (CTTxbxContent) XmlBeans.getContextTypeLoader().parse(url, CTTxbxContent.type, (XmlOptions) null);
        }

        public static CTTxbxContent parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTxbxContent) XmlBeans.getContextTypeLoader().parse(url, CTTxbxContent.type, xmlOptions);
        }

        public static CTTxbxContent parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTTxbxContent) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTxbxContent.type, (XmlOptions) null);
        }

        public static CTTxbxContent parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTTxbxContent) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTTxbxContent.type, xmlOptions);
        }

        public static CTTxbxContent parse(Node node) throws XmlException {
            return (CTTxbxContent) XmlBeans.getContextTypeLoader().parse(node, CTTxbxContent.type, (XmlOptions) null);
        }

        public static CTTxbxContent parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTxbxContent) XmlBeans.getContextTypeLoader().parse(node, CTTxbxContent.type, xmlOptions);
        }
    }

    CTAltChunk addNewAltChunk();

    CTMarkupRange addNewBookmarkEnd();

    CTBookmark addNewBookmarkStart();

    CTMarkupRange addNewCommentRangeEnd();

    CTMarkupRange addNewCommentRangeStart();

    CTCustomXmlBlock addNewCustomXml();

    CTMarkup addNewCustomXmlDelRangeEnd();

    CTTrackChange addNewCustomXmlDelRangeStart();

    CTMarkup addNewCustomXmlInsRangeEnd();

    CTTrackChange addNewCustomXmlInsRangeStart();

    CTMarkup addNewCustomXmlMoveFromRangeEnd();

    CTTrackChange addNewCustomXmlMoveFromRangeStart();

    CTMarkup addNewCustomXmlMoveToRangeEnd();

    CTTrackChange addNewCustomXmlMoveToRangeStart();

    CTRunTrackChange addNewDel();

    CTRunTrackChange addNewIns();

    CTRunTrackChange addNewMoveFrom();

    CTMarkupRange addNewMoveFromRangeEnd();

    CTMoveBookmark addNewMoveFromRangeStart();

    CTRunTrackChange addNewMoveTo();

    CTMarkupRange addNewMoveToRangeEnd();

    CTMoveBookmark addNewMoveToRangeStart();

    CTOMath addNewOMath();

    CTOMathPara addNewOMathPara();

    CTP addNewP();

    CTPerm addNewPermEnd();

    CTPermStart addNewPermStart();

    CTProofErr addNewProofErr();

    CTSdtBlock addNewSdt();

    CTTbl addNewTbl();

    CTAltChunk getAltChunkArray(int i);

    CTAltChunk[] getAltChunkArray();

    List<CTAltChunk> getAltChunkList();

    CTMarkupRange getBookmarkEndArray(int i);

    CTMarkupRange[] getBookmarkEndArray();

    List<CTMarkupRange> getBookmarkEndList();

    CTBookmark getBookmarkStartArray(int i);

    CTBookmark[] getBookmarkStartArray();

    List<CTBookmark> getBookmarkStartList();

    CTMarkupRange getCommentRangeEndArray(int i);

    CTMarkupRange[] getCommentRangeEndArray();

    List<CTMarkupRange> getCommentRangeEndList();

    CTMarkupRange getCommentRangeStartArray(int i);

    CTMarkupRange[] getCommentRangeStartArray();

    List<CTMarkupRange> getCommentRangeStartList();

    CTCustomXmlBlock getCustomXmlArray(int i);

    CTCustomXmlBlock[] getCustomXmlArray();

    CTMarkup getCustomXmlDelRangeEndArray(int i);

    CTMarkup[] getCustomXmlDelRangeEndArray();

    List<CTMarkup> getCustomXmlDelRangeEndList();

    CTTrackChange getCustomXmlDelRangeStartArray(int i);

    CTTrackChange[] getCustomXmlDelRangeStartArray();

    List<CTTrackChange> getCustomXmlDelRangeStartList();

    CTMarkup getCustomXmlInsRangeEndArray(int i);

    CTMarkup[] getCustomXmlInsRangeEndArray();

    List<CTMarkup> getCustomXmlInsRangeEndList();

    CTTrackChange getCustomXmlInsRangeStartArray(int i);

    CTTrackChange[] getCustomXmlInsRangeStartArray();

    List<CTTrackChange> getCustomXmlInsRangeStartList();

    List<CTCustomXmlBlock> getCustomXmlList();

    CTMarkup getCustomXmlMoveFromRangeEndArray(int i);

    CTMarkup[] getCustomXmlMoveFromRangeEndArray();

    List<CTMarkup> getCustomXmlMoveFromRangeEndList();

    CTTrackChange getCustomXmlMoveFromRangeStartArray(int i);

    CTTrackChange[] getCustomXmlMoveFromRangeStartArray();

    List<CTTrackChange> getCustomXmlMoveFromRangeStartList();

    CTMarkup getCustomXmlMoveToRangeEndArray(int i);

    CTMarkup[] getCustomXmlMoveToRangeEndArray();

    List<CTMarkup> getCustomXmlMoveToRangeEndList();

    CTTrackChange getCustomXmlMoveToRangeStartArray(int i);

    CTTrackChange[] getCustomXmlMoveToRangeStartArray();

    List<CTTrackChange> getCustomXmlMoveToRangeStartList();

    CTRunTrackChange getDelArray(int i);

    CTRunTrackChange[] getDelArray();

    List<CTRunTrackChange> getDelList();

    CTRunTrackChange getInsArray(int i);

    CTRunTrackChange[] getInsArray();

    List<CTRunTrackChange> getInsList();

    CTRunTrackChange getMoveFromArray(int i);

    CTRunTrackChange[] getMoveFromArray();

    List<CTRunTrackChange> getMoveFromList();

    CTMarkupRange getMoveFromRangeEndArray(int i);

    CTMarkupRange[] getMoveFromRangeEndArray();

    List<CTMarkupRange> getMoveFromRangeEndList();

    CTMoveBookmark getMoveFromRangeStartArray(int i);

    CTMoveBookmark[] getMoveFromRangeStartArray();

    List<CTMoveBookmark> getMoveFromRangeStartList();

    CTRunTrackChange getMoveToArray(int i);

    CTRunTrackChange[] getMoveToArray();

    List<CTRunTrackChange> getMoveToList();

    CTMarkupRange getMoveToRangeEndArray(int i);

    CTMarkupRange[] getMoveToRangeEndArray();

    List<CTMarkupRange> getMoveToRangeEndList();

    CTMoveBookmark getMoveToRangeStartArray(int i);

    CTMoveBookmark[] getMoveToRangeStartArray();

    List<CTMoveBookmark> getMoveToRangeStartList();

    CTOMath getOMathArray(int i);

    CTOMath[] getOMathArray();

    List<CTOMath> getOMathList();

    CTOMathPara getOMathParaArray(int i);

    CTOMathPara[] getOMathParaArray();

    List<CTOMathPara> getOMathParaList();

    CTP getPArray(int i);

    CTP[] getPArray();

    List<CTP> getPList();

    CTPerm getPermEndArray(int i);

    CTPerm[] getPermEndArray();

    List<CTPerm> getPermEndList();

    CTPermStart getPermStartArray(int i);

    CTPermStart[] getPermStartArray();

    List<CTPermStart> getPermStartList();

    CTProofErr getProofErrArray(int i);

    CTProofErr[] getProofErrArray();

    List<CTProofErr> getProofErrList();

    CTSdtBlock getSdtArray(int i);

    CTSdtBlock[] getSdtArray();

    List<CTSdtBlock> getSdtList();

    CTTbl getTblArray(int i);

    CTTbl[] getTblArray();

    List<CTTbl> getTblList();

    CTAltChunk insertNewAltChunk(int i);

    CTMarkupRange insertNewBookmarkEnd(int i);

    CTBookmark insertNewBookmarkStart(int i);

    CTMarkupRange insertNewCommentRangeEnd(int i);

    CTMarkupRange insertNewCommentRangeStart(int i);

    CTCustomXmlBlock insertNewCustomXml(int i);

    CTMarkup insertNewCustomXmlDelRangeEnd(int i);

    CTTrackChange insertNewCustomXmlDelRangeStart(int i);

    CTMarkup insertNewCustomXmlInsRangeEnd(int i);

    CTTrackChange insertNewCustomXmlInsRangeStart(int i);

    CTMarkup insertNewCustomXmlMoveFromRangeEnd(int i);

    CTTrackChange insertNewCustomXmlMoveFromRangeStart(int i);

    CTMarkup insertNewCustomXmlMoveToRangeEnd(int i);

    CTTrackChange insertNewCustomXmlMoveToRangeStart(int i);

    CTRunTrackChange insertNewDel(int i);

    CTRunTrackChange insertNewIns(int i);

    CTRunTrackChange insertNewMoveFrom(int i);

    CTMarkupRange insertNewMoveFromRangeEnd(int i);

    CTMoveBookmark insertNewMoveFromRangeStart(int i);

    CTRunTrackChange insertNewMoveTo(int i);

    CTMarkupRange insertNewMoveToRangeEnd(int i);

    CTMoveBookmark insertNewMoveToRangeStart(int i);

    CTOMath insertNewOMath(int i);

    CTOMathPara insertNewOMathPara(int i);

    CTP insertNewP(int i);

    CTPerm insertNewPermEnd(int i);

    CTPermStart insertNewPermStart(int i);

    CTProofErr insertNewProofErr(int i);

    CTSdtBlock insertNewSdt(int i);

    CTTbl insertNewTbl(int i);

    void removeAltChunk(int i);

    void removeBookmarkEnd(int i);

    void removeBookmarkStart(int i);

    void removeCommentRangeEnd(int i);

    void removeCommentRangeStart(int i);

    void removeCustomXml(int i);

    void removeCustomXmlDelRangeEnd(int i);

    void removeCustomXmlDelRangeStart(int i);

    void removeCustomXmlInsRangeEnd(int i);

    void removeCustomXmlInsRangeStart(int i);

    void removeCustomXmlMoveFromRangeEnd(int i);

    void removeCustomXmlMoveFromRangeStart(int i);

    void removeCustomXmlMoveToRangeEnd(int i);

    void removeCustomXmlMoveToRangeStart(int i);

    void removeDel(int i);

    void removeIns(int i);

    void removeMoveFrom(int i);

    void removeMoveFromRangeEnd(int i);

    void removeMoveFromRangeStart(int i);

    void removeMoveTo(int i);

    void removeMoveToRangeEnd(int i);

    void removeMoveToRangeStart(int i);

    void removeOMath(int i);

    void removeOMathPara(int i);

    void removeP(int i);

    void removePermEnd(int i);

    void removePermStart(int i);

    void removeProofErr(int i);

    void removeSdt(int i);

    void removeTbl(int i);

    void setAltChunkArray(int i, CTAltChunk cTAltChunk);

    void setAltChunkArray(CTAltChunk[] cTAltChunkArr);

    void setBookmarkEndArray(int i, CTMarkupRange cTMarkupRange);

    void setBookmarkEndArray(CTMarkupRange[] cTMarkupRangeArr);

    void setBookmarkStartArray(int i, CTBookmark cTBookmark);

    void setBookmarkStartArray(CTBookmark[] cTBookmarkArr);

    void setCommentRangeEndArray(int i, CTMarkupRange cTMarkupRange);

    void setCommentRangeEndArray(CTMarkupRange[] cTMarkupRangeArr);

    void setCommentRangeStartArray(int i, CTMarkupRange cTMarkupRange);

    void setCommentRangeStartArray(CTMarkupRange[] cTMarkupRangeArr);

    void setCustomXmlArray(int i, CTCustomXmlBlock cTCustomXmlBlock);

    void setCustomXmlArray(CTCustomXmlBlock[] cTCustomXmlBlockArr);

    void setCustomXmlDelRangeEndArray(int i, CTMarkup cTMarkup);

    void setCustomXmlDelRangeEndArray(CTMarkup[] cTMarkupArr);

    void setCustomXmlDelRangeStartArray(int i, CTTrackChange cTTrackChange);

    void setCustomXmlDelRangeStartArray(CTTrackChange[] cTTrackChangeArr);

    void setCustomXmlInsRangeEndArray(int i, CTMarkup cTMarkup);

    void setCustomXmlInsRangeEndArray(CTMarkup[] cTMarkupArr);

    void setCustomXmlInsRangeStartArray(int i, CTTrackChange cTTrackChange);

    void setCustomXmlInsRangeStartArray(CTTrackChange[] cTTrackChangeArr);

    void setCustomXmlMoveFromRangeEndArray(int i, CTMarkup cTMarkup);

    void setCustomXmlMoveFromRangeEndArray(CTMarkup[] cTMarkupArr);

    void setCustomXmlMoveFromRangeStartArray(int i, CTTrackChange cTTrackChange);

    void setCustomXmlMoveFromRangeStartArray(CTTrackChange[] cTTrackChangeArr);

    void setCustomXmlMoveToRangeEndArray(int i, CTMarkup cTMarkup);

    void setCustomXmlMoveToRangeEndArray(CTMarkup[] cTMarkupArr);

    void setCustomXmlMoveToRangeStartArray(int i, CTTrackChange cTTrackChange);

    void setCustomXmlMoveToRangeStartArray(CTTrackChange[] cTTrackChangeArr);

    void setDelArray(int i, CTRunTrackChange cTRunTrackChange);

    void setDelArray(CTRunTrackChange[] cTRunTrackChangeArr);

    void setInsArray(int i, CTRunTrackChange cTRunTrackChange);

    void setInsArray(CTRunTrackChange[] cTRunTrackChangeArr);

    void setMoveFromArray(int i, CTRunTrackChange cTRunTrackChange);

    void setMoveFromArray(CTRunTrackChange[] cTRunTrackChangeArr);

    void setMoveFromRangeEndArray(int i, CTMarkupRange cTMarkupRange);

    void setMoveFromRangeEndArray(CTMarkupRange[] cTMarkupRangeArr);

    void setMoveFromRangeStartArray(int i, CTMoveBookmark cTMoveBookmark);

    void setMoveFromRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr);

    void setMoveToArray(int i, CTRunTrackChange cTRunTrackChange);

    void setMoveToArray(CTRunTrackChange[] cTRunTrackChangeArr);

    void setMoveToRangeEndArray(int i, CTMarkupRange cTMarkupRange);

    void setMoveToRangeEndArray(CTMarkupRange[] cTMarkupRangeArr);

    void setMoveToRangeStartArray(int i, CTMoveBookmark cTMoveBookmark);

    void setMoveToRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr);

    void setOMathArray(int i, CTOMath cTOMath);

    void setOMathArray(CTOMath[] cTOMathArr);

    void setOMathParaArray(int i, CTOMathPara cTOMathPara);

    void setOMathParaArray(CTOMathPara[] cTOMathParaArr);

    void setPArray(int i, CTP ctp);

    void setPArray(CTP[] ctpArr);

    void setPermEndArray(int i, CTPerm cTPerm);

    void setPermEndArray(CTPerm[] cTPermArr);

    void setPermStartArray(int i, CTPermStart cTPermStart);

    void setPermStartArray(CTPermStart[] cTPermStartArr);

    void setProofErrArray(int i, CTProofErr cTProofErr);

    void setProofErrArray(CTProofErr[] cTProofErrArr);

    void setSdtArray(int i, CTSdtBlock cTSdtBlock);

    void setSdtArray(CTSdtBlock[] cTSdtBlockArr);

    void setTblArray(int i, CTTbl cTTbl);

    void setTblArray(CTTbl[] cTTblArr);

    int sizeOfAltChunkArray();

    int sizeOfBookmarkEndArray();

    int sizeOfBookmarkStartArray();

    int sizeOfCommentRangeEndArray();

    int sizeOfCommentRangeStartArray();

    int sizeOfCustomXmlArray();

    int sizeOfCustomXmlDelRangeEndArray();

    int sizeOfCustomXmlDelRangeStartArray();

    int sizeOfCustomXmlInsRangeEndArray();

    int sizeOfCustomXmlInsRangeStartArray();

    int sizeOfCustomXmlMoveFromRangeEndArray();

    int sizeOfCustomXmlMoveFromRangeStartArray();

    int sizeOfCustomXmlMoveToRangeEndArray();

    int sizeOfCustomXmlMoveToRangeStartArray();

    int sizeOfDelArray();

    int sizeOfInsArray();

    int sizeOfMoveFromArray();

    int sizeOfMoveFromRangeEndArray();

    int sizeOfMoveFromRangeStartArray();

    int sizeOfMoveToArray();

    int sizeOfMoveToRangeEndArray();

    int sizeOfMoveToRangeStartArray();

    int sizeOfOMathArray();

    int sizeOfOMathParaArray();

    int sizeOfPArray();

    int sizeOfPermEndArray();

    int sizeOfPermStartArray();

    int sizeOfProofErrArray();

    int sizeOfSdtArray();

    int sizeOfTblArray();
}
