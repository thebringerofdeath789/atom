package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes6.dex */
public final class STTableType$Enum extends StringEnumAbstractBase {
    static final int INT_QUERY_TABLE = 3;
    static final int INT_WORKSHEET = 1;
    static final int INT_XML = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STTableType$Enum[]{new STTableType$Enum("worksheet", 1), new STTableType$Enum("xml", 2), new STTableType$Enum("queryTable", 3)});

    private STTableType$Enum(String str, int i) {
        super(str, i);
    }

    public static STTableType$Enum forInt(int i) {
        return (STTableType$Enum) table.forInt(i);
    }

    public static STTableType$Enum forString(String str) {
        return (STTableType$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
