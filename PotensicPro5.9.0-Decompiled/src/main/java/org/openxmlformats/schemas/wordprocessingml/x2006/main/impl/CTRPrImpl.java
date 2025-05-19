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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedTwipsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextEffect;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextScale;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalAlignRun;

/* loaded from: classes6.dex */
public class CTRPrImpl extends XmlComplexContentImpl implements CTRPr {
    private static final QName RSTYLE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rStyle");
    private static final QName RFONTS$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rFonts");
    private static final QName B$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "b");
    private static final QName BCS$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bCs");
    private static final QName I$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", Complex.DEFAULT_SUFFIX);
    private static final QName ICS$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "iCs");
    private static final QName CAPS$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "caps");
    private static final QName SMALLCAPS$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "smallCaps");
    private static final QName STRIKE$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "strike");
    private static final QName DSTRIKE$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dstrike");
    private static final QName OUTLINE$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "outline");
    private static final QName SHADOW$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shadow");
    private static final QName EMBOSS$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "emboss");
    private static final QName IMPRINT$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "imprint");
    private static final QName NOPROOF$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "noProof");
    private static final QName SNAPTOGRID$30 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "snapToGrid");
    private static final QName VANISH$32 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vanish");
    private static final QName WEBHIDDEN$34 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "webHidden");
    private static final QName COLOR$36 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", TtmlNode.ATTR_TTS_COLOR);
    private static final QName SPACING$38 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "spacing");
    private static final QName W$40 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "w");
    private static final QName KERN$42 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "kern");
    private static final QName POSITION$44 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "position");
    private static final QName SZ$46 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sz");
    private static final QName SZCS$48 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "szCs");
    private static final QName HIGHLIGHT$50 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "highlight");
    private static final QName U$52 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "u");
    private static final QName EFFECT$54 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "effect");
    private static final QName BDR$56 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bdr");
    private static final QName SHD$58 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shd");
    private static final QName FITTEXT$60 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fitText");
    private static final QName VERTALIGN$62 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vertAlign");
    private static final QName RTL$64 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rtl");
    private static final QName CS$66 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cs");
    private static final QName EM$68 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "em");
    private static final QName LANG$70 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lang");
    private static final QName EASTASIANLAYOUT$72 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "eastAsianLayout");
    private static final QName SPECVANISH$74 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "specVanish");
    private static final QName OMATH$76 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "oMath");
    private static final QName RPRCHANGE$78 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPrChange");

    public CTRPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewB() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(B$4);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewBCs() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(BCS$6);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTBorder addNewBdr() {
        CTBorder cTBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBorder = (CTBorder) get_store().add_element_user(BDR$56);
        }
        return cTBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewCaps() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(CAPS$12);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTColor addNewColor() {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().add_element_user(COLOR$36);
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewCs() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(CS$66);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewDstrike() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(DSTRIKE$18);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTEastAsianLayout addNewEastAsianLayout() {
        CTEastAsianLayout add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EASTASIANLAYOUT$72);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTTextEffect addNewEffect() {
        CTTextEffect add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EFFECT$54);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTEm addNewEm() {
        CTEm add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EM$68);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewEmboss() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(EMBOSS$24);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTFitText addNewFitText() {
        CTFitText add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(FITTEXT$60);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTHighlight addNewHighlight() {
        CTHighlight add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(HIGHLIGHT$50);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewI() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(I$8);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewICs() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(ICS$10);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewImprint() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(IMPRINT$26);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTHpsMeasure addNewKern() {
        CTHpsMeasure cTHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasure = (CTHpsMeasure) get_store().add_element_user(KERN$42);
        }
        return cTHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTLanguage addNewLang() {
        CTLanguage cTLanguage;
        synchronized (monitor()) {
            check_orphaned();
            cTLanguage = (CTLanguage) get_store().add_element_user(LANG$70);
        }
        return cTLanguage;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewNoProof() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(NOPROOF$28);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewOMath() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(OMATH$76);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewOutline() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(OUTLINE$20);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTSignedHpsMeasure addNewPosition() {
        CTSignedHpsMeasure cTSignedHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTSignedHpsMeasure = (CTSignedHpsMeasure) get_store().add_element_user(POSITION$44);
        }
        return cTSignedHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTFonts addNewRFonts() {
        CTFonts cTFonts;
        synchronized (monitor()) {
            check_orphaned();
            cTFonts = (CTFonts) get_store().add_element_user(RFONTS$2);
        }
        return cTFonts;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTRPrChange addNewRPrChange() {
        CTRPrChange add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(RPRCHANGE$78);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTString addNewRStyle() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(RSTYLE$0);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewRtl() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(RTL$64);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewShadow() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(SHADOW$22);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTShd addNewShd() {
        CTShd cTShd;
        synchronized (monitor()) {
            check_orphaned();
            cTShd = (CTShd) get_store().add_element_user(SHD$58);
        }
        return cTShd;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewSmallCaps() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(SMALLCAPS$14);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewSnapToGrid() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(SNAPTOGRID$30);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTSignedTwipsMeasure addNewSpacing() {
        CTSignedTwipsMeasure add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(SPACING$38);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewSpecVanish() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(SPECVANISH$74);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewStrike() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(STRIKE$16);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTHpsMeasure addNewSz() {
        CTHpsMeasure cTHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasure = (CTHpsMeasure) get_store().add_element_user(SZ$46);
        }
        return cTHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTHpsMeasure addNewSzCs() {
        CTHpsMeasure cTHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasure = (CTHpsMeasure) get_store().add_element_user(SZCS$48);
        }
        return cTHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTUnderline addNewU() {
        CTUnderline cTUnderline;
        synchronized (monitor()) {
            check_orphaned();
            cTUnderline = (CTUnderline) get_store().add_element_user(U$52);
        }
        return cTUnderline;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewVanish() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(VANISH$32);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTVerticalAlignRun addNewVertAlign() {
        CTVerticalAlignRun cTVerticalAlignRun;
        synchronized (monitor()) {
            check_orphaned();
            cTVerticalAlignRun = (CTVerticalAlignRun) get_store().add_element_user(VERTALIGN$62);
        }
        return cTVerticalAlignRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTTextScale addNewW() {
        CTTextScale add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(W$40);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff addNewWebHidden() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(WEBHIDDEN$34);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getB() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(B$4, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getBCs() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(BCS$6, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTBorder getBdr() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder cTBorder = (CTBorder) get_store().find_element_user(BDR$56, 0);
            if (cTBorder == null) {
                return null;
            }
            return cTBorder;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getCaps() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(CAPS$12, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTColor getColor() {
        synchronized (monitor()) {
            check_orphaned();
            CTColor cTColor = (CTColor) get_store().find_element_user(COLOR$36, 0);
            if (cTColor == null) {
                return null;
            }
            return cTColor;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getCs() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(CS$66, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getDstrike() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(DSTRIKE$18, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTEastAsianLayout getEastAsianLayout() {
        synchronized (monitor()) {
            check_orphaned();
            CTEastAsianLayout find_element_user = get_store().find_element_user(EASTASIANLAYOUT$72, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTTextEffect getEffect() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextEffect find_element_user = get_store().find_element_user(EFFECT$54, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTEm getEm() {
        synchronized (monitor()) {
            check_orphaned();
            CTEm find_element_user = get_store().find_element_user(EM$68, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getEmboss() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(EMBOSS$24, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTFitText getFitText() {
        synchronized (monitor()) {
            check_orphaned();
            CTFitText find_element_user = get_store().find_element_user(FITTEXT$60, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTHighlight getHighlight() {
        synchronized (monitor()) {
            check_orphaned();
            CTHighlight find_element_user = get_store().find_element_user(HIGHLIGHT$50, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getI() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(I$8, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getICs() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(ICS$10, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getImprint() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(IMPRINT$26, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTHpsMeasure getKern() {
        synchronized (monitor()) {
            check_orphaned();
            CTHpsMeasure cTHpsMeasure = (CTHpsMeasure) get_store().find_element_user(KERN$42, 0);
            if (cTHpsMeasure == null) {
                return null;
            }
            return cTHpsMeasure;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTLanguage getLang() {
        synchronized (monitor()) {
            check_orphaned();
            CTLanguage cTLanguage = (CTLanguage) get_store().find_element_user(LANG$70, 0);
            if (cTLanguage == null) {
                return null;
            }
            return cTLanguage;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getNoProof() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(NOPROOF$28, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getOMath() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(OMATH$76, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getOutline() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(OUTLINE$20, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTSignedHpsMeasure getPosition() {
        synchronized (monitor()) {
            check_orphaned();
            CTSignedHpsMeasure cTSignedHpsMeasure = (CTSignedHpsMeasure) get_store().find_element_user(POSITION$44, 0);
            if (cTSignedHpsMeasure == null) {
                return null;
            }
            return cTSignedHpsMeasure;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTFonts getRFonts() {
        synchronized (monitor()) {
            check_orphaned();
            CTFonts cTFonts = (CTFonts) get_store().find_element_user(RFONTS$2, 0);
            if (cTFonts == null) {
                return null;
            }
            return cTFonts;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTRPrChange getRPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            CTRPrChange find_element_user = get_store().find_element_user(RPRCHANGE$78, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTString getRStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTString = (CTString) get_store().find_element_user(RSTYLE$0, 0);
            if (cTString == null) {
                return null;
            }
            return cTString;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getRtl() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(RTL$64, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getShadow() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(SHADOW$22, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTShd getShd() {
        synchronized (monitor()) {
            check_orphaned();
            CTShd cTShd = (CTShd) get_store().find_element_user(SHD$58, 0);
            if (cTShd == null) {
                return null;
            }
            return cTShd;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getSmallCaps() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(SMALLCAPS$14, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getSnapToGrid() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(SNAPTOGRID$30, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTSignedTwipsMeasure getSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            CTSignedTwipsMeasure find_element_user = get_store().find_element_user(SPACING$38, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getSpecVanish() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(SPECVANISH$74, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getStrike() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(STRIKE$16, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTHpsMeasure getSz() {
        synchronized (monitor()) {
            check_orphaned();
            CTHpsMeasure cTHpsMeasure = (CTHpsMeasure) get_store().find_element_user(SZ$46, 0);
            if (cTHpsMeasure == null) {
                return null;
            }
            return cTHpsMeasure;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTHpsMeasure getSzCs() {
        synchronized (monitor()) {
            check_orphaned();
            CTHpsMeasure cTHpsMeasure = (CTHpsMeasure) get_store().find_element_user(SZCS$48, 0);
            if (cTHpsMeasure == null) {
                return null;
            }
            return cTHpsMeasure;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTUnderline getU() {
        synchronized (monitor()) {
            check_orphaned();
            CTUnderline cTUnderline = (CTUnderline) get_store().find_element_user(U$52, 0);
            if (cTUnderline == null) {
                return null;
            }
            return cTUnderline;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getVanish() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(VANISH$32, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTVerticalAlignRun getVertAlign() {
        synchronized (monitor()) {
            check_orphaned();
            CTVerticalAlignRun cTVerticalAlignRun = (CTVerticalAlignRun) get_store().find_element_user(VERTALIGN$62, 0);
            if (cTVerticalAlignRun == null) {
                return null;
            }
            return cTVerticalAlignRun;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTTextScale getW() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextScale find_element_user = get_store().find_element_user(W$40, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public CTOnOff getWebHidden() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(WEBHIDDEN$34, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetB() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(B$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetBCs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BCS$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetBdr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BDR$56) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetCaps() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CAPS$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetColor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(COLOR$36) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetCs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CS$66) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetDstrike() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DSTRIKE$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetEastAsianLayout() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EASTASIANLAYOUT$72) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetEffect() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EFFECT$54) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetEm() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EM$68) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetEmboss() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EMBOSS$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetFitText() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FITTEXT$60) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetHighlight() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HIGHLIGHT$50) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetI() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(I$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetICs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ICS$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetImprint() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(IMPRINT$26) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetKern() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(KERN$42) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetLang() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LANG$70) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetNoProof() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NOPROOF$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetOMath() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OMATH$76) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetOutline() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OUTLINE$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetPosition() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(POSITION$44) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetRFonts() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RFONTS$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetRPrChange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RPRCHANGE$78) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetRStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RSTYLE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetRtl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RTL$64) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetShadow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHADOW$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetShd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHD$58) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetSmallCaps() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SMALLCAPS$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetSnapToGrid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SNAPTOGRID$30) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetSpacing() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SPACING$38) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetSpecVanish() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SPECVANISH$74) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetStrike() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STRIKE$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetSz() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SZ$46) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetSzCs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SZCS$48) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetU() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(U$52) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetVanish() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VANISH$32) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetVertAlign() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VERTALIGN$62) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetW() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(W$40) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public boolean isSetWebHidden() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WEBHIDDEN$34) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setB(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = B$4;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setBCs(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BCS$6;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setBdr(CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BDR$56;
            CTBorder cTBorder2 = (CTBorder) typeStore.find_element_user(qName, 0);
            if (cTBorder2 == null) {
                cTBorder2 = (CTBorder) get_store().add_element_user(qName);
            }
            cTBorder2.set(cTBorder);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setCaps(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CAPS$12;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setColor(CTColor cTColor) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLOR$36;
            CTColor cTColor2 = (CTColor) typeStore.find_element_user(qName, 0);
            if (cTColor2 == null) {
                cTColor2 = (CTColor) get_store().add_element_user(qName);
            }
            cTColor2.set(cTColor);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setCs(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CS$66;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setDstrike(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DSTRIKE$18;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setEastAsianLayout(CTEastAsianLayout cTEastAsianLayout) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EASTASIANLAYOUT$72;
            CTEastAsianLayout find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTEastAsianLayout) get_store().add_element_user(qName);
            }
            find_element_user.set(cTEastAsianLayout);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setEffect(CTTextEffect cTTextEffect) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EFFECT$54;
            CTTextEffect find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTextEffect) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTextEffect);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setEm(CTEm cTEm) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EM$68;
            CTEm find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTEm) get_store().add_element_user(qName);
            }
            find_element_user.set(cTEm);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setEmboss(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EMBOSS$24;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setFitText(CTFitText cTFitText) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FITTEXT$60;
            CTFitText find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTFitText) get_store().add_element_user(qName);
            }
            find_element_user.set(cTFitText);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setHighlight(CTHighlight cTHighlight) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HIGHLIGHT$50;
            CTHighlight find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTHighlight) get_store().add_element_user(qName);
            }
            find_element_user.set(cTHighlight);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setI(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = I$8;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setICs(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ICS$10;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setImprint(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IMPRINT$26;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setKern(CTHpsMeasure cTHpsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KERN$42;
            CTHpsMeasure cTHpsMeasure2 = (CTHpsMeasure) typeStore.find_element_user(qName, 0);
            if (cTHpsMeasure2 == null) {
                cTHpsMeasure2 = (CTHpsMeasure) get_store().add_element_user(qName);
            }
            cTHpsMeasure2.set(cTHpsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setLang(CTLanguage cTLanguage) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LANG$70;
            CTLanguage cTLanguage2 = (CTLanguage) typeStore.find_element_user(qName, 0);
            if (cTLanguage2 == null) {
                cTLanguage2 = (CTLanguage) get_store().add_element_user(qName);
            }
            cTLanguage2.set(cTLanguage);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setNoProof(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NOPROOF$28;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setOMath(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OMATH$76;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setOutline(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OUTLINE$20;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setPosition(CTSignedHpsMeasure cTSignedHpsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = POSITION$44;
            CTSignedHpsMeasure cTSignedHpsMeasure2 = (CTSignedHpsMeasure) typeStore.find_element_user(qName, 0);
            if (cTSignedHpsMeasure2 == null) {
                cTSignedHpsMeasure2 = (CTSignedHpsMeasure) get_store().add_element_user(qName);
            }
            cTSignedHpsMeasure2.set(cTSignedHpsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setRFonts(CTFonts cTFonts) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RFONTS$2;
            CTFonts cTFonts2 = (CTFonts) typeStore.find_element_user(qName, 0);
            if (cTFonts2 == null) {
                cTFonts2 = (CTFonts) get_store().add_element_user(qName);
            }
            cTFonts2.set(cTFonts);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setRPrChange(CTRPrChange cTRPrChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RPRCHANGE$78;
            CTRPrChange find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTRPrChange) get_store().add_element_user(qName);
            }
            find_element_user.set(cTRPrChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setRStyle(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RSTYLE$0;
            CTString cTString2 = (CTString) typeStore.find_element_user(qName, 0);
            if (cTString2 == null) {
                cTString2 = (CTString) get_store().add_element_user(qName);
            }
            cTString2.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setRtl(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RTL$64;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setShadow(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHADOW$22;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setShd(CTShd cTShd) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHD$58;
            CTShd cTShd2 = (CTShd) typeStore.find_element_user(qName, 0);
            if (cTShd2 == null) {
                cTShd2 = (CTShd) get_store().add_element_user(qName);
            }
            cTShd2.set(cTShd);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setSmallCaps(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SMALLCAPS$14;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setSnapToGrid(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SNAPTOGRID$30;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setSpacing(CTSignedTwipsMeasure cTSignedTwipsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPACING$38;
            CTSignedTwipsMeasure find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTSignedTwipsMeasure) get_store().add_element_user(qName);
            }
            find_element_user.set(cTSignedTwipsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setSpecVanish(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPECVANISH$74;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setStrike(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STRIKE$16;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setSz(CTHpsMeasure cTHpsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SZ$46;
            CTHpsMeasure cTHpsMeasure2 = (CTHpsMeasure) typeStore.find_element_user(qName, 0);
            if (cTHpsMeasure2 == null) {
                cTHpsMeasure2 = (CTHpsMeasure) get_store().add_element_user(qName);
            }
            cTHpsMeasure2.set(cTHpsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setSzCs(CTHpsMeasure cTHpsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SZCS$48;
            CTHpsMeasure cTHpsMeasure2 = (CTHpsMeasure) typeStore.find_element_user(qName, 0);
            if (cTHpsMeasure2 == null) {
                cTHpsMeasure2 = (CTHpsMeasure) get_store().add_element_user(qName);
            }
            cTHpsMeasure2.set(cTHpsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setU(CTUnderline cTUnderline) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = U$52;
            CTUnderline cTUnderline2 = (CTUnderline) typeStore.find_element_user(qName, 0);
            if (cTUnderline2 == null) {
                cTUnderline2 = (CTUnderline) get_store().add_element_user(qName);
            }
            cTUnderline2.set(cTUnderline);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setVanish(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VANISH$32;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setVertAlign(CTVerticalAlignRun cTVerticalAlignRun) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VERTALIGN$62;
            CTVerticalAlignRun cTVerticalAlignRun2 = (CTVerticalAlignRun) typeStore.find_element_user(qName, 0);
            if (cTVerticalAlignRun2 == null) {
                cTVerticalAlignRun2 = (CTVerticalAlignRun) get_store().add_element_user(qName);
            }
            cTVerticalAlignRun2.set(cTVerticalAlignRun);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setW(CTTextScale cTTextScale) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = W$40;
            CTTextScale find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTextScale) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTextScale);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void setWebHidden(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WEBHIDDEN$34;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetB() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(B$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetBCs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BCS$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetBdr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BDR$56, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetCaps() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CAPS$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetColor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COLOR$36, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetCs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CS$66, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetDstrike() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DSTRIKE$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetEastAsianLayout() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EASTASIANLAYOUT$72, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetEffect() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EFFECT$54, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetEm() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EM$68, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetEmboss() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EMBOSS$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetFitText() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FITTEXT$60, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetHighlight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HIGHLIGHT$50, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetI() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(I$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetICs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ICS$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetImprint() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(IMPRINT$26, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetKern() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(KERN$42, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetLang() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LANG$70, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetNoProof() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOPROOF$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetOMath() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATH$76, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetOutline() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OUTLINE$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetPosition() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(POSITION$44, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetRFonts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RFONTS$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetRPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RPRCHANGE$78, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetRStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RSTYLE$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetRtl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RTL$64, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetShadow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHADOW$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetShd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHD$58, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetSmallCaps() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SMALLCAPS$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetSnapToGrid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SNAPTOGRID$30, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPACING$38, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetSpecVanish() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPECVANISH$74, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetStrike() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STRIKE$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetSz() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SZ$46, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetSzCs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SZCS$48, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetU() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(U$52, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetVanish() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VANISH$32, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetVertAlign() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VERTALIGN$62, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetW() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(W$40, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr
    public void unsetWebHidden() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WEBHIDDEN$34, 0);
        }
    }
}
