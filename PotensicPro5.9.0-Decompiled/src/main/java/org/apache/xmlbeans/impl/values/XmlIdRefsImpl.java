package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlIDREFS;

/* loaded from: classes5.dex */
public class XmlIdRefsImpl extends XmlListImpl implements XmlIDREFS {
    public XmlIdRefsImpl() {
        super(XmlIDREFS.type, false);
    }

    public XmlIdRefsImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
