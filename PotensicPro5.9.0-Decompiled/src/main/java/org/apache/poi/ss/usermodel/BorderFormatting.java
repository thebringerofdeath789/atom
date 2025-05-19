package org.apache.poi.ss.usermodel;

/* loaded from: classes5.dex */
public interface BorderFormatting {
    public static final short BORDER_DASHED = 3;
    public static final short BORDER_DASH_DOT = 9;
    public static final short BORDER_DASH_DOT_DOT = 11;
    public static final short BORDER_DOTTED = 7;
    public static final short BORDER_DOUBLE = 6;
    public static final short BORDER_HAIR = 4;
    public static final short BORDER_MEDIUM = 2;
    public static final short BORDER_MEDIUM_DASHED = 8;
    public static final short BORDER_MEDIUM_DASH_DOT = 10;
    public static final short BORDER_MEDIUM_DASH_DOT_DOT = 12;
    public static final short BORDER_NONE = 0;
    public static final short BORDER_SLANTED_DASH_DOT = 13;
    public static final short BORDER_THICK = 5;
    public static final short BORDER_THIN = 1;

    short getBorderBottom();

    short getBorderDiagonal();

    short getBorderLeft();

    short getBorderRight();

    short getBorderTop();

    short getBottomBorderColor();

    short getDiagonalBorderColor();

    short getLeftBorderColor();

    short getRightBorderColor();

    short getTopBorderColor();

    void setBorderBottom(short s);

    void setBorderDiagonal(short s);

    void setBorderLeft(short s);

    void setBorderRight(short s);

    void setBorderTop(short s);

    void setBottomBorderColor(short s);

    void setDiagonalBorderColor(short s);

    void setLeftBorderColor(short s);

    void setRightBorderColor(short s);

    void setTopBorderColor(short s);
}
