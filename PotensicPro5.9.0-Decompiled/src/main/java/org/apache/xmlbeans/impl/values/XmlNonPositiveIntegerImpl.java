package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNonPositiveInteger;

/* loaded from: classes5.dex */
public class XmlNonPositiveIntegerImpl extends JavaIntegerHolderEx implements XmlNonPositiveInteger {
    public XmlNonPositiveIntegerImpl() {
        super(XmlNonPositiveInteger.type, false);
    }

    public XmlNonPositiveIntegerImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
