package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import javax.xml.transform.OutputKeys;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes6.dex */
public final class STPTabRelativeTo$Enum extends StringEnumAbstractBase {
    static final int INT_INDENT = 2;
    static final int INT_MARGIN = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STPTabRelativeTo$Enum[]{new STPTabRelativeTo$Enum("margin", 1), new STPTabRelativeTo$Enum(OutputKeys.INDENT, 2)});

    private STPTabRelativeTo$Enum(String str, int i) {
        super(str, i);
    }

    public static STPTabRelativeTo$Enum forInt(int i) {
        return (STPTabRelativeTo$Enum) table.forInt(i);
    }

    public static STPTabRelativeTo$Enum forString(String str) {
        return (STPTabRelativeTo$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
