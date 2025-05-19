package org.apache.xmlbeans.impl.jam.provider;

import java.io.File;
import java.io.IOException;
import org.apache.xmlbeans.impl.jam.annotation.JavadocTagParser;
import org.apache.xmlbeans.impl.jam.visitor.MVisitor;

/* loaded from: classes5.dex */
public interface JamServiceContext extends JamLogger {
    String[] getAllClassnames() throws IOException;

    JamClassBuilder getBaseBuilder();

    MVisitor getInitializer();

    ResourcePath getInputClasspath();

    ResourcePath getInputSourcepath();

    JamLogger getLogger();

    String getProperty(String str);

    ClassLoader[] getReflectionClassLoaders();

    File[] getSourceFiles() throws IOException;

    JavadocTagParser getTagParser();

    ResourcePath getToolClasspath();

    boolean is14WarningsEnabled();
}
