package org.apache.xmlbeans.impl.jam.mutable;

import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JInvokable;

/* loaded from: classes5.dex */
public interface MInvokable extends JInvokable, MMember {
    void addException(String str);

    void addException(JClass jClass);

    MParameter addNewParameter();

    MParameter[] getMutableParameters();

    void removeException(String str);

    void removeException(JClass jClass);

    void removeParameter(MParameter mParameter);
}
