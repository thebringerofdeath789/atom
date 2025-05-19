package org.openxmlformats.schemas.drawingml.x2006.main;

import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes5.dex */
public final class STTextTabAlignType$Enum extends StringEnumAbstractBase {
    static final int INT_CTR = 2;
    static final int INT_DEC = 4;
    static final int INT_L = 1;
    static final int INT_R = 3;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STTextTabAlignType$Enum[]{new STTextTabAlignType$Enum("l", 1), new STTextTabAlignType$Enum("ctr", 2), new STTextTabAlignType$Enum(InternalZipConstants.READ_MODE, 3), new STTextTabAlignType$Enum("dec", 4)});

    private STTextTabAlignType$Enum(String str, int i) {
        super(str, i);
    }

    public static STTextTabAlignType$Enum forInt(int i) {
        return (STTextTabAlignType$Enum) table.forInt(i);
    }

    public static STTextTabAlignType$Enum forString(String str) {
        return (STTextTabAlignType$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
