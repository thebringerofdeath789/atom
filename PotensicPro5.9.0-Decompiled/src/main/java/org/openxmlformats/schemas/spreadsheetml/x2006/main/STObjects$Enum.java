package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes6.dex */
public final class STObjects$Enum extends StringEnumAbstractBase {
    static final int INT_ALL = 1;
    static final int INT_NONE = 3;
    static final int INT_PLACEHOLDERS = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STObjects$Enum[]{new STObjects$Enum(TtmlNode.COMBINE_ALL, 1), new STObjects$Enum("placeholders", 2), new STObjects$Enum("none", 3)});

    private STObjects$Enum(String str, int i) {
        super(str, i);
    }

    public static STObjects$Enum forInt(int i) {
        return (STObjects$Enum) table.forInt(i);
    }

    public static STObjects$Enum forString(String str) {
        return (STObjects$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
