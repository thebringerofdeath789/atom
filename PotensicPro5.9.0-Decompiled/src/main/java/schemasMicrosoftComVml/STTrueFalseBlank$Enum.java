package schemasMicrosoftComVml;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes6.dex */
public final class STTrueFalseBlank$Enum extends StringEnumAbstractBase {
    static final int INT_F = 2;
    static final int INT_FALSE = 4;
    static final int INT_T = 1;
    static final int INT_TRUE = 3;
    static final int INT_X = 5;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STTrueFalseBlank$Enum[]{new STTrueFalseBlank$Enum("t", 1), new STTrueFalseBlank$Enum("f", 2), new STTrueFalseBlank$Enum(BooleanUtils.TRUE, 3), new STTrueFalseBlank$Enum("false", 4), new STTrueFalseBlank$Enum("", 5)});

    private STTrueFalseBlank$Enum(String str, int i) {
        super(str, i);
    }

    public static STTrueFalseBlank$Enum forInt(int i) {
        return (STTrueFalseBlank$Enum) table.forInt(i);
    }

    public static STTrueFalseBlank$Enum forString(String str) {
        return (STTrueFalseBlank$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
