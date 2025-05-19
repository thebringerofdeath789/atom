package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlID;

/* loaded from: classes5.dex */
public class XmlIdImpl extends JavaStringHolderEx implements XmlID {
    public XmlIdImpl() {
        super(XmlID.type, false);
    }

    public XmlIdImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
