package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMoveBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPerm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPermStart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

/* loaded from: classes6.dex */
public class CTSdtContentCellImpl extends XmlComplexContentImpl implements CTSdtContentCell {
    private static final QName TC$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tc");
    private static final QName CUSTOMXML$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXml");
    private static final QName SDT$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdt");
    private static final QName PROOFERR$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "proofErr");
    private static final QName PERMSTART$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permStart");
    private static final QName PERMEND$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permEnd");
    private static final QName BOOKMARKSTART$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkStart");
    private static final QName BOOKMARKEND$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkEnd");
    private static final QName MOVEFROMRANGESTART$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeStart");
    private static final QName MOVEFROMRANGEEND$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeEnd");
    private static final QName MOVETORANGESTART$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeStart");
    private static final QName MOVETORANGEEND$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeEnd");
    private static final QName COMMENTRANGESTART$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeStart");
    private static final QName COMMENTRANGEEND$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeEnd");
    private static final QName CUSTOMXMLINSRANGESTART$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeStart");
    private static final QName CUSTOMXMLINSRANGEEND$30 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeEnd");
    private static final QName CUSTOMXMLDELRANGESTART$32 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeStart");
    private static final QName CUSTOMXMLDELRANGEEND$34 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeEnd");
    private static final QName CUSTOMXMLMOVEFROMRANGESTART$36 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeStart");
    private static final QName CUSTOMXMLMOVEFROMRANGEEND$38 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeEnd");
    private static final QName CUSTOMXMLMOVETORANGESTART$40 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeStart");
    private static final QName CUSTOMXMLMOVETORANGEEND$42 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeEnd");
    private static final QName INS$44 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins");
    private static final QName DEL$46 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "del");
    private static final QName MOVEFROM$48 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFrom");
    private static final QName MOVETO$50 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveTo");
    private static final QName OMATHPARA$52 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMathPara");
    private static final QName OMATH$54 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMath");

    public CTSdtContentCellImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange addNewBookmarkEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(BOOKMARKEND$14);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTBookmark addNewBookmarkStart() {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().add_element_user(BOOKMARKSTART$12);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange addNewCommentRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(COMMENTRANGEEND$26);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange addNewCommentRangeStart() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(COMMENTRANGESTART$24);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTCustomXmlCell addNewCustomXml() {
        CTCustomXmlCell add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CUSTOMXML$2);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup addNewCustomXmlDelRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLDELRANGEEND$34);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange addNewCustomXmlDelRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLDELRANGESTART$32);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup addNewCustomXmlInsRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLINSRANGEEND$30);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange addNewCustomXmlInsRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLINSRANGESTART$28);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup addNewCustomXmlMoveFromRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLMOVEFROMRANGEEND$38);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange addNewCustomXmlMoveFromRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLMOVEFROMRANGESTART$36);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup addNewCustomXmlMoveToRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLMOVETORANGEEND$42);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange addNewCustomXmlMoveToRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLMOVETORANGESTART$40);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange addNewDel() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(DEL$46);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange addNewIns() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(INS$44);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange addNewMoveFrom() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(MOVEFROM$48);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange addNewMoveFromRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(MOVEFROMRANGEEND$18);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMoveBookmark addNewMoveFromRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(MOVEFROMRANGESTART$16);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange addNewMoveTo() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(MOVETO$50);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange addNewMoveToRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(MOVETORANGEEND$22);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMoveBookmark addNewMoveToRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(MOVETORANGESTART$20);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTOMath addNewOMath() {
        CTOMath add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(OMATH$54);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTOMathPara addNewOMathPara() {
        CTOMathPara add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(OMATHPARA$52);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTPerm addNewPermEnd() {
        CTPerm add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(PERMEND$10);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTPermStart addNewPermStart() {
        CTPermStart add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(PERMSTART$8);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTProofErr addNewProofErr() {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().add_element_user(PROOFERR$6);
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTSdtCell addNewSdt() {
        CTSdtCell cTSdtCell;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtCell = (CTSdtCell) get_store().add_element_user(SDT$4);
        }
        return cTSdtCell;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTc addNewTc() {
        CTTc cTTc;
        synchronized (monitor()) {
            check_orphaned();
            cTTc = (CTTc) get_store().add_element_user(TC$0);
        }
        return cTTc;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange getBookmarkEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(BOOKMARKEND$14, i);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange[] getBookmarkEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOOKMARKEND$14, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTMarkupRange> getBookmarkEndList() {
        1BookmarkEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BookmarkEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTBookmark getBookmarkStartArray(int i) {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().find_element_user(BOOKMARKSTART$12, i);
            if (cTBookmark == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTBookmark[] getBookmarkStartArray() {
        CTBookmark[] cTBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOOKMARKSTART$12, arrayList);
            cTBookmarkArr = new CTBookmark[arrayList.size()];
            arrayList.toArray(cTBookmarkArr);
        }
        return cTBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTBookmark> getBookmarkStartList() {
        1BookmarkStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BookmarkStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange getCommentRangeEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(COMMENTRANGEEND$26, i);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange[] getCommentRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMMENTRANGEEND$26, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTMarkupRange> getCommentRangeEndList() {
        1CommentRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CommentRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange getCommentRangeStartArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(COMMENTRANGESTART$24, i);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange[] getCommentRangeStartArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMMENTRANGESTART$24, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTMarkupRange> getCommentRangeStartList() {
        1CommentRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CommentRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTCustomXmlCell getCustomXmlArray(int i) {
        CTCustomXmlCell find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(CUSTOMXML$2, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTCustomXmlCell[] getCustomXmlArray() {
        CTCustomXmlCell[] cTCustomXmlCellArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXML$2, arrayList);
            cTCustomXmlCellArr = new CTCustomXmlCell[arrayList.size()];
            arrayList.toArray(cTCustomXmlCellArr);
        }
        return cTCustomXmlCellArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup getCustomXmlDelRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLDELRANGEEND$34, i);
            if (cTMarkup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup[] getCustomXmlDelRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLDELRANGEEND$34, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTMarkup> getCustomXmlDelRangeEndList() {
        1CustomXmlDelRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlDelRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange getCustomXmlDelRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLDELRANGESTART$32, i);
            if (cTTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange[] getCustomXmlDelRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLDELRANGESTART$32, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTTrackChange> getCustomXmlDelRangeStartList() {
        1CustomXmlDelRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlDelRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup getCustomXmlInsRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLINSRANGEEND$30, i);
            if (cTMarkup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup[] getCustomXmlInsRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLINSRANGEEND$30, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTMarkup> getCustomXmlInsRangeEndList() {
        1CustomXmlInsRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlInsRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange getCustomXmlInsRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLINSRANGESTART$28, i);
            if (cTTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange[] getCustomXmlInsRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLINSRANGESTART$28, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTTrackChange> getCustomXmlInsRangeStartList() {
        1CustomXmlInsRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlInsRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTCustomXmlCell> getCustomXmlList() {
        1CustomXmlList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup getCustomXmlMoveFromRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGEEND$38, i);
            if (cTMarkup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup[] getCustomXmlMoveFromRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVEFROMRANGEEND$38, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTMarkup> getCustomXmlMoveFromRangeEndList() {
        1CustomXmlMoveFromRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveFromRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange getCustomXmlMoveFromRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGESTART$36, i);
            if (cTTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange[] getCustomXmlMoveFromRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVEFROMRANGESTART$36, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTTrackChange> getCustomXmlMoveFromRangeStartList() {
        1CustomXmlMoveFromRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveFromRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup getCustomXmlMoveToRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVETORANGEEND$42, i);
            if (cTMarkup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup[] getCustomXmlMoveToRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVETORANGEEND$42, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTMarkup> getCustomXmlMoveToRangeEndList() {
        1CustomXmlMoveToRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveToRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange getCustomXmlMoveToRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVETORANGESTART$40, i);
            if (cTTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange[] getCustomXmlMoveToRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVETORANGESTART$40, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTTrackChange> getCustomXmlMoveToRangeStartList() {
        1CustomXmlMoveToRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveToRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange getDelArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(DEL$46, i);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange[] getDelArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DEL$46, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTRunTrackChange> getDelList() {
        1DelList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DelList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange getInsArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(INS$44, i);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange[] getInsArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(INS$44, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTRunTrackChange> getInsList() {
        1InsList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1InsList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange getMoveFromArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(MOVEFROM$48, i);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange[] getMoveFromArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROM$48, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTRunTrackChange> getMoveFromList() {
        1MoveFromList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange getMoveFromRangeEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(MOVEFROMRANGEEND$18, i);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange[] getMoveFromRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROMRANGEEND$18, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTMarkupRange> getMoveFromRangeEndList() {
        1MoveFromRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMoveBookmark getMoveFromRangeStartArray(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().find_element_user(MOVEFROMRANGESTART$16, i);
            if (cTMoveBookmark == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMoveBookmark[] getMoveFromRangeStartArray() {
        CTMoveBookmark[] cTMoveBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROMRANGESTART$16, arrayList);
            cTMoveBookmarkArr = new CTMoveBookmark[arrayList.size()];
            arrayList.toArray(cTMoveBookmarkArr);
        }
        return cTMoveBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTMoveBookmark> getMoveFromRangeStartList() {
        1MoveFromRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange getMoveToArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(MOVETO$50, i);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange[] getMoveToArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETO$50, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTRunTrackChange> getMoveToList() {
        1MoveToList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange getMoveToRangeEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(MOVETORANGEEND$22, i);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange[] getMoveToRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETORANGEEND$22, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTMarkupRange> getMoveToRangeEndList() {
        1MoveToRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMoveBookmark getMoveToRangeStartArray(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().find_element_user(MOVETORANGESTART$20, i);
            if (cTMoveBookmark == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMoveBookmark[] getMoveToRangeStartArray() {
        CTMoveBookmark[] cTMoveBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETORANGESTART$20, arrayList);
            cTMoveBookmarkArr = new CTMoveBookmark[arrayList.size()];
            arrayList.toArray(cTMoveBookmarkArr);
        }
        return cTMoveBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTMoveBookmark> getMoveToRangeStartList() {
        1MoveToRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTOMath getOMathArray(int i) {
        CTOMath find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(OMATH$54, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTOMath[] getOMathArray() {
        CTOMath[] cTOMathArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OMATH$54, arrayList);
            cTOMathArr = new CTOMath[arrayList.size()];
            arrayList.toArray(cTOMathArr);
        }
        return cTOMathArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTOMath> getOMathList() {
        1OMathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OMathList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTOMathPara getOMathParaArray(int i) {
        CTOMathPara find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(OMATHPARA$52, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTOMathPara[] getOMathParaArray() {
        CTOMathPara[] cTOMathParaArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OMATHPARA$52, arrayList);
            cTOMathParaArr = new CTOMathPara[arrayList.size()];
            arrayList.toArray(cTOMathParaArr);
        }
        return cTOMathParaArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTOMathPara> getOMathParaList() {
        1OMathParaList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OMathParaList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTPerm getPermEndArray(int i) {
        CTPerm find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(PERMEND$10, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTPerm[] getPermEndArray() {
        CTPerm[] cTPermArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PERMEND$10, arrayList);
            cTPermArr = new CTPerm[arrayList.size()];
            arrayList.toArray(cTPermArr);
        }
        return cTPermArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTPerm> getPermEndList() {
        1PermEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PermEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTPermStart getPermStartArray(int i) {
        CTPermStart find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(PERMSTART$8, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTPermStart[] getPermStartArray() {
        CTPermStart[] cTPermStartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PERMSTART$8, arrayList);
            cTPermStartArr = new CTPermStart[arrayList.size()];
            arrayList.toArray(cTPermStartArr);
        }
        return cTPermStartArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTPermStart> getPermStartList() {
        1PermStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PermStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTProofErr getProofErrArray(int i) {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().find_element_user(PROOFERR$6, i);
            if (cTProofErr == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTProofErr[] getProofErrArray() {
        CTProofErr[] cTProofErrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PROOFERR$6, arrayList);
            cTProofErrArr = new CTProofErr[arrayList.size()];
            arrayList.toArray(cTProofErrArr);
        }
        return cTProofErrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTProofErr> getProofErrList() {
        1ProofErrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ProofErrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTSdtCell getSdtArray(int i) {
        CTSdtCell cTSdtCell;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtCell = (CTSdtCell) get_store().find_element_user(SDT$4, i);
            if (cTSdtCell == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSdtCell;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTSdtCell[] getSdtArray() {
        CTSdtCell[] cTSdtCellArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SDT$4, arrayList);
            cTSdtCellArr = new CTSdtCell[arrayList.size()];
            arrayList.toArray(cTSdtCellArr);
        }
        return cTSdtCellArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTSdtCell> getSdtList() {
        1SdtList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SdtList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTc getTcArray(int i) {
        CTTc cTTc;
        synchronized (monitor()) {
            check_orphaned();
            cTTc = (CTTc) get_store().find_element_user(TC$0, i);
            if (cTTc == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTc;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTc[] getTcArray() {
        CTTc[] cTTcArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TC$0, arrayList);
            cTTcArr = new CTTc[arrayList.size()];
            arrayList.toArray(cTTcArr);
        }
        return cTTcArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTTc> getTcList() {
        1TcList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TcList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange insertNewBookmarkEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(BOOKMARKEND$14, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTBookmark insertNewBookmarkStart(int i) {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().insert_element_user(BOOKMARKSTART$12, i);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange insertNewCommentRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(COMMENTRANGEEND$26, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange insertNewCommentRangeStart(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(COMMENTRANGESTART$24, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTCustomXmlCell insertNewCustomXml(int i) {
        CTCustomXmlCell insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(CUSTOMXML$2, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup insertNewCustomXmlDelRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLDELRANGEEND$34, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange insertNewCustomXmlDelRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLDELRANGESTART$32, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup insertNewCustomXmlInsRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLINSRANGEEND$30, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange insertNewCustomXmlInsRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLINSRANGESTART$28, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup insertNewCustomXmlMoveFromRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGEEND$38, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange insertNewCustomXmlMoveFromRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGESTART$36, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup insertNewCustomXmlMoveToRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLMOVETORANGEEND$42, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange insertNewCustomXmlMoveToRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLMOVETORANGESTART$40, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange insertNewDel(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(DEL$46, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange insertNewIns(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(INS$44, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange insertNewMoveFrom(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(MOVEFROM$48, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange insertNewMoveFromRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(MOVEFROMRANGEEND$18, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMoveBookmark insertNewMoveFromRangeStart(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(MOVEFROMRANGESTART$16, i);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange insertNewMoveTo(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(MOVETO$50, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange insertNewMoveToRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(MOVETORANGEEND$22, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMoveBookmark insertNewMoveToRangeStart(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(MOVETORANGESTART$20, i);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTOMath insertNewOMath(int i) {
        CTOMath insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(OMATH$54, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTOMathPara insertNewOMathPara(int i) {
        CTOMathPara insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(OMATHPARA$52, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTPerm insertNewPermEnd(int i) {
        CTPerm insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(PERMEND$10, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTPermStart insertNewPermStart(int i) {
        CTPermStart insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(PERMSTART$8, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTProofErr insertNewProofErr(int i) {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().insert_element_user(PROOFERR$6, i);
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTSdtCell insertNewSdt(int i) {
        CTSdtCell cTSdtCell;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtCell = (CTSdtCell) get_store().insert_element_user(SDT$4, i);
        }
        return cTSdtCell;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTc insertNewTc(int i) {
        CTTc cTTc;
        synchronized (monitor()) {
            check_orphaned();
            cTTc = (CTTc) get_store().insert_element_user(TC$0, i);
        }
        return cTTc;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeBookmarkEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKEND$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeBookmarkStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKSTART$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeCommentRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGEEND$26, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeCommentRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGESTART$24, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeCustomXml(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXML$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeCustomXmlDelRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGEEND$34, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeCustomXmlDelRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGESTART$32, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeCustomXmlInsRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGEEND$30, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeCustomXmlInsRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGESTART$28, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeCustomXmlMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGEEND$38, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeCustomXmlMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGESTART$36, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeCustomXmlMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGEEND$42, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeCustomXmlMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGESTART$40, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeDel(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEL$46, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeIns(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INS$44, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeMoveFrom(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROM$48, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGEEND$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGESTART$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeMoveTo(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETO$50, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGEEND$22, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGESTART$20, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeOMath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATH$54, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeOMathPara(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATHPARA$52, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removePermEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMEND$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removePermStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMSTART$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeProofErr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROOFERR$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeSdt(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SDT$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeTc(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TC$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setBookmarkEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(BOOKMARKEND$14, i);
            if (cTMarkupRange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRange2.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setBookmarkEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, BOOKMARKEND$14);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setBookmarkStartArray(int i, CTBookmark cTBookmark) {
        synchronized (monitor()) {
            check_orphaned();
            CTBookmark cTBookmark2 = (CTBookmark) get_store().find_element_user(BOOKMARKSTART$12, i);
            if (cTBookmark2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBookmark2.set(cTBookmark);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setBookmarkStartArray(CTBookmark[] cTBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBookmarkArr, BOOKMARKSTART$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCommentRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(COMMENTRANGEEND$26, i);
            if (cTMarkupRange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRange2.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCommentRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGEEND$26);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCommentRangeStartArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(COMMENTRANGESTART$24, i);
            if (cTMarkupRange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRange2.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCommentRangeStartArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGESTART$24);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlArray(int i, CTCustomXmlCell cTCustomXmlCell) {
        synchronized (monitor()) {
            check_orphaned();
            CTCustomXmlCell find_element_user = get_store().find_element_user(CUSTOMXML$2, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTCustomXmlCell);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlArray(CTCustomXmlCell[] cTCustomXmlCellArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTCustomXmlCellArr, CUSTOMXML$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlDelRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLDELRANGEEND$34, i);
            if (cTMarkup2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkup2.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlDelRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLDELRANGEEND$34);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlDelRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLDELRANGESTART$32, i);
            if (cTTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChange2.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlDelRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLDELRANGESTART$32);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlInsRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLINSRANGEEND$30, i);
            if (cTMarkup2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkup2.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlInsRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLINSRANGEEND$30);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlInsRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLINSRANGESTART$28, i);
            if (cTTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChange2.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlInsRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLINSRANGESTART$28);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlMoveFromRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGEEND$38, i);
            if (cTMarkup2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkup2.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlMoveFromRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVEFROMRANGEEND$38);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlMoveFromRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGESTART$36, i);
            if (cTTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChange2.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlMoveFromRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVEFROMRANGESTART$36);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlMoveToRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVETORANGEEND$42, i);
            if (cTMarkup2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkup2.set(cTMarkup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlMoveToRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVETORANGEEND$42);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlMoveToRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVETORANGESTART$40, i);
            if (cTTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTrackChange2.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlMoveToRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVETORANGESTART$40);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setDelArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(DEL$46, i);
            if (cTRunTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChange2.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setDelArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, DEL$46);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setInsArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(INS$44, i);
            if (cTRunTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChange2.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setInsArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, INS$44);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveFromArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(MOVEFROM$48, i);
            if (cTRunTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChange2.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveFromArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVEFROM$48);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveFromRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(MOVEFROMRANGEEND$18, i);
            if (cTMarkupRange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRange2.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveFromRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVEFROMRANGEEND$18);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveFromRangeStartArray(int i, CTMoveBookmark cTMoveBookmark) {
        synchronized (monitor()) {
            check_orphaned();
            CTMoveBookmark cTMoveBookmark2 = (CTMoveBookmark) get_store().find_element_user(MOVEFROMRANGESTART$16, i);
            if (cTMoveBookmark2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMoveBookmark2.set(cTMoveBookmark);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveFromRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVEFROMRANGESTART$16);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveToArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(MOVETO$50, i);
            if (cTRunTrackChange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRunTrackChange2.set(cTRunTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveToArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVETO$50);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveToRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(MOVETORANGEEND$22, i);
            if (cTMarkupRange2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMarkupRange2.set(cTMarkupRange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveToRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVETORANGEEND$22);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveToRangeStartArray(int i, CTMoveBookmark cTMoveBookmark) {
        synchronized (monitor()) {
            check_orphaned();
            CTMoveBookmark cTMoveBookmark2 = (CTMoveBookmark) get_store().find_element_user(MOVETORANGESTART$20, i);
            if (cTMoveBookmark2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMoveBookmark2.set(cTMoveBookmark);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveToRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVETORANGESTART$20);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setOMathArray(int i, CTOMath cTOMath) {
        synchronized (monitor()) {
            check_orphaned();
            CTOMath find_element_user = get_store().find_element_user(OMATH$54, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTOMath);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setOMathArray(CTOMath[] cTOMathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTOMathArr, OMATH$54);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setOMathParaArray(int i, CTOMathPara cTOMathPara) {
        synchronized (monitor()) {
            check_orphaned();
            CTOMathPara find_element_user = get_store().find_element_user(OMATHPARA$52, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTOMathPara);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setOMathParaArray(CTOMathPara[] cTOMathParaArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTOMathParaArr, OMATHPARA$52);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setPermEndArray(int i, CTPerm cTPerm) {
        synchronized (monitor()) {
            check_orphaned();
            CTPerm find_element_user = get_store().find_element_user(PERMEND$10, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTPerm);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setPermEndArray(CTPerm[] cTPermArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPermArr, PERMEND$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setPermStartArray(int i, CTPermStart cTPermStart) {
        synchronized (monitor()) {
            check_orphaned();
            CTPermStart find_element_user = get_store().find_element_user(PERMSTART$8, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTPermStart);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setPermStartArray(CTPermStart[] cTPermStartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPermStartArr, PERMSTART$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setProofErrArray(int i, CTProofErr cTProofErr) {
        synchronized (monitor()) {
            check_orphaned();
            CTProofErr cTProofErr2 = (CTProofErr) get_store().find_element_user(PROOFERR$6, i);
            if (cTProofErr2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTProofErr2.set(cTProofErr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setProofErrArray(CTProofErr[] cTProofErrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTProofErrArr, PROOFERR$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setSdtArray(int i, CTSdtCell cTSdtCell) {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtCell cTSdtCell2 = (CTSdtCell) get_store().find_element_user(SDT$4, i);
            if (cTSdtCell2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSdtCell2.set(cTSdtCell);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setSdtArray(CTSdtCell[] cTSdtCellArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSdtCellArr, SDT$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setTcArray(int i, CTTc cTTc) {
        synchronized (monitor()) {
            check_orphaned();
            CTTc cTTc2 = (CTTc) get_store().find_element_user(TC$0, i);
            if (cTTc2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTc2.set(cTTc);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setTcArray(CTTc[] cTTcArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTcArr, TC$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfBookmarkEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BOOKMARKEND$14);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfBookmarkStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BOOKMARKSTART$12);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfCommentRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(COMMENTRANGEEND$26);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfCommentRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(COMMENTRANGESTART$24);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfCustomXmlArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXML$2);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfCustomXmlDelRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLDELRANGEEND$34);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfCustomXmlDelRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLDELRANGESTART$32);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfCustomXmlInsRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLINSRANGEEND$30);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfCustomXmlInsRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLINSRANGESTART$28);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfCustomXmlMoveFromRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGEEND$38);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfCustomXmlMoveFromRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGESTART$36);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfCustomXmlMoveToRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLMOVETORANGEEND$42);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfCustomXmlMoveToRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLMOVETORANGESTART$40);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfDelArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DEL$46);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfInsArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(INS$44);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfMoveFromArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVEFROM$48);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfMoveFromRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVEFROMRANGEEND$18);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfMoveFromRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVEFROMRANGESTART$16);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfMoveToArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVETO$50);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfMoveToRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVETORANGEEND$22);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfMoveToRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVETORANGESTART$20);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfOMathArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(OMATH$54);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfOMathParaArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(OMATHPARA$52);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfPermEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PERMEND$10);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfPermStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PERMSTART$8);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfProofErrArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PROOFERR$6);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfSdtArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SDT$4);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfTcArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TC$0);
        }
        return count_elements;
    }
}
