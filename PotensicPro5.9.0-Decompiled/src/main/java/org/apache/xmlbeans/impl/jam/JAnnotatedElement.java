package org.apache.xmlbeans.impl.jam;

/* loaded from: classes5.dex */
public interface JAnnotatedElement extends JElement {
    JAnnotation[] getAllJavadocTags();

    JAnnotation getAnnotation(Class cls);

    JAnnotation getAnnotation(String str);

    Object getAnnotationProxy(Class cls);

    JAnnotationValue getAnnotationValue(String str);

    JAnnotation[] getAnnotations();

    JComment getComment();
}
