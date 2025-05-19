package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.mapbox.mapboxsdk.style.layers.Property;
import org.apache.poi.ss.util.CellUtil;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes6.dex */
public final class STVisibility$Enum extends StringEnumAbstractBase {
    static final int INT_HIDDEN = 2;
    static final int INT_VERY_HIDDEN = 3;
    static final int INT_VISIBLE = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STVisibility$Enum[]{new STVisibility$Enum(Property.VISIBLE, 1), new STVisibility$Enum(CellUtil.HIDDEN, 2), new STVisibility$Enum("veryHidden", 3)});

    private STVisibility$Enum(String str, int i) {
        super(str, i);
    }

    public static STVisibility$Enum forInt(int i) {
        return (STVisibility$Enum) table.forInt(i);
    }

    public static STVisibility$Enum forString(String str) {
        return (STVisibility$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
