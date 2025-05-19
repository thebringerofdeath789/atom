package schemasMicrosoftComOfficeOffice;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes6.dex */
public final class STTrueFalse$Enum extends StringEnumAbstractBase {
    static final int INT_F = 2;
    static final int INT_FALSE = 4;
    static final int INT_T = 1;
    static final int INT_TRUE = 3;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STTrueFalse$Enum[]{new STTrueFalse$Enum("t", 1), new STTrueFalse$Enum("f", 2), new STTrueFalse$Enum(BooleanUtils.TRUE, 3), new STTrueFalse$Enum("false", 4)});

    private STTrueFalse$Enum(String str, int i) {
        super(str, i);
    }

    public static STTrueFalse$Enum forInt(int i) {
        return (STTrueFalse$Enum) table.forInt(i);
    }

    public static STTrueFalse$Enum forString(String str) {
        return (STTrueFalse$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
