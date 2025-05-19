package org.apache.poi.xssf.usermodel;

import org.apache.poi.POIXMLException;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FontCharset;
import org.apache.poi.ss.usermodel.FontFamily;
import org.apache.poi.ss.usermodel.FontScheme;
import org.apache.poi.ss.usermodel.FontUnderline;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.model.ThemesTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBooleanProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontScheme;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIntProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTUnderlineProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTVerticalAlignFontProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFontScheme;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STUnderlineValues;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STVerticalAlignRun;

/* loaded from: classes5.dex */
public class XSSFFont implements Font {
    public static final short DEFAULT_FONT_COLOR = IndexedColors.BLACK.getIndex();
    public static final String DEFAULT_FONT_NAME = "Calibri";
    public static final short DEFAULT_FONT_SIZE = 11;
    private CTFont _ctFont;
    private short _index;
    private ThemesTable _themes;

    public XSSFFont(CTFont cTFont) {
        this._ctFont = cTFont;
        this._index = (short) 0;
    }

    public XSSFFont(CTFont cTFont, int i) {
        this._ctFont = cTFont;
        this._index = (short) i;
    }

    protected XSSFFont() {
        this._ctFont = CTFont.Factory.newInstance();
        setFontName(DEFAULT_FONT_NAME);
        setFontHeight(11.0d);
    }

    @Internal
    public CTFont getCTFont() {
        return this._ctFont;
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public boolean getBold() {
        CTBooleanProperty bArray = this._ctFont.sizeOfBArray() == 0 ? null : this._ctFont.getBArray(0);
        return bArray != null && bArray.getVal();
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public int getCharSet() {
        CTIntProperty charsetArray = this._ctFont.sizeOfCharsetArray() == 0 ? null : this._ctFont.getCharsetArray(0);
        return (charsetArray == null ? FontCharset.ANSI : FontCharset.valueOf(charsetArray.getVal())).getValue();
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public short getColor() {
        CTColor colorArray = this._ctFont.sizeOfColorArray() == 0 ? null : this._ctFont.getColorArray(0);
        if (colorArray == null) {
            return IndexedColors.BLACK.getIndex();
        }
        long indexed = colorArray.getIndexed();
        if (indexed == DEFAULT_FONT_COLOR) {
            return IndexedColors.BLACK.getIndex();
        }
        return indexed == ((long) IndexedColors.RED.getIndex()) ? IndexedColors.RED.getIndex() : (short) indexed;
    }

    public XSSFColor getXSSFColor() {
        XSSFColor xSSFColor = null;
        CTColor colorArray = this._ctFont.sizeOfColorArray() == 0 ? null : this._ctFont.getColorArray(0);
        if (colorArray != null) {
            xSSFColor = new XSSFColor(colorArray);
            ThemesTable themesTable = this._themes;
            if (themesTable != null) {
                themesTable.inheritFromThemeAsRequired(xSSFColor);
            }
        }
        return xSSFColor;
    }

    public short getThemeColor() {
        return (short) ((this._ctFont.sizeOfColorArray() == 0 ? null : this._ctFont.getColorArray(0)) == null ? 0L : r0.getTheme());
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public short getFontHeight() {
        if ((this._ctFont.sizeOfSzArray() == 0 ? null : this._ctFont.getSzArray(0)) != null) {
            return (short) (r0.getVal() * 20.0d);
        }
        return (short) 220;
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public short getFontHeightInPoints() {
        return (short) (getFontHeight() / 20);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public String getFontName() {
        CTFontName nameArray = this._ctFont.sizeOfNameArray() == 0 ? null : this._ctFont.getNameArray(0);
        return nameArray == null ? DEFAULT_FONT_NAME : nameArray.getVal();
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public boolean getItalic() {
        CTBooleanProperty iArray = this._ctFont.sizeOfIArray() == 0 ? null : this._ctFont.getIArray(0);
        return iArray != null && iArray.getVal();
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public boolean getStrikeout() {
        CTBooleanProperty strikeArray = this._ctFont.sizeOfStrikeArray() == 0 ? null : this._ctFont.getStrikeArray(0);
        return strikeArray != null && strikeArray.getVal();
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public short getTypeOffset() {
        int intValue;
        CTVerticalAlignFontProperty vertAlignArray = this._ctFont.sizeOfVertAlignArray() == 0 ? null : this._ctFont.getVertAlignArray(0);
        if (vertAlignArray == null || (intValue = vertAlignArray.getVal().intValue()) == 1) {
            return (short) 0;
        }
        if (intValue == 2) {
            return (short) 1;
        }
        if (intValue == 3) {
            return (short) 2;
        }
        throw new POIXMLException("Wrong offset value " + intValue);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public byte getUnderline() {
        CTUnderlineProperty uArray = this._ctFont.sizeOfUArray() == 0 ? null : this._ctFont.getUArray(0);
        if (uArray != null) {
            return FontUnderline.valueOf(uArray.getVal().intValue()).getByteValue();
        }
        return (byte) 0;
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setBold(boolean z) {
        if (z) {
            (this._ctFont.sizeOfBArray() == 0 ? this._ctFont.addNewB() : this._ctFont.getBArray(0)).setVal(z);
        } else {
            this._ctFont.setBArray(null);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setBoldweight(short s) {
        setBold(s == 700);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public short getBoldweight() {
        return getBold() ? (short) 700 : (short) 400;
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setCharSet(byte b) {
        int i = b;
        if (b < 0) {
            i = b + 256;
        }
        setCharSet(i);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setCharSet(int i) {
        FontCharset valueOf = FontCharset.valueOf(i);
        if (valueOf != null) {
            setCharSet(valueOf);
            return;
        }
        throw new POIXMLException("Attention: an attempt to set a type of unknow charset and charset");
    }

    public void setCharSet(FontCharset fontCharset) {
        CTIntProperty charsetArray;
        if (this._ctFont.sizeOfCharsetArray() == 0) {
            charsetArray = this._ctFont.addNewCharset();
        } else {
            charsetArray = this._ctFont.getCharsetArray(0);
        }
        charsetArray.setVal(fontCharset.getValue());
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setColor(short s) {
        CTColor addNewColor = this._ctFont.sizeOfColorArray() == 0 ? this._ctFont.addNewColor() : this._ctFont.getColorArray(0);
        if (s == 10) {
            addNewColor.setIndexed(IndexedColors.RED.getIndex());
        } else if (s == Short.MAX_VALUE) {
            addNewColor.setIndexed(DEFAULT_FONT_COLOR);
        } else {
            addNewColor.setIndexed(s);
        }
    }

    public void setColor(XSSFColor xSSFColor) {
        if (xSSFColor == null) {
            this._ctFont.setColorArray(null);
        } else {
            (this._ctFont.sizeOfColorArray() == 0 ? this._ctFont.addNewColor() : this._ctFont.getColorArray(0)).setRgb(xSSFColor.getRgb());
        }
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setFontHeight(short s) {
        setFontHeight(s / 20.0d);
    }

    public void setFontHeight(double d) {
        (this._ctFont.sizeOfSzArray() == 0 ? this._ctFont.addNewSz() : this._ctFont.getSzArray(0)).setVal(d);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setFontHeightInPoints(short s) {
        setFontHeight(s);
    }

    public void setThemeColor(short s) {
        (this._ctFont.sizeOfColorArray() == 0 ? this._ctFont.addNewColor() : this._ctFont.getColorArray(0)).setTheme(s);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setFontName(String str) {
        CTFontName addNewName = this._ctFont.sizeOfNameArray() == 0 ? this._ctFont.addNewName() : this._ctFont.getNameArray(0);
        if (str == null) {
            str = DEFAULT_FONT_NAME;
        }
        addNewName.setVal(str);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setItalic(boolean z) {
        if (z) {
            (this._ctFont.sizeOfIArray() == 0 ? this._ctFont.addNewI() : this._ctFont.getIArray(0)).setVal(z);
        } else {
            this._ctFont.setIArray(null);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setStrikeout(boolean z) {
        if (!z) {
            this._ctFont.setStrikeArray(null);
        } else {
            (this._ctFont.sizeOfStrikeArray() == 0 ? this._ctFont.addNewStrike() : this._ctFont.getStrikeArray(0)).setVal(z);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setTypeOffset(short s) {
        if (s == 0) {
            this._ctFont.setVertAlignArray(null);
            return;
        }
        CTVerticalAlignFontProperty addNewVertAlign = this._ctFont.sizeOfVertAlignArray() == 0 ? this._ctFont.addNewVertAlign() : this._ctFont.getVertAlignArray(0);
        if (s == 0) {
            addNewVertAlign.setVal(STVerticalAlignRun.BASELINE);
        } else if (s == 1) {
            addNewVertAlign.setVal(STVerticalAlignRun.SUPERSCRIPT);
        } else {
            if (s != 2) {
                return;
            }
            addNewVertAlign.setVal(STVerticalAlignRun.SUBSCRIPT);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setUnderline(byte b) {
        setUnderline(FontUnderline.valueOf(b));
    }

    public void setUnderline(FontUnderline fontUnderline) {
        if (fontUnderline == FontUnderline.NONE && this._ctFont.sizeOfUArray() > 0) {
            this._ctFont.setUArray(null);
        } else {
            (this._ctFont.sizeOfUArray() == 0 ? this._ctFont.addNewU() : this._ctFont.getUArray(0)).setVal(STUnderlineValues.Enum.forInt(fontUnderline.getValue()));
        }
    }

    public String toString() {
        return this._ctFont.toString();
    }

    public long registerTo(StylesTable stylesTable) {
        this._themes = stylesTable.getTheme();
        short putFont = (short) stylesTable.putFont(this, true);
        this._index = putFont;
        return putFont;
    }

    public void setThemesTable(ThemesTable themesTable) {
        this._themes = themesTable;
    }

    public FontScheme getScheme() {
        CTFontScheme schemeArray = this._ctFont.sizeOfSchemeArray() == 0 ? null : this._ctFont.getSchemeArray(0);
        return schemeArray == null ? FontScheme.NONE : FontScheme.valueOf(schemeArray.getVal().intValue());
    }

    public void setScheme(FontScheme fontScheme) {
        (this._ctFont.sizeOfSchemeArray() == 0 ? this._ctFont.addNewScheme() : this._ctFont.getSchemeArray(0)).setVal(STFontScheme.Enum.forInt(fontScheme.getValue()));
    }

    public int getFamily() {
        CTIntProperty addNewFamily = this._ctFont.sizeOfFamilyArray() == 0 ? this._ctFont.addNewFamily() : this._ctFont.getFamilyArray(0);
        return (addNewFamily == null ? FontFamily.NOT_APPLICABLE : FontFamily.valueOf(addNewFamily.getVal())).getValue();
    }

    public void setFamily(int i) {
        (this._ctFont.sizeOfFamilyArray() == 0 ? this._ctFont.addNewFamily() : this._ctFont.getFamilyArray(0)).setVal(i);
    }

    public void setFamily(FontFamily fontFamily) {
        setFamily(fontFamily.getValue());
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public short getIndex() {
        return this._index;
    }

    public int hashCode() {
        return this._ctFont.toString().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof XSSFFont) {
            return this._ctFont.toString().equals(((XSSFFont) obj).getCTFont().toString());
        }
        return false;
    }
}
