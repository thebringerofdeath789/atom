package org.apache.poi.hssf.usermodel;

import org.apache.poi.ddf.EscherChildAnchorRecord;
import org.apache.poi.ddf.EscherClientAnchorRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherRecord;

/* loaded from: classes5.dex */
public abstract class HSSFAnchor {
    protected boolean _isHorizontallyFlipped = false;
    protected boolean _isVerticallyFlipped = false;

    protected abstract void createEscherAnchor();

    public abstract int getDx1();

    public abstract int getDx2();

    public abstract int getDy1();

    public abstract int getDy2();

    protected abstract EscherRecord getEscherAnchor();

    public abstract boolean isHorizontallyFlipped();

    public abstract boolean isVerticallyFlipped();

    public abstract void setDx1(int i);

    public abstract void setDx2(int i);

    public abstract void setDy1(int i);

    public abstract void setDy2(int i);

    public HSSFAnchor() {
        createEscherAnchor();
    }

    public HSSFAnchor(int i, int i2, int i3, int i4) {
        createEscherAnchor();
        setDx1(i);
        setDy1(i2);
        setDx2(i3);
        setDy2(i4);
    }

    public static HSSFAnchor createAnchorFromEscher(EscherContainerRecord escherContainerRecord) {
        if (escherContainerRecord.getChildById(EscherChildAnchorRecord.RECORD_ID) != null) {
            return new HSSFChildAnchor((EscherChildAnchorRecord) escherContainerRecord.getChildById(EscherChildAnchorRecord.RECORD_ID));
        }
        if (escherContainerRecord.getChildById(EscherClientAnchorRecord.RECORD_ID) != null) {
            return new HSSFClientAnchor((EscherClientAnchorRecord) escherContainerRecord.getChildById(EscherClientAnchorRecord.RECORD_ID));
        }
        return null;
    }
}
