package org.apache.xmlbeans.impl.jam.internal.elements;

import org.apache.xmlbeans.impl.jam.JClass;

/* loaded from: classes5.dex */
public final class VoidClassImpl extends BuiltinClassImpl {
    private static final String SIMPLE_NAME = "void";

    @Override // org.apache.xmlbeans.impl.jam.JClass
    public boolean isAssignableFrom(JClass jClass) {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.elements.BuiltinClassImpl, org.apache.xmlbeans.impl.jam.JClass
    public boolean isVoidType() {
        return true;
    }

    public static boolean isVoid(String str) {
        return str.equals(SIMPLE_NAME);
    }

    public VoidClassImpl(ElementContext elementContext) {
        super(elementContext);
        super.reallySetSimpleName(SIMPLE_NAME);
    }
}
