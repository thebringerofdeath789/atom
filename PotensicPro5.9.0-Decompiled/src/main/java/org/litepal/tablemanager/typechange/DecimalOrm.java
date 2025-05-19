package org.litepal.tablemanager.typechange;

import org.apache.xmlbeans.XmlErrorCodes;

/* loaded from: classes5.dex */
public class DecimalOrm extends OrmChange {
    @Override // org.litepal.tablemanager.typechange.OrmChange
    public String object2Relation(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals(XmlErrorCodes.FLOAT) || str.equals("java.lang.Float") || str.equals(XmlErrorCodes.DOUBLE) || str.equals("java.lang.Double")) {
            return "real";
        }
        return null;
    }
}
