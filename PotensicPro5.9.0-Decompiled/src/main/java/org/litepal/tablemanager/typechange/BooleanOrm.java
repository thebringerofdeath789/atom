package org.litepal.tablemanager.typechange;

import org.apache.xmlbeans.XmlErrorCodes;

/* loaded from: classes5.dex */
public class BooleanOrm extends OrmChange {
    @Override // org.litepal.tablemanager.typechange.OrmChange
    public String object2Relation(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals(XmlErrorCodes.BOOLEAN) || str.equals("java.lang.Boolean")) {
            return XmlErrorCodes.INTEGER;
        }
        return null;
    }
}
