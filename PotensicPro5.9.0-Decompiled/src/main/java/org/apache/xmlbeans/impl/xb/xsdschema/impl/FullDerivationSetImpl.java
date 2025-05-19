package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.FullDerivationSet;

/* loaded from: classes5.dex */
public class FullDerivationSetImpl extends XmlUnionImpl implements FullDerivationSet, FullDerivationSet.Member, FullDerivationSet.Member2 {
    public FullDerivationSetImpl(SchemaType schemaType) {
        super(schemaType, false);
    }

    protected FullDerivationSetImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }

    public static class MemberImpl extends JavaStringEnumerationHolderEx implements FullDerivationSet.Member {
        public MemberImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected MemberImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }

    public static class MemberImpl2 extends XmlListImpl implements FullDerivationSet.Member2 {
        public MemberImpl2(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected MemberImpl2(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }
}
