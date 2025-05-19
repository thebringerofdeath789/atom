package org.apache.xmlbeans.impl.jam;

/* loaded from: classes5.dex */
public interface JMember extends JAnnotatedElement {
    JClass getContainingClass();

    int getModifiers();

    boolean isPackagePrivate();

    boolean isPrivate();

    boolean isProtected();

    boolean isPublic();
}
