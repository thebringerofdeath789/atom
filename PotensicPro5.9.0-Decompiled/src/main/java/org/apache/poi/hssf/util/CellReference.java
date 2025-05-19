package org.apache.poi.hssf.util;

/* loaded from: classes5.dex */
public final class CellReference extends org.apache.poi.ss.util.CellReference {
    public CellReference(String str) {
        super(str);
    }

    public CellReference(int i, int i2) {
        super(i, i2, true, true);
    }

    public CellReference(int i, int i2, boolean z, boolean z2) {
        super(null, i, i2, z, z2);
    }

    public CellReference(String str, int i, int i2, boolean z, boolean z2) {
        super(str, i, i2, z, z2);
    }
}
