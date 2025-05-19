package schemasMicrosoftComVml;

import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlErrorCodes;

/* loaded from: classes6.dex */
public final class STStrokeArrowLength$Enum extends StringEnumAbstractBase {
    static final int INT_LONG = 3;
    static final int INT_MEDIUM = 2;
    static final int INT_SHORT = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STStrokeArrowLength$Enum[]{new STStrokeArrowLength$Enum("short", 1), new STStrokeArrowLength$Enum("medium", 2), new STStrokeArrowLength$Enum(XmlErrorCodes.LONG, 3)});

    private STStrokeArrowLength$Enum(String str, int i) {
        super(str, i);
    }

    public static STStrokeArrowLength$Enum forInt(int i) {
        return (STStrokeArrowLength$Enum) table.forInt(i);
    }

    public static STStrokeArrowLength$Enum forString(String str) {
        return (STStrokeArrowLength$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
