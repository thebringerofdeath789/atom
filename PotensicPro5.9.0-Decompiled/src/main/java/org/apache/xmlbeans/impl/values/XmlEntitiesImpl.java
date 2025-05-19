package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlENTITIES;

/* loaded from: classes5.dex */
public class XmlEntitiesImpl extends XmlListImpl implements XmlENTITIES {
    public XmlEntitiesImpl() {
        super(XmlENTITIES.type, false);
    }

    public XmlEntitiesImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
