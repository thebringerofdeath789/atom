package org.apache.xmlbeans.impl.jam;

/* loaded from: classes5.dex */
public interface JField extends JMember {
    @Override // org.apache.xmlbeans.impl.jam.JElement
    String getQualifiedName();

    JClass getType();

    boolean isFinal();

    boolean isStatic();

    boolean isTransient();

    boolean isVolatile();
}
