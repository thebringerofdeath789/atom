package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;

/* loaded from: classes5.dex */
public class AllNNIImpl extends XmlUnionImpl implements AllNNI, XmlNonNegativeInteger, AllNNI.Member {
    public AllNNIImpl(SchemaType schemaType) {
        super(schemaType, false);
    }

    protected AllNNIImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }

    public static class MemberImpl extends JavaStringEnumerationHolderEx implements AllNNI.Member {
        public MemberImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected MemberImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }
}
