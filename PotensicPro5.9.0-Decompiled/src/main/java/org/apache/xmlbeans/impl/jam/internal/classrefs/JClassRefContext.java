package org.apache.xmlbeans.impl.jam.internal.classrefs;

import org.apache.xmlbeans.impl.jam.JamClassLoader;

/* loaded from: classes5.dex */
public interface JClassRefContext {
    JamClassLoader getClassLoader();

    String[] getImportSpecs();

    String getPackageName();
}
