package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlIDREF;

/* loaded from: classes5.dex */
public class XmlIdRefImpl extends JavaStringHolderEx implements XmlIDREF {
    public XmlIdRefImpl() {
        super(XmlIDREF.type, false);
    }

    public XmlIdRefImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
