package org.apache.xmlbeans.impl.jam.internal.elements;

import org.apache.xmlbeans.impl.jam.JamClassLoader;
import org.apache.xmlbeans.impl.jam.annotation.AnnotationProxy;
import org.apache.xmlbeans.impl.jam.provider.JamLogger;

/* loaded from: classes5.dex */
public interface ElementContext extends JamLogger {
    AnnotationProxy createAnnotationProxy(String str);

    JamClassLoader getClassLoader();

    JamLogger getLogger();
}
