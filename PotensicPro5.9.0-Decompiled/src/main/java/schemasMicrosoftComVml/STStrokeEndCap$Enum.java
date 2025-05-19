package schemasMicrosoftComVml;

import com.mapbox.mapboxsdk.style.layers.Property;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes6.dex */
public final class STStrokeEndCap$Enum extends StringEnumAbstractBase {
    static final int INT_FLAT = 1;
    static final int INT_ROUND = 3;
    static final int INT_SQUARE = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STStrokeEndCap$Enum[]{new STStrokeEndCap$Enum("flat", 1), new STStrokeEndCap$Enum(Property.LINE_CAP_SQUARE, 2), new STStrokeEndCap$Enum("round", 3)});

    private STStrokeEndCap$Enum(String str, int i) {
        super(str, i);
    }

    public static STStrokeEndCap$Enum forInt(int i) {
        return (STStrokeEndCap$Enum) table.forInt(i);
    }

    public static STStrokeEndCap$Enum forString(String str) {
        return (STStrokeEndCap$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
