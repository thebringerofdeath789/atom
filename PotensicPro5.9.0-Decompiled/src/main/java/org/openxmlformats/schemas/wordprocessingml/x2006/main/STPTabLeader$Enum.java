package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes6.dex */
public final class STPTabLeader$Enum extends StringEnumAbstractBase {
    static final int INT_DOT = 2;
    static final int INT_HYPHEN = 3;
    static final int INT_MIDDLE_DOT = 5;
    static final int INT_NONE = 1;
    static final int INT_UNDERSCORE = 4;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STPTabLeader$Enum[]{new STPTabLeader$Enum("none", 1), new STPTabLeader$Enum(TtmlNode.TEXT_EMPHASIS_MARK_DOT, 2), new STPTabLeader$Enum("hyphen", 3), new STPTabLeader$Enum("underscore", 4), new STPTabLeader$Enum("middleDot", 5)});

    private STPTabLeader$Enum(String str, int i) {
        super(str, i);
    }

    public static STPTabLeader$Enum forInt(int i) {
        return (STPTabLeader$Enum) table.forInt(i);
    }

    public static STPTabLeader$Enum forString(String str) {
        return (STPTabLeader$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
