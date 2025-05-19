package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes6.dex */
public final class STDisplacedByCustomXml$Enum extends StringEnumAbstractBase {
    static final int INT_NEXT = 1;
    static final int INT_PREV = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STDisplacedByCustomXml$Enum[]{new STDisplacedByCustomXml$Enum("next", 1), new STDisplacedByCustomXml$Enum("prev", 2)});

    private STDisplacedByCustomXml$Enum(String str, int i) {
        super(str, i);
    }

    public static STDisplacedByCustomXml$Enum forInt(int i) {
        return (STDisplacedByCustomXml$Enum) table.forInt(i);
    }

    public static STDisplacedByCustomXml$Enum forString(String str) {
        return (STDisplacedByCustomXml$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
