package org.litepal.tablemanager.typechange;

import org.apache.xmlbeans.XmlErrorCodes;

/* loaded from: classes5.dex */
public class NumericOrm extends OrmChange {
    @Override // org.litepal.tablemanager.typechange.OrmChange
    public String object2Relation(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals(XmlErrorCodes.INT) || str.equals("java.lang.Integer") || str.equals(XmlErrorCodes.LONG) || str.equals("java.lang.Long") || str.equals("short") || str.equals("java.lang.Short")) {
            return XmlErrorCodes.INTEGER;
        }
        return null;
    }
}
