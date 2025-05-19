package org.apache.poi.xslf.usermodel;

import java.awt.Color;
import java.awt.font.FontRenderContext;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.text.AttributedString;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xslf.model.CharacterPropertyFetcher;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STSchemeColorVal;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextStrikeType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextUnderlineType;

/* loaded from: classes5.dex */
public class XSLFTextRun {
    private final XSLFTextParagraph _p;
    private final CTRegularTextRun _r;

    XSLFTextRun(CTRegularTextRun cTRegularTextRun, XSLFTextParagraph xSLFTextParagraph) {
        this._r = cTRegularTextRun;
        this._p = xSLFTextParagraph;
    }

    XSLFTextParagraph getParentParagraph() {
        return this._p;
    }

    public String getText() {
        return this._r.getT();
    }

    String getRenderableText() {
        String t = this._r.getT();
        TextCap textCap = getTextCap();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < t.length(); i++) {
            char charAt = t.charAt(i);
            if (charAt == '\t') {
                stringBuffer.append("  ");
            } else {
                int i2 = AnonymousClass13.$SwitchMap$org$apache$poi$xslf$usermodel$TextCap[textCap.ordinal()];
                if (i2 == 1) {
                    stringBuffer.append(Character.toUpperCase(charAt));
                } else if (i2 == 2) {
                    stringBuffer.append(Character.toLowerCase(charAt));
                } else {
                    stringBuffer.append(charAt);
                }
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: org.apache.poi.xslf.usermodel.XSLFTextRun$13, reason: invalid class name */
    static /* synthetic */ class AnonymousClass13 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xslf$usermodel$TextCap;

        static {
            int[] iArr = new int[TextCap.values().length];
            $SwitchMap$org$apache$poi$xslf$usermodel$TextCap = iArr;
            try {
                iArr[TextCap.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$TextCap[TextCap.SMALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private String tab2space() {
        AttributedString attributedString = new AttributedString(StringUtils.SPACE);
        attributedString.addAttribute(TextAttribute.FAMILY, getFontFamily());
        attributedString.addAttribute(TextAttribute.SIZE, Float.valueOf((float) getFontSize()));
        int ceil = (int) Math.ceil(this._p.getDefaultTabSize() / new TextLayout(attributedString.getIterator(), new FontRenderContext((AffineTransform) null, true, true)).getAdvance());
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < ceil; i++) {
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }

    public void setText(String str) {
        this._r.setT(str);
    }

    public CTRegularTextRun getXmlObject() {
        return this._r;
    }

    public void setFontColor(Color color) {
        CTTextCharacterProperties rPr = getRPr();
        CTSolidColorFillProperties solidFill = rPr.isSetSolidFill() ? rPr.getSolidFill() : rPr.addNewSolidFill();
        (solidFill.isSetSrgbClr() ? solidFill.getSrgbClr() : solidFill.addNewSrgbClr()).setVal(new byte[]{(byte) color.getRed(), (byte) color.getGreen(), (byte) color.getBlue()});
        if (solidFill.isSetHslClr()) {
            solidFill.unsetHslClr();
        }
        if (solidFill.isSetPrstClr()) {
            solidFill.unsetPrstClr();
        }
        if (solidFill.isSetSchemeClr()) {
            solidFill.unsetSchemeClr();
        }
        if (solidFill.isSetScrgbClr()) {
            solidFill.unsetScrgbClr();
        }
        if (solidFill.isSetSysClr()) {
            solidFill.unsetSysClr();
        }
    }

    public Color getFontColor() {
        final XSLFTheme theme = this._p.getParentShape().getSheet().getTheme();
        CTShapeStyle spStyle = this._p.getParentShape().getSpStyle();
        final CTSchemeColor schemeClr = spStyle == null ? null : spStyle.getFontRef().getSchemeClr();
        CharacterPropertyFetcher<Color> characterPropertyFetcher = new CharacterPropertyFetcher<Color>(this._p.getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextRun.1
            @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher
            public boolean fetch(CTTextCharacterProperties cTTextCharacterProperties) {
                CTSolidColorFillProperties solidFill = cTTextCharacterProperties.getSolidFill();
                if (solidFill == null) {
                    return false;
                }
                setValue(new XSLFColor(solidFill, theme, (solidFill.isSetSchemeClr() && solidFill.getSchemeClr().getVal() == STSchemeColorVal.PH_CLR) || this.isFetchingFromMaster ? schemeClr : null).getColor());
                return true;
            }
        };
        fetchCharacterProperty(characterPropertyFetcher);
        return characterPropertyFetcher.getValue();
    }

    public void setFontSize(double d) {
        CTTextCharacterProperties rPr = getRPr();
        if (d == -1.0d) {
            if (rPr.isSetSz()) {
                rPr.unsetSz();
            }
        } else {
            if (d < 1.0d) {
                throw new IllegalArgumentException("Minimum font size is 1pt but was " + d);
            }
            rPr.setSz((int) (d * 100.0d));
        }
    }

    public double getFontSize() {
        double fontScale = getParentParagraph().getParentShape().getTextBodyPr().getNormAutofit() != null ? r0.getFontScale() / 100000.0d : 1.0d;
        CharacterPropertyFetcher<Double> characterPropertyFetcher = new CharacterPropertyFetcher<Double>(this._p.getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextRun.2
            @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher
            public boolean fetch(CTTextCharacterProperties cTTextCharacterProperties) {
                if (!cTTextCharacterProperties.isSetSz()) {
                    return false;
                }
                setValue(Double.valueOf(cTTextCharacterProperties.getSz() * 0.01d));
                return true;
            }
        };
        fetchCharacterProperty(characterPropertyFetcher);
        if (characterPropertyFetcher.getValue() == null) {
            return -1.0d;
        }
        return fontScale * characterPropertyFetcher.getValue().doubleValue();
    }

    public double getCharacterSpacing() {
        CharacterPropertyFetcher<Double> characterPropertyFetcher = new CharacterPropertyFetcher<Double>(this._p.getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextRun.3
            @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher
            public boolean fetch(CTTextCharacterProperties cTTextCharacterProperties) {
                if (!cTTextCharacterProperties.isSetSpc()) {
                    return false;
                }
                setValue(Double.valueOf(cTTextCharacterProperties.getSpc() * 0.01d));
                return true;
            }
        };
        fetchCharacterProperty(characterPropertyFetcher);
        if (characterPropertyFetcher.getValue() == null) {
            return 0.0d;
        }
        return characterPropertyFetcher.getValue().doubleValue();
    }

    public void setCharacterSpacing(double d) {
        CTTextCharacterProperties rPr = getRPr();
        if (d == 0.0d) {
            if (rPr.isSetSpc()) {
                rPr.unsetSpc();
                return;
            }
            return;
        }
        rPr.setSpc((int) (d * 100.0d));
    }

    public void setFontFamily(String str) {
        setFontFamily(str, (byte) -1, (byte) -1, false);
    }

    public void setFontFamily(String str, byte b, byte b2, boolean z) {
        CTTextCharacterProperties rPr = getRPr();
        if (str == null) {
            if (rPr.isSetLatin()) {
                rPr.unsetLatin();
            }
            if (rPr.isSetCs()) {
                rPr.unsetCs();
            }
            if (rPr.isSetSym()) {
                rPr.unsetSym();
                return;
            }
            return;
        }
        if (z) {
            (rPr.isSetSym() ? rPr.getSym() : rPr.addNewSym()).setTypeface(str);
            return;
        }
        CTTextFont latin = rPr.isSetLatin() ? rPr.getLatin() : rPr.addNewLatin();
        latin.setTypeface(str);
        if (b != -1) {
            latin.setCharset(b);
        }
        if (b2 != -1) {
            latin.setPitchFamily(b2);
        }
    }

    public String getFontFamily() {
        final XSLFTheme theme = this._p.getParentShape().getSheet().getTheme();
        CharacterPropertyFetcher<String> characterPropertyFetcher = new CharacterPropertyFetcher<String>(this._p.getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextRun.4
            @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher
            public boolean fetch(CTTextCharacterProperties cTTextCharacterProperties) {
                CTTextFont latin = cTTextCharacterProperties.getLatin();
                if (latin == null) {
                    return false;
                }
                String typeface = latin.getTypeface();
                if ("+mj-lt".equals(typeface)) {
                    typeface = theme.getMajorFont();
                } else if ("+mn-lt".equals(typeface)) {
                    typeface = theme.getMinorFont();
                }
                setValue(typeface);
                return true;
            }
        };
        fetchCharacterProperty(characterPropertyFetcher);
        return characterPropertyFetcher.getValue();
    }

    public byte getPitchAndFamily() {
        this._p.getParentShape().getSheet().getTheme();
        CharacterPropertyFetcher<Byte> characterPropertyFetcher = new CharacterPropertyFetcher<Byte>(this._p.getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextRun.5
            @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher
            public boolean fetch(CTTextCharacterProperties cTTextCharacterProperties) {
                CTTextFont latin = cTTextCharacterProperties.getLatin();
                if (latin == null) {
                    return false;
                }
                setValue(Byte.valueOf(latin.getPitchFamily()));
                return true;
            }
        };
        fetchCharacterProperty(characterPropertyFetcher);
        if (characterPropertyFetcher.getValue() == null) {
            return (byte) 0;
        }
        return characterPropertyFetcher.getValue().byteValue();
    }

    public void setStrikethrough(boolean z) {
        getRPr().setStrike(z ? STTextStrikeType.SNG_STRIKE : STTextStrikeType.NO_STRIKE);
    }

    public boolean isStrikethrough() {
        CharacterPropertyFetcher<Boolean> characterPropertyFetcher = new CharacterPropertyFetcher<Boolean>(this._p.getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextRun.6
            @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher
            public boolean fetch(CTTextCharacterProperties cTTextCharacterProperties) {
                if (!cTTextCharacterProperties.isSetStrike()) {
                    return false;
                }
                setValue(Boolean.valueOf(cTTextCharacterProperties.getStrike() != STTextStrikeType.NO_STRIKE));
                return true;
            }
        };
        fetchCharacterProperty(characterPropertyFetcher);
        if (characterPropertyFetcher.getValue() == null) {
            return false;
        }
        return characterPropertyFetcher.getValue().booleanValue();
    }

    public boolean isSuperscript() {
        CharacterPropertyFetcher<Boolean> characterPropertyFetcher = new CharacterPropertyFetcher<Boolean>(this._p.getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextRun.7
            @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher
            public boolean fetch(CTTextCharacterProperties cTTextCharacterProperties) {
                if (!cTTextCharacterProperties.isSetBaseline()) {
                    return false;
                }
                setValue(Boolean.valueOf(cTTextCharacterProperties.getBaseline() > 0));
                return true;
            }
        };
        fetchCharacterProperty(characterPropertyFetcher);
        if (characterPropertyFetcher.getValue() == null) {
            return false;
        }
        return characterPropertyFetcher.getValue().booleanValue();
    }

    public void setBaselineOffset(double d) {
        getRPr().setBaseline(((int) d) * 1000);
    }

    public void setSuperscript(boolean z) {
        setBaselineOffset(z ? 30.0d : 0.0d);
    }

    public void setSubscript(boolean z) {
        setBaselineOffset(z ? -25.0d : 0.0d);
    }

    public boolean isSubscript() {
        CharacterPropertyFetcher<Boolean> characterPropertyFetcher = new CharacterPropertyFetcher<Boolean>(this._p.getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextRun.8
            @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher
            public boolean fetch(CTTextCharacterProperties cTTextCharacterProperties) {
                if (!cTTextCharacterProperties.isSetBaseline()) {
                    return false;
                }
                setValue(Boolean.valueOf(cTTextCharacterProperties.getBaseline() < 0));
                return true;
            }
        };
        fetchCharacterProperty(characterPropertyFetcher);
        if (characterPropertyFetcher.getValue() == null) {
            return false;
        }
        return characterPropertyFetcher.getValue().booleanValue();
    }

    public TextCap getTextCap() {
        CharacterPropertyFetcher<TextCap> characterPropertyFetcher = new CharacterPropertyFetcher<TextCap>(this._p.getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextRun.9
            @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher
            public boolean fetch(CTTextCharacterProperties cTTextCharacterProperties) {
                if (!cTTextCharacterProperties.isSetCap()) {
                    return false;
                }
                setValue(TextCap.values()[cTTextCharacterProperties.getCap().intValue() - 1]);
                return true;
            }
        };
        fetchCharacterProperty(characterPropertyFetcher);
        return characterPropertyFetcher.getValue() == null ? TextCap.NONE : characterPropertyFetcher.getValue();
    }

    public void setBold(boolean z) {
        getRPr().setB(z);
    }

    public boolean isBold() {
        CharacterPropertyFetcher<Boolean> characterPropertyFetcher = new CharacterPropertyFetcher<Boolean>(this._p.getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextRun.10
            @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher
            public boolean fetch(CTTextCharacterProperties cTTextCharacterProperties) {
                if (!cTTextCharacterProperties.isSetB()) {
                    return false;
                }
                setValue(Boolean.valueOf(cTTextCharacterProperties.getB()));
                return true;
            }
        };
        fetchCharacterProperty(characterPropertyFetcher);
        if (characterPropertyFetcher.getValue() == null) {
            return false;
        }
        return characterPropertyFetcher.getValue().booleanValue();
    }

    public void setItalic(boolean z) {
        getRPr().setI(z);
    }

    public boolean isItalic() {
        CharacterPropertyFetcher<Boolean> characterPropertyFetcher = new CharacterPropertyFetcher<Boolean>(this._p.getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextRun.11
            @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher
            public boolean fetch(CTTextCharacterProperties cTTextCharacterProperties) {
                if (!cTTextCharacterProperties.isSetI()) {
                    return false;
                }
                setValue(Boolean.valueOf(cTTextCharacterProperties.getI()));
                return true;
            }
        };
        fetchCharacterProperty(characterPropertyFetcher);
        if (characterPropertyFetcher.getValue() == null) {
            return false;
        }
        return characterPropertyFetcher.getValue().booleanValue();
    }

    public void setUnderline(boolean z) {
        getRPr().setU(z ? STTextUnderlineType.SNG : STTextUnderlineType.NONE);
    }

    public boolean isUnderline() {
        CharacterPropertyFetcher<Boolean> characterPropertyFetcher = new CharacterPropertyFetcher<Boolean>(this._p.getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextRun.12
            @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher
            public boolean fetch(CTTextCharacterProperties cTTextCharacterProperties) {
                if (!cTTextCharacterProperties.isSetU()) {
                    return false;
                }
                setValue(Boolean.valueOf(cTTextCharacterProperties.getU() != STTextUnderlineType.NONE));
                return true;
            }
        };
        fetchCharacterProperty(characterPropertyFetcher);
        if (characterPropertyFetcher.getValue() == null) {
            return false;
        }
        return characterPropertyFetcher.getValue().booleanValue();
    }

    protected CTTextCharacterProperties getRPr() {
        return this._r.isSetRPr() ? this._r.getRPr() : this._r.addNewRPr();
    }

    public String toString() {
        return "[" + getClass() + "]" + getText();
    }

    public XSLFHyperlink createHyperlink() {
        return new XSLFHyperlink(this._r.getRPr().addNewHlinkClick(), this);
    }

    public XSLFHyperlink getHyperlink() {
        if (this._r.getRPr().isSetHlinkClick()) {
            return new XSLFHyperlink(this._r.getRPr().getHlinkClick(), this);
        }
        return null;
    }

    private boolean fetchCharacterProperty(CharacterPropertyFetcher characterPropertyFetcher) {
        boolean z;
        CTTextParagraphProperties defaultMasterStyle;
        CTTextParagraphProperties defaultParagraphStyle;
        boolean fetch = this._r.isSetRPr() ? characterPropertyFetcher.fetch(getRPr()) : false;
        if (fetch) {
            return fetch;
        }
        XSLFTextShape parentShape = this._p.getParentShape();
        boolean fetchShapeProperty = parentShape.fetchShapeProperty(characterPropertyFetcher);
        if (fetchShapeProperty) {
            return fetchShapeProperty;
        }
        if (parentShape.getCTPlaceholder() != null || (defaultParagraphStyle = parentShape.getSheet().getSlideShow().getDefaultParagraphStyle(this._p.getLevel())) == null) {
            z = fetchShapeProperty;
        } else {
            characterPropertyFetcher.isFetchingFromMaster = true;
            z = characterPropertyFetcher.fetch(defaultParagraphStyle);
        }
        if (z || (defaultMasterStyle = this._p.getDefaultMasterStyle()) == null) {
            return z;
        }
        characterPropertyFetcher.isFetchingFromMaster = true;
        return characterPropertyFetcher.fetch(defaultMasterStyle);
    }

    void copy(XSLFTextRun xSLFTextRun) {
        String fontFamily = xSLFTextRun.getFontFamily();
        if (fontFamily != null && !fontFamily.equals(getFontFamily())) {
            setFontFamily(fontFamily);
        }
        Color fontColor = xSLFTextRun.getFontColor();
        if (fontColor != null && !fontColor.equals(getFontColor())) {
            setFontColor(fontColor);
        }
        double fontSize = xSLFTextRun.getFontSize();
        if (fontSize != getFontSize()) {
            setFontSize(fontSize);
        }
        boolean isBold = xSLFTextRun.isBold();
        if (isBold != isBold()) {
            setBold(isBold);
        }
        boolean isItalic = xSLFTextRun.isItalic();
        if (isItalic != isItalic()) {
            setItalic(isItalic);
        }
        boolean isUnderline = xSLFTextRun.isUnderline();
        if (isUnderline != isUnderline()) {
            setUnderline(isUnderline);
        }
        boolean isStrikethrough = xSLFTextRun.isStrikethrough();
        if (isStrikethrough != isStrikethrough()) {
            setStrikethrough(isStrikethrough);
        }
    }
}
