package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNonNegativeInteger;

/* loaded from: classes5.dex */
public class XmlNonNegativeIntegerImpl extends JavaIntegerHolderEx implements XmlNonNegativeInteger {
    public XmlNonNegativeIntegerImpl() {
        super(XmlNonNegativeInteger.type, false);
    }

    public XmlNonNegativeIntegerImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
