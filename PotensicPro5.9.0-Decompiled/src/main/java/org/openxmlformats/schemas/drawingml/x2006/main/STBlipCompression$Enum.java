package org.openxmlformats.schemas.drawingml.x2006.main;

import androidx.core.app.NotificationCompat;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes5.dex */
public final class STBlipCompression$Enum extends StringEnumAbstractBase {
    static final int INT_EMAIL = 1;
    static final int INT_HQPRINT = 4;
    static final int INT_NONE = 5;
    static final int INT_PRINT = 3;
    static final int INT_SCREEN = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STBlipCompression$Enum[]{new STBlipCompression$Enum(NotificationCompat.CATEGORY_EMAIL, 1), new STBlipCompression$Enum("screen", 2), new STBlipCompression$Enum("print", 3), new STBlipCompression$Enum("hqprint", 4), new STBlipCompression$Enum("none", 5)});

    private STBlipCompression$Enum(String str, int i) {
        super(str, i);
    }

    public static STBlipCompression$Enum forInt(int i) {
        return (STBlipCompression$Enum) table.forInt(i);
    }

    public static STBlipCompression$Enum forString(String str) {
        return (STBlipCompression$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
