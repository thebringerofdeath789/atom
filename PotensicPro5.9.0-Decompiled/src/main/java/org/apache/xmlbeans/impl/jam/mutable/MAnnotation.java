package org.apache.xmlbeans.impl.jam.mutable;

import org.apache.xmlbeans.impl.jam.JAnnotation;
import org.apache.xmlbeans.impl.jam.JClass;

/* loaded from: classes5.dex */
public interface MAnnotation extends JAnnotation, MElement {
    MAnnotation createNestedValue(String str, String str2);

    MAnnotation[] createNestedValueArray(String str, String str2, int i);

    void setAnnotationInstance(Object obj);

    void setSimpleValue(String str, Object obj, JClass jClass);
}
