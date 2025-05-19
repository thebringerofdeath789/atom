package org.litepal.tablemanager.typechange;

import org.apache.xmlbeans.XmlErrorCodes;

/* loaded from: classes5.dex */
public class DateOrm extends OrmChange {
    @Override // org.litepal.tablemanager.typechange.OrmChange
    public String object2Relation(String str) {
        if (str == null || !str.equals("java.util.Date")) {
            return null;
        }
        return XmlErrorCodes.INTEGER;
    }
}
