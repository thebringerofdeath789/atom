package schemasMicrosoftComVml;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes6.dex */
public final class STFillType$Enum extends StringEnumAbstractBase {
    static final int INT_FRAME = 6;
    static final int INT_GRADIENT = 2;
    static final int INT_GRADIENT_RADIAL = 3;
    static final int INT_PATTERN = 5;
    static final int INT_SOLID = 1;
    static final int INT_TILE = 4;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STFillType$Enum[]{new STFillType$Enum("solid", 1), new STFillType$Enum("gradient", 2), new STFillType$Enum("gradientRadial", 3), new STFillType$Enum("tile", 4), new STFillType$Enum("pattern", 5), new STFillType$Enum("frame", 6)});

    private STFillType$Enum(String str, int i) {
        super(str, i);
    }

    public static STFillType$Enum forInt(int i) {
        return (STFillType$Enum) table.forInt(i);
    }

    public static STFillType$Enum forString(String str) {
        return (STFillType$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
