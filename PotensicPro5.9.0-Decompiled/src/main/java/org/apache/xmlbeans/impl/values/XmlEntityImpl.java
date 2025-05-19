package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlENTITY;

/* loaded from: classes5.dex */
public class XmlEntityImpl extends JavaStringHolderEx implements XmlENTITY {
    public XmlEntityImpl() {
        super(XmlENTITY.type, false);
    }

    public XmlEntityImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
