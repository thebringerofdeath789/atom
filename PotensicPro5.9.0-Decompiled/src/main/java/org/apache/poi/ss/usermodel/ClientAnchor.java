package org.apache.poi.ss.usermodel;

/* loaded from: classes5.dex */
public interface ClientAnchor {
    public static final int DONT_MOVE_AND_RESIZE = 3;
    public static final int MOVE_AND_RESIZE = 0;
    public static final int MOVE_DONT_RESIZE = 2;

    int getAnchorType();

    short getCol1();

    short getCol2();

    int getDx1();

    int getDx2();

    int getDy1();

    int getDy2();

    int getRow1();

    int getRow2();

    void setAnchorType(int i);

    void setCol1(int i);

    void setCol2(int i);

    void setDx1(int i);

    void setDx2(int i);

    void setDy1(int i);

    void setDy2(int i);

    void setRow1(int i);

    void setRow2(int i);
}
