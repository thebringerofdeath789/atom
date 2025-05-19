package org.apache.xmlbeans.impl.jam;

import org.apache.xmlbeans.impl.jam.visitor.JVisitor;

/* loaded from: classes5.dex */
public interface JElement {
    void accept(JVisitor jVisitor);

    Object getArtifact();

    JElement getParent();

    String getQualifiedName();

    String getSimpleName();

    JSourcePosition getSourcePosition();

    String toString();
}
