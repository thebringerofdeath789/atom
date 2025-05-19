package org.apache.poi.ss.usermodel;

import java.util.Iterator;

/* loaded from: classes5.dex */
public interface Row extends Iterable<Cell> {
    public static final MissingCellPolicy CREATE_NULL_AS_BLANK;
    public static final MissingCellPolicy RETURN_BLANK_AS_NULL;
    public static final MissingCellPolicy RETURN_NULL_AND_BLANK;

    Iterator<Cell> cellIterator();

    Cell createCell(int i);

    Cell createCell(int i, int i2);

    Cell getCell(int i);

    Cell getCell(int i, MissingCellPolicy missingCellPolicy);

    short getFirstCellNum();

    short getHeight();

    float getHeightInPoints();

    short getLastCellNum();

    int getOutlineLevel();

    int getPhysicalNumberOfCells();

    int getRowNum();

    CellStyle getRowStyle();

    Sheet getSheet();

    boolean getZeroHeight();

    boolean isFormatted();

    void removeCell(Cell cell);

    void setHeight(short s);

    void setHeightInPoints(float f);

    void setRowNum(int i);

    void setRowStyle(CellStyle cellStyle);

    void setZeroHeight(boolean z);

    public static final class MissingCellPolicy {
        private static int NEXT_ID = 1;
        public final int id;

        private MissingCellPolicy() {
            int i = NEXT_ID;
            NEXT_ID = i + 1;
            this.id = i;
        }
    }

    static {
        RETURN_NULL_AND_BLANK = new MissingCellPolicy();
        RETURN_BLANK_AS_NULL = new MissingCellPolicy();
        CREATE_NULL_AS_BLANK = new MissingCellPolicy();
    }
}
