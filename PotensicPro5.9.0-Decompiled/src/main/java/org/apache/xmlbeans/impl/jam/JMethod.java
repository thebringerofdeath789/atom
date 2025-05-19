package org.apache.xmlbeans.impl.jam;

/* loaded from: classes5.dex */
public interface JMethod extends JInvokable {
    @Override // org.apache.xmlbeans.impl.jam.JElement
    String getQualifiedName();

    JClass getReturnType();

    boolean isAbstract();

    boolean isFinal();

    boolean isNative();

    boolean isStatic();

    boolean isSynchronized();
}
