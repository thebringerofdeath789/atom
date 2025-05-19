package org.apache.xmlbeans.impl.xb.xmlconfig.impl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.apache.xmlbeans.impl.xb.xmlconfig.JavaNameList;

/* loaded from: classes5.dex */
public class JavaNameListImpl extends XmlUnionImpl implements JavaNameList, JavaNameList.Member, JavaNameList.Member2 {
    public JavaNameListImpl(SchemaType schemaType) {
        super(schemaType, false);
    }

    protected JavaNameListImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }

    public static class MemberImpl extends JavaStringEnumerationHolderEx implements JavaNameList.Member {
        public MemberImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected MemberImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }

    public static class MemberImpl2 extends XmlListImpl implements JavaNameList.Member2 {
        public MemberImpl2(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected MemberImpl2(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }
}
