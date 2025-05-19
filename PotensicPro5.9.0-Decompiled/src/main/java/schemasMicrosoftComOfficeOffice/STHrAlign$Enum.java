package schemasMicrosoftComOfficeOffice;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes6.dex */
public final class STHrAlign$Enum extends StringEnumAbstractBase {
    static final int INT_CENTER = 3;
    static final int INT_LEFT = 1;
    static final int INT_RIGHT = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STHrAlign$Enum[]{new STHrAlign$Enum("left", 1), new STHrAlign$Enum("right", 2), new STHrAlign$Enum("center", 3)});

    private STHrAlign$Enum(String str, int i) {
        super(str, i);
    }

    public static STHrAlign$Enum forInt(int i) {
        return (STHrAlign$Enum) table.forInt(i);
    }

    public static STHrAlign$Enum forString(String str) {
        return (STHrAlign$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
