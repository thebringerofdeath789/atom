package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.apache.poi.ss.formula.functions.Complex;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEastAsianLayout;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFitText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHighlight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedTwipsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextEffect;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextScale;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalAlignRun;

/* loaded from: classes6.dex */
public class CTParaRPrImpl extends XmlComplexContentImpl implements CTParaRPr {
    private static final QName INS$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins");
    private static final QName DEL$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "del");
    private static final QName MOVEFROM$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFrom");
    private static final QName MOVETO$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveTo");
    private static final QName RSTYLE$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rStyle");
    private static final QName RFONTS$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rFonts");
    private static final QName B$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "b");
    private static final QName BCS$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bCs");
    private static final QName I$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", Complex.DEFAULT_SUFFIX);
    private static final QName ICS$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "iCs");
    private static final QName CAPS$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "caps");
    private static final QName SMALLCAPS$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "smallCaps");
    private static final QName STRIKE$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "strike");
    private static final QName DSTRIKE$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dstrike");
    private static final QName OUTLINE$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "outline");
    private static final QName SHADOW$30 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shadow");
    private static final QName EMBOSS$32 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "emboss");
    private static final QName IMPRINT$34 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "imprint");
    private static final QName NOPROOF$36 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "noProof");
    private static final QName SNAPTOGRID$38 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "snapToGrid");
    private static final QName VANISH$40 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vanish");
    private static final QName WEBHIDDEN$42 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "webHidden");
    private static final QName COLOR$44 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", TtmlNode.ATTR_TTS_COLOR);
    private static final QName SPACING$46 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "spacing");
    private static final QName W$48 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "w");
    private static final QName KERN$50 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "kern");
    private static final QName POSITION$52 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "position");
    private static final QName SZ$54 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sz");
    private static final QName SZCS$56 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "szCs");
    private static final QName HIGHLIGHT$58 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "highlight");
    private static final QName U$60 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "u");
    private static final QName EFFECT$62 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "effect");
    private static final QName BDR$64 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bdr");
    private static final QName SHD$66 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shd");
    private static final QName FITTEXT$68 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fitText");
    private static final QName VERTALIGN$70 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vertAlign");
    private static final QName RTL$72 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rtl");
    private static final QName CS$74 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cs");
    private static final QName EM$76 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "em");
    private static final QName LANG$78 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lang");
    private static final QName EASTASIANLAYOUT$80 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "eastAsianLayout");
    private static final QName SPECVANISH$82 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "specVanish");
    private static final QName OMATH$84 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "oMath");
    private static final QName RPRCHANGE$86 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPrChange");

    public CTParaRPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff addNewB() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(B$12);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff addNewBCs() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(BCS$14);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTBorder addNewBdr() {
        CTBorder cTBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBorder = (CTBorder) get_store().add_element_user(BDR$64);
        }
        return cTBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff addNewCaps() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(CAPS$20);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTColor addNewColor() {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().add_element_user(COLOR$44);
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff addNewCs() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(CS$74);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTTrackChange addNewDel() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(DEL$2);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff addNewDstrike() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(DSTRIKE$26);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTEastAsianLayout addNewEastAsianLayout() {
        CTEastAsianLayout add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EASTASIANLAYOUT$80);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTTextEffect addNewEffect() {
        CTTextEffect add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EFFECT$62);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTEm addNewEm() {
        CTEm add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EM$76);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff addNewEmboss() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(EMBOSS$32);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTFitText addNewFitText() {
        CTFitText add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(FITTEXT$68);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTHighlight addNewHighlight() {
        CTHighlight add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(HIGHLIGHT$58);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff addNewI() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(I$16);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff addNewICs() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(ICS$18);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff addNewImprint() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(IMPRINT$34);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTTrackChange addNewIns() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(INS$0);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTHpsMeasure addNewKern() {
        CTHpsMeasure cTHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasure = (CTHpsMeasure) get_store().add_element_user(KERN$50);
        }
        return cTHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTLanguage addNewLang() {
        CTLanguage cTLanguage;
        synchronized (monitor()) {
            check_orphaned();
            cTLanguage = (CTLanguage) get_store().add_element_user(LANG$78);
        }
        return cTLanguage;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTTrackChange addNewMoveFrom() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(MOVEFROM$4);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTTrackChange addNewMoveTo() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(MOVETO$6);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff addNewNoProof() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(NOPROOF$36);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff addNewOMath() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(OMATH$84);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff addNewOutline() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(OUTLINE$28);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTSignedHpsMeasure addNewPosition() {
        CTSignedHpsMeasure cTSignedHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTSignedHpsMeasure = (CTSignedHpsMeasure) get_store().add_element_user(POSITION$52);
        }
        return cTSignedHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTFonts addNewRFonts() {
        CTFonts cTFonts;
        synchronized (monitor()) {
            check_orphaned();
            cTFonts = (CTFonts) get_store().add_element_user(RFONTS$10);
        }
        return cTFonts;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTParaRPrChange addNewRPrChange() {
        CTParaRPrChange add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(RPRCHANGE$86);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTString addNewRStyle() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(RSTYLE$8);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff addNewRtl() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(RTL$72);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff addNewShadow() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(SHADOW$30);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTShd addNewShd() {
        CTShd cTShd;
        synchronized (monitor()) {
            check_orphaned();
            cTShd = (CTShd) get_store().add_element_user(SHD$66);
        }
        return cTShd;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff addNewSmallCaps() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(SMALLCAPS$22);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff addNewSnapToGrid() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(SNAPTOGRID$38);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTSignedTwipsMeasure addNewSpacing() {
        CTSignedTwipsMeasure add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(SPACING$46);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff addNewSpecVanish() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(SPECVANISH$82);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff addNewStrike() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(STRIKE$24);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTHpsMeasure addNewSz() {
        CTHpsMeasure cTHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasure = (CTHpsMeasure) get_store().add_element_user(SZ$54);
        }
        return cTHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTHpsMeasure addNewSzCs() {
        CTHpsMeasure cTHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasure = (CTHpsMeasure) get_store().add_element_user(SZCS$56);
        }
        return cTHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTUnderline addNewU() {
        CTUnderline cTUnderline;
        synchronized (monitor()) {
            check_orphaned();
            cTUnderline = (CTUnderline) get_store().add_element_user(U$60);
        }
        return cTUnderline;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff addNewVanish() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(VANISH$40);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTVerticalAlignRun addNewVertAlign() {
        CTVerticalAlignRun cTVerticalAlignRun;
        synchronized (monitor()) {
            check_orphaned();
            cTVerticalAlignRun = (CTVerticalAlignRun) get_store().add_element_user(VERTALIGN$70);
        }
        return cTVerticalAlignRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTTextScale addNewW() {
        CTTextScale add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(W$48);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff addNewWebHidden() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(WEBHIDDEN$42);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff getB() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(B$12, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff getBCs() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(BCS$14, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTBorder getBdr() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorder = (CTBorder) get_store().find_element_user(BDR$64, 0);
            if (cTBorder == null) {
                return null;
            }
            return cTBorder;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff getCaps() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(CAPS$20, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTColor getColor() {
        synchronized (monitor()) {
            check_orphaned();
            CTColor cTColor = (CTColor) get_store().find_element_user(COLOR$44, 0);
            if (cTColor == null) {
                return null;
            }
            return cTColor;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff getCs() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(CS$74, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTTrackChange getDel() {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChange = (CTTrackChange) get_store().find_element_user(DEL$2, 0);
            if (cTTrackChange == null) {
                return null;
            }
            return cTTrackChange;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff getDstrike() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(DSTRIKE$26, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTEastAsianLayout getEastAsianLayout() {
        synchronized (monitor()) {
            check_orphaned();
            CTEastAsianLayout find_element_user = get_store().find_element_user(EASTASIANLAYOUT$80, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTTextEffect getEffect() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextEffect find_element_user = get_store().find_element_user(EFFECT$62, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTEm getEm() {
        synchronized (monitor()) {
            check_orphaned();
            CTEm find_element_user = get_store().find_element_user(EM$76, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff getEmboss() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(EMBOSS$32, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTFitText getFitText() {
        synchronized (monitor()) {
            check_orphaned();
            CTFitText find_element_user = get_store().find_element_user(FITTEXT$68, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTHighlight getHighlight() {
        synchronized (monitor()) {
            check_orphaned();
            CTHighlight find_element_user = get_store().find_element_user(HIGHLIGHT$58, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff getI() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(I$16, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff getICs() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(ICS$18, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff getImprint() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(IMPRINT$34, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTTrackChange getIns() {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChange = (CTTrackChange) get_store().find_element_user(INS$0, 0);
            if (cTTrackChange == null) {
                return null;
            }
            return cTTrackChange;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTHpsMeasure getKern() {
        synchronized (monitor()) {
            check_orphaned();
            CTHpsMeasure cTHpsMeasure = (CTHpsMeasure) get_store().find_element_user(KERN$50, 0);
            if (cTHpsMeasure == null) {
                return null;
            }
            return cTHpsMeasure;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTLanguage getLang() {
        synchronized (monitor()) {
            check_orphaned();
            CTLanguage cTLanguage = (CTLanguage) get_store().find_element_user(LANG$78, 0);
            if (cTLanguage == null) {
                return null;
            }
            return cTLanguage;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTTrackChange getMoveFrom() {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChange = (CTTrackChange) get_store().find_element_user(MOVEFROM$4, 0);
            if (cTTrackChange == null) {
                return null;
            }
            return cTTrackChange;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTTrackChange getMoveTo() {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChange = (CTTrackChange) get_store().find_element_user(MOVETO$6, 0);
            if (cTTrackChange == null) {
                return null;
            }
            return cTTrackChange;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff getNoProof() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(NOPROOF$36, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff getOMath() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(OMATH$84, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff getOutline() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(OUTLINE$28, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTSignedHpsMeasure getPosition() {
        synchronized (monitor()) {
            check_orphaned();
            CTSignedHpsMeasure cTSignedHpsMeasure = (CTSignedHpsMeasure) get_store().find_element_user(POSITION$52, 0);
            if (cTSignedHpsMeasure == null) {
                return null;
            }
            return cTSignedHpsMeasure;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTFonts getRFonts() {
        synchronized (monitor()) {
            check_orphaned();
            CTFonts cTFonts = (CTFonts) get_store().find_element_user(RFONTS$10, 0);
            if (cTFonts == null) {
                return null;
            }
            return cTFonts;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTParaRPrChange getRPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            CTParaRPrChange find_element_user = get_store().find_element_user(RPRCHANGE$86, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTString getRStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTString = (CTString) get_store().find_element_user(RSTYLE$8, 0);
            if (cTString == null) {
                return null;
            }
            return cTString;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff getRtl() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(RTL$72, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff getShadow() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(SHADOW$30, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTShd getShd() {
        synchronized (monitor()) {
            check_orphaned();
            CTShd cTShd = (CTShd) get_store().find_element_user(SHD$66, 0);
            if (cTShd == null) {
                return null;
            }
            return cTShd;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff getSmallCaps() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(SMALLCAPS$22, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff getSnapToGrid() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(SNAPTOGRID$38, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTSignedTwipsMeasure getSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            CTSignedTwipsMeasure find_element_user = get_store().find_element_user(SPACING$46, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff getSpecVanish() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(SPECVANISH$82, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff getStrike() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(STRIKE$24, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTHpsMeasure getSz() {
        synchronized (monitor()) {
            check_orphaned();
            CTHpsMeasure cTHpsMeasure = (CTHpsMeasure) get_store().find_element_user(SZ$54, 0);
            if (cTHpsMeasure == null) {
                return null;
            }
            return cTHpsMeasure;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTHpsMeasure getSzCs() {
        synchronized (monitor()) {
            check_orphaned();
            CTHpsMeasure cTHpsMeasure = (CTHpsMeasure) get_store().find_element_user(SZCS$56, 0);
            if (cTHpsMeasure == null) {
                return null;
            }
            return cTHpsMeasure;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTUnderline getU() {
        synchronized (monitor()) {
            check_orphaned();
            CTUnderline cTUnderline = (CTUnderline) get_store().find_element_user(U$60, 0);
            if (cTUnderline == null) {
                return null;
            }
            return cTUnderline;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff getVanish() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(VANISH$40, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTVerticalAlignRun getVertAlign() {
        synchronized (monitor()) {
            check_orphaned();
            CTVerticalAlignRun cTVerticalAlignRun = (CTVerticalAlignRun) get_store().find_element_user(VERTALIGN$70, 0);
            if (cTVerticalAlignRun == null) {
                return null;
            }
            return cTVerticalAlignRun;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTTextScale getW() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextScale find_element_user = get_store().find_element_user(W$48, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public CTOnOff getWebHidden() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(WEBHIDDEN$42, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetB() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(B$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetBCs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BCS$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetBdr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BDR$64) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetCaps() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CAPS$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetColor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(COLOR$44) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetCs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CS$74) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetDel() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DEL$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetDstrike() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DSTRIKE$26) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetEastAsianLayout() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EASTASIANLAYOUT$80) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetEffect() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EFFECT$62) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetEm() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EM$76) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetEmboss() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EMBOSS$32) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetFitText() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FITTEXT$68) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetHighlight() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HIGHLIGHT$58) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetI() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(I$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetICs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ICS$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetImprint() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(IMPRINT$34) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetIns() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(INS$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetKern() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(KERN$50) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetLang() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LANG$78) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetMoveFrom() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MOVEFROM$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetMoveTo() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MOVETO$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetNoProof() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NOPROOF$36) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetOMath() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OMATH$84) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetOutline() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OUTLINE$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetPosition() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(POSITION$52) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetRFonts() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RFONTS$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetRPrChange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RPRCHANGE$86) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetRStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RSTYLE$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetRtl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RTL$72) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetShadow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHADOW$30) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetShd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHD$66) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetSmallCaps() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SMALLCAPS$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetSnapToGrid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SNAPTOGRID$38) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetSpacing() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SPACING$46) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetSpecVanish() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SPECVANISH$82) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetStrike() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STRIKE$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetSz() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SZ$54) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetSzCs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SZCS$56) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetU() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(U$60) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetVanish() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VANISH$40) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetVertAlign() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VERTALIGN$70) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetW() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(W$48) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public boolean isSetWebHidden() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WEBHIDDEN$42) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setB(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = B$12;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setBCs(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BCS$14;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setBdr(CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BDR$64;
            CTBorder cTBorder2 = (CTBorder) typeStore.find_element_user(qName, 0);
            if (cTBorder2 == null) {
                cTBorder2 = (CTBorder) get_store().add_element_user(qName);
            }
            cTBorder2.set(cTBorder);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setCaps(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CAPS$20;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setColor(CTColor cTColor) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLOR$44;
            CTColor cTColor2 = (CTColor) typeStore.find_element_user(qName, 0);
            if (cTColor2 == null) {
                cTColor2 = (CTColor) get_store().add_element_user(qName);
            }
            cTColor2.set(cTColor);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setCs(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CS$74;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setDel(CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEL$2;
            CTTrackChange cTTrackChange2 = (CTTrackChange) typeStore.find_element_user(qName, 0);
            if (cTTrackChange2 == null) {
                cTTrackChange2 = (CTTrackChange) get_store().add_element_user(qName);
            }
            cTTrackChange2.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setDstrike(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DSTRIKE$26;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setEastAsianLayout(CTEastAsianLayout cTEastAsianLayout) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EASTASIANLAYOUT$80;
            CTEastAsianLayout find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTEastAsianLayout) get_store().add_element_user(qName);
            }
            find_element_user.set(cTEastAsianLayout);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setEffect(CTTextEffect cTTextEffect) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EFFECT$62;
            CTTextEffect find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTextEffect) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTextEffect);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setEm(CTEm cTEm) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EM$76;
            CTEm find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTEm) get_store().add_element_user(qName);
            }
            find_element_user.set(cTEm);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setEmboss(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EMBOSS$32;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setFitText(CTFitText cTFitText) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FITTEXT$68;
            CTFitText find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTFitText) get_store().add_element_user(qName);
            }
            find_element_user.set(cTFitText);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setHighlight(CTHighlight cTHighlight) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HIGHLIGHT$58;
            CTHighlight find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTHighlight) get_store().add_element_user(qName);
            }
            find_element_user.set(cTHighlight);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setI(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I$16;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setICs(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ICS$18;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setImprint(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IMPRINT$34;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setIns(CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INS$0;
            CTTrackChange cTTrackChange2 = (CTTrackChange) typeStore.find_element_user(qName, 0);
            if (cTTrackChange2 == null) {
                cTTrackChange2 = (CTTrackChange) get_store().add_element_user(qName);
            }
            cTTrackChange2.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setKern(CTHpsMeasure cTHpsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KERN$50;
            CTHpsMeasure cTHpsMeasure2 = (CTHpsMeasure) typeStore.find_element_user(qName, 0);
            if (cTHpsMeasure2 == null) {
                cTHpsMeasure2 = (CTHpsMeasure) get_store().add_element_user(qName);
            }
            cTHpsMeasure2.set(cTHpsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setLang(CTLanguage cTLanguage) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LANG$78;
            CTLanguage cTLanguage2 = (CTLanguage) typeStore.find_element_user(qName, 0);
            if (cTLanguage2 == null) {
                cTLanguage2 = (CTLanguage) get_store().add_element_user(qName);
            }
            cTLanguage2.set(cTLanguage);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setMoveFrom(CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MOVEFROM$4;
            CTTrackChange cTTrackChange2 = (CTTrackChange) typeStore.find_element_user(qName, 0);
            if (cTTrackChange2 == null) {
                cTTrackChange2 = (CTTrackChange) get_store().add_element_user(qName);
            }
            cTTrackChange2.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setMoveTo(CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MOVETO$6;
            CTTrackChange cTTrackChange2 = (CTTrackChange) typeStore.find_element_user(qName, 0);
            if (cTTrackChange2 == null) {
                cTTrackChange2 = (CTTrackChange) get_store().add_element_user(qName);
            }
            cTTrackChange2.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setNoProof(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NOPROOF$36;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setOMath(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OMATH$84;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setOutline(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OUTLINE$28;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setPosition(CTSignedHpsMeasure cTSignedHpsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = POSITION$52;
            CTSignedHpsMeasure cTSignedHpsMeasure2 = (CTSignedHpsMeasure) typeStore.find_element_user(qName, 0);
            if (cTSignedHpsMeasure2 == null) {
                cTSignedHpsMeasure2 = (CTSignedHpsMeasure) get_store().add_element_user(qName);
            }
            cTSignedHpsMeasure2.set(cTSignedHpsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setRFonts(CTFonts cTFonts) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RFONTS$10;
            CTFonts cTFonts2 = (CTFonts) typeStore.find_element_user(qName, 0);
            if (cTFonts2 == null) {
                cTFonts2 = (CTFonts) get_store().add_element_user(qName);
            }
            cTFonts2.set(cTFonts);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setRPrChange(CTParaRPrChange cTParaRPrChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RPRCHANGE$86;
            CTParaRPrChange find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTParaRPrChange) get_store().add_element_user(qName);
            }
            find_element_user.set(cTParaRPrChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setRStyle(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RSTYLE$8;
            CTString cTString2 = (CTString) typeStore.find_element_user(qName, 0);
            if (cTString2 == null) {
                cTString2 = (CTString) get_store().add_element_user(qName);
            }
            cTString2.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setRtl(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RTL$72;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setShadow(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHADOW$30;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setShd(CTShd cTShd) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHD$66;
            CTShd cTShd2 = (CTShd) typeStore.find_element_user(qName, 0);
            if (cTShd2 == null) {
                cTShd2 = (CTShd) get_store().add_element_user(qName);
            }
            cTShd2.set(cTShd);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setSmallCaps(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SMALLCAPS$22;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setSnapToGrid(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SNAPTOGRID$38;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setSpacing(CTSignedTwipsMeasure cTSignedTwipsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPACING$46;
            CTSignedTwipsMeasure find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTSignedTwipsMeasure) get_store().add_element_user(qName);
            }
            find_element_user.set(cTSignedTwipsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setSpecVanish(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPECVANISH$82;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setStrike(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STRIKE$24;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setSz(CTHpsMeasure cTHpsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SZ$54;
            CTHpsMeasure cTHpsMeasure2 = (CTHpsMeasure) typeStore.find_element_user(qName, 0);
            if (cTHpsMeasure2 == null) {
                cTHpsMeasure2 = (CTHpsMeasure) get_store().add_element_user(qName);
            }
            cTHpsMeasure2.set(cTHpsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setSzCs(CTHpsMeasure cTHpsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SZCS$56;
            CTHpsMeasure cTHpsMeasure2 = (CTHpsMeasure) typeStore.find_element_user(qName, 0);
            if (cTHpsMeasure2 == null) {
                cTHpsMeasure2 = (CTHpsMeasure) get_store().add_element_user(qName);
            }
            cTHpsMeasure2.set(cTHpsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setU(CTUnderline cTUnderline) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = U$60;
            CTUnderline cTUnderline2 = (CTUnderline) typeStore.find_element_user(qName, 0);
            if (cTUnderline2 == null) {
                cTUnderline2 = (CTUnderline) get_store().add_element_user(qName);
            }
            cTUnderline2.set(cTUnderline);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setVanish(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VANISH$40;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setVertAlign(CTVerticalAlignRun cTVerticalAlignRun) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VERTALIGN$70;
            CTVerticalAlignRun cTVerticalAlignRun2 = (CTVerticalAlignRun) typeStore.find_element_user(qName, 0);
            if (cTVerticalAlignRun2 == null) {
                cTVerticalAlignRun2 = (CTVerticalAlignRun) get_store().add_element_user(qName);
            }
            cTVerticalAlignRun2.set(cTVerticalAlignRun);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setW(CTTextScale cTTextScale) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = W$48;
            CTTextScale find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTextScale) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTextScale);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void setWebHidden(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WEBHIDDEN$42;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetB() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(B$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetBCs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BCS$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetBdr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BDR$64, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetCaps() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CAPS$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetColor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COLOR$44, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetCs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CS$74, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetDel() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEL$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetDstrike() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DSTRIKE$26, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetEastAsianLayout() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EASTASIANLAYOUT$80, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetEffect() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EFFECT$62, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetEm() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EM$76, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetEmboss() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EMBOSS$32, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetFitText() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FITTEXT$68, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetHighlight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HIGHLIGHT$58, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetI() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(I$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetICs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ICS$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetImprint() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(IMPRINT$34, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetIns() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INS$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetKern() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(KERN$50, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetLang() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LANG$78, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetMoveFrom() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROM$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetMoveTo() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETO$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetNoProof() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOPROOF$36, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetOMath() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATH$84, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetOutline() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OUTLINE$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetPosition() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(POSITION$52, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetRFonts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RFONTS$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetRPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RPRCHANGE$86, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetRStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RSTYLE$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetRtl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RTL$72, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetShadow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHADOW$30, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetShd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHD$66, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetSmallCaps() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SMALLCAPS$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetSnapToGrid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SNAPTOGRID$38, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPACING$46, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetSpecVanish() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPECVANISH$82, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetStrike() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STRIKE$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetSz() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SZ$54, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetSzCs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SZCS$56, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetU() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(U$60, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetVanish() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VANISH$40, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetVertAlign() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VERTALIGN$70, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetW() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(W$48, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr
    public void unsetWebHidden() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WEBHIDDEN$42, 0);
        }
    }
}
