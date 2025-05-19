package schemasMicrosoftComOfficeOffice;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes6.dex */
public final class STTrueFalseBlank$Enum extends StringEnumAbstractBase {
    static final int INT_F = 3;
    static final int INT_FALSE = 5;
    static final int INT_T = 2;
    static final int INT_TRUE = 4;
    static final int INT_X = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STTrueFalseBlank$Enum[]{new STTrueFalseBlank$Enum("", 1), new STTrueFalseBlank$Enum("t", 2), new STTrueFalseBlank$Enum("f", 3), new STTrueFalseBlank$Enum(BooleanUtils.TRUE, 4), new STTrueFalseBlank$Enum("false", 5)});

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
