package org.apache.poi.ss.usermodel;

/* loaded from: classes5.dex */
public interface CellStyle {
    public static final short ALIGN_CENTER = 2;
    public static final short ALIGN_CENTER_SELECTION = 6;
    public static final short ALIGN_FILL = 4;
    public static final short ALIGN_GENERAL = 0;
    public static final short ALIGN_JUSTIFY = 5;
    public static final short ALIGN_LEFT = 1;
    public static final short ALIGN_RIGHT = 3;
    public static final short ALT_BARS = 3;
    public static final short BIG_SPOTS = 9;
    public static final short BORDER_DASHED = 3;
    public static final short BORDER_DASH_DOT = 9;
    public static final short BORDER_DASH_DOT_DOT = 11;
    public static final short BORDER_DOTTED = 4;
    public static final short BORDER_DOUBLE = 6;
    public static final short BORDER_HAIR = 7;
    public static final short BORDER_MEDIUM = 2;
    public static final short BORDER_MEDIUM_DASHED = 8;
    public static final short BORDER_MEDIUM_DASH_DOT = 10;
    public static final short BORDER_MEDIUM_DASH_DOT_DOT = 12;
    public static final short BORDER_NONE = 0;
    public static final short BORDER_SLANTED_DASH_DOT = 13;
    public static final short BORDER_THICK = 5;
    public static final short BORDER_THIN = 1;
    public static final short BRICKS = 10;
    public static final short DIAMONDS = 16;
    public static final short FINE_DOTS = 2;
    public static final short LEAST_DOTS = 18;
    public static final short LESS_DOTS = 17;
    public static final short NO_FILL = 0;
    public static final short SOLID_FOREGROUND = 1;
    public static final short SPARSE_DOTS = 4;
    public static final short SQUARES = 15;
    public static final short THICK_BACKWARD_DIAG = 7;
    public static final short THICK_FORWARD_DIAG = 8;
    public static final short THICK_HORZ_BANDS = 5;
    public static final short THICK_VERT_BANDS = 6;
    public static final short THIN_BACKWARD_DIAG = 13;
    public static final short THIN_FORWARD_DIAG = 14;
    public static final short THIN_HORZ_BANDS = 11;
    public static final short THIN_VERT_BANDS = 12;
    public static final short VERTICAL_BOTTOM = 2;
    public static final short VERTICAL_CENTER = 1;
    public static final short VERTICAL_JUSTIFY = 3;
    public static final short VERTICAL_TOP = 0;

    void cloneStyleFrom(CellStyle cellStyle);

    short getAlignment();

    short getBorderBottom();

    short getBorderLeft();

    short getBorderRight();

    short getBorderTop();

    short getBottomBorderColor();

    short getDataFormat();

    String getDataFormatString();

    short getFillBackgroundColor();

    Color getFillBackgroundColorColor();

    short getFillForegroundColor();

    Color getFillForegroundColorColor();

    short getFillPattern();

    short getFontIndex();

    boolean getHidden();

    short getIndention();

    short getIndex();

    short getLeftBorderColor();

    boolean getLocked();

    short getRightBorderColor();

    short getRotation();

    boolean getShrinkToFit();

    short getTopBorderColor();

    short getVerticalAlignment();

    boolean getWrapText();

    void setAlignment(short s);

    void setBorderBottom(short s);

    void setBorderLeft(short s);

    void setBorderRight(short s);

    void setBorderTop(short s);

    void setBottomBorderColor(short s);

    void setDataFormat(short s);

    void setFillBackgroundColor(short s);

    void setFillForegroundColor(short s);

    void setFillPattern(short s);

    void setFont(Font font);

    void setHidden(boolean z);

    void setIndention(short s);

    void setLeftBorderColor(short s);

    void setLocked(boolean z);

    void setRightBorderColor(short s);

    void setRotation(short s);

    void setShrinkToFit(boolean z);

    void setTopBorderColor(short s);

    void setVerticalAlignment(short s);

    void setWrapText(boolean z);
}
