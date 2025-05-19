package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

/* loaded from: classes6.dex */
public class CTTcImpl extends XmlComplexContentImpl implements CTTc {
    private static final QName TCPR$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcPr");
    private static final QName CUSTOMXML$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXml");
    private static final QName SDT$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdt");
    private static final QName P$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", TtmlNode.TAG_P);
    private static final QName TBL$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tbl");
    private static final QName PROOFERR$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "proofErr");
    private static final QName PERMSTART$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permStart");
    private static final QName PERMEND$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permEnd");
    private static final QName BOOKMARKSTART$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkStart");
    private static final QName BOOKMARKEND$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkEnd");
    private static final QName MOVEFROMRANGESTART$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeStart");
    private static final QName MOVEFROMRANGEEND$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeEnd");
    private static final QName MOVETORANGESTART$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeStart");
    private static final QName MOVETORANGEEND$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeEnd");
    private static final QName COMMENTRANGESTART$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeStart");
    private static final QName COMMENTRANGEEND$30 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeEnd");
    private static final QName CUSTOMXMLINSRANGESTART$32 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeStart");
    private static final QName CUSTOMXMLINSRANGEEND$34 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeEnd");
    private static final QName CUSTOMXMLDELRANGESTART$36 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeStart");
    private static final QName CUSTOMXMLDELRANGEEND$38 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeEnd");
    private static final QName CUSTOMXMLMOVEFROMRANGESTART$40 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeStart");
    private static final QName CUSTOMXMLMOVEFROMRANGEEND$42 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeEnd");
    private static final QName CUSTOMXMLMOVETORANGESTART$44 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeStart");
    private static final QName CUSTOMXMLMOVETORANGEEND$46 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeEnd");
    private static final QName INS$48 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins");
    private static final QName DEL$50 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "del");
    private static final QName MOVEFROM$52 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFrom");
    private static final QName MOVETO$54 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveTo");
    private static final QName OMATHPARA$56 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMathPara");
    private static final QName OMATH$58 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMath");
    private static final QName ALTCHUNK$60 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "altChunk");

    public CTTcImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTAltChunk addNewAltChunk() {
        CTAltChunk add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(ALTCHUNK$60);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange addNewBookmarkEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(BOOKMARKEND$18);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTBookmark addNewBookmarkStart() {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().add_element_user(BOOKMARKSTART$16);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange addNewCommentRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(COMMENTRANGEEND$30);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange addNewCommentRangeStart() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(COMMENTRANGESTART$28);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTCustomXmlBlock addNewCustomXml() {
        CTCustomXmlBlock add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CUSTOMXML$2);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup addNewCustomXmlDelRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLDELRANGEEND$38);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange addNewCustomXmlDelRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLDELRANGESTART$36);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup addNewCustomXmlInsRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLINSRANGEEND$34);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange addNewCustomXmlInsRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLINSRANGESTART$32);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup addNewCustomXmlMoveFromRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLMOVEFROMRANGEEND$42);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange addNewCustomXmlMoveFromRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLMOVEFROMRANGESTART$40);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup addNewCustomXmlMoveToRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLMOVETORANGEEND$46);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange addNewCustomXmlMoveToRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLMOVETORANGESTART$44);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange addNewDel() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(DEL$50);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange addNewIns() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(INS$48);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange addNewMoveFrom() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(MOVEFROM$52);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange addNewMoveFromRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(MOVEFROMRANGEEND$22);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMoveBookmark addNewMoveFromRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(MOVEFROMRANGESTART$20);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange addNewMoveTo() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(MOVETO$54);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange addNewMoveToRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(MOVETORANGEEND$26);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMoveBookmark addNewMoveToRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(MOVETORANGESTART$24);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTOMath addNewOMath() {
        CTOMath add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(OMATH$58);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTOMathPara addNewOMathPara() {
        CTOMathPara add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(OMATHPARA$56);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTP addNewP() {
        CTP ctp;
        synchronized (monitor()) {
            check_orphaned();
            ctp = (CTP) get_store().add_element_user(P$6);
        }
        return ctp;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTPerm addNewPermEnd() {
        CTPerm add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(PERMEND$14);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTPermStart addNewPermStart() {
        CTPermStart add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(PERMSTART$12);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTProofErr addNewProofErr() {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().add_element_user(PROOFERR$10);
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTSdtBlock addNewSdt() {
        CTSdtBlock cTSdtBlock;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtBlock = (CTSdtBlock) get_store().add_element_user(SDT$4);
        }
        return cTSdtBlock;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTbl addNewTbl() {
        CTTbl cTTbl;
        synchronized (monitor()) {
            check_orphaned();
            cTTbl = (CTTbl) get_store().add_element_user(TBL$8);
        }
        return cTTbl;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTcPr addNewTcPr() {
        CTTcPr cTTcPr;
        synchronized (monitor()) {
            check_orphaned();
            cTTcPr = (CTTcPr) get_store().add_element_user(TCPR$0);
        }
        return cTTcPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTAltChunk getAltChunkArray(int i) {
        CTAltChunk find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(ALTCHUNK$60, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTAltChunk[] getAltChunkArray() {
        CTAltChunk[] cTAltChunkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ALTCHUNK$60, arrayList);
            cTAltChunkArr = new CTAltChunk[arrayList.size()];
            arrayList.toArray(cTAltChunkArr);
        }
        return cTAltChunkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTAltChunk> getAltChunkList() {
        1AltChunkList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AltChunkList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange getBookmarkEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(BOOKMARKEND$18, i);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange[] getBookmarkEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOOKMARKEND$18, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTMarkupRange> getBookmarkEndList() {
        1BookmarkEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BookmarkEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTBookmark getBookmarkStartArray(int i) {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().find_element_user(BOOKMARKSTART$16, i);
            if (cTBookmark == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTBookmark[] getBookmarkStartArray() {
        CTBookmark[] cTBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOOKMARKSTART$16, arrayList);
            cTBookmarkArr = new CTBookmark[arrayList.size()];
            arrayList.toArray(cTBookmarkArr);
        }
        return cTBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTBookmark> getBookmarkStartList() {
        1BookmarkStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BookmarkStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange getCommentRangeEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(COMMENTRANGEEND$30, i);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange[] getCommentRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMMENTRANGEEND$30, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTMarkupRange> getCommentRangeEndList() {
        1CommentRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CommentRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange getCommentRangeStartArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(COMMENTRANGESTART$28, i);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange[] getCommentRangeStartArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMMENTRANGESTART$28, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTMarkupRange> getCommentRangeStartList() {
        1CommentRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CommentRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTCustomXmlBlock getCustomXmlArray(int i) {
        CTCustomXmlBlock find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(CUSTOMXML$2, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTCustomXmlBlock[] getCustomXmlArray() {
        CTCustomXmlBlock[] cTCustomXmlBlockArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXML$2, arrayList);
            cTCustomXmlBlockArr = new CTCustomXmlBlock[arrayList.size()];
            arrayList.toArray(cTCustomXmlBlockArr);
        }
        return cTCustomXmlBlockArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup getCustomXmlDelRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLDELRANGEEND$38, i);
            if (cTMarkup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup[] getCustomXmlDelRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLDELRANGEEND$38, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTMarkup> getCustomXmlDelRangeEndList() {
        1CustomXmlDelRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlDelRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange getCustomXmlDelRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLDELRANGESTART$36, i);
            if (cTTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange[] getCustomXmlDelRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLDELRANGESTART$36, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTTrackChange> getCustomXmlDelRangeStartList() {
        1CustomXmlDelRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlDelRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup getCustomXmlInsRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLINSRANGEEND$34, i);
            if (cTMarkup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup[] getCustomXmlInsRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLINSRANGEEND$34, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTMarkup> getCustomXmlInsRangeEndList() {
        1CustomXmlInsRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlInsRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange getCustomXmlInsRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLINSRANGESTART$32, i);
            if (cTTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange[] getCustomXmlInsRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLINSRANGESTART$32, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTTrackChange> getCustomXmlInsRangeStartList() {
        1CustomXmlInsRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlInsRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTCustomXmlBlock> getCustomXmlList() {
        1CustomXmlList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup getCustomXmlMoveFromRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGEEND$42, i);
            if (cTMarkup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup[] getCustomXmlMoveFromRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVEFROMRANGEEND$42, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTMarkup> getCustomXmlMoveFromRangeEndList() {
        1CustomXmlMoveFromRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveFromRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange getCustomXmlMoveFromRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGESTART$40, i);
            if (cTTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange[] getCustomXmlMoveFromRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVEFROMRANGESTART$40, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTTrackChange> getCustomXmlMoveFromRangeStartList() {
        1CustomXmlMoveFromRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveFromRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup getCustomXmlMoveToRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVETORANGEEND$46, i);
            if (cTMarkup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup[] getCustomXmlMoveToRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVETORANGEEND$46, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTMarkup> getCustomXmlMoveToRangeEndList() {
        1CustomXmlMoveToRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveToRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange getCustomXmlMoveToRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVETORANGESTART$44, i);
            if (cTTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange[] getCustomXmlMoveToRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVETORANGESTART$44, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTTrackChange> getCustomXmlMoveToRangeStartList() {
        1CustomXmlMoveToRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveToRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange getDelArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(DEL$50, i);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange[] getDelArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DEL$50, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTRunTrackChange> getDelList() {
        1DelList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DelList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange getInsArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(INS$48, i);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange[] getInsArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(INS$48, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTRunTrackChange> getInsList() {
        1InsList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1InsList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange getMoveFromArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(MOVEFROM$52, i);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange[] getMoveFromArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROM$52, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTRunTrackChange> getMoveFromList() {
        1MoveFromList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange getMoveFromRangeEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(MOVEFROMRANGEEND$22, i);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange[] getMoveFromRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROMRANGEEND$22, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTMarkupRange> getMoveFromRangeEndList() {
        1MoveFromRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMoveBookmark getMoveFromRangeStartArray(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().find_element_user(MOVEFROMRANGESTART$20, i);
            if (cTMoveBookmark == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMoveBookmark[] getMoveFromRangeStartArray() {
        CTMoveBookmark[] cTMoveBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROMRANGESTART$20, arrayList);
            cTMoveBookmarkArr = new CTMoveBookmark[arrayList.size()];
            arrayList.toArray(cTMoveBookmarkArr);
        }
        return cTMoveBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTMoveBookmark> getMoveFromRangeStartList() {
        1MoveFromRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange getMoveToArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(MOVETO$54, i);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange[] getMoveToArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETO$54, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTRunTrackChange> getMoveToList() {
        1MoveToList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange getMoveToRangeEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(MOVETORANGEEND$26, i);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange[] getMoveToRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETORANGEEND$26, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTMarkupRange> getMoveToRangeEndList() {
        1MoveToRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMoveBookmark getMoveToRangeStartArray(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().find_element_user(MOVETORANGESTART$24, i);
            if (cTMoveBookmark == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMoveBookmark[] getMoveToRangeStartArray() {
        CTMoveBookmark[] cTMoveBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETORANGESTART$24, arrayList);
            cTMoveBookmarkArr = new CTMoveBookmark[arrayList.size()];
            arrayList.toArray(cTMoveBookmarkArr);
        }
        return cTMoveBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTMoveBookmark> getMoveToRangeStartList() {
        1MoveToRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTOMath getOMathArray(int i) {
        CTOMath find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(OMATH$58, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTOMath[] getOMathArray() {
        CTOMath[] cTOMathArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OMATH$58, arrayList);
            cTOMathArr = new CTOMath[arrayList.size()];
            arrayList.toArray(cTOMathArr);
        }
        return cTOMathArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTOMath> getOMathList() {
        1OMathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OMathList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTOMathPara getOMathParaArray(int i) {
        CTOMathPara find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(OMATHPARA$56, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTOMathPara[] getOMathParaArray() {
        CTOMathPara[] cTOMathParaArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OMATHPARA$56, arrayList);
            cTOMathParaArr = new CTOMathPara[arrayList.size()];
            arrayList.toArray(cTOMathParaArr);
        }
        return cTOMathParaArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTOMathPara> getOMathParaList() {
        1OMathParaList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OMathParaList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTP getPArray(int i) {
        CTP ctp;
        synchronized (monitor()) {
            check_orphaned();
            ctp = (CTP) get_store().find_element_user(P$6, i);
            if (ctp == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return ctp;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTP[] getPArray() {
        CTP[] ctpArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(P$6, arrayList);
            ctpArr = new CTP[arrayList.size()];
            arrayList.toArray(ctpArr);
        }
        return ctpArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTP> getPList() {
        1PList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTPerm getPermEndArray(int i) {
        CTPerm find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(PERMEND$14, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTPerm[] getPermEndArray() {
        CTPerm[] cTPermArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PERMEND$14, arrayList);
            cTPermArr = new CTPerm[arrayList.size()];
            arrayList.toArray(cTPermArr);
        }
        return cTPermArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTPerm> getPermEndList() {
        1PermEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PermEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTPermStart getPermStartArray(int i) {
        CTPermStart find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(PERMSTART$12, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTPermStart[] getPermStartArray() {
        CTPermStart[] cTPermStartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PERMSTART$12, arrayList);
            cTPermStartArr = new CTPermStart[arrayList.size()];
            arrayList.toArray(cTPermStartArr);
        }
        return cTPermStartArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTPermStart> getPermStartList() {
        1PermStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PermStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTProofErr getProofErrArray(int i) {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().find_element_user(PROOFERR$10, i);
            if (cTProofErr == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTProofErr[] getProofErrArray() {
        CTProofErr[] cTProofErrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PROOFERR$10, arrayList);
            cTProofErrArr = new CTProofErr[arrayList.size()];
            arrayList.toArray(cTProofErrArr);
        }
        return cTProofErrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTProofErr> getProofErrList() {
        1ProofErrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ProofErrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTSdtBlock getSdtArray(int i) {
        CTSdtBlock cTSdtBlock;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtBlock = (CTSdtBlock) get_store().find_element_user(SDT$4, i);
            if (cTSdtBlock == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSdtBlock;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTSdtBlock[] getSdtArray() {
        CTSdtBlock[] cTSdtBlockArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SDT$4, arrayList);
            cTSdtBlockArr = new CTSdtBlock[arrayList.size()];
            arrayList.toArray(cTSdtBlockArr);
        }
        return cTSdtBlockArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTSdtBlock> getSdtList() {
        1SdtList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SdtList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTbl getTblArray(int i) {
        CTTbl cTTbl;
        synchronized (monitor()) {
            check_orphaned();
            cTTbl = (CTTbl) get_store().find_element_user(TBL$8, i);
            if (cTTbl == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTbl;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTbl[] getTblArray() {
        CTTbl[] cTTblArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TBL$8, arrayList);
            cTTblArr = new CTTbl[arrayList.size()];
            arrayList.toArray(cTTblArr);
        }
        return cTTblArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTTbl> getTblList() {
        1TblList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TblList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTcPr getTcPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTcPr cTTcPr = (CTTcPr) get_store().find_element_user(TCPR$0, 0);
            if (cTTcPr == null) {
                return null;
            }
            return cTTcPr;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTAltChunk insertNewAltChunk(int i) {
        CTAltChunk insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(ALTCHUNK$60, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange insertNewBookmarkEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(BOOKMARKEND$18, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTBookmark insertNewBookmarkStart(int i) {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().insert_element_user(BOOKMARKSTART$16, i);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange insertNewCommentRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(COMMENTRANGEEND$30, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange insertNewCommentRangeStart(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(COMMENTRANGESTART$28, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTCustomXmlBlock insertNewCustomXml(int i) {
        CTCustomXmlBlock insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(CUSTOMXML$2, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup insertNewCustomXmlDelRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLDELRANGEEND$38, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange insertNewCustomXmlDelRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLDELRANGESTART$36, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup insertNewCustomXmlInsRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLINSRANGEEND$34, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange insertNewCustomXmlInsRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLINSRANGESTART$32, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup insertNewCustomXmlMoveFromRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGEEND$42, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange insertNewCustomXmlMoveFromRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGESTART$40, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup insertNewCustomXmlMoveToRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLMOVETORANGEEND$46, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange insertNewCustomXmlMoveToRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLMOVETORANGESTART$44, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange insertNewDel(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(DEL$50, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange insertNewIns(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(INS$48, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange insertNewMoveFrom(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(MOVEFROM$52, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange insertNewMoveFromRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(MOVEFROMRANGEEND$22, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMoveBookmark insertNewMoveFromRangeStart(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(MOVEFROMRANGESTART$20, i);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange insertNewMoveTo(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(MOVETO$54, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange insertNewMoveToRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(MOVETORANGEEND$26, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMoveBookmark insertNewMoveToRangeStart(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(MOVETORANGESTART$24, i);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTOMath insertNewOMath(int i) {
        CTOMath insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(OMATH$58, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTOMathPara insertNewOMathPara(int i) {
        CTOMathPara insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(OMATHPARA$56, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTP insertNewP(int i) {
        CTP ctp;
        synchronized (monitor()) {
            check_orphaned();
            ctp = (CTP) get_store().insert_element_user(P$6, i);
        }
        return ctp;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTPerm insertNewPermEnd(int i) {
        CTPerm insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(PERMEND$14, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTPermStart insertNewPermStart(int i) {
        CTPermStart insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(PERMSTART$12, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTProofErr insertNewProofErr(int i) {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().insert_element_user(PROOFERR$10, i);
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTSdtBlock insertNewSdt(int i) {
        CTSdtBlock cTSdtBlock;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtBlock = (CTSdtBlock) get_store().insert_element_user(SDT$4, i);
        }
        return cTSdtBlock;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTbl insertNewTbl(int i) {
        CTTbl cTTbl;
        synchronized (monitor()) {
            check_orphaned();
            cTTbl = (CTTbl) get_store().insert_element_user(TBL$8, i);
        }
        return cTTbl;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public boolean isSetTcPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TCPR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeAltChunk(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALTCHUNK$60, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeBookmarkEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKEND$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeBookmarkStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKSTART$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeCommentRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGEEND$30, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeCommentRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGESTART$28, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeCustomXml(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXML$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeCustomXmlDelRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGEEND$38, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeCustomXmlDelRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGESTART$36, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeCustomXmlInsRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGEEND$34, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeCustomXmlInsRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGESTART$32, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeCustomXmlMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGEEND$42, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeCustomXmlMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGESTART$40, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeCustomXmlMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGEEND$46, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeCustomXmlMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGESTART$44, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeDel(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEL$50, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeIns(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INS$48, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeMoveFrom(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROM$52, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGEEND$22, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGESTART$20, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeMoveTo(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETO$54, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGEEND$26, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGESTART$24, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeOMath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATH$58, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeOMathPara(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATHPARA$56, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeP(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(P$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removePermEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMEND$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removePermStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMSTART$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeProofErr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROOFERR$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeSdt(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SDT$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeTbl(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBL$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setAltChunkArray(int i, CTAltChunk cTAltChunk) {
        synchronized (monitor()) {
            check_orphaned();
            CTAltChunk find_element_user = get_store().find_element_user(ALTCHUNK$60, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTAltChunk);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setAltChunkArray(CTAltChunk[] cTAltChunkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTAltChunkArr, ALTCHUNK$60);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setBookmarkEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(BOOKMARKEND$18, i);
            if (cTMarkupRange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRange2.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setBookmarkEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, BOOKMARKEND$18);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setBookmarkStartArray(int i, CTBookmark cTBookmark) {
        synchronized (monitor()) {
            check_orphaned();
            CTBookmark cTBookmark2 = (CTBookmark) get_store().find_element_user(BOOKMARKSTART$16, i);
            if (cTBookmark2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBookmark2.set(cTBookmark);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setBookmarkStartArray(CTBookmark[] cTBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBookmarkArr, BOOKMARKSTART$16);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCommentRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(COMMENTRANGEEND$30, i);
            if (cTMarkupRange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRange2.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCommentRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGEEND$30);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCommentRangeStartArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(COMMENTRANGESTART$28, i);
            if (cTMarkupRange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRange2.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCommentRangeStartArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGESTART$28);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlArray(int i, CTCustomXmlBlock cTCustomXmlBlock) {
        synchronized (monitor()) {
            check_orphaned();
            CTCustomXmlBlock find_element_user = get_store().find_element_user(CUSTOMXML$2, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTCustomXmlBlock);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlArray(CTCustomXmlBlock[] cTCustomXmlBlockArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTCustomXmlBlockArr, CUSTOMXML$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlDelRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLDELRANGEEND$38, i);
            if (cTMarkup2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkup2.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlDelRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLDELRANGEEND$38);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlDelRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLDELRANGESTART$36, i);
            if (cTTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChange2.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlDelRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLDELRANGESTART$36);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlInsRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLINSRANGEEND$34, i);
            if (cTMarkup2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkup2.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlInsRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLINSRANGEEND$34);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlInsRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLINSRANGESTART$32, i);
            if (cTTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChange2.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlInsRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLINSRANGESTART$32);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlMoveFromRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGEEND$42, i);
            if (cTMarkup2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkup2.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlMoveFromRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVEFROMRANGEEND$42);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlMoveFromRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGESTART$40, i);
            if (cTTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChange2.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlMoveFromRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVEFROMRANGESTART$40);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlMoveToRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVETORANGEEND$46, i);
            if (cTMarkup2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkup2.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlMoveToRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVETORANGEEND$46);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlMoveToRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVETORANGESTART$44, i);
            if (cTTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChange2.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlMoveToRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVETORANGESTART$44);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setDelArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(DEL$50, i);
            if (cTRunTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChange2.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setDelArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, DEL$50);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setInsArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(INS$48, i);
            if (cTRunTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChange2.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setInsArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, INS$48);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveFromArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(MOVEFROM$52, i);
            if (cTRunTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChange2.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveFromArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVEFROM$52);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveFromRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(MOVEFROMRANGEEND$22, i);
            if (cTMarkupRange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRange2.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveFromRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVEFROMRANGEEND$22);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveFromRangeStartArray(int i, CTMoveBookmark cTMoveBookmark) {
        synchronized (monitor()) {
            check_orphaned();
            CTMoveBookmark cTMoveBookmark2 = (CTMoveBookmark) get_store().find_element_user(MOVEFROMRANGESTART$20, i);
            if (cTMoveBookmark2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMoveBookmark2.set(cTMoveBookmark);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveFromRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVEFROMRANGESTART$20);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveToArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(MOVETO$54, i);
            if (cTRunTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChange2.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveToArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVETO$54);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveToRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(MOVETORANGEEND$26, i);
            if (cTMarkupRange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRange2.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveToRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVETORANGEEND$26);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveToRangeStartArray(int i, CTMoveBookmark cTMoveBookmark) {
        synchronized (monitor()) {
            check_orphaned();
            CTMoveBookmark cTMoveBookmark2 = (CTMoveBookmark) get_store().find_element_user(MOVETORANGESTART$24, i);
            if (cTMoveBookmark2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMoveBookmark2.set(cTMoveBookmark);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveToRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVETORANGESTART$24);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setOMathArray(int i, CTOMath cTOMath) {
        synchronized (monitor()) {
            check_orphaned();
            CTOMath find_element_user = get_store().find_element_user(OMATH$58, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTOMath);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setOMathArray(CTOMath[] cTOMathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTOMathArr, OMATH$58);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setOMathParaArray(int i, CTOMathPara cTOMathPara) {
        synchronized (monitor()) {
            check_orphaned();
            CTOMathPara find_element_user = get_store().find_element_user(OMATHPARA$56, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTOMathPara);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setOMathParaArray(CTOMathPara[] cTOMathParaArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTOMathParaArr, OMATHPARA$56);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setPArray(int i, CTP ctp) {
        synchronized (monitor()) {
            check_orphaned();
            CTP ctp2 = (CTP) get_store().find_element_user(P$6, i);
            if (ctp2 == null) {
                throw new IndexOutOfBoundsException();
            }
            ctp2.set(ctp);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setPArray(CTP[] ctpArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(ctpArr, P$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setPermEndArray(int i, CTPerm cTPerm) {
        synchronized (monitor()) {
            check_orphaned();
            CTPerm find_element_user = get_store().find_element_user(PERMEND$14, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTPerm);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setPermEndArray(CTPerm[] cTPermArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPermArr, PERMEND$14);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setPermStartArray(int i, CTPermStart cTPermStart) {
        synchronized (monitor()) {
            check_orphaned();
            CTPermStart find_element_user = get_store().find_element_user(PERMSTART$12, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTPermStart);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setPermStartArray(CTPermStart[] cTPermStartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPermStartArr, PERMSTART$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setProofErrArray(int i, CTProofErr cTProofErr) {
        synchronized (monitor()) {
            check_orphaned();
            CTProofErr cTProofErr2 = (CTProofErr) get_store().find_element_user(PROOFERR$10, i);
            if (cTProofErr2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTProofErr2.set(cTProofErr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setProofErrArray(CTProofErr[] cTProofErrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTProofErrArr, PROOFERR$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setSdtArray(int i, CTSdtBlock cTSdtBlock) {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtBlock cTSdtBlock2 = (CTSdtBlock) get_store().find_element_user(SDT$4, i);
            if (cTSdtBlock2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSdtBlock2.set(cTSdtBlock);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setSdtArray(CTSdtBlock[] cTSdtBlockArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSdtBlockArr, SDT$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setTblArray(int i, CTTbl cTTbl) {
        synchronized (monitor()) {
            check_orphaned();
            CTTbl cTTbl2 = (CTTbl) get_store().find_element_user(TBL$8, i);
            if (cTTbl2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTbl2.set(cTTbl);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setTblArray(CTTbl[] cTTblArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTblArr, TBL$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setTcPr(CTTcPr cTTcPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TCPR$0;
            CTTcPr cTTcPr2 = (CTTcPr) typeStore.find_element_user(qName, 0);
            if (cTTcPr2 == null) {
                cTTcPr2 = (CTTcPr) get_store().add_element_user(qName);
            }
            cTTcPr2.set(cTTcPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfAltChunkArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ALTCHUNK$60);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfBookmarkEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BOOKMARKEND$18);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfBookmarkStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BOOKMARKSTART$16);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfCommentRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(COMMENTRANGEEND$30);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfCommentRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(COMMENTRANGESTART$28);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfCustomXmlArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXML$2);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfCustomXmlDelRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLDELRANGEEND$38);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfCustomXmlDelRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLDELRANGESTART$36);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfCustomXmlInsRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLINSRANGEEND$34);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfCustomXmlInsRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLINSRANGESTART$32);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfCustomXmlMoveFromRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGEEND$42);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfCustomXmlMoveFromRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGESTART$40);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfCustomXmlMoveToRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLMOVETORANGEEND$46);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfCustomXmlMoveToRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLMOVETORANGESTART$44);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfDelArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DEL$50);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfInsArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(INS$48);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfMoveFromArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVEFROM$52);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfMoveFromRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVEFROMRANGEEND$22);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfMoveFromRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVEFROMRANGESTART$20);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfMoveToArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVETO$54);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfMoveToRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVETORANGEEND$26);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfMoveToRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVETORANGESTART$24);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfOMathArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(OMATH$58);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfOMathParaArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(OMATHPARA$56);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfPArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(P$6);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfPermEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PERMEND$14);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfPermStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PERMSTART$12);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfProofErrArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PROOFERR$10);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfSdtArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SDT$4);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfTblArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TBL$8);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void unsetTcPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TCPR$0, 0);
        }
    }
}
