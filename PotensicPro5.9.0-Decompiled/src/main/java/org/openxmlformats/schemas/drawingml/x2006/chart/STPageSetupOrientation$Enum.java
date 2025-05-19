package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes2.dex */
public final class STPageSetupOrientation$Enum extends StringEnumAbstractBase {
    static final int INT_DEFAULT = 1;
    static final int INT_LANDSCAPE = 3;
    static final int INT_PORTRAIT = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STPageSetupOrientation$Enum[]{new STPageSetupOrientation$Enum("default", 1), new STPageSetupOrientation$Enum("portrait", 2), new STPageSetupOrientation$Enum("landscape", 3)});

    private STPageSetupOrientation$Enum(String str, int i) {
        super(str, i);
    }

    public static STPageSetupOrientation$Enum forInt(int i) {
        return (STPageSetupOrientation$Enum) table.forInt(i);
    }

    public static STPageSetupOrientation$Enum forString(String str) {
        return (STPageSetupOrientation$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
