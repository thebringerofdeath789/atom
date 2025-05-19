package org.apache.xmlbeans.impl.jam.mutable;

import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JField;

/* loaded from: classes5.dex */
public interface MField extends JField, MMember {
    void setType(String str);

    void setType(JClass jClass);

    void setUnqualifiedType(String str);
}
