package org.apache.xmlbeans.impl.jam;

/* loaded from: classes5.dex */
public interface JAnnotation extends JElement {
    public static final String SINGLE_VALUE_NAME = "value";

    Object getAnnotationInstance();

    Object getProxy();

    @Override // org.apache.xmlbeans.impl.jam.JElement
    String getSimpleName();

    JAnnotationValue getValue(String str);

    JAnnotationValue[] getValues();
}
