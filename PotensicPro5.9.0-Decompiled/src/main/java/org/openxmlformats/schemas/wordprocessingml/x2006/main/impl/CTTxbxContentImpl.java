package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAltChunk;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMoveBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPerm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPermStart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent;

/* loaded from: classes6.dex */
public class CTTxbxContentImpl extends XmlComplexContentImpl implements CTTxbxContent {
    private static final QName CUSTOMXML$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXml");
    private static final QName SDT$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdt");
    private static final QName P$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", TtmlNode.TAG_P);
    private static final QName TBL$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tbl");
    private static final QName PROOFERR$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "proofErr");
    private static final QName PERMSTART$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permStart");
    private static final QName PERMEND$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permEnd");
    private static final QName BOOKMARKSTART$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkStart");
    private static final QName BOOKMARKEND$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkEnd");
    private static final QName MOVEFROMRANGESTART$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeStart");
    private static final QName MOVEFROMRANGEEND$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeEnd");
    private static final QName MOVETORANGESTART$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeStart");
    private static final QName MOVETORANGEEND$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeEnd");
    private static final QName COMMENTRANGESTART$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeStart");
    private static final QName COMMENTRANGEEND$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeEnd");
    private static final QName CUSTOMXMLINSRANGESTART$30 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeStart");
    private static final QName CUSTOMXMLINSRANGEEND$32 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeEnd");
    private static final QName CUSTOMXMLDELRANGESTART$34 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeStart");
    private static final QName CUSTOMXMLDELRANGEEND$36 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeEnd");
    private static final QName CUSTOMXMLMOVEFROMRANGESTART$38 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeStart");
    private static final QName CUSTOMXMLMOVEFROMRANGEEND$40 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeEnd");
    private static final QName CUSTOMXMLMOVETORANGESTART$42 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeStart");
    private static final QName CUSTOMXMLMOVETORANGEEND$44 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeEnd");
    private static final QName INS$46 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins");
    private static final QName DEL$48 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "del");
    private static final QName MOVEFROM$50 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFrom");
    private static final QName MOVETO$52 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveTo");
    private static final QName OMATHPARA$54 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMathPara");
    private static final QName OMATH$56 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMath");
    private static final QName ALTCHUNK$58 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "altChunk");

    public CTTxbxContentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTAltChunk addNewAltChunk() {
        CTAltChunk add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(ALTCHUNK$58);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkupRange addNewBookmarkEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(BOOKMARKEND$16);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTBookmark addNewBookmarkStart() {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().add_element_user(BOOKMARKSTART$14);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkupRange addNewCommentRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(COMMENTRANGEEND$28);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkupRange addNewCommentRangeStart() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(COMMENTRANGESTART$26);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTCustomXmlBlock addNewCustomXml() {
        CTCustomXmlBlock add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CUSTOMXML$0);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkup addNewCustomXmlDelRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLDELRANGEEND$36);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTTrackChange addNewCustomXmlDelRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLDELRANGESTART$34);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkup addNewCustomXmlInsRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLINSRANGEEND$32);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTTrackChange addNewCustomXmlInsRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLINSRANGESTART$30);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkup addNewCustomXmlMoveFromRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLMOVEFROMRANGEEND$40);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTTrackChange addNewCustomXmlMoveFromRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLMOVEFROMRANGESTART$38);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkup addNewCustomXmlMoveToRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLMOVETORANGEEND$44);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTTrackChange addNewCustomXmlMoveToRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLMOVETORANGESTART$42);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTRunTrackChange addNewDel() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(DEL$48);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTRunTrackChange addNewIns() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(INS$46);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTRunTrackChange addNewMoveFrom() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(MOVEFROM$50);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkupRange addNewMoveFromRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(MOVEFROMRANGEEND$20);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMoveBookmark addNewMoveFromRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(MOVEFROMRANGESTART$18);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTRunTrackChange addNewMoveTo() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(MOVETO$52);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkupRange addNewMoveToRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(MOVETORANGEEND$24);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMoveBookmark addNewMoveToRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(MOVETORANGESTART$22);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTOMath addNewOMath() {
        CTOMath add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(OMATH$56);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTOMathPara addNewOMathPara() {
        CTOMathPara add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(OMATHPARA$54);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTP addNewP() {
        CTP ctp;
        synchronized (monitor()) {
            check_orphaned();
            ctp = (CTP) get_store().add_element_user(P$4);
        }
        return ctp;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTPerm addNewPermEnd() {
        CTPerm add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(PERMEND$12);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTPermStart addNewPermStart() {
        CTPermStart add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(PERMSTART$10);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTProofErr addNewProofErr() {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().add_element_user(PROOFERR$8);
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTSdtBlock addNewSdt() {
        CTSdtBlock cTSdtBlock;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtBlock = (CTSdtBlock) get_store().add_element_user(SDT$2);
        }
        return cTSdtBlock;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTTbl addNewTbl() {
        CTTbl cTTbl;
        synchronized (monitor()) {
            check_orphaned();
            cTTbl = (CTTbl) get_store().add_element_user(TBL$6);
        }
        return cTTbl;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTAltChunk getAltChunkArray(int i) {
        CTAltChunk find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(ALTCHUNK$58, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTAltChunk[] getAltChunkArray() {
        CTAltChunk[] cTAltChunkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ALTCHUNK$58, arrayList);
            cTAltChunkArr = new CTAltChunk[arrayList.size()];
            arrayList.toArray(cTAltChunkArr);
        }
        return cTAltChunkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTAltChunk> getAltChunkList() {
        1AltChunkList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AltChunkList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkupRange getBookmarkEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(BOOKMARKEND$16, i);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkupRange[] getBookmarkEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOOKMARKEND$16, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTMarkupRange> getBookmarkEndList() {
        1BookmarkEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BookmarkEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTBookmark getBookmarkStartArray(int i) {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().find_element_user(BOOKMARKSTART$14, i);
            if (cTBookmark == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTBookmark[] getBookmarkStartArray() {
        CTBookmark[] cTBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOOKMARKSTART$14, arrayList);
            cTBookmarkArr = new CTBookmark[arrayList.size()];
            arrayList.toArray(cTBookmarkArr);
        }
        return cTBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTBookmark> getBookmarkStartList() {
        1BookmarkStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BookmarkStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkupRange getCommentRangeEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(COMMENTRANGEEND$28, i);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkupRange[] getCommentRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMMENTRANGEEND$28, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTMarkupRange> getCommentRangeEndList() {
        1CommentRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CommentRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkupRange getCommentRangeStartArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(COMMENTRANGESTART$26, i);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkupRange[] getCommentRangeStartArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMMENTRANGESTART$26, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTMarkupRange> getCommentRangeStartList() {
        1CommentRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CommentRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTCustomXmlBlock getCustomXmlArray(int i) {
        CTCustomXmlBlock find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(CUSTOMXML$0, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTCustomXmlBlock[] getCustomXmlArray() {
        CTCustomXmlBlock[] cTCustomXmlBlockArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXML$0, arrayList);
            cTCustomXmlBlockArr = new CTCustomXmlBlock[arrayList.size()];
            arrayList.toArray(cTCustomXmlBlockArr);
        }
        return cTCustomXmlBlockArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkup getCustomXmlDelRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLDELRANGEEND$36, i);
            if (cTMarkup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkup[] getCustomXmlDelRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLDELRANGEEND$36, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTMarkup> getCustomXmlDelRangeEndList() {
        1CustomXmlDelRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlDelRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTTrackChange getCustomXmlDelRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLDELRANGESTART$34, i);
            if (cTTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTTrackChange[] getCustomXmlDelRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLDELRANGESTART$34, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTTrackChange> getCustomXmlDelRangeStartList() {
        1CustomXmlDelRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlDelRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkup getCustomXmlInsRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLINSRANGEEND$32, i);
            if (cTMarkup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkup[] getCustomXmlInsRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLINSRANGEEND$32, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTMarkup> getCustomXmlInsRangeEndList() {
        1CustomXmlInsRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlInsRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTTrackChange getCustomXmlInsRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLINSRANGESTART$30, i);
            if (cTTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTTrackChange[] getCustomXmlInsRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLINSRANGESTART$30, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTTrackChange> getCustomXmlInsRangeStartList() {
        1CustomXmlInsRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlInsRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTCustomXmlBlock> getCustomXmlList() {
        1CustomXmlList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkup getCustomXmlMoveFromRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGEEND$40, i);
            if (cTMarkup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkup[] getCustomXmlMoveFromRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVEFROMRANGEEND$40, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTMarkup> getCustomXmlMoveFromRangeEndList() {
        1CustomXmlMoveFromRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveFromRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTTrackChange getCustomXmlMoveFromRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGESTART$38, i);
            if (cTTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTTrackChange[] getCustomXmlMoveFromRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVEFROMRANGESTART$38, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTTrackChange> getCustomXmlMoveFromRangeStartList() {
        1CustomXmlMoveFromRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveFromRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkup getCustomXmlMoveToRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVETORANGEEND$44, i);
            if (cTMarkup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkup[] getCustomXmlMoveToRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVETORANGEEND$44, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTMarkup> getCustomXmlMoveToRangeEndList() {
        1CustomXmlMoveToRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveToRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTTrackChange getCustomXmlMoveToRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVETORANGESTART$42, i);
            if (cTTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTTrackChange[] getCustomXmlMoveToRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVETORANGESTART$42, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTTrackChange> getCustomXmlMoveToRangeStartList() {
        1CustomXmlMoveToRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveToRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTRunTrackChange getDelArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(DEL$48, i);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTRunTrackChange[] getDelArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DEL$48, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTRunTrackChange> getDelList() {
        1DelList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DelList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTRunTrackChange getInsArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(INS$46, i);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTRunTrackChange[] getInsArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(INS$46, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTRunTrackChange> getInsList() {
        1InsList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1InsList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTRunTrackChange getMoveFromArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(MOVEFROM$50, i);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTRunTrackChange[] getMoveFromArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROM$50, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTRunTrackChange> getMoveFromList() {
        1MoveFromList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkupRange getMoveFromRangeEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(MOVEFROMRANGEEND$20, i);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkupRange[] getMoveFromRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROMRANGEEND$20, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTMarkupRange> getMoveFromRangeEndList() {
        1MoveFromRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMoveBookmark getMoveFromRangeStartArray(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().find_element_user(MOVEFROMRANGESTART$18, i);
            if (cTMoveBookmark == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMoveBookmark[] getMoveFromRangeStartArray() {
        CTMoveBookmark[] cTMoveBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROMRANGESTART$18, arrayList);
            cTMoveBookmarkArr = new CTMoveBookmark[arrayList.size()];
            arrayList.toArray(cTMoveBookmarkArr);
        }
        return cTMoveBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTMoveBookmark> getMoveFromRangeStartList() {
        1MoveFromRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTRunTrackChange getMoveToArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(MOVETO$52, i);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTRunTrackChange[] getMoveToArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETO$52, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTRunTrackChange> getMoveToList() {
        1MoveToList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkupRange getMoveToRangeEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(MOVETORANGEEND$24, i);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkupRange[] getMoveToRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETORANGEEND$24, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTMarkupRange> getMoveToRangeEndList() {
        1MoveToRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMoveBookmark getMoveToRangeStartArray(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().find_element_user(MOVETORANGESTART$22, i);
            if (cTMoveBookmark == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMoveBookmark[] getMoveToRangeStartArray() {
        CTMoveBookmark[] cTMoveBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETORANGESTART$22, arrayList);
            cTMoveBookmarkArr = new CTMoveBookmark[arrayList.size()];
            arrayList.toArray(cTMoveBookmarkArr);
        }
        return cTMoveBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTMoveBookmark> getMoveToRangeStartList() {
        1MoveToRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTOMath getOMathArray(int i) {
        CTOMath find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(OMATH$56, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTOMath[] getOMathArray() {
        CTOMath[] cTOMathArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OMATH$56, arrayList);
            cTOMathArr = new CTOMath[arrayList.size()];
            arrayList.toArray(cTOMathArr);
        }
        return cTOMathArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTOMath> getOMathList() {
        1OMathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OMathList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTOMathPara getOMathParaArray(int i) {
        CTOMathPara find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(OMATHPARA$54, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTOMathPara[] getOMathParaArray() {
        CTOMathPara[] cTOMathParaArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OMATHPARA$54, arrayList);
            cTOMathParaArr = new CTOMathPara[arrayList.size()];
            arrayList.toArray(cTOMathParaArr);
        }
        return cTOMathParaArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTOMathPara> getOMathParaList() {
        1OMathParaList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OMathParaList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTP getPArray(int i) {
        CTP ctp;
        synchronized (monitor()) {
            check_orphaned();
            ctp = (CTP) get_store().find_element_user(P$4, i);
            if (ctp == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return ctp;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTP[] getPArray() {
        CTP[] ctpArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(P$4, arrayList);
            ctpArr = new CTP[arrayList.size()];
            arrayList.toArray(ctpArr);
        }
        return ctpArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTP> getPList() {
        1PList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTPerm getPermEndArray(int i) {
        CTPerm find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(PERMEND$12, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTPerm[] getPermEndArray() {
        CTPerm[] cTPermArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PERMEND$12, arrayList);
            cTPermArr = new CTPerm[arrayList.size()];
            arrayList.toArray(cTPermArr);
        }
        return cTPermArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTPerm> getPermEndList() {
        1PermEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PermEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTPermStart getPermStartArray(int i) {
        CTPermStart find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(PERMSTART$10, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTPermStart[] getPermStartArray() {
        CTPermStart[] cTPermStartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PERMSTART$10, arrayList);
            cTPermStartArr = new CTPermStart[arrayList.size()];
            arrayList.toArray(cTPermStartArr);
        }
        return cTPermStartArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTPermStart> getPermStartList() {
        1PermStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PermStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTProofErr getProofErrArray(int i) {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().find_element_user(PROOFERR$8, i);
            if (cTProofErr == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTProofErr[] getProofErrArray() {
        CTProofErr[] cTProofErrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PROOFERR$8, arrayList);
            cTProofErrArr = new CTProofErr[arrayList.size()];
            arrayList.toArray(cTProofErrArr);
        }
        return cTProofErrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTProofErr> getProofErrList() {
        1ProofErrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ProofErrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTSdtBlock getSdtArray(int i) {
        CTSdtBlock cTSdtBlock;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtBlock = (CTSdtBlock) get_store().find_element_user(SDT$2, i);
            if (cTSdtBlock == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSdtBlock;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTSdtBlock[] getSdtArray() {
        CTSdtBlock[] cTSdtBlockArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SDT$2, arrayList);
            cTSdtBlockArr = new CTSdtBlock[arrayList.size()];
            arrayList.toArray(cTSdtBlockArr);
        }
        return cTSdtBlockArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTSdtBlock> getSdtList() {
        1SdtList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SdtList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTTbl getTblArray(int i) {
        CTTbl cTTbl;
        synchronized (monitor()) {
            check_orphaned();
            cTTbl = (CTTbl) get_store().find_element_user(TBL$6, i);
            if (cTTbl == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTbl;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTTbl[] getTblArray() {
        CTTbl[] cTTblArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TBL$6, arrayList);
            cTTblArr = new CTTbl[arrayList.size()];
            arrayList.toArray(cTTblArr);
        }
        return cTTblArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public List<CTTbl> getTblList() {
        1TblList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TblList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTAltChunk insertNewAltChunk(int i) {
        CTAltChunk insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(ALTCHUNK$58, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkupRange insertNewBookmarkEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(BOOKMARKEND$16, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTBookmark insertNewBookmarkStart(int i) {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().insert_element_user(BOOKMARKSTART$14, i);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkupRange insertNewCommentRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(COMMENTRANGEEND$28, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkupRange insertNewCommentRangeStart(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(COMMENTRANGESTART$26, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTCustomXmlBlock insertNewCustomXml(int i) {
        CTCustomXmlBlock insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(CUSTOMXML$0, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkup insertNewCustomXmlDelRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLDELRANGEEND$36, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTTrackChange insertNewCustomXmlDelRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLDELRANGESTART$34, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkup insertNewCustomXmlInsRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLINSRANGEEND$32, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTTrackChange insertNewCustomXmlInsRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLINSRANGESTART$30, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkup insertNewCustomXmlMoveFromRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGEEND$40, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTTrackChange insertNewCustomXmlMoveFromRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGESTART$38, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkup insertNewCustomXmlMoveToRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLMOVETORANGEEND$44, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTTrackChange insertNewCustomXmlMoveToRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLMOVETORANGESTART$42, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTRunTrackChange insertNewDel(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(DEL$48, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTRunTrackChange insertNewIns(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(INS$46, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTRunTrackChange insertNewMoveFrom(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(MOVEFROM$50, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkupRange insertNewMoveFromRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(MOVEFROMRANGEEND$20, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMoveBookmark insertNewMoveFromRangeStart(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(MOVEFROMRANGESTART$18, i);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTRunTrackChange insertNewMoveTo(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(MOVETO$52, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMarkupRange insertNewMoveToRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(MOVETORANGEEND$24, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTMoveBookmark insertNewMoveToRangeStart(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(MOVETORANGESTART$22, i);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTOMath insertNewOMath(int i) {
        CTOMath insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(OMATH$56, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTOMathPara insertNewOMathPara(int i) {
        CTOMathPara insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(OMATHPARA$54, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTP insertNewP(int i) {
        CTP ctp;
        synchronized (monitor()) {
            check_orphaned();
            ctp = (CTP) get_store().insert_element_user(P$4, i);
        }
        return ctp;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTPerm insertNewPermEnd(int i) {
        CTPerm insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(PERMEND$12, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTPermStart insertNewPermStart(int i) {
        CTPermStart insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(PERMSTART$10, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTProofErr insertNewProofErr(int i) {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().insert_element_user(PROOFERR$8, i);
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTSdtBlock insertNewSdt(int i) {
        CTSdtBlock cTSdtBlock;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtBlock = (CTSdtBlock) get_store().insert_element_user(SDT$2, i);
        }
        return cTSdtBlock;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public CTTbl insertNewTbl(int i) {
        CTTbl cTTbl;
        synchronized (monitor()) {
            check_orphaned();
            cTTbl = (CTTbl) get_store().insert_element_user(TBL$6, i);
        }
        return cTTbl;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeAltChunk(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALTCHUNK$58, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeBookmarkEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKEND$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeBookmarkStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKSTART$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeCommentRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGEEND$28, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeCommentRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGESTART$26, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeCustomXml(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXML$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeCustomXmlDelRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGEEND$36, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeCustomXmlDelRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGESTART$34, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeCustomXmlInsRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGEEND$32, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeCustomXmlInsRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGESTART$30, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeCustomXmlMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGEEND$40, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeCustomXmlMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGESTART$38, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeCustomXmlMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGEEND$44, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeCustomXmlMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGESTART$42, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeDel(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEL$48, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeIns(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INS$46, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeMoveFrom(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROM$50, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGEEND$20, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGESTART$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeMoveTo(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETO$52, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGEEND$24, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGESTART$22, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeOMath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATH$56, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeOMathPara(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATHPARA$54, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeP(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(P$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removePermEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMEND$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removePermStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMSTART$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeProofErr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROOFERR$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeSdt(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SDT$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void removeTbl(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBL$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setAltChunkArray(int i, CTAltChunk cTAltChunk) {
        synchronized (monitor()) {
            check_orphaned();
            CTAltChunk find_element_user = get_store().find_element_user(ALTCHUNK$58, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTAltChunk);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setAltChunkArray(CTAltChunk[] cTAltChunkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTAltChunkArr, ALTCHUNK$58);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setBookmarkEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(BOOKMARKEND$16, i);
            if (cTMarkupRange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRange2.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setBookmarkEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, BOOKMARKEND$16);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setBookmarkStartArray(int i, CTBookmark cTBookmark) {
        synchronized (monitor()) {
            check_orphaned();
            CTBookmark cTBookmark2 = (CTBookmark) get_store().find_element_user(BOOKMARKSTART$14, i);
            if (cTBookmark2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBookmark2.set(cTBookmark);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setBookmarkStartArray(CTBookmark[] cTBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBookmarkArr, BOOKMARKSTART$14);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setCommentRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(COMMENTRANGEEND$28, i);
            if (cTMarkupRange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRange2.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setCommentRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGEEND$28);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setCommentRangeStartArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(COMMENTRANGESTART$26, i);
            if (cTMarkupRange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRange2.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setCommentRangeStartArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGESTART$26);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setCustomXmlArray(int i, CTCustomXmlBlock cTCustomXmlBlock) {
        synchronized (monitor()) {
            check_orphaned();
            CTCustomXmlBlock find_element_user = get_store().find_element_user(CUSTOMXML$0, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTCustomXmlBlock);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setCustomXmlArray(CTCustomXmlBlock[] cTCustomXmlBlockArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTCustomXmlBlockArr, CUSTOMXML$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setCustomXmlDelRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLDELRANGEEND$36, i);
            if (cTMarkup2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkup2.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setCustomXmlDelRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLDELRANGEEND$36);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setCustomXmlDelRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLDELRANGESTART$34, i);
            if (cTTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChange2.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setCustomXmlDelRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLDELRANGESTART$34);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setCustomXmlInsRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLINSRANGEEND$32, i);
            if (cTMarkup2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkup2.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setCustomXmlInsRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLINSRANGEEND$32);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setCustomXmlInsRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLINSRANGESTART$30, i);
            if (cTTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChange2.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setCustomXmlInsRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLINSRANGESTART$30);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setCustomXmlMoveFromRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGEEND$40, i);
            if (cTMarkup2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkup2.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setCustomXmlMoveFromRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVEFROMRANGEEND$40);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setCustomXmlMoveFromRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGESTART$38, i);
            if (cTTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChange2.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setCustomXmlMoveFromRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVEFROMRANGESTART$38);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setCustomXmlMoveToRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVETORANGEEND$44, i);
            if (cTMarkup2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkup2.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setCustomXmlMoveToRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVETORANGEEND$44);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setCustomXmlMoveToRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVETORANGESTART$42, i);
            if (cTTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChange2.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setCustomXmlMoveToRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVETORANGESTART$42);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setDelArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(DEL$48, i);
            if (cTRunTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChange2.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setDelArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, DEL$48);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setInsArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(INS$46, i);
            if (cTRunTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChange2.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setInsArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, INS$46);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setMoveFromArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(MOVEFROM$50, i);
            if (cTRunTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChange2.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setMoveFromArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVEFROM$50);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setMoveFromRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(MOVEFROMRANGEEND$20, i);
            if (cTMarkupRange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRange2.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setMoveFromRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVEFROMRANGEEND$20);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setMoveFromRangeStartArray(int i, CTMoveBookmark cTMoveBookmark) {
        synchronized (monitor()) {
            check_orphaned();
            CTMoveBookmark cTMoveBookmark2 = (CTMoveBookmark) get_store().find_element_user(MOVEFROMRANGESTART$18, i);
            if (cTMoveBookmark2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMoveBookmark2.set(cTMoveBookmark);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setMoveFromRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVEFROMRANGESTART$18);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setMoveToArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(MOVETO$52, i);
            if (cTRunTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChange2.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setMoveToArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVETO$52);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setMoveToRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(MOVETORANGEEND$24, i);
            if (cTMarkupRange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRange2.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setMoveToRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVETORANGEEND$24);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setMoveToRangeStartArray(int i, CTMoveBookmark cTMoveBookmark) {
        synchronized (monitor()) {
            check_orphaned();
            CTMoveBookmark cTMoveBookmark2 = (CTMoveBookmark) get_store().find_element_user(MOVETORANGESTART$22, i);
            if (cTMoveBookmark2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMoveBookmark2.set(cTMoveBookmark);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setMoveToRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVETORANGESTART$22);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setOMathArray(int i, CTOMath cTOMath) {
        synchronized (monitor()) {
            check_orphaned();
            CTOMath find_element_user = get_store().find_element_user(OMATH$56, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTOMath);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setOMathArray(CTOMath[] cTOMathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTOMathArr, OMATH$56);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setOMathParaArray(int i, CTOMathPara cTOMathPara) {
        synchronized (monitor()) {
            check_orphaned();
            CTOMathPara find_element_user = get_store().find_element_user(OMATHPARA$54, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTOMathPara);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setOMathParaArray(CTOMathPara[] cTOMathParaArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTOMathParaArr, OMATHPARA$54);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setPArray(int i, CTP ctp) {
        synchronized (monitor()) {
            check_orphaned();
            CTP ctp2 = (CTP) get_store().find_element_user(P$4, i);
            if (ctp2 == null) {
                throw new IndexOutOfBoundsException();
            }
            ctp2.set(ctp);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setPArray(CTP[] ctpArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(ctpArr, P$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setPermEndArray(int i, CTPerm cTPerm) {
        synchronized (monitor()) {
            check_orphaned();
            CTPerm find_element_user = get_store().find_element_user(PERMEND$12, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTPerm);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setPermEndArray(CTPerm[] cTPermArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPermArr, PERMEND$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setPermStartArray(int i, CTPermStart cTPermStart) {
        synchronized (monitor()) {
            check_orphaned();
            CTPermStart find_element_user = get_store().find_element_user(PERMSTART$10, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTPermStart);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setPermStartArray(CTPermStart[] cTPermStartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPermStartArr, PERMSTART$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setProofErrArray(int i, CTProofErr cTProofErr) {
        synchronized (monitor()) {
            check_orphaned();
            CTProofErr cTProofErr2 = (CTProofErr) get_store().find_element_user(PROOFERR$8, i);
            if (cTProofErr2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTProofErr2.set(cTProofErr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setProofErrArray(CTProofErr[] cTProofErrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTProofErrArr, PROOFERR$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setSdtArray(int i, CTSdtBlock cTSdtBlock) {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtBlock cTSdtBlock2 = (CTSdtBlock) get_store().find_element_user(SDT$2, i);
            if (cTSdtBlock2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSdtBlock2.set(cTSdtBlock);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setSdtArray(CTSdtBlock[] cTSdtBlockArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSdtBlockArr, SDT$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setTblArray(int i, CTTbl cTTbl) {
        synchronized (monitor()) {
            check_orphaned();
            CTTbl cTTbl2 = (CTTbl) get_store().find_element_user(TBL$6, i);
            if (cTTbl2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTbl2.set(cTTbl);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public void setTblArray(CTTbl[] cTTblArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTblArr, TBL$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfAltChunkArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ALTCHUNK$58);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfBookmarkEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BOOKMARKEND$16);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfBookmarkStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BOOKMARKSTART$14);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfCommentRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(COMMENTRANGEEND$28);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfCommentRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(COMMENTRANGESTART$26);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfCustomXmlArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXML$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfCustomXmlDelRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLDELRANGEEND$36);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfCustomXmlDelRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLDELRANGESTART$34);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfCustomXmlInsRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLINSRANGEEND$32);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfCustomXmlInsRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLINSRANGESTART$30);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfCustomXmlMoveFromRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGEEND$40);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfCustomXmlMoveFromRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGESTART$38);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfCustomXmlMoveToRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLMOVETORANGEEND$44);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfCustomXmlMoveToRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLMOVETORANGESTART$42);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfDelArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DEL$48);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfInsArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(INS$46);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfMoveFromArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVEFROM$50);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfMoveFromRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVEFROMRANGEEND$20);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfMoveFromRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVEFROMRANGESTART$18);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfMoveToArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVETO$52);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfMoveToRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVETORANGEEND$24);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfMoveToRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVETORANGESTART$22);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfOMathArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(OMATH$56);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfOMathParaArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(OMATHPARA$54);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfPArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(P$4);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfPermEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PERMEND$12);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfPermStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PERMSTART$10);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfProofErrArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PROOFERR$8);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfSdtArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SDT$2);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent
    public int sizeOfTblArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TBL$6);
        }
        return count_elements;
    }
}
