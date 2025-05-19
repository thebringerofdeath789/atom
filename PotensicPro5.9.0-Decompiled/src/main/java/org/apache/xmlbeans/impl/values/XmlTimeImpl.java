package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlTime;

/* loaded from: classes5.dex */
public class XmlTimeImpl extends JavaGDateHolderEx implements XmlTime {
    public XmlTimeImpl() {
        super(XmlTime.type, false);
    }

    public XmlTimeImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
