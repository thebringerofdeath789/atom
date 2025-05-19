package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNormalizedString;

/* loaded from: classes5.dex */
public class XmlNormalizedStringImpl extends JavaStringHolderEx implements XmlNormalizedString {
    public XmlNormalizedStringImpl() {
        super(XmlNormalizedString.type, false);
    }

    public XmlNormalizedStringImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
