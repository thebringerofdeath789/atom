package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCnf;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFramePr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextAlignment;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextDirection;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextboxTightWrap;

/* loaded from: classes6.dex */
public class CTPPrBaseImpl extends XmlComplexContentImpl implements CTPPrBase {
    private static final QName PSTYLE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pStyle");
    private static final QName KEEPNEXT$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "keepNext");
    private static final QName KEEPLINES$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "keepLines");
    private static final QName PAGEBREAKBEFORE$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pageBreakBefore");
    private static final QName FRAMEPR$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "framePr");
    private static final QName WIDOWCONTROL$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "widowControl");
    private static final QName NUMPR$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numPr");
    private static final QName SUPPRESSLINENUMBERS$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "suppressLineNumbers");
    private static final QName PBDR$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pBdr");
    private static final QName SHD$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shd");
    private static final QName TABS$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tabs");
    private static final QName SUPPRESSAUTOHYPHENS$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "suppressAutoHyphens");
    private static final QName KINSOKU$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "kinsoku");
    private static final QName WORDWRAP$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "wordWrap");
    private static final QName OVERFLOWPUNCT$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "overflowPunct");
    private static final QName TOPLINEPUNCT$30 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "topLinePunct");
    private static final QName AUTOSPACEDE$32 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "autoSpaceDE");
    private static final QName AUTOSPACEDN$34 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "autoSpaceDN");
    private static final QName BIDI$36 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bidi");
    private static final QName ADJUSTRIGHTIND$38 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "adjustRightInd");
    private static final QName SNAPTOGRID$40 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "snapToGrid");
    private static final QName SPACING$42 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "spacing");
    private static final QName IND$44 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ind");
    private static final QName CONTEXTUALSPACING$46 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "contextualSpacing");
    private static final QName MIRRORINDENTS$48 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "mirrorIndents");
    private static final QName SUPPRESSOVERLAP$50 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "suppressOverlap");
    private static final QName JC$52 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "jc");
    private static final QName TEXTDIRECTION$54 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "textDirection");
    private static final QName TEXTALIGNMENT$56 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "textAlignment");
    private static final QName TEXTBOXTIGHTWRAP$58 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "textboxTightWrap");
    private static final QName OUTLINELVL$60 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "outlineLvl");
    private static final QName DIVID$62 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "divId");
    private static final QName CNFSTYLE$64 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cnfStyle");

    public CTPPrBaseImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewAdjustRightInd() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(ADJUSTRIGHTIND$38);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewAutoSpaceDE() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(AUTOSPACEDE$32);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewAutoSpaceDN() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(AUTOSPACEDN$34);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewBidi() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(BIDI$36);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTCnf addNewCnfStyle() {
        CTCnf add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CNFSTYLE$64);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewContextualSpacing() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(CONTEXTUALSPACING$46);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTDecimalNumber addNewDivId() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(DIVID$62);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTFramePr addNewFramePr() {
        CTFramePr add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(FRAMEPR$8);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTInd addNewInd() {
        CTInd cTInd;
        synchronized (monitor()) {
            check_orphaned();
            cTInd = (CTInd) get_store().add_element_user(IND$44);
        }
        return cTInd;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTJc addNewJc() {
        CTJc cTJc;
        synchronized (monitor()) {
            check_orphaned();
            cTJc = (CTJc) get_store().add_element_user(JC$52);
        }
        return cTJc;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewKeepLines() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(KEEPLINES$4);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewKeepNext() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(KEEPNEXT$2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewKinsoku() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(KINSOKU$24);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewMirrorIndents() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(MIRRORINDENTS$48);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTNumPr addNewNumPr() {
        CTNumPr cTNumPr;
        synchronized (monitor()) {
            check_orphaned();
            cTNumPr = (CTNumPr) get_store().add_element_user(NUMPR$12);
        }
        return cTNumPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTDecimalNumber addNewOutlineLvl() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(OUTLINELVL$60);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewOverflowPunct() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(OVERFLOWPUNCT$28);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTPBdr addNewPBdr() {
        CTPBdr cTPBdr;
        synchronized (monitor()) {
            check_orphaned();
            cTPBdr = (CTPBdr) get_store().add_element_user(PBDR$16);
        }
        return cTPBdr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTString addNewPStyle() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(PSTYLE$0);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewPageBreakBefore() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PAGEBREAKBEFORE$6);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTShd addNewShd() {
        CTShd cTShd;
        synchronized (monitor()) {
            check_orphaned();
            cTShd = (CTShd) get_store().add_element_user(SHD$18);
        }
        return cTShd;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewSnapToGrid() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(SNAPTOGRID$40);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTSpacing addNewSpacing() {
        CTSpacing cTSpacing;
        synchronized (monitor()) {
            check_orphaned();
            cTSpacing = (CTSpacing) get_store().add_element_user(SPACING$42);
        }
        return cTSpacing;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewSuppressAutoHyphens() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(SUPPRESSAUTOHYPHENS$22);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewSuppressLineNumbers() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(SUPPRESSLINENUMBERS$14);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewSuppressOverlap() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(SUPPRESSOVERLAP$50);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTTabs addNewTabs() {
        CTTabs cTTabs;
        synchronized (monitor()) {
            check_orphaned();
            cTTabs = (CTTabs) get_store().add_element_user(TABS$20);
        }
        return cTTabs;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTTextAlignment addNewTextAlignment() {
        CTTextAlignment cTTextAlignment;
        synchronized (monitor()) {
            check_orphaned();
            cTTextAlignment = (CTTextAlignment) get_store().add_element_user(TEXTALIGNMENT$56);
        }
        return cTTextAlignment;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTTextDirection addNewTextDirection() {
        CTTextDirection add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TEXTDIRECTION$54);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTTextboxTightWrap addNewTextboxTightWrap() {
        CTTextboxTightWrap add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TEXTBOXTIGHTWRAP$58);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewTopLinePunct() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(TOPLINEPUNCT$30);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewWidowControl() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(WIDOWCONTROL$10);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff addNewWordWrap() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(WORDWRAP$26);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getAdjustRightInd() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(ADJUSTRIGHTIND$38, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getAutoSpaceDE() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(AUTOSPACEDE$32, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getAutoSpaceDN() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(AUTOSPACEDN$34, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getBidi() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(BIDI$36, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTCnf getCnfStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTCnf find_element_user = get_store().find_element_user(CNFSTYLE$64, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getContextualSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(CONTEXTUALSPACING$46, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTDecimalNumber getDivId() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(DIVID$62, 0);
            if (cTDecimalNumber == null) {
                return null;
            }
            return cTDecimalNumber;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTFramePr getFramePr() {
        synchronized (monitor()) {
            check_orphaned();
            CTFramePr find_element_user = get_store().find_element_user(FRAMEPR$8, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTInd getInd() {
        synchronized (monitor()) {
            check_orphaned();
            CTInd cTInd = (CTInd) get_store().find_element_user(IND$44, 0);
            if (cTInd == null) {
                return null;
            }
            return cTInd;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTJc getJc() {
        synchronized (monitor()) {
            check_orphaned();
            CTJc cTJc = (CTJc) get_store().find_element_user(JC$52, 0);
            if (cTJc == null) {
                return null;
            }
            return cTJc;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getKeepLines() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(KEEPLINES$4, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getKeepNext() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(KEEPNEXT$2, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getKinsoku() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(KINSOKU$24, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getMirrorIndents() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(MIRRORINDENTS$48, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTNumPr getNumPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTNumPr cTNumPr = (CTNumPr) get_store().find_element_user(NUMPR$12, 0);
            if (cTNumPr == null) {
                return null;
            }
            return cTNumPr;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTDecimalNumber getOutlineLvl() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(OUTLINELVL$60, 0);
            if (cTDecimalNumber == null) {
                return null;
            }
            return cTDecimalNumber;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getOverflowPunct() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(OVERFLOWPUNCT$28, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTPBdr getPBdr() {
        synchronized (monitor()) {
            check_orphaned();
            CTPBdr cTPBdr = (CTPBdr) get_store().find_element_user(PBDR$16, 0);
            if (cTPBdr == null) {
                return null;
            }
            return cTPBdr;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTString getPStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTString = (CTString) get_store().find_element_user(PSTYLE$0, 0);
            if (cTString == null) {
                return null;
            }
            return cTString;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getPageBreakBefore() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(PAGEBREAKBEFORE$6, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTShd getShd() {
        synchronized (monitor()) {
            check_orphaned();
            CTShd cTShd = (CTShd) get_store().find_element_user(SHD$18, 0);
            if (cTShd == null) {
                return null;
            }
            return cTShd;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getSnapToGrid() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(SNAPTOGRID$40, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTSpacing getSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            CTSpacing cTSpacing = (CTSpacing) get_store().find_element_user(SPACING$42, 0);
            if (cTSpacing == null) {
                return null;
            }
            return cTSpacing;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getSuppressAutoHyphens() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(SUPPRESSAUTOHYPHENS$22, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getSuppressLineNumbers() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(SUPPRESSLINENUMBERS$14, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getSuppressOverlap() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(SUPPRESSOVERLAP$50, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTTabs getTabs() {
        synchronized (monitor()) {
            check_orphaned();
            CTTabs cTTabs = (CTTabs) get_store().find_element_user(TABS$20, 0);
            if (cTTabs == null) {
                return null;
            }
            return cTTabs;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTTextAlignment getTextAlignment() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextAlignment cTTextAlignment = (CTTextAlignment) get_store().find_element_user(TEXTALIGNMENT$56, 0);
            if (cTTextAlignment == null) {
                return null;
            }
            return cTTextAlignment;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTTextDirection getTextDirection() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextDirection find_element_user = get_store().find_element_user(TEXTDIRECTION$54, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTTextboxTightWrap getTextboxTightWrap() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextboxTightWrap find_element_user = get_store().find_element_user(TEXTBOXTIGHTWRAP$58, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getTopLinePunct() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(TOPLINEPUNCT$30, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getWidowControl() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(WIDOWCONTROL$10, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public CTOnOff getWordWrap() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(WORDWRAP$26, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetAdjustRightInd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ADJUSTRIGHTIND$38) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetAutoSpaceDE() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(AUTOSPACEDE$32) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetAutoSpaceDN() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(AUTOSPACEDN$34) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetBidi() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BIDI$36) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetCnfStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CNFSTYLE$64) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetContextualSpacing() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CONTEXTUALSPACING$46) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetDivId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DIVID$62) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetFramePr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FRAMEPR$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetInd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(IND$44) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetJc() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(JC$52) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetKeepLines() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(KEEPLINES$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetKeepNext() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(KEEPNEXT$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetKinsoku() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(KINSOKU$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetMirrorIndents() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MIRRORINDENTS$48) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetNumPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NUMPR$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetOutlineLvl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OUTLINELVL$60) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetOverflowPunct() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OVERFLOWPUNCT$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetPBdr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PBDR$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetPStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PSTYLE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetPageBreakBefore() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PAGEBREAKBEFORE$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetShd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHD$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetSnapToGrid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SNAPTOGRID$40) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetSpacing() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SPACING$42) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetSuppressAutoHyphens() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SUPPRESSAUTOHYPHENS$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetSuppressLineNumbers() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SUPPRESSLINENUMBERS$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetSuppressOverlap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SUPPRESSOVERLAP$50) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetTabs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TABS$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetTextAlignment() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TEXTALIGNMENT$56) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetTextDirection() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TEXTDIRECTION$54) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetTextboxTightWrap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TEXTBOXTIGHTWRAP$58) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetTopLinePunct() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TOPLINEPUNCT$30) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetWidowControl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WIDOWCONTROL$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public boolean isSetWordWrap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WORDWRAP$26) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setAdjustRightInd(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ADJUSTRIGHTIND$38;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setAutoSpaceDE(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTOSPACEDE$32;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setAutoSpaceDN(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTOSPACEDN$34;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setBidi(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BIDI$36;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setCnfStyle(CTCnf cTCnf) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CNFSTYLE$64;
            CTCnf find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTCnf) get_store().add_element_user(qName);
            }
            find_element_user.set(cTCnf);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setContextualSpacing(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTEXTUALSPACING$46;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setDivId(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIVID$62;
            CTDecimalNumber cTDecimalNumber2 = (CTDecimalNumber) typeStore.find_element_user(qName, 0);
            if (cTDecimalNumber2 == null) {
                cTDecimalNumber2 = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumber2.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setFramePr(CTFramePr cTFramePr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FRAMEPR$8;
            CTFramePr find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTFramePr) get_store().add_element_user(qName);
            }
            find_element_user.set(cTFramePr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setInd(CTInd cTInd) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IND$44;
            CTInd cTInd2 = (CTInd) typeStore.find_element_user(qName, 0);
            if (cTInd2 == null) {
                cTInd2 = (CTInd) get_store().add_element_user(qName);
            }
            cTInd2.set(cTInd);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setJc(CTJc cTJc) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = JC$52;
            CTJc cTJc2 = (CTJc) typeStore.find_element_user(qName, 0);
            if (cTJc2 == null) {
                cTJc2 = (CTJc) get_store().add_element_user(qName);
            }
            cTJc2.set(cTJc);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setKeepLines(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KEEPLINES$4;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setKeepNext(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KEEPNEXT$2;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setKinsoku(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KINSOKU$24;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setMirrorIndents(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MIRRORINDENTS$48;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setNumPr(CTNumPr cTNumPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMPR$12;
            CTNumPr cTNumPr2 = (CTNumPr) typeStore.find_element_user(qName, 0);
            if (cTNumPr2 == null) {
                cTNumPr2 = (CTNumPr) get_store().add_element_user(qName);
            }
            cTNumPr2.set(cTNumPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setOutlineLvl(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OUTLINELVL$60;
            CTDecimalNumber cTDecimalNumber2 = (CTDecimalNumber) typeStore.find_element_user(qName, 0);
            if (cTDecimalNumber2 == null) {
                cTDecimalNumber2 = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumber2.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setOverflowPunct(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OVERFLOWPUNCT$28;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setPBdr(CTPBdr cTPBdr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PBDR$16;
            CTPBdr cTPBdr2 = (CTPBdr) typeStore.find_element_user(qName, 0);
            if (cTPBdr2 == null) {
                cTPBdr2 = (CTPBdr) get_store().add_element_user(qName);
            }
            cTPBdr2.set(cTPBdr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setPStyle(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PSTYLE$0;
            CTString cTString2 = (CTString) typeStore.find_element_user(qName, 0);
            if (cTString2 == null) {
                cTString2 = (CTString) get_store().add_element_user(qName);
            }
            cTString2.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setPageBreakBefore(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAGEBREAKBEFORE$6;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setShd(CTShd cTShd) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHD$18;
            CTShd cTShd2 = (CTShd) typeStore.find_element_user(qName, 0);
            if (cTShd2 == null) {
                cTShd2 = (CTShd) get_store().add_element_user(qName);
            }
            cTShd2.set(cTShd);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setSnapToGrid(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SNAPTOGRID$40;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setSpacing(CTSpacing cTSpacing) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPACING$42;
            CTSpacing cTSpacing2 = (CTSpacing) typeStore.find_element_user(qName, 0);
            if (cTSpacing2 == null) {
                cTSpacing2 = (CTSpacing) get_store().add_element_user(qName);
            }
            cTSpacing2.set(cTSpacing);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setSuppressAutoHyphens(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUPPRESSAUTOHYPHENS$22;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setSuppressLineNumbers(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUPPRESSLINENUMBERS$14;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setSuppressOverlap(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUPPRESSOVERLAP$50;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setTabs(CTTabs cTTabs) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TABS$20;
            CTTabs cTTabs2 = (CTTabs) typeStore.find_element_user(qName, 0);
            if (cTTabs2 == null) {
                cTTabs2 = (CTTabs) get_store().add_element_user(qName);
            }
            cTTabs2.set(cTTabs);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setTextAlignment(CTTextAlignment cTTextAlignment) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEXTALIGNMENT$56;
            CTTextAlignment cTTextAlignment2 = (CTTextAlignment) typeStore.find_element_user(qName, 0);
            if (cTTextAlignment2 == null) {
                cTTextAlignment2 = (CTTextAlignment) get_store().add_element_user(qName);
            }
            cTTextAlignment2.set(cTTextAlignment);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setTextDirection(CTTextDirection cTTextDirection) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEXTDIRECTION$54;
            CTTextDirection find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTextDirection) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTextDirection);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setTextboxTightWrap(CTTextboxTightWrap cTTextboxTightWrap) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEXTBOXTIGHTWRAP$58;
            CTTextboxTightWrap find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTextboxTightWrap) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTextboxTightWrap);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setTopLinePunct(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOPLINEPUNCT$30;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setWidowControl(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WIDOWCONTROL$10;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void setWordWrap(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WORDWRAP$26;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetAdjustRightInd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ADJUSTRIGHTIND$38, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetAutoSpaceDE() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AUTOSPACEDE$32, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetAutoSpaceDN() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AUTOSPACEDN$34, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetBidi() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BIDI$36, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetCnfStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CNFSTYLE$64, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetContextualSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CONTEXTUALSPACING$46, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetDivId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DIVID$62, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetFramePr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FRAMEPR$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetInd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(IND$44, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetJc() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(JC$52, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetKeepLines() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(KEEPLINES$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetKeepNext() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(KEEPNEXT$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetKinsoku() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(KINSOKU$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetMirrorIndents() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MIRRORINDENTS$48, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetNumPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMPR$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetOutlineLvl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OUTLINELVL$60, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetOverflowPunct() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OVERFLOWPUNCT$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetPBdr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PBDR$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetPStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PSTYLE$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetPageBreakBefore() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PAGEBREAKBEFORE$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetShd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHD$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetSnapToGrid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SNAPTOGRID$40, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPACING$42, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetSuppressAutoHyphens() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SUPPRESSAUTOHYPHENS$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetSuppressLineNumbers() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SUPPRESSLINENUMBERS$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetSuppressOverlap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SUPPRESSOVERLAP$50, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetTabs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TABS$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetTextAlignment() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTALIGNMENT$56, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetTextDirection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTDIRECTION$54, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetTextboxTightWrap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTBOXTIGHTWRAP$58, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetTopLinePunct() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TOPLINEPUNCT$30, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetWidowControl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WIDOWCONTROL$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase
    public void unsetWordWrap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WORDWRAP$26, 0);
        }
    }
}
