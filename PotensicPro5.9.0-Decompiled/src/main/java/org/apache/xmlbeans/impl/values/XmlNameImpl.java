package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlName;

/* loaded from: classes5.dex */
public class XmlNameImpl extends JavaStringHolderEx implements XmlName {
    public XmlNameImpl() {
        super(XmlName.type, false);
    }

    public XmlNameImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
