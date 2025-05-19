package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTAcc;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTBar;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTBorderBox;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTBox;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTD;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTEqArr;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTF;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTFunc;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTGroupChr;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTLimLow;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTLimUpp;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTM;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTNary;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTPhant;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTRad;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTSPre;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTSSub;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTSSubSup;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTSSup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMoveBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPerm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPermStart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

/* loaded from: classes6.dex */
public class CTRunTrackChangeImpl extends CTTrackChangeImpl implements CTRunTrackChange {
    private static final QName CUSTOMXML$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXml");
    private static final QName SMARTTAG$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "smartTag");
    private static final QName SDT$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdt");
    private static final QName R$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", InternalZipConstants.READ_MODE);
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
    private static final QName ACC$58 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "acc");
    private static final QName BAR$60 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "bar");
    private static final QName BOX$62 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "box");
    private static final QName BORDERBOX$64 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "borderBox");
    private static final QName D$66 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "d");
    private static final QName EQARR$68 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "eqArr");
    private static final QName F$70 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "f");
    private static final QName FUNC$72 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "func");
    private static final QName GROUPCHR$74 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "groupChr");
    private static final QName LIMLOW$76 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "limLow");
    private static final QName LIMUPP$78 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "limUpp");
    private static final QName M$80 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "m");
    private static final QName NARY$82 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "nary");
    private static final QName PHANT$84 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "phant");
    private static final QName RAD$86 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "rad");
    private static final QName SPRE$88 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "sPre");
    private static final QName SSUB$90 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "sSub");
    private static final QName SSUBSUP$92 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "sSubSup");
    private static final QName SSUP$94 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "sSup");
    private static final QName R2$96 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", InternalZipConstants.READ_MODE);

    public CTRunTrackChangeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTAcc addNewAcc() {
        CTAcc add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(ACC$58);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBar addNewBar() {
        CTBar add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(BAR$60);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange addNewBookmarkEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(BOOKMARKEND$16);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBookmark addNewBookmarkStart() {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().add_element_user(BOOKMARKSTART$14);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBorderBox addNewBorderBox() {
        CTBorderBox add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(BORDERBOX$64);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBox addNewBox() {
        CTBox add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(BOX$62);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange addNewCommentRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(COMMENTRANGEEND$28);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange addNewCommentRangeStart() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(COMMENTRANGESTART$26);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTCustomXmlRun addNewCustomXml() {
        CTCustomXmlRun add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CUSTOMXML$0);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup addNewCustomXmlDelRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLDELRANGEEND$36);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange addNewCustomXmlDelRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLDELRANGESTART$34);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup addNewCustomXmlInsRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLINSRANGEEND$32);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange addNewCustomXmlInsRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLINSRANGESTART$30);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup addNewCustomXmlMoveFromRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLMOVEFROMRANGEEND$40);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange addNewCustomXmlMoveFromRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLMOVEFROMRANGESTART$38);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup addNewCustomXmlMoveToRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLMOVETORANGEEND$44);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange addNewCustomXmlMoveToRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLMOVETORANGESTART$42);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTD addNewD() {
        CTD add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(D$66);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange addNewDel() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(DEL$48);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTEqArr addNewEqArr() {
        CTEqArr add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EQARR$68);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTF addNewF() {
        CTF add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(F$70);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTFunc addNewFunc() {
        CTFunc add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(FUNC$72);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTGroupChr addNewGroupChr() {
        CTGroupChr add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(GROUPCHR$74);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange addNewIns() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(INS$46);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTLimLow addNewLimLow() {
        CTLimLow add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(LIMLOW$76);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTLimUpp addNewLimUpp() {
        CTLimUpp add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(LIMUPP$78);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTM addNewM() {
        CTM add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(M$80);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange addNewMoveFrom() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(MOVEFROM$50);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange addNewMoveFromRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(MOVEFROMRANGEEND$20);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMoveBookmark addNewMoveFromRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(MOVEFROMRANGESTART$18);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange addNewMoveTo() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(MOVETO$52);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange addNewMoveToRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(MOVETORANGEEND$24);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMoveBookmark addNewMoveToRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(MOVETORANGESTART$22);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTNary addNewNary() {
        CTNary add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(NARY$82);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTOMath addNewOMath() {
        CTOMath add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(OMATH$56);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTOMathPara addNewOMathPara() {
        CTOMathPara add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(OMATHPARA$54);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTPerm addNewPermEnd() {
        CTPerm add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(PERMEND$12);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTPermStart addNewPermStart() {
        CTPermStart add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(PERMSTART$10);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTPhant addNewPhant() {
        CTPhant add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(PHANT$84);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTProofErr addNewProofErr() {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().add_element_user(PROOFERR$8);
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTR addNewR() {
        CTR ctr;
        synchronized (monitor()) {
            check_orphaned();
            ctr = (CTR) get_store().add_element_user(R$6);
        }
        return ctr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public org.openxmlformats.schemas.officeDocument.x2006.math.CTR addNewR2() {
        org.openxmlformats.schemas.officeDocument.x2006.math.CTR add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(R2$96);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRad addNewRad() {
        CTRad add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(RAD$86);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSPre addNewSPre() {
        CTSPre add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(SPRE$88);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSub addNewSSub() {
        CTSSub add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(SSUB$90);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSubSup addNewSSubSup() {
        CTSSubSup add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(SSUBSUP$92);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSup addNewSSup() {
        CTSSup add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(SSUP$94);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSdtRun addNewSdt() {
        CTSdtRun cTSdtRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtRun = (CTSdtRun) get_store().add_element_user(SDT$4);
        }
        return cTSdtRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSmartTagRun addNewSmartTag() {
        CTSmartTagRun cTSmartTagRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagRun = (CTSmartTagRun) get_store().add_element_user(SMARTTAG$2);
        }
        return cTSmartTagRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTAcc getAccArray(int i) {
        CTAcc find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(ACC$58, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTAcc[] getAccArray() {
        CTAcc[] cTAccArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ACC$58, arrayList);
            cTAccArr = new CTAcc[arrayList.size()];
            arrayList.toArray(cTAccArr);
        }
        return cTAccArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTAcc> getAccList() {
        1AccList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AccList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBar getBarArray(int i) {
        CTBar find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(BAR$60, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBar[] getBarArray() {
        CTBar[] cTBarArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BAR$60, arrayList);
            cTBarArr = new CTBar[arrayList.size()];
            arrayList.toArray(cTBarArr);
        }
        return cTBarArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTBar> getBarList() {
        1BarList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BarList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTMarkupRange> getBookmarkEndList() {
        1BookmarkEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BookmarkEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTBookmark> getBookmarkStartList() {
        1BookmarkStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BookmarkStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBorderBox getBorderBoxArray(int i) {
        CTBorderBox find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(BORDERBOX$64, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBorderBox[] getBorderBoxArray() {
        CTBorderBox[] cTBorderBoxArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BORDERBOX$64, arrayList);
            cTBorderBoxArr = new CTBorderBox[arrayList.size()];
            arrayList.toArray(cTBorderBoxArr);
        }
        return cTBorderBoxArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTBorderBox> getBorderBoxList() {
        1BorderBoxList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BorderBoxList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBox getBoxArray(int i) {
        CTBox find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(BOX$62, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBox[] getBoxArray() {
        CTBox[] cTBoxArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOX$62, arrayList);
            cTBoxArr = new CTBox[arrayList.size()];
            arrayList.toArray(cTBoxArr);
        }
        return cTBoxArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTBox> getBoxList() {
        1BoxList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BoxList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTMarkupRange> getCommentRangeEndList() {
        1CommentRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CommentRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTMarkupRange> getCommentRangeStartList() {
        1CommentRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CommentRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTCustomXmlRun getCustomXmlArray(int i) {
        CTCustomXmlRun find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(CUSTOMXML$0, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTCustomXmlRun[] getCustomXmlArray() {
        CTCustomXmlRun[] cTCustomXmlRunArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXML$0, arrayList);
            cTCustomXmlRunArr = new CTCustomXmlRun[arrayList.size()];
            arrayList.toArray(cTCustomXmlRunArr);
        }
        return cTCustomXmlRunArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTMarkup> getCustomXmlDelRangeEndList() {
        1CustomXmlDelRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlDelRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTTrackChange> getCustomXmlDelRangeStartList() {
        1CustomXmlDelRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlDelRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTMarkup> getCustomXmlInsRangeEndList() {
        1CustomXmlInsRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlInsRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTTrackChange> getCustomXmlInsRangeStartList() {
        1CustomXmlInsRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlInsRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTCustomXmlRun> getCustomXmlList() {
        1CustomXmlList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTMarkup> getCustomXmlMoveFromRangeEndList() {
        1CustomXmlMoveFromRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveFromRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTTrackChange> getCustomXmlMoveFromRangeStartList() {
        1CustomXmlMoveFromRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveFromRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTMarkup> getCustomXmlMoveToRangeEndList() {
        1CustomXmlMoveToRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveToRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTTrackChange> getCustomXmlMoveToRangeStartList() {
        1CustomXmlMoveToRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustomXmlMoveToRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTD getDArray(int i) {
        CTD find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(D$66, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTD[] getDArray() {
        CTD[] ctdArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(D$66, arrayList);
            ctdArr = new CTD[arrayList.size()];
            arrayList.toArray(ctdArr);
        }
        return ctdArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTD> getDList() {
        1DList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTRunTrackChange> getDelList() {
        1DelList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DelList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTEqArr getEqArrArray(int i) {
        CTEqArr find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(EQARR$68, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTEqArr[] getEqArrArray() {
        CTEqArr[] cTEqArrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(EQARR$68, arrayList);
            cTEqArrArr = new CTEqArr[arrayList.size()];
            arrayList.toArray(cTEqArrArr);
        }
        return cTEqArrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTEqArr> getEqArrList() {
        1EqArrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1EqArrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTF getFArray(int i) {
        CTF find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(F$70, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTF[] getFArray() {
        CTF[] ctfArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(F$70, arrayList);
            ctfArr = new CTF[arrayList.size()];
            arrayList.toArray(ctfArr);
        }
        return ctfArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTF> getFList() {
        1FList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTFunc getFuncArray(int i) {
        CTFunc find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(FUNC$72, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTFunc[] getFuncArray() {
        CTFunc[] cTFuncArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FUNC$72, arrayList);
            cTFuncArr = new CTFunc[arrayList.size()];
            arrayList.toArray(cTFuncArr);
        }
        return cTFuncArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTFunc> getFuncList() {
        1FuncList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FuncList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTGroupChr getGroupChrArray(int i) {
        CTGroupChr find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(GROUPCHR$74, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTGroupChr[] getGroupChrArray() {
        CTGroupChr[] cTGroupChrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GROUPCHR$74, arrayList);
            cTGroupChrArr = new CTGroupChr[arrayList.size()];
            arrayList.toArray(cTGroupChrArr);
        }
        return cTGroupChrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTGroupChr> getGroupChrList() {
        1GroupChrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1GroupChrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTRunTrackChange> getInsList() {
        1InsList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1InsList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTLimLow getLimLowArray(int i) {
        CTLimLow find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(LIMLOW$76, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTLimLow[] getLimLowArray() {
        CTLimLow[] cTLimLowArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LIMLOW$76, arrayList);
            cTLimLowArr = new CTLimLow[arrayList.size()];
            arrayList.toArray(cTLimLowArr);
        }
        return cTLimLowArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTLimLow> getLimLowList() {
        1LimLowList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LimLowList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTLimUpp getLimUppArray(int i) {
        CTLimUpp find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(LIMUPP$78, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTLimUpp[] getLimUppArray() {
        CTLimUpp[] cTLimUppArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LIMUPP$78, arrayList);
            cTLimUppArr = new CTLimUpp[arrayList.size()];
            arrayList.toArray(cTLimUppArr);
        }
        return cTLimUppArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTLimUpp> getLimUppList() {
        1LimUppList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LimUppList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTM getMArray(int i) {
        CTM find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(M$80, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTM[] getMArray() {
        CTM[] ctmArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(M$80, arrayList);
            ctmArr = new CTM[arrayList.size()];
            arrayList.toArray(ctmArr);
        }
        return ctmArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTM> getMList() {
        1MList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTRunTrackChange> getMoveFromList() {
        1MoveFromList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTMarkupRange> getMoveFromRangeEndList() {
        1MoveFromRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTMoveBookmark> getMoveFromRangeStartList() {
        1MoveFromRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveFromRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTRunTrackChange> getMoveToList() {
        1MoveToList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTMarkupRange> getMoveToRangeEndList() {
        1MoveToRangeEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToRangeEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTMoveBookmark> getMoveToRangeStartList() {
        1MoveToRangeStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToRangeStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTNary getNaryArray(int i) {
        CTNary find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(NARY$82, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTNary[] getNaryArray() {
        CTNary[] cTNaryArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(NARY$82, arrayList);
            cTNaryArr = new CTNary[arrayList.size()];
            arrayList.toArray(cTNaryArr);
        }
        return cTNaryArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTNary> getNaryList() {
        1NaryList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1NaryList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTOMath> getOMathList() {
        1OMathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OMathList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTOMathPara> getOMathParaList() {
        1OMathParaList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OMathParaList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTPerm> getPermEndList() {
        1PermEndList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PermEndList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTPermStart> getPermStartList() {
        1PermStartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PermStartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTPhant getPhantArray(int i) {
        CTPhant find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(PHANT$84, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTPhant[] getPhantArray() {
        CTPhant[] cTPhantArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PHANT$84, arrayList);
            cTPhantArr = new CTPhant[arrayList.size()];
            arrayList.toArray(cTPhantArr);
        }
        return cTPhantArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTPhant> getPhantList() {
        1PhantList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PhantList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTProofErr> getProofErrList() {
        1ProofErrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ProofErrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public org.openxmlformats.schemas.officeDocument.x2006.math.CTR getR2Array(int i) {
        org.openxmlformats.schemas.officeDocument.x2006.math.CTR find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(R2$96, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public org.openxmlformats.schemas.officeDocument.x2006.math.CTR[] getR2Array() {
        org.openxmlformats.schemas.officeDocument.x2006.math.CTR[] ctrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(R2$96, arrayList);
            ctrArr = new org.openxmlformats.schemas.officeDocument.x2006.math.CTR[arrayList.size()];
            arrayList.toArray(ctrArr);
        }
        return ctrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<org.openxmlformats.schemas.officeDocument.x2006.math.CTR> getR2List() {
        1R2List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1R2List(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTR getRArray(int i) {
        CTR ctr;
        synchronized (monitor()) {
            check_orphaned();
            ctr = (CTR) get_store().find_element_user(R$6, i);
            if (ctr == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return ctr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTR[] getRArray() {
        CTR[] ctrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(R$6, arrayList);
            ctrArr = new CTR[arrayList.size()];
            arrayList.toArray(ctrArr);
        }
        return ctrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTR> getRList() {
        1RList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRad getRadArray(int i) {
        CTRad find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(RAD$86, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRad[] getRadArray() {
        CTRad[] cTRadArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(RAD$86, arrayList);
            cTRadArr = new CTRad[arrayList.size()];
            arrayList.toArray(cTRadArr);
        }
        return cTRadArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTRad> getRadList() {
        1RadList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RadList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSPre getSPreArray(int i) {
        CTSPre find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(SPRE$88, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSPre[] getSPreArray() {
        CTSPre[] cTSPreArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SPRE$88, arrayList);
            cTSPreArr = new CTSPre[arrayList.size()];
            arrayList.toArray(cTSPreArr);
        }
        return cTSPreArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTSPre> getSPreList() {
        1SPreList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SPreList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSub getSSubArray(int i) {
        CTSSub find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(SSUB$90, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSub[] getSSubArray() {
        CTSSub[] cTSSubArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SSUB$90, arrayList);
            cTSSubArr = new CTSSub[arrayList.size()];
            arrayList.toArray(cTSSubArr);
        }
        return cTSSubArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTSSub> getSSubList() {
        1SSubList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SSubList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSubSup getSSubSupArray(int i) {
        CTSSubSup find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(SSUBSUP$92, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSubSup[] getSSubSupArray() {
        CTSSubSup[] cTSSubSupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SSUBSUP$92, arrayList);
            cTSSubSupArr = new CTSSubSup[arrayList.size()];
            arrayList.toArray(cTSSubSupArr);
        }
        return cTSSubSupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTSSubSup> getSSubSupList() {
        1SSubSupList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SSubSupList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSup getSSupArray(int i) {
        CTSSup find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(SSUP$94, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSup[] getSSupArray() {
        CTSSup[] cTSSupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SSUP$94, arrayList);
            cTSSupArr = new CTSSup[arrayList.size()];
            arrayList.toArray(cTSSupArr);
        }
        return cTSSupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTSSup> getSSupList() {
        1SSupList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SSupList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSdtRun getSdtArray(int i) {
        CTSdtRun cTSdtRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtRun = (CTSdtRun) get_store().find_element_user(SDT$4, i);
            if (cTSdtRun == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSdtRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSdtRun[] getSdtArray() {
        CTSdtRun[] cTSdtRunArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SDT$4, arrayList);
            cTSdtRunArr = new CTSdtRun[arrayList.size()];
            arrayList.toArray(cTSdtRunArr);
        }
        return cTSdtRunArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTSdtRun> getSdtList() {
        1SdtList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SdtList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSmartTagRun getSmartTagArray(int i) {
        CTSmartTagRun cTSmartTagRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagRun = (CTSmartTagRun) get_store().find_element_user(SMARTTAG$2, i);
            if (cTSmartTagRun == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSmartTagRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSmartTagRun[] getSmartTagArray() {
        CTSmartTagRun[] cTSmartTagRunArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SMARTTAG$2, arrayList);
            cTSmartTagRunArr = new CTSmartTagRun[arrayList.size()];
            arrayList.toArray(cTSmartTagRunArr);
        }
        return cTSmartTagRunArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTSmartTagRun> getSmartTagList() {
        1SmartTagList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SmartTagList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTAcc insertNewAcc(int i) {
        CTAcc insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(ACC$58, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBar insertNewBar(int i) {
        CTBar insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(BAR$60, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange insertNewBookmarkEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(BOOKMARKEND$16, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBookmark insertNewBookmarkStart(int i) {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().insert_element_user(BOOKMARKSTART$14, i);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBorderBox insertNewBorderBox(int i) {
        CTBorderBox insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(BORDERBOX$64, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBox insertNewBox(int i) {
        CTBox insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(BOX$62, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange insertNewCommentRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(COMMENTRANGEEND$28, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange insertNewCommentRangeStart(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(COMMENTRANGESTART$26, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTCustomXmlRun insertNewCustomXml(int i) {
        CTCustomXmlRun insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(CUSTOMXML$0, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup insertNewCustomXmlDelRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLDELRANGEEND$36, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange insertNewCustomXmlDelRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLDELRANGESTART$34, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup insertNewCustomXmlInsRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLINSRANGEEND$32, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange insertNewCustomXmlInsRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLINSRANGESTART$30, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup insertNewCustomXmlMoveFromRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGEEND$40, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange insertNewCustomXmlMoveFromRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGESTART$38, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup insertNewCustomXmlMoveToRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLMOVETORANGEEND$44, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange insertNewCustomXmlMoveToRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLMOVETORANGESTART$42, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTD insertNewD(int i) {
        CTD insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(D$66, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange insertNewDel(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(DEL$48, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTEqArr insertNewEqArr(int i) {
        CTEqArr insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(EQARR$68, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTF insertNewF(int i) {
        CTF insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(F$70, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTFunc insertNewFunc(int i) {
        CTFunc insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(FUNC$72, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTGroupChr insertNewGroupChr(int i) {
        CTGroupChr insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(GROUPCHR$74, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange insertNewIns(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(INS$46, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTLimLow insertNewLimLow(int i) {
        CTLimLow insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(LIMLOW$76, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTLimUpp insertNewLimUpp(int i) {
        CTLimUpp insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(LIMUPP$78, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTM insertNewM(int i) {
        CTM insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(M$80, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange insertNewMoveFrom(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(MOVEFROM$50, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange insertNewMoveFromRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(MOVEFROMRANGEEND$20, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMoveBookmark insertNewMoveFromRangeStart(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(MOVEFROMRANGESTART$18, i);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange insertNewMoveTo(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(MOVETO$52, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange insertNewMoveToRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(MOVETORANGEEND$24, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMoveBookmark insertNewMoveToRangeStart(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(MOVETORANGESTART$22, i);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTNary insertNewNary(int i) {
        CTNary insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(NARY$82, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTOMath insertNewOMath(int i) {
        CTOMath insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(OMATH$56, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTOMathPara insertNewOMathPara(int i) {
        CTOMathPara insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(OMATHPARA$54, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTPerm insertNewPermEnd(int i) {
        CTPerm insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(PERMEND$12, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTPermStart insertNewPermStart(int i) {
        CTPermStart insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(PERMSTART$10, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTPhant insertNewPhant(int i) {
        CTPhant insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(PHANT$84, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTProofErr insertNewProofErr(int i) {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().insert_element_user(PROOFERR$8, i);
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTR insertNewR(int i) {
        CTR ctr;
        synchronized (monitor()) {
            check_orphaned();
            ctr = (CTR) get_store().insert_element_user(R$6, i);
        }
        return ctr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public org.openxmlformats.schemas.officeDocument.x2006.math.CTR insertNewR2(int i) {
        org.openxmlformats.schemas.officeDocument.x2006.math.CTR insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(R2$96, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRad insertNewRad(int i) {
        CTRad insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(RAD$86, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSPre insertNewSPre(int i) {
        CTSPre insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(SPRE$88, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSub insertNewSSub(int i) {
        CTSSub insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(SSUB$90, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSubSup insertNewSSubSup(int i) {
        CTSSubSup insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(SSUBSUP$92, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSup insertNewSSup(int i) {
        CTSSup insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(SSUP$94, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSdtRun insertNewSdt(int i) {
        CTSdtRun cTSdtRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtRun = (CTSdtRun) get_store().insert_element_user(SDT$4, i);
        }
        return cTSdtRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSmartTagRun insertNewSmartTag(int i) {
        CTSmartTagRun cTSmartTagRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagRun = (CTSmartTagRun) get_store().insert_element_user(SMARTTAG$2, i);
        }
        return cTSmartTagRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeAcc(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ACC$58, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeBar(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BAR$60, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeBookmarkEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKEND$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeBookmarkStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKSTART$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeBorderBox(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERBOX$64, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeBox(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOX$62, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeCommentRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGEEND$28, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeCommentRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGESTART$26, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeCustomXml(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXML$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeCustomXmlDelRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGEEND$36, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeCustomXmlDelRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGESTART$34, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeCustomXmlInsRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGEEND$32, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeCustomXmlInsRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGESTART$30, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeCustomXmlMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGEEND$40, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeCustomXmlMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGESTART$38, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeCustomXmlMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGEEND$44, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeCustomXmlMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGESTART$42, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeD(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(D$66, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeDel(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEL$48, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeEqArr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EQARR$68, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeF(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(F$70, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeFunc(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FUNC$72, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeGroupChr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GROUPCHR$74, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeIns(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INS$46, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeLimLow(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LIMLOW$76, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeLimUpp(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LIMUPP$78, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeM(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(M$80, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeMoveFrom(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROM$50, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGEEND$20, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGESTART$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeMoveTo(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETO$52, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGEEND$24, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGESTART$22, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeNary(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NARY$82, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeOMath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATH$56, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeOMathPara(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATHPARA$54, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removePermEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMEND$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removePermStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMSTART$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removePhant(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PHANT$84, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeProofErr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROOFERR$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeR(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(R$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeR2(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(R2$96, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeRad(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RAD$86, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeSPre(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPRE$88, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeSSub(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SSUB$90, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeSSubSup(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SSUBSUP$92, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeSSup(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SSUP$94, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeSdt(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SDT$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeSmartTag(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SMARTTAG$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setAccArray(int i, CTAcc cTAcc) {
        synchronized (monitor()) {
            check_orphaned();
            CTAcc find_element_user = get_store().find_element_user(ACC$58, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTAcc);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setAccArray(CTAcc[] cTAccArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTAccArr, ACC$58);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setBarArray(int i, CTBar cTBar) {
        synchronized (monitor()) {
            check_orphaned();
            CTBar find_element_user = get_store().find_element_user(BAR$60, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTBar);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setBarArray(CTBar[] cTBarArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBarArr, BAR$60);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setBookmarkEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, BOOKMARKEND$16);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setBookmarkStartArray(CTBookmark[] cTBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBookmarkArr, BOOKMARKSTART$14);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setBorderBoxArray(int i, CTBorderBox cTBorderBox) {
        synchronized (monitor()) {
            check_orphaned();
            CTBorderBox find_element_user = get_store().find_element_user(BORDERBOX$64, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTBorderBox);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setBorderBoxArray(CTBorderBox[] cTBorderBoxArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBorderBoxArr, BORDERBOX$64);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setBoxArray(int i, CTBox cTBox) {
        synchronized (monitor()) {
            check_orphaned();
            CTBox find_element_user = get_store().find_element_user(BOX$62, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTBox);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setBoxArray(CTBox[] cTBoxArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBoxArr, BOX$62);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCommentRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGEEND$28);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCommentRangeStartArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGESTART$26);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlArray(int i, CTCustomXmlRun cTCustomXmlRun) {
        synchronized (monitor()) {
            check_orphaned();
            CTCustomXmlRun find_element_user = get_store().find_element_user(CUSTOMXML$0, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTCustomXmlRun);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlArray(CTCustomXmlRun[] cTCustomXmlRunArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTCustomXmlRunArr, CUSTOMXML$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlDelRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLDELRANGEEND$36);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlDelRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLDELRANGESTART$34);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlInsRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLINSRANGEEND$32);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlInsRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLINSRANGESTART$30);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlMoveFromRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVEFROMRANGEEND$40);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlMoveFromRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVEFROMRANGESTART$38);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlMoveToRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVETORANGEEND$44);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlMoveToRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVETORANGESTART$42);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setDArray(int i, CTD ctd) {
        synchronized (monitor()) {
            check_orphaned();
            CTD find_element_user = get_store().find_element_user(D$66, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(ctd);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setDArray(CTD[] ctdArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) ctdArr, D$66);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setDelArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, DEL$48);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setEqArrArray(int i, CTEqArr cTEqArr) {
        synchronized (monitor()) {
            check_orphaned();
            CTEqArr find_element_user = get_store().find_element_user(EQARR$68, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTEqArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setEqArrArray(CTEqArr[] cTEqArrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTEqArrArr, EQARR$68);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setFArray(int i, CTF ctf) {
        synchronized (monitor()) {
            check_orphaned();
            CTF find_element_user = get_store().find_element_user(F$70, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(ctf);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setFArray(CTF[] ctfArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) ctfArr, F$70);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setFuncArray(int i, CTFunc cTFunc) {
        synchronized (monitor()) {
            check_orphaned();
            CTFunc find_element_user = get_store().find_element_user(FUNC$72, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTFunc);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setFuncArray(CTFunc[] cTFuncArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTFuncArr, FUNC$72);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setGroupChrArray(int i, CTGroupChr cTGroupChr) {
        synchronized (monitor()) {
            check_orphaned();
            CTGroupChr find_element_user = get_store().find_element_user(GROUPCHR$74, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTGroupChr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setGroupChrArray(CTGroupChr[] cTGroupChrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTGroupChrArr, GROUPCHR$74);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setInsArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, INS$46);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setLimLowArray(int i, CTLimLow cTLimLow) {
        synchronized (monitor()) {
            check_orphaned();
            CTLimLow find_element_user = get_store().find_element_user(LIMLOW$76, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTLimLow);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setLimLowArray(CTLimLow[] cTLimLowArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTLimLowArr, LIMLOW$76);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setLimUppArray(int i, CTLimUpp cTLimUpp) {
        synchronized (monitor()) {
            check_orphaned();
            CTLimUpp find_element_user = get_store().find_element_user(LIMUPP$78, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTLimUpp);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setLimUppArray(CTLimUpp[] cTLimUppArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTLimUppArr, LIMUPP$78);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setMArray(int i, CTM ctm) {
        synchronized (monitor()) {
            check_orphaned();
            CTM find_element_user = get_store().find_element_user(M$80, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(ctm);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setMArray(CTM[] ctmArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) ctmArr, M$80);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setMoveFromArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVEFROM$50);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setMoveFromRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVEFROMRANGEEND$20);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setMoveFromRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVEFROMRANGESTART$18);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setMoveToArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVETO$52);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setMoveToRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVETORANGEEND$24);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setMoveToRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVETORANGESTART$22);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setNaryArray(int i, CTNary cTNary) {
        synchronized (monitor()) {
            check_orphaned();
            CTNary find_element_user = get_store().find_element_user(NARY$82, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTNary);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setNaryArray(CTNary[] cTNaryArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTNaryArr, NARY$82);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setOMathArray(CTOMath[] cTOMathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTOMathArr, OMATH$56);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setOMathParaArray(CTOMathPara[] cTOMathParaArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTOMathParaArr, OMATHPARA$54);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setPermEndArray(CTPerm[] cTPermArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPermArr, PERMEND$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setPermStartArray(CTPermStart[] cTPermStartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPermStartArr, PERMSTART$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setPhantArray(int i, CTPhant cTPhant) {
        synchronized (monitor()) {
            check_orphaned();
            CTPhant find_element_user = get_store().find_element_user(PHANT$84, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTPhant);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setPhantArray(CTPhant[] cTPhantArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPhantArr, PHANT$84);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setProofErrArray(CTProofErr[] cTProofErrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTProofErrArr, PROOFERR$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setR2Array(int i, org.openxmlformats.schemas.officeDocument.x2006.math.CTR ctr) {
        synchronized (monitor()) {
            check_orphaned();
            org.openxmlformats.schemas.officeDocument.x2006.math.CTR find_element_user = get_store().find_element_user(R2$96, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(ctr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setR2Array(org.openxmlformats.schemas.officeDocument.x2006.math.CTR[] ctrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) ctrArr, R2$96);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setRArray(int i, CTR ctr) {
        synchronized (monitor()) {
            check_orphaned();
            CTR ctr2 = (CTR) get_store().find_element_user(R$6, i);
            if (ctr2 == null) {
                throw new IndexOutOfBoundsException();
            }
            ctr2.set(ctr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setRArray(CTR[] ctrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(ctrArr, R$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setRadArray(int i, CTRad cTRad) {
        synchronized (monitor()) {
            check_orphaned();
            CTRad find_element_user = get_store().find_element_user(RAD$86, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTRad);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setRadArray(CTRad[] cTRadArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTRadArr, RAD$86);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSPreArray(int i, CTSPre cTSPre) {
        synchronized (monitor()) {
            check_orphaned();
            CTSPre find_element_user = get_store().find_element_user(SPRE$88, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTSPre);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSPreArray(CTSPre[] cTSPreArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSPreArr, SPRE$88);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSSubArray(int i, CTSSub cTSSub) {
        synchronized (monitor()) {
            check_orphaned();
            CTSSub find_element_user = get_store().find_element_user(SSUB$90, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTSSub);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSSubArray(CTSSub[] cTSSubArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSSubArr, SSUB$90);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSSubSupArray(int i, CTSSubSup cTSSubSup) {
        synchronized (monitor()) {
            check_orphaned();
            CTSSubSup find_element_user = get_store().find_element_user(SSUBSUP$92, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTSSubSup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSSubSupArray(CTSSubSup[] cTSSubSupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSSubSupArr, SSUBSUP$92);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSSupArray(int i, CTSSup cTSSup) {
        synchronized (monitor()) {
            check_orphaned();
            CTSSup find_element_user = get_store().find_element_user(SSUP$94, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTSSup);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSSupArray(CTSSup[] cTSSupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSSupArr, SSUP$94);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSdtArray(int i, CTSdtRun cTSdtRun) {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtRun cTSdtRun2 = (CTSdtRun) get_store().find_element_user(SDT$4, i);
            if (cTSdtRun2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSdtRun2.set(cTSdtRun);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSdtArray(CTSdtRun[] cTSdtRunArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSdtRunArr, SDT$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSmartTagArray(int i, CTSmartTagRun cTSmartTagRun) {
        synchronized (monitor()) {
            check_orphaned();
            CTSmartTagRun cTSmartTagRun2 = (CTSmartTagRun) get_store().find_element_user(SMARTTAG$2, i);
            if (cTSmartTagRun2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSmartTagRun2.set(cTSmartTagRun);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSmartTagArray(CTSmartTagRun[] cTSmartTagRunArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSmartTagRunArr, SMARTTAG$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfAccArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ACC$58);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfBarArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BAR$60);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfBookmarkEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BOOKMARKEND$16);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfBookmarkStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BOOKMARKSTART$14);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfBorderBoxArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BORDERBOX$64);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfBoxArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BOX$62);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfCommentRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(COMMENTRANGEEND$28);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfCommentRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(COMMENTRANGESTART$26);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfCustomXmlArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXML$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfCustomXmlDelRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLDELRANGEEND$36);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfCustomXmlDelRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLDELRANGESTART$34);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfCustomXmlInsRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLINSRANGEEND$32);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfCustomXmlInsRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLINSRANGESTART$30);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfCustomXmlMoveFromRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGEEND$40);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfCustomXmlMoveFromRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGESTART$38);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfCustomXmlMoveToRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLMOVETORANGEEND$44);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfCustomXmlMoveToRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CUSTOMXMLMOVETORANGESTART$42);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfDArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(D$66);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfDelArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DEL$48);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfEqArrArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(EQARR$68);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfFArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(F$70);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfFuncArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(FUNC$72);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfGroupChrArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(GROUPCHR$74);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfInsArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(INS$46);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfLimLowArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(LIMLOW$76);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfLimUppArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(LIMUPP$78);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfMArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(M$80);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfMoveFromArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVEFROM$50);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfMoveFromRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVEFROMRANGEEND$20);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfMoveFromRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVEFROMRANGESTART$18);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfMoveToArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVETO$52);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfMoveToRangeEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVETORANGEEND$24);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfMoveToRangeStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVETORANGESTART$22);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfNaryArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(NARY$82);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfOMathArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(OMATH$56);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfOMathParaArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(OMATHPARA$54);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfPermEndArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PERMEND$12);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfPermStartArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PERMSTART$10);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfPhantArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PHANT$84);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfProofErrArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PROOFERR$8);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfR2Array() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(R2$96);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfRArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(R$6);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfRadArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(RAD$86);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfSPreArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SPRE$88);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfSSubArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SSUB$90);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfSSubSupArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SSUBSUP$92);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfSSupArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SSUP$94);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfSdtArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SDT$4);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfSmartTagArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SMARTTAG$2);
        }
        return count_elements;
    }
}
