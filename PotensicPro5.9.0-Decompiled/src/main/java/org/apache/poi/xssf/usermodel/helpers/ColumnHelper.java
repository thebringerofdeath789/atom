package org.apache.poi.xssf.usermodel.helpers;

import java.util.Arrays;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.util.CTColComparator;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;

/* loaded from: classes5.dex */
public class ColumnHelper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private CTCols newCols;
    private CTWorksheet worksheet;

    public ColumnHelper(CTWorksheet cTWorksheet) {
        this.worksheet = cTWorksheet;
        cleanColumns();
    }

    public void cleanColumns() {
        this.newCols = CTCols.Factory.newInstance();
        CTCols newInstance = CTCols.Factory.newInstance();
        CTCols[] colsArray = this.worksheet.getColsArray();
        for (CTCols cTCols : colsArray) {
            for (CTCol cTCol : cTCols.getColArray()) {
                cloneCol(newInstance, cTCol);
            }
        }
        sortColumns(newInstance);
        sweepCleanColumns(this.newCols, newInstance.getColArray(), null);
        for (int length = colsArray.length - 1; length >= 0; length--) {
            this.worksheet.removeCols(length);
        }
        this.worksheet.addNewCols();
        this.worksheet.setColsArray(0, this.newCols);
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x011d, code lost:
    
        if (r15.contains(r30) != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0129, code lost:
    
        r17 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0127, code lost:
    
        if (r15.contains(r30) != false) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void sweepCleanColumns(org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols r28, org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol[] r29, org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol r30) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.xssf.usermodel.helpers.ColumnHelper.sweepCleanColumns(org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols, org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol[], org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol):void");
    }

    public static void sortColumns(CTCols cTCols) {
        CTCol[] colArray = cTCols.getColArray();
        Arrays.sort(colArray, CTColComparator.BY_MIN_MAX);
        cTCols.setColArray(colArray);
    }

    public CTCol cloneCol(CTCols cTCols, CTCol cTCol) {
        CTCol addNewCol = cTCols.addNewCol();
        addNewCol.setMin(cTCol.getMin());
        addNewCol.setMax(cTCol.getMax());
        setColumnAttributes(cTCol, addNewCol);
        return addNewCol;
    }

    public CTCol getColumn(long j, boolean z) {
        return getColumn1Based(j + 1, z);
    }

    public CTCol getColumn1Based(long j, boolean z) {
        int i;
        char c = 0;
        CTCols colsArray = this.worksheet.getColsArray(0);
        CTCol[] colArray = colsArray.getColArray();
        int length = colArray.length;
        int i2 = 0;
        while (i2 < length) {
            CTCol cTCol = colArray[i2];
            long min = cTCol.getMin();
            long max = cTCol.getMax();
            if (min <= j && max >= j) {
                if (z) {
                    if (min < j) {
                        CTCol[] cTColArr = new CTCol[1];
                        cTColArr[c] = cTCol;
                        i = 1;
                        insertCol(colsArray, min, j - 1, cTColArr);
                    } else {
                        i = 1;
                    }
                    if (max > j) {
                        CTCol[] cTColArr2 = new CTCol[i];
                        cTColArr2[0] = cTCol;
                        insertCol(colsArray, j + 1, max, cTColArr2);
                    }
                    cTCol.setMin(j);
                    cTCol.setMax(j);
                }
                return cTCol;
            }
            i2++;
            c = c;
        }
        return null;
    }

    public CTCols addCleanColIntoCols(CTCols cTCols, CTCol cTCol) {
        CTCols newInstance = CTCols.Factory.newInstance();
        for (CTCol cTCol2 : cTCols.getColArray()) {
            cloneCol(newInstance, cTCol2);
        }
        cloneCol(newInstance, cTCol);
        sortColumns(newInstance);
        CTCol[] colArray = newInstance.getColArray();
        CTCols newInstance2 = CTCols.Factory.newInstance();
        sweepCleanColumns(newInstance2, colArray, cTCol);
        cTCols.setColArray(newInstance2.getColArray());
        return newInstance2;
    }

    private CTCol insertCol(CTCols cTCols, long j, long j2, CTCol[] cTColArr) {
        return insertCol(cTCols, j, j2, cTColArr, false, null);
    }

    private CTCol insertCol(CTCols cTCols, long j, long j2, CTCol[] cTColArr, boolean z, CTCol cTCol) {
        if (!z && columnExists(cTCols, j, j2)) {
            return null;
        }
        CTCol insertNewCol = cTCols.insertNewCol(0);
        insertNewCol.setMin(j);
        insertNewCol.setMax(j2);
        for (CTCol cTCol2 : cTColArr) {
            setColumnAttributes(cTCol2, insertNewCol);
        }
        if (cTCol != null) {
            setColumnAttributes(cTCol, insertNewCol);
        }
        return insertNewCol;
    }

    public boolean columnExists(CTCols cTCols, long j) {
        return columnExists1Based(cTCols, j + 1);
    }

    private boolean columnExists1Based(CTCols cTCols, long j) {
        for (CTCol cTCol : cTCols.getColArray()) {
            if (cTCol.getMin() == j) {
                return true;
            }
        }
        return false;
    }

    public void setColumnAttributes(CTCol cTCol, CTCol cTCol2) {
        if (cTCol.isSetBestFit()) {
            cTCol2.setBestFit(cTCol.getBestFit());
        }
        if (cTCol.isSetCustomWidth()) {
            cTCol2.setCustomWidth(cTCol.getCustomWidth());
        }
        if (cTCol.isSetHidden()) {
            cTCol2.setHidden(cTCol.getHidden());
        }
        if (cTCol.isSetStyle()) {
            cTCol2.setStyle(cTCol.getStyle());
        }
        if (cTCol.isSetWidth()) {
            cTCol2.setWidth(cTCol.getWidth());
        }
        if (cTCol.isSetCollapsed()) {
            cTCol2.setCollapsed(cTCol.getCollapsed());
        }
        if (cTCol.isSetPhonetic()) {
            cTCol2.setPhonetic(cTCol.getPhonetic());
        }
        if (cTCol.isSetOutlineLevel()) {
            cTCol2.setOutlineLevel(cTCol.getOutlineLevel());
        }
        cTCol2.setCollapsed(cTCol.isSetCollapsed());
    }

    public void setColBestFit(long j, boolean z) {
        getOrCreateColumn1Based(j + 1, false).setBestFit(z);
    }

    public void setCustomWidth(long j, boolean z) {
        getOrCreateColumn1Based(j + 1, true).setCustomWidth(z);
    }

    public void setColWidth(long j, double d) {
        getOrCreateColumn1Based(j + 1, true).setWidth(d);
    }

    public void setColHidden(long j, boolean z) {
        getOrCreateColumn1Based(j + 1, true).setHidden(z);
    }

    protected CTCol getOrCreateColumn1Based(long j, boolean z) {
        CTCol column1Based = getColumn1Based(j, z);
        if (column1Based != null) {
            return column1Based;
        }
        CTCol addNewCol = this.worksheet.getColsArray(0).addNewCol();
        addNewCol.setMin(j);
        addNewCol.setMax(j);
        return addNewCol;
    }

    public void setColDefaultStyle(long j, CellStyle cellStyle) {
        setColDefaultStyle(j, cellStyle.getIndex());
    }

    public void setColDefaultStyle(long j, int i) {
        getOrCreateColumn1Based(j + 1, true).setStyle(i);
    }

    public int getColDefaultStyle(long j) {
        if (getColumn(j, false) != null) {
            return (int) getColumn(j, false).getStyle();
        }
        return -1;
    }

    private boolean columnExists(CTCols cTCols, long j, long j2) {
        for (CTCol cTCol : cTCols.getColArray()) {
            if (cTCol.getMin() == j && cTCol.getMax() == j2) {
                return true;
            }
        }
        return false;
    }

    public int getIndexOfColumn(CTCols cTCols, CTCol cTCol) {
        int i = 0;
        for (CTCol cTCol2 : cTCols.getColArray()) {
            if (cTCol2.getMin() == cTCol.getMin() && cTCol2.getMax() == cTCol.getMax()) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
