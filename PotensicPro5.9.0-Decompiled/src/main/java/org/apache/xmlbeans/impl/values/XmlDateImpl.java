package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlDate;

/* loaded from: classes5.dex */
public class XmlDateImpl extends JavaGDateHolderEx implements XmlDate {
    public XmlDateImpl() {
        super(XmlDate.type, false);
    }

    public XmlDateImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
