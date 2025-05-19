package org.apache.xmlbeans.impl.jam.mutable;

import org.apache.xmlbeans.impl.jam.JAnnotatedElement;

/* loaded from: classes5.dex */
public interface MAnnotatedElement extends MElement, JAnnotatedElement {
    MAnnotation addLiteralAnnotation(String str);

    MComment createComment();

    MAnnotation findOrCreateAnnotation(String str);

    MAnnotation getMutableAnnotation(String str);

    MAnnotation[] getMutableAnnotations();

    MComment getMutableComment();

    void removeComment();
}
