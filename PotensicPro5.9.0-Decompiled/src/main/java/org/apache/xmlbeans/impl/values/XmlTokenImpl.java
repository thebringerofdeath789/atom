package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlToken;

/* loaded from: classes5.dex */
public class XmlTokenImpl extends JavaStringHolderEx implements XmlToken {
    public XmlTokenImpl() {
        super(XmlToken.type, false);
    }

    public XmlTokenImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
