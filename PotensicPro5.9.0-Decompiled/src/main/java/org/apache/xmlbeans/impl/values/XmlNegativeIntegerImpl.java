package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNegativeInteger;

/* loaded from: classes5.dex */
public class XmlNegativeIntegerImpl extends JavaIntegerHolderEx implements XmlNegativeInteger {
    public XmlNegativeIntegerImpl() {
        super(XmlNegativeInteger.type, false);
    }

    public XmlNegativeIntegerImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
