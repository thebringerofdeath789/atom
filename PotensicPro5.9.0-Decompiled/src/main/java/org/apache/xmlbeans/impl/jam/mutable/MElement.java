package org.apache.xmlbeans.impl.jam.mutable;

import org.apache.xmlbeans.impl.jam.JElement;
import org.apache.xmlbeans.impl.jam.JamClassLoader;
import org.apache.xmlbeans.impl.jam.visitor.MVisitor;

/* loaded from: classes5.dex */
public interface MElement extends JElement {
    void accept(MVisitor mVisitor);

    MSourcePosition createSourcePosition();

    JamClassLoader getClassLoader();

    MSourcePosition getMutableSourcePosition();

    void removeSourcePosition();

    void setArtifact(Object obj);

    void setSimpleName(String str);
}
