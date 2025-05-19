package org.apache.xmlbeans.impl.jam;

/* loaded from: classes5.dex */
public interface JamService {
    JClass[] getAllClasses();

    JamClassLoader getClassLoader();

    String[] getClassNames();

    JamClassIterator getClasses();
}
