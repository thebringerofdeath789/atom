package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlPositiveInteger;

/* loaded from: classes5.dex */
public class XmlPositiveIntegerImpl extends JavaIntegerHolderEx implements XmlPositiveInteger {
    public XmlPositiveIntegerImpl() {
        super(XmlPositiveInteger.type, false);
    }

    public XmlPositiveIntegerImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
