package org.apache.poi.hssf.usermodel;

import androidx.core.view.MotionEventCompat;
import org.apache.poi.ddf.EscherClientAnchorRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ss.usermodel.ClientAnchor;

/* loaded from: classes5.dex */
public final class HSSFClientAnchor extends HSSFAnchor implements ClientAnchor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private EscherClientAnchorRecord _escherClientAnchor;

    public int hashCode() {
        return 42;
    }

    public HSSFClientAnchor(EscherClientAnchorRecord escherClientAnchorRecord) {
        this._escherClientAnchor = escherClientAnchorRecord;
    }

    public HSSFClientAnchor() {
    }

    public HSSFClientAnchor(int i, int i2, int i3, int i4, short s, int i5, short s2, int i6) {
        super(i, i2, i3, i4);
        checkRange(i, 0, 1023, "dx1");
        checkRange(i3, 0, 1023, "dx2");
        checkRange(i2, 0, 255, "dy1");
        checkRange(i4, 0, 255, "dy2");
        checkRange(s, 0, 255, "col1");
        checkRange(s2, 0, 255, "col2");
        checkRange(i5, 0, MotionEventCompat.ACTION_POINTER_INDEX_MASK, "row1");
        checkRange(i6, 0, MotionEventCompat.ACTION_POINTER_INDEX_MASK, "row2");
        setCol1((short) Math.min((int) s, (int) s2));
        setCol2((short) Math.max((int) s, (int) s2));
        setRow1((short) Math.min(i5, i6));
        setRow2((short) Math.max(i5, i6));
        if (s > s2) {
            this._isHorizontallyFlipped = true;
        }
        if (i5 > i6) {
            this._isVerticallyFlipped = true;
        }
    }

    public float getAnchorHeightInPoints(HSSFSheet hSSFSheet) {
        int dy1 = getDy1();
        int dy2 = getDy2();
        int min = Math.min(getRow1(), getRow2());
        int max = Math.max(getRow1(), getRow2());
        if (min == max) {
            return ((dy2 - dy1) / 256.0f) * getRowHeightInPoints(hSSFSheet, max);
        }
        float rowHeightInPoints = ((256.0f - dy1) / 256.0f) * getRowHeightInPoints(hSSFSheet, min);
        float f = 0.0f;
        while (true) {
            rowHeightInPoints += f;
            min++;
            if (min < max) {
                f = getRowHeightInPoints(hSSFSheet, min);
            } else {
                return rowHeightInPoints + ((dy2 / 256.0f) * getRowHeightInPoints(hSSFSheet, max));
            }
        }
    }

    private float getRowHeightInPoints(HSSFSheet hSSFSheet, int i) {
        HSSFRow row = hSSFSheet.getRow(i);
        if (row == null) {
            return hSSFSheet.getDefaultRowHeightInPoints();
        }
        return row.getHeightInPoints();
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public short getCol1() {
        return this._escherClientAnchor.getCol1();
    }

    public void setCol1(short s) {
        checkRange(s, 0, 255, "col1");
        this._escherClientAnchor.setCol1(s);
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setCol1(int i) {
        setCol1((short) i);
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public short getCol2() {
        return this._escherClientAnchor.getCol2();
    }

    public void setCol2(short s) {
        checkRange(s, 0, 255, "col2");
        this._escherClientAnchor.setCol2(s);
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setCol2(int i) {
        setCol2((short) i);
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public int getRow1() {
        return this._escherClientAnchor.getRow1();
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setRow1(int i) {
        checkRange(i, 0, 65536, "row1");
        this._escherClientAnchor.setRow1(Integer.valueOf(i).shortValue());
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public int getRow2() {
        return this._escherClientAnchor.getRow2();
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setRow2(int i) {
        checkRange(i, 0, 65536, "row2");
        this._escherClientAnchor.setRow2(Integer.valueOf(i).shortValue());
    }

    public void setAnchor(short s, int i, int i2, int i3, short s2, int i4, int i5, int i6) {
        checkRange(getDx1(), 0, 1023, "dx1");
        checkRange(getDx2(), 0, 1023, "dx2");
        checkRange(getDy1(), 0, 255, "dy1");
        checkRange(getDy2(), 0, 255, "dy2");
        checkRange(getCol1(), 0, 255, "col1");
        checkRange(getCol2(), 0, 255, "col2");
        checkRange(getRow1(), 0, MotionEventCompat.ACTION_POINTER_INDEX_MASK, "row1");
        checkRange(getRow2(), 0, MotionEventCompat.ACTION_POINTER_INDEX_MASK, "row2");
        setCol1(s);
        setRow1(i);
        setDx1(i2);
        setDy1(i3);
        setCol2(s2);
        setRow2(i4);
        setDx2(i5);
        setDy2(i6);
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFAnchor
    public boolean isHorizontallyFlipped() {
        return this._isHorizontallyFlipped;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFAnchor
    public boolean isVerticallyFlipped() {
        return this._isVerticallyFlipped;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFAnchor
    protected EscherRecord getEscherAnchor() {
        return this._escherClientAnchor;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFAnchor
    protected void createEscherAnchor() {
        this._escherClientAnchor = new EscherClientAnchorRecord();
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public int getAnchorType() {
        return this._escherClientAnchor.getFlag();
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setAnchorType(int i) {
        this._escherClientAnchor.setFlag(Integer.valueOf(i).shortValue());
    }

    private void checkRange(int i, int i2, int i3, String str) {
        if (i < i2 || i > i3) {
            throw new IllegalArgumentException(str + " must be between " + i2 + " and " + i3 + ", but was: " + i);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        HSSFClientAnchor hSSFClientAnchor = (HSSFClientAnchor) obj;
        return hSSFClientAnchor.getCol1() == getCol1() && hSSFClientAnchor.getCol2() == getCol2() && hSSFClientAnchor.getDx1() == getDx1() && hSSFClientAnchor.getDx2() == getDx2() && hSSFClientAnchor.getDy1() == getDy1() && hSSFClientAnchor.getDy2() == getDy2() && hSSFClientAnchor.getRow1() == getRow1() && hSSFClientAnchor.getRow2() == getRow2() && hSSFClientAnchor.getAnchorType() == getAnchorType();
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFAnchor
    public int getDx1() {
        return this._escherClientAnchor.getDx1();
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFAnchor
    public void setDx1(int i) {
        this._escherClientAnchor.setDx1(Integer.valueOf(i).shortValue());
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFAnchor
    public int getDy1() {
        return this._escherClientAnchor.getDy1();
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFAnchor
    public void setDy1(int i) {
        this._escherClientAnchor.setDy1(Integer.valueOf(i).shortValue());
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFAnchor
    public int getDy2() {
        return this._escherClientAnchor.getDy2();
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFAnchor
    public void setDy2(int i) {
        this._escherClientAnchor.setDy2(Integer.valueOf(i).shortValue());
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFAnchor
    public int getDx2() {
        return this._escherClientAnchor.getDx2();
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFAnchor
    public void setDx2(int i) {
        this._escherClientAnchor.setDx2(Integer.valueOf(i).shortValue());
    }
}
