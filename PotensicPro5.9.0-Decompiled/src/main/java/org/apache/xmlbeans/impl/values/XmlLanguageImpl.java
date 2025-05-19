package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlLanguage;

/* loaded from: classes5.dex */
public class XmlLanguageImpl extends JavaStringHolderEx implements XmlLanguage {
    public XmlLanguageImpl() {
        super(XmlLanguage.type, false);
    }

    public XmlLanguageImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
