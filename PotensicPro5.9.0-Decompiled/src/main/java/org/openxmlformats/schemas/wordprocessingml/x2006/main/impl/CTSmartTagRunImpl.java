package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMoveBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPerm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPermStart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRel;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STString;

/* loaded from: classes6.dex */
public class CTSmartTagRunImpl extends XmlComplexContentImpl implements CTSmartTagRun {
    private static final QName SMARTTAGPR$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "smartTagPr");
    private static final QName CUSTOMXML$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXml");
    private static final QName SMARTTAG$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "smartTag");
    private static final QName SDT$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdt");
    private static final QName R$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", InternalZipConstants.READ_MODE);
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
    private static final QName FLDSIMPLE$60 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fldSimple");
    private static final QName HYPERLINK$62 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hyperlink");
    private static final QName SUBDOC$64 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "subDoc");
    private static final QName URI$66 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "uri");
    private static final QName ELEMENT$68 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "element");

    public CTSmartTagRunImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTMarkupRange addNewBookmarkEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(BOOKMARKEND$18);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTBookmark addNewBookmarkStart() {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().add_element_user(BOOKMARKSTART$16);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTMarkupRange addNewCommentRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(COMMENTRANGEEND$30);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTMarkupRange addNewCommentRangeStart() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(COMMENTRANGESTART$28);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTCustomXmlRun addNewCustomXml() {
        CTCustomXmlRun add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CUSTOMXML$2);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTMarkup addNewCustomXmlDelRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLDELRANGEEND$38);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTTrackChange addNewCustomXmlDelRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLDELRANGESTART$36);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTMarkup addNewCustomXmlInsRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLINSRANGEEND$34);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTTrackChange addNewCustomXmlInsRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLINSRANGESTART$32);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTMarkup addNewCustomXmlMoveFromRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLMOVEFROMRANGEEND$42);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTTrackChange addNewCustomXmlMoveFromRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLMOVEFROMRANGESTART$40);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTMarkup addNewCustomXmlMoveToRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLMOVETORANGEEND$46);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTTrackChange addNewCustomXmlMoveToRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLMOVETORANGESTART$44);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTRunTrackChange addNewDel() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(DEL$50);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTSimpleField addNewFldSimple() {
        CTSimpleField cTSimpleField;
        synchronized (monitor()) {
            check_orphaned();
            cTSimpleField = (CTSimpleField) get_store().add_element_user(FLDSIMPLE$60);
        }
        return cTSimpleField;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTHyperlink addNewHyperlink() {
        CTHyperlink cTHyperlink;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlink = (CTHyperlink) get_store().add_element_user(HYPERLINK$62);
        }
        return cTHyperlink;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTRunTrackChange addNewIns() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(INS$48);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTRunTrackChange addNewMoveFrom() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(MOVEFROM$52);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTMarkupRange addNewMoveFromRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(MOVEFROMRANGEEND$22);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTMoveBookmark addNewMoveFromRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(MOVEFROMRANGESTART$20);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTRunTrackChange addNewMoveTo() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(MOVETO$54);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTMarkupRange addNewMoveToRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(MOVETORANGEEND$26);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTMoveBookmark addNewMoveToRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(MOVETORANGESTART$24);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTOMath addNewOMath() {
        CTOMath add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(OMATH$58);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTOMathPara addNewOMathPara() {
        CTOMathPara add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(OMATHPARA$56);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTPerm addNewPermEnd() {
        CTPerm add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(PERMEND$14);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTPermStart addNewPermStart() {
        CTPermStart add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(PERMSTART$12);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTProofErr addNewProofErr() {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().add_element_user(PROOFERR$10);
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTR addNewR() {
        CTR ctr;
        synchronized (monitor()) {
            check_orphaned();
            ctr = (CTR) get_store().add_element_user(R$8);
        }
        return ctr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTSdtRun addNewSdt() {
        CTSdtRun cTSdtRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtRun = (CTSdtRun) get_store().add_element_user(SDT$6);
        }
        return cTSdtRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTSmartTagRun addNewSmartTag() {
        CTSmartTagRun cTSmartTagRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagRun = (CTSmartTagRun) get_store().add_element_user(SMARTTAG$4);
        }
        return cTSmartTagRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTSmartTagPr addNewSmartTagPr() {
        CTSmartTagPr cTSmartTagPr;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagPr = (CTSmartTagPr) get_store().add_element_user(SMARTTAGPR$0);
        }
        return cTSmartTagPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTRel addNewSubDoc() {
        CTRel cTRel;
        synchronized (monitor()) {
            check_orphaned();
            cTRel = (CTRel) get_store().add_element_user(SUBDOC$64);
        }
        return cTRel;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTMarkupRange> getBookmarkEndList() {
        1BookmarkEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BookmarkEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTBookmark> getBookmarkStartList() {
        1BookmarkStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BookmarkStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTMarkupRange> getCommentRangeEndList() {
        1CommentRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CommentRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTMarkupRange> getCommentRangeStartList() {
        1CommentRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CommentRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTCustomXmlRun getCustomXmlArray(int i) {
        CTCustomXmlRun find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(CUSTOMXML$2, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTCustomXmlRun[] getCustomXmlArray() {
        CTCustomXmlRun[] cTCustomXmlRunArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXML$2, arrayList);
            cTCustomXmlRunArr = new CTCustomXmlRun[arrayList.size()];
            arrayList.toArray(cTCustomXmlRunArr);
        }
        return cTCustomXmlRunArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTMarkup> getCustomXmlDelRangeEndList() {
        1CustomXmlDelRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlDelRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTTrackChange> getCustomXmlDelRangeStartList() {
        1CustomXmlDelRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlDelRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTMarkup> getCustomXmlInsRangeEndList() {
        1CustomXmlInsRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlInsRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTTrackChange> getCustomXmlInsRangeStartList() {
        1CustomXmlInsRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlInsRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTCustomXmlRun> getCustomXmlList() {
        1CustomXmlList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTMarkup> getCustomXmlMoveFromRangeEndList() {
        1CustomXmlMoveFromRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveFromRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTTrackChange> getCustomXmlMoveFromRangeStartList() {
        1CustomXmlMoveFromRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveFromRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTMarkup> getCustomXmlMoveToRangeEndList() {
        1CustomXmlMoveToRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveToRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTTrackChange> getCustomXmlMoveToRangeStartList() {
        1CustomXmlMoveToRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveToRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTRunTrackChange> getDelList() {
        1DelList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DelList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public String getElement() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ELEMENT$68);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTSimpleField getFldSimpleArray(int i) {
        CTSimpleField cTSimpleField;
        synchronized (monitor()) {
            check_orphaned();
            cTSimpleField = (CTSimpleField) get_store().find_element_user(FLDSIMPLE$60, i);
            if (cTSimpleField == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSimpleField;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTSimpleField[] getFldSimpleArray() {
        CTSimpleField[] cTSimpleFieldArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FLDSIMPLE$60, arrayList);
            cTSimpleFieldArr = new CTSimpleField[arrayList.size()];
            arrayList.toArray(cTSimpleFieldArr);
        }
        return cTSimpleFieldArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTSimpleField> getFldSimpleList() {
        1FldSimpleList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FldSimpleList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTHyperlink getHyperlinkArray(int i) {
        CTHyperlink cTHyperlink;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlink = (CTHyperlink) get_store().find_element_user(HYPERLINK$62, i);
            if (cTHyperlink == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTHyperlink;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTHyperlink[] getHyperlinkArray() {
        CTHyperlink[] cTHyperlinkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(HYPERLINK$62, arrayList);
            cTHyperlinkArr = new CTHyperlink[arrayList.size()];
            arrayList.toArray(cTHyperlinkArr);
        }
        return cTHyperlinkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTHyperlink> getHyperlinkList() {
        1HyperlinkList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1HyperlinkList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTRunTrackChange> getInsList() {
        1InsList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1InsList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTRunTrackChange> getMoveFromList() {
        1MoveFromList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTMarkupRange> getMoveFromRangeEndList() {
        1MoveFromRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTMoveBookmark> getMoveFromRangeStartList() {
        1MoveFromRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTRunTrackChange> getMoveToList() {
        1MoveToList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTMarkupRange> getMoveToRangeEndList() {
        1MoveToRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTMoveBookmark> getMoveToRangeStartList() {
        1MoveToRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTOMath> getOMathList() {
        1OMathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OMathList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTOMathPara> getOMathParaList() {
        1OMathParaList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OMathParaList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTPerm> getPermEndList() {
        1PermEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PermEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTPermStart> getPermStartList() {
        1PermStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PermStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTProofErr> getProofErrList() {
        1ProofErrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ProofErrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTR getRArray(int i) {
        CTR ctr;
        synchronized (monitor()) {
            check_orphaned();
            ctr = (CTR) get_store().find_element_user(R$8, i);
            if (ctr == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return ctr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTR[] getRArray() {
        CTR[] ctrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(R$8, arrayList);
            ctrArr = new CTR[arrayList.size()];
            arrayList.toArray(ctrArr);
        }
        return ctrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTR> getRList() {
        1RList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTSdtRun getSdtArray(int i) {
        CTSdtRun cTSdtRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtRun = (CTSdtRun) get_store().find_element_user(SDT$6, i);
            if (cTSdtRun == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSdtRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTSdtRun[] getSdtArray() {
        CTSdtRun[] cTSdtRunArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SDT$6, arrayList);
            cTSdtRunArr = new CTSdtRun[arrayList.size()];
            arrayList.toArray(cTSdtRunArr);
        }
        return cTSdtRunArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTSdtRun> getSdtList() {
        1SdtList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SdtList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTSmartTagRun getSmartTagArray(int i) {
        CTSmartTagRun cTSmartTagRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagRun = (CTSmartTagRun) get_store().find_element_user(SMARTTAG$4, i);
            if (cTSmartTagRun == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSmartTagRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTSmartTagRun[] getSmartTagArray() {
        CTSmartTagRun[] cTSmartTagRunArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SMARTTAG$4, arrayList);
            cTSmartTagRunArr = new CTSmartTagRun[arrayList.size()];
            arrayList.toArray(cTSmartTagRunArr);
        }
        return cTSmartTagRunArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTSmartTagRun> getSmartTagList() {
        1SmartTagList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SmartTagList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTSmartTagPr getSmartTagPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTSmartTagPr cTSmartTagPr = (CTSmartTagPr) get_store().find_element_user(SMARTTAGPR$0, 0);
            if (cTSmartTagPr == null) {
                return null;
            }
            return cTSmartTagPr;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTRel getSubDocArray(int i) {
        CTRel cTRel;
        synchronized (monitor()) {
            check_orphaned();
            cTRel = (CTRel) get_store().find_element_user(SUBDOC$64, i);
            if (cTRel == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRel;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTRel[] getSubDocArray() {
        CTRel[] cTRelArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SUBDOC$64, arrayList);
            cTRelArr = new CTRel[arrayList.size()];
            arrayList.toArray(cTRelArr);
        }
        return cTRelArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public List<CTRel> getSubDocList() {
        1SubDocList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SubDocList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public String getUri() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(URI$66);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTMarkupRange insertNewBookmarkEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(BOOKMARKEND$18, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTBookmark insertNewBookmarkStart(int i) {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().insert_element_user(BOOKMARKSTART$16, i);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTMarkupRange insertNewCommentRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(COMMENTRANGEEND$30, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTMarkupRange insertNewCommentRangeStart(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(COMMENTRANGESTART$28, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTCustomXmlRun insertNewCustomXml(int i) {
        CTCustomXmlRun insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(CUSTOMXML$2, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTMarkup insertNewCustomXmlDelRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLDELRANGEEND$38, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTTrackChange insertNewCustomXmlDelRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLDELRANGESTART$36, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTMarkup insertNewCustomXmlInsRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLINSRANGEEND$34, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTTrackChange insertNewCustomXmlInsRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLINSRANGESTART$32, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTMarkup insertNewCustomXmlMoveFromRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGEEND$42, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTTrackChange insertNewCustomXmlMoveFromRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGESTART$40, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTMarkup insertNewCustomXmlMoveToRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLMOVETORANGEEND$46, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTTrackChange insertNewCustomXmlMoveToRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLMOVETORANGESTART$44, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTRunTrackChange insertNewDel(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(DEL$50, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTSimpleField insertNewFldSimple(int i) {
        CTSimpleField cTSimpleField;
        synchronized (monitor()) {
            check_orphaned();
            cTSimpleField = (CTSimpleField) get_store().insert_element_user(FLDSIMPLE$60, i);
        }
        return cTSimpleField;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTHyperlink insertNewHyperlink(int i) {
        CTHyperlink cTHyperlink;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlink = (CTHyperlink) get_store().insert_element_user(HYPERLINK$62, i);
        }
        return cTHyperlink;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTRunTrackChange insertNewIns(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(INS$48, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTRunTrackChange insertNewMoveFrom(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(MOVEFROM$52, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTMarkupRange insertNewMoveFromRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(MOVEFROMRANGEEND$22, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTMoveBookmark insertNewMoveFromRangeStart(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(MOVEFROMRANGESTART$20, i);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTRunTrackChange insertNewMoveTo(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(MOVETO$54, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTMarkupRange insertNewMoveToRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(MOVETORANGEEND$26, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTMoveBookmark insertNewMoveToRangeStart(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(MOVETORANGESTART$24, i);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTOMath insertNewOMath(int i) {
        CTOMath insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(OMATH$58, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTOMathPara insertNewOMathPara(int i) {
        CTOMathPara insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(OMATHPARA$56, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTPerm insertNewPermEnd(int i) {
        CTPerm insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(PERMEND$14, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTPermStart insertNewPermStart(int i) {
        CTPermStart insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(PERMSTART$12, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTProofErr insertNewProofErr(int i) {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().insert_element_user(PROOFERR$10, i);
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTR insertNewR(int i) {
        CTR ctr;
        synchronized (monitor()) {
            check_orphaned();
            ctr = (CTR) get_store().insert_element_user(R$8, i);
        }
        return ctr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTSdtRun insertNewSdt(int i) {
        CTSdtRun cTSdtRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtRun = (CTSdtRun) get_store().insert_element_user(SDT$6, i);
        }
        return cTSdtRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTSmartTagRun insertNewSmartTag(int i) {
        CTSmartTagRun cTSmartTagRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagRun = (CTSmartTagRun) get_store().insert_element_user(SMARTTAG$4, i);
        }
        return cTSmartTagRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public CTRel insertNewSubDoc(int i) {
        CTRel cTRel;
        synchronized (monitor()) {
            check_orphaned();
            cTRel = (CTRel) get_store().insert_element_user(SUBDOC$64, i);
        }
        return cTRel;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public boolean isSetSmartTagPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SMARTTAGPR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public boolean isSetUri() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(URI$66) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeBookmarkEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKEND$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeBookmarkStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKSTART$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeCommentRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGEEND$30, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeCommentRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGESTART$28, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeCustomXml(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXML$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeCustomXmlDelRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGEEND$38, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeCustomXmlDelRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGESTART$36, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeCustomXmlInsRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGEEND$34, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeCustomXmlInsRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGESTART$32, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeCustomXmlMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGEEND$42, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeCustomXmlMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGESTART$40, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeCustomXmlMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGEEND$46, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeCustomXmlMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGESTART$44, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeDel(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEL$50, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeFldSimple(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FLDSIMPLE$60, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeHyperlink(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HYPERLINK$62, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeIns(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INS$48, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeMoveFrom(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROM$52, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGEEND$22, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGESTART$20, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeMoveTo(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETO$54, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGEEND$26, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGESTART$24, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeOMath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATH$58, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeOMathPara(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATHPARA$56, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removePermEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMEND$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removePermStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMSTART$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeProofErr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROOFERR$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeR(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(R$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeSdt(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SDT$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeSmartTag(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SMARTTAG$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void removeSubDoc(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SUBDOC$64, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setBookmarkEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, BOOKMARKEND$18);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setBookmarkStartArray(CTBookmark[] cTBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBookmarkArr, BOOKMARKSTART$16);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setCommentRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGEEND$30);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setCommentRangeStartArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGESTART$28);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setCustomXmlArray(int i, CTCustomXmlRun cTCustomXmlRun) {
        synchronized (monitor()) {
            check_orphaned();
            CTCustomXmlRun find_element_user = get_store().find_element_user(CUSTOMXML$2, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTCustomXmlRun);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setCustomXmlArray(CTCustomXmlRun[] cTCustomXmlRunArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTCustomXmlRunArr, CUSTOMXML$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setCustomXmlDelRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLDELRANGEEND$38);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setCustomXmlDelRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLDELRANGESTART$36);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setCustomXmlInsRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLINSRANGEEND$34);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setCustomXmlInsRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLINSRANGESTART$32);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setCustomXmlMoveFromRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVEFROMRANGEEND$42);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setCustomXmlMoveFromRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVEFROMRANGESTART$40);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setCustomXmlMoveToRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVETORANGEEND$46);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setCustomXmlMoveToRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVETORANGESTART$44);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setDelArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, DEL$50);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setElement(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ELEMENT$68;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setFldSimpleArray(int i, CTSimpleField cTSimpleField) {
        synchronized (monitor()) {
            check_orphaned();
            CTSimpleField cTSimpleField2 = (CTSimpleField) get_store().find_element_user(FLDSIMPLE$60, i);
            if (cTSimpleField2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSimpleField2.set(cTSimpleField);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setFldSimpleArray(CTSimpleField[] cTSimpleFieldArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSimpleFieldArr, FLDSIMPLE$60);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setHyperlinkArray(int i, CTHyperlink cTHyperlink) {
        synchronized (monitor()) {
            check_orphaned();
            CTHyperlink cTHyperlink2 = (CTHyperlink) get_store().find_element_user(HYPERLINK$62, i);
            if (cTHyperlink2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTHyperlink2.set(cTHyperlink);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setHyperlinkArray(CTHyperlink[] cTHyperlinkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTHyperlinkArr, HYPERLINK$62);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setInsArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, INS$48);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setMoveFromArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVEFROM$52);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setMoveFromRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVEFROMRANGEEND$22);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setMoveFromRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVEFROMRANGESTART$20);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setMoveToArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVETO$54);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setMoveToRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVETORANGEEND$26);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setMoveToRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVETORANGESTART$24);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setOMathArray(CTOMath[] cTOMathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTOMathArr, OMATH$58);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setOMathParaArray(CTOMathPara[] cTOMathParaArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTOMathParaArr, OMATHPARA$56);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setPermEndArray(CTPerm[] cTPermArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPermArr, PERMEND$14);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setPermStartArray(CTPermStart[] cTPermStartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPermStartArr, PERMSTART$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setProofErrArray(CTProofErr[] cTProofErrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTProofErrArr, PROOFERR$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setRArray(int i, CTR ctr) {
        synchronized (monitor()) {
            check_orphaned();
            CTR ctr2 = (CTR) get_store().find_element_user(R$8, i);
            if (ctr2 == null) {
                throw new IndexOutOfBoundsException();
            }
            ctr2.set(ctr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setRArray(CTR[] ctrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(ctrArr, R$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setSdtArray(int i, CTSdtRun cTSdtRun) {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtRun cTSdtRun2 = (CTSdtRun) get_store().find_element_user(SDT$6, i);
            if (cTSdtRun2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSdtRun2.set(cTSdtRun);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setSdtArray(CTSdtRun[] cTSdtRunArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSdtRunArr, SDT$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setSmartTagArray(int i, CTSmartTagRun cTSmartTagRun) {
        synchronized (monitor()) {
            check_orphaned();
            CTSmartTagRun cTSmartTagRun2 = (CTSmartTagRun) get_store().find_element_user(SMARTTAG$4, i);
            if (cTSmartTagRun2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSmartTagRun2.set(cTSmartTagRun);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setSmartTagArray(CTSmartTagRun[] cTSmartTagRunArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSmartTagRunArr, SMARTTAG$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setSmartTagPr(CTSmartTagPr cTSmartTagPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SMARTTAGPR$0;
            CTSmartTagPr cTSmartTagPr2 = (CTSmartTagPr) typeStore.find_element_user(qName, 0);
            if (cTSmartTagPr2 == null) {
                cTSmartTagPr2 = (CTSmartTagPr) get_store().add_element_user(qName);
            }
            cTSmartTagPr2.set(cTSmartTagPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setSubDocArray(int i, CTRel cTRel) {
        synchronized (monitor()) {
            check_orphaned();
            CTRel cTRel2 = (CTRel) get_store().find_element_user(SUBDOC$64, i);
            if (cTRel2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRel2.set(cTRel);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setSubDocArray(CTRel[] cTRelArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRelArr, SUBDOC$64);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void setUri(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$66;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfBookmarkEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BOOKMARKEND$18);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfBookmarkStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BOOKMARKSTART$16);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfCommentRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(COMMENTRANGEEND$30);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfCommentRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(COMMENTRANGESTART$28);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfCustomXmlArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXML$2);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfCustomXmlDelRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLDELRANGEEND$38);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfCustomXmlDelRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLDELRANGESTART$36);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfCustomXmlInsRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLINSRANGEEND$34);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfCustomXmlInsRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLINSRANGESTART$32);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfCustomXmlMoveFromRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGEEND$42);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfCustomXmlMoveFromRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGESTART$40);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfCustomXmlMoveToRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLMOVETORANGEEND$46);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfCustomXmlMoveToRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLMOVETORANGESTART$44);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfDelArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DEL$50);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfFldSimpleArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(FLDSIMPLE$60);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfHyperlinkArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(HYPERLINK$62);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfInsArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(INS$48);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfMoveFromArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVEFROM$52);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfMoveFromRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVEFROMRANGEEND$22);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfMoveFromRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVEFROMRANGESTART$20);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfMoveToArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVETO$54);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfMoveToRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVETORANGEEND$26);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfMoveToRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVETORANGESTART$24);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfOMathArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(OMATH$58);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfOMathParaArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(OMATHPARA$56);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfPermEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PERMEND$14);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfPermStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PERMSTART$12);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfProofErrArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PROOFERR$10);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfRArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(R$8);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfSdtArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SDT$6);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfSmartTagArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SMARTTAG$4);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public int sizeOfSubDocArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SUBDOC$64);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void unsetSmartTagPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SMARTTAGPR$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void unsetUri() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(URI$66);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public STString xgetElement() {
        STString sTString;
        synchronized (monitor()) {
            check_orphaned();
            sTString = (STString) get_store().find_attribute_user(ELEMENT$68);
        }
        return sTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public STString xgetUri() {
        STString sTString;
        synchronized (monitor()) {
            check_orphaned();
            sTString = (STString) get_store().find_attribute_user(URI$66);
        }
        return sTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void xsetElement(STString sTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ELEMENT$68;
            STString sTString2 = (STString) typeStore.find_attribute_user(qName);
            if (sTString2 == null) {
                sTString2 = (STString) get_store().add_attribute_user(qName);
            }
            sTString2.set(sTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun
    public void xsetUri(STString sTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$66;
            STString sTString2 = (STString) typeStore.find_attribute_user(qName);
            if (sTString2 == null) {
                sTString2 = (STString) get_store().add_attribute_user(qName);
            }
            sTString2.set(sTString);
        }
    }
}
