package org.apache.xmlbeans.impl.jam.mutable;

import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JMethod;

/* loaded from: classes5.dex */
public interface MMethod extends JMethod, MInvokable {
    void setReturnType(String str);

    void setReturnType(JClass jClass);

    void setUnqualifiedReturnType(String str);
}
